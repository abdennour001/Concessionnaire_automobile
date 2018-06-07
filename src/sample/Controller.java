package sample;

import com.sun.deploy.util.SessionState;
import com.sun.org.apache.xpath.internal.operations.Mod;
import javafx.event.*;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javafx.stage.WindowEvent;
import sample.*;

public class Controller {

    @FXML
    public Button signOut;

    @FXML
    public Label achat, qualite, garanti, sessionTitle, sessionName, offreFournisseur;

    @FXML
    public ImageView image;

    @FXML
    public VBox rechercherVbox;

    @FXML
    public ScrollPane mainScrollPane;

    @FXML
    private VBox recherche;

    @FXML
    public HBox connectionField, pageBar, pageBar1;

    @FXML
    private HBox firstRow, secondRow, thirdRow, fourthRow, firstRowFournisseur, secondRowFournisseur, thirdRowFournisseur, fourthRowFournisseur, oFirstRow, oSecondRow, oThirdRow, oFourthRow;

    @FXML
    private VBox voiture11, voiture12, voiture21, voiture22, voiture31, voiture32, voiture41, voiture42, voitureFournisseur11, voitureFournisseur12, voitureFournisseur21, voitureFournisseur22, voitureFournisseur31, voitureFournisseur32, voitureFournisseur41, voitureFournisseur42;

    @FXML
    private VBox voiture1, voiture2, voiture3, voiture4, voiture5, voiture6, voiture7, voiture8;


    @FXML
    private VBox voiturePage, voiturePageFournisseur;

    @FXML
    private TabPane mainTabPane;

    @FXML
    private Tab tabFournisseur;

    private ArrayList<Voiture> voitureList;

    @FXML
    private VBox mainVBox;

    //-------------------------------

    @FXML
    private void onVoiture11Clicked() {

        mainScrollPane.setVvalue(0.4);
        voiturePage.setVisible(true);
        voiturePage.setManaged(true);

        firstRow.setVisible(false);
        firstRow.setManaged(false);
        secondRow.setVisible(false);
        secondRow.setManaged(false);
        thirdRow.setVisible(false);
        thirdRow.setManaged(false);
        fourthRow.setVisible(false);
        fourthRow.setManaged(false);
        pageBar.setVisible(false);
        pageBar.setManaged(false);
    }

    @FXML
    private void onVoiture12Clicked() {

        mainScrollPane.setVvalue(0.4);
        voiturePage.setVisible(true);
        voiturePage.setManaged(true);

        firstRow.setVisible(false);
        firstRow.setManaged(false);
        secondRow.setVisible(false);
        secondRow.setManaged(false);
        thirdRow.setVisible(false);
        thirdRow.setManaged(false);
        fourthRow.setVisible(false);
        fourthRow.setManaged(false);
        pageBar.setVisible(false);
        pageBar.setManaged(false);
    }

    @FXML
    private void onVoiture21Clicked() {

        mainScrollPane.setVvalue(0.4);
        voiturePage.setVisible(true);
        voiturePage.setManaged(true);

        firstRow.setVisible(false);
        firstRow.setManaged(false);
        secondRow.setVisible(false);
        secondRow.setManaged(false);
        thirdRow.setVisible(false);
        thirdRow.setManaged(false);
        fourthRow.setVisible(false);
        fourthRow.setManaged(false);
        pageBar.setVisible(false);
        pageBar.setManaged(false);
    }

    @FXML
    private void onVoiture22Clicked() {

        mainScrollPane.setVvalue(0.4);
        voiturePage.setVisible(true);
        voiturePage.setManaged(true);

        firstRow.setVisible(false);
        firstRow.setManaged(false);
        secondRow.setVisible(false);
        secondRow.setManaged(false);
        thirdRow.setVisible(false);
        thirdRow.setManaged(false);
        fourthRow.setVisible(false);
        fourthRow.setManaged(false);
        pageBar.setVisible(false);
        pageBar.setManaged(false);
    }

