package com.example.demo.Comentarios;

import com.example.demo.Comentarios.ComentarioModel.Comentario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
