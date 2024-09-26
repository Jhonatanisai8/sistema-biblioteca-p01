package Vista;

import Controlador.Metodos;
import Controlador.MetodosUsuarios;
import Controlador.Principal;
import Modelo.Libro;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmPrestar extends javax.swing.JInternalFrame {

    Vector<String> cabezera = new Vector<>();
    DefaultTableModel miModelo;
    Usuario usuario;
    ArrayList<Libro> listaLibros;

    public frmPrestar(Usuario usuario1) {
        initComponents();
        this.inicializar();
        this.usuario = usuario1;
        txtNombre.setText(usuario.getNombre());
        txtDni.setText(usuario.getDni());
        txtDni.setEnabled(false);
        txtNombre.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        txtDni = new javax.swing.JTextField();
        btnListar = new javax.swing.JButton();
        btnPrestarLibro1 = new javax.swing.JButton();

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
        jScrollPane1.setViewportView(tblDatos);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS DE USUARIO:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Rockwell Extra Bold", 1, 18))); // NOI18N

        txtNombre.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        txtNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Rockwell Extra Bold", 1, 18))); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtDni.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        txtDni.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dni:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Rockwell Extra Bold", 1, 18))); // NOI18N
        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });

        btnListar.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        btnPrestarLibro1.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        btnPrestarLibro1.setText("Prestar Libro");
        btnPrestarLibro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrestarLibro1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                        .addComponent(txtDni))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPrestarLibro1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnListar)
                                .addGap(28, 28, 28)))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159)
                .addComponent(btnPrestarLibro1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListar)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        listarLibrosTabla();
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnPrestarLibro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrestarLibro1ActionPerformed

        listarLibrosTabla();

        int filaSeleccionada = this.tblDatos.getSelectedRow();

        if (filaSeleccionada != -1) {
            String titulo = tblDatos.getValueAt(filaSeleccionada, 0).toString();
            String autor = tblDatos.getValueAt(filaSeleccionada, 1).toString();
            String isbn = tblDatos.getValueAt(filaSeleccionada, 2).toString();
            int paginas = Integer.parseInt(tblDatos.getValueAt(filaSeleccionada, 3).toString());
            boolean disponible = Boolean.parseBoolean(tblDatos.getValueAt(filaSeleccionada, 4).toString());

            Libro libro = new Libro(titulo, autor, isbn, paginas);
            libro.setDisponible(disponible);

            libro = Principal.BIBLIOTECA.buscarLibroPorISBN(isbn);

            if (libro != null) {
                if (usuario.prestarLibro(libro)) {
                    JOptionPane.showMessageDialog(rootPane, "El libro ha sido prestado".toUpperCase(), "Atención", JOptionPane.INFORMATION_MESSAGE);

                    listaLibros = Principal.BIBLIOTECA.getListaLibros();
                    MetodosUsuarios.guardarLibrosEnArchivo(listaLibros);

                    actualizarTabla();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "El libro no está disponible.".toUpperCase(), "Atención", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "El libro no se encuentra en la biblioteca.".toUpperCase(), "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un libro en la tabla.".toUpperCase(), "Advertencia", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_btnPrestarLibro1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnPrestarLibro1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    public void inicializar() {
        cabezera.addElement("TÍTULO");
        cabezera.addElement("AUTOR");
        cabezera.addElement("ISBN");
        cabezera.addElement("DISPONIBLE");
        miModelo = new DefaultTableModel(cabezera, 0);
        this.tblDatos.setModel(miModelo);
        this.tblDatos.setModel(Metodos.listarLibros());
    }

    public void actualizarTabla() {
        MetodosUsuarios.actualizarTablaLibros(listaLibros, tblDatos);
    }

    private void listarLibrosTabla() {
        listaLibros = MetodosUsuarios.obtenerLibrosDeTabla((DefaultTableModel) this.tblDatos.getModel());
        Principal.BIBLIOTECA.setListaLibros(listaLibros);
        for (Libro listaLibro : listaLibros) {
            System.out.println(listaLibro.mostrarInformacion());
        }
    }
}
