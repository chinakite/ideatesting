/**
 * 
 */
package com.ideamoment.ideatesting.report.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ideamoment.ideajdbc.IdeaJdbc;
import com.ideamoment.ideajdbc.action.Page;
import com.ideamoment.ideatesting.model.CaseResult;
import com.ideamoment.ideatesting.model.CommandResult;
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

	public List<CaseResult> queryCaseReportsBySchemaExecution(String schemaExecutionId) {
		String sql = "SELECT cr.C_ID as cr$id, "
				   +       " cr.C_CASE_NAME as cr$caseName, "
				   +       " cr.C_RESULT as cr$result, "
				   +       " cr.C_START_TIME as cr$startTime, "
				   +       " cr.C_END_TIME as cr$endTime, "
				   +       " cr.C_CREATOR_ID as cr$creatorId, "
				   +       " s.C_ID as s$id, "
				   +       " s.C_FILE_NAME as s$fileName "
				   + " FROM T_CASE_RESULT cr, T_SCRIPT s "
				   + " WHERE cr.C_SCHEMA_EXECUTION_ID = :schemaExecutionId "
				   +   " AND cr.C_SCRIPT_ID = s.C_ID "
				   + " ORDER BY cr.C_CREATETIME asc ";
		return IdeaJdbc.query(sql).setParameter("schemaExecutionId", schemaExecutionId).populate("script", "s").listTo(CaseResult.class, "cr");
	}

	public List<CommandResult> queryCommandReportsByCaseResult(String caseResultId) {
		String sql = "SELECT * FROM T_COMMAND_RESULT WHERE C_CASE_RESULT_ID = :caseResultId ORDER BY C_ID";
		return IdeaJdbc.query(sql).setParameter("caseResultId", caseResultId).listTo(CommandResult.class);
	}
}
