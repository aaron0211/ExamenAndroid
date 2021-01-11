/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import interfaces.IDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cine;
import utils.ConnectionFactory;
import utils.MotorSQL;

/**
 *
 * @author aaron
 */
public class CineDAO implements IDAO<Cine,Integer>{
    
    private final String SQL_FINDALL
            = "SELECT * FROM `cine` WHERE 1=1 ";
    private final String SQL_ADD
            = "INSERT INTO `cine` (`nombre`, `localidad`) VALUES ";
    private final String SQL_DELETE = "DELETE FROM `cine` WHERE id_cine=";
    private final String SQL_UPDATE = "UPDATE `cine` SET ";
    
    private MotorSQL motorSql;
    
    public CineDAO(){
        motorSql = ConnectionFactory.selectDb();
    }

    @Override
    public ArrayList<Cine> findAll(Cine bean) {
        ArrayList<Cine> cines = new ArrayList<>();
        String sql= SQL_FINDALL;
        try {
            //1º) 
            motorSql.connect();
            if (bean != null) {
                if (bean.getId_cine()!= 0) {
                    sql += "AND id_cine'" + bean.getId_cine() + "'";
                }
                if (bean.getNombre() != null) {
                    sql += "AND nombre LIKE ('%" + bean.getNombre() + "%')";
                }

                if (bean.getLocalidad() != null) {
                    sql += "AND localidad LIKE ('%" + bean.getLocalidad() + "%')";
                }                
            }

            System.out.println(sql);
            ResultSet rs = motorSql.
                    executeQuery(sql);

            while (rs.next()) {
                Cine cine = new Cine();

                cine.setId_cine(rs.getInt(1));
                cine.setNombre(rs.getString(2));
                cine.setLocalidad(rs.getString(3));          

                cines.add(cine);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return cines;
    }
    
    @Override
    public int add(Cine bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Integer Integer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Cine bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String[] args) {
        /*PRUEBAS UNITARIAS - TEST*/
        CineDAO cineDAO = new CineDAO();
        
        //Findall - filtra segun campos que no son null o 0
//        ArrayList lstPeliculas
//                = peliculaDAO.findAll(new Pelicula("Interstellar", null, null, null, 0, 500, 0, 0, null, null));
//        System.out.println(lstPeliculas.toString());
//
//        Pelicula peliprueba = new Pelicula("Joshua y los teleñecos", "www", "abc", "2015", 90, 5, 6, 9, 5.3, null);

//        //Add de registro
       // peliculaDAO.add(peliprueba);

//        //Update del registro con id pelicula 1
   //     peliculaDAO.update(new Pelicula("Titulo cambiado", null, null, null, 0, 0, 0, 1, null));

//        //Delete del registro 2
   //     peliculaDAO.delete(2);
    }
}
