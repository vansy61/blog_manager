package com.example.blog_manager.services.blog;

import com.example.blog_manager.models.Blog;
import com.example.blog_manager.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class BlogService implements IBlogService {
    @Autowired
    private BlogRepository iBlogRepo;

    @Override
    public Page<Blog> findAll(int pageNo, int pageSize, String sortBy, String searchKey) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return iBlogRepo.findAll(pageable);
    }

    @Override
    public Blog findById(Long id) {
        return iBlogRepo.findById(id).orElse(null);
    }
}
