package com.example.springrediscachedemo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticlesRepository extends JpaRepository<Article,Long> {

}
