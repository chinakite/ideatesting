package com.ideamoment.ideatesting.datapool.dao;

import com.ideamoment.ideajdbc.IdeaJdbc;
import com.ideamoment.ideajdbc.action.Page;
import com.ideamoment.ideatesting.datapool.service.DataCell;
import com.ideamoment.ideatesting.model.CaseScript;
import com.ideamoment.ideatesting.model.Param;

import java.util.List;

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

	public List<DataCell> listParamTableHeader(String paramId) {
		String sql = "SELECT * FROM T_PARAM_TABLE WHERE C_PARAM_ID = :paramId AND C_ROW_NO = -1 ORDER BY C_CELL_NO ASC";
		return IdeaJdbc.query(sql).setParameter("paramId", paramId)
				       .listTo(DataCell.class);
	}

	public List<DataCell> listParamTableValues(String paramId) {
		String sql = "SELECT * FROM T_PARAM_TABLE WHERE C_PARAM_ID = :paramId AND C_ROW_NO > -1 ORDER BY C_ROW_NO ASC, C_CELL_NO ASC";
		return IdeaJdbc.query(sql).setParameter("paramId", paramId)
				       .listTo(DataCell.class);
	}

	public Page<DataCell> pageParamTableValues(String paramId, int curPage, int pageSize) {
		String sql = "SELECT * FROM T_PARAM_TABLE WHERE C_PARAM_ID = :paramId AND C_ROW_NO > -1 ORDER BY C_ROW_NO ASC, C_CELL_NO ASC";
		return IdeaJdbc.query(sql).setParameter("paramId", paramId)
				       .pageTo(DataCell.class, curPage, pageSize);
	}
}
