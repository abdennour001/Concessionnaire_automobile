package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by AMOKRANE Abdennour on 15/05/2018.
 */
public class numeroController {

    @FXML
    Label numero;

    @FXML
    public void initialize(){
        numero.setText(Session.getSessionFocusedVoiture().getFournisseur().getNumeroTelephone());
    }

}
