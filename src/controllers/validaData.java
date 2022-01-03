package controllers;

public class validaData {
    public boolean valida(String dataNascimento) {
        int dia, mes, ano;
        String separador = "/";
        try{
            dia = Integer.parseInt(dataNascimento.substring(0,2));
            mes = Integer.parseInt(dataNascimento.substring(3,5));
            ano = Integer.parseInt(dataNascimento.substring(6,10));
        }catch (Exception e){
            System.out.println("Data inválida");
            return false;
        }
        boolean validaDia;
        boolean validaSeparador1 = (dataNascimento.substring(2,3).equalsIgnoreCase(separador));
        boolean validaSeparador2 = (dataNascimento.substring(5,6).equalsIgnoreCase(separador));
        boolean validaTamanhoTotal = (dataNascimento.length()==10);

        switch (mes) {
            case 1,3,5,7,8,10,12:
                validaDia = dia <= 31;
                break;
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
                validaDia = false;
        }
        if(validaDia&validaSeparador1&validaSeparador2&validaTamanhoTotal){
            return true;
        }else{
            System.out.println("Data Inválida");
            return false;
        }
    }
    public boolean bisexto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }
}
