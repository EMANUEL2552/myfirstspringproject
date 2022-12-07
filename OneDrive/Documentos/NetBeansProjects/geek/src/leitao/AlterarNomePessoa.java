/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leitao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Emanu
 */
public class AlterarNomePessoa {
    
    public static void main(String[] args)  throws SQLException{
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("informe o codigo da pessoa");
        int codigo = entrada.nextInt();
        String select = "SELECT codigo,nome FROM pessoas WHERE codigo =?";
        String update = "UPDATE pessoas SET nome = ? WHERE codigo = ? ";
        Connection conexao = FabricaConexao.getConexao();
        PreparedStatement stmt = conexao.prepareStatement(select);
        stmt.setInt(1, codigo);
        ResultSet r = stmt.executeQuery();
        if(r.next()){
            Pessoa p = new Pessoa(r.getInt(1), r.getString(2));
            
            System.out.println("o nome atual e "+ p.getNome() );
            entrada.nextLine();
             System.out.println("informe o novo nome ");
             String novoNome = entrada.nextLine();
             
             
            stmt.close();
            stmt = conexao.prepareStatement(update);
            stmt.setString(1, novoNome);
            stmt.setInt(2, codigo);
            stmt.execute();
            
            System.out.println("pessoa alterada com sucesso");
            
             
            
        }else{
            System.out.println("pessoa nao encontrada");
        }
                
                
      conexao.close();
      entrada.close();
    }
    
}
