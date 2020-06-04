package com.example.demo.domain;

import java.io.Serializable;

public class Praise implements Serializable {

    private Integer id;
    private Integer userId;
    private Integer articleId;
    private Integer ispraise;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getIspraise() {
        return ispraise;
    }

    public void setIspraise(Integer ispraise) {
        this.ispraise = ispraise;
    }

    @Override
    public String toString() {
        return "Praise{" +
                "id=" + id +
                ", userId=" + userId +
                ", articleId=" + articleId +
                ", ispraise=" + ispraise +
                '}';
    }
}
