package com.example.demo.Curtidas.CurtidasController;

import com.example.demo.Posts.PostModel.Post;
import com.example.demo.Posts.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/culturallis")
public class CurtidasController {

    private final PostsRepository postRepository;

    @Autowired
    public CurtidasController(PostsRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/listarCurtidas")
    public List<Post> getContents() {
        return postRepository.findAll();
    }

    @PostMapping("/curtir")
    public ResponseEntity<String> createPost(@RequestBody Post post) {
        post.setData_criacao(new Date());
        try {
            postRepository.save(post);
            return ResponseEntity.ok("Post Inserido");
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/excluirCurtida")
    public ResponseEntity<String> deletePost(@RequestParam Long id) {
        Optional<Post> postToDel = postRepository.findById(id);
        if (postToDel.isPresent()) {
            postRepository.deleteById(id);
            return ResponseEntity.ok("Post excluído!");
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/alterarCurtida/{id}")
    public ResponseEntity<String> alterarPost(@PathVariable Long id, @RequestBody Post postAtt) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            Post pst = post.get();
            pst.setDescricao(postAtt.getDescricao());
            pst.setFk_cul_usuarios_id(postAtt.getFk_cul_usuarios_id());
            pst.setData_criacao(postAtt.getData_criacao());
            pst.setData_mudanca(new Date());
            pst.setData_desativacao(postAtt.getData_desativacao());
            postRepository.save(pst);
            return ResponseEntity.ok("Post atualizado!");
        }
        return ResponseEntity.notFound().build();

    }
}
