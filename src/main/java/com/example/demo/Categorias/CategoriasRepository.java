package com.example.demo.Categorias;

import com.example.demo.Categorias.CategoriasModel.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriasRepository extends JpaRepository<Categorias, Long> {

    Categorias findTopByOrderByPk_idDesc();
}
