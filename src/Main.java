import dao.ConcreteLibroDAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        ConcreteLibroDAO concreteLibroDAO = new ConcreteLibroDAO();
        concreteLibroDAO.readLibri();

    }
}