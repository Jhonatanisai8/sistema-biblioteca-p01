package Modelo;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Usuario {

    private String nombre;
    private String dni;
    private ArrayList<Libro> librosPrestamos;

    public Usuario(String nombre, String dni) {
        librosPrestamos = new ArrayList<>();
        this.nombre = nombre;
        this.dni = dni;
    }

    public Object[] Registro(int num) {
        Object[] fila = {nombre, dni};
        return fila;
    }

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getDni() {return dni; }
    public void setDni(String dni) {this.dni = dni;}
    public ArrayList<Libro> getLibrosPrestamos() {return librosPrestamos;}
    public void setLibrosPrestamos(ArrayList<Libro> librosPrestamos) {this.librosPrestamos = librosPrestamos;}

    @Override
    public String toString() {
        String info = "\nUsuario "
                + "\nNombre         : " + nombre
                + "\nDni            : " + dni
                + "\nLibrosPrestamos: ";
        return info;
    }

    public void mostrarLibrosPrestamos(DefaultTableModel modeloTabla, JTable tblLibrosPrestamos) {
        String[] columnas = {"TÍTULO", "AUTOR", "ISBN", "PÁGINAS", "DISPONIBLE"};

        modeloTabla = new DefaultTableModel(columnas, 0);
        for (Libro libro : librosPrestamos) {
            // Crear una fila con los datos del libro
            Object[] fila = {
                libro.getTitulo(),
                libro.getAutor(),
                libro.getIsbn(),
                libro.getNumPaginas(),
                libro.isDisponible()
            };

            modeloTabla.addRow(fila);
        }

        // Asignar el modelo a la tabla
        tblLibrosPrestamos.setModel(modeloTabla);
    }

    public boolean prestarLibro(Libro libro) {
        if (libro.isDisponible()) {
            librosPrestamos.add(libro);
            libro.prestar();
            return true;
        } else {
            return false;
        }
    }

    public void devolverLibro(Libro libro) {
        librosPrestamos.remove(libro); // Asegúrate de que esto elimine el libro correctamente
    }

    public void eliminarLibroPrestado(String isbn) {
        librosPrestamos.removeIf(libro -> libro.getIsbn().equals(isbn)); // Eliminar por ISBN
    }

}
