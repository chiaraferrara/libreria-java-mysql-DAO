package dao;
import datasource.ConnectionDBH;
import model.Libro;
import java.io.*;
import java.sql.*;
import java.util.*;

//I Prepared Statement (letteralmente “dichiarazioni preparate”) sono modelli già pronti all'uso per
// le interrogazioni nei sistemi di database in SQL, che non contengono valori per i singoli parametri.
public class ConcreteLibroDAO implements LibroDAO{

    private final ConnectionDBH connection_db;

    public ConcreteLibroDAO(ConnectionDBH connectionDBH) {
        //IMPORTANTE, avevo errore : crea istanza ConnectionDBH!
        this.connection_db = new ConnectionDBH();
    }

    public void add() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci le info del libro:\n");
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Titolo: ");
        String titolo = scanner.nextLine();
        System.out.print("Autore: ");
        String autore = scanner.nextLine();
//la query è una isttuzione SQL che in questo caso aggiunge libro alla table -> ? , ? , ? specifichiamo i valori da inserire con dei segnaposto (?)
        String query = "INSERT INTO libro (isbn, titolo, autore) VALUES (?, ?, ?)";

        try (Connection connection = connection_db.getConnectData();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, isbn);
            preparedStatement.setString(2, titolo);
            preparedStatement.setString(3, autore);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Libro inserito con successo.");
            } else {
                System.out.println("Nessun libro inserito.");
            }
        } catch (SQLException e) {
            System.out.println("Errore durante l'inserimento del libro: " + e.getMessage());
        }
    }




    public void readLibri() {

        String url = "jdbc:mysql://localhost:3306/mysql";
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
