package dao;

import model.Libro;

import java.io.IOException;
import java.util.List;

public interface CRUD<T> {
    void add(Libro item) throws IOException;

    List<T> readLibri();

    void updateLibro(String isbn);

    void delete(String isbn);

}
