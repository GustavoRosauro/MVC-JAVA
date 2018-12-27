/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Connecttion {
    String dbUrl = "jdbc:mysql://localhost:3306/cadastro";
    String userName = "root";
    String password = "";
    public Connection Conexao()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn =  DriverManager.getConnection(dbUrl,userName,password);
              if (conn != null) {

        return conn;
        
    }
        } catch (SQLException ex) {
            Logger.getLogger(Connecttion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connecttion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
          
}
