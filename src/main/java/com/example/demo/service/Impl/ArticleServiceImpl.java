package com.example.demo.service.Impl;

import com.example.demo.domain.Article;
import com.example.demo.mapper.AriticleMapper;
import com.example.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl  implements ArticleService {

    @Autowired
    private AriticleMapper ariticleMapper;

    @Override
    public void addArticle(Article article) {
        ariticleMapper.addArticle(article);
    }

    @Override
    public void delArticleById(Integer id) {
        ariticleMapper.delArticleById(id);
    }

    @Override
    public Article findArticleById(Integer id) {
        return ariticleMapper.findArticleById(id);
    }

    @Override
    public void saveArticle(Article article) {
        ariticleMapper.saveArticle(article);
    }
}
