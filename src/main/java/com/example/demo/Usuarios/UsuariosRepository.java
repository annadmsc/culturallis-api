package com.example.demo.Usuarios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Usuarios.UsuariosModel.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

    Usuarios findByEmail(String email);
}
