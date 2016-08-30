package com.ideamoment.ideatesting.datapool.service;

import com.ideamoment.ideajdbc.IdeaJdbc;
import com.ideamoment.ideajdbc.action.Page;
import com.ideamoment.ideajdbc.spring.IdeaJdbcTx;
import com.ideamoment.ideatesting.datapool.dao.DataPoolDao;
import com.ideamoment.ideatesting.model.CaseScript;
import com.ideamoment.ideatesting.model.Param;
import com.ideamoment.ideatesting.model.dict.ParamTypeDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by zhangzhonghua on 2016/8/29.
 */
@Service
public class DataPoolService {

    @Autowired
    private DataPoolDao dataPoolDao;

    @IdeaJdbcTx
    public Page<Param> pageProjectParams(int curPage, int pageSize, String projectId) {
        return dataPoolDao.pageQueryParamsByProjectId(curPage, pageSize, projectId);
    }

    @IdeaJdbcTx
    public void saveParam(String projectId, String name, String desc, String varName, String type, String value) {
        Date curTime = new Date();
        String curUserId = "1";

        Param param = new Param();
        param.setName(name);
        param.setDesc(desc);
        param.setProjectId(projectId);
        param.setType(type);
        param.setVarName(varName);
        param.setCreateTime(curTime);
        param.setCreatorId(curUserId);
        param.setModifyTime(curTime);
        param.setModifierId(curUserId);
        if(ParamTypeDict.VALUE.equals(type)) {
            param.setValue(value);
        }

        IdeaJdbc.save(param);
    }
}
