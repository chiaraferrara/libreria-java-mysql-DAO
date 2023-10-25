package dao;

import model.Libro;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface CRUD<T> {
    void add() throws IOException;

    void readLibri();

    void updateLibro() throws SQLException;

    void delete() throws SQLException;

}
