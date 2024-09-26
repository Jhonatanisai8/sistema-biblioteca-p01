package Controlador;

import Modelo.Biblioteca;
import Modelo.Libro;
import Modelo.Usuario;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MetodosUsuarios {

    public static String validarCamposFormularioRegistrarUsuario(
            JTextField txtNombre,
            JTextField txtDni
    ) {
        if (txtNombre.getText().isBlank()) {
            txtNombre.requestFocus();
            return "Nombre".toUpperCase();
        }
        if (txtDni.getText().isBlank()) {
            txtDni.requestFocus();
            return "dni".toUpperCase();
        }
        return "";
    }

    public static void mostrarUsuarios(JTable tabla, Biblioteca biblioteca) {
        String titulos[] = {"NOMBRE", "DNI"};
        DefaultTableModel mt = new DefaultTableModel(null,
                titulos);
        tabla.setModel(mt);
        for (int i = 0; i < biblioteca.getListaUsuarios().size(); i++) {
            mt.addRow(biblioteca.getListaUsuarios().get(i).Registro(i + 1));
        }
    }

    public static void limpiarCamposFormularioUsuarios(
            JTextField txtNombre,
            JTextField txtDni
    ) {
        txtDni.setText("");
        txtNombre.setText("");
        txtNombre.requestFocus();
    }

    public static Usuario buscarUsuario(String dni) {
        ArrayList<Usuario> listaUsuario = Principal.BIBLIOTECA.getListaUsuarios();

        if (listaUsuario == null || listaUsuario.isEmpty()) {
            System.out.println("La lista de usuarios está vacía o no se ha inicializado.");
            return null;
        }

        for (Usuario usuario : listaUsuario) {
            if (usuario.getDni().equalsIgnoreCase(dni)) {
                return usuario;
            }
        }
        return null;
    }

    public static ArrayList<Libro> obtenerLibrosDeTabla(DefaultTableModel modeloTabla) {
        ArrayList<Libro> listaLibros = new ArrayList<>();

        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            String titulo = modeloTabla.getValueAt(i, 0).toString();
            String autor = modeloTabla.getValueAt(i, 1).toString();
            String isbn = modeloTabla.getValueAt(i, 2).toString();
            int paginas = Integer.parseInt(modeloTabla.getValueAt(i, 3).toString());
            boolean disponible = Boolean.parseBoolean(modeloTabla.getValueAt(i, 4).toString());

            Libro libro = new Libro(titulo, autor, isbn, paginas);
            libro.setDisponible(disponible);
            listaLibros.add(libro);
        }

        return listaLibros;
    }

    public static void actualizarTablaLibros(ArrayList<Libro> listaLibros, JTable tblDatos) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tblDatos.getModel();

        modeloTabla.setRowCount(0);

        for (Libro libro : listaLibros) {
            Object[] fila = {
                libro.getTitulo(),
                libro.getAutor(),
                libro.getIsbn(),
                libro.getNumPaginas(),
                libro.isDisponible() 
            };
            modeloTabla.addRow(fila);
        }
    }

    public static void guardarLibrosEnArchivo(ArrayList<Libro> listaLibros) {
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter("Libros.txt"))) {
            for (Libro libro : listaLibros) {
                // cada libro en formato separado por "|"
                String libroData = libro.getTitulo() + "|" + libro.getAutor() + "|" + libro.getIsbn() + "|" + libro.getNumPaginas() + "|" + libro.isDisponible();
                bw.write(libroData);
                bw.newLine(); //nueva linea
            }
        } catch (IOException e) {
            System.out.println("Error al guardar libros: " + e.getMessage());
        }
    }
}
