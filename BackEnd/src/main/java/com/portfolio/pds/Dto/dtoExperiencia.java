package com.portfolio.pds.Dto;

import javax.validation.constraints.NotBlank;

public class dtoExperiencia {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    @NotBlank
    private String urlE;
    @NotBlank
    private String aniosE;
    
    //Constructores

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String descripcionE,String urlE, String aniosE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.urlE = urlE;
        this.aniosE = aniosE;
    }
    //Getters & Setters

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }
    
    public String getUrlE() {
        return urlE;
    }

    public void setUrlE(String urlE) {
        this.urlE = urlE;
    }
    
    public String getAniosE() {
        return aniosE;
    }

    public void setAniosE(String aniosE) {
        this.aniosE = aniosE;
    }
  
}