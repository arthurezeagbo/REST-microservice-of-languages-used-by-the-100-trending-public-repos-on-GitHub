package com.arthurezeagbo.repodataservice.exceptions;

import java.util.Map;

public class ErrorJson {

    private Integer status;
    private String error;
    private String message;
    private String timeStamp;

    public ErrorJson(int status, Map<String, Object> errorAttributes){

        this.status = status;
        this.error = errorAttributes.get("error").toString();
        this.message = errorAttributes.get("message").toString();
        this.timeStamp = errorAttributes.get("timestamp").toString();
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

}
