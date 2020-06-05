package com.example.demo.controller;

import com.example.demo.domain.Article;
import com.example.demo.service.ArticleService;
import com.example.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/add")
    public String  addArticle(Article article){
        articleService.addArticle(article);
        return "add article success";
    }

    @DeleteMapping("/del/{id}")
    public String delArticleById(@PathVariable("id") Integer id){
        articleService.delArticleById(id);
        return "del article success";
    }

    @GetMapping("/get/{id}")
    public Article findArticleById(@PathVariable("id") Integer id){
        Article article=articleService.findArticleById(id);
        return article;
    }

    //测试
    @GetMapping("/get/list")
    public List<Article> findArticle(){

    }


    @PutMapping("/praise/{id}")
    public String  praiseArticle(Integer id){

        return "praise article success";
    }

    @PutMapping("/dispraise/{id}")
    public String  praiseArticle(Integer id){

        return "dispraise article success";
    }

    @PutMapping("/save")
    public String  saveArticle(@RequestBody  Article article){
        articleService.saveArticle(article);
        return "save article success";
    }
}
