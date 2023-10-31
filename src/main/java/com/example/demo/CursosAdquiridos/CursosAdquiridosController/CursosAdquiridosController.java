package com.example.demo.CursosAdquiridos.CursosAdquiridosController;

import com.example.demo.CursosAdquiridos.CursosAdquiridosModel.CursosAdquiridosModel;
import com.example.demo.CursosAdquiridos.CursosAdquiridosRepository;
import com.example.demo.Usuarios.UsuariosRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/culturallis")
public class CursosAdquiridosController {

    private final CursosAdquiridosRepository cursosAdquiridosRepository;

    private final UsuariosRepository usuariosRepository;


    public CursosAdquiridosController(CursosAdquiridosRepository cursosAdquiridosRepository, UsuariosRepository usuariosRepository) {
        this.cursosAdquiridosRepository = cursosAdquiridosRepository;
        this.usuariosRepository = usuariosRepository;
    }

    @PostMapping("/adquirirCurso/{courseId}/{email}")
    public CursosAdquiridosModel adquireCourse(@PathVariable int courseId, @PathVariable String email){

        CursosAdquiridosModel cursosAdquiridosModel = new CursosAdquiridosModel(Math.toIntExact(usuariosRepository.findByEmail(email).getpkId()), courseId, new Date(), null, null);

        cursosAdquiridosRepository.save(cursosAdquiridosModel);

        return cursosAdquiridosModel;

    }
}
