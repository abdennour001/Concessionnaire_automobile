package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by asus on 02/05/2018.
 */
public class SignInController {

    public static Fournisseur fournisseur=null;

    @FXML
    private TextField email;

    @FXML
    private PasswordField password;

    @FXML
    private Button signInButton;

    public String Semail, Spassword;
    public boolean Bemail=false, Bpassword=false;

    // onAction
    @FXML
    public void signIn(ActionEvent  actionEvent) {

        Semail = email.getText();
        Spassword = password.getText();

        String inputPassword="";

        ArrayList<String> Lemail=new ArrayList<String>();
        ArrayList<String> Lid=new ArrayList<String>();

        try {
            ConnexionMySQL.connectToDataBase();
            Statement statement=ConnexionMySQL.connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT id_fournisseur, email from fournisseur");
            resultSet.first();
            resultSet.previous();
            while (resultSet.next()){
                Lemail.add(resultSet.getString(2));
                Lid.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(Semail.equals("") || !Semail.contains("@") || !Lemail.contains(Semail)) {
            try {
                Stage stage = new Stage();
                Parent root = null;
                root = FXMLLoader.load(getClass().getResource("invalide.fxml"));
                stage.setTitle("Vérification de l'email");
                javafx.scene.image.Image icon=new javafx.scene.image.Image(getClass().getResource("../icon.png").toURI().toString());
                stage.getIcons().add(icon);
                stage.setScene(new Scene(root));
                stage.initStyle(StageStyle.DECORATED);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            Bemail=false;
            try {
                ConnexionMySQL.closeConnexion();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return;
        } else {
            try {
                Statement statement=ConnexionMySQL.connection.createStatement();
                ResultSet resultSet=statement.executeQuery("SELECT password_compte from compte where id_fournisseur = "+ Lid.get(Lemail.indexOf(Semail)));
                resultSet.first();
                inputPassword = resultSet.getString(1);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Bemail=true;
        }

        if(Spassword.equals("") || !Spassword.equals(inputPassword)) {
            try {
                Stage stage = new Stage();
                Parent root = null;
                root = FXMLLoader.load(getClass().getResource("invalide_pass.fxml"));
                stage.setTitle("Mot de passe");
                javafx.scene.image.Image icon=new javafx.scene.image.Image(getClass().getResource("../icon.png").toURI().toString());
                stage.getIcons().add(icon);
                stage.setScene(new Scene(root));
                stage.initStyle(StageStyle.DECORATED);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            Bpassword=false;
        } else {
            Bpassword=true;
        }

        if (Bemail && Bpassword) {

            try {
                ConnexionMySQL.connectToDataBase();
                Statement statement=ConnexionMySQL.connection.createStatement();
                ResultSet resultSet=statement.executeQuery("SELECT * from fournisseur where id_fournisseur="+Lid.get(Lemail.indexOf(Semail)));
                resultSet.first();
                resultSet.previous();
                fournisseur = new Fournisseur();
                while (resultSet.next()){
                    fournisseur.setNom(resultSet.getString(2));
                    fournisseur.setPrenom(resultSet.getString(3));
                    fournisseur.setVille(resultSet.getString(4));
                    fournisseur.setNumeroTelephone(resultSet.getString(6));
                    fournisseur.setEmail(Semail);
                    fournisseur.setId(resultSet.getInt(1));
                    fournisseur.setNombreOffre(resultSet.getInt(7));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // mysql balbalbla


        /**/

            Node source = (Node)  actionEvent.getSource();
            Stage stage  = (Stage) source.getScene().getWindow();
            stage.close();
        } else {
            //
        }

        try {
            ConnexionMySQL.closeConnexion();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void initialize() {

        email.setFocusTraversable(false);
        password.setFocusTraversable(false);
        signInButton.setFocusTraversable(true);

    }
}
