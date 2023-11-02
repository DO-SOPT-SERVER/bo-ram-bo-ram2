package com.server.SOPT.seminar1007.dto;

import lombok.Getter;

@Getter
public class HealthCheckResponse {
    private static final String STATUS ="OK";
    private String status;
    public HealthCheckResponse(){//클래스랑 이름 똑같이
        this.status=STATUS;
    }
}
