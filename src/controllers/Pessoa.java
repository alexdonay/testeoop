package controllers;

import java.util.Date;

/*
* Propriedades de Pessoa
* ID
* nome
* telefone
* data de nascimento
* data de cadastro da pessoa
* data da ultima alteracao
 */
public class Pessoa {

    //Atributos de Pessoa
    private int id;
    public enum tipoPessoa {ALUNO, PESSOA};
    private tipoPessoa tipo;
    private String nome;
    private String telefone;
    private String dataNascimento; //futuramente utilizar o DATE como tipo
    private Date dataCadastro;
    private Date dataAlteracao;

    //Construtor de Pessoa
    public Pessoa(int id, String nome, String dataNascimento, Date dataCadastro, Date dataAlteracao, tipoPessoa tipo, String telefone) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = dataCadastro;
        this.dataAlteracao = dataAlteracao;
        this.telefone = telefone;
        this.tipo = tipo;
    }
    public Pessoa(String nome, String telefone, String dataNascimento, Date dataCadastro, Date dataAlteracao) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = dataCadastro;
        this.dataAlteracao = dataAlteracao;
        this.telefone = telefone;

    }
    public Pessoa(){

    }

    //Geters e Seters da Classe Pessoa
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
    public tipoPessoa getTipo() {
        return tipo;
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
    public Date getDataCadastro(Date hoje) {
        return dataCadastro;
    }
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    public Date getDataAlteracao() {
        return dataAlteracao;
    }
    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
}
