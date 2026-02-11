package com.example.blogapi2.controllers;

import com.example.blogapi2.entities.Author;
import com.example.blogapi2.repositories.AuthorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    // CREATE
    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    // READ ALL
    @GetMapping
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}
