package com.example.demo.Curtidas.CurtidasController;

import com.example.demo.Curtidas.CurtidaModel.Curtida;
import com.example.demo.Curtidas.CurtidasRepository;
import com.example.demo.Usuarios.UsuariosModel.Usuarios;
import com.example.demo.Usuarios.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/culturallis")
public class CurtidasController {

    private final CurtidasRepository curtidasRepository;
    private final UsuariosRepository usuariosRepository;

    @Autowired
    public CurtidasController(CurtidasRepository curtidasRepository, UsuariosRepository usuariosRepository) {
        this.curtidasRepository = curtidasRepository;
        this.usuariosRepository = usuariosRepository;
    }

    @GetMapping("/listarCurtidas")
    public List<Curtida> listarCurtidas(){
        return curtidasRepository.findAll();
    }

    @PostMapping("/curtirPost/{postId}/{email}")
    public Curtida togglePostLike(@PathVariable long postId, @PathVariable String email){
        Usuarios usuarios = usuariosRepository.findByEmail(email);
        Optional<Curtida> postsHome = Optional.ofNullable(curtidasRepository.findFirstByFkCulPostsIdAndFkCulUsuariosIdOrderByDataCriacaoDesc(postId, usuarios.getpkId()));
        Curtida curtida = new Curtida();

        postsHome.ifPresent(cr -> {
            if(cr.getData_desativacao() == null){
                curtida.setPk_id(cr.getPk_id());
                curtida.setFk_cul_posts_id(cr.getFk_cul_posts_id());
                curtida.setFk_cul_usuarios_id(cr.getFk_cul_usuarios_id());
                curtida.setData_criacao(cr.getData_criacao());
                curtida.setData_mudanca(new Date());
                curtida.setData_desativacao(new Date());
            }else{
                curtida.setFk_cul_posts_id(postId);
                curtida.setFk_cul_usuarios_id(usuarios.getpkId());
                curtida.setData_criacao(new Date());
            }
        });

        if(!postsHome.isPresent()){
            curtida.setFk_cul_posts_id(postId);
            curtida.setFk_cul_usuarios_id(usuarios.getpkId());
            curtida.setData_criacao(new Date());
        }

        curtidasRepository.save(curtida);


        return curtida;
    }

}
