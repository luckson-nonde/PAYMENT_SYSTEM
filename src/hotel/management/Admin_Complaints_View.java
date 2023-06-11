package hotel.management;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Admin_Complaints_View extends javax.swing.JFrame {

      Connection conn = null;
      PreparedStatement pps, pps1, pps2, pps3, pps4, pps6, pps5, pps7, pps8, pps9, pps10, pps11, pps12 ,pps13 = null;
      ResultSet rs, rs1, rs2, rs3, rs4, rs5, rs6, rs7, rs8, rs9, rs10, rs11, rs12 ,rs13= null;

   String class_teacher_id = null;  
    String gettingIDof_SelectedSubject = null;// getting id and use it to delecte elected content       
    String Resource_for_employeeID = null; //id to get the employee id and put it in relation to subjects
    String Resource_for_SubjectID = null; //id to get the subject id and put it in relation to subjects

 
    //variable for class teacher id to make a joint like Students_Table_display1
    String Teacher_id = null;

    String Cass_id = null;
    String grade_room = null;
    String class_capacity = null;
    int ClassCapacity_caculation;

     String assignToClass_count_students = null;
     String room_capacity_AsDefined_space = null;
     
    //user access
    private static String Recieved_user_id = null;
    private static String usertype = null;
    //passing user id
    private static Admin_Complaints_View Obj = null;
    
    
    
    String passed_user_id;
       String subject_selected3 = "none";
       String subject_selected2 = "none";
       
       
    String  get_Full_Name= null; 
       String   get_Student_Age= null; 
        String get_Student_class= null; 
         String get_Date= null; 
         
         String getComplaint_id = null; 
         String getComplaintHander_id = null; 
          String subject_selected= "none";
    
    
      String  get_Complaint_Name = null;  
       String   get_DateComplaint= null;  
       String    get_Student_Name = null;  
                 
          String       subject_selected1= "none";
     String  table_clicked = "none";
     String getclass_Id = null;           
     String getSubject_Id = null;
      String Seleted_teacher = null;
    
            int xx = 0;
            int yy = 0;
            String Search_EmployeeID = null;

        Admin_Complaints_View() {
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));

        ShowRoomType_onTable();
   
        
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
       myClass();
    }
    
    
      public void myClass(){
          
        try {
            conn = DBConnection.getConnction();
            pps1 = conn.prepareStatement("SELECT * FROM classes");
            rs1 = pps1.executeQuery();
            while(rs1.next()){
              jComboBox1.addItem(rs1.getString("grade_room"));
              
            }
        } catch (SQLException ex) { JOptionPane.showMessageDialog(null, ex);}
        
        
        
        
         
        
        
        
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
      
        
       
           try {
               String STATE2 = "Pending";
            conn = DBConnection.getConnction();
            pps7 = conn.prepareStatement("SELECT  count(Complaint_id) FROM   complaints  WHERE state =? ");
             pps7.setString(1 , STATE2);
            rs7 = pps7.executeQuery();
            if (rs7.next()) {
                String sum = rs7.getString("count(Complaint_id)");
               
                students_tata.setText(sum);
            }
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);  }

             try {
               String STATE1 = "Resolved";
            conn = DBConnection.getConnction();
            pps8 = conn.prepareStatement("SELECT  count(Complaint_id) FROM   complaints  WHERE state=? ");
             pps8.setString(1 , STATE1);
            rs8 = pps8.executeQuery();
            if (rs8.next()) {
                String sum = rs8.getString("count(Complaint_id)");
                lb_payment_counter.setText(sum);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   

      

        
       
       }
    
    
    
   
    
    

    
  

    ///-----------------------------------------------------------------displying table content on jtable-----------------------------------------------------
    public void ShowRoomType_onTable() {//school srtucture

   
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

   try {
            conn = DBConnection.getConnction();
            pps3 = conn.prepareStatement("SELECT Complaint_name,Student_name, Student_class,Complaint,Complaint_date FROM complaints WHERE Student_name =?  AND Student_class =?");
            
            pps3.setString(1 ,  get_Full_Name);
            pps3.setString(2 ,  get_Student_class);
            rs3 = pps3.executeQuery();
            Students_Table_display1.setModel(DbUtils.resultSetToTableModel(rs3));//sho
        } catch (Exception ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

        
          
      
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
        jLabel211 = new javax.swing.JLabel();
        building_classes_panel = new javax.swing.JPanel();
        Complaint_view = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        Add_price3 = new javax.swing.JLabel();
        Delecte11 = new javax.swing.JLabel();
        Delecte12 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jLabel209 = new javax.swing.JLabel();
        jLabel213 = new javax.swing.JLabel();
        jLabel214 = new javax.swing.JLabel();
        jLabel215 = new javax.swing.JLabel();
        jLabel216 = new javax.swing.JLabel();
        jScrollPane25 = new javax.swing.JScrollPane();
        Students_Table_display = new javax.swing.JTable();
        table_holder_bg8 = new javax.swing.JLabel();
        pExpenses = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        lb_payment_counter = new javax.swing.JLabel();
        lb_payment_pending = new javax.swing.JLabel();
        lb_payments = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        lb_payment_bg = new javax.swing.JLabel();
        students_tata = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        lb_students = new javax.swing.JLabel();
        lb_students_pending = new javax.swing.JLabel();
        lb_student_bg = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        viewComplaint_pane = new javax.swing.JPanel();
        Delecte22 = new javax.swing.JLabel();
        Delecte23 = new javax.swing.JLabel();
        Add_price2 = new javax.swing.JLabel();
        Delecte13 = new javax.swing.JLabel();
        Delecte14 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jLabel218 = new javax.swing.JLabel();
        jLabel219 = new javax.swing.JLabel();
        jLabel220 = new javax.swing.JLabel();
        jLabel221 = new javax.swing.JLabel();
        jLabel222 = new javax.swing.JLabel();
        jScrollPane26 = new javax.swing.JScrollPane();
        Students_Table_display1 = new javax.swing.JTable();
        table_holder_bg9 = new javax.swing.JLabel();
        panal_Complaint = new javax.swing.JPanel();
        main_subjects = new javax.swing.JPanel();
        subject_entry = new javax.swing.JPanel();
        jLabel154 = new javax.swing.JLabel();
        Delecte19 = new javax.swing.JLabel();
        Add_PaidServices = new javax.swing.JLabel();
        jLabel223 = new javax.swing.JLabel();
        jLabel224 = new javax.swing.JLabel();
        jLabel210 = new javax.swing.JLabel();
        jLabel212 = new javax.swing.JLabel();
        jLabel217 = new javax.swing.JLabel();
        Delecte21 = new javax.swing.JLabel();
        Delecte20 = new javax.swing.JLabel();
        Student_class = new javax.swing.JTextField();
        Student_name = new javax.swing.JTextField();
        Complaint_Title = new javax.swing.JTextField();
        Complaint_date = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        Count_title39 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();
        Complaint_id = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        contact = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        Qualification = new javax.swing.JLabel();
        Qualification1 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        Qualification2 = new javax.swing.JLabel();
        Qualification3 = new javax.swing.JLabel();
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

        jLabel211.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel211.setForeground(new java.awt.Color(102, 102, 102));
        jLabel211.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel211.setText("Complaint Handler ");
        right.add(jLabel211);

        jPanel1.add(right, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 760, 1380, 60));

        building_classes_panel.setLayout(new java.awt.CardLayout());

        Complaint_view.setBackground(new java.awt.Color(255, 255, 255));
        Complaint_view.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CLASSES" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        Complaint_view.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 610, 120, 30));

        Add_price3.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Add_price3.setForeground(new java.awt.Color(255, 255, 255));
        Add_price3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Add_price3.setText("View  Complaint");
        Add_price3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_price3MouseClicked(evt);
            }
        });
        Complaint_view.add(Add_price3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 600, 150, 50));

        Delecte11.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte11.setForeground(new java.awt.Color(255, 255, 255));
        Delecte11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        Delecte11.setText("Delecte");
        Complaint_view.add(Delecte11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 580, 380, 80));

        Delecte12.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte12.setForeground(new java.awt.Color(255, 255, 255));
        Delecte12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        Complaint_view.add(Delecte12, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 580, 270, 80));

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
        jPanel35.add(jLabel213, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 40));

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

        Complaint_view.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 890, 50));

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
        Students_Table_display.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Students_Table_displayMouseClicked(evt);
            }
        });
        jScrollPane25.setViewportView(Students_Table_display);

        Complaint_view.add(jScrollPane25, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 890, 350));

        table_holder_bg8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        table_holder_bg8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/display.png"))); // NOI18N
        Complaint_view.add(table_holder_bg8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 140, 1130, 550));

        pExpenses.setBackground(new java.awt.Color(95, 158, 160));
        pExpenses.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        pExpenses.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel77.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setText("0");
        jLabel77.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 60, 30));

        lb_payment_counter.setFont(new java.awt.Font("Tw Cen MT", 0, 13)); // NOI18N
        lb_payment_counter.setForeground(new java.awt.Color(0, 204, 51));
        lb_payment_counter.setText("0");
        lb_payment_counter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(lb_payment_counter, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 60, 60, 20));

        lb_payment_pending.setFont(new java.awt.Font("Tw Cen MT", 0, 11)); // NOI18N
        lb_payment_pending.setForeground(new java.awt.Color(255, 255, 255));
        lb_payment_pending.setText("All   Complaints");
        lb_payment_pending.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(lb_payment_pending, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 110, 30));

        lb_payments.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        lb_payments.setForeground(new java.awt.Color(255, 255, 255));
        lb_payments.setText("Complaints");
        lb_payments.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(lb_payments, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 120, 30));

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Currency_Settings_30px.png"))); // NOI18N
        jLabel38.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 40, 80));

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
        pExpenses.add(students_tata, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, 80, 20));

        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_binder_30px_1.png"))); // NOI18N
        jLabel71.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 40, 60));

        lb_students.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        lb_students.setForeground(new java.awt.Color(255, 255, 255));
        lb_students.setText("Complaints Pending");
        lb_students.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(lb_students, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 180, 30));

        lb_students_pending.setFont(new java.awt.Font("Tw Cen MT", 0, 11)); // NOI18N
        lb_students_pending.setForeground(new java.awt.Color(255, 255, 255));
        lb_students_pending.setText("Pending");
        lb_students_pending.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(lb_students_pending, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 70, 40));

        lb_student_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/shortcut.png"))); // NOI18N
        lb_student_bg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_student_bg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_student_bgMouseClicked(evt);
            }
        });
        pExpenses.add(lb_student_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 340, 100));

        jLabel78.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setText("Complaints Resolved ");
        jLabel78.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 20, 180, 40));

        jLabel39.setFont(new java.awt.Font("Tw Cen MT", 0, 11)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Resolved Issues");
        jLabel39.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 50, 90, 40));
        pExpenses.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 30, 40, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/shortcut3.png"))); // NOI18N
        pExpenses.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 330, 90));

        jLabel3.setText("jLabel3");
        pExpenses.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 24, -1, 40));

        Complaint_view.add(pExpenses, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 120));

        building_classes_panel.add(Complaint_view, "card2");

        viewComplaint_pane.setBackground(new Color(66,66,66,110));
        viewComplaint_pane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Delecte22.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte22.setForeground(new java.awt.Color(255, 255, 255));
        Delecte22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_no_entry_25px.png"))); // NOI18N
        Delecte22.setText("Delecte");
        Delecte22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Delecte22MouseClicked(evt);
            }
        });
        viewComplaint_pane.add(Delecte22, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 610, 100, 30));

        Delecte23.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte23.setForeground(new java.awt.Color(255, 255, 255));
        Delecte23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_no_entry_25px.png"))); // NOI18N
        Delecte23.setText("BACK");
        Delecte23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Delecte23MouseClicked(evt);
            }
        });
        viewComplaint_pane.add(Delecte23, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 610, 100, 30));

        Add_price2.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Add_price2.setForeground(new java.awt.Color(255, 255, 255));
        Add_price2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Add_price2.setText("Resolve");
        Add_price2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_price2MouseClicked(evt);
            }
        });
        viewComplaint_pane.add(Add_price2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 600, 110, 50));

        Delecte13.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte13.setForeground(new java.awt.Color(255, 255, 255));
        Delecte13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        viewComplaint_pane.add(Delecte13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 580, 290, 80));

        Delecte14.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte14.setForeground(new java.awt.Color(255, 255, 255));
        Delecte14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        Delecte14.setText("Delecte");
        viewComplaint_pane.add(Delecte14, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 580, 460, 80));

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));
        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel218.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel218.setForeground(new java.awt.Color(102, 102, 102));
        jLabel218.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel218.setText("DATE");
        jPanel36.add(jLabel218, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 140, 50));

        jLabel219.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel219.setForeground(new java.awt.Color(102, 102, 102));
        jLabel219.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel219.setText("Complaint NAME");
        jPanel36.add(jLabel219, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 150, 40));

        jLabel220.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel220.setForeground(new java.awt.Color(102, 102, 102));
        jLabel220.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel220.setText("Student_class");
        jPanel36.add(jLabel220, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 120, 50));

        jLabel221.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel221.setForeground(new java.awt.Color(102, 102, 102));
        jLabel221.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel221.setText("Student_name");
        jPanel36.add(jLabel221, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 120, 40));

        jLabel222.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel222.setForeground(new java.awt.Color(102, 102, 102));
        jLabel222.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel222.setText("Complaint");
        jPanel36.add(jLabel222, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 100, 50));

        viewComplaint_pane.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 890, 50));

        Students_Table_display1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Students_Table_display1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Students_Table_display1.setGridColor(new java.awt.Color(255, 255, 255));
        Students_Table_display1.setIntercellSpacing(new java.awt.Dimension(20, 5));
        Students_Table_display1.setRowHeight(30);
        Students_Table_display1.setTableHeader(null);
        Students_Table_display1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Students_Table_display1MouseClicked(evt);
            }
        });
        jScrollPane26.setViewportView(Students_Table_display1);

        viewComplaint_pane.add(jScrollPane26, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 890, 350));

        table_holder_bg9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        table_holder_bg9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/display.png"))); // NOI18N
        viewComplaint_pane.add(table_holder_bg9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 140, 1130, 550));

        building_classes_panel.add(viewComplaint_pane, "card2");

        panal_Complaint.setBackground(new java.awt.Color(255, 255, 255));
        panal_Complaint.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        main_subjects.setBackground(new java.awt.Color(255, 255, 255));
        main_subjects.setLayout(new java.awt.CardLayout());

        subject_entry.setBackground(new java.awt.Color(255, 255, 255));
        subject_entry.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel154.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel154.setForeground(new java.awt.Color(33, 173, 178));
        jLabel154.setText("Complaint Entry");
        subject_entry.add(jLabel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 170, 40));

        Delecte19.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte19.setForeground(new java.awt.Color(255, 255, 255));
        Delecte19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_no_entry_25px.png"))); // NOI18N
        Delecte19.setText("Delecte");
        Delecte19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Delecte19MouseClicked(evt);
            }
        });
        subject_entry.add(Delecte19, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, 90, 50));

        Add_PaidServices.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Add_PaidServices.setForeground(new java.awt.Color(255, 255, 255));
        Add_PaidServices.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Add_PaidServices.setText("  Submit");
        Add_PaidServices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_PaidServicesMouseClicked(evt);
            }
        });
        subject_entry.add(Add_PaidServices, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 430, 100, 50));

        jLabel223.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel223.setForeground(new java.awt.Color(102, 102, 102));
        jLabel223.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel223.setText("Complaint Resolution");
        subject_entry.add(jLabel223, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 200, 30));

        jLabel224.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel224.setForeground(new java.awt.Color(102, 102, 102));
        jLabel224.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Search_15px.png"))); // NOI18N
        subject_entry.add(jLabel224, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, 50, 30));

        jLabel210.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel210.setForeground(new java.awt.Color(102, 102, 102));
        jLabel210.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel210.setText("Complaint Handler ");
        subject_entry.add(jLabel210, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 210, 30));

        jLabel212.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel212.setForeground(new java.awt.Color(102, 102, 102));
        jLabel212.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel212.setText("Complaint Handler Name");
        subject_entry.add(jLabel212, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 190, 50));

        jLabel217.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel217.setForeground(new java.awt.Color(102, 102, 102));
        jLabel217.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel217.setText("Complaint Handler ID");
        subject_entry.add(jLabel217, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 170, 50));

        Delecte21.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte21.setForeground(new java.awt.Color(255, 255, 255));
        Delecte21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        subject_entry.add(Delecte21, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 180, 80));

        Delecte20.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte20.setForeground(new java.awt.Color(255, 255, 255));
        Delecte20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        Delecte20.setText("Delecte");
        subject_entry.add(Delecte20, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, 360, 80));
        subject_entry.add(Student_class, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 290, 30));

        Student_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Student_nameKeyTyped(evt);
            }
        });
        subject_entry.add(Student_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 290, 30));
        subject_entry.add(Complaint_Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 290, 30));
        subject_entry.add(Complaint_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 290, 30));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        subject_entry.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 190, 530, 280));

        Count_title39.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title39.setForeground(new java.awt.Color(255, 255, 255));
        Count_title39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_30px.png"))); // NOI18N
        Count_title39.setText("Complaint List");
        Count_title39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Count_title39MouseClicked(evt);
            }
        });
        subject_entry.add(Count_title39, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 70, 190, 60));

        background.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/Untitled-2.png"))); // NOI18N
        subject_entry.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1150, 470));

        Complaint_id.setText("jLabel1");
        subject_entry.add(Complaint_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 110, -1));

        main_subjects.add(subject_entry, "card3");

        panal_Complaint.add(main_subjects, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1140, 560));

        jPanel12.setBackground(new java.awt.Color(66, 66, 66));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        name.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        name.setForeground(new java.awt.Color(110, 156, 182));
        name.setText("Complaint NAME");
        jPanel12.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 170, 40));

        contact.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        contact.setForeground(new java.awt.Color(110, 156, 182));
        contact.setText("Contact");
        jPanel12.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 180, 40));

        email.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        email.setForeground(new java.awt.Color(110, 156, 182));
        email.setText("Email");
        jPanel12.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 80, 40));

        Qualification.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        Qualification.setForeground(new java.awt.Color(110, 156, 182));
        Qualification.setText("Qualification");
        jPanel12.add(Qualification, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, 210, 40));

        Qualification1.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        Qualification1.setForeground(new java.awt.Color(161, 169, 171));
        Qualification1.setText("Class :");
        jPanel12.add(Qualification1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 70, 40));

        jLabel52.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(161, 169, 171));
        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        jLabel52.setText("Complaint name :");
        jPanel12.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 40));

        Qualification2.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        Qualification2.setForeground(new java.awt.Color(161, 169, 171));
        Qualification2.setText("Complaint");
        jPanel12.add(Qualification2, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 100, 40));

        Qualification3.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        Qualification3.setForeground(new java.awt.Color(161, 169, 171));
        Qualification3.setText("Student :");
        jPanel12.add(Qualification3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 70, 40));

        panal_Complaint.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 40));

        building_classes_panel.add(panal_Complaint, "card8");

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
        admin_btn.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, -6, 160, 50));

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
     

        panal_Complaint.hide();
     
        Complaint_view.setVisible(true);
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

    private void Add_PaidServicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_PaidServicesMouseClicked
           
             
             
         if(Complaint_Title.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "There is no title");
        }else if( jTextArea1.getText().isEmpty()){
          JOptionPane.showMessageDialog(null, "Write the massage ");
         }else {
        
        
       
    
         Date date = new Date();
         java.sql.Date sqldate = new java.sql.Date(date.getTime());
         
         
        
        String State = "Resolved";
        
        
        
          try {
       conn = DBConnection.getConnction();
            String sql = "UPDATE  complaints SET  Complaint_Handler_ID =?, resolution =?,resolved_date =?, state =?WHERE Complaint_id =? ";
            pps = conn.prepareStatement(sql);
            pps.setString(1 , getComplaintHander_id);
            pps.setString(2 , jTextArea1.getText());
            pps.setDate(3, sqldate);
            pps.setString(4 , State);
             pps.setString(5 ,getComplaint_id );
             
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "complaint Resolved" );
            Complaint_Title.setText(null);
            Student_name.setText(null);
            Student_class.setText(null);
            Complaint_date.setText(null);
            jTextArea1 .setText(null);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        
        
        
        
        
        
        
        
        
        
        
       
        
      
        }
             
        ShowRoomType_onTable() ;

    }//GEN-LAST:event_Add_PaidServicesMouseClicked

    private void Count_title39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Count_title39MouseClicked
        subject_entry.hide();
        Complaint_view.setVisible(true);
        panal_Complaint.hide();
           subject_entry.hide();
    }//GEN-LAST:event_Count_title39MouseClicked

    private void Delecte19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Delecte19MouseClicked
        

        try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("DELETE  FROM  complaints WHERE  Complaint = ? AND Complaint_date = ?");
            pps.setString(1, jTextArea1.getText());
            // pps.setString(2, Student_name.getText().trim());
             // pps.setString(3, Student_class.getText().trim());
               pps.setString(2, Complaint_date.getText());
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "DELECTED" );
        } catch (Exception ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        ShowRoomType_onTable(); //displaying changes on the table


    }//GEN-LAST:event_Delecte19MouseClicked

    
 
    
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

    private void lb_payment_bgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_payment_bgMouseClicked
    
    }//GEN-LAST:event_lb_payment_bgMouseClicked

    private void lb_student_bgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_student_bgMouseClicked
       // line_chart();
    }//GEN-LAST:event_lb_student_bgMouseClicked

    private void Students_Table_displayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Students_Table_displayMouseClicked
         
        
        DefaultTableModel tableMode_type = (DefaultTableModel) Students_Table_display.getModel();
          get_Full_Name = tableMode_type.getValueAt(Students_Table_display.getSelectedRow(), 0).toString();
        
         DefaultTableModel tableMode_type1 = (DefaultTableModel) Students_Table_display.getModel();
         get_Student_Age = tableMode_type1.getValueAt(Students_Table_display.getSelectedRow(), 1).toString();
         
        
         
         DefaultTableModel tableMode_type2 = (DefaultTableModel) Students_Table_display.getModel();
         get_Date = tableMode_type2.getValueAt(Students_Table_display.getSelectedRow(), 3).toString();
        
         DefaultTableModel tableMode_type3 = (DefaultTableModel) Students_Table_display.getModel();
           get_Student_class= tableMode_type3.getValueAt(Students_Table_display.getSelectedRow(),4).toString();
         
            subject_selected2 = "selected";
        subject_selected = "selected";
    }//GEN-LAST:event_Students_Table_displayMouseClicked

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
            // /-----------------------------------------------------------------displying students on the table on class_assignment-----------------------------------------------------
        try {
            conn = DBConnection.getConnction();
            String sql = " SELECT Full_Name,Student_Age,Student_Gender, Date,Student_Class  FROM students WHERE Student_Class=? ";
            pps = conn.prepareStatement(sql);
           pps.setString(1, jComboBox1.getSelectedItem().toString().trim());
            rs = pps.executeQuery();
            Students_Table_display.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void Add_price2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_price2MouseClicked
       
        if(!subject_selected3.contentEquals("selected")){
         JOptionPane.showMessageDialog(null, "Choose  The Student, Then Press Complaint" );
        
        }else{
        
         //    Add_PaidServices.hide();
            
             try {
             
             
             
                 
            try {
            conn = DBConnection.getConnction();
            pps3 = conn.prepareStatement("SELECT Complaint_name,Student_name, Student_class,Complaint,Complaint_date,Complaint_id FROM complaints WHERE Student_name =?  AND Student_class =?");
            
            pps3.setString(1 ,  get_Full_Name);
            pps3.setString(2 ,  get_Student_class);
            rs3 = pps3.executeQuery();
            if(rs3.next()){
            name.setText(rs3.getString("Complaint_name"));
            contact .setText(rs3.getString("Student_name"));   
            Qualification1.setText(rs3.getString("Student_Class"));
             Qualification.setText(rs3.getString("Complaint_date"));
            getComplaint_id =  rs3.getString("Complaint_id");

             
            
            panal_Complaint.setVisible(true);
            Complaint_view.hide();
            viewComplaint_pane.hide();
            }
            
        } catch (Exception ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

        
                 
                 
                 
                 
                 
                 
                 
                 
        
            
        } catch (Exception ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
            
        }
        
        
        
        
       

         
        
    }//GEN-LAST:event_Add_price2MouseClicked
  
    private void Students_Table_display1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Students_Table_display1MouseClicked
      
         subject_selected3 = "selected";
        
        
        DefaultTableModel tableMode_type = (DefaultTableModel) Students_Table_display1.getModel();
          get_Complaint_Name = tableMode_type.getValueAt(Students_Table_display1.getSelectedRow(), 0).toString();
        
         DefaultTableModel tableMode_type1 = (DefaultTableModel) Students_Table_display1.getModel();
         get_Student_Name = tableMode_type1.getValueAt(Students_Table_display1.getSelectedRow(), 1).toString();
       
         DefaultTableModel tableMode_type2 = (DefaultTableModel) Students_Table_display1.getModel();
         get_DateComplaint = tableMode_type2.getValueAt(Students_Table_display1.getSelectedRow(), 4).toString();
        
        
        
         subject_selected3 = "selected";
    }//GEN-LAST:event_Students_Table_display1MouseClicked

    private void Delecte22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Delecte22MouseClicked
            try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("DELETE  FROM  complaints WHERE  Complaint = ? AND Complaint_date = ?");
            pps.setString(1, jTextArea1.getText());
            // pps.setString(2, Student_name.getText().trim());
             // pps.setString(3, Student_class.getText().trim());
               pps.setString(2, Complaint_date.getText());
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "DELECTED" );
        } catch (Exception ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
         ShowRoomType_onTable(); //displaying changes on the table


    }//GEN-LAST:event_Delecte22MouseClicked

    private void Add_price3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_price3MouseClicked
         
       // JOptionPane.showMessageDialog(null, get_Complaint_Name+"   "+get_Student_Name );
        
        
        if (!subject_selected2.contains("selected")) {
            JOptionPane.showMessageDialog(null, "Select the Student you wish to view");
        } else  {
                 
             String State ="Pending";
            try {
            conn = DBConnection.getConnction();
            pps3 = conn.prepareStatement("SELECT Complaint_name,Student_name, Student_class,Complaint,Complaint_date FROM complaints WHERE (Student_name =?  AND Student_class =?) AND state =?");
            
            pps3.setString(1 ,  get_Full_Name);
            pps3.setString(2 ,  get_Student_class);
            pps3.setString(3 ,  State);
            rs3 = pps3.executeQuery();
            Students_Table_display1.setModel(DbUtils.resultSetToTableModel(rs3));//sho
        } catch (Exception ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

        
          
          
          viewComplaint_pane.setVisible(true);
          Complaint_view.hide();
          panal_Complaint.hide();
            
            
        }
          
       
         
     
       
    }//GEN-LAST:event_Add_price3MouseClicked

    private void Delecte23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Delecte23MouseClicked
          viewComplaint_pane.hide();
          Complaint_view.setVisible(true);
          panal_Complaint.hide();
    }//GEN-LAST:event_Delecte23MouseClicked

    private void Student_nameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Student_nameKeyTyped
               try {

            conn = DBConnection.getConnction();
            String sql ="SELECT  * FROM employee  WHERE  name  like '%" + Student_name.getText() + "%'  OR surname  like '%" + Student_name.getText() + "%'   OR  employeeid  like '%" + Student_name.getText() + "%'   OR  contact  like '%" + Student_name.getText() + "%' "
            + "  OR  email  like '%" + Student_name.getText() + "%'   ";
            pps = conn.prepareStatement(sql);
            rs = pps.executeQuery();
            if(rs.next()){
            Student_class.setText(rs.getString("surname"));
            Complaint_date.setText(rs.getString("employeeid"));
            getComplaintHander_id = rs.getString("user_login_id");
            }
            
            
        } catch (SQLException ex) {Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);}

    }//GEN-LAST:event_Student_nameKeyTyped
   
    
    
    
    
    
    
    
    
    

    
    

     public static Admin_Complaints_View getObj() {  //public method for instance Restriction
        if (Obj == null) {
            Obj = new Admin_Complaints_View();
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
            java.util.logging.Logger.getLogger(Admin_Complaints_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Complaints_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Complaints_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Complaints_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Complaints_View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Add_PaidServices;
    private javax.swing.JLabel Add_price2;
    private javax.swing.JLabel Add_price3;
    private javax.swing.JLabel BackGround_layer1;
    private javax.swing.JTextField Complaint_Title;
    private javax.swing.JTextField Complaint_date;
    private javax.swing.JLabel Complaint_id;
    private javax.swing.JPanel Complaint_view;
    private javax.swing.JLabel Count_title39;
    private javax.swing.JLabel Delecte11;
    private javax.swing.JLabel Delecte12;
    private javax.swing.JLabel Delecte13;
    private javax.swing.JLabel Delecte14;
    private javax.swing.JLabel Delecte19;
    private javax.swing.JLabel Delecte20;
    private javax.swing.JLabel Delecte21;
    private javax.swing.JLabel Delecte22;
    private javax.swing.JLabel Delecte23;
    private javax.swing.JLabel Qualification;
    private javax.swing.JLabel Qualification1;
    private javax.swing.JLabel Qualification2;
    private javax.swing.JLabel Qualification3;
    private javax.swing.JTextField Student_class;
    private javax.swing.JTextField Student_name;
    private javax.swing.JTable Students_Table_display;
    private javax.swing.JTable Students_Table_display1;
    private javax.swing.JPanel Tex_manager_lb;
    private javax.swing.JPanel admin_btn;
    private javax.swing.JLabel background;
    private javax.swing.JPanel building_classes_panel;
    private javax.swing.JLabel contact;
    private javax.swing.JLabel email;
    private javax.swing.JLabel exit_lb;
    private javax.swing.JPanel frontSide_btn_holder;
    private javax.swing.JLabel header;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel209;
    private javax.swing.JLabel jLabel210;
    private javax.swing.JLabel jLabel211;
    private javax.swing.JLabel jLabel212;
    private javax.swing.JLabel jLabel213;
    private javax.swing.JLabel jLabel214;
    private javax.swing.JLabel jLabel215;
    private javax.swing.JLabel jLabel216;
    private javax.swing.JLabel jLabel217;
    private javax.swing.JLabel jLabel218;
    private javax.swing.JLabel jLabel219;
    private javax.swing.JLabel jLabel220;
    private javax.swing.JLabel jLabel221;
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel223;
    private javax.swing.JLabel jLabel224;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lb_payment_bg;
    private javax.swing.JLabel lb_payment_counter;
    private javax.swing.JLabel lb_payment_pending;
    private javax.swing.JLabel lb_payments;
    private javax.swing.JLabel lb_student_bg;
    private javax.swing.JLabel lb_students;
    private javax.swing.JLabel lb_students_pending;
    private javax.swing.JPanel main_subjects;
    private javax.swing.JLabel minize_lb;
    private javax.swing.JLabel model;
    private javax.swing.JLabel name;
    private javax.swing.JPanel pExpenses;
    private javax.swing.JPanel panal_Complaint;
    private javax.swing.JPanel right;
    private javax.swing.JLabel students_tata;
    private javax.swing.JPanel subject_entry;
    private javax.swing.JLabel table_holder_bg8;
    private javax.swing.JLabel table_holder_bg9;
    private javax.swing.JPanel viewComplaint_pane;
    // End of variables declaration//GEN-END:variables
}
