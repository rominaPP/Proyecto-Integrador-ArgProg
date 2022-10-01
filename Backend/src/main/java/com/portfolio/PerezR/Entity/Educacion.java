package com.portfolio.PerezR.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nombreEdu;
    
    private String descripEdu;
    
    private String inicioEdu;
    
    private String finEdu;

    //Constructor
    
    public Educacion() {
    }

    public Educacion(String nombreEdu, String descripEdu, String inicioEdu, String finEdu) {
        this.nombreEdu = nombreEdu;
        this.descripEdu = descripEdu;
        this.inicioEdu = inicioEdu;
        this.finEdu = finEdu;
    }
    
    //Getter and Setter

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
