package com.server.SOPT.seminar1007.controller;

import com.server.SOPT.seminar1007.dto.CheckResponse;
import com.server.SOPT.seminar1007.dto.HealthCheckResponse;
import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.Person;

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
    //        Person person = new Person("보람", "김");
    //        Person person2 = new Person("김", "보람");
    // 파라미터 순서가 기억안날 때 >> 빌더패턴
        Person person = Person.builder()
                .lastName("김")
                .firstName("보람")
                .build();
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

    //다르게해보기
    @GetMapping("v6")
    public ResponseEntity<HealthCheckResponse> healthCheck6(){
        HttpHeaders header = new HttpHeaders();
        HealthCheckResponse healthCheckResponse = new HealthCheckResponse();
        return ResponseEntity.status(HttpStatus.OK).headers(header).body(healthCheckResponse);
    }
    //심화과제
    @GetMapping("v7")
    public CheckResponse healthCheck7(){
        String statusMessage = "OK";
        return new CheckResponse(HttpStatus.OK.value(), statusMessage, true);
    }

}
