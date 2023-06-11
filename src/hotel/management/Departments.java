
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
import static java.lang.Thread.sleep;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Departments extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pps, pps1, pps2, pps3, pps4, pps6, pps5, pps7, pps8, pps9, pps10, pps11, pps12, pps13 = null;
    ResultSet rs, rs1, rs2, rs3, rs4, rs5, rs6, rs7, rs8, rs9, rs10, rs11, rs12, rs13 = null;
    
    
//xtDepartment
    String resource = null;
    String Selected_Department_getID =null;
    
   String  designation_resource_getID =  null;
   String   department_resource_getID  = null;  
   
   String User_login_ID_resource= null;
      String Option_Department = null;
       String Employee_Given_ID_resource  = null;
       
       //getting the id from the majors to use update the subjects
       String  Major1_resource   = null;
       String  Major2_resource   = null;
       String  Major3_resource   = null;

    private static String Recieved_user_id = null;
    private static String usertype = null;
    //passing user id
    private static Departments Obj = null;
    private String passed_user_id;
    
    
     String imgBTN_clicked = "none";
     String obtained_use_id= null; //obtaing the generated user id



    
    //geting user id
    String entered_user_name =null;
    String entered_user_level =null;
    String entered_user_password =null;
    
    
            int xx = 0;
            int yy = 0;
    
     Departments() {
        initComponents();
        showContent_onAllTables();
        ComboDisplay();
        
        
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
            byte[] image = null;
            while(rs6.next()){
            //     user_access_id  =  rs6.getString("access_id");

                 String fname=  rs6.getString("first_name");
                 String lname=  rs6.getString("last_name");
                 mode.setText("Hi !"+fname +"  "+lname + "  Welcome HR Manager");
                 model.setText(rs6.getString("user"));
              
                 
            
                }
            } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
     
    
  public void showContent_onAllTables(){
  
          //rooms on the 
        try {
         conn = DBConnection.getConnction();
        String sql ="SELECT department.name, employee.name,employee.surname  FROM    department INNER JOIN  employee ON  department.department_id = employee.Head_Of_Department  ";
        pps1 = conn.prepareStatement(sql);
         rs1 = pps1.executeQuery();
         Department_Table_display.setModel(DbUtils.resultSetToTableModel(rs1));
        
    } catch (SQLException ex) {Logger.getLogger(Departments.class.getName()).log(Level.SEVERE, null, ex);}
       
      
      
     
      
    try {
      
         conn = DBConnection.getConnction();
          String sql = " SELECT name FROM department";
         pps = conn.prepareStatement(sql);
         rs = pps.executeQuery();
       ///  Department_Table_display.setModel(DbUtils.resultSetToTableModel(rs));
         
    } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
    
    
         //rooms on the 
        try {
         conn = DBConnection.getConnction();
        String sql ="SELECT department.name, designation.name FROM    department INNER JOIN  designation ON  department.department_id = designation.department_id  ";
        pps1 = conn.prepareStatement(sql);
         rs1 = pps1.executeQuery();
         Designation_Table_display.setModel(DbUtils.resultSetToTableModel(rs1));
        
    } catch (SQLException ex) {Logger.getLogger(Departments.class.getName()).log(Level.SEVERE, null, ex);}
        
        
       try {
      
        conn = DBConnection.getConnction();
          String sql = " SELECT name,surname,department,designation FROM employee";
         pps = conn.prepareStatement(sql);
         rs = pps.executeQuery();
         Employee_Table_display.setModel(DbUtils.resultSetToTableModel(rs));
    } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
         //rooms on the  Employee_Table_display
        
  }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Side_Panel = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        front_holder = new javax.swing.JPanel();
        hotel_ma = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        calender = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        report_panelBTN = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        center = new javax.swing.JPanel();
        P_Departments = new javax.swing.JPanel();
        roomcount5 = new javax.swing.JLabel();
        Count_title4 = new javax.swing.JLabel();
        lb_hold7 = new javax.swing.JLabel();
        lb_hold5 = new javax.swing.JLabel();
        lb_hold6 = new javax.swing.JLabel();
        lb_hold4 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        Count_title45 = new javax.swing.JLabel();
        roomcount6 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        roomcount7 = new javax.swing.JLabel();
        Count_title6 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        roomcount8 = new javax.swing.JLabel();
        Count_title7 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        Departments_main = new javax.swing.JPanel();
        Departments_list = new javax.swing.JPanel();
        Searching_panel_holder = new javax.swing.JPanel();
        btn_layout1 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        textSearch_Department = new javax.swing.JTextField();
        Add_price4 = new javax.swing.JLabel();
        lb_bg_btnFirstView3 = new javax.swing.JLabel();
        cover_layout1 = new javax.swing.JPanel();
        edit20 = new javax.swing.JLabel();
        Delecte27 = new javax.swing.JLabel();
        addRoom_type2 = new javax.swing.JLabel();
        bg_back_layout = new javax.swing.JLabel();
        jPanel37 = new javax.swing.JPanel();
        jLabel222 = new javax.swing.JLabel();
        jLabel223 = new javax.swing.JLabel();
        jScrollPane27 = new javax.swing.JScrollPane();
        Department_Table_display = new javax.swing.JTable();
        table_holder_bg17 = new javax.swing.JLabel();
        Departments_entry = new javax.swing.JPanel();
        Count_title8 = new javax.swing.JLabel();
        jScrollPane30 = new javax.swing.JScrollPane();
        DPTable = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        PreDefined_Departments = new javax.swing.JComboBox();
        txtHeadOFDP = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        Depart = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel200 = new javax.swing.JLabel();
        DOBid = new javax.swing.JTextField();
        P_Designation = new javax.swing.JPanel();
        roomcount14 = new javax.swing.JLabel();
        Count_title13 = new javax.swing.JLabel();
        lb_hold13 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        lb_hold12 = new javax.swing.JLabel();
        Count_title12 = new javax.swing.JLabel();
        roomcount13 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        Count_title14 = new javax.swing.JLabel();
        roomcount15 = new javax.swing.JLabel();
        lb_hold14 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        Count_title15 = new javax.swing.JLabel();
        roomcount16 = new javax.swing.JLabel();
        lb_hold15 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        P_Designation_main = new javax.swing.JPanel();
        Designation_list = new javax.swing.JPanel();
        Delecte25 = new javax.swing.JLabel();
        edit19 = new javax.swing.JLabel();
        addRoom_type1 = new javax.swing.JLabel();
        Delecte26 = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        jLabel226 = new javax.swing.JLabel();
        jLabel227 = new javax.swing.JLabel();
        jScrollPane28 = new javax.swing.JScrollPane();
        Designation_Table_display = new javax.swing.JTable();
        table_holder_bg16 = new javax.swing.JLabel();
        Designation_entry = new javax.swing.JPanel();
        Dname = new javax.swing.JTextField();
        ShowDepartments = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lb_BG = new javax.swing.JLabel();
        backtoDesig = new javax.swing.JLabel();
        P_employee = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        roomcount1 = new javax.swing.JLabel();
        roomcount2 = new javax.swing.JLabel();
        Count_title1 = new javax.swing.JLabel();
        Count_title2 = new javax.swing.JLabel();
        Count_title = new javax.swing.JLabel();
        roomcount4 = new javax.swing.JLabel();
        roomcount3 = new javax.swing.JLabel();
        lb_hold1 = new javax.swing.JLabel();
        lb_hold2 = new javax.swing.JLabel();
        lb_hold3 = new javax.swing.JLabel();
        lb_hold = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        Count_title40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        employee_main = new javax.swing.JPanel();
        Employee_list = new javax.swing.JPanel();
        Searching_panel_holder1 = new javax.swing.JPanel();
        Cover_layout = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        tex_Search_Employee = new javax.swing.JTextField();
        Add_price5 = new javax.swing.JLabel();
        lb_bg_btnFirstView4 = new javax.swing.JLabel();
        btn_layout = new javax.swing.JPanel();
        edit18 = new javax.swing.JLabel();
        Delecte23 = new javax.swing.JLabel();
        addRoom_type = new javax.swing.JLabel();
        bg_back_layout1 = new javax.swing.JLabel();
        jScrollPane29 = new javax.swing.JScrollPane();
        Employee_Table_display = new javax.swing.JTable();
        jPanel39 = new javax.swing.JPanel();
        jLabel229 = new javax.swing.JLabel();
        jLabel230 = new javax.swing.JLabel();
        jLabel231 = new javax.swing.JLabel();
        jLabel232 = new javax.swing.JLabel();
        table_holder_bg15 = new javax.swing.JLabel();
        Employee_entry = new javax.swing.JPanel();
        employee_Inner_panel = new javax.swing.JPanel();
        panel_forUser_Account = new javax.swing.JPanel();
        txtConfirm_pass = new javax.swing.JPasswordField();
        txtPassword = new javax.swing.JTextField();
        txtUser_name = new javax.swing.JTextField();
        access_level_choser = new javax.swing.JComboBox();
        txtHint = new javax.swing.JTextField();
        fname_txt = new javax.swing.JTextField();
        lname_txt = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel77 = new javax.swing.JLabel();
        image_chooser = new javax.swing.JLabel();
        logo2 = new javax.swing.JLabel();
        txtcontact = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        panel_forPersonal_info = new javax.swing.JPanel();
        Container_forGeneral = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        addreessLb = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbEmail1 = new javax.swing.JLabel();
        lbSLname = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        lbContact1 = new javax.swing.JLabel();
        SaveTeacher_General_Info = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        lbFname = new javax.swing.JLabel();
        txtFname = new javax.swing.JTextField();
        txtLname = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        txtEmployee_id = new javax.swing.JTextField();
        txtContact = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        lBDATE = new javax.swing.JLabel();
        txtDOB = new com.toedter.calendar.JDateChooser();
        LBGENDER = new javax.swing.JLabel();
        Gender = new javax.swing.JComboBox();
        txtCountry = new javax.swing.JTextField();
        lb_Chooser_btn = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        img_holder = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        layer = new javax.swing.JPanel();
        jLabel97 = new javax.swing.JLabel();
        lb_PaymentSettings_btn = new javax.swing.JLabel();
        lb_GeneralSettings_btn = new javax.swing.JLabel();
        lb_GlobalSettings_btn = new javax.swing.JLabel();
        main_BG = new javax.swing.JLabel();
        img_url = new javax.swing.JLabel();
        panel_forQualifications = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        txtQualification = new javax.swing.JComboBox();
        Major_One = new javax.swing.JTextField();
        Major_Two = new javax.swing.JTextField();
        Major3 = new javax.swing.JTextField();
        txtImployment_Date = new com.toedter.calendar.JDateChooser();
        txtSalary = new javax.swing.JComboBox();
        txtDepartment = new javax.swing.JComboBox();
        txtDesignation = new javax.swing.JComboBox();
        jLabel56 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        Save_Qualifications_info1 = new javax.swing.JLabel();
        exit_lb = new javax.swing.JLabel();
        admin_btn = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        minize_lb = new javax.swing.JLabel();
        model = new javax.swing.JLabel();
        mode = new javax.swing.JLabel();
        BackGround_header = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Side_Panel.setBackground(new java.awt.Color(121, 119, 119));
        Side_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Copyright @ webTech software ");
        Side_Panel.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 720, 180, 30));

        front_holder.setBackground(new java.awt.Color(121, 119, 119));
        front_holder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                front_holderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                front_holderMouseExited(evt);
            }
        });
        front_holder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jLabel20.setText("    Employees");
        hotel_ma.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 130, 60));

        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        hotel_ma.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 60));

        front_holder.add(hotel_ma, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 210, 70));

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
        jLabel23.setText("    Designation");
        calender.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, 60));

        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        calender.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 60));

        front_holder.add(calender, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 210, 70));

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
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_autism_30px.png"))); // NOI18N
        jLabel21.setText("     Departments");
        report_panelBTN.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 60));

        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        report_panelBTN.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 60));

        front_holder.add(report_panelBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 210, 70));

        Side_Panel.add(front_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 650));

        jPanel1.add(Side_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 210, 660));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 60, 20, 750));

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 740, 1360, 50));

        center.setLayout(new java.awt.CardLayout());

        P_Departments.setBackground(new java.awt.Color(255, 255, 255));
        P_Departments.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roomcount5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roomcount5.setText("45");
        P_Departments.add(roomcount5, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 40, 60, 30));

        Count_title4.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title4.setForeground(new java.awt.Color(33, 173, 178));
        Count_title4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title4.setText("Booked");
        P_Departments.add(Count_title4, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 10, 100, 40));

        lb_hold7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_direction_30px.png"))); // NOI18N
        P_Departments.add(lb_hold7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 60, 60));

        lb_hold5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_condo_30px.png"))); // NOI18N
        P_Departments.add(lb_hold5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 60, 60));

        lb_hold6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Escalator_Down_30px.png"))); // NOI18N
        P_Departments.add(lb_hold6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 60, 60));

        lb_hold4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_literature_30px.png"))); // NOI18N
        P_Departments.add(lb_hold4, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 20, 60, 60));

        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/count4.png"))); // NOI18N
        jLabel49.setText("jLabel41");
        P_Departments.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 250, 80));

        Count_title45.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title45.setForeground(new java.awt.Color(33, 173, 178));
        Count_title45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title45.setText("Room Types");
        P_Departments.add(Count_title45, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 100, 40));

        roomcount6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roomcount6.setText("45");
        P_Departments.add(roomcount6, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 40, 60, 30));

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/counter4.png"))); // NOI18N
        jLabel50.setText("jLabel41");
        P_Departments.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 250, 80));

        roomcount7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roomcount7.setText("45");
        P_Departments.add(roomcount7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 60, 30));

        Count_title6.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title6.setForeground(new java.awt.Color(33, 173, 178));
        Count_title6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title6.setText("Floors");
        P_Departments.add(Count_title6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 100, 50));

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/count2.png"))); // NOI18N
        jLabel51.setText("jLabel41");
        P_Departments.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 250, 80));

        roomcount8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roomcount8.setText("45");
        P_Departments.add(roomcount8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 50, 40));

        Count_title7.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title7.setForeground(new java.awt.Color(33, 173, 178));
        Count_title7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title7.setText("Rooms");
        P_Departments.add(Count_title7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 100, 30));

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/count.png"))); // NOI18N
        P_Departments.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 260, 80));

        Departments_main.setBackground(new java.awt.Color(255, 255, 255));
        Departments_main.setLayout(new java.awt.CardLayout());

        Departments_list.setBackground(new java.awt.Color(255, 255, 255));
        Departments_list.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Searching_panel_holder.setLayout(new java.awt.CardLayout());

        btn_layout1.setPreferredSize(new java.awt.Dimension(370, 71));
        btn_layout1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Trebuchet MS", 2, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(204, 204, 204));
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Search_15px.png"))); // NOI18N
        jLabel31.setText("    Search");
        btn_layout1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 80, 40));

        textSearch_Department.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textSearch_DepartmentKeyPressed(evt);
            }
        });
        btn_layout1.add(textSearch_Department, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 180, 30));

        Add_price4.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Add_price4.setForeground(new java.awt.Color(255, 255, 255));
        Add_price4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Add_price4.setText(" Department");
        Add_price4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_price4MouseClicked(evt);
            }
        });
        btn_layout1.add(Add_price4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 110, 60));

        lb_bg_btnFirstView3.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        lb_bg_btnFirstView3.setForeground(new java.awt.Color(255, 255, 255));
        lb_bg_btnFirstView3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_bg_btnFirstView3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        btn_layout1.add(lb_bg_btnFirstView3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 380, 70));

        Searching_panel_holder.add(btn_layout1, "card2");

        cover_layout1.setPreferredSize(new java.awt.Dimension(380, 84));
        cover_layout1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        edit20.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        edit20.setForeground(new java.awt.Color(255, 255, 255));
        edit20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_upload_to_ftp_30px.png"))); // NOI18N
        edit20.setText("Edit");
        edit20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edit20MouseClicked(evt);
            }
        });
        cover_layout1.add(edit20, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 70, 40));

        Delecte27.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte27.setForeground(new java.awt.Color(255, 255, 255));
        Delecte27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_no_entry_25px.png"))); // NOI18N
        Delecte27.setText("Delecte");
        Delecte27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Delecte27MouseClicked(evt);
            }
        });
        cover_layout1.add(Delecte27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 40));

        addRoom_type2.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        addRoom_type2.setForeground(new java.awt.Color(255, 255, 255));
        addRoom_type2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        addRoom_type2.setText("Departments");
        addRoom_type2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addRoom_type2MouseClicked(evt);
            }
        });
        cover_layout1.add(addRoom_type2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 100, 40));

        bg_back_layout.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        bg_back_layout.setForeground(new java.awt.Color(255, 255, 255));
        bg_back_layout.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bg_back_layout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        cover_layout1.add(bg_back_layout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 380, 70));

        Searching_panel_holder.add(cover_layout1, "card2");

        Departments_list.add(Searching_panel_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 360, 60));

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel222.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel222.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel222.setText("     Head Of Department");
        jPanel37.add(jLabel222, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 200, 40));

        jLabel223.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel223.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel223.setText("     Departments");
        jPanel37.add(jLabel223, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 50));

        Departments_list.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 800, 50));

        Department_Table_display.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Department_Table_display.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Department_Table_display.setGridColor(new java.awt.Color(255, 255, 255));
        Department_Table_display.setIntercellSpacing(new java.awt.Dimension(20, 5));
        Department_Table_display.setRowHeight(30);
        Department_Table_display.setTableHeader(null);
        Department_Table_display.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Department_Table_displayMouseClicked(evt);
            }
        });
        jScrollPane27.setViewportView(Department_Table_display);

        Departments_list.add(jScrollPane27, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 800, 350));

        table_holder_bg17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        table_holder_bg17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/display.png"))); // NOI18N
        Departments_list.add(table_holder_bg17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, -20, 1080, 570));

        Departments_main.add(Departments_list, "card8");

        Departments_entry.setBackground(new java.awt.Color(255, 255, 255));
        Departments_entry.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Count_title8.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title8.setForeground(new java.awt.Color(33, 173, 178));
        Count_title8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_30px.png"))); // NOI18N
        Count_title8.setText("  Department list");
        Count_title8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Count_title8MouseClicked(evt);
            }
        });
        Departments_entry.add(Count_title8, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 60, 150, 50));

        DPTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        DPTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        DPTable.setGridColor(new java.awt.Color(255, 255, 255));
        DPTable.setIntercellSpacing(new java.awt.Dimension(20, 5));
        DPTable.setRowHeight(30);
        DPTable.setTableHeader(null);
        DPTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DPTableMouseClicked(evt);
            }
        });
        jScrollPane30.setViewportView(DPTable);

        Departments_entry.add(jScrollPane30, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 490, 210));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText(" Head Of Department ");
        Departments_entry.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 180, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Update");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        Departments_entry.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, 120, 40));

        PreDefined_Departments.setBackground(new Color(225,225,225,1));
        PreDefined_Departments.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PreDefined_Departments.setForeground(new java.awt.Color(102, 102, 102));
        PreDefined_Departments.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "Teaching", "Accounting", "IT", "Security", "General" }));
        PreDefined_Departments.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                PreDefined_DepartmentsItemStateChanged(evt);
            }
        });
        Departments_entry.add(PreDefined_Departments, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 240, 30));

        txtHeadOFDP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHeadOFDPKeyTyped(evt);
            }
        });
        Departments_entry.add(txtHeadOFDP, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 240, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText(" Department ");
        Departments_entry.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 210, 30));

        Depart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DepartMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DepartMouseExited(evt);
            }
        });
        Departments_entry.add(Depart, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 240, 30));

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("Predefined Department Name");
        Departments_entry.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 210, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Save Department");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        Departments_entry.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 400, 110, 40));

        jLabel200.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel200.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/Untitled-2.png"))); // NOI18N
        Departments_entry.add(jLabel200, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1160, -1));
        Departments_entry.add(DOBid, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, 230, -1));

        Departments_main.add(Departments_entry, "card3");

        P_Departments.add(Departments_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1140, 560));

        center.add(P_Departments, "card4");

        P_Designation.setBackground(new java.awt.Color(255, 255, 255));
        P_Designation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roomcount14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roomcount14.setText("45");
        P_Designation.add(roomcount14, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 80, 60, 30));

        Count_title13.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title13.setForeground(new java.awt.Color(33, 173, 178));
        Count_title13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title13.setText("Booked");
        P_Designation.add(Count_title13, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 50, 100, 40));

        lb_hold13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_literature_30px.png"))); // NOI18N
        P_Designation.add(lb_hold13, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 60, 60, 60));

        jLabel105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/count4.png"))); // NOI18N
        jLabel105.setText("jLabel41");
        P_Designation.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 50, 250, 80));

        lb_hold12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_direction_30px.png"))); // NOI18N
        P_Designation.add(lb_hold12, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, 60, 60));

        Count_title12.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title12.setForeground(new java.awt.Color(33, 173, 178));
        Count_title12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title12.setText("Hall Types");
        P_Designation.add(Count_title12, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 100, 20));

        roomcount13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roomcount13.setText("45");
        P_Designation.add(roomcount13, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 80, 60, 30));

        jLabel106.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/counter4.png"))); // NOI18N
        jLabel106.setText("jLabel41");
        P_Designation.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 250, 80));

        Count_title14.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title14.setForeground(new java.awt.Color(33, 173, 178));
        Count_title14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title14.setText("Floors");
        P_Designation.add(Count_title14, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 120, 40));

        roomcount15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roomcount15.setText("45");
        P_Designation.add(roomcount15, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 60, 30));

        lb_hold14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Escalator_Down_30px.png"))); // NOI18N
        P_Designation.add(lb_hold14, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 60, 60));

        jLabel107.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/counter3.png"))); // NOI18N
        P_Designation.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 260, 80));

        Count_title15.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title15.setForeground(new java.awt.Color(33, 173, 178));
        Count_title15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title15.setText("Halls ");
        P_Designation.add(Count_title15, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 100, 30));

        roomcount16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roomcount16.setText("45");
        P_Designation.add(roomcount16, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 50, 40));

        lb_hold15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_condo_30px.png"))); // NOI18N
        P_Designation.add(lb_hold15, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 60, 60));

        jLabel108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/count.png"))); // NOI18N
        P_Designation.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 260, 80));

        jLabel109.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(33, 173, 178));
        jLabel109.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel109.setText("    Designation");
        P_Designation.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 50));

        P_Designation_main.setBackground(new java.awt.Color(255, 255, 255));
        P_Designation_main.setLayout(new java.awt.CardLayout());

        Designation_list.setBackground(new java.awt.Color(255, 255, 255));
        Designation_list.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Delecte25.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte25.setForeground(new java.awt.Color(255, 255, 255));
        Delecte25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_no_entry_25px.png"))); // NOI18N
        Delecte25.setText("Delecte");
        Delecte25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Delecte25MouseClicked(evt);
            }
        });
        Designation_list.add(Delecte25, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 460, -1, 50));

        edit19.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        edit19.setForeground(new java.awt.Color(255, 255, 255));
        edit19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_upload_to_ftp_30px.png"))); // NOI18N
        edit19.setText("Edit");
        edit19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edit19MouseClicked(evt);
            }
        });
        Designation_list.add(edit19, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 460, 70, 50));

        addRoom_type1.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        addRoom_type1.setForeground(new java.awt.Color(255, 255, 255));
        addRoom_type1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        addRoom_type1.setText("Designation");
        addRoom_type1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addRoom_type1MouseClicked(evt);
            }
        });
        Designation_list.add(addRoom_type1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 460, 100, 50));

        Delecte26.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte26.setForeground(new java.awt.Color(255, 255, 255));
        Delecte26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        Delecte26.setText("Delecte");
        Designation_list.add(Delecte26, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, 370, 80));

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel226.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel226.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel226.setText("     Departments");
        jPanel38.add(jLabel226, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 40));

        jLabel227.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel227.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel227.setText("  Designation ");
        jPanel38.add(jLabel227, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 120, 50));

        Designation_list.add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 800, 50));

        Designation_Table_display.setBackground(new java.awt.Color(240, 240, 240));
        Designation_Table_display.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Designation_Table_display.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Designation_Table_display.setGridColor(new java.awt.Color(255, 255, 255));
        Designation_Table_display.setIntercellSpacing(new java.awt.Dimension(20, 5));
        Designation_Table_display.setRowHeight(30);
        Designation_Table_display.setTableHeader(null);
        jScrollPane28.setViewportView(Designation_Table_display);

        Designation_list.add(jScrollPane28, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 800, 360));

        table_holder_bg16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        table_holder_bg16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/display.png"))); // NOI18N
        Designation_list.add(table_holder_bg16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1100, 550));

        P_Designation_main.add(Designation_list, "card8");

        Designation_entry.setBackground(new java.awt.Color(255, 255, 255));
        Designation_entry.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Designation_entry.add(Dname, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 290, 40));

        Designation_entry.add(ShowDepartments, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 290, 40));

        jLabel6.setText("Departments");
        Designation_entry.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 130, 30));

        jLabel7.setText(" Designation name");
        Designation_entry.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 180, 40));

        jLabel8.setText("Save");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        Designation_entry.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 380, 80, 50));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_submit_progress_25px.png"))); // NOI18N
        jLabel9.setText("   View Departments");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        Designation_entry.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 140, 50));

        jLabel10.setText("Update");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        Designation_entry.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 390, 60, 40));

        lb_BG.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/Untitled-2.png"))); // NOI18N
        Designation_entry.add(lb_BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1160, 470));

        backtoDesig.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        backtoDesig.setForeground(new java.awt.Color(33, 173, 178));
        backtoDesig.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backtoDesig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_30px.png"))); // NOI18N
        backtoDesig.setText("Designation list");
        backtoDesig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backtoDesigMouseClicked(evt);
            }
        });
        Designation_entry.add(backtoDesig, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, 150, 50));

        P_Designation_main.add(Designation_entry, "card3");

        P_Designation.add(P_Designation_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1140, 560));

        center.add(P_Designation, "card6");

        P_employee.setBackground(new java.awt.Color(255, 255, 255));
        P_employee.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        P_employee.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(33, 173, 178));
        jLabel2.setText("Employees");
        P_employee.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 160, 40));

        roomcount1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roomcount1.setText("45");
        P_employee.add(roomcount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 60, 60, 30));

        roomcount2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roomcount2.setText("45");
        P_employee.add(roomcount2, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 60, 60, 30));

        Count_title1.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title1.setForeground(new java.awt.Color(33, 173, 178));
        Count_title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title1.setText("Departments");
        P_employee.add(Count_title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 100, 20));

        Count_title2.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title2.setForeground(new java.awt.Color(33, 173, 178));
        Count_title2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title2.setText("Employees");
        P_employee.add(Count_title2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, 100, 20));

        Count_title.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title.setForeground(new java.awt.Color(33, 173, 178));
        Count_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title.setText("Designations");
        P_employee.add(Count_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 100, 20));

        roomcount4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roomcount4.setText("45");
        P_employee.add(roomcount4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 60, 30));

        roomcount3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roomcount3.setText("45");
        P_employee.add(roomcount3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 60, 30));

        lb_hold1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Escalator_Down_30px.png"))); // NOI18N
        P_employee.add(lb_hold1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 60, 60));

        lb_hold2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_direction_30px.png"))); // NOI18N
        P_employee.add(lb_hold2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 60, 60));

        lb_hold3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_literature_30px.png"))); // NOI18N
        P_employee.add(lb_hold3, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 40, 60, 60));

        lb_hold.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_condo_30px.png"))); // NOI18N
        P_employee.add(lb_hold, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 60, 60));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/counters.png"))); // NOI18N
        P_employee.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 260, 80));

        Count_title40.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title40.setForeground(new java.awt.Color(33, 173, 178));
        Count_title40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title40.setText("Vacances");
        P_employee.add(Count_title40, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 30, 100, 20));

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/counter2.png"))); // NOI18N
        jLabel41.setText("jLabel41");
        P_employee.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 30, 250, 80));

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/counter1.png"))); // NOI18N
        jLabel44.setText("jLabel41");
        P_employee.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 250, 80));

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/counter4.png"))); // NOI18N
        jLabel47.setText("jLabel41");
        P_employee.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 250, 80));

        employee_main.setBackground(new java.awt.Color(255, 255, 255));
        employee_main.setLayout(new java.awt.CardLayout());

        Employee_list.setBackground(new java.awt.Color(255, 255, 255));
        Employee_list.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Searching_panel_holder1.setLayout(new java.awt.CardLayout());

        Cover_layout.setPreferredSize(new java.awt.Dimension(370, 71));
        Cover_layout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("Trebuchet MS", 2, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(204, 204, 204));
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Search_15px.png"))); // NOI18N
        jLabel33.setText("    Search");
        Cover_layout.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 80, 40));

        tex_Search_Employee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tex_Search_EmployeeKeyPressed(evt);
            }
        });
        Cover_layout.add(tex_Search_Employee, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 180, 30));

        Add_price5.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Add_price5.setForeground(new java.awt.Color(255, 255, 255));
        Add_price5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Add_price5.setText(" Employee");
        Add_price5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_price5MouseClicked(evt);
            }
        });
        Cover_layout.add(Add_price5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 110, 60));

        lb_bg_btnFirstView4.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        lb_bg_btnFirstView4.setForeground(new java.awt.Color(255, 255, 255));
        lb_bg_btnFirstView4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_bg_btnFirstView4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        Cover_layout.add(lb_bg_btnFirstView4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 380, 70));

        Searching_panel_holder1.add(Cover_layout, "card2");

        btn_layout.setPreferredSize(new java.awt.Dimension(380, 84));
        btn_layout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        edit18.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        edit18.setForeground(new java.awt.Color(255, 255, 255));
        edit18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_upload_to_ftp_30px.png"))); // NOI18N
        edit18.setText("Edit");
        edit18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edit18MouseClicked(evt);
            }
        });
        btn_layout.add(edit18, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 70, 40));

        Delecte23.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte23.setForeground(new java.awt.Color(255, 255, 255));
        Delecte23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_no_entry_25px.png"))); // NOI18N
        Delecte23.setText("Delecte");
        Delecte23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Delecte23MouseClicked(evt);
            }
        });
        btn_layout.add(Delecte23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 40));

        addRoom_type.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        addRoom_type.setForeground(new java.awt.Color(255, 255, 255));
        addRoom_type.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        addRoom_type.setText("  Employee");
        addRoom_type.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addRoom_typeMouseClicked(evt);
            }
        });
        btn_layout.add(addRoom_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 100, 40));

        bg_back_layout1.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        bg_back_layout1.setForeground(new java.awt.Color(255, 255, 255));
        bg_back_layout1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bg_back_layout1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        btn_layout.add(bg_back_layout1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 380, 70));

        Searching_panel_holder1.add(btn_layout, "card2");

        Employee_list.add(Searching_panel_holder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 360, 60));

        Employee_Table_display.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Employee_Table_display.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Employee_Table_display.setGridColor(new java.awt.Color(255, 255, 255));
        Employee_Table_display.setIntercellSpacing(new java.awt.Dimension(20, 5));
        Employee_Table_display.setRowHeight(30);
        Employee_Table_display.setTableHeader(null);
        Employee_Table_display.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Employee_Table_displayMouseClicked(evt);
            }
        });
        jScrollPane29.setViewportView(Employee_Table_display);

        Employee_list.add(jScrollPane29, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 800, 370));

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel229.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel229.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel229.setText("Designation");
        jPanel39.add(jLabel229, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 100, 50));

        jLabel230.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel230.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel230.setText("  Name");
        jPanel39.add(jLabel230, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 150, 40));

        jLabel231.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel231.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel231.setText("Department");
        jPanel39.add(jLabel231, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 120, 50));

        jLabel232.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel232.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel232.setText("Surname");
        jPanel39.add(jLabel232, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 120, 50));

        Employee_list.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 800, 50));

        table_holder_bg15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        table_holder_bg15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/display.png"))); // NOI18N
        Employee_list.add(table_holder_bg15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1100, 550));

        employee_main.add(Employee_list, "card8");

        P_employee.add(employee_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1140, 560));

        center.add(P_employee, "card3");

        Employee_entry.setBackground(new java.awt.Color(252, 252, 252));
        Employee_entry.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        employee_Inner_panel.setLayout(new java.awt.CardLayout());

        panel_forUser_Account.setBackground(new java.awt.Color(255, 255, 255));
        panel_forUser_Account.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel_forUser_Account.add(txtConfirm_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 280, 300, 40));
        panel_forUser_Account.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 200, 300, 36));
        panel_forUser_Account.add(txtUser_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 120, 300, 36));

        access_level_choser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administration", "Account", "Teacher", " " }));
        panel_forUser_Account.add(access_level_choser, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 370, 300, 40));
        panel_forUser_Account.add(txtHint, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 290, 40));
        panel_forUser_Account.add(fname_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 290, 40));
        panel_forUser_Account.add(lname_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 290, 40));

        jLabel68.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_customer_30px.png"))); // NOI18N
        jLabel68.setText("   first name");
        panel_forUser_Account.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 120, 40));

        jLabel46.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_customer_30px.png"))); // NOI18N
        jLabel46.setText("   last name");
        panel_forUser_Account.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 130, 40));

        jLabel63.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_info_30px.png"))); // NOI18N
        jLabel63.setText("     Hint Q");
        panel_forUser_Account.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 130, 40));

        jLabel53.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_faq_30px.png"))); // NOI18N
        jLabel53.setText("    Hint A");
        panel_forUser_Account.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 140, 40));

        jLabel69.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_key_30px.png"))); // NOI18N
        jLabel69.setText("   User name");
        panel_forUser_Account.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 120, 40));

        jLabel54.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_lock_30px.png"))); // NOI18N
        jLabel54.setText("   Password");
        panel_forUser_Account.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 130, 40));

        jLabel71.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_lock_orientation_30px.png"))); // NOI18N
        jLabel71.setText("   Comfirm password");
        panel_forUser_Account.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 170, 40));

        jLabel75.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_upload_to_cloud_30px.png"))); // NOI18N
        jLabel75.setText("     Save");
        jLabel75.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel75MouseClicked(evt);
            }
        });
        panel_forUser_Account.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 430, 150, 70));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "What is the name of your school?", "Word after your heart?", "why do you love animals?", "where would you love to and live?" }));
        panel_forUser_Account.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 290, 40));

        jLabel77.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_team_30px.png"))); // NOI18N
        jLabel77.setText("   User level");
        panel_forUser_Account.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 370, 150, 40));

        image_chooser.setText("btn chooser");
        image_chooser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                image_chooserMouseClicked(evt);
            }
        });
        panel_forUser_Account.add(image_chooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 30, 70, 20));

        logo2.setText("image");
        panel_forUser_Account.add(logo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 100, 80));
        panel_forUser_Account.add(txtcontact, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, 290, 40));

        jLabel55.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_faq_30px.png"))); // NOI18N
        jLabel55.setText("   Contact");
        panel_forUser_Account.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 140, 40));

        employee_Inner_panel.add(panel_forUser_Account, "card2");

        panel_forPersonal_info.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Container_forGeneral.setBackground(new java.awt.Color(255, 255, 255));
        Container_forGeneral.setPreferredSize(new java.awt.Dimension(1010, 956));
        Container_forGeneral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_slack_35px.png"))); // NOI18N
        Container_forGeneral.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 100, 50));

        jLabel13.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_profile_35px.png"))); // NOI18N
        Container_forGeneral.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 50, 50));

        jLabel14.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_home_address_35px.png"))); // NOI18N
        Container_forGeneral.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 60, 50));

        addreessLb.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        addreessLb.setForeground(new java.awt.Color(102, 102, 102));
        addreessLb.setText("Address");
        Container_forGeneral.add(addreessLb, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 120, 40));

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        jScrollPane2.setViewportView(txtAddress);

        Container_forGeneral.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, 320, 60));

        jLabel15.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_address_book_35px.png"))); // NOI18N
        Container_forGeneral.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 70, 40));

        jLabel16.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_fax_35px.png"))); // NOI18N
        Container_forGeneral.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 70, 50));

        jLabel17.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_descending_sorting_35px.png"))); // NOI18N
        Container_forGeneral.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 280, 70, 50));

        lbEmail1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbEmail1.setForeground(new java.awt.Color(102, 102, 102));
        lbEmail1.setText("Email");
        Container_forGeneral.add(lbEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 120, 40));

        lbSLname.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbSLname.setForeground(new java.awt.Color(102, 102, 102));
        lbSLname.setText("Surname");
        Container_forGeneral.add(lbSLname, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 120, 50));

        jLabel57.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_address_book_35px.png"))); // NOI18N
        Container_forGeneral.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 80, 50));

        lbContact1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbContact1.setForeground(new java.awt.Color(102, 102, 102));
        lbContact1.setText("Contact");
        Container_forGeneral.add(lbContact1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 120, 40));

        SaveTeacher_General_Info.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        SaveTeacher_General_Info.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_upload_to_cloud_30px.png"))); // NOI18N
        SaveTeacher_General_Info.setText("  Save");
        SaveTeacher_General_Info.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveTeacher_General_InfoMouseClicked(evt);
            }
        });
        Container_forGeneral.add(SaveTeacher_General_Info, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 450, 120, 60));

        jLabel98.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(102, 102, 102));
        jLabel98.setText("Country of Residence");
        Container_forGeneral.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 370, 190, 40));

        jLabel99.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_address_book_35px.png"))); // NOI18N
        Container_forGeneral.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 370, 70, 40));

        lbFname.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbFname.setForeground(new java.awt.Color(102, 102, 102));
        lbFname.setText("First name");
        Container_forGeneral.add(lbFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 210, 40));
        Container_forGeneral.add(txtFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 310, 36));

        txtLname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtLnameMouseExited(evt);
            }
        });
        Container_forGeneral.add(txtLname, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 310, 36));

        jLabel100.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(102, 102, 102));
        jLabel100.setText("Employee ID");
        Container_forGeneral.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 120, 40));

        jLabel101.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_fax_35px.png"))); // NOI18N
        Container_forGeneral.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 40));

        txtEmployee_id.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtEmployee_idMouseExited(evt);
            }
        });
        Container_forGeneral.add(txtEmployee_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 310, 40));

        txtContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContactActionPerformed(evt);
            }
        });
        Container_forGeneral.add(txtContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 310, 36));
        Container_forGeneral.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 310, 36));

        lBDATE.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lBDATE.setForeground(new java.awt.Color(102, 102, 102));
        lBDATE.setText("D.O.B");
        Container_forGeneral.add(lBDATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, 120, 40));
        Container_forGeneral.add(txtDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 230, 320, 40));

        LBGENDER.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        LBGENDER.setForeground(new java.awt.Color(102, 102, 102));
        LBGENDER.setText("Gender");
        Container_forGeneral.add(LBGENDER, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 280, 120, 40));

        Gender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "Male", "Female" }));
        Gender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                GenderMouseExited(evt);
            }
        });
        Container_forGeneral.add(Gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 320, 320, 36));
        Container_forGeneral.add(txtCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 410, 320, 36));

        lb_Chooser_btn.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lb_Chooser_btn.setForeground(new java.awt.Color(102, 102, 102));
        lb_Chooser_btn.setText("Profile");
        lb_Chooser_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_Chooser_btnMouseClicked(evt);
            }
        });
        Container_forGeneral.add(lb_Chooser_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 80, 40));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/image.png"))); // NOI18N
        jPanel2.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, -30, 270, 210));
        jPanel2.add(img_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 140, 130));

        Container_forGeneral.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 230, 130));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_image_gallery_35px_2.png"))); // NOI18N
        Container_forGeneral.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, 40));

        panel_forPersonal_info.add(Container_forGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, -1));

        employee_Inner_panel.add(panel_forPersonal_info, "card3");
        employee_Inner_panel.add(layer, "card5");

        Employee_entry.add(employee_Inner_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 1050, 540));

        jLabel97.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(33, 173, 178));
        jLabel97.setText("SETTINGS");
        Employee_entry.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 130, 50));

        lb_PaymentSettings_btn.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lb_PaymentSettings_btn.setForeground(new java.awt.Color(51, 51, 51));
        lb_PaymentSettings_btn.setText("Account ");
        lb_PaymentSettings_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_PaymentSettings_btnMouseClicked(evt);
            }
        });
        Employee_entry.add(lb_PaymentSettings_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 80, 70));

        lb_GeneralSettings_btn.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lb_GeneralSettings_btn.setForeground(new java.awt.Color(255, 255, 255));
        lb_GeneralSettings_btn.setText("Personal");
        lb_GeneralSettings_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_GeneralSettings_btnMouseClicked(evt);
            }
        });
        Employee_entry.add(lb_GeneralSettings_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 110, 60));

        lb_GlobalSettings_btn.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lb_GlobalSettings_btn.setForeground(new java.awt.Color(255, 255, 255));
        lb_GlobalSettings_btn.setText("Qualifications info");
        lb_GlobalSettings_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_GlobalSettings_btnMouseClicked(evt);
            }
        });
        Employee_entry.add(lb_GlobalSettings_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, 60));

        main_BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/add_Room_typebg.png"))); // NOI18N
        Employee_entry.add(main_BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1100, 670));
        Employee_entry.add(img_url, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 170, 30));

        center.add(Employee_entry, "card6");

        panel_forQualifications.setBackground(new java.awt.Color(255, 255, 255));
        panel_forQualifications.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(100, 1258));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel27.setText("Qualifications");
        jPanel4.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 210, 30));

        jLabel28.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_invoice_35px.png"))); // NOI18N
        jPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 90, 60));

        jLabel43.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel43.setText("Major name");
        jPanel4.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 220, 190, 30));

        jLabel61.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_closed_sign_35px.png"))); // NOI18N
        jPanel4.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 80, 50));

        jLabel70.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel70.setText("Salary");
        jPanel4.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 190, 30));

        jLabel72.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_no_chat_35px.png"))); // NOI18N
        jPanel4.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, 90, 60));

        jLabel73.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel73.setText("Major name");
        jPanel4.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, 190, 30));

        jLabel74.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_currency_exchange_35px.png"))); // NOI18N
        jLabel74.setText(" ");
        jPanel4.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 90, 60));

        jLabel76.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_countdown_clock_35px.png"))); // NOI18N
        jPanel4.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 90, 60));

        jLabel78.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/language.png"))); // NOI18N
        jLabel78.setText(" ");
        jPanel4.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 90, 60));

        jLabel81.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel81.setText("Imployment date");
        jPanel4.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, 190, 30));

        jLabel82.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_interior_35px.png"))); // NOI18N
        jPanel4.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 70, 50));

        jLabel84.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_africa_35px.png"))); // NOI18N
        jPanel4.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 90, 60));

        txtQualification.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masters", "Degree", "Diploma", "Certificate" }));
        txtQualification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQualificationActionPerformed(evt);
            }
        });
        jPanel4.add(txtQualification, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 300, 30));
        jPanel4.add(Major_One, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 160, 300, 30));
        jPanel4.add(Major_Two, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 250, 300, 36));
        jPanel4.add(Major3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 330, 300, 36));
        jPanel4.add(txtImployment_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 310, 30));

        txtSalary.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(txtSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 300, 30));

        jPanel4.add(txtDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 300, 30));

        jPanel4.add(txtDesignation, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 300, 30));

        jLabel56.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel56.setText("Designation");
        jPanel4.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 120, 40));

        jLabel66.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel66.setText("Department");
        jPanel4.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 120, 40));

        jLabel48.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel48.setText("Major name");
        jPanel4.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 300, 190, 30));

        Save_Qualifications_info1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        Save_Qualifications_info1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_upload_to_cloud_30px.png"))); // NOI18N
        Save_Qualifications_info1.setText("     SAVE");
        Save_Qualifications_info1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Save_Qualifications_info1MouseClicked(evt);
            }
        });
        jPanel4.add(Save_Qualifications_info1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 380, 110, 50));

        panel_forQualifications.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, -1));

        center.add(panel_forQualifications, "card4");

        jPanel1.add(center, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 1080, 670));

        exit_lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit_lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_delete_18px_1.png"))); // NOI18N
        exit_lb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit_lbMouseClicked(evt);
            }
        });
        jPanel1.add(exit_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 10, 50, 40));

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
        admin_btn.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 140, 40));

        jPanel1.add(admin_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 190, 40));

        minize_lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minize_lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_minus_19px.png"))); // NOI18N
        minize_lb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minize_lbMouseClicked(evt);
            }
        });
        jPanel1.add(minize_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 10, 40, 40));

        model.setForeground(new java.awt.Color(240, 240, 240));
        model.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        model.setText("jLabel2");
        jPanel1.add(model, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 10, 110, 40));

        mode.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        mode.setForeground(new java.awt.Color(255, 255, 255));
        mode.setText("Hi Admin,  Welcome To Your School Management");
        jPanel1.add(mode, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, -1, 30));

        BackGround_header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/header.png"))); // NOI18N
        BackGround_header.setText("jLabel18");
        BackGround_header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                BackGround_headerMouseDragged(evt);
            }
        });
        BackGround_header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BackGround_headerMousePressed(evt);
            }
        });
        jPanel1.add(BackGround_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1370, 80));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/background_admi.png"))); // NOI18N
        jLabel18.setText("jLabel18");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 40, 1450, 820));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, 820));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void hotel_maMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hotel_maMouseClicked

        
        P_employee.setVisible(true);
        P_Designation.hide();
       P_Departments.hide();
        showContent_onAllTables();
    }//GEN-LAST:event_hotel_maMouseClicked

    private void hotel_maMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hotel_maMouseEntered
        hotel_ma.setBackground(new Color(33,173,178));
    }//GEN-LAST:event_hotel_maMouseEntered

    private void hotel_maMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hotel_maMouseExited
        hotel_ma.setBackground(new Color(121,119,119));
    }//GEN-LAST:event_hotel_maMouseExited

    private void calenderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calenderMouseClicked
          P_employee.hide();
        P_Designation.setVisible(true);
       P_Departments.hide();
    }//GEN-LAST:event_calenderMouseClicked

    private void calenderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calenderMouseEntered
        calender.setBackground(new Color(33,173,178));
    }//GEN-LAST:event_calenderMouseEntered

    private void calenderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calenderMouseExited
        calender.setBackground(new Color(121,119,119));
    }//GEN-LAST:event_calenderMouseExited

    private void report_panelBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_report_panelBTNMouseClicked
         P_employee.hide();
        P_Designation.hide();
       P_Departments.setVisible(true); 
        
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

    private void front_holderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_front_holderMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_front_holderMouseEntered

    private void front_holderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_front_holderMouseExited
        // TODO add your handling code here:////////////eixt
        // if(evt.getSource()==MuiltpleOption1 ){
            //   top.setVisible(true);

            //   }
    }//GEN-LAST:event_front_holderMouseExited

    private void exit_lbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_lbMouseClicked
        Dialog frame = new Dialog();
        frame.setVisible(true);
    }//GEN-LAST:event_exit_lbMouseClicked

    private void minize_lbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minize_lbMouseClicked
        this.setExtendedState(Admin_Home.ICONIFIED);
    }//GEN-LAST:event_minize_lbMouseClicked

    private void addRoom_typeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addRoom_typeMouseClicked
       Employee_list.hide();
       P_Departments.hide();
       P_Designation  .hide(); 
       P_employee.hide();
       Employee_entry.setVisible(true);
    }//GEN-LAST:event_addRoom_typeMouseClicked

    private void addRoom_type1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addRoom_type1MouseClicked
        Designation_list.hide();
        Designation_entry.setVisible(true);
    }//GEN-LAST:event_addRoom_type1MouseClicked

    private void backtoDesigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backtoDesigMouseClicked
        Designation_entry.hide();
        Designation_list.setVisible(true);
    }//GEN-LAST:event_backtoDesigMouseClicked

    private void addRoom_type2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addRoom_type2MouseClicked
       Departments_list.hide();
      Departments_entry.setVisible(true);
    }//GEN-LAST:event_addRoom_type2MouseClicked

    private void Count_title8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Count_title8MouseClicked
          Departments_list.setVisible(true);
               Departments_entry.hide();
    }//GEN-LAST:event_Count_title8MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
      
        //Department_Table_display
        
          try {
                      conn = DBConnection.getConnction();
                     pps = conn.prepareStatement("SELECT  name, Head_Of_Department  FROM department WHERE name = ?");
                     pps.setString(1, Depart.getText());
                     rs = pps.executeQuery();
                     if(rs.next()){
                          JOptionPane.showMessageDialog(null, "Department Already Exsit");
                      
                     }else{
                    
                         
                         
                try {
                conn = DBConnection.getConnction();
                String sql = "INSERT INTO department (name,Head_Of_Department) VALUES (?,?)";
                pps = conn.prepareStatement(sql);
                pps.setString(1 , Depart.getText());
                pps.setString(2 , DOBid.getText());
                pps.executeUpdate();
                
               
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
                showContent_onAllTables();
                ComboDisplay();
                         
                         
                        
                     
          }
        } catch (Exception ex) {
             Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        
        
        
        
        
       
        
    }//GEN-LAST:event_jLabel3MouseClicked

    private void Delecte27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Delecte27MouseClicked
           DefaultTableModel tableMode =(DefaultTableModel)Department_Table_display.getModel();
           String IDfromTable = tableMode.getValueAt(Department_Table_display.getSelectedRow(), 0).toString();
           try {
                      conn = DBConnection.getConnction();
                     pps = conn.prepareStatement("DELETE  FROM department WHERE name = ? ");
                     pps.setString(1, IDfromTable);
                     pps.executeUpdate();

        } catch (Exception ex) {
             Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
               
    
         showContent_onAllTables();//show changes on the table after delete                                 
    }//GEN-LAST:event_Delecte27MouseClicked

    private void edit20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit20MouseClicked
        Departments_list.hide();
        Departments_entry.setVisible(true);

        //Employee_Table_display
        DefaultTableModel tableMode2 = (DefaultTableModel) Department_Table_display.getModel();
        String ID = tableMode2.getValueAt(Department_Table_display.getSelectedRow(), 0).toString();
        try {
             conn = DBConnection.getConnction();
            pps = conn.prepareStatement("SELECT department_id,name FROM department WHERE name = ?");
            pps.setString(1, ID);
            rs = pps.executeQuery();
            if (rs.next()) {
                resource = rs.getString("department_id");
                Depart.setText(rs.getString("name"));
            } else {
                JOptionPane.showMessageDialog(null, "not found");

            }
        } catch (Exception ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }

// TODO add your handling code here:
    }//GEN-LAST:event_edit20MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
         // updating
         try {
                 conn = DBConnection.getConnction();
                String sql = "UPDATE  department  SET name =? WHERE id = ?";
                pps = conn.prepareStatement(sql);
                pps.setString(1 , Depart.getText());
                  pps.setString(2 ,resource);                   
                  pps.executeUpdate();
                  Depart .setText(null); 
                    
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
                 showContent_onAllTables();

    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
      
            //getting department ID before insertion 
         String Selected_DepartmentID = ShowDepartments.getSelectedItem().toString().trim();
           try {
                      conn = DBConnection.getConnction();
                     pps = conn.prepareStatement("SELECT department_id FROM department WHERE name = ?");
                     pps.setString(1, Selected_DepartmentID);
                     rs = pps.executeQuery();
                     if(rs.next()){
                     Selected_Department_getID =rs.getString("department_id");  
                     }else{
                     JOptionPane.showMessageDialog(null, "not found");
                     
                     }
        } catch (Exception ex) {
             Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
           //inserting designation 
        try {
                 conn = DBConnection.getConnction();
                String sql = "INSERT INTO designation (department_id,name) VALUES (?,?)";
                pps = conn.prepareStatement(sql);
                pps.setString(1 , Selected_Department_getID);
                pps.setString(2 , Dname.getText());
                  pps.executeUpdate();
                  Dname .setText(null); 
                
                    JOptionPane.showMessageDialog(null, "Successfully Saved");
                   
                    
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
                  showContent_onAllTables();
                                   
    }//GEN-LAST:event_jLabel8MouseClicked

    private void Delecte25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Delecte25MouseClicked
   DefaultTableModel tableMode =(DefaultTableModel)Designation_Table_display.getModel();
           String IDfromTable = tableMode.getValueAt(Designation_Table_display.getSelectedRow(), 1).toString();
           try {
                      conn = DBConnection.getConnction();
                     pps = conn.prepareStatement("DELETE  FROM designation WHERE name = ? ");
                     pps.setString(1, IDfromTable);
                     pps.executeUpdate();
        } catch (Exception ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
    
         showContent_onAllTables();//show changes on the table after delete             


    }//GEN-LAST:event_Delecte25MouseClicked

    private void edit19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit19MouseClicked
        Designation_list.hide();
        Designation_entry.setVisible(true);
        
        //wh
           DefaultTableModel tableMode =(DefaultTableModel)Designation_Table_display.getModel();
           String ID = tableMode.getValueAt(Designation_Table_display.getSelectedRow(), 1).toString();
           try {
                     conn = DBConnection.getConnction();
                     pps = conn.prepareStatement("SELECT id,name FROM designation WHERE name = ?");
                     pps.setString(1, ID);
                     rs = pps.executeQuery();
                     if(rs.next()){
                     designation_resource_getID =rs.getString("id"); //putting id on the resource 
                     Dname .setText(rs.getString("name")); 
                     }
        } catch (Exception ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}   

           
          DefaultTableModel tableMode1 =(DefaultTableModel)Designation_Table_display.getModel();
           String IDCombo = tableMode1.getValueAt(Designation_Table_display.getSelectedRow(), 0).toString();
           
           
           try {
                      conn = DBConnection.getConnction();
                     pps = conn.prepareStatement("SELECT department_id,name FROM department WHERE name = ?");
                     pps.setString(1, IDCombo);
                     rs = pps.executeQuery();
                     if(rs.next()){
                     department_resource_getID =rs.getString("department_id"); //putting id on the resource 
                     ShowDepartments.removeAllItems();
                     ShowDepartments.addItem(rs.getString("name"));
                     }
        } catch (Exception ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}   
           
           
           
    }//GEN-LAST:event_edit19MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        ShowDepartments.removeAllItems();
        ComboDisplay();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
          // updating
         try {
                conn = DBConnection.getConnction();
                String sql = "UPDATE  designation  SET department_id =? , name =? WHERE id = ?";
                pps = conn.prepareStatement(sql);
                pps.setString(1 ,department_resource_getID );
                pps.setString(2 ,Dname.getText());                   
                pps.setString(3 , designation_resource_getID); //updating by designation ID

               pps.executeUpdate();
                  Depart .setText(null); 
              

                    JOptionPane.showMessageDialog(null, "Successfully Updated");
                     
                    
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
                 showContent_onAllTables();

    }//GEN-LAST:event_jLabel10MouseClicked

    private void Delecte23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Delecte23MouseClicked
           DefaultTableModel tableModel1 =(DefaultTableModel)Employee_Table_display.getModel();
           String first_name = tableModel1.getValueAt(Employee_Table_display.getSelectedRow(), 0).toString();
           
            DefaultTableModel tableModel2 =(DefaultTableModel)Employee_Table_display.getModel();
            String last_name = tableModel2.getValueAt(Employee_Table_display.getSelectedRow(), 1).toString();
           
            DefaultTableModel tableModel3 =(DefaultTableModel)Employee_Table_display.getModel();
            String depart = tableModel3.getValueAt(Employee_Table_display.getSelectedRow(), 2).toString();
           
           try {
                     conn = DBConnection.getConnction();
                     pps = conn.prepareStatement("DELETE  FROM employee WHERE name = ? AND surname =? And designation =? ");
                     pps.setString(1, first_name);
                       pps.setString(2, last_name);
                         pps.setString(3, depart);
                     pps.executeUpdate();

        } catch (Exception ex) {
             Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
               
    
         showContent_onAllTables();//show changes on the table after delete    
    }//GEN-LAST:event_Delecte23MouseClicked

    private void edit18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit18MouseClicked
     
        P_Departments.hide();
        P_Designation.hide();
        Employee_list.hide();
        P_employee.hide();
        Employee_entry.setVisible(true);
        
        
           DefaultTableModel tableModed =(DefaultTableModel)Employee_Table_display.getModel();
           String fnane = tableModed.getValueAt(Employee_Table_display.getSelectedRow(), 0).toString();
        
           
           DefaultTableModel tableModed1 =(DefaultTableModel)Employee_Table_display.getModel();
           String lname = tableModed1.getValueAt(Employee_Table_display.getSelectedRow(), 1).toString();
           
          try {
           
                conn = DBConnection.getConnction();
                String sql = "SELECT  * FROM employee WHERE name = ? AND surname =? ";
                 pps = conn.prepareStatement(sql);
                 pps.setString(1, fnane);
                  pps.setString(2, lname);
                          byte[] image = null;

                  rs = pps.executeQuery();
                     if(rs.next()){
                    User_login_ID_resource =rs.getString("user_login_id"); 
                    Employee_Given_ID_resource =rs.getString("employeeid");  

                              txtFname.setText(rs.getString("name"));
                              txtLname.setText(rs.getString("surname"));
                              txtEmployee_id.setText(rs.getString("employeeid"));
                                txtContact.setText(rs.getString("contact"));
                                  txtEmail.setText(rs.getString("email"));
                               txtAddress.setText(rs.getString("address"));
                            
                            
                            
                               
                               
                               image = rs.getBytes("image");
                              Image img = Toolkit.getDefaultToolkit().createImage(image);
                               ImageIcon icon = new ImageIcon(img);
                               img_holder.setIcon(icon);
                           
                              Gender.setSelectedItem(rs.getString("gender"));
                                //  txtImployment_Date.
                              txtUser_name.setText(rs.getString("username"));
                               txtConfirm_pass.setText(rs.getString("confirmed_pass"));
                           txtCountry.setText(rs.getString("country"));
                           txtSalary.setSelectedItem(rs.getString("salary"));
                           txtDepartment.setSelectedItem(rs.getString("department"));
                           txtDesignation.setSelectedItem(rs.getString("designation"));
                          txtQualification.setSelectedItem(rs.getString("qualification"));
                        //first nd last name on the account info
                          fname_txt.setText(rs.getString("name"));
                          lname_txt.setText(rs.getString("surname"));    
                          
                          
                     }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
          
                try {
                 conn = DBConnection.getConnction();
                String sql = "SELECT  * FROM employee_qualifications_major WHERE employee_id = ? ";
                 pps = conn.prepareStatement(sql);
                 pps.setString(1, Employee_Given_ID_resource);
                  rs = pps.executeQuery();
                     if(rs.next()){
                       Major_One.setText(rs.getString("major_name"));
                       Major1_resource =rs.getString("qualifications_major_id");
                       rs.next();
                      Major_Two.setText(rs.getString("major_name"));
                      Major2_resource =rs.getString("qualifications_major_id");

                      rs.next();
                      Major3.setText(rs.getString("major_name"));
                       Major3_resource =rs.getString("qualifications_major_id");

                     }
              } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);}
  
    
  
        showContent_onAllTables();
    }//GEN-LAST:event_edit18MouseClicked

    public void updating_method(){
        
               InputStream inputSteam = null;
            String dir = img_url.getText();
            
            try {
                inputSteam = new FileInputStream(new File(dir));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Adminstrative.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        
        
     try {
              String DOB_Selected_date= ((JTextField)txtDOB.getDateEditor().getUiComponent()).getText();
           
                conn = DBConnection.getConnction();
                String sql = "UPDATE   employee SET name =?,surname =?, employeeid =?,contact =?, email =?,address =?,dob =?, gender =?, country =?, image = ? WHERE employee_Id = ?";
                pps = conn.prepareStatement(sql);
                pps.setString(1 , txtFname.getText().trim());
                pps.setString(2 , txtLname.getText().trim());
                pps.setString(3 ,  txtEmployee_id.getText().trim());
                pps.setString(4 , txtContact.getText().trim());
                pps.setString(5 ,txtEmail.getText().trim());
                pps.setString(6 , txtAddress.getText().trim());
                pps.setString(7,  DOB_Selected_date.trim());
                pps.setString(8, Gender.getSelectedItem().toString().trim());
                pps.setString(9,   txtCountry.getText().trim());
                pps.setBlob(10,   inputSteam);

                 pps.setString(11,   User_login_ID_resource);
                pps.executeUpdate();
                 
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

    }
    
    private void lb_PaymentSettings_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_PaymentSettings_btnMouseClicked
        panel_forQualifications.hide();
        panel_forUser_Account.setVisible(true);
        panel_forPersonal_info.hide();
    }//GEN-LAST:event_lb_PaymentSettings_btnMouseClicked

    private void lb_GeneralSettings_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_GeneralSettings_btnMouseClicked
        panel_forQualifications.hide();
        panel_forUser_Account.hide();
        panel_forPersonal_info.setVisible(true);
    }//GEN-LAST:event_lb_GeneralSettings_btnMouseClicked

    private void lb_GlobalSettings_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_GlobalSettings_btnMouseClicked
        panel_forQualifications.setVisible(true);
        panel_forUser_Account.hide();
        panel_forPersonal_info.hide();
    }//GEN-LAST:event_lb_GlobalSettings_btnMouseClicked

    private void SaveTeacher_General_InfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveTeacher_General_InfoMouseClicked
      panel_forPersonal_info.hide();
      panel_forUser_Account.hide();
              P_Departments.hide();
              P_Designation.hide();
              P_employee.hide();
               Employee_entry.hide();
      
      panel_forQualifications.setVisible(true);
    }//GEN-LAST:event_SaveTeacher_General_InfoMouseClicked
    
    public void adding_majorSubjects_for_Teacher(){
              try {
                 conn = DBConnection.getConnction();
                String sql = "INSERT INTO   employee_qualifications_major (employee_id,major_name) VALUES (?,?)";
                pps = conn.prepareStatement(sql);
                pps.setString(1,     Employee_Given_ID_resource);
                pps.setString(2,   Major_One.getText().trim());
                pps.executeUpdate();
                 Major_One.setText(null);
               } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);} 
      
              try {
                conn = DBConnection.getConnction();
                String sql = "INSERT INTO   employee_qualifications_major (employee_id,major_name) VALUES (?,?)";
                pps = conn.prepareStatement(sql);
                pps.setString(1,     Employee_Given_ID_resource);
                pps.setString(2,   Major_Two.getText().trim());

                pps.executeUpdate();
                  Major_Two.setText(null);      
                } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);} 
      
              try {
                 conn = DBConnection.getConnction();
                String sql = "INSERT INTO   employee_qualifications_major (employee_id,major_name) VALUES (?,?)";
                pps = conn.prepareStatement(sql);
                pps.setString(1,     Employee_Given_ID_resource);
                pps.setString(2,      Major3.getText().trim());

                pps.executeUpdate();
                 Major3.setText(null);      
                } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);} 
    }
    
      public void Updaing_majorSubjects_for_Teacher(){
              try {
                 conn = DBConnection.getConnction();
                String sql = "UPDATE  employee_qualifications_major SET  major_name =? WHERE  qualifications_major_id = ?";
                pps = conn.prepareStatement(sql);
                pps.setString(1,   Major_One.getText().trim());
                pps.setString(2,    Major1_resource);

                pps.executeUpdate();
                 Major_One.setText(null);
               } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);} 
      
              try {
                conn = DBConnection.getConnction();
                String sql = "UPDATE  employee_qualifications_major SET  major_name =? WHERE  qualifications_major_id = ?";
                pps = conn.prepareStatement(sql);
                pps.setString(1,   Major_Two.getText().trim());
                    pps.setString(2,    Major2_resource);
                pps.executeUpdate();
                  Major_Two.setText(null);      
                } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);} 
      
              try {
                conn = DBConnection.getConnction();
                String sql = "UPDATE  employee_qualifications_major SET  major_name =? WHERE  qualifications_major_id = ?";
                pps = conn.prepareStatement(sql);
                pps.setString(1,      Major3.getText().trim());
                  pps.setString(2,      Major3_resource);
                pps.executeUpdate();
                 Major3.setText(null);      
                } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);} 
              
    }
    
    
      //ENCODING THE PASSWORD
    private static String getEncodedString(String Passward){
       return Base64.getEncoder().encodeToString(Passward.getBytes());
    }
    
    private void jLabel75MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel75MouseClicked
         insertRegistraion();
    }//GEN-LAST:event_jLabel75MouseClicked

    
     public void insertRegistraion() {
        //checking the  field for inputs if its empt
        if (fname_txt.getText().length() == 0) {
            fname_txt.setText("Enter first Name");

        } else if (lname_txt.getText().length() == 0) {
            lname_txt.setText("Enter last Name");

        } else if (txtHint.getText().length() == 0) {
            txtHint.setText("Enter user Hint");

        } else {

                try {// database connection
                conn = DBConnection.getConnction();
                pps3 = conn.prepareStatement("SELECT * FROM  access WHERE name = ? and confirmed_password =? AND user =? ");
                pps3.setString(1, txtUser_name.getText());
                pps3.setString(2, txtPassword.getText());
                pps3.setString(3, access_level_choser.getSelectedItem().toString());

                rs3 = pps3.executeQuery();
                
                 
                
                if (rs3.next()) {
                 JOptionPane.showMessageDialog(this, "Account Already Exists");
                    
                } else {
                      //getting the used info for sign up to get the user ID
                  entered_user_name = txtUser_name.getText();
                  entered_user_password = access_level_choser.getSelectedItem().toString();
                  
                 inserting_user_afterNOT_Found();
                    
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }
     String encryptedPassward = null;
    public void inserting_user_afterNOT_Found() {
        
         if (imgBTN_clicked.equals("none")) {
          JOptionPane.showMessageDialog(null, "Select the Image");
         } else if (!imgBTN_clicked.equals("none")) {
        
              InputStream inputSteam = null;
              String dir = img_url.getText();
            
            try {
                inputSteam = new FileInputStream(new File(dir));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Adminstrative.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        try {
            conn = DBConnection.getConnction();
            pps4 = conn.prepareStatement("INSERT INTO access(name,confirmed_password,email_phone,first_name,last_name,hint,user, user_pic) VALUES (?,?,?,?,?,?,?,?)");
            pps4.setString(1, txtUser_name.getText().toLowerCase().trim());
            
           encryptedPassward = getEncodedString(txtConfirm_pass.getText());
            
            pps4.setString(2, encryptedPassward);
            
            
            pps4.setString(3, txtcontact.getText().trim());
            pps4.setString(4, fname_txt.getText().trim());
            pps4.setString(5, lname_txt.getText().trim());
            pps4.setString(6, txtHint.getText().trim());
            pps4.setString(7, access_level_choser.getSelectedItem().toString());
            pps4.setBlob(8, inputSteam);

            pps4.executeUpdate();
            
            
            
            

             
             
             GetUser_ID_afterRegistration();
              
           
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);}
        
         }

    }
    
    
      private void GetUser_ID_afterRegistration() {
             try {//database connection
                conn = DBConnection.getConnction();
                pps2 = conn.prepareStatement("SELECT * FROM  access WHERE name = ?");
                pps2.setString(1, entered_user_name);
                rs2 = pps2.executeQuery();
                if (rs2.next()) {
                   JOptionPane.showMessageDialog(null, "Access Info Successfully Saved, Complete All Required Info");

                            obtained_use_id = rs2.getString("access_id");
                            panel_forPersonal_info.setVisible(true);
                            panel_forUser_Account.hide();
                            panel_forQualifications.hide();
                    
                    Insert_Personal_info();
                } 

             } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
             
             
             
    }
    public void Insert_Personal_info(){
              try {
            conn = DBConnection.getConnction();
            pps5 = conn.prepareStatement(" SELECT  * FROM  access WHERE access_id =?");
            pps5.setString(1,obtained_use_id.trim()); 
            rs5 = pps5.executeQuery();
            byte[] image = null;
            while(rs5.next()){
                 String fname = rs5.getString("first_name");
                 String  lname= rs5.getString("last_name");
                        txtFname.setText(fname);
                        txtLname.setText(lname);
                        txtContact.setText(rs5.getString("email_phone"));
                        mode.setText("HI " +fname +"  "+lname +"  Welcome To SMS");
                        
                  image = rs5.getBytes("user_pic");
                 Image img = Toolkit.getDefaultToolkit().createImage(image);
                 ImageIcon icon = new ImageIcon(img);

                Image modifiedImaged = img.getScaledInstance(img_holder.getWidth(), img_holder.getHeight(), Image.SCALE_SMOOTH);
                icon = new ImageIcon(modifiedImaged);
                img_holder.setIcon(icon);
               
                }
            } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
          }
    
    
    }
    
    
    
    
    
    
    
    
//method not being usered..
    
    public void update(){
    
       try {
            
                String DOB_Selected_date= ((JTextField)txtDOB.getDateEditor().getUiComponent()).getText();
                String Imployment_Date= ((JTextField)txtImployment_Date.getDateEditor().getUiComponent()).getText();
           
                 conn = DBConnection.getConnction();
                String sql = "UPDATE   employee SET name =?,surname =?, employeeid =?,contact =?, email =?,address =?,dob =?, gender =?,Joining_date =?,username=?,confirmed_pass =?, country =?,salary =?,department =?,designation=?,qualification =? WHERE employee_Id = ?";
                pps = conn.prepareStatement(sql);
                pps.setString(1 , txtFname.getText());
                pps.setString(2 , txtLname.getText());
                pps.setString(3 ,  txtEmployee_id.getText());
                pps.setString(4 , txtContact.getText());
                pps.setString(5 ,txtEmail.getText());
                pps.setString(6 , txtAddress.getText());
                pps.setString(7,  DOB_Selected_date);
                pps.setString(8, Gender.getSelectedItem().toString());
                pps.setString(9, Imployment_Date);
                pps.setString(10,   txtUser_name.getText());
                pps.setString(11, txtConfirm_pass.getText());
                pps.setString(12,   txtCountry.getText());
                pps.setString(13,   txtSalary.getSelectedItem().toString());
                pps.setString(14,   txtDepartment.getSelectedItem().toString());
                pps.setString(15,   txtDesignation.getSelectedItem().toString());
                pps.setString(16,   txtQualification.getSelectedItem().toString());
                pps.setString(17,   Major_One.getText());
                pps.setString(18,   Major_Two.getText());
                pps.setString(19,   Major3.getText());
                 pps.setString(20,   User_login_ID_resource);
                pps.executeUpdate();
                
                 
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
    }
    
    
    
    
    private void Save_Qualifications_info1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Save_Qualifications_info1MouseClicked
        
         SaveTeacher_General_Info();
    }//GEN-LAST:event_Save_Qualifications_info1MouseClicked

    private void Add_price4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_price4MouseClicked
        Departments_list.hide();
        Departments_entry.setVisible(true);
    }//GEN-LAST:event_Add_price4MouseClicked

    
    
    private void Department_Table_displayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Department_Table_displayMouseClicked
        // making the btn visible when the table is clicked
          if(cover_layout1.isShowing()){
         cover_layout1.hide();
         btn_layout1.setVisible(true);
         }else if(btn_layout1.isShowing()){
          btn_layout1.hide();
          cover_layout1.setVisible(true);
        }
    }//GEN-LAST:event_Department_Table_displayMouseClicked

    private void Add_price5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_price5MouseClicked
        // TODO add your handling code here:
         Employee_list.hide();
       P_Departments.hide();
       P_Designation  .hide(); 
       P_employee.hide();
       Employee_entry.setVisible(true);
    }//GEN-LAST:event_Add_price5MouseClicked

    private void Employee_Table_displayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Employee_Table_displayMouseClicked
         // making the btn visible when the table is clicked
          if(btn_layout.isShowing()){
          btn_layout.hide();
          Cover_layout.setVisible(true);
         }else if(Cover_layout.isShowing()){
          Cover_layout.hide();
          btn_layout.setVisible(true);
        }
    }//GEN-LAST:event_Employee_Table_displayMouseClicked

    private void DepartMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DepartMouseEntered
       
    }//GEN-LAST:event_DepartMouseEntered

    private void DepartMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DepartMouseExited
        // TODO add your handling code here:
      //  Employee_Table_display
        
    }//GEN-LAST:event_DepartMouseExited

    private void lb_Chooser_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_Chooser_btnMouseClicked
        img_holder.setIcon(null);
        
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
               img_holder.setIcon(icon);
           } catch (IOException ex) {
                Logger.getLogger(Adminstrative.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_lb_Chooser_btnMouseClicked

    private void txtEmployee_idMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEmployee_idMouseExited
              
      if(!txtEmployee_id.getText().isEmpty()) {
       jLabel100.hide();
      }else{
        jLabel100.setVisible(true);
        
      }
        
       

    }//GEN-LAST:event_txtEmployee_idMouseExited

    private void txtLnameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtLnameMouseExited
          if(!txtLname.getText().isEmpty()) {
       lbSLname.hide();
      }else{
        lbSLname.setVisible(true);
        
      }
    }//GEN-LAST:event_txtLnameMouseExited

    private void GenderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GenderMouseExited
      
       if(Gender.getSelectedItem().toString().equals("None")) {
             lBDATE.setVisible(true);

       }else{
               lBDATE.hide();

      }
    }//GEN-LAST:event_GenderMouseExited

    private void textSearch_DepartmentKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSearch_DepartmentKeyPressed
        try {
      
         conn = DBConnection.getConnction();
         String sql = " SELECT name FROM department   WHERE  name  like '%" + textSearch_Department.getText() + "%' ";
         pps = conn.prepareStatement(sql);
         rs = pps.executeQuery();
         Department_Table_display.setModel(DbUtils.resultSetToTableModel(rs));
    } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_textSearch_DepartmentKeyPressed

    private void tex_Search_EmployeeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tex_Search_EmployeeKeyPressed
         try {
      
        conn = DBConnection.getConnction();
          String sql = " SELECT name,surname,department,designation FROM employee  WHERE  name  like '%" + tex_Search_Employee.getText() + "%'  OR  surname  like '%" + tex_Search_Employee.getText() + "%'   OR designation  like '%" + tex_Search_Employee.getText() + "%' ";
         pps = conn.prepareStatement(sql);
         rs = pps.executeQuery();
         Employee_Table_display.setModel(DbUtils.resultSetToTableModel(rs));
    } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_tex_Search_EmployeeKeyPressed

    private void txtQualificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQualificationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQualificationActionPerformed

    private void BackGround_headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackGround_headerMouseDragged
       int x=evt.getXOnScreen();
         int y=evt.getYOnScreen();
         this.setLocation(x-xx, y-yy);
    }//GEN-LAST:event_BackGround_headerMouseDragged

    private void BackGround_headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackGround_headerMousePressed
         xx = evt.getX();
          yy = evt.getY();
    }//GEN-LAST:event_BackGround_headerMousePressed

    private void image_chooserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_image_chooserMouseClicked
       
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
               Image modifiedImage = image.getScaledInstance(logo2.getWidth(), logo2.getHeight(), Image.SCALE_SMOOTH);
               icon = new ImageIcon(modifiedImage);
             //   img_holder.setIcon(new ImageIcon(ImageIO.read(f)));
                logo2.setIcon(icon);
                imgBTN_clicked = "TRUE";
           } catch (IOException ex) {
                Logger.getLogger(Adminstrative.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_image_chooserMouseClicked

    private void txtContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContactActionPerformed

    private void DPTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DPTableMouseClicked
        
          DefaultTableModel tableModed =(DefaultTableModel)DPTable.getModel();
           String fnane = tableModed.getValueAt(DPTable.getSelectedRow(), 0).toString();
        
           DefaultTableModel tableModed1 =(DefaultTableModel)DPTable.getModel();
           String lname = tableModed1.getValueAt(DPTable.getSelectedRow(), 1).toString();
           txtHeadOFDP.setText(fnane +"   "+ lname);
           
           
           
            try {
           
                conn = DBConnection.getConnction();
                String sql = "SELECT  * FROM employee WHERE name = ? AND surname =? ";
                 pps = conn.prepareStatement(sql);
                 pps.setString(1, fnane);
                  pps.setString(2, lname);
                          

                  rs = pps.executeQuery();
                     if(rs.next()){
                         DOBid.setText(rs.getString("user_login_id"));
                    User_login_ID_resource =rs.getString("user_login_id"); 
                    

                        
                          
                     }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
           
           
           
           
          
           
    }//GEN-LAST:event_DPTableMouseClicked

    private void txtHeadOFDPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHeadOFDPKeyTyped
           try {
      
        conn = DBConnection.getConnction();
          String sql = " SELECT name,surname,department,designation FROM employee  WHERE  name  like '%" + txtHeadOFDP.getText() + "%'  OR  surname  like '%" + txtHeadOFDP.getText() + "%'   OR designation  like '%" + txtHeadOFDP.getText() + "%' ";
         pps = conn.prepareStatement(sql);
         rs = pps.executeQuery();
         DPTable.setModel(DbUtils.resultSetToTableModel(rs));
    } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_txtHeadOFDPKeyTyped

    private void PreDefined_DepartmentsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_PreDefined_DepartmentsItemStateChanged
        // TODO add your handling code here:
      String Selecteditem =  PreDefined_Departments.getSelectedItem().toString().trim();
      Depart.setText(Selecteditem);
    }//GEN-LAST:event_PreDefined_DepartmentsItemStateChanged
 
     public void  SaveTeacher_General_Info(){
         
         try {
                String DOB_Selected_date= ((JTextField)txtDOB.getDateEditor().getUiComponent()).getText();
                 conn = DBConnection.getConnction();
                String sql = "INSERT INTO  employee (user_login_id,name,surname,employeeid,contact, email,address,dob, gender, country,salary,department,designation,qualification) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                pps = conn.prepareStatement(sql);
                pps.setString(1 , obtained_use_id.trim());  

                pps.setString(2 ,txtFname.getText() );  
                pps.setString(3 , txtLname.getText());
                pps.setString(4 , txtEmployee_id.getText() );
                pps.setString(5 , txtContact.getText()); 
                pps.setString(6 ,txtEmail.getText());
                pps.setString(7 , txtAddress.getText());
                pps.setString(8,  DOB_Selected_date);
                pps.setString(9, Gender.getSelectedItem().toString());
                pps.setString(10, txtCountry.getText());
               
                pps.setString(11,   txtSalary.getSelectedItem().toString());
                pps.setString(12,   txtDepartment.getSelectedItem().toString());
                pps.setString(13,   txtDesignation.getSelectedItem().toString());
                pps.setString(14,   txtQualification.getSelectedItem().toString());
                
               
                  pps.executeUpdate();
                  txtFname .setText(null); 
                  txtLname.setText(null);
                  txtContact.setText(null);     
                  txtEmail .setText(null);       
                  txtAddress.setText(null);
                  Gender .setSelectedIndex(0);
                  txtCountry.setText(null);      
                } catch (SQLException ex) { JOptionPane.showMessageDialog(null, ex); }
       showContent_onAllTables();
       Save_Teachers_major();
    }

   public void Save_Teachers_major(){
   
              try {
                 conn = DBConnection.getConnction();
                String sql = "INSERT INTO   employee_qualifications_major (user_login_id,major_name) VALUES (?,?)";
                pps5 = conn.prepareStatement(sql);
                pps5.setString(1,     obtained_use_id);
                pps5.setString(2,   Major_One.getText().trim());
                pps5.executeUpdate();
                 Major_One.setText(null);
               } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);} 
      
              try {
                conn = DBConnection.getConnction();
                String sql = "INSERT INTO   employee_qualifications_major (user_login_id,major_name) VALUES (?,?)";
                pps6 = conn.prepareStatement(sql);
                pps6.setString(1,     obtained_use_id);
                pps6.setString(2,   Major_Two.getText().trim());

                pps6.executeUpdate();
                  Major_Two.setText(null);      
                } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);} 
      
              try {
                 conn = DBConnection.getConnction();
                String sql = "INSERT INTO   employee_qualifications_major (user_login_id,major_name) VALUES (?,?)";
                pps7 = conn.prepareStatement(sql);
                pps7.setString(1,     obtained_use_id);
                pps7.setString(2,      Major3.getText().trim());

                pps7.executeUpdate();
                 Major3.setText(null);      
                } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);} 
              
              JOptionPane.showMessageDialog(null, "Registration Complete");
    
                obtained_use_id = null;
   
   }
     
     
     
     
     
    
     public void ComboDisplay(){
       // /---------------------------------------------------------------Departments-------------------------------  
        try {
             conn = DBConnection.getConnction();
             pps = conn.prepareStatement("SELECT * FROM department");
             rs = pps.executeQuery();
             while(rs.next()){
              ShowDepartments.addItem(rs.getString("name"));//Showdepaertmets pa combo on the create room--
              txtDepartment.addItem(rs.getString("name"));//Showdepaertmets pa combo on the employee form--
            }
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex); }
        
        try {
             conn = DBConnection.getConnction();
             pps = conn.prepareStatement("SELECT * FROM  designation");
             rs = pps.executeQuery();
             while(rs.next()){
              txtDesignation.addItem(rs.getString("name"));//Show designation pa combo on the employyee form--
            //  txtDepartment.addItem(rs.getString("name"));//Showdepaertmets pa combo on the employee form--
            }
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex); }
        
                
       try {
      
          conn = DBConnection.getConnction();
          String sql = " SELECT name,surname FROM employee";
          pps = conn.prepareStatement(sql);
         rs = pps.executeQuery();
         DPTable.setModel(DbUtils.resultSetToTableModel(rs));
    } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
        
     }
    
   
     
     
         public static Departments getObj() {  //public method for instance Restriction
        if (Obj == null) {
            Obj = new Departments();
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
            java.util.logging.Logger.getLogger(Departments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Departments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Departments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Departments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Departments().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Add_price4;
    private javax.swing.JLabel Add_price5;
    private javax.swing.JLabel BackGround_header;
    private javax.swing.JPanel Container_forGeneral;
    private javax.swing.JLabel Count_title;
    private javax.swing.JLabel Count_title1;
    private javax.swing.JLabel Count_title12;
    private javax.swing.JLabel Count_title13;
    private javax.swing.JLabel Count_title14;
    private javax.swing.JLabel Count_title15;
    private javax.swing.JLabel Count_title2;
    private javax.swing.JLabel Count_title4;
    private javax.swing.JLabel Count_title40;
    private javax.swing.JLabel Count_title45;
    private javax.swing.JLabel Count_title6;
    private javax.swing.JLabel Count_title7;
    private javax.swing.JLabel Count_title8;
    private javax.swing.JPanel Cover_layout;
    private javax.swing.JTextField DOBid;
    private javax.swing.JTable DPTable;
    private javax.swing.JLabel Delecte23;
    private javax.swing.JLabel Delecte25;
    private javax.swing.JLabel Delecte26;
    private javax.swing.JLabel Delecte27;
    private javax.swing.JTextField Depart;
    private javax.swing.JTable Department_Table_display;
    private javax.swing.JPanel Departments_entry;
    private javax.swing.JPanel Departments_list;
    private javax.swing.JPanel Departments_main;
    private javax.swing.JTable Designation_Table_display;
    private javax.swing.JPanel Designation_entry;
    private javax.swing.JPanel Designation_list;
    private javax.swing.JTextField Dname;
    private javax.swing.JTable Employee_Table_display;
    private javax.swing.JPanel Employee_entry;
    private javax.swing.JPanel Employee_list;
    private javax.swing.JComboBox Gender;
    private javax.swing.JLabel LBGENDER;
    private javax.swing.JTextField Major3;
    private javax.swing.JTextField Major_One;
    private javax.swing.JTextField Major_Two;
    private javax.swing.JPanel P_Departments;
    private javax.swing.JPanel P_Designation;
    private javax.swing.JPanel P_Designation_main;
    private javax.swing.JPanel P_employee;
    private javax.swing.JComboBox PreDefined_Departments;
    private javax.swing.JLabel SaveTeacher_General_Info;
    private javax.swing.JLabel Save_Qualifications_info1;
    private javax.swing.JPanel Searching_panel_holder;
    private javax.swing.JPanel Searching_panel_holder1;
    private javax.swing.JComboBox ShowDepartments;
    private javax.swing.JPanel Side_Panel;
    private javax.swing.JComboBox access_level_choser;
    private javax.swing.JLabel addRoom_type;
    private javax.swing.JLabel addRoom_type1;
    private javax.swing.JLabel addRoom_type2;
    private javax.swing.JLabel addreessLb;
    private javax.swing.JPanel admin_btn;
    private javax.swing.JLabel backtoDesig;
    private javax.swing.JLabel bg_back_layout;
    private javax.swing.JLabel bg_back_layout1;
    private javax.swing.JPanel btn_layout;
    private javax.swing.JPanel btn_layout1;
    private javax.swing.JPanel calender;
    private javax.swing.JPanel center;
    private javax.swing.JPanel cover_layout1;
    private javax.swing.JLabel edit18;
    private javax.swing.JLabel edit19;
    private javax.swing.JLabel edit20;
    private javax.swing.JPanel employee_Inner_panel;
    private javax.swing.JPanel employee_main;
    private javax.swing.JLabel exit_lb;
    private javax.swing.JTextField fname_txt;
    private javax.swing.JPanel front_holder;
    private javax.swing.JPanel hotel_ma;
    private javax.swing.JLabel image_chooser;
    private javax.swing.JLabel img_holder;
    private javax.swing.JLabel img_url;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel200;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel223;
    private javax.swing.JLabel jLabel226;
    private javax.swing.JLabel jLabel227;
    private javax.swing.JLabel jLabel229;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel230;
    private javax.swing.JLabel jLabel231;
    private javax.swing.JLabel jLabel232;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel66;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JLabel lBDATE;
    private javax.swing.JPanel layer;
    private javax.swing.JLabel lbContact1;
    private javax.swing.JLabel lbEmail1;
    private javax.swing.JLabel lbFname;
    private javax.swing.JLabel lbSLname;
    private javax.swing.JLabel lb_BG;
    private javax.swing.JLabel lb_Chooser_btn;
    private javax.swing.JLabel lb_GeneralSettings_btn;
    private javax.swing.JLabel lb_GlobalSettings_btn;
    private javax.swing.JLabel lb_PaymentSettings_btn;
    private javax.swing.JLabel lb_bg_btnFirstView3;
    private javax.swing.JLabel lb_bg_btnFirstView4;
    private javax.swing.JLabel lb_hold;
    private javax.swing.JLabel lb_hold1;
    private javax.swing.JLabel lb_hold12;
    private javax.swing.JLabel lb_hold13;
    private javax.swing.JLabel lb_hold14;
    private javax.swing.JLabel lb_hold15;
    private javax.swing.JLabel lb_hold2;
    private javax.swing.JLabel lb_hold3;
    private javax.swing.JLabel lb_hold4;
    private javax.swing.JLabel lb_hold5;
    private javax.swing.JLabel lb_hold6;
    private javax.swing.JLabel lb_hold7;
    private javax.swing.JTextField lname_txt;
    private javax.swing.JLabel logo2;
    private javax.swing.JLabel main_BG;
    private javax.swing.JLabel minize_lb;
    private javax.swing.JLabel mode;
    private javax.swing.JLabel model;
    private javax.swing.JPanel panel_forPersonal_info;
    private javax.swing.JPanel panel_forQualifications;
    private javax.swing.JPanel panel_forUser_Account;
    private javax.swing.JPanel report_panelBTN;
    private javax.swing.JLabel roomcount1;
    private javax.swing.JLabel roomcount13;
    private javax.swing.JLabel roomcount14;
    private javax.swing.JLabel roomcount15;
    private javax.swing.JLabel roomcount16;
    private javax.swing.JLabel roomcount2;
    private javax.swing.JLabel roomcount3;
    private javax.swing.JLabel roomcount4;
    private javax.swing.JLabel roomcount5;
    private javax.swing.JLabel roomcount6;
    private javax.swing.JLabel roomcount7;
    private javax.swing.JLabel roomcount8;
    private javax.swing.JLabel table_holder_bg15;
    private javax.swing.JLabel table_holder_bg16;
    private javax.swing.JLabel table_holder_bg17;
    private javax.swing.JTextField tex_Search_Employee;
    private javax.swing.JTextField textSearch_Department;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JPasswordField txtConfirm_pass;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtCountry;
    private com.toedter.calendar.JDateChooser txtDOB;
    private javax.swing.JComboBox txtDepartment;
    private javax.swing.JComboBox txtDesignation;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmployee_id;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtHeadOFDP;
    private javax.swing.JTextField txtHint;
    private com.toedter.calendar.JDateChooser txtImployment_Date;
    private javax.swing.JTextField txtLname;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JComboBox txtQualification;
    private javax.swing.JComboBox txtSalary;
    private javax.swing.JTextField txtUser_name;
    private javax.swing.JTextField txtcontact;
    // End of variables declaration//GEN-END:variables
}
