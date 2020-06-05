package com.example.demo.controller;

import com.example.demo.domain.Article;
import com.example.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    @PutMapping("/save")
    public String  saveArticle(@RequestBody  Article article){
        articleService.saveArticle(article);
        return "save article success";
    }
}
