package com.example.demo.PostFavoritos.PostFavoritosController;

import com.example.demo.Curtidas.CurtidaModel.Curtida;
import com.example.demo.FavoritosCurso.FavoritosCursoModel.FavoritoCurso;
import com.example.demo.PostFavoritos.PostFavoritosRepository;
import com.example.demo.PostFavoritos.PostFavoritosModel.PostFavorito;
import com.example.demo.Posts.PostModel.Post;
import com.example.demo.Usuarios.UsuariosModel.Usuarios;
import com.example.demo.Usuarios.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/culturallis")
public class PostFavoritosController {

    private final PostFavoritosRepository postFavoritosRepository;

    private final UsuariosRepository usuariosRepository;

    @Autowired
    public PostFavoritosController(PostFavoritosRepository postFavoritosRepository, UsuariosRepository usuariosRepository) {
        this.postFavoritosRepository = postFavoritosRepository;
        this.usuariosRepository = usuariosRepository;
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

    @PostMapping("/favPost/{postId}/{email}")
    public PostFavorito togglePostFav(@PathVariable long postId, @PathVariable String email){
        Usuarios usuarios = usuariosRepository.findByEmail(email);
        Optional<PostFavorito> postsHome = Optional.ofNullable(postFavoritosRepository.findFirstByFkCulPostsIdAndFkCulUsuariosIdOrderByDataCriacaoDesc(postId, usuarios.getpkId()));
        PostFavorito postfav = new PostFavorito();

        postsHome.ifPresent(cr -> {
            if(cr.getData_desativacao() == null){
                postfav.setPk_id(cr.getPk_id());
                postfav.setPfk_cul_posts_id(cr.getPfk_cul_posts_id());
                postfav.setPfk_cul_usuarios_id(cr.getPfk_cul_usuarios_id());
                postfav.setData_criacao(cr.getData_criacao());
                postfav.setData_mudanca(new Date());
                postfav.setData_desativacao(new Date());
            }else{
                postfav.setPfk_cul_posts_id(postId);
                postfav.setPfk_cul_usuarios_id(usuarios.getpkId());
                postfav.setData_criacao(new Date());
            }
        });

        if(!postsHome.isPresent()){
            postfav.setPfk_cul_posts_id(postId);
            postfav.setPfk_cul_usuarios_id(usuarios.getpkId());
            postfav.setData_criacao(new Date());
        }

        postFavoritosRepository.save(postfav);


        return postfav;
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
