package com.example.blog_manager.models;

import org.springframework.web.multipart.MultipartFile;

public class BlogForm {
    private Long id;
    private String title;
    private String summary;
    private String content;
    private String author;
    private MultipartFile avatar;

    public BlogForm() {
    }

    public BlogForm(Long id, String title, String summary, String content, String author, MultipartFile avatar) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.author = author;
        this.avatar = avatar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public MultipartFile getAvatar() {
        return avatar;
    }

    public void setAvatar(MultipartFile avatar) {
        this.avatar = avatar;
    }
}
