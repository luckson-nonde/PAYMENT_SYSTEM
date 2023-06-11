
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

public class Team_manger extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pps, pps1, pps2, pps3, pps4, pps6, pps5, pps7, pps8, pps9, pps10, pps11, pps12, pps13 = null;
    ResultSet rs, rs1, rs2, rs3, rs4, rs5, rs6, rs7, rs8, rs9, rs10, rs11, rs12, rs13 = null;
    
    
//xtDepartment
    String resource = null;
    String Selected_Department_getID =null;
    
   String  designation_resource_getID =  null;
   String   department_resource_getID  = null;  
   
   String User_login_ID_resource= null;
     String User_login_ID_resource4Teacher= null;
      String Option_Department = null;
       String Employee_Given_ID_resource  = null;
       
       //getting the id from the majors to use update the subjects
       String  Major1_resource   = null;
       String  Major2_resource   = null;
       String  Major3_resource   = null;

    private static String Recieved_user_id = null;
    private static String usertype = null;
    //passing user id
    private static Team_manger Obj = null;
    private String passed_user_id;
    
    
     String imgBTN_clicked = "none";
     String obtained_use_id= null; //obtaing the generated user id

String get_first_Name = null;
String get_last_Name = null;
    
    //geting user id
    String entered_user_name =null;
    String entered_user_level =null;
    String entered_user_password =null;
    
    
            int xx = 0;
            int yy = 0;
    
     Team_manger() {
        initComponents();
        showContent_onAllTables();
        
        
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
  
      //select the  users with no access 
      
      try {
           String access_user = "NoAccess";
           
         conn = DBConnection.getConnction();
          String sql = "SELECT first_name,last_name,user,user_access FROM access WHERE user_access = ? ";
         pps2 = conn.prepareStatement(sql);
         pps2.setString(1, access_user);
         rs2 = pps2.executeQuery();
         Employee_Table_display.setModel(DbUtils.resultSetToTableModel(rs2));
    } catch (SQLException ex) {Logger.getLogger(Team_manger.class.getName()).log(Level.SEVERE, null, ex);}
      
      
      
       
   
        
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
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        center = new javax.swing.JPanel();
        P_employee = new javax.swing.JPanel();
        roomcount2 = new javax.swing.JLabel();
        Count_title1 = new javax.swing.JLabel();
        Count_title = new javax.swing.JLabel();
        roomcount4 = new javax.swing.JLabel();
        roomcount3 = new javax.swing.JLabel();
        lb_hold1 = new javax.swing.JLabel();
        lb_hold3 = new javax.swing.JLabel();
        lb_hold = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        Count_title40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        employee_main = new javax.swing.JPanel();
        Employee_list = new javax.swing.JPanel();
        Searching_panel_holder1 = new javax.swing.JPanel();
        Cover_layout = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        tex_Search_Employee = new javax.swing.JTextField();
        lb_bg_btnFirstView4 = new javax.swing.JLabel();
        btn_layout = new javax.swing.JPanel();
        Add_price5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Delecte23 = new javax.swing.JLabel();
        bg_back_layout1 = new javax.swing.JLabel();
        jScrollPane29 = new javax.swing.JScrollPane();
        Employee_Table_display = new javax.swing.JTable();
        jPanel39 = new javax.swing.JPanel();
        jLabel229 = new javax.swing.JLabel();
        jLabel230 = new javax.swing.JLabel();
        jLabel231 = new javax.swing.JLabel();
        jLabel232 = new javax.swing.JLabel();
        table_holder_bg15 = new javax.swing.JLabel();
        ViewUser_Info = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Container_forGeneral = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        addreessLb = new javax.swing.JLabel();
        lbEmail1 = new javax.swing.JLabel();
        lbSLname = new javax.swing.JLabel();
        lbContact1 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        lbFname = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        lBDATE = new javax.swing.JLabel();
        LBGENDER = new javax.swing.JLabel();
        LBGENDER1 = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        lbAddress = new javax.swing.JLabel();
        lbEmployeeID = new javax.swing.JLabel();
        lbUserAccess = new javax.swing.JLabel();
        lbUsername = new javax.swing.JLabel();
        lbUserLevel = new javax.swing.JLabel();
        lbContact = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        lbQualifications = new javax.swing.JLabel();
        lbGender = new javax.swing.JLabel();
        lbDOB = new javax.swing.JLabel();
        lbResidence = new javax.swing.JLabel();
        lbSLname1 = new javax.swing.JLabel();
        lbSurname1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
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
        jLabel20.setText(" VIEW USERS LIST");
        hotel_ma.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 60));

        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        hotel_ma.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 60));

        front_holder.add(hotel_ma, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 70));

        Side_Panel.add(front_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 650));

        jPanel1.add(Side_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 210, 660));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 60, 20, 750));

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 740, 1360, 50));

        center.setLayout(new java.awt.CardLayout());

        P_employee.setBackground(new java.awt.Color(255, 255, 255));
        P_employee.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        P_employee.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roomcount2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roomcount2.setText("45");
        P_employee.add(roomcount2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 50, 60, 30));

        Count_title1.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title1.setForeground(new java.awt.Color(33, 173, 178));
        Count_title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title1.setText("Approved");
        P_employee.add(Count_title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 100, 20));

        Count_title.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title.setForeground(new java.awt.Color(33, 173, 178));
        Count_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title.setText("Denied");
        P_employee.add(Count_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 100, 20));

        roomcount4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roomcount4.setText("45");
        P_employee.add(roomcount4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 60, 30));

        roomcount3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roomcount3.setText("45");
        P_employee.add(roomcount3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 60, 30));

        lb_hold1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Escalator_Down_30px.png"))); // NOI18N
        P_employee.add(lb_hold1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 60, 60));

        lb_hold3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_literature_30px.png"))); // NOI18N
        P_employee.add(lb_hold3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, 60, 60));

        lb_hold.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_condo_30px.png"))); // NOI18N
        P_employee.add(lb_hold, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 60, 60));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/counters.png"))); // NOI18N
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel32MouseClicked(evt);
            }
        });
        P_employee.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 260, 80));

        Count_title40.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title40.setForeground(new java.awt.Color(33, 173, 178));
        Count_title40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title40.setText("Accounts");
        P_employee.add(Count_title40, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 20, 100, 20));

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/counter2.png"))); // NOI18N
        jLabel41.setText("jLabel41");
        jLabel41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel41MouseClicked(evt);
            }
        });
        P_employee.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 250, 80));

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/counter1.png"))); // NOI18N
        jLabel44.setText("jLabel41");
        jLabel44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel44MouseClicked(evt);
            }
        });
        P_employee.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 250, 80));

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
        Cover_layout.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 80, 40));

        tex_Search_Employee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tex_Search_EmployeeKeyPressed(evt);
            }
        });
        Cover_layout.add(tex_Search_Employee, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 290, 30));

        lb_bg_btnFirstView4.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        lb_bg_btnFirstView4.setForeground(new java.awt.Color(255, 255, 255));
        lb_bg_btnFirstView4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_bg_btnFirstView4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        Cover_layout.add(lb_bg_btnFirstView4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 380, 70));

        Searching_panel_holder1.add(Cover_layout, "card2");

        btn_layout.setPreferredSize(new java.awt.Dimension(380, 84));
        btn_layout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Add_price5.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Add_price5.setForeground(new java.awt.Color(255, 255, 255));
        Add_price5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Add_price5.setText("View");
        Add_price5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_price5MouseClicked(evt);
            }
        });
        btn_layout.add(Add_price5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 80, 60));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Denied");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        btn_layout.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 60, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("   All");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        btn_layout.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 50, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Granted");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        btn_layout.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 50, 40));

        Delecte23.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte23.setForeground(new java.awt.Color(255, 255, 255));
        Delecte23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_no_entry_25px.png"))); // NOI18N
        Delecte23.setText("Delecte");
        Delecte23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Delecte23MouseClicked(evt);
            }
        });
        btn_layout.add(Delecte23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 40));

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
        jLabel229.setText("User Access");
        jPanel39.add(jLabel229, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 100, 50));

        jLabel230.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel230.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel230.setText("  First Name");
        jPanel39.add(jLabel230, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 150, 40));

        jLabel231.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel231.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel231.setText("User Level");
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

        ViewUser_Info.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Container_forGeneral.setBackground(new java.awt.Color(255, 255, 255));
        Container_forGeneral.setPreferredSize(new java.awt.Dimension(1010, 956));
        Container_forGeneral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel69.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(102, 102, 102));
        jLabel69.setText("   User name");
        Container_forGeneral.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 140, 30));

        jLabel77.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(102, 102, 102));
        jLabel77.setText("   User level");
        Container_forGeneral.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 140, 30));

        addreessLb.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        addreessLb.setForeground(new java.awt.Color(102, 102, 102));
        addreessLb.setText("Address");
        Container_forGeneral.add(addreessLb, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 120, 40));

        lbEmail1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lbEmail1.setForeground(new java.awt.Color(102, 102, 102));
        lbEmail1.setText("Email");
        Container_forGeneral.add(lbEmail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 140, 30));

        lbSLname.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lbSLname.setForeground(new java.awt.Color(102, 102, 102));
        lbSLname.setText("User Access");
        Container_forGeneral.add(lbSLname, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 110, 30));

        lbContact1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lbContact1.setForeground(new java.awt.Color(102, 102, 102));
        lbContact1.setText("Contact");
        Container_forGeneral.add(lbContact1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 140, 30));

        jLabel98.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(102, 102, 102));
        jLabel98.setText(" Residence");
        Container_forGeneral.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, 120, 30));

        lbFname.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lbFname.setForeground(new java.awt.Color(102, 102, 102));
        lbFname.setText("First name");
        Container_forGeneral.add(lbFname, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 110, 30));

        jLabel100.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(102, 102, 102));
        jLabel100.setText("Employee ID");
        Container_forGeneral.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 140, 30));

        lBDATE.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lBDATE.setForeground(new java.awt.Color(102, 102, 102));
        lBDATE.setText("D.O.B");
        Container_forGeneral.add(lBDATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 500, 80, 30));

        LBGENDER.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        LBGENDER.setForeground(new java.awt.Color(102, 102, 102));
        LBGENDER.setText("Gender");
        Container_forGeneral.add(LBGENDER, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 550, 140, 30));

        LBGENDER1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        LBGENDER1.setForeground(new java.awt.Color(102, 102, 102));
        LBGENDER1.setText("Qualifications");
        Container_forGeneral.add(LBGENDER1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 600, 130, 30));

        lbName.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbName.setForeground(new java.awt.Color(102, 102, 102));
        Container_forGeneral.add(lbName, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 270, 30));

        lbAddress.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbAddress.setForeground(new java.awt.Color(102, 102, 102));
        Container_forGeneral.add(lbAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, 270, 30));

        lbEmployeeID.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbEmployeeID.setForeground(new java.awt.Color(102, 102, 102));
        Container_forGeneral.add(lbEmployeeID, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 270, 30));

        lbUserAccess.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbUserAccess.setForeground(new java.awt.Color(102, 102, 102));
        Container_forGeneral.add(lbUserAccess, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 270, 30));

        lbUsername.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbUsername.setForeground(new java.awt.Color(102, 102, 102));
        Container_forGeneral.add(lbUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 270, 30));

        lbUserLevel.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbUserLevel.setForeground(new java.awt.Color(102, 102, 102));
        Container_forGeneral.add(lbUserLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 270, 30));

        lbContact.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbContact.setForeground(new java.awt.Color(102, 102, 102));
        Container_forGeneral.add(lbContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 270, 30));

        lbEmail.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbEmail.setForeground(new java.awt.Color(102, 102, 102));
        Container_forGeneral.add(lbEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 270, 30));

        lbQualifications.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbQualifications.setForeground(new java.awt.Color(102, 102, 102));
        Container_forGeneral.add(lbQualifications, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 590, 270, 30));

        lbGender.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbGender.setForeground(new java.awt.Color(102, 102, 102));
        Container_forGeneral.add(lbGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 540, 270, 30));

        lbDOB.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbDOB.setForeground(new java.awt.Color(102, 102, 102));
        Container_forGeneral.add(lbDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 490, 270, 30));

        lbResidence.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbResidence.setForeground(new java.awt.Color(102, 102, 102));
        Container_forGeneral.add(lbResidence, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, 270, 30));

        lbSLname1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lbSLname1.setForeground(new java.awt.Color(102, 102, 102));
        lbSLname1.setText("Surname");
        Container_forGeneral.add(lbSLname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 110, 30));

        lbSurname1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lbSurname1.setForeground(new java.awt.Color(102, 102, 102));
        Container_forGeneral.add(lbSurname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 270, 30));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel1.setText("Deny Access");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        Container_forGeneral.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 80, 80, 60));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jLabel2.setText("Grant Access");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        Container_forGeneral.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 80, 90, 60));

        jScrollPane1.setViewportView(Container_forGeneral);

        ViewUser_Info.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 670));

        center.add(ViewUser_Info, "card7");

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
       
        showContent_onAllTables();
    }//GEN-LAST:event_hotel_maMouseClicked

    private void hotel_maMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hotel_maMouseEntered
        hotel_ma.setBackground(new Color(33,173,178));
    }//GEN-LAST:event_hotel_maMouseEntered

    private void hotel_maMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hotel_maMouseExited
        hotel_ma.setBackground(new Color(121,119,119));
    }//GEN-LAST:event_hotel_maMouseExited

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

    private void Delecte23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Delecte23MouseClicked
           DefaultTableModel tableModel1 =(DefaultTableModel)Employee_Table_display.getModel();
           String first_name = tableModel1.getValueAt(Employee_Table_display.getSelectedRow(), 0).toString();
           
            DefaultTableModel tableModel2 =(DefaultTableModel)Employee_Table_display.getModel();
            String last_name = tableModel2.getValueAt(Employee_Table_display.getSelectedRow(), 1).toString();
           
            DefaultTableModel tableModel3 =(DefaultTableModel)Employee_Table_display.getModel();
            String depart = tableModel3.getValueAt(Employee_Table_display.getSelectedRow(), 2).toString();
           
            
            
            
               try {
                        
                conn = DBConnection.getConnction();
                String sql = "DELETE  FROM access  WHERE first_name = ?  AND  last_name = ?";
                pps3 = conn.prepareStatement(sql);
                 
                pps3.setString(1 , first_name);
                pps3.setString(2, last_name);
            
                 pps3.executeUpdate();
                 JOptionPane.showMessageDialog(null, " User Delected");
                 
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            
            
            
            
            
            
            
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

    
     
    
      //ENCODING THE PASSWORD
    private static String getEncodedString(String Passward){
       return Base64.getEncoder().encodeToString(Passward.getBytes());
    }
    
    
     
     String encryptedPassward = null;
    
 
    
    
    
    private void Add_price5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_price5MouseClicked

          

display();

    }//GEN-LAST:event_Add_price5MouseClicked

    
    public void display(){
    
    ViewUser_Info.setVisible(true);
P_employee.hide();


           
          try {
           
                conn = DBConnection.getConnction();
                String sql = "SELECT  * FROM access WHERE first_name = ? AND last_name =? ";
                 pps = conn.prepareStatement(sql);
                 pps.setString(1, get_first_Name);
                  pps.setString(2, get_last_Name);

                  rs = pps.executeQuery();
                     if(rs.next()){
                   
                    lbName.setText(rs.getString("first_name"));
                    lbSurname1.setText(rs.getString("last_name"));
                    lbUsername.setText(rs.getString("name"));
                    lbUserLevel.setText(rs.getString("user"));
                    lbUserAccess.setText(rs.getString("user_access"));
                    
                
                   
                       
                     }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
          

             
          try {
           
                conn = DBConnection.getConnction();
                String sql = "SELECT  * FROM employee WHERE name = ? AND surname =? ";
                 pps1 = conn.prepareStatement(sql);
                 pps1.setString(1, get_first_Name);
                  pps1.setString(2, get_last_Name);

                  rs1 = pps1.executeQuery();
                     if(rs1.next()){
                    
                     lbEmployeeID.setText(rs1.getString("employeeid"));
                    lbContact.setText(rs1.getString("contact"));
                    lbEmail.setText(rs1.getString("email"));
                    lbAddress.setText(rs1.getString("address"));
                    lbResidence.setText(rs1.getString("country"));
                    lbDOB.setText(rs1.getString("dob"));
                    lbGender.setText(rs1.getString("gender"));
                    lbQualifications.setText(rs1.getString("qualification"));
                   
                       
                     }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }   
          
    
    
    }
    
    
    
    private void Employee_Table_displayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Employee_Table_displayMouseClicked
         // making the btn visible when the table is clicked
          if(btn_layout.isShowing()){
          btn_layout.hide();
          Cover_layout.setVisible(true);
         }else if(Cover_layout.isShowing()){
          Cover_layout.hide();
          btn_layout.setVisible(true);
        }
          
          
                 DefaultTableModel tableMode_type = (DefaultTableModel) Employee_Table_display.getModel();
          get_first_Name = tableMode_type.getValueAt(Employee_Table_display.getSelectedRow(), 0).toString();
        
         DefaultTableModel tableMode_type1 = (DefaultTableModel) Employee_Table_display.getModel();
         get_last_Name = tableMode_type1.getValueAt(Employee_Table_display.getSelectedRow(), 1).toString(); 
          
          
          
          
          
          
          
    }//GEN-LAST:event_Employee_Table_displayMouseClicked

    private void tex_Search_EmployeeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tex_Search_EmployeeKeyPressed
         try {
      
        conn = DBConnection.getConnction();
          String sql = " SELECT name,surname,department,designation FROM employee  WHERE  name  like '%" + tex_Search_Employee.getText() + "%'  OR  surname  like '%" + tex_Search_Employee.getText() + "%'   OR designation  like '%" + tex_Search_Employee.getText() + "%' ";
         pps = conn.prepareStatement(sql);
         rs = pps.executeQuery();
         Employee_Table_display.setModel(DbUtils.resultSetToTableModel(rs));
    } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_tex_Search_EmployeeKeyPressed

    private void BackGround_headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackGround_headerMouseDragged
       int x=evt.getXOnScreen();
         int y=evt.getYOnScreen();
         this.setLocation(x-xx, y-yy);
    }//GEN-LAST:event_BackGround_headerMouseDragged

    private void BackGround_headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackGround_headerMousePressed
         xx = evt.getX();
          yy = evt.getY();
    }//GEN-LAST:event_BackGround_headerMousePressed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
      
            
     try {
                        
                conn = DBConnection.getConnction();
                String sql = "UPDATE   access SET user_access =? WHERE first_name = ?  AND  last_name = ?";
                pps3 = conn.prepareStatement(sql);
                 pps3.setString(1 , "Granted");
                pps3.setString(2 , lbName.getText().trim());
                pps3.setString(3, lbSurname1.getText().trim());
            
                 pps3.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Access Granted");
                 
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

     
     display();///redesplay
     
     
     
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:Deny Access
        
                  
     try {
                        
                conn = DBConnection.getConnction();
                String sql = "UPDATE   access SET user_access =? WHERE first_name = ?  AND  last_name = ?";
                pps3 = conn.prepareStatement(sql);
                 pps3.setString(1 , "Denied");
                pps3.setString(2 , lbName.getText().trim());
                pps3.setString(3, lbSurname1.getText().trim());
            
                              pps3.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Access Denied");
                 
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

     
     display();///redesplay
        
        
        
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        
           //select the  users with no access 
      
      try {
           String access_user = "Granted";
           
         conn = DBConnection.getConnction();
          String sql = "SELECT first_name,last_name,user,user_access FROM access WHERE user_access = ? ";
         pps2 = conn.prepareStatement(sql);
         pps2.setString(1, access_user);
         rs2 = pps2.executeQuery();
         Employee_Table_display.setModel(DbUtils.resultSetToTableModel(rs2));
    } catch (SQLException ex) {Logger.getLogger(Team_manger.class.getName()).log(Level.SEVERE, null, ex);}
      
    
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
           //select the  users with no access 
      
      try {
           String access_user = "Denied";
           
         conn = DBConnection.getConnction();
          String sql = "SELECT first_name,last_name,user,user_access FROM access WHERE user_access = ? ";
         pps2 = conn.prepareStatement(sql);
         pps2.setString(1, access_user);
         rs2 = pps2.executeQuery();
         Employee_Table_display.setModel(DbUtils.resultSetToTableModel(rs2));
    } catch (SQLException ex) {Logger.getLogger(Team_manger.class.getName()).log(Level.SEVERE, null, ex);}    
      
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        
         
      try {
           
           
         conn = DBConnection.getConnction();
          String sql = "SELECT first_name,last_name,user,user_access FROM access ";
         pps2 = conn.prepareStatement(sql);
         rs2 = pps2.executeQuery();
         Employee_Table_display.setModel(DbUtils.resultSetToTableModel(rs2));
    } catch (SQLException ex) {Logger.getLogger(Team_manger.class.getName()).log(Level.SEVERE, null, ex);}
      
      
      
       
   
        
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseClicked
      
      
      try {
           String access_user = "Granted";
           
         conn = DBConnection.getConnction();
          String sql = "SELECT first_name,last_name,user,user_access FROM access WHERE user_access = ? ";
         pps2 = conn.prepareStatement(sql);
         pps2.setString(1, access_user);
         rs2 = pps2.executeQuery();
         Employee_Table_display.setModel(DbUtils.resultSetToTableModel(rs2));
    } catch (SQLException ex) {Logger.getLogger(Team_manger.class.getName()).log(Level.SEVERE, null, ex);}
        
    }//GEN-LAST:event_jLabel32MouseClicked

    private void jLabel44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MouseClicked
        // TODO add your handling code here:
         try {
           String access_user = "Denied";
           
         conn = DBConnection.getConnction();
          String sql = "SELECT first_name,last_name,user,user_access FROM access WHERE user_access = ? ";
         pps2 = conn.prepareStatement(sql);
         pps2.setString(1, access_user);
         rs2 = pps2.executeQuery();
         Employee_Table_display.setModel(DbUtils.resultSetToTableModel(rs2));
    } catch (SQLException ex) {Logger.getLogger(Team_manger.class.getName()).log(Level.SEVERE, null, ex);} 
    }//GEN-LAST:event_jLabel44MouseClicked

    private void jLabel41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel41MouseClicked
        // TODO add your handling code here:
             
      try {
           
           
         conn = DBConnection.getConnction();
          String sql = "SELECT first_name,last_name,user,user_access FROM access ";
         pps2 = conn.prepareStatement(sql);
         rs2 = pps2.executeQuery();
         Employee_Table_display.setModel(DbUtils.resultSetToTableModel(rs2));
    } catch (SQLException ex) {Logger.getLogger(Team_manger.class.getName()).log(Level.SEVERE, null, ex);}
      
      
    }//GEN-LAST:event_jLabel41MouseClicked
 
 
     
    
   
     
     
         public static Team_manger getObj() {  //public method for instance Restriction
        if (Obj == null) {
            Obj = new Team_manger();
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
            java.util.logging.Logger.getLogger(Team_manger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Team_manger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Team_manger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Team_manger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Team_manger().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Add_price5;
    private javax.swing.JLabel BackGround_header;
    private javax.swing.JPanel Container_forGeneral;
    private javax.swing.JLabel Count_title;
    private javax.swing.JLabel Count_title1;
    private javax.swing.JLabel Count_title40;
    private javax.swing.JPanel Cover_layout;
    private javax.swing.JLabel Delecte23;
    private javax.swing.JTable Employee_Table_display;
    private javax.swing.JPanel Employee_list;
    private javax.swing.JLabel LBGENDER;
    private javax.swing.JLabel LBGENDER1;
    private javax.swing.JPanel P_employee;
    private javax.swing.JPanel Searching_panel_holder1;
    private javax.swing.JPanel Side_Panel;
    private javax.swing.JPanel ViewUser_Info;
    private javax.swing.JLabel addreessLb;
    private javax.swing.JPanel admin_btn;
    private javax.swing.JLabel bg_back_layout1;
    private javax.swing.JPanel btn_layout;
    private javax.swing.JPanel center;
    private javax.swing.JPanel employee_main;
    private javax.swing.JLabel exit_lb;
    private javax.swing.JPanel front_holder;
    private javax.swing.JPanel hotel_ma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel229;
    private javax.swing.JLabel jLabel230;
    private javax.swing.JLabel jLabel231;
    private javax.swing.JLabel jLabel232;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JLabel lBDATE;
    private javax.swing.JLabel lbAddress;
    private javax.swing.JLabel lbContact;
    private javax.swing.JLabel lbContact1;
    private javax.swing.JLabel lbDOB;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbEmail1;
    private javax.swing.JLabel lbEmployeeID;
    private javax.swing.JLabel lbFname;
    private javax.swing.JLabel lbGender;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbQualifications;
    private javax.swing.JLabel lbResidence;
    private javax.swing.JLabel lbSLname;
    private javax.swing.JLabel lbSLname1;
    private javax.swing.JLabel lbSurname1;
    private javax.swing.JLabel lbUserAccess;
    private javax.swing.JLabel lbUserLevel;
    private javax.swing.JLabel lbUsername;
    private javax.swing.JLabel lb_bg_btnFirstView4;
    private javax.swing.JLabel lb_hold;
    private javax.swing.JLabel lb_hold1;
    private javax.swing.JLabel lb_hold3;
    private javax.swing.JLabel minize_lb;
    private javax.swing.JLabel mode;
    private javax.swing.JLabel model;
    private javax.swing.JLabel roomcount2;
    private javax.swing.JLabel roomcount3;
    private javax.swing.JLabel roomcount4;
    private javax.swing.JLabel table_holder_bg15;
    private javax.swing.JTextField tex_Search_Employee;
    // End of variables declaration//GEN-END:variables
}
