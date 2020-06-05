package com.example.demo.service.Impl;

import com.example.demo.domain.Article;
import com.example.demo.mapper.ArticleMapper;
import com.example.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl  implements ArticleService {

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
    public Article findArticleById(Integer id) {
        return articleMapper.findArticleById(id);
    }

    @Override
    public void saveArticle(Article article) {
        articleMapper.saveArticle(article);
    }
}
