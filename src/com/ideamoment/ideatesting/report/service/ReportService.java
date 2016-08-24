/**
 * 
 */
package com.ideamoment.ideatesting.report.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideamoment.ideajdbc.action.Page;
import com.ideamoment.ideajdbc.spring.IdeaJdbcTx;
import com.ideamoment.ideatesting.model.CaseResult;
import com.ideamoment.ideatesting.model.CommandResult;
import com.ideamoment.ideatesting.model.SchemaExecution;
import com.ideamoment.ideatesting.report.dao.ReportDao;

/**
 * @author Chinakite
 *
 */
@Service
public class ReportService {
	
	@Autowired
	private ReportDao reportDao;
	
	
	@IdeaJdbcTx
	public Page<SchemaExecution> pageProjectReports(int curPage, int pageSize, String projectId) {
		return reportDao.pageQueryReportsByProjectId(curPage, pageSize, projectId);
	}

	@IdeaJdbcTx
	public List<CaseResult> listCaseReports(String schemaExecutionId) {
		return reportDao.queryCaseReportsBySchemaExecution(schemaExecutionId);
	}

	@IdeaJdbcTx
	public List<CommandResult> listCommandReports(String caseResultId) {
		return reportDao.queryCommandReportsByCaseResult(caseResultId);
	}

}
