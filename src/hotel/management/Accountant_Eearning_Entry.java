package hotel.management;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Accountant_Eearning_Entry extends javax.swing.JFrame {

      Connection conn = null;
      PreparedStatement pps, pps1, pps2, pps3, pps4, pps6, pps5, pps7, pps8, pps9, pps10, pps11, pps12 ,pps13 ,pps14 ,pps15= null;
      ResultSet rs, rs1, rs2, rs3, rs4, rs5, rs6, rs7, rs8, rs9, rs10, rs11, rs12 ,rs13 ,rs14 ,rs15 = null;

   String class_teacher_id = null;  
    String get_Expense_id_toUpdate = null;// getting id and use it to delecte elected content       
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
    private static Accountant_Eearning_Entry Obj = null;
    
    
    
          String passed_user_id;
       String subject_selected = "none";
       String subject_selected2 = "none";
       
       
        String  get_Payment_To= null; 
       String   get_Amount = null; 
        String get_description= null; 
         String get_Date= null; 
         
        
    String       Deducation_subject_selected  ="none"; 
    String       get_Deducation_name = null; 
    String        get_Deducation_amount = null; 
    String        get_Deducation_date = null; 
    String        get_Deducation_id_toUpdate = null;
    String        get_Deducation_id_toUpdate2 = null;
    
         String  Employee_selected2 = "none";
         String  get_Employee_name = null; 
         String  get_Employee_surname= null; 
         String  get_Qualification = null; 
         String  get_Department = null; 
           String  get_Employee_id= null;
    
   
         String    Deducation_Assign_selected = "none";
         String    Deducation_Assign_selected1 = "none";
         String   get_Deducation_Assign_name = null;
          String   get_Deducation_Assign_Tag = null;
          String   get_Deducation_Assign_Tag1 = null;
         String   get_Deducation_Assign_name1 = null;
         String    get_Deducation_Assign_amount  = null;        
         String    get_Deducation_Assign_id  = null;        

          String  Employee_selected3 = "none";
         String  get_Employee_id3= null;
            int xx = 0;
            int yy = 0;
            String Search_EmployeeID = null;

        Accountant_Eearning_Entry() {
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
            Logger.getLogger(Accountant_Eearning_Entry.class.getName()).log(Level.SEVERE, null, ex);
          }
       
       
       
          
    }
  
    
    
       public void Count_Roomtype() {
    
        
       
           try {
             
            conn = DBConnection.getConnction();
            pps7 = conn.prepareStatement("SELECT COUNT(earning_joint_id) FROM earning INNER JOIN earning_joint ON earning.Earning_id = earning_joint.Earning_id INNER JOIN employee ON employee.user_login_id = earning_joint.user_login_id WHERE employee.user_login_id = earning_joint.user_login_id");
            rs7 = pps7.executeQuery();
            if (rs7.next()) {
                String sum = rs7.getString("count(earning_joint_id)");
               
                jLabel77.setText(sum);
            }
        } catch (SQLException ex) {Logger.getLogger(Accountant_Eearning_Entry.class.getName()).log(Level.SEVERE, null, ex);  }

           
           
             try {
              
                 
             Date date = new Date();
             java.sql.Date sqldate = new java.sql.Date(date.getTime());
             
            conn = DBConnection.getConnction();
            pps8 = conn.prepareStatement("SELECT  count(Earning_id) FROM   earning ");
            rs8 = pps8.executeQuery();
            if (rs8.next()) {
                String sum = rs8.getString("count(earning_id)");
                students_tata.setText(sum);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Eearning_Entry.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   

      
             try {
              
                 
         
            conn = DBConnection.getConnction();
            pps10 = conn.prepareStatement("SELECT count(Expenses_id) FROM expenses WHERE YEARWEEK(Date) = YEARWEEK(NOW())");
            rs10 = pps10.executeQuery();
            if (rs10.next()) {
                String sum = rs10.getString("count(Expenses_id)");
                lb_payment_counter.setText(sum);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Eearning_Entry.class.getName()).log(Level.SEVERE, null, ex);
        }
       

        
       
       }
   
  

    public void ShowRoomType_onTable() {//school srtucture
        try {
            conn = DBConnection.getConnction();
            String sql = "SELECT name,surname,employeeid, Earning_name,Earning_amount FROM earning INNER JOIN earning_joint ON earning.Earning_id = earning_joint.Earning_id INNER JOIN employee ON employee.user_login_id = earning_joint.user_login_id WHERE  employee.user_login_id = earning_joint.user_login_id ";
            pps2 = conn.prepareStatement(sql);
            rs2 = pps2.executeQuery();
            Employee_withDeducations_table.setModel(DbUtils.resultSetToTableModel(rs2));
                       

        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Eearning_Entry.class.getName()).log(Level.SEVERE, null, ex);
        }

        
           
         try {
            conn = DBConnection.getConnction();
            String sql = " SELECT  Tag_name, Earning_name,Earning_amount, Date  FROM  earning";
            pps11 = conn.prepareStatement(sql);
            rs11= pps11.executeQuery();
            Deducation_table1.setModel(DbUtils.resultSetToTableModel(rs11));
                        

        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Eearning_Entry.class.getName()).log(Level.SEVERE, null, ex);
        }

        
         try {
      
         conn = DBConnection.getConnction();
         String sql = " SELECT name,surname,qualification,department,designation FROM employee";
         pps = conn.prepareStatement(sql);
         rs = pps.executeQuery();
         Employee_List_Earing.setModel(DbUtils.resultSetToTableModel(rs));
    } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
         //rooms on the  
        
         
           
         
         
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        frontSide_btn_holder = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        Add_Earning_button = new javax.swing.JLabel();
        Assign_Button = new javax.swing.JLabel();
        Add_Slip_button = new javax.swing.JLabel();
        right = new javax.swing.JPanel();
        building_classes_panel = new javax.swing.JPanel();
        Complaint_view = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        Add_price3 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        user_img1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        Deducation_Search_Employee = new javax.swing.JTextField();
        Delecte11 = new javax.swing.JLabel();
        Delecte12 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jLabel209 = new javax.swing.JLabel();
        jLabel213 = new javax.swing.JLabel();
        jLabel215 = new javax.swing.JLabel();
        jLabel216 = new javax.swing.JLabel();
        jLabel225 = new javax.swing.JLabel();
        jScrollPane25 = new javax.swing.JScrollPane();
        Employee_withDeducations_table = new javax.swing.JTable();
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
        Employee_Assign_Vlist = new javax.swing.JPanel();
        jScrollPane29 = new javax.swing.JScrollPane();
        Employee_List_Earing = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        user_img = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lb_Title_holder = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jPanel39 = new javax.swing.JPanel();
        jLabel239 = new javax.swing.JLabel();
        jLabel240 = new javax.swing.JLabel();
        jLabel241 = new javax.swing.JLabel();
        jLabel242 = new javax.swing.JLabel();
        jLabel243 = new javax.swing.JLabel();
        DelecteDeducation1 = new javax.swing.JLabel();
        Delecte26 = new javax.swing.JLabel();
        Delecte27 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        panal_ADD_Dedications = new javax.swing.JPanel();
        DelecteDeducation = new javax.swing.JLabel();
        updateDeducation = new javax.swing.JLabel();
        jScrollPane28 = new javax.swing.JScrollPane();
        Deducation_table1 = new javax.swing.JTable();
        Edit_Deducation = new javax.swing.JLabel();
        Delecte29 = new javax.swing.JLabel();
        Delecte25 = new javax.swing.JLabel();
        Deducationheader3 = new javax.swing.JPanel();
        jLabel232 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        name = new javax.swing.JLabel();
        Earning_Name = new javax.swing.JTextField();
        amount = new javax.swing.JLabel();
        Earning_Amount = new javax.swing.JTextField();
        Delecte28 = new javax.swing.JLabel();
        submit_btn = new javax.swing.JLabel();
        Delecte24 = new javax.swing.JLabel();
        Deducationheader = new javax.swing.JPanel();
        jLabel222 = new javax.swing.JLabel();
        jLabel230 = new javax.swing.JLabel();
        jLabel231 = new javax.swing.JLabel();
        jLabel223 = new javax.swing.JLabel();
        jLabel235 = new javax.swing.JLabel();
        Allocation_panel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane30 = new javax.swing.JScrollPane();
        Deducation_Assign_table = new javax.swing.JTable();
        Deducationheader1 = new javax.swing.JPanel();
        jLabel229 = new javax.swing.JLabel();
        jLabel238 = new javax.swing.JLabel();
        jLabel233 = new javax.swing.JLabel();
        jScrollPane31 = new javax.swing.JScrollPane();
        Deducation_Assigned_table = new javax.swing.JTable();
        Deducationheader2 = new javax.swing.JPanel();
        jLabel244 = new javax.swing.JLabel();
        jLabel234 = new javax.swing.JLabel();
        ASSIGN_Deduction_Button = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        employee_name = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        Designation = new javax.swing.JLabel();
        Capacitylb = new javax.swing.JLabel();
        Qualification = new javax.swing.JLabel();
        Qualification5 = new javax.swing.JLabel();
        Qualification6 = new javax.swing.JLabel();
        UN_Assign = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        Delecte30 = new javax.swing.JLabel();
        Delecte31 = new javax.swing.JLabel();
        PaySlip = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane27 = new javax.swing.JScrollPane();
        Employee_withDeducations_table2 = new javax.swing.JTable();
        jScrollPane26 = new javax.swing.JScrollPane();
        Employee_withDeducations_table1 = new javax.swing.JTable();
        jScrollPane32 = new javax.swing.JScrollPane();
        Employee_TotalIncome_table2 = new javax.swing.JTable();
        jPanel36 = new javax.swing.JPanel();
        jLabel210 = new javax.swing.JLabel();
        jLabel214 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        paid_date = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        designationated = new javax.swing.JLabel();
        lb_name = new javax.swing.JLabel();
        jScrollPane33 = new javax.swing.JScrollPane();
        Employee_TotalIncome_table1 = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        Salary_Total = new javax.swing.JLabel();
        jScrollPane34 = new javax.swing.JScrollPane();
        TotalIncome_table = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        Add_price5 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        lb_Title_holder1 = new javax.swing.JLabel();
        txtSearch1 = new javax.swing.JTextField();
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

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_connect_develop_30px.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        frontSide_btn_holder.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 70));

        Add_Earning_button.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Add_Earning_button.setForeground(new java.awt.Color(255, 255, 255));
        Add_Earning_button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Add_Earning_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_registration_30px_2.png"))); // NOI18N
        Add_Earning_button.setToolTipText(" ADD EARNINGS");
        Add_Earning_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Add_Earning_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_Earning_buttonMouseClicked(evt);
            }
        });
        frontSide_btn_holder.add(Add_Earning_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 60, 70));

        Assign_Button.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Assign_Button.setForeground(new java.awt.Color(255, 255, 255));
        Assign_Button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Assign_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_weight_care_30px.png"))); // NOI18N
        Assign_Button.setToolTipText("ASSIGN MANAGER");
        Assign_Button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Assign_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Assign_ButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Assign_ButtonMouseEntered(evt);
            }
        });
        frontSide_btn_holder.add(Assign_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 60, 70));

        Add_Slip_button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Add_Slip_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_general_ledger_30px.png"))); // NOI18N
        Add_Slip_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_Slip_buttonMouseClicked(evt);
            }
        });
        frontSide_btn_holder.add(Add_Slip_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 60, 60));

        jPanel1.add(frontSide_btn_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 60, 680));

        right.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.add(right, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 760, 1380, 30));

        building_classes_panel.setLayout(new java.awt.CardLayout());

        Complaint_view.setBackground(new java.awt.Color(255, 255, 255));
        Complaint_view.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("View Payslip");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        Complaint_view.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 640, 90, 40));

        Add_price3.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Add_price3.setForeground(new java.awt.Color(255, 255, 255));
        Add_price3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Add_price3.setText("  Allocation   Processing");
        Add_price3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_price3MouseClicked(evt);
            }
        });
        Complaint_view.add(Add_price3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 640, 170, 40));

        jPanel8.setBackground(new java.awt.Color(153, 153, 153));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel10.add(user_img1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 180));

        jPanel8.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 260, 200));

        jLabel20.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("12 : 35");
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 70, 30));

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/conneccter.png"))); // NOI18N
        jPanel8.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, 130));

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Employee");
        jPanel8.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 60, -1));

        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("counter");
        jPanel8.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 80, -1));

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Employee");
        jPanel8.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 60, 10));

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("counter");
        jPanel8.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 80, 10));

        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Employee");
        jPanel8.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 60, 20));

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("counter");
        jPanel8.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 80, 20));

        Deducation_Search_Employee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Deducation_Search_EmployeeKeyTyped(evt);
            }
        });
        jPanel8.add(Deducation_Search_Employee, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, 20));

        Complaint_view.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 160, 280, 470));

        Delecte11.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte11.setForeground(new java.awt.Color(255, 255, 255));
        Delecte11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        Complaint_view.add(Delecte11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 620, 120, 70));

        Delecte12.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte12.setForeground(new java.awt.Color(255, 255, 255));
        Delecte12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        Complaint_view.add(Delecte12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 620, 390, 70));

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));
        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel209.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel209.setForeground(new java.awt.Color(102, 102, 102));
        jLabel209.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel209.setText("Earning name");
        jPanel35.add(jLabel209, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 140, 50));

        jLabel213.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel213.setForeground(new java.awt.Color(102, 102, 102));
        jLabel213.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel213.setText("Name");
        jPanel35.add(jLabel213, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 120, 50));

        jLabel215.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel215.setForeground(new java.awt.Color(102, 102, 102));
        jLabel215.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel215.setText("Surname");
        jPanel35.add(jLabel215, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 120, 50));

        jLabel216.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel216.setForeground(new java.awt.Color(102, 102, 102));
        jLabel216.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel216.setText("Employee ID");
        jPanel35.add(jLabel216, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 100, 50));

        jLabel225.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel225.setForeground(new java.awt.Color(102, 102, 102));
        jLabel225.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel225.setText("Earning Amount");
        jPanel35.add(jLabel225, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 150, 50));

        Complaint_view.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 1210, 50));

        Employee_withDeducations_table.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Employee_withDeducations_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Employee_withDeducations_table.setGridColor(new java.awt.Color(255, 255, 255));
        Employee_withDeducations_table.setIntercellSpacing(new java.awt.Dimension(20, 5));
        Employee_withDeducations_table.setRowHeight(30);
        Employee_withDeducations_table.setTableHeader(null);
        Employee_withDeducations_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Employee_withDeducations_tableMouseClicked(evt);
            }
        });
        jScrollPane25.setViewportView(Employee_withDeducations_table);

        Complaint_view.add(jScrollPane25, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 920, 470));

        table_holder_bg8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        table_holder_bg8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/display.png"))); // NOI18N
        Complaint_view.add(table_holder_bg8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-130, 120, 1340, 550));

        pExpenses.setBackground(new java.awt.Color(95, 158, 160));
        pExpenses.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        pExpenses.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel77.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setText("0");
        jLabel77.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 60, 30));

        lb_payment_counter.setFont(new java.awt.Font("Tw Cen MT", 0, 13)); // NOI18N
        lb_payment_counter.setForeground(new java.awt.Color(0, 204, 51));
        lb_payment_counter.setText("0");
        lb_payment_counter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(lb_payment_counter, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 50, 80, 20));

        lb_payment_pending.setFont(new java.awt.Font("Tw Cen MT", 0, 11)); // NOI18N
        lb_payment_pending.setForeground(new java.awt.Color(255, 255, 255));
        lb_payment_pending.setText("All   Earnings");
        lb_payment_pending.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(lb_payment_pending, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 90, 30));

        lb_payments.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        lb_payments.setForeground(new java.awt.Color(255, 255, 255));
        lb_payments.setText("Assigned Earnings");
        lb_payments.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(lb_payments, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 160, 30));

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Currency_Settings_30px.png"))); // NOI18N
        jLabel38.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 40, 80));

        lb_payment_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/shortcut2.png"))); // NOI18N
        lb_payment_bg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_payment_bg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_payment_bgMouseClicked(evt);
            }
        });
        pExpenses.add(lb_payment_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 330, 120));

        students_tata.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        students_tata.setForeground(new java.awt.Color(255, 255, 102));
        students_tata.setText("6");
        students_tata.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(students_tata, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 70, 20));

        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_binder_30px_1.png"))); // NOI18N
        jLabel71.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 40, 60));

        lb_students.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        lb_students.setForeground(new java.awt.Color(255, 255, 255));
        lb_students.setText("Earnings Level");
        lb_students.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(lb_students, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 140, 30));

        lb_students_pending.setFont(new java.awt.Font("Tw Cen MT", 0, 11)); // NOI18N
        lb_students_pending.setForeground(new java.awt.Color(255, 255, 255));
        lb_students_pending.setText("All  Earnings");
        lb_students_pending.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(lb_students_pending, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 90, 40));

        lb_student_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/shortcut.png"))); // NOI18N
        lb_student_bg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_student_bg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_student_bgMouseClicked(evt);
            }
        });
        pExpenses.add(lb_student_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 340, 70));

        jLabel78.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setText("   Weekly Expenses");
        jLabel78.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 180, 40));

        jLabel39.setFont(new java.awt.Font("Tw Cen MT", 0, 11)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Weeky");
        jLabel39.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 40, 40, 40));

        jLabel79.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Escalator_Down_30px.png"))); // NOI18N
        pExpenses.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 20, 40, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/shortcut3.png"))); // NOI18N
        pExpenses.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, 330, 90));

        jLabel3.setText("jLabel3");
        pExpenses.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 24, -1, 40));

        Complaint_view.add(pExpenses, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 100));

        building_classes_panel.add(Complaint_view, "card2");

        Employee_Assign_Vlist.setBackground(new java.awt.Color(239, 234, 234));
        Employee_Assign_Vlist.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Employee_List_Earing.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Employee_List_Earing.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Employee_List_Earing.setGridColor(new java.awt.Color(255, 255, 255));
        Employee_List_Earing.setIntercellSpacing(new java.awt.Dimension(20, 5));
        Employee_List_Earing.setRowHeight(30);
        Employee_List_Earing.setTableHeader(null);
        Employee_List_Earing.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Employee_List_EaringMouseClicked(evt);
            }
        });
        jScrollPane29.setViewportView(Employee_List_Earing);

        Employee_Assign_Vlist.add(jScrollPane29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 950, 380));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(user_img, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 180));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 260, 200));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("12 : 35");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 70, 30));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/conneccter.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 80, 130));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Employee");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 60, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("counter");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 80, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Employee");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 60, 10));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("counter");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 80, 10));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Employee");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 60, 20));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("counter");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 80, 20));

        Employee_Assign_Vlist.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 70, 280, 370));

        lb_Title_holder.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lb_Title_holder.setForeground(new java.awt.Color(153, 153, 153));
        lb_Title_holder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Search_15px.png"))); // NOI18N
        lb_Title_holder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_Title_holderMouseEntered(evt);
            }
        });
        Employee_Assign_Vlist.add(lb_Title_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 20, 20, 30));

        txtSearch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });
        Employee_Assign_Vlist.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 20, 270, 30));

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel239.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel239.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel239.setText("Designation");
        jPanel39.add(jLabel239, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 100, 50));

        jLabel240.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel240.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel240.setText("  Name");
        jPanel39.add(jLabel240, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 150, 40));

        jLabel241.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel241.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel241.setText("Qualification");
        jPanel39.add(jLabel241, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 120, 50));

        jLabel242.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel242.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel242.setText("Surname");
        jPanel39.add(jLabel242, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 120, 50));

        jLabel243.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel243.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel243.setText("Department");
        jPanel39.add(jLabel243, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 120, 50));

        Employee_Assign_Vlist.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 950, 50));

        DelecteDeducation1.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        DelecteDeducation1.setForeground(new java.awt.Color(255, 255, 255));
        DelecteDeducation1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_no_entry_25px.png"))); // NOI18N
        DelecteDeducation1.setText("  Earning Allocation ");
        DelecteDeducation1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DelecteDeducation1MouseClicked(evt);
            }
        });
        Employee_Assign_Vlist.add(DelecteDeducation1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, 170, 50));

        Delecte26.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte26.setForeground(new java.awt.Color(255, 255, 255));
        Delecte26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        Employee_Assign_Vlist.add(Delecte26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 230, 60));

        Delecte27.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte27.setForeground(new java.awt.Color(255, 255, 255));
        Delecte27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        Employee_Assign_Vlist.add(Delecte27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 330, 60));

        jPanel5.setBackground(new java.awt.Color(255, 102, 0));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Employee_Assign_Vlist.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 470, 360, 150));

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("0000");
        jPanel6.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 120, 40));

        jLabel30.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Currency_Settings_30px.png"))); // NOI18N
        jLabel30.setText("Earning Allocations");
        jPanel6.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 180, 40));

        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Total Earnings :");
        jPanel6.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 110, 40));

        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Total Earnings :");
        jPanel6.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 110, 40));

        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("00000");
        jPanel6.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 120, 40));

        Employee_Assign_Vlist.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 380, 150));

        jPanel7.setBackground(new java.awt.Color(0, 153, 153));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Employee_Assign_Vlist.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 470, 380, 150));

        building_classes_panel.add(Employee_Assign_Vlist, "card4");

        panal_ADD_Dedications.setBackground(new java.awt.Color(255, 255, 255));
        panal_ADD_Dedications.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DelecteDeducation.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        DelecteDeducation.setForeground(new java.awt.Color(255, 255, 255));
        DelecteDeducation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_no_entry_25px.png"))); // NOI18N
        DelecteDeducation.setText("Delecte");
        DelecteDeducation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DelecteDeducationMouseClicked(evt);
            }
        });
        panal_ADD_Dedications.add(DelecteDeducation, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 630, 110, 50));

        updateDeducation.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        updateDeducation.setForeground(new java.awt.Color(255, 255, 255));
        updateDeducation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        updateDeducation.setText("Update");
        updateDeducation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateDeducationMouseClicked(evt);
            }
        });
        panal_ADD_Dedications.add(updateDeducation, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 630, 70, 50));

        Deducation_table1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Deducation_table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Deducation_table1.setGridColor(new java.awt.Color(255, 255, 255));
        Deducation_table1.setIntercellSpacing(new java.awt.Dimension(20, 5));
        Deducation_table1.setRowHeight(30);
        Deducation_table1.setTableHeader(null);
        Deducation_table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Deducation_table1MouseClicked(evt);
            }
        });
        jScrollPane28.setViewportView(Deducation_table1);

        panal_ADD_Dedications.add(jScrollPane28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 760, 520));

        Edit_Deducation.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Edit_Deducation.setForeground(new java.awt.Color(255, 255, 255));
        Edit_Deducation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Edit_Deducation.setText("Edit");
        Edit_Deducation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Edit_DeducationMouseClicked(evt);
            }
        });
        panal_ADD_Dedications.add(Edit_Deducation, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 630, 80, 50));

        Delecte29.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte29.setForeground(new java.awt.Color(255, 255, 255));
        Delecte29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        panal_ADD_Dedications.add(Delecte29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 180, 60));

        Delecte25.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte25.setForeground(new java.awt.Color(255, 255, 255));
        Delecte25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        panal_ADD_Dedications.add(Delecte25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, 400, 60));

        Deducationheader3.setBackground(new java.awt.Color(153, 153, 153));
        Deducationheader3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel232.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel232.setForeground(new java.awt.Color(255, 255, 255));
        jLabel232.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel232.setText("Tag Name");
        Deducationheader3.add(jLabel232, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 140, 30));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Earnings", "Deducations", "Basic Salary", " " }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        Deducationheader3.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 280, 30));

        name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        name.setText("Earning  Name");
        Deducationheader3.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 140, 30));
        Deducationheader3.add(Earning_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 280, 30));

        amount.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        amount.setForeground(new java.awt.Color(255, 255, 255));
        amount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        amount.setText("Earning  Amount");
        Deducationheader3.add(amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 150, 30));
        Deducationheader3.add(Earning_Amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 280, 30));

        Delecte28.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte28.setForeground(new java.awt.Color(255, 255, 255));
        Delecte28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        Deducationheader3.add(Delecte28, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 630, 400, 60));

        submit_btn.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        submit_btn.setForeground(new java.awt.Color(255, 255, 255));
        submit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        submit_btn.setText("  Submit");
        submit_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submit_btnMouseClicked(evt);
            }
        });
        Deducationheader3.add(submit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 120, 40));

        Delecte24.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte24.setForeground(new java.awt.Color(255, 255, 255));
        Delecte24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        Deducationheader3.add(Delecte24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 180, 40));

        panal_ADD_Dedications.add(Deducationheader3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 100, 440, 260));

        Deducationheader.setBackground(new java.awt.Color(153, 153, 153));
        Deducationheader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel222.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel222.setForeground(new java.awt.Color(255, 255, 255));
        jLabel222.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel222.setText("Description");
        Deducationheader.add(jLabel222, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 170, 50));

        jLabel230.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel230.setForeground(new java.awt.Color(255, 255, 255));
        jLabel230.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel230.setText("  Amount");
        Deducationheader.add(jLabel230, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 150, 50));

        jLabel231.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel231.setForeground(new java.awt.Color(255, 255, 255));
        jLabel231.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel231.setText("Allocation Entry");
        Deducationheader.add(jLabel231, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 190, 50));

        jLabel223.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel223.setForeground(new java.awt.Color(255, 255, 255));
        jLabel223.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel223.setText("  Name Tag");
        Deducationheader.add(jLabel223, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 170, 50));

        jLabel235.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel235.setForeground(new java.awt.Color(255, 255, 255));
        jLabel235.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel235.setText("Entry  Date");
        Deducationheader.add(jLabel235, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 150, 50));

        panal_ADD_Dedications.add(Deducationheader, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 1210, 50));

        building_classes_panel.add(panal_ADD_Dedications, "card8");

        Allocation_panel.setBackground(new Color(255,255,255,1));
        Allocation_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Deducation_Assign_table.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Deducation_Assign_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Deducation_Assign_table.setGridColor(new java.awt.Color(255, 255, 255));
        Deducation_Assign_table.setIntercellSpacing(new java.awt.Dimension(20, 5));
        Deducation_Assign_table.setRowHeight(30);
        Deducation_Assign_table.setTableHeader(null);
        Deducation_Assign_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Deducation_Assign_tableMouseClicked(evt);
            }
        });
        jScrollPane30.setViewportView(Deducation_Assign_table);

        jPanel4.add(jScrollPane30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 400, 310));

        Deducationheader1.setBackground(new java.awt.Color(204, 204, 204));
        Deducationheader1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel229.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel229.setForeground(new java.awt.Color(102, 102, 102));
        jLabel229.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel229.setText("Description");
        Deducationheader1.add(jLabel229, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 90, 50));

        jLabel238.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel238.setForeground(new java.awt.Color(102, 102, 102));
        jLabel238.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel238.setText(" Amount");
        Deducationheader1.add(jLabel238, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 100, 50));

        jLabel233.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel233.setForeground(new java.awt.Color(102, 102, 102));
        jLabel233.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel233.setText("Tag Name");
        Deducationheader1.add(jLabel233, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 50));

        jPanel4.add(Deducationheader1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 400, 50));

        Deducation_Assigned_table.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Deducation_Assigned_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Deducation_Assigned_table.setGridColor(new java.awt.Color(255, 255, 255));
        Deducation_Assigned_table.setIntercellSpacing(new java.awt.Dimension(20, 5));
        Deducation_Assigned_table.setRowHeight(30);
        Deducation_Assigned_table.setTableHeader(null);
        Deducation_Assigned_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Deducation_Assigned_tableMouseClicked(evt);
            }
        });
        jScrollPane31.setViewportView(Deducation_Assigned_table);

        jPanel4.add(jScrollPane31, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 320, 310));

        Deducationheader2.setBackground(new java.awt.Color(204, 204, 204));
        Deducationheader2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel244.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel244.setForeground(new java.awt.Color(102, 102, 102));
        jLabel244.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel244.setText("Assigned Deducation ");
        Deducationheader2.add(jLabel244, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 150, 50));

        jLabel234.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel234.setForeground(new java.awt.Color(102, 102, 102));
        jLabel234.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel234.setText("Tag Name");
        Deducationheader2.add(jLabel234, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 90, 50));

        jPanel4.add(Deducationheader2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 400, 50));

        ASSIGN_Deduction_Button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ASSIGN_Deduction_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_direction_30px.png"))); // NOI18N
        ASSIGN_Deduction_Button.setToolTipText("Assign");
        ASSIGN_Deduction_Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ASSIGN_Deduction_ButtonMouseClicked(evt);
            }
        });
        jPanel4.add(ASSIGN_Deduction_Button, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 60, 60));

        jPanel14.setBackground(new java.awt.Color(66, 66, 66));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel53.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(161, 169, 171));
        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        jLabel53.setText("Employee  :");
        jPanel14.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 40));

        employee_name.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        employee_name.setForeground(new java.awt.Color(110, 156, 182));
        employee_name.setText("Profession");
        jPanel14.add(employee_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 170, 40));

        jLabel80.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(161, 169, 171));
        jLabel80.setText("Designation :");
        jPanel14.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 80, 40));

        Designation.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        Designation.setForeground(new java.awt.Color(110, 156, 182));
        Designation.setText("SUBJECT");
        jPanel14.add(Designation, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 120, 40));

        Capacitylb.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        Capacitylb.setForeground(new java.awt.Color(110, 156, 182));
        Capacitylb.setText("SUBJECT");
        jPanel14.add(Capacitylb, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 0, 130, 40));

        Qualification.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        Qualification.setForeground(new java.awt.Color(110, 156, 182));
        Qualification.setText("Qualification");
        jPanel14.add(Qualification, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 100, 40));

        Qualification5.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        Qualification5.setForeground(new java.awt.Color(161, 169, 171));
        Qualification5.setText(" ID :");
        jPanel14.add(Qualification5, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 0, 40, 40));

        Qualification6.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        Qualification6.setForeground(new java.awt.Color(161, 169, 171));
        Qualification6.setText("Qualification:");
        jPanel14.add(Qualification6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 90, 40));

        jPanel4.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 40));

        UN_Assign.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UN_Assign.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_close_window_25px.png"))); // NOI18N
        UN_Assign.setToolTipText("Un-Assign");
        UN_Assign.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UN_AssignMouseClicked(evt);
            }
        });
        jPanel4.add(UN_Assign, new org.netbeans.lib.awtextra.AbsoluteConstraints(424, 310, 70, 50));

        Allocation_panel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 960, 430));

        jLabel28.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("View Payslip");
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });
        Allocation_panel.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 630, 110, 50));

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("BACK");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        Allocation_panel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 630, 90, 50));

        Delecte30.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte30.setForeground(new java.awt.Color(255, 255, 255));
        Delecte30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        Allocation_panel.add(Delecte30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 130, 60));

        Delecte31.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte31.setForeground(new java.awt.Color(255, 255, 255));
        Delecte31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        Allocation_panel.add(Delecte31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, 320, 60));

        building_classes_panel.add(Allocation_panel, "card6");

        PaySlip.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Employee_withDeducations_table2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Employee_withDeducations_table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Employee_withDeducations_table2.setGridColor(new java.awt.Color(255, 255, 255));
        Employee_withDeducations_table2.setIntercellSpacing(new java.awt.Dimension(20, 5));
        Employee_withDeducations_table2.setRowHeight(30);
        Employee_withDeducations_table2.setTableHeader(null);
        Employee_withDeducations_table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Employee_withDeducations_table2MouseClicked(evt);
            }
        });
        jScrollPane27.setViewportView(Employee_withDeducations_table2);

        jPanel9.add(jScrollPane27, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 450, 300));

        Employee_withDeducations_table1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Employee_withDeducations_table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Employee_withDeducations_table1.setGridColor(new java.awt.Color(255, 255, 255));
        Employee_withDeducations_table1.setIntercellSpacing(new java.awt.Dimension(20, 5));
        Employee_withDeducations_table1.setRowHeight(30);
        Employee_withDeducations_table1.setTableHeader(null);
        Employee_withDeducations_table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Employee_withDeducations_table1MouseClicked(evt);
            }
        });
        jScrollPane26.setViewportView(Employee_withDeducations_table1);

        jPanel9.add(jScrollPane26, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 470, 300));

        Employee_TotalIncome_table2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Employee_TotalIncome_table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Employee_TotalIncome_table2.setGridColor(new java.awt.Color(255, 255, 255));
        Employee_TotalIncome_table2.setIntercellSpacing(new java.awt.Dimension(20, 5));
        Employee_TotalIncome_table2.setRowHeight(30);
        Employee_TotalIncome_table2.setTableHeader(null);
        Employee_TotalIncome_table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Employee_TotalIncome_table2MouseClicked(evt);
            }
        });
        jScrollPane32.setViewportView(Employee_TotalIncome_table2);

        jPanel9.add(jScrollPane32, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 450, 460, 40));

        jPanel36.setBackground(new java.awt.Color(204, 208, 212));
        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel210.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel210.setForeground(new java.awt.Color(102, 102, 102));
        jLabel210.setText("Deducation ");
        jPanel36.add(jLabel210, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 140, 50));

        jLabel214.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel214.setForeground(new java.awt.Color(102, 102, 102));
        jLabel214.setText("Earnings");
        jPanel36.add(jLabel214, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 50));

        jPanel9.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 910, 50));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Month And Year:");
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 110, 30));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Designation :");
        jPanel9.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 110, 30));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Employee Name :");
        jPanel9.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 110, 30));

        jLabel16.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Company Name ");
        jPanel9.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, 220, 30));

        paid_date.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        paid_date.setForeground(new java.awt.Color(102, 102, 102));
        paid_date.setText("Employee Name ");
        jPanel9.add(paid_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 320, 30));

        jLabel34.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(102, 102, 102));
        jLabel34.setText("Employee Name ");
        jPanel9.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 60, 160, 30));

        designationated.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        designationated.setForeground(new java.awt.Color(102, 102, 102));
        designationated.setText("Employee Name ");
        jPanel9.add(designationated, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 320, 30));

        lb_name.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        lb_name.setForeground(new java.awt.Color(102, 102, 102));
        lb_name.setText("Employee Name ");
        jPanel9.add(lb_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 320, 30));

        Employee_TotalIncome_table1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Employee_TotalIncome_table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Employee_TotalIncome_table1.setGridColor(new java.awt.Color(255, 255, 255));
        Employee_TotalIncome_table1.setIntercellSpacing(new java.awt.Dimension(20, 5));
        Employee_TotalIncome_table1.setRowHeight(30);
        Employee_TotalIncome_table1.setTableHeader(null);
        Employee_TotalIncome_table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Employee_TotalIncome_table1MouseClicked(evt);
            }
        });
        jScrollPane33.setViewportView(Employee_TotalIncome_table1);

        jPanel9.add(jScrollPane33, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 460, 40));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("NET SALARY");
        jPanel9.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 490, 220, 30));

        Salary_Total.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel9.add(Salary_Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 490, 190, 30));

        TotalIncome_table.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TotalIncome_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TotalIncome_table.setGridColor(new java.awt.Color(255, 255, 255));
        TotalIncome_table.setIntercellSpacing(new java.awt.Dimension(20, 5));
        TotalIncome_table.setRowHeight(30);
        TotalIncome_table.setTableHeader(null);
        TotalIncome_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TotalIncome_tableMouseClicked(evt);
            }
        });
        jScrollPane34.setViewportView(TotalIncome_table);

        jPanel9.add(jScrollPane34, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 910, 40));

        PaySlip.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1000, 680));

        jPanel11.setBackground(new java.awt.Color(102, 102, 102));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Add_price5.setBackground(new java.awt.Color(255, 255, 255));
        Add_price5.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Add_price5.setForeground(new java.awt.Color(153, 153, 153));
        Add_price5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Add_price5.setText("  Print");
        Add_price5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_price5MouseClicked(evt);
            }
        });
        jPanel11.add(Add_price5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 80, 50));

        jLabel35.setForeground(new java.awt.Color(204, 204, 204));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("BACK");
        jLabel35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel35MouseClicked(evt);
            }
        });
        jPanel11.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 60, 60));

        lb_Title_holder1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lb_Title_holder1.setForeground(new java.awt.Color(153, 153, 153));
        lb_Title_holder1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Search_15px.png"))); // NOI18N
        lb_Title_holder1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_Title_holder1MouseEntered(evt);
            }
        });
        jPanel11.add(lb_Title_holder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 20, 30));

        txtSearch1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSearch1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearch1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearch1KeyTyped(evt);
            }
        });
        jPanel11.add(txtSearch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, 30));

        PaySlip.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 30, 260, 120));

        building_classes_panel.add(PaySlip, "card6");

        jPanel1.add(building_classes_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 1280, 690));

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
        admin_btn.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 40));

        jPanel1.add(admin_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 40));

        jLabel37.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Hi Admin,  Welcome To Report  Management");
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 310, 40));

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
       
         
                    Accountant_Home_Page.getObj().setVisible(true);
                    //passing user id 
                    Accountant_Home_Page.getObj().setUserID(Recieved_user_id);
                    Accountant_Home_Page.getObj().printUserID();

                    this.dispose();   
        

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
        this.setExtendedState(Accountant_Eearning_Entry.ICONIFIED);
    }//GEN-LAST:event_minize_lbMouseClicked

    String get_expenses_id = null;
    
    
  public void Delecte_expenses() {
  
    try {
             conn = DBConnection.getConnction();
             pps3 = conn.prepareStatement("DELETE  FROM  earning WHERE  Earning_id = ? ");
             pps3.setString(1, get_Expense_id_toUpdate);
             pps3.executeUpdate();
             JOptionPane.showMessageDialog(null, "Earning Delected" );
            
             
            } catch (SQLException ex) {
            Logger.getLogger(Accountant_Eearning_Entry.class.getName()).log(Level.SEVERE, null, ex);
            }
           
           
           
           
           
           ShowRoomType_onTable() ;
           Count_Roomtype();
  
  }
    
    
    
    
    
    
    
    
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
        try {
            conn = DBConnection.getConnction();
            String sql = " SELECT payment_to,payment_method, description,Amount,Date,Due_date  FROM expenses";
            pps2 = conn.prepareStatement(sql);
            rs2 = pps2.executeQuery();
            Employee_withDeducations_table.setModel(DbUtils.resultSetToTableModel(rs2));
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Eearning_Entry.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_lb_payment_bgMouseClicked

    private void lb_student_bgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_student_bgMouseClicked
      
        
        
        try {
             Date date = new Date();
             java.sql.Date sqldate = new java.sql.Date(date.getTime());
            
            
            
            conn = DBConnection.getConnction();
            String sql = " SELECT payment_to,payment_method, description,Amount,Date,Due_date  FROM expenses WHERE date =? ";
            pps2 = conn.prepareStatement(sql);
            pps2.setDate(1, sqldate);
            rs2 = pps2.executeQuery();
            Employee_withDeducations_table.setModel(DbUtils.resultSetToTableModel(rs2));
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Eearning_Entry.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_lb_student_bgMouseClicked

    private void Employee_withDeducations_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Employee_withDeducations_tableMouseClicked
         
        
        DefaultTableModel tableMode_type = (DefaultTableModel) Employee_withDeducations_table.getModel();
          get_Payment_To = tableMode_type.getValueAt(Employee_withDeducations_table.getSelectedRow(), 0).toString();
        
         DefaultTableModel tableMode_type1 = (DefaultTableModel) Employee_withDeducations_table.getModel();
         get_Amount = tableMode_type1.getValueAt(Employee_withDeducations_table.getSelectedRow(), 3).toString();
         
        
         
         DefaultTableModel tableMode_type2 = (DefaultTableModel) Employee_withDeducations_table.getModel();
         get_Date = tableMode_type2.getValueAt(Employee_withDeducations_table.getSelectedRow(), 4).toString();
        
         DefaultTableModel tableMode_type3 = (DefaultTableModel) Employee_withDeducations_table.getModel();
           get_description= tableMode_type3.getValueAt(Employee_withDeducations_table.getSelectedRow(),2).toString();
         
            subject_selected2 = "selected";
        subject_selected = "selected";
        
        

        
        
        
        
        
    }//GEN-LAST:event_Employee_withDeducations_tableMouseClicked
  
    private void Add_price3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_price3MouseClicked
         Employee_Assign_Vlist.hide();
        Complaint_view.hide();
        panal_ADD_Dedications.setVisible(true); 
    }//GEN-LAST:event_Add_price3MouseClicked

    
   
    
    
    
    
    private void Assign_ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Assign_ButtonMouseClicked
   
               
        
        
       Complaint_view.hide();
       
        panal_ADD_Dedications.hide();
        Employee_Assign_Vlist.setVisible(true);
        
        
    }//GEN-LAST:event_Assign_ButtonMouseClicked

    private void DelecteDeducationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DelecteDeducationMouseClicked
         if (Deducation_subject_selected.equals("none")) {
            JOptionPane.showMessageDialog(null, "Select the Earning you wish to Edit");
            
        } else if (!Deducation_subject_selected.equals("none")) {
        
        
        
          try {
             conn = DBConnection.getConnction();
             String sql = "SELECT  * FROM earning WHERE Earning_name = ? AND Earning_amount  = ? AND Date = ? ";
            pps4 = conn.prepareStatement(sql);
            pps4.setString(1 , get_Deducation_name);
            pps4.setString(2 , get_Deducation_amount );
            pps4.setString(3, get_Deducation_date );
           
             rs4 = pps4.executeQuery();
              if(rs4.next()){
              
               
                get_Deducation_id_toUpdate2 = rs4.getString("Earning_id");
                Delecte_Deducation();
              }
             
             
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
          
         
          
        }
    }//GEN-LAST:event_DelecteDeducationMouseClicked

    public void Delecte_Deducation() {
  
    try {
             conn = DBConnection.getConnction();
             pps3 = conn.prepareStatement("DELETE  FROM  earning WHERE  Earning_id = ? ");
             pps3.setString(1, get_Deducation_id_toUpdate2);
             pps3.executeUpdate();
             JOptionPane.showMessageDialog(null, "Earning Delected" );
            
             
            } catch (SQLException ex) {
            Logger.getLogger(Accountant_Eearning_Entry.class.getName()).log(Level.SEVERE, null, ex);
            }
           
           
           
           
           
           ShowRoomType_onTable() ;
           Count_Roomtype();
  
  }
    
    
    
    private void updateDeducationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateDeducationMouseClicked
          Date date1 = new Date();
         java.sql.Date sqldate = new java.sql.Date(date1.getTime());
         
         String obtaned =  jComboBox1.getSelectedItem().toString().trim();
        try {
                 conn = DBConnection.getConnction();
                String sql = "UPDATE  earning SET Tag_name =?, Earning_name =?,Earning_amount =?,Date =?  WHERE Earning_id =? ";
                pps5 = conn.prepareStatement(sql);
                 pps5.setString(1 , obtaned);
                 pps5.setString(2 , Earning_Name.getText());
                 pps5.setString(3 , Earning_Amount.getText());
                 pps5.setDate(4, sqldate);
                 pps5.setString(5 ,get_Deducation_id_toUpdate2 );
                  
                pps5.executeUpdate();
               
                  Earning_Name.setText(null);
                  Earning_Amount.setText(null);
                 
                  JOptionPane.showMessageDialog(null, "Successfully Updated");
                  submit_btn.setVisible(true);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
         ShowRoomType_onTable() ;
         Count_Roomtype();
        
        
        
        
    }//GEN-LAST:event_updateDeducationMouseClicked

    private void Deducation_table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Deducation_table1MouseClicked
         
        DefaultTableModel tableMode_type = (DefaultTableModel) Deducation_table1.getModel();
          get_Deducation_name = tableMode_type.getValueAt(Deducation_table1.getSelectedRow(),1).toString();
        
         DefaultTableModel tableMode_type1 = (DefaultTableModel) Deducation_table1.getModel();
         get_Deducation_amount = tableMode_type1.getValueAt(Deducation_table1.getSelectedRow(), 2).toString();
         
        
         
         DefaultTableModel tableMode_type2 = (DefaultTableModel) Deducation_table1.getModel();
         get_Deducation_date = tableMode_type2.getValueAt(Deducation_table1.getSelectedRow(), 3).toString();
        
         
           Deducation_subject_selected = "selected";
                
      
    }//GEN-LAST:event_Deducation_table1MouseClicked

    private void submit_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submit_btnMouseClicked
        if(Earning_Name.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Name Field is Empty");
        }else if( Earning_Amount.getText().isEmpty()){
          JOptionPane.showMessageDialog(null, "Amount Field is Empty");
         }else {
     
          String obtaned =  jComboBox1.getSelectedItem().toString().trim();
            
                   try {
             conn = DBConnection.getConnction();
             String sql = "SELECT  * FROM earning WHERE Earning_name = ? AND Earning_amount  = ? AND Tag_name = ? ";
            pps4 = conn.prepareStatement(sql);
            pps4.setString(1 , Earning_Name.getText());
            pps4.setString(2 , Earning_Amount.getText());
            pps4.setString(3, obtaned );
           
             rs4 = pps4.executeQuery();
              if(rs4.next()){
               JOptionPane.showMessageDialog(null, "Records Already Exists");
              }else{
                             insert();

              }
             
             
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
          
      
        }
             
         
         
    }//GEN-LAST:event_submit_btnMouseClicked

    public void insert(){
    
              String obtaned =  jComboBox1.getSelectedItem().toString().trim();
         Date date1 = new Date();
         java.sql.Date sqldate1 = new java.sql.Date(date1.getTime());
          try {
             conn = DBConnection.getConnction();
             String sql = "INSERT INTO earning  (Tag_name,Earning_name,Earning_amount,Date) VALUES (?,?,?,?)";
            pps = conn.prepareStatement(sql);
             pps.setString(1 , obtaned);
            pps.setString(2 , Earning_Name.getText());
            pps.setString(3 , Earning_Amount.getText());
            pps.setDate(4,sqldate1 );
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully Saved" );
            Earning_Name.setText(null);
            Earning_Amount.setText(null);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    
        ShowRoomType_onTable() ;
           Count_Roomtype();
    }
    
    
    
    private void Edit_DeducationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Edit_DeducationMouseClicked
        
           
             
                    
                  if (Deducation_subject_selected.equals("none")) {
            JOptionPane.showMessageDialog(null, "Select the Earning you wish to Edit");
            
        } else if (!Deducation_subject_selected.equals("none")) {
        
        
        
          try {
             conn = DBConnection.getConnction();
             String sql = "SELECT  * FROM earning WHERE Earning_name = ? AND Earning_amount  = ? AND Date = ? ";
            pps4 = conn.prepareStatement(sql);
            pps4.setString(1 , get_Deducation_name);
            pps4.setString(2 , get_Deducation_amount );
            pps4.setString(3, get_Deducation_date );
           
             rs4 = pps4.executeQuery();
              if(rs4.next()){
              
                Earning_Name.setText(rs4.getString("Earning_name"));
                Earning_Amount.setText(rs4.getString("Earning_amount"));
                get_Deducation_id_toUpdate2 = rs4.getString("Earning_id");
                submit_btn.hide();
              }
             
             
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
          
         
          
        }
          
                    
    }//GEN-LAST:event_Edit_DeducationMouseClicked

    private void Add_Earning_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_Earning_buttonMouseClicked
             try {
            conn = DBConnection.getConnction();
            String sql = "SELECT Tag_name, Earning_name,Earning_amount  FROM  earning";
            pps11 = conn.prepareStatement(sql);
            rs11= pps11.executeQuery();
            Deducation_Assign_table.setModel(DbUtils.resultSetToTableModel(rs11));

        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Eearning_Entry.class.getName()).log(Level.SEVERE, null, ex);
        }
        Employee_Assign_Vlist.hide();
        Complaint_view.hide();
        panal_ADD_Dedications.setVisible(true); 
        
    }//GEN-LAST:event_Add_Earning_buttonMouseClicked

    private void Employee_List_EaringMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Employee_List_EaringMouseClicked
         
        DefaultTableModel tableMode_type = (DefaultTableModel) Employee_List_Earing.getModel();
          get_Employee_name = tableMode_type.getValueAt(Employee_List_Earing.getSelectedRow(), 0).toString();
        
         DefaultTableModel tableMode_type1 = (DefaultTableModel) Employee_List_Earing.getModel();
         get_Employee_surname = tableMode_type1.getValueAt(Employee_List_Earing.getSelectedRow(),1).toString();
         
        
         
         DefaultTableModel tableMode_type2 = (DefaultTableModel) Employee_List_Earing.getModel();
         get_Qualification = tableMode_type2.getValueAt(Employee_List_Earing.getSelectedRow(), 2).toString();
        
         DefaultTableModel tableMode_type3 = (DefaultTableModel) Employee_List_Earing.getModel();
           get_Department= tableMode_type3.getValueAt(Employee_List_Earing.getSelectedRow(),3).toString();
         
           Employee_selected2 = "selected";
           Employee_selected3 = "selected";
           getimage();
         
    }//GEN-LAST:event_Employee_List_EaringMouseClicked

    
    public void getimage(){ 
     try {
             conn = DBConnection.getConnction();
             String sql = "SELECT  * FROM employee WHERE (name = ? AND surname  = ?) AND (qualification = ?  AND department = ?)";
            pps4 = conn.prepareStatement(sql);
            pps4.setString(1 , get_Employee_name);
            pps4.setString(2 , get_Employee_surname );
            pps4.setString(3, get_Qualification );
            pps4.setString(4, get_Department );
         
             rs4 = pps4.executeQuery();
               byte[] image = null;
              while(rs4.next()){
               
                 
                 image = rs4.getBytes("image");
                 Image img = Toolkit.getDefaultToolkit().createImage(image);
                 ImageIcon icon = new ImageIcon(img);

                Image modifiedImaged = img.getScaledInstance(user_img.getWidth(), user_img.getHeight(), Image.SCALE_SMOOTH);
                icon = new ImageIcon(modifiedImaged);
                user_img.setIcon(icon);
             
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    
    
    }
    
    
    private void lb_Title_holderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_Title_holderMouseEntered

    }//GEN-LAST:event_lb_Title_holderMouseEntered

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        try {
            conn = DBConnection.getConnction();
            String sql ="SELECT name,surname,qualification,department,designation FROM employee     WHERE name  like '%" + txtSearch.getText() + "%'  OR surname  like '%" + txtSearch.getText() + "%'   OR  qualification  like '%" + txtSearch.getText() + "%'   OR  department  like '%" + txtSearch.getText() + "%' "
            + "  OR  designation  like '%" + txtSearch.getText() + "%'  OR  employeeid  like '%" + txtSearch.getText() + "%'   OR gender  like '%" + txtSearch.getText() + "%' ";
            pps = conn.prepareStatement(sql);
            rs = pps.executeQuery();
            Employee_List_Earing.setModel(DbUtils.resultSetToTableModel(rs));//sho
        } catch (SQLException ex) {Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);
        
        }

    }//GEN-LAST:event_txtSearchKeyTyped

    
    
    
    private void Deducation_Assign_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Deducation_Assign_tableMouseClicked
       
         DefaultTableModel tableMode_type1 = (DefaultTableModel) Deducation_Assign_table.getModel();
         get_Deducation_Assign_Tag = tableMode_type1.getValueAt(Deducation_Assign_table.getSelectedRow(), 0).toString();
         
        
        DefaultTableModel tableMode_type2 = (DefaultTableModel) Deducation_Assign_table.getModel();
          get_Deducation_Assign_name = tableMode_type2.getValueAt(Deducation_Assign_table.getSelectedRow(), 1).toString();
        
         DefaultTableModel tableMode_type3 = (DefaultTableModel) Deducation_Assign_table.getModel();
         get_Deducation_Assign_amount = tableMode_type3.getValueAt(Deducation_Assign_table.getSelectedRow(), 2).toString();
         
           Deducation_Assign_selected = "selected";
           
                 
    }//GEN-LAST:event_Deducation_Assign_tableMouseClicked

    private void Assign_ButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Assign_ButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Assign_ButtonMouseEntered

    private void DelecteDeducation1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DelecteDeducation1MouseClicked
          if (Employee_selected2.equals("none")) {
            JOptionPane.showMessageDialog(null, "Select the Employee");
            
        } else if (!Employee_selected2.equals("none")) {
        
        
          try {
             conn = DBConnection.getConnction();
             String sql = "SELECT  * FROM employee WHERE (name = ? AND surname  = ?) AND (qualification = ?  AND department = ?)";
            pps4 = conn.prepareStatement(sql);
            pps4.setString(1 , get_Employee_name);
            pps4.setString(2 , get_Employee_surname );
            pps4.setString(3, get_Qualification );
            pps4.setString(4, get_Department );
         
             rs4 = pps4.executeQuery();
              
              
             // byte[] image = null;
              if(rs4.next()){
               
                  
                  get_Employee_id = rs4.getString("user_login_id");
                 employee_name.setText(rs4.getString("name")  +"  "+ rs4.getString("surname"));
                 Qualification.setText(rs4.getString("qualification"));
                 Designation.setText(rs4.getString("designation"));
                 Capacitylb.setText(rs4.getString("employeeid"));
              
              }
             
             
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
          
           try {
            conn = DBConnection.getConnction();
            String sql = " SELECT Tag_name,Earning_name,Earning_amount  FROM  earning";
            pps11 = conn.prepareStatement(sql);
            rs11= pps11.executeQuery();
            Deducation_Assign_table.setModel(DbUtils.resultSetToTableModel(rs11));
                        

        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Eearning_Entry.class.getName()).log(Level.SEVERE, null, ex);
        }
         
           
           try {
            conn = DBConnection.getConnction();
            String sql = "SELECT Tag_name, Earning_name FROM earning INNER JOIN earning_joint ON earning.Earning_id = earning_joint.Earning_id INNER JOIN employee ON employee.user_login_id = earning_joint.user_login_id WHERE  earning_joint.user_login_id =?";
            pps11 = conn.prepareStatement(sql);
            pps11.setString(1, get_Employee_id);
            rs11= pps11.executeQuery();
            Deducation_Assigned_table.setModel(DbUtils.resultSetToTableModel(rs11));
                        
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Eearning_Entry.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        Complaint_view.hide();
        panal_ADD_Dedications.hide();
        Employee_Assign_Vlist.hide();
        PaySlip.hide();
        Allocation_panel.setVisible(true);
        }
    }//GEN-LAST:event_DelecteDeducation1MouseClicked

    private void Deducation_Assigned_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Deducation_Assigned_tableMouseClicked
        DefaultTableModel tableMode_type = (DefaultTableModel) Deducation_Assigned_table.getModel();
       get_Deducation_Assign_Tag1 = tableMode_type.getValueAt(Deducation_Assigned_table.getSelectedRow(), 0).toString();
        
        
         DefaultTableModel tableMode_type1 = (DefaultTableModel) Deducation_Assigned_table.getModel();
         get_Deducation_Assign_name1 = tableMode_type1.getValueAt(Deducation_Assigned_table.getSelectedRow(), 1).toString();
        
       
       
           Deducation_Assign_selected1 = "selected";
    }//GEN-LAST:event_Deducation_Assigned_tableMouseClicked

    
    
    String Deductcation_idObtained = null;
    private void ASSIGN_Deduction_ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ASSIGN_Deduction_ButtonMouseClicked
       
                    
        if (Deducation_Assign_selected.equals("none")) {
            JOptionPane.showMessageDialog(null, "Select the Earning you wish to Assign");
            
        } else if (!Deducation_Assign_selected.equals("none")) {
        
        
        
          try {
             conn = DBConnection.getConnction();
             String sql = "SELECT  * FROM earning WHERE Tag_name=? AND Earning_name = ? AND Earning_amount  = ?  ";
            pps4 = conn.prepareStatement(sql);
             pps4.setString(1 , get_Deducation_Assign_Tag);
            pps4.setString(2 , get_Deducation_Assign_name);
            pps4.setString(3 , get_Deducation_Assign_amount);

            rs4 = pps4.executeQuery();
            if(rs4.next()){
                  
              
                 get_Deducation_Assign_id = rs4.getString("Earning_id");
                 Search_if_Exists_INtheJoint();

              }
             
        } catch (SQLException ex) {
              Logger.getLogger(Accountant_Eearning_Entry.class.getName()).log(Level.SEVERE, null, ex);
        }
          
         
        }
    }//GEN-LAST:event_ASSIGN_Deduction_ButtonMouseClicked

    
    String getting_Deducation_id = null;
    private void UN_AssignMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UN_AssignMouseClicked
    
        
              
         if (Deducation_Assign_selected1.equals("none")) {
            JOptionPane.showMessageDialog(null, "Select the Item you wish to Edit");
            
        } else if (!Deducation_Assign_selected1.equals("none")) {
        
        
          try {
            conn = DBConnection.getConnction();
            String sql = "SELECT  * FROM earning WHERE Tag_name =? AND Earning_name = ? ";
            pps4 = conn.prepareStatement(sql);
            pps4.setString(1 , get_Deducation_Assign_Tag1);
            pps4.setString(2 , get_Deducation_Assign_name1);
            rs4 = pps4.executeQuery();
            if(rs4.next()){
                 getting_Deducation_id = rs4.getString("Earning_id");
                 Update_AssignedDeduction();
              }
             
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex); }
          
    
         
          
        }
          
          
        
    }//GEN-LAST:event_UN_AssignMouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked

        Allocation_panel.hide();
        panal_ADD_Dedications.hide();
        Employee_Assign_Vlist.hide();
        Complaint_view.setVisible(true);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void Add_Slip_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_Slip_buttonMouseClicked
       

         Allocation_panel.hide();
        panal_ADD_Dedications.hide();
        Employee_Assign_Vlist.hide();
        Complaint_view.hide();
        PaySlip.setVisible(true);
    }//GEN-LAST:event_Add_Slip_buttonMouseClicked

    private void Employee_withDeducations_table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Employee_withDeducations_table1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Employee_withDeducations_table1MouseClicked

    private void Deducation_Search_EmployeeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Deducation_Search_EmployeeKeyTyped
        try {
            conn = DBConnection.getConnction();
            String sql ="SELECT name,surname,qualification,department,designation FROM employee     WHERE name  like '%" + Deducation_Search_Employee.getText() + "%'  OR surname  like '%" + Deducation_Search_Employee.getText() + "%'   OR  qualification  like '%" + Deducation_Search_Employee.getText() + "%'   OR  department  like '%" + Deducation_Search_Employee.getText() + "%' "
            + "  OR  designation  like '%" + Deducation_Search_Employee.getText() + "%'  OR  employeeid  like '%" + Deducation_Search_Employee.getText() + "%'   OR gender  like '%" + Deducation_Search_Employee.getText() + "%' ";
            pps = conn.prepareStatement(sql);
            rs = pps.executeQuery();
            Employee_withDeducations_table.setModel(DbUtils.resultSetToTableModel(rs));//sho
        } catch (SQLException ex) {Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    }//GEN-LAST:event_Deducation_Search_EmployeeKeyTyped

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
      String obtaned =  jComboBox1.getSelectedItem().toString().trim();
        if(obtaned.equals("Earnings")){
        Earning_Name.setText(null);
        name.setText("Earning Name");
        amount.setText("Earning Amount");
        
        }else if(obtaned.equals("Deducations")){
        Earning_Name.setText(null);
        name.setText("Deducation Name");
        amount.setText("Deducation Amount");
        
        }else if(obtaned.equals("Basic Salary")){
        Earning_Name.setText(null);
          name.setText("Basic Salary");
          amount.setText("Basic Amount");
        Earning_Name.setText("Basic Salary");
        } 
                
                
                
                
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
       Complaint_view.hide();
        panal_ADD_Dedications.hide();
        PaySlip.hide();
       Allocation_panel.hide();
        Employee_Assign_Vlist.setVisible(true);
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
         Allocation_panel.hide();
        panal_ADD_Dedications.hide();
        Employee_Assign_Vlist.hide();
        Complaint_view.hide();
        PaySlip.setVisible(true);
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
      
        
         
         try {
            conn = DBConnection.getConnction();
            String sql = "SELECT  Earning_name, Earning_amount FROM earning INNER JOIN earning_joint ON earning.Earning_id = earning_joint.Earning_id INNER JOIN employee ON employee.user_login_id = earning_joint.user_login_id WHERE  earning_joint.user_login_id =? AND Tag_name = \"Earning\"   OR Tag_name = \"Basic Salary\"  ";
            pps15 = conn.prepareStatement(sql);
            pps15.setString(1, get_Employee_id);
            rs15= pps15.executeQuery();
            Employee_withDeducations_table2.setModel(DbUtils.resultSetToTableModel(rs15));
                        
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Eearning_Entry.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
           try {
            conn = DBConnection.getConnction();
            String sql = "SELECT  Earning_name, Earning_amount FROM earning INNER JOIN earning_joint ON earning.Earning_id = earning_joint.Earning_id INNER JOIN employee ON employee.user_login_id = earning_joint.user_login_id WHERE  earning_joint.user_login_id =? AND Tag_name = \"Deducations\"";
            pps15 = conn.prepareStatement(sql);
            pps15.setString(1, get_Employee_id); 
            rs15= pps15.executeQuery();
            Employee_withDeducations_table1.setModel(DbUtils.resultSetToTableModel(rs15));
                        
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Eearning_Entry.class.getName()).log(Level.SEVERE, null, ex);
        }
      
          try {
              
            conn = DBConnection.getConnction();
            String sql = "SELECT 'Total Adtition', SUM(Earning_amount) FROM earning INNER JOIN earning_joint ON earning.Earning_id = earning_joint.Earning_id INNER JOIN employee ON employee.user_login_id = earning_joint.user_login_id WHERE earning_joint.user_login_id =? AND Tag_name = \"Earning\"";
            pps15 = conn.prepareStatement(sql);
            pps15.setString(1, get_Employee_id); 
            rs15= pps15.executeQuery();
            Employee_TotalIncome_table1.setModel(DbUtils.resultSetToTableModel(rs15));
                        
        } catch (SQLException ex) { Logger.getLogger(Accountant_Eearning_Entry.class.getName()).log(Level.SEVERE, null, ex); }
        
            try {
            conn = DBConnection.getConnction();
            String sql = "SELECT '  Total Deducations', SUM(Earning_amount) FROM earning INNER JOIN earning_joint ON earning.Earning_id = earning_joint.Earning_id INNER JOIN employee ON employee.user_login_id = earning_joint.user_login_id WHERE earning_joint.user_login_id =? AND Tag_name = \"Deducations\"";
            pps11 = conn.prepareStatement(sql);
            pps11.setString(1, get_Employee_id); 
            rs11= pps11.executeQuery();
           
            Employee_TotalIncome_table2.setModel(DbUtils.resultSetToTableModel(rs11));
                        
        } catch (SQLException ex) {Logger.getLogger(Accountant_Eearning_Entry.class.getName()).log(Level.SEVERE, null, ex); }
            
            
          String totalEarning= null;
          try {
              
            conn = DBConnection.getConnction();
            String sql = "SELECT 'Total Adtition', SUM(Earning_amount) FROM earning INNER JOIN earning_joint ON earning.Earning_id = earning_joint.Earning_id INNER JOIN employee ON employee.user_login_id = earning_joint.user_login_id WHERE earning_joint.user_login_id =? AND Tag_name = \"Earning\"";
            pps15 = conn.prepareStatement(sql);
            pps15.setString(1, get_Employee_id); 
            rs15= pps15.executeQuery();
            if(rs15.next()){
            
            totalEarning = rs15.getString("SUM(Earning_amount)");
           // Employee_TotalIncome_table1.setModel(DbUtils.resultSetToTableModel(rs15));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Eearning_Entry.class.getName()).log(Level.SEVERE, null, ex);
        }
         String totalDeducation = null;
            try {
            conn = DBConnection.getConnction();
            String sql = "SELECT '  Total Deducations', SUM(Earning_amount) FROM earning INNER JOIN earning_joint ON earning.Earning_id = earning_joint.Earning_id INNER JOIN employee ON employee.user_login_id = earning_joint.user_login_id WHERE earning_joint.user_login_id =? AND Tag_name = \"Deducations\"";
            pps11 = conn.prepareStatement(sql);
            pps11.setString(1, get_Employee_id); 
            rs11= pps11.executeQuery();
            if(rs11.next()){
            totalDeducation = rs11.getString("SUM(Earning_amount)");
        //    Employee_TotalIncome_table2.setModel(DbUtils.resultSetToTableModel(rs11));
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Eearning_Entry.class.getName()).log(Level.SEVERE, null, ex);
        }     
            
            
            
         int sumDed = Integer.parseInt(totalDeducation);
           int sumEarn = Integer.parseInt(totalEarning);   
           
           String salary = Integer.toString(sumEarn -sumDed) ;
            Salary_Total.setText("k: "+salary);
                   
          try {
             conn = DBConnection.getConnction();
             String sql = "SELECT  * FROM employee WHERE user_login_id = ?";
            pps4 = conn.prepareStatement(sql);
            pps4.setString(1 , get_Employee_id);
            rs4 = pps4.executeQuery();
              if(rs4.next()){
                  Date date1 = new Date();
                 java.sql.Date sqldate = new java.sql.Date(date1.getTime());
                 paid_date.setText(sqldate.toString());
                 
                 get_Employee_id = rs4.getString("user_login_id");
                 lb_name.setText(rs4.getString("name")  +"  "+ rs4.getString("surname"));
                 designationated.setText(rs4.getString("designation"));
                 jLabel34.setText(rs4.getString("address"));
              
              }
             
             
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
         
        
        Allocation_panel.hide();
        panal_ADD_Dedications.hide();
        Employee_Assign_Vlist.hide();
        Complaint_view.hide();
        PaySlip.setVisible(true);
    }//GEN-LAST:event_jLabel28MouseClicked

    private void lb_Title_holder1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_Title_holder1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lb_Title_holder1MouseEntered
 String USer_id =null;
    private void txtSearch1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch1KeyTyped
      
        
        
        
         
        
        
    }//GEN-LAST:event_txtSearch1KeyTyped

    
    public void salary_for(){
    
    
    
         try {
            conn = DBConnection.getConnction();
            String sql = "SELECT  Earning_name, Earning_amount FROM earning INNER JOIN earning_joint ON earning.Earning_id = earning_joint.Earning_id INNER JOIN employee ON employee.user_login_id = earning_joint.user_login_id WHERE  earning_joint.user_login_id =? AND Tag_name = \"Earning\"   OR Tag_name = \"Basic Salary\"  ";
            pps15 = conn.prepareStatement(sql);
            pps15.setString(1, USer_id);
            rs15= pps15.executeQuery();
            Employee_withDeducations_table2.setModel(DbUtils.resultSetToTableModel(rs15));
                        
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Eearning_Entry.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
           try {
            conn = DBConnection.getConnction();
            String sql = "SELECT  Earning_name, Earning_amount FROM earning INNER JOIN earning_joint ON earning.Earning_id = earning_joint.Earning_id INNER JOIN employee ON employee.user_login_id = earning_joint.user_login_id WHERE  earning_joint.user_login_id =? AND Tag_name = \"Deducations\"";
            pps15 = conn.prepareStatement(sql);
            pps15.setString(1, USer_id); 
            rs15= pps15.executeQuery();
            Employee_withDeducations_table1.setModel(DbUtils.resultSetToTableModel(rs15));
                        
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Eearning_Entry.class.getName()).log(Level.SEVERE, null, ex);
        }
      
          try {
              
            conn = DBConnection.getConnction();
            String sql = "SELECT 'Total Adtition', SUM(Earning_amount) FROM earning INNER JOIN earning_joint ON earning.Earning_id = earning_joint.Earning_id INNER JOIN employee ON employee.user_login_id = earning_joint.user_login_id WHERE earning_joint.user_login_id =? AND Tag_name = \"Earning\"";
            pps15 = conn.prepareStatement(sql);
            pps15.setString(1, USer_id); 
            rs15= pps15.executeQuery();
            Employee_TotalIncome_table1.setModel(DbUtils.resultSetToTableModel(rs15));
                        
        } catch (SQLException ex) { Logger.getLogger(Accountant_Eearning_Entry.class.getName()).log(Level.SEVERE, null, ex); }
        
            try {
            conn = DBConnection.getConnction();
            String sql = "SELECT '  Total Deducations', SUM(Earning_amount) FROM earning INNER JOIN earning_joint ON earning.Earning_id = earning_joint.Earning_id INNER JOIN employee ON employee.user_login_id = earning_joint.user_login_id WHERE earning_joint.user_login_id =? AND Tag_name = \"Deducations\"";
            pps11 = conn.prepareStatement(sql);
            pps11.setString(1, USer_id); 
            rs11= pps11.executeQuery();
           
            Employee_TotalIncome_table2.setModel(DbUtils.resultSetToTableModel(rs11));
                        
        } catch (SQLException ex) {Logger.getLogger(Accountant_Eearning_Entry.class.getName()).log(Level.SEVERE, null, ex); }
            
            
          String totalEarning= null;
          try {
              
            conn = DBConnection.getConnction();
            String sql = "SELECT 'Total Adtition', SUM(Earning_amount) FROM earning INNER JOIN earning_joint ON earning.Earning_id = earning_joint.Earning_id INNER JOIN employee ON employee.user_login_id = earning_joint.user_login_id WHERE earning_joint.user_login_id =? AND Tag_name = \"Earning\"";
            pps15 = conn.prepareStatement(sql);
            pps15.setString(1, USer_id); 
            rs15= pps15.executeQuery();
            if(rs15.next()){
            
            totalEarning = rs15.getString("SUM(Earning_amount)");
           // Employee_TotalIncome_table1.setModel(DbUtils.resultSetToTableModel(rs15));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Eearning_Entry.class.getName()).log(Level.SEVERE, null, ex);
        }
         String totalDeducation = null;
            try {
            conn = DBConnection.getConnction();
            String sql = "SELECT '  Total Deducations', SUM(Earning_amount) FROM earning INNER JOIN earning_joint ON earning.Earning_id = earning_joint.Earning_id INNER JOIN employee ON employee.user_login_id = earning_joint.user_login_id WHERE earning_joint.user_login_id =? AND Tag_name = \"Deducations\"";
            pps11 = conn.prepareStatement(sql);
            pps11.setString(1, USer_id); 
            rs11= pps11.executeQuery();
            if(rs11.next()){
            totalDeducation = rs11.getString("SUM(Earning_amount)");
        //    Employee_TotalIncome_table2.setModel(DbUtils.resultSetToTableModel(rs11));
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Eearning_Entry.class.getName()).log(Level.SEVERE, null, ex);
        }     
            
            
            
         int sumDed = Integer.parseInt(totalDeducation);
           int sumEarn = Integer.parseInt(totalEarning);   
           
           String salary = Integer.toString(sumEarn -sumDed) ;
            Salary_Total.setText("k: "+salary);
                   
          try {
             conn = DBConnection.getConnction();
             String sql = "SELECT  * FROM employee WHERE user_login_id = ?";
            pps4 = conn.prepareStatement(sql);
            pps4.setString(1 , USer_id);
            rs4 = pps4.executeQuery();
              if(rs4.next()){
                  Date date1 = new Date();
                 java.sql.Date sqldate = new java.sql.Date(date1.getTime());
                 paid_date.setText(sqldate.toString());
                 
                 get_Employee_id = rs4.getString("user_login_id");
                 lb_name.setText(rs4.getString("name")  +"  "+ rs4.getString("surname"));
                 designationated.setText(rs4.getString("designation"));
                 jLabel34.setText(rs4.getString("address"));
              }
             
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    
    
    
    
    
    }
    
    private void Employee_withDeducations_table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Employee_withDeducations_table2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Employee_withDeducations_table2MouseClicked

    private void Employee_TotalIncome_table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Employee_TotalIncome_table2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Employee_TotalIncome_table2MouseClicked

    private void Employee_TotalIncome_table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Employee_TotalIncome_table1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Employee_TotalIncome_table1MouseClicked

    private void TotalIncome_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TotalIncome_tableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalIncome_tableMouseClicked

    private void txtSearch1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch1KeyPressed
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
           
             
           try {
        conn = DBConnection.getConnction();
        
        String sql ="SELECT * FROM  employee WHERE  name  like '%" + txtSearch1.getText() + "%'  OR surname  like '%" + txtSearch1.getText() + "%'   OR  employeeid  like '%" + txtSearch1.getText() + "%'       ";
         pps = conn.prepareStatement(sql);
         rs = pps.executeQuery();
         if(rs.next()){
         USer_id = rs.getString("user_login_id");
          JOptionPane.showMessageDialog(null, USer_id);
        salary_for();
         }
      } catch (SQLException ex) {Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);}
        
             
        }
    }//GEN-LAST:event_txtSearch1KeyPressed

    private void Add_price5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_price5MouseClicked

        
          PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("PRINT PAYSLIP ");

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
                jPanel9.print(g2);

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

    }//GEN-LAST:event_Add_price5MouseClicked

    private void jLabel35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseClicked
       Complaint_view.hide();
        panal_ADD_Dedications.hide();
        Employee_Assign_Vlist.setVisible(true);
        
    }//GEN-LAST:event_jLabel35MouseClicked

    
    
    
 
       
    public void Update_AssignedDeduction(){
     try {
                 conn = DBConnection.getConnction();
                String sql = "UPDATE  earning_joint SET  user_login_id =?,Earning_id =?  WHERE Earning_id =? AND user_login_id =?";
                pps5 = conn.prepareStatement(sql);
                 pps5.setString(1 , "");
                 pps5.setString(2 , "");
                 pps5.setString(3,getting_Deducation_id );
                   pps5.setString(4,get_Employee_id );
                pps5.executeUpdate();
               
                
                 
                  JOptionPane.showMessageDialog(null, "Successfully Un-Assigned Earning");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            Select_after_inserting();
    
    }
    
   
   public void Search_if_Exists_INtheJoint(){
   try {
             conn = DBConnection.getConnction();
             String sql = "SELECT * FROM earning_joint WHERE user_login_id = ? AND earning_id = ?  ";
            pps4 = conn.prepareStatement(sql);
            pps4.setString(1 , get_Employee_id);
            pps4.setString(2 , get_Deducation_Assign_id);
           
             rs4 = pps4.executeQuery();
             
              if(rs4.next()){
                  
                  
                
                   JOptionPane.showMessageDialog(null, "Already Assigned " );
              }else{
             
                  
                  
                 
               insert_Earning();

              }
             
        } catch (SQLException ex) {Logger.getLogger(Accountant_Eearning_Entry.class.getName()).log(Level.SEVERE, null, ex); }
          
         
        
   
   } 
    
 
    
    
    
    public void insert_Earning(){
      Date date1 = new Date();
         java.sql.Date sqldate1 = new java.sql.Date(date1.getTime());
        
        
          try {
             conn = DBConnection.getConnction();
             String sql = "INSERT INTO earning_joint (user_login_id,earning_id,earning_date) VALUES (?,?,?)";
            pps = conn.prepareStatement(sql);
            pps.setString(1 , get_Employee_id);
            pps.setString(2 , get_Deducation_Assign_id);
            pps.setDate(3,sqldate1 );
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Assigned Successfully " );
            Earning_Name.setText(null);
            Earning_Amount.setText(null);
            
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Eearning_Entry.class.getName()).log(Level.SEVERE, null, ex);
        }
         Select_after_inserting();
    
    }
    
    
    public void Select_after_inserting(){
    
         
         try {
            conn = DBConnection.getConnction();
            String sql = "SELECT Tag_name, Earning_name FROM earning INNER JOIN earning_joint ON earning.Earning_id = earning_joint.Earning_id INNER JOIN employee ON employee.user_login_id = earning_joint.user_login_id WHERE  earning_joint.user_login_id =?";
            pps15 = conn.prepareStatement(sql);
            pps15.setString(1, get_Employee_id);
            rs15= pps15.executeQuery();
            Deducation_Assigned_table.setModel(DbUtils.resultSetToTableModel(rs15));
                        
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Eearning_Entry.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    
    
    

    
    

     public static Accountant_Eearning_Entry getObj() {  //public method for instance Restriction
        if (Obj == null) {
            Obj = new Accountant_Eearning_Entry();
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
            java.util.logging.Logger.getLogger(Accountant_Eearning_Entry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Accountant_Eearning_Entry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Accountant_Eearning_Entry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Accountant_Eearning_Entry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Accountant_Eearning_Entry().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ASSIGN_Deduction_Button;
    private javax.swing.JLabel Add_Earning_button;
    private javax.swing.JLabel Add_Slip_button;
    private javax.swing.JLabel Add_price3;
    private javax.swing.JLabel Add_price5;
    private javax.swing.JPanel Allocation_panel;
    private javax.swing.JLabel Assign_Button;
    private javax.swing.JLabel BackGround_layer1;
    private javax.swing.JLabel Capacitylb;
    private javax.swing.JPanel Complaint_view;
    private javax.swing.JTable Deducation_Assign_table;
    private javax.swing.JTable Deducation_Assigned_table;
    private javax.swing.JTextField Deducation_Search_Employee;
    private javax.swing.JTable Deducation_table1;
    private javax.swing.JPanel Deducationheader;
    private javax.swing.JPanel Deducationheader1;
    private javax.swing.JPanel Deducationheader2;
    private javax.swing.JPanel Deducationheader3;
    private javax.swing.JLabel Delecte11;
    private javax.swing.JLabel Delecte12;
    private javax.swing.JLabel Delecte24;
    private javax.swing.JLabel Delecte25;
    private javax.swing.JLabel Delecte26;
    private javax.swing.JLabel Delecte27;
    private javax.swing.JLabel Delecte28;
    private javax.swing.JLabel Delecte29;
    private javax.swing.JLabel Delecte30;
    private javax.swing.JLabel Delecte31;
    private javax.swing.JLabel DelecteDeducation;
    private javax.swing.JLabel DelecteDeducation1;
    private javax.swing.JLabel Designation;
    private javax.swing.JTextField Earning_Amount;
    private javax.swing.JTextField Earning_Name;
    private javax.swing.JLabel Edit_Deducation;
    private javax.swing.JPanel Employee_Assign_Vlist;
    private javax.swing.JTable Employee_List_Earing;
    private javax.swing.JTable Employee_TotalIncome_table1;
    private javax.swing.JTable Employee_TotalIncome_table2;
    private javax.swing.JTable Employee_withDeducations_table;
    private javax.swing.JTable Employee_withDeducations_table1;
    private javax.swing.JTable Employee_withDeducations_table2;
    private javax.swing.JPanel PaySlip;
    private javax.swing.JLabel Qualification;
    private javax.swing.JLabel Qualification5;
    private javax.swing.JLabel Qualification6;
    private javax.swing.JLabel Salary_Total;
    private javax.swing.JTable TotalIncome_table;
    private javax.swing.JLabel UN_Assign;
    private javax.swing.JPanel admin_btn;
    private javax.swing.JLabel amount;
    private javax.swing.JPanel building_classes_panel;
    private javax.swing.JLabel designationated;
    private javax.swing.JLabel employee_name;
    private javax.swing.JLabel exit_lb;
    private javax.swing.JPanel frontSide_btn_holder;
    private javax.swing.JLabel header;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel209;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel210;
    private javax.swing.JLabel jLabel213;
    private javax.swing.JLabel jLabel214;
    private javax.swing.JLabel jLabel215;
    private javax.swing.JLabel jLabel216;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel223;
    private javax.swing.JLabel jLabel225;
    private javax.swing.JLabel jLabel229;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel230;
    private javax.swing.JLabel jLabel231;
    private javax.swing.JLabel jLabel232;
    private javax.swing.JLabel jLabel233;
    private javax.swing.JLabel jLabel234;
    private javax.swing.JLabel jLabel235;
    private javax.swing.JLabel jLabel238;
    private javax.swing.JLabel jLabel239;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel240;
    private javax.swing.JLabel jLabel241;
    private javax.swing.JLabel jLabel242;
    private javax.swing.JLabel jLabel243;
    private javax.swing.JLabel jLabel244;
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
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JScrollPane jScrollPane31;
    private javax.swing.JScrollPane jScrollPane32;
    private javax.swing.JScrollPane jScrollPane33;
    private javax.swing.JScrollPane jScrollPane34;
    private javax.swing.JLabel lb_Title_holder;
    private javax.swing.JLabel lb_Title_holder1;
    private javax.swing.JLabel lb_name;
    private javax.swing.JLabel lb_payment_bg;
    private javax.swing.JLabel lb_payment_counter;
    private javax.swing.JLabel lb_payment_pending;
    private javax.swing.JLabel lb_payments;
    private javax.swing.JLabel lb_student_bg;
    private javax.swing.JLabel lb_students;
    private javax.swing.JLabel lb_students_pending;
    private javax.swing.JLabel minize_lb;
    private javax.swing.JLabel model;
    private javax.swing.JLabel name;
    private javax.swing.JPanel pExpenses;
    private javax.swing.JLabel paid_date;
    private javax.swing.JPanel panal_ADD_Dedications;
    private javax.swing.JPanel right;
    private javax.swing.JLabel students_tata;
    private javax.swing.JLabel submit_btn;
    private javax.swing.JLabel table_holder_bg8;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSearch1;
    private javax.swing.JLabel updateDeducation;
    private javax.swing.JLabel user_img;
    private javax.swing.JLabel user_img1;
    // End of variables declaration//GEN-END:variables
}
