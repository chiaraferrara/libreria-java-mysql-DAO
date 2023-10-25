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


}
