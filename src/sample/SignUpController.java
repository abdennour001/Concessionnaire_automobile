package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sun.awt.image.BadDepthException;
import sun.util.resources.LocaleData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by asus on 02/05/2018.
 */
public class SignUpController {

    private String insertFournisseurQuery="";
    private String insertCompteQuery="";

    public static Fournisseur fournisseur=null;
    public static Compte compte=null;

    @FXML
    private TextField nom, prenom, numero, adresse, email;

    @FXML
    private PasswordField password, confirmer;

    @FXML
    private Label Cnom, Cprenom, Cnumero, Cadresse, Cconfirmer, Cemail, Cpassword;

    @FXML
    private Button signUpButton;

    @FXML
    private ChoiceBox<String> abonement;

    // onAction
    @FXML
    public void signUp(ActionEvent actionEvent) {

        String Snom, Sprenom, Snumero, Sadresse, Sconfirmer, Semail, Spassword;
        boolean Bnom=false, Bprenom=false, Bnumero=false, Badresse=false,
                Bconfirmer=false, Bemail=false, Bpassword=false;

        Snom=nom.getText();Sprenom=prenom.getText();Snumero=numero.getText();Sadresse=adresse.getText();Sconfirmer=confirmer.getText();Semail=email.getText();
        Spassword=password.getText();

        if(Snom.equals("")) {
            Cnom.setManaged(true);
            Cnom.setVisible(true);
            Bnom = false;
        } else {
            Cnom.setManaged(false);
            Cnom.setVisible(false);
            Bnom=true;
        }

        if (Sprenom.equals("")) {
            Cprenom.setManaged(true);
            Cprenom.setVisible(true);
            Bprenom=false;
        } else {
            Cprenom.setManaged(false);
            Cprenom.setVisible(false);
            Bprenom=true;
        }

        if (Semail.equals("") || !Semail.contains("@")) {
            Cemail.setManaged(true);
            Cemail.setVisible(true);
            Bemail=false;
        } else {
            Cemail.setManaged(false);
            Cemail.setVisible(false);
            Bemail=true;
        }

        if(Snumero.equals("") || !Snumero.matches("(\\d*)")) {
            Cnumero.setManaged(true);
            Cnumero.setVisible(true);
            Bnumero=false;
        } else {
            Cnumero.setManaged(false);
            Cnumero.setVisible(false);
            Bnumero=true;
        }

        if (Sadresse.equals("")) {
            Cadresse.setManaged(true);
            Cadresse.setVisible(true);
            Badresse=false;
        } else {
            Cadresse.setManaged(false);
            Cadresse.setVisible(false);
            Badresse=true;
        }

        if (Spassword.equals("") || Spassword.length() < 4) {
            Cpassword.setManaged(true);
            Cpassword.setVisible(true);
            Bpassword=false;
        } else {
            Cpassword.setManaged(false);
            Cpassword.setVisible(false);
            Bpassword=true;
        }

        if (!Sconfirmer.equals(Spassword)) {
            Cconfirmer.setManaged(true);
            Cconfirmer.setVisible(true);
            Bconfirmer=false;
        } else {
            Cconfirmer.setManaged(false);
            Cconfirmer.setVisible(false);
            Bconfirmer=true;
        }

        if (Bnom && Bprenom && Bnumero && Badresse && Bconfirmer && Bemail && Bpassword) {
            /** MySQL ICI*/
            fournisseur=new Fournisseur();
            fournisseur.setNom(Snom);
            fournisseur.setPrenom(Sprenom);
            fournisseur.setEmail(Semail);
            fournisseur.setVille(Sadresse);
            fournisseur.setNumeroTelephone(Snumero);

            compte=new Compte();
            compte.setPassword(Spassword);
            Date now=new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(now);
            if (abonement.getSelectionModel().getSelectedItem().equals("1 mois (10 $)")) {
                cal.add(Calendar.MONTH, 1);
            } else if(abonement.getSelectionModel().getSelectedItem().equals("3 mois (50 $)")) {
                cal.add(Calendar.MONTH, 3);
            } else {
                cal.add(Calendar.YEAR, 1);
            }
            compte.setDate_fin(cal.getTime());
            compte.setDate_debut(now);

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            insertFournisseurQuery="INSERT INTO `"+ ConnexionMySQL.BDD +"`.`fournisseur` (`nom`, `prenom`, `ville`, `email`, `num_telephone`) VALUES ('"+
                    Snom+"', '"+
                    Sprenom+"', '"+
                    Sadresse+"', '"+
                    Semail+"', '"+
                    Snumero+"')";

            Statement statement= null;
            int ID_FOURNISSEUR=0;
            try {
                ConnexionMySQL.connectToDataBase();
                statement = ConnexionMySQL.connection.createStatement();
                statement.executeUpdate(insertFournisseurQuery);
                //get the ID
                ResultSet resultSet=statement.executeQuery("SELECT LAST_INSERT_ID()");
                resultSet.first();
                ID_FOURNISSEUR=resultSet.getInt(1);
                ConnexionMySQL.closeConnexion();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            insertCompteQuery="INSERT INTO `"+ ConnexionMySQL.BDD +"`.`compte` (`id_fournisseur`, `password_compte`, `date_debut`, `date_fin`) VALUES ('"+
                    ID_FOURNISSEUR+"', '"+
                    Spassword+"', '"+
                    formatter.format(compte.getDate_debut())+"', '"+
                    formatter.format(compte.getDate_fin())+"')";

            Statement statement2= null;
            try {
                ConnexionMySQL.connectToDataBase();
                statement2 = ConnexionMySQL.connection.createStatement();
                statement2.executeUpdate(insertCompteQuery);
                ConnexionMySQL.closeConnexion();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        /**/

            Node source = (Node)  actionEvent.getSource();
            Stage stage  = (Stage) source.getScene().getWindow();
            stage.close();
        }

    }

    @FXML
    public void initialize() {

        password.setCache(true);


        nom.setFocusTraversable(false);
        prenom.setFocusTraversable(false);
        adresse.setFocusTraversable(false);
        numero.setFocusTraversable(false);
        confirmer.setFocusTraversable(false);
        email.setFocusTraversable(false);
        password.setFocusTraversable(false);
        signUpButton.setFocusTraversable(true);

        Cnom.setVisible(false);
        Cnom.setManaged(false);
        Cprenom.setVisible(false);
        Cprenom.setManaged(false);
        Cadresse.setVisible(false);
        Cadresse.setManaged(false);
        Cnumero.setVisible(false);
        Cnumero.setManaged(false);
        Cpassword.setVisible(false);
        Cpassword.setManaged(false);
        Cemail.setVisible(false);
        Cemail.setManaged(false);
        Cconfirmer.setVisible(false);
        Cconfirmer.setManaged(false);

        initializeAboChoiceBox();

    }

    void initializeAboChoiceBox() {
        abonement.getItems().addAll(
                "1 mois (10 $)",
                "3 mois (50 $)",
                "1 an (200 $)"
        );
        abonement.setTooltip(new Tooltip("Abonement"));
        abonement.getSelectionModel().select("1 mois (10 $)");
        abonement.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
    }
}
