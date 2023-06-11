package hotel.management;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.util.Base64;

public class Login extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pps,pps2 = null;
    ResultSet rs, rs2 = null;

    String usertype = null;
    String username = null;
    String password = null;

    //checking employee records in the system to give the access to creating an account  rsou_employee_id
    String rs_employeeid = null;

    //getting employee id from access to creating an account  
    String User_Access_id = null;
    String rsou_employee_name = null;

    String imgBTN_clicked = "none";
    

//free
    
    //geting user id
    String entered_user_name =null;
    String entered_user_level =null;
    String entered_user_password =null;
    
    
        String obtained_use_id =null;
       String obtained_use_type =null;
    
    public Login() {
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));
        lb_confirm_password.hide();
        confirm_pass.hide();
    }
   // 

     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Login_panel = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtUser_name1 = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lb_mini = new javax.swing.JLabel();
        lb_close = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        Sign_up = new javax.swing.JPanel();
        hide_frome = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        txtUser_Name = new javax.swing.JTextField();
        TxtPassword_SP = new javax.swing.JTextField();
        txtConfrim_Password_SP = new javax.swing.JPasswordField();
        txtEmail_Phone_SP = new javax.swing.JTextField();
        txtFirst_name = new javax.swing.JTextField();
        txtLast_name = new javax.swing.JTextField();
        txtHint = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        lb_signup = new javax.swing.JLabel();
        user = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        logo2 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        img_url = new javax.swing.JTextField();
        Reset_password = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Hint = new javax.swing.JTextField();
        Phone_email = new javax.swing.JTextField();
        Fname = new javax.swing.JTextField();
        Lname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        new_pass = new javax.swing.JPanel();
        lb_confirm_password = new javax.swing.JLabel();
        lb_new_pass = new javax.swing.JLabel();
        lb_new_user_name = new javax.swing.JLabel();
        user_name = new javax.swing.JTextField();
        new_password = new javax.swing.JTextField();
        confirm_pass = new javax.swing.JPasswordField();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.CardLayout());

        Login_panel.setBackground(new Color(66,66,66,5));
        Login_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Century", 0, 11)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("SIGN IN");
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
        });
        Login_panel.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, 110, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/lock.png"))); // NOI18N
        Login_panel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 40, 50));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_add_key_30px_1.png"))); // NOI18N
        Login_panel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 40, 40));

        txtUser_name1.setBackground(new java.awt.Color(102, 102, 102));
        txtUser_name1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txtUser_name1.setForeground(new java.awt.Color(255, 255, 255));
        txtUser_name1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUser_name1.setBorder(null);
        txtUser_name1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtUser_name1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUser_name1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUser_name1KeyTyped(evt);
            }
        });
        Login_panel.add(txtUser_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 340, 40));

        txtPassword.setBackground(new java.awt.Color(102, 102, 102));
        txtPassword.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasswordKeyTyped(evt);
            }
        });
        Login_panel.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 340, 40));

        jLabel3.setBackground(new java.awt.Color(234, 232, 232));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("LOGIN");
        Login_panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 120, 40));

        lb_mini.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_mini.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_minus_19px.png"))); // NOI18N
        lb_mini.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_miniMouseClicked(evt);
            }
        });
        Login_panel.add(lb_mini, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, 50, 40));

        lb_close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_delete_18px_1.png"))); // NOI18N
        lb_close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_closeMouseClicked(evt);
            }
        });
        Login_panel.add(lb_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, 50, 40));

        jLabel1.setBackground(new java.awt.Color(234, 232, 232));
        jLabel1.setFont(new java.awt.Font("Century", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SIGN UP");
        jLabel1.setToolTipText("sign up");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        Login_panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 90, 40));

        jLabel9.setBackground(new java.awt.Color(234, 232, 232));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText(" FORGOTTEN  PASSWORD");
        jLabel9.setToolTipText("forgotten password?");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        Login_panel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, 150, 40));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/Login-Back.png"))); // NOI18N
        jLabel27.setText("jLabel27");
        Login_panel.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 0, 900, 570));

        getContentPane().add(Login_panel, "card8");

        Sign_up.setBackground(new Color(66,66,66,5));
        Sign_up.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hide_frome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hide_frome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_minus_19px.png"))); // NOI18N
        hide_frome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hide_fromeMouseClicked(evt);
            }
        });
        Sign_up.add(hide_frome, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 70, 40));

        close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_delete_18px_1.png"))); // NOI18N
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        Sign_up.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, 50, 40));

        txtUser_Name.setBackground(new java.awt.Color(153, 153, 153));
        txtUser_Name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUser_Name.setBorder(null);
        txtUser_Name.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtUser_Name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUser_NameMouseClicked(evt);
            }
        });
        txtUser_Name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUser_NameKeyPressed(evt);
            }
        });
        Sign_up.add(txtUser_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 210, 30));

        TxtPassword_SP.setBackground(new java.awt.Color(153, 153, 153));
        TxtPassword_SP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TxtPassword_SP.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 1, 1, 1));
        TxtPassword_SP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TxtPassword_SP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TxtPassword_SPMouseClicked(evt);
            }
        });
        TxtPassword_SP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtPassword_SPKeyPressed(evt);
            }
        });
        Sign_up.add(TxtPassword_SP, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 260, 30));

        txtConfrim_Password_SP.setBackground(new java.awt.Color(153, 153, 153));
        txtConfrim_Password_SP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtConfrim_Password_SP.setBorder(null);
        txtConfrim_Password_SP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtConfrim_Password_SPMouseClicked(evt);
            }
        });
        txtConfrim_Password_SP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtConfrim_Password_SPKeyPressed(evt);
            }
        });
        Sign_up.add(txtConfrim_Password_SP, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 310, 30));

        txtEmail_Phone_SP.setBackground(new java.awt.Color(153, 153, 153));
        txtEmail_Phone_SP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEmail_Phone_SP.setBorder(null);
        txtEmail_Phone_SP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtEmail_Phone_SP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtEmail_Phone_SPMouseClicked(evt);
            }
        });
        txtEmail_Phone_SP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmail_Phone_SPKeyPressed(evt);
            }
        });
        Sign_up.add(txtEmail_Phone_SP, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 310, 30));

        txtFirst_name.setBackground(new java.awt.Color(153, 153, 153));
        txtFirst_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFirst_name.setBorder(null);
        txtFirst_name.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtFirst_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFirst_nameMouseClicked(evt);
            }
        });
        txtFirst_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFirst_nameKeyPressed(evt);
            }
        });
        Sign_up.add(txtFirst_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, 310, 30));

        txtLast_name.setBackground(new java.awt.Color(153, 153, 153));
        txtLast_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtLast_name.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 1, 1, 1));
        txtLast_name.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtLast_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtLast_nameMouseClicked(evt);
            }
        });
        txtLast_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLast_nameKeyPressed(evt);
            }
        });
        Sign_up.add(txtLast_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, 310, 30));

        txtHint.setBackground(new java.awt.Color(153, 153, 153));
        txtHint.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtHint.setBorder(null);
        txtHint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtHint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtHintMouseClicked(evt);
            }
        });
        txtHint.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtHintKeyPressed(evt);
            }
        });
        Sign_up.add(txtHint, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 460, 310, 30));

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_home_page_20px.png"))); // NOI18N
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel23MouseClicked(evt);
            }
        });
        Sign_up.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 80, 40));

        lb_signup.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lb_signup.setForeground(new java.awt.Color(204, 204, 204));
        lb_signup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_signup.setText("NEW  ACCOUNT");
        Sign_up.add(lb_signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 250, 40));

        user.setBackground(new Color(255,255,255,5));
        user.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administration", "Teacher", "Accountant", "Reception" }));
        Sign_up.add(user, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 100, 30));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_add_image_25px.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        Sign_up.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 150, 60, 40));
        Sign_up.add(logo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 90, 110));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icon.png"))); // NOI18N
        jLabel18.setText("jLabel18");
        Sign_up.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 130, 110));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Hint ");
        Sign_up.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 450, 90, 40));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Last name");
        Sign_up.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 90, 40));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("First name");
        Sign_up.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 170, 50));

        jLabel24.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText(" Phone number");
        Sign_up.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 140, 40));

        jLabel26.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Confirm password");
        Sign_up.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 160, 40));

        jLabel21.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("New password");
        Sign_up.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 130, 40));

        jLabel25.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("User name ");
        Sign_up.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 110, 40));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/Login-Back-2.png"))); // NOI18N
        Sign_up.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 0, 930, 560));

        img_url.setText("jTextField1");
        Sign_up.add(img_url, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, 150, -1));

        getContentPane().add(Sign_up, "card7");

        Reset_password.setBackground(new Color(66,66,66,5));
        Reset_password.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(153, 153, 153));
        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Phone / Email");
        Reset_password.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 140, -1));

        jLabel11.setBackground(new java.awt.Color(153, 153, 153));
        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Hint");
        Reset_password.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 140, 30));

        jLabel13.setBackground(new java.awt.Color(153, 153, 153));
        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Last name");
        Reset_password.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 170, 30));

        jLabel14.setBackground(new java.awt.Color(153, 153, 153));
        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("First name");
        Reset_password.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 170, 30));

        Hint.setBackground(new java.awt.Color(153, 153, 153));
        Hint.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Hint.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 5, 10));
        Hint.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                HintKeyPressed(evt);
            }
        });
        Reset_password.add(Hint, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 340, 30));

        Phone_email.setBackground(new java.awt.Color(153, 153, 153));
        Phone_email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Phone_email.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 10));
        Phone_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Phone_emailKeyPressed(evt);
            }
        });
        Reset_password.add(Phone_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 340, 30));

        Fname.setBackground(new java.awt.Color(153, 153, 153));
        Fname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Fname.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 5, 10));
        Fname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FnameMouseEntered(evt);
            }
        });
        Fname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FnameKeyPressed(evt);
            }
        });
        Reset_password.add(Fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 340, 30));

        Lname.setBackground(new java.awt.Color(153, 153, 153));
        Lname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Lname.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 1, 1, 10));
        Lname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                LnameKeyPressed(evt);
            }
        });
        Reset_password.add(Lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, 340, 30));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_minus_19px.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        Reset_password.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, 40, 40));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_delete_18px_1.png"))); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        Reset_password.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, 40, 40));

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_home_page_20px.png"))); // NOI18N
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        Reset_password.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 370, 70, 30));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/Login-Back-3.png"))); // NOI18N
        Reset_password.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 50, 820, 420));

        getContentPane().add(Reset_password, "card4");

        new_pass.setBackground(new Color(66,66,66,5));
        new_pass.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_confirm_password.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lb_confirm_password.setForeground(new java.awt.Color(255, 255, 255));
        lb_confirm_password.setText("                           Confirm");
        new_pass.add(lb_confirm_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 210, 40));

        lb_new_pass.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lb_new_pass.setForeground(new java.awt.Color(255, 255, 255));
        lb_new_pass.setText("New Password");
        lb_new_pass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lb_new_passMouseExited(evt);
            }
        });
        new_pass.add(lb_new_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 160, 40));

        lb_new_user_name.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lb_new_user_name.setForeground(new java.awt.Color(255, 255, 255));
        lb_new_user_name.setText("User Name");
        new_pass.add(lb_new_user_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 90, 40));

        user_name.setBackground(new java.awt.Color(102, 102, 102));
        user_name.setBorder(null);
        user_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                user_nameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                user_nameMouseExited(evt);
            }
        });
        user_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_nameActionPerformed(evt);
            }
        });
        user_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                user_nameKeyPressed(evt);
            }
        });
        new_pass.add(user_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 250, 40));

        new_password.setBackground(new java.awt.Color(102, 102, 102));
        new_password.setBorder(null);
        new_password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                new_passwordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                new_passwordMouseExited(evt);
            }
        });
        new_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new_passwordActionPerformed(evt);
            }
        });
        new_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                new_passwordKeyPressed(evt);
            }
        });
        new_pass.add(new_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 250, 40));

        confirm_pass.setBackground(new java.awt.Color(102, 102, 102));
        confirm_pass.setBorder(null);
        confirm_pass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                confirm_passMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                confirm_passMouseExited(evt);
            }
        });
        confirm_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                confirm_passKeyPressed(evt);
            }
        });
        new_pass.add(confirm_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, 240, 40));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_delete_18px_1.png"))); // NOI18N
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        new_pass.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 210, 80, 40));

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_minus_19px.png"))); // NOI18N
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        new_pass.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 210, 90, 40));

        jLabel17.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(240, 240, 240));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_user_25px.png"))); // NOI18N
        jLabel17.setText("Update  details");
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        new_pass.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 440, 250, 50));

        jLabel20.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(240, 240, 240));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_login_25px.png"))); // NOI18N
        jLabel20.setText("Login");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        new_pass.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, 190, 50));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/Login-Back-4.png"))); // NOI18N
        new_pass.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 140, 810, 420));

        getContentPane().add(new_pass, "card5");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lb_closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_closeMouseClicked
        // close frmae
        System.exit(0);
    }//GEN-LAST:event_lb_closeMouseClicked

    private void lb_miniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_miniMouseClicked
