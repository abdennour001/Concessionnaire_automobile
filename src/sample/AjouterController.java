package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.plaf.basic.BasicProgressBarUI;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by AMOKRANE Abdennour on 02/05/2018.
 */
public class AjouterController {

    private String insertVoitureQuery="";
    private int voitureID=0;
    private String insertMarqueQuery="";
    private int marqueID=0;
    private String insertTypeQuery="";
    private int typeID=0;
    private String insertModeleQuery="";
    private int modeleID=0;
    private String insertMoteurQuery="";
    private int moteurID=0;
    private String insertMarqueTypeQuery="";

    FileChooser photoChooser = new FileChooser();

    @FXML
    public ChoiceBox<String> categorie, carburant;

    @FXML
    public TextField marque, modele, prix, km, sortie, couleur, moteur, moteurPuissance, garanti, version;

    @FXML
    public Label Cmarque, Cmodele, Cprix, Ckm, Csortie, Ccouleur, Cmoteur, CpuissanceMoteur, Cgaranti, ajouterOffreNumber, Cphoto, Cversion;

    public String Smarque, Smodele, Sprix, Skm, Ssortie, Scouleur, Smoteur, SmoteurPuissance, Sgaranti, Sversion;
    public boolean Bmarque=false, Bmodele=false, Bprix=false, Bkm=false, Bsortie=false, Bcouleur=false, Bmoteur=false, BmoteurPuissance=false, Bgaranti=false, Bversion=false, Bphoto=false;

    @FXML
    public Hyperlink photo;

    private String photoPath;
    private String Sphoto;

    void initializeChecks() {
        Cmarque.setVisible(false);
        Cmarque.setManaged(false);
        Cmodele.setVisible(false);
        Cmodele.setManaged(false);
        Cprix.setVisible(false);
        Cprix.setManaged(false);
        Ckm.setVisible(false);
        Ckm.setManaged(false);
        Csortie.setVisible(false);
        Csortie.setManaged(false);
        Ccouleur.setVisible(false);
        Ccouleur.setManaged(false);
        Cmoteur.setVisible(false);
        Cmoteur.setManaged(false);
        Cversion.setVisible(false);
        Cversion.setManaged(false);
        CpuissanceMoteur.setVisible(false);
        CpuissanceMoteur.setManaged(false);
        Cgaranti.setVisible(false);
        Cgaranti.setManaged(false);
        Cphoto.setVisible(false);
        Cphoto.setManaged(false);
    }

