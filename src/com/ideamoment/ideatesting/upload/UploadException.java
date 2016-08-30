package com.ideamoment.ideatesting.upload;

import com.ideamoment.ideadp.exception.IdeaBaseException;

/**
 * Created by zhangzhonghua on 2016/8/30.
 */
public class UploadException extends IdeaBaseException {

    private static final long serialVersionUID = -8936870627520065255L;

    public UploadException(String code, String message) {
        super(code, message);
    }

    public UploadException(String code, String message, Throwable e) {
        super(code, message, e);
    }
}