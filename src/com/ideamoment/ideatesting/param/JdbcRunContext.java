package com.ideamoment.ideatesting.param;

import com.ideamoment.caserunner.model.parameterize.*;
import com.ideamoment.caserunner.runner.RunContext;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhangzhonghua on 2016/9/19.
 */
public class JdbcRunContext implements RunContext {

    @Override
    public String resolveValue(List<ParamMethod> paramMethods) {
        Object curObj = context;

        for(ParamMethod method : paramMethods) {
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

        return null;
    }

    @Override
    public void setContext(ConcurrentHashMap concurrentHashMap) {

    }
}
