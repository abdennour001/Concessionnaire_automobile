package sample;

import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by AMOKRANE Abdennour on 02/05/2018.
 */
public class Session {

    public static ArrayList<Voiture> sessionAllVoitureList=new ArrayList<Voiture>();

    public Session() {

    }

    private static SESSION_TYPE sessionType;
    private static Fournisseur sessionFournisseur=null;
    public static ArrayList<Voiture> sessionRechercheVoitureList=new ArrayList<Voiture>();
    public static ArrayList<Voiture> sessionFournisseurVoitureList=new ArrayList<Voiture>();
    private static ArrayList<ArrayList<Voiture>> sessionVoiturePagesList=new ArrayList<ArrayList<Voiture>>();
    private static Voiture sessionFocusedVoiture=null;
    private static int sessionPage=0;


    private static void openSession(SESSION_TYPE sessionType) {
        sessionType = sessionType;
    }

    private static void openSession(SESSION_TYPE sessionType, Fournisseur fournisseur) {
        sessionType = sessionType;
        sessionFournisseur = fournisseur;
    }

    public static SESSION_TYPE getSessionType() {
        return sessionType;
    }

    public static void setSessionType(SESSION_TYPE sessionType) {
        Session.sessionType = sessionType;
    }

    public static Fournisseur getSessionFournisseur() {
        return sessionFournisseur;
    }

    public static void setSessionFournisseur(Fournisseur sessionFournisseur) {
        Session.sessionFournisseur = sessionFournisseur;
    }

