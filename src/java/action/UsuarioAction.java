/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import DAO.UsuarioDAO;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

/**
 *
 * @author aaron
 */
public class UsuarioAction implements interfaces.Action{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
                String cadDestino = "";
        String action = (String) request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");
        switch (arrayAction[1]) {
            case "LOGIN":
                cadDestino = login(request, response);
                break;
        }
        return cadDestino;
    }
    private String login(HttpServletRequest request, 
                                HttpServletResponse response) {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        ArrayList<Usuario> lstUsuarios;
        String action = (String) request.getParameter("ACTION");
        String user = request.getParameter("USER");
        String pass = request.getParameter("PASSWORD");
        String[] arrayAction = action.split("\\.");
        if(user!=null && pass!=null){
            Usuario usuario = new Usuario();
            usuario.setEmail(user);
            usuario.setPassword(pass);
            lstUsuarios = usuarioDao.findAll(usuario);
        }else{
            lstUsuarios = usuarioDao.findAll(null);
        }
        return Usuario.toArrayJSon(lstUsuarios);
    }    
}
