package com.example.demo.Posts;

import com.example.demo.Posts.PostModel.Post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Post, Long> {
}
