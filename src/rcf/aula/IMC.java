/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rcf.aula;

import java.util.Scanner;

/**
 *
 * @author cotti
 */


public class IMC {
    
    /**/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome: ");
        String nome = sc.nextLine();
        System.out.print("Digite sua altura: ");
        float altura = sc.nextFloat();
        System.out.print("Digite seu peso: ");
        float peso = sc.nextFloat();
        imprime("Seu nome é............: ", nome);
        imprime("Seu peso é............: ", peso);
        imprime("Sua altura é..........: ", altura);
        imprime("Seu IMC é.............: ", calculaIMC(peso, altura));
        imprime("A análise do seu IMC é: ", analiseIMC(calculaIMC(peso, altura)));
    }
    /**/
        
    public static void imprime(String texto, Object valor){
        if(valor instanceof Float){
            System.out.printf(texto + "%.2f\n", valor);
        } else {
            System.out.printf(texto + valor + "\n");
        }        
    }
    
    public static float calculaIMC(float peso, float altura){
        return peso / (altura * altura);
    }
    
    public static String analiseIMC(float imc){
        String analise = "";
        if(imc <= 18.5f){
            analise = "Abaixo do peso";
        }
        else if(imc >= 18.6f && imc <= 24.9f){
            analise = "Peso ideal (parabéns)";
        }
        else if(imc >= 25f && imc <= 29.9f){
            analise = "Levemente acima do peso";
        }
        else if(imc >= 30f && imc <= 34.9f){
            analise = "Obesidade grau I";
        }
        else if(imc >= 35f && imc <= 39.9f){
            analise = "Obesidade grau II (severa)";
        }
        else if(imc >= 40f){
            analise = "Obesidade";
        }
        return analise;
    }
}
