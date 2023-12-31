package com.example.demo.Seguidores.SeguidorModel;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cul_seguidores")
public class Seguidor {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pk_id;

    private long fk_cul_usuarios_seguidores_id;

    private long fk_cul_usuarios_seguidos_id;

    private Date data_criacao;

    private Date data_mudanca;

    private Date data_desativacao;

    public Seguidor(long pk_id, long fk_cul_usuarios_seguidores_id, long fk_cul_usuarios_seguidos_id, Date data_criacao,
            Date data_mudanca, Date data_desativacao) {
        this.pk_id = pk_id;
        this.fk_cul_usuarios_seguidores_id = fk_cul_usuarios_seguidores_id;
        this.fk_cul_usuarios_seguidos_id = fk_cul_usuarios_seguidos_id;
        this.data_criacao = data_criacao;
        this.data_mudanca = data_mudanca;
        this.data_desativacao = data_desativacao;
    }

    public Seguidor(long fk_cul_usuarios_seguidores_id, long fk_cul_usuarios_seguidos_id, Date data_criacao,
            Date data_mudanca, Date data_desativacao) {
        this.fk_cul_usuarios_seguidores_id = fk_cul_usuarios_seguidores_id;
        this.fk_cul_usuarios_seguidos_id = fk_cul_usuarios_seguidos_id;
        this.data_criacao = data_criacao;
        this.data_mudanca = data_mudanca;
        this.data_desativacao = data_desativacao;
    }

    public Seguidor() {
    }

    public long getPk_id() {
        return pk_id;
    }

    public void setPk_id(long pk_id) {
        this.pk_id = pk_id;
    }

    public void setFk_cul_usuarios_seguidores_id(long fk_cul_usuarios_seguidores_id) {
        this.fk_cul_usuarios_seguidores_id = fk_cul_usuarios_seguidores_id;
    }

    public long getFk_cul_usuarios_seguidores_id() {
        return fk_cul_usuarios_seguidores_id;
    }

    public void setFk_cul_usuarios_seguidos_id(long fk_cul_usuarios_seguidos_id) {
        this.fk_cul_usuarios_seguidos_id = fk_cul_usuarios_seguidos_id;
    }
    public long getFk_cul_usuarios_seguidos_id() {
        return fk_cul_usuarios_seguidos_id;
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
        return "Seguidor{" +
                "pk_id=" + pk_id +
                ", fk_cul_usuarios_seguidores_id=" + fk_cul_usuarios_seguidores_id +
                ", fk_cul_usuarios_seguidos_id=" + fk_cul_usuarios_seguidos_id +
                ", data_criacao=" + data_criacao +
                ", data_mudanca=" + data_mudanca +
                ", data_desativacao=" + data_desativacao +
                '}';
    }

}
