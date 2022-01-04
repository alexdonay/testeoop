package views;

import controllers.Pessoa;
import controllers.Aluno;
import controllers.DataBase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ExibeDados {
    final DataBase dataBase = new DataBase();
    final SimpleDateFormat formatter =  new  SimpleDateFormat ( "dd/MM/yyyy" );
    public void exibeDadosAluno(){
        ArrayList<Aluno> dadosAluno;
        dadosAluno = dataBase.listaAluno();
        System.out.format("+----+-------------+----------+--------------+-------------+------------+-------+%n");
        System.out.format("|                              Cadastros de Alunos                              |%n");
        System.out.format("+----+-------------+----------+--------------+-------------+------------+-------+%n");
        System.out.format("| ID |     Nome    | Dt Nasc. |   Telefone   | Dt Cadastro |Dt Alteracao| Nota  |%n");
        System.out.format("+----+-------------+----------+--------------+-------------+------------+-------+%n");

        for(Aluno i:dadosAluno){
            int tamanhoNome = i.getNome().length();
            int tamanhoTelefone = i.getTelefone().length();
            int tamanhoDataNascimento = i.getDataNascimento().length();
            if(tamanhoNome >= 11){
                tamanhoNome = 11;
            }

            if (tamanhoTelefone >= 11) {
                tamanhoTelefone = 11;
            }

            System.out.format("| %-2s | %-11s |%-10s| %-12s | %-11s | %-10s |  %-4s |%n",
                    i.getId(),
                    i.getNome().substring(0,tamanhoNome),
                    i.getDataNascimento().substring(0,tamanhoDataNascimento),
                    i.getTelefone().substring(0,tamanhoTelefone),
                    formatter.format(i.getDataCadastro()),
                    formatter.format(i.getDataAlteracao()),
                    i.getNota());
            System.out.format("+----+-------------+----------+--------------+-------------+------------+-------+%n");
        }
    }

    public void exibeDadosPessoa(){
        ArrayList<Pessoa> dadosPessoa;
        dadosPessoa = dataBase.listaPessoa();
        System.out.format("+----+-------------+----------+--------------+-------------+------------+%n");
        System.out.format("|                            Cadastros de Pessoas                       |%n");
        System.out.format("+----+-------------+----------+--------------+-------------+------------+%n");
        System.out.format("| ID |     Nome    | Dt Nasc. |   Telefone   | Dt Cadastro |Dt Alteracao|%n");
        System.out.format("+----+-------------+----------+--------------+-------------+------------+%n");

        for(Pessoa i:dadosPessoa){
            int tamanhoDataNascimento = i.getDataNascimento().length();
            int tamanhoNome = i.getNome().length();
            int tamanhoTelefone = i.getTelefone().length();
            if(tamanhoNome >= 11){
                tamanhoNome = 11;
            }

            if (tamanhoTelefone >= 11) {
                tamanhoTelefone = 11;
            }

            System.out.format("| %-2s | %-11s |%-10s| %-12s | %-11s | %-10s |%n",
                    i.getId(),
                    i.getNome().substring(0,tamanhoNome),
                    i.getDataNascimento().substring(0,tamanhoDataNascimento),
                    i.getTelefone().substring(0,tamanhoTelefone),
                    formatter.format(i.getDataCadastro()),
                    formatter.format(i.getDataAlteracao()));
            System.out.format("+----+-------------+----------+--------------+-------------+------------+%n");
        }
    }
}
