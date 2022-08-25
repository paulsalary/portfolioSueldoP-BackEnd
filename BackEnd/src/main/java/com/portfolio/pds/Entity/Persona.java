
package com.portfolio.pds.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;
    private String nombre;
    private String apellido;
    @Size(min = 1, max = 5000, message = "no cumple con la longitud")
    private String img;
    private String acercaDe;
    
    public Persona() {
    }

    public Persona(String nombre, String apellido, String img, String acercaDe) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.acercaDe = acercaDe;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getImg() {
        return img;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
     public String getAcercaDe() {
        return acercaDe;
    }
     
     public void setAcercaDe(String acercaDe) {
        this.acercaDe = acercaDe;
    }
}
