package com.register.register.response;

import io.micrometer.core.instrument.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;

public class BaseResponse {

    private String objectId;
    private String objectName;
    private boolean success;
    private String errorStatus;
    private Collection<String> errors;

    public Collection<String> getErrors() {
        if(errors == null) {
            this.errors = new ArrayList<>();
        }
        return this.errors;
    }

    public String getErrorStatus() {
        return errorStatus;
    }

    public boolean isError() {
        return StringUtils.isNotBlank(errorStatus);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setErrorStatus(String errorStatus) {
        this.errorStatus = errorStatus;
    }


    public void setErrors(Collection<String> errors) {
        this.errors = errors;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }
}
