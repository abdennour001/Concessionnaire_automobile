package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.text.SimpleDateFormat;

/**
 * Created by AMOKRANE Abdennour on 16/05/2018.
 */
public class BienvenueController {

    @FXML
    public Label bienvenue;

    @FXML
    public void initialize() {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        if (SignUpController.fournisseur != null) {
            bienvenue.setText("Bienvenue "+ SignUpController.fournisseur.getNom() + " " +
                    SignUpController.fournisseur.getPrenom() +
                    ", vous êtes maintenant un fournisseur dans notre sociéte"
            + "\n\n" + "Votre abonnement sera expiré le : " + formatter.format(SignUpController.compte.getDate_fin()));
        }
    }
}
