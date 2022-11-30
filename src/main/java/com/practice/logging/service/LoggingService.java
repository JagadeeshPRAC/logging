package com.practice.logging.service;

import com.practice.logging.entity.Practice;
import com.practice.logging.repository.LoggingRepository;
import com.practice.logging.response.LoggingResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class LoggingService {

    @Autowired
    LoggingRepository loggingRepository;
    public ResponseEntity<LoggingResponse> getData() {
        LoggingResponse loggingResponse=new LoggingResponse();
        try{
            log.info("Reached to service layer ");
            List<Practice> practice=loggingRepository.getData();
            Map<Long,String> map =new HashMap<>();
            for (Practice p:practice
            ) {
                map.put(p.getPhone(),p.getName());
            }
             log.info("Query executed and fetched the result-set");
            loggingResponse.setStatus("SUCCESS");
            loggingResponse.setMessage("DATA_RETRIEVED_SUCCESSFULLY");
            loggingResponse.setData(map);
            log.info("Operation= Retrieve , message= Getting the details from practice table Result=COMPLETED");
            log.info("Response is :{}",loggingResponse);
            return new ResponseEntity<>(loggingResponse, HttpStatus.OK);
        }catch (Exception e){
            loggingResponse.setStatus("ERROR");
            loggingResponse.setMessage("EXCEPTION OCCURRED :"+e.getMessage());
            log.error("Operation= Retrieve , message= Getting the details from practice table Result=ERROR");
            return new ResponseEntity<>(loggingResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<LoggingResponse> getDataById(Integer id) {
        LoggingResponse loggingResponse = new LoggingResponse();
        try{
            log.info("input reached to service layer");
            Optional<Practice> practice=loggingRepository.findById(id);
            log.info("Query executed and database hit is success");
            if(practice.isEmpty()){
                log.info("Result-set is NULL");
                log.info("API = api/test/logging/data-by-id, METHOD=GET ,RESULT=FINSIHED and RESPONSE=:{}",practice);
                loggingResponse.setStatus("SUCCESS");
                loggingResponse.setMessage("NO_DATA_FOUND");
                return new ResponseEntity<>(loggingResponse, HttpStatus.OK);
            }else {
                loggingResponse.setStatus("SUCCESS");
                loggingResponse.setMessage("DATA_FECTHED :"+practice);
                log.info("API = api/test/logging/data-by-id, METHOD=GET ,RESULT=FINSIHED and RESPONSE=:{}",practice);
                return new ResponseEntity<>(loggingResponse, HttpStatus.OK);
            }
        }catch (Exception e){
            loggingResponse.setStatus("ERROR");
            loggingResponse.setMessage("EXCEPTION_OCCURED :"+e.getMessage());
            log.info("API = api/test/logging/data-by-id, METHOD=GET ,RESULT=ERROR");
            return new ResponseEntity<>(loggingResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
