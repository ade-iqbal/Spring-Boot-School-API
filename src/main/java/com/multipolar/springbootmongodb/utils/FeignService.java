package com.multipolar.springbootmongodb.utils;

import com.multipolar.springbootmongodb.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "feign-service-1", url = "http://localhost:1234/server1")
public interface FeignService {

    @GetMapping("/getStudents")
    List<Student> getAllStudents();

}
