/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmanager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author 00348046
 */
public class DBLogin extends Conexao {
    private String login;
    private String senha;
    private String status= "";

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
   public String getStatus(){
    return status;
 }   

    
    public void logar(){
        Conexao conexao = new Conexao();  
        Connection conn = conexao.conectar();

        String sql= "SELECT * FROM logar ";
        sql= sql+ "WHERE login='" + login + "'";
        sql= sql+ " and senha='" +  senha + "'";
        try{
            Statement st= conn.createStatement();
            ResultSet rs= st.executeQuery(sql);
            if(rs.next()){
                status="1";
                conn.close();
                //FrmClientes frm = new FrmClientes();  
                //frm.setVisible(true);
                System.out.println("Funcionou");
            } else {
                conn.close();
                status="2";     
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog (null, "Erro Logar usuário no Banco de Dados", "Mensagem",JOptionPane.INFORMATION_MESSAGE);   
        }
    }
   
    public void incluirLogin(){
        conectar();
        try{
            Conexao conexao = new Conexao();  
            Connection conn = conexao.conectar();       
            Statement st = conn.createStatement();
            String sql="insert into logar(login,senha) VALUES ('"+login + "','"+ senha+"')";
            st.executeUpdate(sql);
            status="0";
        }
        catch(Exception e){
            JOptionPane.showMessageDialog (null, "Erro no Banco de Dados: " + e.getMessage(), "Mensagem",JOptionPane.INFORMATION_MESSAGE);   
        }
    }
}
