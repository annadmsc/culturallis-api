package com.example.demo.CursosSalvos.CursosSalvosController;

import com.example.demo.CursosSalvos.CursosSalvosModel.CursosSalvos;
import com.example.demo.CursosSalvos.CursosSalvosRepository;
import com.example.demo.Usuarios.UsuariosModel.Usuarios;
import com.example.demo.Usuarios.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/culturallis")
public class CursosSalvosController {
    private final CursosSalvosRepository cursosSalvosRepository;

    private final UsuariosRepository usuariosRepository;


    @Autowired
    public CursosSalvosController(CursosSalvosRepository cursosSalvosRepository, UsuariosRepository usuariosRepository) {
        this.cursosSalvosRepository = cursosSalvosRepository;
        this.usuariosRepository = usuariosRepository;
    }

    @GetMapping("/listarCursosSalvos")
    public List<CursosSalvos> listarCursosSalvoss(){
        return cursosSalvosRepository.findAll();
    }

    @PostMapping("/salvarCurso/{courseId}/{email}")
    public CursosSalvos toggleCourseSave(@PathVariable long courseId, @PathVariable String email){
        Usuarios usuarios = usuariosRepository.findByEmail(email);
        Optional<CursosSalvos> coursesHome = Optional.ofNullable(cursosSalvosRepository.findFirstByFkCulCursosIdAndFkCulUsuariosIdOrderByDataCriacaoDesc(courseId, usuarios.getpkId()));
        CursosSalvos curtida = new CursosSalvos();

        coursesHome.ifPresent(cr -> {
            if(cr.getData_desativacao() == null){
                curtida.setPk_id(cr.getPk_id());
                curtida.setFkCulCursosId(cr.getFkCulCursosId());
                curtida.setFk_cul_usuarios_id(cr.getFk_cul_usuarios_id());
                curtida.setData_criacao(cr.getData_criacao());
                curtida.setData_mudanca(new Date());
                curtida.setData_desativacao(new Date());
            }else{
                curtida.setFkCulCursosId(courseId);
                curtida.setFk_cul_usuarios_id(usuarios.getpkId());
                curtida.setData_criacao(new Date());
            }
        });

        if(!coursesHome.isPresent()){
            curtida.setFkCulCursosId(courseId);
            curtida.setFk_cul_usuarios_id(usuarios.getpkId());
            curtida.setData_criacao(new Date());
        }

        cursosSalvosRepository.save(curtida);


        return curtida;
    }
}