    @FXML
    private void onVoiture31Clicked() {

        mainScrollPane.setVvalue(0.4);
        voiturePage.setVisible(true);
        voiturePage.setManaged(true);

        firstRow.setVisible(false);
        firstRow.setManaged(false);
        secondRow.setVisible(false);
        secondRow.setManaged(false);
        thirdRow.setVisible(false);
        thirdRow.setManaged(false);
        fourthRow.setVisible(false);
        fourthRow.setManaged(false);
        pageBar.setVisible(false);
        pageBar.setManaged(false);
    }

    @FXML
    private void onVoiture32Clicked() {

        mainScrollPane.setVvalue(0.4);
        voiturePage.setVisible(true);
        voiturePage.setManaged(true);

        firstRow.setVisible(false);
        firstRow.setManaged(false);
        secondRow.setVisible(false);
        secondRow.setManaged(false);
        thirdRow.setVisible(false);
        thirdRow.setManaged(false);
        fourthRow.setVisible(false);
        fourthRow.setManaged(false);
        pageBar.setVisible(false);
        pageBar.setManaged(false);
    }

    @FXML
    private void onVoiture41Clicked() {

        mainScrollPane.setVvalue(0.4);
        voiturePage.setVisible(true);
        voiturePage.setManaged(true);

        firstRow.setVisible(false);
        firstRow.setManaged(false);
        secondRow.setVisible(false);
        secondRow.setManaged(false);
        thirdRow.setVisible(false);
        thirdRow.setManaged(false);
        fourthRow.setVisible(false);
        fourthRow.setManaged(false);
        pageBar.setVisible(false);
        pageBar.setManaged(false);
    }

    @FXML
    private void onVoiture42Clicked() {

        mainScrollPane.setVvalue(0.4);
        voiturePage.setVisible(true);
        voiturePage.setManaged(true);

        firstRow.setVisible(false);
        firstRow.setManaged(false);
        secondRow.setVisible(false);
        secondRow.setManaged(false);
        thirdRow.setVisible(false);
        thirdRow.setManaged(false);
        fourthRow.setVisible(false);
        fourthRow.setManaged(false);
        pageBar.setVisible(false);
        pageBar.setManaged(false);
    }

    //------------------------

    @FXML
    private void onVoitureFournisseurClicked() {

        mainScrollPane.setVvalue(0.4);
        voiturePageFournisseur.setVisible(true);
        voiturePageFournisseur.setManaged(true);

        firstRowFournisseur.setVisible(false);
        firstRowFournisseur.setManaged(false);
        secondRowFournisseur.setVisible(false);
        secondRowFournisseur.setManaged(false);
        thirdRowFournisseur.setVisible(false);
        thirdRowFournisseur.setManaged(false);
        fourthRowFournisseur.setVisible(false);
        fourthRowFournisseur.setManaged(false);
        pageBar1.setVisible(false);
        pageBar1.setManaged(false);
    }

    @FXML
    private void onRetourFournisseurClicked() {

        mainScrollPane.setVvalue(0.2);
        voiturePageFournisseur.setVisible(false);
        voiturePageFournisseur.setManaged(false);

        showVoitureFournisseur();
        pageBar1.setVisible(true);
        pageBar1.setManaged(true);
    }

    @FXML
    private void onRetourClicked() {

        showVoitureRecherche();

        mainScrollPane.setVvalue(0.4);
        voiturePage.setVisible(false);
        voiturePage.setManaged(false);
    }

