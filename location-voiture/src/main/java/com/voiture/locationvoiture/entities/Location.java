package com.voiture.locationvoiture.entities;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Location {

    @Id
    @GeneratedValue (strategy =  GenerationType.AUTO)
    private Long id;

    @Column(name = "date_debut")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDebut;

    @Column(name = "date_retour")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateRetour;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "voiture_id")
    private Voiture voiture;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }
}
