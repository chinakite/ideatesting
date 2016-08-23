/**
 * 
 */
package com.ideamoment.ideatesting.report.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideamoment.ideajdbc.action.Page;
import com.ideamoment.ideajdbc.spring.IdeaJdbcTx;
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

}
