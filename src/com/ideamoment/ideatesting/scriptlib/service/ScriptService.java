/**
 * 
 */
package com.ideamoment.ideatesting.scriptlib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideamoment.ideajdbc.spring.IdeaJdbcTx;
import com.ideamoment.ideatesting.model.CaseScript;
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
    public List<CaseScript> listScripts(String projectId) {
        return scriptDao.queryScriptsByProjectId(projectId);
    }
    
}
