/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author cotti
 */
public class CampoVazioException extends Exception {
    
    public CampoVazioException(String campo){
        super("O Campo '" + campo + "' não pode estar vazio.");
    }
    
}
