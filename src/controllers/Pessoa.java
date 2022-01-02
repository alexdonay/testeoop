package controllers;

import java.util.Date;

public class Pessoa {

    private int id;
    private tipoPessoa tipo;
    public enum tipoPessoa {ALUNO, PESSOA}
    private String nome;
    private String telefone;
    private String dataNascimento;
    final private Date dataCadastro;
    private Date dataAlteracao;

    public Pessoa(String nome, String telefone, String dataNascimento, Date dataCadastro, Date dataAlteracao) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = dataCadastro;
        this.dataAlteracao = dataAlteracao;
        this.telefone = telefone;
    }


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(tipoPessoa tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
}
