package com.example.springrediscachedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CachingArticlesService implements ArticlesService{
    @Autowired
    ArticlesRepository articlesRepository;
    @Override
    @Cacheable(value = "articles",key = "#articleId",unless = "#result==null")
    // 不缓存null值
    public Article getArticle(Long articleId) {
        Optional<Article> optionalArticle = articlesRepository.findById(articleId);
        if(optionalArticle.isPresent()){
            return optionalArticle.get();
        }
        return null;
    }

    @Override
    public void removeArticle(Long articleId) {
        articlesRepository.deleteById(articleId);
    }

    @Override
    public void saveArticle(Article article) {
        articlesRepository.save(article);
    }

    @Override
    public Article updateLikes(Long articleId, int likes) {
        Optional<Article> articleOptional = articlesRepository.findById(articleId);
        if (articleOptional.isPresent()) {
            Article article = articleOptional.get();
            article.setLikes(likes);
            articlesRepository.save(article);
        }
        return null;
    }
}
