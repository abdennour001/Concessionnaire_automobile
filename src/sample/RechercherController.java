package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by asus on 01/05/2018.
 */
public class RechercherController {

    private Controller controller;

    @FXML
    public Label rechercheNumber;

    @FXML
    public Button rechercher;

    @FXML
    public ChoiceBox<String> categorie, marque, modele, carburant, prix, km;

    void initializeCategorieChoiceBox() {
        categorie.getItems().addAll("Berline",
                "Break",
                "Coupé",
                "4X4 & Crossover",
                "Voitures sociétés, commerciales",
                "Monospace",
                "Familiale",
                "Indifférent"
        );
        categorie.getSelectionModel().select("Indifférent");
        categorie.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
    }

    void initializeMarqueChoiceBox() {
        marque.getItems().addAll("Audi",
                "BMW",
                "Ford",
                "Kia",
                "Mercedes",
                "Renault",
                "Indifférent"
        );
        marque.getSelectionModel().select("Indifférent");
        marque.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
    }

    void initializeModeleChoiceBox() {
        modele.getItems().addAll(
                "Indifférent"
        );
        modele.getSelectionModel().select("Indifférent");
        modele.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
    }

    void initializeCarburantChoiceBox() {
        carburant.getItems().addAll(
                "Diesel",
                "Essence",
                "Electrique",
                "Hybrides",
                "Autre énergies",
                "Indifférent"
        );
        carburant.getSelectionModel().select("Indifférent");
        carburant.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
    }

    void initializePrixChoiceBox() {
        prix.getItems().addAll(
                "3000 $",
                "4500 $",
                "6000 $",
                "9000 $",
                "10 500 $",
                "12 000 $",
                "19 500 $",
                "30 000 $",
                "Indifférent"
        );
        prix.getSelectionModel().select("Indifférent");
        prix.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
    }

    void initializeKmChoiceBox() {
        km.getItems().addAll(
                "5000 km",
                "8000 km",
                "10 000 km",
                "15 000 km",
                "20 000 km",
                "30 000 km",
                "40 000 km",
                "50 000 km",
                "60 000 km",
                "70 000 km",
                "80 000 km",
                "90 000 km",
                "100 000 km",
                "150 000 km",
                "Indifférent"
        );
        km.getSelectionModel().select("Indifférent");
        km.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
    }

    @FXML
    public void recherche() {

    }

    @FXML
    public void initialize() {
        initializeCategorieChoiceBox();
        initializeMarqueChoiceBox();
        initializeModeleChoiceBox();
        initializeCarburantChoiceBox();
        initializePrixChoiceBox();
        initializeKmChoiceBox();

        try {
            ConnexionMySQL.connectToDataBase();
            Statement statement4=ConnexionMySQL.connection.createStatement();
            ResultSet resultSet4=statement4.executeQuery("SELECT count(*) from voiture");
            resultSet4.first();
            rechercheNumber.setText("Rechercher ("+resultSet4.getInt(1)+" annonces)");
            ConnexionMySQL.closeConnexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void init(Controller controller) {
        controller = controller;
    }
}
