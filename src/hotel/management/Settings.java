
package hotel.management;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Settings extends javax.swing.JFrame {

 
    Connection conn = null;
    PreparedStatement pps, pps1, pps2, pps3, pps4, pps6, pps5, pps7, pps8, pps9, pps10, pps11, pps12, pps13 = null;
    ResultSet rs, rs1, rs2, rs3, rs4, rs5, rs6, rs7, rs8, rs9, rs10, rs11, rs12, rs13 = null;
    
    
      private static String Recieved_user_id = null;
     private static String usertype = null;
    //passing user id
    private static Settings Obj = null;
    private String passed_user_id;
    

     Settings() {
        initComponents();
        update.hide();
       show_settings_info();       
    }

    
         //*********************************************************GETTING CURRENT USER ID
    public void setPassed_id(String Received_id) {
        passed_user_id = Received_id;
    }

    public String getPassed_id() {
        return passed_user_id;
    }

    public void printPassed_id() {
       Recieved_user_id =  getPassed_id();//setting the id of the user who logged in and set it to a global variable
       infoicon();
    }
    
    
    
      public void infoicon(){
       try {conn = DBConnection.getConnction();
            pps6 = conn.prepareStatement(" SELECT  * FROM  access WHERE access_id =?");
            pps6.setString(1,Recieved_user_id.trim()); 
            rs6 = pps6.executeQuery();
            while(rs6.next()){
            //    user_access_id  =  rs6.getString("access_id");

                 String fname=  rs6.getString("first_name");
                 String lname=  rs6.getString("last_name");
                 jLabel37.setText("Hi !"+fname +"  "+lname + "  Welcome Settings Manager");
                 model.setText(rs6.getString("user"));
              
                 
            
                }
            } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        left1 = new javax.swing.JPanel();
        left = new javax.swing.JPanel();
        Container = new javax.swing.JPanel();
        Settings_Inner_holder = new javax.swing.JPanel();
        panel_forGeneral = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        img_url = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_school_name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_school_email = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_school_address = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txt_school_motto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_school_mission_staement = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        txt_school_contact = new javax.swing.JTextField();
        img_bg = new javax.swing.JPanel();
        img_holder = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lb_saveBtn = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        update = new javax.swing.JLabel();
        img_bg1 = new javax.swing.JPanel();
        img_holder1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        img_url1 = new javax.swing.JTextField();
        admin_btn = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        exit_lb = new javax.swing.JLabel();
        minize_lb = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        model = new javax.swing.JLabel();
        header = new javax.swing.JLabel();
        front_holder = new javax.swing.JPanel();
        hotel_ma = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lb_GeneralSettings_btn = new javax.swing.JLabel();
        lb_GlobalSettings_btn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        left1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.add(left1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 750, 1390, 40));

        left.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.add(left, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 60, 30, 730));

        Container.setLayout(new java.awt.CardLayout());

        Settings_Inner_holder.setLayout(new java.awt.CardLayout());

        panel_forGeneral.setBackground(new java.awt.Color(255, 255, 255));
        panel_forGeneral.setPreferredSize(new java.awt.Dimension(1010, 956));
        panel_forGeneral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Logo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel_forGeneral.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, 30));

        jLabel14.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel14.setText("School Logo  ");
        panel_forGeneral.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 150, 50));
        panel_forGeneral.add(img_url, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 280, 40));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_slack_35px.png"))); // NOI18N
        panel_forGeneral.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 90, 70));

        jLabel15.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel15.setText("School Name");
        panel_forGeneral.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 130, 40));
        panel_forGeneral.add(txt_school_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 280, 40));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_profile_35px.png"))); // NOI18N
        panel_forGeneral.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 50, 70));

        jLabel11.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel11.setText("Email  Address");
        panel_forGeneral.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 470, 140, 40));
        panel_forGeneral.add(txt_school_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 470, 320, 40));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_home_address_35px.png"))); // NOI18N
        panel_forGeneral.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 90, 60));

        jLabel10.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel10.setText("Address");
        panel_forGeneral.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 120, 40));

        txt_school_address.setColumns(20);
        txt_school_address.setRows(5);
        jScrollPane2.setViewportView(txt_school_address);

        panel_forGeneral.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 280, 100));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_address_book_35px.png"))); // NOI18N
        panel_forGeneral.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 460, 70, 60));
        panel_forGeneral.add(txt_school_motto, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 280, 320, 40));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_fax_35px.png"))); // NOI18N
        panel_forGeneral.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, 70, 70));

        jLabel9.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_descending_sorting_35px.png"))); // NOI18N
        panel_forGeneral.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 360, 70, 70));
        panel_forGeneral.add(txt_school_mission_staement, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 380, 320, 40));

        jLabel12.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel12.setText("School Motto");
        panel_forGeneral.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 280, 120, 40));

        jLabel13.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel13.setText("Mission Statement");
        panel_forGeneral.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 380, 180, 40));

        jLabel56.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_address_book_35px.png"))); // NOI18N
        panel_forGeneral.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 70, 60));

        jLabel57.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel57.setText("Contact");
        panel_forGeneral.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 120, 40));
        panel_forGeneral.add(txt_school_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, 280, 40));

        img_bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        img_bg.add(img_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 150));

        panel_forGeneral.add(img_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 30, 150, 170));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_saveBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_saveBtn.setForeground(new java.awt.Color(153, 153, 153));
        lb_saveBtn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/balance.png"))); // NOI18N
        lb_saveBtn.setText("Save");
        lb_saveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_saveBtnMouseClicked(evt);
            }
        });
        jPanel2.add(lb_saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 0, 150, 70));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_administrative_tools_30px.png"))); // NOI18N
        jLabel1.setText(" School Info");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 170, 70));

        update.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        update.setForeground(new java.awt.Color(153, 153, 153));
        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_administrative_tools_30px.png"))); // NOI18N
        update.setText("Update School Info");
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });
        jPanel2.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 4, 170, 70));

        panel_forGeneral.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 1100, 70));

        img_bg1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        img_bg1.add(img_holder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 150));

        panel_forGeneral.add(img_bg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, 160, 170));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_slack_35px.png"))); // NOI18N
        panel_forGeneral.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 90, 70));

        jButton2.setText("Logo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panel_forGeneral.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 60, 30));

        jLabel17.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel17.setText("Minstry Logo ");
        panel_forGeneral.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 110, 50));
        panel_forGeneral.add(img_url1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 280, 40));

        Settings_Inner_holder.add(panel_forGeneral, "card4");

        Container.add(Settings_Inner_holder, "card3");

        jPanel1.add(Container, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 1110, -1));

        admin_btn.setBackground(new java.awt.Color(121, 119, 119));
        admin_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                admin_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                admin_btnMouseExited(evt);
            }
        });
        admin_btn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_upload_to_ftp_30px.png"))); // NOI18N
        jLabel42.setText("     Home");
        jLabel42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel42MouseClicked(evt);
            }
        });
        admin_btn.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 190, 40));

        jPanel1.add(admin_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 40));

        exit_lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit_lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_delete_18px_1.png"))); // NOI18N
        exit_lb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit_lbMouseClicked(evt);
            }
        });
        jPanel1.add(exit_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 0, 50, 60));

        minize_lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minize_lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_minus_19px.png"))); // NOI18N
        minize_lb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minize_lbMouseClicked(evt);
            }
        });
        jPanel1.add(minize_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 0, 40, 60));

        jLabel37.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Hi Admin,  Welcome To Your School Management");
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, 30));

        model.setForeground(new java.awt.Color(240, 240, 240));
        model.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        model.setText("jLabel2");
        jPanel1.add(model, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 10, 110, 40));

        header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/header.png"))); // NOI18N
        header.setText("jLabel7");
        jPanel1.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1380, 100));

        front_holder.setBackground(new java.awt.Color(121, 119, 119));
        front_holder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                front_holderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                front_holderMouseExited(evt);
            }
        });
        front_holder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hotel_ma.setBackground(new java.awt.Color(121, 119, 119));
        hotel_ma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hotel_maMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hotel_maMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hotel_maMouseExited(evt);
            }
        });
        hotel_ma.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_verified_account_30px.png"))); // NOI18N
        jLabel20.setText("    Settings");
        hotel_ma.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 60));

        front_holder.add(hotel_ma, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 200, 60));

        jPanel1.add(front_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 190, 650));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/background_admi.png"))); // NOI18N
        jLabel16.setText("jLabel16");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 30, -1, 840));

        lb_GeneralSettings_btn.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        lb_GeneralSettings_btn.setForeground(new java.awt.Color(153, 153, 153));
        lb_GeneralSettings_btn.setText("General ");
        lb_GeneralSettings_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_GeneralSettings_btnMouseClicked(evt);
            }
        });
        jPanel1.add(lb_GeneralSettings_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 90, 30));

        lb_GlobalSettings_btn.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        lb_GlobalSettings_btn.setForeground(new java.awt.Color(153, 153, 153));
        lb_GlobalSettings_btn.setText("Server Settings");
        lb_GlobalSettings_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_GlobalSettings_btnMouseClicked(evt);
            }
        });
        jPanel1.add(lb_GlobalSettings_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, 780));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void minize_lbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minize_lbMouseClicked
        this.setExtendedState(Admin_Home.ICONIFIED);
    }//GEN-LAST:event_minize_lbMouseClicked

    private void exit_lbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_lbMouseClicked
        Dialog frame = new Dialog();
        frame.setVisible(true);
    }//GEN-LAST:event_exit_lbMouseClicked

    private void hotel_maMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hotel_maMouseClicked
     // Settings_Outer_holder.setVisible(true);
    }//GEN-LAST:event_hotel_maMouseClicked

    private void hotel_maMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hotel_maMouseEntered
        hotel_ma.setBackground(new Color(33,173,178));
    }//GEN-LAST:event_hotel_maMouseEntered

    private void hotel_maMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hotel_maMouseExited
        hotel_ma.setBackground(new Color(61,61,61));
    }//GEN-LAST:event_hotel_maMouseExited

    private void admin_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btnMouseClicked
       this.dispose();
        Admin_Home.getObj().setVisible(true);
    }//GEN-LAST:event_admin_btnMouseClicked

    private void admin_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btnMouseEntered
        admin_btn.setBackground(new Color(82,120,152));
    }//GEN-LAST:event_admin_btnMouseEntered

    private void admin_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btnMouseExited
        admin_btn.setBackground(new Color(61,61,61));
    }//GEN-LAST:event_admin_btnMouseExited

    private void front_holderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_front_holderMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_front_holderMouseEntered

    private void front_holderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_front_holderMouseExited
        // TODO add your handling code here:////////////eixt
        // if(evt.getSource()==MuiltpleOption1 ){
            //   top.setVisible(true);

            //   }
    }//GEN-LAST:event_front_holderMouseExited

    private void lb_GeneralSettings_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_GeneralSettings_btnMouseClicked
       panel_forGeneral.setVisible(true);
    }//GEN-LAST:event_lb_GeneralSettings_btnMouseClicked

    private void lb_GlobalSettings_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_GlobalSettings_btnMouseClicked
      //  panel_forGeneral.hide();
    }//GEN-LAST:event_lb_GlobalSettings_btnMouseClicked

    private void lb_saveBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_saveBtnMouseClicked
         
             InputStream inputSteam = null;
             String dir = img_url.getText();
            try {
                inputSteam = new FileInputStream(new File(dir));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Adminstrative.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            
             InputStream inputSteams = null;
             String directory = img_url1.getText();
            try {
                inputSteams = new FileInputStream(new File(directory));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Adminstrative.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        
        try {
            conn = DBConnection.getConnction();
                String sql = "INSERT INTO school_settings (school_name,school_address, school_contact,school_email,school_logo, school_motto,school_mission_statement, minstry_logo) VALUES (?,?,?,?,?,?,?,?)";
            pps = conn.prepareStatement(sql);
            pps.setString(1, txt_school_name.getText().toUpperCase());
            pps.setString(2, txt_school_address.getText());
            pps.setString(3, txt_school_contact.getText());
             pps.setString(4, txt_school_email.getText());
             pps.setBlob(5, inputSteam);
            pps.setString(6, txt_school_motto.getText().toUpperCase());
            pps.setString(7, txt_school_mission_staement.getText().toUpperCase());
             pps.setBlob(8, inputSteams);
            pps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Successfully Saved");
         
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_lb_saveBtnMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setFileHidingEnabled(false);
        if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
        java.io.File f = chooser.getSelectedFile();
        img_url.setText(f.getPath());
        
            try {
               ImageIcon icon= new ImageIcon(ImageIO.read(f));
               Image image = icon.getImage();
               Image modifiedImage = image.getScaledInstance(img_bg.getWidth(), img_bg.getHeight(), Image.SCALE_SMOOTH);
               icon = new ImageIcon(modifiedImage);
             //   img_holder.setIcon(new ImageIcon(ImageIO.read(f)));
                img_holder.setIcon(icon);
                
           } catch (IOException ex) {
                Logger.getLogger(Adminstrative.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
  
     try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("SELECT * FROM school_settings");
            rs = pps.executeQuery();

            byte[] image = null;
            while (rs.next()) {
         
                txt_school_name.setText(rs.getString("school_name"));
                txt_school_address.setText(rs.getString("school_address"));
                txt_school_contact.setText(rs.getString("school_contact"));
                 txt_school_email.setText(rs.getString("school_email"));

                image = rs.getBytes("school_logo");
                Image img = Toolkit.getDefaultToolkit().createImage(image);
                ImageIcon icon = new ImageIcon(img);
                img_holder.setIcon(icon);
                
                 txt_school_motto.setText(rs.getString("school_motto"));

                 txt_school_mission_staement.setText(rs.getString("school_mission_statement"));
              update.setVisible(true);
            }

        } catch (Exception ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jLabel1MouseClicked

    public void show_settings_info(){
     try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("SELECT * FROM school_settings");
            rs = pps.executeQuery();

            byte[] image = null;
            byte[] images = null;
            while (rs.next()) {
         
                txt_school_name.setText(rs.getString("school_name"));
                txt_school_address.setText(rs.getString("school_address"));
                txt_school_contact.setText(rs.getString("school_contact"));
                 txt_school_email.setText(rs.getString("school_email"));

                image = rs.getBytes("school_logo");
                Image img = Toolkit.getDefaultToolkit().createImage(image);
                ImageIcon icon = new ImageIcon(img);
                img_holder.setIcon(icon);
                
                  images = rs.getBytes("minstry_logo");
                Image imgs = Toolkit.getDefaultToolkit().createImage(images);
                ImageIcon icons = new ImageIcon(imgs);
                img_holder1.setIcon(icons);
                
                
                 txt_school_motto.setText(rs.getString("school_motto"));

                 txt_school_mission_staement.setText(rs.getString("school_mission_statement"));
              update.setVisible(true);
            }

        } catch (Exception ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    
    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
     
         
             InputStream inputSteam = null;
            String dir = img_url.getText();
            
            try {
                inputSteam = new FileInputStream(new File(dir));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Adminstrative.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        try {//WHERE school_name = ? 
            conn = DBConnection.getConnction();
            String sql = "UPDAE  school_settings  SET school_name =?,school_address =?, school_contact=?,school_email=?,school_logo=?, school_motto=?,school_mission_statement=? ";
            pps = conn.prepareStatement(sql);
            pps.setString(1, txt_school_name.getText());
            pps.setString(2, txt_school_address.getText());
            pps.setString(3, txt_school_contact.getText());
             pps.setString(4, txt_school_email.getText());
             pps.setBlob(5, inputSteam);
            pps.setString(6, txt_school_motto.getText());
            pps.setString(7, txt_school_mission_staement.getText());
           // pps.setString(8, txt_school_mission_staement.getText());

            pps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Updated");
         
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }  
        
        
        
        
        
        
        
        
  

    }//GEN-LAST:event_updateMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setFileHidingEnabled(false);
        if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
        java.io.File f = chooser.getSelectedFile();
        img_url1.setText(f.getPath());
        
            try {
               ImageIcon icon= new ImageIcon(ImageIO.read(f));
               Image image = icon.getImage();
               Image modifiedImage = image.getScaledInstance(img_bg1.getWidth(), img_bg1.getHeight(), Image.SCALE_SMOOTH);
               icon = new ImageIcon(modifiedImage);
             //   img_holder.setIcon(new ImageIcon(ImageIO.read(f)));
                img_holder1.setIcon(icon);
                
           } catch (IOException ex) {
                Logger.getLogger(Adminstrative.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseClicked
                     Admin_Home.getObj().setVisible(true);
                    //passing user id 
                    Admin_Home.getObj().setUserID(Recieved_user_id);
                    Admin_Home.getObj().printUserID();

                    this.dispose();
    }//GEN-LAST:event_jLabel42MouseClicked
  
       public static Settings getObj() {  //public method for instance Restriction
        if (Obj == null) {
            Obj = new Settings();
        }
        return Obj;
    }
    
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Settings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Settings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Container;
    private javax.swing.JPanel Settings_Inner_holder;
    private javax.swing.JPanel admin_btn;
    private javax.swing.JLabel exit_lb;
    private javax.swing.JPanel front_holder;
    private javax.swing.JLabel header;
    private javax.swing.JPanel hotel_ma;
    private javax.swing.JPanel img_bg;
    private javax.swing.JPanel img_bg1;
    private javax.swing.JLabel img_holder;
    private javax.swing.JLabel img_holder1;
    private javax.swing.JTextField img_url;
    private javax.swing.JTextField img_url1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_GeneralSettings_btn;
    private javax.swing.JLabel lb_GlobalSettings_btn;
    private javax.swing.JLabel lb_saveBtn;
    private javax.swing.JPanel left;
    private javax.swing.JPanel left1;
    private javax.swing.JLabel minize_lb;
    private javax.swing.JLabel model;
    private javax.swing.JPanel panel_forGeneral;
    private javax.swing.JTextArea txt_school_address;
    private javax.swing.JTextField txt_school_contact;
    private javax.swing.JTextField txt_school_email;
    private javax.swing.JTextField txt_school_mission_staement;
    private javax.swing.JTextField txt_school_motto;
    private javax.swing.JTextField txt_school_name;
    private javax.swing.JLabel update;
    // End of variables declaration//GEN-END:variables
}
