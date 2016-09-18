package com.ideamoment.ideatesting.datapool.dao;

import com.ideamoment.ideajdbc.IdeaJdbc;
import com.ideamoment.ideajdbc.action.Page;
import com.ideamoment.ideatesting.datapool.service.DataCell;
import com.ideamoment.ideatesting.model.CaseScript;
import com.ideamoment.ideatesting.model.Param;

import java.util.List;

import com.ideamoment.ideatesting.model.ParamTableValue;
import org.springframework.stereotype.Component;

/**
 * Created by zhangzhonghua on 2016/8/30.
 */
@Component
public class DataPoolDao {
    public Page<Param> pageQueryParamsByProjectId(int curPage, int pageSize, String projectId) {
        String sql = "SELECT * FROM T_PARAM WHERE C_PROJECT_ID = :projectId";
        return IdeaJdbc.query(sql)
                        .setParameter("projectId", projectId)
                        .pageTo(Param.class, curPage, pageSize);
    }

	public List<ParamTableValue> listParamTableHeader(String paramId) {
		String sql = "SELECT * FROM T_PARAM_TABLE WHERE C_PARAM_ID = :paramId AND C_ROW_NO = -1 ORDER BY C_CELL_NO ASC";
		return IdeaJdbc.query(sql).setParameter("paramId", paramId)
				       .listTo(ParamTableValue.class);
	}

	public List<ParamTableValue> listParamTableValues(String paramId) {
		String sql = "SELECT * FROM T_PARAM_TABLE WHERE C_PARAM_ID = :paramId AND C_ROW_NO > -1 ORDER BY C_ROW_NO ASC, C_CELL_NO ASC";
		return IdeaJdbc.query(sql).setParameter("paramId", paramId)
				       .listTo(ParamTableValue.class);
	}

	public List<ParamTableValue> listParamTableValues(String paramId, int startRow, int endRow) {
		String sql = "SELECT * FROM T_PARAM_TABLE WHERE C_PARAM_ID = :paramId AND C_ROW_NO >= :startRow and C_ROW_NO < :endRow ORDER BY C_ROW_NO ASC, C_CELL_NO ASC";
		return IdeaJdbc.query(sql)
					   .setParameter("paramId", paramId)
				       .setParameter("startRow", startRow)
				       .setParameter("endRow", endRow)
				       .listTo(ParamTableValue.class);
	}

	public long countParamTableRow(String paramId) {
		String sql = "select max(C_ROW_NO) from T_PARAM_TABLE where C_PARAM_ID = :paramId";
		return (Long)IdeaJdbc.query(sql).setParameter("paramId", paramId).uniqueValue();
	}
}
