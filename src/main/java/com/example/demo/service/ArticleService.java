package com.example.demo.service;

import com.example.demo.domain.Article;

import java.util.List;

public interface ArticleService {

    void addArticle(Article article);
    void delArticleById(Integer id);
    Article findArticleById(Integer id);
    List<Article> getArticle();
    void saveArticle(Article article);

}
