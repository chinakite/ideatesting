/**
 * 
 */
package com.ideamoment.ideatesting.schema.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideamoment.caserunner.model.Case;
import com.ideamoment.caserunner.model.CaseExecuteResult;
import com.ideamoment.caserunner.model.CaseFile;
import com.ideamoment.caserunner.model.CommandExecuteResult;
import com.ideamoment.caserunner.model.Env;
import com.ideamoment.caserunner.model.dict.BrowserType;
import com.ideamoment.caserunner.model.dict.CommandExecuteResultType;
import com.ideamoment.caserunner.parser.CaseFileParser;
import com.ideamoment.caserunner.runner.DefaultCaseRunner;
import com.ideamoment.ideadp.appcontext.IdeaApplicationContext;
import com.ideamoment.ideadp.exception.IdeaDataException;
import com.ideamoment.ideadp.exception.IdeaDataExceptionCode;
import com.ideamoment.ideajdbc.IdeaJdbc;
import com.ideamoment.ideajdbc.action.Page;
import com.ideamoment.ideajdbc.spring.IdeaJdbcTx;
import com.ideamoment.ideatesting.model.CaseResult;
import com.ideamoment.ideatesting.model.CaseScript;
import com.ideamoment.ideatesting.model.CommandResult;
import com.ideamoment.ideatesting.model.RunNode;
import com.ideamoment.ideatesting.model.RunSchema;
import com.ideamoment.ideatesting.model.SchemaHub;
import com.ideamoment.ideatesting.model.SchemaNode;
import com.ideamoment.ideatesting.model.SchemaScript;
import com.ideamoment.ideatesting.model.dict.RunResultDict;
import com.ideamoment.ideatesting.schema.dao.SchemaDao;

/**
 * @author Chinakite
 *
 */
@Service
public class SchemaService {
    @Autowired
    private SchemaDao schemaDao;

    @IdeaJdbcTx
    public Page<RunSchema> pageProjectSchemas(int curPage,
                                               int pageSize,
                                               String projectId)
    {
        return schemaDao.pageQuerySchemasByProjectId(curPage, pageSize, projectId);
    }

    @IdeaJdbcTx
    public void runSchema(String id) {
    	String curUserId = "1";
    	
        try{
            RunSchema schema = IdeaJdbc.find(RunSchema.class, id);
            List<CaseScript> scripts = schemaDao.queryScriptsBySchema(id);
//            HashSet<String> scriptIds = new HashSet<String>();
//            for(RunCase runCase : runCases) {
//                scriptIds.add(runCase.getScriptId());
//            }

            Map<String, Case> allCases = new HashMap<String, Case>();
            for(CaseScript caseScript : scripts) {
                String fileUrl = caseScript.getFileUrl();
                if(fileUrl.startsWith("/") || fileUrl.startsWith("\\")) {
                    fileUrl = fileUrl.substring(1);
                }

                String webRoot = IdeaApplicationContext.getInstance().getWebRoot();
                if(!webRoot.endsWith("/") && !webRoot.endsWith("\\")) {
                    webRoot += File.separator;
                }

                String absolutePath = webRoot + fileUrl;

                File sourceFile = new File(absolutePath);

                try {
                    FileInputStream source = new FileInputStream(sourceFile);
                    CaseFileParser parser = new CaseFileParser();
                    CaseFile casefile = parser.parse(source);

                    Map<String, Case> cases = casefile.getCases();
                    allCases.putAll(cases);
                } catch(IOException e) {
                    e.printStackTrace();
                    throw new IdeaDataException(IdeaDataExceptionCode.DATA_NOU_FOUND, String.format("Script file [{0}] is not found.", fileUrl));
                }
            }

            //TODO 依赖排序

            Env env = new Env();
            env.setBrowser(BrowserType.CHROME);

            DefaultCaseRunner runner = new DefaultCaseRunner();

            RunNode hub = schemaDao.queryHubBySchema(id);
            if(hub == null) {
                throw new RuntimeException("No hub.");
            }else{
                env.setAddress(hub.getAddress());
                env.setPort(hub.getPort());
            }

            for(String caseName : allCases.keySet()) {
//                String caseName = runCase.getName();
                Case caze = allCases.get(caseName);
                CaseExecuteResult result = runner.run(env, caze);
                
                CaseResult caseResult = new CaseResult();
                caseResult.setCaseName(caseName);
                caseResult.setCreateTime(new Date());
                caseResult.setCreatorId(curUserId);
                caseResult.setResult(result.isSuccess() ? RunResultDict.SUCCESS : RunResultDict.FAILED);
                caseResult.setSchemaId(id);
                caseResult.setScriptId("1");
                
                IdeaJdbc.save(caseResult);
                
                List<CommandExecuteResult> commandExecuteResults = result.getCommandResults();
                for(CommandExecuteResult commandExecuteResult : commandExecuteResults) {
                	CommandResult commandResult = new CommandResult();
                	commandResult.setCaseResultId(caseResult.getId());
                	commandResult.setCommandText(commandExecuteResult.getCommand().getText());
                	commandResult.setCreateTime(new Date());
                	commandResult.setCreatorId(curUserId);
                	commandResult.setEndLine(commandExecuteResult.getCommand().getEndLine());
                	commandResult.setStartLine(commandExecuteResult.getCommand().getStartLine());
                	commandResult.setMessage(commandExecuteResult.getMessage());
                	commandResult.setResult(commandExecuteResult.getResult() == CommandExecuteResultType.SUCCESS ? RunResultDict.SUCCESS : RunResultDict.FAILED);
                
                	IdeaJdbc.save(commandResult);
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @IdeaJdbcTx
	public void saveSchema(String projectId, String schemaName, String schemaDesc, String schemaScripts, String schemaHub,
			String schemaNodes, String schemaRunType) {
    	Date curTime = new Date();
    	String curUserId = "1"; 
    	
		RunSchema schema = new RunSchema();
		schema.setName(schemaName);
		schema.setCreateTime(curTime);
		schema.setCreatorId(curUserId);
		schema.setDesc(schemaDesc);
		schema.setModifierId(curUserId);
		schema.setModifyTime(curTime);
		schema.setProjectId(projectId);
    	schema.setRunType(schemaRunType);
    	
    	IdeaJdbc.save(schema);
    	
    	String schemaId = schema.getId();
    	
    	String[] scriptArr = schemaScripts.split(",");
    	for(String scriptId : scriptArr) {
    		SchemaScript script = new SchemaScript();
    		script.setCreateTime(curTime);
    		script.setCreatorId(curUserId);
    		script.setModifierId(curUserId);
    		script.setModifyTime(curTime);
    		script.setSchemaId(schemaId);
    		script.setScriptId(scriptId);
    		
    		IdeaJdbc.save(script);
    	}
    	
    	SchemaHub hub = new SchemaHub();
    	hub.setCreateTime(curTime);
    	hub.setCreatorId(curUserId);
    	hub.setModifierId(curUserId);
    	hub.setModifyTime(curTime);
    	hub.setNodeId(schemaHub);
    	hub.setSchemaId(schemaId);
    	
    	IdeaJdbc.save(hub);
    	
    	String[] nodeArr = schemaNodes.split(",");
    	for(String nodeId : nodeArr) {
    		SchemaNode node = new SchemaNode();
    		node.setCreateTime(curTime);
    		node.setCreatorId(curUserId);
    		node.setModifierId(curUserId);
    		node.setModifyTime(curTime);
    		node.setSchemaId(schemaId);
    		node.setNodeId(nodeId);
    		
    		IdeaJdbc.save(node);
    	}
	}
}
