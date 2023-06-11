
package hotel.management;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;


public class Teacher_Home_Page extends javax.swing.JFrame {

    
    //DATABASE CONNECTION
      Connection conn = null;
      PreparedStatement pps, pps1, pps2, pps3, pps4, pps6, pps5, pps7, pps8, pps9, pps10, pps11, pps12 ,pps13 = null;
      ResultSet rs, rs1, rs2, rs3, rs4, rs5, rs6, rs7, rs8, rs9, rs10, rs11, rs12 ,rs13= null;

    
    
    
 String  class_teacher_class  = null;
    //container variables that holds passed on info
    private String pass_user_id;
    private String user_name;

   String global_user_id = null; // A variable thats holds the id 
   
    String  user_access_id = null; 
    String resuorce = null;//resource to hold the id for amenities after qurying the avaliable content then use it when updating

    private static Teacher_Home_Page Obj = null;
    
    
    
    public Teacher_Home_Page() {
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
         count_lessonplan();
    }
    
        public void icon(){
       try {conn = DBConnection.getConnction();
            pps = conn.prepareStatement(" SELECT  * FROM  access WHERE access_id =?");
            pps.setString(1,global_user_id.trim()); 
            rs = pps.executeQuery();
            byte[] image = null;
            while(rs.next()){
                 user_access_id  =  rs.getString("access_id");
                 model.setText(rs.getString("user"));
                 String fname=  rs.getString("first_name");
                 String lname=  rs.getString("last_name");
                 welcome_lb.setText("HI " +fname +"  "+lname +"  Welcome To Your Home Page");
               
                }
            } catch (SQLException ex) {
            Logger.getLogger(Teacher_Home_Page.class.getName()).log(Level.SEVERE, null, ex);
            
            
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
       
       
         
    }
    
       
         public void count_lessonplan(){
            try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("SELECT  count(lesson_plan_id) FROM lesson_plan  WHERE Teacher_id =?  AND approve ='Pending'");
            pps.setString(1, global_user_id);
            rs = pps.executeQuery();
            if (rs.next()) {
                lb_payment_counter1.setText(rs.getString("count(lesson_plan_id)"));
             
            }
            } catch (SQLException ex) {
            Logger.getLogger(Teacher_lesson_plan.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
             try {
            conn = DBConnection.getConnction();
            pps1 = conn.prepareStatement("SELECT  count(lesson_plan_id) FROM lesson_plan  WHERE Teacher_id =?  AND approve ='approved'");
            pps1.setString(1, global_user_id);
            rs1 = pps1.executeQuery();
            if (rs1.next()) {
                lb_payment_counter.setText(rs1.getString("count(lesson_plan_id)"));
             
            }
            } catch (SQLException ex) {
            Logger.getLogger(Teacher_lesson_plan.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                try {
            conn = DBConnection.getConnction();
            pps5 = conn.prepareStatement("SELECT  count(Notification_id) FROM notification  WHERE Send_To =?  OR Send_To ='To All'  OR Send_To ='Teacher'");
            pps5.setString(1, global_user_id);
            rs5 = pps5.executeQuery();
            if (rs5.next()) {
                jLabel77.setText(rs5.getString("count(Notification_id)"));
             
            }
            } catch (SQLException ex) {
            Logger.getLogger(Teacher_lesson_plan.class.getName()).log(Level.SEVERE, null, ex);
            }
             
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
        
        
        
       public void line_chart(){
    
    
        try {
          String sql = "SELECT day_time, attendency FROM student_register";
          JDBCCategoryDataset dataset =new  JDBCCategoryDataset(DBConnection.getConnction(), sql);
          JFreeChart chart = ChartFactory.createLineChart(null, "day_time",   "attendency", dataset, PlotOrientation.VERTICAL, false, true, true); 
          BarRenderer renderer = null;
          CategoryPlot Plot = null;
          renderer = new BarRenderer(); 
        
           ChartFrame frame = new ChartFrame("Line chart",chart);
           frame.setVisible(true);
           frame.setLocation(237, 77);
           frame.setSize(1110,500);
           
        } catch (Exception ex) {
         Logger.getLogger(Teacher_Home_Page.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        report_panelBTN4 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        report_panelBTN5 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        report_panelBTN6 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        center_card = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        pay = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        pExpenses = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        lb_payment_counter1 = new javax.swing.JLabel();
        students_present = new javax.swing.JLabel();
        lb_payment_counter = new javax.swing.JLabel();
        lb_payment_pending = new javax.swing.JLabel();
        lb_payments = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        lb_payment_bg = new javax.swing.JLabel();
        students_tata = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        lb_students = new javax.swing.JLabel();
        lb_students_pending = new javax.swing.JLabel();
        lb_student_counter = new javax.swing.JLabel();
        lb_student_bg = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        homebg = new javax.swing.JLabel();
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

        report_panelBTN.setBackground(new java.awt.Color(121, 119, 119));
        report_panelBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                report_panelBTNMouseClicked(evt);
            }
        });
        report_panelBTN.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Currency_Settings_30px.png"))); // NOI18N
        jLabel21.setText("  lesson plan");
        report_panelBTN.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 30));

        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        report_panelBTN.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 30, 30));

        frontSide_btn_holder.add(report_panelBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 210, 60));

