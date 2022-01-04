package controllers;

import java.util.Date;

public class Aluno extends Pessoa{
    private Double nota;

    public Aluno(String nome, String telefone, String dataNascimento, Date dataCadastro, Date dataAlteracao, Double nota) {
        super(nome, telefone, dataNascimento, dataCadastro, dataAlteracao);
        this.nota = nota;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
}
