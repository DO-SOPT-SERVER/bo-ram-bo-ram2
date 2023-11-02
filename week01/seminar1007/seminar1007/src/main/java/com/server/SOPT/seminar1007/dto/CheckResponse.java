package com.server.SOPT.seminar1007.dto;
import lombok.Getter;

@Getter
public class CheckResponse {
    private int code;
    private String status;
    private boolean success;

    public CheckResponse(int code, String status, boolean success){
        this.code = code;
        this.status = status;
        this.success = success;
    }
}
