package hotel.management;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Teacher_lesson_plan extends javax.swing.JFrame {

       Connection conn = null;
      PreparedStatement pps, pps1, pps2, pps3, pps4, pps6, pps5, pps7, pps8, pps9, pps10, pps11, pps12 ,pps13 = null;
      ResultSet rs, rs1, rs2, rs3, rs4, rs5, rs6, rs7, rs8, rs9, rs10, rs11, rs12 ,rs13= null;

    String Class_ResourceGetting_id = null;
    String insert_classromID_Class  = null;
    
     String   get_Subject  = null;
    String    get_Date  = null;
     String   get_Objectives  = null;
    String   get_Method  = null;
    
    
       
           
           
           
         
    
    String get_class_id  = "none";   
    String  obtained_class_id = null;
   
    String  subject_selected   = "none";
    String  obtained_subject_id = null;
     
     String Totalnum_pupils = "0";
    //user access
    private static String Recieved_user_id = null;
    private static String usertype = null;
    //passing user id
    private static Teacher_lesson_plan Obj = null;
    String passed_user_id;
     
      String  user_access_id = null; 
    
            int xx = 0;
            int yy = 0;
            String Search_EmployeeID = null;

        Teacher_lesson_plan() {
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));
        
              
      myClass_lessonPlans();

       myClass();
       count_students(); 
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
                         
           myClass_lessonPlans();              
                     
                         
                         

       icon();
    }
    
    
        public void icon(){
       try {conn = DBConnection.getConnction();
            pps = conn.prepareStatement(" SELECT  * FROM  access WHERE access_id =?");
            pps.setString(1,Recieved_user_id.trim()); 
            rs = pps.executeQuery();
            byte[] image = null;
            while(rs.next()){
                 user_access_id  =  rs.getString("access_id");
                usertype=  rs.getString("access_id");
                 model.setText(rs.getString("user"));
                 String fname=  rs.getString("first_name");
                 String lname=  rs.getString("last_name");
                 jLabel37.setText("HI " +fname +"  "+lname +"  Welcome To Your Lesson Plan Tool");
                 
                 
                }
            } catch (SQLException ex) {
            Logger.getLogger(Teacher_lesson_plan.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    
    
    
    
    public void myClass(){
        try {
            conn = DBConnection.getConnction();
            pps4 = conn.prepareStatement("SELECT * FROM classes");
            rs4 = pps4.executeQuery();
            while(rs4.next()){
              showclasses.addItem(rs4.getString("grade_room"));
             
            }
        } catch (SQLException ex) { JOptionPane.showMessageDialog(null, ex);}
        
        
      
        
        
    }
   
      
    public void myClass_lessonPlans(){
   try {
                 
                 conn = DBConnection.getConnction();
                String sql = ("SELECT   Subject,Topic,Objectives, Teaching_Learning,Method,Date, approve FROM lesson_plan  WHERE Teacher_id =?");
                pps5 = conn.prepareStatement(sql);
               
                  pps5.setString(1 ,  Recieved_user_id);
                  rs5 = pps5.executeQuery();
                  CreatedClasses.setModel(DbUtils.resultSetToTableModel(rs5));
                  
                } catch (SQLException ex) {
                    Logger.getLogger(Teacher_lesson_plan.class.getName()).log(Level.SEVERE, null, ex);
                }  
        
           try {
         String gendas = "Approved";
            conn = DBConnection.getConnction();
            pps3 = conn.prepareStatement("SELECT  count(lesson_plan_id) FROM  lesson_plan  WHERE Teacher_id =?  AND approve =?");
            pps3.setString(1, Recieved_user_id);
            pps3.setString(2, gendas);
            rs3= pps3.executeQuery();
            if (rs3.next()) {
                VApproved.setText(rs3.getString("count(lesson_plan_id)"));
             
            }
        } catch (SQLException ex) {
            Logger.getLogger(Teacher_lesson_plan.class.getName()).log(Level.SEVERE, null, ex);
        }
     
           
           
           
              try {
         String gendas = "Pending";
            conn = DBConnection.getConnction();
            pps4 = conn.prepareStatement("SELECT  count(lesson_plan_id) FROM  lesson_plan  WHERE Teacher_id =?  AND approve =?");
            pps4.setString(1, Recieved_user_id);
            pps4.setString(2, gendas);
            rs4= pps4.executeQuery();
            if (rs4.next()) {
                VApproved1.setText(rs4.getString("count(lesson_plan_id)"));
             
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Teacher_lesson_plan.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     
         try {
         String gendas = "Decline";
            conn = DBConnection.getConnction();
            pps5 = conn.prepareStatement("SELECT  count(lesson_plan_id) FROM  lesson_plan  WHERE Teacher_id =?  AND approve =?");
            pps5.setString(1, Recieved_user_id);
            pps5.setString(2, gendas);
            rs5= pps5.executeQuery();
            if (rs5.next()) {
                VApproved2.setText(rs5.getString("count(lesson_plan_id)"));
             
            }
        } catch (SQLException ex) {
            Logger.getLogger(Teacher_lesson_plan.class.getName()).log(Level.SEVERE, null, ex);
        }
   
   
   
        
        
    }
   
    
       public void count_students(){
            try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("SELECT  count(student_ids) FROM students  WHERE Student_Class =?");
            pps.setString(1, showclasses.getSelectedItem().toString().trim());
            rs = pps.executeQuery();
            if (rs.next()) {
                txtTotalnum_pupils.setText(rs.getString("count(student_ids)"));
             
            }
        } catch (SQLException ex) {
            Logger.getLogger(Teacher_lesson_plan.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
     try {
         String genda = "Male";
            conn = DBConnection.getConnction();
            pps1 = conn.prepareStatement("SELECT  count(student_ids) FROM students  WHERE Student_Class =? AND Student_Gender =?");
            pps1.setString(1, showclasses.getSelectedItem().toString().trim());
            pps1.setString(2, genda);
            rs1 = pps1.executeQuery();
            if (rs1.next()) {
                txtTotalnum_boys.setText(rs1.getString("count(student_ids)"));
             
            }
        } catch (SQLException ex) {
            Logger.getLogger(Teacher_lesson_plan.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
     
     
     try {
         String gendas = "Female";
            conn = DBConnection.getConnction();
            pps2 = conn.prepareStatement("SELECT  count(student_ids) FROM students  WHERE Student_Class =? AND Student_Gender =?");
            pps2.setString(1, showclasses.getSelectedItem().toString().trim());
            pps2.setString(2, gendas);
            rs2= pps2.executeQuery();
            if (rs2.next()) {
                girs.setText(rs2.getString("count(student_ids)"));
             
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
        right = new javax.swing.JPanel();
        building_classes_panel = new javax.swing.JPanel();
        Class_Config_panel = new javax.swing.JPanel();
        BookedContainer_main1 = new javax.swing.JPanel();
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
        jButton6 = new javax.swing.JButton();
        addRoom_type = new javax.swing.JLabel();
        edit19 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        Delecte27 = new javax.swing.JLabel();
        Delecte26 = new javax.swing.JLabel();
        Delecte28 = new javax.swing.JLabel();
        lb_bg_btnFirstView2 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        CreatedClasses = new javax.swing.JTable();
        jPanel37 = new javax.swing.JPanel();
        jLabel222 = new javax.swing.JLabel();
        jLabel223 = new javax.swing.JLabel();
        jLabel224 = new javax.swing.JLabel();
        jLabel225 = new javax.swing.JLabel();
        jLabel226 = new javax.swing.JLabel();
        jLabel227 = new javax.swing.JLabel();
        jLabel228 = new javax.swing.JLabel();
        VApproved2 = new javax.swing.JLabel();
        VApproved1 = new javax.swing.JLabel();
        VApproved = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        Delecte25 = new javax.swing.JLabel();
        table_holder_bg16 = new javax.swing.JLabel();
        panel_Teachers = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        showclasses = new javax.swing.JComboBox();
        self_eval = new javax.swing.JTextField();
        txt_subject_name = new javax.swing.JTextField();
        txtTopic = new javax.swing.JTextField();
        txtObjective = new javax.swing.JTextField();
        txtRationall = new javax.swing.JTextField();
        txtTandLaids = new javax.swing.JTextField();
        txtReferences = new javax.swing.JTextField();
        jPanel38 = new javax.swing.JPanel();
        jLabel232 = new javax.swing.JLabel();
        jLabel233 = new javax.swing.JLabel();
        jLabel234 = new javax.swing.JLabel();
        jLabel235 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtmethds = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtintro = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtContent = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtActivity = new javax.swing.JTextArea();
        jLabel229 = new javax.swing.JLabel();
        jLabel230 = new javax.swing.JLabel();
        txtSub_Topic = new javax.swing.JTextField();
        lesson_eva2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        girs = new javax.swing.JLabel();
        txtTotalnum_boys = new javax.swing.JLabel();
        txtTotalnum_pupils = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lesson_eva = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        view_plans = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        self_eval1 = new javax.swing.JTextField();
        txt_subject_name1 = new javax.swing.JTextField();
        txtTopic1 = new javax.swing.JTextField();
        txtObjective1 = new javax.swing.JTextField();
        txtRationall1 = new javax.swing.JTextField();
        txtTandLaids1 = new javax.swing.JTextField();
        txtReferences1 = new javax.swing.JTextField();
        jPanel39 = new javax.swing.JPanel();
        jLabel236 = new javax.swing.JLabel();
        jLabel237 = new javax.swing.JLabel();
        jLabel238 = new javax.swing.JLabel();
        jLabel239 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtmethds1 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtintro1 = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtContent1 = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtActivity1 = new javax.swing.JTextArea();
        jLabel231 = new javax.swing.JLabel();
        jLabel240 = new javax.swing.JLabel();
        txtSub_Topic1 = new javax.swing.JTextField();
        lesson_eva3 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        girs1 = new javax.swing.JLabel();
        txtTotalnum_boys1 = new javax.swing.JLabel();
        txtTotalnum_pupils1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        lesson_eva4 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        tbClass = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ntApproved = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel29 = new javax.swing.JLabel();
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
        jPanel1.add(frontSide_btn_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 200, 660));

        right.setBackground(new java.awt.Color(153, 153, 153));
        right.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(right, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 780, 1420, 50));

        building_classes_panel.setLayout(new java.awt.CardLayout());

        Class_Config_panel.setBackground(new Color(66,66,66,50));
        Class_Config_panel.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        Class_Config_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BookedContainer_main1.setBackground(new java.awt.Color(255, 255, 255));
        BookedContainer_main1.setLayout(new java.awt.CardLayout());

        ClassViewer_list.setBackground(new java.awt.Color(255, 255, 255));
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

        Searching_panel_holder.setBackground(new java.awt.Color(255, 255, 255));
        Searching_panel_holder.setLayout(new java.awt.CardLayout());

        SByRoomType.setBackground(new java.awt.Color(255, 255, 255));
        SByRoomType.setPreferredSize(new java.awt.Dimension(370, 71));
        SByRoomType.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 2, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Search_15px.png"))); // NOI18N
        jLabel2.setText("  Search");
        SByRoomType.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 80, 40));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        SByRoomType.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 190, 30));

        Add_price4.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Add_price4.setForeground(new java.awt.Color(255, 255, 255));
        Add_price4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Add_price4.setText("Lesson Plan");
        Add_price4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_price4MouseClicked(evt);
            }
        });
        SByRoomType.add(Add_price4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 130, 60));

        lb_bg_btnFirstView3.setBackground(new java.awt.Color(255, 255, 255));
        lb_bg_btnFirstView3.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        lb_bg_btnFirstView3.setForeground(new java.awt.Color(255, 255, 255));
        lb_bg_btnFirstView3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_bg_btnFirstView3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        SByRoomType.add(lb_bg_btnFirstView3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 380, 70));

        Searching_panel_holder.add(SByRoomType, "card2");

        Cover.setBackground(new java.awt.Color(255, 255, 255));
        Cover.setPreferredSize(new java.awt.Dimension(380, 84));
        Cover.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton6.setText("Review");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        Cover.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, -1, -1));

        addRoom_type.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        addRoom_type.setForeground(new java.awt.Color(255, 255, 255));
        addRoom_type.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        addRoom_type.setText("Lesson Plan");
        addRoom_type.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addRoom_typeMouseClicked(evt);
            }
        });
        Cover.add(addRoom_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 110, 40));

        edit19.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        edit19.setForeground(new java.awt.Color(255, 255, 255));
        edit19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_upload_to_ftp_30px.png"))); // NOI18N
        edit19.setText("Edit");
        edit19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edit19MouseClicked(evt);
            }
        });
        Cover.add(edit19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 80, 40));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Approved", "Pending", "Decline" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        Cover.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 90, 26));

        Delecte27.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte27.setForeground(new java.awt.Color(255, 255, 255));
        Delecte27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_no_entry_25px.png"))); // NOI18N
        Delecte27.setText("Delecte");
        Delecte27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Delecte27MouseClicked(evt);
            }
        });
        Cover.add(Delecte27, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 80, 40));

        Delecte26.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte26.setForeground(new java.awt.Color(255, 255, 255));
        Delecte26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        Cover.add(Delecte26, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -10, 390, 70));

        Delecte28.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte28.setForeground(new java.awt.Color(255, 255, 255));
        Delecte28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        Cover.add(Delecte28, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, -10, 610, 70));

        Searching_panel_holder.add(Cover, "card2");

        ClassViewer_list.add(Searching_panel_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, 610, 60));

        lb_bg_btnFirstView2.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        lb_bg_btnFirstView2.setForeground(new java.awt.Color(255, 255, 255));
        lb_bg_btnFirstView2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_bg_btnFirstView2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        ClassViewer_list.add(lb_bg_btnFirstView2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, -10, 170, 80));

        CreatedClasses.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        CreatedClasses.setForeground(new java.awt.Color(102, 102, 102));
        CreatedClasses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        CreatedClasses.setRowHeight(35);
        CreatedClasses.setRowMargin(5);
        CreatedClasses.setShowVerticalLines(false);
        CreatedClasses.setTableHeader(null);
        CreatedClasses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreatedClassesMouseClicked(evt);
            }
        });
        jScrollPane19.setViewportView(CreatedClasses);

        ClassViewer_list.add(jScrollPane19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 1050, 500));

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel222.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel222.setForeground(new java.awt.Color(102, 102, 102));
        jLabel222.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel222.setText("State");
        jPanel37.add(jLabel222, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 0, 100, 50));

        jLabel223.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel223.setForeground(new java.awt.Color(102, 102, 102));
        jLabel223.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel223.setText("Subject");
        jPanel37.add(jLabel223, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 50));

        jLabel224.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel224.setForeground(new java.awt.Color(102, 102, 102));
        jLabel224.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel224.setText("Objectives");
        jPanel37.add(jLabel224, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 150, 50));

        jLabel225.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel225.setForeground(new java.awt.Color(102, 102, 102));
        jLabel225.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel225.setText("Method");
        jPanel37.add(jLabel225, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 130, 30));

        jLabel226.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel226.setForeground(new java.awt.Color(102, 102, 102));
        jLabel226.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel226.setText("Topic");
        jPanel37.add(jLabel226, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 170, 50));

        jLabel227.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel227.setForeground(new java.awt.Color(102, 102, 102));
        jLabel227.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel227.setText("Teaching Learning");
        jPanel37.add(jLabel227, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 160, 50));

        jLabel228.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel228.setForeground(new java.awt.Color(102, 102, 102));
        jLabel228.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel228.setText("Date");
        jPanel37.add(jLabel228, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, 80, 50));

        ClassViewer_list.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 1040, 50));

        VApproved2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        VApproved2.setForeground(new java.awt.Color(204, 0, 0));
        VApproved2.setText("Decline");
        ClassViewer_list.add(VApproved2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, 70, 30));

        VApproved1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        VApproved1.setForeground(new java.awt.Color(0, 204, 204));
        VApproved1.setText("Pending");
        ClassViewer_list.add(VApproved1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 70, 50));

        VApproved.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        VApproved.setForeground(new java.awt.Color(51, 255, 102));
        VApproved.setText("Approved");
        ClassViewer_list.add(VApproved, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 24, 70, 30));

        jLabel28.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Decline");
        ClassViewer_list.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, 80, 30));

        jLabel31.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Pending");
        ClassViewer_list.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 70, 30));

        jLabel30.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Approved");
        ClassViewer_list.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 70, 40));

        Delecte25.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte25.setForeground(new java.awt.Color(255, 255, 255));
        Delecte25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_no_entry_25px.png"))); // NOI18N
        Delecte25.setText("View lessn plan");
        Delecte25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Delecte25MouseClicked(evt);
            }
        });
        ClassViewer_list.add(Delecte25, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 10, 140, 50));

        table_holder_bg16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        table_holder_bg16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/add_Room_typebg.png"))); // NOI18N
        ClassViewer_list.add(table_holder_bg16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1130, 600));

        BookedContainer_main1.add(ClassViewer_list, "card8");

        panel_Teachers.setBackground(new java.awt.Color(255, 255, 255));
        panel_Teachers.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Sub Topic");
        panel_Teachers.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 100, 30));

        jLabel4.setText("References");
        panel_Teachers.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 130, 30));

        jLabel5.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        jLabel5.setText("Class");
        panel_Teachers.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 90, 20));

        jLabel6.setText("Subject");
        panel_Teachers.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 90, 30));

        jLabel7.setText("Topic");
        panel_Teachers.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 90, 30));

        jLabel9.setText("Number of Girls ");
        panel_Teachers.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 140, 120, 20));

        jLabel10.setText("Rationall");
        panel_Teachers.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 120, 30));

        jLabel12.setText("Teaching / Learning Aids ");
        panel_Teachers.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 150, 30));

        jLabel13.setText("Objectives ");
        panel_Teachers.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 120, 20));

        jLabel14.setText("Number of pupils ");
        panel_Teachers.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 30, 120, 20));

        jLabel15.setText("Number of Boys ");
        panel_Teachers.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 90, 120, 20));

        showclasses.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        showclasses.setForeground(new java.awt.Color(153, 153, 153));
        showclasses.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                showclassesItemStateChanged(evt);
            }
        });
        panel_Teachers.add(showclasses, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 31, 240, 30));
        panel_Teachers.add(self_eval, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 650, 470, -1));
        panel_Teachers.add(txt_subject_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 240, 30));
        panel_Teachers.add(txtTopic, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 240, 30));
        panel_Teachers.add(txtObjective, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 240, 30));
        panel_Teachers.add(txtRationall, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 240, 30));
        panel_Teachers.add(txtTandLaids, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 240, 30));
        panel_Teachers.add(txtReferences, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 240, 30));

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel232.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel232.setForeground(new java.awt.Color(102, 102, 102));
        jLabel232.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel232.setText("Learner Activity ");
        jPanel38.add(jLabel232, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 200, 50));

        jLabel233.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel233.setForeground(new java.awt.Color(102, 102, 102));
        jLabel233.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel233.setText(" introduction");
        jPanel38.add(jLabel233, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 150, 50));

        jLabel234.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel234.setForeground(new java.awt.Color(102, 102, 102));
        jLabel234.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel234.setText("Method");
        jPanel38.add(jLabel234, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 0, 130, 50));

        jLabel235.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel235.setForeground(new java.awt.Color(102, 102, 102));
        jLabel235.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel235.setText("lesson content");
        jPanel38.add(jLabel235, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 150, 50));

        panel_Teachers.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 1080, 40));

        txtmethds.setColumns(20);
        txtmethds.setRows(5);
        jScrollPane1.setViewportView(txtmethds);

        panel_Teachers.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 300, 200, 260));

        txtintro.setColumns(20);
        txtintro.setRows(5);
        jScrollPane2.setViewportView(txtintro);

        panel_Teachers.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 200, 260));

        txtContent.setColumns(20);
        txtContent.setRows(5);
        jScrollPane3.setViewportView(txtContent);

        panel_Teachers.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 410, 260));

        txtActivity.setColumns(20);
        txtActivity.setRows(5);
        jScrollPane4.setViewportView(txtActivity);

        panel_Teachers.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 300, 280, 260));

        jLabel229.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel229.setForeground(new java.awt.Color(102, 102, 102));
        jLabel229.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel229.setText("Self evaluation");
        panel_Teachers.add(jLabel229, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, 140, 30));

        jLabel230.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel230.setForeground(new java.awt.Color(102, 102, 102));
        jLabel230.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel230.setText("Lesson evaluation ");
        panel_Teachers.add(jLabel230, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, 170, 30));
        panel_Teachers.add(txtSub_Topic, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 240, 30));

        lesson_eva2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lesson_eva2ActionPerformed(evt);
            }
        });
        panel_Teachers.add(lesson_eva2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 610, 70, -1));

        jLabel16.setText("Out of");
        panel_Teachers.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 610, 50, 20));

        girs.setText("43");
        panel_Teachers.add(girs, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 140, 80, 20));

        txtTotalnum_boys.setText("87");
        panel_Teachers.add(txtTotalnum_boys, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 90, 80, 20));

        txtTotalnum_pupils.setText("100");
        panel_Teachers.add(txtTotalnum_pupils, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 30, 80, 20));

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel_Teachers.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 640, -1, -1));

        lesson_eva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lesson_evaActionPerformed(evt);
            }
        });
        lesson_eva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lesson_evaKeyTyped(evt);
            }
        });
        panel_Teachers.add(lesson_eva, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 610, 70, -1));

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panel_Teachers.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 640, -1, -1));

        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panel_Teachers.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 640, -1, -1));

        BookedContainer_main1.add(panel_Teachers, "card2");

        view_plans.setBackground(new java.awt.Color(255, 255, 255));
        view_plans.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setText("Sub Topic");
        view_plans.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 100, 30));

        jLabel17.setText("References");
        view_plans.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 130, 30));

        jLabel18.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        jLabel18.setText("Class");
        view_plans.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 90, 20));

        jLabel19.setText("Subject");
        view_plans.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 90, 30));

        jLabel20.setText("Topic");
        view_plans.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 90, 30));

        jLabel21.setText("Number of Girls ");
        view_plans.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 140, 120, 20));

        jLabel22.setText("Rationall");
        view_plans.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 120, 30));

        jLabel23.setText("Teaching / Learning Aids ");
        view_plans.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 150, 30));

        jLabel24.setText("Objectives ");
        view_plans.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 120, 20));

        jLabel25.setText("Number of pupils ");
        view_plans.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 30, 120, 20));

        jLabel26.setText("Number of Boys ");
        view_plans.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 90, 120, 20));

        self_eval1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        self_eval1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        view_plans.add(self_eval1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 650, 470, 30));

        txt_subject_name1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txt_subject_name1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        view_plans.add(txt_subject_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 240, 30));

        txtTopic1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtTopic1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        view_plans.add(txtTopic1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 240, 30));

        txtObjective1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtObjective1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        view_plans.add(txtObjective1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 240, 30));

        txtRationall1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtRationall1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        view_plans.add(txtRationall1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, 240, 30));

        txtTandLaids1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtTandLaids1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        view_plans.add(txtTandLaids1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 240, 30));

        txtReferences1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtReferences1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        view_plans.add(txtReferences1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 180, 240, 30));

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel236.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel236.setForeground(new java.awt.Color(102, 102, 102));
        jLabel236.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel236.setText("Learner Activity ");
        jPanel39.add(jLabel236, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 200, 50));

        jLabel237.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel237.setForeground(new java.awt.Color(102, 102, 102));
        jLabel237.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel237.setText(" introduction");
        jPanel39.add(jLabel237, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 150, 50));

        jLabel238.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel238.setForeground(new java.awt.Color(102, 102, 102));
        jLabel238.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel238.setText("Method");
        jPanel39.add(jLabel238, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 0, 130, 50));

        jLabel239.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel239.setForeground(new java.awt.Color(102, 102, 102));
        jLabel239.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel239.setText("lesson content");
        jPanel39.add(jLabel239, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 150, 50));

        view_plans.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 1080, 40));

        txtmethds1.setColumns(20);
        txtmethds1.setRows(5);
        jScrollPane5.setViewportView(txtmethds1);

        view_plans.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 300, 200, 260));

        txtintro1.setColumns(20);
        txtintro1.setRows(5);
        jScrollPane6.setViewportView(txtintro1);

        view_plans.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 200, 260));

        txtContent1.setColumns(20);
        txtContent1.setRows(5);
        jScrollPane7.setViewportView(txtContent1);

        view_plans.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 410, 260));

        txtActivity1.setColumns(20);
        txtActivity1.setRows(5);
        jScrollPane8.setViewportView(txtActivity1);

        view_plans.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 300, 280, 260));

        jLabel231.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel231.setForeground(new java.awt.Color(102, 102, 102));
        jLabel231.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel231.setText("Self evaluation");
        view_plans.add(jLabel231, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, 140, 30));

        jLabel240.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel240.setForeground(new java.awt.Color(102, 102, 102));
        jLabel240.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel240.setText("Lesson evaluation ");
        view_plans.add(jLabel240, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, 170, 30));

        txtSub_Topic1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        txtSub_Topic1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        view_plans.add(txtSub_Topic1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 240, 30));

        lesson_eva3.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lesson_eva3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        lesson_eva3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lesson_eva3ActionPerformed(evt);
            }
        });
        view_plans.add(lesson_eva3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 610, 70, 20));

        jLabel27.setText("Out of");
        view_plans.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 610, 50, 20));

        girs1.setText("43");
        view_plans.add(girs1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 140, 80, 20));

        txtTotalnum_boys1.setText("87");
        view_plans.add(txtTotalnum_boys1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 90, 80, 20));

        txtTotalnum_pupils1.setText("100");
        view_plans.add(txtTotalnum_pupils1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 30, 80, 20));

        jButton4.setText("Print");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        view_plans.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 640, -1, -1));

        lesson_eva4.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lesson_eva4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        lesson_eva4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lesson_eva1ActionPerformed(evt);
            }
        });
        view_plans.add(lesson_eva4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 610, 70, -1));

        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        view_plans.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 640, -1, -1));

        tbClass.setText("jLabel28");
        view_plans.add(tbClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 230, 30));

        BookedContainer_main1.add(view_plans, "card2");

        Class_Config_panel.add(BookedContainer_main1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 690));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_delete_25px.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        Class_Config_panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 60, 60, 50));

        building_classes_panel.add(Class_Config_panel, "card3");

        ntApproved.setBackground(new Color(66,66,66,110));
        ntApproved.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane9.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 16, 700, 360));

        jLabel29.setForeground(new java.awt.Color(153, 0, 0));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Close");
        jLabel29.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 380, 90, 40));

        ntApproved.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 730, 430));

        building_classes_panel.add(ntApproved, "card3");

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
        jLabel42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel42MouseClicked(evt);
            }
        });
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
              Teacher_Home_Page.getObj().setVisible(true);

    }//GEN-LAST:event_admin_btnMouseClicked

    private void admin_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btnMouseEntered
     admin_btn.setBackground(new Color(121,119,119));

    }//GEN-LAST:event_admin_btnMouseEntered

    private void admin_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btnMouseExited
    admin_btn.setBackground(new Color(121,119,119));
    }//GEN-LAST:event_admin_btnMouseExited

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


      
   
    
    


    
    String class_chooser = null;
    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
         int x=evt.getXOnScreen();
         int y=evt.getYOnScreen();
         this.setLocation(x-xx, y-yy);
    }//GEN-LAST:event_headerMouseDragged

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
       xx = evt.getX();
       yy = evt.getY();
    }//GEN-LAST:event_headerMousePressed

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
            String sql ="SELECT  Subject,Topic, Sub_Topic,Class,Objectives,Date  FROM lesson_plan WHERE  Subject  like '%" + jTextField1.getText() + "%'  OR Topic  like '%" + jTextField1.getText() + "%'   OR  Sub_Topic  like '%" + jTextField1.getText() + "%'   OR  Class  like '%" + jTextField1.getText() + "%' "
            + "  OR  Objectives  like '%" + jTextField1.getText() + "%'  OR    Date  like '%" + jTextField1.getText() + "%'  ";
            pps6 = conn.prepareStatement(sql);
            rs6 = pps6.executeQuery();
            CreatedClasses.setModel(DbUtils.resultSetToTableModel(rs6));//sho
        } catch (SQLException ex) {Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);}

    }//GEN-LAST:event_jTextField1KeyTyped

    private void Add_price4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_price4MouseClicked
         ClassViewer_list.hide();
        panel_Teachers.setVisible(true);
        
    }//GEN-LAST:event_Add_price4MouseClicked

    private void addRoom_typeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addRoom_typeMouseClicked
        ClassViewer_list.hide();
        panel_Teachers.setVisible(true);

    }//GEN-LAST:event_addRoom_typeMouseClicked

    
    
    String class_names = null;
    String class_capacity = null;
    String class_counts = null;
    
    
    private void Delecte25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Delecte25MouseClicked
      
        
        if (subject_selected.equals("none")) {
            JOptionPane.showMessageDialog(null, " Choose the lesson plan  You wise to View ");
        } else if (!subject_selected.equals("none")) {
          
             
          
            
            ClassViewer_list.hide();
        panel_Teachers.hide();
        view_plans.setVisible(true);
      
               try {
                 
                conn = DBConnection.getConnction();
                String sql = ("SELECT  * FROM lesson_plan WHERE Subject =?  AND Date =? ");
                pps3 = conn.prepareStatement(sql);
                pps3.setString(1 ,  get_Subject);
                pps3.setString(2 ,  get_Date);
                  rs3 = pps3.executeQuery();
                  if(rs3.next()){ 
                  tbClass.setText(rs3.getString("Class"));
                      txt_subject_name1.setText(rs3.getString("Subject"));
                      txtTopic1.setText(rs3.getString("Topic"));
                      txtSub_Topic1 .setText(rs3.getString("Sub_Topic"));  
                      txtObjective1 .setText(rs3.getString("Objectives"));
                      txtRationall1 .setText(rs3.getString("Rationall"));
                      txtTandLaids1 .setText(rs3.getString("Teaching_Learning"));
                      txtReferences1 .setText(rs3.getString("Reference"));
                      txtTotalnum_pupils1   .setText(rs3.getString("Number_of_pupils"));      
                      txtTotalnum_boys1 .setText(rs3.getString("Number_of_Boys"));        
                      girs1 .setText(rs3.getString("Number_of_Girls"));
                      txtintro1 .setText(rs3.getString("introduction"));       
                      txtContent1 .setText(rs3.getString("lesson_content"));        
                      txtActivity1  .setText(rs3.getString("Learner_activity"));       
                      txtmethds1  .setText(rs3.getString("Method"));       
                      lesson_eva4  .setText(rs3.getString("Lesson_evalu_1"));       
                      lesson_eva3 .setText(rs3.getString("Lesson_evalu_2"));
                      self_eval1  .setText(rs3.getString("Self_evaluation"));       
                 }else{
                 
                     JOptionPane.showMessageDialog(null, "An Error was encounted "); 
                  }
            
                  
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            
            
            
        }
        
        
        
        
        
      
    }//GEN-LAST:event_Delecte25MouseClicked

    private void edit19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit19MouseClicked
        ClassViewer_list.hide();
        panel_Teachers.setVisible(true);
        
     
    
       
        
              Date date = new Date();
             java.sql.Date sqldate = new java.sql.Date(date.getTime());
             
               try {
                 
                conn = DBConnection.getConnction();
                String sql = ("SELECT  * FROM lesson_plan WHERE  (Subject = ? AND Date = ?) AND (Objectives = ? AND Method = ?) ");
                pps3 = conn.prepareStatement(sql);
                pps3.setString(1 ,  get_Subject);
                pps3.setString(2 ,  get_Date);
                 pps3.setString(3 ,  get_Objectives);
                 pps3.setString(4 ,  get_Method);
                  rs3 = pps3.executeQuery();
                  if(rs3.next()){ 
                  
                      txt_subject_name.setText(rs3.getString("Subject"));
                      txtTopic.setText(rs3.getString("Topic"));
                      txtSub_Topic .setText(rs3.getString("Sub_Topic"));  
                      txtObjective .setText(rs3.getString("Objectives"));
                      txtRationall .setText(rs3.getString("Rationall"));
                      txtTandLaids .setText(rs3.getString("Teaching_Learning"));
                      txtReferences .setText(rs3.getString("Reference"));
                      txtTotalnum_pupils   .setText(rs3.getString("Number_of_pupils"));      
                      txtTotalnum_boys .setText(rs3.getString("Number_of_Boys"));        
                      girs .setText(rs3.getString("Number_of_Girls"));
                      txtintro .setText(rs3.getString("introduction"));       
                      txtContent .setText(rs3.getString("lesson_content"));        
                      txtActivity  .setText(rs3.getString("Learner_activity"));       
                      txtmethds  .setText(rs3.getString("Method"));       
                      lesson_eva  .setText(rs3.getString("Lesson_evalu_1"));       
                      lesson_eva2 .setText(rs3.getString("Lesson_evalu_2"));
                      self_eval  .setText(rs3.getString("Self_evaluation"));       
                 }else{
                 
                     JOptionPane.showMessageDialog(null, "An Error was encounted "); 
                  }
            
                  
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

   
    }//GEN-LAST:event_edit19MouseClicked

    private void CreatedClassesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreatedClassesMouseClicked
          if(Cover.isShowing()){
            Cover.hide();
            SByRoomType.setVisible(true);
        }else if(SByRoomType.isShowing()){
            SByRoomType.hide();
            Cover.setVisible(true);
        }
        DefaultTableModel tableMode_type = (DefaultTableModel) CreatedClasses.getModel();
        get_Subject = tableMode_type.getValueAt(CreatedClasses.getSelectedRow(), 0).toString();
        
         DefaultTableModel tableMode_type1 = (DefaultTableModel) CreatedClasses.getModel();
         get_Date = tableMode_type1.getValueAt(CreatedClasses.getSelectedRow(), 5).toString();
         
         
         
         DefaultTableModel tableMode_type2 = (DefaultTableModel) CreatedClasses.getModel();
         get_Objectives = tableMode_type2.getValueAt(CreatedClasses.getSelectedRow(), 2).toString();
        
         DefaultTableModel tableMode_type3 = (DefaultTableModel) CreatedClasses.getModel();
         get_Method = tableMode_type3.getValueAt(CreatedClasses.getSelectedRow(), 4).toString();
         
        
         
         
         
         subject_selected = "selected";
    }//GEN-LAST:event_CreatedClassesMouseClicked

    
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void lesson_eva2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lesson_eva2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lesson_eva2ActionPerformed
  
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
            Totalnum_pupils = txtTotalnum_pupils.getText().trim();
        
        
        if (Totalnum_pupils.equals("0")) {
            JOptionPane.showMessageDialog(null, "The Class You Selected is Empt");
            
        } else if (txt_subject_name.getText().isEmpty()) {
             JOptionPane.showMessageDialog(null, "Subject name is Empt");
        
        } else if (txtTopic.getText().isEmpty()) {
             JOptionPane.showMessageDialog(null, "Topic is Empt");
        
        } else if (txtSub_Topic.getText().isEmpty()) {
             JOptionPane.showMessageDialog(null, "Sub_Topic is Empt");
        
        } else if (lesson_eva.getText().isEmpty()) {
             JOptionPane.showMessageDialog(null, "The Pupils Who understood is Empt");
        
        } else if (lesson_eva2.getText().isEmpty()) {
             JOptionPane.showMessageDialog(null, "The Pupils Who didnt understand is Empt");
        
        } else if (self_eval.getText().isEmpty()) {
             JOptionPane.showMessageDialog(null, "Self evaluation is Empt");
        
        } else if (txtActivity.getText().isEmpty()) {
             JOptionPane.showMessageDialog(null, "Activity is Empt");
        
        } else if (txtContent.getText().isEmpty()) {
             JOptionPane.showMessageDialog(null, "Content is Empt");
        
        }  else if (txtObjective.getText().isEmpty()) {
            
         JOptionPane.showMessageDialog(null, "References is Empt");
        }  else if (txtReferences.getText().isEmpty()) {
            
         JOptionPane.showMessageDialog(null, "The Class You Selected is Empt");
        } else if (txtTandLaids.getText().isEmpty()) {
            
         JOptionPane.showMessageDialog(null, "The Class You Selected is Empt");
        } else if (txtintro.getText().isEmpty()) {
             JOptionPane.showMessageDialog(null, " Introduction is Empt");
        
        } else if (txtmethds.getText().isEmpty()) {
             JOptionPane.showMessageDialog(null, "methods is Empt");
        
        } else if (!Totalnum_pupils.equals("0")) {
            
             JOptionPane.showMessageDialog(null, Totalnum_pupils);
              Date date = new Date();
             java.sql.Date sqldate = new java.sql.Date(date.getTime());
             String mClass_name  = showclasses.getSelectedItem().toString().trim();
               try {
                 
                conn = DBConnection.getConnction();
                String sql = ("SELECT  * FROM lesson_plan WHERE (Subject =?  AND Topic=? ) AND (  Class =?  AND lesson_content=?)    AND (  Date=? AND Teacher_id=? )");
                pps = conn.prepareStatement(sql);
                pps.setString(1 ,  txt_subject_name.getText().trim());
                pps.setString(2 ,  txtTopic.getText().trim());
                
                pps.setString(3 ,  showclasses.getSelectedItem().toString().trim());  
                pps.setString(4,  txtContent.getText().trim());

                  pps.setDate(5 , sqldate);
                  pps.setString(6 ,  user_access_id);
                  rs = pps.executeQuery();
                  if(rs.next()){ 
                  JOptionPane.showMessageDialog(null, "lesson plan  already exits ");
                
                 }else{
                  insert_lessonPlan();
                  }
            
                  
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
           
        
        
        
        
        }
        
            
    }//GEN-LAST:event_jButton1ActionPerformed

     public void insert_lessonPlan(){
                Date date = new Date();
             java.sql.Date sqldate = new java.sql.Date(date.getTime());
             String mClass_name  = showclasses.getSelectedItem().toString().trim();
               try {
                 
                 conn = DBConnection.getConnction();
                String sql = "INSERT INTO lesson_plan (Subject,Topic, Sub_Topic,Class,Objectives,Rationall, Teaching_Learning,Reference, Number_of_pupils, Number_of_Boys,Number_of_Girls,introduction,lesson_content,Learner_activity,Method,Lesson_evalu_1,Lesson_evalu_2,Self_evaluation ,Date,Teacher_id ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                pps = conn.prepareStatement(sql);
                pps.setString(1 ,  txt_subject_name.getText().trim());
                pps.setString(2 ,  txtTopic.getText().trim());
                pps.setString(3 ,  txtSub_Topic.getText().trim());
                pps.setString(4 ,  showclasses.getSelectedItem().toString().trim());  
                pps.setString(5 ,  txtObjective.getText().trim());
                pps.setString(6 ,  txtRationall.getText().trim());
                pps.setString(7 ,  txtTandLaids.getText().trim());
                 pps.setString(8 ,  txtReferences.getText().trim());
                pps.setString(9 ,  txtTotalnum_pupils.getText().trim());
                pps.setString(10 ,  txtTotalnum_boys.getText().trim());
                
                  pps.setString(11 ,  girs.getText().trim());
                 pps.setString(12 ,  txtintro.getText().trim());
                pps.setString(13 ,  txtContent.getText().trim());
                pps.setString(14 ,  txtActivity.getText().trim());

                
                   pps.setString(15 ,  txtmethds.getText().trim());
                pps.setString(16 ,  lesson_eva.getText().trim());
                pps.setString(17 ,  lesson_eva2.getText().trim());
                
                 pps.setString(18 ,  self_eval.getText().trim());
                  pps.setDate(19 , sqldate);
                  pps.setString(20 ,  user_access_id);
                pps.executeUpdate();
               
            
                  JOptionPane.showMessageDialog(null, "Successfully Saved");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
             Clear_lessonPlans_txtFed();
         
         
     }
    
      public void Clear_lessonPlans_txtFed(){
   
      txt_subject_name.setText(null);
      txtTopic.setText(null);
      txtSub_Topic .setText(null);  
      lesson_eva.setText(null);
     lesson_eva2.setText(null);
     self_eval.setText(null);
    showclasses.setSelectedIndex(0);
    
     txtActivity.setText(null);
    txtContent.setText(null);
    txtObjective.setText(null);
    txtRationall.setText(null);
    txtReferences.setText(null);
    txtSub_Topic.setText(null);
   txtTandLaids.setText(null);
     txtTopic.setText(null);
   txtTotalnum_boys.setText(null);
     txtTotalnum_pupils.setText(null);
     txt_subject_name.setText(null);
    txtintro.setText(null);
     txtmethds.setText(null);
        
        
    }
    
    private void lesson_evaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lesson_evaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lesson_evaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ClassViewer_list.setVisible(true);
        panel_Teachers.hide();
        view_plans.hide();
         Clear_lessonPlans_txtFed();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseClicked
              
              Teacher_Home_Page.getObj().setVisible(true);
              this.dispose();
    }//GEN-LAST:event_jLabel42MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
          // updating
      
          
                Date date = new Date();
             java.sql.Date sqldate = new java.sql.Date(date.getTime());
             String mClass_name  = showclasses.getSelectedItem().toString().trim();
               try {
                 
                 conn = DBConnection.getConnction();
                String sql = "UPDATE lesson_plan SET Subject =?,Topic=?, Sub_Topic=?,Class=?,Objectives=?,Rationall=?, Teaching_Learning=?,Reference=?, Number_of_pupils=?, Number_of_Boys=?,Number_of_Girls=?,introduction=?,lesson_content=?,Learner_activity=?,Method=?,Lesson_evalu_1=?,Lesson_evalu_2=?,Self_evaluation=? ";
                pps = conn.prepareStatement(sql);
                pps.setString(1 ,  txt_subject_name.getText().trim());
                pps.setString(2 ,  txtTopic.getText().trim());
                pps.setString(3 ,  txtSub_Topic.getText().trim());
                pps.setString(4 ,  showclasses.getSelectedItem().toString().trim());  
                pps.setString(5 ,  txtObjective.getText().trim());
                pps.setString(6 ,  txtRationall.getText().trim());
                pps.setString(7 ,  txtTandLaids.getText().trim());
                 pps.setString(8 ,  txtReferences.getText().trim());
                pps.setString(9 ,  txtTotalnum_pupils.getText().trim());
                pps.setString(10 ,  txtTotalnum_boys.getText().trim());
                
                  pps.setString(11 ,  girs.getText().trim());
                 pps.setString(12 ,  txtintro.getText().trim());
                pps.setString(13 ,  txtContent.getText().trim());
                pps.setString(14 ,  txtActivity.getText().trim());

                
                   pps.setString(15 ,  txtmethds.getText().trim());
                pps.setString(16 ,  lesson_eva.getText().trim());
                pps.setString(17 ,  lesson_eva2.getText().trim());
                
                 pps.setString(18 ,  self_eval.getText().trim());
                 
                pps.executeUpdate();
          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
         myClass_lessonPlans();
          
       ClassViewer_list.setVisible(true);
        panel_Teachers.hide();
        Clear_lessonPlans_txtFed();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
             //printing the panel with its content
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Print lesson Plan");

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
                view_plans.print(g2);

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
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        ClassViewer_list.setVisible(true);
        panel_Teachers.hide();
        view_plans.hide();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void lesson_eva3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lesson_eva3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lesson_eva3ActionPerformed

    private void lesson_eva1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lesson_eva1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lesson_eva1ActionPerformed

    private void Delecte27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Delecte27MouseClicked
       try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("DELETE  FROM lesson_plan WHERE (Subject = ? AND Date = ?) AND (Objectives = ? AND Method = ?)  ");
            pps.setString(1, get_Subject);
             pps.setString(2, get_Date);
              pps.setString(3, get_Objectives);
             pps.setString(4, get_Method);
            pps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(AdminApprove_lesson_plan.class.getName()).log(Level.SEVERE, null, ex);
        }
     myClass_lessonPlans();//show changes on the table after delete

 
    
    
     
     
    }//GEN-LAST:event_Delecte27MouseClicked

    private void showclassesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_showclassesItemStateChanged
        count_students();
    }//GEN-LAST:event_showclassesItemStateChanged

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
         
       try {
                
                 conn = DBConnection.getConnction();
                String sql = ("SELECT  Subject,Topic,Objectives, Teaching_Learning,Method,Date, approve FROM lesson_plan WHERE approve =?");
                pps5 = conn.prepareStatement(sql);
               
                  pps5.setString(1 ,  jComboBox1.getSelectedItem().toString().trim());
                  rs5 = pps5.executeQuery();
                  CreatedClasses.setModel(DbUtils.resultSetToTableModel(rs5));
                  
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                } 
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       
        jTextArea1.setText(null);
        
        
        
        
        try {
                 
                  conn = DBConnection.getConnction();
                  String sql = ("SELECT  Comments,Decline_date,Date FROM lesson_plan WHERE  (Subject = ? AND Date = ?) AND (Objectives = ? AND Method = ?) ");
                  pps3 = conn.prepareStatement(sql);
                  pps3.setString(1 ,  get_Subject);
                  pps3.setString(2 ,  get_Date);
                  pps3.setString(3 ,  get_Objectives);
                  pps3.setString(4 ,  get_Method);
                  rs3 = pps3.executeQuery();
                  if(rs3.next()){ 
                     
                      
                      
                      
                     String Comments = rs3.getString("Comments");
                     String Decline_date = rs3.getString("Decline_date");
                     String Wrote_date = rs3.getString("Date");
                     String rec = "Review Lesson plan as recommended ";
                     
             jTextArea1.append("                                            LESSON PLAN RECOMMENDATION REPORT \n\n " +
            "                                            DATE OF DELINE :\t" + Decline_date +"\n\n"+
            "                                            RECOMMENDATION :\t" + rec+"\n\n"+   
            "   ========================================================================================================"+
            " \n========================================================================================================\n"+
            " RECOMMENDATION  :\t" + Comments +"\n\n"+
            "                                                                    \n\n"
           +""
        );
        
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     Class_Config_panel.hide();
                     ntApproved.setVisible(true);
                     }else{ JOptionPane.showMessageDialog(null, "Choose A Delined Lesson Plan"); }
                  
                } catch (SQLException ex) {  JOptionPane.showMessageDialog(null, ex); }
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        
        Class_Config_panel.setVisible(true);
        ntApproved.hide(); 
    }//GEN-LAST:event_jLabel29MouseClicked

    private void lesson_evaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lesson_evaKeyTyped
        char iNumb = evt.getKeyChar();
        if(!(Character.isDigit(iNumb))
           // ||(iNumb == KeyEvent.VK_BACKSPACE)
            ||(iNumb == KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_lesson_evaKeyTyped
   
    
    
    
     public static Teacher_lesson_plan getObj() {  //public method for instance Restriction
        if (Obj == null) {
            Obj = new Teacher_lesson_plan();
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
            java.util.logging.Logger.getLogger(Teacher_lesson_plan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Teacher_lesson_plan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Teacher_lesson_plan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Teacher_lesson_plan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Teacher_lesson_plan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Add_price4;
    private javax.swing.JLabel BackGround_layer1;
    private javax.swing.JPanel BookedContainer_main1;
    private javax.swing.JPanel ClassViewer_list;
    private javax.swing.JPanel Class_Config_panel;
    private javax.swing.JPanel Cover;
    private javax.swing.JTable CreatedClasses;
    private javax.swing.JLabel Delecte25;
    private javax.swing.JLabel Delecte26;
    private javax.swing.JLabel Delecte27;
    private javax.swing.JLabel Delecte28;
    private javax.swing.JPanel SByRoomType;
    private javax.swing.JPanel Searching_panel_holder;
    private javax.swing.JLabel VApproved;
    private javax.swing.JLabel VApproved1;
    private javax.swing.JLabel VApproved2;
    private javax.swing.JLabel addRoom_type;
    private javax.swing.JPanel admin_btn;
    private javax.swing.JPanel building_classes_panel;
    private javax.swing.JLabel edit19;
    private javax.swing.JLabel exit_lb;
    private javax.swing.JPanel frontSide_btn_holder;
    private javax.swing.JLabel girs;
    private javax.swing.JLabel girs1;
    private javax.swing.JLabel header;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox jComboBox1;
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
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel223;
    private javax.swing.JLabel jLabel224;
    private javax.swing.JLabel jLabel225;
    private javax.swing.JLabel jLabel226;
    private javax.swing.JLabel jLabel227;
    private javax.swing.JLabel jLabel228;
    private javax.swing.JLabel jLabel229;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel230;
    private javax.swing.JLabel jLabel231;
    private javax.swing.JLabel jLabel232;
    private javax.swing.JLabel jLabel233;
    private javax.swing.JLabel jLabel234;
    private javax.swing.JLabel jLabel235;
    private javax.swing.JLabel jLabel236;
    private javax.swing.JLabel jLabel237;
    private javax.swing.JLabel jLabel238;
    private javax.swing.JLabel jLabel239;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel240;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lb_ByRoomType;
    private javax.swing.JLabel lb_bg_btnFirstView2;
    private javax.swing.JLabel lb_bg_btnFirstView3;
    private javax.swing.JTextField lesson_eva;
    private javax.swing.JTextField lesson_eva2;
    private javax.swing.JTextField lesson_eva3;
    private javax.swing.JTextField lesson_eva4;
    private javax.swing.JLabel minize_lb;
    private javax.swing.JLabel model;
    private javax.swing.JPanel ntApproved;
    private javax.swing.JPanel panel_Teachers;
    private javax.swing.JPanel right;
    private javax.swing.JTextField self_eval;
    private javax.swing.JTextField self_eval1;
    private javax.swing.JComboBox showclasses;
    private javax.swing.JLabel table_holder_bg16;
    private javax.swing.JLabel tbClass;
    private javax.swing.JTextArea txtActivity;
    private javax.swing.JTextArea txtActivity1;
    private javax.swing.JTextArea txtContent;
    private javax.swing.JTextArea txtContent1;
    private javax.swing.JTextField txtObjective;
    private javax.swing.JTextField txtObjective1;
    private javax.swing.JTextField txtRationall;
    private javax.swing.JTextField txtRationall1;
    private javax.swing.JTextField txtReferences;
    private javax.swing.JTextField txtReferences1;
    private javax.swing.JTextField txtSub_Topic;
    private javax.swing.JTextField txtSub_Topic1;
    private javax.swing.JTextField txtTandLaids;
    private javax.swing.JTextField txtTandLaids1;
    private javax.swing.JTextField txtTopic;
    private javax.swing.JTextField txtTopic1;
    private javax.swing.JLabel txtTotalnum_boys;
    private javax.swing.JLabel txtTotalnum_boys1;
    private javax.swing.JLabel txtTotalnum_pupils;
    private javax.swing.JLabel txtTotalnum_pupils1;
    private javax.swing.JTextField txt_subject_name;
    private javax.swing.JTextField txt_subject_name1;
    private javax.swing.JTextArea txtintro;
    private javax.swing.JTextArea txtintro1;
    private javax.swing.JTextArea txtmethds;
    private javax.swing.JTextArea txtmethds1;
    private javax.swing.JPanel view_plans;
    // End of variables declaration//GEN-END:variables
}
