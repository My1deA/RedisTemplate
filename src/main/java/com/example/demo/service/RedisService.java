package com.example.demo.service;

import com.example.demo.domain.Article;
import com.example.demo.domain.User;

import java.util.List;

public interface RedisService {

    //user
    User getUserByUsername(String username);
    void addUser(User user);

    //article
    Article getArticleById(Integer id);
    void addArticle(Article article);
    //修改article 点赞
    void praiseArticle(Integer id);
    void disPraiseArticle(Integer id);
    //获取 article list
    List<Article> getArticleList();




}
