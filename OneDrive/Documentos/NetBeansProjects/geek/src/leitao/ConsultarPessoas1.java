/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leitao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Emanu
 */
public class ConsultarPessoas1 {
    
    public static void main(String[] args) throws SQLException {
        
        Connection conexao = FabricaConexao.getConexao();
        String sql = "SELECT * FROM pessoas";
        
        Statement stmt = conexao.createStatement();
        ResultSet resultado =  stmt.executeQuery(sql);
        
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        
        while(resultado.next()){
            int codigo = resultado.getInt("codigo");
            String nome = resultado.getString("nome");
            pessoas.add(new Pessoa(codigo, nome));
            
        }
        for(Pessoa p : pessoas){
            System.out.println(p.getCodigo() + "=====>" + p.getNome());
        }
        stmt.close();
        conexao.close();
        
    }
    
}
