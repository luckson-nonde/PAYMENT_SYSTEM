
package hotel.management;

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListSelectionModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

 
public class Adminstrative extends javax.swing.JFrame {

     
     private static String Recieved_user_id = null;
     private static String usertype = null;

      private String Guarden = null; 
      
      Connection conn = null;
      PreparedStatement pps, pps1, pps2, pps3, pps4, pps6, pps5, pps7, pps8, pps9, pps10, pps11, pps12 ,pps13 = null;
      ResultSet rs, rs1, rs2, rs3, rs4, rs5, rs6, rs7, rs8, rs9, rs10, rs11, rs12 ,rs13= null;

        
      String     Student_ID_toParentRelation = null;
      String     parent_ID_toStudentRelation = null;
        
       String parent_name = null;
       
       
        String s = null;
       
        String string_For_IMAGE2 = null;
        private String Gender;
        String lastIDdb = null;
        
            //passing user id
            private static Adminstrative Obj = null;
            private String passed_user_id;
            
            int xx = 0;
            int yy = 0;

           Adminstrative() {
            initComponents();
            myClass();
            setBackground(new Color(0,0,0,0));
            
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
        icon();
       
    }
          public void icon(){
       try {conn = DBConnection.getConnction();
            pps = conn.prepareStatement(" SELECT  * FROM  access WHERE access_id =?");
            pps.setString(1,Recieved_user_id.trim()); 
            rs = pps.executeQuery();
            byte[] image = null;
            while(rs.next()){

                 model.setText(rs.getString("user"));
                 String name = rs.getString("first_name");
                 String lname = rs.getString("last_name");

                 lb_user.setText( name +"  " + lname );
                 
                 image = rs.getBytes("user_pic");
                 Image img = Toolkit.getDefaultToolkit().createImage(image);
                 ImageIcon icon = new ImageIcon(img);

                Image modifiedImaged = img.getScaledInstance(img_usera.getWidth(), img_usera.getHeight(), Image.SCALE_SMOOTH);
                icon = new ImageIcon(modifiedImaged);
                user_img.setIcon(icon);
                
                 changeIcon();
                }
            } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
          }
    } 
         public void changeIcon(){
      
                  if(model.getText().equals("Administration")){
                    access1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_padlock_13px.png"))); 
                    access2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_padlock_13px.png"))); 
                    access3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_padlock_13px.png"))); 
                    access4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_padlock_13px.png"))); 
                    access5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_padlock_13px.png"))); 
                    access6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_padlock_13px.png"))); 
                    access7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_padlock_13px.png"))); 

                 }else if(model.getText().equals("Accountant")){
                    access3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_padlock_13px.png"))); 
                    access4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_padlock_13px.png"))); 
                    access5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_padlock_13px.png"))); 
                 
                 }else if(model.getText().equals("Reception")){
                    access1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_padlock_13px.png"))); 
                    access2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_padlock_13px.png"))); 
                 }
  
  }      
  //  icons8_unlock_19px
    
     public void myClass(){
        try {
            conn = DBConnection.getConnction();
            pps1 = conn.prepareStatement("SELECT * FROM classes");
            rs = pps1.executeQuery();
            while(rs.next()){
              txtChooseGrade.addItem(rs.getString("grade_room"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
           
//-----------------------------------------------------------------total students-------------------------------
        try {
             conn = DBConnection.getConnction();
            pps = conn.prepareStatement("SELECT  count(student_ids) FROM  students");
            rs = pps.executeQuery();
            if (rs.next()) {
                String sum = rs.getString("count(student_ids)");
                counter_view_students.setText(sum);
            }
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

   

        // /-----------------------------------------------------------------teacher------------------------------
        try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("SELECT  count(user_login_id) FROM  employee");
            rs = pps.executeQuery();
            if (rs.next()) {
                String sum = rs.getString("count(user_login_id)");
                counter_view_teachers.setText(sum);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }

        // /-----------------------------------------------------------------hall type countroomcount16-------------------------------
        try {
           conn = DBConnection.getConnction();
            pps = conn.prepareStatement("SELECT  count(class_id) FROM  classes");
            rs = pps.executeQuery();
            if (rs.next()) {
                String sum = rs.getString("count(class_id)");
                counter_view_classes.setText(sum);
            }
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

        
        
        
        
            try {
           conn = DBConnection.getConnction();
            pps5 = conn.prepareStatement("SELECT  students.Full_Name, students.physical_adress,   students.Student_Age, students.Student_Gender, students.Health_Status,   parents.parents_names, parents.Profession,  parents.`Language`  ,  Contact FROM  students  INNER JOIN   parents_students  ON  students.student_ids = parents_students.student_ids   INNER JOIN parents ON  parents.parents_id = parents_students.parents_id ");
            rs5 = pps5.executeQuery();
             View_Portal_table.setModel(DbUtils.resultSetToTableModel(rs5));
           
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

        
        
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelForContent_Display = new javax.swing.JPanel();
        main_Container = new javax.swing.JPanel();
        panel_cover = new javax.swing.JPanel();
        counter_view1 = new javax.swing.JLabel();
        counter_view2 = new javax.swing.JLabel();
        counter_view3 = new javax.swing.JLabel();
        counter_view_classes = new javax.swing.JLabel();
        counter_view5 = new javax.swing.JLabel();
        counter_view_students = new javax.swing.JLabel();
        counter_view7 = new javax.swing.JLabel();
        counter_view_teachers = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        create = new javax.swing.JLabel();
        create1 = new javax.swing.JLabel();
        create2 = new javax.swing.JLabel();
        create3 = new javax.swing.JLabel();
        counter_view = new javax.swing.JLabel();
        Student_Registration = new javax.swing.JPanel();
        studentp = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        combAp = new javax.swing.JComboBox();
        level_change = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        subject_table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        corner = new javax.swing.JLabel();
        num_subject = new javax.swing.JLabel();
        num_subject1 = new javax.swing.JLabel();
        num_subject2 = new javax.swing.JLabel();
        num_subject3 = new javax.swing.JLabel();
        lb_roomNumber = new javax.swing.JLabel();
        max = new javax.swing.JLabel();
        max1 = new javax.swing.JLabel();
        max2 = new javax.swing.JLabel();
        max3 = new javax.swing.JLabel();
        num_subject6 = new javax.swing.JLabel();
        num_subject7 = new javax.swing.JLabel();
        num_subject8 = new javax.swing.JLabel();
        group_year1 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        group_year = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        room_capacity_lb = new javax.swing.JLabel();
        subject_lidt_view1 = new javax.swing.JLabel();
        subject_lidt_view = new javax.swing.JLabel();
        lb_background = new javax.swing.JLabel();
        img_holder = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        rMale = new javax.swing.JRadioButton();
        Image_chooser = new javax.swing.JLabel();
        level_change1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtSAge = new javax.swing.JTextField();
        txtPAdress = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtFName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFor_Student_ID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Status = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        rFemale = new javax.swing.JRadioButton();
        txtChooseGrade = new javax.swing.JComboBox();
        register_bg = new javax.swing.JLabel();
        img_url = new javax.swing.JLabel();
        subject_lidt_view2 = new javax.swing.JLabel();
        parentp = new javax.swing.JPanel();
        Parents_register = new javax.swing.JPanel();
        lb_background1 = new javax.swing.JLabel();
        lb_ParentImage_holder = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lbIMAGE_Chooser = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtFathersName = new javax.swing.JTextField();
        occupFather = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        ContactNumberF = new javax.swing.JTextField();
        emailFather = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        nationalityFather = new javax.swing.JTextField();
        txtNRC1 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        PostCode1 = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        langugeFather = new javax.swing.JTextField();
        SaveButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        Mark_Selected = new javax.swing.JCheckBox();
        ParentsDropList = new javax.swing.JComboBox();
        jLabel31 = new javax.swing.JLabel();
        lb_URL = new javax.swing.JLabel();
        pURL = new javax.swing.JLabel();
        View_Portal = new javax.swing.JPanel();
        ClassViewer_list = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        lb_ByRoomType = new javax.swing.JLabel();
        Searching_panel_holder = new javax.swing.JPanel();
        SByRoomType = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        Add_price4 = new javax.swing.JLabel();
        lb_bg_btnFirstView3 = new javax.swing.JLabel();
        Cover = new javax.swing.JPanel();
        addRoom_type = new javax.swing.JLabel();
        Delecte25 = new javax.swing.JLabel();
        edit19 = new javax.swing.JLabel();
        Delecte26 = new javax.swing.JLabel();
        lb_bg_btnFirstView2 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        View_Portal_table = new javax.swing.JTable();
        jPanel40 = new javax.swing.JPanel();
        jLabel222 = new javax.swing.JLabel();
        jLabel223 = new javax.swing.JLabel();
        jLabel224 = new javax.swing.JLabel();
        jLabel225 = new javax.swing.JLabel();
        jLabel226 = new javax.swing.JLabel();
        jLabel227 = new javax.swing.JLabel();
        jLabel228 = new javax.swing.JLabel();
        jLabel229 = new javax.swing.JLabel();
        jLabel230 = new javax.swing.JLabel();
        table_holder_bg16 = new javax.swing.JLabel();
        admin_btn = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        minize_lb = new javax.swing.JLabel();
        exit_lb = new javax.swing.JLabel();
        model = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        hotel_ma = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        access7 = new javax.swing.JLabel();
        report_panelBTN = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        access6 = new javax.swing.JLabel();
        Tex_manager_lb2 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        access5 = new javax.swing.JLabel();
        calender = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        access4 = new javax.swing.JLabel();
        expenses = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        access3 = new javax.swing.JLabel();
        parent_btn = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        access2 = new javax.swing.JLabel();
        Student_btn = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        access1 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel28 = new javax.swing.JPanel();
        lb_user = new javax.swing.JLabel();
        img_usera = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        user_img = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        PanelForPopUP_Display = new javax.swing.JPanel();
        sID = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        IDname = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        last_Generation = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        gb = new javax.swing.JLabel();
        popup_parentRegister = new javax.swing.JPanel();
        lb_Search = new javax.swing.JLabel();
        lb_background2 = new javax.swing.JLabel();
        popup_img_Holder = new javax.swing.JLabel();
        sID1 = new javax.swing.JLabel();
        Ib_name = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        lb_Gender = new javax.swing.JLabel();
        lb_Resource_parentName_holder = new javax.swing.JLabel();
        Save_parent = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        Save_parent1 = new javax.swing.JLabel();
        txtSerach_student = new javax.swing.JTextField();
        gb1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.CardLayout());

        PanelForContent_Display.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        main_Container.setLayout(new java.awt.CardLayout());

        panel_cover.setBackground(new java.awt.Color(255, 255, 255));
        panel_cover.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        counter_view1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        counter_view1.setForeground(new java.awt.Color(102, 102, 102));
        counter_view1.setText("Number of teachers");
        panel_cover.add(counter_view1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 130, 30));

        counter_view2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        counter_view2.setForeground(new java.awt.Color(102, 102, 102));
        counter_view2.setText("Number of classes");
        panel_cover.add(counter_view2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 570, 110, 40));

        counter_view3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        counter_view3.setForeground(new java.awt.Color(102, 102, 102));
        counter_view3.setText("Number of subjects");
        panel_cover.add(counter_view3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 550, 140, 20));

        counter_view_classes.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        counter_view_classes.setForeground(new java.awt.Color(85, 133, 143));
        counter_view_classes.setText("00");
        panel_cover.add(counter_view_classes, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 570, 110, 40));

        counter_view5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        counter_view5.setForeground(new java.awt.Color(85, 133, 143));
        counter_view5.setText("00");
        panel_cover.add(counter_view5, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 550, 110, 20));

        counter_view_students.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        counter_view_students.setForeground(new java.awt.Color(85, 133, 143));
        counter_view_students.setText("00");
        panel_cover.add(counter_view_students, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 220, 140, 20));

        counter_view7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        counter_view7.setForeground(new java.awt.Color(102, 102, 102));
        counter_view7.setText("Registered Students");
        panel_cover.add(counter_view7, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 210, 130, 40));

        counter_view_teachers.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        counter_view_teachers.setForeground(new java.awt.Color(85, 133, 143));
        counter_view_teachers.setText("00");
        panel_cover.add(counter_view_teachers, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 130, 30));

        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_business_building_100px.png"))); // NOI18N
        jLabel11.setText("TEACHERS");
        panel_cover.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 190, 100));

        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_book_reading_100px.png"))); // NOI18N
        jLabel16.setText("   SUBJECTS");
        panel_cover.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 440, 200, 90));

        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_student_male_100px.png"))); // NOI18N
        jLabel26.setText(" STUDENTS");
        panel_cover.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, 190, 110));

        jLabel36.setForeground(new java.awt.Color(102, 102, 102));
        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_apartment_100px.png"))); // NOI18N
        jLabel36.setText("CLASSES");
        panel_cover.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, 190, 100));

        create.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/Counter.png"))); // NOI18N
        create.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createMouseClicked(evt);
            }
        });
        panel_cover.add(create, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, -1, -1));

        create1.setForeground(new java.awt.Color(204, 204, 204));
        create1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/Counter.png"))); // NOI18N
        create1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                create1MouseClicked(evt);
            }
        });
        panel_cover.add(create1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, -1));

        create2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/Counter.png"))); // NOI18N
        create2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                create2MouseClicked(evt);
            }
        });
        panel_cover.add(create2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, -1, -1));

        create3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/Counter.png"))); // NOI18N
        create3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                create3MouseClicked(evt);
            }
        });
        panel_cover.add(create3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 360, -1, -1));

        counter_view.setText("jLabel5");
        panel_cover.add(counter_view, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 220, 110, 20));

        main_Container.add(panel_cover, "card2");

        Student_Registration.setLayout(new java.awt.CardLayout());

        studentp.setBackground(new java.awt.Color(0, 153, 153));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        combAp.setBackground(new Color(255,255,255,30));
        combAp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        combAp.setForeground(new java.awt.Color(102, 102, 102));
        combAp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Compulsory", "Optional", " " }));
        jPanel5.add(combAp, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 240, 100, 30));

        level_change.setBackground(new Color(255,255,255,30));
        level_change.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        level_change.setForeground(new java.awt.Color(102, 102, 102));
        level_change.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Search_15px.png"))); // NOI18N
        level_change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level_changeActionPerformed(evt);
            }
        });
        jPanel5.add(level_change, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 240, 40, 30));

        subject_table.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        subject_table.setForeground(new java.awt.Color(153, 153, 153));
        subject_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        subject_table.setTableHeader(null);
        subject_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subject_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(subject_table);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 270, 370, 190));

        jPanel1.setBackground(new java.awt.Color(121, 119, 119));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Grade");
        jPanel1.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 60, 30));

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Subjects");
        jPanel1.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 30));

        jPanel5.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 240, -1, 40));

        corner.setBackground(new java.awt.Color(255, 255, 255));
        corner.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        corner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/IconImage.png"))); // NOI18N
        jPanel5.add(corner, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 280, 260));

        num_subject.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        num_subject.setForeground(new java.awt.Color(204, 204, 204));
        num_subject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/backtoSearch.png"))); // NOI18N
        num_subject.setText("# of Subject");
        jPanel5.add(num_subject, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 570, 100, 40));

        num_subject1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        num_subject1.setForeground(new java.awt.Color(204, 204, 204));
        num_subject1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/backtoSearch.png"))); // NOI18N
        num_subject1.setText(" Room  #");
        jPanel5.add(num_subject1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 520, 90, 40));

        num_subject2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        num_subject2.setForeground(new java.awt.Color(204, 204, 204));
        jPanel5.add(num_subject2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 470, 70, 40));

        num_subject3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        num_subject3.setForeground(new java.awt.Color(204, 204, 204));
        jPanel5.add(num_subject3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 570, 60, 40));

        lb_roomNumber.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lb_roomNumber.setForeground(new java.awt.Color(204, 204, 204));
        jPanel5.add(lb_roomNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 520, 60, 40));

        max.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        max.setForeground(new java.awt.Color(204, 204, 204));
        max.setText("Max Capacity");
        jPanel5.add(max, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 520, -1, 40));

        max1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        max1.setForeground(new java.awt.Color(204, 204, 204));
        max1.setText("Remaining  ");
        jPanel5.add(max1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 470, 70, 40));

        max2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        max2.setForeground(new java.awt.Color(204, 204, 204));
        max2.setText(" Subject Max");
        jPanel5.add(max2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 570, 80, 40));

        max3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        max3.setForeground(new java.awt.Color(204, 204, 204));
        jPanel5.add(max3, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 470, 90, 40));

        num_subject6.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        num_subject6.setForeground(new java.awt.Color(204, 204, 204));
        num_subject6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/backtoSearch.png"))); // NOI18N
        num_subject6.setText("Group Year ");
        jPanel5.add(num_subject6, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 610, 100, 40));

        num_subject7.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        num_subject7.setForeground(new java.awt.Color(204, 204, 204));
        num_subject7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/backtoSearch.png"))); // NOI18N
        num_subject7.setText("# of Students");
        jPanel5.add(num_subject7, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 470, 110, 40));

        num_subject8.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        num_subject8.setForeground(new java.awt.Color(204, 204, 204));
        num_subject8.setText(" ");
        jPanel5.add(num_subject8, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 570, 100, 40));

        group_year1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        group_year1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel5.add(group_year1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 610, 120, 40));

        jLabel45.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("S.T");
        jPanel5.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 40, 20));

        group_year.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        group_year.setForeground(new java.awt.Color(204, 204, 204));
        jPanel5.add(group_year, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 610, 130, 40));

        jLabel10.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("STUDENT");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 60, 50));

        room_capacity_lb.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        room_capacity_lb.setForeground(new java.awt.Color(204, 204, 204));
        jPanel5.add(room_capacity_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 520, 90, 40));

        subject_lidt_view1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/subjecx.png"))); // NOI18N
        jPanel5.add(subject_lidt_view1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 210, 450, 330));

        subject_lidt_view.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/subjecx.png"))); // NOI18N
        jPanel5.add(subject_lidt_view, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 210, 450, 400));

        lb_background.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/image.png"))); // NOI18N
        jPanel5.add(lb_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 70, 220, 170));
        jPanel5.add(img_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, 130, 130));

        jLabel18.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Select Gender");
        jPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 540, -1, 30));

        jDateChooser1.setBackground(new Color(225,225,225,2));
        jDateChooser1.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(225,225,225,2)));
        jPanel5.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 330, 35));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("physical Adress");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, 130, 30));

        rMale.setBackground(new java.awt.Color(153, 153, 153));
        rMale.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rMale.setForeground(new java.awt.Color(51, 51, 51));
        rMale.setText("Male");
        rMale.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rMaleActionPerformed(evt);
            }
        });
        jPanel5.add(rMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 540, 100, 30));

        Image_chooser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_businessman_30px.png"))); // NOI18N
        Image_chooser.setToolTipText("Choose image");
        Image_chooser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Image_chooserMouseClicked(evt);
            }
        });
        jPanel5.add(Image_chooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 30, 50));

        level_change1.setBackground(new Color(255,255,255,30));
        level_change1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        level_change1.setForeground(new java.awt.Color(102, 102, 102));
        level_change1.setText("Submit");
        level_change1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level_change1ActionPerformed(evt);
            }
        });
        jPanel5.add(level_change1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 600, 100, 30));

        jButton4.setBackground(new Color(66,66,66,20));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Check ");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, 50, 40));

        jLabel9.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText(" Grade  & Class  ");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 130, 30));

        txtSAge.setBackground(new Color(225,225,225,10));
        txtSAge.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSAge.setBorder(null);
        txtSAge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSAgeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSAgeKeyTyped(evt);
            }
        });
        jPanel5.add(txtSAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 320, 40));

        txtPAdress.setBackground(new Color(225,225,225,10));
        txtPAdress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPAdress.setBorder(null);
        jPanel5.add(txtPAdress, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 480, 320, 40));

        jLabel17.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Date of Birth");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 110, 30));

        txtFName.setBackground(new Color(225,225,225,10));
        txtFName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFName.setBorder(null);
        txtFName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFNameActionPerformed(evt);
            }
        });
        txtFName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFNameKeyPressed(evt);
            }
        });
        jPanel5.add(txtFName, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 290, 40));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Student ID ");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 120, 40));

        txtFor_Student_ID.setBackground(new Color(225,225,225,10));
        txtFor_Student_ID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtFor_Student_ID.setBorder(null);
        txtFor_Student_ID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFor_Student_IDKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFor_Student_IDKeyTyped(evt);
            }
        });
        jPanel5.add(txtFor_Student_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 270, 40));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Full Name");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 130, 40));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText(" Health Status  ");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 130, 30));

        Status.setBackground(new Color(225,225,225,10));
        Status.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Status.setForeground(new java.awt.Color(51, 51, 51));
        Status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Health", "Mantally Disabled", "Physically Disabled", "visually impaired", "asthmatis", "aneamis" }));
        Status.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(225,225,225,1)));
        Status.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel5.add(Status, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 330, 35));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Student Age");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 100, 30));

        rFemale.setBackground(new java.awt.Color(153, 153, 153));
        rFemale.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rFemale.setForeground(new java.awt.Color(51, 51, 51));
        rFemale.setText("Female");
        rFemale.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        rFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rFemaleActionPerformed(evt);
            }
        });
        jPanel5.add(rFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 540, 230, 30));

        txtChooseGrade.setBackground(new Color(225,225,225,10));
        txtChooseGrade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtChooseGrade.setForeground(new java.awt.Color(51, 51, 51));
        txtChooseGrade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None" }));
        txtChooseGrade.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(225,225,225,1)));
        txtChooseGrade.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel5.add(txtChooseGrade, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, 330, 35));

        register_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/register_BG5.png"))); // NOI18N
        jPanel5.add(register_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, -30, 670, 730));

        img_url.setText("Url");
        jPanel5.add(img_url, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 260, 30));

        subject_lidt_view2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/subjecx.png"))); // NOI18N
        jPanel5.add(subject_lidt_view2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 210, 450, 690));

        javax.swing.GroupLayout studentpLayout = new javax.swing.GroupLayout(studentp);
        studentp.setLayout(studentpLayout);
        studentpLayout.setHorizontalGroup(
            studentpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1110, Short.MAX_VALUE)
        );
        studentpLayout.setVerticalGroup(
            studentpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Student_Registration.add(studentp, "card2");

        main_Container.add(Student_Registration, "card10");

        parentp.setBackground(new java.awt.Color(255, 255, 255));

        Parents_register.setBackground(new java.awt.Color(255, 255, 255));
        Parents_register.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_background1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_background1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/image.png"))); // NOI18N
        Parents_register.add(lb_background1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 280, 210));
        Parents_register.add(lb_ParentImage_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 130, 150, 130));

        jLabel50.setBackground(new java.awt.Color(255, 255, 255));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/IconImage.png"))); // NOI18N
        Parents_register.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, 250, 150));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbIMAGE_Chooser.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lbIMAGE_Chooser.setForeground(new java.awt.Color(255, 255, 255));
        lbIMAGE_Chooser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_businessman_30px.png"))); // NOI18N
        lbIMAGE_Chooser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbIMAGE_ChooserMouseClicked(evt);
            }
        });
        jPanel6.add(lbIMAGE_Chooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 50, 50));

        jLabel15.setBackground(new java.awt.Color(0, 102, 102));
        jLabel15.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("parents Name");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 200, 50));

        txtFathersName.setBackground(new Color(255,255,255,2));
        txtFathersName.setBorder(null);
        txtFathersName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFathersNameKeyPressed(evt);
            }
        });
        jPanel6.add(txtFathersName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 320, 35));

        occupFather.setBackground(new Color(255,255,255,2));
        occupFather.setBorder(null);
        occupFather.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                occupFatherKeyPressed(evt);
            }
        });
        jPanel6.add(occupFather, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 320, 35));

        jLabel19.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Occupation/Profession ");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 200, 40));

        jLabel24.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Contact Number");
        jPanel6.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 210, 40));

        ContactNumberF.setBackground(new Color(255,255,255,2));
        ContactNumberF.setBorder(null);
        ContactNumberF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ContactNumberFKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ContactNumberFKeyTyped(evt);
            }
        });
        jPanel6.add(ContactNumberF, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 320, 40));

        emailFather.setBackground(new Color(255,255,255,2));
        emailFather.setBorder(null);
        emailFather.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailFatherKeyPressed(evt);
            }
        });
        jPanel6.add(emailFather, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 275, 320, 40));

        jLabel25.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Email Address");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 200, 30));

        jLabel28.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Nationality");
        jPanel6.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 210, 30));

        nationalityFather.setBackground(new Color(255,255,255,2));
        nationalityFather.setBorder(null);
        nationalityFather.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nationalityFatherKeyPressed(evt);
            }
        });
        jPanel6.add(nationalityFather, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 325, 320, 40));

        txtNRC1.setBackground(new Color(255,255,255,2));
        txtNRC1.setBorder(null);
        txtNRC1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNRC1KeyPressed(evt);
            }
        });
        jPanel6.add(txtNRC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 320, 35));

        jLabel29.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Language(s) Spoken");
        jPanel6.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 210, 40));

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Post Code            ");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 210, 40));

        PostCode1.setBackground(new Color(255,255,255,2));
        PostCode1.setBorder(null);
        PostCode1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PostCode1KeyPressed(evt);
            }
        });
        jPanel6.add(PostCode1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 470, 320, 40));

        address.setBackground(new Color(255,255,255,2));
        address.setBorder(null);
        address.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addressKeyPressed(evt);
            }
        });
        jPanel6.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 520, 320, 40));

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Address");
        jPanel6.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 520, 210, 40));

        langugeFather.setBackground(new Color(255,255,255,2));
        langugeFather.setBorder(null);
        langugeFather.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                langugeFatherKeyPressed(evt);
            }
        });
        jPanel6.add(langugeFather, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, 320, 40));

        SaveButton.setText("save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });
        jPanel6.add(SaveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 630, 80, 30));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Guarden");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 570, 210, 40));

        Mark_Selected.setBackground(new java.awt.Color(153, 153, 153));
        Mark_Selected.setText("Mark Selected");
        Mark_Selected.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Mark_Selected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mark_SelectedActionPerformed(evt);
            }
        });
        jPanel6.add(Mark_Selected, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 570, 130, 45));

        ParentsDropList.setBackground(new Color(225,225,225,1));
        ParentsDropList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Father", "   Mother", "   Uncle", "   Aunt", "   Grande Mother", "   Grande Father", "   Others" }));
        ParentsDropList.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(225,225,225,1)));
        jPanel6.add(ParentsDropList, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 570, 170, 45));

        jLabel31.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("NRC");
        jPanel6.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 210, 20));

        lb_URL.setBackground(new java.awt.Color(255, 255, 255));
        lb_URL.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lb_URL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/PARENT_BG.png"))); // NOI18N
        jPanel6.add(lb_URL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -100, 640, 900));

        pURL.setText("url");
        jPanel6.add(pURL, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 180, 30));

        Parents_register.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 640, 720));

        javax.swing.GroupLayout parentpLayout = new javax.swing.GroupLayout(parentp);
        parentp.setLayout(parentpLayout);
        parentpLayout.setHorizontalGroup(
            parentpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Parents_register, javax.swing.GroupLayout.DEFAULT_SIZE, 1110, Short.MAX_VALUE)
        );
        parentpLayout.setVerticalGroup(
            parentpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(parentpLayout.createSequentialGroup()
                .addComponent(Parents_register, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        main_Container.add(parentp, "card3");

        View_Portal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ClassViewer_list.setBackground(new java.awt.Color(204, 204, 204));
        ClassViewer_list.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel77.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(102, 102, 102));
        jLabel77.setText("List  View");
        jLabel77.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ClassViewer_list.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 70, 50));

        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_user_25px.png"))); // NOI18N
        ClassViewer_list.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 50, 70));

        lb_ByRoomType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_ByRoomType.setForeground(new java.awt.Color(255, 255, 255));
        lb_ByRoomType.setText("Un_Assiged");
        lb_ByRoomType.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_ByRoomType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_ByRoomTypeMouseClicked(evt);
            }
        });
        ClassViewer_list.add(lb_ByRoomType, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 80, 50));

        Searching_panel_holder.setLayout(new java.awt.CardLayout());

        SByRoomType.setPreferredSize(new java.awt.Dimension(370, 71));
        SByRoomType.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 2, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Search_15px.png"))); // NOI18N
        jLabel2.setText("  Search");
        SByRoomType.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 80, 40));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        SByRoomType.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 200, 30));

        Add_price4.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Add_price4.setForeground(new java.awt.Color(255, 255, 255));
        Add_price4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Add_price4.setText(" Class");
        Add_price4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_price4MouseClicked(evt);
            }
        });
        SByRoomType.add(Add_price4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 80, 60));

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
        addRoom_type.setText("Class");
        addRoom_type.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addRoom_typeMouseClicked(evt);
            }
        });
        Cover.add(addRoom_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 60, 40));

        Delecte25.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte25.setForeground(new java.awt.Color(255, 255, 255));
        Delecte25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_no_entry_25px.png"))); // NOI18N
        Delecte25.setText("Delecte");
        Delecte25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Delecte25MouseClicked(evt);
            }
        });
        Cover.add(Delecte25, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 80, 40));

        edit19.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        edit19.setForeground(new java.awt.Color(255, 255, 255));
        edit19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_upload_to_ftp_30px.png"))); // NOI18N
        edit19.setText("Edit");
        edit19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edit19MouseClicked(evt);
            }
        });
        Cover.add(edit19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 70, 40));

        Delecte26.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte26.setForeground(new java.awt.Color(255, 255, 255));
        Delecte26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        Cover.add(Delecte26, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, -10, 380, 70));

        Searching_panel_holder.add(Cover, "card2");

        ClassViewer_list.add(Searching_panel_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, 370, 60));

        lb_bg_btnFirstView2.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        lb_bg_btnFirstView2.setForeground(new java.awt.Color(255, 255, 255));
        lb_bg_btnFirstView2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_bg_btnFirstView2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        ClassViewer_list.add(lb_bg_btnFirstView2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 170, 80));

        View_Portal_table.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        View_Portal_table.setForeground(new java.awt.Color(102, 102, 102));
        View_Portal_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        View_Portal_table.setRowHeight(35);
        View_Portal_table.setRowMargin(5);
        View_Portal_table.setShowVerticalLines(false);
        View_Portal_table.setTableHeader(null);
        View_Portal_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                View_Portal_tableMouseClicked(evt);
            }
        });
        jScrollPane19.setViewportView(View_Portal_table);

        ClassViewer_list.add(jScrollPane19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 1040, 380));

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel222.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel222.setForeground(new java.awt.Color(102, 102, 102));
        jLabel222.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel222.setText("Contact");
        jPanel40.add(jLabel222, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 0, 100, 50));

        jLabel223.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel223.setForeground(new java.awt.Color(102, 102, 102));
        jLabel223.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel223.setText("Student name");
        jPanel40.add(jLabel223, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 50));

        jLabel224.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel224.setForeground(new java.awt.Color(102, 102, 102));
        jLabel224.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel224.setText("   Gender");
        jPanel40.add(jLabel224, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 150, 50));

        jLabel225.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel225.setForeground(new java.awt.Color(102, 102, 102));
        jLabel225.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel225.setText("Profession");
        jPanel40.add(jLabel225, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 160, 50));

        jLabel226.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel226.setForeground(new java.awt.Color(102, 102, 102));
        jLabel226.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel226.setText("Age");
        jPanel40.add(jLabel226, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 70, 50));

        jLabel227.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel227.setForeground(new java.awt.Color(102, 102, 102));
        jLabel227.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel227.setText("Parents name");
        jPanel40.add(jLabel227, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 120, 50));

        jLabel228.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel228.setForeground(new java.awt.Color(102, 102, 102));
        jLabel228.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel228.setText("Address");
        jPanel40.add(jLabel228, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 90, 50));

        jLabel229.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel229.setForeground(new java.awt.Color(102, 102, 102));
        jLabel229.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel229.setText(" Status");
        jPanel40.add(jLabel229, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 80, 50));

        jLabel230.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel230.setForeground(new java.awt.Color(102, 102, 102));
        jLabel230.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel230.setText("Language");
        jPanel40.add(jLabel230, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 100, 50));

        ClassViewer_list.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 1040, 50));

        table_holder_bg16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        table_holder_bg16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/add_Room_typebg.png"))); // NOI18N
        ClassViewer_list.add(table_holder_bg16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1130, 680));

        View_Portal.add(ClassViewer_list, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 670));

        main_Container.add(View_Portal, "card5");

        PanelForContent_Display.add(main_Container, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 1110, 670));

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
        jLabel42.setText("   Back Home");
        admin_btn.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, 40));

        PanelForContent_Display.add(admin_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 180, 40));

        minize_lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minize_lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_minus_19px.png"))); // NOI18N
        minize_lb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minize_lbMouseClicked(evt);
            }
        });
        PanelForContent_Display.add(minize_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 0, 40, 60));

        exit_lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit_lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_delete_18px_1.png"))); // NOI18N
        exit_lb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit_lbMouseClicked(evt);
            }
        });
        PanelForContent_Display.add(exit_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 0, 50, 60));

        model.setForeground(new java.awt.Color(240, 240, 240));
        model.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        model.setText("jLabel2");
        PanelForContent_Display.add(model, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 10, 110, 40));

        jLabel37.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Hi Admin,  Welcome To My  Manager");
        PanelForContent_Display.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 480, 40));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/header.png"))); // NOI18N
        jLabel30.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel30MouseDragged(evt);
            }
        });
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel30MousePressed(evt);
            }
        });
        PanelForContent_Display.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 1380, 100));

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
        jLabel20.setText("   Fee Records");
        hotel_ma.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 60));

        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        hotel_ma.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 60));

        access7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_unlock_19px.png"))); // NOI18N
        hotel_ma.add(access7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 9, -1, 40));

        PanelForContent_Display.add(hotel_ma, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 210, -1));

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
        jLabel21.setText("   Price Manager");
        report_panelBTN.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 60));

        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        report_panelBTN.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 60));

        access6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_unlock_19px.png"))); // NOI18N
        report_panelBTN.add(access6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 9, -1, 40));

        PanelForContent_Display.add(report_panelBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 210, -1));

        Tex_manager_lb2.setBackground(new java.awt.Color(121, 119, 119));
        Tex_manager_lb2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tex_manager_lb2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Tex_manager_lb2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Tex_manager_lb2MouseExited(evt);
            }
        });
        Tex_manager_lb2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel81.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(255, 255, 255));
        jLabel81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_weight_care_30px.png"))); // NOI18N
        jLabel81.setText("    Analysis");
        Tex_manager_lb2.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 60));

        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel82.setText("Search Records");
        jPanel37.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        Tex_manager_lb2.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 130, 30));

        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel83.setText("Search Records");
        jPanel38.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel84.setText("Search Records");
        jPanel39.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel38.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 130, 30));

        Tex_manager_lb2.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 130, 30));

        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        Tex_manager_lb2.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 60));

        access5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_unlock_19px.png"))); // NOI18N
        Tex_manager_lb2.add(access5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 9, -1, 40));

        PanelForContent_Display.add(Tex_manager_lb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 210, 60));

        calender.setBackground(new java.awt.Color(121, 119, 119));
        calender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calenderMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                calenderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                calenderMouseExited(evt);
            }
        });
        calender.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_handshake_heart_30px.png"))); // NOI18N
        jLabel23.setText("   Payments");
        calender.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 130, 60));

        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        calender.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 60));

        access4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_unlock_19px.png"))); // NOI18N
        calender.add(access4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 9, -1, 40));

        PanelForContent_Display.add(calender, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 210, -1));

        expenses.setBackground(new java.awt.Color(121, 119, 119));
        expenses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                expensesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                expensesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                expensesMouseExited(evt);
            }
        });
        expenses.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_general_ledger_30px.png"))); // NOI18N
        jLabel46.setText("  View Portal");
        expenses.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 0, 120, 44));

        jLabel92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        expenses.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 60));

        access3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_unlock_19px.png"))); // NOI18N
        expenses.add(access3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 9, -1, 40));

        PanelForContent_Display.add(expenses, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 210, -1));

        parent_btn.setBackground(new java.awt.Color(121, 119, 119));
        parent_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                parent_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                parent_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                parent_btnMouseExited(evt);
            }
        });
        parent_btn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_family_35px_1.png"))); // NOI18N
        jLabel22.setText("Parents Registration");
        parent_btn.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 190, 60));

        jLabel94.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel94.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        parent_btn.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 60));

        access2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_unlock_19px.png"))); // NOI18N
        parent_btn.add(access2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 9, -1, 40));

        PanelForContent_Display.add(parent_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 210, -1));

        Student_btn.setBackground(new java.awt.Color(121, 119, 119));
        Student_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Student_btnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Student_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Student_btnMouseExited(evt);
            }
        });
        Student_btn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_user_25px.png"))); // NOI18N
        jLabel39.setText(" Student Registration");
        Student_btn.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, 50));

        access1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_unlock_19px.png"))); // NOI18N
        Student_btn.add(access1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, 30));

        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        Student_btn.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 30, 50));
        Student_btn.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 200, 10));

        PanelForContent_Display.add(Student_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 210, 60));

        jPanel28.setBackground(new java.awt.Color(121, 119, 119));
        jPanel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel28MouseClicked(evt);
            }
        });
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_user.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        lb_user.setForeground(new java.awt.Color(255, 255, 255));
        lb_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_ok_12px.png"))); // NOI18N
        lb_user.setText("name");
        jPanel28.add(lb_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 120, 20));

        img_usera.setBackground(new java.awt.Color(121, 119, 119));
        img_usera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel43.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icon.png"))); // NOI18N
        img_usera.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 90));

        user_img.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        user_img.setForeground(new java.awt.Color(153, 153, 153));
        user_img.setPreferredSize(new java.awt.Dimension(50, 60));
        img_usera.add(user_img, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, 70));

        jPanel28.add(img_usera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 100));

        PanelForContent_Display.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 210, -1));

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/background_adm.png"))); // NOI18N
        PanelForContent_Display.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, -80, 1440, 1180));

        getContentPane().add(PanelForContent_Display, "card2");

        PanelForPopUP_Display.setBackground(new Color(225,225,225,10));
        PanelForPopUP_Display.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sID.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        sID.setText("Student ID");
        PanelForPopUP_Display.add(sID, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, 200, 40));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("ID Owner");
        PanelForPopUP_Display.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, 80, 50));

        IDname.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        IDname.setText("jLabel26");
        PanelForPopUP_Display.add(IDname, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 190, 40));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_30px.png"))); // NOI18N
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel32MouseClicked(evt);
            }
        });
        PanelForPopUP_Display.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 210, 70, 60));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setText("Last Generated ID");
        PanelForPopUP_Display.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, 130, 40));

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_add_user_male_127px.png"))); // NOI18N
        PanelForPopUP_Display.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 280, 180, 150));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText("Student ID");
        PanelForPopUP_Display.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, 80, 40));

        last_Generation.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        last_Generation.setText(" 202030");
        PanelForPopUP_Display.add(last_Generation, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 440, 140, 40));

        jLabel14.setText("ID As by our suggestion ");
        PanelForPopUP_Display.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 470, 150, 30));

        jLabel1.setText("Press Back to Continue From the  last");
        PanelForPopUP_Display.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 430, 230, 50));

        gb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/info.png"))); // NOI18N
        PanelForPopUP_Display.add(gb, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 1040, -1));

        getContentPane().add(PanelForPopUP_Display, "card3");

        popup_parentRegister.setBackground(new Color(225,225,225,50));
        popup_parentRegister.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_Search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Search_15px.png"))); // NOI18N
        lb_Search.setText("    find Student");
        lb_Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_SearchMouseClicked(evt);
            }
        });
        popup_parentRegister.add(lb_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 170, 50));

        lb_background2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_background2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/image.png"))); // NOI18N
        popup_parentRegister.add(lb_background2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 200, 280, 210));
        popup_parentRegister.add(popup_img_Holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 240, 150, 130));

        sID1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        sID1.setText("Student ID");
        popup_parentRegister.add(sID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, 200, 50));

        Ib_name.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        Ib_name.setText("student name");
        popup_parentRegister.add(Ib_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, 190, 40));

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_30px.png"))); // NOI18N
        jLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel40MouseClicked(evt);
            }
        });
        popup_parentRegister.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 210, 70, 60));

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel41.setText("Gender");
        popup_parentRegister.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 440, 180, 40));

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel44.setText("Student ID");
        popup_parentRegister.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 130, 50));

        lb_Gender.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lb_Gender.setText(" 202030");
        popup_parentRegister.add(lb_Gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 440, 140, 40));

        lb_Resource_parentName_holder.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_Resource_parentName_holder.setText("parents Name");
        popup_parentRegister.add(lb_Resource_parentName_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, 110, 50));

        Save_parent.setForeground(new java.awt.Color(153, 153, 153));
        Save_parent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Save_parent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_add_20px.png"))); // NOI18N
        Save_parent.setText(" Save");
        Save_parent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Save_parentMouseClicked(evt);
            }
        });
        popup_parentRegister.add(Save_parent, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 470, 90, 50));

        jLabel47.setText("Profile Image");
        popup_parentRegister.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 410, 90, 50));

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel49.setText("Parents Name");
        popup_parentRegister.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 160, 50));

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel48.setText("Student Name");
        popup_parentRegister.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 160, 50));

        Save_parent1.setForeground(new java.awt.Color(153, 153, 153));
        Save_parent1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Save_parent1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_add_20px.png"))); // NOI18N
        Save_parent1.setText("  Clear");
        Save_parent1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Save_parent1MouseClicked(evt);
            }
        });
        popup_parentRegister.add(Save_parent1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 470, 90, 50));

        txtSerach_student.setBackground(new Color(255,255,255,1));
        txtSerach_student.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSerach_studentKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSerach_studentKeyTyped(evt);
            }
        });
        popup_parentRegister.add(txtSerach_student, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 250, 30));

        gb1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gb1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/info.png"))); // NOI18N
        popup_parentRegister.add(gb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, -1));

        getContentPane().add(popup_parentRegister, "card3");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void hotel_maMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hotel_maMouseClicked
        //chech if the user is an admin
            try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement(" SELECT  * FROM  access WHERE access_id =?");//searching for the user by access_id receieved to check the info for the useer
            pps.setString(1,Recieved_user_id.trim()); 
            rs = pps.executeQuery();
                 if(rs.next()){
                     
                      usertype=  rs.getString("user");
                     }
                    } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
             
               if(usertype.equals("Administration")){//checking the user mode if it is equal to this 
                        RecordsV v = new   RecordsV();
                        this.dispose();
                        v.setVisible(true);
                         //**************************************send id
                     v.setPassed_id(Recieved_user_id);
                     v.printPassed_id();
                     //*********************************************
                     
                        
                        
                }else if(usertype.equals("Accountant") ){//checking the user mode if it is equal to this
                     RecordsV v = new   RecordsV();
                     this.dispose();
                     v.setVisible(true);
                     
                     //**************************************send id
                     v.setPassed_id(Recieved_user_id);
                     v.printPassed_id();
                     //*********************************************
                     
                     
                } else if (usertype.equals("Reception")){//checking the user mode if it is equal to this
                  JOptionPane.showMessageDialog(null, "You Have No Access");

                }   
        
        
        
     
        
    }//GEN-LAST:event_hotel_maMouseClicked

    private void hotel_maMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hotel_maMouseEntered
        hotel_ma.setBackground(new Color(33,173,178));
    }//GEN-LAST:event_hotel_maMouseEntered

    private void hotel_maMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hotel_maMouseExited
        hotel_ma.setBackground(new Color(121,119,119));
    }//GEN-LAST:event_hotel_maMouseExited

    private void calenderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calenderMouseClicked
      //chech if the user is an admin
            try {
            conn = DBConnection.getConnction();
            pps9 = conn.prepareStatement(" SELECT  * FROM  access WHERE access_id =?");//searching for the user by access_id receieved to check the info for the useer
            pps9.setString(1,Recieved_user_id.trim()); 
            rs9 = pps9.executeQuery();
                 if(rs9.next()){
                      String fname=  rs9.getString("first_name");
                      String lname=  rs9.getString("last_name");
                      jLabel37.setText("Hi   " +fname +"  "+lname +"   Welcome To Payment  Management");
                      usertype=  rs9.getString("user");
                     }
                    } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
             
               if(usertype.equals("Administration")){//checking the user mode if it is equal to this 
                     Payments rp = new Payments();
                      rp.setVisible(true);
                }else if(usertype.equals("Accountant") ){//checking the user mode if it is equal to this
                     Payments rp = new Payments();
                     rp.setVisible(true);
                } else if (usertype.equals("Reception")){//checking the user mode if it is equal to this
                   JOptionPane.showMessageDialog(null, "You Have No Access");
                }
        
        
       
    }//GEN-LAST:event_calenderMouseClicked

    private void calenderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calenderMouseEntered
        calender.setBackground(new Color(33,173,178));
    }//GEN-LAST:event_calenderMouseEntered

    private void calenderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calenderMouseExited
        calender.setBackground(new Color(121,119,119));
    }//GEN-LAST:event_calenderMouseExited

    private void report_panelBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_report_panelBTNMouseClicked
          //chech if the user is an admin
           String user_id = null;

            try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement(" SELECT  * FROM  access WHERE access_id =?");//searching for the user by access_id receieved to check the info for the useer
            pps.setString(1,Recieved_user_id.trim()); 
            rs = pps.executeQuery();
                 if(rs.next()){
                      usertype=  rs.getString("user");  //getting the user mode
                        user_id =  rs.getString("access_id");

                     }
                    } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
             
               if(usertype.equals("Administration")){//checking the user mode if it is equal to this 
                         Expenses myEX = new Expenses();
                         myEX.setVisible(true);
                         
                         //**************************************send id
                     myEX.setPassed_id(user_id);
                     myEX.printPassed_id();
                     this.dispose();
                     //*********************************************
                }else if(usertype.equals("Accountant") ){//checking the user mode if it is equal to this
                         Expenses myEX = new Expenses();
                         myEX.setVisible(true);
                         
                         //**************************************send id
                     myEX.setPassed_id(user_id);
                     myEX.printPassed_id();
                     this.dispose();
                     //*********************************************
                } else if (usertype.equals("Reception")){//checking the user mode if it is equal to this
                   JOptionPane.showMessageDialog(null, "You Have No Access");
                }
        
        
        
        
        
            
    }//GEN-LAST:event_report_panelBTNMouseClicked

    private void report_panelBTNMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_report_panelBTNMouseEntered
        report_panelBTN.setBackground(new Color(33,173,178));
    }//GEN-LAST:event_report_panelBTNMouseEntered

    private void report_panelBTNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_report_panelBTNMouseExited
        report_panelBTN.setBackground(new Color(121,119,119));
    }//GEN-LAST:event_report_panelBTNMouseExited

    private void admin_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btnMouseClicked
        
        
                    Admin_Home.getObj().setVisible(true);
                    //passing user id 
                    Admin_Home.getObj().setUserID(Recieved_user_id);
                    Admin_Home.getObj().printUserID();

                    this.dispose();

    }//GEN-LAST:event_admin_btnMouseClicked

    private void admin_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btnMouseEntered
        admin_btn.setBackground(new Color(82,120,152));
    }//GEN-LAST:event_admin_btnMouseEntered

    private void admin_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btnMouseExited
        admin_btn.setBackground(new Color(121,119,119));
    }//GEN-LAST:event_admin_btnMouseExited

    private void expensesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expensesMouseClicked
                      //chech if the user is an admin
            try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement(" SELECT  * FROM  access WHERE access_id =?");
            pps.setString(1,Recieved_user_id.trim()); 
            rs = pps.executeQuery();
                 if(rs.next()){
                      String fname=  rs.getString("first_name");
                      String lname=  rs.getString("last_name");
                      jLabel37.setText("Hi !  " +fname +"  "+lname +"   Welcome  Registration View Point");
                      usertype=  rs.getString("user");
                     }
                    } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
             
               if(usertype.equals("Administration")){
                     
                   panel_cover.hide();
                     parentp.hide();
                     Student_Registration.hide();
                     View_Portal.setVisible(true);
                }else if(usertype.equals("Accountant") ){
                    
                    panel_cover.hide();
                    parentp.hide();
                    Student_Registration.hide();
                    View_Portal .setVisible(true);
                } else if (usertype.equals("Reception")){
                   
                    panel_cover.hide();
                    parentp.hide();
                    Student_Registration.hide();
                    View_Portal .setVisible(true);
                }   

    }//GEN-LAST:event_expensesMouseClicked

    private void expensesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expensesMouseEntered
        expenses.setBackground(new Color(33,173,178));
    }//GEN-LAST:event_expensesMouseEntered

    private void expensesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expensesMouseExited
        expenses.setBackground(new Color(121,119,119));
    }//GEN-LAST:event_expensesMouseExited

    private void Student_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Student_btnMouseClicked
          //chech if the user is an admin
            try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement(" SELECT  * FROM  access WHERE access_id =?");
            pps.setString(1,Recieved_user_id.trim()); 
            rs = pps.executeQuery();
                 if(rs.next()){
                      String fname=  rs.getString("first_name");
                      String lname=  rs.getString("last_name");
                      jLabel37.setText("Hi !  " +fname +"  "+lname +"   Welcome  Registration Student Point");
                      usertype=  rs.getString("user");
                     }
                    } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
             
               if(usertype.equals("Administration")){
                     panel_cover.hide();
                     parentp.hide();
                     Student_Registration .setVisible(true);
                }else if(usertype.equals("Accountant") ){
                     JOptionPane.showMessageDialog(null, "You Have No Access");
                } else if (usertype.equals("Reception")){
                    panel_cover.hide();
                    parentp.hide();
                    Student_Registration .setVisible(true);
                }
        
        
        
        
        

    }//GEN-LAST:event_Student_btnMouseClicked

    private void Student_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Student_btnMouseEntered
        Student_btn.setBackground(new Color(33,173,178));
    }//GEN-LAST:event_Student_btnMouseEntered

    private void Student_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Student_btnMouseExited
        Student_btn.setBackground(new Color(121,119,119));
    }//GEN-LAST:event_Student_btnMouseExited

    private void exit_lbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_lbMouseClicked
        Dialog frame = new Dialog();
        frame.setVisible(true);
    }//GEN-LAST:event_exit_lbMouseClicked

    private void minize_lbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minize_lbMouseClicked
        this.setExtendedState(Admin_Home.ICONIFIED);
    }//GEN-LAST:event_minize_lbMouseClicked

    private void txtFNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFNameActionPerformed

    private void txtFNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFNameKeyPressed
        if (evt.getKeyCode()== KeyEvent.VK_ENTER){
            txtFor_Student_ID.requestFocus();
        }
    }//GEN-LAST:event_txtFNameKeyPressed
         
    private void txtFor_Student_IDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFor_Student_IDKeyPressed
      
        
        if (evt.getKeyCode()== KeyEvent.VK_ENTER){
             CheckingID();
             txtSAge.requestFocus();
        }
    }//GEN-LAST:event_txtFor_Student_IDKeyPressed

    private void txtFor_Student_IDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFor_Student_IDKeyTyped
        char iNumb = evt.getKeyChar();
        if(!(Character.isDigit(iNumb))
            ||(iNumb == KeyEvent.VK_BACKSPACE)
            ||(iNumb == KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_txtFor_Student_IDKeyTyped

    private void txtSAgeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSAgeKeyPressed

    }//GEN-LAST:event_txtSAgeKeyPressed

    private void txtSAgeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSAgeKeyTyped
        char iNumb = evt.getKeyChar();
        if(!(Character.isDigit(iNumb))
            ||(iNumb == KeyEvent.VK_BACKSPACE)
            ||(iNumb == KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_txtSAgeKeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         CheckingID();
    }//GEN-LAST:event_jButton4ActionPerformed
    
    public void CheckingID(){
    
           try {
            conn = DBConnection.getConnction();
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("select Max(Student_ID) from students");
            rs.next();
            lastIDdb = rs.getString("Max(Student_ID)");
            
            last_Generation.setText( rs.getString("Max(Student_ID)"));//putting on popup
            if(rs.getString("Max(Student_ID)")== null){
            }
        } catch (Exception e) {
        }
        
        try {
            String StudentId = txtFor_Student_ID.getText();
             conn = DBConnection.getConnction();
            pps4 = conn.prepareStatement(" SELECT Student_ID,Full_Name FROM students WHERE Student_ID = ?");
            pps4.setString(1, StudentId);
            rs4 = pps4.executeQuery();
            if(rs4.next() == false){
                JOptionPane.showMessageDialog(this, "Student not Found");
            }else{
                
               PanelForContent_Display.hide();
               PanelForPopUP_Display.setVisible(true);
              
                IDname.setText(  rs4.getString("Full_Name"));
                sID.setText(  rs4.getString("Student_ID"));
            }
        } catch (SQLException ex) {Logger.getLogger(Adminstrative.class.getName()).log(Level.SEVERE, null, ex);}
    }
    
    
    private void rMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rMaleActionPerformed
        Gender ="Male";
        rMale.setSelected(true);
        rFemale.setSelected(false);
    }//GEN-LAST:event_rMaleActionPerformed

    private void rFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rFemaleActionPerformed
        Gender ="Female";
        rFemale.setSelected(true);
        rMale.setSelected(false);
    }//GEN-LAST:event_rFemaleActionPerformed

    
    private static String USERNAME ="root";
  private static String Password ="";
  private static String CONN ="jdbc:mysql://localhost/schoolms";
    private void txtFathersNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFathersNameKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            occupFather.requestFocus();
        }
    }//GEN-LAST:event_txtFathersNameKeyPressed

    private void occupFatherKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_occupFatherKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            ContactNumberF.requestFocus();
        }
    }//GEN-LAST:event_occupFatherKeyPressed

    private void ContactNumberFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ContactNumberFKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){

            emailFather.requestFocus();
        }
    }//GEN-LAST:event_ContactNumberFKeyPressed

    private void ContactNumberFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ContactNumberFKeyTyped
        // to allow only number in the contact txtbox
        char numb = evt.getKeyChar();
        if(!(Character.isDigit(numb))
            ||(numb == KeyEvent.VK_BACKSPACE)
            ||(numb == KeyEvent.VK_BACKSPACE) ){
            evt.consume();
        }
    }//GEN-LAST:event_ContactNumberFKeyTyped

    private void emailFatherKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailFatherKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            nationalityFather.requestFocus();
        }
    }//GEN-LAST:event_emailFatherKeyPressed

    private void nationalityFatherKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nationalityFatherKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            txtNRC1.requestFocus();
        }
    }//GEN-LAST:event_nationalityFatherKeyPressed

    private void txtNRC1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNRC1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            langugeFather.requestFocus();
        }
    }//GEN-LAST:event_txtNRC1KeyPressed

    private void PostCode1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PostCode1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            address.requestFocus();
        }
    }//GEN-LAST:event_PostCode1KeyPressed

    private void addressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addressKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
        }
    }//GEN-LAST:event_addressKeyPressed

    private void langugeFatherKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_langugeFatherKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            PostCode1.requestFocus();
        }
    }//GEN-LAST:event_langugeFatherKeyPressed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
  //getting students id
       
        if(!popup_parentRegister.isShowing()){
          panel_cover.hide();
          Student_Registration.hide();
          PanelForContent_Display.hide();
          PanelForPopUP_Display.hide();
          View_Portal.hide();
          popup_parentRegister.setVisible(true);  
          
          
          
           parent_name = txtFathersName .getText();
          lb_Resource_parentName_holder.setText(parent_name);
        }
        
       
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void Mark_SelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mark_SelectedActionPerformed
        Guarden =   ParentsDropList.getSelectedItem().toString().trim();
        if(Mark_Selected.isSelected()){
            ParentsDropList.disable();

        }else if(!Mark_Selected.isSelected()){
            ParentsDropList.setEnabled(true);}
    }//GEN-LAST:event_Mark_SelectedActionPerformed

    private void lbIMAGE_ChooserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbIMAGE_ChooserMouseClicked
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setFileHidingEnabled(false);
        if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
        java.io.File f = chooser.getSelectedFile();
        pURL.setText(f.getPath());
        
            try {
               ImageIcon icon= new ImageIcon(ImageIO.read(f));
               Image image = icon.getImage();
               Image modifiedImage = image.getScaledInstance(lb_ParentImage_holder.getWidth(), lb_ParentImage_holder.getHeight(), Image.SCALE_SMOOTH);
               icon = new ImageIcon(modifiedImage);
               lb_ParentImage_holder.setIcon(icon);
           } catch (IOException ex) {
                Logger.getLogger(Adminstrative.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_lbIMAGE_ChooserMouseClicked

    private void jLabel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseClicked
      int lastid;
      int increaseID = 1;
      int result ;
           lastid = Integer.parseInt(lastIDdb); 
           result =  lastid +  increaseID;
               txtFor_Student_ID.setText(Integer.toString(result));//putting the last restset
               PanelForPopUP_Display.hide();
               PanelForContent_Display.setVisible(true);
    }//GEN-LAST:event_jLabel32MouseClicked

    private void createMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createMouseClicked

    }//GEN-LAST:event_createMouseClicked

    private void create1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_create1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_create1MouseClicked

    private void create2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_create2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_create2MouseClicked

    private void create3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_create3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_create3MouseClicked

    private void Tex_manager_lb2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tex_manager_lb2MouseClicked
        //chech if the user is an admin
            try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement(" SELECT  * FROM  access WHERE access_id =?");//searching for the user by access_id receieved to check the info for the useer
            pps.setString(1,Recieved_user_id.trim()); 
            rs = pps.executeQuery();
                 if(rs.next()){
                     
                      usertype=  rs.getString("user");
                     }
                    } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
             
               if(usertype.equals("Administration")){//checking the user mode if it is equal to this 
                          Fee_Analysis an = new Fee_Analysis();
                          this.hide();
                          an.setVisible(true);
                }else if(usertype.equals("Accountant") ){//checking the user mode if it is equal to this
                       Fee_Analysis an = new Fee_Analysis();
                       an.setVisible(true);
                } else if (usertype.equals("Reception")){//checking the user mode if it is equal to this
                  JOptionPane.showMessageDialog(null, "You Have No Access");

                }  
      
    }//GEN-LAST:event_Tex_manager_lb2MouseClicked

    private void Tex_manager_lb2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tex_manager_lb2MouseEntered
       Tex_manager_lb2.setBackground(new Color(33,173,178));

    }//GEN-LAST:event_Tex_manager_lb2MouseEntered

    private void Tex_manager_lb2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tex_manager_lb2MouseExited
            Tex_manager_lb2.setBackground(new Color(121,119,119));

    }//GEN-LAST:event_Tex_manager_lb2MouseExited

    private void parent_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parent_btnMouseExited
        parent_btn.setBackground(new Color(121,119,119));
    }//GEN-LAST:event_parent_btnMouseExited

    private void parent_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parent_btnMouseEntered
        parent_btn.setBackground(new Color(33,173,178));
    }//GEN-LAST:event_parent_btnMouseEntered

    private void parent_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_parent_btnMouseClicked
       
        //chech if the user is an admin
            try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement(" SELECT  * FROM  access WHERE access_id =?");//searching for the user by access_id receieved to check the info for the useer
            pps.setString(1,Recieved_user_id.trim()); 
            rs = pps.executeQuery();
                 if(rs.next()){
                      String fname=  rs.getString("first_name");
                      String lname=  rs.getString("last_name");
                      jLabel37.setText("Hi   " +fname +"  "+lname +"   Welcome To Registration Parent Point");
                      usertype=  rs.getString("user");
                     }
                    } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
             
               if(usertype.equals("Administration")){//checking the user mode if it is equal to this 
                     Student_Registration .hide();
                     panel_cover.hide();
                     parentp.setVisible(true);
                }else if(usertype.equals("Accountant") ){//checking the user mode if it is equal to this
                     JOptionPane.showMessageDialog(null, "You Have No Access");
                } else if (usertype.equals("Reception")){//checking the user mode if it is equal to this
                    Student_Registration .hide();
                    panel_cover.hide();
                    parentp.setVisible(true);
                }
        
    }//GEN-LAST:event_parent_btnMouseClicked

    private void jLabel40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseClicked
          panel_cover.hide();
          Student_Registration.hide();
          PanelForPopUP_Display.hide();
          popup_parentRegister.hide();
          PanelForContent_Display.setVisible(true);

    }//GEN-LAST:event_jLabel40MouseClicked

    private void lb_SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_SearchMouseClicked
      
    }//GEN-LAST:event_lb_SearchMouseClicked
