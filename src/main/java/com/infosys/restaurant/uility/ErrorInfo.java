package com.infosys.restaurant.uility;

import java.time.LocalDateTime;

public class ErrorInfo {

    private String message;
    private Integer errorCode;
    private LocalDateTime time;

    public ErrorInfo(String message, Integer errorCode, LocalDateTime time) {
        this.message = message;
        this.errorCode = errorCode;
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
