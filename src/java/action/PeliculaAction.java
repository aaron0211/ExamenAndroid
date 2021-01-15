/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import DAO.PeliculaDAO;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pelicula;

/**
 *
 * @author aaron
 */
public class PeliculaAction implements interfaces.Action{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String cadDestino = "";
        String action = (String) request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");
        switch (arrayAction[1]) {
            case "FIND_ALL":
                cadDestino = findAll(request, response);
                break;
            case "CINE":
                cadDestino = findPelisCine(request, response);
                break;
            case "PELICULA":
                cadDestino = findCinesPeli(request, response);
                break;
        }
        return cadDestino;
    }
    private String findAll(HttpServletRequest request, 
                                HttpServletResponse response) {
        ArrayList<Pelicula> lstPeliculas = null;
        String action = (String) request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");
        String filtro = request.getParameter("FILTRO");
        PeliculaDAO peliculaDao = new PeliculaDAO();
        Pelicula peli = new Pelicula();
        if(filtro!=null){
            String[] arrayFiltro = filtro.split("\\.");
            switch(arrayFiltro[0]){
                case "TITULO":
                    String titulo = request.getParameter("TITULO");
                    peli.setTitulo(titulo);
                    lstPeliculas = peliculaDao.findAll(peli);
                    break;
                case "SINOPSIS":
                    String sinopsis = request.getParameter("SINOPSIS");
                    peli.setSinopsis(sinopsis);
                    lstPeliculas = peliculaDao.findAll(peli);
                    break;
                case "GENERO":
                    String genero = request.getParameter("GENERO");
                    lstPeliculas = peliculaDao.obtenerGenero(genero);
                    break;
                case "TOP10":
                    lstPeliculas = peliculaDao.top10();
            }
        }else{
            lstPeliculas = peliculaDao.findAll(null);
        }
        return Pelicula.toArrayJSon(lstPeliculas);
    }
    
    private String findPelisCine(HttpServletRequest request,
                                    HttpServletResponse response){
        ArrayList<Pelicula> lstPeliculas = null;
        PeliculaDAO peliculaDao = new PeliculaDAO();
        String action = (String) request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");
        String cine = request.getParameter("CINE");
        lstPeliculas = peliculaDao.obtenerPeliCine(cine);
        return Pelicula.toArrayJSon(lstPeliculas);
    }
    
    private String findCinesPeli(HttpServletRequest request,
                                HttpServletResponse response){
        PeliculaDAO peliculaDao = new PeliculaDAO();
        ArrayList<Pelicula> lstCines = null;
        String action = request.getParameter("ACTION");
        String [] arrayAction = action.split("\\.");
        String titulo = request.getParameter("TITULO");
        lstCines = peliculaDao.obtenerCinePeli(titulo);
        return Pelicula.toArrayJSon(lstCines);
    }
}
