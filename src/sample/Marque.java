package sample;

/**
 * Created by AMOKRANE Abdennour on 15/05/2018.
 */
public class Marque {

    private int id;
    private String nomMarque;
    private TypeVoiture type;

    public Marque() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomMarque() {
        return nomMarque;
    }

    public void setNomMarque(String nomMarque) {
        this.nomMarque = nomMarque;
    }

    public TypeVoiture getType() {
        return type;
    }

    public void setType(TypeVoiture type) {
        this.type = type;
    }
}
