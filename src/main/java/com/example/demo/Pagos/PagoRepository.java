package com.example.demo.Pagos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Pagos.PagoModel.Pago;

public interface PagoRepository extends JpaRepository<Pago, Long> {
}
