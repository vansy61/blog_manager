package com.example.blog_manager.repository;

import com.example.blog_manager.models.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface BlogRepository extends PagingAndSortingRepository<Blog, Long> {
}


