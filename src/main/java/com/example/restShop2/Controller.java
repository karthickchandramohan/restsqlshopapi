package com.example.restShop2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@EnableCaching
public class Controller {

    @Autowired
    private MyService myService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/value/{key}")
    public String getValue(@PathVariable String key) {
        return myService.getValue(key);
    }

    @GetMapping("/evict/{key}")
    public String evictValue(@PathVariable String key) {
        myService.evictValue(key);
        return "Cache evicted for key: " + key;
    }

    @GetMapping(value = "/hello")
    public String getHello(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Employee employee = new Employee();
        employee.setTitle("Test V2");
        employee = employeeRepository.save(employee);
        return "Hello from RestShop2 V3, created id "+employee.getId();
    }
}
