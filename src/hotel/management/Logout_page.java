/*  TASK TO COMPLETE
 * > on teacher display table  
 * making the log in take you to the last page you were
 * 
 */

package hotel.management;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Logout_page extends javax.swing.JFrame {

  Connection conn = null;
   PreparedStatement pps = null;
   ResultSet rs =null;
    public Logout_page() {
        initComponents();
        setBackground(new Color(66,66,66,50));
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Login_panel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lb_mini = new javax.swing.JLabel();
        lb_close = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new Color(66,66,66,50));
        jPanel1.setLayout(new java.awt.CardLayout());

        Login_panel.setBackground(new Color(0,0,0,0)
        );
        Login_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(121, 119, 119));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_add_key_30px.png"))); // NOI18N
        jLabel1.setText("  login");
        jLabel1.setToolTipText("sign up");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 140, 70));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("You Are Now logged out ...");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 230, 50));

        lb_mini.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_mini.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_minus_19px.png"))); // NOI18N
        lb_mini.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_miniMouseClicked(evt);
            }
        });
        jPanel2.add(lb_mini, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 60, 40));

        lb_close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_delete_18px_1.png"))); // NOI18N
        lb_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_closeMouseClicked(evt);
            }
        });
        jPanel2.add(lb_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 60, 40));

        Login_panel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 670, 260));

        bg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/login.gif"))); // NOI18N
        Login_panel.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, -1, 380));

        jPanel1.add(Login_panel, "card8");

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 790));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lb_miniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_miniMouseClicked

       
        if(Admin_Home.getObj().isShowing()){      //closing another panel if its active
            Admin_Home.getObj().setExtendedState(Admin_Home.ICONIFIED);
           }
        
// minimize
        this.setExtendedState(Login.ICONIFIED);
         Admin_Home.getObj().setVisible(false);

    }//GEN-LAST:event_lb_miniMouseClicked

    private void lb_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_closeMouseClicked
        // close frmae
        System.exit(0);
    }//GEN-LAST:event_lb_closeMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Login another = new Login();
        
        another.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

   
    
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
            java.util.logging.Logger.getLogger(Logout_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Logout_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Logout_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Logout_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Logout_page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Login_panel;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lb_close;
    private javax.swing.JLabel lb_mini;
    // End of variables declaration//GEN-END:variables
}
