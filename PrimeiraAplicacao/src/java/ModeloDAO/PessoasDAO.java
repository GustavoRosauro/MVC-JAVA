/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import config.Connecttion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Pessoa;

/**
 *
 * @author Usuario
 */
public class PessoasDAO {
    Connecttion cn = new Connecttion();
    
    
    public List retornaPessoas()
    {
        ArrayList<Pessoa> list = new ArrayList<Pessoa>();
        String sql = "SELECT * FROM PESSOA";
        try {
           Connection conn = cn.Conexao();
          Statement statment = conn.createStatement();
          ResultSet result = statment.executeQuery(sql);
          while(result.next()){
          Pessoa p = new Pessoa();
          p.setId(result.getInt("Id"));
          p.setNome(result.getString("Nome"));
          list.add(p);
          }
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Erro no SQL", "Ocorreu um erro no banco de dados", JOptionPane.INFORMATION_MESSAGE);
        }
        return list;
    }
    public void InserirPessoa(String nome){
    String sql = "INSERT INTO PESSOA (NOME) VALUES ('"+nome+"')";
    try{
       Connection conn = cn.Conexao();
       PreparedStatement executa = conn.prepareStatement(sql);
       executa.executeUpdate();
    }catch(Exception e){
         JOptionPane.showMessageDialog(null, "Erro no SQL", "Ocorreu um erro no banco de dados", JOptionPane.INFORMATION_MESSAGE);
    }
    }
    public void DeletarPessoa(int id){
    String sql = "DELETE FROM PESSOA WHERE Id = "+id+"";
    try{
       Connection conn = cn.Conexao();
       PreparedStatement executa = conn.prepareStatement(sql);
       executa.executeUpdate();
    }catch(Exception e){
         JOptionPane.showMessageDialog(null, "Erro no SQL", "Ocorreu um erro no banco de dados", JOptionPane.INFORMATION_MESSAGE);
    }
    }
        public Pessoa PessoaId(int id)
    {
        Pessoa p = new Pessoa();
        String sql = "SELECT * FROM PESSOA WHERE Id = "+id+"";
        try{            
           Connection conn = cn.Conexao();
          Statement statment = conn.createStatement();
          ResultSet result = statment.executeQuery(sql);
          while(result.next()){          
          p.setId(result.getInt("Id"));
          p.setNome(result.getString("Nome"));         
          }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no SQL", "Ocorreu um erro no banco de dados", JOptionPane.INFORMATION_MESSAGE);
        }
        return p;
    }
        public void AtualizaPessoa(int id, String nome){
    String sql = "UPDATE PESSOA SET NOME = '"+nome+"' WHERE Id = "+id+"";
    try{
       Connection conn = cn.Conexao();
       PreparedStatement executa = conn.prepareStatement(sql);
       executa.executeUpdate();
    }catch(Exception e){
         JOptionPane.showMessageDialog(null, "Erro no SQL", "Ocorreu um erro no banco de dados", JOptionPane.INFORMATION_MESSAGE);
    }
    }

}
