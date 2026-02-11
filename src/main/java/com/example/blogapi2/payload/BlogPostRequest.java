package com.example.blogapi2.payload;

import java.util.UUID;

public class BlogPostRequest {

    private String title;
    private String content;
    private int readingTime;
    private UUID authorId;

    public BlogPostRequest() {
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getReadingTime() {
        return readingTime;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setReadingTime(int readingTime) {
        this.readingTime = readingTime;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }
}
