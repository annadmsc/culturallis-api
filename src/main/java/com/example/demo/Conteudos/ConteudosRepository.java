package com.example.demo.Conteudos;

import com.example.demo.Conteudos.ConteudosModel.Conteudos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConteudosRepository extends JpaRepository<Conteudos, Long> {

    List<Conteudos> findAllByFkCulCursosId(Long fk_cul_courses_id);
}
