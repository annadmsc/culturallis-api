package com.example.demo.FavoritosCurso.FavoritosCursoModel;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cul_cursos_favoritos")
public class FavoritoCurso {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pk_id;


    @Column(name = "fk_cul_cursos_id")
    private long fkCulCursosId;

    @Column(name = "fk_cul_usuarios_id")
    private long fkCulUsuariosId;

    @Column(name="data_criacao")
    private Date dataCriacao;


    private Date data_mudanca;

    private Date data_desativacao;


    public FavoritoCurso(long pk_id, long fk_cul_cursos_id, long fk_cul_usuarios_id, Date data_criacao, Date data_mudanca, Date data_desativacao) {
        this.pk_id = pk_id;
        this.fkCulCursosId = fk_cul_cursos_id;
        this.fkCulUsuariosId = fk_cul_usuarios_id;
        this.dataCriacao = data_criacao;
        this.data_mudanca = data_mudanca;
        this.data_desativacao = data_desativacao;
    }

    public FavoritoCurso(long fk_cul_cursos_id, long fk_cul_usuarios_id, Date data_criacao, Date data_mudanca, Date data_desativacao) {
        this.fkCulCursosId = fk_cul_cursos_id;
        this.fkCulUsuariosId = fk_cul_usuarios_id;
        this.dataCriacao = data_criacao;
        this.data_mudanca = data_mudanca;
        this.data_desativacao = data_desativacao;
    }

    public FavoritoCurso() {

    }

    public long getPk_id() {
        return pk_id;
    }

    public void setPk_id(long pk_id) {
        this.pk_id = pk_id;
    }

    public long getFk_cul_cursos_id() {
        return fkCulCursosId;
    }

    public void setFk_cul_cursos_id(long fk_cul_cursos_id) {
        this.fkCulCursosId = fk_cul_cursos_id;
    }

    public long getFk_cul_usuarios_id() {
        return fkCulUsuariosId;
    }

    public void setFk_cul_usuarios_id(long fk_cul_usuarios_id) {
        this.fkCulUsuariosId = fk_cul_usuarios_id;
    }

    public Date getData_criacao() {
        return dataCriacao;
    }

    public void setData_criacao(Date data_criacao) {
        this.dataCriacao = data_criacao;
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




}
