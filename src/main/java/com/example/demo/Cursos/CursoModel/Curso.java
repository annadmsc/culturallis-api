package com.example.demo.Cursos.CursoModel;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cul_cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pk_id;

    @Column(name = "fk_cul_categorias_id")
    private long fkCulCategoriasId;

    @Column(name = "fkCulUsuariosId")
    private long fkCulUsuariosId;

    private String nome;

    private Double preco;

    private String url_midia;

    private String descricao;

    private Date data_criacao;

    private Date data_mudanca;

    private Date data_desativacao;

    public Curso(long pk_id, long fkCulCategoriasId, long fkCulUsuariosId, String nome, String url_midia, String descricao, Date data_criacao, Date data_mudanca, Date data_desativacao) {
        this.pk_id = pk_id;
        this.fkCulCategoriasId = fkCulCategoriasId;
        this.fkCulUsuariosId = fkCulUsuariosId;
        this.nome = nome;
        this.url_midia = url_midia;
        this.descricao = descricao;
        this.data_criacao = data_criacao;
        this.data_mudanca = data_mudanca;
        this.data_desativacao = data_desativacao;
    }

    public Curso(long fkCulCategoriasId, long fkCulUsuariosId, String nome, Double preco, String url_midia, String descricao, Date data_criacao, Date data_mudanca, Date data_desativacao) {
        this.fkCulCategoriasId = fkCulCategoriasId;
        this.fkCulUsuariosId = fkCulUsuariosId;
        this.nome = nome;
        this.preco = preco;
        this.url_midia = url_midia;
        this.descricao = descricao;
        this.data_criacao = data_criacao;
        this.data_mudanca = data_mudanca;
        this.data_desativacao = data_desativacao;
    }

    public Curso(long fkCulCategoriasId, long fkCulUsuariosId, String nome, String url_midia, String descricao, Date data_criacao, Date data_mudanca, Date data_desativacao) {
        this.fkCulCategoriasId = fkCulCategoriasId;
        this.fkCulUsuariosId = fkCulUsuariosId;
        this.nome = nome;
        this.url_midia = url_midia;
        this.descricao = descricao;
        this.data_criacao = data_criacao;
        this.data_mudanca = data_mudanca;
        this.data_desativacao = data_desativacao;
    }

    public Curso() {
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public long getPk_id() {
        return pk_id;
    }

    public void setPk_id(long pk_id) {
        this.pk_id = pk_id;
    }

    public long getFkCulCategoriasId() {
        return fkCulCategoriasId;
    }

    public void setFkCulCategoriasId(long fkCulCategoriasId) {
        this.fkCulCategoriasId = fkCulCategoriasId;
    }
//
//    public long getFkCulUsuariosId() {
//        return fkCulUsuariosId;
//    }
//
//    public void setFkCulUsuariosId(long fkCulUsuariosId) {
//        this.fkCulUsuariosId = fkCulUsuariosId;
//    }

    public String getUrl_midia() {
        return url_midia;
    }

    public void setUrl_midia(String url_midia) {
        this.url_midia = url_midia;
    }

    public long getFk_cul_categorias_id() {
        return fkCulCategoriasId;
    }

    public void setFk_cul_categorias_id(long fkCulCategoriasId) {
        this.fkCulCategoriasId = fkCulCategoriasId;
    }

    public long getfkCulUsuariosId() {
        return fkCulUsuariosId;
    }

    public void setfkCulUsuariosId(long fkCulUsuariosId) {
        this.fkCulUsuariosId = fkCulUsuariosId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        return "Curso{" +
                "pk_id=" + pk_id +
                ", fkCulCategoriasId=" + fkCulCategoriasId +
                ", fkCulUsuariosId=" + fkCulUsuariosId +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", url_midia='" + url_midia + '\'' +
                ", descricao='" + descricao + '\'' +
                ", data_criacao=" + data_criacao +
                ", data_mudanca=" + data_mudanca +
                ", data_desativacao=" + data_desativacao +
                '}';
    }
}
