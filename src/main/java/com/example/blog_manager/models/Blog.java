package com.example.blog_manager.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String summary;
    private String content;
    private String avatar;
    private String author;
    private Date createdAt;

    public Blog() {
        this.createdAt = new Date(System.currentTimeMillis());
    }

    public Blog(Long id, String title, String summary, String content, String avatar, String author) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.avatar = avatar;
        this.author = author;
        this.createdAt = new Date(System.currentTimeMillis());
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", avatar='" + avatar + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
