package com.example.springrediscachedemo.web;

import com.example.springrediscachedemo.service.ArticlesService;
import com.example.springrediscachedemo.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArticleController {
    @Autowired
    ArticlesService articlesService;

    @GetMapping("/article/{id}")
    public Article getArticle(@PathVariable Long id) {
        return articlesService.getArticle(id);
    }

    @DeleteMapping("/article/{id}")
    public void deleteArticle(@PathVariable Long id) {
        articlesService.removeArticle(id);
    }

    @PutMapping("/article")
    public Article updateArticle(@RequestBody Article article){
        return articlesService.updateLikes(article.getArticleId(),article.getLikes());
    }
}
