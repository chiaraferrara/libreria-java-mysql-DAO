package datasource;

import java.sql.*;

//classe chiamata ConnectionDBH che gestisce la connessione al database
// 1) crea connessione
// 2) registra il driver https://mvnrepository.com/artifact/mysql/mysql-connector-java/8.0.25 POI File > Project Structure > Dependencies e carica il file JAR.
// 3) consente l'accesso restituendo la connessione (Connection)

public class ConnectionDBH {
    private Connection connectData;
    public ConnectionDBH(){
        String url = "jdbc:mysql://localhost:3306/mysql";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connectData = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Connection getConnectData() {
        String url = "jdbc:mysql://localhost:3306/mysql";
        String username = "root";
        String password = "";
        Connection connectData = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connectData = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println(e);
        }
        return connectData;
    }
}
