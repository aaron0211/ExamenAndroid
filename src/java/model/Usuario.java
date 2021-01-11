
package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;


public class Usuario {
    //Atributos:
    // ID_Usuario	
    // Nombre	
    // Apellido	
    // Email	
    // Password	
    // Fecha_registro
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String fechaRegistro;
    


    public Usuario() {
    }

    public Usuario(int idUsuario, String nombre, String apellido, String email, String password, String fechaRegistro) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", password=" + password + ", fechaRegistro=" + fechaRegistro + '}';
    }
    
    public static String 
        toArrayJSon(ArrayList<Usuario> usuarios) {
            GsonBuilder builder = new GsonBuilder(); 
            builder.setPrettyPrinting();

            Gson gson = builder.create();
            String resp = gson.toJson(usuarios);
            
            return resp;
    }
}