    @FXML
    public void importPhoto() {
        photoChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG (*.jpg)", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG (*.png)", "*.png"),
                new FileChooser.ExtensionFilter("JPEG (*.jpeg)", "*.jpeg")
        );
        File file = photoChooser.showOpenDialog(Main.stage);
        if (file != null && (file.getName().contains("jpg") || file.getName().contains("jpeg") || file.getName().contains("png"))) {
            photoPath = file.getAbsolutePath();
            photo.setText(photoPath);
            Bphoto=true;
        } else {
            Bphoto=false;
            try {
                Stage stage = new Stage();
                Parent root = null;
                root = FXMLLoader.load(getClass().getResource("photo.fxml"));
                stage.setTitle("Alert");
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
        }
    }

    void initializeCategorieChoiceBox() {
        categorie.getItems().addAll("Berline",
                "Break",
                "Coupé",
                "4X4 & Crossover",
                "Voitures sociétés, commerciales",
                "Monospace",
                "Familiale"
        );
        categorie.setTooltip(new Tooltip("Catégorie"));
        categorie.getSelectionModel().select("Familiale");
        categorie.setOnAction(new EventHandler<ActionEvent>() {
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
                "Autre énergies"
        );
        carburant.setTooltip(new Tooltip("Carburant"));
        carburant.getSelectionModel().select("Essence");
        carburant.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
    }

    public void ajouter(ActionEvent actionEvent) {

        Smarque = marque.getText();
        Smodele = modele.getText();
        Sprix = prix.getText();
        Skm = km.getText();
        Ssortie = sortie.getText();
        Scouleur = couleur.getText();
        Smoteur = moteur.getText();
        SmoteurPuissance = moteurPuissance.getText();
        Sgaranti = garanti.getText();
        Sversion = version.getText();
        Sphoto = photo.getText();

        if (Sphoto.contains("Ajouter")) {
            Cphoto.setVisible(true);
            Cphoto.setManaged(true);
            Bphoto=true;
        } else {
            Cphoto.setVisible(false);
            Cphoto.setManaged(false);
            Bphoto=false;
        }

        if(Smarque.equals("")) {
            Cmarque.setVisible(true);
            Cmarque.setManaged(true);
            Bmarque=true;
        } else {
            Cmarque.setVisible(false);
            Cmarque.setManaged(false);
            Bmarque=false;
        }

        if(Smodele.equals("")) {
            Cmodele.setVisible(true);
            Cmodele.setManaged(true);
            Bmodele=true;
        } else {
            Cmodele.setVisible(false);
            Cmodele.setManaged(false);
            Bmodele=false;
        }

        if(Sprix.equals("") || !Sprix.matches("(\\d*)")) {
            Cprix.setVisible(true);
            Cprix.setManaged(true);
            Bprix=true;
        } else {
            Cprix.setVisible(false);
            Cprix.setManaged(false);
            Bprix=false;
        }

        if(Skm.equals("") || !Skm.matches("(\\d*)")) {
            Ckm.setVisible(true);
            Ckm.setManaged(true);
            Bkm=true;
        } else {
            Ckm.setVisible(false);
            Ckm.setManaged(false);
            Bkm=false;
        }

        if(Ssortie.equals("") || !Ssortie.matches("(\\d\\d\\d\\d)")) {
            Csortie.setVisible(true);
            Csortie.setManaged(true);
            Bsortie=true;
        } else {
            Csortie.setVisible(false);
            Csortie.setManaged(false);
            Bsortie=false;
        }

        if(Scouleur.equals("")) {
            Ccouleur.setVisible(true);
            Ccouleur.setManaged(true);
            Bcouleur=true;
        } else {
            Ccouleur.setVisible(false);
            Ccouleur.setManaged(false);
            Bcouleur=false;
        }

        if(Smoteur.equals("")) {
            Cmoteur.setVisible(true);
            Cmoteur.setManaged(true);
            Bmoteur=true;
        } else {
            Cmoteur.setVisible(false);
            Cmoteur.setManaged(false);
            Bmoteur=false;
        }

        if(SmoteurPuissance.equals("")) {
            CpuissanceMoteur.setVisible(true);
            CpuissanceMoteur.setManaged(true);
            BmoteurPuissance=true;
        } else {
            CpuissanceMoteur.setVisible(false);
            CpuissanceMoteur.setManaged(false);
            BmoteurPuissance=false;
        }

        if(Sgaranti.equals("")) {
            Cgaranti.setVisible(true);
            Cgaranti.setManaged(true);
            Bgaranti=true;
        } else {
            Cgaranti.setVisible(false);
            Cgaranti.setManaged(false);
            Bgaranti=false;
        }

        if(Sversion.equals("")) {
            Cversion.setVisible(true);
            Cversion.setManaged(true);
            Bversion=true;
        } else {
            Cversion.setVisible(false);
            Cversion.setManaged(false);
            Bversion=false;
        }

        if(!Bphoto && !BmoteurPuissance && !Bmoteur && !Bsortie && ! Bgaranti && !Bversion && !Bcouleur && !Bkm && !Bmarque && !Bmodele && !Bprix) {
            // sql talks
            Voiture voiture=new Voiture();
            Marque marque=new Marque();
            TypeVoiture type=new TypeVoiture();
            Modele modele=new Modele();
            Moteur moteur=new Moteur();

            voiture.setDateEntree(new Date());
            voiture.setFournisseur(Session.getSessionFournisseur());
            voiture.setGarantie(Sgaranti);
            voiture.setMarque(marque);

            marque.setNomMarque(Smarque);
            marque.setType(type);

            type.setModele(modele);
            type.setNomType(categorie.getSelectionModel().getSelectedItem());

            modele.setCouleur(Scouleur);
            modele.setDateSortie(Ssortie);
            modele.setImagePath(photo.getText().replace("\\", "/"));
            modele.setKm(Integer.valueOf(Skm));
            modele.setMoteur(moteur);
            modele.setNomModele(Smodele);
            modele.setVersion(Sversion);
            modele.setPrix(Integer.valueOf(Sprix));
            modele.setNumero(Sversion);

            moteur.setCarburant(String.valueOf(carburant.getSelectionModel().getSelectedIndex()));
            moteur.setNomMoteur(Smoteur);
            moteur.setPuissance(SmoteurPuissance);

            // insert marque
            insertMarqueQuery="INSERT INTO `"+ ConnexionMySQL.BDD +"`.`marque` (`nom_marque`) VALUES ('"+
                    Smarque+"')";

            try {
                Statement statement= null;
                ConnexionMySQL.connectToDataBase();
                statement = ConnexionMySQL.connection.createStatement();
                statement.executeUpdate(insertMarqueQuery);
                //get the ID
                ResultSet resultSet=statement.executeQuery("SELECT LAST_INSERT_ID()");
                resultSet.first();
                marqueID=resultSet.getInt(1);
                ConnexionMySQL.closeConnexion();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // insert type
            insertTypeQuery="INSERT INTO `"+ ConnexionMySQL.BDD +"`.`type_voiture` (`nom_type`) VALUES ('"+
                    type.getNomType()+"')";

            try {
                Statement statement= null;
                ConnexionMySQL.connectToDataBase();
                statement = ConnexionMySQL.connection.createStatement();
                statement.executeUpdate(insertTypeQuery);
                //get the ID
                ResultSet resultSet=statement.executeQuery("SELECT LAST_INSERT_ID()");
                resultSet.first();
                typeID=resultSet.getInt(1);
                ConnexionMySQL.closeConnexion();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // insert type_marque
            insertMarqueTypeQuery="INSERT INTO `"+ ConnexionMySQL.BDD +"`.`type_marque` (`id_type_voiture`, `id_marque`) VALUES ('"+
                    typeID+"', '"+marqueID+"')";

            try {
                Statement statement= null;
                ConnexionMySQL.connectToDataBase();
                statement = ConnexionMySQL.connection.createStatement();
                statement.executeUpdate(insertMarqueTypeQuery);
                ConnexionMySQL.closeConnexion();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // insert moteur
            insertMoteurQuery="INSERT INTO `"+ ConnexionMySQL.BDD +"`.`moteur` (`carburant`, `nom_moteur`, `puissance`) VALUES ('"+
                    moteur.getCarburant()+"', '"+moteur.getNomMoteur()+"', '"+ moteur.getPuissance()+"')";

            try {
                Statement statement= null;
                ConnexionMySQL.connectToDataBase();
                statement = ConnexionMySQL.connection.createStatement();
                statement.executeUpdate(insertMoteurQuery);
                //get the ID
                ResultSet resultSet=statement.executeQuery("SELECT LAST_INSERT_ID()");
                resultSet.first();
                moteurID=resultSet.getInt(1);
                ConnexionMySQL.closeConnexion();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");


            // insert voiture
            insertVoitureQuery="INSERT INTO `"+ ConnexionMySQL.BDD +"`.`voiture` (`id_fournisseur`, `id_marque`, `garantie`, `date_entree`) VALUES ('"+
                    Session.getSessionFournisseur().getId()+"', '"+marqueID+"', '"+ voiture.getGarantie()+"', '"+formatter.format(voiture.getDateEntree())+"')";

            try {
                Statement statement= null;
                ConnexionMySQL.connectToDataBase();
                statement = ConnexionMySQL.connection.createStatement();
                statement.executeUpdate(insertVoitureQuery);
                //get the ID
                ResultSet resultSet=statement.executeQuery("SELECT LAST_INSERT_ID()");
                resultSet.first();
                voitureID=resultSet.getInt(1);
                ConnexionMySQL.closeConnexion();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            // insert modele
            insertModeleQuery="INSERT INTO `"+ ConnexionMySQL.BDD +"`.`modele` (`id_moteur`, `id_type_voiture`, `nom_modele`, `image`, `couleur`, `numero`, `prix`, `km`, `date_sortie`) " +
                    "VALUES ('"+
                    moteurID+
                    "', '"+
                    typeID+
                    "', '"+
                    Smodele+
                    "', '"+
                    modele.getImagePath()+
                    "', '"+
                    modele.getCouleur()+
                    "', '"+
                    modele.getNumero()+
                    "', '"+
                    modele.getPrix()+
                    "', '"+
                    modele.getKm()+
                    "', '"+
                    modele.getDateSortie()+
                    "')";

            try {
                Statement statement= null;
                ConnexionMySQL.connectToDataBase();
                statement = ConnexionMySQL.connection.createStatement();
                statement.executeUpdate(insertModeleQuery);
                //get the ID
                ResultSet resultSet=statement.executeQuery("SELECT LAST_INSERT_ID()");
                resultSet.first();
                modeleID=resultSet.getInt(1);
                ConnexionMySQL.closeConnexion();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                ConnexionMySQL.closeConnexion();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    @FXML
    public void initialize() {
        initializeCategorieChoiceBox();
        initializeCarburantChoiceBox();
        initializeChecks();
    }
}