public void getStudentInf(){

 try {   //item_name  like '%" + txt_search.getText() + "%'  OR item_number  like '%" + txt_search.getText() + "%'   OR  conditions  like '%" + txt_search.getText() + "%'  
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("select * from students WHERE   Full_Name  like '%" + txtSerach_student.getText() + "%'");
              byte[] image = null;

            rs = pps.executeQuery();
            if(rs.next()){
             Student_ID_toParentRelation   = rs.getString("student_ids");
             sID1.setText(rs.getString("Student_ID"));
             Ib_name.setText(rs.getString("Full_Name"));
             lb_Gender.setText(rs.getString("Student_Gender"));

                         image = rs.getBytes("image");
                         Image img = Toolkit.getDefaultToolkit().createImage(image);
                         ImageIcon icon = new ImageIcon(img);
                         popup_img_Holder.setIcon(icon);
           }
        } catch (Exception e) {
        }
}
    
    private void Save_parentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Save_parentMouseClicked
       insert_parentsInfo_ND_relateStudent_ID();
       myClass();
    }//GEN-LAST:event_Save_parentMouseClicked

    private void Save_parent1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Save_parent1MouseClicked
       
        
    }//GEN-LAST:event_Save_parent1MouseClicked

    private void Image_chooserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Image_chooserMouseClicked
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
               Image modifiedImage = image.getScaledInstance(img_holder.getWidth(), img_holder.getHeight(), Image.SCALE_SMOOTH);
               icon = new ImageIcon(modifiedImage);
             //   img_holder.setIcon(new ImageIcon(ImageIO.read(f)));
                img_holder.setIcon(icon);
                
           } catch (IOException ex) {
                Logger.getLogger(Adminstrative.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_Image_chooserMouseClicked

    private void txtSerach_studentKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerach_studentKeyPressed
          if(evt.getKeyCode() == KeyEvent.VK_ENTER){
             getStudentInf();  
        }
    }//GEN-LAST:event_txtSerach_studentKeyPressed

    private void level_changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level_changeActionPerformed
     String Option =  combAp.getSelectedItem().toString();
     String class_chooser  =  txtChooseGrade.getSelectedItem().toString();

     if (class_chooser.equals("None")) {
          JOptionPane.showMessageDialog(null, "Select class of Choice");
          
     } else if (!class_chooser.equals("None")) {

    
     if(Option.equals("Compulsory")){
           // combAp.setSelectedIndex(0);
           // combAp.setEnabled(true);

            try {
            conn = DBConnection.getConnction();
            String sql = "SELECT   subjects.subject_name,  classes.grade_room FROM  subjects  JOIN  class_subject_joint  ON  subjects.subject_id = class_subject_joint.subject_id   INNER JOIN classes ON  classes.class_id = class_subject_joint.class_id WHERE grade_room =? AND subject_application = 'Compulsory'"; 
            pps7 = conn.prepareStatement(sql);
            pps7.setString(1, class_chooser);
            rs7 = pps7.executeQuery();
            subject_table.setModel(DbUtils.resultSetToTableModel(rs7));
          } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
                    
        }else  if(Option.equals("Optional")){
         //   combAp.setSelectedIndex(1);
          //  combAp.setEnabled(false);

         try {
           conn = DBConnection.getConnction();
           String sql = "SELECT   subjects.subject_name,  classes.grade_room FROM  subjects  JOIN  class_subject_joint  ON  subjects.subject_id = class_subject_joint.subject_id   INNER JOIN classes ON  classes.class_id = class_subject_joint.class_id WHERE grade_room =? AND subject_application = 'Optional'"; 
           pps7 = conn.prepareStatement(sql);
           pps7.setString(1, class_chooser);
           rs7 = pps7.executeQuery();
           subject_table.setModel(DbUtils.resultSetToTableModel(rs7));
         } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
        } 
     
       more_info();
           
           

   }  
              
              
       
    }//GEN-LAST:event_level_changeActionPerformed

    
    public void more_info(){
    
      
            //count the number of subjects
             String class_chooser  =  txtChooseGrade.getSelectedItem().toString();

           try {conn = DBConnection.getConnction();
            String sql = "SELECT   subjects.subject_name,  classes.grade_room,num_of_subjects,	 COUNT(class_subject_joint.class_subject_id)  AS subject_count FROM  class_subject_joint   INNER JOIN  subjects  ON  subjects.subject_id = class_subject_joint.subject_id    INNER JOIN classes ON  classes.class_id = class_subject_joint.class_id WHERE grade_room =? GROUP BY grade_room";
            pps8 = conn.prepareStatement(sql);
            pps8.setString(1, class_chooser.trim());
            rs8 = pps8.executeQuery();
            if(rs8.next()){
            num_subject3.setText(rs8.getString("subject_count"));
            num_subject8.setText(rs8.getString("num_of_subjects"));
            }
            } catch (SQLException ex) { JOptionPane.showMessageDialog(null, ex); }
           
           
         String  class_capacity = null;
           
            try { conn = DBConnection.getConnction();
                pps3 = conn.prepareStatement("SELECT class_id,grade_room,class_period,DATE   ,room_number,room_capacity FROM    rooms INNER JOIN  classes ON classes.classroom_id = rooms.classroom_id WHERE grade_room = ?");
                pps3.setString(1, class_chooser.trim());
                rs3 = pps3.executeQuery();
                
               if(rs3.next()){
                lb_roomNumber.setText(rs3.getString("room_number"));
                group_year.setText(rs3.getString("class_period"));
                room_capacity_lb.setText(rs3.getString("room_capacity"));   
                
                class_capacity = rs3.getString("room_capacity");  // capacity - number of students 
                
                group_year1.setText(rs3.getString("date"));    }
            } catch (Exception ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
           
           
           
            try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("SELECT  count(student_ids) FROM students  WHERE Student_Class =?");
            pps.setString(1,class_chooser.trim());

            rs = pps.executeQuery();
            if (rs.next()) {
                String count_students = rs.getString("count(student_ids)");
                num_subject2.setText(rs.getString("count(student_ids)")); 
                
                int Students = Integer.parseInt(count_students);//reconverting Occuped space to int

                int ClassCapacity = Integer.parseInt(class_capacity);//reconverting capacity to int

                if (ClassCapacity == Students) {
                       max3.setText("this Class is full");
                } else {

                   int    ClassCapacity_caculation = ClassCapacity - Students;
                    max3.setText(Integer.toString(ClassCapacity_caculation)); //reconverting sum variables back to string and adding it to a lebal

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Class_Assignment.class.getName()).log(Level.SEVERE, null, ex);
        } 
    
    }
    
    
    
    
    private void subject_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subject_tableMouseClicked
        DefaultTableModel tableMode_type = (DefaultTableModel) subject_table.getModel();
    //    subject_selected = tableMode_type.getValueAt(subject_table.getSelectedRow(), 0).toString();
    }//GEN-LAST:event_subject_tableMouseClicked

    private void level_change1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level_change1ActionPerformed

       
        if(txtFName.getText().length() == 0){
            JOptionPane.showMessageDialog(this, "Enter Full Name");
            txtFName.requestFocus();

        }else if(txtPAdress.getText().length() == 0){
            JOptionPane.showMessageDialog(this, "Enter Physical Adress");

        }else if (txtFor_Student_ID.getText().length()== 0){
            JOptionPane.showMessageDialog(this, "Enter Student Id");
            //checking for student id in the db

        }else if(txtSAge.getText().length() ==0){
            JOptionPane.showMessageDialog(this, "Enter Student Age");

        }else if(Status.getSelectedItem().toString().length() == 0){
            JOptionPane.showMessageDialog(this, " Select the Status of Student");

        }else  {

            InputStream inputSteam = null;
            String dir = img_url.getText();
            
            try {
                inputSteam = new FileInputStream(new File(dir));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Adminstrative.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                 conn = DBConnection.getConnction();
                 String sql = "INSERT INTO students (Full_Name, physical_adress, Student_Age,  Student_Gender, Health_Status,Student_ID, Student_Class,Date,image) VALUES (?,?,?,?,?,?,?,?,?)";
                pps = conn.prepareStatement(sql);
                pps.setString(1 , txtFName.getText());
                pps.setString(2 , txtPAdress.getText());
                pps.setString(3 ,  txtSAge.getText());
                pps.setString(4 , Gender);
                pps.setString(5 ,Status.getSelectedItem().toString());
                pps.setString(6 , txtFor_Student_ID.getText());
                pps.setString(7, txtChooseGrade.getSelectedItem().toString());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(jDateChooser1.getDate());
                pps.setString(8, date);
                pps.setBlob(9, inputSteam);

                pps.executeUpdate();
                more_info();
                
                txtFName.requestFocus();
                txtFName.setText(null);
                txtPAdress.setText(null);
                txtSAge.setText(null);
                txtChooseGrade.setSelectedIndex(0);
                Status.setSelectedIndex(0);
                jDateChooser1.setDate(null);
                JOptionPane.showMessageDialog(null, "Successfully Registered..");
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            } 
           
        } 




    }//GEN-LAST:event_level_change1ActionPerformed

    private void jPanel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel28MouseClicked

     
    }//GEN-LAST:event_jPanel28MouseClicked

    private void jLabel30MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseDragged
         int x=evt.getXOnScreen();
         int y=evt.getYOnScreen();
         this.setLocation(x-xx, y-yy);
    }//GEN-LAST:event_jLabel30MouseDragged

    private void jLabel30MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MousePressed
          xx = evt.getX();
          yy = evt.getY();
    }//GEN-LAST:event_jLabel30MousePressed

    private void txtSerach_studentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSerach_studentKeyTyped
         getStudentInf(); 
    }//GEN-LAST:event_txtSerach_studentKeyTyped

    private void lb_ByRoomTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_ByRoomTypeMouseClicked

        if(Cover.isShowing()){
            Cover.hide();
            SByRoomType.setVisible(true);
        }else if(SByRoomType.isShowing()){
            SByRoomType.hide();
            Cover.setVisible(true);
        }
        
         try {
           conn = DBConnection.getConnction();
            pps5 = conn.prepareStatement("SELECT  students.Full_Name, students.physical_adress,   students.Student_Age, students.Student_Gender, students.Health_Status,   parents.parents_names, parents.Profession,  parents.`Language`  ,  Contact FROM  students  INNER JOIN   parents_students  ON  students.student_ids = parents_students.student_ids   INNER JOIN parents ON  parents.parents_id = parents_students.parents_id ");
            rs5 = pps5.executeQuery();
             View_Portal_table.setModel(DbUtils.resultSetToTableModel(rs5));
           
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

        
    }//GEN-LAST:event_lb_ByRoomTypeMouseClicked

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        try {

            conn = DBConnection.getConnction();
            String sql ="SELECT  grade_room,class_period,room_number,room_type,room_capacity,date FROM classes,rooms WHERE classes.classroom_id = rooms.classroom_id  AND grade_room  like '%" + jTextField1.getText() + "%'  OR class_period  like '%" + jTextField1.getText() + "%'   OR  room_number  like '%" + jTextField1.getText() + "%'   OR  room_type  like '%" + jTextField1.getText() + "%' "
            + "  OR  room_capacity  like '%" + jTextField1.getText() + "%'  OR  date  like '%" + jTextField1.getText() + "%'  ";
            pps = conn.prepareStatement(sql);
            rs = pps.executeQuery();
            View_Portal_table.setModel(DbUtils.resultSetToTableModel(rs));//sho
        } catch (SQLException ex) {Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);}

    }//GEN-LAST:event_jTextField1KeyTyped

    private void Add_price4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_price4MouseClicked
        
    }//GEN-LAST:event_Add_price4MouseClicked

    private void addRoom_typeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addRoom_typeMouseClicked
       
    }//GEN-LAST:event_addRoom_typeMouseClicked

    private void Delecte25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Delecte25MouseClicked
        
        try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("DELETE  FROM classes WHERE class_id = ?");
         //   pps.setString(1, Class_ResourceGetting_id);
            pps.executeUpdate();
            } catch (Exception ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
           }
       

    }//GEN-LAST:event_Delecte25MouseClicked

    private void edit19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit19MouseClicked
     
    }//GEN-LAST:event_edit19MouseClicked

    private void View_Portal_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_View_Portal_tableMouseClicked
        if(Cover.isShowing()){
            Cover.hide();
            SByRoomType.setVisible(true);
        }else if(SByRoomType.isShowing()){
            SByRoomType.hide();
            Cover.setVisible(true);
        }
        DefaultTableModel tableMode_type = (DefaultTableModel) View_Portal_table.getModel();
