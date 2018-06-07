package sample;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 * Created by asus on 01/05/2018.
 */
public class SignOutController {

    public static boolean confirm=false;

    public void oui(ActionEvent actionEvent) {
        confirm = true;
        Node source = (Node)  actionEvent.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void annuler(ActionEvent actionEvent) {
        confirm = false;
        Node  source = (Node)  actionEvent.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
