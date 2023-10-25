package dao;

import model.Libro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class ConcreteLibroDAO implements LibroDAO{


    public void add(Libro item) throws IOException {

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
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
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
