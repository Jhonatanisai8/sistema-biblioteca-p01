package Vista;

import Controlador.MetodosUsuarios;
import Controlador.Principal;
import Modelo.Libro;
import Modelo.Usuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmMostrarInfoUsuarioLibros extends javax.swing.JInternalFrame {

    Usuario usuario;
    DefaultTableModel model;

    public frmMostrarInfoUsuarioLibros(Usuario usuario1) {
        initComponents();
        this.usuario = usuario1;
        model = new DefaultTableModel(new String[]{"Título", "Autor", "ISBN", "Estado"}, 0);
// Ajusta los nombres de las columnas según tus necesidades
        tblDatos.setModel(model);
        this.txaInformacion.append(usuario.toString());
        limpiarTabla();
        usuario.mostrarLibrosPrestamos(model, tblDatos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaInformacion = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        btnDevolverLibro = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INFORMACION DEL USUARIO:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Rockwell Extra Bold", 1, 18))); // NOI18N

        txaInformacion.setEditable(false);
        txaInformacion.setColumns(20);
        txaInformacion.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 15)); // NOI18N
        txaInformacion.setRows(5);
        jScrollPane2.setViewportView(txaInformacion);

        tblDatos.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 12)); // NOI18N
        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDatos);

        btnDevolverLibro.setText("Devolver Libro");
        btnDevolverLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverLibroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDevolverLibro, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDevolverLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatosMouseClicked
        //        enviarUsuario();
    }//GEN-LAST:event_tblDatosMouseClicked

    private void btnDevolverLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverLibroActionPerformed
        int filaSeleccionada = tblDatos.getSelectedRow();

        if (filaSeleccionada != -1) {
            String isbn = tblDatos.getValueAt(filaSeleccionada, 2).toString();

            boolean libroDevuelto = Principal.BIBLIOTECA.devolverLibro(isbn, usuario);

            if (libroDevuelto) {
                Libro libro = Principal.BIBLIOTECA.buscarLibroPorISBN(isbn);
                if (libro != null) {
                    libro.setDisponible(true); 
                }

                usuario.eliminarLibroPrestado(isbn); 

                ArrayList<Libro> listaLibros = Principal.BIBLIOTECA.getListaLibros();
                MetodosUsuarios.guardarLibrosEnArchivo(listaLibros);

                JOptionPane.showMessageDialog(rootPane, "El libro ha sido devuelto".toUpperCase(), "Atención", JOptionPane.INFORMATION_MESSAGE);

                limpiarTabla();

                usuario.mostrarLibrosPrestamos(model, tblDatos);

            } else {
                JOptionPane.showMessageDialog(this, "El libro no se encuentra en la biblioteca.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un libro en la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnDevolverLibroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDevolverLibro;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextArea txaInformacion;
    // End of variables declaration//GEN-END:variables

    //metodo para limpiar el modelo de la tabla
    private void limpiarTabla() {
        if (model != null) {
            model.setRowCount(0); 
        }
    }
}
