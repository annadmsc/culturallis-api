package com.example.demo.CursosAdquiridos.CursosAdquiridosModel;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cul_cursos_adquiridos")
public class CursosAdquiridosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pk_id;

    private int fk_cul_Usuarios_id;

    @Column(name = "fk_cul_cursos_id")
    private int fkCulCursosId;

    private Date data_criacao;

    private Date data_mudanca;

    private Date data_desativacao;

    public CursosAdquiridosModel(){}

    public CursosAdquiridosModel(int fk_cul_Usuarios_id, int fkCulCursosId, Date data_criacao, Date data_mudanca, Date data_desativacao) {
        this.fk_cul_Usuarios_id = fk_cul_Usuarios_id;
        this.fkCulCursosId = fkCulCursosId;
        this.data_criacao = data_criacao;
        this.data_mudanca = data_mudanca;
        this.data_desativacao = data_desativacao;
    }

    public CursosAdquiridosModel(Long pk_id, int fk_cul_Usuarios_id, int fkCulCursosId, Date data_criacao, Date data_mudanca, Date data_desativacao) {
        this.pk_id = pk_id;
        this.fk_cul_Usuarios_id = fk_cul_Usuarios_id;
        this.fkCulCursosId = fkCulCursosId;
        this.data_criacao = data_criacao;
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
        return fk_cul_Usuarios_id;
    }

    public void setFk_cul_Usuarios_id(int fk_cul_Usuarios_id) {
        this.fk_cul_Usuarios_id = fk_cul_Usuarios_id;
    }

    public int getFk_cul_cursos_id() {
        return fkCulCursosId;
    }

    public void setFk_cul_cursos_id(int fkCulCursosId) {
        this.fkCulCursosId = fkCulCursosId;
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
        return "CursosAdquiridosModel{" +
                "pk_id=" + pk_id +
                ", fk_cul_Usuarios_id=" + fk_cul_Usuarios_id +
                ", fkCulCursosId=" + fkCulCursosId +
                ", data_criacao=" + data_criacao +
                ", data_mudanca=" + data_mudanca +
                ", data_desativacao=" + data_desativacao +
                '}';
    }
}
