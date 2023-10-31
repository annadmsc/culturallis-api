package com.example.demo.FavoritosCurso;

import com.example.demo.FavoritosCurso.FavoritosCursoModel.FavoritoCurso;

import com.example.demo.Usuarios.UsuariosModel.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritosCursoRepository extends JpaRepository<FavoritoCurso, Long> {
    FavoritoCurso findFirstByFkCulCursosIdAndFkCulUsuariosIdOrderByDataCriacaoDesc(long cursoId, Long aLong);


}
