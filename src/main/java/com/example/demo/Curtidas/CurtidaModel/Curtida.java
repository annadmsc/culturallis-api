package com.example.demo.Curtidas.CurtidaModel;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cul_curtidas")
public class Curtida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pk_id;

    @Column(name = "fk_cul_usuarios_id")
    private long fkCulUsuariosId;

    @Column(name = "fk_cul_posts_id")
    private long fkCulPostsId;

    @Column(name="data_criacao")
     private Date dataCriacao;

     private Date data_mudanca;

     private Date data_desativacao;
    public Curtida() {
    }

    public Date getData_desativacao() {
        return data_desativacao;
    }

    public void setData_desativacao(Date data_desativacao) {
        this.data_desativacao = data_desativacao;
    }

    public Curtida(long fkCulUsuariosId, long fkCulPostsId, Date dataCriacao, Date data_mudanca, Date data_desativacao) {
        this.fkCulUsuariosId = fkCulUsuariosId;
        this.fkCulPostsId = fkCulPostsId;
         this.dataCriacao = dataCriacao;
         this.data_mudanca = data_mudanca;
        this.data_desativacao = data_desativacao;
    }

    public Curtida(long pk_id, long fkCulUsuariosId, long fkCulPostsId, Date dataCriacao, Date data_mudanca, Date data_desativacao) {
        this.pk_id = pk_id;
        this.fkCulUsuariosId = fkCulUsuariosId;
        this.fkCulPostsId = fkCulPostsId;
         this.dataCriacao = dataCriacao;
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
        return fkCulUsuariosId;
    }

    public void setFk_cul_usuarios_id(long fkCulUsuariosId) {
        this.fkCulUsuariosId = fkCulUsuariosId;
    }

    public long getFk_cul_posts_id() {
        return fkCulPostsId;
    }

    public void setFk_cul_posts_id(long fkCulPostsId) {
        this.fkCulPostsId = fkCulPostsId;
    }

     public Date getData_criacao() {
     return dataCriacao;
     }

     public void setData_criacao(Date dataCriacao) {
     this.dataCriacao = dataCriacao;
     }

     public Date getData_mudanca() {
     return data_mudanca;
     }

     public void setData_mudanca(Date data_mudanca) {
     this.data_mudanca = data_mudanca;
     }

    @Override
    public String toString() {
        return "Curtida{" +
                "pk_id=" + pk_id +
                ", fkCulUsuariosId=" + fkCulUsuariosId +
                ", fkCulPostsId=" + fkCulPostsId +
                 ", dataCriacao=" + dataCriacao +
                 ", data_mudanca=" + data_mudanca +
                ", data_desativacao=" + data_desativacao +
                '}';
    }
}
