package controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class validaData {
    public boolean valida(String dataNascimento) {
        int dia, mes, ano;
        try{
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate = LocalDate.parse(dataNascimento,formato);
            dia = localDate.getDayOfYear();
            mes = localDate.getDayOfMonth();
            ano = localDate.getYear();
        }catch (Exception e){
            return false;
        }
        boolean validaDia;
        switch (mes) {
            case 4,6,9,11:
                validaDia = dia <= 30;
                break;
            case 2:
                if(bisexto(ano)){
                    validaDia = dia <= 29;
                }else{
                    validaDia = dia <= 28;
                }
                break;
            default:
                validaDia = dia <= 31;
        }
        return  validaDia;
        }

    public boolean bisexto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }
}
