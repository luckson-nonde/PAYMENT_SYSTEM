
package hotel.management;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.AreaRendererEndType;
import org.jfree.chart.renderer.category.AreaRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;


public class Teacher_ResultView_Page extends javax.swing.JFrame {

    
    //DATABASE CONNECTION
      Connection conn = null;
      PreparedStatement pps, pps1, pps2, pps3, pps4, pps6, pps5, pps7, pps8, pps9, pps10, pps11, pps12 ,pps13 = null;
      ResultSet rs, rs1, rs2, rs3, rs4, rs5, rs6, rs7, rs8, rs9, rs10, rs11, rs12 ,rs13= null;

      String  get_class_id = null; 
      String Search_by;
    String  class_teacher_class = null; 
   
    //container variables that holds passed on info
    private String pass_user_id;
    private String user_name;

   String global_user_id = null; // A variable thats holds the id 
   
    String  user_access_id = null; 
    String resuorce = null;//resource to hold the id for amenities after qurying the avaliable content then use it when updating

    private static Teacher_ResultView_Page Obj = null;
    
    
    
    public Teacher_ResultView_Page() {
        initComponents();
    }

 //*********************************************************GETTING CURRENT USER ID
    public void setUserID(String user_id) {
        pass_user_id = user_id;
    }

    public String getUserID() {
        return pass_user_id;
    }

    public void printUserID() {
        global_user_id = getUserID();//setting the id of the user who logged in and set it to a global variable
        icon();
        school_icon_info();
        count_attaindancy();
     //    changeIcon();
    }
    
