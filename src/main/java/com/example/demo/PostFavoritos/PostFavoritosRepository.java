package com.example.demo.PostFavoritos;

import com.example.demo.PostFavoritos.PostFavoritosModel.PostFavorito;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostFavoritosRepository extends JpaRepository<PostFavorito, Long> {
    PostFavorito findFirstByFkCulPostsIdAndFkCulUsuariosIdOrderByDataCriacaoDesc(long postId, Long aLong);
}
