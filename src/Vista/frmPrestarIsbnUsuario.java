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

public class frmPrestarIsbnUsuario extends javax.swing.JInternalFrame {

    Vector<String> cabezera = new Vector<>();
    DefaultTableModel miModelo;
    Usuario usuario;
    ArrayList<Libro> listaLibros;

    public frmPrestarIsbnUsuario(Usuario usuario1) {
        initComponents();
        this.inicializar();
        this.usuario = usuario1;
        lblUsuario.setText("Usuario: " + usuario.getNombre().toUpperCase());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnListar = new javax.swing.JButton();
        btnPrestarLibro1 = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ACCIONES:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Rockwell Extra Bold", 1, 18))); // NOI18N

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

        lblUsuario.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 15)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPrestarLibro1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnListar)
                        .addGap(28, 28, 28)))
                .addContainerGap(85, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnPrestarLibro1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListar)
                .addGap(17, 17, 17))
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        listarLibrosTabla();
    }//GEN-LAST:event_btnListarActionPerformed

    private void btnPrestarLibro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrestarLibro1ActionPerformed
        listarLibrosTabla();

        int filaSeleccionada = this.tblDatos.getSelectedRow();

        if (filaSeleccionada != -1) {
            String isbn = tblDatos.getValueAt(filaSeleccionada, 2).toString();  // ISBN está en la columna 2

            boolean prestamoExitoso = Principal.BIBLIOTECA.prestarLibro(isbn, usuario);  // usuario es el que está usando el sistema

            if (prestamoExitoso) {
                JOptionPane.showMessageDialog(rootPane, "El libro ha sido prestado".toUpperCase(), "Atención", JOptionPane.INFORMATION_MESSAGE);

                listaLibros = Principal.BIBLIOTECA.getListaLibros();
                MetodosUsuarios.guardarLibrosEnArchivo(listaLibros);

                actualizarTabla();
            } else {
                JOptionPane.showMessageDialog(rootPane, "El libro no está disponible".toUpperCase(), "Atención", JOptionPane.INFORMATION_MESSAGE);
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
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTable tblDatos;
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
