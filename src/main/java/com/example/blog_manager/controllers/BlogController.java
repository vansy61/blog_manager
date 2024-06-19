package com.example.blog_manager.controllers;

import com.example.blog_manager.models.Blog;
import com.example.blog_manager.services.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;



    @RequestMapping("/list")
    public String list(Model model) {
        Iterable<Blog> blogs = blogService.findAll();
        model.addAttribute("blogs", blogs);
        return "/index";
    }

}
