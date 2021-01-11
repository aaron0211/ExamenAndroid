package DAO;

import interfaces.IDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Pelicula;
import model.Usuario;
import utils.ConnectionFactory;
import utils.MotorSQL;

public class UsuarioDAO 
        implements IDAO<Usuario, Integer>{
    private final String SQL_FINDALL
            = "SELECT * FROM `usuario` WHERE 1=1 ";
    private MotorSQL motorSql;
    
    public UsuarioDAO() {
        motorSql = ConnectionFactory.selectDb();
    }
    @Override
    public int add(Usuario bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(Integer Integer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Usuario> findAll(Usuario bean) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        String sql= SQL_FINDALL;
        try {
            //1º) 
            motorSql.connect();
            if (bean != null) {
                if (bean.getIdUsuario() != 0) {
                    sql += "AND ID_Usuario='" + bean.getIdUsuario() + "'";
                }
                if (bean.getNombre() != null) {
                    sql += "AND Nombre='" + bean.getNombre() + "'";
                }

                if (bean.getApellido() != null) {
                    sql += "AND Apellido ='" + bean.getApellido() + "'";
                }
                if (bean.getEmail() != null) {
                    sql += "AND Email='" + bean.getEmail() + "'";
                }
                if (bean.getPassword() != null) {
                    sql += "AND Password ='" + bean.getPassword() + "'";
                }
                if (bean.getFechaRegistro()!= null) {
                    sql += "AND Fecha_registro ='" + bean.
                            getFechaRegistro() + "'";
                }
                
            }

            System.out.println(sql);
            ResultSet rs = motorSql.
                    executeQuery(sql);

            while (rs.next()) {
                Usuario usuario = new Usuario();

                usuario.setIdUsuario(rs.getInt(1));
                usuario.setNombre(rs.getString(2));
                usuario.setApellido(rs.getString(3));
                usuario.setEmail(rs.getString(4));
                usuario.setPassword(rs.getString(5));
                usuario.setFechaRegistro(rs.getString(6));
              

                usuarios.add(usuario);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return usuarios;
    }

    @Override
    public int update(Usuario bean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void main(String[] args) {
        /*PRUEBAS UNITARIAS - TEST*/
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        //Findall - filtra segun campos que no son null o 0
        Usuario usuario = new Usuario();
            usuario.setEmail("prueba@gmail.com");
            usuario.setPassword("12345");
        ArrayList<Usuario> lstUsuarios
                = usuarioDAO.findAll(usuario);
        System.out.println(lstUsuarios.toString());
    }
}
