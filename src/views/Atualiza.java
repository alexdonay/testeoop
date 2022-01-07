package views;

import controllers.Aluno;
import controllers.DataBase;
import controllers.Pessoa;
import controllers.validaData;

import java.util.Date;
import java.util.Scanner;

public class Atualiza {
    final Date hoje = new Date();
    final DataBase dataBase = new DataBase();
    final Scanner teclado = new Scanner(System.in);
    int opcao;
    int id;
      public void atualiza(){
          boolean valida = false;
          while (!valida){
              try  {
                  System.out.println("Digite 1 para atualizar cadastro de aluno ou 2 para atualizar cadastro de não aluno");
                  opcao = teclado.nextInt();
                  switch (opcao) {
                      case 1 -> {
                          atualizaAluno();
                          valida= true;
                      }
                      case 2 -> {
                          atualizaPessoa();
                          valida = true;
                      }
                      default -> throw new IllegalStateException("Valor inexperado: " + opcao);
                  }
              }catch (Exception e){
                  System.out.println("Valor inexperado");
                  teclado.nextLine();

              }
          }
    }

    private void atualizaAluno(){
          boolean valida = false;
          Aluno alunoTemp = null;
        try{
          while (!valida){
              System.out.println("Digite o ID do Aluno para Alterar");
              teclado.nextLine();
              id = teclado.nextInt();
              valida = true;
              alunoTemp = dataBase.pesquisaAlunoID(id);
          }
          try  {
              System.out.println("Digite uma das opcoes para Atualizar");
              System.out.println("1 - Nome");
              System.out.println("2 - Data de Nascimento");
              System.out.println("3 - Telefone" );
              System.out.println("4 - Nota");
              System.out.println("5 - Torneo uma pessoa");
              opcao = teclado.nextInt();
          }catch(Exception e){
              System.out.println("valor Inválido");
          }


           alunoTemp.setDataAlteracao(hoje);
            switch (opcao) {
                case 1 -> {
                    System.out.println("Digite o novo nome: ");
                    teclado.nextLine();
                    alunoTemp.setNome(teclado.nextLine());

                }
                case 2 -> {
                    do{
                        System.out.println("Digite a nova data de Nascimento ");
                        String data = teclado.next();
                        validaData validaData = new validaData();
                        if(validaData.valida(data)){
                            alunoTemp.setDataNascimento(data);
                            valida = true;
                        }else{
                            System.out.println("Data inválida");
                            valida = false;
                        }
                    }while(!valida);
                }
                case 3 -> {
                    System.out.println("Digite o novo telefone ");
                    alunoTemp.setTelefone(teclado.next());
                }
                case 4 -> {
                    double nota;
                    valida = false;
                    while (!valida){
                        System.out.println("Digite a nova nota ");
                        try{
                            nota = teclado.nextDouble();
                            if(nota>=0&&nota<=10){
                                alunoTemp.setNota(nota);
                                valida = true;
                            }else{
                                System.out.println("O valor da nota de ser entre 0 e 10");
                            }

                        }catch (Exception e){
                            System.out.println("valor inválido");
                            teclado.nextLine();
                        }
                    }
                }
                case 5 -> {
                    dataBase.excluiAlunoID(id);
                    dataBase.adicionaPessoa(alunoTemp);
                }
                default -> throw new IllegalStateException("valor inválido: " + opcao);
            }
            if(opcao != 5)
                dataBase.atualizaAluno(id, alunoTemp);
        }catch (Exception e){
            System.out.println("Valor Inválido");
        }

    }

    private void atualizaPessoa(){
          try{
              System.out.println("Digite o ID da Pessoa para Alterar");
              id = teclado.nextInt();
              System.out.println("Digite uma das opcoes para atualizar");
              System.out.println("1 - Nome");
              System.out.println("2 - Data de Nascimento");
              System.out.println("3 - Telefone" );
              System.out.println("4 - Torneo um Aluno");
              Pessoa pessoaTemp = dataBase.pesquisaPessoaID(id);

              opcao = teclado.nextInt();
              teclado.nextLine();
              switch (opcao) {
                  case 1 -> {
                      System.out.println("Digite o novo nome");
                      pessoaTemp.setNome(teclado.nextLine());
                  }
                  case 2 -> {
                      boolean valida = false;
                      try  {
                      while(!valida) {
                          System.out.println("Digite a nova data de Nascimento ");
                          String data = teclado.next();
                          validaData validaData = new validaData();
                          if(validaData.valida(data)){
                              valida = true;
                              System.out.println("Data de nascimento atualizada com sucesso");
                              pessoaTemp.setDataNascimento(data);
                          }
                      }
                      }catch (Exception e){
                          System.out.println("Data Inválida");
                      }
                  }
                  case 3 -> {
                      System.out.println("Digite o novo telefone");
                      pessoaTemp.setTelefone(teclado.next());
                  }
                  case 4 -> {
                      //Downcasting forçada
                      Pessoa pessoaTemporaria = dataBase.pesquisaPessoaID(id);
                      Aluno alunoTemporario = new Aluno(pessoaTemporaria.getNome(),
                              pessoaTemporaria.getTelefone(),
                              pessoaTemporaria.getDataNascimento(),
                              hoje,
                              pessoaTemporaria.getDataCadastro(), 0.0D);
                      System.out.println("Digite a nota do Aluno: ");
                      alunoTemporario.setNota(teclado.nextDouble());
                      dataBase.excluiPessoaID(id);
                      dataBase.adicionaAluno(alunoTemporario);
                  }
                  default -> throw new IllegalStateException("valor inválido: " + opcao);
              }
              if(opcao != 4)
                  dataBase.atualizaPessoa(id, pessoaTemp);
          }catch (Exception e){
              System.out.println("Pessoa não encontrada");
          }

    }
}