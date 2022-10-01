package com.portfolio.PerezR.Dto;


public class EducacionDto {
    
    private String nombreEdu;
    
    private String descripEdu;
    
    private String inicioEdu;
    
    private String finEdu;
    
    //Constructor

    public EducacionDto() {
    }

    public EducacionDto(String nombreEdu, String descripEdu, String inicioEdu, String finEdu) {
        this.nombreEdu = nombreEdu;
        this.descripEdu = descripEdu;
        this.inicioEdu = inicioEdu;
        this.finEdu = finEdu;
    }
    
    //Getter and Setter

    public String getNombreEdu() {
        return nombreEdu;
    }

    public void setNombreEdu(String nombreEdu) {
        this.nombreEdu = nombreEdu;
    }

    public String getDescripEdu() {
        return descripEdu;
    }

    public void setDescripEdu(String descripEdu) {
        this.descripEdu = descripEdu;
    }

    public String getInicioEdu() {
        return inicioEdu;
    }

    public void setInicioEdu(String inicioEdu) {
        this.inicioEdu = inicioEdu;
    }

    public String getFinEdu() {
        return finEdu;
    }

    public void setFinEdu(String finEdu) {
        this.finEdu = finEdu;
    }
}
