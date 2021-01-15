package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;



public class Pelicula {
    private String titulo, trailer, sinopsis, fechaEstreno, url, fecha, hora, cine, localidad;
    private int idGenero, nVotos, sPuntuacion, id;
    private Double precio;

    public Pelicula(String titulo, String trailer, String sinopsis, String fechaEstreno, String url, int idGenero, int nVotos, int sPuntuacion, int id, Double precio) {
        this.titulo = titulo;
        this.trailer = trailer;
        this.sinopsis = sinopsis;
        this.fechaEstreno = fechaEstreno;
        this.url = url;
        this.idGenero = idGenero;
        this.nVotos = nVotos;
        this.sPuntuacion = sPuntuacion;
        this.id = id;
        this.precio = precio;
    }

    public Pelicula() {
    }

    //GETTERS & SETTERS
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getTrailer() {
        return trailer;
    }
    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }
    public String getSinopsis() {
        return sinopsis;
    }
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    public String getFechaEstreno() {
        return fechaEstreno;
    }
    public void setFechaEstreno(String fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }
    public int getidGenero() {
        return idGenero;
    }
    public void setidGenero(int idGenero) {
        this.idGenero = idGenero;
    }
    public int getnVotos() {
        return nVotos;
    }
    public void setnVotos(int nVotos) {
        this.nVotos = nVotos;
    }
    public int getsPuntuacion() {
        return sPuntuacion;
    }
    public void setsPuntuacion(int sPuntuacion) {
        this.sPuntuacion = sPuntuacion;
    }
    public int getId() {
        return id;
    }
    public void setId(int idPelicula) {
        this.id = idPelicula;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getCine() {
        return cine;
    }

    public void setCine(String cine) {
        this.cine = cine;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }
    
    
    
    @Override
    public String toString() {
        return "Pelicula{" + "titulo=" + titulo + ", trailer=" + trailer + ", sinopsis=" + sinopsis + ", fechaEstreno=" + fechaEstreno + ", idGenero=" + idGenero + ", nVotos=" + nVotos + ", sPuntuacion=" + sPuntuacion + ", id=" + id + ", precio=" + precio + '}';
    }
    
    public static String toCadena(Pelicula pelicula) {
        return "Pelicula{" + 
                "titulo=" + pelicula.getTitulo() + ", "
                + "trailer=" + pelicula.getTrailer() + ","
                + " sinopsis=" + pelicula.getSinopsis() + ", "
                + "fechaEstreno=" + pelicula.getFechaEstreno() + ", "
                + "idGenero=" + pelicula.getidGenero() + 
                ", nVotos=" + pelicula.getnVotos() + ", sPuntuacion=" 
                + pelicula.getnVotos() + ", id=" + pelicula.getId() + ", precio=" + pelicula.getPrecio() + '}';
    }
    
    public static String 
        toArrayJSon(ArrayList<Pelicula> peliculas) {
            GsonBuilder builder = new GsonBuilder(); 
            builder.setPrettyPrinting();

            Gson gson = builder.create();
            String resp = gson.toJson(peliculas);
            
            return resp;
    }
        
    public static String toObjectJson(Pelicula pelicula){
        GsonBuilder builder = new GsonBuilder(); 
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        String resp = gson.toJson(pelicula);
        return resp;
    }    
}
