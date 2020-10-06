package com.example.demo.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTest {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void mapTest(){
        redisTemplate.opsForHash().put("map","fristkey",1);
        redisTemplate.opsForHash().increment("map","fristkey",1);
        redisTemplate.opsForHash().get("map","fristkey");

    }
}
