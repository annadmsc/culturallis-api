package com.example.demo.Cursos.CursoModel;

import com.example.demo.Categorias.CategoriasModel.Categorias;
import com.example.demo.Conteudos.ConteudosModel.Conteudos;

import java.util.Date;
import java.util.List;

public class CourseInfo {
    private Long pk_id;

    private Long fk_cul_usuarios_id;

    private Long fk_cul_categorias_id;

    private String nome;

    private String categoria;

    private String descricao;

    private double preco;

    private Date data_criacao;

    private Date data_mudanca;

    private Date data_desativacao;

    private List<Conteudos> modulos;

    public CourseInfo(){};

    public CourseInfo(Long pk_id, Long fk_cul_usuarios_id, Long fk_cul_categorias_id, String nome, String categoria, String descricao, double preco, Date data_criacao, Date data_mudanca, Date data_desativacao, List<Conteudos> modulos) {
        this.pk_id = pk_id;
        this.fk_cul_usuarios_id = fk_cul_usuarios_id;
        this.fk_cul_categorias_id = fk_cul_categorias_id;
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
        this.preco = preco;
        this.data_criacao = data_criacao;
        this.data_mudanca = data_mudanca;
        this.data_desativacao = data_desativacao;
        this.modulos = modulos;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Long getPk_id() {
        return pk_id;
    }

    public void setPk_id(Long pk_id) {
        this.pk_id = pk_id;
    }

    public Long getFk_cul_usuarios_id() {
        return fk_cul_usuarios_id;
    }

    public void setFk_cul_usuarios_id(Long fk_cul_usuarios_id) {
        this.fk_cul_usuarios_id = fk_cul_usuarios_id;
    }

    public Long getFk_cul_categorias_id() {
        return fk_cul_categorias_id;
    }

    public void setFk_cul_categorias_id(Long fk_cul_categorias_id) {
        this.fk_cul_categorias_id = fk_cul_categorias_id;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
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

    public List<Conteudos> getModulos() {
        return modulos;
    }

    public void setModulos(List<Conteudos> modulos) {
        this.modulos = modulos;
    }

    @Override
    public String toString() {
        return "CourseInfo{" +
                "pk_id=" + pk_id +
                ", fk_cul_usuarios_id=" + fk_cul_usuarios_id +
                ", fk_cul_categorias_id=" + fk_cul_categorias_id +
                ", nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", data_criacao=" + data_criacao +
                ", data_mudanca=" + data_mudanca +
                ", data_desativacao=" + data_desativacao +
                ", modulos=" + modulos +
                '}';
    }
}
