package hotel.management;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Class_Assignment extends javax.swing.JFrame {

      Connection conn = null;
      PreparedStatement pps, pps1, pps2, pps3, pps4, pps6, pps5, pps7, pps8, pps9, pps10, pps11, pps12 ,pps13 = null;
      ResultSet rs, rs1, rs2, rs3, rs4, rs5, rs6, rs7, rs8, rs9, rs10, rs11, rs12 ,rs13= null;


    String gettingIDof_SelectedSubject = null;// getting id and use it to delecte elected content       
    String Resource_for_employeeID = null; //id to get the employee id and put it in relation to subjects
    String Resource_for_SubjectID = null; //id to get the subject id and put it in relation to subjects

 
    //variable for class teacher id to make a joint like table
    String Teacher_id = null;

    //
    String grade_room = null;
    String class_capacity = null;
    int ClassCapacity_caculation;

     String assignToClass_count_students = null;
     String room_capacity_AsDefined_space = null;
     
    //user access
    private static String Recieved_user_id = null;
    private static String usertype = null;
    //passing user id
    private static Class_Assignment Obj = null;
    String passed_user_id;
     
     String  table_clicked = "none";
     String getclass_Id = null;           
     String getSubject_Id = null;
      String Seleted_teacher = null;
    
            int xx = 0;
            int yy = 0;
            String Search_EmployeeID = null;
           String USer_login_id = null;



        Class_Assignment() {
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));

        ShowRoomType_onTable();
        ShowSubject_OnSubject_assigning();
        ComboDisplay();
        
        // header counter
        Count_Roomtype();
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
            //     user_access_id  =  rs6.getString("access_id");

                 String fname=  rs6.getString("first_name");
                 String lname=  rs6.getString("last_name");
                 jLabel37.setText("Hi !"+fname +"  "+lname + "  Welcome ID Manager");
                 model.setText(rs6.getString("user"));
            
                }
            } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    
    
       public void Count_Roomtype() {
        //-----------------------------------------------------------------Count_Subjects total-------------------------------  
  
        try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("SELECT  count(subject_id) FROM  subjects");
            rs = pps.executeQuery();
            if (rs.next()) {
                String sum = rs.getString("count(subject_id)");
                total_numberOF_subjects.setText(sum);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }

        
       
        
        
        //-----------------------------------------------------------------Secondary count-------------------------------
        try {
            conn = DBConnection.getConnction();
            pps1 = conn.prepareStatement("SELECT  count(subject_id) FROM  subjects WHERE class_level = 'Secondary' ");
            rs1 = pps1.executeQuery();
            if (rs1.next()) {
                String sum = rs1.getString("count(subject_id)");
                total_4Secondary.setText(sum);
            }
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

   

          // /-----------------------------------------------------------------hall type countroomcount16-------------------------------
        try {
            conn = DBConnection.getConnction();
            pps3 = conn.prepareStatement("SELECT  count(subject_id) FROM  subjects  WHERE class_level = 'Primary' ");
            rs3 = pps3.executeQuery();
            if (rs3.next()) {
                String sum = rs3.getString("count(subject_id)");
                Primary_lb.setText(sum);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }

       // /-----------------------------------------------------------------hall type countroomcount16-------------------------------
        try {
           conn = DBConnection.getConnction();

            pps4 = conn.prepareStatement("SELECT  count(subject_id) FROM  subjects   WHERE subject_application = 'Optional'");
            rs4 = pps4.executeQuery();
            if (rs4.next()) {
                String sum = rs4.getString("count(subject_id)");
                options_lb.setText(sum);
            }
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

        
       
       }
    
    
    
    public void ComboDisplay() {
        // /---------------------------------------------------------------floors-------------------------------  
        try {
           conn = DBConnection.getConnction();
            pps = conn.prepareStatement("SELECT * FROM classes");
            rs = pps.executeQuery();
            while (rs.next()) {
                String grade = rs.getString("grade_room");
                comb_classes.addItem(rs.getString("grade_room"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }

        // /-----------------------------------------------------------------displying students on the table on class_assignment-----------------------------------------------------
        try {
            conn = DBConnection.getConnction();
            String sql = " SELECT Full_Name,Student_ID,Student_Age,Student_Gender, Date  FROM students WHERE Student_Class = 0";
            pps = conn.prepareStatement(sql);
            rs = pps.executeQuery();
            StudentsAssignment_Table_display.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
    }
    
    public void ShowSubject_OnSubject_assigning() {
        //  conbo thats shows the selectable subjects to assign to a teacher
        try {
            conn = DBConnection.getConnction();
            String sql = " SELECT* FROM classes";
            pps = conn.prepareStatement(sql);
            rs = pps.executeQuery();
            while (rs.next()) {
                String Sub_name = rs.getString("grade_room");
                String Sub_type = rs.getString("class_period");
                GetClass_id.addItem(Sub_name  +"  "+ Sub_type);
            }
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

        
     

    }
  

    ///-----------------------------------------------------------------displying table content on jtable-----------------------------------------------------
    public void ShowRoomType_onTable() {//school srtucture

        try {
            conn = DBConnection.getConnction();
            String sql = " SELECT subject_name,subject_application, subject_type  FROM subjects  WHERE class_level = 'Secondary' ";
            pps = conn.prepareStatement(sql);
            rs = pps.executeQuery();
            Subjects_Table_display.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }

        // /-----------------------------------------------------------------displying students on the table on class_assignment-----------------------------------------------------
        try {
            conn = DBConnection.getConnction();
            String sql = " SELECT Full_Name,Student_Age,Student_Gender, Date,Student_Class  FROM students";
            pps = conn.prepareStatement(sql);
            rs = pps.executeQuery();
            Students_Table_display.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }

        // /-----------------------------------------------------------------displying teachers on the table on class_assignment-----------------------------------------------------
        try {
            conn = DBConnection.getConnction();
            String sql = " SELECT name,surname,employeeid,department,designation ,qualification FROM  employee WHERE department = ?";
            pps = conn.prepareStatement(sql);
            String sqlm = "Teaching";
            pps.setString(1, sqlm);
            rs = pps.executeQuery();
            TeacherAssignment_Table_display.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }

        // /-----------------------------------------------------------------displying teachers on the table -----------------------------------------------------
        try {
            conn = DBConnection.getConnction();
            String sql = " SELECT name,surname,employeeid,department,designation  FROM  employee WHERE department = 'Teaching'";
            pps = conn.prepareStatement(sql);

            rs = pps.executeQuery();
            Teachers_Table_display.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        frontSide_btn_holder = new javax.swing.JPanel();
        hotel_ma = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        calender = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        expenses = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        archived_booking = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        CMS = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
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
        panel_Teachers = new javax.swing.JPanel();
        edit9 = new javax.swing.JLabel();
        Delecte7 = new javax.swing.JLabel();
        Delecte8 = new javax.swing.JLabel();
        jScrollPane23 = new javax.swing.JScrollPane();
        Teachers_Table_display = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        jLabel205 = new javax.swing.JLabel();
        jLabel206 = new javax.swing.JLabel();
        jLabel207 = new javax.swing.JLabel();
        jLabel208 = new javax.swing.JLabel();
        jLabel217 = new javax.swing.JLabel();
        lb_hold28 = new javax.swing.JLabel();
        roomcount29 = new javax.swing.JLabel();
        Count_title28 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        lb_hold29 = new javax.swing.JLabel();
        roomcount30 = new javax.swing.JLabel();
        Count_title29 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        lb_hold30 = new javax.swing.JLabel();
        roomcount31 = new javax.swing.JLabel();
        Count_title30 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        lb_hold31 = new javax.swing.JLabel();
        roomcount32 = new javax.swing.JLabel();
        Count_title31 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        table_holder_bg7 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        panel_Students = new javax.swing.JPanel();
        Add_price1 = new javax.swing.JLabel();
        edit10 = new javax.swing.JLabel();
        Delecte10 = new javax.swing.JLabel();
        Delecte9 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jLabel209 = new javax.swing.JLabel();
        jLabel213 = new javax.swing.JLabel();
        jLabel214 = new javax.swing.JLabel();
        jLabel215 = new javax.swing.JLabel();
        jLabel216 = new javax.swing.JLabel();
        jScrollPane25 = new javax.swing.JScrollPane();
        Students_Table_display = new javax.swing.JTable();
        table_holder_bg8 = new javax.swing.JLabel();
        jLabel159 = new javax.swing.JLabel();
        panal_Subjects = new javax.swing.JPanel();
        lb_hold36 = new javax.swing.JLabel();
        total_numberOF_subjects = new javax.swing.JLabel();
        Count_title36 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
        lb_hold37 = new javax.swing.JLabel();
        total_4Secondary = new javax.swing.JLabel();
        Count_title37 = new javax.swing.JLabel();
        Count_title44 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        lb_hold38 = new javax.swing.JLabel();
        Primary_lb = new javax.swing.JLabel();
        Count_title38 = new javax.swing.JLabel();
        lb_hold39 = new javax.swing.JLabel();
        jLabel157 = new javax.swing.JLabel();
        options_lb = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        main_subjects = new javax.swing.JPanel();
        Subject_list = new javax.swing.JPanel();
        class_level1 = new javax.swing.JComboBox();
        level_change1 = new javax.swing.JButton();
        Delecte19 = new javax.swing.JLabel();
        edit21 = new javax.swing.JLabel();
        Add_PaidServices = new javax.swing.JLabel();
        Delecte20 = new javax.swing.JLabel();
        jScrollPane24 = new javax.swing.JScrollPane();
        Subjects_Table_display = new javax.swing.JTable();
        jPanel34 = new javax.swing.JPanel();
        jLabel210 = new javax.swing.JLabel();
        jLabel211 = new javax.swing.JLabel();
        jLabel212 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        table_holder_bg14 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        subject_entry = new javax.swing.JPanel();
        jLabel154 = new javax.swing.JLabel();
        Count_title39 = new javax.swing.JLabel();
        combAp = new javax.swing.JComboBox();
        CombSu = new javax.swing.JComboBox();
        txtNa = new javax.swing.JTextField();
        Reload = new javax.swing.JLabel();
        Update = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        level_change = new javax.swing.JButton();
        class_level = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();
        panel_Class_builder = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        organizer = new javax.swing.JPanel();
        Teachers_list_view = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        search_employes = new javax.swing.JTextField();
        jScrollPane27 = new javax.swing.JScrollPane();
        TeacherAssignment_Table_display = new javax.swing.JTable();
        jPanel37 = new javax.swing.JPanel();
        jLabel222 = new javax.swing.JLabel();
        jLabel223 = new javax.swing.JLabel();
        jLabel224 = new javax.swing.JLabel();
        jLabel225 = new javax.swing.JLabel();
        jLabel226 = new javax.swing.JLabel();
        jLabel227 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        Teacher_Subject_Add = new javax.swing.JPanel();
        level_change2 = new javax.swing.JButton();
        combAp1 = new javax.swing.JComboBox();
        GetClass_id = new javax.swing.JComboBox();
        jLabel27 = new javax.swing.JLabel();
        AssigningSubjects_withTeacherID = new javax.swing.JButton();
        counter = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        contact = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        lb_major3 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        lb_major1 = new javax.swing.JLabel();
        lb_major2 = new javax.swing.JLabel();
        Qualification = new javax.swing.JLabel();
        Qualification1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        Assigned_subject = new javax.swing.JTable();
        Teacher_Handlier = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        lb_GB = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        Add_Students_ToClasses = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        Teacherlb = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        Yearlb = new javax.swing.JLabel();
        Capacitylb = new javax.swing.JLabel();
        Classlb = new javax.swing.JLabel();
        Qualification5 = new javax.swing.JLabel();
        Qualification6 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jScrollPane28 = new javax.swing.JScrollPane();
        StudentsAssignment_Table_display = new javax.swing.JTable();
        jLabel79 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        lb_Search = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        image_viewer = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();
        pExpenses = new javax.swing.JPanel();
        View_class_panel = new javax.swing.JPanel();
        Popup_class_selection = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel57 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        lbyear = new javax.swing.JLabel();
        lbcapacity = new javax.swing.JLabel();
        lbspace = new javax.swing.JLabel();
        lbclass = new javax.swing.JLabel();
        lbname = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        comb_classes = new javax.swing.JComboBox();
        jLabel58 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        panel_cover = new javax.swing.JPanel();
        counter_view1 = new javax.swing.JLabel();
        counter_view2 = new javax.swing.JLabel();
        counter_view3 = new javax.swing.JLabel();
        counter_view4 = new javax.swing.JLabel();
        counter_view5 = new javax.swing.JLabel();
        counter_view6 = new javax.swing.JLabel();
        counter_view7 = new javax.swing.JLabel();
        counter_view8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        create = new javax.swing.JLabel();
        create1 = new javax.swing.JLabel();
        create2 = new javax.swing.JLabel();
        create3 = new javax.swing.JLabel();
        counter_view = new javax.swing.JLabel();
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
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_verified_account_30px.png"))); // NOI18N
        hotel_ma.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, -10, 110, 60));

        jLabel9.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("VIEW CLASSES");
        hotel_ma.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 100, 20));

        frontSide_btn_holder.add(hotel_ma, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 210, 80));

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
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_person_30px.png"))); // NOI18N
        calender.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 110, 60));

        jLabel17.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("TEACHERS PORTAL ");
        calender.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 150, 20));

        frontSide_btn_holder.add(calender, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 210, 110));

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
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_general_ledger_30px.png"))); // NOI18N
        expenses.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 80, 40));

        jLabel11.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ADD STUDENT TO A CLASS");
        expenses.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 200, 20));

        frontSide_btn_holder.add(expenses, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 210, 80));

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
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_binder_30px_1.png"))); // NOI18N
        archived_booking.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 130, 44));

        jLabel15.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("SUBJECTS");
        archived_booking.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 80, 20));

        frontSide_btn_holder.add(archived_booking, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 220, 210, 80));

        CMS.setBackground(new java.awt.Color(121, 119, 119));
        CMS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CMSMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CMSMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CMSMouseExited(evt);
            }
        });
        CMS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_wrench_35px_1.png"))); // NOI18N
        CMS.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 160, 40));

        jLabel14.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText(" CLASS  BUILDER");
        CMS.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 140, 20));

        frontSide_btn_holder.add(CMS, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 320, 220, 90));

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
        Tex_manager_lb.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 100, 40));

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
        Tex_manager_lb.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 160, 20));

        frontSide_btn_holder.add(Tex_manager_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 120, 220, 80));

        jPanel1.add(frontSide_btn_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 200, 660));

        right.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.add(right, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 760, 1380, 60));

        building_classes_panel.setLayout(new java.awt.CardLayout());

        panel_Teachers.setBackground(new java.awt.Color(255, 255, 255));
        panel_Teachers.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        edit9.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        edit9.setForeground(new java.awt.Color(255, 255, 255));
        edit9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_upload_to_ftp_30px.png"))); // NOI18N
        edit9.setText("Edit");
        panel_Teachers.add(edit9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 610, 90, 50));

        Delecte7.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte7.setForeground(new java.awt.Color(255, 255, 255));
        Delecte7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_no_entry_25px.png"))); // NOI18N
        Delecte7.setText("Delecte");
        panel_Teachers.add(Delecte7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 610, 80, 50));

        Delecte8.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte8.setForeground(new java.awt.Color(255, 255, 255));
        Delecte8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        Delecte8.setText("Delecte");
        panel_Teachers.add(Delecte8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 590, 310, 80));

        Teachers_Table_display.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Teachers_Table_display.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Teachers_Table_display.setGridColor(new java.awt.Color(255, 255, 255));
        Teachers_Table_display.setIntercellSpacing(new java.awt.Dimension(20, 5));
        Teachers_Table_display.setRowHeight(30);
        Teachers_Table_display.setTableHeader(null);
        jScrollPane23.setViewportView(Teachers_Table_display);

        panel_Teachers.add(jScrollPane23, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 890, 360));

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel205.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel205.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel205.setText("Designation");
        jPanel30.add(jLabel205, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 110, 50));

        jLabel206.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel206.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel206.setText("FIRST NAME");
        jPanel30.add(jLabel206, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 50));

        jLabel207.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel207.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel207.setText("  ID NUMBER");
        jPanel30.add(jLabel207, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 120, 50));

        jLabel208.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel208.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel208.setText("SURNAME");
        jPanel30.add(jLabel208, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 120, 50));

        jLabel217.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel217.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel217.setText("  DEPARTMENT");
        jPanel30.add(jLabel217, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 130, 50));

        panel_Teachers.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 890, 50));

        lb_hold28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_condo_30px.png"))); // NOI18N
        panel_Teachers.add(lb_hold28, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 60, 60));

        roomcount29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roomcount29.setText("45");
        panel_Teachers.add(roomcount29, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 50, 40));

        Count_title28.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title28.setForeground(new java.awt.Color(33, 173, 178));
        Count_title28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title28.setText("Prices");
        panel_Teachers.add(Count_title28, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 100, 30));

        jLabel138.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/count.png"))); // NOI18N
        panel_Teachers.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 260, 80));

        lb_hold29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Escalator_Down_30px.png"))); // NOI18N
        panel_Teachers.add(lb_hold29, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 60, 60));

        roomcount30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roomcount30.setText("45");
        panel_Teachers.add(roomcount30, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 60, 30));

        Count_title29.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title29.setForeground(new java.awt.Color(33, 173, 178));
        Count_title29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title29.setText("Floors");
        panel_Teachers.add(Count_title29, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 120, 40));

        jLabel139.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/count2.png"))); // NOI18N
        panel_Teachers.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 260, 80));

        lb_hold30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_direction_30px.png"))); // NOI18N
        panel_Teachers.add(lb_hold30, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 70, 60, 60));

        roomcount31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roomcount31.setText("45");
        panel_Teachers.add(roomcount31, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, 60, 30));

        Count_title30.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title30.setForeground(new java.awt.Color(33, 173, 178));
        Count_title30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title30.setText("Hall Types");
        panel_Teachers.add(Count_title30, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 70, 100, 20));

        jLabel140.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/counter4.png"))); // NOI18N
        jLabel140.setText("jLabel41");
        panel_Teachers.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 250, 80));

        lb_hold31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_literature_30px.png"))); // NOI18N
        panel_Teachers.add(lb_hold31, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 70, 60, 60));

        roomcount32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roomcount32.setText("45");
        panel_Teachers.add(roomcount32, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 90, 60, 30));

        Count_title31.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title31.setForeground(new java.awt.Color(33, 173, 178));
        Count_title31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title31.setText("Booked");
        panel_Teachers.add(Count_title31, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 60, 100, 40));

        jLabel141.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/count4.png"))); // NOI18N
        jLabel141.setText("jLabel41");
        panel_Teachers.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 60, 250, 80));

        table_holder_bg7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        table_holder_bg7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/display.png"))); // NOI18N
        panel_Teachers.add(table_holder_bg7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 140, 1130, 550));

        jLabel161.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel161.setForeground(new java.awt.Color(33, 173, 178));
        jLabel161.setText("  Teachers");
        panel_Teachers.add(jLabel161, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 160, 50));

        building_classes_panel.add(panel_Teachers, "card2");

        panel_Students.setBackground(new java.awt.Color(255, 255, 255));
        panel_Students.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Add_price1.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Add_price1.setForeground(new java.awt.Color(255, 255, 255));
        Add_price1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Add_price1.setText(" Student");
        Add_price1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_price1MouseClicked(evt);
            }
        });
        panel_Students.add(Add_price1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 560, 80, 50));

        edit10.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        edit10.setForeground(new java.awt.Color(255, 255, 255));
        edit10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_upload_to_ftp_30px.png"))); // NOI18N
        edit10.setText("Edit");
        panel_Students.add(edit10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 560, 90, 50));

        Delecte10.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte10.setForeground(new java.awt.Color(255, 255, 255));
        Delecte10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_no_entry_25px.png"))); // NOI18N
        Delecte10.setText("Delecte");
        panel_Students.add(Delecte10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 560, 80, 50));

        Delecte9.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte9.setForeground(new java.awt.Color(255, 255, 255));
        Delecte9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        Delecte9.setText("Delecte");
        panel_Students.add(Delecte9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 540, 340, 80));

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));
        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel209.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel209.setForeground(new java.awt.Color(102, 102, 102));
        jLabel209.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel209.setText("  GRADE/CLASS");
        jPanel35.add(jLabel209, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 140, 50));

        jLabel213.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel213.setForeground(new java.awt.Color(102, 102, 102));
        jLabel213.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel213.setText("NAME");
        jPanel35.add(jLabel213, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 150, 40));

        jLabel214.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel214.setForeground(new java.awt.Color(102, 102, 102));
        jLabel214.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel214.setText("  GENDER");
        jPanel35.add(jLabel214, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 120, 50));

        jLabel215.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel215.setForeground(new java.awt.Color(102, 102, 102));
        jLabel215.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel215.setText("  AGE");
        jPanel35.add(jLabel215, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 120, 40));

        jLabel216.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel216.setForeground(new java.awt.Color(102, 102, 102));
        jLabel216.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel216.setText("  D.O.B");
        jPanel35.add(jLabel216, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 100, 50));

        panel_Students.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 890, 50));

        Students_Table_display.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Students_Table_display.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Students_Table_display.setGridColor(new java.awt.Color(255, 255, 255));
        Students_Table_display.setIntercellSpacing(new java.awt.Dimension(20, 5));
        Students_Table_display.setRowHeight(30);
        Students_Table_display.setTableHeader(null);
        jScrollPane25.setViewportView(Students_Table_display);

        panel_Students.add(jScrollPane25, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 890, 360));

        table_holder_bg8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        table_holder_bg8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/display.png"))); // NOI18N
        panel_Students.add(table_holder_bg8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1130, 550));

        jLabel159.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel159.setForeground(new java.awt.Color(33, 173, 178));
        jLabel159.setText("STUDENT");
        panel_Students.add(jLabel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 160, 50));

        building_classes_panel.add(panel_Students, "card2");

        panal_Subjects.setBackground(new java.awt.Color(255, 255, 255));
        panal_Subjects.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_hold36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_condo_30px.png"))); // NOI18N
        panal_Subjects.add(lb_hold36, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 60, 60));

        total_numberOF_subjects.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        total_numberOF_subjects.setForeground(new java.awt.Color(153, 153, 153));
        total_numberOF_subjects.setText("45");
        panal_Subjects.add(total_numberOF_subjects, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 90, 30));

        Count_title36.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title36.setForeground(new java.awt.Color(33, 173, 178));
        Count_title36.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Count_title36.setText("   Subjects");
        panal_Subjects.add(Count_title36, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 100, 20));

        jLabel155.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/counters.png"))); // NOI18N
        panal_Subjects.add(jLabel155, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 260, 80));

        lb_hold37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Escalator_Down_30px.png"))); // NOI18N
        panal_Subjects.add(lb_hold37, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 60, 60));

        total_4Secondary.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        total_4Secondary.setForeground(new java.awt.Color(153, 153, 153));
        total_4Secondary.setText("45");
        panal_Subjects.add(total_4Secondary, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 100, 30));

        Count_title37.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title37.setForeground(new java.awt.Color(33, 173, 178));
        Count_title37.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Count_title37.setText("  Secondary");
        panal_Subjects.add(Count_title37, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 100, 20));

        Count_title44.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title44.setForeground(new java.awt.Color(33, 173, 178));
        Count_title44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title44.setText("Options");
        panal_Subjects.add(Count_title44, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 60, 100, 20));

        jLabel156.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/counter1.png"))); // NOI18N
        jLabel156.setText("jLabel41");
        panal_Subjects.add(jLabel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 250, 80));

        lb_hold38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_direction_30px.png"))); // NOI18N
        panal_Subjects.add(lb_hold38, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, 60, 60));

        Primary_lb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Primary_lb.setForeground(new java.awt.Color(153, 153, 153));
        Primary_lb.setText("45");
        panal_Subjects.add(Primary_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 80, 70, 30));

        Count_title38.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title38.setForeground(new java.awt.Color(33, 173, 178));
        Count_title38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title38.setText("Primary ");
        panal_Subjects.add(Count_title38, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, 100, 20));

        lb_hold39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_literature_30px.png"))); // NOI18N
        panal_Subjects.add(lb_hold39, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 60, 60, 60));

        jLabel157.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/counter4.png"))); // NOI18N
        jLabel157.setText("jLabel41");
        panal_Subjects.add(jLabel157, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, 250, 80));

        options_lb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        options_lb.setForeground(new java.awt.Color(153, 153, 153));
        options_lb.setText("45");
        panal_Subjects.add(options_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 80, 60, 30));

        jLabel158.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/counter2.png"))); // NOI18N
        jLabel158.setText("jLabel41");
        panal_Subjects.add(jLabel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 50, 250, 80));

        main_subjects.setBackground(new java.awt.Color(255, 255, 255));
        main_subjects.setLayout(new java.awt.CardLayout());

        Subject_list.setBackground(new java.awt.Color(255, 255, 255));
        Subject_list.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        class_level1.setForeground(new java.awt.Color(102, 102, 102));
        class_level1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Secondary", "Primary", "ALL" }));
        Subject_list.add(class_level1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 150, 130, 30));

        level_change1.setForeground(new java.awt.Color(102, 102, 102));
        level_change1.setText("OK");
        level_change1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level_change1ActionPerformed(evt);
            }
        });
        Subject_list.add(level_change1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 150, -1, 30));

        Delecte19.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte19.setForeground(new java.awt.Color(255, 255, 255));
        Delecte19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_no_entry_25px.png"))); // NOI18N
        Delecte19.setText("Delecte");
        Delecte19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Delecte19MouseClicked(evt);
            }
        });
        Subject_list.add(Delecte19, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, -1, 50));

        edit21.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        edit21.setForeground(new java.awt.Color(255, 255, 255));
        edit21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_upload_to_ftp_30px.png"))); // NOI18N
        edit21.setText("Edit");
        edit21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edit21MouseClicked(evt);
            }
        });
        Subject_list.add(edit21, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, 90, 50));

        Add_PaidServices.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Add_PaidServices.setForeground(new java.awt.Color(255, 255, 255));
        Add_PaidServices.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Add_PaidServices.setText("  Subject");
        Add_PaidServices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_PaidServicesMouseClicked(evt);
            }
        });
        Subject_list.add(Add_PaidServices, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 460, 100, 50));

        Delecte20.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte20.setForeground(new java.awt.Color(255, 255, 255));
        Delecte20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        Delecte20.setText("Delecte");
        Subject_list.add(Delecte20, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, 360, 80));

        Subjects_Table_display.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Subjects_Table_display.setForeground(new java.awt.Color(102, 102, 102));
        Subjects_Table_display.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Subjects_Table_display.setGridColor(new java.awt.Color(255, 255, 255));
        Subjects_Table_display.setIntercellSpacing(new java.awt.Dimension(20, 5));
        Subjects_Table_display.setRowHeight(30);
        Subjects_Table_display.setTableHeader(null);
        jScrollPane24.setViewportView(Subjects_Table_display);

        Subject_list.add(jScrollPane24, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 680, 370));

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));
        jPanel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel210.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel210.setForeground(new java.awt.Color(102, 102, 102));
        jLabel210.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel210.setText("SUBJECT");
        jPanel34.add(jLabel210, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 40));

        jLabel211.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel211.setForeground(new java.awt.Color(102, 102, 102));
        jLabel211.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel211.setText("SUBJECT STATUS");
        jPanel34.add(jLabel211, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 150, 50));

        jLabel212.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel212.setForeground(new java.awt.Color(102, 102, 102));
        jLabel212.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel212.setText("SUBJECT TYPE");
        jPanel34.add(jLabel212, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 140, 50));

        Subject_list.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 680, 50));

        jLabel55.setForeground(new java.awt.Color(102, 102, 102));
        jLabel55.setText("subject list by selecting and pressing ok");
        Subject_list.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 100, -1, 50));

        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Show only One  class level on the ");
        Subject_list.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 80, -1, 50));

        table_holder_bg14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        table_holder_bg14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/display.png"))); // NOI18N
        Subject_list.add(table_holder_bg14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 550));

        jLabel50.setText("Show only One  class level on the ");
        Subject_list.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 70, -1, 50));

        main_subjects.add(Subject_list, "card8");

        subject_entry.setBackground(new java.awt.Color(255, 255, 255));
        subject_entry.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel154.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel154.setForeground(new java.awt.Color(33, 173, 178));
        jLabel154.setText("Subject Entry");
        subject_entry.add(jLabel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 170, 40));

        Count_title39.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title39.setForeground(new java.awt.Color(255, 255, 255));
        Count_title39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_30px.png"))); // NOI18N
        Count_title39.setText("SUBJECT LIST");
        Count_title39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Count_title39MouseClicked(evt);
            }
        });
        subject_entry.add(Count_title39, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 70, 190, 60));

        combAp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Optional", "Compulsory" }));
        subject_entry.add(combAp, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 180, 280, 30));

        CombSu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Natural", "Pure", "Art", "Business", "2044", "2046", " " }));
        subject_entry.add(CombSu, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 260, 280, 30));
        subject_entry.add(txtNa, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 340, 280, 40));

        Reload.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Reload.setForeground(new java.awt.Color(102, 102, 102));
        Reload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_submit_progress_25px.png"))); // NOI18N
        Reload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReloadMouseClicked(evt);
            }
        });
        subject_entry.add(Reload, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 180, 70, 30));

        Update.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Update.setForeground(new java.awt.Color(102, 102, 102));
        Update.setText("  Update");
        Update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateMouseClicked(evt);
            }
        });
        subject_entry.add(Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 420, 80, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Subject Name");
        subject_entry.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, 170, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Save");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        subject_entry.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 400, 80, 70));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("belong to before you create the subject.");
        subject_entry.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 240, 40));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(102, 102, 102));
        jLabel33.setText("Select the class level  to which the  subjects will ");
        subject_entry.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 280, 40));

        level_change.setText("Revert To");
        level_change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level_changeActionPerformed(evt);
            }
        });
        subject_entry.add(level_change, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, -1, 30));

        class_level.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Secondary", "Primary" }));
        subject_entry.add(class_level, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 180, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Subject Application");
        subject_entry.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, 130, 40));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(102, 102, 102));
        jLabel36.setText("Subject Type");
        subject_entry.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, 150, 30));

        background.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/Untitled-2.png"))); // NOI18N
        subject_entry.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1160, 470));

        main_subjects.add(subject_entry, "card3");

        panal_Subjects.add(main_subjects, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1140, 560));

        building_classes_panel.add(panal_Subjects, "card8");

        panel_Class_builder.setBackground(new java.awt.Color(255, 255, 255));
        panel_Class_builder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Subjects");
        panel_Class_builder.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 600, 80, -1));

        organizer.setBackground(new java.awt.Color(255, 255, 255));
        organizer.setLayout(new java.awt.CardLayout());

        Teachers_list_view.setBackground(new java.awt.Color(255, 255, 255));
        Teachers_list_view.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel66.setFont(new java.awt.Font("Trebuchet MS", 2, 12)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(204, 204, 204));
        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Search_15px.png"))); // NOI18N
        jLabel66.setText("  Search");
        Teachers_list_view.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 50, 80, 30));

        search_employes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search_employesKeyTyped(evt);
            }
        });
        Teachers_list_view.add(search_employes, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 50, 200, 30));

        TeacherAssignment_Table_display.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TeacherAssignment_Table_display.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TeacherAssignment_Table_display.setGridColor(new java.awt.Color(255, 255, 255));
        TeacherAssignment_Table_display.setIntercellSpacing(new java.awt.Dimension(20, 5));
        TeacherAssignment_Table_display.setRowHeight(30);
        TeacherAssignment_Table_display.setTableHeader(null);
        TeacherAssignment_Table_display.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TeacherAssignment_Table_displayMouseClicked(evt);
            }
        });
        jScrollPane27.setViewportView(TeacherAssignment_Table_display);

        Teachers_list_view.add(jScrollPane27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 1090, 320));

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel222.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel222.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel222.setText("  Designation");
        jPanel37.add(jLabel222, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 20, 150, 30));

        jLabel223.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel223.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel223.setText("First Name");
        jPanel37.add(jLabel223, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 150, 30));

        jLabel224.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel224.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel224.setText("  Surname");
        jPanel37.add(jLabel224, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 150, 30));

        jLabel225.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel225.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel225.setText("  ID Number");
        jPanel37.add(jLabel225, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 150, 30));

        jLabel226.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel226.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel226.setText("  Departments");
        jPanel37.add(jLabel226, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 150, 30));

        jLabel227.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel227.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel227.setText("  Designation");
        jPanel37.add(jLabel227, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, 150, 30));

        Teachers_list_view.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1090, 50));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText(" Teachers with Classes");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });
        Teachers_list_view.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 160, 60));

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel43.setText("    All");
        jLabel43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel43MouseClicked(evt);
            }
        });
        Teachers_list_view.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 70, 60));

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText(" Teachers With No Classes");
        jLabel45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel45MouseClicked(evt);
            }
        });
        Teachers_list_view.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 190, 60));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/Untitled-2.png"))); // NOI18N
        Teachers_list_view.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(-130, 0, 1270, 510));

        organizer.add(Teachers_list_view, "card2");

        Teacher_Subject_Add.setBackground(new java.awt.Color(255, 255, 255));
        Teacher_Subject_Add.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        level_change2.setBackground(new Color(255,255,255,30));
        level_change2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        level_change2.setForeground(new java.awt.Color(102, 102, 102));
        level_change2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Search_15px.png"))); // NOI18N
        level_change2.setText("View ");
        level_change2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level_change2ActionPerformed(evt);
            }
        });
        Teacher_Subject_Add.add(level_change2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, 90, 30));

        combAp1.setBackground(new Color(255,255,255,30));
        combAp1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        combAp1.setForeground(new java.awt.Color(102, 102, 102));
        combAp1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Compulsory", "Optional", " " }));
        Teacher_Subject_Add.add(combAp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 110, 30));

        GetClass_id.setBackground(new Color(255,255,255,10));
        GetClass_id.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        GetClass_id.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        GetClass_id.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GetClass_idMouseClicked(evt);
            }
        });
        GetClass_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GetClass_idActionPerformed(evt);
            }
        });
        Teacher_Subject_Add.add(GetClass_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 270, 40));

        jLabel27.setForeground(new java.awt.Color(153, 153, 153));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_update_25px.png"))); // NOI18N
        jLabel27.setText("UNASSIGN ");
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });
        Teacher_Subject_Add.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, 120, 50));

        AssigningSubjects_withTeacherID.setBackground(new Color(255,255,255,10));
        AssigningSubjects_withTeacherID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AssigningSubjects_withTeacherID.setForeground(new java.awt.Color(102, 102, 102));
        AssigningSubjects_withTeacherID.setText("ASSIGN ");
        AssigningSubjects_withTeacherID.setBorder(null);
        AssigningSubjects_withTeacherID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AssigningSubjects_withTeacherIDActionPerformed(evt);
            }
        });
        Teacher_Subject_Add.add(AssigningSubjects_withTeacherID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 90, 30));

        counter.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        counter.setForeground(new java.awt.Color(153, 153, 153));
        Teacher_Subject_Add.add(counter, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 450, 450, 30));

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("Handler Class As");
        Teacher_Subject_Add.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 190, 50));

        jPanel12.setBackground(new java.awt.Color(66, 66, 66));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel51.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(161, 169, 171));
        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        jLabel51.setText("Person Info :");
        jPanel12.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        name.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        name.setForeground(new java.awt.Color(110, 156, 182));
        name.setText("Profession");
        jPanel12.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 150, 40));

        contact.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        contact.setForeground(new java.awt.Color(110, 156, 182));
        contact.setText("Contact");
        jPanel12.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 90, 40));

        email.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        email.setForeground(new java.awt.Color(110, 156, 182));
        email.setText("Email");
        jPanel12.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 190, 40));

        lb_major3.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        lb_major3.setForeground(new java.awt.Color(110, 156, 182));
        lb_major3.setText("SUBJECT");
        jPanel12.add(lb_major3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 0, 100, 40));

        jLabel62.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(161, 169, 171));
        jLabel62.setText("MAJOR IN :");
        jPanel12.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 70, 40));

        lb_major1.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        lb_major1.setForeground(new java.awt.Color(110, 156, 182));
        lb_major1.setText("SUBJECT");
        jPanel12.add(lb_major1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 100, 40));

        lb_major2.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        lb_major2.setForeground(new java.awt.Color(110, 156, 182));
        lb_major2.setText("SUBJECT");
        jPanel12.add(lb_major2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 70, 40));

        Qualification.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        Qualification.setForeground(new java.awt.Color(110, 156, 182));
        Qualification.setText("Qualification");
        jPanel12.add(Qualification, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 90, 40));

        Qualification1.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        Qualification1.setForeground(new java.awt.Color(161, 169, 171));
        Qualification1.setText("Qualification:");
        jPanel12.add(Qualification1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 100, 40));

        Teacher_Subject_Add.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1200, 40));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("Class Selection");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 180, 44));

        jLabel25.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(153, 153, 153));
        jLabel25.setText("Subject  List");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 160, 40));

        Teacher_Subject_Add.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1140, 60));

        jScrollPane6.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane6.setWheelScrollingEnabled(false);

        Assigned_subject.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        Assigned_subject.setForeground(new java.awt.Color(162, 161, 161));
        Assigned_subject.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        Assigned_subject.setAutoscrolls(false);
        Assigned_subject.setIntercellSpacing(new java.awt.Dimension(25, 10));
        Assigned_subject.setRowHeight(40);
        Assigned_subject.setShowHorizontalLines(false);
        Assigned_subject.setShowVerticalLines(false);
        Assigned_subject.setTableHeader(null);
        Assigned_subject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Assigned_subjectMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(Assigned_subject);

        Teacher_Subject_Add.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, 430, 260));

        Teacher_Handlier.setBackground(new Color(255,255,255,10));
        Teacher_Handlier.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        Teacher_Handlier.setForeground(new java.awt.Color(153, 153, 153));
        Teacher_Handlier.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Subject Teacher", "Class Teacher", " " }));
        Teacher_Handlier.setBorder(null);
        Teacher_Handlier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Teacher_HandlierMouseClicked(evt);
            }
        });
        Teacher_Handlier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Teacher_HandlierActionPerformed(evt);
            }
        });
        Teacher_Subject_Add.add(Teacher_Handlier, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 270, 40));

        jLabel29.setForeground(new java.awt.Color(153, 153, 153));
        jLabel29.setText("View subjects in the Selected Class by Pressing View ");
        Teacher_Subject_Add.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 300, 50));

        lb_GB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_GB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/Untitled-2.png"))); // NOI18N
        Teacher_Subject_Add.add(lb_GB, new org.netbeans.lib.awtextra.AbsoluteConstraints(-120, -50, 1282, 640));
        Teacher_Subject_Add.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 180, -1));

        organizer.add(Teacher_Subject_Add, "card3");

        panel_Class_builder.add(organizer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 500));

        jLabel18.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/back.png"))); // NOI18N
        jLabel18.setText("  Back");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        panel_Class_builder.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, 100, 60));

        building_classes_panel.add(panel_Class_builder, "card2");

        Add_Students_ToClasses.setBackground(new java.awt.Color(255, 255, 255));
        Add_Students_ToClasses.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(66, 66, 66));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel53.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(161, 169, 171));
        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        jLabel53.setText(" Class Teacher :");
        jPanel14.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 40));

        Teacherlb.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        Teacherlb.setForeground(new java.awt.Color(110, 156, 182));
        Teacherlb.setText("Profession");
        jPanel14.add(Teacherlb, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 200, 40));

        jLabel78.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(161, 169, 171));
        jLabel78.setText("Year :");
        jPanel14.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 70, 40));

        Yearlb.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        Yearlb.setForeground(new java.awt.Color(110, 156, 182));
        Yearlb.setText("SUBJECT");
        jPanel14.add(Yearlb, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 90, 40));

        Capacitylb.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        Capacitylb.setForeground(new java.awt.Color(110, 156, 182));
        Capacitylb.setText("SUBJECT");
        jPanel14.add(Capacitylb, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 100, 40));

        Classlb.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        Classlb.setForeground(new java.awt.Color(110, 156, 182));
        Classlb.setText("Qualification");
        jPanel14.add(Classlb, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 90, 40));

        Qualification5.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        Qualification5.setForeground(new java.awt.Color(161, 169, 171));
        Qualification5.setText("Class Capacity:");
        jPanel14.add(Qualification5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 100, 40));

        Qualification6.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        Qualification6.setForeground(new java.awt.Color(161, 169, 171));
        Qualification6.setText("Class :");
        jPanel14.add(Qualification6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 100, 40));

        jLabel69.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(161, 169, 171));
        jLabel69.setText("View");
        jLabel69.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel69MouseClicked(evt);
            }
        });
        jPanel14.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 0, 140, 40));

        Add_Students_ToClasses.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1200, 40));

        StudentsAssignment_Table_display.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        StudentsAssignment_Table_display.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        StudentsAssignment_Table_display.setGridColor(new java.awt.Color(255, 255, 255));
        StudentsAssignment_Table_display.setIntercellSpacing(new java.awt.Dimension(20, 5));
        StudentsAssignment_Table_display.setRowHeight(30);
        StudentsAssignment_Table_display.setTableHeader(null);
        StudentsAssignment_Table_display.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StudentsAssignment_Table_displayMouseClicked(evt);
            }
        });
        jScrollPane28.setViewportView(StudentsAssignment_Table_display);

        Add_Students_ToClasses.add(jScrollPane28, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 970, 460));

        jLabel79.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setText("Gender");
        Add_Students_ToClasses.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, 90, 50));

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(110, 156, 182));
        jLabel65.setText("Waiting List");
        Add_Students_ToClasses.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 120, 60));

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("Age");
        Add_Students_ToClasses.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 90, 50));

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_30px.png"))); // NOI18N
        jLabel64.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel64MouseClicked(evt);
            }
        });
        Add_Students_ToClasses.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 640, 90, 60));

        jLabel70.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setText("Date of Birth");
        Add_Students_ToClasses.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 130, 90, 50));

        jLabel72.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setText("Student ID");
        Add_Students_ToClasses.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 90, 50));

        jLabel77.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setText("Name");
        Add_Students_ToClasses.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 90, 50));

        lb_Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_submit_progress_25px.png"))); // NOI18N
        lb_Search.setText("  Search");
        Add_Students_ToClasses.add(lb_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 60, 100, 30));
        Add_Students_ToClasses.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 60, 220, 30));

        jLabel71.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Escrow_Process_45px.png"))); // NOI18N
        jLabel71.setText("  Assign ");
        jLabel71.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel71MouseClicked(evt);
            }
        });
        Add_Students_ToClasses.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 570, 140, 70));

        image_viewer.setText("jLabel13");
        Add_Students_ToClasses.add(image_viewer, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 180, 190, 180));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/add_Room_typebg.png"))); // NOI18N
        Add_Students_ToClasses.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 90, 1190, 660));

        building_classes_panel.add(Add_Students_ToClasses, "card2");

        javax.swing.GroupLayout pExpensesLayout = new javax.swing.GroupLayout(pExpenses);
        pExpenses.setLayout(pExpensesLayout);
        pExpensesLayout.setHorizontalGroup(
            pExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        pExpensesLayout.setVerticalGroup(
            pExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );

        building_classes_panel.add(pExpenses, "card2");

        View_class_panel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout View_class_panelLayout = new javax.swing.GroupLayout(View_class_panel);
        View_class_panel.setLayout(View_class_panelLayout);
        View_class_panelLayout.setHorizontalGroup(
            View_class_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        View_class_panelLayout.setVerticalGroup(
            View_class_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );

        building_classes_panel.add(View_class_panel, "card2");

        Popup_class_selection.setBackground(new Color(66,66,66,50));
        Popup_class_selection.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Popup_class_selection.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 760, 10));

        jLabel57.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_person_30px.png"))); // NOI18N
        jLabel57.setText("  Class Teacher      :");
        Popup_class_selection.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 210, 30));

        jLabel80.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_adobe_lightroom_30px.png"))); // NOI18N
        jLabel80.setText("  Class                 :");
        Popup_class_selection.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 180, 30));

        jLabel61.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_direction_30px.png"))); // NOI18N
        jLabel61.setText(" Close Class Selection");
        Popup_class_selection.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 460, 240, 70));

        jLabel60.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_octahedron_30px.png"))); // NOI18N
        jLabel60.setText("  Current Space    :");
        Popup_class_selection.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 400, 180, 30));

        jLabel67.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_increase_profits_30px.png"))); // NOI18N
        jLabel67.setText("  Capacity");
        Popup_class_selection.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 340, 130, 30));

        jLabel68.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_calendar_6_30px.png"))); // NOI18N
        jLabel68.setText("  year");
        Popup_class_selection.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 410, 130, 30));

        lbyear.setBackground(new Color(77,77,77,5));
        lbyear.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        lbyear.setForeground(new java.awt.Color(255, 255, 255));
        lbyear.setText("Year");
        Popup_class_selection.add(lbyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 410, 110, 30));

        lbcapacity.setBackground(new Color(77,77,77,5));
        lbcapacity.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        lbcapacity.setForeground(new java.awt.Color(255, 255, 255));
        lbcapacity.setText("C");
        Popup_class_selection.add(lbcapacity, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 340, 120, 30));

        lbspace.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        lbspace.setForeground(new java.awt.Color(255, 255, 255));
        lbspace.setText("Cc");
        Popup_class_selection.add(lbspace, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, 150, 30));

        lbclass.setBackground(new Color(77,77,77,5));
        lbclass.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        lbclass.setForeground(new java.awt.Color(255, 255, 255));
        lbclass.setText("Class");
        Popup_class_selection.add(lbclass, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, 130, 30));

        lbname.setBackground(new Color(77,77,77,5));
        lbname.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        lbname.setForeground(new java.awt.Color(255, 255, 255));
        lbname.setText("Name                                            Surname");
        Popup_class_selection.add(lbname, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 380, 30));

        jLabel56.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_verified_account_30px.png"))); // NOI18N
        jLabel56.setText("  Add Students");
        jLabel56.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel56MouseClicked(evt);
            }
        });
        Popup_class_selection.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 460, 180, 60));

        comb_classes.setBackground(new Color(255,255,255,10));
        comb_classes.setFont(new java.awt.Font("Trebuchet MS", 2, 14)); // NOI18N
        comb_classes.setForeground(new java.awt.Color(255, 255, 255));
        comb_classes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None" }));
        comb_classes.setBorder(null);
        comb_classes.setOpaque(false);
        comb_classes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comb_classesActionPerformed(evt);
            }
        });
        Popup_class_selection.add(comb_classes, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 210, 160, 40));

        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_in_progress_30px_1.png"))); // NOI18N
        jLabel58.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel58MouseClicked(evt);
            }
        });
        Popup_class_selection.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 200, 70, 60));

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/class_info.png"))); // NOI18N
        jLabel47.setText("jLabel47");
        Popup_class_selection.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(-220, 170, 1350, 570));

        building_classes_panel.add(Popup_class_selection, "card10");

        panel_cover.setBackground(new java.awt.Color(255, 255, 255));
        panel_cover.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        counter_view1.setText("Number of teachers");
        panel_cover.add(counter_view1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 130, 20));

        counter_view2.setText("Number of classes");
        panel_cover.add(counter_view2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 580, 130, 20));

        counter_view3.setText("Number of subjects");
        panel_cover.add(counter_view3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 550, 110, 30));

        counter_view4.setText("00");
        panel_cover.add(counter_view4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 570, 110, 40));

        counter_view5.setText("00");
        panel_cover.add(counter_view5, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 550, 110, 30));

        counter_view6.setText("00");
        panel_cover.add(counter_view6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 110, 20));

        counter_view7.setText("Registered Students");
        panel_cover.add(counter_view7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, 150, 30));

        counter_view8.setText("00");
        panel_cover.add(counter_view8, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 220, 130, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_business_building_100px.png"))); // NOI18N
        jLabel2.setText("TEACHERS");
        panel_cover.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 190, 100));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_book_reading_100px.png"))); // NOI18N
        jLabel3.setText("   SUBJECTS");
        panel_cover.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 440, 200, 90));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_student_male_100px.png"))); // NOI18N
        jLabel4.setText(" STUDENTS");
        panel_cover.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 100, 190, 110));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_apartment_100px.png"))); // NOI18N
        jLabel1.setText("CLASSES");
        panel_cover.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, 190, 100));

        create.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/Counter.png"))); // NOI18N
        create.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createMouseClicked(evt);
            }
        });
        panel_cover.add(create, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, -1, -1));

        create1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/Counter.png"))); // NOI18N
        create1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                create1MouseClicked(evt);
            }
        });
        panel_cover.add(create1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

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

        building_classes_panel.add(panel_cover, "card2");

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

    private void hotel_maMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hotel_maMouseClicked
        panel_cover.hide();
        panel_Teachers.hide();
        panel_Students.hide();
        panel_Class_builder.hide();
        Add_Students_ToClasses.hide();
        pExpenses.setVisible(true);
        View_class_panel.hide();
    }//GEN-LAST:event_hotel_maMouseClicked

    private void hotel_maMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hotel_maMouseEntered
        hotel_ma.setBackground(new Color(33, 173, 178));
    }//GEN-LAST:event_hotel_maMouseEntered

    private void hotel_maMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hotel_maMouseExited
        hotel_ma.setBackground(new Color(121,119,119));
    }//GEN-LAST:event_hotel_maMouseExited

    private void calenderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calenderMouseClicked

        panel_cover.hide();

        panel_Students.hide();
        panel_Class_builder.hide();
        panal_Subjects.hide();
        Add_Students_ToClasses.hide();
        pExpenses.hide();
        View_class_panel.hide();
        panel_Teachers.setVisible(true);
    }//GEN-LAST:event_calenderMouseClicked

    private void calenderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calenderMouseEntered
        calender.setBackground(new Color(33, 173, 178));
    }//GEN-LAST:event_calenderMouseEntered

    private void calenderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calenderMouseExited
        calender.setBackground(new Color(121,119,119));
    }//GEN-LAST:event_calenderMouseExited

    private void admin_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btnMouseClicked
        if (!panel_cover.isShowing()) {

            panel_cover.setVisible(true);
            panel_Teachers.hide();
            panel_Students.hide();
            panel_Class_builder.hide();
            panal_Subjects.hide();
            Add_Students_ToClasses.hide();
            pExpenses.hide();
            View_class_panel.hide();
        } else {
            this.dispose();
            Admin_Home.getObj().setVisible(true);

        }

    }//GEN-LAST:event_admin_btnMouseClicked

    private void admin_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btnMouseEntered
     admin_btn.setBackground(new Color(121,119,119));

    }//GEN-LAST:event_admin_btnMouseEntered

    private void admin_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btnMouseExited
    admin_btn.setBackground(new Color(121,119,119));
    }//GEN-LAST:event_admin_btnMouseExited

    private void expensesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expensesMouseClicked
        panel_cover.hide();
        panel_Teachers.hide();
        panel_Students.hide();
        panel_Class_builder.hide();
        panal_Subjects.hide();
        Add_Students_ToClasses.hide();
        //  Add_Students_ToClasses.setVisible(true);
        Popup_class_selection.setVisible(true);
        pExpenses.hide();
        View_class_panel.hide();
    }//GEN-LAST:event_expensesMouseClicked

    private void expensesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expensesMouseEntered
        expenses.setBackground(new Color(33, 173, 178));
    }//GEN-LAST:event_expensesMouseEntered

    private void expensesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expensesMouseExited
        expenses.setBackground(new Color(121,119,119));
    }//GEN-LAST:event_expensesMouseExited

    private void archived_bookingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_archived_bookingMouseClicked
        panel_cover.hide();
        panel_Students.hide();
        panal_Subjects.hide();

        panel_Class_builder.hide();
        Add_Students_ToClasses.hide();
        pExpenses.hide();
        View_class_panel.hide();
        panal_Subjects.setVisible(true);

    }//GEN-LAST:event_archived_bookingMouseClicked

    private void archived_bookingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_archived_bookingMouseEntered
        archived_booking.setBackground(new Color(33, 173, 178));
    }//GEN-LAST:event_archived_bookingMouseEntered

    private void archived_bookingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_archived_bookingMouseExited
        archived_booking.setBackground(new Color(121,119,119));
    }//GEN-LAST:event_archived_bookingMouseExited

    private void CMSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMSMouseClicked
        panel_cover.hide();
        panel_Teachers.hide();
        panel_Students.hide();

        Add_Students_ToClasses.hide();
        panal_Subjects.hide();
        pExpenses.hide();
        View_class_panel.hide();
        panel_Class_builder.setVisible(true);
    }//GEN-LAST:event_CMSMouseClicked

    private void CMSMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMSMouseEntered
        CMS.setBackground(new Color(33, 173, 178));
    }//GEN-LAST:event_CMSMouseEntered

    private void CMSMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMSMouseExited
        CMS.setBackground(new Color(121,119,119));
    }//GEN-LAST:event_CMSMouseExited

    private void Tex_manager_lbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tex_manager_lbMouseClicked
        panel_cover.hide();
        panel_Teachers.hide();

        panal_Subjects.hide();
        panel_Class_builder.hide();
        Add_Students_ToClasses.hide();
        pExpenses.hide();
        View_class_panel.hide();
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

    private void Add_PaidServicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_PaidServicesMouseClicked
        Subject_list.hide();
        subject_entry.setVisible(true);

    }//GEN-LAST:event_Add_PaidServicesMouseClicked

    private void Count_title39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Count_title39MouseClicked
        Subject_list.setVisible(true);
        subject_entry.hide();
    }//GEN-LAST:event_Count_title39MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked

        try {
           conn = DBConnection.getConnction();
            String sql = "INSERT INTO subjects (subject_name,subject_application, subject_type,class_level) VALUES (?,?,?,?)";
            pps5 = conn.prepareStatement(sql);
            pps5.setString(1, txtNa.getText().trim());
            pps5.setString(2, combAp.getSelectedItem().toString().trim());
            pps5.setString(3, CombSu.getSelectedItem().toString().trim());
            pps5.setString(4, class_level.getSelectedItem().toString().trim());

            pps5.executeUpdate();
            combAp.setSelectedIndex(0);
            CombSu.setSelectedIndex(0);
            class_level.setSelectedIndex(0);

            txtNa.setText(null);
            JOptionPane.showMessageDialog(null, "Successfully Saved");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        // assigning_subjectsToteacher();//showing update o combo

        ShowRoomType_onTable();

    }//GEN-LAST:event_jLabel8MouseClicked

    private void Add_price1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_price1MouseClicked
        // taking the user to the registration form
        Adminstrative ad = new Adminstrative();
        this.dispose();
        ad.setVisible(true);
    }//GEN-LAST:event_Add_price1MouseClicked

    private void edit21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit21MouseClicked
        DisplayingContent();//getting id method
        Subject_list.hide();
        subject_entry.setVisible(true);
    }//GEN-LAST:event_edit21MouseClicked

    private void Delecte19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Delecte19MouseClicked
        DisplayingContent();

        try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("DELETE  FROM subjects WHERE subject_id = ?");
            pps.setString(1, gettingIDof_SelectedSubject);
            pps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        ShowRoomType_onTable(); //displaying changes on the table


    }//GEN-LAST:event_Delecte19MouseClicked

    private void UpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseClicked
        // updating
        try {
           conn = DBConnection.getConnction();
            String sql = "UPDATE  subjects  SET subject_name =?,subject_application=?, subject_type =? , class_level=? WHERE subject_id = ?";
            pps = conn.prepareStatement(sql);
            pps.setString(1, txtNa.getText());
            pps.setString(2, combAp.getSelectedItem().toString().trim());
            pps.setString(3, CombSu.getSelectedItem().toString().trim());
            pps.setString(4, class_level.getSelectedItem().toString().trim());
            pps.setString(5, gettingIDof_SelectedSubject);


            pps.executeUpdate();

            combAp.setSelectedIndex(0);
            CombSu.setSelectedIndex(0);
           class_level.setSelectedIndex(0);

            txtNa.setText(null);
            JOptionPane.showMessageDialog(null, "Successfully Saved");
            ShowRoomType_onTable();//show on tables fuction
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        ShowRoomType_onTable();

    }//GEN-LAST:event_UpdateMouseClicked

    private void ReloadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReloadMouseClicked
        CombSu.removeAllItems();
        combAp.removeAllItems();
        combAp.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Optional", "Compulsory"}));
        CombSu.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Naturaly", "Pure"}));


    }//GEN-LAST:event_ReloadMouseClicked

    
    private void TeacherAssignment_Table_displayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TeacherAssignment_Table_displayMouseClicked
        DefaultTableModel tableMode = (DefaultTableModel) TeacherAssignment_Table_display.getModel();
        Search_EmployeeID = tableMode.getValueAt(TeacherAssignment_Table_display.getSelectedRow(), 2).toString();
        teachers_info();

         Teachers_list_view.hide();
         Teacher_Subject_Add.setVisible(true);
         
    }//GEN-LAST:event_TeacherAssignment_Table_displayMouseClicked
  public void teachers_info(){
        try {// putting the major id from the subject the teacher can teacher and puttng them on resources
            conn = DBConnection.getConnction();
            String sql = "SELECT * FROM  employee WHERE  employeeid = ?";
            pps4 = conn.prepareStatement(sql);
            pps4.setString(1, Search_EmployeeID.trim());
            rs4 = pps4.executeQuery();
            while (rs4.next()) {
                String fname = rs4.getString("name");
                String lname = rs4.getString("surname");
                 Seleted_teacher = fname +"  "+ lname;
                name.setText(Seleted_teacher);
                contact.setText(rs4.getString("contact"));
                email.setText(rs4.getString("email"));
                Qualification.setText(rs4.getString("qualification"));
                 USer_login_id = rs4.getString("user_login_id");

            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
        
        
        
         try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("SELECT * FROM  employee_qualifications_major WHERE  user_login_id = ? ");
            pps.setString(1, USer_login_id);
            rs = pps.executeQuery();
            if (rs.next()) {
                //displaying them on the leb of teaher info
                lb_major1.setText(rs.getString("major_name"));
                rs.next();
                lb_major2.setText(rs.getString("major_name"));
                rs.next();
                lb_major3.setText(rs.getString("major_name"));

            }
            } catch (SQLException ex) {}
        
        
        
  
  }

     
    private void AssigningSubjects_withTeacherIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AssigningSubjects_withTeacherIDActionPerformed
     
        if (table_clicked.equals("none")) {
            JOptionPane.showMessageDialog(null, "Select the Subject");
            
        } else if (!table_clicked.equals("none")) {

            try {//GETTING CLASS ID 
                conn = DBConnection.getConnction();
                pps5 = conn.prepareStatement("SELECT * FROM  classes WHERE grade_room = ?");
                pps5.setString(1, GetClass_id.getSelectedItem().toString().substring(0, 3).trim());
                rs5 = pps5.executeQuery();
                if (rs5.next()) {
                    getclass_Id = rs5.getString("class_id");//puting id on the resource
                }
            } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

            try {  //GETTING THE SUBJECT ID 
                conn = DBConnection.getConnction();
                pps6 = conn.prepareStatement("SELECT * FROM subjects WHERE subject_name = ?");
                pps6.setString(1, table_clicked);
                rs6 = pps6.executeQuery();
                if (rs6.next()) {
                   getSubject_Id = rs6.getString("subject_id");
                }
            } catch (Exception ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
            
           
            
                //CHECKING IF THE SELECTED SUBJECT IS IN THE TEACHERS HANDLING TABLE       
        try {  //if the selected subject is not in the employee_qualifications_major
            conn = DBConnection.getConnction();
            String sql = "SELECT * FROM  employee_qualifications_major WHERE  user_login_id= ?  AND major_name = ?";
            pps10 = conn.prepareStatement(sql);
            pps10.setString(1, USer_login_id.trim());
            pps10.setString(2, table_clicked.trim());

            rs10 = pps10.executeQuery();
            if (rs10.next()) {  //if next then the teacher is qualified to teacher the selected subject
                Check_if_theRelation_Exists();
            }else{
             JOptionPane.showMessageDialog(null, Seleted_teacher +" is UnCertified");
            }
            
            } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

        }// close table check if clicked   
    }//GEN-LAST:event_AssigningSubjects_withTeacherIDActionPerformed
 
    public void Check_if_theRelation_Exists(){
              // SEARCH IF THE RELATION EXITS 
              int   Class = Integer.parseInt(getclass_Id);  //amount paid to the school
              int   subject = Integer.parseInt(getSubject_Id);  //amount paid to the school
              int   employee = Integer.parseInt(USer_login_id);  //amount paid to the school
            
            try {
                conn = DBConnection.getConnction();
                String sql = "SELECT  * FROM  class_subject_joint    WHERE class_id = ?  AND subject_id=? AND user_login_id IS NULL  OR 0"; 
                pps9 = conn.prepareStatement(sql);
                pps9.setInt(1, Class);
                pps9.setInt(2, subject);
                rs9 = pps9.executeQuery();
                if(rs9.next()){
                    Check_if_ClassTeacher_exists();
                }else{JOptionPane.showMessageDialog(null, "Subject Already Assigned");}
            } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);}
            
            
    }
    
    
     public void Check_if_ClassTeacher_exists(){
         
            int   employee = Integer.parseInt(USer_login_id);  //amount paid to the school
            
            try {
                conn = DBConnection.getConnction();
                String sql = "SELECT  * FROM  class_subject_joint    WHERE user_login_id = ?  AND teacher_state ='Class Teacher'"; 
                pps10 = conn.prepareStatement(sql);
                pps10.setInt(1, employee);
                rs10 = pps10.executeQuery();
                if(rs10.next()){
                 JOptionPane.showMessageDialog(null, "Teacher  " +Seleted_teacher+"  Already As A Class");
                }else{
                 update_joint_relation();

                }
            } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);}
         
     
     }
  
    
    public void update_joint_relation(){
                 // updating Relation 
                 int   employee = Integer.parseInt(USer_login_id);  //amount paid to the school
                 int   Class = Integer.parseInt(getclass_Id);  //amount paid to the school
                 int   subject = Integer.parseInt(getSubject_Id);  //amount paid to the school
                 try {
                 conn = DBConnection.getConnction();
                 String sql = "UPDATE  class_subject_joint  SET user_login_id =?, teacher_state =?   WHERE class_id = ?  AND subject_id=?";
                 pps7 = conn.prepareStatement(sql);
                 pps7.setInt(1, employee);
                 pps7.setString(2, Teacher_Handlier.getSelectedItem().toString().trim());
                 pps7.setInt(3, Class);
                 pps7.setInt(4, subject);
                 pps7.executeUpdate();
                JOptionPane.showMessageDialog(null, Seleted_teacher +" Is Now The Subject Teacher");
                } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
               }
    
    
            
                    try {
                    conn = DBConnection.getConnction();
                    String sql = "SELECT  employee.user_login_id,   classes.grade_room, COUNT(class_subject_joint.class_id)  AS subject_count FROM  class_subject_joint   INNER JOIN  subjects  ON  subjects.subject_id = class_subject_joint.subject_id      INNER JOIN employee ON  employee.user_login_id = class_subject_joint.user_login_id         INNER JOIN classes ON  classes.class_id = class_subject_joint.class_id   WHERE user_login_id =?  GROUP BY grade_room " ;
                    pps9 = conn.prepareStatement(sql);
                    pps9.setString(1, USer_login_id);
                    rs9 = pps9.executeQuery();
                  //  Assigned_subject.setf
                    Assigned_subject.setModel(DbUtils.resultSetToTableModel(rs9));
                    counter.setText("Subject Count  For Each Class Teacher  "  +  Seleted_teacher +"  Is Handling ");
                   } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
            
            
            
    }
    
 

    private void GetClass_idMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GetClass_idMouseClicked
        try {
            String Search_By_subjectid = GetClass_id.getSelectedItem().toString().trim();
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement(" SELECT * FROM  subjects WHERE subject_name = ?  ");
            pps.setString(1, Search_By_subjectid);
            rs = pps.executeQuery();
            if (rs.next()) {
                jTextField1.setText(rs.getString("subject_type"));
            } else {
                jTextField1.setText(null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_GetClass_idMouseClicked

    private void Teacher_HandlierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Teacher_HandlierMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Teacher_HandlierMouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked

        lb_major3.setText(null);
        lb_major2.setText(null);
        lb_major1.setText(null);

        Teacher_Subject_Add.hide();
        Teachers_list_view.setVisible(true);

    }//GEN-LAST:event_jLabel18MouseClicked

    

    private void jLabel45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseClicked
        String id = "202008";
        ///-----------------------------------------------------------------displying teachers on the table on class_assignment-----------------------------------------------------
        try {
            conn = DBConnection.getConnction();
            String sql = "SELECT employee.name,  employee.surname,employee.employeeid,  employee.department,  employee.designation, employee.qualification, classes.grade_room,  classes.room, classes.date FROM   classes  INNER JOIN  employee ON  classes.class_teacher_id  = employee.employeeid WHERE employee_id = ? ";
            pps5 = conn.prepareStatement(sql);
            pps5.setString(1, id);
            rs5 = pps5.executeQuery();
            TeacherAssignment_Table_display.setModel(DbUtils.resultSetToTableModel(rs5));

        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel45MouseClicked

    private void jLabel43MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel43MouseClicked
        ShowRoomType_onTable();
    }//GEN-LAST:event_jLabel43MouseClicked

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
       
       
        try {
            conn = DBConnection.getConnction();
            String sql = "SELECT employee.name,  employee.surname,employee.employeeid,  employee.department,  employee.designation,  employee.qualification, classes.grade,  classes.room, classes.date FROM   classes   INNER JOIN  employee ON  classes.class_teacher_id  = employee.employeeid";
            pps = conn.prepareStatement(sql);
            rs = pps.executeQuery();

            TeacherAssignment_Table_display.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jLabel56MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel56MouseClicked

        // assignToClass_count_students  
        int Students = Integer.parseInt(assignToClass_count_students);//converting students count to int

        int definespace = Integer.parseInt(room_capacity_AsDefined_space);//converting students count to int

        if (Students == definespace) {
             JOptionPane.showMessageDialog(null, "Class is full");
        } else if (definespace > Students) {
            panel_cover.hide();
            panel_Teachers.hide();
            panel_Students.hide();
            panel_Class_builder.hide();
            panal_Subjects.hide();
            Add_Students_ToClasses.hide();
            Popup_class_selection.hide();
            pExpenses.hide();
            View_class_panel.hide();
            Add_Students_ToClasses.setVisible(true);

        }



    }//GEN-LAST:event_jLabel56MouseClicked

    private void comb_classesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comb_classesActionPerformed
    }//GEN-LAST:event_comb_classesActionPerformed

    private void jLabel58MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel58MouseClicked
         showON_Combo_SelectedClassInfo();

    }//GEN-LAST:event_jLabel58MouseClicked

    private void StudentsAssignment_Table_displayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudentsAssignment_Table_displayMouseClicked
          DefaultTableModel tableMode = (DefaultTableModel) StudentsAssignment_Table_display.getModel();
           String SID = tableMode.getValueAt(StudentsAssignment_Table_display.getSelectedRow(), 1).toString();
           
            try {
            conn = DBConnection.getConnction();
           String sql = "SELECT * FROM students WHERE  Student_ID  = ?";
            
            pps = conn.prepareStatement(sql);  
            pps.setString(1, SID);
            rs = pps.executeQuery();
            
            byte[] image = null;
            
            while (rs.next()) {
            image = rs.getBytes("image");
            Image img = Toolkit.getDefaultToolkit().createImage(image);
            ImageIcon icon = new ImageIcon(img);
            image_viewer.setIcon(icon);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_StudentsAssignment_Table_displayMouseClicked

    private void jLabel64MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel64MouseClicked
        panel_cover.hide();
        panel_Teachers.hide();
        panel_Students.hide();
        panel_Class_builder.hide();
        panal_Subjects.hide();
        Add_Students_ToClasses.hide();
        Popup_class_selection.hide();
        pExpenses.hide();
        View_class_panel.hide();
        Popup_class_selection.setVisible(true);
    }//GEN-LAST:event_jLabel64MouseClicked

    private void jLabel71MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel71MouseClicked
        DefaultTableModel tableMode = (DefaultTableModel) StudentsAssignment_Table_display.getModel();
        String SearchID1 = tableMode.getValueAt(StudentsAssignment_Table_display.getSelectedRow(), 1).toString();

        try {

            conn = DBConnection.getConnction();
            String sql = "UPDATE  students  SET Student_Class = ? WHERE Student_ID =?";
            pps = conn.prepareStatement(sql);
            pps.setString(1, grade_room);
            pps.setString(2, SearchID1);

            pps.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        ComboDisplay();
        showON_Combo_SelectedClassInfo();
    }//GEN-LAST:event_jLabel71MouseClicked

    private void jLabel69MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel69MouseClicked
        // swatch to view students in a class
        panel_cover.hide();
        panel_Teachers.hide();
        panel_Students.hide();
        panel_Class_builder.hide();
        panal_Subjects.hide();
        Add_Students_ToClasses.hide();
        Popup_class_selection.hide();
        pExpenses.hide();
        View_class_panel.hide();
        Add_Students_ToClasses.hide();
        View_class_panel.setVisible(true);
    }//GEN-LAST:event_jLabel69MouseClicked

    
    
    private void level_changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level_changeActionPerformed
       String level=  class_level.getSelectedItem().toString();
       if(level.equals("Secondary")){
          combAp.setSelectedIndex(0);
                combAp.setEnabled(true);

       }else  if(level.equals("Primary")){ 
         combAp.setSelectedIndex(1);
         combAp.setEnabled(false);
         CombSu.setEnabled(false);

       
       }
    }//GEN-LAST:event_level_changeActionPerformed

    private void level_change1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level_change1ActionPerformed
     
    String class_level = class_level1.getSelectedItem().toString();  //OR (class_level == "Primary")
    if( class_level.equals("Secondary") ){
          table();
       }else  if(class_level.equals("Primary")){ 
         table();
         
       }else  if(class_level.equals("ALL")){ 
          try {
            conn = DBConnection.getConnction();
            String sql = " SELECT subject_name,subject_application, subject_type  FROM subjects ";
            pps7 = conn.prepareStatement(sql);
            rs7 = pps7.executeQuery();
            Subjects_Table_display.setModel(DbUtils.resultSetToTableModel(rs7));
           } catch (SQLException ex) { Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
           } 
       }
        
        
      
    }//GEN-LAST:event_level_change1ActionPerformed

    private void search_employesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_employesKeyTyped
        // TODO add your handling code here:
        
       try {
        conn = DBConnection.getConnction();
        String sql ="SELECT name,surname,employeeid,department,designation ,qualification FROM  employee WHERE department = 'Teaching'  AND name  like '%" + search_employes.getText() + "%'  OR surname  like '%" + search_employes.getText() + "%'   OR  employeeid  like '%" + search_employes.getText() + "%'   OR  department  like '%" + search_employes.getText() + "%' "
                    + "  OR  designation  like '%" + search_employes.getText() + "%'  OR  qualification  like '%" + search_employes.getText() + "%'   ";
         pps = conn.prepareStatement(sql);
         rs = pps.executeQuery();
         TeacherAssignment_Table_display.setModel(DbUtils.resultSetToTableModel(rs));//sho
      } catch (SQLException ex) {Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);}
        
    }//GEN-LAST:event_search_employesKeyTyped
