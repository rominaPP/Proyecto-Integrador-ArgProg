package com.portfolio.PerezR.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nombrePro;
    
    private String descripPro;
    
    private String inicioPro;
    
    //Constructor

    public Proyecto() {
    }

    public Proyecto(String nombrePro, String descripPro, String inicioPro) {
        this.nombrePro = nombrePro;
        this.descripPro = descripPro;
        this.inicioPro = inicioPro;
    }
    
    //Getter and Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
