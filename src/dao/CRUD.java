package dao;

import model.Libro;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

public interface CRUD<T> {
    void add(Libro item) throws IOException;

    void readLibri();

    void updateLibro(String isbn);

    void delete(String isbn);

}
