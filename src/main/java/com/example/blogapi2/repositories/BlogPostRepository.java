package com.example.blogapi2.repositories;

import com.example.blogapi2.entities.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface BlogPostRepository extends JpaRepository<BlogPost, UUID> {
}
