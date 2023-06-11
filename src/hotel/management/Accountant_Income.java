package hotel.management;

import java.awt.Color;
import java.awt.Graphics;
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
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Accountant_Income extends javax.swing.JFrame {

      Connection conn = null;
      PreparedStatement pps, pps1, pps2, pps3, pps4, pps6, pps5, pps7, pps8, pps9, pps10, pps11, pps12 ,pps13 = null;
      ResultSet rs, rs1, rs2, rs3, rs4, rs5, rs6, rs7, rs8, rs9, rs10, rs11, rs12 ,rs13= null;

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
    private static Accountant_Income Obj = null;
    
    
    
          String passed_user_id;
       String subject_selected = "none";
       String subject_selected2 = "none";
       
       
        String  get_Payment_To= null; 
       String   get_Amount = null; 
        String get_description= null; 
         String get_Date= null; 
         
        
    
      
    
            int xx = 0;
            int yy = 0;
            String Search_EmployeeID = null;

        Accountant_Income() {
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
            Logger.getLogger(Accountant_Income.class.getName()).log(Level.SEVERE, null, ex);
          }
        
    }
  
    
    
       public void Count_Roomtype() {
      
        
       
           try {
             
            conn = DBConnection.getConnction();
            pps7 = conn.prepareStatement("SELECT  count(Income_id) FROM   income");
            rs7 = pps7.executeQuery();
            if (rs7.next()) {
                String sum = rs7.getString("count(Income_id)");
               
                jLabel77.setText(sum);
            }
        } catch (SQLException ex) {Logger.getLogger(Accountant_Income.class.getName()).log(Level.SEVERE, null, ex);  }

           
        
           try {
                Date date = new Date();
             java.sql.Date sqldate = new java.sql.Date(date.getTime());
             
            conn = DBConnection.getConnction();
            pps11 = conn.prepareStatement("SELECT  Sum(Income_amount) FROM   income WHERE Date = ?");
            pps11.setDate(1 , sqldate);
            rs11= pps11.executeQuery();
            if (rs11.next()) {
                String sum = rs11.getString("Sum(Income_amount)");
               
                Daily_ExpensesLB.setText(sum);
            }
        } catch (SQLException ex) {Logger.getLogger(Accountant_Income.class.getName()).log(Level.SEVERE, null, ex);  }
   
           
           
          try {
             
            conn = DBConnection.getConnction();
            pps11 = conn.prepareStatement("SELECT  Sum(Income_amount) FROM   income WHERE YEARWEEK(Date) = YEARWEEK(NOW())");
            rs11= pps11.executeQuery();
            if (rs11.next()) {
                String sum = rs11.getString("Sum(Income_amount)");
               
                Weekly_ExpensesLB.setText(sum);
            }
        } catch (SQLException ex) {Logger.getLogger(Accountant_Income.class.getName()).log(Level.SEVERE, null, ex);  }
    
           
           
           try {
             
            conn = DBConnection.getConnction();
            pps11 = conn.prepareStatement("SELECT  Sum(Income_amount) FROM   income WHERE MONTH(Date) = MONTH(NOW())");
            rs11= pps11.executeQuery();
            if (rs11.next()) {
                String sum = rs11.getString("Sum(Income_amount)");
               
                Monthly_ExpensesLB.setText(sum);
            }
        } catch (SQLException ex) {Logger.getLogger(Accountant_Income.class.getName()).log(Level.SEVERE, null, ex);  }
    
           
          // 
           
             try {
              
                 
             Date date = new Date();
             java.sql.Date sqldate = new java.sql.Date(date.getTime());
             
            conn = DBConnection.getConnction();
            pps8 = conn.prepareStatement("SELECT  count(Income_id) FROM   income  WHERE date=? ");
             pps8.setDate(1 , sqldate);
            rs8 = pps8.executeQuery();
            if (rs8.next()) {
                String sum = rs8.getString("count(Income_id)");
                students_tata.setText(sum);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Income.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   
//students_tata
      
             try {
              
                 
         
            conn = DBConnection.getConnction();
            pps10 = conn.prepareStatement("SELECT count(Income_id) FROM income WHERE YEARWEEK(Date) = YEARWEEK(NOW())");
            rs10 = pps10.executeQuery();
            if (rs10.next()) {
                String sum = rs10.getString("count(Income_id)");
                lb_payment_counter.setText(sum);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Income.class.getName()).log(Level.SEVERE, null, ex);
        }
       
             
         try {
         
            conn = DBConnection.getConnction();
            pps10 = conn.prepareStatement("SELECT count(Income_id) FROM income WHERE MONTH(Date) = MONTH(NOW())");
            rs10 = pps10.executeQuery();
            if (rs10.next()) {
                String sum = rs10.getString("count(Income_id)");
                lb_payment_counter1.setText(sum);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Income.class.getName()).log(Level.SEVERE, null, ex);
        }
       
             
             
     
       
       }
   
  

    public void ShowRoomType_onTable() {//school srtucture
   
        try {
            conn = DBConnection.getConnction();
            String sql = " SELECT Income_from,Obtained_method, Income_amount,Income_description,Date  FROM  income";
            pps2 = conn.prepareStatement(sql);
            rs2 = pps2.executeQuery();
            Students_Table_display.setModel(DbUtils.resultSetToTableModel(rs2));

        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Income.class.getName()).log(Level.SEVERE, null, ex);
        }


      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        frontSide_btn_holder = new javax.swing.JPanel();
        right = new javax.swing.JPanel();
        building_classes_panel = new javax.swing.JPanel();
        income_view = new javax.swing.JPanel();
        Delecte19 = new javax.swing.JLabel();
        Add_price4 = new javax.swing.JLabel();
        Add_price6 = new javax.swing.JLabel();
        Delecte11 = new javax.swing.JLabel();
        Delecte12 = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jLabel209 = new javax.swing.JLabel();
        jLabel213 = new javax.swing.JLabel();
        jLabel215 = new javax.swing.JLabel();
        jLabel216 = new javax.swing.JLabel();
        jLabel222 = new javax.swing.JLabel();
        jScrollPane25 = new javax.swing.JScrollPane();
        Students_Table_display = new javax.swing.JTable();
        pExpenses = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        lb_payment_counter = new javax.swing.JLabel();
        lb_payment_pending = new javax.swing.JLabel();
        lb_payments = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        lb_payment_bg = new javax.swing.JLabel();
        students_tata = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lb_students = new javax.swing.JLabel();
        lb_students_pending = new javax.swing.JLabel();
        lb_student_bg = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        lb_payment_counter1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        Monthly_ExpensesLB = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        Daily_ExpensesLB = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel82 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        Weekly_ExpensesLB = new javax.swing.JLabel();
        income_entry = new javax.swing.JPanel();
        main_subjects = new javax.swing.JPanel();
        subject_entry = new javax.swing.JPanel();
        Add_PaidServices1 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        Add_PaidServices = new javax.swing.JLabel();
        jLabel223 = new javax.swing.JLabel();
        jLabel210 = new javax.swing.JLabel();
        jLabel212 = new javax.swing.JLabel();
        jLabel217 = new javax.swing.JLabel();
        Delecte21 = new javax.swing.JLabel();
        Delecte20 = new javax.swing.JLabel();
        DueDate = new com.toedter.calendar.JDateChooser();
        jLabel228 = new javax.swing.JLabel();
        Amount = new javax.swing.JTextField();
        Payment_method = new javax.swing.JTextField();
        Payment_txt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        Count_title40 = new javax.swing.JLabel();
        Count_title39 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();
        Complaint_id = new javax.swing.JLabel();
        jLabel226 = new javax.swing.JLabel();
        Complaint_date1 = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        contact = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        Qualification = new javax.swing.JLabel();
        Qualification1 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        Qualification2 = new javax.swing.JLabel();
        Qualification3 = new javax.swing.JLabel();
        income_lits = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        printable_records = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jLabel211 = new javax.swing.JLabel();
        jLabel218 = new javax.swing.JLabel();
        jLabel219 = new javax.swing.JLabel();
        jLabel220 = new javax.swing.JLabel();
        jLabel221 = new javax.swing.JLabel();
        jLabel224 = new javax.swing.JLabel();
        jScrollPane26 = new javax.swing.JScrollPane();
        Students_Table_display1 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lb_DateIndicator = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        netexpense = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        netincome = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        Add_price5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
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
        jPanel1.add(frontSide_btn_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 80, 680));

        right.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.add(right, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 760, 1380, 60));

        building_classes_panel.setLayout(new java.awt.CardLayout());

        income_view.setBackground(new java.awt.Color(255, 255, 255));
        income_view.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Delecte19.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte19.setForeground(new java.awt.Color(255, 255, 255));
        Delecte19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_no_entry_25px.png"))); // NOI18N
        Delecte19.setText("Delecte");
        Delecte19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Delecte19MouseClicked(evt);
            }
        });
        income_view.add(Delecte19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 640, 80, 40));

        Add_price4.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Add_price4.setForeground(new java.awt.Color(255, 255, 255));
        Add_price4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Add_price4.setText("Edit");
        Add_price4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_price4MouseClicked(evt);
            }
        });
        income_view.add(Add_price4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 640, 80, 40));

        Add_price6.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Add_price6.setForeground(new java.awt.Color(255, 255, 255));
        Add_price6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Add_price6.setText("Income");
        Add_price6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_price6MouseClicked(evt);
            }
        });
        income_view.add(Add_price6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 640, 100, 40));

        Delecte11.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte11.setForeground(new java.awt.Color(255, 255, 255));
        Delecte11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        income_view.add(Delecte11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 140, 70));

        Delecte12.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte12.setForeground(new java.awt.Color(255, 255, 255));
        Delecte12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        income_view.add(Delecte12, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 620, 430, 70));

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));
        jPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel209.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel209.setForeground(new java.awt.Color(102, 102, 102));
        jLabel209.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel209.setText("Amount");
        jPanel35.add(jLabel209, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 150, 50));

        jLabel213.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel213.setForeground(new java.awt.Color(102, 102, 102));
        jLabel213.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel213.setText("Income From");
        jPanel35.add(jLabel213, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 50));

        jLabel215.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel215.setForeground(new java.awt.Color(102, 102, 102));
        jLabel215.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel215.setText("Payment method");
        jPanel35.add(jLabel215, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 120, 50));

        jLabel216.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel216.setForeground(new java.awt.Color(102, 102, 102));
        jLabel216.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel216.setText("description");
        jPanel35.add(jLabel216, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 100, 50));

        jLabel222.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel222.setForeground(new java.awt.Color(102, 102, 102));
        jLabel222.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel222.setText("Date");
        jPanel35.add(jLabel222, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, 120, 50));

        income_view.add(jPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 780, 50));

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

        income_view.add(jScrollPane25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 780, 470));

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
        pExpenses.add(lb_payment_counter, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 50, 80, 20));

        lb_payment_pending.setFont(new java.awt.Font("Tw Cen MT", 0, 11)); // NOI18N
        lb_payment_pending.setForeground(new java.awt.Color(255, 255, 255));
        lb_payment_pending.setText("All   Income");
        lb_payment_pending.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(lb_payment_pending, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 90, 30));

        lb_payments.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        lb_payments.setForeground(new java.awt.Color(255, 255, 255));
        lb_payments.setText("Income");
        lb_payments.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(lb_payments, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 120, 30));

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Currency_Settings_30px.png"))); // NOI18N
        jLabel38.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 40, 70));

        lb_payment_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/shortcut2.png"))); // NOI18N
        lb_payment_bg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_payment_bg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_payment_bgMouseClicked(evt);
            }
        });
        pExpenses.add(lb_payment_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 330, 110));

        students_tata.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        students_tata.setForeground(new java.awt.Color(255, 255, 102));
        students_tata.setText("6");
        students_tata.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(students_tata, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 80, 20));

        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_binder_30px_1.png"))); // NOI18N
        jLabel71.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 40, 60));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_calendar_6_30px.png"))); // NOI18N
        pExpenses.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 20, 40, 50));

        lb_students.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        lb_students.setForeground(new java.awt.Color(255, 255, 255));
        lb_students.setText("   Daily Income");
        lb_students.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(lb_students, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 180, 30));

        lb_students_pending.setFont(new java.awt.Font("Tw Cen MT", 0, 11)); // NOI18N
        lb_students_pending.setForeground(new java.awt.Color(255, 255, 255));
        lb_students_pending.setText("To Day");
        lb_students_pending.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(lb_students_pending, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 70, 40));

        lb_student_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/shortcut.png"))); // NOI18N
        lb_student_bg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_student_bg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_student_bgMouseClicked(evt);
            }
        });
        pExpenses.add(lb_student_bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 340, 70));

        jLabel78.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setText("   Weekly Income");
        jLabel78.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 180, 40));

        jLabel39.setFont(new java.awt.Font("Tw Cen MT", 0, 11)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Weekly");
        jLabel39.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 40, 40, 40));

        jLabel79.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Escalator_Down_30px.png"))); // NOI18N
        pExpenses.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 40, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/shortcut3.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        pExpenses.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 330, 90));

        jLabel3.setText("jLabel3");
        pExpenses.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 24, -1, 40));

        jLabel40.setFont(new java.awt.Font("Tw Cen MT", 0, 11)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Monthly");
        jLabel40.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 40, 40, 40));

        jLabel80.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setText("   Monthly Income");
        jLabel80.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, 180, 40));

        lb_payment_counter1.setFont(new java.awt.Font("Tw Cen MT", 0, 13)); // NOI18N
        lb_payment_counter1.setForeground(new java.awt.Color(0, 204, 51));
        lb_payment_counter1.setText("0");
        lb_payment_counter1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pExpenses.add(lb_payment_counter1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 50, 80, 20));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/shortcut.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        pExpenses.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 330, 90));

        jLabel81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Escalator_Down_30px.png"))); // NOI18N
        pExpenses.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 20, 40, 60));

        income_view.add(pExpenses, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 90));

        jPanel2.setBackground(new java.awt.Color(0, 153, 102));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(218, 216, 216));
        jLabel33.setText("000");
        jPanel2.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 70, 50));

        jLabel34.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(218, 216, 216));
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_loading_25px.png"))); // NOI18N
        jLabel34.setText("Total Income  ");
        jPanel2.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 130, 50));

        jLabel36.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(218, 216, 216));
        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_loading_25px.png"))); // NOI18N
        jLabel36.setText("Print");
        jLabel36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel36MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, 70));

        Monthly_ExpensesLB.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        Monthly_ExpensesLB.setForeground(new java.awt.Color(226, 224, 224));
        Monthly_ExpensesLB.setText("34000");
        Monthly_ExpensesLB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(Monthly_ExpensesLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 70, 20));

        jLabel88.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(226, 224, 224));
        jLabel88.setText("Total k :");
        jLabel88.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 60, 40));

        jLabel41.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(218, 216, 216));
        jLabel41.setText("   Monthly Income");
        jPanel2.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 130, 30));

        income_view.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 490, 410, 140));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(218, 216, 216));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_loading_25px.png"))); // NOI18N
        jLabel24.setText("Print");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 90, 50));

        jLabel30.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(218, 216, 216));
        jLabel30.setText("000");
        jPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 80, 30));

        jLabel31.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(218, 216, 216));
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_loading_25px.png"))); // NOI18N
        jLabel31.setText("Total Income  ");
        jPanel3.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 120, 30));

        Daily_ExpensesLB.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        Daily_ExpensesLB.setForeground(new java.awt.Color(226, 224, 224));
        Daily_ExpensesLB.setText("34000");
        Daily_ExpensesLB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(Daily_ExpensesLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 70, 20));

        jLabel86.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(226, 224, 224));
        jLabel86.setText("Total k :");
        jLabel86.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 70, 40));

        jLabel32.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(218, 216, 216));
        jLabel32.setText("   Daily Income");
        jPanel3.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 100, 30));

        income_view.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 160, 410, 130));

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel82.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(226, 224, 224));
        jLabel82.setText("Total k :");
        jLabel82.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 70, 40));

        jLabel18.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(218, 216, 216));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_loading_25px.png"))); // NOI18N
        jLabel18.setText("Total Income  ");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 120, 40));

        jLabel20.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(218, 216, 216));
        jLabel20.setText("   Weekly Income");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 110, 30));

        jLabel21.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(218, 216, 216));
        jLabel21.setText("000");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 70, 40));

        jLabel22.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(218, 216, 216));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_loading_25px.png"))); // NOI18N
        jLabel22.setText("Print");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 80, 60));

        Weekly_ExpensesLB.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        Weekly_ExpensesLB.setForeground(new java.awt.Color(226, 224, 224));
        Weekly_ExpensesLB.setText("34000");
        Weekly_ExpensesLB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(Weekly_ExpensesLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 70, -1));

        income_view.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 310, 410, 160));

        building_classes_panel.add(income_view, "card2");

        income_entry.setBackground(new java.awt.Color(255, 255, 255));
        income_entry.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        main_subjects.setBackground(new java.awt.Color(255, 255, 255));
        main_subjects.setLayout(new java.awt.CardLayout());

        subject_entry.setBackground(new java.awt.Color(255, 255, 255));
        subject_entry.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Add_PaidServices1.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Add_PaidServices1.setForeground(new java.awt.Color(255, 255, 255));
        Add_PaidServices1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Add_PaidServices1.setText("Update");
        Add_PaidServices1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_PaidServices1MouseClicked(evt);
            }
        });
        subject_entry.add(Add_PaidServices1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 100, 50));

        jLabel154.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel154.setForeground(new java.awt.Color(33, 173, 178));
        jLabel154.setText("Income Entry");
        subject_entry.add(jLabel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 170, 40));

        Add_PaidServices.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Add_PaidServices.setForeground(new java.awt.Color(255, 255, 255));
        Add_PaidServices.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Add_PaidServices.setText("  Submit");
        Add_PaidServices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_PaidServicesMouseClicked(evt);
            }
        });
        subject_entry.add(Add_PaidServices, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, 100, 50));

        jLabel223.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel223.setForeground(new java.awt.Color(102, 102, 102));
        jLabel223.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel223.setText("  Income From");
        subject_entry.add(jLabel223, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 200, 30));

        jLabel210.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel210.setForeground(new java.awt.Color(102, 102, 102));
        jLabel210.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel210.setText("  Obtained method");
        subject_entry.add(jLabel210, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 210, 30));

        jLabel212.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel212.setForeground(new java.awt.Color(102, 102, 102));
        jLabel212.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel212.setText("  description");
        subject_entry.add(jLabel212, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 190, 20));

        jLabel217.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel217.setForeground(new java.awt.Color(102, 102, 102));
        jLabel217.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel217.setText("  Amount");
        subject_entry.add(jLabel217, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 170, 50));

        Delecte21.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte21.setForeground(new java.awt.Color(255, 255, 255));
        Delecte21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        subject_entry.add(Delecte21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 180, 80));

        Delecte20.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte20.setForeground(new java.awt.Color(255, 255, 255));
        Delecte20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        Delecte20.setText("Delecte");
        subject_entry.add(Delecte20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 360, 80));

        DueDate.setBackground(new java.awt.Color(204, 204, 204));
        subject_entry.add(DueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 290, 30));

        jLabel228.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel228.setForeground(new java.awt.Color(102, 102, 102));
        jLabel228.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel228.setText("Date");
        subject_entry.add(jLabel228, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 170, 50));
        subject_entry.add(Amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 290, 30));
        subject_entry.add(Payment_method, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 290, 30));
        subject_entry.add(Payment_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 290, 30));

        description.setColumns(20);
        description.setRows(5);
        jScrollPane1.setViewportView(description);

        subject_entry.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 530, 240));

        Count_title40.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title40.setForeground(new java.awt.Color(255, 255, 255));
        Count_title40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title40.setText("NEW RECORDS");
        Count_title40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Count_title40MouseClicked(evt);
            }
        });
        subject_entry.add(Count_title40, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 190, 60));

        Count_title39.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title39.setForeground(new java.awt.Color(255, 255, 255));
        Count_title39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_30px.png"))); // NOI18N
        Count_title39.setText("   BACK");
        Count_title39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Count_title39MouseClicked(evt);
            }
        });
        subject_entry.add(Count_title39, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 0, 190, 60));

        background.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/Untitled-2.png"))); // NOI18N
        subject_entry.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -90, 1150, 620));

        Complaint_id.setText("jLabel1");
        subject_entry.add(Complaint_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 110, -1));

        jLabel226.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel226.setForeground(new java.awt.Color(102, 102, 102));
        jLabel226.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel226.setText("Complaint Handler ID");
        subject_entry.add(jLabel226, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 170, 50));
        subject_entry.add(Complaint_date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 290, 30));

        main_subjects.add(subject_entry, "card3");

        income_entry.add(main_subjects, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1140, 560));

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

        income_entry.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 40));

        building_classes_panel.add(income_entry, "card8");

        income_lits.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        printable_records.setBackground(new java.awt.Color(255, 255, 255));
        printable_records.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel36.setBackground(new java.awt.Color(204, 204, 204));
        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel211.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel211.setForeground(new java.awt.Color(102, 102, 102));
        jLabel211.setText("Amount");
        jPanel36.add(jLabel211, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 140, 50));

        jLabel218.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel218.setForeground(new java.awt.Color(102, 102, 102));
        jLabel218.setText("Income From");
        jPanel36.add(jLabel218, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 50));

        jLabel219.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel219.setForeground(new java.awt.Color(102, 102, 102));
        jLabel219.setText("Total  Income");
        jPanel36.add(jLabel219, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, 120, 50));

        jLabel220.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel220.setForeground(new java.awt.Color(102, 102, 102));
        jLabel220.setText("Payment method");
        jPanel36.add(jLabel220, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 150, 50));

        jLabel221.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel221.setForeground(new java.awt.Color(102, 102, 102));
        jLabel221.setText("description");
        jPanel36.add(jLabel221, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 100, 50));

        jLabel224.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel224.setForeground(new java.awt.Color(102, 102, 102));
        jLabel224.setText("   Date");
        jPanel36.add(jLabel224, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 120, 50));

        printable_records.add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 910, 60));

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

        printable_records.add(jScrollPane26, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 770, 640));
        printable_records.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 140, 190, 30));
        printable_records.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 860, 210, 20));
        printable_records.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 860, 160, 30));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel1.setText("=");
        printable_records.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 830, 20, 20));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel4.setText("Total Net Income");
        printable_records.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 860, 110, 40));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel5.setText("Total Expenses");
        printable_records.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 850, 110, 40));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel6.setText("Total Net Income");
        printable_records.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 860, 110, 30));

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel7.setText("/");
        printable_records.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 840, 20, 20));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel8.setText("INCOME RECORDS");
        printable_records.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 350, 40));

        lb_DateIndicator.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lb_DateIndicator.setText("MONTHLY ");
        printable_records.add(lb_DateIndicator, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 130, 40));
        printable_records.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 730, 140, 20));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTable1);

        printable_records.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 140, 10, 640));
        printable_records.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 860, 220, 30));
        printable_records.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 780, 900, 10));
        printable_records.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 770, 190, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        printable_records.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 734, 130, 40));

        netexpense.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        netexpense.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        netexpense.setText("jLabel11");
        printable_records.add(netexpense, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 820, 160, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("jLabel11");
        printable_records.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 820, 210, 30));

        netincome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        netincome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        netincome.setText("jLabel11");
        printable_records.add(netincome, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 824, 210, 30));

        jScrollPane2.setViewportView(printable_records);

        income_lits.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 690));

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel5.add(Add_price5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 80, 50));

        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("BACK");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 70));

        income_lits.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 20, 210, 70));

        building_classes_panel.add(income_lits, "card4");

        jPanel1.add(building_classes_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 1260, 690));

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
        admin_btn.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 110, 40));

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
        this.setExtendedState(Accountant_Income.ICONIFIED);
    }//GEN-LAST:event_minize_lbMouseClicked

    private void Add_PaidServicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_PaidServicesMouseClicked
           
             
             
         if(Payment_txt.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Payment To is Empty");
        }else if( description.getText().isEmpty()){
          JOptionPane.showMessageDialog(null, "Write the massage ");
         }else {
        
            
      Date Date_Recorded;  
         if(DueDate.getDateEditor().equals(null)){
           Date date1 = DueDate.getDate();
           java.sql.Date sqldate1 = new java.sql.Date(date1.getTime());
           Date_Recorded = sqldate1;
         }else{
         
         
         Date date = new Date();
         java.sql.Date sqldate = new java.sql.Date(date.getTime());
         Date_Recorded = sqldate;
         
         }
       

        int New_amount  = Integer.parseInt(Amount.getText());
        
        
          try {
             conn = DBConnection.getConnction();
             String sql = "INSERT INTO  income (Income_from,Obtained_method,Income_amount, Income_description,Date) VALUES (?,?,?,?,?)";
            pps = conn.prepareStatement(sql);
            pps.setString(1 , Payment_txt.getText());
            pps.setString(2 , Payment_method.getText());
            pps.setInt(3,   New_amount);
            pps.setString(4 , description.getText());
            pps.setDate(5 , (java.sql.Date) Date_Recorded);
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Successfully Saved" );
            Payment_txt.setText(null);
            Payment_method.setText(null);
            Amount.setText(null);
            DueDate.setDate(null);
            description .setText(null);
        } catch (SQLException ex) {
           Logger.getLogger(Accountant_Income.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
      
        }
             
     //    Students_Table_display
         
        ShowRoomType_onTable() ;
           Count_Roomtype();
    }//GEN-LAST:event_Add_PaidServicesMouseClicked

    private void Count_title39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Count_title39MouseClicked
        subject_entry.hide();
        income_view.setVisible(true);
        income_entry.hide();
           subject_entry.hide();
            Add_PaidServices.setVisible(true);
    }//GEN-LAST:event_Count_title39MouseClicked

    String get_expenses_id = null;
    
    private void Delecte19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Delecte19MouseClicked
        

        if (subject_selected.equals("none")) {
            JOptionPane.showMessageDialog(null, "Select the Message you wish to view");
            
        } else if (!subject_selected.equals("none")) {
        
        
            
            
             try {
            conn = DBConnection.getConnction();
            String sql = " SELECT * FROM income WHERE (Income_from =? AND Income_description  =?) AND ( Income_amount  =? AND  Date  =? ) ";
            pps9 = conn.prepareStatement(sql);
            pps9.setString(1, get_Payment_To);
            pps9.setString(2, get_description);
            pps9.setString(3, get_Amount);
            pps9.setString(4, get_Date);
            
            rs9 = pps9.executeQuery();
            if(rs9.next()){
             get_expenses_id = rs9.getString("Income_id");
              Delecte_expenses();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Income.class.getName()).log(Level.SEVERE, null, ex);
        }

            
           
       
         
        
        }
        
    }//GEN-LAST:event_Delecte19MouseClicked

    
  public void Delecte_expenses() {
  
    try {
             conn = DBConnection.getConnction();
             pps3 = conn.prepareStatement("DELETE  FROM   income WHERE  Income_id = ? ");
             pps3.setString(1, get_expenses_id);
             pps3.executeUpdate();
             JOptionPane.showMessageDialog(null, "income Delected" );
            
             
            } catch (SQLException ex) {
            Logger.getLogger(Accountant_Income.class.getName()).log(Level.SEVERE, null, ex);
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
            String sql = "SELECT Income_from,Obtained_method, Income_amount,Income_description,Date  FROM  income";
            pps2 = conn.prepareStatement(sql);
            rs2 = pps2.executeQuery();
            Students_Table_display.setModel(DbUtils.resultSetToTableModel(rs2));
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Income.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_lb_payment_bgMouseClicked

    private void lb_student_bgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_student_bgMouseClicked
      
        
        try {
             Date date = new Date();
             java.sql.Date sqldate = new java.sql.Date(date.getTime());
            
            
            
            conn = DBConnection.getConnction();
            String sql = " SELECT Income_from,Obtained_method, Income_amount,Income_description,Date FROM income WHERE Date =? ";
            pps2 = conn.prepareStatement(sql);
            pps2.setDate(1, sqldate);
            rs2 = pps2.executeQuery();
            Students_Table_display.setModel(DbUtils.resultSetToTableModel(rs2));
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Income.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_lb_student_bgMouseClicked

    private void Students_Table_displayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Students_Table_displayMouseClicked
         
        
        DefaultTableModel tableMode_type = (DefaultTableModel) Students_Table_display.getModel();
          get_Payment_To = tableMode_type.getValueAt(Students_Table_display.getSelectedRow(), 0).toString();
        
         DefaultTableModel tableMode_type1 = (DefaultTableModel) Students_Table_display.getModel();
         get_Amount = tableMode_type1.getValueAt(Students_Table_display.getSelectedRow(), 2).toString();
         
        
         
        
         DefaultTableModel tableMode_type3 = (DefaultTableModel) Students_Table_display.getModel();
           get_description= tableMode_type3.getValueAt(Students_Table_display.getSelectedRow(),3).toString();
           
           
         DefaultTableModel tableMode_type2 = (DefaultTableModel) Students_Table_display.getModel();
         get_Date = tableMode_type2.getValueAt(Students_Table_display.getSelectedRow(), 4).toString();
         
            subject_selected2 = "selected";
        subject_selected = "selected";
        
        

        
        
        
        
        
    }//GEN-LAST:event_Students_Table_displayMouseClicked
  
    private void Add_price4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_price4MouseClicked
       
          if (subject_selected.equals("none")) {
            JOptionPane.showMessageDialog(null, "Select the Message you wish to view");
            
        } else if (!subject_selected.equals("none")) {
        
        
     
          try {
             conn = DBConnection.getConnction();
             String sql = "SELECT  Income_from,Obtained_method,Income_amount, Income_description,Date, Income_id  FROM income WHERE (Income_from = ? AND Date = ?) AND (Income_description = ? OR Income_amount = ? )";
            pps4 = conn.prepareStatement(sql);
            pps4.setString(1 , get_Payment_To);
            pps4.setString(2 , get_Date);
            pps4.setString(3, get_description);
            pps4.setString(4 , get_Amount);
           
             rs4 = pps4.executeQuery();
              if(rs4.next()){
              
                Payment_txt.setText(rs4.getString("Income_from"));
                Payment_method.setText(rs4.getString("Obtained_method"));
                Amount.setText(rs4.getString("Income_amount"));
                description .setText(rs4.getString("Income_description"));
                get_Expense_id_toUpdate = rs4.getString("Income_id");
              }
             
             
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
          
         Add_PaidServices.hide();
            income_view.hide();
            income_entry.setVisible(true);
      
          
          
        }
    }//GEN-LAST:event_Add_price4MouseClicked

    private void Add_PaidServices1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_PaidServices1MouseClicked
                
      Date Date_Recorded;  
         if(DueDate.getDateEditor().equals(null)){
           Date date1 = DueDate.getDate();
           java.sql.Date sqldate1 = new java.sql.Date(date1.getTime());
           Date_Recorded = sqldate1;
         }else{
         
         
         Date date = new Date();
         java.sql.Date sqldate = new java.sql.Date(date.getTime());
         Date_Recorded = sqldate;
         
         }
         int New_Amount = Integer.parseInt(Amount.getText());
        
        try {  //,,, ,
                 conn = DBConnection.getConnction();
                String sql = "UPDATE   income SET Income_from =?,Obtained_method =?, Income_amount =? ,Income_description =?,Date =? WHERE Income_id =? ";
                pps5 = conn.prepareStatement(sql);
                 pps5.setString(1 , Payment_txt.getText());
                 pps5.setString(2 , Payment_method.getText().toUpperCase());
                 pps5.setInt(3, New_Amount);
                pps5.setString(4 , description.getText());
                pps5.setDate(5 , (java.sql.Date) Date_Recorded);
                
                
                 pps5.setString(6 ,get_Expense_id_toUpdate );
                  
                pps5.executeUpdate();
               
                  Payment_txt.setText(null);
                  Payment_method.setText(null);
                  Amount.setText(null);
                  description.setText(null);
                  
                  JOptionPane.showMessageDialog(null, "Successfully Updated");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
         ShowRoomType_onTable() ;
         Count_Roomtype();
    }//GEN-LAST:event_Add_PaidServices1MouseClicked

    private void Students_Table_display1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Students_Table_display1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Students_Table_display1MouseClicked

    private void Add_price5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_price5MouseClicked
       
       
          PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("PRINT EXPENSE RECORDS");

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
                printable_records.print(g2);

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

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        try {
            
            conn = DBConnection.getConnction();
            String sql = " SELECT Income_from,Obtained_method, Income_amount,Income_description,Date  FROM income WHERE  YEARWEEK(date) = YEARWEEK(NOW())";
            pps2 = conn.prepareStatement(sql);
            rs2 = pps2.executeQuery();
            Students_Table_display.setModel(DbUtils.resultSetToTableModel(rs2));
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Income.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        try {
             
            conn = DBConnection.getConnction();
            String sql = " SELECT Income_from,Obtained_method, Income_amount,Income_description,Date  FROM income WHERE MONTH(date) = MONTH(NOW())";
            pps3 = conn.prepareStatement(sql);
            rs3 = pps3.executeQuery();
            Students_Table_display.setModel(DbUtils.resultSetToTableModel(rs3));
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Income.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel36MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel36MouseClicked
      
        
        lb_DateIndicator.setText("MONTHLY");
       
        income_view.hide();
        income_entry.hide();
        income_lits.setVisible(true);
        
        
    }//GEN-LAST:event_jLabel36MouseClicked

    private void Add_price6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_price6MouseClicked
        income_view.hide();
        income_lits.hide();
        income_entry.setVisible(true);
    }//GEN-LAST:event_Add_price6MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        income_view.setVisible(true);
        income_entry.hide();
        income_lits.hide();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
           try {
            
            conn = DBConnection.getConnction();
            String sql = " SELECT Income_from,Obtained_method, Income_amount,Income_description,Date  FROM income WHERE  MONTH(Date) = MONTH(NOW())  ";
            pps9 = conn.prepareStatement(sql);
    
            rs9 = pps9.executeQuery();
            Students_Table_display1.setModel(DbUtils.resultSetToTableModel(rs9));
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Income.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        try {
            
          
            conn = DBConnection.getConnction();
            String sql = " SELECT  sum(Income_amount)  FROM income WHERE   MONTH(Date) = MONTH(NOW())  ";
            pps6 = conn.prepareStatement(sql);
           
            rs6 = pps6.executeQuery();
           if(rs6.next()){
            jLabel10.setText("K :" +  rs6.getString("sum(Income_amount)"));
           
           }
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Income.class.getName()).log(Level.SEVERE, null, ex);
        }
        ///
        
        
        
        
            String Total_Net_Income = null;
        try {
             
            conn = DBConnection.getConnction();
            pps11 = conn.prepareStatement("SELECT  Sum(Income_amount) FROM   income WHERE MONTH(Date) = MONTH(NOW())");
            rs11= pps11.executeQuery();
            if (rs11.next()) {
              Total_Net_Income = rs11.getString("Sum(Income_amount)");
               
                netincome.setText(Total_Net_Income);
            }
        } catch (SQLException ex) {Logger.getLogger(Accountant_Income.class.getName()).log(Level.SEVERE, null, ex);  }
    
          
        
        String Total_Net_expense = null;
        
             try {
       
            conn = DBConnection.getConnction();
            pps10 = conn.prepareStatement("SELECT sum(Amount) FROM expenses WHERE MONTH(Date) = MONTH(NOW())");
            rs10 = pps10.executeQuery();
            if (rs10.next()) {
                Total_Net_expense = rs10.getString("sum(Amount)");
                netexpense.setText(Total_Net_expense);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Expenses.class.getName()).log(Level.SEVERE, null, ex);
        }
       
     
           int Net_Income = Integer.parseInt(Total_Net_Income);
           int Net_Expense = Integer.parseInt(Total_Net_expense);        
             String sum = Integer.toString(Net_Income - Net_Expense);
             jLabel12.setText("k: "+ sum );
        
        
            lb_DateIndicator.setText("MONTHLY");
        income_view.hide();
        income_entry.hide();
        income_lits.setVisible(true);
        
        
        
        
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
       
           try {
  
            
            conn = DBConnection.getConnction();
            String sql = " SELECT  Income_from,Obtained_method, Income_amount,Income_description,Date  FROM income WHERE   YEARWEEK(Date) = YEARWEEK(NOW()) "; //AND Status =?
            pps8 = conn.prepareStatement(sql);
            rs8 = pps8.executeQuery();
            Students_Table_display1.setModel(DbUtils.resultSetToTableModel(rs8));
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Income.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        countSumWeekly();
       
    }//GEN-LAST:event_jPanel4MouseClicked

    public void countSumWeekly(){
    
     try {
            
            conn = DBConnection.getConnction();
            String sql = " SELECT  sum(Income_amount)   FROM income WHERE  (YEARWEEK(Date) = YEARWEEK(NOW()) )   ";
            pps10 = conn.prepareStatement(sql);
            rs10 = pps10.executeQuery();
           if(rs10.next()){
               String SUM = rs10.getString("sum(Income_amount)");
            jLabel10.setText("K :" +  SUM);
           
           }
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Income.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     String Total_Net_Income = null;
        try {
             
            conn = DBConnection.getConnction();
            pps11 = conn.prepareStatement("SELECT  Sum(Income_amount) FROM   income WHERE YEARWEEK(Date) = YEARWEEK(NOW())");
            rs11= pps11.executeQuery();
            if (rs11.next()) {
              Total_Net_Income = rs11.getString("Sum(Income_amount)");
               
                netincome.setText(Total_Net_Income);
            }
        } catch (SQLException ex) {Logger.getLogger(Accountant_Income.class.getName()).log(Level.SEVERE, null, ex);  }
    
          
        
        String Total_Net_expense = null;
        
             try {
       
            conn = DBConnection.getConnction();
            pps10 = conn.prepareStatement("SELECT sum(Amount) FROM expenses WHERE YEARWEEK(Date) = YEARWEEK(NOW())");
            rs10 = pps10.executeQuery();
            if (rs10.next()) {
                Total_Net_expense = rs10.getString("sum(Amount)");
                netexpense.setText(Total_Net_expense);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Expenses.class.getName()).log(Level.SEVERE, null, ex);
        }
       
     
           int Net_Income = Integer.parseInt(Total_Net_Income);
           int Net_Expense = Integer.parseInt(Total_Net_expense);        
             String sum = Integer.toString(Net_Income - Net_Expense);
             jLabel12.setText(sum );
             
        
        lb_DateIndicator.setText("WEEKLY");
        income_view.hide();
        income_entry.hide();
        income_lits.setVisible(true);
    
    }
    
    
    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
      
        
              Date date = new Date();
             java.sql.Date sqldate = new java.sql.Date(date.getTime());
            
                          

        try {
            
            
            conn = DBConnection.getConnction();
            String sql = " SELECT  Income_from,Obtained_method, Income_amount,Income_description,Date  FROM income WHERE Date =? ";
            pps6 = conn.prepareStatement(sql);
            pps6.setDate(1, sqldate);
            rs6 = pps6.executeQuery();
            Students_Table_display1.setModel(DbUtils.resultSetToTableModel(rs6));
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Income.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        try {
             
            
            conn = DBConnection.getConnction();
            String sql = " SELECT  sum(Income_amount)   FROM income WHERE Date =? ";
            pps7 = conn.prepareStatement(sql);
            pps7.setDate(1, sqldate);
            rs7 = pps7.executeQuery();
           if(rs7.next()){
            jLabel10.setText("K :" +  rs7.getString("sum(Income_amount)"));
           
           }
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Income.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        
        
        
        
            String Total_Net_Income = null;
        try {
             
            conn = DBConnection.getConnction();
            pps11 = conn.prepareStatement("SELECT  Sum(Income_amount) FROM   income WHERE Date =?");
            pps11.setDate(1, sqldate);
            rs11= pps11.executeQuery();
            if (rs11.next()) {
              Total_Net_Income = rs11.getString("Sum(Income_amount)");
               
                netincome.setText(Total_Net_Income);
            }
        } catch (SQLException ex) {Logger.getLogger(Accountant_Income.class.getName()).log(Level.SEVERE, null, ex);  }
    
          
        
        String Total_Net_expense = null;
        
             try {
       
            conn = DBConnection.getConnction();
            pps10 = conn.prepareStatement("SELECT sum(Amount) FROM expenses WHERE Date =?");
           pps10.setDate(1, sqldate);
            rs10 = pps10.executeQuery();
            if (rs10.next()) {
                Total_Net_expense = rs10.getString("sum(Amount)");
                netexpense.setText(Total_Net_expense);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Accountant_Expenses.class.getName()).log(Level.SEVERE, null, ex);
        }
       
     
           int Net_Income = Integer.parseInt(Total_Net_Income);
           int Net_Expense = Integer.parseInt(Total_Net_expense);        
             String sum = Integer.toString(Net_Income - Net_Expense);
             jLabel12.setText("k: "+ sum );
        
        
        
        
        
        lb_DateIndicator.setText("DAILY");
        
          income_view.hide();
        income_entry.hide();
        income_lits.setVisible(true);
        
        
        
    }//GEN-LAST:event_jPanel3MouseClicked

    private void Count_title40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Count_title40MouseClicked
       Add_PaidServices.setVisible(true);
    }//GEN-LAST:event_Count_title40MouseClicked
   
    
    
    
    
    

     public static Accountant_Income getObj() {  //public method for instance Restriction
        if (Obj == null) {
            Obj = new Accountant_Income();
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
            java.util.logging.Logger.getLogger(Accountant_Income.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Accountant_Income.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Accountant_Income.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Accountant_Income.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Accountant_Income().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Add_PaidServices;
    private javax.swing.JLabel Add_PaidServices1;
    private javax.swing.JLabel Add_price4;
    private javax.swing.JLabel Add_price5;
    private javax.swing.JLabel Add_price6;
    private javax.swing.JTextField Amount;
    private javax.swing.JLabel BackGround_layer1;
    private javax.swing.JTextField Complaint_date1;
    private javax.swing.JLabel Complaint_id;
    private javax.swing.JLabel Count_title39;
    private javax.swing.JLabel Count_title40;
    private javax.swing.JLabel Daily_ExpensesLB;
    private javax.swing.JLabel Delecte11;
    private javax.swing.JLabel Delecte12;
    private javax.swing.JLabel Delecte19;
    private javax.swing.JLabel Delecte20;
    private javax.swing.JLabel Delecte21;
    private com.toedter.calendar.JDateChooser DueDate;
    private javax.swing.JLabel Monthly_ExpensesLB;
    private javax.swing.JTextField Payment_method;
    private javax.swing.JTextField Payment_txt;
    private javax.swing.JLabel Qualification;
    private javax.swing.JLabel Qualification1;
    private javax.swing.JLabel Qualification2;
    private javax.swing.JLabel Qualification3;
    private javax.swing.JTable Students_Table_display;
    private javax.swing.JTable Students_Table_display1;
    private javax.swing.JLabel Weekly_ExpensesLB;
    private javax.swing.JPanel admin_btn;
    private javax.swing.JLabel background;
    private javax.swing.JPanel building_classes_panel;
    private javax.swing.JLabel contact;
    private javax.swing.JTextArea description;
    private javax.swing.JLabel email;
    private javax.swing.JLabel exit_lb;
    private javax.swing.JPanel frontSide_btn_holder;
    private javax.swing.JLabel header;
    private javax.swing.JPanel income_entry;
    private javax.swing.JPanel income_lits;
    private javax.swing.JPanel income_view;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel209;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel210;
    private javax.swing.JLabel jLabel211;
    private javax.swing.JLabel jLabel212;
    private javax.swing.JLabel jLabel213;
    private javax.swing.JLabel jLabel215;
    private javax.swing.JLabel jLabel216;
    private javax.swing.JLabel jLabel217;
    private javax.swing.JLabel jLabel218;
    private javax.swing.JLabel jLabel219;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel220;
    private javax.swing.JLabel jLabel221;
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel223;
    private javax.swing.JLabel jLabel224;
    private javax.swing.JLabel jLabel226;
    private javax.swing.JLabel jLabel228;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lb_DateIndicator;
    private javax.swing.JLabel lb_payment_bg;
    private javax.swing.JLabel lb_payment_counter;
    private javax.swing.JLabel lb_payment_counter1;
    private javax.swing.JLabel lb_payment_pending;
    private javax.swing.JLabel lb_payments;
    private javax.swing.JLabel lb_student_bg;
    private javax.swing.JLabel lb_students;
    private javax.swing.JLabel lb_students_pending;
    private javax.swing.JPanel main_subjects;
    private javax.swing.JLabel minize_lb;
    private javax.swing.JLabel model;
    private javax.swing.JLabel name;
    private javax.swing.JLabel netexpense;
    private javax.swing.JLabel netincome;
    private javax.swing.JPanel pExpenses;
    private javax.swing.JPanel printable_records;
    private javax.swing.JPanel right;
    private javax.swing.JLabel students_tata;
    private javax.swing.JPanel subject_entry;
    // End of variables declaration//GEN-END:variables
}
