package com.example.demo.Pagos.PagoModel;

import jakarta.persistence.*;

@Entity
@Table(name = "cul_pagos")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long fk_cul_cursos_id;

    private double preco;

    public Pago(long fk_cul_cursos_id, double preco) {
        this.fk_cul_cursos_id = fk_cul_cursos_id;
        this.preco = preco;
    }

    public long getFk_cul_cursos_id() {
        return fk_cul_cursos_id;
    }

    public void setFk_cul_cursos_id(long fk_cul_cursos_id) {
        this.fk_cul_cursos_id = fk_cul_cursos_id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Pago() {
    }

    @Override
    public String toString() {
        return "Pago{" +
                "fk_cul_cursos_id=" + fk_cul_cursos_id +
                ", preco=" + preco +
                '}';
    }
}
