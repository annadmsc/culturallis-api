package com.example.demo.PostFavoritos;

import com.example.demo.Cursos.CursoModel.Curso;
import com.example.demo.PostFavoritos.PostFavoritosModel.PostFavorito;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostFavoritosRepository extends JpaRepository<PostFavorito, Long> {

    List<PostFavorito> findAllByPfkCulUsuariosId(Long pfk_cul_usuarios_id);

    PostFavorito findFirstByPfkCulPostsIdOrderByDataCriacaoDesc(Long pfk_cul_posts_id);

    PostFavorito findFirstByPfkCulPostsIdAndPfkCulUsuariosIdOrderByDataCriacaoDesc(Long pfk_cul_posts_id, Long pfk_cul_usuarios_id);

}
