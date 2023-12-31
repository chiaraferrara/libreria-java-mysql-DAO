import dao.ConcreteLibroDAO;
import datasource.ConnectionDBH;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static datasource.ConnectionDBH ConnectionDBH;

    public static void main(String[] args) throws IOException, SQLException {
        boolean exit = false;
        int scelta;
        ConnectionDBH connectionDBH = new ConnectionDBH();
        ConcreteLibroDAO concreteLibroDAO = new ConcreteLibroDAO(connectionDBH);
        while (exit == false) {
            System.out.print("-----------------------------" +
                    "\nCosa vorresti fare?\n" +
                    "1) Aggiungi libro\n" +
                    "2) Visualizza Libri\n" +
                    "3) Modifica Libro\n" +
                    "4) Rimuovi Libro\n" +
                    "5) Esci \n\n" +
                    "Inserisci il numero della tua scelta.\n" +
                    "-----------------------------\n");
            Scanner s = new Scanner(System.in);
            scelta = s.nextInt();
            switch (scelta){
                case 1:

                    concreteLibroDAO.add();
                    break;
                case 2:
                    concreteLibroDAO.readLibri();
                    break;
                case 3:
                    concreteLibroDAO.updateLibro();
                    break;
                case 4:
                    concreteLibroDAO.delete();
                    break;
                case 5:
                    exit = true;
                    break;
            }
        }
    }
}