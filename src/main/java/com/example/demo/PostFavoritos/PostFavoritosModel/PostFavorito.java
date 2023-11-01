package com.example.demo.PostFavoritos.PostFavoritosModel;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cul_posts_favoritos")
public class PostFavorito {
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

    public PostFavorito() {
    }

    public PostFavorito(long pk_id, long pfk_cul_posts_id, long pfk_cul_usuarios_id, Date data_criacao,
            Date data_mudanca, Date data_desativacao) {
        this.pk_id = pk_id;
        this.fkCulPostsId = pfk_cul_posts_id;
        this.fkCulUsuariosId = pfk_cul_usuarios_id;
        this.dataCriacao = data_criacao;
        this.data_mudanca = data_mudanca;
        this.data_desativacao = data_desativacao;
    }

    public PostFavorito(long pfk_cul_posts_id, long pfk_cul_usuarios_id, Date data_criacao, Date data_mudanca,
            Date data_desativacao) {
        this.fkCulPostsId = pfk_cul_posts_id;
        this.fkCulUsuariosId = pfk_cul_usuarios_id;
        this.dataCriacao = data_criacao;
        this.data_mudanca = data_mudanca;
        this.data_desativacao = data_desativacao;
    }

    public long getPk_id() {
        return pk_id;
    }

    public void setPk_id(long pk_id) {
        this.pk_id = pk_id;
    }

    public long getPfk_cul_posts_id() {
        return fkCulPostsId;
    }

    public void setPfk_cul_posts_id(long pfk_cul_posts_id) {
        this.fkCulPostsId = pfk_cul_posts_id;
    }

    public long getPfk_cul_usuarios_id() {
        return fkCulUsuariosId;
    }

    public void setPfk_cul_usuarios_id(long pfk_cul_usuarios_id) {
        this.fkCulUsuariosId = pfk_cul_usuarios_id;
    }

    public Date getData_criacao() {
        return dataCriacao;
    }

    public void setData_criacao(Date data_criacao) {
        this.dataCriacao = data_criacao;
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
        return "PostFavorito{" +
                "pk_id=" + pk_id +
                ", pfk_cul_posts_id=" + fkCulPostsId +
                ", pfk_cul_usuarios_id=" + fkCulUsuariosId +
                ", data_criacao=" + dataCriacao +
                ", data_mudanca=" + data_mudanca +
                ", data_desativacao=" + data_desativacao +
                '}';
    }
}
