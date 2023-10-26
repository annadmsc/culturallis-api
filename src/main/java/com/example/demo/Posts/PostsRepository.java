package com.example.demo.Posts;

import com.example.demo.Cursos.CursoModel.Curso;
import com.example.demo.Posts.PostModel.Post;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostsRepository extends JpaRepository<Post, Long> {
    List<Post> findByFkCulUsuariosId(Long fk_cul_usuarios_id);
}
