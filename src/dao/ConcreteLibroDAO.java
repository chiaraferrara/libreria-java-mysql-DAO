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


    public void updateLibro() throws SQLException {
        System.out.println("Inserisci isbn del libro che vuoi modificare.");
        Scanner i = new Scanner(System.in);
        String isbn = i.nextLine();
        String query = "SELECT * FROM libro WHERE isbn = ?";
        //voglio che una volta inserito l'isbn mostri i campi così da rendersi conto che l'isbn inserito è del libro che vogliamo modificare.
        try(Connection connection = connection_db.getConnectData(); //uso il metodo che mi ritorna la connessione...
            PreparedStatement preparedStatement = connection.prepareStatement(query)){ //la query specificata sopra richiamata qui per eseguirla con il metodo sql PrepareStatement.
            //imposto parametro dell'ISBN nella query
            preparedStatement.setString(1, isbn);
            //con il ResultSet ottengo il risultato
            ResultSet resultSet = preparedStatement.executeQuery();

            //se trova l'isbn
            if (resultSet.next()){
                String isbnr = resultSet.getString("isbn");
                String titolor = resultSet.getString("titolo");
                String autorer = resultSet.getString("autore");
                System.out.println("Le informazioni del tuo libro sono:\n" +
                        "Titolo:" +
                        titolor +
                        "\n" +
                        "Autore:" +
                        autorer +
                        "\n" +
                        "isbn:" +
                        isbnr);

            } else{
                System.out.println("Non ho trovato nessun libro con quell'isbn. Ritenta.");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        //qui avviene la scelta del campo da modificare...
        System.out.println("Quale campo vuoi modificare?" +
                "1) Titolo\n" +
                "2) Autore\n" +
                "3) Annulla");
            Scanner s = new Scanner(System.in);
            int scelta = s.nextInt();
            if(scelta == 1){
                //scelta == 1 per modifica titolo
                String query1 = "UPDATE libro SET titolo = ? WHERE isbn = ?";

                System.out.println("Qual è il nuovo titolo?\n");
                Scanner nt = new Scanner(System.in);
                String nuovoTitolo = nt.nextLine();


                try(
                    Connection connection = connection_db.getConnectData();
                    PreparedStatement preparedStatement = connection.prepareStatement(query1)){
                    preparedStatement.setString(1, nuovoTitolo);
            //metodo viene utilizzato per eseguire un'operazione di aggiornamento dei dati EXECUTE UPDATE
                    int colonnaAggiornata = preparedStatement.executeUpdate();
                    if(colonnaAggiornata>0){
                        System.out.println("Campo modificato");
                    }else {
                        System.out.println("ERRORE: Campo non modificato.");
                    }
                }catch (SQLException e){
                    System.out.println(e);

                }


            } else if (scelta == 2) {
                //scelta == 2 per modifica autore
                String query2 = "UPDATE libro SET autore = ? WHERE isbn = ?";
                System.out.println("Qual è il nuovo autore?\n");
                Scanner na = new Scanner(System.in);
                String nuovoAutore = na.nextLine();


                try(
                        Connection connection = connection_db.getConnectData();
                        PreparedStatement preparedStatement = connection.prepareStatement(query2)){
                    preparedStatement.setString(1, nuovoAutore);
                    //metodo viene utilizzato per eseguire un'operazione di aggiornamento dei dati EXECUTE UPDATE
                    int colonnaAggiornata = preparedStatement.executeUpdate();
                    if(colonnaAggiornata>0){
                        System.out.println("Campo modificato");
                    }else {
                        System.out.println("ERRORE: Campo non modificato.");
                    }
                }catch (SQLException e){
                    System.out.println(e);

                }
            }else {
                System.out.println("Operazione di modifica annullata.");
            }


    }


    public void delete(String isbn) {

    }
}
