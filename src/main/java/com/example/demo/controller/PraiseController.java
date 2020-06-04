package com.example.demo.controller;

import com.example.demo.domain.Article;
import com.example.demo.domain.Praise;
import com.example.demo.domain.User;
import com.example.demo.service.ArticleService;
import com.example.demo.service.PraiseService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/praise")
public class PraiseController {

    @Autowired
    private PraiseService praiseService;

    @PostMapping("/add")
    public String  addPraise(Praise praise){
        praiseService.addPraise(praise);
        return "add praise success";
    }

    @DeleteMapping("/del/{id}")
    public String delPraiseById(@PathVariable("id") Integer id){
        praiseService.delPraiseById(id);
        return "del praise success";
    }

    @GetMapping("/get/{id}")
    public Praise findPraiseById(@PathVariable("id") Integer id){
        Praise praise=praiseService.findPraiseById(id);
        return praise;
    }


    @PutMapping("/save")
    public String  savePraise(Praise praise){
        praiseService.savePraise(praise);
        return "save praise success";
    }
}
