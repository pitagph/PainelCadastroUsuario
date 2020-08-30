/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import DAO.CadastroDAO;
import classe.Usuario;

/**
 *
 * @author PhillipeNoteTec
 */
public class cadastrocontrole {
    CadastroDAO cdao = new CadastroDAO();
    
    public boolean cadastrar(Usuario usuario){
        return cdao.cadastrar(usuario);
    }
    
}
