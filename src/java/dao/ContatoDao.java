
package dao;


import java.io.Serializable;
import java.sql.PreparedStatement;
import jdbc.FazConexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.ContatoModelo;

public class ContatoDao implements Serializable  {
    
    
    PreparedStatement pst;
    ResultSet rs;
    String sql;
    Connection conexao;
    
        
   
    public void salvar(ContatoModelo c )
    {
        
       sql = ("insert into contato(nome,telefone,email) values (?,?,?)");
  
        try {
                Connection conecta = FazConexao.getConexao(); //Abre uma coneção com Banco de Dados 

            pst = conecta.prepareStatement(sql);          // Passa a string SQL para para esta váriavel. 

            pst.setString(1, c.getNome());                // Pega o valor dititado no campo "NOME" e passa p/ string "SQL".
            pst.setString(2, c.getTelefone());            // Pega o valor dititado no campo "TELEFONE" e passa p/ string "SQL".
            pst.setString(3, c.getEmail());               // Pega o valor dititado no campo "EMAIL" e passa p/ string "SQL".

            pst.executeUpdate();                          // Executa a string "SQL", cadastrando o contado no banco.   
            FazConexao.getConexao().close();              // Fecha a conexão.

            System.out.println("SALVOU!!!");

        } catch (Exception e) 
        {
           System.out.println("NÃO SALVOU !!!!   " + e);

        }
     }
     
    public List busca(){
       
       sql = ("select * from contato");
      
       List<ContatoModelo> list = new ArrayList<>();               
        
        try {
            
            conexao = FazConexao.getConexao();
            pst =  conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while (rs.next()){
            
              ContatoModelo cont = new ContatoModelo();
              cont.setId(rs.getInt("id"));
              cont.setNome(rs.getString("nome"));
              cont.setTelefone(rs.getString("telefone"));
              cont.setEmail(rs.getString("email"));
              list.add(cont);
              
            }  
            
            FazConexao.getConexao().close();
            
        } catch (Exception e) {
            
            System.out.println("ERRO NA CONSULTA NA LISTA!!!");
        }
        
        
        
        return list;
    }
    
    
    public void excluir(ContatoModelo c){
        
        sql = ("delete from contato where id = ?");
        
        try {
            
            conexao =  FazConexao.getConexao();
            pst = conexao.prepareStatement(sql);
            
            pst.setInt(1,c.getId());
            pst.executeUpdate();
            FazConexao.getConexao().close();
            
            
            System.out.println("EXCLUIU!!!"); 
            
            
        } catch (Exception e) {
            
            System.out.println("NÃO EXCLUIU!!!" + e);
        }
     }
    
    public void editar(ContatoModelo c){
    
      sql = ("UPDATE contato SET nome=?, telefone=?, email=? where id=?");
      
        try {
            
            conexao = FazConexao.getConexao();
            pst = conexao.prepareStatement(sql);
            
            pst.setInt(4,c.getId());
            pst.setString(1, c.getNome());
            pst.setString(2, c.getTelefone());
            pst.setString(3, c.getEmail());
            pst.executeUpdate();
                        
            FazConexao.getConexao().close();
            
            System.out.println("CONTATO ATUALIZADO!!!");
                            
            
        } catch (Exception e) {
   
            System.out.println("CONTATO NÃO FOI ATUALIZADO!!!"+e);
            
        }
    
    }
}

 
    

