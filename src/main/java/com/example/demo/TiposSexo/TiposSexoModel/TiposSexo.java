package com.example.demo.TiposSexo.TiposSexoModel;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_tipos_sexos")
public class TiposSexo {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pk_id;

    private String nome;

    private Date data_criacao;

    private Date data_mudanca;

    private Date data_desativacao;

    public TiposSexo(long pk_id, String nome, Date data_criacao, Date data_mudanca, Date data_desativacao) {
        this.pk_id = pk_id;
        this.nome = nome;
        this.data_criacao = data_criacao;
        this.data_mudanca = data_mudanca;
        this.data_desativacao = data_desativacao;
    }

    public TiposSexo(String nome, Date data_criacao, Date data_mudanca, Date data_desativacao) {
        this.nome = nome;
        this.data_criacao = data_criacao;
        this.data_mudanca = data_mudanca;
        this.data_desativacao = data_desativacao;
    }

    public TiposSexo(){}

    public long getPk_id() {
        return pk_id;
    }

    public void setPk_id(long pk_id) {
        this.pk_id = pk_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        return "TiposSexo{" +
                "pk_id=" + pk_id +
                ", nome='" + nome + '\'' +
                ", data_criacao=" + data_criacao +
                ", data_mudanca=" + data_mudanca +
                ", data_desativacao=" + data_desativacao +
                '}';
    }
}
