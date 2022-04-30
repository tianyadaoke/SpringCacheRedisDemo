package com.example.springrediscachedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {
    @Autowired
    ArticlesService articlesService;
    @GetMapping("/article/{id}")
    public Article getArticle(@PathVariable Long id){
        return articlesService.getArticle(id);
    }

}
