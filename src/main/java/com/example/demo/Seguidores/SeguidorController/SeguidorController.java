package com.example.demo.Seguidores.SeguidorController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Seguidores.SeguidorRepository;
import com.example.demo.Seguidores.SeguidorModel.Seguidor;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api/culturallis")
public class SeguidorController {

    private final SeguidorRepository seguidorRepository;

    @Autowired
    public SeguidorController(SeguidorRepository seguidorRepository) {
        this.seguidorRepository = seguidorRepository;
    }

    @GetMapping("/listarSeguidores/{id}")
    public ResponseEntity<String> findSeguidoresById(@RequestParam Long id) {
        Optional<Seguidor> seguidores = seguidorRepository.findById(id);

        if (seguidores.isPresent()) {
            seguidores = seguidores.filter(s -> s.getFk_cul_usuarios_seguidores_id() == id);
        }

        return ResponseEntity.ok(seguidores.toString());
    }

    @PostMapping("/inserirSeguidor")
    public ResponseEntity<String> inserirSeguidor(@RequestBody Seguidor seguidor) {
        seguidor.setData_criacao(new Date());
        try {
            seguidorRepository.save(seguidor);
            return ResponseEntity.ok("Seguidor Inserido");
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/excluirSeguidores")
    public ResponseEntity<String> deleteSeguidor(@RequestParam Long id) {
        Optional<Seguidor> seguidorToDelete = seguidorRepository.findById(id);
        if (seguidorToDelete.isPresent()) {
            seguidorRepository.deleteById(id);
            return ResponseEntity.ok("Seguidor excluído!");
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/alterarSeguidor/{id}")
    public ResponseEntity<String> updateSeguidor(@PathVariable Long id, @RequestBody Seguidor seguidorAtt) {
        Optional<Seguidor> seguidor = seguidorRepository.findById(id);
        if (seguidor.isPresent()) {
            Seguidor seg = seguidor.get();
            seg.setFk_cul_usuarios_seguidores_id(seguidorAtt.getFk_cul_usuarios_seguidores_id());
            seg.setFk_cul_usuarios_seguidos_id(seguidorAtt.getFk_cul_usuarios_seguidos_id());
            seg.setData_criacao(seguidorAtt.getData_criacao());
            seg.setData_mudanca(new Date());
            seg.setData_desativacao(seguidorAtt.getData_desativacao());
            seguidorRepository.save(seg);
            return ResponseEntity.ok("Seguidor atualizado!");
        }
        return ResponseEntity.notFound().build();

    }
}
