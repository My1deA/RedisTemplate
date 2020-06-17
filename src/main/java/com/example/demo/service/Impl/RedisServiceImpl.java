package com.example.demo.service.Impl;

import com.example.demo.domain.Article;
import com.example.demo.domain.User;
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
import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public User getUserByUsername(String username) {

        if(redisTemplate.hasKey(username)){
            User user=new User();
            String password = (String) redisTemplate.opsForValue().get(username);
            user.setUsername(username);
            user.setPassword(password);
            return user;
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        redisTemplate.opsForValue().set(user.getUsername(),user.getPassword());
        redisTemplate.expire(user.getUsername(),30, TimeUnit.SECONDS);
    }


    @Override
    public Article getArticleById(Integer id) {
        if (redisTemplate.opsForHash().hasKey(RedisKeyUtil.ARTICLE_KEY_MAP,id)){
            Article article= (Article) redisTemplate.opsForHash().get(RedisKeyUtil.ARTICLE_KEY_MAP,id);
            return article;
        }
        return null;
    }

    @Override
    public void addArticle(Article article) {
        redisTemplate.opsForHash().put(RedisKeyUtil.ARTICLE_KEY_MAP,article.getId(),article);

    }

    @Override
    public void praiseArticle(Integer id) {
        Article article= (Article) redisTemplate.opsForHash().get(RedisKeyUtil.ARTICLE_KEY_MAP,id);
        article.setPraise(article.getPraise()+1);
        redisTemplate.opsForHash().put(RedisKeyUtil.ARTICLE_KEY_MAP,id,article);
    }

    @Override
    public void disPraiseArticle(Integer id) {
        Article article= (Article) redisTemplate.opsForHash().get(RedisKeyUtil.ARTICLE_KEY_MAP,id);
        if(article.getPraise()!=0){
            article.setPraise(article.getPraise()-1);
        }
        redisTemplate.opsForHash().put(RedisKeyUtil.ARTICLE_KEY_MAP,id,article);
    }

    @Override
    public List<Article> getArticleList() {

        List<Article> articleList=new ArrayList<>();
        Cursor<Map<Object,Object>> cursor=redisTemplate.opsForHash().scan(RedisKeyUtil.ARTICLE_KEY_MAP, ScanOptions.NONE);
        while (cursor.hasNext()){
            Map.Entry<Object,Object> entry = (Map.Entry<Object, Object>) cursor.next();
            //String key =entry.getKey;
            Article article= (Article) entry.getValue();
            articleList.add(article);
        }
        System.out.println(articleList);
        return articleList;
    }


}
