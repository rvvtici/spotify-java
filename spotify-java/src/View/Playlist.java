/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import javax.swing.JLabel;
import Controller.ControlePlaylist;
import Model.Usuario;

/**
 *
 * @author ravi
 */
public class Playlist extends javax.swing.JFrame {

    private String user, nome, senha;
    public Playlist() {
        initComponents();
        c = new ControlePlaylist(this);
    }

    public Playlist(Usuario usuario){
        initComponents();
        
        user = usuario.getUsuario();
        nome = usuario.getNome();
        senha = usuario.getSenha();
        c = new ControlePlaylist(this);    
    }
    
    
    
    public JLabel getLbl_playlists() {
        return lbl_playlists;
    }

    public void setLbl_playlists(JLabel lbl_playlists) {
        this.lbl_playlists = lbl_playlists;
    }

    public JLabel getLbl_voltar() {
        return lbl_voltar;
    }

    public void setLbl_voltar(JLabel lbl_voltar) {
        this.lbl_voltar = lbl_voltar;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_voltar = new javax.swing.JLabel();
        lbl_playlists = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_voltar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lbl_voltar.setText("←");
        lbl_voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_voltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_voltarMouseClicked(evt);
            }
        });

        lbl_playlists.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lbl_playlists.setText("Playlists");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(lbl_voltar)
                .addGap(108, 108, 108)
                .addComponent(lbl_playlists)
                .addContainerGap(151, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_voltar)
                    .addComponent(lbl_playlists))
                .addContainerGap(247, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_voltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_voltarMouseClicked
        // TODO add your handling code here:
        // h = new Home();
        //h.setVisible(true);
        //this.setVisible(false);

        Usuario usuario2 = new Usuario(user,nome,senha);
        c.redirectPaginaHome(usuario2);
    }//GEN-LAST:event_lbl_voltarMouseClicked

    /**
     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Playlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Playlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Playlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Playlist.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Playlist().setVisible(true);
//            }
//        });
//    }

    private ControlePlaylist c;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl_playlists;
    private javax.swing.JLabel lbl_voltar;
    // End of variables declaration//GEN-END:variables
}
