package com.practice.logging.response;

import com.practice.logging.entity.Practice;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class LoggingResponse {

    private String status;
    private String message;
    private Map<Long,String> data;
}
