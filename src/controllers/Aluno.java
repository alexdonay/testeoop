package controllers;

import java.util.Date;

/*
* Nota do aluno
 */
public class Aluno extends Pessoa{

    //Atributos de Aluno;
    private Double nota;

    //Construtores de Aluno
    public Aluno(int id, String nome, String dataNascimento, Date dataCadastro, Date dataAlteracao, Pessoa.tipoPessoa tipo, String telefone) {
        super(id, nome, dataNascimento, dataCadastro, dataAlteracao, tipo, telefone);
    }

    public Aluno(String nome, String telefone, String dataNascimento, Date dataCadastro, Date dataAlteracao, Double nota) {
        super(nome, telefone, dataNascimento, dataCadastro, dataAlteracao);
        this.nota = nota;
    }

    public Aluno(){}

    //Get and Seters de Aluno
    public Double getNota() {
        return nota;
    }
    public void setNota(Double nota) {
        this.nota = nota;
    }
}
