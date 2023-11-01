package com.example.demo.CursosAdquiridos.CursosAdquiridosModel;

import java.util.Date;

public class CursosAdquiridos {

    private Long pk_id;

    private int fkCulUsuariosId;

    private int fkCulCursosId;

    private Date dataCriacao;

    private Date dataModificacao;

    private Date dataDesativacao;

    CursosAdquiridos(){}

    public CursosAdquiridos(Long pk_id, int fkCulUsuariosId, int fkCulCursosId, Date dataCriacao, Date dataModificacao, Date dataDesativacao) {
        this.pk_id = pk_id;
        this.fkCulUsuariosId = fkCulUsuariosId;
        this.fkCulCursosId = fkCulCursosId;
        this.dataCriacao = dataCriacao;
        this.dataModificacao = dataModificacao;
        this.dataDesativacao = dataDesativacao;
    }

    public Long getPk_id() {
        return pk_id;
    }

    public void setPk_id(Long pk_id) {
        this.pk_id = pk_id;
    }

    public int getFkCulUsuariosId() {
        return fkCulUsuariosId;
    }

    public void setFkCulUsuariosId(int fkCulUsuariosId) {
        this.fkCulUsuariosId = fkCulUsuariosId;
    }

    public int getFkCulCursosId() {
        return fkCulCursosId;
    }

    public void setFkCulCursosId(int fkCulCursosId) {
        this.fkCulCursosId = fkCulCursosId;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public Date getDataDesativacao() {
        return dataDesativacao;
    }

    public void setDataDesativacao(Date dataDesativacao) {
        this.dataDesativacao = dataDesativacao;
    }

    @Override
    public String toString() {
        return "CursosAdquiridos{" +
                "pk_id=" + pk_id +
                ", fkCulUsuariosId=" + fkCulUsuariosId +
                ", fkCulCursosId=" + fkCulCursosId +
                ", dataCriacao=" + dataCriacao +
                ", dataModificacao=" + dataModificacao +
                ", dataDesativacao=" + dataDesativacao +
                '}';
    }
}
