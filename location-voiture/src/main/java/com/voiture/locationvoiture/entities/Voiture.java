package com.voiture.locationvoiture.entities;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Voiture {


    @Getter
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    @Column(name = "serie")
    private String serie;

    @Column(name = "date_mise_en_marche")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateMiseEnMarche;

    @Column(name = "modele")
    private String modele;

    @Column(name = "prix_jour")
    private float prixJour;

    @OneToMany(mappedBy = "voiture")
    private List<Location> location = new ArrayList<Location>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Date getDateMiseEnMarche() {
        return dateMiseEnMarche;
    }

    public void setDateMiseEnMarche(Date dateMiseEnMarche) {
        this.dateMiseEnMarche = dateMiseEnMarche;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public float getPrixJour() {
        return prixJour;
    }

    public void setPrixJour(float prixJour) {
        this.prixJour = prixJour;
    }

    public List<Location> getLocation() {
        return location;
    }

    public void setLocation(List<Location> location) {
        this.location = location;
    }
}
