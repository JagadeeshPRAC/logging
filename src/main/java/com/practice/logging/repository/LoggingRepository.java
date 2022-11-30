package com.practice.logging.repository;

import com.practice.logging.entity.Practice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoggingRepository extends JpaRepository<Practice,Integer> {

    @Query(value="select * from practice",nativeQuery = true)
    List<Practice> getData();
}
