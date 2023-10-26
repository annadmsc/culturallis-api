package com.example.demo.Usuarios.UsuariosModel;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cul_usuarios")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id")
    private long pkId;

    private long fk_cul_generos_id;

    private String nomeUsuario;

    private String senha;

    private String nomeCompleto;

    private String urlFoto;

    private String telefone;

    private String bio;

    private String cpf;

    private String email;

    private Date dataNasc;

    private Date dataCriacao;

    private Date dataMudanca;

    @Column(name = "data_desativacao")
    private Date dataDesativacao;

    public Usuarios(long fk_cul_generos_id, String nomeUsuario, String nomeCompleto, String senha, String urlFoto,
            String telefone, String bio, String cpf, String email, Date dataNasc) {
        this.fk_cul_generos_id = fk_cul_generos_id;
        this.nomeUsuario = nomeUsuario;
        this.nomeCompleto = nomeCompleto;
        this.urlFoto = urlFoto;
        this.telefone = telefone;
        this.bio = bio;
        this.email = email;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.senha = senha;
    }

    public Usuarios(Long pkId, Long fk_cul_generos_id, String nomeUsuario, String nomeCompleto, String urlFoto,
            String telefone, String bio, String cpf, String email, Date dataNasc, Date dataCriacao, Date dataMudanca,
            Date dataDesativacao, String senha) {
        this.pkId = pkId;
        this.fk_cul_generos_id = fk_cul_generos_id;
        this.nomeUsuario = nomeUsuario;
        this.nomeCompleto = nomeCompleto;
        this.urlFoto = urlFoto;
        this.telefone = telefone;
        this.bio = bio;
        this.email = email;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.dataCriacao = dataCriacao;
        this.dataMudanca = dataMudanca;
        this.dataDesativacao = dataDesativacao;
        this.senha = senha;
    }

    public Usuarios(Long fk_cul_generos_id, String nomeUsuario, String nomeCompleto, String urlFoto,
            String telefone, String bio, String cpf, String email, Date dataNasc,
            Date dataCriacao, Date dataMudanca, Date dataDesativacao, String senha) {
        this.fk_cul_generos_id = fk_cul_generos_id;
        this.nomeUsuario = nomeUsuario;
        this.nomeCompleto = nomeCompleto;
        this.urlFoto = urlFoto;
        this.telefone = telefone;
        this.bio = bio;
        this.email = email;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.dataCriacao = dataCriacao;
        this.dataMudanca = dataMudanca;
        this.dataDesativacao = dataDesativacao;
        this.senha = senha;
    }

    public Usuarios() {

    }

    public void setpkId(long pkId) {
        this.pkId = pkId;
    }

    public Long getpkId() {
        return pkId;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public long getfk_cul_generos_id() {
        return fk_cul_generos_id;
    }

    public void setfk_cul_generos_id(long fk_cul_generos_id) {
        this.fk_cul_generos_id = fk_cul_generos_id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getBio() {
        return bio;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataMudanca() {
        return dataMudanca;
    }

    public void setDataMudanca(Date dataMudanca) {
        this.dataMudanca = dataMudanca;
    }

    public Date getDataDesativacao() {
        return dataDesativacao;
    }

    public void setDataDesativacao(Date dataDesativacao) {
        this.dataDesativacao = dataDesativacao;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "pkId=" + pkId +
                ", fk_cul_generos_id=" + fk_cul_generos_id +
                ", nomeUsuario='" + nomeUsuario + '\'' +
                ", senha='" + senha + '\'' +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", urlFoto='" + urlFoto + '\'' +
                ", telefone='" + telefone + '\'' +
                ", bio='" + bio + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", dataNasc=" + dataNasc +
                ", dataCriacao=" + dataCriacao +
                ", dataMudanca=" + dataMudanca +
                ", dataDesativacao=" + dataDesativacao +
                '}';
    }
}
