/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rcf.aula;

import java.util.Scanner;

/**
 *
 * @author 00348046
 */
public class Salario {
    
    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome: ");
        String nome = sc.nextLine();
        System.out.print("Digite o Salario Atual: ");
        float salAtual = sc.nextFloat();
        float aumento = aumentoSalario(salAtual);
        imprime("Salario Bruto Atual............:", salAtual);
        imprime("INSS sob o Salario Atual.......:",
        calculaINSS(salAtual));
        imprime("IR sob o Salario Atual.........:",
        calculaIR(salAtual));
        imprime("Salario Liquido Atual..........:", salAtual -
        calculaINSS(salAtual) - calculaIR(salAtual));
        imprime("Salario Bruto com Aumento......:", aumento);
        imprime("INSS sob o Salario com Aumento.:",
        calculaINSS(aumento));
        imprime("IR sob o Salario com Aumento...:",
        calculaIR(aumento));
        imprime("Salario Liquido com Aumento....:", aumento -
        calculaINSS(aumento) - calculaIR(aumento));
    }
    */
    
    public void imprime(String texto, float valor){
        System.out.printf(texto+" %.2f\n",valor);
    }
    
    public float aumentoSalario(float salAtual){
        float perc = 0f;
        if(salAtual <= 1600){
            perc = 0.20f;
        }
        else if(salAtual > 1600 && salAtual <= 3000){
            perc = 0.15f;
        }
        else{
            perc = 0.10f;
        }
        return salAtual + perc * salAtual;
    }
    
    public float calculaINSS(float salario){
        return (salario / 100) * 10;
    }
    
    public float calculaIR(float salario){
        float imposto = 0.0f;
        if(salario >= 3000){
            imposto = (salario / 100) * 12;
        }
        return imposto;
    }
}
