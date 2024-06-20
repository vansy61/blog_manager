package com.example.blog_manager.services.blog;

import com.example.blog_manager.models.Blog;


public interface IBlogService {
    Iterable<Blog> findAll(int pageNo, int pageSize, String sortBy, String searchKey);
    Blog findById(Long id);
}
