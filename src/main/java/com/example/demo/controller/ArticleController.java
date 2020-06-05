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
    public Article getArticleById(@PathVariable("id") Integer id){
        Article article=articleService.getArticleById(id);
        return article;
    }

    @PutMapping("/save")
    public String  saveArticle(@RequestBody  Article article){
        articleService.saveArticle(article);
        return "save article success";
    }

    //点赞
    @PutMapping("/praise/{id}")
    public String  praiseArticle(@PathVariable("id") Integer id){
        articleService.praiseArticle(id);
        return "praise article success";
    }

    //踩
    @PutMapping("/dispraise/{id}")
    public String  disPraiseArticle(@PathVariable("id")  Integer id){
        articleService.disPraiseArticle(id);
        return "dispraise article success";
    }

 /*   @Autowired
    private RedisService redisService;

    @GetMapping("/get/list")
    public List<Article> getArticleList(){
        return redisService.getArticleList();
    }


    @PutMapping("/praise/{id}")
    public String  praiseArticle(@PathVariable("id") Integer id){
        redisService.praiseArticle(id);
        return "praise article success";
    }

    @PutMapping("/dispraise/{id}")
    public String  disPraiseArticle(@PathVariable("id")  Integer id){
        redisService.disPraiseArticle(id);
        return "dispraise article success";
    }*/


}