        archived_booking.setBackground(new java.awt.Color(121, 119, 119));
        archived_booking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                archived_bookingMouseClicked(evt);
            }
        });
        archived_booking.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_binder_30px_1.png"))); // NOI18N
        jLabel39.setText("  School Fees");
        jLabel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel39MouseClicked(evt);
            }
        });
        archived_booking.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 60));

        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        archived_booking.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 60));

        frontSide_btn_holder.add(archived_booking, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 210, -1));

        report_panelBTN1.setBackground(new java.awt.Color(121, 119, 119));
        report_panelBTN1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                report_panelBTN1MouseClicked(evt);
            }
        });
        report_panelBTN1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Currency_Settings_30px.png"))); // NOI18N
        jLabel22.setText("   Students Portal");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });
        report_panelBTN1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 160, 70));

        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        report_panelBTN1.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 60));

        frontSide_btn_holder.add(report_panelBTN1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 210, 60));

        report_panelBTN2.setBackground(new java.awt.Color(121, 119, 119));
        report_panelBTN2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                report_panelBTN2MouseClicked(evt);
            }
        });
        report_panelBTN2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Currency_Settings_30px.png"))); // NOI18N
        jLabel23.setText("   Student Register ");
        report_panelBTN2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 200, 60));

        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        report_panelBTN2.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 50));

        frontSide_btn_holder.add(report_panelBTN2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 210, 60));

        report_panelBTN3.setBackground(new java.awt.Color(121, 119, 119));
        report_panelBTN3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                report_panelBTN3MouseClicked(evt);
            }
        });
        report_panelBTN3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Currency_Settings_30px.png"))); // NOI18N
        jLabel24.setText("   View Results  ");
        report_panelBTN3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 140, 30));

        jLabel92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        report_panelBTN3.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 60));

        frontSide_btn_holder.add(report_panelBTN3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 210, 70));

        report_panelBTN4.setBackground(new java.awt.Color(121, 119, 119));
        report_panelBTN4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                report_panelBTN4MouseClicked(evt);
            }
        });
        report_panelBTN4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Currency_Settings_30px.png"))); // NOI18N
        jLabel25.setText(" Records of work ");
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel25MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel25MouseExited(evt);
            }
        });
        report_panelBTN4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 30));

        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        report_panelBTN4.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 60));

        frontSide_btn_holder.add(report_panelBTN4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 600, 210, 60));

        report_panelBTN5.setBackground(new java.awt.Color(121, 119, 119));
        report_panelBTN5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                report_panelBTN5MouseClicked(evt);
            }
        });
        report_panelBTN5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Currency_Settings_30px.png"))); // NOI18N
        jLabel26.setText("   Item Request");
        report_panelBTN5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 170, 30));

        jLabel94.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel94.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        report_panelBTN5.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 30, 50));

        frontSide_btn_holder.add(report_panelBTN5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 210, 70));

        report_panelBTN6.setBackground(new java.awt.Color(121, 119, 119));
        report_panelBTN6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                report_panelBTN6MouseClicked(evt);
            }
        });
        report_panelBTN6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Currency_Settings_30px.png"))); // NOI18N
        jLabel27.setText("   Results Entry ");
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel27MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel27MouseExited(evt);
            }
        });
        report_panelBTN6.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 60));

        jLabel95.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel95.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        report_panelBTN6.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 60));

        frontSide_btn_holder.add(report_panelBTN6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 210, 60));

        layer_holder.add(frontSide_btn_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 210, 660));

        center_card.setBackground(new java.awt.Color(255, 255, 255));
        center_card.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_pass_fail_90px.png"))); // NOI18N
        jLabel29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });
        center_card.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, -1, 90));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(102, 102, 102));
        jLabel31.setText("STUDENT");
        center_card.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, 90, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/compliant1.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        center_card.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 520, 90, 100));

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(102, 102, 102));
        jLabel46.setText("Complaints");
        center_card.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 600, 70, 30));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Clock_Settings_90px.png"))); // NOI18N
        jLabel30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
        });
        center_card.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 400, 110, 90));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/compliant.png"))); // NOI18N
        center_card.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 510, 100, 100));

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(102, 102, 102));
        jLabel53.setText("LESSON  PLAN ");
        center_card.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 420, 150, 40));

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(102, 102, 102));
        jLabel54.setText("VIEW PORTAL");
        center_card.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 460, 90, 40));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_gantt_chart_90px.png"))); // NOI18N
        jLabel28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        center_card.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 210, 90, 90));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(102, 102, 102));
        jLabel43.setText("REPORT");
        center_card.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 240, -1, 40));

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(102, 102, 102));
        jLabel48.setText("ANALYSIS");
        center_card.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 270, -1, 30));

        pay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_create_document_90px.png"))); // NOI18N
        pay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                payMouseClicked(evt);
            }
        });
        center_card.add(pay, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 110, 120));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(102, 102, 102));
        jLabel37.setText("ENTRY");
        center_card.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 60, 20));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(102, 102, 102));
        jLabel40.setText("REUSLTS");
        center_card.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 70, 40));

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(102, 102, 102));
        jLabel56.setText("TM");
        center_card.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 250, 50, 40));

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(102, 102, 102));
        jLabel59.setText("SMS");
        center_card.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, 150, 50));

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(102, 102, 102));
        jLabel47.setText("REGISTER");
        center_card.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 490, 70, 30));

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(102, 102, 102));
        jLabel58.setText("instant");
        center_card.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, 120, 50));

        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_business_network_60px.png"))); // NOI18N
        center_card.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 80, 80));

        pExpenses.setBackground(new java.awt.Color(95, 158, 160));
        pExpenses.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        pExpenses.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel77.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setText("0");
        jLabel77.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 60, 30));

        lb_payment_counter1.setFont(new java.awt.Font("Tw Cen MT", 0, 13)); // NOI18N
        lb_payment_counter1.setForeground(new java.awt.Color(255, 51, 51));
        lb_payment_counter1.setText("0");
        lb_payment_counter1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(lb_payment_counter1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 70, 40, 20));

        students_present.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        students_present.setForeground(new java.awt.Color(102, 204, 0));
        students_present.setText("0");
        students_present.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(students_present, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 40, 20));

        lb_payment_counter.setFont(new java.awt.Font("Tw Cen MT", 0, 13)); // NOI18N
        lb_payment_counter.setForeground(new java.awt.Color(0, 204, 51));
        lb_payment_counter.setText("0");
        lb_payment_counter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(lb_payment_counter, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 70, 40, 20));

        lb_payment_pending.setFont(new java.awt.Font("Tw Cen MT", 0, 11)); // NOI18N
        lb_payment_pending.setForeground(new java.awt.Color(255, 255, 255));
        lb_payment_pending.setText(" Pending Notification");
        lb_payment_pending.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(lb_payment_pending, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 110, 30));

        lb_payments.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        lb_payments.setForeground(new java.awt.Color(255, 255, 255));
        lb_payments.setText("Notification");
        lb_payments.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(lb_payments, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 100, 30));

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Currency_Settings_30px.png"))); // NOI18N
        jLabel36.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 40, 80));

        lb_payment_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/shortcut2.png"))); // NOI18N
        lb_payment_bg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_payment_bg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_payment_bgMouseClicked(evt);
            }
        });
        pExpenses.add(lb_payment_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 120));

        students_tata.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        students_tata.setForeground(new java.awt.Color(255, 255, 102));
        students_tata.setText("6");
        students_tata.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(students_tata, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 30, 20));

        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_binder_30px_1.png"))); // NOI18N
        jLabel71.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 40, 60));

        lb_students.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        lb_students.setForeground(new java.awt.Color(255, 255, 255));
        lb_students.setText("Attendence");
        lb_students.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(lb_students, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 120, 30));

        lb_students_pending.setFont(new java.awt.Font("Tw Cen MT", 0, 11)); // NOI18N
        lb_students_pending.setForeground(new java.awt.Color(255, 255, 255));
        lb_students_pending.setText("attendence ");
        lb_students_pending.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(lb_students_pending, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, -1, 40));

        lb_student_counter.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        lb_student_counter.setForeground(new java.awt.Color(255, 255, 255));
        lb_student_counter.setText("/");
        lb_student_counter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(lb_student_counter, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, 20, 20));

        lb_student_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/shortcut.png"))); // NOI18N
        lb_student_bg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_student_bg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_student_bgMouseClicked(evt);
            }
        });
        pExpenses.add(lb_student_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 340, 100));

        jLabel76.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setText("Lesson plan");
        jLabel76.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, 110, 40));

        jLabel38.setFont(new java.awt.Font("Tw Cen MT", 0, 11)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText(" Pending Lesson");
        jLabel38.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 50, 90, 40));
        pExpenses.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 30, 40, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/shortcut3.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        pExpenses.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 330, 90));

        jLabel3.setText("jLabel3");
        pExpenses.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 24, -1, 40));

        center_card.add(pExpenses, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1100, 120));

        homebg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        homebg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/home.png"))); // NOI18N
        homebg.setText("jLabel4");
        center_card.add(homebg, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 970, 600));

        layer_holder.add(center_card, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 1100, 670));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/background_admi.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        layer_holder.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 60, -1, 780));

        getContentPane().add(layer_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 800));

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

    private void admin_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btnMouseClicked
 
    }//GEN-LAST:event_admin_btnMouseClicked

    private void admin_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btnMouseEntered
        admin_btn.setBackground(new Color(82,120,152));
    }//GEN-LAST:event_admin_btnMouseEntered

    private void admin_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btnMouseExited
        admin_btn.setBackground(new Color(121,119,119));
    }//GEN-LAST:event_admin_btnMouseExited

    private void report_panelBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_report_panelBTNMouseClicked
        
            Teacher_lesson_plan.getObj().setVisible(true);
         
       //passing user id 
        Teacher_lesson_plan.getObj().setPassed_id(pass_user_id);
        Teacher_lesson_plan.getObj().printPassed_id();
        this.dispose();   
        
                
    }//GEN-LAST:event_report_panelBTNMouseClicked

    private void archived_bookingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_archived_bookingMouseClicked
     
     
        Teacher_Payment_view My_New_view = new Teacher_Payment_view();
        this.dispose();
        My_New_view.setVisible(true);
    }//GEN-LAST:event_archived_bookingMouseClicked

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
          Teacher_Student_View.getObj().setVisible(true);
         
       //passing user id Teacher_ResultView_Page
        Teacher_Student_View.getObj().setPassed_id(pass_user_id);
        Teacher_Student_View.getObj().printPassed_id();
        this.dispose();
                     
        
    }//GEN-LAST:event_report_panelBTN1MouseClicked

    private void report_panelBTN2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_report_panelBTN2MouseClicked
         Teacher_Student_Register.getObj().setVisible(true);
         
       //passing user id 
        Teacher_Student_Register.getObj().setUserID(pass_user_id);
        Teacher_Student_Register.getObj().printUserID();
        this.dispose();
        
    }//GEN-LAST:event_report_panelBTN2MouseClicked

    private void report_panelBTN3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_report_panelBTN3MouseClicked
        Teacher_ResultView_Page.getObj().setVisible(true);
         
       //passing user id Teacher_ResultView_Page
        Teacher_ResultView_Page.getObj().setUserID(pass_user_id);
        Teacher_ResultView_Page.getObj().printUserID();
        this.dispose();
        
    }//GEN-LAST:event_report_panelBTN3MouseClicked

    private void lb_student_bgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_student_bgMouseClicked
       line_chart();
    }//GEN-LAST:event_lb_student_bgMouseClicked

    private void report_panelBTN4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_report_panelBTN4MouseClicked
        // TODO add your handling code Teacher_Student_Analysis:
        
         Teacher_Student_Analysis.getObj().setVisible(true);
         
       //passing user id Teacher_ResultView_Page
        Teacher_Student_Analysis.getObj().setPassed_id(pass_user_id);
        Teacher_Student_Analysis.getObj().printPassed_id();
        this.dispose();
        
    }//GEN-LAST:event_report_panelBTN4MouseClicked

    private void report_panelBTN5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_report_panelBTN5MouseClicked
         
         Teacher_Inventory.getObj().setVisible(true);
         
       //passing user id Teacher_ResultView_Page
        Teacher_Inventory.getObj().setPassed_id(pass_user_id);
        Teacher_Inventory.getObj().printPassed_id();
        this.dispose();
        
        
    }//GEN-LAST:event_report_panelBTN5MouseClicked

    private void report_panelBTN6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_report_panelBTN6MouseClicked
        Teacher_Student_Data_Entry.getObj().setVisible(true);
         
       //passing user id Teacher_ResultView_Page
        Teacher_Student_Data_Entry.getObj().setUserID(pass_user_id);
        Teacher_Student_Data_Entry.getObj().printUserID();
        this.dispose();
    }//GEN-LAST:event_report_panelBTN6MouseClicked

    private void payMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_payMouseClicked
        Teacher_Student_Data_Entry.getObj().setVisible(true);
         
       //passing user id Teacher_ResultView_Page
        Teacher_Student_Data_Entry.getObj().setUserID(pass_user_id);
        Teacher_Student_Data_Entry.getObj().printUserID();
        this.dispose();
    }//GEN-LAST:event_payMouseClicked

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        Teacher_Student_Register.getObj().setVisible(true);
         
       //passing user id 
        Teacher_Student_Register.getObj().setUserID(pass_user_id);
        Teacher_Student_Register.getObj().printUserID();
        this.dispose();
    }//GEN-LAST:event_jLabel29MouseClicked

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
         Teacher_Student_Data_Entry.getObj().setVisible(true);
         
       //passing user id Teacher_ResultView_Page
        Teacher_Student_Data_Entry.getObj().setUserID(pass_user_id);
        Teacher_Student_Data_Entry.getObj().printUserID();
        this.dispose();
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
              Teacher_lesson_plan.getObj().setVisible(true);
         
       //passing user id 
        Teacher_lesson_plan.getObj().setPassed_id(pass_user_id);
        Teacher_lesson_plan.getObj().printPassed_id();
        this.dispose();
    }//GEN-LAST:event_jLabel30MouseClicked

    private void lb_payment_bgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_payment_bgMouseClicked
          Teacher_Notification.getObj().setVisible(true);
         
       //passing user id Teacher_ResultView_Page
        Teacher_Notification.getObj().setPassed_id(pass_user_id);
        Teacher_Notification.getObj().printPassed_id();
        this.dispose();
    }//GEN-LAST:event_lb_payment_bgMouseClicked

    private void jLabel25MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseEntered
         
         jLabel25.setBackground(new Color(33,173,178));//enter
    }//GEN-LAST:event_jLabel25MouseEntered

    private void jLabel25MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseExited
          jLabel25.setBackground(new Color(121,119,119));//exit
        
    }//GEN-LAST:event_jLabel25MouseExited

    private void jLabel27MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseEntered
          
         jLabel27.setBackground(new Color(33,173,178));//enter
    }//GEN-LAST:event_jLabel27MouseEntered

    private void jLabel27MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseExited
           jLabel27.setBackground(new Color(121,119,119));//exit
         
    }//GEN-LAST:event_jLabel27MouseExited

    private void jLabel39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseClicked
       Teacher_Payment_view My_New_view = new Teacher_Payment_view();
        this.dispose();
        My_New_view.setVisible(true);
    }//GEN-LAST:event_jLabel39MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
      
           Teacher_Student_View.getObj().setVisible(true);
         
       //passing user id Teacher_ResultView_Page
        Teacher_Student_View.getObj().setPassed_id(pass_user_id);
        Teacher_Student_View.getObj().printPassed_id();
        this.dispose();
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
         Teacher_Student_View.getObj().setVisible(true);
         
       //passing user id Teacher_ResultView_Page
        Teacher_Student_View.getObj().setPassed_id(pass_user_id);
        Teacher_Student_View.getObj().printPassed_id();
        this.dispose();
                     
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
            Teacher_lesson_plan.getObj().setVisible(true);
         
       //passing user id 
        Teacher_lesson_plan.getObj().setPassed_id(pass_user_id);
        Teacher_lesson_plan.getObj().printPassed_id();
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

     public static Teacher_Home_Page getObj() {  //public method for instance Restriction
        if (Obj == null) {
            Obj = new Teacher_Home_Page();
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
            java.util.logging.Logger.getLogger(Teacher_Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Teacher_Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Teacher_Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Teacher_Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Teacher_Home_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel admin_btn;
    private javax.swing.JPanel archived_booking;
    private javax.swing.JPanel center_card;
    private javax.swing.JLabel exit_lb;
    private javax.swing.JPanel frontSide_btn_holder;
    private javax.swing.JLabel header_forExp;
    private javax.swing.JLabel homebg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JPanel layer_holder;
    private javax.swing.JLabel lb_payment_bg;
    private javax.swing.JLabel lb_payment_counter;
    private javax.swing.JLabel lb_payment_counter1;
    private javax.swing.JLabel lb_payment_pending;
    private javax.swing.JLabel lb_payments;
    private javax.swing.JLabel lb_student_bg;
    private javax.swing.JLabel lb_student_counter;
    private javax.swing.JLabel lb_students;
    private javax.swing.JLabel lb_students_pending;
    private javax.swing.JPanel left;
    private javax.swing.JLabel minize_lb;
    private javax.swing.JLabel model;
    private javax.swing.JPanel pExpenses;
    private javax.swing.JLabel pay;
    private javax.swing.JPanel report_panelBTN;
    private javax.swing.JPanel report_panelBTN1;
    private javax.swing.JPanel report_panelBTN2;
    private javax.swing.JPanel report_panelBTN3;
    private javax.swing.JPanel report_panelBTN4;
    private javax.swing.JPanel report_panelBTN5;
    private javax.swing.JPanel report_panelBTN6;
    private javax.swing.JPanel right;
    private javax.swing.JLabel students_present;
    private javax.swing.JLabel students_tata;
    private javax.swing.JLabel welcome_lb;
    // End of variables declaration//GEN-END:variables
}