// minimize
        this.setExtendedState(Login.ICONIFIED);

    }//GEN-LAST:event_lb_miniMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // swatch to sign up panel
        Sign_up.setVisible(true);
        Login_panel.hide();
        Reset_password.hide();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        // close frmae
        System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

    private void txtEmail_Phone_SPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmail_Phone_SPKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtFirst_name.requestFocus();
        }
        
        

        
       /* 
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (txtUser_Name.getText().isEmpty()
                    || TxtPassword_SP.getText().isEmpty()
                    || txtConfrim_Password_SP.getText().isEmpty()
                    || txtEmail_Phone_SP.getText().isEmpty()) {
                if (txtUser_Name.getText().length() == 0) {
                    txtUser_Name.setText("Please Enter User Name");

                } else if (TxtPassword_SP.getText().length() == 0) {
                    TxtPassword_SP.setText("Please Enter User Name");

                } else if (txtConfrim_Password_SP.getText().length() == 0) {
                    TxtPassword_SP.setText("Comfirm Password");

                } else if (txtConfrim_Password_SP.getText().equals(TxtPassword_SP.getText()) == false) {

                    JOptionPane.showMessageDialog(this, "Passwords dont match");

                } else if (txtEmail_Phone_SP.getText().length() == 0) {
                    TxtPassword_SP.setText("Enter Email  /  Phone Number");
                }
            } else {
                lb_container.setVisible(true);
                //hidding the first row of text fields
                txtUser_Name.hide();
                TxtPassword_SP.hide();
                txtConfrim_Password_SP.hide();
                txtEmail_Phone_SP.hide();
                //hidding the first row of text fields     
                txtFirst_name.setVisible(true);
                txtLast_name.setVisible(true);
                txtHint.setVisible(true);
                
                

            }

        }//closing controllors  */
    }//GEN-LAST:event_txtEmail_Phone_SPKeyPressed

    public void insertRegistraion() {
        //checking the  field for inputs if its empt
        if (txtFirst_name.getText().length() == 0) {
            txtFirst_name.setText("Enter first Name");

        } else if (txtLast_name.getText().length() == 0) {
            txtLast_name.setText("Enter last Name");

        } else if (txtHint.getText().length() == 0) {
            txtHint.setText("Enter user Hint");

        } else {

                try {// database connection
                conn = DBConnection.getConnction();
                pps = conn.prepareStatement("SELECT * FROM  access WHERE name = ? and confirmed_password =? AND user =? ");
                pps.setString(1, txtUser_Name.getText());
                pps.setString(2, txtConfrim_Password_SP.getText());
                pps.setString(3, user.getSelectedItem().toString());

                rs = pps.executeQuery();
                
                  entered_user_name = txtUser_Name.getText();
                  entered_user_level =  txtConfrim_Password_SP.getText() ;
                  entered_user_password = user.getSelectedItem().toString();
                
                if (rs.next()) {
                 JOptionPane.showMessageDialog(this, "Account Already Exists");
                    
                } else {
                 inserting_user_afterNOT_Found();
                    
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }

    public void inserting_user_afterNOT_Found() {
        
         if (imgBTN_clicked.equals("none")) {
          JOptionPane.showMessageDialog(null, "Select the Image");
         } else if (!imgBTN_clicked.equals("none")) {
        
              InputStream inputSteam = null;
              String dir = img_url.getText();
            
            try {
                inputSteam = new FileInputStream(new File(dir));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Adminstrative.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("INSERT INTO access(name,confirmed_password,email_phone,first_name,last_name,hint,user, user_pic) VALUES (?,?,?,?,?,?,?,?)");
            pps.setString(1, txtUser_Name.getText().toLowerCase().trim());
            
            String encryptedPassward = getEncodedString(txtConfrim_Password_SP.getText());
            
            pps.setString(2, encryptedPassward.toLowerCase());
            
            
            pps.setString(3, txtEmail_Phone_SP.getText().trim());
            pps.setString(4, txtFirst_name.getText().trim());
            pps.setString(5, txtLast_name.getText().trim());
            pps.setString(6, txtHint.getText().trim());
            pps.setString(7, user.getSelectedItem().toString());
            pps.setBlob(8, inputSteam);

            pps.executeUpdate();
            
            
            
            
              obtained_use_type =  user.getSelectedItem().toString();    
             obtained_use_id =  txtUser_Name.getText().toLowerCase().trim();

     
             contro_landing_page();
              
                    
                  
                    
              
            
            
          
        
           
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);}
        
         }

    }

    public void contro_landing_page(){
    
    
                 if(obtained_use_type.equals("Administration")){
                    Login my_log = new Login();
                    JOptionPane.showMessageDialog(null, "Your Account has successfully Registered");
                    this.dispose();
                    my_log.setVisible(true);
                    
                  }else if(obtained_use_type.equals("Accountant")){
                    Login my_log = new Login();
                    JOptionPane.showMessageDialog(null, "Your Account has successfully Registered");

                    this.dispose();
                    my_log.setVisible(true);
                  } else if (obtained_use_type.equals("Reception") ){
                   
                    //passing user id 
                     Login my_log = new Login();
                      JOptionPane.showMessageDialog(null, "Your Account has successfully Registered");

                    this.dispose();
                    my_log.setVisible(true);
                    
                    
                  } else if (obtained_use_type.equals("Teacher") ){
                      JOptionPane.showMessageDialog(null, "Complete Your Registration by submitting all required info");

                      Teacher_more_info.getObj().setVisible(true);

                     Teacher_more_info.getObj().setPassed_id(obtained_use_id);
                     Teacher_more_info.getObj().printPassed_id();
                     this.dispose();
                     
                  }
    
    
    }
    
    
    
    
    //ENCODING THE PASSWORD
    private static String getEncodedString(String Passward){
       return Base64.getEncoder().encodeToString(Passward.getBytes());
    }

    private void txtUser_NameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUser_NameKeyPressed
        // next textfield
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            TxtPassword_SP.requestFocus();
        }
    }//GEN-LAST:event_txtUser_NameKeyPressed

    private void TxtPassword_SPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPassword_SPKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtConfrim_Password_SP.requestFocus();

        }
    }//GEN-LAST:event_TxtPassword_SPKeyPressed


    private void txtConfrim_Password_SPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConfrim_Password_SPKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtEmail_Phone_SP.requestFocus();
        }
    }//GEN-LAST:event_txtConfrim_Password_SPKeyPressed

    private void txtUser_NameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUser_NameMouseClicked
        txtUser_Name.setText(null);
    }//GEN-LAST:event_txtUser_NameMouseClicked

    private void TxtPassword_SPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TxtPassword_SPMouseClicked
        TxtPassword_SP.setText(null);
    }//GEN-LAST:event_TxtPassword_SPMouseClicked

    private void txtConfrim_Password_SPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtConfrim_Password_SPMouseClicked
        txtConfrim_Password_SP.setText(null);
    }//GEN-LAST:event_txtConfrim_Password_SPMouseClicked

    private void txtEmail_Phone_SPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmail_Phone_SPMouseClicked
        txtEmail_Phone_SP.setText(null);
    }//GEN-LAST:event_txtEmail_Phone_SPMouseClicked

    private void txtUser_name1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUser_name1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtPassword.requestFocus();
        }
    }//GEN-LAST:event_txtUser_name1KeyPressed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        // Login
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            try {

                if (txtUser_name1.getText().isEmpty() || txtPassword.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "User name or Password is Empty");

                } else {

                    String UserName = txtUser_name1.getText();
                    String passwords = txtPassword.getText();
                    String encryptedPassward = getEncodedString(passwords);

                    
                    
                    
                    conn = DBConnection.getConnction();
                    pps = conn.prepareStatement("SELECT * FROM access WHERE name = ? and confirmed_password =?");
                    pps.setString(1, UserName);
                    pps.setString(2, encryptedPassward);
                    rs = pps.executeQuery();
                    if (rs.next()) {
                        //-----------------------------------------------------frame control
                         username = rs.getString("name");
                         usertype = rs.getString("user");
                         password = rs.getString("confirmed_password");

                        //resources for passing the info to another class
                          User_Access_id = rs.getString("access_id");

                         CheckAccess();
                      } else {//result try block
                        JOptionPane.showMessageDialog(this, "Wrong user Name or Password");
                        txtUser_name1.setText(null);
                        txtPassword.setText(null);
                    }

                }
            } catch (Exception e) {
                System.err.println(e);
            } finally {    //*****************************************************CLOSING THE CONECTIONS
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (pps != null) {
                    try {
                        pps.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }//try and catch
        }//key entered close breakets

    }//GEN-LAST:event_txtPasswordKeyPressed

    
    
      //ENCODING THE PASSWORD
    private static String getEncodedStrings(String Passwards){
       return Base64.getEncoder().encodeToString(Passwards.getBytes());
    }
    
    
    
    
    
    
    
    
    public void frame_control() throws NoSuchFieldException {
        try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("SELECT  count(school_id) FROM  school_settings");
            rs = pps.executeQuery();
            if (rs.next()) {
                //-----------------------------------------------------frame control                         String encryptedPassward = getEncodedString(passwords);
                
                

                 if(usertype.equals("Administration") && txtUser_name1.getText().equals(username) &&   getEncodedString(txtPassword.getText()).equals(password)){
                    Admin_Home.getObj().setVisible(true);
                    Admin_Home.getObj().setUserID(User_Access_id);
                    Admin_Home.getObj().printUserID();
                    this.dispose();
                    
                  }else if(usertype.equals("Accountant") && txtUser_name1.getText().equals(username) && getEncodedString(txtPassword.getText()).equals(password)){
                    Accountant_Home_Page.getObj().setVisible(true);
                    Accountant_Home_Page.getObj().setUserID(User_Access_id);
                    Accountant_Home_Page.getObj().printUserID();

                    this.dispose();
                  } else if (usertype.equals("Reception") && txtUser_name1.getText().equals(username) && getEncodedString(txtPassword.getText()).equals(password)){
                   Reception_Home_Page.getObj().setVisible(true);
                    //passing user id 
                    Reception_Home_Page.getObj().setUserID(User_Access_id);
                    Reception_Home_Page.getObj().printUserID();
                    this.dispose();
                    
                    
                  } else if (usertype.equals("Teacher") && txtUser_name1.getText().equals(username) && getEncodedString(txtPassword.getText()).equals(password)){
                     Teacher_Home_Page.getObj().setVisible(true);
                     //passing user id 
                     
                     Teacher_Home_Page.getObj().setUserID(User_Access_id);
                     Teacher_Home_Page.getObj().printUserID();
                     this.dispose();
                     
                  }
                     
                     
            }else{  // IF THE SETTING DATABASE IS EMPTY THEN LAND ON SETTINGS
              Settings mys  = new Settings();
              this.dispose();
              mys.setVisible(true);
            }
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

        
        
   

    }


    private void txtFirst_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFirst_nameMouseClicked
        txtFirst_name.setText(null);
    }//GEN-LAST:event_txtFirst_nameMouseClicked

    private void txtLast_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtLast_nameMouseClicked
        txtLast_name.setText(null);
    }//GEN-LAST:event_txtLast_nameMouseClicked

    private void txtLast_nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLast_nameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
           txtHint.requestFocus();
        }
    }//GEN-LAST:event_txtLast_nameKeyPressed

    private void txtHintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHintMouseClicked
        txtHint.setText(null);
    }//GEN-LAST:event_txtHintMouseClicked

    private void txtHintKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHintKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
              insertRegistraion();
               
        }
    }//GEN-LAST:event_txtHintKeyPressed

   
    private void txtFirst_nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFirst_nameKeyPressed
        // next textfield
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtLast_name.requestFocus();
        }
    }//GEN-LAST:event_txtFirst_nameKeyPressed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        Sign_up.hide();
        Login_panel.hide();
        Reset_password.setVisible(true);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel15MouseClicked

    private void Phone_emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Phone_emailKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (Fname.getText().length() == 0) {
                Fname.setText("Please Enter  Name");

            } else if (Lname.getText().length() == 0) {
                Lname.setText("Please Enter  Surname");

            } else if (Hint.getText().length() == 0) {
                Hint.setText("Hint 'my wife's name is beth'");

            } else if (Phone_email.getText().length() == 0) {
                Phone_email.setText("Enter Email or  Phone Number");
            } else {

                //retriving information 
                try {
                    String mfname = Fname.getText();
                    String mlname = Lname.getText();
                    String mhint = Hint.getText();
                    String mphone_email = Phone_email.getText();
                    conn = DBConnection.getConnction();
                    String sql = " SELECT first_name,last_name,hint, email_phone FROM access WHERE (first_name = ? AND last_name =?)  AND (hint =? || email_phone =? )";
                    pps = conn.prepareStatement(sql);
                    pps.setString(1, mfname);
                    pps.setString(2, mlname);
                    pps.setString(3, mhint);
                    pps.setString(4, mphone_email);
                    rs = pps.executeQuery();
                    if (rs.next()) {
                        Login_panel.hide();
                        Sign_up.hide();
                        Reset_password.hide();
                        new_pass.setVisible(true);

                    } else {
                        JOptionPane.showMessageDialog(this, "User not found");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e);
                }finally{
                   if(rs != null){
                       try {
                           rs.close();
                       } catch (SQLException ex) {Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);}
                       }
                       if(pps != null){
                       try {
                           pps.close();
                       } catch (SQLException ex) {Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);}
                       }
                       
                        if(conn != null){
                        try {
                          conn.close();
                       } catch (SQLException ex) {Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);}
                       }
                
                }
            }
        }
    }//GEN-LAST:event_Phone_emailKeyPressed

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void new_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_new_passwordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            new_password.hide();
            lb_new_pass.hide();
            lb_confirm_password.setVisible(true);
            confirm_pass.setVisible(true);
            confirm_pass.requestFocus();
        }
    }//GEN-LAST:event_new_passwordKeyPressed

    private void FnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FnameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Lname.requestFocus();
        }
    }//GEN-LAST:event_FnameKeyPressed

    private void LnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LnameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
          Hint.requestFocus();
        }
    }//GEN-LAST:event_LnameKeyPressed

    private void HintKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_HintKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Phone_email.requestFocus();
        }
    }//GEN-LAST:event_HintKeyPressed

    private void user_nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_user_nameKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            new_password.requestFocus();
        }
    }//GEN-LAST:event_user_nameKeyPressed

    private void confirm_passKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirm_passKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (user_name.getText().length() == 0) {
                user_name.setText("Enter User Name");

            } else if (!new_password.getText().trim().equals(confirm_pass.getText().trim())) {
                JOptionPane.showMessageDialog(null, "Password dont match");
                new_password.setVisible(true);
                new_password.setText(null);
                new_password.requestFocus();

                lb_new_pass.setVisible(true);
                lb_confirm_password.hide();
                confirm_pass.hide();
                confirm_pass.setText(null);
            } else {

                try {
                    conn = DBConnection.getConnction();
                    String sql = " UPDATE access SET name = ?, confirmed_password =?  WHERE first_name =? AND  last_name =?";
                    pps = conn.prepareStatement(sql);
                    pps.setString(1, user_name.getText());
                    String encryptedPassward = getEncodedString(confirm_pass.getText());
                    
                    pps.setString(2, encryptedPassward);
                    pps.setString(3, Fname.getText());
                    pps.setString(4, Lname.getText());

                    pps.executeUpdate();
                    JOptionPane.showMessageDialog(this, "login with your new username & password");
                    user_name.setText(null);
                    confirm_pass.setText(null);
                    
                   
                    
                } catch (Exception e) {
                    System.err.print(e);
                }finally{ //****************************        CLOSING THE CONNECTION 
                   if(rs != null){
                       try {
                           rs.close();
                       } catch (SQLException ex) {Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);}
                       }
                       if(pps != null){
                       try {
                           pps.close();
                       } catch (SQLException ex) {Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);}
                       }
                       
                        if(conn != null){
                        try {
                          conn.close();
                       } catch (SQLException ex) {Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);}
                       }
                
                }
            }

        }
    }//GEN-LAST:event_confirm_passKeyPressed

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        new_password.hide();
        confirm_pass .hide();
        user_name  .hide();
        
        
        Sign_up.hide();
        Reset_password.hide();
        Login_panel.setVisible(true);
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        Sign_up.hide();
        Login_panel.hide();
        Reset_password.setVisible(true);
    }//GEN-LAST:event_jLabel17MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
        Login_panel.setVisible(true);
        Sign_up.hide();
        Reset_password.hide();
        new_pass.hide();
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseClicked
        Login_panel.setVisible(true);
        Sign_up.hide();
        Reset_password.hide();
        new_pass.hide();
    }//GEN-LAST:event_jLabel23MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        this.setExtendedState(Login.ICONIFIED);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void hide_fromeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hide_fromeMouseClicked
        this.setExtendedState(Login.ICONIFIED);

    }//GEN-LAST:event_hide_fromeMouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        this.setExtendedState(Login.ICONIFIED);

    }//GEN-LAST:event_jLabel19MouseClicked

    private void txtUser_name1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUser_name1MouseEntered
       
    }//GEN-LAST:event_txtUser_name1MouseEntered

    private void txtPasswordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMouseEntered
       
    }//GEN-LAST:event_txtPasswordMouseEntered

    private void txtUser_name1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUser_name1MouseExited
     
    }//GEN-LAST:event_txtUser_name1MouseExited

    private void txtPasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMouseExited
       
    }//GEN-LAST:event_txtPasswordMouseExited

    private void FnameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FnameMouseEntered
    
    }//GEN-LAST:event_FnameMouseEntered

    private void user_nameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_user_nameMouseEntered
       lb_new_user_name.hide();
    }//GEN-LAST:event_user_nameMouseEntered

    private void user_nameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_user_nameMouseExited
            if(!user_name.getText().isEmpty()){
            lb_new_user_name.hide();
       }else{
          lb_new_user_name.setVisible(true);
       }
    }//GEN-LAST:event_user_nameMouseExited

    private void new_passwordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_new_passwordMouseEntered
             lb_new_pass.hide();

    }//GEN-LAST:event_new_passwordMouseEntered

    private void lb_new_passMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_new_passMouseExited
             if(!lb_new_pass.getText().isEmpty()){
            lb_new_pass.hide();
       }else{
          lb_new_pass.setVisible(true);
       }
             
           
             
             
    }//GEN-LAST:event_lb_new_passMouseExited

    private void new_passwordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_new_passwordMouseExited
                if(!new_password.getText().isEmpty()){
            lb_new_pass.hide();
       }else{
          lb_new_pass.setVisible(true);
       }
    }//GEN-LAST:event_new_passwordMouseExited

    private void confirm_passMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirm_passMouseExited
       
                if(!confirm_pass.getText().isEmpty()){
            lb_confirm_password.hide();
       }else{
          lb_confirm_password.setVisible(true);
       }         
    }//GEN-LAST:event_confirm_passMouseExited

    private void confirm_passMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirm_passMouseEntered
      lb_confirm_password.hide();
    }//GEN-LAST:event_confirm_passMouseEntered

    private void txtUser_name1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUser_name1KeyTyped
       
     
    }//GEN-LAST:event_txtUser_name1KeyTyped

    private void txtPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyTyped
      
    }//GEN-LAST:event_txtPasswordKeyTyped

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
     
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
               Image modifiedImage = image.getScaledInstance(logo2.getWidth(), logo2.getHeight(), Image.SCALE_SMOOTH);
               icon = new ImageIcon(modifiedImage);
             //   img_holder.setIcon(new ImageIcon(ImageIO.read(f)));
                logo2.setIcon(icon);
                imgBTN_clicked = "TRUE";
           } catch (IOException ex) {
                Logger.getLogger(Adminstrative.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      
    }//GEN-LAST:event_jLabel12MouseClicked

    private void user_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_user_nameActionPerformed

    private void new_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_new_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_new_passwordActionPerformed

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
          try {

                if (txtUser_name1.getText().isEmpty() || txtPassword.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "User name or Password is Empty");

                } else{

                    String UserName = txtUser_name1.getText();
                    String passwords = txtPassword.getText();
                    String encryptedPassward = getEncodedString(passwords);

                    
                    
                    
                    conn = DBConnection.getConnction();
                    pps = conn.prepareStatement("SELECT * FROM access WHERE name = ? and confirmed_password =?");
                    pps.setString(1, UserName);
                    pps.setString(2, encryptedPassward);
                    rs = pps.executeQuery();
                    if (rs.next()) {
                        //-----------------------------------------------------frame control
                         username = rs.getString("name");
                         usertype = rs.getString("user");
                         password = rs.getString("confirmed_password");

                        //resources for passing the info to another class
                          User_Access_id = rs.getString("access_id");

                          //
                            CheckAccess();
                      } else {//result try block
                        JOptionPane.showMessageDialog(this, "Wrong user Name or Password");
                        txtUser_name1.setText(null);
                        txtPassword.setText(null);
                    }

                }
            } catch (Exception e) {
                System.err.println(e);
            } finally {    //*****************************************************CLOSING THE CONECTIONS
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (pps != null) {
                    try {
                        pps.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }//try and catch
    }//GEN-LAST:event_jLabel31MouseClicked

    
    public void CheckAccess(){
    
        try {// database connection
                    String UserName = txtUser_name1.getText();
                    String passwords = txtPassword.getText();
                    String encryptedPassward = getEncodedString(passwords);
                      String UserAccess =  "Granted";
                    
                              
                    conn = DBConnection.getConnction();
                    pps = conn.prepareStatement("SELECT * FROM access WHERE name = ? and confirmed_password =?  and  user_access =?");
                    pps.setString(1, UserName);
                    pps.setString(2, encryptedPassward);
                     pps.setString(3, UserAccess);
                    rs = pps.executeQuery();
                    if (rs.next()) {
                        
                        try {
                            frame_control();
                        } catch (NoSuchFieldException ex) {
                            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                } else {
                  
                    JOptionPane.showMessageDialog(this, "Access Denied, Wait for Approval");
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
    
    
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Fname;
    private javax.swing.JTextField Hint;
    private javax.swing.JTextField Lname;
    private javax.swing.JPanel Login_panel;
    private javax.swing.JTextField Phone_email;
    private javax.swing.JPanel Reset_password;
    private javax.swing.JPanel Sign_up;
    private javax.swing.JTextField TxtPassword_SP;
    private javax.swing.JLabel close;
    private javax.swing.JPasswordField confirm_pass;
    private javax.swing.JLabel hide_frome;
    private javax.swing.JTextField img_url;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lb_close;
    private javax.swing.JLabel lb_confirm_password;
    private javax.swing.JLabel lb_mini;
    private javax.swing.JLabel lb_new_pass;
    private javax.swing.JLabel lb_new_user_name;
    private javax.swing.JLabel lb_signup;
    private javax.swing.JLabel logo2;
    private javax.swing.JPanel new_pass;
    private javax.swing.JTextField new_password;
    private javax.swing.JPasswordField txtConfrim_Password_SP;
    private javax.swing.JTextField txtEmail_Phone_SP;
    private javax.swing.JTextField txtFirst_name;
    private javax.swing.JTextField txtHint;
    private javax.swing.JTextField txtLast_name;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUser_Name;
    private javax.swing.JTextField txtUser_name1;
    private javax.swing.JComboBox user;
    private javax.swing.JTextField user_name;
    // End of variables declaration//GEN-END:variables

   

    private void GetUser_ID_afterRegistration() {
        
        
             try {//database connection
                conn = DBConnection.getConnction();
                pps2 = conn.prepareStatement("SELECT * FROM  access WHERE name = ? and confirmed_password =? AND user =? ");
                pps2.setString(1, entered_user_name);
                pps2.setString(2, entered_user_password);
                pps2.setString(3, entered_user_level);

                rs2 = pps2.executeQuery();

                if (rs2.next()) {
                    obtained_use_id = rs2.getString("access_id");
                    
                    Teacher_more_info.getObj().setVisible(true);

                     Teacher_more_info.getObj().setPassed_id(obtained_use_id);
                     Teacher_more_info.getObj().printPassed_id();
                    this.dispose();
                    
                } 

             } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
             
             
             
    }
}
