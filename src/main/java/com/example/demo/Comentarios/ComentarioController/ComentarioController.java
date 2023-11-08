package com.example.demo.Comentarios.ComentarioController;

import com.example.demo.Comentarios.ComentarioModel.Comentario;
import com.example.demo.Comentarios.ComentarioRepository;
import com.example.demo.Curtidas.CurtidaModel.Curtida;
import com.example.demo.Posts.PostModel.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/culturallis")
public class ComentarioController {

    private final ComentarioRepository comentarioRepository;

    @Autowired
    public ComentarioController(ComentarioRepository comentarioRepository) {
        this.comentarioRepository =  comentarioRepository;
    }

    @GetMapping("/listarComentarios")
    public List<Comentario> getComments() {
        return comentarioRepository.findAll();
    }

    @PostMapping("/comentar")
    public ResponseEntity<String> insertComment(@RequestBody Comentario comentario) {
        comentario.setData_criacao(new Date());
        try {
            comentarioRepository.save(comentario);
            return ResponseEntity.ok("Comentario Inserido");
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/excluirComentario")
    public ResponseEntity<String> deleteComment(@RequestParam Long id) {
        Optional<Comentario> commentToDel = comentarioRepository.findById(id);
        if (commentToDel.isPresent()) {
            comentarioRepository.deleteById(id);
            return ResponseEntity.ok("Comentário excluído!");
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/alterarComentario/{id}")
    public ResponseEntity<String> updateComment(@PathVariable Long id, @RequestBody Comentario commentAtt) {
        Optional<Comentario> comment = comentarioRepository.findById(id);
        if (comment.isPresent()) {
            Comentario cmmt = comment.get();
            cmmt.setDescricao(commentAtt.getDescricao());
            cmmt.setFk_cul_usuarios_id(commentAtt.getFk_cul_usuarios_id());
            cmmt.setData_criacao(commentAtt.getData_criacao());
            cmmt.setData_mudanca(new Date());
            cmmt.setData_desativacao(commentAtt.getData_desativacao());
            comentarioRepository.save(cmmt);
            return ResponseEntity.ok("Comentario atualizado!");
        }
        return ResponseEntity.notFound().build();

    }
}
