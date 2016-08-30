package com.ideamoment.ideatesting.datapool.dao;

import com.ideamoment.ideajdbc.IdeaJdbc;
import com.ideamoment.ideajdbc.action.Page;
import com.ideamoment.ideatesting.model.CaseScript;
import com.ideamoment.ideatesting.model.Param;
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
}
