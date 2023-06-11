
package hotel.management;

import java.awt.Color;


public class Dialog extends javax.swing.JFrame {

    public Dialog() {
        initComponents();
      setBackground(new Color(0,0,0,0));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lb_noStayOnPage = new javax.swing.JLabel();
        lb_yesExit = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lb_logout = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new Color(0,0,0,0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_noStayOnPage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_noStayOnPage.setForeground(new java.awt.Color(255, 255, 255));
        lb_noStayOnPage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_noStayOnPage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_no_entry_25px.png"))); // NOI18N
        lb_noStayOnPage.setText(" No");
        lb_noStayOnPage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_noStayOnPageMouseClicked(evt);
            }
        });
        jPanel1.add(lb_noStayOnPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, 90, 60));

        lb_yesExit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_yesExit.setForeground(new java.awt.Color(255, 255, 255));
        lb_yesExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_yesExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_checked_25px_2.png"))); // NOI18N
        lb_yesExit.setText(" Yes");
        lb_yesExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_yesExitMouseClicked(evt);
            }
        });
        jPanel1.add(lb_yesExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 390, 80, 60));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ARE YOU SURE YOU WANT TO EXIT THE  SYSTEM .. !");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, 480, 50));

        lb_logout.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_logout.setForeground(new java.awt.Color(255, 255, 255));
        lb_logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_login_25px.png"))); // NOI18N
        lb_logout.setText(" Logout");
        lb_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_logoutMouseClicked(evt);
            }
        });
        jPanel1.add(lb_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, 90, 60));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/Untitled-1.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -130, 1620, 1000));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 760));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lb_yesExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_yesExitMouseClicked
        if(Admin_Home.getObj().isShowing()){      //closing another panel if its active
                  Admin_Home.getObj().dispose();
                  System.exit(0);
                 }else{
                     System.exit(0);
                }
    }//GEN-LAST:event_lb_yesExitMouseClicked

    private void lb_noStayOnPageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_noStayOnPageMouseClicked
        this.dispose();
    }//GEN-LAST:event_lb_noStayOnPageMouseClicked

    private void lb_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_logoutMouseClicked

                         //closing another panel if its active
                //  Admin_Home.getObj().setVisible(false);
                
                    Logout_page frame = new Logout_page();
                    this.dispose();
                     frame.setVisible(true);
                 
                 
    
    }//GEN-LAST:event_lb_logoutMouseClicked

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
            java.util.logging.Logger.getLogger(Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dialog().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb_logout;
    private javax.swing.JLabel lb_noStayOnPage;
    private javax.swing.JLabel lb_yesExit;
    // End of variables declaration//GEN-END:variables
}
