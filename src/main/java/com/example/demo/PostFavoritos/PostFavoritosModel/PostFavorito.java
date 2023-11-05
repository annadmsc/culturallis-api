package com.example.demo.PostFavoritos.PostFavoritosModel;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cul_posts_favoritos")
public class PostFavorito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pk_id;

    @Column(name = "fk_cul_posts_id")
    private long pfkCulPostsId;

    @Column(name = "fk_cul_usuarios_id")
    private long pfkCulUsuariosId;

    @Column(name = "data_criacao")
    private Date dataCriacao;

    private Date data_mudanca;

    private Date data_desativacao;

    public PostFavorito() {
    }

    public PostFavorito(long pk_id, long pfkCulPostsId, long pfkCulUsuariosId, Date dataCriacao,
            Date data_mudanca, Date data_desativacao) {
        this.pk_id = pk_id;
        this.pfkCulPostsId = pfkCulPostsId;
        this.pfkCulUsuariosId = pfkCulUsuariosId;
        this.dataCriacao = dataCriacao;
        this.data_mudanca = data_mudanca;
        this.data_desativacao = data_desativacao;
    }

    public PostFavorito(long pfkCulPostsId, long pfkCulUsuariosId, Date dataCriacao, Date data_mudanca,
            Date data_desativacao) {
        this.pfkCulPostsId = pfkCulPostsId;
        this.pfkCulUsuariosId = pfkCulUsuariosId;
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

    public long getPfk_cul_posts_id() {
        return pfkCulPostsId;
    }

    public void setPfk_cul_posts_id(long pfkCulPostsId) {
        this.pfkCulPostsId = pfkCulPostsId;
    }

    public long getPfk_cul_usuarios_id() {
        return pfkCulUsuariosId;
    }

    public void setPfk_cul_usuarios_id(long pfkCulUsuariosId) {
        this.pfkCulUsuariosId = pfkCulUsuariosId;
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
                ", pfkCulPostsId=" + pfkCulPostsId +
                ", pfkCulUsuariosId=" + pfkCulUsuariosId +
                ", dataCriacao=" + dataCriacao +
                ", data_mudanca=" + data_mudanca +
                ", data_desativacao=" + data_desativacao +
                '}';
    }
}
