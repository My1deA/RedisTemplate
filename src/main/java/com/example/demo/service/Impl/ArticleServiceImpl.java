package com.example.demo.service.Impl;

import com.example.demo.domain.Article;
import com.example.demo.mapper.ArticleMapper;
import com.example.demo.service.ArticleService;
import com.example.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl  implements ArticleService {

    @Autowired
    private RedisService redisService;

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void addArticle(Article article) {
        articleMapper.addArticle(article);
    }

    @Override
    public void delArticleById(Integer id) {
        articleMapper.delArticleById(id);
    }

    @Override
    public Article getArticleById(Integer id) {
        Article article = redisService.getArticleById(id);
        //在此新建redisMap来操作存放article
        if(article !=null){
            System.out.println("redis map get");
        }else{
            System.out.println("mysql map get");
            article = articleMapper.getArticleById(id);
            redisService.addArticle(article);
        }
        return article;
    }

    @Override
    public void saveArticle(Article article) {
        articleMapper.saveArticle(article);
    }


    @Override
    public void praiseArticle(Integer id) {
        redisService.praiseArticle(id);
    }

    @Override
    public void disPraiseArticle(Integer id) {
        redisService.disPraiseArticle(id);
    }

}
