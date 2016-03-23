package com.example.controller;

import com.example.domain.TestDomain;
import com.example.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by arahansa on 2016-03-24.
 */
@Slf4j
@RestController
public class RestTestController {

    @Autowired
    TestService testService;

    @RequestMapping("/")
    private String index(){
        return "hello";
    }

    @RequestMapping("/list")
    public List<TestDomain> list(){
        return testService.list();
    }

    // Create
    @RequestMapping("/save")
    public TestDomain save(TestDomain testDomain){
        testService.saveDomain(testDomain);
        return testDomain;
    }

    // Read
    @RequestMapping("/get")
    public TestDomain get(String key){
        return testService.getDomain(key);
    }

    // Update
    @RequestMapping("/update")
    public String update(TestDomain testDomain, Model model){
        testService.saveDomain(testDomain);
        return "success";
    }

    // Delete
    @RequestMapping("/delete")
    public String delete(String key){
        testService.deleteTestDomain(key);
        return "success";
    }
}