    public static ArrayList<Voiture> getSessionFournisseurVoitureList() {

        sessionFournisseurVoitureList.clear();

        if (sessionType==SESSION_TYPE.FOURNISSEUR) {
            try {
                ConnexionMySQL.connectToDataBase();

                Statement statement=ConnexionMySQL.connection.createStatement();
                ResultSet resultSet=statement.executeQuery("SELECT * from voiture where id_fournisseur="+getSessionFournisseur().getId());
                resultSet.first();
                resultSet.previous();
                while (resultSet.next()){
                    Voiture voiture=new Voiture();
                    voiture.setId(resultSet.getInt("id_voiture"));
                    voiture.setFournisseur(sessionFournisseur);
                    voiture.setGarantie(resultSet.getString("garantie"));
                    voiture.setDateEntree(resultSet.getDate("date_entree"));

                    Marque marque=new Marque();
                    marque.setId(resultSet.getInt("id_marque"));
                    Statement statement1=ConnexionMySQL.connection.createStatement();
                    ResultSet resultSet1=statement1.executeQuery("SELECT nom_marque from marque where id_marque="+marque.getId());
                    resultSet1.first();
                    marque.setNomMarque(resultSet1.getString(1));
                    voiture.setMarque(marque);

                    TypeVoiture type=new TypeVoiture();
                    marque.setType(type);
                    Statement statement2=ConnexionMySQL.connection.createStatement();
                    ResultSet resultSet2=statement2.executeQuery("SELECT id_type_voiture from type_marque where id_marque="+marque.getId());
                    resultSet2.first();
                    type.setId(resultSet2.getInt(1));
                    Statement statement3=ConnexionMySQL.connection.createStatement();
                    ResultSet resultSet3=statement3.executeQuery("SELECT nom_type from type_voiture where id_type_voiture="+type.getId());
                    resultSet3.first();
                    type.setNomType(resultSet3.getString(1));

                    Modele modele=new Modele();
                    type.setModele(modele);
                    Statement statement4=ConnexionMySQL.connection.createStatement();
                    ResultSet resultSet4=statement4.executeQuery("SELECT * from modele where id_type_voiture="+type.getId());
                    resultSet4.first();

                    modele.setNumero(resultSet4.getString("numero"));
                    modele.setPrix(Double.parseDouble(resultSet4.getString("prix")));
                    modele.setId(resultSet4.getInt("id_modele"));
                    modele.setNomModele(resultSet4.getString("nom_modele"));
                    modele.setCouleur(resultSet4.getString("couleur"));
                    modele.setKm(Integer.parseInt(resultSet4.getString("km")));
                    modele.setDateSortie(resultSet4.getString("date_sortie"));
                    modele.setImagePath(resultSet4.getString("image"));
                    System.out.println(resultSet4.getString("image"));

                    Moteur moteur=new Moteur();
                    moteur.setId(resultSet4.getInt("id_moteur"));
                    modele.setMoteur(moteur);

                    Statement statement5=ConnexionMySQL.connection.createStatement();
                    ResultSet resultSet5=statement5.executeQuery("SELECT * from moteur where id_moteur="+moteur.getId());
                    resultSet5.first();

                    moteur.setNomMoteur(resultSet5.getString("nom_moteur"));
                    moteur.setCarburant(resultSet5.getString("carburant"));
                    moteur.setPuissance(resultSet5.getString("puissance"));

                    sessionFournisseurVoitureList.add(voiture);
                }

                ConnexionMySQL.closeConnexion();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return sessionFournisseurVoitureList;
    }


    public static ArrayList<Voiture> getSessionAllVoitureList() {

        sessionAllVoitureList.clear();

            try {
                ConnexionMySQL.connectToDataBase();

                Statement statement=ConnexionMySQL.connection.createStatement();
                ResultSet resultSet=statement.executeQuery("SELECT * from voiture");
                resultSet.first();
                resultSet.previous();
                while (resultSet.next()){
                    Voiture voiture=new Voiture();
                    voiture.setId(resultSet.getInt("id_voiture"));
                    voiture.setFournisseur(sessionFournisseur);
                    voiture.setGarantie(resultSet.getString("garantie"));
                    voiture.setDateEntree(resultSet.getDate("date_entree"));

                    Marque marque=new Marque();
                    marque.setId(resultSet.getInt("id_marque"));
                    Statement statement1=ConnexionMySQL.connection.createStatement();
                    ResultSet resultSet1=statement1.executeQuery("SELECT nom_marque from marque where id_marque="+marque.getId());
                    resultSet1.first();
                    marque.setNomMarque(resultSet1.getString(1));
                    voiture.setMarque(marque);

                    TypeVoiture type=new TypeVoiture();
                    marque.setType(type);
                    Statement statement2=ConnexionMySQL.connection.createStatement();
                    ResultSet resultSet2=statement2.executeQuery("SELECT id_type_voiture from type_marque where id_marque="+marque.getId());
                    resultSet2.first();
                    type.setId(resultSet2.getInt(1));
                    Statement statement3=ConnexionMySQL.connection.createStatement();
                    ResultSet resultSet3=statement3.executeQuery("SELECT nom_type from type_voiture where id_type_voiture="+type.getId());
                    resultSet3.first();
                    type.setNomType(resultSet3.getString(1));

                    Modele modele=new Modele();
                    type.setModele(modele);
                    Statement statement4=ConnexionMySQL.connection.createStatement();
                    ResultSet resultSet4=statement4.executeQuery("SELECT * from modele where id_type_voiture="+type.getId());
                    resultSet4.first();

                    modele.setNumero(resultSet4.getString("numero"));
                    modele.setPrix(Double.parseDouble(resultSet4.getString("prix")));
                    modele.setId(resultSet4.getInt("id_modele"));
                    modele.setNomModele(resultSet4.getString("nom_modele"));
                    modele.setCouleur(resultSet4.getString("couleur"));
                    modele.setKm(Integer.parseInt(resultSet4.getString("km")));
                    modele.setDateSortie(resultSet4.getString("date_sortie"));
                    modele.setImagePath(resultSet4.getString("image"));
                    System.out.println(resultSet4.getString("image"));

                    Moteur moteur=new Moteur();
                    moteur.setId(resultSet4.getInt("id_moteur"));
                    modele.setMoteur(moteur);

                    Statement statement5=ConnexionMySQL.connection.createStatement();
                    ResultSet resultSet5=statement5.executeQuery("SELECT * from moteur where id_moteur="+moteur.getId());
                    resultSet5.first();

                    moteur.setNomMoteur(resultSet5.getString("nom_moteur"));
                    moteur.setCarburant(resultSet5.getString("carburant"));
                    moteur.setPuissance(resultSet5.getString("puissance"));

                    sessionAllVoitureList.add(voiture);
                }

                ConnexionMySQL.closeConnexion();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        return sessionAllVoitureList;
    }



    public static ArrayList<Voiture> getSessionRechercheVoitureList() {

        sessionRechercheVoitureList.clear();

        if (sessionType==SESSION_TYPE.FOURNISSEUR) {
            try {
                ConnexionMySQL.connectToDataBase();

                Statement statement=ConnexionMySQL.connection.createStatement();
                ResultSet resultSet=statement.executeQuery("SELECT * from voiture where id_fournisseur="+getSessionFournisseur().getId());
                resultSet.first();
                resultSet.previous();
                while (resultSet.next()){
                    Voiture voiture=new Voiture();
                    voiture.setId(resultSet.getInt("id_voiture"));
                    voiture.setFournisseur(sessionFournisseur);
                    voiture.setGarantie(resultSet.getString("garantie"));
                    voiture.setDateEntree(resultSet.getDate("date_entree"));

                    Marque marque=new Marque();
                    marque.setId(resultSet.getInt("id_marque"));
                    Statement statement1=ConnexionMySQL.connection.createStatement();
                    ResultSet resultSet1=statement1.executeQuery("SELECT nom_marque from marque where id_marque="+marque.getId());
                    resultSet1.first();
                    marque.setNomMarque(resultSet1.getString(1));
                    voiture.setMarque(marque);

                    TypeVoiture type=new TypeVoiture();
                    marque.setType(type);
                    Statement statement2=ConnexionMySQL.connection.createStatement();
                    ResultSet resultSet2=statement2.executeQuery("SELECT id_type_voiture from type_marque where id_marque="+marque.getId());
                    resultSet2.first();
                    type.setId(resultSet2.getInt(1));
                    Statement statement3=ConnexionMySQL.connection.createStatement();
                    ResultSet resultSet3=statement3.executeQuery("SELECT nom_type from type_voiture where id_type_voiture="+type.getId());
                    resultSet3.first();
                    type.setNomType(resultSet3.getString(1));

                    Modele modele=new Modele();
                    type.setModele(modele);
                    Statement statement4=ConnexionMySQL.connection.createStatement();
                    ResultSet resultSet4=statement4.executeQuery("SELECT * from modele where id_type_voiture="+type.getId());
                    resultSet4.first();

                    modele.setNumero(resultSet4.getString("numero"));
                    modele.setPrix(Double.parseDouble(resultSet4.getString("prix")));
                    modele.setId(resultSet4.getInt("id_modele"));
                    modele.setNomModele(resultSet4.getString("nom_modele"));
                    modele.setCouleur(resultSet4.getString("couleur"));
                    modele.setKm(Integer.parseInt(resultSet4.getString("km")));
                    modele.setDateSortie(resultSet4.getString("date_sortie"));
                    modele.setImagePath(resultSet4.getString("image"));
                    System.out.println(resultSet4.getString("image"));

                    Moteur moteur=new Moteur();
                    moteur.setId(resultSet4.getInt("id_moteur"));
                    modele.setMoteur(moteur);

                    Statement statement5=ConnexionMySQL.connection.createStatement();
                    ResultSet resultSet5=statement5.executeQuery("SELECT * from moteur where id_moteur="+moteur.getId());
                    resultSet5.first();

                    moteur.setNomMoteur(resultSet5.getString("nom_moteur"));
                    moteur.setCarburant(resultSet5.getString("carburant"));
                    moteur.setPuissance(resultSet5.getString("puissance"));

                    sessionFournisseurVoitureList.add(voiture);
                }

                ConnexionMySQL.closeConnexion();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return sessionFournisseurVoitureList;
    }


    public static Voiture getSessionFocusedVoiture() {
        return sessionFocusedVoiture;
    }

    public static void setSessionFocusedVoiture(Voiture sessionFocusedVoiture) {
        Session.sessionFocusedVoiture = sessionFocusedVoiture;
    }

    public static void closeSession() {
        sessionType = null;
        sessionFocusedVoiture = null;
        sessionRechercheVoitureList.clear();
        sessionFournisseurVoitureList.clear();
        sessionFournisseur = null;
    }

    public static ArrayList<ArrayList<Voiture>> getSessionVoiturePagesList() {
        return sessionVoiturePagesList;
    }

    public static void setSessionVoiturePagesList(ArrayList<ArrayList<Voiture>> sessionVoiturePagesList) {
        Session.sessionVoiturePagesList = sessionVoiturePagesList;
    }
}
