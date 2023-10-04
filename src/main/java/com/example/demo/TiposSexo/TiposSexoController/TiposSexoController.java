package com.example.demo.TiposSexo.TiposSexoController;

import com.example.demo.TiposSexo.TiposSexoModel.TiposSexo;
import com.example.demo.TiposSexo.TiposSexoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/culturallis")
public class TiposSexoController {

    private final TiposSexoRepository tiposSexoRepository;

    @Autowired
    public TiposSexoController(TiposSexoRepository tiposSexoRepository) {
        this.tiposSexoRepository = tiposSexoRepository;
    }

    @GetMapping("/listarTiposSexo")
    public List<TiposSexo> getSexs() {
        return tiposSexoRepository.findAll();
    }

    @PostMapping("/inserirTiposSexo")
    public ResponseEntity<String> insertSexs(@RequestBody TiposSexo tiposSexo) {
        tiposSexo.setData_criacao(new Date());
        try {
            tiposSexoRepository.save(tiposSexo);
            return ResponseEntity.ok("Sexo Inserido");
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/excluirTiposSexo")
    public ResponseEntity<String> deleteSex(@RequestParam Long id) {
        Optional<TiposSexo> sexToDelete = tiposSexoRepository.findById(id);
        if (sexToDelete.isPresent()) {
            tiposSexoRepository.deleteById(id);
            return ResponseEntity.ok("Sexo excluído!");
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/alterarTiposSexo/{id}")
    public ResponseEntity<String> alterarSexo(@PathVariable Long id, @RequestBody TiposSexo tiposSexoAtt) {
        Optional<TiposSexo> sex = tiposSexoRepository.findById(id);
        if (sex.isPresent()) {
            TiposSexo sexo = sex.get();
            sexo.setNome(tiposSexoAtt.getNome());
            sexo.setData_criacao(tiposSexoAtt.getData_criacao());
            sexo.setData_mudanca(new Date());
            sexo.setData_desativacao(tiposSexoAtt.getData_desativacao());
            tiposSexoRepository.save(sexo);
            return ResponseEntity.ok("Tipo Sexo atualizado!");
        }
        return ResponseEntity.notFound().build();

    }
}
