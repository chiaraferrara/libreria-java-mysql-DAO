package datasource;

import java.sql.*;

public class ConnectionDBH {
    private static Connection connectData = null;
    private ConnectionDBH(){
        String url = "jdbc:mysql://localhost:3306/libreria";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Connection getConnectData() {
        return connectData;
    }
}
