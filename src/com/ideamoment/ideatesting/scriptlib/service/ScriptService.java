/**
 * 
 */
package com.ideamoment.ideatesting.scriptlib.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideamoment.caserunner.model.Case;
import com.ideamoment.caserunner.model.CaseFile;
import com.ideamoment.caserunner.model.CaseGroup;
import com.ideamoment.caserunner.parser.CaseFileParser;
import com.ideamoment.ideadp.appcontext.IdeaApplicationContext;
import com.ideamoment.ideadp.exception.IdeaDataException;
import com.ideamoment.ideadp.exception.IdeaDataExceptionCode;
import com.ideamoment.ideadp.usercontext.UserContext;
import com.ideamoment.ideajdbc.IdeaJdbc;
import com.ideamoment.ideajdbc.action.Page;
import com.ideamoment.ideajdbc.spring.IdeaJdbcTx;
import com.ideamoment.ideatesting.model.CaseScript;
import com.ideamoment.ideatesting.model.RunCase;
import com.ideamoment.ideatesting.model.RunCaseGroup;
import com.ideamoment.ideatesting.model.RunCaseGroupMap;
import com.ideamoment.ideatesting.scriptlib.dao.ScriptDao;

/**
 * @author Chinakite
 *
 */
@Service
public class ScriptService {
    
    @Autowired
    private ScriptDao scriptDao;

    @IdeaJdbcTx
    public List<CaseScript> listProjectScripts(String projectId) {
        return scriptDao.queryScriptsByProjectId(projectId);
    }

    @IdeaJdbcTx
    public Page<CaseScript> pageProjectScripts(int curPage, int pageSize, String projectId) {
        return scriptDao.pageQueryScriptsByProjectId(curPage, pageSize, projectId);
    }

    @IdeaJdbcTx
    public void parseScript(String id) {
        UserContext uc = UserContext.getCurrentContext();
        // User curUser =
        // (User)uc.getContextAttribute(UserContext.SESSION_USER);
        String userId = "1";
        Date curTime = new Date();
        
        CaseScript script = IdeaJdbc.find(CaseScript.class, id);
        String fileUrl = script.getFileUrl();
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
            for(String caseName : cases.keySet()) {
                Case caze = cases.get(caseName);
                RunCase runCase = new RunCase();
                runCase.setCreateTime(curTime);
                runCase.setCreatorId(userId);
                runCase.setEndLine(14);
                runCase.setModifierId(userId);
                runCase.setModifyTime(curTime);
                runCase.setName(caseName);
                runCase.setScriptId(id);
                runCase.setStartLine(5);
                
                IdeaJdbc.save(runCase);
            }
            
            Map<String, CaseGroup> groups = casefile.getGroups();
            for(String groupName : groups.keySet()) {
                CaseGroup caseGroup = groups.get(groupName);
                RunCaseGroup runCaseGroup = new RunCaseGroup();
                runCaseGroup.setCreateTime(curTime);
                runCaseGroup.setCreatorId(userId);
                runCaseGroup.setEndLine(3);
                runCaseGroup.setModifierId(userId);
                runCaseGroup.setModifyTime(curTime);
                runCaseGroup.setName(groupName);
                runCaseGroup.setScriptId(id);
                runCaseGroup.setStartLine(1);
                
                IdeaJdbc.save(runCaseGroup);
                
                List<String> caseIds = caseGroup.getCaseIds();
                for(String caseName : caseIds) {
                    RunCaseGroupMap mapping = new RunCaseGroupMap();
                    mapping.setCaseName(caseName);
                    mapping.setCreateTime(curTime);
                    mapping.setCreatorId(userId);
                    mapping.setGroupName(groupName);
                    mapping.setModifierId(userId);
                    mapping.setModifyTime(curTime);
                    IdeaJdbc.save(mapping);
                }
            }
            
        }catch(IOException e){
            e.printStackTrace();
            throw new IdeaDataException(IdeaDataExceptionCode.DATA_NOU_FOUND, String.format("Script file [{0}] is not found.", fileUrl));
        }
        
    }
    
}
