package com.example.demo.Cursos.CursoModel;

import com.example.demo.Conteudos.ConteudosModel.Conteudos;

import java.util.Date;
import java.util.List;

public class CourseCreation {

    private String nome;

    private String fotoPost;

    private String fk_cul_usuarios_id;

    private String descricao;

    private String categoria;

    private Double preco;

    private Date data_criaco;

    private Date data_mudanca;

    private Date data_desastivacao;

    private List<Conteudos> conteudosList;

    public CourseCreation(String nome, String fotoPost, String fk_cul_usuarios_id, String descricao, String categoria, Double preco, Date data_criaco, Date data_mudanca, Date data_desastivacao, List<Conteudos> conteudosList) {
        this.nome = nome;
        this.fotoPost = fotoPost;
        this.fk_cul_usuarios_id = fk_cul_usuarios_id;
        this.descricao = descricao;
        this.categoria = categoria;
        this.preco = preco;
        this.data_criaco = data_criaco;
        this.data_mudanca = data_mudanca;
        this.data_desastivacao = data_desastivacao;
        this.conteudosList = conteudosList;
    }

    @Override
    public String toString() {
        return "CourseCreation{" +
                "nome='" + nome + '\'' +
                ", fotoPost='" + fotoPost + '\'' +
                ", fk_cul_usuarios_id='" + fk_cul_usuarios_id + '\'' +
                ", descricao='" + descricao + '\'' +
                ", categoria='" + categoria + '\'' +
                ", preco=" + preco +
                ", data_criaco=" + data_criaco +
                ", data_mudanca=" + data_mudanca +
                ", data_desastivacao=" + data_desastivacao +
                ", conteudosList=" + conteudosList +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFotoPost() {
        return fotoPost;
    }

    public void setFotoPost(String fotoPost) {
        this.fotoPost = fotoPost;
    }

    public String getFk_cul_usuarios_id() {
        return fk_cul_usuarios_id;
    }

    public void setFk_cul_usuarios_id(String fk_cul_usuarios_id) {
        this.fk_cul_usuarios_id = fk_cul_usuarios_id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Date getData_criaco() {
        return data_criaco;
    }

    public void setData_criaco(Date data_criaco) {
        this.data_criaco = data_criaco;
    }

    public Date getData_mudanca() {
        return data_mudanca;
    }

    public void setData_mudanca(Date data_mudanca) {
        this.data_mudanca = data_mudanca;
    }

    public Date getData_desastivacao() {
        return data_desastivacao;
    }

    public void setData_desastivacao(Date data_desastivacao) {
        this.data_desastivacao = data_desastivacao;
    }

    public List<Conteudos> getConteudosList() {
        return conteudosList;
    }

    public void setConteudosList(List<Conteudos> conteudosList) {
        this.conteudosList = conteudosList;
    }
}
