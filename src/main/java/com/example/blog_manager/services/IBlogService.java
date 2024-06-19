package com.example.blog_manager.services;

import com.example.blog_manager.models.Blog;


public interface IBlogService {
    Iterable<Blog> findAll();
}
