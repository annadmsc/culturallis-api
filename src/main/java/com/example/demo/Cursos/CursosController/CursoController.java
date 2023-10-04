package com.example.demo.Cursos.CursosController;

import com.example.demo.Cursos.CursoModel.Curso;
import com.example.demo.Cursos.CursoRepository;
import com.example.demo.Usuarios.UsuariosModel.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Categorias.CategoriasRepository;
import com.example.demo.Seguidores.SeguidorModel.Seguidor;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/culturallis")
public class CursoController {

    private final CursoRepository cursoRepository;

    @Autowired
    public CursoController(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @GetMapping("/listarCursos")
    public List<Curso> getCursos() {
        return cursoRepository.findAll();
    }


    @PostMapping("/inserirCurso")
    public ResponseEntity<String> inserirCurso(@RequestBody Curso curso) {
        curso.setData_criacao(new Date());
        try {
            cursoRepository.save(curso);
            return ResponseEntity.ok("Curso Inserido");
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/excluirCurso")
    public ResponseEntity<String> deleteCurso(@RequestParam Long id) {
        Optional<Curso> cursoToDelete = cursoRepository.findById(id);
        if (cursoToDelete.isPresent()) {
            cursoRepository.deleteById(id);
            return ResponseEntity.ok("Curso excluído!");
        }
        return ResponseEntity.notFound().build();
    }


    @PutMapping("/alterarCurso/{id}")
    public ResponseEntity<String> alterarCurso(@PathVariable Long id, @RequestBody Curso cursoAtt) {
        Optional<Curso> curso = cursoRepository.findById(id);
        if (curso.isPresent()) {
            Curso crs = curso.get();
            crs.setDescricao(cursoAtt.getDescricao());
            crs.setNome(cursoAtt.getNome());
            crs.setFk_cul_categorias_id(cursoAtt.getFk_cul_categorias_id());
            crs.setFk_cul_usuarios_id(cursoAtt.getFk_cul_usuarios_id());
            crs.setData_criacao(cursoAtt.getData_criacao());
            crs.setData_mudanca(new Date());
            crs.setData_desativacao(cursoAtt.getData_desativacao());
            cursoRepository.save(crs);
            return ResponseEntity.ok("Curso atualizado!");
        }
        return ResponseEntity.notFound().build();

    }
}
