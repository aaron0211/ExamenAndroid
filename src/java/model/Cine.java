/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;

/**
 *
 * @author aaron
 */
public class Cine {
    private int id_cine;
    private String nombre, localidad;

    public Cine(int id_cine, String nombre, String localidad) {
        this.id_cine = id_cine;
        this.nombre = nombre;
        this.localidad = localidad;
    }
    
    public Cine(){
    }

    public int getId_cine() {
        return id_cine;
    }

    public void setId_cine(int id_cine) {
        this.id_cine = id_cine;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @Override
    public String toString() {
        return "Cine{" + "id_cine=" + id_cine + ", nombre=" + nombre + ", localidad=" + localidad + '}';
    }
    
    public static String toCadena(Cine cine) {
        return "Cine{" + 
                "nombre=" + cine.getNombre() + ", "
                + "localidad=" + cine.getLocalidad() + '}';
    }
    
    public static String 
        toArrayJSon(ArrayList<Cine> cines) {
            GsonBuilder builder = new GsonBuilder(); 
            builder.setPrettyPrinting();

            Gson gson = builder.create();
            String resp = gson.toJson(cines);
            
            return resp;
    }
        
    public static String toObjectJson(Cine cine){
        GsonBuilder builder = new GsonBuilder(); 
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String resp = gson.toJson(cine);
        return resp;
    }
}
