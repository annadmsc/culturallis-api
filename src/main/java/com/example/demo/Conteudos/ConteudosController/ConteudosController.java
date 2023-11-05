package com.example.demo.Conteudos.ConteudosController;

import com.example.demo.Conteudos.ConteudosModel.Conteudos;
import com.example.demo.Conteudos.ConteudosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/culturallis")
public class ConteudosController {

    private final ConteudosRepository conteudosRepository;

    @Autowired
    public ConteudosController(ConteudosRepository conteudosRepository) {
        this.conteudosRepository = conteudosRepository;
    }

    @GetMapping("/listarConteudos")
    public List<Conteudos> getContents() {
        return conteudosRepository.findAll();
    }

    @PostMapping("/inserirConteudos")
    public ResponseEntity<String> insertContents(@RequestBody Conteudos conteudos) {
        conteudos.setData_criacao(new Date());
        try {
            conteudosRepository.save(conteudos);
            return ResponseEntity.ok("Conteúdo Inserido");
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/excluirConteudos")
    public ResponseEntity<String> deleteContents(@RequestParam Long id) {
        Optional<Conteudos> contentToDelete = conteudosRepository.findById(id);
        if (contentToDelete.isPresent()) {
            conteudosRepository.deleteById(id);
            return ResponseEntity.ok("Conteúdo excluído!");
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/alterarConteudos/{id}")
    public ResponseEntity<String> alterarProduto(@PathVariable Long id, @RequestBody Conteudos conteudosAtt) {
        Optional<Conteudos> content = conteudosRepository.findById(id);
        if (content.isPresent()) {
            Conteudos cont = content.get();
            cont.setFk_tb_curso_id(conteudosAtt.getFk_tb_curso_id());
            cont.setNome(conteudosAtt.getNome());
            cont.setUrl_material(conteudosAtt.getUrl_material());
            cont.setData_criacao(conteudosAtt.getData_criacao());
            cont.setData_mudanca(new Date());
            cont.setData_desativacao(conteudosAtt.getData_desativacao());
            conteudosRepository.save(cont);
            return ResponseEntity.ok("Conteúdo atualizado!");
        }
        return ResponseEntity.notFound().build();

    }

}
