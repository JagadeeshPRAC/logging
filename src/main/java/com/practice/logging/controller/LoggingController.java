package com.practice.logging.controller;

import com.practice.logging.response.LoggingResponse;
import com.practice.logging.service.LoggingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test/logging")
@Slf4j
public class LoggingController {

    @Autowired
    LoggingService loggingService;


    @GetMapping("/get-data")
    public ResponseEntity<LoggingResponse> getData(){
        log.info("Operation= Retrieve , message= Getting all the details from practice table Result=IN_PROGRESS");
        return loggingService.getData();
    }

    @GetMapping("/data-by-id")
    public ResponseEntity<LoggingResponse> getDataById(@RequestParam(name="id") Integer id){
        log.info("API = api/test/logging/data-by-id, METHOD=GET ,RESULT=IN_PROGRESS and REQUEST=:{}",id);
        return loggingService.getDataById(id);
    }
}
