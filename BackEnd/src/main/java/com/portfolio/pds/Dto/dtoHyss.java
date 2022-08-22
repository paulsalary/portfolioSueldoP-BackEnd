package com.portfolio.pds.Dto;

import javax.validation.constraints.NotBlank;

public class dtoHyss {
    @NotBlank
    private String nombreH;
    @NotBlank
    private String descripcionE;
    
    //Constructores

    public dtoHyss() {
    }

    public dtoHyss(String nombreH, String descripcionE) {
        this.nombreH = nombreH;
        this.descripcionE = descripcionE;
    }
    //Getters & Setters

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
    
}