String class_chooser = null;
    private void level_change2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level_change2ActionPerformed
        String Option =  combAp1.getSelectedItem().toString();
        class_chooser  =  GetClass_id.getSelectedItem().toString().substring(0, 3).trim();

        if (class_chooser.equals("None")) {
            JOptionPane.showMessageDialog(null, "Select class of Choice");

        } else if (!class_chooser.equals("None")) {

            if(Option.equals("Compulsory")){

                try {
                    conn = DBConnection.getConnction();
                    String sql = "SELECT   subjects.subject_name,  classes.grade_room FROM  subjects  JOIN  class_subject_joint  ON  subjects.subject_id = class_subject_joint.subject_id   INNER JOIN classes ON  classes.class_id = class_subject_joint.class_id WHERE grade_room =? AND subject_application = 'Compulsory'";
                    pps7 = conn.prepareStatement(sql);
                    pps7.setString(1, class_chooser);
                    rs7 = pps7.executeQuery();
                    Assigned_subject.setModel(DbUtils.resultSetToTableModel(rs7));
                } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

            }else  if(Option.equals("Optional")){

                try {
                    conn = DBConnection.getConnction();
                    String sql = "SELECT   subjects.subject_name,  classes.grade_room FROM  subjects  JOIN  class_subject_joint  ON  subjects.subject_id = class_subject_joint.subject_id   INNER JOIN classes ON  classes.class_id = class_subject_joint.class_id WHERE grade_room =? AND subject_application = 'Optional'";
                    pps7 = conn.prepareStatement(sql);
                    pps7.setString(1, class_chooser);
                    rs7 = pps7.executeQuery();
                    Assigned_subject.setModel(DbUtils.resultSetToTableModel(rs7));
                } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
            }


        }

    }//GEN-LAST:event_level_change2ActionPerformed

    private void GetClass_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GetClass_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GetClass_idActionPerformed

    private void Assigned_subjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Assigned_subjectMouseClicked
           DefaultTableModel tableMode = (DefaultTableModel) Assigned_subject.getModel();
           table_clicked = tableMode.getValueAt(Assigned_subject.getSelectedRow(), 0).toString();
    }//GEN-LAST:event_Assigned_subjectMouseClicked

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMouseDragged
         int x=evt.getXOnScreen();
         int y=evt.getYOnScreen();
         this.setLocation(x-xx, y-yy);
    }//GEN-LAST:event_headerMouseDragged

    private void headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headerMousePressed
       xx = evt.getX();
       yy = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void Teacher_HandlierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Teacher_HandlierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Teacher_HandlierActionPerformed

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
      
         if (table_clicked.equals("none")) {
            JOptionPane.showMessageDialog(null, "Select the Subject");
            
        } else if (!table_clicked.equals("none")) {
            
               try {//GETTING CLASS ID 
                conn = DBConnection.getConnction();
                pps5 = conn.prepareStatement("SELECT * FROM  classes WHERE grade_room = ?");
                pps5.setString(1, GetClass_id.getSelectedItem().toString().substring(0, 3).trim());
                rs5 = pps5.executeQuery();
                if (rs5.next()) {
                    getclass_Id = rs5.getString("class_id");//puting id on the resource
                }
            } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

            try {  //GETTING THE SUBJECT ID 
                conn = DBConnection.getConnction();
                pps6 = conn.prepareStatement("SELECT * FROM subjects WHERE subject_name = ?");
                pps6.setString(1, table_clicked);
                rs6 = pps6.executeQuery();
                if (rs6.next()) {
                   getSubject_Id = rs6.getString("subject_id");
                }
            } catch (Exception ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
            
        
        UnAssign_theClass_FromAsubject_Teacher();
       }
    }//GEN-LAST:event_jLabel27MouseClicked
   
   
     String delete_by_Joint_id = null;
    
    public void UnAssign_theClass_FromAsubject_Teacher(){
              // SEARCH IF THE RELATION EXITS 
              int   Class = Integer.parseInt(getclass_Id);  //amount paid to the school
              int   subject = Integer.parseInt(getSubject_Id);  //amount paid to the school   user_login_id
              int   employee = Integer.parseInt(Search_EmployeeID);  //amount paid to the school  employee_id
            
              try {
                conn = DBConnection.getConnction();
                String sql = "SELECT  * FROM  class_subject_joint    WHERE class_id = ?  AND subject_id=? AND user_login_id =?"; 
                pps9 = conn.prepareStatement(sql);
                pps9.setInt(1, Class);
                pps9.setInt(2, subject);
                pps9.setInt(3, employee);

                rs9 = pps9.executeQuery();
                if(rs9.next()){
                     delete_by_Joint_id =  rs9.getString("class_subject_id");
                     delete_joint_relation();     
                }else{
                JOptionPane.showMessageDialog(null, "Not Desigated to  "+ Seleted_teacher);
                }
               
              } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);}
            
            
    }
    
     public void delete_joint_relation(){
          // updating Relation 
            int   delete = Integer.parseInt(delete_by_Joint_id);  //amount paid to the school
            try {
                conn = DBConnection.getConnction();
                String sql = "UPDATE  class_subject_joint  SET user_login_id = NULL, teacher_state = NULL   WHERE class_subject_id = ?";
                pps7 = conn.prepareStatement(sql);
                pps7.setInt(1, delete);
                pps7.executeUpdate();

                JOptionPane.showMessageDialog(null, "Successfully Re-Assigned");
              } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
             }
            
            
    }
    
    
    
    
    
    
    
    public void table() {
      try {
           String class_level = class_level1.getSelectedItem().toString();
            conn = DBConnection.getConnction();
            String sql = " SELECT subject_name,subject_application, subject_type  FROM subjects WHERE class_level =?";
            pps6 = conn.prepareStatement(sql);
            pps6.setString(1, class_level);
            rs6 = pps6.executeQuery();
            Subjects_Table_display.setModel(DbUtils.resultSetToTableModel(rs6));
           } catch (SQLException ex) { Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
           }    
    }
    
    
    
    public void showON_Combo_SelectedClassInfo() {
        lbclass.setText(null);
        lbcapacity.setText(null);
        lbyear.setText(null);
        lbname.setText(null);
        lbspace.setText(null);

        grade_room = comb_classes.getSelectedItem().toString().trim();

        // geting the ID  to insert in a joint table to make a one to many relation        
        try {
            conn = DBConnection.getConnction();
            String sql = " SELECT  room_number,room_type,room_capacity,room_status, grade_room ,class_period,date,time,user_login_id      FROM  rooms ,classes  WHERE classes.classroom_id =  rooms.classroom_id AND grade_room = ?";
            pps = conn.prepareStatement(sql);
            pps.setString(1, grade_room);
            rs = pps.executeQuery();

            while (rs.next()) {
                String Grade = rs.getString("grade_room");
//              String Room =rs.getString("room");
                String Year = rs.getString("date");
                String Capacity = rs.getString("room_capacity");
                
                Teacher_id = rs.getString("user_login_id");//making the class_teacher_id capacity a private variable for easy accsess
                class_capacity = rs.getString("room_capacity");//making the class capacity a private variable for easy accsess
                room_capacity_AsDefined_space = rs.getString("room_capacity"); 
                
                 //  lb_classCapacity.setText(rs.getString("room_capacity"));

                lbclass.setText(Grade);
                lbcapacity.setText(Capacity);
                lbyear.setText(Year);
                //show on waiting list  
                Classlb.setText(Grade);
                Yearlb.setText(Year);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }     

        try {//getting the teachers info
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement(" SELECT * FROM   employee WHERE user_login_id = ?");
            pps.setString(1, Teacher_id);
            rs = pps.executeQuery();
            while (rs.next()) {
                String Fname = rs.getString("name");
                String Lname = rs.getString("surname");
                lbname.setText(Fname + "  " + Lname);

                //show on the waiting list panel
                Teacherlb.setText(Fname + "  " + Lname);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("SELECT  count(student_ids) FROM students  WHERE Student_Class =?");
            pps.setString(1, grade_room.trim());

            rs = pps.executeQuery();
            if (rs.next()) {
                String count_students = rs.getString("count(student_ids)");
               assignToClass_count_students  = rs.getString("count(student_ids)");
                int Students = Integer.parseInt(count_students);//reconverting Occuped space to int

                int ClassCapacity = Integer.parseInt(class_capacity);//reconverting capacity to int

                if (ClassCapacity == Students) {
                       lbspace.setText("this Class is full");

                } else {

                    ClassCapacity_caculation = ClassCapacity - Students;
                    lbspace.setText(Integer.toString(ClassCapacity_caculation)); //reconverting sum variables back to string and adding it to a lebal
                    //show on the waiting list panel
                    Capacitylb.setText(Integer.toString(ClassCapacity_caculation));

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Class_Assignment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void DisplayingContent() {
        DefaultTableModel tableMode = (DefaultTableModel) Subjects_Table_display.getModel();
        String SearchID = tableMode.getValueAt(Subjects_Table_display.getSelectedRow(), 0).toString();
        try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("SELECT * FROM subjects WHERE subject_name = ?");
            pps.setString(1, SearchID);
            rs = pps.executeQuery();
            combAp.removeAllItems();
            CombSu.removeAllItems();
            if (rs.next()) {
                gettingIDof_SelectedSubject = rs.getString("subject_id");
                combAp.addItem(rs.getString("subject_application"));
                CombSu.addItem(rs.getString("subject_type"));
                txtNa.setText(rs.getString("subject_name"));
            }
        } catch (Exception ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
     public static Class_Assignment getObj() {  //public method for instance Restriction
        if (Obj == null) {
            Obj = new Class_Assignment();
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
            java.util.logging.Logger.getLogger(Class_Assignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Class_Assignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Class_Assignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Class_Assignment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Class_Assignment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Add_PaidServices;
    private javax.swing.JPanel Add_Students_ToClasses;
    private javax.swing.JLabel Add_price1;
    private javax.swing.JTable Assigned_subject;
    private javax.swing.JButton AssigningSubjects_withTeacherID;
    private javax.swing.JLabel BackGround_layer1;
    private javax.swing.JPanel CMS;
    private javax.swing.JLabel Capacitylb;
    private javax.swing.JLabel Classlb;
    private javax.swing.JComboBox CombSu;
    private javax.swing.JLabel Count_title28;
    private javax.swing.JLabel Count_title29;
    private javax.swing.JLabel Count_title30;
    private javax.swing.JLabel Count_title31;
    private javax.swing.JLabel Count_title36;
    private javax.swing.JLabel Count_title37;
    private javax.swing.JLabel Count_title38;
    private javax.swing.JLabel Count_title39;
    private javax.swing.JLabel Count_title44;
    private javax.swing.JLabel Delecte10;
    private javax.swing.JLabel Delecte19;
    private javax.swing.JLabel Delecte20;
    private javax.swing.JLabel Delecte7;
    private javax.swing.JLabel Delecte8;
    private javax.swing.JLabel Delecte9;
    private javax.swing.JComboBox GetClass_id;
    private javax.swing.JPanel Popup_class_selection;
    private javax.swing.JLabel Primary_lb;
    private javax.swing.JLabel Qualification;
    private javax.swing.JLabel Qualification1;
    private javax.swing.JLabel Qualification5;
    private javax.swing.JLabel Qualification6;
    private javax.swing.JLabel Reload;
    private javax.swing.JTable StudentsAssignment_Table_display;
    private javax.swing.JTable Students_Table_display;
    private javax.swing.JPanel Subject_list;
    private javax.swing.JTable Subjects_Table_display;
    private javax.swing.JTable TeacherAssignment_Table_display;
    private javax.swing.JComboBox Teacher_Handlier;
    private javax.swing.JPanel Teacher_Subject_Add;
    private javax.swing.JLabel Teacherlb;
    private javax.swing.JTable Teachers_Table_display;
    private javax.swing.JPanel Teachers_list_view;
    private javax.swing.JPanel Tex_manager_lb;
    private javax.swing.JLabel Update;
    private javax.swing.JPanel View_class_panel;
    private javax.swing.JLabel Yearlb;
    private javax.swing.JPanel admin_btn;
    private javax.swing.JPanel archived_booking;
    private javax.swing.JLabel background;
    private javax.swing.JLabel bg;
    private javax.swing.JPanel building_classes_panel;
    private javax.swing.JPanel calender;
    private javax.swing.JComboBox class_level;
    private javax.swing.JComboBox class_level1;
    private javax.swing.JComboBox combAp;
    private javax.swing.JComboBox combAp1;
    private javax.swing.JComboBox comb_classes;
    private javax.swing.JLabel contact;
    private javax.swing.JLabel counter;
    private javax.swing.JLabel counter_view;
    private javax.swing.JLabel counter_view1;
    private javax.swing.JLabel counter_view2;
    private javax.swing.JLabel counter_view3;
    private javax.swing.JLabel counter_view4;
    private javax.swing.JLabel counter_view5;
    private javax.swing.JLabel counter_view6;
    private javax.swing.JLabel counter_view7;
    private javax.swing.JLabel counter_view8;
    private javax.swing.JLabel create;
    private javax.swing.JLabel create1;
    private javax.swing.JLabel create2;
    private javax.swing.JLabel create3;
    private javax.swing.JLabel edit10;
    private javax.swing.JLabel edit21;
    private javax.swing.JLabel edit9;
    private javax.swing.JLabel email;
    private javax.swing.JLabel exit_lb;
    private javax.swing.JPanel expenses;
    private javax.swing.JPanel frontSide_btn_holder;
    private javax.swing.JLabel header;
    private javax.swing.JPanel hotel_ma;
    private javax.swing.JLabel image_viewer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel205;
    private javax.swing.JLabel jLabel206;
    private javax.swing.JLabel jLabel207;
    private javax.swing.JLabel jLabel208;
    private javax.swing.JLabel jLabel209;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel210;
    private javax.swing.JLabel jLabel211;
    private javax.swing.JLabel jLabel212;
    private javax.swing.JLabel jLabel213;
    private javax.swing.JLabel jLabel214;
    private javax.swing.JLabel jLabel215;
    private javax.swing.JLabel jLabel216;
    private javax.swing.JLabel jLabel217;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel223;
    private javax.swing.JLabel jLabel224;
    private javax.swing.JLabel jLabel225;
    private javax.swing.JLabel jLabel226;
    private javax.swing.JLabel jLabel227;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lb_GB;
    private javax.swing.JLabel lb_Search;
    private javax.swing.JLabel lb_hold28;
    private javax.swing.JLabel lb_hold29;
    private javax.swing.JLabel lb_hold30;
    private javax.swing.JLabel lb_hold31;
    private javax.swing.JLabel lb_hold36;
    private javax.swing.JLabel lb_hold37;
    private javax.swing.JLabel lb_hold38;
    private javax.swing.JLabel lb_hold39;
    private javax.swing.JLabel lb_major1;
    private javax.swing.JLabel lb_major2;
    private javax.swing.JLabel lb_major3;
    private javax.swing.JLabel lbcapacity;
    private javax.swing.JLabel lbclass;
    private javax.swing.JLabel lbname;
    private javax.swing.JLabel lbspace;
    private javax.swing.JLabel lbyear;
    private javax.swing.JButton level_change;
    private javax.swing.JButton level_change1;
    private javax.swing.JButton level_change2;
    private javax.swing.JPanel main_subjects;
    private javax.swing.JLabel minize_lb;
    private javax.swing.JLabel model;
    private javax.swing.JLabel name;
    private javax.swing.JLabel options_lb;
    private javax.swing.JPanel organizer;
    private javax.swing.JPanel pExpenses;
    private javax.swing.JPanel panal_Subjects;
    private javax.swing.JPanel panel_Class_builder;
    private javax.swing.JPanel panel_Students;
    private javax.swing.JPanel panel_Teachers;
    private javax.swing.JPanel panel_cover;
    private javax.swing.JPanel right;
    private javax.swing.JLabel roomcount29;
    private javax.swing.JLabel roomcount30;
    private javax.swing.JLabel roomcount31;
    private javax.swing.JLabel roomcount32;
    private javax.swing.JTextField search_employes;
    private javax.swing.JPanel subject_entry;
    private javax.swing.JLabel table_holder_bg14;
    private javax.swing.JLabel table_holder_bg7;
    private javax.swing.JLabel table_holder_bg8;
    private javax.swing.JLabel total_4Secondary;
    private javax.swing.JLabel total_numberOF_subjects;
    private javax.swing.JTextField txtNa;
    // End of variables declaration//GEN-END:variables
}
