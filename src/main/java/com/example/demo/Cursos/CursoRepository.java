package com.example.demo.Cursos;

import com.example.demo.Cursos.CursoModel.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
