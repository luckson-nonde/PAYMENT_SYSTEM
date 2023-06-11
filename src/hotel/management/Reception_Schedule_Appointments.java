package hotel.management;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Reception_Schedule_Appointments extends javax.swing.JFrame {

      Connection conn = null;
      PreparedStatement pps, pps1, pps2, pps3, pps4, pps6, pps5, pps7, pps8, pps9, pps10, pps11, pps12 ,pps13 = null;
      ResultSet rs, rs1, rs2, rs3, rs4, rs5, rs6, rs7, rs8, rs9, rs10, rs11, rs12 ,rs13= null;


    String gettingIDof_SelectedSubject = null;// getting id and use it to delecte elected content       
    String Resource_for_employeeID = null; //id to get the employee id and put it in relation to subjects
    String Resource_for_SubjectID = null; //id to get the subject id and put it in relation to subjects

            String  get_name = null;
            String  get_date= null;
            String  get_title= null;
            String get_content = null;
    //variable for class teacher id to make a joint like table
    String Teacher_id = null;

    //
    String grade_room = null;
    String class_capacity = null;
    int ClassCapacity_caculation;

     String assignToClass_count_students = null;
     String room_capacity_AsDefined_space = null;
     String subject_selected = "none";
    //user access
    private static String Recieved_user_id = null;
    private static String usertype = null;
    //passing user id
    private static Reception_Schedule_Appointments Obj = null;
    String passed_user_id;
     
     String  table_clicked = "none";
     String getclass_Id = null;           
     String getSubject_Id = null;
      String Seleted_teacher = null;
    
            int xx = 0;
            int yy = 0;
            String Search_EmployeeID = null;

            String input = null;
            
        Reception_Schedule_Appointments() {
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));
       
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
        DisplayingContent();
    }
    
    
    
      public void infoicon(){
       try {conn = DBConnection.getConnction();
            pps6 = conn.prepareStatement(" SELECT  * FROM  access WHERE access_id =?");
            pps6.setString(1,Recieved_user_id.trim()); 
            rs6 = pps6.executeQuery();
            while(rs6.next()){
            //     user_access_id  =  rs6.getString("access_id");

                 String fname=  rs6.getString("first_name");
                 String lname=  rs6.getString("last_name");
                 
                 jLabel37.setText("Hi !"+fname +"  "+lname + "  Welcome Messenger");
                 model.setText(rs6.getString("user"));
            
                }
            } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    
   
    
    
   
    
    public void DisplayingContent() {
          try {
            conn = DBConnection.getConnction();
            pps3 = conn.prepareStatement("SELECT name,date, purpose,content FROM appointments ");
            rs3 = pps3.executeQuery();
           
            notif_Table_display.setModel(DbUtils.resultSetToTableModel(rs3));//sho
        } catch (Exception ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

        
               try {
            conn = DBConnection.getConnction();
            pps5 = conn.prepareStatement("SELECT  count(Notification_id) FROM notification ");
            rs5 = pps5.executeQuery();
            if (rs5.next()) {
                lb_payment_counter.setText(rs5.getString("count(Notification_id)"));
             
            }
            } catch (SQLException ex) {
            Logger.getLogger(Teacher_lesson_plan.class.getName()).log(Level.SEVERE, null, ex);
            } 
          
                try {
            conn = DBConnection.getConnction();
            pps6 = conn.prepareStatement("SELECT  count(Notification_id) FROM notification  WHERE State ='Draft'");
            
            rs6 = pps6.executeQuery();
            if (rs6.next()) {
                jLabel78.setText(rs6.getString("count(Notification_id)"));
             
            }
            } catch (SQLException ex) {
            Logger.getLogger(Teacher_lesson_plan.class.getName()).log(Level.SEVERE, null, ex);
            } 
             try {
            conn = DBConnection.getConnction();
            pps7= conn.prepareStatement("SELECT  count(Notification_id) FROM notification  WHERE State ='Sent'");
            
            rs7 = pps7.executeQuery();
            if (rs7.next()) {
                lb_student_counter.setText(rs7.getString("count(Notification_id)"));
             
            }
            } catch (SQLException ex) {
            Logger.getLogger(Teacher_lesson_plan.class.getName()).log(Level.SEVERE, null, ex);
            } 
    }

    

    
  


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        frontSide_btn_holder = new javax.swing.JPanel();
        Tex_manager_lb = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        right = new javax.swing.JPanel();
        building_classes_panel = new javax.swing.JPanel();
        panel_Students = new javax.swing.JPanel();
        view_tabe = new javax.swing.JPanel();
        jScrollPane25 = new javax.swing.JScrollPane();
        notif_Table_display = new javax.swing.JTable();
        jPanel35 = new javax.swing.JPanel();
        jLabel213 = new javax.swing.JLabel();
        jLabel214 = new javax.swing.JLabel();
        jLabel215 = new javax.swing.JLabel();
        jLabel220 = new javax.swing.JLabel();
        Delecte10 = new javax.swing.JLabel();
        edit10 = new javax.swing.JLabel();
        Add_price1 = new javax.swing.JLabel();
        Add_price5 = new javax.swing.JLabel();
        Delecte9 = new javax.swing.JLabel();
        table_holder_bg8 = new javax.swing.JLabel();
        Add_price4 = new javax.swing.JLabel();
        upper_pane = new javax.swing.JPanel();
        lb_payment_counter = new javax.swing.JLabel();
        lb_payment_pending = new javax.swing.JLabel();
        lb_payments = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        lb_payment_bg = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        lb_students = new javax.swing.JLabel();
        lb_students_pending = new javax.swing.JLabel();
        lb_student_counter = new javax.swing.JLabel();
        lb_student_bg = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        view_tabe1 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jLabel219 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel218 = new javax.swing.JLabel();
        txt_from = new javax.swing.JTextField();
        txt_postion = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        txt_time = new com.github.lgooddatepicker.components.TimePicker();
        jLabel1 = new javax.swing.JLabel();
        jLabel223 = new javax.swing.JLabel();
        edit11 = new javax.swing.JLabel();
        Add_price2 = new javax.swing.JLabel();
        Add_price3 = new javax.swing.JLabel();
        jLabel222 = new javax.swing.JLabel();
        jLabel221 = new javax.swing.JLabel();
        Delecte12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        txtRef = new javax.swing.JTextField();
        State_v = new javax.swing.JLabel();
        jLabel217 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        table_holder_bg10 = new javax.swing.JLabel();
        table_holder_bg9 = new javax.swing.JLabel();
        minize_lb = new javax.swing.JLabel();
        exit_lb = new javax.swing.JLabel();
        admin_btn = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        model = new javax.swing.JLabel();
        header = new javax.swing.JLabel();
        BackGround_layer1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        Tex_manager_lb.setBackground(new java.awt.Color(121, 119, 119));
        Tex_manager_lb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tex_manager_lbMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Tex_manager_lbMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Tex_manager_lbMouseExited(evt);
            }
        });
        Tex_manager_lb.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel73.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_student_registration_35px.png"))); // NOI18N
        Tex_manager_lb.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 100, 40));

        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel74.setText("Search Records");
        jPanel31.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        Tex_manager_lb.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 130, 30));

        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel75.setText("Search Records");
        jPanel32.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel76.setText("Search Records");
        jPanel33.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel32.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 130, 30));

        Tex_manager_lb.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 130, 30));

        jLabel16.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("STUDENTS PORTAL ");
        Tex_manager_lb.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 160, 20));

        frontSide_btn_holder.add(Tex_manager_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 200, 80));

        jPanel1.add(frontSide_btn_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 200, 660));

        right.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.add(right, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 760, 1380, 60));

        building_classes_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_Students.setBackground(new java.awt.Color(255, 255, 255));
        panel_Students.setLayout(new java.awt.CardLayout());

        view_tabe.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        notif_Table_display.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        notif_Table_display.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        notif_Table_display.setGridColor(new java.awt.Color(255, 255, 255));
        notif_Table_display.setIntercellSpacing(new java.awt.Dimension(20, 5));
        notif_Table_display.setRowHeight(30);
        notif_Table_display.setTableHeader(null);
        notif_Table_display.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notif_Table_displayMouseClicked(evt);
            }
        });
        jScrollPane25.setViewportView(notif_Table_display);

        view_tabe.add(jScrollPane25, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 920, 360));

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));
        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel213.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel213.setForeground(new java.awt.Color(102, 102, 102));
        jLabel213.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel213.setText(" NAME");
        jPanel35.add(jLabel213, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 150, 40));

        jLabel214.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel214.setForeground(new java.awt.Color(102, 102, 102));
        jLabel214.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel214.setText("MEETING PURPOSE");
        jPanel35.add(jLabel214, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 180, 50));

        jLabel215.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel215.setForeground(new java.awt.Color(102, 102, 102));
        jLabel215.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel215.setText("SCHEDULED  DATE ");
        jPanel35.add(jLabel215, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 150, 40));

        jLabel220.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel220.setForeground(new java.awt.Color(102, 102, 102));
        jLabel220.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel220.setText("MEETING  TITLE ");
        jPanel35.add(jLabel220, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 140, 50));

        view_tabe.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 890, 50));

        Delecte10.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte10.setForeground(new java.awt.Color(255, 255, 255));
        Delecte10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_no_entry_25px.png"))); // NOI18N
        Delecte10.setText("Delecte");
        Delecte10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Delecte10MouseClicked(evt);
            }
        });
        view_tabe.add(Delecte10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 600, 80, 50));

        edit10.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        edit10.setForeground(new java.awt.Color(255, 255, 255));
        edit10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_upload_to_ftp_30px.png"))); // NOI18N
        edit10.setText("Edit");
        edit10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edit10MouseClicked(evt);
            }
        });
        view_tabe.add(edit10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 600, 80, 50));

        Add_price1.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Add_price1.setForeground(new java.awt.Color(255, 255, 255));
        Add_price1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Add_price1.setText("  Notice ");
        Add_price1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_price1MouseClicked(evt);
            }
        });
        view_tabe.add(Add_price1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 600, 80, 50));

        Add_price5.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Add_price5.setForeground(new java.awt.Color(255, 255, 255));
        Add_price5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Add_price5.setText("  View");
        Add_price5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_price5MouseClicked(evt);
            }
        });
        view_tabe.add(Add_price5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 600, 80, 50));

        Delecte9.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte9.setForeground(new java.awt.Color(255, 255, 255));
        Delecte9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        Delecte9.setText("Delecte");
        view_tabe.add(Delecte9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 580, 420, 80));

        table_holder_bg8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        table_holder_bg8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/display.png"))); // NOI18N
        view_tabe.add(table_holder_bg8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1130, 550));

        Add_price4.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Add_price4.setForeground(new java.awt.Color(255, 255, 255));
        Add_price4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Add_price4.setText("  Notice ");
        Add_price4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_price4MouseClicked(evt);
            }
        });
        view_tabe.add(Add_price4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 600, 80, 50));

        upper_pane.setBackground(new java.awt.Color(95, 158, 160));
        upper_pane.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        upper_pane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_payment_counter.setFont(new java.awt.Font("Tw Cen MT", 0, 13)); // NOI18N
        lb_payment_counter.setForeground(new java.awt.Color(0, 204, 51));
        lb_payment_counter.setText("0");
        upper_pane.add(lb_payment_counter, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 40, 30));

        lb_payment_pending.setFont(new java.awt.Font("Tw Cen MT", 0, 11)); // NOI18N
        lb_payment_pending.setForeground(new java.awt.Color(255, 255, 255));
        lb_payment_pending.setText(" All Notification");
        upper_pane.add(lb_payment_pending, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 90, 30));

        lb_payments.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        lb_payments.setForeground(new java.awt.Color(255, 255, 255));
        lb_payments.setText("Notification");
        upper_pane.add(lb_payments, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 100, 30));

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Currency_Settings_30px.png"))); // NOI18N
        upper_pane.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 40, 80));

        lb_payment_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/shortcut2.png"))); // NOI18N
        lb_payment_bg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_payment_bgMouseClicked(evt);
            }
        });
        upper_pane.add(lb_payment_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 340, 120));

        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_binder_30px_1.png"))); // NOI18N
        upper_pane.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 40, 60));

        lb_students.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        lb_students.setForeground(new java.awt.Color(255, 255, 255));
        lb_students.setText("Messages");
        upper_pane.add(lb_students, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 110, 30));

        lb_students_pending.setFont(new java.awt.Font("Tw Cen MT", 0, 11)); // NOI18N
        lb_students_pending.setForeground(new java.awt.Color(255, 255, 255));
        lb_students_pending.setText("Messages Sent");
        upper_pane.add(lb_students_pending, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 80, 40));

        lb_student_counter.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        lb_student_counter.setForeground(new java.awt.Color(255, 255, 255));
        lb_student_counter.setText("0");
        upper_pane.add(lb_student_counter, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 50, 20));

        lb_student_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/shortcut.png"))); // NOI18N
        lb_student_bg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_student_bg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_student_bgMouseClicked(evt);
            }
        });
        upper_pane.add(lb_student_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 340, 100));

        jLabel77.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setText("Draft");
        upper_pane.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, 110, 30));

        jLabel39.setFont(new java.awt.Font("Tw Cen MT", 0, 11)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText(" Messages approve");
        upper_pane.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 50, -1, 40));

        jLabel78.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setText("0");
        upper_pane.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 50, 60, 40));
        upper_pane.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, 40, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/shortcut3.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        upper_pane.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 330, 90));

        jLabel3.setText("jLabel3");
        upper_pane.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 24, -1, 40));

        view_tabe.add(upper_pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1140, 120));

        panel_Students.add(view_tabe, "card2");

        view_tabe1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));
        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel219.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel219.setForeground(new java.awt.Color(102, 102, 102));
        jLabel219.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel219.setText("SCHEDULED  DATE ");
        jPanel36.add(jLabel219, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 160, 30));

        jDateChooser1.setBackground(new Color(225,225,225,2));
        jDateChooser1.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(225,225,225,2)));
        jPanel36.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 260, 30));

        jLabel218.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel218.setForeground(new java.awt.Color(102, 102, 102));
        jLabel218.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel218.setText("FROM");
        jPanel36.add(jLabel218, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 160, 40));

        txt_from.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_fromKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_fromKeyTyped(evt);
            }
        });
        jPanel36.add(txt_from, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 290, 30));

        view_tabe1.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 950, 50));

        txt_postion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_postionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_postionKeyTyped(evt);
            }
        });
        view_tabe1.add(txt_postion, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 290, 30));

        txt_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nameKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nameKeyTyped(evt);
            }
        });
        view_tabe1.add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 290, 30));
        view_tabe1.add(txt_time, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 213, 270, 30));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_checkmark_15px.png"))); // NOI18N
        jLabel1.setText("Back ");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        view_tabe1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 50, 70, 30));

        jLabel223.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel223.setForeground(new java.awt.Color(102, 102, 102));
        jLabel223.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel223.setText("POSTION");
        view_tabe1.add(jLabel223, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 150, 30));

        edit11.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        edit11.setForeground(new java.awt.Color(255, 255, 255));
        edit11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_upload_to_ftp_30px.png"))); // NOI18N
        edit11.setText("Save As Draft");
        edit11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edit11MouseClicked(evt);
            }
        });
        view_tabe1.add(edit11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 620, 130, 50));

        Add_price2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Add_price2.setText("SCHEDULE");
        Add_price2.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Add_price2.setForeground(new java.awt.Color(255, 255, 255));
        Add_price2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_price2MouseClicked(evt);
            }
        });
        view_tabe1.add(Add_price2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 620, 100, 50));

        Add_price3.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Add_price3.setForeground(new java.awt.Color(255, 255, 255));
        Add_price3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Add_price3.setText("Update");
        Add_price3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_price3MouseClicked(evt);
            }
        });
        view_tabe1.add(Add_price3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 620, 80, 50));

        jLabel222.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel222.setForeground(new java.awt.Color(102, 102, 102));
        jLabel222.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel222.setText("SCHEDULED  TIME ");
        view_tabe1.add(jLabel222, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, 150, 40));

        jLabel221.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel221.setForeground(new java.awt.Color(102, 102, 102));
        jLabel221.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel221.setText(" PURPOSE  OF MEETING");
        view_tabe1.add(jLabel221, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, 180, 40));

        Delecte12.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte12.setForeground(new java.awt.Color(255, 255, 255));
        Delecte12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        Delecte12.setText("Delecte");
        view_tabe1.add(Delecte12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 600, 400, 80));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        view_tabe1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 900, 280));
        view_tabe1.add(txtRef, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 100, 260, 35));

        State_v.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        State_v.setForeground(new java.awt.Color(102, 102, 102));
        State_v.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        State_v.setText("CONTENT OF MEETING ");
        view_tabe1.add(State_v, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 180, 30));

        jLabel217.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel217.setForeground(new java.awt.Color(102, 102, 102));
        jLabel217.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel217.setText("NAME ");
        view_tabe1.add(jLabel217, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 170, 40));
        view_tabe1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 940, 20));
        view_tabe1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 910, 20));

        table_holder_bg10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        table_holder_bg10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/display.png"))); // NOI18N
        view_tabe1.add(table_holder_bg10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 850));

        table_holder_bg9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        table_holder_bg9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/display.png"))); // NOI18N
        view_tabe1.add(table_holder_bg9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1130, 550));

        panel_Students.add(view_tabe1, "card2");

        building_classes_panel.add(panel_Students, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 690));

        jPanel1.add(building_classes_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 1130, 690));

        minize_lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minize_lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_minus_19px.png"))); // NOI18N
        minize_lb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minize_lbMouseClicked(evt);
            }
        });
        jPanel1.add(minize_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 10, 40, 40));

        exit_lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit_lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_delete_18px_1.png"))); // NOI18N
        exit_lb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit_lbMouseClicked(evt);
            }
        });
        jPanel1.add(exit_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 10, 50, 40));

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
        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_home_page_30px.png"))); // NOI18N
        jLabel42.setText("   Home");
        admin_btn.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -6, 190, 50));

        jPanel1.add(admin_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 40));

        jLabel37.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Hi Admin,  Welcome To Report  Management");
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, 50));

        model.setForeground(new java.awt.Color(240, 240, 240));
        model.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        model.setText("jLabel2");
        jPanel1.add(model, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 10, 110, 40));

        header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/header.png"))); // NOI18N
        header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                headerMouseDragged(evt);
            }
        });
        header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                headerMousePressed(evt);
            }
        });
        jPanel1.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1370, 80));

        BackGround_layer1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/background_admi.png"))); // NOI18N
        BackGround_layer1.setText("jLabel13");
        jPanel1.add(BackGround_layer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, -20, -1, 940));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, 830));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void admin_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btnMouseClicked
       
            this.dispose();
            Admin_Home.getObj().setVisible(true);

        

    }//GEN-LAST:event_admin_btnMouseClicked

    private void admin_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btnMouseEntered
     admin_btn.setBackground(new Color(121,119,119));

    }//GEN-LAST:event_admin_btnMouseEntered

    private void admin_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btnMouseExited
    admin_btn.setBackground(new Color(121,119,119));
    }//GEN-LAST:event_admin_btnMouseExited

    private void Tex_manager_lbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tex_manager_lbMouseClicked
     

     
        panel_Students.setVisible(true);
    }//GEN-LAST:event_Tex_manager_lbMouseClicked

    private void Tex_manager_lbMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tex_manager_lbMouseEntered
        Tex_manager_lb.setBackground(new Color(33, 173, 178));
    }//GEN-LAST:event_Tex_manager_lbMouseEntered

    private void Tex_manager_lbMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tex_manager_lbMouseExited
        Tex_manager_lb.setBackground(new Color(121,119,119));
    }//GEN-LAST:event_Tex_manager_lbMouseExited

    private void frontSide_btn_holderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frontSide_btn_holderMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_frontSide_btn_holderMouseEntered

    private void frontSide_btn_holderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frontSide_btn_holderMouseExited
        // TODO add your handling code here:////////////eixt
        // if(evt.getSource()==MuiltpleOption1 ){
        //   top.setVisible(true);

        //   }
    }//GEN-LAST:event_frontSide_btn_holderMouseExited

    private void exit_lbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_lbMouseClicked
        Dialog frame = new Dialog();
        frame.setVisible(true);
    }//GEN-LAST:event_exit_lbMouseClicked

    private void minize_lbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minize_lbMouseClicked
        this.setExtendedState(Admin_Home.ICONIFIED);
    }//GEN-LAST:event_minize_lbMouseClicked

    private void Add_price1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_price1MouseClicked
         
        
        
        view_tabe.hide();
        view_tabe1.setVisible(true);
    }//GEN-LAST:event_Add_price1MouseClicked

    
 
    
    
    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
         int x=evt.getXOnScreen();
         int y=evt.getYOnScreen();
         this.setLocation(x-xx, y-yy);
    }//GEN-LAST:event_headerMouseDragged

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
       xx = evt.getX();
       yy = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void Add_price2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_price2MouseClicked
       
         if(txtRef.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "There is no title");
        }else if( jTextArea1.getText().isEmpty()){
          JOptionPane.showMessageDialog(null, "Write the massage ");
         }else {
        
        
       
    
         Date date = jDateChooser1.getDate();
         java.sql.Date sqldate = new java.sql.Date(date.getTime());
         
         
         
         
         
         
         
         
        
        try {
                 conn = DBConnection.getConnction();
                String sql = "INSERT INTO appointments (name,date, purpose,content,From_where,company_postion,meeting_time ) VALUES (?,?,?,?,?,?,?)";
                pps = conn.prepareStatement(sql);
                pps.setString(1 ,txt_name .getText().trim() );
                pps.setDate(2 ,  sqldate);
                pps.setString(3 ,  txtRef.getText().trim());  
                pps.setString(4 ,  jTextArea1.getText().trim());
                 pps.setString(5 ,  txt_from.getText().trim()); 
                 pps.setString(6 ,  txt_postion.getText().trim()); 
                 pps.setString(7 ,  txt_time.getText().trim()); 

                  pps.executeUpdate();
                  txt_from.setText(null);
                  txt_postion.setText(null);
                  txt_time.setText(null);
                  txtRef.setText(null);
                  jTextArea1.setText(null);
                  txt_name.setText(null);
                  JOptionPane.showMessageDialog(null, "Meeting  successfully scheduled");
                } catch (SQLException ex) {
                    Logger.getLogger(Reception_Schedule_Appointments.class.getName()).log(Level.SEVERE, null, ex); 
                }
                     DisplayingContent();
        
      
        }
         
        

    }//GEN-LAST:event_Add_price2MouseClicked

    private void txt_nameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nameKeyPressed
 if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
        }        
        
        
     
    }//GEN-LAST:event_txt_nameKeyPressed

    private void txt_nameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nameKeyTyped
           try {
        conn = DBConnection.getConnction();
        String sql ="SELECT name,surname,employeeid, contact,user_login_id    FROM employee     WHERE name  like '%" + txt_name.getText() + "%'  OR surname  like '%" + txt_name.getText() + "%'   OR  employeeid  like '%" + txt_name.getText() + "%'   OR  contact  like '%" + txt_name.getText() + "%' ";
                   
         pps = conn.prepareStatement(sql);
         rs = pps.executeQuery();
         if(rs.next()){
             input = rs.getString("user_login_id");
          String  name =   rs.getString("name");
           String  sname =   rs.getString("surname");
       //   txtname_holder.setText( name +"  "+sname);
         }
        
      } catch (SQLException ex) {Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);}
       
    }//GEN-LAST:event_txt_nameKeyTyped

    private void edit11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit11MouseClicked
        
    }//GEN-LAST:event_edit11MouseClicked

    private void Delecte10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Delecte10MouseClicked
      if (subject_selected.equals("none")) {
            JOptionPane.showMessageDialog(null, "Select the Message you wish to  DELETE");
        } else if (!subject_selected.equals("none")) {
         
        
        
           
        
        try {
            conn = DBConnection.getConnction();
            pps6 = conn.prepareStatement("DELETE  FROM appointments WHERE name = ?  AND date = ? AND purpose = ?");
            pps6.setString(1, get_name);
              pps6.setString(2, get_date);
              pps6.setString(3, get_title);
            pps6.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        DisplayingContent();//show changes on the table after delete
 }
    }//GEN-LAST:event_Delecte10MouseClicked

    private void notif_Table_displayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notif_Table_displayMouseClicked
        
        
      
        DefaultTableModel tableMode_type = (DefaultTableModel) notif_Table_display.getModel();
        get_name = tableMode_type.getValueAt(notif_Table_display.getSelectedRow(), 0).toString();
        
         DefaultTableModel tableMode_type1 = (DefaultTableModel) notif_Table_display.getModel();
         get_date = tableMode_type1.getValueAt(notif_Table_display.getSelectedRow(), 1).toString();
         
         
         
         DefaultTableModel tableMode_type2 = (DefaultTableModel) notif_Table_display.getModel();
         get_title = tableMode_type2.getValueAt(notif_Table_display.getSelectedRow(), 2).toString();
        
         DefaultTableModel tableMode_type3 = (DefaultTableModel) notif_Table_display.getModel();
         get_content = tableMode_type3.getValueAt(notif_Table_display.getSelectedRow(), 3).toString();
          subject_selected = "clicked";
        
    }//GEN-LAST:event_notif_Table_displayMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
               txtRef.setText(null);
                  jTextArea1.setText(null);
        
        
        
                txtRef.setEditable(true);
                 jTextArea1.setEditable(true);       
        
        
        view_tabe.setVisible(true);
        view_tabe1.hide(); 
    }//GEN-LAST:event_jLabel1MouseClicked

    private void edit10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit10MouseClicked
     if (subject_selected.equals("none")) {
            JOptionPane.showMessageDialog(null, "Select the Message you wish to  edit");
        } else if (!subject_selected.equals("none")) {
         
          
         State_v.setVisible(true); 
        
        view_tabe.hide();
        view_tabe1.setVisible(true);  
        
        try {
            conn = DBConnection.getConnction();
            pps6 = conn.prepareStatement("SELECT *  FROM appointments WHERE name = ?  AND date = ? AND purpose = ?");
            pps6.setString(1, get_name);
              pps6.setString(2, get_date);
              pps6.setString(3, get_title);
                rs6 = pps6.executeQuery();
                 while(rs6.next()){
        
                 txtRef.setText(rs6.getString("purpose"));
                 txt_name.setText(rs6.getString("name"));
                jTextArea1.setText(rs6.getString("content"));
                  txt_from.setText(rs6.getString("From_where"));
                  txt_postion.setText(rs6.getString("company_postion"));
                  txt_time.setText(rs6.getString("meeting_time"));
            
                }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
    }//GEN-LAST:event_edit10MouseClicked

    private void Add_price3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_price3MouseClicked
         
        
       if(txtRef.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "There is no title");
        }else if( jTextArea1.getText().isEmpty()){
          JOptionPane.showMessageDialog(null, "Write the massage ");
         }else {
        Date date = jDateChooser1.getDate();
         java.sql.Date sqldate = new java.sql.Date(date.getTime());
        
        try {
                 conn = DBConnection.getConnction();
                String sql = "UPDATE  appointments SET name =?,date=?, purpose =?,From_where,company_postion,meeting_time";
                pps = conn.prepareStatement(sql);
                pps.setString(1 ,txt_name .getText().trim() );
                pps.setDate(2 ,  sqldate);
                pps.setString(3 ,  txtRef.getText().trim());  
                pps.setString(4 ,  jTextArea1.getText().trim());
                 pps.setString(5 ,  txt_from.getText().trim()); 
                 pps.setString(6 ,  txt_postion.getText().trim()); 
                 pps.setString(7 ,  txt_time.getText().trim()); 
                pps.executeUpdate();
               
                  txtRef.setText(null);
                  jTextArea1.setText(null);
                  txt_time.setText(null);
                  txt_postion.setText(null);
                  txt_time.setText(null);
                  JOptionPane.showMessageDialog(null, "Successfully Updated");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
        
     
                     DisplayingContent();
            
            
            
         }
        
     
        
        
    
    }//GEN-LAST:event_Add_price3MouseClicked

    private void Add_price4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_price4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Add_price4MouseClicked

    private void Add_price5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_price5MouseClicked
      if (subject_selected.equals("none")) {
            JOptionPane.showMessageDialog(null, "Select the Message you wish to view");
        } else if (!subject_selected.equals("none")) {
          
             view_tabe.hide();
        view_tabe1.setVisible(true);  
       
        
        try {
            conn = DBConnection.getConnction();
            pps6 = conn.prepareStatement("SELECT *  FROM appointments WHERE name = ?  AND date = ? AND purpose = ?");
            pps6.setString(1, get_name);
              pps6.setString(2, get_date);
              pps6.setString(3, get_title);
                rs6 = pps6.executeQuery();
                 while(rs6.next()){
        
                 txtRef.setText(rs6.getString("purpose"));
                 txt_name.setText(rs6.getString("name"));
                jTextArea1.setText(rs6.getString("content"));
                txt_from.setText(rs6.getString("From_where"));
                txt_postion.setText(rs6.getString("company_postion"));
                txt_time.setText(rs6.getString("meeting_time"));
                txtRef.setEditable(false);
                 jTextArea1.setEditable(false);
                }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         State_v.hide(); 
            
        }
        
      
    }//GEN-LAST:event_Add_price5MouseClicked

    private void lb_student_bgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_student_bgMouseClicked
        String State = "Sent";
        
          try {
            conn = DBConnection.getConnction();
            pps3 = conn.prepareStatement("SELECT Ref,Sent_from,Content,Date ,State FROM notification WHERE State = ?");
            pps3.setString(1, State);
            rs3 = pps3.executeQuery();
           
            notif_Table_display.setModel(DbUtils.resultSetToTableModel(rs3));//sho
        } catch (Exception ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

    }//GEN-LAST:event_lb_student_bgMouseClicked

    private void lb_payment_bgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_payment_bgMouseClicked
      
          try {
            conn = DBConnection.getConnction();
            pps3 = conn.prepareStatement("SELECT Ref,Sent_from,Content,Date ,State FROM notification WHERE State = 'Sent' OR State ='Draft'");
            rs3 = pps3.executeQuery();
            notif_Table_display.setModel(DbUtils.resultSetToTableModel(rs3));//sho
        } catch (Exception ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

    }//GEN-LAST:event_lb_payment_bgMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
           try {
            conn = DBConnection.getConnction();
            pps3 = conn.prepareStatement("SELECT Ref,Sent_from,Content,Date ,State FROM notification WHERE  State ='Draft'");
            rs3 = pps3.executeQuery();
            notif_Table_display.setModel(DbUtils.resultSetToTableModel(rs3));//sho
        } catch (Exception ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

          
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txt_fromKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fromKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fromKeyPressed

    private void txt_fromKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fromKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fromKeyTyped

    private void txt_postionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_postionKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_postionKeyPressed

    private void txt_postionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_postionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_postionKeyTyped
   
    
  
    
    
    
    
    
    
    

    
     public static Reception_Schedule_Appointments getObj() {  //public method for instance Restriction
        if (Obj == null) {
            Obj = new Reception_Schedule_Appointments();
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
            java.util.logging.Logger.getLogger(Reception_Schedule_Appointments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reception_Schedule_Appointments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reception_Schedule_Appointments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reception_Schedule_Appointments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reception_Schedule_Appointments().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Add_price1;
    private javax.swing.JLabel Add_price2;
    private javax.swing.JLabel Add_price3;
    private javax.swing.JLabel Add_price4;
    private javax.swing.JLabel Add_price5;
    private javax.swing.JLabel BackGround_layer1;
    private javax.swing.JLabel Delecte10;
    private javax.swing.JLabel Delecte12;
    private javax.swing.JLabel Delecte9;
    private javax.swing.JLabel State_v;
    private javax.swing.JPanel Tex_manager_lb;
    private javax.swing.JPanel admin_btn;
    private javax.swing.JPanel building_classes_panel;
    private javax.swing.JLabel edit10;
    private javax.swing.JLabel edit11;
    private javax.swing.JLabel exit_lb;
    private javax.swing.JPanel frontSide_btn_holder;
    private javax.swing.JLabel header;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel213;
    private javax.swing.JLabel jLabel214;
    private javax.swing.JLabel jLabel215;
    private javax.swing.JLabel jLabel217;
    private javax.swing.JLabel jLabel218;
    private javax.swing.JLabel jLabel219;
    private javax.swing.JLabel jLabel220;
    private javax.swing.JLabel jLabel221;
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel223;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lb_payment_bg;
    private javax.swing.JLabel lb_payment_counter;
    private javax.swing.JLabel lb_payment_pending;
    private javax.swing.JLabel lb_payments;
    private javax.swing.JLabel lb_student_bg;
    private javax.swing.JLabel lb_student_counter;
    private javax.swing.JLabel lb_students;
    private javax.swing.JLabel lb_students_pending;
    private javax.swing.JLabel minize_lb;
    private javax.swing.JLabel model;
    private javax.swing.JTable notif_Table_display;
    private javax.swing.JPanel panel_Students;
    private javax.swing.JPanel right;
    private javax.swing.JLabel table_holder_bg10;
    private javax.swing.JLabel table_holder_bg8;
    private javax.swing.JLabel table_holder_bg9;
    private javax.swing.JTextField txtRef;
    private javax.swing.JTextField txt_from;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_postion;
    private com.github.lgooddatepicker.components.TimePicker txt_time;
    private javax.swing.JPanel upper_pane;
    private javax.swing.JPanel view_tabe;
    private javax.swing.JPanel view_tabe1;
    // End of variables declaration//GEN-END:variables
}
