package com.example.blog_manager.services;

import com.example.blog_manager.models.Blog;
import com.example.blog_manager.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class BlogService implements IBlogService {
    @Autowired
    private BlogRepository iBlogRepo;

    @Override
    public Iterable<Blog> findAll() {
        return iBlogRepo.findAll();
    }
}
