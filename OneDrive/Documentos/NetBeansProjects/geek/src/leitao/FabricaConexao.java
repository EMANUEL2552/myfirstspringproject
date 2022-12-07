/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leitao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Emanu
 */
public class FabricaConexao {
    
    public static Connection getConexao(){
        
        try{
        
         final String url = "jdbc:mysql://localhost:3306/curso_java";
         final String usuario = "root";
         final String senha = "1234567";
         
         return DriverManager.getConnection(url, usuario, senha);
         
        }catch(SQLException e){
         throw new RuntimeException(e);
        }
        
    }    
        
    
      private static Properties getProperties() throws IOException{
          Properties prop = new Properties();
          String caminho = "/conexao.properties";
          prop.load(FabricaConexao.class.getResourceAsStream(caminho));
          return prop;
          
      }
    
        
    
    
}
