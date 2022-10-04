package com.portfolio.PerezR.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nombreExp;
    
    private String descripExp;
    
    private String inicioExp;
    
    private String finExp;
    
    //Constructor

    public Experiencia() {
    }

    public Experiencia(String nombreExp, String descripExp, String inicioExp, String finExp) {
        this.nombreExp = nombreExp;
        this.descripExp = descripExp;
        this.inicioExp = inicioExp;
        this.finExp = finExp;
    }
    
    //Getter and Setter

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
