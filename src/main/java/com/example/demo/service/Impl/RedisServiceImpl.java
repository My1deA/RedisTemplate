package com.example.demo.service.Impl;

import com.example.demo.domain.Article;
import com.example.demo.service.RedisService;
import com.example.demo.util.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean increaseArticlePraise(Integer id) {
        Article article= (Article) redisTemplate.opsForHash().get(RedisKeyUtil.ARTICLE_KEY_MAP,id);
        article.setPraise(article.getPraise()+1);
        redisTemplate.opsForHash().put(RedisKeyUtil.ARTICLE_KEY_MAP,id,article);
        return true;
    }

    @Override
    public boolean decreaseArticlePraise(Integer id) {
        Article article= (Article) redisTemplate.opsForHash().get(RedisKeyUtil.ARTICLE_KEY_MAP,id);
        if(article.getPraise()!=0){
            article.setPraise(article.getPraise()-1);
        }
        redisTemplate.opsForHash().put(RedisKeyUtil.ARTICLE_KEY_MAP,id,article);
        return true;
    }

    @Override
    public List<Article> getArticleList() {

        List<Article> articleList=new ArrayList<>();
        Cursor<Map<Object,Object>> cursor=redisTemplate.opsForHash().scan(RedisKeyUtil.ARTICLE_KEY_MAP, ScanOptions.NONE);
        while (cursor.hasNext()){
            Map.Entry<Object,Object> entry = (Map.Entry<Object, Object>) cursor.next();
            Article article= (Article) entry.getValue();
            articleList.add(article);
        }
        System.out.println(articleList);
        return articleList;
    }
}
