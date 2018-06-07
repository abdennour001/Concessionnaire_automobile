package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by AMOKRANE Abdennour on 15/05/2018.
 */
public class adresseController {

    @FXML
    Label adresse;

    @FXML
    public void initialize(){
        adresse.setText(Session.getSessionFocusedVoiture().getFournisseur().getVille());
    }
}
