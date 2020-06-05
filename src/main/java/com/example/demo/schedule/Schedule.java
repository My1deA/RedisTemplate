package com.example.demo.schedule;

import com.example.demo.domain.Article;
import com.example.demo.service.ArticleService;
import com.example.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.List;

@Configuration
@EnableScheduling
public class Schedule {

    /* * 第一位，表示秒，取值0-59
       * 第二位，表示分，取值0-59
       * 第三位，表示小时，取值0-23
       * 第四位，日期天/日，取值1-31
       * 第五位，日期月份，取值1-12
       * 第六位，星期，取值1-7，星期一，星期二...，注：不是第1周，第二周的意思
    另外：1表示星期天，2表示星期一。
       * 第7为，年份，可以留空，取值1970-2099
       * */

    @Autowired
    private RedisService redisService;

    @Autowired
    private ArticleService articleService;

    //crontab 和linux 多了个秒
    @Scheduled(cron = "0 * * * * *")
    public void refreshMysql(){
        List<Article> articleList=redisService.getArticleList();
        for(Article article : articleList){
            articleService.saveArticle(article);
        }
        System.out.println("定时写入数据库"+new Date());
    }
}
