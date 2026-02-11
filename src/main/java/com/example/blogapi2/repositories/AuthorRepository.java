package com.example.blogapi2.repositories;

import com.example.blogapi2.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
}
