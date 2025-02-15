package com.traini8.training_center_registry.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorResponse {
    private String errorMsg;
    private Object errorDetail;

    public ErrorResponse(String errorMsg, Object errorDetail) {
        this.errorMsg = errorMsg;
        this.errorDetail = errorDetail;
    }
    public ErrorResponse(String message, String error) {
        this.errorMsg = message;
        this.errorDetail = error;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getErrorDetail() {
        return errorDetail;
    }

    public void setErrorDetail(Object errorDetail) {
        this.errorDetail = errorDetail;
    }
}