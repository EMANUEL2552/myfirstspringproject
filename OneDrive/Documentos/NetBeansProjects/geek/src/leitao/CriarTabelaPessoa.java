/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leitao;


import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

/**
 *
 * @author Emanu
 */
public class CriarTabelaPessoa {
    
    public static void main(String[] args)  throws SQLException{
        Connection conexao = FabricaConexao.getConexao();
        
    String sql = "CREATE TABLE pessoas ("
            + "codigo INT AUTO_INCREMENT PRIMARY KEY,"
            + "nome VARCHAR(80) NOT NULL"
            + ")";
    
    
    Statement stmt = conexao.createStatement();
    stmt.execute(sql);
    
    
    System.out.println("tabela criada");
    
    conexao.close();
    }
    
    
    
}
