package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.awt.*;
import java.awt.Image;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main extends Application {

    public static Stage stage;
    public static Stage exitStage;
    public static Dimension resolution= Toolkit.getDefaultToolkit().getScreenSize();
    public static final int MAX_X=(int)resolution.getWidth();
    public static final int MAX_Y=(int)resolution.getHeight() - 65;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("interface_principal.fxml"));
        primaryStage.setTitle("Concession des voitures [Client] - version 1.0");
        javafx.scene.image.Image icon=new javafx.scene.image.Image(getClass().getResource("../icon.png").toURI().toString());
        stage.getIcons().add(icon);
        primaryStage.setScene(new Scene(root, MAX_X, MAX_Y));
        stage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                exitStage=new Stage();
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("exit.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                exitStage.setTitle("Confirmation");
                javafx.scene.image.Image icon= null;
                try {
                    icon = new javafx.scene.image.Image(getClass().getResource("../icon.png").toURI().toString());
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
                exitStage.getIcons().add(icon);
                exitStage.setScene(new Scene(root));
                exitStage.initStyle(StageStyle.DECORATED);
                exitStage.show();
                try {
                    stage.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
