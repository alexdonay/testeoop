package views;

import controllers.Aluno;
import controllers.Pessoa;
import controllers.DataBase;

import java.util.Date;
import java.util.Scanner;

public class PedeDados {
    //Variaveis
    String nome;
    String dataNascimento;
    String telefone;
    String opNota;//String para definir a nota
    Double nota;
    //Instancia objetos
    Scanner teclado = new Scanner(System.in);
    DataBase dataBase = new DataBase();
    Date hoje = new Date();

     public void pedeDados(){

        boolean continua = true;

        while(continua){
            System.out.println("Digite nome do Aluno/Pessoa:");
            nome = teclado.nextLine();
            System.out.println("Digite a data de nascimento do Aluno/Pessoa (dd/mm/aaaa):");
            dataNascimento = teclado.next();
            System.out.println("Digite o número de telefone:");
            telefone = teclado.next();
            System.out.println("Digite a nota, caso seja um aluno ou N para Pessoa");
            opNota = teclado.next();

            if (opNota.equalsIgnoreCase("n")){
                Pessoa pessoa = new Pessoa(nome, telefone, dataNascimento, hoje, hoje);
                dataBase.adicionaPessoa(pessoa);
            }else{
                nota = Double.parseDouble(opNota);
                Aluno aluno = new Aluno(nome, telefone, dataNascimento, hoje, hoje, nota);
                dataBase.adicionaAluno(aluno);
            }
            continua = false;
        }
    }
}
