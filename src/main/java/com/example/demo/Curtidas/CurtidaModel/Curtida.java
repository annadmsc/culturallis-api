package com.example.demo.Curtidas.CurtidaModel;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cul_curtidas")
public class Curtida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pk_id;

    private long fk_cul_usuarios_id;

    private long fk_cul_posts_id;

    private Date data_criacao;

    private Date data_mudanca;

    private Date data_desativacao;

    public Curtida() {
    }

    public Curtida(long fk_cul_usuarios_id, long fk_cul_posts_id, Date data_criacao, Date data_mudanca, Date data_desativacao) {
        this.fk_cul_usuarios_id = fk_cul_usuarios_id;
        this.fk_cul_posts_id = fk_cul_posts_id;
        this.data_criacao = data_criacao;
        this.data_mudanca = data_mudanca;
        this.data_desativacao = data_desativacao;
    }

    public Curtida(long pk_id, long fk_cul_usuarios_id, long fk_cul_posts_id, Date data_criacao, Date data_mudanca, Date data_desativacao) {
        this.pk_id = pk_id;
        this.fk_cul_usuarios_id = fk_cul_usuarios_id;
        this.fk_cul_posts_id = fk_cul_posts_id;
        this.data_criacao = data_criacao;
        this.data_mudanca = data_mudanca;
        this.data_desativacao = data_desativacao;
    }

    public long getPk_id() {
        return pk_id;
    }

    public void setPk_id(long pk_id) {
        this.pk_id = pk_id;
    }

    public long getFk_cul_usuarios_id() {
        return fk_cul_usuarios_id;
    }

    public void setFk_cul_usuarios_id(long fk_cul_usuarios_id) {
        this.fk_cul_usuarios_id = fk_cul_usuarios_id;
    }

    public long getFk_cul_posts_id() {
        return fk_cul_posts_id;
    }

    public void setFk_cul_posts_id(long fk_cul_posts_id) {
        this.fk_cul_posts_id = fk_cul_posts_id;
    }

    public Date getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }

    public Date getData_mudanca() {
        return data_mudanca;
    }

    public void setData_mudanca(Date data_mudanca) {
        this.data_mudanca = data_mudanca;
    }

    public Date getData_desativacao() {
        return data_desativacao;
    }

    public void setData_desativacao(Date data_desativacao) {
        this.data_desativacao = data_desativacao;
    }

    @Override
    public String toString() {
        return "Curtida{" +
                "pk_id=" + pk_id +
                ", fk_cul_usuarios_id=" + fk_cul_usuarios_id +
                ", fk_cul_posts_id=" + fk_cul_posts_id +
                ", data_criacao=" + data_criacao +
                ", data_mudanca=" + data_mudanca +
                ", data_desativacao=" + data_desativacao +
                '}';
    }
}
