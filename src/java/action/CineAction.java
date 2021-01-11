/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import DAO.CineDAO;
import DAO.PeliculaDAO;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cine;
import model.Pelicula;

/**
 *
 * @author aaron
 */
public class CineAction implements interfaces.Action{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String cadDestino = "";
        String action = (String) request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");
        switch (arrayAction[1]) {
            case "FIND_ALL":
                cadDestino = findAll(request, response);
                break;
        }
        return cadDestino;
    }
    
    private String findAll(HttpServletRequest request, 
                                HttpServletResponse response) {
        CineDAO cineDao = new CineDAO();
        ArrayList<Cine> lstCines = null;
        String action = (String) request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");
        String filtro = request.getParameter("FILTRO");
        Cine cine = new Cine();
        if(filtro!=null){
            String[] arrayFiltro = filtro.split("\\.");
            switch(arrayFiltro[0]){
                case "NOMBRE":
                    cine.setNombre(arrayFiltro[1]);
                    lstCines = cineDao.findAll(cine);
                    break;
                case "LOCALIDAD":
                    cine.setLocalidad(arrayFiltro[1]);
                    lstCines = cineDao.findAll(cine);
                    break;
            }
        }else{
            lstCines = cineDao.findAll(null);
        }
        return Cine.toArrayJSon(lstCines);
    }
}
