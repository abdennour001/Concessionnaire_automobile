package sample;

import java.util.ArrayList;

/**
 * Created by asus on 02/05/2018.
 */
public class Fournisseur {

    private int id;
    private String nom;
    private String prenom;
    private String ville;
    private String email;
    private String numeroTelephone;
    private ArrayList<Voiture> voituresList=new ArrayList<Voiture>();
    private int nombreOffre;

    public Fournisseur() {

    }

    public Fournisseur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public int getNombreOffre() {
        return nombreOffre;
    }

    public void setNombreOffre(int nombreOffre) {
        this.nombreOffre = nombreOffre;
    }
}