        public void icon(){
       try {conn = DBConnection.getConnction();
            pps = conn.prepareStatement(" SELECT  * FROM  access WHERE access_id =?");
            pps.setString(1,global_user_id.trim()); 
            rs = pps.executeQuery();
            byte[] image = null;
            while(rs.next()){
                 user_access_id  =  rs.getString("access_id");

                 String fname=  rs.getString("first_name");
                 String lname=  rs.getString("last_name");
                 welcome_lb.setText("HI " +fname +"  "+lname +"  Welcome To Results View");
                 lb_user.setText(rs.getString("name"));
                 model.setText(rs.getString("user"));
                 
                 image = rs.getBytes("user_pic");
                 Image img = Toolkit.getDefaultToolkit().createImage(image);
                 ImageIcon icon = new ImageIcon(img);

                Image modifiedImaged = img.getScaledInstance(img_usera.getWidth(), img_usera.getHeight(), Image.SCALE_SMOOTH);
                icon = new ImageIcon(modifiedImaged);
                user_img.setIcon(icon);
                }
            } catch (SQLException ex) {
            Logger.getLogger(Teacher_ResultView_Page.class.getName()).log(Level.SEVERE, null, ex);
           
          }
       
       
        try {  //GETTING AN EMPLOYEE NAME AND ID JOINT WITH THE HANDLING CLASS
            conn = DBConnection.getConnction();
            String sql = " SELECT employee.name, employee.user_login_id, classes.grade_room FROM employee INNER JOIN class_subject_joint ON employee.user_login_id = class_subject_joint.user_login_id INNER JOIN classes ON class_subject_joint.class_id = classes.class_id WHERE class_subject_joint.user_login_id = ? AND teacher_state = \"Class Teacher\"";
            pps5 = conn.prepareStatement(sql);
            pps5.setString(1, user_access_id);
            rs5 = pps5.executeQuery();
            if(rs5.next()){
             class_teacher_class = rs5.getString("grade_room");
            }
            } catch (SQLException ex) {Logger.getLogger(Teacher_Home_Page.class.getName()).log(Level.SEVERE, null, ex);}
       
       
       
       
       
       
       
       
        showContent_onAllTables();
    }
    
        
        
        
           public void school_icon_info(){
      
       try {
            conn = DBConnection.getConnction();
            pps3 = conn.prepareStatement(" SELECT  * FROM  school_settings");
            rs3 = pps3.executeQuery();
                 byte[] image = null;
                 byte[] images = null;

                 if(rs3.next()){
                     image = rs3.getBytes("school_logo");
                     Image img = Toolkit.getDefaultToolkit().createImage(image);
                     ImageIcon icon = new ImageIcon(img);

                     Image modifiedImaged = img.getScaledInstance(Url_logo.getWidth(), Url_logo.getHeight(), Image.SCALE_SMOOTH);
                     icon = new ImageIcon(modifiedImaged);
                     Url_logo.setIcon(icon);
                     
                     
                      images = rs3.getBytes("minstry_logo");
                     Image imgs = Toolkit.getDefaultToolkit().createImage(images);
                     ImageIcon icons = new ImageIcon(imgs);

                     Image modifiedImages = imgs.getScaledInstance(ministry_icon.getWidth(), ministry_icon.getHeight(), Image.SCALE_SMOOTH);
                     icons = new ImageIcon(modifiedImages);
                    ministry_icon.setIcon(icons);
                     
                     school_title.setText(rs3.getString("school_name").toUpperCase());
                    
                     
                     }
            } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
          }
    
    }
    
               public void count_attaindancy(){
          
            //#################################################Attendence#########################################################
            
             
             
              try {
            conn = DBConnection.getConnction();
            pps3 = conn.prepareStatement("SELECT  count(student_ids) FROM students  WHERE Student_Class =?");
            pps3.setString(1, class_teacher_class);
            rs3 = pps3.executeQuery();
            if (rs3.next()) {
                students_tata.setText(rs3.getString("count(student_ids)"));
             
            }
            } catch (SQLException ex) {
            Logger.getLogger(Teacher_lesson_plan.class.getName()).log(Level.SEVERE, null, ex);
             
            }
             
              
              
              
                Date date = new Date();
             java.sql.Date sqldate = new java.sql.Date(date.getTime());
       
           String timeLate = "Late";
           String timePresent = "Present";

           //USING THE CLASS THE TEACHERS HANDLS TO CALL ALL STUDENTS IN THAT CLASS   student_register
           try {conn = DBConnection.getConnction();
            pps4= conn.prepareStatement("SELECT  count(student_register_id) FROM  student_register WHERE (Class =? AND day_time =?) AND (attendency =? ||  attendency =? ) ");
            pps4.setString(1,class_teacher_class.trim()); 
             pps4.setDate(2,sqldate); 
             pps4.setString(3,timeLate);
             pps4.setString(4,timePresent);
            rs4 = pps4.executeQuery();
             if(rs4.next()){
                students_present.setText(rs4.getString("count(student_register_id)"));
                }
            } catch (SQLException ex) {Logger.getLogger(Teacher_Home_Page.class.getName()).log(Level.SEVERE, null, ex);}
       
       
              
              
              
              
              
              
              
              
              
              
               }
          
        
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layer_holder = new javax.swing.JPanel();
        model = new javax.swing.JLabel();
        welcome_lb = new javax.swing.JLabel();
        minize_lb = new javax.swing.JLabel();
        exit_lb = new javax.swing.JLabel();
        admin_btn = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        header_forExp = new javax.swing.JLabel();
        right = new javax.swing.JPanel();
        left = new javax.swing.JPanel();
        frontSide_btn_holder = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        img_usera = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        user_img = new javax.swing.JLabel();
        lb_user = new javax.swing.JLabel();
        report_panelBTN = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        archived_booking = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        report_panelBTN1 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        report_panelBTN2 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        report_panelBTN3 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        center_card = new javax.swing.JPanel();
        ClassViewer_list = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lb_ByRoomType = new javax.swing.JLabel();
        Searching_panel_holder = new javax.swing.JPanel();
        SByRoomType = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        Add_price4 = new javax.swing.JLabel();
        lb_bg_btnFirstView3 = new javax.swing.JLabel();
        Cover = new javax.swing.JPanel();
        addRoom_type = new javax.swing.JLabel();
        Assign = new javax.swing.JLabel();
        Delecte25 = new javax.swing.JLabel();
        edit19 = new javax.swing.JLabel();
        Delecte26 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lb_bg_btnFirstView2 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        Register_view = new javax.swing.JTable();
        jPanel37 = new javax.swing.JPanel();
        jLabel222 = new javax.swing.JLabel();
        jLabel223 = new javax.swing.JLabel();
        jLabel224 = new javax.swing.JLabel();
        jLabel225 = new javax.swing.JLabel();
        jLabel226 = new javax.swing.JLabel();
        jLabel227 = new javax.swing.JLabel();
        jLabel228 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        table_holder_bg16 = new javax.swing.JLabel();
        table_holder_bg17 = new javax.swing.JLabel();
        print_resuits = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ID = new javax.swing.JPanel();
        school_title = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jLabel229 = new javax.swing.JLabel();
        jLabel232 = new javax.swing.JLabel();
        jLabel233 = new javax.swing.JLabel();
        jLabel234 = new javax.swing.JLabel();
        jLabel235 = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        txtClass = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtName = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        number_Students = new javax.swing.JLabel();
        txtTerm = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane20 = new javax.swing.JScrollPane();
        Register_view1 = new javax.swing.JTable();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        ministry_icon = new javax.swing.JLabel();
        Url_logo = new javax.swing.JLabel();
        students_tata = new javax.swing.JLabel();
        students_present = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        layer_holder.setBackground(new java.awt.Color(153, 153, 153));
        layer_holder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        model.setForeground(new java.awt.Color(240, 240, 240));
        model.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        model.setText("jLabel2");
        layer_holder.add(model, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 10, 110, 40));

        welcome_lb.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        welcome_lb.setForeground(new java.awt.Color(255, 255, 255));
        welcome_lb.setText("Hi Admin,  Welcome To Report  Management");
        layer_holder.add(welcome_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 580, 30));

        minize_lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minize_lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_minus_19px.png"))); // NOI18N
        minize_lb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minize_lbMouseClicked(evt);
            }
        });
        layer_holder.add(minize_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 0, 40, 60));

        exit_lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit_lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_delete_18px_1.png"))); // NOI18N
        exit_lb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit_lbMouseClicked(evt);
            }
        });
        layer_holder.add(exit_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 0, 50, 60));

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
        jLabel42.setText("   Home");
        admin_btn.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, 40));

        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        admin_btn.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 30, 40));

        layer_holder.add(admin_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 210, 40));

        header_forExp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/header.png"))); // NOI18N
        header_forExp.setText("jLabel1");
        layer_holder.add(header_forExp, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, -1, 80));

        right.setBackground(new java.awt.Color(153, 153, 153));
        layer_holder.add(right, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 740, 1400, 60));

        left.setBackground(new java.awt.Color(153, 153, 153));
        layer_holder.add(left, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 60, 50, 740));

        frontSide_btn_holder.setBackground(new java.awt.Color(121, 119, 119));
        frontSide_btn_holder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                frontSide_btn_holderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                frontSide_btn_holderMouseExited(evt);
            }
        });
        frontSide_btn_holder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel28.setBackground(new java.awt.Color(121, 119, 119));
        jPanel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel28MouseClicked(evt);
            }
        });
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img_usera.setBackground(new java.awt.Color(121, 119, 119));
        img_usera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icon.png"))); // NOI18N
        img_usera.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, 130));

        user_img.setBackground(new java.awt.Color(51, 153, 255));
        user_img.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        user_img.setForeground(new java.awt.Color(153, 153, 153));
        user_img.setMaximumSize(new java.awt.Dimension(50, 60));
        user_img.setMinimumSize(new java.awt.Dimension(50, 60));
        user_img.setPreferredSize(new java.awt.Dimension(50, 60));
        img_usera.add(user_img, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 80, 70));

        jPanel28.add(img_usera, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 140, -1));

        lb_user.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        lb_user.setForeground(new java.awt.Color(255, 255, 255));
        lb_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_ok_12px.png"))); // NOI18N
        lb_user.setText("name");
        jPanel28.add(lb_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 160, 30));

        frontSide_btn_holder.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 150));

        report_panelBTN.setBackground(new java.awt.Color(121, 119, 119));
        report_panelBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                report_panelBTNMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                report_panelBTNMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                report_panelBTNMouseExited(evt);
            }
        });
        report_panelBTN.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Currency_Settings_30px.png"))); // NOI18N
        jLabel21.setText("   Results staticties ");
        report_panelBTN.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 60));

        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        report_panelBTN.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 60));

        frontSide_btn_holder.add(report_panelBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 210, 60));

        archived_booking.setBackground(new java.awt.Color(121, 119, 119));
        archived_booking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                archived_bookingMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                archived_bookingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                archived_bookingMouseExited(evt);
            }
        });
        archived_booking.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_binder_30px_1.png"))); // NOI18N
        jLabel39.setText("  School Fees");
        archived_booking.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 130, 44));

        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        archived_booking.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 60));

        frontSide_btn_holder.add(archived_booking, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 210, -1));

        report_panelBTN1.setBackground(new java.awt.Color(121, 119, 119));
        report_panelBTN1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                report_panelBTN1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                report_panelBTN1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                report_panelBTN1MouseExited(evt);
            }
        });
        report_panelBTN1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Currency_Settings_30px.png"))); // NOI18N
        jLabel22.setText("indiviual Analysis ");
        report_panelBTN1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 150, 30));

        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        report_panelBTN1.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 60));

        frontSide_btn_holder.add(report_panelBTN1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 210, 60));

        report_panelBTN2.setBackground(new java.awt.Color(121, 119, 119));
        report_panelBTN2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                report_panelBTN2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                report_panelBTN2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                report_panelBTN2MouseExited(evt);
            }
        });
        report_panelBTN2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Currency_Settings_30px.png"))); // NOI18N
        jLabel23.setText("   Register ");
        report_panelBTN2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 60));

        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        report_panelBTN2.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 60));

        frontSide_btn_holder.add(report_panelBTN2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 210, 60));

        report_panelBTN3.setBackground(new java.awt.Color(121, 119, 119));
        report_panelBTN3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                report_panelBTN3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                report_panelBTN3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                report_panelBTN3MouseExited(evt);
            }
        });
        report_panelBTN3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Currency_Settings_30px.png"))); // NOI18N
        jLabel24.setText("   Results Entry ");
        report_panelBTN3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 60));

        jLabel92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        report_panelBTN3.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 60));

        frontSide_btn_holder.add(report_panelBTN3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 210, 60));

        layer_holder.add(frontSide_btn_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 210, 660));

        center_card.setBackground(new java.awt.Color(255, 255, 255));
        center_card.setLayout(new java.awt.CardLayout());

        ClassViewer_list.setBackground(new Color(66,66,66,5));
        ClassViewer_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClassViewer_listMouseClicked(evt);
            }
        });
        ClassViewer_list.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel77.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(102, 102, 102));
        jLabel77.setText("CLASS");
        jLabel77.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ClassViewer_list.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 50, 50));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_user_25px.png"))); // NOI18N
        ClassViewer_list.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 40, 70));

        lb_ByRoomType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_ByRoomType.setForeground(new java.awt.Color(255, 255, 255));
        lb_ByRoomType.setText("Fliter");
        lb_ByRoomType.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_ByRoomType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_ByRoomTypeMouseClicked(evt);
            }
        });
        ClassViewer_list.add(lb_ByRoomType, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 80, 50));

        Searching_panel_holder.setLayout(new java.awt.CardLayout());

        SByRoomType.setPreferredSize(new java.awt.Dimension(370, 71));
        SByRoomType.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 2, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Search_15px.png"))); // NOI18N
        jLabel2.setText("  Search");
        SByRoomType.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 70, 40));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        SByRoomType.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 200, 30));

        Add_price4.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Add_price4.setForeground(new java.awt.Color(255, 255, 255));
        Add_price4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Add_price4.setText(" Results");
        Add_price4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_price4MouseClicked(evt);
            }
        });
        SByRoomType.add(Add_price4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 130, 60));

        lb_bg_btnFirstView3.setBackground(new java.awt.Color(255, 255, 255));
        lb_bg_btnFirstView3.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        lb_bg_btnFirstView3.setForeground(new java.awt.Color(255, 255, 255));
        lb_bg_btnFirstView3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_bg_btnFirstView3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        SByRoomType.add(lb_bg_btnFirstView3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 380, 70));

        Searching_panel_holder.add(SByRoomType, "card2");

        Cover.setPreferredSize(new java.awt.Dimension(380, 84));
        Cover.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addRoom_type.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        addRoom_type.setForeground(new java.awt.Color(255, 255, 255));
        addRoom_type.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        addRoom_type.setText("Results");
        addRoom_type.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addRoom_typeMouseClicked(evt);
            }
        });
        Cover.add(addRoom_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 80, 40));

        Assign.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Assign.setForeground(new java.awt.Color(255, 255, 255));
        Assign.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_checked_25px_2.png"))); // NOI18N
        Assign.setText("Print");
        Assign.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AssignMouseClicked(evt);
            }
        });
        Cover.add(Assign, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 70, 40));

        Delecte25.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte25.setForeground(new java.awt.Color(255, 255, 255));
        Delecte25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_no_entry_25px.png"))); // NOI18N
        Delecte25.setText("Delecte");
        Delecte25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Delecte25MouseClicked(evt);
            }
        });
        Cover.add(Delecte25, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 80, 40));

        edit19.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        edit19.setForeground(new java.awt.Color(255, 255, 255));
        edit19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_upload_to_ftp_30px.png"))); // NOI18N
        edit19.setText("Edit");
        edit19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edit19MouseClicked(evt);
            }
        });
        Cover.add(edit19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, 40));

        Delecte26.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte26.setForeground(new java.awt.Color(255, 255, 255));
        Delecte26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        Cover.add(Delecte26, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, -10, 380, 70));

        Searching_panel_holder.add(Cover, "card2");

        ClassViewer_list.add(Searching_panel_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, 370, 60));

        jButton1.setText("View");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        ClassViewer_list.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 610, -1, 30));

        lb_bg_btnFirstView2.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        lb_bg_btnFirstView2.setForeground(new java.awt.Color(255, 255, 255));
        lb_bg_btnFirstView2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_bg_btnFirstView2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        ClassViewer_list.add(lb_bg_btnFirstView2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, -10, 170, 80));

        Register_view.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        Register_view.setForeground(new java.awt.Color(102, 102, 102));
        Register_view.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Register_view.setRowHeight(35);
        Register_view.setRowMargin(5);
        Register_view.setShowVerticalLines(false);
        Register_view.setTableHeader(null);
        Register_view.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Register_viewMouseClicked(evt);
            }
        });
        jScrollPane19.setViewportView(Register_view);

        ClassViewer_list.add(jScrollPane19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 1080, 460));

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel222.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel222.setForeground(new java.awt.Color(102, 102, 102));
        jLabel222.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel222.setText("DATE");
        jPanel37.add(jLabel222, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 70, 50));

        jLabel223.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel223.setForeground(new java.awt.Color(102, 102, 102));
        jLabel223.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel223.setText("NAMES");
        jPanel37.add(jLabel223, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 50));

        jLabel224.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel224.setForeground(new java.awt.Color(102, 102, 102));
        jLabel224.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel224.setText("MARKS  ");
        jPanel37.add(jLabel224, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 90, 50));

        jLabel225.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel225.setForeground(new java.awt.Color(102, 102, 102));
        jLabel225.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel225.setText("TOTAL MARKS ");
        jPanel37.add(jLabel225, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 140, 50));

        jLabel226.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel226.setForeground(new java.awt.Color(102, 102, 102));
        jLabel226.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel226.setText("SUBJECTS");
        jPanel37.add(jLabel226, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 100, 50));

        jLabel227.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel227.setForeground(new java.awt.Color(102, 102, 102));
        jLabel227.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel227.setText("PERCENTAGE");
        jPanel37.add(jLabel227, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 130, 50));

        jLabel228.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel228.setForeground(new java.awt.Color(102, 102, 102));
        jLabel228.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel228.setText("TERM");
        jPanel37.add(jLabel228, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, 80, 50));

        ClassViewer_list.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1080, 50));

        jComboBox2.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(153, 153, 153));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Quiz", "Test", "Exam", "" }));
        ClassViewer_list.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 610, 100, 30));

        jComboBox1.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(153, 153, 153));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "First Term", "Second Term", "Third Term", "Final", "Mid Term" }));
        ClassViewer_list.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 610, 100, 30));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Term");
        ClassViewer_list.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 610, 40, 30));

        table_holder_bg16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        table_holder_bg16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/add_Room_typebg.png"))); // NOI18N
        ClassViewer_list.add(table_holder_bg16, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, -130, 1180, 850));

        table_holder_bg17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        table_holder_bg17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/add_Room_typebg.png"))); // NOI18N
        ClassViewer_list.add(table_holder_bg17, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, -130, 1180, 850));

        center_card.add(ClassViewer_list, "card8");

        print_resuits.setBackground(new java.awt.Color(153, 153, 153));
        print_resuits.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ID.setBackground(new java.awt.Color(255, 255, 255));
        ID.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        school_title.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        school_title.setForeground(new java.awt.Color(102, 102, 102));
        school_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        school_title.setText("SCHOOL NAME GOES HERE");
        ID.add(school_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 510, 20));

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel229.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel229.setForeground(new java.awt.Color(102, 102, 102));
        jLabel229.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel229.setText("COMMENTS");
        jPanel38.add(jLabel229, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 140, 50));

        jLabel232.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel232.setForeground(new java.awt.Color(102, 102, 102));
        jLabel232.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel232.setText(" MARKS OBTAINED ");
        jPanel38.add(jLabel232, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 170, 50));

        jLabel233.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel233.setForeground(new java.awt.Color(102, 102, 102));
        jLabel233.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel233.setText("SUBJECTS");
        jPanel38.add(jLabel233, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 50));

        jLabel234.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel234.setForeground(new java.awt.Color(102, 102, 102));
        jLabel234.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel234.setText("PERCENTAGE");
        jPanel38.add(jLabel234, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 130, 50));

        jLabel235.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel235.setForeground(new java.awt.Color(102, 102, 102));
        jLabel235.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel235.setText("TOTAL MARKS ");
        jPanel38.add(jLabel235, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 140, 50));

        ID.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 920, 50));

        email.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        email.setForeground(new java.awt.Color(102, 102, 102));
        email.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        email.setText("ASSESSMENT REPORT CARD");
        ID.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 520, 30));

        txtClass.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtClass.setText("12B");
        ID.add(txtClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 100, 30));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel10.setText("EXAM HELD IN ");
        ID.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, 130, 30));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel12.setText("12B");
        ID.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 100, 30));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel13.setText("EXAMINATION");
        ID.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 100, 30));

        txtName.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtName.setText("NAME");
        ID.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 120, 20));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel15.setText("STUDENT NAME");
        ID.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 110, 20));

        number_Students.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        number_Students.setText("POSTION IN CLASS");
        ID.add(number_Students, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 150, 20));

        txtTerm.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtTerm.setText("TERM 2");
        ID.add(txtTerm, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 210, 100, 20));
        ID.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 290, 200, 20));
        ID.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 160, 20));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel18.setText("CLASS");
        ID.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 60, 30));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel19.setText("TOTAL NUMBER OF PUPILS IN CLASS");
        ID.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 230, 30));
        ID.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 230, 190, 10));
        ID.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 190, 20));

        Register_view1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        Register_view1.setForeground(new java.awt.Color(102, 102, 102));
        Register_view1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Register_view1.setRowHeight(35);
        Register_view1.setRowMargin(5);
        Register_view1.setShowVerticalLines(false);
        Register_view1.setTableHeader(null);
        Register_view1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Register_view1MouseClicked(evt);
            }
        });
        jScrollPane20.setViewportView(Register_view1);

        ID.add(jScrollPane20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 920, 390));
        ID.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 110, 20));

        jLabel28.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel28.setText("   / ");
        ID.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, 20, 20));

        jLabel29.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel29.setText("ATTENDANCE");
        ID.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 110, 20));

        jLabel9.setText("Teacters signature");
        ID.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 980, 140, 30));

        jLabel30.setText("jLabel30");
        ID.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 1060, -1, -1));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel17.setText("POSTION IN CLASS");
        ID.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 270, 150, 30));

        ministry_icon.setText("Image UR");
        ID.add(ministry_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 150, 110));

        Url_logo.setText("Image UR");
        ID.add(Url_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, 150, 110));

        students_tata.setText("0");
        ID.add(students_tata, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, 20, 20));

        students_present.setText("0");
        ID.add(students_present, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 30, 20));

        jScrollPane1.setViewportView(ID);

        print_resuits.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 740));

        jLabel20.setText("Print Rep");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        print_resuits.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 80, 110, 50));

        center_card.add(print_resuits, "card3");
        center_card.add(jPanel1, "card4");

        layer_holder.add(center_card, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 1110, 670));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/background_admi.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        layer_holder.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 60, -1, 780));

        getContentPane().add(layer_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 800));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void minize_lbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minize_lbMouseClicked
        this.setExtendedState(Teacher_ResultView_Page.ICONIFIED);
    }//GEN-LAST:event_minize_lbMouseClicked

    private void exit_lbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_lbMouseClicked
        Dialog frame = new Dialog();
        frame.setVisible(true);
    }//GEN-LAST:event_exit_lbMouseClicked

    private void admin_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btnMouseClicked
              this.dispose();
              Teacher_Home_Page.getObj().setVisible(true);
    }//GEN-LAST:event_admin_btnMouseClicked

    private void admin_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btnMouseEntered
        admin_btn.setBackground(new Color(82,120,152));
    }//GEN-LAST:event_admin_btnMouseEntered

    private void admin_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btnMouseExited
        admin_btn.setBackground(new Color(121,119,119));
    }//GEN-LAST:event_admin_btnMouseExited

    private void report_panelBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_report_panelBTNMouseClicked
    
    }//GEN-LAST:event_report_panelBTNMouseClicked

    private void report_panelBTNMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_report_panelBTNMouseEntered
        report_panelBTN.setBackground(new Color(33,173,178));
    }//GEN-LAST:event_report_panelBTNMouseEntered

    private void report_panelBTNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_report_panelBTNMouseExited
        report_panelBTN.setBackground(new Color(121,119,119));
    }//GEN-LAST:event_report_panelBTNMouseExited

    private void archived_bookingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_archived_bookingMouseClicked
    ClassViewer_list.hide();
            print_resuits.hide();
            jPanel1.setVisible(true);
    }//GEN-LAST:event_archived_bookingMouseClicked

    private void archived_bookingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_archived_bookingMouseEntered
        archived_booking.setBackground(new Color(33,173,178));
    }//GEN-LAST:event_archived_bookingMouseEntered

    private void archived_bookingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_archived_bookingMouseExited
        archived_booking.setBackground(new Color(121,119,119));
    }//GEN-LAST:event_archived_bookingMouseExited

    private void frontSide_btn_holderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frontSide_btn_holderMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_frontSide_btn_holderMouseEntered

    private void frontSide_btn_holderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frontSide_btn_holderMouseExited
        // TODO add your handling code here:////////////eixt
        // if(evt.getSource()==MuiltpleOption1 ){
            //   top.setVisible(true);

            //   }
    }//GEN-LAST:event_frontSide_btn_holderMouseExited

    private void report_panelBTN1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_report_panelBTN1MouseClicked
        
        
        
       areaChart();
    }//GEN-LAST:event_report_panelBTN1MouseClicked

    
     public void areaChart(){
    
        try {
            
             String sql = " SELECT Day_time , Marks_obtain FROM student_resuits WHERE Full_name  like '%" + get_class_id + "%' ";
         
            
            
            
    //     String sql = "SELECT  Day_time, Marks_obtain FROM  student_resuits";
         JDBCCategoryDataset dataset = new  JDBCCategoryDataset(DBConnection.getConnction(), sql);
        
        JFreeChart chart = ChartFactory.createAreaChart( "","Period","Payments",dataset, PlotOrientation.VERTICAL,false,true, true );
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
       //plot.setForegroundAlpha(0.2f);
         plot.setDomainGridlinesVisible(false);
         plot.setRangeGridlinesVisible(false);

         plot.setBackgroundPaint(new Color(234,234,234));
         AreaRenderer renderer = (AreaRenderer) plot.getRenderer();
         renderer.setEndType(AreaRendererEndType.LEVEL);
      
        
         chart.setBackgroundPaint(Color.GREEN);
         chart.setBackgroundPaint(null);
	 chart.setBackgroundImageAlpha(0.4f); 
            
        
          ChartFrame frame = new ChartFrame("Area  Chart",chart);
          frame.setVisible(true);
          frame.setLocation(5, 370);
          frame.setSize(725,390);
            
        } catch (Exception ex) {
                     Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
   
        }
    
    
    }
    
    
    
    
    private void report_panelBTN1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_report_panelBTN1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_report_panelBTN1MouseEntered

    private void report_panelBTN1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_report_panelBTN1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_report_panelBTN1MouseExited

    private void report_panelBTN2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_report_panelBTN2MouseClicked
        Class_areaChart();
    }//GEN-LAST:event_report_panelBTN2MouseClicked

    public void Class_areaChart(){
    
        try {
            
             String sql = " SELECT Day_time , Marks_obtain FROM student_resuits WHERE Full_name  like '%" + get_class_id + "%' ";
         
            
            
            
    //     String sql = "SELECT  Day_time, Marks_obtain FROM  student_resuits";
         JDBCCategoryDataset dataset = new  JDBCCategoryDataset(DBConnection.getConnction(), sql);
        
        JFreeChart chart = ChartFactory.createAreaChart( "","Period","Payments",dataset, PlotOrientation.VERTICAL,false,true, true );
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
       //plot.setForegroundAlpha(0.2f);
         plot.setDomainGridlinesVisible(false);
         plot.setRangeGridlinesVisible(false);

         plot.setBackgroundPaint(new Color(234,234,234));
         AreaRenderer renderer = (AreaRenderer) plot.getRenderer();
         renderer.setEndType(AreaRendererEndType.LEVEL);
      
        
         chart.setBackgroundPaint(Color.GREEN);
         chart.setBackgroundPaint(null);
	 chart.setBackgroundImageAlpha(0.4f); 
            
        
          ChartFrame frame = new ChartFrame("Area  Chart",chart);
          frame.setVisible(true);
          frame.setLocation(5, 370);
          frame.setSize(725,390);
            
        } catch (Exception ex) {
                     Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
   
        }
    
    
    }
    
    
    private void report_panelBTN2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_report_panelBTN2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_report_panelBTN2MouseEntered

    private void report_panelBTN2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_report_panelBTN2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_report_panelBTN2MouseExited

    private void report_panelBTN3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_report_panelBTN3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_report_panelBTN3MouseClicked

    private void report_panelBTN3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_report_panelBTN3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_report_panelBTN3MouseEntered

    private void report_panelBTN3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_report_panelBTN3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_report_panelBTN3MouseExited

    private void jPanel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel28MouseClicked

    }//GEN-LAST:event_jPanel28MouseClicked

    private void lb_ByRoomTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_ByRoomTypeMouseClicked

        if(Cover.isShowing()){
            Cover.hide();
            SByRoomType.setVisible(true);
        }else if(SByRoomType.isShowing()){
            SByRoomType.hide();
            Cover.setVisible(true);
        }
    }//GEN-LAST:event_lb_ByRoomTypeMouseClicked

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        try {

            conn = DBConnection.getConnction();
            String sql ="SELECT  Full_name,subject,Marks_obtain,Percentage,Total_Marks,Day_time,Class,Term FROM student_resuits WHERE Handing_Teacher =?   AND Full_name  like '%" + jTextField1.getText() + "%'  OR subject  like '%" + jTextField1.getText() + "%'   OR  Term  like '%" + jTextField1.getText() + "%'   OR  Percentage  like '%" + jTextField1.getText() + "%'  ";
            pps = conn.prepareStatement(sql);
             pps.setString(1 , global_user_id); 
            rs = pps.executeQuery();
            Register_view.setModel(DbUtils.resultSetToTableModel(rs));//sho
        } catch (SQLException ex) {Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_jTextField1KeyTyped

    private void Add_price4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_price4MouseClicked
          Teacher_Student_Data_Entry.getObj().setVisible(true);
         
       //passing user id Teacher_ResultView_Page
        Teacher_Student_Data_Entry.getObj().setUserID(pass_user_id);
        Teacher_Student_Data_Entry.getObj().printUserID();
        this.dispose();
      
    }//GEN-LAST:event_Add_price4MouseClicked

    private void addRoom_typeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addRoom_typeMouseClicked
       Teacher_Student_Data_Entry.getObj().setVisible(true);
         
       //passing user id Teacher_ResultView_Page
        Teacher_Student_Data_Entry.getObj().setUserID(pass_user_id);
        Teacher_Student_Data_Entry.getObj().printUserID();
        this.dispose();
    }//GEN-LAST:event_addRoom_typeMouseClicked

    private void AssignMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AssignMouseClicked

             if (get_class_id.equals("none")) {
            JOptionPane.showMessageDialog(null, "Select the Result You Wish To Print");
        } else if (!get_class_id.equals("none")) {
        
        
        
        try {
            conn = DBConnection.getConnction();
            pps2 = conn.prepareStatement("SELECT *  FROM student_resuits WHERE Handing_Teacher = ? AND Full_name=? ");
            pps2.setString(1, global_user_id);
             pps2.setString(2, get_class_id);
            rs2 = pps2.executeQuery();
            if(rs2.next()){
                
                
         try {
      
         conn = DBConnection.getConnction();
         String sql = " SELECT  subject,Total_Marks,Marks_obtain,Percentage,Comments FROM student_resuits WHERE Handing_Teacher =? AND Full_name=? ";
         pps4 = conn.prepareStatement(sql);
         pps4.setString(1, global_user_id);
         pps4.setString(2, get_class_id);
         rs4 = pps4.executeQuery();
         Register_view1.setModel(DbUtils.resultSetToTableModel(rs4));
         } catch (SQLException ex) {Logger.getLogger(Teacher_ResultView_Page.class.getName()).log(Level.SEVERE, null, ex);}
                
                
                students_inf();
            }
        } catch (Exception ex) {
            Logger.getLogger(Teacher_ResultView_Page.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        }
        
        
         
        
       
    }//GEN-LAST:event_AssignMouseClicked

    public void students_inf(){
                ClassViewer_list.hide();
                print_resuits.setVisible(true); 
        
        
        
       String class_names = null;
       try {
      
         conn = DBConnection.getConnction();
          String sql = " SELECT  Full_name,subject,Marks_obtain,Percentage,Total_Marks,Day_time,Class,Term FROM student_resuits WHERE Handing_Teacher =? AND Full_name =?";
         pps1 = conn.prepareStatement(sql);
         pps1.setString(1, global_user_id);
             pps1.setString(2, get_class_id);
         rs1 = pps1.executeQuery();
            if(rs1.next()){
              txtName.setText(rs1.getString("Full_name"));
                txtTerm.setText(rs1.getString("Term"));
                 txtClass .setText(rs1.getString("Class"));      
                class_names = rs1.getString("Class");
            }
         } catch (SQLException ex) {Logger.getLogger(Teacher_ResultView_Page.class.getName()).log(Level.SEVERE, null, ex);}
       
       
              try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("SELECT  count(student_ids) FROM students  WHERE Student_Class =?");
            pps.setString(1, class_names);
            rs = pps.executeQuery();
            if (rs.next()) {
                number_Students.setText(rs.getString("count(student_ids)"));
        
            }
        } catch (SQLException ex) {
            Logger.getLogger(Teacher_ResultView_Page.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    private void Delecte25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Delecte25MouseClicked
       
           if (get_class_id.equals("none")) {
            JOptionPane.showMessageDialog(null, "Select the Result You Wish To Delete");
        } else if (!get_class_id.equals("none")) {
        
        
        
        try {
            conn = DBConnection.getConnction();
            pps2 = conn.prepareStatement("DELETE  FROM student_resuits WHERE Handing_Teacher = ?");
           pps2.setString(1, global_user_id);
            pps2.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(Teacher_ResultView_Page.class.getName()).log(Level.SEVERE, null, ex);
        }
        showContent_onAllTables();//show changes on the table after delete
        
        }
    }//GEN-LAST:event_Delecte25MouseClicked

     public void showContent_onAllTables(){
  
          try {
      
         conn = DBConnection.getConnction();
          String sql = " SELECT  Full_name,subject,Total_Marks,Marks_obtain,Percentage FROM student_resuits WHERE Handing_Teacher =? ";
         pps = conn.prepareStatement(sql);
         pps.setString(1, global_user_id);
         rs = pps.executeQuery();
         Register_view.setModel(DbUtils.resultSetToTableModel(rs));
         } catch (SQLException ex) {Logger.getLogger(Teacher_ResultView_Page.class.getName()).log(Level.SEVERE, null, ex);}
         //rooms on the 
    


    
    
    
    
    
    
    
    
     }
    
    
    private void edit19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit19MouseClicked
     
    }//GEN-LAST:event_edit19MouseClicked

    private void Register_viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Register_viewMouseClicked
        if(Cover.isShowing()){
            Cover.hide();
            SByRoomType.setVisible(true);
        }else if(SByRoomType.isShowing()){
            SByRoomType.hide();
            Cover.setVisible(true);
        }
        DefaultTableModel tableMode_type = (DefaultTableModel) Register_view.getModel();
        get_class_id = tableMode_type.getValueAt(Register_view.getSelectedRow(), 0).toString();
        
        
       
       
    }//GEN-LAST:event_Register_viewMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
              String Term_mode_choosers =jComboBox1.getSelectedItem().toString().trim();
             String Term_choosers = jComboBox2.getSelectedItem().toString().trim();
             
            String Term = Term_mode_choosers + Term_choosers;
       
        try {//SELECT ALL STUDENTS

            conn = DBConnection.getConnction();
            String sql = " SELECT  Full_name,subject,Marks_obtain,Percentage,Total_Marks,Day_time,Class,Term FROM student_resuits WHERE Handing_Teacher =? AND Term = ?";
            pps = conn.prepareStatement(sql);
            pps.setString(1, global_user_id);
             pps.setString(2, Term);
            rs = pps.executeQuery();
            Register_view.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (SQLException ex) {Logger.getLogger(Teacher_ResultView_Page.class.getName()).log(Level.SEVERE, null, ex);}
        //rooms on the
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ClassViewer_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClassViewer_listMouseClicked
     
       
       
    }//GEN-LAST:event_ClassViewer_listMouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
          //printing the panel with its content
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Print Report Card ");

        job.setPrintable(new Printable() {
            public int print(Graphics pg, PageFormat pf, int PageNum) {
                pf.setOrientation(PageFormat.LANDSCAPE);
                if (PageNum > 0) {
                    return Printable.NO_SUCH_PAGE;
                }
                java.awt.Graphics2D g2 = (java.awt.Graphics2D) pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.63, 0.80);
             //   jLabel1.print(g2);
                ID.print(g2);

                return Printable.PAGE_EXISTS;
            }
        });

        boolean ok = job.printDialog();
        if (ok) {

            try {
                job.print();
            } catch (PrinterException ex) {
            }

        }
    }//GEN-LAST:event_jLabel20MouseClicked

    private void Register_view1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Register_view1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Register_view1MouseClicked
       
     public static Teacher_ResultView_Page getObj() {  //public method for instance Restriction
        if (Obj == null) {
            Obj = new Teacher_ResultView_Page();
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
            java.util.logging.Logger.getLogger(Teacher_ResultView_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Teacher_ResultView_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Teacher_ResultView_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Teacher_ResultView_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Teacher_ResultView_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Add_price4;
    private javax.swing.JLabel Assign;
    private javax.swing.JPanel ClassViewer_list;
    private javax.swing.JPanel Cover;
    private javax.swing.JLabel Delecte25;
    private javax.swing.JLabel Delecte26;
    private javax.swing.JPanel ID;
    private javax.swing.JTable Register_view;
    private javax.swing.JTable Register_view1;
    private javax.swing.JPanel SByRoomType;
    private javax.swing.JPanel Searching_panel_holder;
    private javax.swing.JLabel Url_logo;
    private javax.swing.JLabel addRoom_type;
    private javax.swing.JPanel admin_btn;
    private javax.swing.JPanel archived_booking;
    private javax.swing.JPanel center_card;
    private javax.swing.JLabel edit19;
    private javax.swing.JLabel email;
    private javax.swing.JLabel exit_lb;
    private javax.swing.JPanel frontSide_btn_holder;
    private javax.swing.JLabel header_forExp;
    private javax.swing.JPanel img_usera;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel223;
    private javax.swing.JLabel jLabel224;
    private javax.swing.JLabel jLabel225;
    private javax.swing.JLabel jLabel226;
    private javax.swing.JLabel jLabel227;
    private javax.swing.JLabel jLabel228;
    private javax.swing.JLabel jLabel229;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel232;
    private javax.swing.JLabel jLabel233;
    private javax.swing.JLabel jLabel234;
    private javax.swing.JLabel jLabel235;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel layer_holder;
    private javax.swing.JLabel lb_ByRoomType;
    private javax.swing.JLabel lb_bg_btnFirstView2;
    private javax.swing.JLabel lb_bg_btnFirstView3;
    private javax.swing.JLabel lb_user;
    private javax.swing.JPanel left;
    private javax.swing.JLabel ministry_icon;
    private javax.swing.JLabel minize_lb;
    private javax.swing.JLabel model;
    private javax.swing.JLabel number_Students;
    private javax.swing.JPanel print_resuits;
    private javax.swing.JPanel report_panelBTN;
    private javax.swing.JPanel report_panelBTN1;
    private javax.swing.JPanel report_panelBTN2;
    private javax.swing.JPanel report_panelBTN3;
    private javax.swing.JPanel right;
    private javax.swing.JLabel school_title;
    private javax.swing.JLabel students_present;
    private javax.swing.JLabel students_tata;
    private javax.swing.JLabel table_holder_bg16;
    private javax.swing.JLabel table_holder_bg17;
    private javax.swing.JLabel txtClass;
    private javax.swing.JLabel txtName;
    private javax.swing.JLabel txtTerm;
    private javax.swing.JLabel user_img;
    private javax.swing.JLabel welcome_lb;
    // End of variables declaration//GEN-END:variables
}
