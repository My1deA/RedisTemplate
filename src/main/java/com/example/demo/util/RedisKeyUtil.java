package com.example.demo.util;

public class RedisKeyUtil {

    public static String ARTICLE_KEY_MAP="article_map";

    //以下未使用
    public static String USER_KEY_SET="user_set";
    public static String PRAISE_KEY_MAP="praise_map";

    public static String getKey(Integer articleId,Integer userId){
        StringBuffer key=new StringBuffer();
        key.append(articleId);
        key.append(":");
        key.append(userId);
        return key.toString();
    }
}
