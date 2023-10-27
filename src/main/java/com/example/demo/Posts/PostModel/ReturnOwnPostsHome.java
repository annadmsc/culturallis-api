package com.example.demo.Posts.PostModel;

import java.util.Date;

public class ReturnOwnPostsHome {

    private long pk_id;

    private long fk_cul_usuarios_id;

    private String descricao;

    private String url_midia;

    private Date data_criacao;

    private Date data_mudanca;

    private Date data_desativacao;

    private String postsOwnerFoto;

    private String postsOwnerName;


    public ReturnOwnPostsHome() {
    }

    public ReturnOwnPostsHome(long pk_id, long fk_cul_usuarios_id, String descricao, String url_midia, Date data_criacao, Date data_mudanca, Date data_desativacao, String postsOwnerFoto, String postsOwnerName) {
        this.pk_id = pk_id;
        this.fk_cul_usuarios_id = fk_cul_usuarios_id;
        this.descricao = descricao;
        this.url_midia = url_midia;
        this.data_criacao = data_criacao;
        this.data_mudanca = data_mudanca;
        this.data_desativacao = data_desativacao;
        this.postsOwnerFoto = postsOwnerFoto;
        this.postsOwnerName = postsOwnerName;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl_midia() {
        return url_midia;
    }

    public void setUrl_midia(String url_midia) {
        this.url_midia = url_midia;
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

    public String getPostsOwnerFoto() {
        return postsOwnerFoto;
    }

    public void setPostsOwnerFoto(String postsOwnerFoto) {
        this.postsOwnerFoto = postsOwnerFoto;
    }

    public String getPostsOwnerName() {
        return postsOwnerName;
    }

    public void setPostsOwnerName(String postsOwnerName) {
        this.postsOwnerName = postsOwnerName;
    }


    @Override
    public String toString() {
        return "ReturnPostsHome{" +
                "pk_id=" + pk_id +
                ", fk_cul_usuarios_id=" + fk_cul_usuarios_id +
                ", descricao='" + descricao + '\'' +
                ", url_midia='" + url_midia + '\'' +
                ", data_criacao=" + data_criacao +
                ", data_mudanca=" + data_mudanca +
                ", data_desativacao=" + data_desativacao +
                ", postsOwnerFoto='" + postsOwnerFoto + '\'' +
                ", postsOwnerName='" + postsOwnerName + '\'' +
                '}';
    }
}
