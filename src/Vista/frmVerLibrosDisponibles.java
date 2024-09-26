package Vista;

import Controlador.MetodosLibro;
import Controlador.MetodosUsuarios;
import Controlador.Principal;
import javax.swing.JOptionPane;

public class frmVerLibrosDisponibles extends javax.swing.JInternalFrame {

    public frmVerLibrosDisponibles() {
        initComponents();
        Principal.BIBLIOTECA.listarLibrosDisponiblesDesdeArchivo(tblDatos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        btnVerInformacion = new javax.swing.JButton();

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

        btnVerInformacion.setFont(new java.awt.Font("Segoe UI Black", 1, 16)); // NOI18N
        btnVerInformacion.setText("Ver Informacion del Libro");
        btnVerInformacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerInformacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 934, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVerInformacion, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerInformacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerInformacionActionPerformed
        int fila;
        fila = this.tblDatos.getSelectedRow();
        if (fila != -1) {
            frmVerInformacionLibro informacionLibro = new frmVerInformacionLibro(MetodosLibro.obtenerInformacionLibro(fila, tblDatos));
            frmMenu.mostrarPanel(informacionLibro);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "por favor seleccione un libro para ver su información.".toUpperCase(), "atención".toUpperCase(), JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnVerInformacionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVerInformacion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDatos;
    // End of variables declaration//GEN-END:variables
}
