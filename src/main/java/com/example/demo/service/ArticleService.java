package com.example.demo.service;

import com.example.demo.domain.Article;


public interface ArticleService {

    void addArticle(Article article);
    void delArticleById(Integer id);
    Article getArticleById(Integer id);
    void saveArticle(Article article);

    //点赞
    void praiseArticle(Integer id);
    //财
    void disPraiseArticle(Integer id);

}
