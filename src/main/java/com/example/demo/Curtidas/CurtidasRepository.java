package com.example.demo.Curtidas;

import com.example.demo.Curtidas.CurtidaModel.Curtida;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurtidasRepository extends JpaRepository<Curtida, Long> {
}
