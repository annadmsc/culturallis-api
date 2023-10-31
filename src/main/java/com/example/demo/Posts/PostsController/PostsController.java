package com.example.demo.Posts.PostsController;

import com.example.demo.Posts.PostModel.Post;
import com.example.demo.Posts.PostsRepository;
import com.example.demo.Usuarios.UsuariosModel.Usuarios;
import com.example.demo.Usuarios.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Pagination.Pagination;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/culturallis")
public class PostsController {

    private final PostsRepository postRepository;
    private final UsuariosRepository usuariosRepository;

    @Autowired
    public PostsController(PostsRepository postRepository, UsuariosRepository usuariosRepository) {
        this.postRepository = postRepository;
        this.usuariosRepository = usuariosRepository;
    }

    @GetMapping("/listarPosts")
    public List<Post> getContents() {

        List<Post> inputData = postRepository.findAll();
        Pagination pagination = new Pagination(inputData);

        List<Post> currentPageData = pagination.getCurrentPageData();
        return currentPageData;
    }

    @GetMapping("/meusPosts/{email}")
    public List<Post> findUsersByEmail(@PathVariable String email) {

        Usuarios user = usuariosRepository.findByEmail(String.valueOf(email));

        return postRepository.findByFkCulUsuariosId(user.getpkId());
    }


    @PostMapping("/criarPost")
    public ResponseEntity<String> createPost(@RequestBody Post post) {
        post.setData_criacao(new Date());
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
