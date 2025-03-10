package co.edu.unac.integradorI.colegio;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Miguel
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Administrador implements Serializable {

    public String nombre;
    public Long id;
    public Integer grado;
    public Long telefono;
    public String contra;
    public static List<Administrador> usuarios = new ArrayList<>();

    public static void main(String[] args) {
       
    }

    public Administrador(String nombre,Long id,Integer grado, Long telefono, String contra ) {
        this.contra= contra;
        this.grado= grado;
        this.nombre= nombre;
        this.telefono= telefono;
        
    }

  
        

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGrado() {
        return grado;
    }

    public void setGrado(Integer grado) {
        this.grado = grado;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getContra() {
        return contra;
    }
}
