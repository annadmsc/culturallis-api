package com.example.demo.Cursos.CursosController;

import com.example.demo.Cursos.CursoModel.Curso;
import com.example.demo.Cursos.CursoRepository;
import com.example.demo.Usuarios.UsuariosModel.Usuarios;
import com.example.demo.Usuarios.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/culturallis")
public class CursoController {

    private final CursoRepository cursoRepository;
    private final UsuariosRepository usuariosRepository;

    @Autowired
    public CursoController(CursoRepository cursoRepository, UsuariosRepository usuariosRepository) {
        this.cursoRepository = cursoRepository;
        this.usuariosRepository = usuariosRepository;
    }

        @GetMapping("/listarCursos")
    public List<Curso> getCursos() {
        return cursoRepository.findAll();
    }

        @GetMapping("/meusCursos/{email}")
    public List<Curso> findCoursesByUser(@PathVariable String email) {

            Usuarios user = usuariosRepository.findByEmail(String.valueOf(email));

                return cursoRepository.findAllByFkCulUsuariosId(user.getpkId());
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
            crs.setfkCulUsuariosId(cursoAtt.getfkCulUsuariosId());
            crs.setData_criacao(cursoAtt.getData_criacao());
            crs.setData_mudanca(new Date());
            crs.setData_desativacao(cursoAtt.getData_desativacao());
            cursoRepository.save(crs);
            return ResponseEntity.ok("Curso atualizado!");
        }
        return ResponseEntity.notFound().build();

    }
}
