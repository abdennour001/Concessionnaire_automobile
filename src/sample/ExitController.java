package sample;

import javafx.event.ActionEvent;

/**
 * Created by asus on 01/05/2018.
 */
public class ExitController {
    public void oui(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void annuler(ActionEvent actionEvent) {
        Main.exitStage.close();
    }
}
