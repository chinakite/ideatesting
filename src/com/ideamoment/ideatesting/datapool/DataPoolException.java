package com.ideamoment.ideatesting.datapool;

import com.ideamoment.ideadp.exception.IdeaBaseException;

/**
 * Created by zhangzhonghua on 2016/9/2.
 */
public class DataPoolException extends IdeaBaseException {
    private static final long serialVersionUID = -8936870627520065255L;

    public DataPoolException(String code, String message) {
        super(code, message);
    }

    public DataPoolException(String code, String message, Throwable e) {
        super(code, message, e);
    }
}
