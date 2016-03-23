package com.example.controller;

import com.example.domain.TestDomain;
import com.example.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by arahansa on 2016-03-24.
 */
@Slf4j
@Controller
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/list")
    public String list(Model model){
        final List<TestDomain> list = testService.list();
        model.addAttribute("list", list);
        return "list";
    }

    // Create
    @RequestMapping("/save")
    public String save(TestDomain testDomain){
        log.debug("save :: {} ", testDomain);
        testService.saveDomain(testDomain);
        return "redirect:/list";
    }

    // Read
    @RequestMapping("/get")
    public String get(String key, Model model){
        final TestDomain domain = testService.getDomain(key);
        model.addAttribute("domain", domain);
        return "get";
    }

    // Update
    @RequestMapping("/update")
    public String update(TestDomain testDomain, Model model){
        model.addAttribute("domain", testDomain);
        testService.saveDomain(testDomain);
        return "redirect:/list";
    }

    // Delete
    @RequestMapping("/delete")
    public String delete(String key){
        testService.deleteTestDomain(key);
        return "redirect:/list";
    }

}
