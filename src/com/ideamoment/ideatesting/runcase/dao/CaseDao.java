/**
 * 
 */
package com.ideamoment.ideatesting.runcase.dao;

import org.springframework.stereotype.Component;

import com.ideamoment.ideajdbc.IdeaJdbc;
import com.ideamoment.ideajdbc.action.Page;
import com.ideamoment.ideatesting.model.CaseScript;
import com.ideamoment.ideatesting.model.RunCase;
import com.ideamoment.ideatesting.model.RunCaseGroup;

/**
 * @author Chinakite
 *
 */
@Component
public class CaseDao {

    public Page<RunCase> pageQueryCasesByProjectId(int curPage,
                                                   int pageSize,
                                                   String projectId)
    {
        String sql = "SELECT * FROM T_CASE WHERE C_PROJECT_ID = :projectId";
        return IdeaJdbc.query(sql)
                        .setParameter("projectId", projectId)
                        .pageTo(RunCase.class, curPage, pageSize);
    }

    public Page<RunCaseGroup> pageQueryCaseGroupsByProjectId(int curPage,
                                                             int pageSize,
                                                             String projectId)
    {
        String sql = "SELECT * FROM T_CASE_GROUP WHERE C_PROJECT_ID = :projectId";
        return IdeaJdbc.query(sql)
                        .setParameter("projectId", projectId)
                        .pageTo(RunCaseGroup.class, curPage, pageSize);
    }

}
