package com.example.blog_manager.repository;

import com.example.blog_manager.models.Blog;
import org.springframework.data.repository.CrudRepository;


public interface BlogRepository extends CrudRepository<Blog, Long> {
}
