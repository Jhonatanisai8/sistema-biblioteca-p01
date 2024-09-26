package Modelo;
public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private int numPaginas;
    private boolean disponible;
    
    public Libro() {
    }
    
    public Libro(String titulo, String autor, String isbn, int numPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.numPaginas = numPaginas;
        this.disponible = true;
    }

    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public String getAutor() {return autor;}
    public void setAutor(String autor) {this.autor = autor;}
    public String getIsbn() {return isbn;}
    public void setIsbn(String isbn) {this.isbn = isbn;}
    public int getNumPaginas() {return numPaginas;}
    public void setNumPaginas(int numPaginas) {this.numPaginas = numPaginas; }
    public boolean isDisponible() {return disponible;}

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String mostrarInformacion() {
        return "\nLibro: "
                + "\nTitulo     : " + titulo
                + "\nautor      : " + autor
                + "\nisbn       : " + isbn
                + "\nnumPaginas : " + numPaginas
                + "\ndisponible : " + disponible;
    }

    public void prestar() {
        if (disponible) {
            this.disponible = false;
        }
    }

    public String devolver() {
        this.disponible = true;
        return "El libro ah sido devuelvo";
    }

}