    public void onEmailFournisseurClicked() {
        try {
            Stage stage = new Stage();
            Parent root = null;
            root = FXMLLoader.load(getClass().getResource("email_fournisseur.fxml"));
            stage.setTitle("Email de Fournisseur");
            javafx.scene.image.Image icon=new javafx.scene.image.Image(getClass().getResource("../icon.png").toURI().toString());
            stage.getIcons().add(icon);
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.DECORATED);
            stage.initOwner(Main.stage);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void onNumeroFournisseurClicked() {
        try {
            Stage stage = new Stage();
            Parent root = null;
            root = FXMLLoader.load(getClass().getResource("numero_fournisseur.fxml"));
            stage.setTitle("Numéro de Fournisseur");
            javafx.scene.image.Image icon=new javafx.scene.image.Image(getClass().getResource("../icon.png").toURI().toString());
            stage.getIcons().add(icon);
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.DECORATED);
            stage.initOwner(Main.stage);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


    public void onLocationFournisseurClicked() {
        try {
            Stage stage = new Stage();
            Parent root = null;
            root = FXMLLoader.load(getClass().getResource("adresse_fournisseur.fxml"));
            stage.setTitle("Adresse de Fournisseur");
            javafx.scene.image.Image icon=new javafx.scene.image.Image(getClass().getResource("../icon.png").toURI().toString());
            stage.getIcons().add(icon);
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.DECORATED);
            stage.initOwner(Main.stage);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


    private ArrayList<String> imageArrayList=new ArrayList<String>();
    public int count = 0;

    private ArrayList<Label> titleArrayList=new ArrayList<Label>();
    public int count2 = 0;

    public void imageSlide() {

        imageArrayList.add("cabine.jpg");
        imageArrayList.add("voiture.jpg");
        imageArrayList.add("voiture2.jpg");
        imageArrayList.add("voiture1.jpg");

        long delay = 10000; //update once per 3 seconds.
        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                image.setImage(new Image(imageArrayList.get(count++)));
                if (count >= imageArrayList.size()) {
                    count = 0;
                }
            }
        }, 0, delay);
    }

