package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by AMOKRANE Abdennour on 15/05/2018.
 */
public class emailController {

    @FXML
    Label email;

    @FXML
    public void initialize(){
        email.setText(Session.getSessionFocusedVoiture().getFournisseur().getEmail());
    }

}
