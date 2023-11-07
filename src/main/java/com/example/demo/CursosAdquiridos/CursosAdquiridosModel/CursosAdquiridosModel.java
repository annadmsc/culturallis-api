package com.example.demo.CursosAdquiridos.CursosAdquiridosModel;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cul_cursos_adquiridos")
public class CursosAdquiridosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk_id;

    @Column(name = "fk_cul_usuarios_id")
    private int fkCulUsuariosId;

    @Column(name = "fk_cul_cursos_id")
    private int fkCulCursosId;

    @Column(name = "data_criacao")
    private Date dataCriacao;

    private Date data_mudanca;

    private Date data_desativacao;

    public CursosAdquiridosModel(){}

    public CursosAdquiridosModel(int fkCulUsuariosId, int fkCulCursosId, Date dataCriacao, Date data_mudanca, Date data_desativacao) {
        this.fkCulUsuariosId = fkCulUsuariosId;
        this.fkCulCursosId = fkCulCursosId;
        this.dataCriacao = dataCriacao;
        this.data_mudanca = data_mudanca;
        this.data_desativacao = data_desativacao;
    }

    public CursosAdquiridosModel(Long pk_id, int fkCulUsuariosId, int fkCulCursosId, Date dataCriacao, Date data_mudanca, Date data_desativacao) {
        this.pk_id = pk_id;
        this.fkCulUsuariosId = fkCulUsuariosId;
        this.fkCulCursosId = fkCulCursosId;
        this.dataCriacao = dataCriacao;
        this.data_mudanca = data_mudanca;
        this.data_desativacao = data_desativacao;
    }

    public Long getPk_id() {
        return pk_id;
    }

    public void setPk_id(Long pk_id) {
        this.pk_id = pk_id;
    }

    public int getFk_cul_Usuarios_id() {
        return fkCulUsuariosId;
    }

    public void setFk_cul_Usuarios_id(int fkCulUsuariosId) {
        this.fkCulUsuariosId = fkCulUsuariosId;
    }

    public int getFk_cul_cursos_id() {
        return fkCulCursosId;
    }

    public void setFk_cul_cursos_id(int fkCulCursosId) {
        this.fkCulCursosId = fkCulCursosId;
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
        return "CursosAdquiridosModel{" +
                "pk_id=" + pk_id +
                ", fkCulUsuariosId=" + fkCulUsuariosId +
                ", fkCulCursosId=" + fkCulCursosId +
                ", dataCriacao=" + dataCriacao +
                ", data_mudanca=" + data_mudanca +
                ", data_desativacao=" + data_desativacao +
                '}';
    }
}
