/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leitao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Emanu
 */
public class ExcluirPessoa {
    
    public static void main(String[] args) throws SQLException {
        
        Scanner entrada = new Scanner(System.in);
        System.out.println("informe o codigo da pessoa");
        int codigo = entrada.nextInt();
        
        
        Connection  conexao = FabricaConexao.getConexao();
        String sql = "DELETE FROM pessoas  WHERE codigo = ? ";
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, codigo);
        
        if(stmt.executeUpdate() > 0){
            System.out.println("pessoa excluida com sucesso");
        }else{
            System.out.println("nada feito");
        }
        
        
        entrada.close();
    }
    
}
