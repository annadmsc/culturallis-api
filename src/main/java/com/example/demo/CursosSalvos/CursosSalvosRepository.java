package com.example.demo.CursosSalvos;

import com.example.demo.CursosSalvos.CursosSalvosModel.CursosSalvos;
import com.example.demo.Curtidas.CurtidaModel.Curtida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursosSalvosRepository extends JpaRepository<CursosSalvos, Long> {
    CursosSalvos findFirstByFkCulCursosIdAndFkCulUsuariosIdOrderByDataCriacaoDesc(Long idCourses, Long idUser);
}
