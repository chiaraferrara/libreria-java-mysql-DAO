package dao;

import datasource.ConnectionDBH;
import model.Libro;

import java.io.IOException;
import java.sql.*;

public class ConcreteLibroDAO implements LibroDAO{

    private final ConnectionDBH connection_db;

    public ConcreteLibroDAO(ConnectionDBH connectionDBH) {
        this.connection_db = connectionDBH;
    }

    public void add(Libro item) throws IOException {
        PreparedStatement preparedStatement = connection_db.getConnectData().prepareStatement("") //inserire qualcosa qui

    }


    public void readLibri() {

        String url = "jdbc:mysql://localhost:3306/libreria";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            //query ritorna tutti gli oggetti della libreria
            ResultSet resultSet = statement.executeQuery("select * from libro");
            //vogliamo mostrare tutti gli oggetti della libreria e per questo utilizziamo il resultSet e l'indice della tabella.
            while(resultSet.next()){
                System.out.println(resultSet.getString(1) + "\n " + resultSet.getString(2) + "\n " + resultSet.getString(3));
                //chiudiamo la connessione

            }connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public void updateLibro(String isbn) {

    }


    public void delete(String isbn) {

    }
}
