package com.example.service;

import com.example.domain.TestDomain;
import com.example.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by arahansa on 2016-03-24.
 */
@Service
public class TestService {
    @Autowired
    TestRepository testRepository;


    // Create
    public void saveDomain(TestDomain testDomain){
        testRepository.saveDomain(testDomain);
    }

    // Read
    public TestDomain getDomain(String key){
        return testRepository.getDomain(key);
    }

    // Update (=Create)

    // Delete
    public void deleteTestDomain(String key){
        testRepository.deleteTestDomain(key);
    }

    // List
    public List<TestDomain> list(){
        return testRepository.list();
    }
}
