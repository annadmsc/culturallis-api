package com.example.demo.Cursos;

import com.example.demo.Cursos.CursoModel.Curso;
import com.example.demo.CursosAdquiridos.CursosAdquiridosModel.CursosAdquiridosModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    List<Curso> findAllByFkCulUsuariosId(Long fk_cul_usuarios_id);
}
