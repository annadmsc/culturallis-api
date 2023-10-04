package com.example.demo.Pagos.PagoController;

import com.example.demo.Pagos.PagoRepository;
import com.example.demo.Pagos.PagoModel.Pago;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/culturallis")
public class PagoController {

    private final PagoRepository pagoRepository;

    @Autowired
    public PagoController(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    @GetMapping("/listarCursosPagos")
    public List<Pago> getPaid() {
        return pagoRepository.findAll();
    }

    @PostMapping("/tornarCursoPago")
    public ResponseEntity<String> isPaid(@RequestBody Pago pago) {
        try {
            pagoRepository.save(pago);
            return ResponseEntity.ok("Curso foi tornado pago");
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/destornarPago")
    public ResponseEntity<String> deletePaid(@RequestParam Long id) {
        Optional<Pago> paid = pagoRepository.findById(id);
        if (paid.isPresent()) {
            pagoRepository.deleteById(id);
            return ResponseEntity.ok("Pago excluído!");
        }
        return ResponseEntity.notFound().build();
    }

}
