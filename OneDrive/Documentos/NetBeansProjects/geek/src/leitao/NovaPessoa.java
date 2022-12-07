/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leitao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;
import leitao.FabricaConexao;


/**
 *
 * @author Emanu
 */
public class NovaPessoa {
    
    public static void main(String[] args)throws SQLException { 
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("informe o nome ");
        String nome = entrada.nextLine();
        
        Connection conexao = FabricaConexao.getConexao();
        
        String sql=  "INSERT INTO pessoas (nome ) VALUES ( ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, nome);
        stmt.execute();
        
        System.out.println("pessoa incluida com sucesso");
        
        entrada.close();
        
    }
    
}
