package com.example.demo.Conteudos.ConteudosModel;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cul_conteudos")
public class Conteudos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pk_id;

    @Column(name = "fk_cul_cursos_id")
    private Long fkCulCursosId;

    private String nome;

    private String url_material;

    private Date data_criacao;

    private Date data_mudanca;

    private Date data_desativacao;

    public Conteudos(Long fkCulCursosId, String nome, String url_material) {
        this.fkCulCursosId = fkCulCursosId;
        this.nome = nome;
        this.url_material = url_material;
    }

    public Conteudos(Long pk_id, Long fkCulCursosId, String nome, String url_material, Date data_criacao, Date data_mudanca, Date data_desativacao) {
        this.pk_id = pk_id;
        this.fkCulCursosId = fkCulCursosId;
        this.nome = nome;
        this.url_material = url_material;
        this.data_criacao = data_criacao;
        this.data_mudanca = data_mudanca;
        this.data_desativacao = data_desativacao;
    }

    public Conteudos(Long fkCulCursosId, String nome, String url_material, Date data_criacao, Date data_mudanca, Date data_desativacao) {
        this.fkCulCursosId = fkCulCursosId;
        this.nome = nome;
        this.url_material = url_material;
        this.data_criacao = data_criacao;
        this.data_mudanca = data_mudanca;
        this.data_desativacao = data_desativacao;
    }

    public Conteudos() {

    }

    public Long getPk_id() {
        return pk_id;
    }

    public void setPk_id(Long pk_id) {
        this.pk_id = pk_id;
    }

    public Long getFk_tb_curso_id() {
        return fkCulCursosId;
    }

    public void setFk_tb_curso_id(Long fkCulCursosId) {
        this.fkCulCursosId = fkCulCursosId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrl_material() {
        return url_material;
    }

    public void setUrl_material(String url_material) {
        this.url_material = url_material;
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
        return "Conteudos{" +
                "pk_id=" + pk_id +
                ", fkCulCursosId=" + fkCulCursosId +
                ", nome='" + nome + '\'' +
                ", url_material='" + url_material + '\'' +
                ", data_criacao=" + data_criacao +
                ", data_mudanca=" + data_mudanca +
                ", data_desativacao=" + data_desativacao +
                '}';
    }
}
