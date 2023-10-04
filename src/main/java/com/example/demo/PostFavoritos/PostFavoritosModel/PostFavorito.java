package com.example.demo.PostFavoritos.PostFavoritosModel;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cul_posts_favoritos")
public class PostFavorito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pk_id;

    private long pfk_cul_posts_id;

    private long pfk_cul_usuarios_id;

    private Date data_criacao;

    private Date data_mudanca;

    private Date data_desativacao;

    public PostFavorito() {
    }

    public PostFavorito(long pk_id, long pfk_cul_posts_id, long pfk_cul_usuarios_id, Date data_criacao,
            Date data_mudanca, Date data_desativacao) {
        this.pk_id = pk_id;
        this.pfk_cul_posts_id = pfk_cul_posts_id;
        this.pfk_cul_usuarios_id = pfk_cul_usuarios_id;
        this.data_criacao = data_criacao;
        this.data_mudanca = data_mudanca;
        this.data_desativacao = data_desativacao;
    }

    public PostFavorito(long pfk_cul_posts_id, long pfk_cul_usuarios_id, Date data_criacao, Date data_mudanca,
            Date data_desativacao) {
        this.pfk_cul_posts_id = pfk_cul_posts_id;
        this.pfk_cul_usuarios_id = pfk_cul_usuarios_id;
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

    public long getPfk_cul_posts_id() {
        return pfk_cul_posts_id;
    }

    public void setPfk_cul_posts_id(long pfk_cul_posts_id) {
        this.pfk_cul_posts_id = pfk_cul_posts_id;
    }

    public long getPfk_cul_usuarios_id() {
        return pfk_cul_usuarios_id;
    }

    public void setPfk_cul_usuarios_id(long pfk_cul_usuarios_id) {
        this.pfk_cul_usuarios_id = pfk_cul_usuarios_id;
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
        return "PostFavorito{" +
                "pk_id=" + pk_id +
                ", pfk_cul_posts_id=" + pfk_cul_posts_id +
                ", pfk_cul_usuarios_id=" + pfk_cul_usuarios_id +
                ", data_criacao=" + data_criacao +
                ", data_mudanca=" + data_mudanca +
                ", data_desativacao=" + data_desativacao +
                '}';
    }
}
