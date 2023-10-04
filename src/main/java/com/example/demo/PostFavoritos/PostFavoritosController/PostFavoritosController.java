package com.example.demo.PostFavoritos.PostFavoritosController;

import com.example.demo.PostFavoritos.PostFavoritosRepository;
import com.example.demo.PostFavoritos.PostFavoritosModel.PostFavorito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api/culturallis")
public class PostFavoritosController {

    private final PostFavoritosRepository postFavoritosRepository;

    @Autowired
    public PostFavoritosController(PostFavoritosRepository postFavoritosRepository) {
        this.postFavoritosRepository = postFavoritosRepository;
    }

    @PostMapping("/favoritarPost")
    public ResponseEntity<String> createFavoritePost(@RequestBody PostFavorito postFavorito) {
        postFavorito.setData_criacao(new Date());
        try {
            postFavoritosRepository.save(postFavorito);
            return ResponseEntity.ok("Post favoritado");
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/excluirPostFavorito")
    public ResponseEntity<String> deleteFavoritePost(@RequestParam Long id) {
        Optional<PostFavorito> postToDel = postFavoritosRepository.findById(id);
        if (postToDel.isPresent()) {
            postFavoritosRepository.deleteById(id);
            return ResponseEntity.ok("Post Favorito excluído!");
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/alterarPostFavorito/{id}")
    public ResponseEntity<String> updateFavoritePost(@PathVariable Long id, @RequestBody PostFavorito postFavAtt) {
        Optional<PostFavorito> postFav = postFavoritosRepository.findById(id);
        if (postFav.isPresent()) {
            PostFavorito fav = postFav.get();
            fav.setPfk_cul_posts_id(postFavAtt.getPfk_cul_posts_id());
            fav.setPfk_cul_usuarios_id(postFavAtt.getPfk_cul_usuarios_id());
            fav.setData_criacao(postFavAtt.getData_criacao());
            fav.setData_mudanca(new Date());
            fav.setData_desativacao(postFavAtt.getData_desativacao());
            postFavoritosRepository.save(fav);
            return ResponseEntity.ok("Post favorito atualizado!");
        }
        return ResponseEntity.notFound().build();

    }
}
