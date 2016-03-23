package com.example.repository;

import com.example.domain.TestDomain;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Created by arahansa on 2016-03-24.
 */
@Repository
public class TestRepository {

    private ConcurrentHashMap<String, TestDomain> map = new ConcurrentHashMap<>();

    // Create
    public void saveDomain(TestDomain testDomain){
        map.put(testDomain.getPrivateKey(), testDomain);
    }

    // Read
    public TestDomain getDomain(String key){
        return map.get(key);
    }

    // Update (=Create)

    // Delete
    public void deleteTestDomain(String key){
        map.put(key, null);
    }

    // List
    public List<TestDomain> list(){
        return map.entrySet().stream().map(e ->e.getValue()).collect(Collectors.toList());
    }

}
