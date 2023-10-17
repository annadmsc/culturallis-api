package com.example.demo.Usuarios.UsuariosController;

import com.example.demo.Usuarios.UsuariosModel.Usuarios;
import com.example.demo.Usuarios.UsuariosRepository;
import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/culturallis")
public class UsuariosController {

    private final UsuariosRepository usuariosRepository;

    @Autowired
    public UsuariosController(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    @GetMapping("/listarUsuarios")
    public List<Usuarios> getUsuarios() {
        return usuariosRepository.findAll();
    }

    @PostMapping("/login")
    public boolean login(@RequestBody Usuarios request) throws Exception {

        Usuarios user = usuariosRepository.findByEmail(request.getEmail());

        if (user == null) {
            throw new Exception("Email não cadastrado");
        }

        Boolean pass = user.getSenha().equals(request.getSenha());

        if(pass.equals(true)){

            throw  new ResponseStatusException( HttpStatus.ACCEPTED,"Logado!");
        }else{
            throw  new ResponseStatusException( HttpStatus.BAD_REQUEST,"Não logado!");
        }

    }

    @GetMapping("/email/{email}")
    public Usuarios findUserByEmail(@PathVariable String email) {
        Usuarios usuario = usuariosRepository.findByEmail(email);
        return usuario;
    }

    @PostMapping("/inserirUsuario")
    public ResponseEntity<String> insertUsuarios(@RequestBody Usuarios usuarios) {
        usuarios.setDataCriacao(new Date());
        try {
            System.out.println(usuarios.getpkId());
            Usuarios savedUsuario = usuariosRepository.save(usuarios);
            return ResponseEntity.ok("Usuário Inserido, ID: " + savedUsuario.getpkId());
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body("Erro: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());
        }
    }

    @DeleteMapping("/excluirUsuarios")
    public ResponseEntity<String> deleteUsuarios(@RequestParam Long id) {
        Optional<Usuarios> contentToDelete = usuariosRepository.findById(id);
        if (contentToDelete.isPresent()) {
            usuariosRepository.deleteById(id);
            return ResponseEntity.ok("Usuário excluído!");
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/alterarUsuarios/{email}")
    public ResponseEntity<String> alterarUsuario(@PathVariable String email, @RequestBody Usuarios usuariosAtt) {
        Optional<Usuarios> usuario = Optional.ofNullable(usuariosRepository.findByEmail(email));

        if (usuario.isPresent()) {
            Usuarios user = usuario.get();

            if (usuariosAtt.getfk_cul_generos_id() != -1) {
                user.setfk_cul_generos_id(usuariosAtt.getfk_cul_generos_id());
            }

            if (usuariosAtt.getNomeUsuario() != null) {
                user.setNomeUsuario(usuariosAtt.getNomeUsuario());
            }

            if (usuariosAtt.getNomeCompleto() != null) {
                user.setNomeCompleto(usuariosAtt.getNomeCompleto());
            }


            if (usuariosAtt.getCpf() != null) {
                user.setCpf(usuariosAtt.getCpf());
            }

            if (usuariosAtt.getDataNasc() != null) {
                user.setDataNasc(usuariosAtt.getDataNasc());
            }

            if (usuariosAtt.getDataDesativacao() != null) {
                user.setDataDesativacao(usuariosAtt.getDataDesativacao());
            }

            if (usuariosAtt.getSenha() != null) {
                user.setSenha(usuariosAtt.getSenha());
            }

            user.setDataMudanca(new Date());
            usuariosRepository.save(user);

            return ResponseEntity.ok("Usuário atualizado!");
        }

        return ResponseEntity.notFound().build();
    }


}
