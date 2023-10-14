package com.example.demo.Usuarios.UsuariosController;

import com.example.demo.Usuarios.UsuariosModel.Usuarios;
import com.example.demo.Usuarios.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        return user.getSenha().equals(request.getSenha());
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

    @PutMapping("/alterarUsuarios/{email}")
    public ResponseEntity<String> alterarUsuario(@PathVariable String email, @RequestBody Usuarios usuariosAtt) {
        Optional<Usuarios> usuario = Optional.ofNullable(usuariosRepository.findByEmail(email));

        if (usuario.isPresent()) {
            Usuarios user = usuario.get();
            user.setfk_cul_generos_id(usuariosAtt.getfk_cul_generos_id());
            user.setNomeUsuario(usuariosAtt.getNomeUsuario());
            user.setNomeCompleto(usuariosAtt.getNomeCompleto());
            user.setTelefone(usuariosAtt.getTelefone());
            user.setBio(usuariosAtt.getBio());
            user.setCpf(usuariosAtt.getCpf());

            if(usuariosAtt.getEmail() != null) {
                user.setEmail(usuariosAtt.getEmail());
            }

            user.setDataNasc(usuariosAtt.getDataNasc());
            user.setDataMudanca(new Date());
            user.setDataDesativacao(usuariosAtt.getDataDesativacao());
            user.setSenha(usuariosAtt.getSenha());
            usuariosRepository.save(user);
            return ResponseEntity.ok("Usuário atualizado!");
        }
        return ResponseEntity.notFound().build();

    }

}
