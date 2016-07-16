/**
 * 
 */
package com.ideamoment.ideatesting.schema.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideamoment.caserunner.model.BrowserType;
import com.ideamoment.caserunner.model.Case;
import com.ideamoment.caserunner.model.CaseFile;
import com.ideamoment.caserunner.model.Env;
import com.ideamoment.caserunner.parser.CaseFileParser;
import com.ideamoment.caserunner.runner.CaseRunner;
import com.ideamoment.caserunner.runner.RemoteCaseRunner;
import com.ideamoment.ideadp.appcontext.IdeaApplicationContext;
import com.ideamoment.ideadp.exception.IdeaDataException;
import com.ideamoment.ideadp.exception.IdeaDataExceptionCode;
import com.ideamoment.ideajdbc.IdeaJdbc;
import com.ideamoment.ideajdbc.action.Page;
import com.ideamoment.ideajdbc.spring.IdeaJdbcTx;
import com.ideamoment.ideatesting.model.CaseScript;
import com.ideamoment.ideatesting.model.RunCase;
import com.ideamoment.ideatesting.model.RunSchema;
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
        RunSchema schema = IdeaJdbc.find(RunSchema.class, id);
        List<RunCase> runCases = schemaDao.queryCasesBySchema(id);
        HashSet<String> scriptIds = new HashSet<String>();
        for(RunCase runCase : runCases) {
            scriptIds.add(runCase.getScriptId());
        }
        
        Map<String, Case> allCases = new HashMap<String, Case>();
        for(String scriptId : scriptIds) {
            CaseScript caseScript = IdeaJdbc.find(CaseScript.class, scriptId);
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

        RemoteCaseRunner runner = new RemoteCaseRunner();
        runner.setAddress("localhost");
        runner.setPort("4444");
        
        for(RunCase runCase : runCases) {
            String caseName = runCase.getName();
            Case caze = allCases.get(caseName);
            runner.run(env, caze);
        }
        
    }
}
