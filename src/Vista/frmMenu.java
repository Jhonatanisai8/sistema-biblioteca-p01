package Vista;

import javax.swing.JInternalFrame;

public class frmMenu extends javax.swing.JFrame {

    public frmMenu() {
        initComponents();
    }

    public static void mostrarPanel(JInternalFrame d) {
        frmMenu.dspEscritorio.add(d);
        d.toFront();
        d.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        dspEscritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        munLibros = new javax.swing.JMenu();
        munRegistroLibros = new javax.swing.JMenuItem();
        munMostrarLibrosDisponibles = new javax.swing.JMenuItem();
        munUsuarios = new javax.swing.JMenu();
        munRegistrarUsuario = new javax.swing.JMenuItem();
        munMostrarUsuarios = new javax.swing.JMenuItem();
        munSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout dspEscritorioLayout = new javax.swing.GroupLayout(dspEscritorio);
        dspEscritorio.setLayout(dspEscritorioLayout);
        dspEscritorioLayout.setHorizontalGroup(
            dspEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
        );
        dspEscritorioLayout.setVerticalGroup(
            dspEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 483, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dspEscritorio)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dspEscritorio)
        );

        munLibros.setText("Libros");
        munLibros.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        munRegistroLibros.setText("Registrar Libro");
        munRegistroLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                munRegistroLibrosActionPerformed(evt);
            }
        });
        munLibros.add(munRegistroLibros);

        munMostrarLibrosDisponibles.setText("Mostrar Libros Disponibles");
        munMostrarLibrosDisponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                munMostrarLibrosDisponiblesActionPerformed(evt);
            }
        });
        munLibros.add(munMostrarLibrosDisponibles);

        jMenuBar1.add(munLibros);

        munUsuarios.setText("Usuarios");
        munUsuarios.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        munRegistrarUsuario.setText("Registrar Usuario");
        munRegistrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                munRegistrarUsuarioActionPerformed(evt);
            }
        });
        munUsuarios.add(munRegistrarUsuario);

        munMostrarUsuarios.setText("Mostrar Usuarios");
        munMostrarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                munMostrarUsuariosActionPerformed(evt);
            }
        });
        munUsuarios.add(munMostrarUsuarios);

        jMenuBar1.add(munUsuarios);

        munSalir.setText("Salir");
        munSalir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jMenuBar1.add(munSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void munRegistroLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_munRegistroLibrosActionPerformed
        frmRegistrarLibro d = new frmRegistrarLibro();
        this.dspEscritorio.add(d);
        d.toFront();
        d.setVisible(true);
    }//GEN-LAST:event_munRegistroLibrosActionPerformed

    private void munRegistrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_munRegistrarUsuarioActionPerformed
        frmRegistrarUsuario d = new frmRegistrarUsuario();
        this.dspEscritorio.add(d);
        d.toFront();
        d.setVisible(true);
    }//GEN-LAST:event_munRegistrarUsuarioActionPerformed

    private void munMostrarLibrosDisponiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_munMostrarLibrosDisponiblesActionPerformed
        frmVerLibrosDisponibles d = new frmVerLibrosDisponibles();
        this.dspEscritorio.add(d);
        d.toFront();
        d.setVisible(true);
    }//GEN-LAST:event_munMostrarLibrosDisponiblesActionPerformed

    private void munMostrarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_munMostrarUsuariosActionPerformed
        frmMostrarUsuarios d = new frmMostrarUsuarios();
        this.dspEscritorio.add(d);
        d.toFront();
        d.setVisible(true);
    }//GEN-LAST:event_munMostrarUsuariosActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane dspEscritorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu munLibros;
    private javax.swing.JMenuItem munMostrarLibrosDisponibles;
    private javax.swing.JMenuItem munMostrarUsuarios;
    private javax.swing.JMenuItem munRegistrarUsuario;
    private javax.swing.JMenuItem munRegistroLibros;
    private javax.swing.JMenu munSalir;
    private javax.swing.JMenu munUsuarios;
    // End of variables declaration//GEN-END:variables
}
