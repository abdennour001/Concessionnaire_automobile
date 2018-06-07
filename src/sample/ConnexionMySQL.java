package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by AMOKRANE Abdennour on 21/05/2018.
 */
public class ConnexionMySQL {

    public static Connection connection=null;

    public static final String HOST="localhost";
    public static final String USER="root";
    public static final String PASSWORD="";
    public static final String BDD="concession_automobile";

    public ConnexionMySQL() {

    }

    public static void connectToDataBase() throws SQLException {
        System.out.println("connexion ...");
        //Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://" + HOST + "/"+BDD+"?"+
                        "user=" + USER + "&password=" + PASSWORD );
        System.out.println("connected ...");
    }

    public static void closeConnexion() throws SQLException {
        connection.close();
    }

}
