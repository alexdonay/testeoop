package database;

import controllers.Aluno;
import controllers.Pessoa;

//Simula o armazenamento de dados utilizando singleton
import java.util.ArrayList;

public class Db {
      private static volatile Db instance = null;
      public ArrayList<Aluno> alunos = new ArrayList<>(); //tabela alunos
      public ArrayList<Pessoa> pessoas = new ArrayList<>(); // tabela não alunos
      private Db(){}
      public static synchronized Db getInstance(){
            if(instance==null){
                  instance = new Db();
            }
            return instance;
      }

}
