package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Biblioteca {

    private String nombre;
    private ArrayList<Libro> listaLibros;
    private ArrayList<Usuario> listaUsuarios;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        listaLibros = new ArrayList<>();
        listaUsuarios = new ArrayList<>();
    }

    public String getNombre() {return nombre; }
    public void setNombre(String nombre) {this.nombre = nombre; }
    public ArrayList<Libro> getListaLibros() {return listaLibros;}
    public void setListaLibros(ArrayList<Libro> listaLibros) {this.listaLibros = listaLibros;}
    public ArrayList<Usuario> getListaUsuarios() {return listaUsuarios;}
    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {this.listaUsuarios = listaUsuarios;}
    public void addLibro(Libro libro) {this.listaLibros.add(libro); }
    public void addUsuario(Usuario usuario) {this.listaUsuarios.add(usuario); }
    
    public Libro buscarLibroPorISBN(String isbn) {
        for (Libro libro : listaLibros) {
            if (libro.getIsbn().equalsIgnoreCase(isbn)) {
                return libro;
            }
        }
        return null;
    }

    public boolean prestarLibro(String isbn, Usuario usuario) {
        Libro libro = buscarLibroPorISBN(isbn);
        if (libro != null && libro.isDisponible()) {
            usuario.prestarLibro(libro);
            return true;
        } else {
            return false;
        }
    }

    public boolean devolverLibro(String isbn, Usuario usuario) {
        Libro libro = buscarLibroPorISBN(isbn);
        if (libro != null) {
            usuario.devolverLibro(libro);
            return true;
        } else {
            return false;
        }
    }

    public static void listarLibrosDisponiblesDesdeArchivo(JTable tblLibrosDisponibles) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("TÍTULO");
        modeloTabla.addColumn("AUTOR");
        modeloTabla.addColumn("ISBN");
        modeloTabla.addColumn("PÁGINAS");
        modeloTabla.addColumn("DISPONIBLE");

        try ( BufferedReader br = new BufferedReader(new FileReader("Libros.txt"))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datosLibro = linea.split("\\|");
                if (datosLibro.length == 5) {
                    String titulo = datosLibro[0];
                    String autor = datosLibro[1];
                    String isbn = datosLibro[2];
                    int paginas = Integer.parseInt(datosLibro[3]);
                    boolean disponible = Boolean.parseBoolean(datosLibro[4]);

                    if (disponible) {
                        Object[] fila = {
                            titulo,
                            autor,
                            isbn,
                            paginas,
                            disponible // Mostrando true o false directamente
                        };

                        modeloTabla.addRow(fila);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de libros: " + e.getMessage());
        }

        tblLibrosDisponibles.setModel(modeloTabla);
    }

}
