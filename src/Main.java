import dao.ConcreteLibroDAO;
import datasource.ConnectionDBH;

import java.io.IOException;

public class Main {
    private static datasource.ConnectionDBH ConnectionDBH;

    public static void main(String[] args) throws IOException {
        ConnectionDBH connectionDBH = new ConnectionDBH();
        ConcreteLibroDAO concreteLibroDAO = new ConcreteLibroDAO(ConnectionDBH);
        concreteLibroDAO.readLibri();
        try {
            concreteLibroDAO.add();
        }catch (IOException e){
            System.out.println(e);
        }

    }
}