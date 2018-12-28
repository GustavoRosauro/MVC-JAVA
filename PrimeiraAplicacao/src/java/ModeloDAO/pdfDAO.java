/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import config.Connecttion;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Usuario
 */
public class pdfDAO {
    Connecttion cn = new Connecttion();
    public void InserirPDF(int id_pessoa, InputStream arquivo) throws Exception{
    String sql = "INSERT INTO ARQUIVO (ID_PESSOA,PDF) VALUES (?,?)";
    try{
    Connection conn = cn.Conexao();
    PreparedStatement executa = conn.prepareStatement(sql);
     executa.setInt(1, id_pessoa);
     executa.setBlob(2, arquivo);
    executa.executeUpdate();
    }
    catch(Exception e){
        throw new Exception(e.getMessage());
    }
    }
    public InputStream MostraPDF(int id) throws Exception{
        String sql = "SELECT PDF FROM ARQUIVO WHERE ID_PESSOA = "+id+" AND ID = (SELECT MAX(ID) FROM ARQUIVO )";
        try{
            Connection conn = cn.Conexao();
            PreparedStatement executa = conn.prepareStatement(sql);
            ResultSet rs = executa.executeQuery();  
            if(rs.next()){
                //save blob as an image
                //String id = rs.getString(1);
                //String name = rs.getString(2);
                InputStream is  = rs.getBinaryStream(1);
                return is;
            }
    }catch(Exception e){
        throw new Exception(e.getMessage());
    }   return null;
}
}