    public void titleSlide() {

        titleArrayList.add(achat);
        titleArrayList.add(qualite);
        titleArrayList.add(garanti);

        long delay = 1000; //update once per 3 seconds.
        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                for (Label l:
                     titleArrayList) {
                    if(titleArrayList.indexOf(l) != count2) {
                        l.setOpacity(0);
                    } else {
                        l.setOpacity(1);
                    }
                }
                count2++;
                if (count2 >= titleArrayList.size()) {
                    count2 = 0;
                }
            }
        }, 0, delay);
    }


    @FXML
    public void numero(){
        try {
            Stage stage = new Stage();
            Parent root = null;
            root = FXMLLoader.load(getClass().getResource("numero.fxml"));
            stage.setTitle("Numéro téléphone");
            javafx.scene.image.Image icon=new javafx.scene.image.Image(getClass().getResource("../icon.png").toURI().toString());
            stage.getIcons().add(icon);
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.DECORATED);
            stage.initOwner(Main.stage);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    void rowsManager(boolean r1, boolean r2, boolean r3, boolean r4) {
        firstRow.setVisible(r1);
        firstRow.setManaged(r1);
        secondRow.setVisible(r2);
        secondRow.setManaged(r2);
        thirdRow.setVisible(r3);
        thirdRow.setManaged(r3);
        fourthRow.setVisible(r4);
        fourthRow.setManaged(r4);
    }

    public void adresse(){
        try {
            Stage stage = new Stage();
            Parent root = null;
            root = FXMLLoader.load(getClass().getResource("adresse.fxml"));
            stage.setTitle("Adresse");
            javafx.scene.image.Image icon=new javafx.scene.image.Image(getClass().getResource("../icon.png").toURI().toString());
            stage.getIcons().add(icon);
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.DECORATED);
            stage.initOwner(Main.stage);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public Tab rechercheTab;
    public void email(){
        try {
            Stage stage = new Stage();
            Parent root = null;
            root = FXMLLoader.load(getClass().getResource("email.fxml"));
            stage.setTitle("Email");
            javafx.scene.image.Image icon=new javafx.scene.image.Image(getClass().getResource("../icon.png").toURI().toString());
            stage.getIcons().add(icon);
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.DECORATED);
            stage.initOwner(Main.stage);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void signIn() {
        try {
            Stage stage = new Stage();
            Parent root = null;
            root = FXMLLoader.load(getClass().getResource("sign_in.fxml"));
            stage.setTitle("Connection");
            javafx.scene.image.Image icon=new javafx.scene.image.Image(getClass().getResource("../icon.png").toURI().toString());
            stage.getIcons().add(icon);
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.DECORATED);
            stage.initOwner(mainScrollPane.getScene().getWindow());
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
            stage.setOnHidden(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    if(SignInController.fournisseur != null) {
                        Session.setSessionType(SESSION_TYPE.FOURNISSEUR);
                        Session.setSessionFournisseur(SignInController.fournisseur);
                        refreshPage();
                        mainTabPane.getSelectionModel().select(tabFournisseur);
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public void refreshPage() {
        initializeSessionTitle();
        connectionFieldReControl();
        setTabFournisseurReControl();
        if(Session.getSessionType() == SESSION_TYPE.FOURNISSEUR) showVoitureFournisseur();
        showVoitureRecherche();
        offreFournisseur.setText("Vos Offres  ("+Session.getSessionFournisseur().getNombreOffre()+" offres)");
        mainScrollPane.setFocusTraversable(true);
        sessionTitle.requestFocus();
    }

    public void focusedVoitureControl(boolean estFournisseur) {
        if(!estFournisseur) {

        } else {

        }
    }

    @FXML
    public void signOut() {

        try {
            Stage stage = new Stage();
            Parent root = null;
            root = FXMLLoader.load(getClass().getResource("sign_out.fxml"));
            stage.setTitle("Confirmation");
            javafx.scene.image.Image icon=new javafx.scene.image.Image(getClass().getResource("../icon.png").toURI().toString());
            stage.getIcons().add(icon);
            stage.setScene(new Scene(root));
            stage.initStyle(StageStyle.DECORATED);
            stage.initOwner(Main.stage);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
            stage.setOnHidden(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    if(SignOutController.confirm) {
                        Session.setSessionType(SESSION_TYPE.CLIENT);
                        Session.setSessionFournisseur(null);
                        initializeSessionTitle();
                        connectionFieldReControl();
                        setTabFournisseurReControl();
                        mainScrollPane.setVvalue(0);
                        mainTabPane.getSelectionModel().select(0);
                    } else {
                        //
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void signUp() {

        try {
            Stage stage = new Stage();
            Parent root = null;
            root = FXMLLoader.load(getClass().getResource("sign_up.fxml"));
            stage.setTitle("Inscription");
            javafx.scene.image.Image icon=new javafx.scene.image.Image(getClass().getResource("../icon.png").toURI().toString());
            stage.getIcons().add(icon);
            stage.setScene(new Scene(root));
            stage.initOwner(mainScrollPane.getScene().getWindow());
            stage.initStyle(StageStyle.DECORATED);
            stage.initOwner(Main.stage);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
            stage.setOnHidden(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    if(SignUpController.fournisseur != null) {
                        try {
                            Stage stage = new Stage();
                            Parent root = null;
                            root = FXMLLoader.load(getClass().getResource("bienvenue.fxml"));
                            stage.setTitle("Bienvenue");
                            javafx.scene.image.Image icon=new javafx.scene.image.Image(getClass().getResource("../icon.png").toURI().toString());
                            stage.getIcons().add(icon);
                            stage.setScene(new Scene(root));
                            stage.initOwner(mainScrollPane.getScene().getWindow());
                            stage.initStyle(StageStyle.DECORATED);
                            stage.initModality(Modality.WINDOW_MODAL);
                            stage.setOnHidden(new EventHandler<WindowEvent>() {
                                @Override
                                public void handle(WindowEvent event) {
                                    if(SignUpController.fournisseur != null) {
                                        Session.setSessionType(SESSION_TYPE.FOURNISSEUR);
                                        Session.setSessionFournisseur(SignUpController.fournisseur);
                                        refreshPage();
                                        mainTabPane.getSelectionModel().select(tabFournisseur);
                                    }
                                }
                            });
                            stage.initModality(Modality.WINDOW_MODAL);
                            stage.show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (URISyntaxException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }


    //Come here
    @FXML
    public void initialize(){

        showVoitureRecherche();

        mainScrollPane.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    ConnexionMySQL.connectToDataBase();
                    Statement statement4=ConnexionMySQL.connection.createStatement();
                    ResultSet resultSet4=statement4.executeQuery("SELECT count(*) from voiture");
                    resultSet4.first();
                    ((Label) rechercherVbox.lookup("#rechercheNumber")).setText("Rechercher ("+resultSet4.getInt(1)+" annonces)");
                    if(Session.getSessionType() == SESSION_TYPE.FOURNISSEUR) {
                        Statement statement5=ConnexionMySQL.connection.createStatement();
                        ResultSet resultSet5=statement5.executeQuery("SELECT count(*) from voiture where id_fournisseur="+Session.getSessionFournisseur().getId());
                        resultSet5.first();
                        offreFournisseur.setText("Vos Offres  ("+resultSet5.getInt(1)+" offres)");
                    }
                    ConnexionMySQL.closeConnexion();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                showVoitureFournisseur();
            }
        });

        tabFournisseur.setOnSelectionChanged(new EventHandler<javafx.event.Event>() {
            @Override
            public void handle(Event event) {
                showVoitureFournisseur();
            }
        });
        rechercheTab.setOnSelectionChanged(new EventHandler<javafx.event.Event>() {
            @Override
            public void handle(Event event) {
                showVoitureRecherche();
            }
        });

        /** Data base business (connexion test)*/

        try {

            ConnexionMySQL.connectToDataBase();
            ConnexionMySQL.closeConnexion();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        /**********************/

        imageSlide();
        titleSlide();
        initializeSession();
        initializeSessionTitle();
        connectionFieldReControl();
        setTabFournisseurReControl();
        initializeVoitureList();
        qualite.setFocusTraversable(true);
        //---------------------------
        rowsManager(false, false, false, false);
        //------------------------
        rowsFournisseurManager(false, false, false, false);
        //-----------------------
        rowsNewManager(true, false, false, false);
        showVoitureRecherche();

        //----------------------
        voiturePage.setVisible(false);
        voiturePage.setManaged(false);
        voiturePageFournisseur.setVisible(false);
        voiturePageFournisseur.setManaged(false);
        ((Label) voiture11.lookup("#color")).setText("Customize this");
        ((Button) voiturePage.lookup("#retour")).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onRetourClicked();
            }
        });
        ((Button) voiturePage.lookup("#email")).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onEmailFournisseurClicked();
            }
        });
        ((Button) voiturePage.lookup("#numero")).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onNumeroFournisseurClicked();
            }
        });
        ((Button) voiturePage.lookup("#adresse")).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onLocationFournisseurClicked();
            }
        });

        ((Button) voiturePage.lookup("#retour")).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onRetourClicked();
            }
        });
        ((Button) voiturePage.lookup("#email")).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onEmailFournisseurClicked();
            }
        });
        ((Button) voiturePage.lookup("#numero")).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onNumeroFournisseurClicked();
            }
        });
        ((Button) voiturePage.lookup("#adresse")).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onLocationFournisseurClicked();
            }
        });



        ((Button) voiturePageFournisseur.lookup("#retour")).setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onRetourFournisseurClicked();
            }
        });
    }

    private void rowsNewManager(boolean b, boolean b1, boolean b2, boolean b3) {
        oFirstRow.setVisible(b);
        oFirstRow.setManaged(b);
        oSecondRow.setVisible(b1);
        oSecondRow.setManaged(b1);
        oThirdRow.setVisible(b2);
        oThirdRow.setManaged(b2);
        oFourthRow.setVisible(b3);
        oFourthRow.setManaged(b3);
    }

    private void rowsFournisseurManager(boolean b, boolean b1, boolean b2, boolean b3) {
        firstRowFournisseur.setVisible(b);
        firstRowFournisseur.setManaged(b);
        secondRowFournisseur.setVisible(b1);
        secondRowFournisseur.setManaged(b1);
        thirdRowFournisseur.setVisible(b2);
        thirdRowFournisseur.setManaged(b2);
        fourthRowFournisseur.setVisible(b3);
        fourthRowFournisseur.setManaged(b3);
    }

    private void initializeSessionTitle() {
        if (Session.getSessionType().equals(SESSION_TYPE.CLIENT)) {
            sessionTitle.setText("Bienvenue | Vous êtes connectés comme si un Client |");
            sessionName.setText("");
            Main.stage.setTitle("Concession des voitures [Client] - version 1.0");
            signOut.setVisible(false);
            signOut.setManaged(false);
        } else {
            sessionTitle.setText("Bienvenue | Vous êtes connectés avec un compte Fournisseur |");
            sessionName.setText(Session.getSessionFournisseur().getNom() + " " + Session.getSessionFournisseur().getPrenom());
            Main.stage.setTitle("Concession des voitures (" + Session.getSessionFournisseur().getNom() + " " + Session.getSessionFournisseur().getPrenom() +" [Fournisseur]) - version 1.0");
            signOut.setVisible(true);
            signOut.setManaged(true);
        }
    }

    private void setTabFournisseurReControl() {
        if(Session.getSessionType().equals(SESSION_TYPE.CLIENT)) {
            tabFournisseur.setDisable(true);
        } else {
            tabFournisseur.setDisable(false);
    }
    }

    private void connectionFieldReControl() {
        if(Session.getSessionType().equals(SESSION_TYPE.CLIENT)) {
            connectionField.setVisible(true);
            connectionField.setManaged(true);
        } else {
            connectionField.setVisible(false);
            connectionField.setManaged(false);
        }
    }

    private void initializeVoitureList() {
        voitureList = new ArrayList<Voiture>();
        voitureList.add(new Voiture());
    }

    private void initializeSession() {
        Session.setSessionType(SESSION_TYPE.CLIENT);
    }

    public void audi(ActionEvent actionEvent) {
        ((ChoiceBox)recherche.lookup("#marque")).getSelectionModel().select("Audi");
        mainScrollPane.setVvalue(0.25);
        mainTabPane.getSelectionModel().select(0);
    }

    public void bmw(ActionEvent actionEvent) {
        ((ChoiceBox)recherche.lookup("#marque")).getSelectionModel().select("BMW");
        mainScrollPane.setVvalue(0.25);
        mainTabPane.getSelectionModel().select(0);
    }

    public void ford(ActionEvent actionEvent) {
        ((ChoiceBox)recherche.lookup("#marque")).getSelectionModel().select("Ford");
        mainScrollPane.setVvalue(0.25);
        mainTabPane.getSelectionModel().select(0);
    }

    public void kia(ActionEvent actionEvent) {
        ((ChoiceBox)recherche.lookup("#marque")).getSelectionModel().select("Kia");
        mainScrollPane.setVvalue(0.25);
        mainTabPane.getSelectionModel().select(0);
    }

    public void mercedes(ActionEvent actionEvent) {
        ((ChoiceBox)recherche.lookup("#marque")).getSelectionModel().select("Mercedes");
        mainScrollPane.setVvalue(0.25);
        mainTabPane.getSelectionModel().select(0);
    }

    public void renault(ActionEvent actionEvent) {
        ((ChoiceBox)recherche.lookup("#marque")).getSelectionModel().select("Renault");
        mainScrollPane.setVvalue(0.25);
        mainTabPane.getSelectionModel().select(0);
    }

    public void majorVehicleRemodelOnList(VBox voitureContainer, Voiture voiture) {
        String image, marque, version, color, carburant;
        long prix; String date; String km;

        Modele modeleVoiture;
        modeleVoiture=voiture.getMarque().getType().getModele();

        image=modeleVoiture.getImagePath();
        marque=voiture.getMarque().getNomMarque();
        version=modeleVoiture.getNomModele();
        color=modeleVoiture.getCouleur();
        carburant=modeleVoiture.getMoteur().getCarburant().toString();
        prix=(long) modeleVoiture.getPrix();
        date=String.valueOf(modeleVoiture.getDateSortie());
        km=String.valueOf(modeleVoiture.getKm());


        File file = new File(image);
        Image image0 = new Image(file.toURI().toString());

        ((ImageView) voitureContainer.lookup("#image")).setImage(image0);
        ((Label) voitureContainer.lookup("#marque")).setText(marque);
        ((Label) voitureContainer.lookup("#model")).setText(modeleVoiture.getNomModele());
        ((Label) voitureContainer.lookup("#numero")).setText(modeleVoiture.getNumero());
        ((Label) voitureContainer.lookup("#carburant")).setText(carburant);
        ((Label) voitureContainer.lookup("#color")).setText(color);
        ((Label) voitureContainer.lookup("#date")).setText(date);
        ((Label) voitureContainer.lookup("#km")).setText(km + " Km");
        ((Label) voitureContainer.lookup("#prix")).setText(String.valueOf(prix) + " $");
    }

    public void majorVehicleRemodelOnPage(VBox voiturePageContainer, Voiture voiture) {
        String image, marque, version, color, carburant, numeroSerie, garanti, moteur, puissance;
        long prix; String date; String km;

        Modele modeleVoiture=voiture.getMarque().getType().getModele();

        image=modeleVoiture.getImagePath();
        marque=voiture.getMarque().getNomMarque();
        version=modeleVoiture.getNomModele();
        color=modeleVoiture.getCouleur();
        carburant=modeleVoiture.getMoteur().getCarburant().toString();
        prix=(long) modeleVoiture.getPrix();
        date=String.valueOf(modeleVoiture.getDateSortie());
        km=String.valueOf(modeleVoiture.getKm());
        numeroSerie=modeleVoiture.getNumero();
        garanti=voiture.getGarantie();
        moteur=modeleVoiture.getMoteur().getNomMoteur();
        puissance=String.valueOf(modeleVoiture.getMoteur().getPuissance());

        ((ImageView) voiturePageContainer.lookup("#image")).setImage(new Image(image));
        ((Label) voiturePageContainer.lookup("#marque")).setText(marque);
        ((Label) voiturePageContainer.lookup("#numeroSerie")).setText(numeroSerie);
        ((Label) voiturePageContainer.lookup("#version")).setText(version);
        ((Label) voiturePageContainer.lookup("#version2")).setText(version);
        ((Label) voiturePageContainer.lookup("#prix")).setText(String.valueOf(prix) + "$");
        ((Label) voiturePageContainer.lookup("#km")).setText(km + " Km");
        ((Label) voiturePageContainer.lookup("#km2")).setText(km + " Km");
        ((Label) voiturePageContainer.lookup("#date")).setText(date);
        ((Label) voiturePageContainer.lookup("#date2")).setText(date);
        ((Label) voiturePageContainer.lookup("#garanti")).setText(garanti);
        ((Label) voiturePageContainer.lookup("#moteur")).setText(moteur);
        ((Label) voiturePageContainer.lookup("#puissance")).setText(puissance);
        ((Label) voiturePageContainer.lookup("#color")).setText(color);
        ((Label) voiturePageContainer.lookup("#carburant")).setText(carburant);
    }

    void showVoitureRecherche() {

        firstRow.setVisible(false);
        firstRow.setManaged(false);
        secondRow.setVisible(false);
        secondRow.setManaged(false);
        thirdRow.setVisible(false);
        thirdRow.setManaged(false);
        fourthRow.setVisible(false);
        fourthRow.setManaged(false);

        Session.getSessionAllVoitureList();

        for (Voiture v:
                Session.sessionAllVoitureList) {
            switch (Session.sessionAllVoitureList.indexOf(v)%6) {
                case 0:
                    firstRow.setVisible(true);
                    firstRow.setManaged(true);
                    voiture12.setVisible(false);
                    majorVehicleRemodelOnList(voiture11, v);
                    break;
                case 1:
                    voiture12.setVisible(true);
                    voiture12.setManaged(true);
                    majorVehicleRemodelOnList(voiture12, v);
                    break;
                case 2:
                    secondRow.setVisible(true);
                    secondRow.setManaged(true);
                    voiture22.setVisible(false);
                    majorVehicleRemodelOnList(voiture21, v);
                    break;
                case 3:
                    secondRow.setVisible(true);
                    secondRow.setManaged(true);
                    voiture22.setVisible(true);
                    majorVehicleRemodelOnList(voiture22, v);
                    break;
                case 4:
                    thirdRow.setVisible(true);
                    thirdRow.setManaged(true);
                    voiture32.setVisible(false);
                    majorVehicleRemodelOnList(voiture31, v);
                    break;
                case 5:
                    thirdRow.setVisible(true);
                    thirdRow.setManaged(true);
                    voiture32.setVisible(true);
                    majorVehicleRemodelOnList(voiture32, v);
                    break;
                case 6:
                    fourthRow.setVisible(true);
                    fourthRow.setManaged(true);
                    voiture42.setVisible(false);
                    majorVehicleRemodelOnList(voiture41, v);
                    break;
                case 7:
                    fourthRow.setVisible(true);
                    fourthRow.setManaged(true);
                    voiture42.setVisible(true);
                    majorVehicleRemodelOnList(voiture42, v);
                    break;
            }
        }

    }

    public void showVoitureFournisseur() {

        firstRowFournisseur.setVisible(false);
        firstRowFournisseur.setManaged(false);
        secondRowFournisseur.setVisible(false);
        secondRowFournisseur.setManaged(false);
        thirdRowFournisseur.setVisible(false);
        thirdRowFournisseur.setManaged(false);
        fourthRowFournisseur.setVisible(false);
        fourthRowFournisseur.setManaged(false);

        Session.getSessionFournisseurVoitureList();

        for (Voiture v:
                Session.sessionFournisseurVoitureList) {
            switch (Session.sessionFournisseurVoitureList.indexOf(v)%6) {
                case 0:
                    firstRowFournisseur.setVisible(true);
                    firstRowFournisseur.setManaged(true);
                    voitureFournisseur12.setVisible(false);
                    majorVehicleRemodelOnList(voitureFournisseur11, v);
                    break;
                case 1:
                    voitureFournisseur12.setVisible(true);
                    voitureFournisseur12.setManaged(true);
                    majorVehicleRemodelOnList(voitureFournisseur12, v);
                    break;
                case 2:
                    secondRowFournisseur.setVisible(true);
                    secondRowFournisseur.setManaged(true);
                    voitureFournisseur22.setVisible(false);
                    majorVehicleRemodelOnList(voitureFournisseur21, v);
                    break;
                case 3:
                    secondRowFournisseur.setVisible(true);
                    secondRowFournisseur.setManaged(true);
                    voitureFournisseur22.setVisible(true);
                    majorVehicleRemodelOnList(voitureFournisseur22, v);
                    break;
                case 4:
                    thirdRowFournisseur.setVisible(true);
                    thirdRowFournisseur.setManaged(true);
                    voitureFournisseur32.setVisible(false);
                    majorVehicleRemodelOnList(voitureFournisseur31, v);
                    break;
                case 5:
                    thirdRowFournisseur.setVisible(true);
                    thirdRowFournisseur.setManaged(true);
                    voitureFournisseur32.setVisible(true);
                    majorVehicleRemodelOnList(voitureFournisseur32, v);
                    break;
                case 6:
                    fourthRowFournisseur.setVisible(true);
                    fourthRowFournisseur.setManaged(true);
                    voitureFournisseur42.setVisible(false);
                    majorVehicleRemodelOnList(voitureFournisseur41, v);
                    break;
                case 7:
                    fourthRowFournisseur.setVisible(true);
                    fourthRowFournisseur.setManaged(true);
                    voitureFournisseur42.setVisible(true);
                    majorVehicleRemodelOnList(voitureFournisseur42, v);
                    break;
            }
        }
    }

}
