package com.portfolio.PerezR.Dto;


public class ProyectoDto {
    
    private String nombrePro;
    
    private String descripPro;
    
    private String inicioPro;
    
    //Constructor

    public ProyectoDto() {
    }

    public ProyectoDto(String nombrePro, String descripPro, String inicioPro) {
        this.nombrePro = nombrePro;
        this.descripPro = descripPro;
        this.inicioPro = inicioPro;
    }
     
    //Getter and Setter
    
    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public String getDescripPro() {
        return descripPro;
    }

    public void setDescripPro(String descripPro) {
        this.descripPro = descripPro;
    }

    public String getInicioPro() {
        return inicioPro;
    }

    public void setInicioPro(String inicioPro) {
        this.inicioPro = inicioPro;
    }

}