//        get_class_id = tableMode_type.getValueAt(View_Portal_table.getSelectedRow(), 0).toString();

    }//GEN-LAST:event_View_Portal_tableMouseClicked

 public void insert_parentsInfo_ND_relateStudent_ID(){
//parents now using this
        
     
     
            InputStream inputSteam = null;
            String dir = pURL.getText();
            
            try {
                inputSteam = new FileInputStream(new File(dir));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Adminstrative.class.getName()).log(Level.SEVERE, null, ex);
            }
     
        try {
            String pname = txtFathersName.getText();
            conn = DBConnection.getConnction();
            String sql ="INSERT INTO parents(parents_names  ,Profession,Contact,Email,Nationality,NRC,Language,Post_Code,Address,Guarden,image)VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            pps4 = conn.prepareStatement(sql);

            pps4.setString(1, pname.trim());
            pps4.setString(2, occupFather.getText());
            pps4.setString(3, ContactNumberF.getText());
            pps4.setString(4, emailFather.getText());
            pps4.setString(5, nationalityFather.getText());
            pps4.setString(6, txtNRC1.getText());
            pps4.setString(7, langugeFather.getText());
            pps4.setString(8, PostCode1.getText());
            pps4.setString(9, address.getText());
            pps4.setString(10, Guarden);
            pps4.setBlob(11, inputSteam);

            pps4.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully Saved");
           
        } catch (SQLException e) {
                           Logger.getLogger(Adminstrative.class.getName()).log(Level.SEVERE, null, e);

        }

      //***************************getting the parents id for resource keeping and use to join it in a joint table  
     try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("select * from parents WHERE parents_names =?");
            pps.setString(1, parent_name);
            rs = pps.executeQuery();
            if(rs.next()){
            parent_ID_toStudentRelation   = rs.getString("parents_id");//keeping parent id
             
           }
        } catch (Exception e) {
        }
     insert_parent_studentJoint(); //***************************inserting into parents students joint table
 }
 
 
 public void insert_parent_studentJoint(){
     //converting the FKey to int 
            int parent = Integer.parseInt(parent_ID_toStudentRelation);
            int student = Integer.parseInt(Student_ID_toParentRelation);
    
            
   try {
    conn = DBConnection.getConnction();
    pps10 = conn.prepareStatement("INSERT INTO parents_students(parents_id,student_ids)VALUES (?,?)");
    pps10.setInt(1, parent);
    pps10.setInt(2, student);
    pps10.executeUpdate();          
    } catch (Exception e) {
     }

 }
 
     public static Adminstrative getObj() {  //public method for instance Restriction
        if (Obj == null) {
            Obj = new Adminstrative();
        }
        return Obj;
    }
 
 
 
 
 
    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Adminstrative().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Add_price4;
    private javax.swing.JPanel ClassViewer_list;
    private javax.swing.JTextField ContactNumberF;
    private javax.swing.JPanel Cover;
    private javax.swing.JLabel Delecte25;
    private javax.swing.JLabel Delecte26;
    private javax.swing.JLabel IDname;
    private javax.swing.JLabel Ib_name;
    private javax.swing.JLabel Image_chooser;
    private javax.swing.JCheckBox Mark_Selected;
    private javax.swing.JPanel PanelForContent_Display;
    private javax.swing.JPanel PanelForPopUP_Display;
    private javax.swing.JComboBox ParentsDropList;
    private javax.swing.JPanel Parents_register;
    private javax.swing.JTextField PostCode1;
    private javax.swing.JPanel SByRoomType;
    private javax.swing.JButton SaveButton;
    private javax.swing.JLabel Save_parent;
    private javax.swing.JLabel Save_parent1;
    private javax.swing.JPanel Searching_panel_holder;
    private javax.swing.JComboBox Status;
    private javax.swing.JPanel Student_Registration;
    private javax.swing.JPanel Student_btn;
    private javax.swing.JPanel Tex_manager_lb2;
    private javax.swing.JPanel View_Portal;
    private javax.swing.JTable View_Portal_table;
    private javax.swing.JLabel access1;
    private javax.swing.JLabel access2;
    private javax.swing.JLabel access3;
    private javax.swing.JLabel access4;
    private javax.swing.JLabel access5;
    private javax.swing.JLabel access6;
    private javax.swing.JLabel access7;
    private javax.swing.JLabel addRoom_type;
    private javax.swing.JTextField address;
    private javax.swing.JPanel admin_btn;
    private javax.swing.JPanel calender;
    private javax.swing.JComboBox combAp;
    private javax.swing.JLabel corner;
    private javax.swing.JLabel counter_view;
    private javax.swing.JLabel counter_view1;
    private javax.swing.JLabel counter_view2;
    private javax.swing.JLabel counter_view3;
    private javax.swing.JLabel counter_view5;
    private javax.swing.JLabel counter_view7;
    private javax.swing.JLabel counter_view_classes;
    private javax.swing.JLabel counter_view_students;
    private javax.swing.JLabel counter_view_teachers;
    private javax.swing.JLabel create;
    private javax.swing.JLabel create1;
    private javax.swing.JLabel create2;
    private javax.swing.JLabel create3;
    private javax.swing.JLabel edit19;
    private javax.swing.JTextField emailFather;
    private javax.swing.JLabel exit_lb;
    private javax.swing.JPanel expenses;
    private javax.swing.JLabel gb;
    private javax.swing.JLabel gb1;
    private javax.swing.JLabel group_year;
    private javax.swing.JLabel group_year1;
    private javax.swing.JPanel hotel_ma;
    private javax.swing.JLabel img_holder;
    private javax.swing.JLabel img_url;
    private javax.swing.JPanel img_usera;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
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
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField langugeFather;
    private javax.swing.JLabel last_Generation;
    private javax.swing.JLabel lbIMAGE_Chooser;
    private javax.swing.JLabel lb_ByRoomType;
    private javax.swing.JLabel lb_Gender;
    private javax.swing.JLabel lb_ParentImage_holder;
    private javax.swing.JLabel lb_Resource_parentName_holder;
    private javax.swing.JLabel lb_Search;
    private javax.swing.JLabel lb_URL;
    private javax.swing.JLabel lb_background;
    private javax.swing.JLabel lb_background1;
    private javax.swing.JLabel lb_background2;
    private javax.swing.JLabel lb_bg_btnFirstView2;
    private javax.swing.JLabel lb_bg_btnFirstView3;
    private javax.swing.JLabel lb_roomNumber;
    private javax.swing.JLabel lb_user;
    private javax.swing.JButton level_change;
    private javax.swing.JButton level_change1;
    private javax.swing.JPanel main_Container;
    private javax.swing.JLabel max;
    private javax.swing.JLabel max1;
    private javax.swing.JLabel max2;
    private javax.swing.JLabel max3;
    private javax.swing.JLabel minize_lb;
    private javax.swing.JLabel model;
    private javax.swing.JTextField nationalityFather;
    private javax.swing.JLabel num_subject;
    private javax.swing.JLabel num_subject1;
    private javax.swing.JLabel num_subject2;
    private javax.swing.JLabel num_subject3;
    private javax.swing.JLabel num_subject6;
    private javax.swing.JLabel num_subject7;
    private javax.swing.JLabel num_subject8;
    private javax.swing.JTextField occupFather;
    private javax.swing.JLabel pURL;
    private javax.swing.JPanel panel_cover;
    private javax.swing.JPanel parent_btn;
    private javax.swing.JPanel parentp;
    private javax.swing.JLabel popup_img_Holder;
    private javax.swing.JPanel popup_parentRegister;
    private javax.swing.JRadioButton rFemale;
    private javax.swing.JRadioButton rMale;
    private javax.swing.JLabel register_bg;
    private javax.swing.JPanel report_panelBTN;
    private javax.swing.JLabel room_capacity_lb;
    private javax.swing.JLabel sID;
    private javax.swing.JLabel sID1;
    private javax.swing.JPanel studentp;
    private javax.swing.JLabel subject_lidt_view;
    private javax.swing.JLabel subject_lidt_view1;
    private javax.swing.JLabel subject_lidt_view2;
    private javax.swing.JTable subject_table;
    private javax.swing.JLabel table_holder_bg16;
    private javax.swing.JComboBox txtChooseGrade;
    private javax.swing.JTextField txtFName;
    private javax.swing.JTextField txtFathersName;
    private javax.swing.JTextField txtFor_Student_ID;
    private javax.swing.JTextField txtNRC1;
    private javax.swing.JTextField txtPAdress;
    private javax.swing.JTextField txtSAge;
    private javax.swing.JTextField txtSerach_student;
    private javax.swing.JLabel user_img;
    // End of variables declaration//GEN-END:variables
}
