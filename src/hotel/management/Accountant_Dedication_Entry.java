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

public class Accountant_Dedication_Entry extends javax.swing.JFrame {

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
    private static Accountant_Dedication_Entry Obj = null;
    
    
    
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
         String   get_Deducation_Assign_name1 = null;
         String    get_Deducation_Assign_amount  = null;        
         String    get_Deducation_Assign_id  = null;        

          String  Employee_selected3 = "none";
         String  get_Employee_id3= null;
            int xx = 0;
            int yy = 0;
            String Search_EmployeeID = null;

        Accountant_Dedication_Entry() {
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
            Logger.getLogger(Accountant_Dedication_Entry.class.getName()).log(Level.SEVERE, null, ex);
          }
       
       
       
          
    }
  
    
    
       public void Count_Roomtype() {
    
        
       
           try {
             
            conn = DBConnection.getConnction();
            pps7 = conn.prepareStatement("SELECT COUNT(Deducation_joint_id) FROM deducation INNER JOIN deducation_joint ON deducation.Deducation_id = deducation_joint.Deducation_id INNER JOIN employee ON employee.user_login_id = deducation_joint.user_login_id WHERE employee.user_login_id = deducation_joint.user_login_id");
            rs7 = pps7.executeQuery();
            if (rs7.next()) {
                String sum = rs7.getString("count(Deducation_joint_id)");
               
                jLabel77.setText(sum);
            }
        } catch (SQLException ex) {Logger.getLogger(Accountant_Dedication_Entry.class.getName()).log(Level.SEVERE, null, ex);  }

           
           
             try {
              
                 
             Date date = new Date();
             java.sql.Date sqldate = new java.sql.Date(date.getTime());
             
            conn = DBConnection.getConnction();
            pps8 = conn.prepareStatement("SELECT  count(Deducation_id) FROM   deducation ");
            rs8 = pps8.executeQuery();
            if (rs8.next()) {
                String sum = rs8.getString("count(Deducation_id)");
                students_tata.setText(sum);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Dedication_Entry.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Accountant_Dedication_Entry.class.getName()).log(Level.SEVERE, null, ex);
        }
       

        
       
       }
   
  

    public void ShowRoomType_onTable() {//school srtucture
        try {
            conn = DBConnection.getConnction();
            String sql = "SELECT name,surname,employeeid, Deducation_name,Deducation_amount FROM deducation INNER JOIN payables ON deducation.Deducation_id = payables.Deducation_id INNER JOIN employee ON employee.user_login_id = payables.user_login_id WHERE  employee.user_login_id = payables.user_login_id ";
            pps2 = conn.prepareStatement(sql);
            rs2 = pps2.executeQuery();
            Employee_withDeducations_table.setModel(DbUtils.resultSetToTableModel(rs2));
                       

        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Dedication_Entry.class.getName()).log(Level.SEVERE, null, ex);
        }

        
           
         try {
            conn = DBConnection.getConnction();
            String sql = " SELECT Deducation_name,Deducation_amount, Deducation_date  FROM  deducation";
            pps11 = conn.prepareStatement(sql);
            rs11= pps11.executeQuery();
            Deducation_table1.setModel(DbUtils.resultSetToTableModel(rs11));
                        

        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Dedication_Entry.class.getName()).log(Level.SEVERE, null, ex);
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
        Add_price7 = new javax.swing.JLabel();
        Add_Earning_button = new javax.swing.JLabel();
        Assign_Button = new javax.swing.JLabel();
        Add_Deducation_button = new javax.swing.JLabel();
        right = new javax.swing.JPanel();
        building_classes_panel = new javax.swing.JPanel();
        Complaint_view = new javax.swing.JPanel();
        Add_price3 = new javax.swing.JLabel();
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
        Deducation_Search_Employee = new javax.swing.JTextField();
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
        panal_ADD_Dedications = new javax.swing.JPanel();
        DelecteDeducation = new javax.swing.JLabel();
        updateDeducation = new javax.swing.JLabel();
        jScrollPane28 = new javax.swing.JScrollPane();
        Deducation_table1 = new javax.swing.JTable();
        Add_Deducation = new javax.swing.JLabel();
        jLabel228 = new javax.swing.JLabel();
        Edit_Deducation = new javax.swing.JLabel();
        Delecte24 = new javax.swing.JLabel();
        Delecte25 = new javax.swing.JLabel();
        DeducationName1 = new javax.swing.JTextField();
        Count_title40 = new javax.swing.JLabel();
        Deducationheader = new javax.swing.JPanel();
        jLabel222 = new javax.swing.JLabel();
        jLabel230 = new javax.swing.JLabel();
        jLabel231 = new javax.swing.JLabel();
        jLabel232 = new javax.swing.JLabel();
        DeducationAmount1 = new javax.swing.JTextField();
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
        jPanel7 = new javax.swing.JPanel();
        Payables_Deducations = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane30 = new javax.swing.JScrollPane();
        Deducation_Assign_table = new javax.swing.JTable();
        Deducationheader1 = new javax.swing.JPanel();
        jLabel229 = new javax.swing.JLabel();
        jLabel238 = new javax.swing.JLabel();
        jScrollPane31 = new javax.swing.JScrollPane();
        Deducation_Assigned_table = new javax.swing.JTable();
        Deducationheader2 = new javax.swing.JPanel();
        jLabel244 = new javax.swing.JLabel();
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
        PaySlip = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane26 = new javax.swing.JScrollPane();
        Employee_withDeducations_table1 = new javax.swing.JTable();
        jPanel36 = new javax.swing.JPanel();
        jLabel210 = new javax.swing.JLabel();
        jLabel214 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
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

        Add_price7.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Add_price7.setForeground(new java.awt.Color(255, 255, 255));
        Add_price7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Add_price7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_upload_to_ftp_30px.png"))); // NOI18N
        Add_price7.setToolTipText("ADD DEDUCATIONS");
        Add_price7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Add_price7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_price7MouseClicked(evt);
            }
        });
        frontSide_btn_holder.add(Add_price7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 60, 70));

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

        Add_Deducation_button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Add_Deducation_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_general_ledger_30px.png"))); // NOI18N
        Add_Deducation_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_Deducation_buttonMouseClicked(evt);
            }
        });
        frontSide_btn_holder.add(Add_Deducation_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 60, 60));

        jPanel1.add(frontSide_btn_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 60, 680));

        right.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.add(right, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 760, 1380, 30));

        building_classes_panel.setLayout(new java.awt.CardLayout());

        Complaint_view.setBackground(new java.awt.Color(255, 255, 255));
        Complaint_view.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Add_price3.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Add_price3.setForeground(new java.awt.Color(255, 255, 255));
        Add_price3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Add_price3.setText("  Deducation  Process");
        Add_price3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_price3MouseClicked(evt);
            }
        });
        Complaint_view.add(Add_price3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 640, 170, 40));

        Delecte11.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte11.setForeground(new java.awt.Color(255, 255, 255));
        Delecte11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        Complaint_view.add(Delecte11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 620, 120, 70));

        Delecte12.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte12.setForeground(new java.awt.Color(255, 255, 255));
        Delecte12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        Complaint_view.add(Delecte12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 620, 390, 70));

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));
        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel209.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel209.setForeground(new java.awt.Color(102, 102, 102));
        jLabel209.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel209.setText("Deducation name");
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
        jLabel225.setText("Deducation Amount");
        jPanel35.add(jLabel225, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 150, 50));

        Complaint_view.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 920, 50));

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

        Deducation_Search_Employee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Deducation_Search_EmployeeKeyTyped(evt);
            }
        });
        Complaint_view.add(Deducation_Search_Employee, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 140, 180, -1));

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
        lb_payment_pending.setText("All   Deducations");
        lb_payment_pending.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(lb_payment_pending, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 90, 30));

        lb_payments.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        lb_payments.setForeground(new java.awt.Color(255, 255, 255));
        lb_payments.setText("Assigned Deducations");
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
        lb_students.setText("Deducation Level");
        lb_students.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(lb_students, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 140, 30));

        lb_students_pending.setFont(new java.awt.Font("Tw Cen MT", 0, 11)); // NOI18N
        lb_students_pending.setForeground(new java.awt.Color(255, 255, 255));
        lb_students_pending.setText("All  Deducation");
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
        panal_ADD_Dedications.add(DelecteDeducation, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 620, 110, 50));

        updateDeducation.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        updateDeducation.setForeground(new java.awt.Color(255, 255, 255));
        updateDeducation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        updateDeducation.setText("Update");
        updateDeducation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateDeducationMouseClicked(evt);
            }
        });
        panal_ADD_Dedications.add(updateDeducation, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 620, 70, 50));

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

        panal_ADD_Dedications.add(jScrollPane28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 580, 310));

        Add_Deducation.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Add_Deducation.setForeground(new java.awt.Color(255, 255, 255));
        Add_Deducation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Add_Deducation.setText("  Submit");
        Add_Deducation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_DeducationMouseClicked(evt);
            }
        });
        panal_ADD_Dedications.add(Add_Deducation, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 620, 90, 50));

        jLabel228.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel228.setForeground(new java.awt.Color(102, 102, 102));
        jLabel228.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel228.setText("Deducation Name");
        panal_ADD_Dedications.add(jLabel228, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 130, 30));

        Edit_Deducation.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Edit_Deducation.setForeground(new java.awt.Color(255, 255, 255));
        Edit_Deducation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Edit_Deducation.setText("Edit");
        Edit_Deducation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Edit_DeducationMouseClicked(evt);
            }
        });
        panal_ADD_Dedications.add(Edit_Deducation, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 620, 80, 50));

        Delecte24.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte24.setForeground(new java.awt.Color(255, 255, 255));
        Delecte24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        panal_ADD_Dedications.add(Delecte24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 180, 60));

        Delecte25.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte25.setForeground(new java.awt.Color(255, 255, 255));
        Delecte25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        panal_ADD_Dedications.add(Delecte25, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 610, 400, 60));
        panal_ADD_Dedications.add(DeducationName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, 380, 30));

        Count_title40.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title40.setForeground(new java.awt.Color(102, 102, 102));
        Count_title40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_30px.png"))); // NOI18N
        Count_title40.setText("Complaint List");
        Count_title40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Count_title40MouseClicked(evt);
            }
        });
        panal_ADD_Dedications.add(Count_title40, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 620, 160, 50));

        Deducationheader.setBackground(new java.awt.Color(153, 153, 153));
        Deducationheader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel222.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel222.setForeground(new java.awt.Color(102, 102, 102));
        jLabel222.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel222.setText("Deducation Name");
        Deducationheader.add(jLabel222, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 170, 50));

        jLabel230.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel230.setForeground(new java.awt.Color(102, 102, 102));
        jLabel230.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel230.setText("Deducation Amount");
        Deducationheader.add(jLabel230, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 150, 50));

        jLabel231.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel231.setForeground(new java.awt.Color(102, 102, 102));
        jLabel231.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel231.setText("Deducation Date");
        Deducationheader.add(jLabel231, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 150, 50));

        panal_ADD_Dedications.add(Deducationheader, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 580, 50));

        jLabel232.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel232.setForeground(new java.awt.Color(102, 102, 102));
        jLabel232.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel232.setText("Deducation Amount");
        panal_ADD_Dedications.add(jLabel232, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 150, 30));
        panal_ADD_Dedications.add(DeducationAmount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 500, 380, 30));

        building_classes_panel.add(panal_ADD_Dedications, "card8");

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

        Employee_Assign_Vlist.add(jScrollPane29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 950, 300));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(user_img, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 100));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 260, 120));

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

        Employee_Assign_Vlist.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 70, 280, 290));

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
        DelecteDeducation1.setText("  Allocation Deducation");
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
        Employee_Assign_Vlist.add(Delecte27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 310, 60));

        jPanel5.setBackground(new java.awt.Color(255, 102, 0));
        Employee_Assign_Vlist.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 410, 360, 180));

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));
        Employee_Assign_Vlist.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 380, 180));

        jPanel7.setBackground(new java.awt.Color(0, 153, 153));
        Employee_Assign_Vlist.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, 380, 180));

        building_classes_panel.add(Employee_Assign_Vlist, "card4");

        Payables_Deducations.setBackground(new Color(255,255,255,1));
        Payables_Deducations.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jLabel229.setText("Deducation Name");
        Deducationheader1.add(jLabel229, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 170, 50));

        jLabel238.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel238.setForeground(new java.awt.Color(102, 102, 102));
        jLabel238.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel238.setText("Deducation Amount");
        Deducationheader1.add(jLabel238, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 150, 50));

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
        Deducationheader2.add(jLabel244, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 150, 50));

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
        jPanel14.add(Capacitylb, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 80, 40));

        Qualification.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        Qualification.setForeground(new java.awt.Color(110, 156, 182));
        Qualification.setText("Qualification");
        jPanel14.add(Qualification, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 100, 40));

        Qualification5.setFont(new java.awt.Font("Trebuchet MS", 3, 13)); // NOI18N
        Qualification5.setForeground(new java.awt.Color(161, 169, 171));
        Qualification5.setText(" Capacity:");
        jPanel14.add(Qualification5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, 70, 40));

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

        Payables_Deducations.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 960, 470));

        building_classes_panel.add(Payables_Deducations, "card6");

        PaySlip.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Employee_withDeducations_table1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

        jPanel9.add(jScrollPane26, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 910, 350));

        jPanel36.setBackground(new java.awt.Color(204, 208, 212));
        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel210.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel210.setForeground(new java.awt.Color(102, 102, 102));
        jLabel210.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel210.setText("Deducation ");
        jPanel36.add(jLabel210, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 140, 50));

        jLabel214.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel214.setForeground(new java.awt.Color(102, 102, 102));
        jLabel214.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel214.setText("Earnings");
        jPanel36.add(jLabel214, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 120, 50));

        jPanel9.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 910, 40));

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Month And Year:");
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 110, 30));

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Employee Name ");
        jPanel9.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 100, 160, 30));

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Designation :");
        jPanel9.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 110, 30));
        jPanel9.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 330, 20));
        jPanel9.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 340, 20));
        jPanel9.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 340, 20));

        jLabel15.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Employee Name :");
        jPanel9.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 110, 30));

        jLabel16.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Employee Name ");
        jPanel9.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, 220, 30));

        jLabel17.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Employee Name ");
        jPanel9.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 60, 160, 30));

        PaySlip.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1000, 680));

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
        admin_btn.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 110, 40));

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
        this.setExtendedState(Accountant_Dedication_Entry.ICONIFIED);
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
            Logger.getLogger(Accountant_Dedication_Entry.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Accountant_Dedication_Entry.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Accountant_Dedication_Entry.class.getName()).log(Level.SEVERE, null, ex);
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
            JOptionPane.showMessageDialog(null, "Select the Deducation you wish to Edit");
            
        } else if (!Deducation_subject_selected.equals("none")) {
        
        
        
          try {
             conn = DBConnection.getConnction();
             String sql = "SELECT  * FROM deducation WHERE Deducation_name = ? AND Deducation_amount  = ? AND Deducation_date = ? ";
            pps4 = conn.prepareStatement(sql);
            pps4.setString(1 , get_Deducation_name);
            pps4.setString(2 , get_Deducation_amount );
            pps4.setString(3, get_Deducation_date );
           
             rs4 = pps4.executeQuery();
              if(rs4.next()){
              
               
                get_Deducation_id_toUpdate2 = rs4.getString("Deducation_id");
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
             pps3 = conn.prepareStatement("DELETE  FROM  deducation WHERE  Deducation_id = ? ");
             pps3.setString(1, get_Deducation_id_toUpdate2);
             pps3.executeUpdate();
             JOptionPane.showMessageDialog(null, "Deducation Delected" );
            
             
            } catch (SQLException ex) {
            Logger.getLogger(Accountant_Dedication_Entry.class.getName()).log(Level.SEVERE, null, ex);
            }
           
           
           
           
           
           ShowRoomType_onTable() ;
           Count_Roomtype();
  
  }
    
    
    
    private void updateDeducationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateDeducationMouseClicked
          Date date1 = new Date();
         java.sql.Date sqldate = new java.sql.Date(date1.getTime());
         
        
        try {
                 conn = DBConnection.getConnction();
                String sql = "UPDATE  deducation SET Deducation_name =?,Deducation_amount =?,Deducation_date =?  WHERE Deducation_id =? ";
                pps5 = conn.prepareStatement(sql);
                 pps5.setString(1 , DeducationName1.getText());
                 pps5.setString(2 , DeducationAmount1.getText());
                 pps5.setDate(3, sqldate);
                 pps5.setString(4 ,get_Deducation_id_toUpdate2 );
                  
                pps5.executeUpdate();
               
                  DeducationName1.setText(null);
                  DeducationAmount1.setText(null);
                 
                  JOptionPane.showMessageDialog(null, "Successfully Updated");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
         ShowRoomType_onTable() ;
         Count_Roomtype();
        
        
        
        
    }//GEN-LAST:event_updateDeducationMouseClicked

    private void Deducation_table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Deducation_table1MouseClicked
         
        DefaultTableModel tableMode_type = (DefaultTableModel) Deducation_table1.getModel();
          get_Deducation_name = tableMode_type.getValueAt(Deducation_table1.getSelectedRow(), 0).toString();
        
         DefaultTableModel tableMode_type1 = (DefaultTableModel) Deducation_table1.getModel();
         get_Deducation_amount = tableMode_type1.getValueAt(Deducation_table1.getSelectedRow(), 1).toString();
         
        
         
         DefaultTableModel tableMode_type2 = (DefaultTableModel) Deducation_table1.getModel();
         get_Deducation_date = tableMode_type2.getValueAt(Deducation_table1.getSelectedRow(), 2).toString();
        
         
           Deducation_subject_selected = "selected";
                
      
    }//GEN-LAST:event_Deducation_table1MouseClicked

    private void Add_DeducationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_DeducationMouseClicked
        if(DeducationName1.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Deducation name  is Empty");
        }else if( DeducationAmount1.getText().isEmpty()){
          JOptionPane.showMessageDialog(null, "Deducation amount is Empty");
         }else {
            
    
          Date date1 = new Date();
         java.sql.Date sqldate1 = new java.sql.Date(date1.getTime());
        
        
          try {
             conn = DBConnection.getConnction();
             String sql = "INSERT INTO Deducation (Deducation_name,Deducation_amount,Deducation_date) VALUES (?,?,?)";
            pps = conn.prepareStatement(sql);
            pps.setString(1 , DeducationName1.getText());
            pps.setString(2 , DeducationAmount1.getText());
            pps.setDate(3,sqldate1 );
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully Saved" );
            DeducationName1.setText(null);
            DeducationAmount1.setText(null);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        
        
        
      
        }
             
         
         
        ShowRoomType_onTable() ;
           Count_Roomtype();
    }//GEN-LAST:event_Add_DeducationMouseClicked

    private void Edit_DeducationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Edit_DeducationMouseClicked
        
           
             
                    
                  if (Deducation_subject_selected.equals("none")) {
            JOptionPane.showMessageDialog(null, "Select the Earning you wish to Edit");
            
        } else if (!Deducation_subject_selected.equals("none")) {
        
        
        
          try {
             conn = DBConnection.getConnction();
             String sql = "SELECT  * FROM deducation WHERE Deducation_name = ? AND Deducation_amount  = ? AND Deducation_date = ? ";
            pps4 = conn.prepareStatement(sql);
            pps4.setString(1 , get_Deducation_name);
            pps4.setString(2 , get_Deducation_amount );
            pps4.setString(3, get_Deducation_date );
           
             rs4 = pps4.executeQuery();
              if(rs4.next()){
              
                DeducationName1.setText(rs4.getString("Deducation_name"));
                DeducationAmount1.setText(rs4.getString("Deducation_amount"));
                get_Deducation_id_toUpdate2 = rs4.getString("Deducation_id");
              }
             
             
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
          
         
          
        }
          
                    
    }//GEN-LAST:event_Edit_DeducationMouseClicked

    private void Count_title40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Count_title40MouseClicked
        // TODO add your handling code here: Employee_withDeducations_table
    }//GEN-LAST:event_Count_title40MouseClicked

    private void Add_Earning_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_Earning_buttonMouseClicked
             try {
            conn = DBConnection.getConnction();
            String sql = "SELECT Deducation_name,Deducation_amount  FROM  deducation";
            pps11 = conn.prepareStatement(sql);
            rs11= pps11.executeQuery();
            Deducation_Assign_table.setModel(DbUtils.resultSetToTableModel(rs11));

        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Dedication_Entry.class.getName()).log(Level.SEVERE, null, ex);
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
        DefaultTableModel tableMode_type = (DefaultTableModel) Deducation_Assign_table.getModel();
          get_Deducation_Assign_name = tableMode_type.getValueAt(Deducation_Assign_table.getSelectedRow(), 0).toString();
        
         DefaultTableModel tableMode_type1 = (DefaultTableModel) Deducation_Assign_table.getModel();
         get_Deducation_Assign_amount = tableMode_type1.getValueAt(Deducation_Assign_table.getSelectedRow(), 1).toString();
         
           Deducation_Assign_selected = "selected";
           
                 
    }//GEN-LAST:event_Deducation_Assign_tableMouseClicked

    private void Add_price7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_price7MouseClicked
         
        
        
    }//GEN-LAST:event_Add_price7MouseClicked

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
                
                
              }
             
             
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
          
           try {
            conn = DBConnection.getConnction();
            String sql = " SELECT Deducation_name,Deducation_amount  FROM  deducation";
            pps11 = conn.prepareStatement(sql);
            rs11= pps11.executeQuery();
            Deducation_Assign_table.setModel(DbUtils.resultSetToTableModel(rs11));
                        

        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Dedication_Entry.class.getName()).log(Level.SEVERE, null, ex);
        }
          try {
            conn = DBConnection.getConnction();
            String sql = "SELECT Deducation_name FROM deducation INNER JOIN payables ON deducation.Deducation_id = payables.Deducation_id INNER JOIN employee ON employee.user_login_id = payables.user_login_id WHERE  payables.user_login_id =?";
            pps11 = conn.prepareStatement(sql);
            pps11.setString(1, get_Employee_id);
            rs11= pps11.executeQuery();
            Deducation_Assigned_table.setModel(DbUtils.resultSetToTableModel(rs11));
                        
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Dedication_Entry.class.getName()).log(Level.SEVERE, null, ex);
        }
           
           
           
        Complaint_view.hide();
        panal_ADD_Dedications.hide();
        Employee_Assign_Vlist.hide();
        Payables_Deducations.setVisible(true);
        }
    }//GEN-LAST:event_DelecteDeducation1MouseClicked

    private void Deducation_Assigned_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Deducation_Assigned_tableMouseClicked
        DefaultTableModel tableMode_type = (DefaultTableModel) Deducation_Assigned_table.getModel();
       get_Deducation_Assign_name1 = tableMode_type.getValueAt(Deducation_Assigned_table.getSelectedRow(), 0).toString();
        
         
           Deducation_Assign_selected1 = "selected";
    }//GEN-LAST:event_Deducation_Assigned_tableMouseClicked

    
    
    String Deductcation_idObtained = null;
    private void ASSIGN_Deduction_ButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ASSIGN_Deduction_ButtonMouseClicked
       
                    
        if (Deducation_Assign_selected.equals("none")) {
            JOptionPane.showMessageDialog(null, "Select the Deducation you wish to Assign");
            
        } else if (!Deducation_Assign_selected.equals("none")) {
        
        
        
          try {
             conn = DBConnection.getConnction();
             String sql = "SELECT  * FROM deducation WHERE Deducation_name = ? AND Deducation_amount  = ?  ";
            pps4 = conn.prepareStatement(sql);
            pps4.setString(1 , get_Deducation_Assign_name);
            pps4.setString(2 , get_Deducation_Assign_amount);

            rs4 = pps4.executeQuery();
            if(rs4.next()){
                  
              
                 get_Deducation_Assign_id = rs4.getString("Deducation_id");
                 Search_if_Exists_INtheJoint();

              }
             
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex); }
          
         
        }
    }//GEN-LAST:event_ASSIGN_Deduction_ButtonMouseClicked

    
    String getting_Deducation_id = null;
    private void UN_AssignMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UN_AssignMouseClicked
    
        
        
        
              
                  if (Deducation_Assign_selected1.equals("none")) {
            JOptionPane.showMessageDialog(null, "Select the Earning you wish to Edit");
            
        } else if (!Deducation_Assign_selected1.equals("none")) {
        
        
          try {
            conn = DBConnection.getConnction();
            String sql = "SELECT  * FROM deducation WHERE Deducation_name = ? ";
            pps4 = conn.prepareStatement(sql);
            pps4.setString(1 , get_Deducation_Assign_name1);
            rs4 = pps4.executeQuery();
              if(rs4.next()){
                  
              
                 getting_Deducation_id = rs4.getString("Deducation_id");
                 Update_AssignedDeduction();
              }
             
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex); }
          
    
         
          
        }
          
          
        
    }//GEN-LAST:event_UN_AssignMouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked

        Payables_Deducations.hide();
        panal_ADD_Dedications.hide();
        Employee_Assign_Vlist.hide();
        Complaint_view.setVisible(true);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void Add_Deducation_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_Deducation_buttonMouseClicked
       

         Payables_Deducations.hide();
        panal_ADD_Dedications.hide();
        Employee_Assign_Vlist.hide();
        Complaint_view.hide();
        PaySlip.setVisible(true);
    }//GEN-LAST:event_Add_Deducation_buttonMouseClicked

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

    
    
    
 
       
    public void Update_AssignedDeduction(){
     try {
                 conn = DBConnection.getConnction();
                String sql = "UPDATE  deducation_joint SET  user_login_id =?,Deducation_id =?  WHERE Deducation_id =? AND user_login_id =?";
                pps5 = conn.prepareStatement(sql);
                 pps5.setString(1 , "");
                 pps5.setString(2 , "");
                 pps5.setString(3,getting_Deducation_id );
                   pps5.setString(4,get_Employee_id );
                pps5.executeUpdate();
               
                
                 
                  JOptionPane.showMessageDialog(null, "Successfully Un-Assigned Deducation");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            Select_after_inserting();
    
    }
    
    
   public void Search_if_Exists_INtheJoint(){
   try {
             conn = DBConnection.getConnction();
             String sql = "SELECT  * FROM deducation_joint WHERE user_login_id = ? AND Deducation_id  = ?  ";
            pps4 = conn.prepareStatement(sql);
            pps4.setString(1 , get_Employee_id);
            pps4.setString(2 , get_Deducation_Assign_id);
           
             rs4 = pps4.executeQuery();
              if(rs4.next()){
                  JOptionPane.showMessageDialog(null, "Employee Already Assigned that Deducation");
                  
              }else{
              
                 insert_deducation();

              }
             
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex); }
          
         
        
   
   } 
    
    
    
    public void insert_deducation(){
      Date date1 = new Date();
         java.sql.Date sqldate1 = new java.sql.Date(date1.getTime());
        
        
          try {
             conn = DBConnection.getConnction();
             String sql = "INSERT INTO deducation_joint (user_login_id,Deducation_id,Deducation_date) VALUES (?,?,?)";
            pps = conn.prepareStatement(sql);
            pps.setString(1 , get_Employee_id);
            pps.setString(2 , get_Deducation_Assign_id);
            pps.setDate(3,sqldate1 );
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully Saved" );
            DeducationName1.setText(null);
            DeducationAmount1.setText(null);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
         Select_after_inserting();
    
    }
    
    
    public void Select_after_inserting(){
    
         
         try {
            conn = DBConnection.getConnction();
            String sql = "SELECT Deducation_name FROM deducation INNER JOIN deducation_joint ON deducation.Deducation_id = deducation_joint.Deducation_id INNER JOIN employee ON employee.user_login_id = deducation_joint.user_login_id WHERE  deducation_joint.user_login_id =?";
            pps11 = conn.prepareStatement(sql);
            pps11.setString(1, get_Employee_id);
            rs11= pps11.executeQuery();
            Deducation_Assigned_table.setModel(DbUtils.resultSetToTableModel(rs11));
                        
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Dedication_Entry.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    
    
    

    
    

     public static Accountant_Dedication_Entry getObj() {  //public method for instance Restriction
        if (Obj == null) {
            Obj = new Accountant_Dedication_Entry();
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
            java.util.logging.Logger.getLogger(Accountant_Dedication_Entry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Accountant_Dedication_Entry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Accountant_Dedication_Entry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Accountant_Dedication_Entry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Accountant_Dedication_Entry().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ASSIGN_Deduction_Button;
    private javax.swing.JLabel Add_Deducation;
    private javax.swing.JLabel Add_Deducation_button;
    private javax.swing.JLabel Add_Earning_button;
    private javax.swing.JLabel Add_price3;
    private javax.swing.JLabel Add_price7;
    private javax.swing.JLabel Assign_Button;
    private javax.swing.JLabel BackGround_layer1;
    private javax.swing.JLabel Capacitylb;
    private javax.swing.JPanel Complaint_view;
    private javax.swing.JLabel Count_title40;
    private javax.swing.JTextField DeducationAmount1;
    private javax.swing.JTextField DeducationName1;
    private javax.swing.JTable Deducation_Assign_table;
    private javax.swing.JTable Deducation_Assigned_table;
    private javax.swing.JTextField Deducation_Search_Employee;
    private javax.swing.JTable Deducation_table1;
    private javax.swing.JPanel Deducationheader;
    private javax.swing.JPanel Deducationheader1;
    private javax.swing.JPanel Deducationheader2;
    private javax.swing.JLabel Delecte11;
    private javax.swing.JLabel Delecte12;
    private javax.swing.JLabel Delecte24;
    private javax.swing.JLabel Delecte25;
    private javax.swing.JLabel Delecte26;
    private javax.swing.JLabel Delecte27;
    private javax.swing.JLabel DelecteDeducation;
    private javax.swing.JLabel DelecteDeducation1;
    private javax.swing.JLabel Designation;
    private javax.swing.JLabel Edit_Deducation;
    private javax.swing.JPanel Employee_Assign_Vlist;
    private javax.swing.JTable Employee_List_Earing;
    private javax.swing.JTable Employee_withDeducations_table;
    private javax.swing.JTable Employee_withDeducations_table1;
    private javax.swing.JPanel PaySlip;
    private javax.swing.JPanel Payables_Deducations;
    private javax.swing.JLabel Qualification;
    private javax.swing.JLabel Qualification5;
    private javax.swing.JLabel Qualification6;
    private javax.swing.JLabel UN_Assign;
    private javax.swing.JPanel admin_btn;
    private javax.swing.JPanel building_classes_panel;
    private javax.swing.JLabel employee_name;
    private javax.swing.JLabel exit_lb;
    private javax.swing.JPanel frontSide_btn_holder;
    private javax.swing.JLabel header;
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
    private javax.swing.JLabel jLabel209;
    private javax.swing.JLabel jLabel210;
    private javax.swing.JLabel jLabel213;
    private javax.swing.JLabel jLabel214;
    private javax.swing.JLabel jLabel215;
    private javax.swing.JLabel jLabel216;
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel225;
    private javax.swing.JLabel jLabel228;
    private javax.swing.JLabel jLabel229;
    private javax.swing.JLabel jLabel230;
    private javax.swing.JLabel jLabel231;
    private javax.swing.JLabel jLabel232;
    private javax.swing.JLabel jLabel238;
    private javax.swing.JLabel jLabel239;
    private javax.swing.JLabel jLabel240;
    private javax.swing.JLabel jLabel241;
    private javax.swing.JLabel jLabel242;
    private javax.swing.JLabel jLabel243;
    private javax.swing.JLabel jLabel244;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JScrollPane jScrollPane31;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lb_Title_holder;
    private javax.swing.JLabel lb_payment_bg;
    private javax.swing.JLabel lb_payment_counter;
    private javax.swing.JLabel lb_payment_pending;
    private javax.swing.JLabel lb_payments;
    private javax.swing.JLabel lb_student_bg;
    private javax.swing.JLabel lb_students;
    private javax.swing.JLabel lb_students_pending;
    private javax.swing.JLabel minize_lb;
    private javax.swing.JLabel model;
    private javax.swing.JPanel pExpenses;
    private javax.swing.JPanel panal_ADD_Dedications;
    private javax.swing.JPanel right;
    private javax.swing.JLabel students_tata;
    private javax.swing.JLabel table_holder_bg8;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JLabel updateDeducation;
    private javax.swing.JLabel user_img;
    // End of variables declaration//GEN-END:variables
}
