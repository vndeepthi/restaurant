package com.infosys.restaurant.uility;

import java.time.LocalDateTime;

public class ErrorInfo {

    private String message;
    private Integer errorCode;
    private LocalDateTime time;

    public ErrorInfo() {
    }

    public ErrorInfo(String message, Integer errorCode, LocalDateTime time) {
        this.message = message;
        this.errorCode = errorCode;
        this.time = time;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
