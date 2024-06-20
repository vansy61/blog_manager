package com.example.blog_manager.controllers;

import com.example.blog_manager.models.Blog;
import com.example.blog_manager.models.BlogForm;
import com.example.blog_manager.services.blog.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;


@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Value("${file-upload}")
    private String fileUpload;
    @Autowired
    private IBlogService blogService;

    @RequestMapping("/list")
    public String list(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "20") int pageSize,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "") String searchKey,
            Model model
    ) {
        Iterable<Blog> blogs = blogService.findAll(pageNo, pageSize, sortBy, searchKey);
        model.addAttribute("blogs", blogs);
        return "/blog/index";
    }

    @RequestMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Blog blog = blogService.findById(id);
        model.addAttribute("blog", blog);
        return "/blog/edit";
    }

    @PostMapping("/{id}/update")
    public String update(@ModelAttribute Blog blog, RedirectAttributes redirect) {
        blogService.save(blog);
        redirect.addFlashAttribute("success", "Cập nhật thành công!");
        return "redirect:/blogs/list";
    }

    @RequestMapping("/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirect) {
        blogService.deleteById(id);
        redirect.addFlashAttribute("success", "Xóa thành công!");
        return "redirect:/blogs/list";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        return "/blog/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute BlogForm blogForm, RedirectAttributes redirect) {
        MultipartFile multipartFile = blogForm.getAvatar();
        String fileName = multipartFile.getOriginalFilename();
        try {
            System.out.println(fileUpload);
            FileCopyUtils.copy(blogForm.getAvatar().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Blog blog = new Blog(blogForm.getId(), blogForm.getTitle(), blogForm.getSummary(), blogForm.getContent(), fileName, blogForm.getAuthor());
        blogService.save(blog);
        redirect.addFlashAttribute("success", "Tạo mới thành công!");
        return "redirect:/blogs/list";
    }

}
