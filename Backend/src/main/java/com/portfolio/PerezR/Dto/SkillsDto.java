package com.portfolio.PerezR.Dto;


public class SkillsDto {
     
    private String nombreHyS;
    
    private int porcentaje;
    
    //Constructor

    public SkillsDto() {
    }

    public SkillsDto(String nombreHyS, int porcentaje) {
        this.nombreHyS = nombreHyS;
        this.porcentaje = porcentaje;
    }
    
    //Getter and Setter

    public String getNombreHyS() {
        return nombreHyS;
    }

    public void setNombreHyS(String nombreHyS) {
        this.nombreHyS = nombreHyS;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    
}
