package sample;

/**
 * Created by AMOKRANE Abdennour on 15/05/2018.
 */
public class Moteur {

    private int id;
    private String carburant;
    private String nomMoteur;
    private String puissance;

    public Moteur() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomMoteur() {
        return nomMoteur;
    }

    public void setNomMoteur(String nomMoteur) {
        this.nomMoteur = nomMoteur;
    }

    public String getPuissance() {
        return puissance;
    }

    public void setPuissance(String puissance) {
        this.puissance = puissance;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }
}
