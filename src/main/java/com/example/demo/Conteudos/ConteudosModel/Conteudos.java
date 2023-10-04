package com.example.demo.Conteudos.ConteudosModel;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_conteudos")
public class Conteudos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pk_id;

    private Long fk_tb_curso_id;

    private String nome;

    private String descricao;

    private String url_material;

    private String url_video;

    private Date data_criacao;

    private Date data_mudanca;

    private Date data_desativacao;

    public Conteudos(Long fk_tb_curso_id, String nome, String descricao, String url_material, String url_video) {
        this.fk_tb_curso_id = fk_tb_curso_id;
        this.nome = nome;
        this.descricao = descricao;
        this.url_material = url_material;
        this.url_video = url_video;
    }

    public Conteudos(Long pk_id, Long fk_tb_curso_id, String nome, String descricao, String url_material, String url_video, Date data_criacao, Date data_mudanca, Date data_desativacao) {
        this.pk_id = pk_id;
        this.fk_tb_curso_id = fk_tb_curso_id;
        this.nome = nome;
        this.descricao = descricao;
        this.url_material = url_material;
        this.url_video = url_video;
        this.data_criacao = data_criacao;
        this.data_mudanca = data_mudanca;
        this.data_desativacao = data_desativacao;
    }

    public Conteudos(Long fk_tb_curso_id, String nome, String descricao, String url_material, String url_video, Date data_criacao, Date data_mudanca, Date data_desativacao) {
        this.fk_tb_curso_id = fk_tb_curso_id;
        this.nome = nome;
        this.descricao = descricao;
        this.url_material = url_material;
        this.url_video = url_video;
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
        return fk_tb_curso_id;
    }

    public void setFk_tb_curso_id(Long fk_tb_curso_id) {
        this.fk_tb_curso_id = fk_tb_curso_id;
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

    public String getUrl_material() {
        return url_material;
    }

    public void setUrl_material(String url_material) {
        this.url_material = url_material;
    }

    public String getUrl_video() {
        return url_video;
    }

    public void setUrl_video(String url_video) {
        this.url_video = url_video;
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
        return "ConteudosModel{" +
                "pk_id=" + pk_id +
                ", fk_tb_curso_id=" + fk_tb_curso_id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", url_material='" + url_material + '\'' +
                ", url_video='" + url_video + '\'' +
                ", data_criacao=" + data_criacao +
                ", data_mudanca=" + data_mudanca +
                ", data_desativacao=" + data_desativacao +
                '}';
    }
}
