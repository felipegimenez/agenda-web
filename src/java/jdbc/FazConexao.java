
package jdbc;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;


public class FazConexao {

    private static Connection conexao;
       
    public static Connection getConexao()
    {
        
        try 
        {
           Class.forName("com.mysql.jdbc.Driver");
           
           conexao = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda","root","root");
             
           System.out.println("CONECTOU!!!");
            
            
        } catch (Exception e) 
        {
            
            System.out.println("FALHA NA CONEXÃO!!!");
            
        }
        
        return conexao;
        
    }
}    

