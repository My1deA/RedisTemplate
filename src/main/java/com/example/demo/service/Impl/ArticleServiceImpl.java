package com.example.demo.service.Impl;

import com.example.demo.domain.Article;
import com.example.demo.mapper.ArticleMapper;
import com.example.demo.service.ArticleService;
import com.example.demo.util.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl  implements ArticleService {

    @Autowired
    private RedisTemplate redisTemplate;

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
        Article article;
        //在此新建redisMap来操作存放article
        if(redisTemplate.opsForHash().hasKey(RedisKeyUtil.ARTICLE_KEY_MAP,id)){
            article= (Article) redisTemplate.opsForHash().get(RedisKeyUtil.ARTICLE_KEY_MAP,id);
            System.out.println("redis map get");
        }else{
            System.out.println("mysql map get");
            article = articleMapper.findArticleById(id);
            redisTemplate.opsForHash().put(RedisKeyUtil.ARTICLE_KEY_MAP,id,article);
        }
        return article;
    }




    @Override
    public void saveArticle(Article article) {
        articleMapper.saveArticle(article);
    }
}
