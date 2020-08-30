/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author PhillipeNoteTec
 */
public class ConexaoDAO {
  
    public Connection getConnection() throws ClassNotFoundException, SQLException, IOException {
        Class<?> forName = Class.forName("com.mysql.jdbc.Driver");
        Properties pro = new Properties();
        try (InputStream in = getClass().getClassLoader().getResourceAsStream("propriedades/config.properties")) {
            pro.load(in);
        }
        String URL = pro.getProperty("url");
        String USUARIO = pro.getProperty("usuario");
        String SENHA = pro.getProperty("senha");
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    
       }
    
    public Connection con;
    public Statement stmt = null;
    public ResultSet rs   = null;
    
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://192.168.2.102:3306/BancoTeste";
    String user = "root";
    String pass = "root";
    
       public void abrirConexao(){
    
        try {
             Class.forName(driver);
             con = DriverManager.getConnection(url, user, pass);
             stmt = con.createStatement();
     
        
        
        
        } catch (Exception e) {
            
            System.err.println("Erro: "+ e);
            
            
        } 
    
   
    }
    
    
public void fecharconexao(Connection con) {
       if (con != null) {
        try {
            con.close();
        } catch (SQLException ex) {
            System.err.println("Erro: "+ ex);
        }
   
       }
       
   }
   
   
   public void fecharconexao(Connection con, PreparedStatement stmt) {
       if (stmt != null) {
        try {
            stmt.close();
        } catch (SQLException ex) {
            System.err.println("Erro: "+ ex);
        }
            fecharconexao(con);
       }
       
       
    }
       
  public  void fecharconexao(Connection con, PreparedStatement stmt, ResultSet rs) {
    
        
        if (rs != null) {
        try {
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Erro: "+ ex);
        }
            fecharconexao(con, stmt);
       }
         
   }
       
    
}
