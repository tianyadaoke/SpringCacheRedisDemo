package com.example.springrediscachedemo.service;

import com.example.springrediscachedemo.entity.Article;

public interface ArticlesService {
    Article getArticle(Long articleId);

    void removeArticle(Long articleId);

    void saveArticle(Article article);

    Article updateLikes(Long articleId, int likes);
}
