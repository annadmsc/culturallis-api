package com.example.demo.PostFavoritos.PostFavoritosController;

import com.example.demo.Curtidas.CurtidaModel.Curtida;
import com.example.demo.Curtidas.CurtidasRepository;
import com.example.demo.PostFavoritos.PostFavoritosRepository;
import com.example.demo.PostFavoritos.PostFavoritosModel.PostFavorito;
import com.example.demo.Posts.PostModel.Post;
import com.example.demo.Posts.PostModel.ReturnPostsHome;
import com.example.demo.Posts.PostsRepository;
import com.example.demo.Usuarios.UsuariosModel.Usuarios;
import com.example.demo.Usuarios.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/culturallis")
public class PostFavoritosController {

    private final PostFavoritosRepository postFavoritosRepository;

    private final UsuariosRepository usuariosRepository;

    private final PostsRepository postsRepository;

    private final CurtidasRepository curtidasRepository;

    @Autowired
    public PostFavoritosController(PostFavoritosRepository postFavoritosRepository, UsuariosRepository usuariosRepository, PostsRepository postsRepository, CurtidasRepository curtidasRepository) {
        this.postFavoritosRepository = postFavoritosRepository;
        this.usuariosRepository = usuariosRepository;
        this.postsRepository = postsRepository;
        this.curtidasRepository = curtidasRepository;
    }

    @GetMapping("salvos")
    public Optional<Post> getAll(){
        return postsRepository.findById(63L);
    }

    @GetMapping("/salvos/{email}")
    public List<ReturnPostsHome> getSaved(@PathVariable String email){
        Usuarios usuarios = usuariosRepository.findByEmail(email);

        List<PostFavorito> postFavoritos = postFavoritosRepository.findAllByPfkCulUsuariosId(usuarios.getpkId());

        List<ReturnPostsHome> posts = new ArrayList<>();

        for(PostFavorito post : postFavoritos){
            if(post.getData_desativacao() == null){
            Optional<Post> ps = postsRepository.findById(post.getPfk_cul_posts_id());

            ps.ifPresent(po -> {
                Optional<Usuarios> ownerPost = usuariosRepository.findById(po.getFk_cul_usuarios_id());

                Boolean curtiu;

                Boolean salvou;

                PostFavorito postFavorito = postFavoritosRepository.findFirstByPfkCulPostsIdAndPfkCulUsuariosIdOrderByDataCriacaoDesc(po.getPk_id(), usuarios.getpkId());

                Curtida curtida = curtidasRepository.findFirstByFkCulPostsIdAndFkCulUsuariosIdOrderByDataCriacaoDesc(po.getPk_id(), usuarios.getpkId());

                if(postFavorito != null){
                    if(postFavorito.getData_desativacao() == null){
                        salvou = true;
                    }else{
                        salvou = false;
                    }
                }else{
                    salvou = false;
                }

                if(curtida == null){
                    curtiu = false;
                }else{
                    if(curtida.getData_desativacao() == null){
                        curtiu = true;
                    }else{
                        curtiu = false;
                    }
                }

                ownerPost.ifPresent(usr -> {
                    ReturnPostsHome returnPostsHome = new ReturnPostsHome(
                            po.getPk_id(),
                            po.getFk_cul_usuarios_id(),
                            po.getDescricao(),
                            po.getUrl_midia(),
                            po.getData_criacao(),
                            po.getData_mudanca(),
                            po.getData_desativacao(),
                            usr.getUrlFoto(),
                            usr.getNomeUsuario(),
                            curtiu,
                            salvou
                            );

                    if(po.getData_desativacao() == null && salvou == true){
                        posts.add(returnPostsHome);
                    }
                });
            });
        }
        }
        posts.sort((a, b) -> a.getData_criacao().after(b.getData_criacao()) ? -1 :  1);
        return posts;
    }

    @PostMapping("/salvarPost/{postId}/{email}")
    public PostFavorito togglePostSave(@PathVariable long postId, @PathVariable String email){
        Usuarios usuarios = usuariosRepository.findByEmail(email);
        Optional<PostFavorito> postsHome = Optional.ofNullable(postFavoritosRepository.findFirstByPfkCulPostsIdAndPfkCulUsuariosIdOrderByDataCriacaoDesc(postId, usuarios.getpkId()));
        PostFavorito postFavorito = new PostFavorito();

        postsHome.ifPresent(ph -> {
            if(ph.getData_desativacao() == null){
                postFavorito.setPk_id(ph.getPk_id());
                postFavorito.setPfk_cul_posts_id(ph.getPfk_cul_posts_id());
                postFavorito.setPfk_cul_usuarios_id(ph.getPfk_cul_usuarios_id());
                postFavorito.setData_criacao(ph.getData_criacao());
                postFavorito.setData_mudanca(new Date());
                postFavorito.setData_desativacao(new Date());
            }else{
                postFavorito.setPfk_cul_posts_id(postId);
                postFavorito.setPfk_cul_usuarios_id(usuarios.getpkId());
                postFavorito.setData_criacao(new Date());
            }
        });

        if(!postsHome.isPresent()){
            postFavorito.setPfk_cul_posts_id(postId);
            postFavorito.setPfk_cul_usuarios_id(usuarios.getpkId());
            postFavorito.setData_criacao(new Date());
        }

        postFavoritosRepository.save(postFavorito);


        return postFavorito;
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
