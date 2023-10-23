package dao;

import model.Libro;

import java.io.IOException;
import java.util.List;

public class ConcreteLibroDAO implements LibroDAO{

    @Override
    public void add(Libro item) throws IOException {

    }

    @Override
    public List<Libro> readLibri() {
        return null;
    }

    @Override
    public void updateLibro(String isbn) {

    }

    @Override
    public void delete(String isbn) {

    }
}
