package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilJava {


    public String quebraTraco (String campo, String posicao) {
        String antes = null;
        int pos = campo.indexOf("-");
        if (posicao.equals("Antes")) {
            antes = campo.substring(0 , pos);
        } else {
            antes = campo.substring(pos + 1);
        }
        return antes;
    }

    public String formatData (String campo) {
        if(campo != null) {
            SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date(campo.substring(0, 9).replaceAll("-", "/"));
            return sdt.format(date);
        } else {
            return "19/12/1992";
        }
    }

    public int gerarNr (int vlrPiso, int vlrTeto){
        int valorPiso = 0;
        int valorTeto = vlrTeto + 1;
        int vetor[] = new int[20];
        boolean Salvar = false;
        while (valorPiso <= vlrPiso && valorTeto >= vlrTeto) {
            for (int i = 0; i < 20; i++) {
                valorPiso = 1 + (int) (Math.random() * vlrTeto);
                Salvar = true;
                for (int y = 0; y <= i; y++) {
                    if (vetor[y] == valorPiso) {
                        Salvar = false;
                        i--;
                    }
                }
                if (Salvar) {
                    vetor[i] = valorPiso;
                }
            }
        }
        return valorPiso;
    }

    public String formatVlr(String vlr){
        return vlr.replaceAll("[\\s.]","").replaceAll(",",".");
    }

    public String formatData2 (String campo) {
        try {
            if (campo != null) {
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                df.setLenient(false);
                Date d = null;
                d = df.parse(campo);
                df = new SimpleDateFormat("yyyy-MM-dd");
                return df.format(d);
            } else {
                return getDate("yyyy-MM-dd");
            }
        } catch (ParseException e){
            return getDate("yyyy-MM-dd");
        }
    }

    public String getDate(String formatDate){
        Calendar hoje = Calendar.getInstance();
        SimpleDateFormat formato = new SimpleDateFormat(formatDate);
        Date date = new Date(hoje.getTimeInMillis());
        return formato.format(date);
    }
    
    public String adicionarStringAntesDoUnderline(String texto, String valor) {
       int indiceUnderline = texto.indexOf('_');
       if (indiceUnderline != -1) {
           return texto.substring(0, indiceUnderline) + valor + texto.substring(indiceUnderline);
       } else {
           return texto;
       }
   }

    public String getDateDMais1Util(String formatDate){
        Calendar hoje = Calendar.getInstance();
        SimpleDateFormat formato = new SimpleDateFormat(formatDate);
        SimpleDateFormat semana = new SimpleDateFormat("EEEEEEEEEEEEEEE");
        if(semana.format(new Date(hoje.getTimeInMillis())).equals("sexta-feira") ||
                semana.format(new Date(hoje.getTimeInMillis())).equals("sábado")){
            hoje.add(Calendar.DATE, 3);
        } else if (semana.format(new Date(hoje.getTimeInMillis())).equals("domingo")) {
            hoje.add(Calendar.DATE, 2);
        } else {
            hoje.add(Calendar.DATE, 1);
        }
        Date date = new Date(hoje.getTimeInMillis());
        return formato.format(date);
    }

    private String calcDigVerif(String num) {
        Integer primDig, segDig;
        int soma = 0, peso = 10;
        for (int i = 0; i < num.length(); i++)
            soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;

        if (soma % 11 == 0 | soma % 11 == 1)
            primDig = 0;
        else
            primDig = 11 - (soma % 11);

        soma = 0;
        peso = 11;
        for (int i = 0; i < num.length(); i++)
            soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;

        soma += primDig.intValue() * 2;
        if (soma % 11 == 0 | soma % 11 == 1)
            segDig = 0;
        else
            segDig = 11 - (soma % 11);

        return primDig.toString() + segDig.toString();
    }

    public String geraCPF() {
        String iniciais = "";
        Integer numero;
        for (int i = 0; i < 9; i++) {
            numero = (int) (Math.random() * 10);
            iniciais += numero.toString();
        }
        return iniciais + calcDigVerif(iniciais);
    }

    public boolean validaCPF(String cpf) {
        if (cpf.isEmpty() || cpf.equals(""))
            return false;
        if (cpf.length() != 11)
            return false;

        String numDig = cpf.substring(0, 9);
        return calcDigVerif(numDig).equals(cpf.substring(9, 11));
    }
    
    public boolean validaCPF_v2(String cpf) {
        // Remove caracteres não numéricos do CPF
    	cpf = cpf.replaceAll("[^\\d]", "");

        // Verifica se o CPF possui 11 dígitos
    	if (cpf.length() != 11) {
            return false;
        }

        // Calcula o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Integer.parseInt(cpf.substring(i, i + 1)) * (10 - i);
        }
        int digito1 = 11 - (soma % 11);
        if (digito1 > 9) {
            digito1 = 0;
        }

        // Calcula o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Integer.parseInt(cpf.substring(i, i + 1)) * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        if (digito2 > 9) {
            digito2 = 0;
        }

        // Verifica se os dígitos verificadores estão corretos
        return cpf.substring(9).equals(Integer.toString(digito1) + Integer.toString(digito2));
    
    }
}
