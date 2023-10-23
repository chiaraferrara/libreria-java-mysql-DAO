package model;

public class Libro {
    public  String titolo;
    public String isbn;

public Libro(String titolo, String isbn){

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
