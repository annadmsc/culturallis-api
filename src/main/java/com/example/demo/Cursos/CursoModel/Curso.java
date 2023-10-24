package com.example.demo.Cursos.CursoModel;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cul_cursos")
public class Curso {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pk_id;

    private long fk_cul_categorias_id;

    @Column(name = "fkCulUsuariosId")
    private long fkCulUsuariosId;

    private String nome;

    private String descricao;

    private Date data_criacao;

    private Date data_mudanca;

    private Date data_desativacao;

    public Curso(long pk_id, long fk_cul_categorias_id, long fkCulUsuariosId, String nome, String descricao,
            Date data_criacao, Date data_mudanca, Date data_desativacao) {
        this.pk_id = pk_id;
        this.fk_cul_categorias_id = fk_cul_categorias_id;
        this.fkCulUsuariosId = fkCulUsuariosId;
        this.nome = nome;
        this.descricao = descricao;
        this.data_criacao = data_criacao;
        this.data_mudanca = data_mudanca;
        this.data_desativacao = data_desativacao;
    }

    public Curso(long fk_cul_categorias_id, long fkCulUsuariosId, String nome, String descricao, Date data_criacao,
            Date data_mudanca, Date data_desativacao) {
        this.fk_cul_categorias_id = fk_cul_categorias_id;
        this.fkCulUsuariosId = fkCulUsuariosId;
        this.nome = nome;
        this.descricao = descricao;
        this.data_criacao = data_criacao;
        this.data_mudanca = data_mudanca;
        this.data_desativacao = data_desativacao;
    }

    public Curso() {
    }

    public long getPk_id() {
        return pk_id;
    }

    public void setPk_id(long pk_id) {
        this.pk_id = pk_id;
    }

    public long getFk_cul_categorias_id() {
        return fk_cul_categorias_id;
    }

    public void setFk_cul_categorias_id(long fk_cul_categorias_id) {
        this.fk_cul_categorias_id = fk_cul_categorias_id;
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
                ", fk_cul_categorias_id=" + fk_cul_categorias_id +
                ", fkCulUsuariosId=" + fkCulUsuariosId +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", data_criacao=" + data_criacao +
                ", data_mudanca=" + data_mudanca +
                ", data_desativacao=" + data_desativacao +
                '}';
    }
}
