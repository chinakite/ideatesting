/**
 * 
 */
package com.ideamoment.ideatesting.report.dao;

import org.springframework.stereotype.Component;

import com.ideamoment.ideajdbc.IdeaJdbc;
import com.ideamoment.ideajdbc.action.Page;
import com.ideamoment.ideatesting.model.RunSchema;
import com.ideamoment.ideatesting.model.SchemaExecution;

/**
 * @author Chinakite
 *
 */
@Component
public class ReportDao {
	public Page<SchemaExecution> pageQueryReportsByProjectId(int curPage, int pageSize, String projectId) {
		String sql = "SELECT se.C_ID as se$id, "
				   +       " se.C_START_TIME as se$startTime, "
				   +       " se.C_END_TIME as se$endTime, "
				   +       " se.C_STATE as se$state, "
				   +       " se.C_CREATOR_ID as se$creatorId, "
				   +       " s.C_ID as s$id, "
				   +       " s.C_NAME as s$name "
				   + " FROM T_SCHEMA_EXECUTION se, T_SCHEMA s "
				   + " WHERE se.C_PROJECT_ID = :projectId "
				   +   " AND se.C_SCHEMA_ID = s.C_ID "
				   + "ORDER BY se.C_CREATETIME DESC ";
		return IdeaJdbc.query(sql).setParameter("projectId", projectId).populate("schema", "s").pageTo(SchemaExecution.class, "se", curPage, pageSize);
	}
}
