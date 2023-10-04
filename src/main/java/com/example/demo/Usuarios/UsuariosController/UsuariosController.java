package com.example.demo.Usuarios.UsuariosController;

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

    @PostMapping("/inserirUsuario")
    public ResponseEntity<String> insertUsarios(@RequestBody Usuarios usuarios) {
        usuarios.setDataCriacao(new Date());
        usuarios.setpkId(1);
        System.out.println(usuarios);
        try {
            usuariosRepository.save(usuarios);
            return ResponseEntity.ok("Usuário Inserido");
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
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

    @PutMapping("/alterarUsuarios/{id}")
    public ResponseEntity<String> alterarUsuario(@PathVariable Long id, @RequestBody Usuarios usuariosAtt) {
        Optional<Usuarios> usuario = usuariosRepository.findById(id);
        if (usuario.isPresent()) {

            Usuarios user = usuario.get();
            user.setFk_tb_tipos_sexos_id(usuariosAtt.getFk_tb_tipos_sexos_id());
            user.setNomeUsuario(usuariosAtt.getNomeUsuario());
            user.setNomeCompleto(usuariosAtt.getNomeCompleto());
            user.setTelefone(usuariosAtt.getTelefone());
            user.setBio(usuariosAtt.getBio());
            user.setCpf(usuariosAtt.getCpf());
            user.setUrlFoto(usuariosAtt.getUrlFoto());
            user.setEmail(usuariosAtt.getEmail());
            user.setDataNasc(usuariosAtt.getDataNasc());
            user.setDataMudanca(new Date());
            user.setDataDesativacao(usuariosAtt.getDataDesativacao());
            usuariosRepository.save(user);
            return ResponseEntity.ok("Usuário atualizado!");
        }
        return ResponseEntity.notFound().build();

    }

}
