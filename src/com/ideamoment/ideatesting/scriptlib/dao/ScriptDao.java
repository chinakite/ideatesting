/**
 * 
 */
package com.ideamoment.ideatesting.scriptlib.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ideamoment.ideajdbc.IdeaJdbc;
import com.ideamoment.ideajdbc.action.Page;
import com.ideamoment.ideatesting.model.CaseScript;

/**
 * @author Chinakite
 *
 */
@Component
public class ScriptDao {

    public List<CaseScript> queryScriptsByProjectId(String projectId) {
        String sql = "SELECT * FROM T_SCRIPT WHERE c_PROJECT_ID = :projectId";
        return IdeaJdbc.query(sql)
                        .setParameter("projectId", projectId)
                        .listTo(CaseScript.class);
    }

    public Page<CaseScript> pageQueryScriptsByProjectId(int curPage, int pageSize, String projectId) {
        String sql = "SELECT * FROM T_SCRIPT WHERE c_PROJECT_ID = :projectId";
        return IdeaJdbc.query(sql)
                        .setParameter("projectId", projectId)
                        .pageTo(CaseScript.class, curPage, pageSize);
    }
    
}
