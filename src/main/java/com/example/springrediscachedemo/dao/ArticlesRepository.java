package com.example.springrediscachedemo.dao;

import com.example.springrediscachedemo.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticlesRepository extends JpaRepository<Article,Long> {

}
