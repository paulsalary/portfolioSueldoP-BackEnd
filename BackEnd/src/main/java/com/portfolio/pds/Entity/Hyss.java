package com.portfolio.pds.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hyss {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreH;
    private String descripcionE;
    private String iconoH;
    
    //Constructores

    public Hyss() {
    }

    public Hyss(String nombreH, String descripcionE, String iconoH ) {
        this.nombreH = nombreH;
        this.descripcionE = descripcionE;
        this.iconoH = iconoH;
    }
    
    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreH() {
        return nombreH;
    }

    public void setNombreH(String nombreH) {
        this.nombreH = nombreH;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
     public String getIconoH() {
        return iconoH;
    }

    public void setIconoH(String iconoH) {
        this.iconoH = iconoH;
    }
}