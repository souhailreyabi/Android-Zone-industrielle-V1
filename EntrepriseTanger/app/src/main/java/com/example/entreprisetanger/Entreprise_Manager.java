package com.example.entreprisetanger;

public class Entreprise_Manager {
    private String nom,adresse,domaine,zone,telephone,latitude,longitude;
    private int id;

    public Entreprise_Manager() {
    }

    public Entreprise_Manager(String nom, String adresse, String domaine, String zone, String telephone, String latitude, String longitude) {
        this.nom = nom;
        this.adresse = adresse;
        this.domaine = domaine;
        this.zone = zone;
        this.telephone = telephone;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Entreprise_Manager(String nom, String adresse, String domaine, String zone, String telephone, String latitude, String longitude, int id) {
        this.nom = nom;
        this.adresse = adresse;
        this.domaine = domaine;
        this.zone = zone;
        this.telephone = telephone;
        this.latitude = latitude;
        this.longitude = longitude;
        this.id = id;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Entreprise{" +
                "nom='" + nom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", domaine='" + domaine + '\'' +
                ", zone='" + zone + '\'' +
                ", telephone='" + telephone + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", id=" + id +
                '}';
    }
}
