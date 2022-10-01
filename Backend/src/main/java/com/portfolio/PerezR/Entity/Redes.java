package com.portfolio.PerezR.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Redes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nombreR;
    
    private String img;
    
    private String link;
    
    //Constructor

    public Redes() {
    }
     
    public Redes(String nombreR, String img, String link) {
        this.nombreR = nombreR;
        this.img = img;
        this.link = link;
    }
    
    //Getter and Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreR() {
        return nombreR;
    }

    public void setNombreR(String nombreR) {
        this.nombreR = nombreR;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    
}
