
package Controlador;

import Modelo.Libro;
import javax.swing.JTable;

public class MetodosLibro {

    public static Libro obtenerInformacionLibro(int filaSelect, JTable tblDatos) {

        Libro libro = null;
        String titulo = tblDatos.getValueAt(filaSelect, 0).toString();
        String autor = tblDatos.getValueAt(filaSelect, 1).toString();
        String isbn = tblDatos.getValueAt(filaSelect, 2).toString();
        int paginas = Integer.parseInt(tblDatos.getValueAt(filaSelect, 3).toString());
        boolean disponible = tblDatos.getValueAt(filaSelect, 4).toString().equalsIgnoreCase("true");

        // Crear un objeto Libro con los datos de la fila
        libro = new Libro(titulo, autor, isbn, paginas);
        libro.setDisponible(disponible);

        return libro;
    }
}
