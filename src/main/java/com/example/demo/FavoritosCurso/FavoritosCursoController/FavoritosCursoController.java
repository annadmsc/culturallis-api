package com.example.demo.FavoritosCurso.FavoritosCursoController;

import com.example.demo.FavoritosCurso.FavoritosCursoRepository;
import com.example.demo.FavoritosCurso.FavoritosCursoModel.FavoritoCurso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/culturallis")
public class FavoritosCursoController {

    private final FavoritosCursoRepository favoritosCursoRepository;


    @Autowired
    public FavoritosCursoController(FavoritosCursoRepository favoritosCursoRepository) {
        this.favoritosCursoRepository = favoritosCursoRepository;
    }




    @GetMapping("/listarCursosFavoritos")
    public List<FavoritoCurso> getFavoriteCourse() {
        return favoritosCursoRepository.findAll();
    }

    @PostMapping("/inserirCursoFavorito")
    public ResponseEntity<String> insertFavoriteCourse(@RequestBody FavoritoCurso favCurso) {
        favCurso.setData_criacao(new Date());
        try {
            favoritosCursoRepository.save(favCurso);
            return ResponseEntity.ok("Curso favoritado!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/excluirCursoFavorito")
    public ResponseEntity<String> defavoriteCourse(@RequestParam Long id) {
        Optional<FavoritoCurso> favToDel = favoritosCursoRepository.findById(id);
        if (favToDel.isPresent()) {
            favoritosCursoRepository.deleteById(id);
            return ResponseEntity.ok("Este não é mais um curso favorito");
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/alterarCursoFavorito/{id}")
    public ResponseEntity<String> alterarCursoFavorito(@PathVariable Long id, @RequestBody FavoritoCurso favAtt) {
        Optional<FavoritoCurso> fav = favoritosCursoRepository.findById(id);
        if (fav.isPresent()) {
            FavoritoCurso crsFav = fav.get();
            crsFav.setFk_cul_cursos_id(favAtt.getFk_cul_cursos_id());
            crsFav.setFk_cul_usuarios_id(favAtt.getFk_cul_usuarios_id());
            crsFav.setData_criacao(favAtt.getData_criacao());
            crsFav.setData_mudanca(new Date());
            crsFav.setData_desativacao(favAtt.getData_desativacao());
            favoritosCursoRepository.save(crsFav);
            return ResponseEntity.ok("Curso Favorito atualizado!");
        }
        return ResponseEntity.notFound().build();

    }
}
