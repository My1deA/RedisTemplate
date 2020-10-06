package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;
import java.util.Set;

@RestController
@RequestMapping("/rank")
public class RankController {

    private String rankTitle="rankTitle";

    @Autowired
    private RedisTemplate redisTemplate;


    @GetMapping("/init")
    public String init(){
        for(int i=0;i<20;i++){
            redisTemplate.opsForZSet().add(rankTitle,"title"+i,0);
        }
        return "success";
    }


    @PostMapping("/incrementScore/{i}")
    public String add(@PathVariable("i")String i){
        redisTemplate.opsForZSet().incrementScore(rankTitle,"title"+i,1);
        return "success";
    }

    @GetMapping("/getAns")
    public String getAns(){
        Set<ZSetOperations.TypedTuple<String>> rangeWithScores=redisTemplate.opsForZSet().reverseRangeWithScores(rankTitle,0,10);
        Iterator<ZSetOperations.TypedTuple<String>> iterator=rangeWithScores.iterator();
        while(iterator.hasNext()){
            ZSetOperations.TypedTuple<String> tuple= iterator.next();
            System.out.println(tuple.getValue()+"  "+tuple.getScore());
        }

        System.out.println(JSON.toJSONString(rangeWithScores));
        return JSON.toJSONString(rangeWithScores);
    }



}
