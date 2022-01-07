package views;

import controllers.Aluno;
import controllers.Pessoa;
import controllers.DataBase;
import controllers.validaData;
import java.util.Date;
import java.util.Scanner;

public class Cadastra {
    String nome;
    String dataNascimento;
    String telefone;
    String opNota;
    Double nota;
    final Scanner teclado = new Scanner(System.in);
    final DataBase dataBase = new DataBase();
    final Date hoje = new Date();
    final validaData validaData = new validaData();
    public void pedeDados(){
        boolean continua = true;
        while(continua){
            System.out.println("Digite nome do Aluno ou Pessoa:");
            nome = teclado.nextLine();
            do{
                System.out.println("Digite a data de nascimento do Aluno ou Pessoa (dd/mm/aaaa):");
                dataNascimento = teclado.next();
                if(!validaData.valida(dataNascimento)){
                    System.out.println("Data inválida");
                }
            }while (!validaData.valida(dataNascimento));
            System.out.println("Digite o número de telefone:");
            telefone = teclado.next();
            System.out.println("Digite a nota, caso seja um aluno ou N para Pessoa");
            opNota = teclado.next();
            if (opNota.equalsIgnoreCase("n")){
                Pessoa pessoa = new Pessoa(nome, telefone, dataNascimento, hoje, hoje);
                dataBase.adicionaPessoa(pessoa);
            }else{
                nota = Double.parseDouble(opNota);
                while(nota>10||nota<0){
                    System.out.println("A nota não pode ser menor que Zero ou maior que 10");
                    System.out.println("Digite uma nota válida");
                    opNota = teclado.next();
                    nota = Double.parseDouble(opNota);
                }
                Aluno aluno = new Aluno(nome, telefone, dataNascimento, hoje, hoje, nota);
                dataBase.adicionaAluno(aluno);
            }
            continua = false;
        }
    }
}