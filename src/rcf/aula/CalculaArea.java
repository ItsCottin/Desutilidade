/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rcf.aula;

/**
 *
 * @author 00348046
 */
public class CalculaArea {
    
    public int area(int x){
        return x * x;
    }
    
    public int area(int x, int y){
        return x * y;
    }
    
    public double area(double raio){
        return Math.PI * raio;
    }
    
    // Minha sugestão de método
    public float area(float raio){
        return ((float)Math.PI) * raio;
    }
}
