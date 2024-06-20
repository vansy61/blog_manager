package com.example.blog_manager.controllers;

import com.example.blog_manager.models.Blog;
import com.example.blog_manager.services.blog.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;



    @RequestMapping("/list")
    public String list(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "1") int pageSize,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "") String searchKey,
            Model model
    ) {
        Iterable<Blog> blogs = blogService.findAll(pageNo, pageSize, sortBy, searchKey);
        model.addAttribute("blogs", blogs);
        return "/blog/index";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "/edit";
    }
}
