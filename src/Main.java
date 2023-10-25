import dao.ConcreteLibroDAO;
import datasource.ConnectionDBH;

public class Main {
    private static datasource.ConnectionDBH ConnectionDBH;

    public static void main(String[] args) {
        ConcreteLibroDAO concreteLibroDAO = new ConcreteLibroDAO(ConnectionDBH);
        concreteLibroDAO.readLibri();

    }
}