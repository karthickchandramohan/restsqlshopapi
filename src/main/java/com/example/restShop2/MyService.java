package com.example.restShop2;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class MyService {


    @Cacheable(value = "myCache", key = "#key")
    public String getValue(String key) {
        System.out.println("Fetching value for key: " + key);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Value for " + key;
    }

    @CacheEvict(value = "myCache", key = "#key")
    public void evictValue(String key) {
        System.out.println("Evicting cache for key: " + key);
    }
}
