package com.example.demo.Cursos.CursosController;

import com.example.demo.Cursos.CursoModel.Curso;
import com.example.demo.Cursos.CursoModel.ReturnCoursesHome;
import com.example.demo.Cursos.CursoRepository;
import com.example.demo.CursosAdquiridos.CursosAdquiridosRepository;
import com.example.demo.CursosSalvos.CursosSalvosModel.CursosSalvos;
import com.example.demo.CursosSalvos.CursosSalvosRepository;
import com.example.demo.Pagination.PaginationCourses;
import com.example.demo.Usuarios.UsuariosModel.Usuarios;
import com.example.demo.Usuarios.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/culturallis")
public class CursoController {

    private final CursoRepository cursoRepository;
    private final UsuariosRepository usuariosRepository;
    private final CursosSalvosRepository cursosSalvosRepository;
    private final CursosAdquiridosRepository cursosAdquiridosRepository;

    @Autowired
    public CursoController(CursoRepository cursoRepository, UsuariosRepository usuariosRepository, CursosSalvosRepository cursosSalvosRepository, CursosAdquiridosRepository cursosAdquiridosRepository) {
        this.cursoRepository = cursoRepository;
        this.usuariosRepository = usuariosRepository;
        this.cursosSalvosRepository = cursosSalvosRepository;
        this.cursosAdquiridosRepository = cursosAdquiridosRepository;
    }

        @GetMapping("/listarCursos/{email}")
    public List<ReturnCoursesHome> getCursos(@PathVariable String email) {
            List<Curso> allCourses = cursoRepository.findAll();
            List<ReturnCoursesHome> coursesHome = new ArrayList<>();

            allCourses.sort((a, b) -> a.getData_criacao().after(b.getData_criacao()) ? -1 : 1);
            for (Curso curso : allCourses) {
                Optional<Usuarios> userOptional = usuariosRepository.findById(curso.getfkCulUsuariosId());

                userOptional.ifPresent(usuario -> {
                    Boolean salvou;

                    CursosSalvos cr = cursosSalvosRepository.findFirstByFkCulCursosIdAndFkCulUsuariosIdOrderByDataCriacaoDesc(
                            curso.getPk_id(), usuariosRepository.findByEmail(email).getpkId());


                    if (cr != null) {
                        if (cr.getData_desativacao() == null) {
                            salvou = true;
                        } else {
                            salvou = false;
                        }
                    } else {
                        salvou = false;
                    }

                    ReturnCoursesHome returnCoursesHome = new ReturnCoursesHome(
                            curso.getPk_id(),
                            curso.getfkCulUsuariosId(),
                            curso.getNome(),
                            curso.getUrl_midia(),
                            curso.getData_criacao(),
                            curso.getData_mudanca(),
                            curso.getData_desativacao(),
                            usuario.getUrlFoto(),
                            usuario.getNomeUsuario(),
                            Boolean.parseBoolean(String.valueOf(salvou)),
                            cursosAdquiridosRepository.findByFkCulCursosId(curso.getPk_id()).size()
                            );

                    if (curso.getData_desativacao() == null) {
                        coursesHome.add(returnCoursesHome);
                    }
                });
            }

            PaginationCourses pagination = new PaginationCourses(coursesHome);

            return pagination.getCurrentPageData();
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
