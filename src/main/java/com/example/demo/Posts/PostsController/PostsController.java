package com.example.demo.Posts.PostsController;

import com.example.demo.Curtidas.CurtidaModel.Curtida;
import com.example.demo.Curtidas.CurtidasRepository;
import com.example.demo.Pagination.Pagination;
import com.example.demo.Posts.PostModel.Post;
import com.example.demo.Posts.PostModel.ReturnOwnPostsHome;
import com.example.demo.Posts.PostModel.ReturnPostsHome;
import com.example.demo.Posts.PostsRepository;
import com.example.demo.Usuarios.UsuariosModel.Usuarios;
import com.example.demo.Usuarios.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/culturallis")
public class PostsController {

    private final PostsRepository postRepository;
    private final UsuariosRepository usuariosRepository;

    private final CurtidasRepository curtidasRepository;

    @Autowired
    public PostsController(PostsRepository postRepository, UsuariosRepository usuariosRepository,
            CurtidasRepository curtidasRepository) {
        this.postRepository = postRepository;
        this.usuariosRepository = usuariosRepository;
        this.curtidasRepository = curtidasRepository;
    }

    @GetMapping("/listarPosts/{email}")
    public List<ReturnPostsHome> getContents(@PathVariable String email) {

        List<Post> allPosts = postRepository.findAll();
        List<ReturnPostsHome> postsHome = new ArrayList<>();

        allPosts.sort((a, b) -> a.getData_criacao().after(b.getData_criacao()) ? -1 : 1);
        for (Post post : allPosts) {
            Optional<Usuarios> userOptional = usuariosRepository.findById(post.getFk_cul_usuarios_id());

            userOptional.ifPresent(usuario -> {
                Boolean curtiu;

                Curtida cr = curtidasRepository.findFirstByFkCulPostsIdAndFkCulUsuariosIdOrderByDataCriacaoDesc(
                        post.getPk_id(), usuariosRepository.findByEmail(usuario.getEmail()).getpkId());

                if (cr != null) {
                    if (cr.getData_desativacao() == null) {
                        curtiu = true;
                    } else {
                        curtiu = false;
                    }
                } else {
                    curtiu = false;
                }

                ReturnPostsHome returnPostsHome = new ReturnPostsHome(
                        post.getPk_id(),
                        post.getFk_cul_usuarios_id(),
                        post.getDescricao(),
                        post.getUrl_midia(),
                        post.getData_criacao(),
                        post.getData_mudanca(),
                        post.getData_desativacao(),
                        usuario.getUrlFoto(),
                        usuario.getNomeUsuario(),
                        Boolean.parseBoolean(String.valueOf(curtiu)));

                if (post.getData_desativacao() == null) {
                    postsHome.add(returnPostsHome);
                }
            });
        }

        Pagination pagination = new Pagination(postsHome);

        return pagination.getCurrentPageData();
    }

    @GetMapping("/meusPosts/{email}")
    public List<ReturnOwnPostsHome> findUsersByEmail(@PathVariable String email) {

        Usuarios user = usuariosRepository.findByEmail(String.valueOf(email));

        List<Post> posts = postRepository.findByFkCulUsuariosId(user.getpkId());

        List<ReturnOwnPostsHome> returnOwnPostsHomes = new ArrayList<>();

        for (Post post : posts) {

            Boolean curtiu;

            Curtida cr = curtidasRepository.findFirstByFkCulPostsIdAndFkCulUsuariosIdOrderByDataCriacaoDesc(
                    post.getPk_id(), usuariosRepository.findByEmail(user.getEmail()).getpkId());

            if (cr != null) {
                if (cr.getData_desativacao() == null) {
                    curtiu = true;
                } else {
                    curtiu = false;
                }
            } else {
                curtiu = false;
            }

            ReturnOwnPostsHome returnPostsHome = new ReturnOwnPostsHome(
                    post.getPk_id(),
                    post.getFk_cul_usuarios_id(),
                    post.getDescricao(),
                    post.getUrl_midia(),
                    post.getData_criacao(),
                    post.getData_mudanca(),
                    post.getData_desativacao(),
                    user.getUrlFoto(),
                    user.getNomeUsuario(),
                    curtiu,
                    curtiu);
            if (post.getData_desativacao() == null) {
                returnOwnPostsHomes.add(returnPostsHome);
            }
        }

        returnOwnPostsHomes.sort((a, b) -> a.getData_criacao().after(b.getData_criacao()) ? -1 : 1);

        return returnOwnPostsHomes;
    }

    @PostMapping("/criarPost/{email}")
    public ResponseEntity<String> createPost(@PathVariable String email, @RequestBody Post post) {
        post.setData_criacao(new Date());
        Usuarios usuarios = usuariosRepository.findByEmail(email);
        post.setFk_cul_usuarios_id(usuarios.getpkId());
        try {
            postRepository.save(post);
            return ResponseEntity.ok("Post Inserido");
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/excluirPost")
    public ResponseEntity<String> deletePost(@RequestParam Long id) {
        Optional<Post> postToDel = postRepository.findById(id);
        if (postToDel.isPresent()) {
            postRepository.deleteById(id);
            return ResponseEntity.ok("Post excluído!");
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/alterarPost/{id}")
    public ResponseEntity<String> alterarPost(@PathVariable Long id, @RequestBody Post postAtt) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            Post pst = post.get();
            pst.setDescricao(postAtt.getDescricao());
            pst.setFk_cul_usuarios_id(postAtt.getFk_cul_usuarios_id());
            pst.setData_criacao(postAtt.getData_criacao());
            pst.setData_mudanca(new Date());
            // pst.setData_desativacao(postAtt.getData_desativacao());
            postRepository.save(pst);
            return ResponseEntity.ok("Post atualizado!");
        }
        return ResponseEntity.notFound().build();

    }
}
