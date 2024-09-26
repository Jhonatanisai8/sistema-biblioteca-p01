package Controlador;

import Modelo.Libro;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Metodos {

    public static String validarCamposRegistroLibro(
            JTextField txtTitulo,
            JTextField txtAutor,
            JTextField txtIbns,
            JSpinner spnPaginas
    ) {
        if (txtTitulo.getText().isBlank()) {
            txtTitulo.requestFocus();
            return "Titulo.".toUpperCase();
        }
        if (txtAutor.getText().isBlank()) {
            txtAutor.requestFocus();
            return "Autor.".toUpperCase();
        }

        if (txtIbns.getText().isBlank()) {
            txtIbns.requestFocus();
            return "isbn".toUpperCase();
        }

        if (Integer.parseInt(spnPaginas.getValue().toString()) == 0
                || Integer.parseInt(spnPaginas.getValue().toString()) < 0) {
            spnPaginas.requestFocus();
            return "Número de Páginas.".toUpperCase();
        }
        return "";
    }

    //procedimiento para guardar en un archivo txt
    public static void guardarArchivo(Libro libro) {
        try {
            FileWriter fw = new FileWriter("Libros.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.print(libro.getTitulo());
            pw.print("|" + libro.getAutor());
            pw.print("|" + libro.getIsbn());
            pw.print("|" + libro.getNumPaginas());
            pw.println("|" + libro.isDisponible());

            pw.close();

            JOptionPane.showMessageDialog(null, "LIBRO GUARDADO", "ATENCIÓN", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println("Error al guardar archivo: " + e.getMessage());
        }
    }

    public static DefaultTableModel listarLibros() {
        Vector cabeceras = new Vector();
        cabeceras.addElement("TÍTULO");
        cabeceras.addElement("AUTOR");
        cabeceras.addElement("ISBN");
        cabeceras.addElement("PÁPINAS");
        cabeceras.addElement("DISPONIBLE");

        DefaultTableModel mldTabla = new DefaultTableModel(cabeceras, 0);

        try {
            FileReader fr = new FileReader("Libros.txt");
            BufferedReader br = new BufferedReader(fr);
            String d;
            while ((d = br.readLine()) != null) {
                StringTokenizer dato = new StringTokenizer(d, "|");
                Vector x = new Vector();
                while (dato.hasMoreTokens()) {
                    x.addElement(dato.nextToken());
                }
                mldTabla.addRow(x);
            }
        } catch (IOException e) {
            System.out.println("Error al listar libros: " + e.getMessage());
        }
        return mldTabla;
    }

    public static void limpiarCamposFormualrioLibros(
            JTextField txtTitulo,
            JTextField txtAutor,
            JTextField txtIbns,
            JSpinner spnPaginas
    ) {
        txtAutor.setText("");
        txtIbns.setText("");
        txtTitulo.setText("");
        spnPaginas.setValue(0);
        txtTitulo.requestFocus();
    }

    public void guardarLibrosDesdeTabla(JTable tblDatos) {
        ArrayList<Libro> listaLibros = new ArrayList<>();

        DefaultTableModel model = (DefaultTableModel) tblDatos.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            String titulo = model.getValueAt(i, 0).toString();
            String autor = model.getValueAt(i, 1).toString();
            String isbn = model.getValueAt(i, 2).toString();
            int paginas = Integer.parseInt(model.getValueAt(i, 3).toString());
            boolean disponible = model.getValueAt(i, 4).toString().equalsIgnoreCase("true");

            // creamos un objeto Libro con los datos de la fila
            Libro libro = new Libro(titulo, autor, isbn, paginas);
            libro.setDisponible(disponible);

            // añadimos el libro a la lista
            listaLibros.add(libro);
        }

        // guardamos los libros en el archivo
        MetodosUsuarios.guardarLibrosEnArchivo(listaLibros);
    }

}
