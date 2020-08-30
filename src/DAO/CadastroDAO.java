/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import classe.Usuario;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PhillipeNoteTec
 */
public class CadastroDAO {
    
    private final static String ADICIONAR = "INSERT INTO conta (login, senha, nome, email) values (?,?,?,?)";
    
    public boolean cadastrar (Usuario user) {
        
    Usuario u = new Usuario();
    Connection con = null;
    PreparedStatement stmt = null;
       
        try {
            con = new ConexaoDAO().getConnection();
            stmt = (PreparedStatement) con.prepareStatement(ADICIONAR);
            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getSenha());
            stmt.setString(3, user.getNome());
            stmt.setString(4, user.getEmail());
            stmt.execute();
            return true;
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
           
            return false;
         }
    
}
