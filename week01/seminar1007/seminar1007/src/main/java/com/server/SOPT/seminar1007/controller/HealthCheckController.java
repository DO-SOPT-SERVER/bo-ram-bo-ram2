package com.server.SOPT.seminar1007.controller;

import com.server.SOPT.seminar1007.dto.HealthCheckResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HealthCheckController {
    @GetMapping("/v1")
    public Map<String , String>healthCheck(){
        Map<String, String> response = new HashMap<>();
        response.put("status","Ok");
        return response;
    }

    @GetMapping("v2")
    public ResponseEntity<String> healthCheck2(){
        return ResponseEntity.ok("ok");
    }

    @GetMapping("v3")
    public String healthCheck3(){
        return ("ok");
    }

    @GetMapping("v4")
    public ResponseEntity<Map<String, String>> healthCheck4(){
        Map<String, String> response = new HashMap<>();
        response.put("status","Ok");
        return ResponseEntity.ok(response);
    }

    @GetMapping("v5")
    public ResponseEntity<HealthCheckResponse> healthCheck5(){

        return ResponseEntity.ok(new HealthCheckResponse());
    }

    @GetMapping("v6")
    public ResponseEntity<HealthCheckResponse> healthCheck6(){

        return ResponseEntity.ok(new HealthCheckResponse());
    }
}
