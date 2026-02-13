package com.example.blogapi2.controllers;

import com.example.blogapi2.entities.Author;
import com.example.blogapi2.repositories.AuthorRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.cloudinary.Cloudinary;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;



import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorRepository authorRepository;
    private final Cloudinary cloudinary;


    public AuthorController(AuthorRepository authorRepository,
                            Cloudinary cloudinary) {
        this.authorRepository = authorRepository;
        this.cloudinary = cloudinary;
    }


    // CREATE
    @PostMapping
    public Author createAuthor(@RequestBody @Valid Author author) {
        return authorRepository.save(author);
    }

    // READ ALL
    @GetMapping
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
    @PostMapping("/{id}/avatar")
    public Author uploadAvatar(@PathVariable UUID id,
                               @RequestParam("file") MultipartFile file) throws IOException {

        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), Map.of());

        String imageUrl = uploadResult.get("secure_url").toString();

        author.setAvatarUrl(imageUrl);

        return authorRepository.save(author);
    }

}
