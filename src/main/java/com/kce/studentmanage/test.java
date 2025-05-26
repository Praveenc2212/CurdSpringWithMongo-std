package com.kce.studentmanage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @GetMapping("/hello")
    public String Hello(){
        return "Hello Praveen";
    }
}
