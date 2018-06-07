package sample;

import java.util.Date;

/**
 * Created by AMOKRANE Abdennour on 21/05/2018.
 */
public class Compte {

    private String password;
    private Date date_debut;
    private Date date_fin;

    public Compte() {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }
}
