package com.portfolio.PerezR.Dto;


public class ExperienciaDto {
     
    private String nombreExp;
    
    private String descripExp;
    
    private String inicioExp;
    
    private String finExp;
    
    //Constructor
    
    public ExperienciaDto() {
    }

    public ExperienciaDto(String nombreExp, String descripExp, String inicioExp, String finExp) {
        this.nombreExp = nombreExp;
        this.descripExp = descripExp;
        this.inicioExp = inicioExp;
        this.finExp = finExp;
    }
        
    //Getter and Setter

    public String getNombreExp() {
        return nombreExp;
    }

    public void setNombreExp(String nombreExp) {
        this.nombreExp = nombreExp;
    }

    public String getDescripExp() {
        return descripExp;
    }

    public void setDescripExp(String descripExp) {
        this.descripExp = descripExp;
    }

    public String getInicioExp() {
        return inicioExp;
    }

    public void setInicioExp(String inicioExp) {
        this.inicioExp = inicioExp;
    }

    public String getFinExp() {
        return finExp;
    }

    public void setFinExp(String finExp) {
        this.finExp = finExp;
    }
    
    
}
