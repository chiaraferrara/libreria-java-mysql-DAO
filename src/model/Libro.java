package model;
import java.sql.*;

public class Libro {
    public String autore;
    public  String titolo;
    public String isbn;

public Libro(String autore,String titolo, String isbn){

}

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Libro: \n" +
                "titolo: " + titolo + '\n' +
                "isbn: " + isbn + '\n';
    }

    public static void main(String[] args) {
    //nome del database
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
                connection.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
