package com.example.demo.service;

import com.example.demo.domain.Article;

import java.util.List;

public interface RedisService {

    //读取article
    boolean increaseArticlePraise(Integer id);
    boolean decreaseArticlePraise(Integer id);
    List<Article> getArticleList();

}
