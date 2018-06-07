package sample;

/**
 * Created by AMOKRANE Abdennour on 15/05/2018.
 */
public class TypeVoiture {

    private int id;
    private String nomType;
    private Modele modele;

    public TypeVoiture() {

    }

    public String getNomType() {
        return nomType;
    }

    public void setNomType(String nomType) {
        this.nomType = nomType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }
}
