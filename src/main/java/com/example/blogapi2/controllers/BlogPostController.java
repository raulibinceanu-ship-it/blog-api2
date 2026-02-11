package com.example.blogapi2.controllers;

import com.example.blogapi2.entities.Author;
import com.example.blogapi2.entities.BlogPost;
import com.example.blogapi2.payload.BlogPostRequest;
import com.example.blogapi2.repositories.AuthorRepository;
import com.example.blogapi2.repositories.BlogPostRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogposts")
public class BlogPostController {

    private final BlogPostRepository blogPostRepository;
    private final AuthorRepository authorRepository;

    public BlogPostController(BlogPostRepository blogPostRepository,
                              AuthorRepository authorRepository) {
        this.blogPostRepository = blogPostRepository;
        this.authorRepository = authorRepository;
    }

    @PostMapping
    public BlogPost createBlogPost(@RequestBody BlogPostRequest request) {

        Author author = authorRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        BlogPost blogPost = new BlogPost();
        blogPost.setTitle(request.getTitle());
        blogPost.setContent(request.getContent());
        blogPost.setReadingTime(request.getReadingTime());
        blogPost.setAuthor(author);

        return blogPostRepository.save(blogPost);
    }

    @GetMapping
    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }
    @GetMapping("/{id}")
    public BlogPost getBlogPostById(@PathVariable java.util.UUID id) {
        return blogPostRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BlogPost not found"));
    }
}
