/**
 * 
 */
package com.ideamoment.ideatesting.runcase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideamoment.ideajdbc.action.Page;
import com.ideamoment.ideajdbc.spring.IdeaJdbcTx;
import com.ideamoment.ideatesting.model.RunCase;
import com.ideamoment.ideatesting.model.RunCaseGroup;
import com.ideamoment.ideatesting.runcase.dao.CaseDao;

/**
 * @author Chinakite
 *
 */
@Service
public class CaseService {
    @Autowired
    private CaseDao caseDao;

    @IdeaJdbcTx
    public Page<RunCase> pageProjectCases(int curPage,
                                             int pageSize,
                                             String projectId)
    {
        return caseDao.pageQueryCasesByProjectId(curPage, pageSize, projectId);
    }

    @IdeaJdbcTx
    public Page<RunCaseGroup> pageProjectCaseGroups(int curPage,
                                               int pageSize,
                                               String projectId)
    {
        return caseDao.pageQueryCaseGroupsByProjectId(curPage, pageSize, projectId);
    }
}
