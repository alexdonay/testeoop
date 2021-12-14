package views;

import controllers.Aluno;
import controllers.DataBase;
import controllers.Pessoa;

import java.util.Date;
import java.util.Scanner;

public class Atualiza {
    Date hoje = new Date();
    DataBase dataBase = new DataBase();
    Scanner teclado = new Scanner(System.in);
    public void atualiza(){
        System.out.println("Digite 1 para atualizar cadastro de aluno ou 2 para atualizar cadastro de não aluno");
        int opcao = teclado.nextInt();
        switch(opcao){
            case 1:
                atualizaAluno();
                break;
            case 2:
                atualizaPessoa();
                break;
            default:
                throw new IllegalStateException("Valor inexperado: " + opcao);
        }
    }
    private void atualizaAluno(){
        int opcao;
        int id;
        System.out.println("Digite o ID do Aluno para Alterar");
        id = teclado.nextInt();
        System.out.println("Digite uma das opcoes para Atualizar");
        System.out.println("1 - Nome");
        System.out.println("2 - Data de Nascimento");
        System.out.println("3 - Telefone" );
        System.out.println("4 - Nota");
        System.out.println("5 - Torneo uma pessoa");
        opcao = teclado.nextInt();
        Aluno alunoTemp = dataBase.pesquisaAlunoID(id);
        switch (opcao){
            case 1:
                alunoTemp.setNome(teclado.nextLine());
                break;
            case 2:
                alunoTemp.setDataNascimento(teclado.next());
                break;
            case 3:
                alunoTemp.setTelefone(teclado.next());
            case 4:
                alunoTemp.setNota(teclado.nextDouble());
                break;
            case 5:
                Pessoa pessoatemp = (Pessoa)alunoTemp;
                pessoatemp.setId(dataBase.pessoaUltimo());
                dataBase.excluiAlunoID(id);
                dataBase.adicionaPessoa(pessoatemp);
                break;
            default:
                throw new IllegalStateException("valor inválido: " + opcao);
        }
        if(opcao != 5)
        dataBase.atualizaAluno(id, alunoTemp);
    }
    private void atualizaPessoa(){
        int opcao;
        int id;
        System.out.println("Digite o ID da Pessoa para Alterar");
        id = teclado.nextInt();
        System.out.println("Digite uma das opcoes para atualizar");
        System.out.println("1 - Nome");
        System.out.println("2 - Data de Nascimento");
        System.out.println("3 - Telefone" );
        System.out.println("4 - Torneo um Aluno");
        Pessoa pessoaTemp = dataBase.pesquisaPessoaID(id);
        opcao = teclado.nextInt();
        switch (opcao){
            case 1:
                pessoaTemp.setNome(teclado.nextLine());
                break;
            case 2:
                pessoaTemp.setDataNascimento(teclado.next());
                break;
            case 3:
                pessoaTemp.setTelefone(teclado.next());
            case 4:

                //Downcasting de forma primitiva
                Pessoa pessoaTemporaria = dataBase.pesquisaPessoaID(id);
                Aluno alunoTemporario = new Aluno(pessoaTemporaria.getNome(),
                        pessoaTemporaria.getTelefone(),
                        pessoaTemporaria.getDataNascimento(),
                        pessoaTemporaria.getDataAlteracao(),
                        pessoaTemporaria.getDataCadastro(hoje), 0.0D);
                System.out.println("Digite a nota do Aluno: ");
                alunoTemporario.setNota(teclado.nextDouble());
                dataBase.excluiPessoaID(id);
                dataBase.adicionaAluno(alunoTemporario);
                break;
            default:
                throw new IllegalStateException("valor inválido: " + opcao);
        }
        if(opcao != 4)
            dataBase.atualizaPessoa(id, pessoaTemp);
    }
}