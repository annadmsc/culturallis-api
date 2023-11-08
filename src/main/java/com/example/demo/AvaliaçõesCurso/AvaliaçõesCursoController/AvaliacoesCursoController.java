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
    public List<AvaliacoesCurso> getAssessments() {
        return avaliacoesCursoRepository.findAll();
    }

    @PostMapping("/inserirAvaliacoes")
    public ResponseEntity<String> insertAssessments(@RequestBody AvaliacoesCurso assessment) {
        assessment.setData_criacao(new Date());
        try {
            avaliacoesCursoRepository.save(assessment);
            return ResponseEntity.ok("Avaliação Concluida");
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/excluirAvaliacao")
    public ResponseEntity<String> deleteAssessment(@RequestParam Long id) {
        Optional<AvaliacoesCurso> assessToDelete = avaliacoesCursoRepository.findById(id);
        if (assessToDelete.isPresent()) {
            avaliacoesCursoRepository.deleteById(id);
            return ResponseEntity.ok("Avaliação excluída!");
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/alterarAvaliacaoCurso/{id}")
    public ResponseEntity<String> updateAssessment(@PathVariable Long id, @RequestBody AvaliacoesCurso avvAtt) {
        Optional<AvaliacoesCurso> assess = avaliacoesCursoRepository.findById(id);
        if (assess.isPresent()) {
            AvaliacoesCurso assessment = assess.get();
            assessment.setFk_cul_cursos_id(avvAtt.getFk_cul_cursos_id());
            assessment.setFk_cul_usuarios_id(avvAtt.getFk_cul_usuarios_id());
            assessment.setData_criacao(avvAtt.getData_criacao());
            assessment.setData_mudanca(new Date());
            assessment.setData_desativacao(avvAtt.getData_desativacao());
            avaliacoesCursoRepository.save(assessment);
            return ResponseEntity.ok("Conteúdo atualizado!");
        }
        return ResponseEntity.notFound().build();

    }
}
