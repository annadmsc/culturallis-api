package com.example.demo.Curtidas;

import com.example.demo.Curtidas.CurtidaModel.Curtida;

import com.example.demo.Usuarios.UsuariosModel.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurtidasRepository extends JpaRepository<Curtida, Long> {


        Curtida findFirstByFkCulPostsIdAndFkCulUsuariosIdOrderByDataCriacaoDesc(Long idPosts, Long idUser);

}
