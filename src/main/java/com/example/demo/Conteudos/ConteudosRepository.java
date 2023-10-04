package com.example.demo.Conteudos;

import com.example.demo.Conteudos.ConteudosModel.Conteudos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConteudosRepository extends JpaRepository<Conteudos, Long> {
}
