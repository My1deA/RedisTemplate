package com.example.demo.service;

import com.example.demo.domain.Article;

public interface ArticleService {
    void addArticle(Article article);
    void delArticleById(Integer id);
    Article findArticleById(Integer id);
    void saveArticle(Article article);

}
