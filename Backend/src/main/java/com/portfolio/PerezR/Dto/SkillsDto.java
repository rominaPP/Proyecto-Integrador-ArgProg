package com.portfolio.PerezR.Dto;


public class SkillsDto {
     
    private String nombreHyS;
    
    private String porcentaje;
    
    //Constructor

    public SkillsDto() {
    }

    public SkillsDto(String nombreHyS, String porcentaje) {
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

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }
    
}
