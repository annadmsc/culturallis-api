package com.example.demo.AvaliaçõesCurso.AvaliaçõesCursoController;

import com.example.demo.AvaliaçõesCurso.AvaliacoesCursoRepository;
import com.example.demo.AvaliaçõesCurso.AvaliaçõesCursoModel.AvaliacoesCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/culturallis")
public class AvaliacoesCursoController {

    private final AvaliacoesCursoRepository avaliacoesCursoRepository;

    @Autowired
    public AvaliacoesCursoController(AvaliacoesCursoRepository avaliacoesCursoRepository) {
        this.avaliacoesCursoRepository = avaliacoesCursoRepository;
    }

    @GetMapping("/listarAvaliacoes")
    public List<AvaliacoesCurso> getContents() {
        return avaliacoesCursoRepository.findAll();
    }

    @PostMapping("/inserirAvaliacoes")
    public ResponseEntity<String> insertContents(@RequestBody AvaliacoesCurso avaliacao) {
        avaliacao.setData_criacao(new Date());
        try {
            avaliacoesCursoRepository.save(avaliacao);
            return ResponseEntity.ok("Avaliação Concluida");
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/excluirAvaliacao")
    public ResponseEntity<String> deleteRating(@RequestParam Long id) {
        Optional<AvaliacoesCurso> ratingToDelete = avaliacoesCursoRepository.findById(id);
        if (ratingToDelete.isPresent()) {
            avaliacoesCursoRepository.deleteById(id);
            return ResponseEntity.ok("Avaliação excluída!");
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/alterarAvaliacaoCurso/{id}")
    public ResponseEntity<String> alterarAvaliacao(@PathVariable Long id, @RequestBody AvaliacoesCurso avvAtt) {
        Optional<AvaliacoesCurso> rating = avaliacoesCursoRepository.findById(id);
        if (rating.isPresent()) {
            AvaliacoesCurso avaliacao = rating.get();
            avaliacao.setFk_cul_cursos_id(avvAtt.getFk_cul_cursos_id());
            avaliacao.setFk_cul_usuarios_id(avvAtt.getFk_cul_usuarios_id());
            avaliacao.setData_criacao(avvAtt.getData_criacao());
            avaliacao.setData_mudanca(new Date());
            avaliacao.setData_desativacao(avvAtt.getData_desativacao());
            avaliacoesCursoRepository.save(avaliacao);
            return ResponseEntity.ok("Conteúdo atualizado!");
        }
        return ResponseEntity.notFound().build();

    }
}
