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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entradaDeDados = new Scanner(System.in);
        System.out.println("Digite um número: ");
        int numero1 = entradaDeDados.nextInt();
        System.out.println("Digite outro número: ");
        int numero2 = entradaDeDados.nextInt();
        CalculaArea calcula = new CalculaArea();
        int quadrado = calcula.area(numero1);
        int retangulo = calcula.area(numero1, numero2);
        double circulo = calcula.area(numero1);
        System.out.println("\nArea quadrado: " + quadrado);
        System.out.println("\nArea retangulo: " + retangulo);
        System.out.println("\nArea circulo: " + circulo);
    }
    
}
