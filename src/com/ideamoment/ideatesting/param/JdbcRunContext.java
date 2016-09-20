package com.ideamoment.ideatesting.param;

import com.ideamoment.caserunner.model.parameterize.*;
import com.ideamoment.caserunner.runner.RunContext;
import com.ideamoment.ideajdbc.IdeaJdbc;
import com.ideamoment.ideatesting.model.Param;
import com.ideamoment.ideatesting.model.ParamTableValue;
import com.ideamoment.ideatesting.model.ParamUsedLog;
import com.ideamoment.ideatesting.model.dict.ParamTypeDict;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhangzhonghua on 2016/9/19.
 */
public class JdbcRunContext implements RunContext {

	private ConcurrentHashMap context = new ConcurrentHashMap();
	
    @Override
    public String resolveValue(List<ParamMethod> paramMethods) {
        Object curObj = context;

        for(int i=0; i<paramMethods.size(); i++) {
            ParamMethod method = paramMethods.get(i);

            if(method.getType() == ParamValueType.PROP) {
                PropertyMethod propMethod = (PropertyMethod)method;
                String propName = propMethod.getInputParam1();
                String aliasName = propMethod.getInputParam2();

                curObj = resolvePropertyValue(curObj, propName, aliasName);
            }else if(method.getType() == ParamValueType.RAND){
                RandomMethod randMethod = (RandomMethod)method;
                String propName = randMethod.getDataName();
                String aliasName = randMethod.getAliasName();

                curObj = resolveRandomValue(curObj, propName, aliasName);
            }else if(method.getType() == ParamValueType.SEQ){
                SequenceMethod seqMethod = (SequenceMethod)method;
                String propName = seqMethod.getDataName();
                String aliasName = seqMethod.getAliasName();

                curObj = resolveSequenceValue(curObj, propName, aliasName);
            }else if(method.getType() == ParamValueType.UNIQUE){
                UniqueMethod uniqueMethod = (UniqueMethod)method;
                String propName = uniqueMethod.getDataName();
                String aliasName = uniqueMethod.getAliasName();

                curObj = resolveSequenceValue(curObj, propName, aliasName);
            }else if(method.getType() == ParamValueType.REF){
                ReferenceMethod refMethod = (ReferenceMethod)method;
                String refName = refMethod.getInputParam1();
                curObj = context.get(refName);
            }
        }

        if(curObj != null) {
        	return curObj.toString();
        }else{
        	return "";
        }
    }

    private Object resolvePropertyValue(Object curObj, String propName, String aliasName) {
        try {
            Object retObj = PropertyUtils.getProperty(curObj, propName);
            if(aliasName != null) {
                context.put(aliasName, retObj);
            }
            return retObj;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Object resolveSequenceValue(Object curObj, String propName, String aliasName) {
        IdeaJdbc.beginTransaction();
        String projectId = (String)context.get("projectId");

        String sql = "select * from t_param where C_PROJECT_ID = :projectId and C_VAR_NAME = :varName";
        Param param = (Param)IdeaJdbc.query(sql)
                                      .setParameter("projectId", projectId)
                                      .setParameter("varName", propName)
                                      .uniqueTo(Param.class);

        String paramId = param.getId();
        String paramType = param.getType();

        Map<String, String> resultObj = new HashMap<String, String>();

        if(ParamTypeDict.TABLE.equals(paramType)) {
            sql = "select max(C_ROW_NO) from T_PARAM_USED_LOG where c_param_id = :paramId";
            int maxRowNo = 0;
            Object obj = IdeaJdbc.query(sql).setParameter("paramId", paramId).uniqueValue();
            if(obj != null) {
                maxRowNo = (Integer)obj;
                maxRowNo++;
            }

            sql = "select * from t_param_table where c_param_id = :paramId and c_row_no = :rowNo order by c_cell_no";
            List<ParamTableValue> result = IdeaJdbc.query(sql).setParameter("paramId", paramId).setParameter("rowNo", maxRowNo).listTo(ParamTableValue.class);

            for(ParamTableValue tableValue : result) {
                resultObj.put(tableValue.getColumn(), tableValue.getValue());
                logParamUsed(paramId, (String)context.get("schemaExecutionId"), tableValue.getRowNo());
            }
        }

        IdeaJdbc.endTransaction();
        return resultObj;
	}

	private Object resolveRandomValue(Object curObj, String propName, String aliasName) {
        IdeaJdbc.beginTransaction();
        String projectId = (String)context.get("projectId");

        String sql = "select * from t_param where C_PROJECT_ID = :projectId and C_VAR_NAME = :varName";
        Param param = (Param)IdeaJdbc.query(sql)
                .setParameter("projectId", projectId)
                .setParameter("varName", propName)
                .uniqueTo(Param.class);

        String paramId = param.getId();
        String paramType = param.getType();

        Map<String, String> resultObj = new HashMap<String, String>();

        if(ParamTypeDict.TABLE.equals(paramType)) {
            sql = "select max(C_ROW_NO) from t_param_table where c_param_id = :paramId";
            int count = (Integer)IdeaJdbc.query(sql).setParameter("paramId", paramId).uniqueValue();
            Random ran = new Random();
            int ranValue = ran.nextInt(count);

            sql = "select * from t_param_table where c_param_id = :paramId and c_row_no = :rowNo order by c_cell_no";
            List<ParamTableValue> result = IdeaJdbc.query(sql).setParameter("paramId", paramId).setParameter("rowNo", ranValue).listTo(ParamTableValue.class);

            for(ParamTableValue tableValue : result) {
                resultObj.put(tableValue.getColumn(), tableValue.getValue());
                logParamUsed(paramId, (String)context.get("schemaExecutionId"), tableValue.getRowNo());
            }
        }

        IdeaJdbc.endTransaction();
        return resultObj;
	}

    private void logParamUsed(String paramId, String schemaExecutionId, int rowNo) {
        String curUserId = "1";
        Date curTime = new Date();

        ParamUsedLog log = new ParamUsedLog();
        log.setParamId(paramId);
        log.setRowNo(rowNo);
        log.setSchemaExecutionId(schemaExecutionId);
        log.setCreateTime(curTime);
        log.setCreatorId(curUserId);
        log.setModifierId(curUserId);
        log.setModifyTime(curTime);

        IdeaJdbc.save(log);
    }

    @Override
    public void setContext(ConcurrentHashMap context) {
    	this.context = context;
    }
}
