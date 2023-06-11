package hotel.management;

import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;
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
import javax.swing.table.DefaultTableModel;
import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;
import net.proteanit.sql.DbUtils;

public class Teacher_Student_Register extends javax.swing.JFrame {

      Connection conn = null;
      PreparedStatement pps, pps1, pps2, pps3, pps4, pps6,        pps5, pps7, pps8, pps9, pps10, pps11, pps12 ,pps13 = null;
      ResultSet rs, rs1, rs2, rs3, rs4, rs5, rs6,                  rs7, rs8, rs9, rs10, rs11, rs12 ,rs13= null;


 
 
     
    //user access
    private static String Recieved_user_id = null;
    private static String usertype = null;
    //passing user id
    private static Teacher_Student_Register Obj = null;
    String passed_user_id;
     
String Student_class = null;
    
            int xx = 0;
            int yy = 0;
            String Search_EmployeeID = null;

        Teacher_Student_Register() {
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));

       
    }

    
    
         //*********************************************************GETTING CURRENT USER ID
    public void setUserID(String Received_id) {
      passed_user_id = Received_id;
    }

    public String getUserID() {
        return passed_user_id;
    }

    public void printUserID() {
       Recieved_user_id =  getUserID();//setting the id of the user who logged in and set it to a global variable
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
       
       
         //GETTING AN EMPLOYEE NAME AND ID JOINT WITH THE HANDLING CLASS
         
        ///-----------------------------------------------------------------displying teachers on the table on class_assignment-----------------------------------------------------
        try {
            conn = DBConnection.getConnction();
            String sql = " SELECT employee.name, employee.user_login_id, classes.grade_room FROM employee INNER JOIN class_subject_joint ON employee.user_login_id = class_subject_joint.user_login_id INNER JOIN classes ON class_subject_joint.class_id = classes.class_id WHERE class_subject_joint.user_login_id = ? AND teacher_state = \"Class Teacher\"";
            pps5 = conn.prepareStatement(sql);
            pps5.setString(1, Recieved_user_id);
            rs5 = pps5.executeQuery();
            if(rs5.next()){
             Student_class = rs5.getString("grade_room");
       
            }

        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
         Toshow_all_student_fromeONE_Class();
       
       
    }
    

       public void Toshow_all_student_fromeONE_Class(){
           //USING THE CLASS THE TEACHERS HANDLS TO CALL ALL STUDENTS IN THAT CLASS
           try {conn = DBConnection.getConnction();
            pps4= conn.prepareStatement("SELECT  * FROM  students WHERE Student_Class =?");
            pps4.setString(1,Student_class.trim()); 
            rs4 = pps4.executeQuery();
            while(rs4.next()){
            
                    Sn1.setText(rs4.getString("Full_Name")); 
                    rs4.next();
                    
                    Sn2.setText(rs4.getString("Full_Name"));
                    rs4.next();
                    
                    Sn3.setText(rs4.getString("Full_Name")); 
                    rs4.next();
                    
                    Sn4.setText(rs4.getString("Full_Name"));
                    rs4.next();
                    
                    Sn5.setText(rs4.getString("Full_Name"));
                    rs4.next();
                  
                    Sn6.setText(rs4.getString("Full_Name"));
                     rs4.next();
                    Sn7.setText(rs4.getString("Full_Name"));
                     rs4.next();
                    Sn8.setText(rs4.getString("Full_Name"));
                     rs4.next();
                    Sn9.setText(rs4.getString("Full_Name"));
                     rs4.next();
                    Sn10.setText(rs4.getString("Full_Name"));
                     rs4.next();
                    
                    Sn11.setText( rs4.getString("Full_Name"));
                     rs4.next();
                    Sn12.setText( rs4.getString("Full_Name"));
                     rs4.next();
                    Sn13.setText( rs4.getString("Full_Name"));
                     rs4.next();
                    Sn14.setText(rs4.getString("Full_Name"));
                     rs4.next();
                    Sn15.setText(rs4.getString("Full_Name"));
                     rs4.next();
                    Sn16.setText( rs4.getString("Full_Name"));
                     rs4.next();
                    Sn17.setText( rs4.getString("Full_Name"));
                     rs4.next();
                    Sn18.setText( rs4.getString("Full_Name"));
                     rs4.next();
                     
                    Sn19.setText( rs4.getString("Full_Name"));
                     rs4.next();
                    Sn20.setText(rs4.getString("Full_Name"));
                     rs4.next();
                    Sn21.setText( rs4.getString("Full_Name"));
                     rs4.next();
                    Sn22.setText( rs4.getString("Full_Name"));
                     rs4.next();
                    Sn23.setText(rs4.getString("Full_Name"));
                     rs4.next();
                     
                    Sn24.setText( rs4.getString("Full_Name"));
                    rs4.next();
                     
                    Sn25.setText( rs4.getString("Full_Name"));
                     rs4.next();
                    Sn26.setText( rs4.getString("Full_Name"));
                     rs4.next();
                    Sn27.setText( rs4.getString("Full_Name"));
                     rs4.next();
                    Sn28.setText( rs4.getString("Full_Name"));
                     rs4.next();
                    Sn29.setText( rs4.getString("Full_Name"));
                     rs4.next();
                    Sn30.setText(rs4.getString("Full_Name"));
                     rs4.next();
                    Sn31.setText( rs4.getString("Full_Name"));
                     rs4.next();
                    Sn32.setText( rs4.getString("Full_Name"));
                     rs4.next();
                    Sn33.setText( rs4.getString("Full_Name"));
                     rs4.next();
                    Sn34.setText( rs4.getString("Full_Name"));
                     rs4.next();
                    Sn35.setText( rs4.getString("Full_Name"));
                    rs4.next();
                    Sn36.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn37.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn38.setText(rs4.getString("Full_Name")); rs4.next();
                    Sn39.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn40.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn41.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn42.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn43.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn44.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn45.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn46.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn47.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn48.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn49.setText( rs4.getString("Full_Name")); rs4.next();

                    Sn50.setText(rs4.getString("Full_Name")); rs4.next();
                    Sn51.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn52.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn53.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn54.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn55.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn56.setText( rs4.getString("Full_Name")); rs4.next();
                    
                    Sn57.setText( rs4.getString("Full_Name")); rs4.next();
                     Sn58.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn59.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn60.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn61.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn62.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn63.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn64.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn65.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn66.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn67.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn68.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn69.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn70.setText( rs4.getString("Full_Name")); 
                    
                    
                    Sn71.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn72.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn73.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn74.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn75.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn76.setText( rs4.getString("Full_Name")); rs4.next();
                    
                    Sn77.setText( rs4.getString("Full_Name")); rs4.next();
                     Sn78.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn79.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn80.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn81.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn82.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn83.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn84.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn85.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn86.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn87.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn88.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn89.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn90.setText( rs4.getString("Full_Name"));rs4.next();
                    Sn91.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn92.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn93.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn94.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn95.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn96.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn97.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn98.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn99.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn100.setText( rs4.getString("Full_Name"));rs4.next(); 
                    Sn101.setText( rs4.getString("Full_Name")); rs4.next();
                    Sn102.setText( rs4.getString("Full_Name")); 
               
                    pps4.close();
                    rs4.close();
                    conn.close();
                    
                    
                }
            } catch (SQLException ex) { 
               
            }}
    
    public void count_student(){
  //  SELECT  COUNT(student_ids) FROM `students` WHERE Student_Class = "10B";
    
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
        main_container = new javax.swing.JPanel();
        data_entry = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        R1 = new javax.swing.JComboBox();
        R2 = new javax.swing.JComboBox();
        R3 = new javax.swing.JComboBox();
        R4 = new javax.swing.JComboBox();
        R5 = new javax.swing.JComboBox();
        R6 = new javax.swing.JComboBox();
        R7 = new javax.swing.JComboBox();
        R8 = new javax.swing.JComboBox();
        R9 = new javax.swing.JComboBox();
        R10 = new javax.swing.JComboBox();
        R11 = new javax.swing.JComboBox();
        R12 = new javax.swing.JComboBox();
        R13 = new javax.swing.JComboBox();
        R14 = new javax.swing.JComboBox();
        R15 = new javax.swing.JComboBox();
        R16 = new javax.swing.JComboBox();
        R17 = new javax.swing.JComboBox();
        R18 = new javax.swing.JComboBox();
        R19 = new javax.swing.JComboBox();
        R20 = new javax.swing.JComboBox();
        R21 = new javax.swing.JComboBox();
        R22 = new javax.swing.JComboBox();
        R23 = new javax.swing.JComboBox();
        R24 = new javax.swing.JComboBox();
        R25 = new javax.swing.JComboBox();
        R26 = new javax.swing.JComboBox();
        R27 = new javax.swing.JComboBox();
        R28 = new javax.swing.JComboBox();
        R29 = new javax.swing.JComboBox();
        R30 = new javax.swing.JComboBox();
        R31 = new javax.swing.JComboBox();
        R32 = new javax.swing.JComboBox();
        R33 = new javax.swing.JComboBox();
        R34 = new javax.swing.JComboBox();
        R35 = new javax.swing.JComboBox();
        R36 = new javax.swing.JComboBox();
        R37 = new javax.swing.JComboBox();
        R38 = new javax.swing.JComboBox();
        R39 = new javax.swing.JComboBox();
        R40 = new javax.swing.JComboBox();
        R41 = new javax.swing.JComboBox();
        R42 = new javax.swing.JComboBox();
        R43 = new javax.swing.JComboBox();
        R44 = new javax.swing.JComboBox();
        R45 = new javax.swing.JComboBox();
        R46 = new javax.swing.JComboBox();
        R47 = new javax.swing.JComboBox();
        R48 = new javax.swing.JComboBox();
        R49 = new javax.swing.JComboBox();
        R50 = new javax.swing.JComboBox();
        R51 = new javax.swing.JComboBox();
        R52 = new javax.swing.JComboBox();
        R53 = new javax.swing.JComboBox();
        R54 = new javax.swing.JComboBox();
        R55 = new javax.swing.JComboBox();
        R56 = new javax.swing.JComboBox();
        R57 = new javax.swing.JComboBox();
        R58 = new javax.swing.JComboBox();
        R59 = new javax.swing.JComboBox();
        R60 = new javax.swing.JComboBox();
        R61 = new javax.swing.JComboBox();
        R62 = new javax.swing.JComboBox();
        R63 = new javax.swing.JComboBox();
        R64 = new javax.swing.JComboBox();
        R65 = new javax.swing.JComboBox();
        R66 = new javax.swing.JComboBox();
        R67 = new javax.swing.JComboBox();
        R68 = new javax.swing.JComboBox();
        R69 = new javax.swing.JComboBox();
        R70 = new javax.swing.JComboBox();
        R71 = new javax.swing.JComboBox();
        R72 = new javax.swing.JComboBox();
        R73 = new javax.swing.JComboBox();
        R74 = new javax.swing.JComboBox();
        R75 = new javax.swing.JComboBox();
        R76 = new javax.swing.JComboBox();
        R77 = new javax.swing.JComboBox();
        R78 = new javax.swing.JComboBox();
        R79 = new javax.swing.JComboBox();
        R80 = new javax.swing.JComboBox();
        R81 = new javax.swing.JComboBox();
        R82 = new javax.swing.JComboBox();
        R83 = new javax.swing.JComboBox();
        R84 = new javax.swing.JComboBox();
        R85 = new javax.swing.JComboBox();
        R86 = new javax.swing.JComboBox();
        R87 = new javax.swing.JComboBox();
        R88 = new javax.swing.JComboBox();
        R89 = new javax.swing.JComboBox();
        R90 = new javax.swing.JComboBox();
        R91 = new javax.swing.JComboBox();
        R92 = new javax.swing.JComboBox();
        R93 = new javax.swing.JComboBox();
        R94 = new javax.swing.JComboBox();
        R95 = new javax.swing.JComboBox();
        R96 = new javax.swing.JComboBox();
        R97 = new javax.swing.JComboBox();
        R98 = new javax.swing.JComboBox();
        R99 = new javax.swing.JComboBox();
        R100 = new javax.swing.JComboBox();
        R101 = new javax.swing.JComboBox();
        R102 = new javax.swing.JComboBox();
        Sn4 = new javax.swing.JLabel();
        Sn5 = new javax.swing.JLabel();
        Sn6 = new javax.swing.JLabel();
        Sn3 = new javax.swing.JLabel();
        Sn2 = new javax.swing.JLabel();
        Sn1 = new javax.swing.JLabel();
        Sn7 = new javax.swing.JLabel();
        Sn8 = new javax.swing.JLabel();
        Sn9 = new javax.swing.JLabel();
        Sn52 = new javax.swing.JLabel();
        Sn53 = new javax.swing.JLabel();
        Sn54 = new javax.swing.JLabel();
        Sn55 = new javax.swing.JLabel();
        Sn56 = new javax.swing.JLabel();
        Sn57 = new javax.swing.JLabel();
        Sn58 = new javax.swing.JLabel();
        Sn59 = new javax.swing.JLabel();
        Sn60 = new javax.swing.JLabel();
        Sn61 = new javax.swing.JLabel();
        Sn62 = new javax.swing.JLabel();
        Sn63 = new javax.swing.JLabel();
        Sn64 = new javax.swing.JLabel();
        Sn65 = new javax.swing.JLabel();
        Sn66 = new javax.swing.JLabel();
        Sn67 = new javax.swing.JLabel();
        Sn68 = new javax.swing.JLabel();
        Sn69 = new javax.swing.JLabel();
        Sn70 = new javax.swing.JLabel();
        Sn71 = new javax.swing.JLabel();
        Sn72 = new javax.swing.JLabel();
        Sn73 = new javax.swing.JLabel();
        Sn74 = new javax.swing.JLabel();
        Sn75 = new javax.swing.JLabel();
        Sn76 = new javax.swing.JLabel();
        Sn77 = new javax.swing.JLabel();
        Sn78 = new javax.swing.JLabel();
        Sn79 = new javax.swing.JLabel();
        Sn80 = new javax.swing.JLabel();
        Sn81 = new javax.swing.JLabel();
        Sn82 = new javax.swing.JLabel();
        Sn83 = new javax.swing.JLabel();
        Sn84 = new javax.swing.JLabel();
        Sn85 = new javax.swing.JLabel();
        Sn86 = new javax.swing.JLabel();
        Sn87 = new javax.swing.JLabel();
        Sn88 = new javax.swing.JLabel();
        Sn89 = new javax.swing.JLabel();
        Sn90 = new javax.swing.JLabel();
        Sn91 = new javax.swing.JLabel();
        Sn92 = new javax.swing.JLabel();
        Sn93 = new javax.swing.JLabel();
        Sn94 = new javax.swing.JLabel();
        Sn95 = new javax.swing.JLabel();
        Sn96 = new javax.swing.JLabel();
        Sn97 = new javax.swing.JLabel();
        Sn98 = new javax.swing.JLabel();
        Sn102 = new javax.swing.JLabel();
        Sn99 = new javax.swing.JLabel();
        Sn100 = new javax.swing.JLabel();
        Sn101 = new javax.swing.JLabel();
        Sn10 = new javax.swing.JLabel();
        Sn11 = new javax.swing.JLabel();
        Sn12 = new javax.swing.JLabel();
        Sn13 = new javax.swing.JLabel();
        Sn14 = new javax.swing.JLabel();
        Sn15 = new javax.swing.JLabel();
        Sn16 = new javax.swing.JLabel();
        Sn17 = new javax.swing.JLabel();
        Sn18 = new javax.swing.JLabel();
        Sn19 = new javax.swing.JLabel();
        Sn20 = new javax.swing.JLabel();
        Sn21 = new javax.swing.JLabel();
        Sn22 = new javax.swing.JLabel();
        Sn23 = new javax.swing.JLabel();
        Sn24 = new javax.swing.JLabel();
        Sn25 = new javax.swing.JLabel();
        Sn27 = new javax.swing.JLabel();
        Sn26 = new javax.swing.JLabel();
        Sn28 = new javax.swing.JLabel();
        Sn51 = new javax.swing.JLabel();
        Sn50 = new javax.swing.JLabel();
        Sn49 = new javax.swing.JLabel();
        Sn48 = new javax.swing.JLabel();
        Sn47 = new javax.swing.JLabel();
        Sn46 = new javax.swing.JLabel();
        Sn45 = new javax.swing.JLabel();
        Sn44 = new javax.swing.JLabel();
        Sn43 = new javax.swing.JLabel();
        Sn42 = new javax.swing.JLabel();
        Sn41 = new javax.swing.JLabel();
        Sn40 = new javax.swing.JLabel();
        Sn39 = new javax.swing.JLabel();
        Sn38 = new javax.swing.JLabel();
        Sn37 = new javax.swing.JLabel();
        Sn36 = new javax.swing.JLabel();
        Sn35 = new javax.swing.JLabel();
        Sn34 = new javax.swing.JLabel();
        Sn33 = new javax.swing.JLabel();
        Sn32 = new javax.swing.JLabel();
        Sn31 = new javax.swing.JLabel();
        Sn30 = new javax.swing.JLabel();
        Sn29 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<String>();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        up_date = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        attaindace = new javax.swing.JComboBox();
        full_name = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
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

        main_container.setLayout(new java.awt.CardLayout());

        data_entry.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        R1.setBackground(new java.awt.Color(153, 153, 153));
        R1.setForeground(new java.awt.Color(255, 255, 255));
        R1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R1.setBorder(null);
        jPanel3.add(R1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 120, 30));

        R2.setBackground(new java.awt.Color(153, 153, 153));
        R2.setForeground(new java.awt.Color(255, 255, 255));
        R2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R2.setBorder(null);
        jPanel3.add(R2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 120, 30));

        R3.setBackground(new java.awt.Color(153, 153, 153));
        R3.setForeground(new java.awt.Color(255, 255, 255));
        R3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R3.setBorder(null);
        jPanel3.add(R3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 120, 30));

        R4.setBackground(new java.awt.Color(153, 153, 153));
        R4.setForeground(new java.awt.Color(255, 255, 255));
        R4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R4.setBorder(null);
        jPanel3.add(R4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 120, 30));

        R5.setBackground(new java.awt.Color(153, 153, 153));
        R5.setForeground(new java.awt.Color(255, 255, 255));
        R5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R5.setBorder(null);
        jPanel3.add(R5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 120, 30));

        R6.setBackground(new java.awt.Color(153, 153, 153));
        R6.setForeground(new java.awt.Color(255, 255, 255));
        R6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R6.setBorder(null);
        jPanel3.add(R6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 120, 30));

        R7.setBackground(new java.awt.Color(153, 153, 153));
        R7.setForeground(new java.awt.Color(255, 255, 255));
        R7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R7.setBorder(null);
        jPanel3.add(R7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 120, 36));

        R8.setBackground(new java.awt.Color(153, 153, 153));
        R8.setForeground(new java.awt.Color(255, 255, 255));
        R8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R8.setBorder(null);
        jPanel3.add(R8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 120, 30));

        R9.setBackground(new java.awt.Color(153, 153, 153));
        R9.setForeground(new java.awt.Color(255, 255, 255));
        R9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R9.setBorder(null);
        jPanel3.add(R9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 120, 36));

        R10.setBackground(new java.awt.Color(153, 153, 153));
        R10.setForeground(new java.awt.Color(255, 255, 255));
        R10.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R10.setBorder(null);
        jPanel3.add(R10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 460, 120, 30));

        R11.setBackground(new java.awt.Color(153, 153, 153));
        R11.setForeground(new java.awt.Color(255, 255, 255));
        R11.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R11.setBorder(null);
        jPanel3.add(R11, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 510, 120, 30));

        R12.setBackground(new java.awt.Color(153, 153, 153));
        R12.setForeground(new java.awt.Color(255, 255, 255));
        R12.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R12.setBorder(null);
        jPanel3.add(R12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 560, 120, 30));

        R13.setBackground(new java.awt.Color(153, 153, 153));
        R13.setForeground(new java.awt.Color(255, 255, 255));
        R13.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R13.setBorder(null);
        jPanel3.add(R13, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 610, 120, 30));

        R14.setBackground(new java.awt.Color(153, 153, 153));
        R14.setForeground(new java.awt.Color(255, 255, 255));
        R14.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R14.setBorder(null);
        jPanel3.add(R14, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 660, 120, 30));

        R15.setBackground(new java.awt.Color(153, 153, 153));
        R15.setForeground(new java.awt.Color(255, 255, 255));
        R15.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R15.setBorder(null);
        jPanel3.add(R15, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 710, 120, 30));

        R16.setBackground(new java.awt.Color(153, 153, 153));
        R16.setForeground(new java.awt.Color(255, 255, 255));
        R16.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R16.setBorder(null);
        jPanel3.add(R16, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 760, 120, 30));

        R17.setBackground(new java.awt.Color(153, 153, 153));
        R17.setForeground(new java.awt.Color(255, 255, 255));
        R17.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R17.setBorder(null);
        jPanel3.add(R17, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 810, 120, 30));

        R18.setBackground(new java.awt.Color(153, 153, 153));
        R18.setForeground(new java.awt.Color(255, 255, 255));
        R18.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R18.setBorder(null);
        jPanel3.add(R18, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 860, 120, 30));

        R19.setBackground(new java.awt.Color(153, 153, 153));
        R19.setForeground(new java.awt.Color(255, 255, 255));
        R19.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R19.setBorder(null);
        jPanel3.add(R19, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 910, 120, 30));

        R20.setBackground(new java.awt.Color(153, 153, 153));
        R20.setForeground(new java.awt.Color(255, 255, 255));
        R20.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R20.setBorder(null);
        R20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                R20ActionPerformed(evt);
            }
        });
        jPanel3.add(R20, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 960, 120, 36));

        R21.setBackground(new java.awt.Color(153, 153, 153));
        R21.setForeground(new java.awt.Color(255, 255, 255));
        R21.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R21.setBorder(null);
        jPanel3.add(R21, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1010, 120, 30));

        R22.setBackground(new java.awt.Color(153, 153, 153));
        R22.setForeground(new java.awt.Color(255, 255, 255));
        R22.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R22.setBorder(null);
        jPanel3.add(R22, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1060, 120, 30));

        R23.setBackground(new java.awt.Color(153, 153, 153));
        R23.setForeground(new java.awt.Color(255, 255, 255));
        R23.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R23.setBorder(null);
        jPanel3.add(R23, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1110, 120, 30));

        R24.setBackground(new java.awt.Color(153, 153, 153));
        R24.setForeground(new java.awt.Color(255, 255, 255));
        R24.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R24.setBorder(null);
        jPanel3.add(R24, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1160, 120, 30));

        R25.setBackground(new java.awt.Color(153, 153, 153));
        R25.setForeground(new java.awt.Color(255, 255, 255));
        R25.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R25.setBorder(null);
        jPanel3.add(R25, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1210, 120, 30));

        R26.setBackground(new java.awt.Color(153, 153, 153));
        R26.setForeground(new java.awt.Color(255, 255, 255));
        R26.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R26.setBorder(null);
        jPanel3.add(R26, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1260, 120, 30));

        R27.setBackground(new java.awt.Color(153, 153, 153));
        R27.setForeground(new java.awt.Color(255, 255, 255));
        R27.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R27.setBorder(null);
        jPanel3.add(R27, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1310, 120, 30));

        R28.setBackground(new java.awt.Color(153, 153, 153));
        R28.setForeground(new java.awt.Color(255, 255, 255));
        R28.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R28.setBorder(null);
        jPanel3.add(R28, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1360, 120, 30));

        R29.setBackground(new java.awt.Color(153, 153, 153));
        R29.setForeground(new java.awt.Color(255, 255, 255));
        R29.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R29.setBorder(null);
        jPanel3.add(R29, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1410, 120, 36));

        R30.setBackground(new java.awt.Color(153, 153, 153));
        R30.setForeground(new java.awt.Color(255, 255, 255));
        R30.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R30.setBorder(null);
        jPanel3.add(R30, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1460, 120, 30));

        R31.setBackground(new java.awt.Color(153, 153, 153));
        R31.setForeground(new java.awt.Color(255, 255, 255));
        R31.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R31.setBorder(null);
        jPanel3.add(R31, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1510, 120, 30));

        R32.setBackground(new java.awt.Color(153, 153, 153));
        R32.setForeground(new java.awt.Color(255, 255, 255));
        R32.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R32.setBorder(null);
        jPanel3.add(R32, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1560, 120, 30));

        R33.setBackground(new java.awt.Color(153, 153, 153));
        R33.setForeground(new java.awt.Color(255, 255, 255));
        R33.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R33.setBorder(null);
        jPanel3.add(R33, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1610, 120, 30));

        R34.setBackground(new java.awt.Color(153, 153, 153));
        R34.setForeground(new java.awt.Color(255, 255, 255));
        R34.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R34.setBorder(null);
        jPanel3.add(R34, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1660, 120, 30));

        R35.setBackground(new java.awt.Color(153, 153, 153));
        R35.setForeground(new java.awt.Color(255, 255, 255));
        R35.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R35.setBorder(null);
        jPanel3.add(R35, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1710, 120, 30));

        R36.setBackground(new java.awt.Color(153, 153, 153));
        R36.setForeground(new java.awt.Color(255, 255, 255));
        R36.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R36.setBorder(null);
        jPanel3.add(R36, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1760, 120, 30));

        R37.setBackground(new java.awt.Color(153, 153, 153));
        R37.setForeground(new java.awt.Color(255, 255, 255));
        R37.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R37.setBorder(null);
        jPanel3.add(R37, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1810, 120, 30));

        R38.setBackground(new java.awt.Color(153, 153, 153));
        R38.setForeground(new java.awt.Color(255, 255, 255));
        R38.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R38.setBorder(null);
        jPanel3.add(R38, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1860, 120, 30));

        R39.setBackground(new java.awt.Color(153, 153, 153));
        R39.setForeground(new java.awt.Color(255, 255, 255));
        R39.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R39.setBorder(null);
        jPanel3.add(R39, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1910, 120, 30));

        R40.setBackground(new java.awt.Color(153, 153, 153));
        R40.setForeground(new java.awt.Color(255, 255, 255));
        R40.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R40.setBorder(null);
        jPanel3.add(R40, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 1960, 120, 30));

        R41.setBackground(new java.awt.Color(153, 153, 153));
        R41.setForeground(new java.awt.Color(255, 255, 255));
        R41.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R41.setBorder(null);
        jPanel3.add(R41, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 2010, 120, 30));

        R42.setBackground(new java.awt.Color(153, 153, 153));
        R42.setForeground(new java.awt.Color(255, 255, 255));
        R42.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R42.setBorder(null);
        jPanel3.add(R42, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 2060, 120, 30));

        R43.setBackground(new java.awt.Color(153, 153, 153));
        R43.setForeground(new java.awt.Color(255, 255, 255));
        R43.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R43.setBorder(null);
        jPanel3.add(R43, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 2110, 120, 30));

        R44.setBackground(new java.awt.Color(153, 153, 153));
        R44.setForeground(new java.awt.Color(255, 255, 255));
        R44.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R44.setBorder(null);
        jPanel3.add(R44, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 2160, 120, 30));

        R45.setBackground(new java.awt.Color(153, 153, 153));
        R45.setForeground(new java.awt.Color(255, 255, 255));
        R45.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R45.setBorder(null);
        jPanel3.add(R45, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 2210, 120, 30));

        R46.setBackground(new java.awt.Color(153, 153, 153));
        R46.setForeground(new java.awt.Color(255, 255, 255));
        R46.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R46.setBorder(null);
        jPanel3.add(R46, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 2260, 120, 30));

        R47.setBackground(new java.awt.Color(153, 153, 153));
        R47.setForeground(new java.awt.Color(255, 255, 255));
        R47.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R47.setBorder(null);
        jPanel3.add(R47, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 2310, 120, 36));

        R48.setBackground(new java.awt.Color(153, 153, 153));
        R48.setForeground(new java.awt.Color(255, 255, 255));
        R48.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R48.setBorder(null);
        jPanel3.add(R48, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 2360, 120, 30));

        R49.setBackground(new java.awt.Color(153, 153, 153));
        R49.setForeground(new java.awt.Color(255, 255, 255));
        R49.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R49.setBorder(null);
        jPanel3.add(R49, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 2410, 120, 30));

        R50.setBackground(new java.awt.Color(153, 153, 153));
        R50.setForeground(new java.awt.Color(255, 255, 255));
        R50.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R50.setBorder(null);
        jPanel3.add(R50, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 2460, 120, 30));

        R51.setBackground(new java.awt.Color(153, 153, 153));
        R51.setForeground(new java.awt.Color(255, 255, 255));
        R51.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R51.setBorder(null);
        jPanel3.add(R51, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 2510, 120, 30));

        R52.setBackground(new java.awt.Color(153, 153, 153));
        R52.setForeground(new java.awt.Color(255, 255, 255));
        R52.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R52.setBorder(null);
        jPanel3.add(R52, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 140, 30));

        R53.setBackground(new java.awt.Color(153, 153, 153));
        R53.setForeground(new java.awt.Color(255, 255, 255));
        R53.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R53.setBorder(null);
        jPanel3.add(R53, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, 140, 30));

        R54.setBackground(new java.awt.Color(153, 153, 153));
        R54.setForeground(new java.awt.Color(255, 255, 255));
        R54.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R54.setBorder(null);
        jPanel3.add(R54, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, 140, 30));

        R55.setBackground(new java.awt.Color(153, 153, 153));
        R55.setForeground(new java.awt.Color(255, 255, 255));
        R55.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R55.setBorder(null);
        jPanel3.add(R55, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 160, 140, 30));

        R56.setBackground(new java.awt.Color(153, 153, 153));
        R56.setForeground(new java.awt.Color(255, 255, 255));
        R56.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R56.setBorder(null);
        jPanel3.add(R56, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 210, 140, 30));

        R57.setBackground(new java.awt.Color(153, 153, 153));
        R57.setForeground(new java.awt.Color(255, 255, 255));
        R57.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R57.setBorder(null);
        jPanel3.add(R57, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 260, 140, 30));

        R58.setBackground(new java.awt.Color(153, 153, 153));
        R58.setForeground(new java.awt.Color(255, 255, 255));
        R58.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R58.setBorder(null);
        jPanel3.add(R58, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 310, 140, 30));

        R59.setBackground(new java.awt.Color(153, 153, 153));
        R59.setForeground(new java.awt.Color(255, 255, 255));
        R59.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R59.setBorder(null);
        jPanel3.add(R59, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 360, 140, 30));

        R60.setBackground(new java.awt.Color(153, 153, 153));
        R60.setForeground(new java.awt.Color(255, 255, 255));
        R60.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R60.setBorder(null);
        jPanel3.add(R60, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 410, 140, 30));

        R61.setBackground(new java.awt.Color(153, 153, 153));
        R61.setForeground(new java.awt.Color(255, 255, 255));
        R61.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R61.setBorder(null);
        jPanel3.add(R61, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 460, 140, 30));

        R62.setBackground(new java.awt.Color(153, 153, 153));
        R62.setForeground(new java.awt.Color(255, 255, 255));
        R62.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R62.setBorder(null);
        jPanel3.add(R62, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 510, 140, 30));

        R63.setBackground(new java.awt.Color(153, 153, 153));
        R63.setForeground(new java.awt.Color(255, 255, 255));
        R63.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R63.setBorder(null);
        jPanel3.add(R63, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 560, 140, 30));

        R64.setBackground(new java.awt.Color(153, 153, 153));
        R64.setForeground(new java.awt.Color(255, 255, 255));
        R64.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R64.setBorder(null);
        jPanel3.add(R64, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 610, 140, 30));

        R65.setBackground(new java.awt.Color(153, 153, 153));
        R65.setForeground(new java.awt.Color(255, 255, 255));
        R65.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R65.setBorder(null);
        jPanel3.add(R65, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 660, 140, 30));

        R66.setBackground(new java.awt.Color(153, 153, 153));
        R66.setForeground(new java.awt.Color(255, 255, 255));
        R66.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R66.setBorder(null);
        jPanel3.add(R66, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 710, 140, 30));

        R67.setBackground(new java.awt.Color(153, 153, 153));
        R67.setForeground(new java.awt.Color(255, 255, 255));
        R67.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R67.setBorder(null);
        jPanel3.add(R67, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 760, 140, 30));

        R68.setBackground(new java.awt.Color(153, 153, 153));
        R68.setForeground(new java.awt.Color(255, 255, 255));
        R68.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R68.setBorder(null);
        jPanel3.add(R68, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 810, 140, 30));

        R69.setBackground(new java.awt.Color(153, 153, 153));
        R69.setForeground(new java.awt.Color(255, 255, 255));
        R69.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R69.setBorder(null);
        jPanel3.add(R69, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 860, 140, 30));

        R70.setBackground(new java.awt.Color(153, 153, 153));
        R70.setForeground(new java.awt.Color(255, 255, 255));
        R70.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R70.setBorder(null);
        jPanel3.add(R70, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 910, 140, 30));

        R71.setBackground(new java.awt.Color(153, 153, 153));
        R71.setForeground(new java.awt.Color(255, 255, 255));
        R71.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R71.setBorder(null);
        jPanel3.add(R71, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 960, 140, 30));

        R72.setBackground(new java.awt.Color(153, 153, 153));
        R72.setForeground(new java.awt.Color(255, 255, 255));
        R72.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R72.setBorder(null);
        jPanel3.add(R72, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 1010, 140, 30));

        R73.setBackground(new java.awt.Color(153, 153, 153));
        R73.setForeground(new java.awt.Color(255, 255, 255));
        R73.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R73.setBorder(null);
        jPanel3.add(R73, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 1060, 140, 30));

        R74.setBackground(new java.awt.Color(153, 153, 153));
        R74.setForeground(new java.awt.Color(255, 255, 255));
        R74.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R74.setBorder(null);
        jPanel3.add(R74, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 1110, 140, 30));

        R75.setBackground(new java.awt.Color(153, 153, 153));
        R75.setForeground(new java.awt.Color(255, 255, 255));
        R75.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R75.setBorder(null);
        jPanel3.add(R75, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 1160, 140, 30));

        R76.setBackground(new java.awt.Color(153, 153, 153));
        R76.setForeground(new java.awt.Color(255, 255, 255));
        R76.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R76.setBorder(null);
        jPanel3.add(R76, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 1210, 140, 30));

        R77.setBackground(new java.awt.Color(153, 153, 153));
        R77.setForeground(new java.awt.Color(255, 255, 255));
        R77.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R77.setBorder(null);
        jPanel3.add(R77, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 1260, 140, 30));

        R78.setBackground(new java.awt.Color(153, 153, 153));
        R78.setForeground(new java.awt.Color(255, 255, 255));
        R78.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R78.setBorder(null);
        jPanel3.add(R78, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 1310, 140, 30));

        R79.setBackground(new java.awt.Color(153, 153, 153));
        R79.setForeground(new java.awt.Color(255, 255, 255));
        R79.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R79.setBorder(null);
        jPanel3.add(R79, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 1360, 140, 30));

        R80.setBackground(new java.awt.Color(153, 153, 153));
        R80.setForeground(new java.awt.Color(255, 255, 255));
        R80.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R80.setBorder(null);
        jPanel3.add(R80, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 1410, 140, 30));

        R81.setBackground(new java.awt.Color(153, 153, 153));
        R81.setForeground(new java.awt.Color(255, 255, 255));
        R81.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R81.setBorder(null);
        jPanel3.add(R81, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 1460, 140, 30));

        R82.setBackground(new java.awt.Color(153, 153, 153));
        R82.setForeground(new java.awt.Color(255, 255, 255));
        R82.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R82.setBorder(null);
        jPanel3.add(R82, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 1510, 140, 30));

        R83.setBackground(new java.awt.Color(153, 153, 153));
        R83.setForeground(new java.awt.Color(255, 255, 255));
        R83.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R83.setBorder(null);
        jPanel3.add(R83, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 1560, 140, 30));

        R84.setBackground(new java.awt.Color(153, 153, 153));
        R84.setForeground(new java.awt.Color(255, 255, 255));
        R84.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R84.setBorder(null);
        jPanel3.add(R84, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 1610, 140, 30));

        R85.setBackground(new java.awt.Color(153, 153, 153));
        R85.setForeground(new java.awt.Color(255, 255, 255));
        R85.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R85.setBorder(null);
        jPanel3.add(R85, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 1660, 140, 30));

        R86.setBackground(new java.awt.Color(153, 153, 153));
        R86.setForeground(new java.awt.Color(255, 255, 255));
        R86.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R86.setBorder(null);
        jPanel3.add(R86, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 1710, 140, 30));

        R87.setBackground(new java.awt.Color(153, 153, 153));
        R87.setForeground(new java.awt.Color(255, 255, 255));
        R87.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R87.setBorder(null);
        jPanel3.add(R87, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 1760, 140, 30));

        R88.setBackground(new java.awt.Color(153, 153, 153));
        R88.setForeground(new java.awt.Color(255, 255, 255));
        R88.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R88.setBorder(null);
        jPanel3.add(R88, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 1810, 140, 30));

        R89.setBackground(new java.awt.Color(153, 153, 153));
        R89.setForeground(new java.awt.Color(255, 255, 255));
        R89.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R89.setBorder(null);
        jPanel3.add(R89, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 1860, 140, 30));

        R90.setBackground(new java.awt.Color(153, 153, 153));
        R90.setForeground(new java.awt.Color(255, 255, 255));
        R90.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R90.setBorder(null);
        jPanel3.add(R90, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 1910, 140, 30));

        R91.setBackground(new java.awt.Color(153, 153, 153));
        R91.setForeground(new java.awt.Color(255, 255, 255));
        R91.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R91.setBorder(null);
        jPanel3.add(R91, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 1960, 140, 30));

        R92.setBackground(new java.awt.Color(153, 153, 153));
        R92.setForeground(new java.awt.Color(255, 255, 255));
        R92.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R92.setBorder(null);
        jPanel3.add(R92, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 2010, 140, 30));

        R93.setBackground(new java.awt.Color(153, 153, 153));
        R93.setForeground(new java.awt.Color(255, 255, 255));
        R93.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R93.setBorder(null);
        jPanel3.add(R93, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 2060, 140, 30));

        R94.setBackground(new java.awt.Color(153, 153, 153));
        R94.setForeground(new java.awt.Color(255, 255, 255));
        R94.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R94.setBorder(null);
        jPanel3.add(R94, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 2110, 140, 30));

        R95.setBackground(new java.awt.Color(153, 153, 153));
        R95.setForeground(new java.awt.Color(255, 255, 255));
        R95.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R95.setBorder(null);
        jPanel3.add(R95, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 2160, 140, 30));

        R96.setBackground(new java.awt.Color(153, 153, 153));
        R96.setForeground(new java.awt.Color(255, 255, 255));
        R96.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R96.setBorder(null);
        jPanel3.add(R96, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 2210, 140, 30));

        R97.setBackground(new java.awt.Color(153, 153, 153));
        R97.setForeground(new java.awt.Color(255, 255, 255));
        R97.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R97.setBorder(null);
        jPanel3.add(R97, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 2260, 140, 30));

        R98.setBackground(new java.awt.Color(153, 153, 153));
        R98.setForeground(new java.awt.Color(255, 255, 255));
        R98.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R98.setBorder(null);
        jPanel3.add(R98, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 2310, 140, 36));

        R99.setBackground(new java.awt.Color(153, 153, 153));
        R99.setForeground(new java.awt.Color(255, 255, 255));
        R99.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R99.setBorder(null);
        jPanel3.add(R99, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 2360, 140, 36));

        R100.setBackground(new java.awt.Color(153, 153, 153));
        R100.setForeground(new java.awt.Color(255, 255, 255));
        R100.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R100.setBorder(null);
        jPanel3.add(R100, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 2410, 140, 30));

        R101.setBackground(new java.awt.Color(153, 153, 153));
        R101.setForeground(new java.awt.Color(255, 255, 255));
        R101.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R101.setBorder(null);
        jPanel3.add(R101, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 2460, 140, 30));

        R102.setBackground(new java.awt.Color(153, 153, 153));
        R102.setForeground(new java.awt.Color(255, 255, 255));
        R102.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        R102.setBorder(null);
        jPanel3.add(R102, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 2510, 140, 30));

        Sn4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn4.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 240, 30));

        Sn5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn5.setForeground(new java.awt.Color(153, 153, 153));
        Sn5.setMinimumSize(new java.awt.Dimension(26, 20));
        jPanel3.add(Sn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 240, 30));

        Sn6.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn6.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 240, 30));

        Sn3.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn3.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 240, 30));

        Sn2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn2.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 240, 30));

        Sn1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn1.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, 30));

        Sn7.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn7.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 240, 30));

        Sn8.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn8.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 240, 30));

        Sn9.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn9.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 240, 30));

        Sn52.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn52.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn52, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 250, 30));

        Sn53.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn53.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn53, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 250, 30));

        Sn54.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn54.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn54, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 250, 30));

        Sn55.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn55.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn55, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 250, 30));

        Sn56.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn56.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn56, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 250, 30));

        Sn57.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn57.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn57, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 250, 30));

        Sn58.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn58.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn58, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 250, 30));

        Sn59.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn59.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn59, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, 250, 30));

        Sn60.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn60.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn60, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 410, 250, 30));

        Sn61.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn61.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn61, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 460, 250, 30));

        Sn62.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn62.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn62, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 510, 250, 30));

        Sn63.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn63.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn63, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 560, 250, 30));

        Sn64.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn64.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn64, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 610, 250, 30));

        Sn65.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn65.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn65, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 650, 250, 30));

        Sn66.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn66.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn66, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 710, 250, 30));

        Sn67.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn67.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn67, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 760, 250, 30));

        Sn68.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn68.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn68, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 810, 250, 30));

        Sn69.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn69.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn69, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 860, 250, 30));

        Sn70.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn70.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn70, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 910, 250, 30));

        Sn71.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn71.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn71, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 960, 250, 30));

        Sn72.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn72.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn72, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 1010, 250, 30));

        Sn73.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn73.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn73, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 1060, 250, 30));

        Sn74.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn74.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn74, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 1110, 250, 30));

        Sn75.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn75.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn75, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 1160, 250, 30));

        Sn76.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn76.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn76, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 1210, 250, 30));

        Sn77.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn77.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn77, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 1260, 250, 30));

        Sn78.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn78.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn78, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 1310, 250, 30));

        Sn79.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn79.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn79, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 1360, 250, 30));

        Sn80.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn80.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn80, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 1410, 250, 30));

        Sn81.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn81.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn81, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 1460, 250, 30));

        Sn82.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn82.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn82, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 1510, 250, 30));

        Sn83.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn83.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn83, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 1560, 250, 30));

        Sn84.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn84.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn84, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 1610, 250, 30));

        Sn85.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn85.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn85, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 1660, 250, 30));

        Sn86.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn86.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn86, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 1710, 250, 30));

        Sn87.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn87.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn87, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 1760, 250, 30));

        Sn88.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn88.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn88, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 1810, 250, 30));

        Sn89.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn89.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn89, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 1860, 250, 30));

        Sn90.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn90.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn90, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 1910, 250, 30));

        Sn91.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn91.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn91, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 1960, 250, 30));

        Sn92.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn92.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn92, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 2010, 250, 30));

        Sn93.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn93.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn93, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 2060, 250, 30));

        Sn94.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn94.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn94, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 2110, 250, 30));

        Sn95.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn95.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn95, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 2160, 250, 30));

        Sn96.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn96.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn96, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 2210, 240, 30));

        Sn97.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn97.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn97, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 2260, 240, 30));

        Sn98.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn98.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn98, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 2310, 250, 30));

        Sn102.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn102.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn102, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 2510, 250, 30));

        Sn99.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn99.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn99, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 2360, 250, 30));

        Sn100.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn100.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn100, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 2410, 250, 30));

        Sn101.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn101.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn101, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 2460, 250, 30));

        Sn10.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn10.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 240, 30));

        Sn11.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn11.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 240, 30));

        Sn12.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn12.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 240, 30));

        Sn13.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn13.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 614, 240, 30));

        Sn14.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn14.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 660, 240, 30));

        Sn15.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn15.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 710, 240, 30));

        Sn16.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn16.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 760, 240, 30));

        Sn17.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn17.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 810, 240, 30));

        Sn18.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn18.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 860, 240, 30));

        Sn19.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn19.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 910, 240, 30));

        Sn20.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn20.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn20, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 964, 230, 30));

        Sn21.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn21.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1010, 230, 30));

        Sn22.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn22.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1060, 230, 30));

        Sn23.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn23.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1110, 230, 30));

        Sn24.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn24.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1160, 230, 30));

        Sn25.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn25.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1210, 240, 30));

        Sn27.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn27.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1310, 240, 30));

        Sn26.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn26.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1260, 240, 30));

        Sn28.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn28.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1360, 240, 30));

        Sn51.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn51.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn51, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 2510, 240, 30));

        Sn50.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn50.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn50, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 2460, 240, 30));

        Sn49.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn49.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn49, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 2410, 240, 30));

        Sn48.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn48.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn48, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 2360, 240, 30));

        Sn47.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn47.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn47, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 2310, 240, 30));

        Sn46.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn46.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn46, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 2260, 240, 30));

        Sn45.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn45.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 2210, 240, 30));

        Sn44.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn44.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn44, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 2160, 240, 30));

        Sn43.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn43.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn43, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 2110, 240, 30));

        Sn42.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn42.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 2060, 240, 30));

        Sn41.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn41.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 2010, 240, 30));

        Sn40.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn40.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1960, 240, 30));

        Sn39.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn39.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1910, 240, 30));

        Sn38.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn38.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1860, 240, 30));

        Sn37.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn37.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1810, 240, 30));

        Sn36.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn36.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1760, 240, 30));

        Sn35.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn35.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1710, 240, 30));

        Sn34.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn34.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1660, 240, 30));

        Sn33.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn33.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1610, 240, 30));

        Sn32.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn32.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1560, 240, 30));

        Sn31.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn31.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1510, 240, 30));

        Sn30.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn30.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1460, 240, 30));

        Sn29.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn29.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1414, 240, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 2700));

        jScrollPane1.setViewportView(jPanel2);

        data_entry.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 710));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        data_entry.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(876, 100, 110, -1));
        data_entry.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 80, 210, 20));

        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Update student register");
        data_entry.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 170, 130, 40));

        jButton1.setText("Revert");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        data_entry.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 100, -1, -1));

        jButton2.setText("Mark Register");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        data_entry.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 400, 110, -1));

        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("MUITIPE TRIGER");
        data_entry.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 30, 140, 40));

        jButton4.setText("Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        data_entry.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 220, -1, -1));

        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Press Mark Register to save the informatin");
        data_entry.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 330, 240, 40));

        main_container.add(data_entry, "card4");

        up_date.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        up_date.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 60, 210, 30));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("BACK");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        up_date.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 60, 60, 30));

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setText("Up Date");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 80, -1, 30));

        attaindace.setBackground(new java.awt.Color(153, 153, 153));
        attaindace.setForeground(new java.awt.Color(255, 255, 255));
        attaindace.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Present", "   Late", "   Absent", "   Authorised", "   Sick" }));
        attaindace.setBorder(null);
        jPanel4.add(attaindace, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 120, 30));

        full_name.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        full_name.setForeground(new java.awt.Color(204, 204, 204));
        jPanel4.add(full_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 260, 30));

        jLabel4.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 110, 30));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Attaindence");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 160, 30));

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Student's Full Name");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 160, 30));

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Registered AS");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 160, 30));

        up_date.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 880, 150));

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Search For a Student");
        up_date.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, 140, 30));

        main_container.add(up_date, "card3");

        jPanel1.add(main_container, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 1130, 690));

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
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 380, 40));

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

    private void Tex_manager_lbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tex_manager_lbMouseClicked
     
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  //   jComboBox1.getSelectedItem().toString()
          int Action =  jComboBox1.getSelectedIndex();
          R1.setSelectedIndex(Action);
        
     R10.setSelectedIndex(Action);
   R100.setSelectedIndex(Action);
    R101.setSelectedIndex(Action);
     R102.setSelectedIndex(Action);
    R11.setSelectedIndex(Action);
     R12.setSelectedIndex(Action);
    R13.setSelectedIndex(Action);
     R14.setSelectedIndex(Action);
    R15.setSelectedIndex(Action);
     R16.setSelectedIndex(Action);
    R17.setSelectedIndex(Action);
     R18.setSelectedIndex(Action);
     R19.setSelectedIndex(Action);
     R2.setSelectedIndex(Action);
     R20.setSelectedIndex(Action);
    R21.setSelectedIndex(Action);
     R22.setSelectedIndex(Action);
    R23.setSelectedIndex(Action);
   R24.setSelectedIndex(Action);
    R25.setSelectedIndex(Action);
    R26.setSelectedIndex(Action);
    R27.setSelectedIndex(Action);
    R28.setSelectedIndex(Action);
    R29.setSelectedIndex(Action);
     R3.setSelectedIndex(Action);
   R30.setSelectedIndex(Action);
    R31.setSelectedIndex(Action);
     R32.setSelectedIndex(Action);
     R33.setSelectedIndex(Action);
    R34.setSelectedIndex(Action);
     R35.setSelectedIndex(Action);
    R36.setSelectedIndex(Action);
     R37.setSelectedIndex(Action);
     R38.setSelectedIndex(Action);
   R39.setSelectedIndex(Action);
     R4.setSelectedIndex(Action);
     R40.setSelectedIndex(Action);
    R41.setSelectedIndex(Action);
     R42.setSelectedIndex(Action);
    R43.setSelectedIndex(Action);
    R44.setSelectedIndex(Action);
   R45.setSelectedIndex(Action);
    R46.setSelectedIndex(Action);
    R47.setSelectedIndex(Action);
    R48.setSelectedIndex(Action);
     R49.setSelectedIndex(Action);
    R5.setSelectedIndex(Action);
     R50.setSelectedIndex(Action);
     R51.setSelectedIndex(Action);
   R52.setSelectedIndex(Action);
    R53.setSelectedIndex(Action);
     R54.setSelectedIndex(Action);
    R55.setSelectedIndex(Action);
     R56.setSelectedIndex(Action);
     R57.setSelectedIndex(Action);
     R58.setSelectedIndex(Action);
     R59.setSelectedIndex(Action);
     R6.setSelectedIndex(Action);
     R60.setSelectedIndex(Action);
     R61.setSelectedIndex(Action);
     R62.setSelectedIndex(Action);
     R63.setSelectedIndex(Action);
    R64.setSelectedIndex(Action);
    R65.setSelectedIndex(Action);
    R66.setSelectedIndex(Action);
    R67.setSelectedIndex(Action);
     R68.setSelectedIndex(Action);
     R69.setSelectedIndex(Action);
     R7.setSelectedIndex(Action);
     R70.setSelectedIndex(Action);
     R71.setSelectedIndex(Action);
     R72.setSelectedIndex(Action);
     R73.setSelectedIndex(Action);
    R74.setSelectedIndex(Action);
    R75.setSelectedIndex(Action);
     R76.setSelectedIndex(Action);
    R77.setSelectedIndex(Action);
     R78.setSelectedIndex(Action);
   R79.setSelectedIndex(Action);
     R8.setSelectedIndex(Action);
    R80.setSelectedIndex(Action);
     R82.setSelectedIndex(Action);
    R83.setSelectedIndex(Action);
    R84.setSelectedIndex(Action);
    R85.setSelectedIndex(Action);
    R86.setSelectedIndex(Action);
     R87.setSelectedIndex(Action);
     R88.setSelectedIndex(Action);
     R89.setSelectedIndex(Action);
     R9.setSelectedIndex(Action);
     R90.setSelectedIndex(Action);
     R91.setSelectedIndex(Action);
     R92.setSelectedIndex(Action);
     R93.setSelectedIndex(Action);
     R94.setSelectedIndex(Action);
     R95.setSelectedIndex(Action);
     R96.setSelectedIndex(Action);
    R97.setSelectedIndex(Action);
    R98.setSelectedIndex(Action);
    R99.setSelectedIndex(Action);
    R100.setSelectedIndex(Action);
    R101.setSelectedIndex(Action);
    R102.setSelectedIndex(Action);
          
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         //checking if the register hasnt been marked
        try {
                 Date date = new Date();
                java.sql.Date sqldate = new java.sql.Date(date.getTime());
                conn = DBConnection.getConnction();
                pps9 = conn.prepareStatement("SELECT  * FROM  student_register WHERE day_time >= ?");
                pps9.setDate(1, sqldate); 
                rs9 = pps9.executeQuery();
            if (rs9.next()) {
                
               JOptionPane.showMessageDialog(null, "REGISTER ALREADY  MARKED");
             }else{
               insert_register();
            
              }
          
            } catch (SQLException ex) { Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
       
           
    }//GEN-LAST:event_jButton2ActionPerformed

    public void insert_register(){
       
    
    //INSERTING MUITIPLY DATA         Student_class           Reci
        try {
            
            Date date = new Date();
            java.sql.Date sqldate = new java.sql.Date(date.getTime());
            //add 1 m0re r0 subject name
            conn = DBConnection.getConnction();
             pps7= conn.prepareStatement("INSERT INTO  student_register (full_name,attendency,day_time,Class, Class_Teacher)"  
             + " VALUES (?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?) ,(?,?,?,?,?) , (?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?) ,(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?), (?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?)"
                    + ",(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?) ,(?,?,?,?,?) , (?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?) ,(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?), (?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),"
                     + "(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?) ,(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?)   ,(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?), (?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?), "
                     + "(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?) ,(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?)   ,(?,?,?,?,?), (?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),"
                     + "(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?)   ,(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?)   ,(?,?,?,?,?), (?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?)");
             
             pps7.setString(1 , Sn1.getText().toString().trim());                               //  1
             pps7.setString(2 , R1.getSelectedItem().toString().trim());  
             pps7.setDate(3 , sqldate);
             pps7.setString(4 , Student_class);
             pps7.setString(5 , Recieved_user_id);
                
              pps7.setString(6 , Sn2.getText().toString().trim());                               //  2
              pps7.setString(7 , R2.getSelectedItem().toString().trim());  //37
              pps7.setDate(8 , sqldate);
              pps7.setString(9, Student_class);
              pps7.setString(10, Recieved_user_id);
              
              pps7.setString(11 ,  Sn3.getText().toString().trim());                             //  3
              pps7.setString(12 ,  R3.getSelectedItem().toString().trim());
              pps7.setDate(13 , sqldate);
              pps7.setString(14 , Student_class);
              pps7.setString(15 , Recieved_user_id);
              
              pps7.setString(16 , Sn4.getText().toString());                                      //  4 
              pps7.setString(17 , R4.getSelectedItem().toString());
              pps7.setDate(18 , sqldate);
              pps7.setString(19 , Student_class);
             pps7.setString( 20, Recieved_user_id);
              
               pps7.setString(21 , Sn5.getText().toString());                                      //  5
               pps7.setString(22 ,R5.getSelectedItem().toString());
               pps7.setDate(23 , sqldate);
               pps7.setString(24 , Student_class);
             pps7.setString(25 , Recieved_user_id);
               
              pps7.setString(26 , Sn6.getText().toString());                                         //  6    
               pps7.setString(27 ,R6.getSelectedItem().toString());
               pps7.setDate(28 , sqldate);
               pps7.setString(29 , Student_class);
               pps7.setString(30 , Recieved_user_id);
               
               
               
               
               pps7.setString(31 , Sn7.getText().toString());                                      //  7
               pps7.setString(32 ,R7.getSelectedItem().toString());
               pps7.setDate(33 , sqldate);
               pps7.setString(34 , Student_class);
               pps7.setString(35 , Recieved_user_id);
               
                pps7.setString(36 , Sn8.getText().toString());                                     //  8
               pps7.setString(37 ,R8.getSelectedItem().toString());
               pps7.setDate(38 , sqldate);
               pps7.setString(39 , Student_class);
               pps7.setString(40 , Recieved_user_id);
               
                pps7.setString(41 , Sn9.getText().toString());                                     //  9
               pps7.setString(42 ,R9.getSelectedItem().toString());
               pps7.setDate(43 , sqldate);
               pps7.setString(44 , Student_class);
             pps7.setString(45 , Recieved_user_id);
               
                pps7.setString(46 , Sn10.getText().toString());                                    //  10
               pps7.setString(47 ,R10.getSelectedItem().toString());
               pps7.setDate(48 , sqldate);
               pps7.setString(49 , Student_class);
             pps7.setString(50 , Recieved_user_id);
               
               
                pps7.setString(51 , Sn11.getText().toString());                                    //  11
               pps7.setString(52 ,R11.getSelectedItem().toString());
               pps7.setDate(53 , sqldate);
               pps7.setString(54 , Student_class);
             pps7.setString(55 , Recieved_user_id);
               
                pps7.setString(56 , Sn12.getText().toString());                                     //  12
               pps7.setString(57 ,R12.getSelectedItem().toString());
               pps7.setDate(58 , sqldate);
               pps7.setString(59 , Student_class);
             pps7.setString(60 , Recieved_user_id);
               
                pps7.setString(61 , Sn13.getText().toString());                                      //  13
               pps7.setString(62 ,R13.getSelectedItem().toString());
               pps7.setDate(63 , sqldate);
               pps7.setString(64 , Student_class);
             pps7.setString(65 , Recieved_user_id);
               
               
                pps7.setString(66 , Sn14.getText().toString());                                       //  14 
               pps7.setString(67 ,R14.getSelectedItem().toString());
               pps7.setDate(68 , sqldate);
               pps7.setString(69 , Student_class);
                pps7.setString(70 , Recieved_user_id);
               
                pps7.setString(71 , Sn15.getText().toString());                                       //  15
               pps7.setString(72 ,R15.getSelectedItem().toString());
               pps7.setDate(73 , sqldate);
               pps7.setString(74 , Student_class);
             pps7.setString(75 , Recieved_user_id);
               
                pps7.setString(76 , Sn16.getText().toString());                                        //  16 
               pps7.setString(77 ,R16.getSelectedItem().toString());
               pps7.setDate(78 , sqldate);
               pps7.setString(79 , Student_class);
               pps7.setString(80 , Recieved_user_id);
               
                pps7.setString(81 , Sn17.getText().toString());                                        //  17
               pps7.setString(82 ,R17.getSelectedItem().toString());
               pps7.setDate(83 , sqldate);
               pps7.setString(84 , Student_class);
             pps7.setString(85 , Recieved_user_id);
               
                pps7.setString(86 , Sn18.getText().toString());                                        //  18
               pps7.setString(87 ,R18.getSelectedItem().toString());
               pps7.setDate(88 , sqldate);
               pps7.setString(89 , Student_class);
             pps7.setString(90 , Recieved_user_id);
               
                pps7.setString(91 , Sn19.getText().toString());                                         //  19
               pps7.setString(92 ,R19.getSelectedItem().toString());
               pps7.setDate(93 , sqldate);
               pps7.setString(94 , Student_class);
             pps7.setString(95 , Recieved_user_id);
               
                pps7.setString(96 , Sn20.getText().toString());                                          //  20
               pps7.setString(97 ,R20.getSelectedItem().toString());
               pps7.setDate(98 , sqldate);
               pps7.setString(99 , Student_class);
               pps7.setString(100 , Recieved_user_id);
             
               
               pps7.setString(101 , Sn21.getText().toString());                                        //  21
                pps7.setString(102 ,R21.getSelectedItem().toString());
               pps7.setDate(103 , sqldate);
               pps7.setString(104 , Student_class);
               pps7.setString(105 , Recieved_user_id); 
               

                pps7.setString(106 , Sn22.getText().toString());                                     //  22
               pps7.setString(107 ,R22.getSelectedItem().toString());
               pps7.setDate(108 , sqldate);
               pps7.setString(109 , Student_class);
               pps7.setString(110  , Recieved_user_id);
               
               pps7.setString(111  , Sn23.getText().toString());                                    //  23   
               pps7.setString(112  ,R23.getSelectedItem().toString());
               pps7.setDate(113  , sqldate);
               pps7.setString(114  , Student_class);
               pps7.setString(115  , Recieved_user_id);
               
               pps7.setString(116  , Sn24.getText().toString());                                    //  24
               pps7.setString(117  ,R24.getSelectedItem().toString());
               pps7.setDate(118  , sqldate);
               pps7.setString(119  , Student_class);
               pps7.setString(120  , Recieved_user_id);
               
               pps7.setString(121  , Sn25.getText().toString());                                     //  25
               pps7.setString(122  ,R25.getSelectedItem().toString());
               pps7.setDate(123  , sqldate);
               pps7.setString(124  , Student_class);
               pps7.setString(125  , Recieved_user_id);
               
               pps7.setString(126  , Sn26.getText().toString());                                      //  26  
               pps7.setString(127  ,R26.getSelectedItem().toString());
               pps7.setDate(128  , sqldate);
               pps7.setDate(129  , sqldate);pps7.setString(4 , Student_class);
               pps7.setString(130  , Recieved_user_id);
               
               
               
                
             pps7.setString(131  , Sn27.getText().toString());                                      //  27
               pps7.setString(132  ,R27.getSelectedItem().toString());
               pps7.setDate(133  , sqldate);
               pps7.setString(134  , Student_class);
               pps7.setString(135  , Recieved_user_id);
               
                pps7.setString(136  , Sn28.getText().toString());                                   //  28 
               pps7.setString(137  ,R28.getSelectedItem().toString());
               pps7.setDate(138  , sqldate);
               pps7.setString(139  , Student_class);
               pps7.setString(140  , Recieved_user_id);
               
                pps7.setString(141  , Sn29.getText().toString());                                   //  29
               pps7.setString(142  ,R29.getSelectedItem().toString());
               pps7.setDate(143  , sqldate);
               pps7.setString(144  , Student_class);
               pps7.setString(145  , Recieved_user_id);
               
                pps7.setString(146  , Sn30.getText().toString());                                    //  30
               pps7.setString(147  ,R30.getSelectedItem().toString());
               pps7.setDate(148  , sqldate);
               pps7.setString(149  , Student_class);
               pps7.setString(150  , Recieved_user_id);
               
               
                pps7.setString(151  , Sn31.getText().toString());                                    //  31
               pps7.setString(152  ,R31.getSelectedItem().toString());
               pps7.setDate(153  , sqldate);
               pps7.setString(154  , Student_class);
               pps7.setString(155  , Recieved_user_id);
               
                pps7.setString(156  , Sn32.getText().toString());                                   //  32
               pps7.setString(157  ,R32.getSelectedItem().toString());
               pps7.setDate(158  , sqldate);
               pps7.setString(159  , Student_class);
               pps7.setString(160  , Recieved_user_id);
               
                pps7.setString(161  , Sn33.getText().toString());  //  33
               pps7.setString(162  ,R33.getSelectedItem().toString());
               pps7.setDate(163  , sqldate);
               pps7.setString(164  , Student_class);
               pps7.setString(165  , Recieved_user_id);
               
               pps7.setString(166  , Sn34.getText().toString());         //  34  
               pps7.setString(167  ,R34.getSelectedItem().toString());
               pps7.setDate(168  , sqldate);
               pps7.setString(169  , Student_class);
               pps7.setString(170  , Recieved_user_id);
               
               pps7.setString(171  , Sn35.getText().toString());        //  35
               pps7.setString(172  ,R35.getSelectedItem().toString());
               pps7.setDate(173  , sqldate);
               pps7.setString(174  , Student_class);
               pps7.setString(175  , Recieved_user_id);
               
               pps7.setString(176  , Sn36.getText().toString());         //  36
               pps7.setString(177  ,R36.getSelectedItem().toString());
               pps7.setDate(178  , sqldate);
               pps7.setString(179  , Student_class);
               pps7.setString(180  , Recieved_user_id);
               
               pps7.setString(181  , Sn37.getText().toString());           //  37
               pps7.setString(182  ,R37.getSelectedItem().toString());
               pps7.setDate(183  ,  sqldate);
               pps7.setString(184  , Student_class);
               pps7.setString(185  , Recieved_user_id);
               
               pps7.setString(186  , Sn38.getText().toString());  
               pps7.setString(187  ,R38.getSelectedItem().toString());
               pps7.setDate(188  , sqldate);
               pps7.setString(189  , Student_class);
               pps7.setString(190  , Recieved_user_id);
               
                pps7.setString(191  , Sn39.getText().toString());  
               pps7.setString(192  ,R39.getSelectedItem().toString());
               pps7.setDate(193  , sqldate);
               pps7.setString(194  , Student_class);
              pps7.setString(195  , Recieved_user_id);  
               
                pps7.setString(196  , Sn40.getText().toString());  
               pps7.setString(197   ,R20.getSelectedItem().toString());
               pps7.setDate(198  , sqldate);
               pps7.setString(199  , Student_class);
               pps7.setString(200  , Recieved_user_id);
               
                pps7.setString(201   , Sn41.getText().toString());  
               pps7.setString( 202 ,R41.getSelectedItem().toString());
               pps7.setDate(  203, sqldate);
               pps7.setString(  204, Student_class);
             pps7.setString(  205, Recieved_user_id);

               pps7.setString(  206, Sn42.getText().toString());  
               pps7.setString(  207,R42.getSelectedItem().toString());
               pps7.setDate( 208 , sqldate);
               pps7.setString(  209, Student_class);
             pps7.setString(  210, Recieved_user_id);
             
               
               pps7.setString( 211, Sn43.getText().toString()); 
               pps7.setString(  212,R43.getSelectedItem().toString());
               pps7.setDate(  213, sqldate);
               pps7.setString(  214, Student_class);
               pps7.setString(  215, Recieved_user_id);
               
                pps7.setString(  216, Sn44.getText().toString());  
               pps7.setString(  217,R44.getSelectedItem().toString());
               pps7.setDate(  218, sqldate);
               pps7.setString(  219, Student_class);
             pps7.setString(  220, Recieved_user_id);
               
               pps7.setString(  221, Sn45.getText().toString());  
               pps7.setString( 222 ,R45.getSelectedItem().toString());
               pps7.setDate(  223, sqldate);
               pps7.setString(  224, Student_class);
             pps7.setString(  225, Recieved_user_id);
               
               pps7.setString(  226, Sn46.getText().toString());  
               pps7.setString(  227,R46.getSelectedItem().toString());
               pps7.setDate(  228, sqldate);
               pps7.setString(  229, Student_class);
              pps7.setString(  230, Recieved_user_id);
               
               
              pps7.setString(  231, Sn47.getText().toString());  
                pps7.setString( 232,R47.getSelectedItem().toString());
               pps7.setDate(   233, sqldate);
               pps7.setString(   234, Student_class);
             pps7.setString(   235, Recieved_user_id);
               
                   
              pps7.setString( 236, Sn48.getText().toString());  
               pps7.setString( 237,R48.getSelectedItem().toString());
               pps7.setDate( 238, sqldate);
               pps7.setString( 239, Student_class);
             pps7.setString( 240, Recieved_user_id);
               
                pps7.setString( 241, Sn49.getText().toString());  
               pps7.setString( 242,R49.getSelectedItem().toString());
               pps7.setDate( 243, sqldate);
               pps7.setString( 244, Student_class);
             pps7.setString( 245, Recieved_user_id);
               
                pps7.setString( 246, Sn50.getText().toString());  
               pps7.setString( 247,R50.getSelectedItem().toString());
               pps7.setDate( 248, sqldate);
               pps7.setString( 249, Student_class);
               pps7.setString( 250, Recieved_user_id);
                      
                pps7.setString( 251, Sn51.getText().toString());  
               pps7.setString( 252,R51.getSelectedItem().toString());
               pps7.setDate(  253, sqldate);
               pps7.setString( 254, Student_class);
             pps7.setString( 255, Recieved_user_id);
               
                pps7.setString( 256, Sn52.getText().toString());  
               pps7.setString( 257,R52.getSelectedItem().toString());
               pps7.setDate( 258, sqldate);
               pps7.setString( 259, Student_class);
             pps7.setString( 260, Recieved_user_id);
              
                pps7.setString( 261, Sn53.getText().toString());  
               pps7.setString( 262,R53.getSelectedItem().toString());
               pps7.setDate( 263, sqldate);
               pps7.setString( 264, Student_class);
             pps7.setString( 265, Recieved_user_id);
               
                pps7.setString( 266, Sn54.getText().toString());  
               pps7.setString( 267,R54.getSelectedItem().toString());
               pps7.setDate( 268, sqldate);
               pps7.setString( 269, Student_class);
                 pps7.setString( 270, Recieved_user_id);
               
                pps7.setString( 271, Sn55.getText().toString());  
               pps7.setString( 272,R55.getSelectedItem().toString());
               pps7.setDate( 273, sqldate);
               pps7.setString( 274, Student_class);
               pps7.setString( 275, Recieved_user_id);
               
                pps7.setString( 276, Sn56.getText().toString());  
               pps7.setString( 277,R56.getSelectedItem().toString());
               pps7.setDate( 278, sqldate);
               pps7.setString( 279, Student_class);
             pps7.setString( 280, Recieved_user_id);
               
                pps7.setString( 281, Sn57.getText().toString());  
               pps7.setString( 282,R57.getSelectedItem().toString());
               pps7.setDate( 283, sqldate);
               pps7.setString( 284, Student_class);
              pps7.setString( 285, Recieved_user_id);
               
                pps7.setString( 286, Sn58.getText().toString());  
               pps7.setString( 287,R58.getSelectedItem().toString());
               pps7.setDate( 288, sqldate);
                pps7.setString( 289, Student_class);
               pps7.setString( 290, Recieved_user_id);
               
                pps7.setString( 291, Sn59.getText().toString());  
               pps7.setString( 292,R59.getSelectedItem().toString());
               pps7.setDate( 293, sqldate);
               pps7.setString( 294, Student_class);
               pps7.setString( 295, Recieved_user_id);
               
                pps7.setString( 296, Sn60.getText().toString());  
               pps7.setString( 297,R60.getSelectedItem().toString());
               pps7.setDate( 298, sqldate);
               pps7.setString( 299, Student_class);
             pps7.setString( 300, Recieved_user_id);
               
                pps7.setString( 301, Sn61.getText().toString());  
               pps7.setString( 302,R61.getSelectedItem().toString());
               pps7.setDate( 303, sqldate);
               pps7.setString( 304, Student_class);
               pps7.setString( 305, Recieved_user_id);     
               
               pps7.setString( 306, Sn62.getText().toString());  
               pps7.setString( 307,R62.getSelectedItem().toString());
               pps7.setDate( 308, sqldate);
               pps7.setString( 309, Student_class);
             pps7.setString( 310, Recieved_user_id);
               
               pps7.setString( 311, Sn63.getText().toString()); 
               pps7.setString( 312,R63.getSelectedItem().toString());
               pps7.setDate( 313, sqldate);
               pps7.setString( 314, Student_class);
             pps7.setString( 315, Recieved_user_id);
             
             
              pps7.setString( 316, Sn64.getText().toString());  
               pps7.setString( 317,R64.getSelectedItem().toString());
               pps7.setDate( 318, sqldate);
               pps7.setString( 319, Student_class);
             pps7.setString( 320, Recieved_user_id);
               
               pps7.setString( 321, Sn65.getText().toString());  
               pps7.setString( 322,R65.getSelectedItem().toString());
               pps7.setDate( 323, sqldate);
               pps7.setString( 324, Student_class);
             pps7.setString( 325, Recieved_user_id);
               
               pps7.setString( 326, Sn66.getText().toString()); 
               pps7.setString( 327,R66.getSelectedItem().toString());
               pps7.setDate( 328, sqldate);
               pps7.setString( 329, Student_class);
             pps7.setString( 330, Recieved_user_id);
               
               
               
                pps7.setString(331 , Sn67.getText().toString());  
               pps7.setString(332 ,R67.getSelectedItem().toString());
               pps7.setDate( 333, sqldate);
               pps7.setString( 334, Student_class);
             pps7.setString( 335, Recieved_user_id);
               
                pps7.setString( 336, Sn68.getText().toString());  
               pps7.setString( 337,R68.getSelectedItem().toString());
               pps7.setDate( 338, sqldate);
               pps7.setString( 339, Student_class);
               pps7.setString( 340, Recieved_user_id);
               
                pps7.setString( 341, Sn69.getText().toString());  
               pps7.setString( 342,R69.getSelectedItem().toString());
               pps7.setDate( 343, sqldate);
               pps7.setString( 344, Student_class);
             pps7.setString( 345, Recieved_user_id);
               
                pps7.setString( 346, Sn70.getText().toString());  
               pps7.setString( 347,R70.getSelectedItem().toString());
               pps7.setDate( 348, sqldate);
                pps7.setString( 349, Student_class);
              pps7.setString( 350, Recieved_user_id); 
               
                pps7.setString( 351, Sn71.getText().toString());  
               pps7.setString( 352,R71.getSelectedItem().toString());
               pps7.setDate( 353, sqldate);
               pps7.setString( 354, Student_class);
             pps7.setString( 355, Recieved_user_id);
               
                pps7.setString( 356, Sn72.getText().toString());  
               pps7.setString( 357,R72.getSelectedItem().toString());
               pps7.setDate( 358, sqldate);
               pps7.setString( 359, Student_class);
             pps7.setString( 360, Recieved_user_id);
             
                pps7.setString( 361, Sn73.getText().toString());  
               pps7.setString( 362,R73.getSelectedItem().toString());
               pps7.setDate( 363, sqldate);
               pps7.setString( 364, Student_class);
             pps7.setString( 365, Recieved_user_id);
               
                pps7.setString( 366, Sn74.getText().toString());  
               pps7.setString( 367,R74.getSelectedItem().toString());
               pps7.setDate( 368, sqldate);
               pps7.setString( 369, Student_class);
             pps7.setString( 370, Recieved_user_id);
               
                pps7.setString( 371, Sn75.getText().toString());  
               pps7.setString( 372,R75.getSelectedItem().toString());
               pps7.setDate( 373, sqldate);
               pps7.setString( 374, Student_class);
             pps7.setString( 375, Recieved_user_id);
               
                pps7.setString( 376, Sn76.getText().toString());  
               pps7.setString( 377,R76.getSelectedItem().toString());
               pps7.setDate( 378, sqldate);
               pps7.setString( 379, Student_class);
             pps7.setString( 380, Recieved_user_id);
               
             
             
             
             
             
             
             
              pps7.setString( 381, Sn77.getText().toString());  
               pps7.setString( 382,R77.getSelectedItem().toString());
               pps7.setDate( 383, sqldate);
               pps7.setString( 384, Student_class);
             pps7.setString( 385, Recieved_user_id);
               
                pps7.setString( 386, Sn78.getText().toString());  
               pps7.setString( 387,R78.getSelectedItem().toString());
               pps7.setDate( 388, sqldate);
               pps7.setString( 389, Student_class);
             pps7.setString( 390, Recieved_user_id);
               
                pps7.setString(391, Sn79.getText().toString());  
               pps7.setString(  392,R79.getSelectedItem().toString());
               pps7.setDate( 393, sqldate);
               pps7.setString(  394 , Student_class);
             pps7.setString( 395, Recieved_user_id);
               
                pps7.setString( 396, Sn80.getText().toString());  
               pps7.setString( 397,R80.getSelectedItem().toString());
               pps7.setDate(   398, sqldate);
               pps7.setString( 399, Student_class);
             pps7.setString( 400, Recieved_user_id);
               
                pps7.setString( 401, Sn81.getText().toString());  
               pps7.setString( 402,R81.getSelectedItem().toString());
               pps7.setDate( 403, sqldate);
               pps7.setString( 404, Student_class);
               pps7.setString( 405, Recieved_user_id);
               
               pps7.setString( 406, Sn82.getText().toString());  
               pps7.setString( 407,R82.getSelectedItem().toString());
               pps7.setDate( 408, sqldate);
               pps7.setString( 409, Student_class);
             pps7.setString( 410, Recieved_user_id);
               
               pps7.setString( 411, Sn83.getText().toString()); 
               pps7.setString( 412,R83.getSelectedItem().toString());
               pps7.setDate( 413, sqldate);
               pps7.setString( 414, Student_class);
             pps7.setString( 415, Recieved_user_id);
               
               pps7.setString( 416, Sn84.getText().toString());  
               pps7.setString( 417,R84.getSelectedItem().toString());
               pps7.setDate( 418, sqldate);
               pps7.setString( 419, Student_class);
             pps7.setString( 420, Recieved_user_id);
               
               pps7.setString( 421, Sn85.getText().toString());  
               pps7.setString( 422,R85.getSelectedItem().toString());
               pps7.setDate( 423, sqldate);
               pps7.setString( 424, Student_class);
               pps7.setString( 425, Recieved_user_id);
               
               pps7.setString( 426, Sn86.getText().toString()); 
               pps7.setString( 427,R86.getSelectedItem().toString());
               pps7.setDate( 428, sqldate);
               pps7.setString( 429, Student_class);
               pps7.setString( 430, Recieved_user_id);
               
               
               
               
                pps7.setString(431 , Sn87.getText().toString());  
               pps7.setString(432  ,R87.getSelectedItem().toString());
               pps7.setDate( 433, sqldate);
               
               pps7.setString( 434, Student_class);
               pps7.setString( 435, Recieved_user_id);
               
               pps7.setString( 436, Sn88.getText().toString());  
               pps7.setString( 437,R88.getSelectedItem().toString());
               pps7.setDate( 438, sqldate);
               pps7.setString( 439, Student_class);
             pps7.setString( 440 , Recieved_user_id);
               
               pps7.setString( 441, Sn89.getText().toString());  
               pps7.setString( 442,R89.getSelectedItem().toString());
               pps7.setDate( 443, sqldate);
               pps7.setString( 444, Student_class);
             pps7.setString( 445, Recieved_user_id);
               
               pps7.setString( 446, Sn90.getText().toString());  
               pps7.setString( 447,R90.getSelectedItem().toString());
               pps7.setDate( 448, sqldate);
                 pps7.setString( 449, Student_class);
             pps7.setString( 450, Recieved_user_id);     
               
                pps7.setString( 451, Sn91.getText().toString());  
                pps7.setString( 452,R91.getSelectedItem().toString());
                pps7.setDate( 453 , sqldate);
               pps7.setString( 454, Student_class);
             pps7.setString( 455, Recieved_user_id);
             
             
               pps7.setString( 456, Sn92.getText().toString());  
                pps7.setString( 457,R92.getSelectedItem().toString());
                pps7.setDate( 458, sqldate);
               pps7.setString( 459, Student_class);
                pps7.setString( 460, Recieved_user_id);
                
                pps7.setString( 461, Sn93.getText().toString());  
                pps7.setString( 462,R93.getSelectedItem().toString());
                pps7.setDate( 463 , sqldate);
               pps7.setString( 464, Student_class);
                pps7.setString( 465, Recieved_user_id);
                
                pps7.setString( 466, Sn94.getText().toString());  
               pps7.setString( 467,R94.getSelectedItem().toString());
               pps7.setDate( 468, sqldate);
               pps7.setString( 469, Student_class);
               pps7.setString( 470, Recieved_user_id);
               
                pps7.setString( 471, Sn95.getText().toString());  
               pps7.setString( 472,R95.getSelectedItem().toString());
               pps7.setDate( 473, sqldate);
               pps7.setString( 474, Student_class);
             pps7.setString( 475, Recieved_user_id);
               
                pps7.setString( 476, Sn96.getText().toString());  
               pps7.setString( 477,R96.getSelectedItem().toString());
               pps7.setDate( 478, sqldate);
               pps7.setString( 479, Student_class);
             pps7.setString( 480, Recieved_user_id);
               
                pps7.setString( 481, Sn97.getText().toString());  
               pps7.setString( 482,R97.getSelectedItem().toString());
               pps7.setDate( 483, sqldate);
               pps7.setString( 484, Student_class);
               pps7.setString( 485, Recieved_user_id);
               
                pps7.setString( 486, Sn98.getText().toString());  
               pps7.setString( 487,R98.getSelectedItem().toString());
               pps7.setDate( 488, sqldate);
               pps7.setString( 489, Student_class);
                pps7.setString( 490, Recieved_user_id);
             
                pps7.setString( 491, Sn99.getText().toString());  
               pps7.setString( 492,R99.getSelectedItem().toString());
               pps7.setDate( 493, sqldate);
               pps7.setString( 494 , Student_class);
               pps7.setString( 495, Recieved_user_id);
               
                pps7.setString( 496, Sn100.getText().toString());  
               pps7.setString( 497,R100.getSelectedItem().toString());
               pps7.setDate( 498, sqldate);
               pps7.setString( 499, Student_class);
               pps7.setString(500, Recieved_user_id);
               
                pps7.setString(501 , Sn101.getText().toString());  
               pps7.setString(502 ,R101.getSelectedItem().toString());
               pps7.setDate(503 , sqldate);
              pps7.setString(504 , Student_class);
             pps7.setString(505 , Recieved_user_id);
               
               pps7.setString(506 , Sn102.getText().toString());  
               pps7.setString(507 ,R102.getSelectedItem().toString());
               pps7.setDate(508 , sqldate);
               pps7.setString(509 , Student_class);
               pps7.setString(510 , Recieved_user_id);
               
              /*  pps7.setString(307 , Sn103.getText().toString()); 
               pps7.setString(308 ,R103.getSelectedItem().toString());
               pps7.setDate(309 , sqldate);
               
               pps7.setString(310 , Sn104.getText().toString());  
               pps7.setString(311 ,R104.getSelectedItem().toString());
               pps7.setDate(312 , sqldate);
               
               pps7.setString(313 , Sn105.getText().toString());  
               pps7.setString(314 ,R105.getSelectedItem().toString());
               pps7.setDate(315 , sqldate);
               
               pps7.setString(316 , Sn106.getText().toString()); 
               pps7.setString(317 ,R106.getSelectedItem().toString());
               pps7.setDate(318 , sqldate);*/
               
                pps7.executeUpdate();
                
                  JOptionPane.showMessageDialog(null, "REGISTER  MARKED");
                  clean_student_register();
            } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, ex);
            }
    
    
    }
    
    public void clean_student_register(){
    String de = " ";
     try {
            conn = DBConnection.getConnction();
            pps2 = conn.prepareStatement("DELETE FROM `student_register` WHERE full_name = ?");
            pps2.setString(1, de);
            pps2.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    ;
    
    }
    
  
    
    
    private void R20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_R20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_R20ActionPerformed

    private void jLabel42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseClicked
              this.dispose();
              Teacher_Home_Page.getObj().setVisible(true);
    }//GEN-LAST:event_jLabel42MouseClicked

    
    String Student_id = null;
    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
  if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
         try {   //item_name  like '%" + txt_search.getText() + "%'  OR item_number  like '%" + txt_search.getText() + "%'   OR  conditions  like '%" + txt_search.getText() + "%'  
     
        Date date = new Date();
            java.sql.Date sqldate = new java.sql.Date(date.getTime());
     
     
            conn = DBConnection.getConnction();
            pps7 = conn.prepareStatement("select * from student_register WHERE   full_name =?  AND day_time =? ");
            pps7.setString(1,jTextField1.getText().trim());
             pps7.setDate(2,sqldate);
            rs7 = pps7.executeQuery();
            if(rs7.next()){
             Student_id = rs7.getString("student_register_id");
             full_name.setText(rs7.getString("full_name"));
             jLabel4.setText(rs7.getString("attendency"));

                       
           }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
       }       
        
        
        
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        data_entry.hide();
        up_date.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
     getStudentInf();
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       updateStudentInf();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
       data_entry.setVisible(true);
        up_date.hide(); 
    }//GEN-LAST:event_jLabel3MouseClicked
  
    
      public void updateStudentInf(){
      
       try {
             conn = DBConnection.getConnction();
             pps7= conn.prepareStatement("UPDATE  student_register SET attendency=? WHERE student_register_id = ? ");
              pps7.setString(1 ,attaindace.getSelectedItem().toString().trim());
             pps7.setString(2 , Student_id );  
               pps7.executeUpdate();
               JOptionPane.showMessageDialog(null, "Sudent Attaindace updated");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
      
      }
    
    
    
    public void getStudentInf(){

 try {   //item_name  like '%" + txt_search.getText() + "%'  OR item_number  like '%" + txt_search.getText() + "%'   OR  conditions  like '%" + txt_search.getText() + "%'  
     
        Date date = new Date();
            java.sql.Date sqldate = new java.sql.Date(date.getTime());
     
     
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("select * from student_register WHERE   full_name  like '%" + jTextField1.getText() + "%'   AND day_time =? ");
            pps.setDate(1,sqldate);
            rs = pps.executeQuery();
            if(rs.next()){
             Student_id = rs.getString("student_register_id");
             full_name.setText(rs.getString("full_name"));
             jLabel4.setText(rs.getString("attendency"));

                       
           }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
}
    

    
     public static Teacher_Student_Register getObj() {  //public method for instance Restriction
        if (Obj == null) {
            Obj = new Teacher_Student_Register();
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
            java.util.logging.Logger.getLogger(Teacher_Student_Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Teacher_Student_Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Teacher_Student_Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Teacher_Student_Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Teacher_Student_Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackGround_layer1;
    private javax.swing.JComboBox R1;
    private javax.swing.JComboBox R10;
    private javax.swing.JComboBox R100;
    private javax.swing.JComboBox R101;
    private javax.swing.JComboBox R102;
    private javax.swing.JComboBox R11;
    private javax.swing.JComboBox R12;
    private javax.swing.JComboBox R13;
    private javax.swing.JComboBox R14;
    private javax.swing.JComboBox R15;
    private javax.swing.JComboBox R16;
    private javax.swing.JComboBox R17;
    private javax.swing.JComboBox R18;
    private javax.swing.JComboBox R19;
    private javax.swing.JComboBox R2;
    private javax.swing.JComboBox R20;
    private javax.swing.JComboBox R21;
    private javax.swing.JComboBox R22;
    private javax.swing.JComboBox R23;
    private javax.swing.JComboBox R24;
    private javax.swing.JComboBox R25;
    private javax.swing.JComboBox R26;
    private javax.swing.JComboBox R27;
    private javax.swing.JComboBox R28;
    private javax.swing.JComboBox R29;
    private javax.swing.JComboBox R3;
    private javax.swing.JComboBox R30;
    private javax.swing.JComboBox R31;
    private javax.swing.JComboBox R32;
    private javax.swing.JComboBox R33;
    private javax.swing.JComboBox R34;
    private javax.swing.JComboBox R35;
    private javax.swing.JComboBox R36;
    private javax.swing.JComboBox R37;
    private javax.swing.JComboBox R38;
    private javax.swing.JComboBox R39;
    private javax.swing.JComboBox R4;
    private javax.swing.JComboBox R40;
    private javax.swing.JComboBox R41;
    private javax.swing.JComboBox R42;
    private javax.swing.JComboBox R43;
    private javax.swing.JComboBox R44;
    private javax.swing.JComboBox R45;
    private javax.swing.JComboBox R46;
    private javax.swing.JComboBox R47;
    private javax.swing.JComboBox R48;
    private javax.swing.JComboBox R49;
    private javax.swing.JComboBox R5;
    private javax.swing.JComboBox R50;
    private javax.swing.JComboBox R51;
    private javax.swing.JComboBox R52;
    private javax.swing.JComboBox R53;
    private javax.swing.JComboBox R54;
    private javax.swing.JComboBox R55;
    private javax.swing.JComboBox R56;
    private javax.swing.JComboBox R57;
    private javax.swing.JComboBox R58;
    private javax.swing.JComboBox R59;
    private javax.swing.JComboBox R6;
    private javax.swing.JComboBox R60;
    private javax.swing.JComboBox R61;
    private javax.swing.JComboBox R62;
    private javax.swing.JComboBox R63;
    private javax.swing.JComboBox R64;
    private javax.swing.JComboBox R65;
    private javax.swing.JComboBox R66;
    private javax.swing.JComboBox R67;
    private javax.swing.JComboBox R68;
    private javax.swing.JComboBox R69;
    private javax.swing.JComboBox R7;
    private javax.swing.JComboBox R70;
    private javax.swing.JComboBox R71;
    private javax.swing.JComboBox R72;
    private javax.swing.JComboBox R73;
    private javax.swing.JComboBox R74;
    private javax.swing.JComboBox R75;
    private javax.swing.JComboBox R76;
    private javax.swing.JComboBox R77;
    private javax.swing.JComboBox R78;
    private javax.swing.JComboBox R79;
    private javax.swing.JComboBox R8;
    private javax.swing.JComboBox R80;
    private javax.swing.JComboBox R81;
    private javax.swing.JComboBox R82;
    private javax.swing.JComboBox R83;
    private javax.swing.JComboBox R84;
    private javax.swing.JComboBox R85;
    private javax.swing.JComboBox R86;
    private javax.swing.JComboBox R87;
    private javax.swing.JComboBox R88;
    private javax.swing.JComboBox R89;
    private javax.swing.JComboBox R9;
    private javax.swing.JComboBox R90;
    private javax.swing.JComboBox R91;
    private javax.swing.JComboBox R92;
    private javax.swing.JComboBox R93;
    private javax.swing.JComboBox R94;
    private javax.swing.JComboBox R95;
    private javax.swing.JComboBox R96;
    private javax.swing.JComboBox R97;
    private javax.swing.JComboBox R98;
    private javax.swing.JComboBox R99;
    private javax.swing.JLabel Sn1;
    private javax.swing.JLabel Sn10;
    private javax.swing.JLabel Sn100;
    private javax.swing.JLabel Sn101;
    private javax.swing.JLabel Sn102;
    private javax.swing.JLabel Sn11;
    private javax.swing.JLabel Sn12;
    private javax.swing.JLabel Sn13;
    private javax.swing.JLabel Sn14;
    private javax.swing.JLabel Sn15;
    private javax.swing.JLabel Sn16;
    private javax.swing.JLabel Sn17;
    private javax.swing.JLabel Sn18;
    private javax.swing.JLabel Sn19;
    private javax.swing.JLabel Sn2;
    private javax.swing.JLabel Sn20;
    private javax.swing.JLabel Sn21;
    private javax.swing.JLabel Sn22;
    private javax.swing.JLabel Sn23;
    private javax.swing.JLabel Sn24;
    private javax.swing.JLabel Sn25;
    private javax.swing.JLabel Sn26;
    private javax.swing.JLabel Sn27;
    private javax.swing.JLabel Sn28;
    private javax.swing.JLabel Sn29;
    private javax.swing.JLabel Sn3;
    private javax.swing.JLabel Sn30;
    private javax.swing.JLabel Sn31;
    private javax.swing.JLabel Sn32;
    private javax.swing.JLabel Sn33;
    private javax.swing.JLabel Sn34;
    private javax.swing.JLabel Sn35;
    private javax.swing.JLabel Sn36;
    private javax.swing.JLabel Sn37;
    private javax.swing.JLabel Sn38;
    private javax.swing.JLabel Sn39;
    private javax.swing.JLabel Sn4;
    private javax.swing.JLabel Sn40;
    private javax.swing.JLabel Sn41;
    private javax.swing.JLabel Sn42;
    private javax.swing.JLabel Sn43;
    private javax.swing.JLabel Sn44;
    private javax.swing.JLabel Sn45;
    private javax.swing.JLabel Sn46;
    private javax.swing.JLabel Sn47;
    private javax.swing.JLabel Sn48;
    private javax.swing.JLabel Sn49;
    private javax.swing.JLabel Sn5;
    private javax.swing.JLabel Sn50;
    private javax.swing.JLabel Sn51;
    private javax.swing.JLabel Sn52;
    private javax.swing.JLabel Sn53;
    private javax.swing.JLabel Sn54;
    private javax.swing.JLabel Sn55;
    private javax.swing.JLabel Sn56;
    private javax.swing.JLabel Sn57;
    private javax.swing.JLabel Sn58;
    private javax.swing.JLabel Sn59;
    private javax.swing.JLabel Sn6;
    private javax.swing.JLabel Sn60;
    private javax.swing.JLabel Sn61;
    private javax.swing.JLabel Sn62;
    private javax.swing.JLabel Sn63;
    private javax.swing.JLabel Sn64;
    private javax.swing.JLabel Sn65;
    private javax.swing.JLabel Sn66;
    private javax.swing.JLabel Sn67;
    private javax.swing.JLabel Sn68;
    private javax.swing.JLabel Sn69;
    private javax.swing.JLabel Sn7;
    private javax.swing.JLabel Sn70;
    private javax.swing.JLabel Sn71;
    private javax.swing.JLabel Sn72;
    private javax.swing.JLabel Sn73;
    private javax.swing.JLabel Sn74;
    private javax.swing.JLabel Sn75;
    private javax.swing.JLabel Sn76;
    private javax.swing.JLabel Sn77;
    private javax.swing.JLabel Sn78;
    private javax.swing.JLabel Sn79;
    private javax.swing.JLabel Sn8;
    private javax.swing.JLabel Sn80;
    private javax.swing.JLabel Sn81;
    private javax.swing.JLabel Sn82;
    private javax.swing.JLabel Sn83;
    private javax.swing.JLabel Sn84;
    private javax.swing.JLabel Sn85;
    private javax.swing.JLabel Sn86;
    private javax.swing.JLabel Sn87;
    private javax.swing.JLabel Sn88;
    private javax.swing.JLabel Sn89;
    private javax.swing.JLabel Sn9;
    private javax.swing.JLabel Sn90;
    private javax.swing.JLabel Sn91;
    private javax.swing.JLabel Sn92;
    private javax.swing.JLabel Sn93;
    private javax.swing.JLabel Sn94;
    private javax.swing.JLabel Sn95;
    private javax.swing.JLabel Sn96;
    private javax.swing.JLabel Sn97;
    private javax.swing.JLabel Sn98;
    private javax.swing.JLabel Sn99;
    private javax.swing.JPanel Tex_manager_lb;
    private javax.swing.JPanel admin_btn;
    private javax.swing.JComboBox attaindace;
    private javax.swing.JPanel data_entry;
    private javax.swing.JLabel exit_lb;
    private javax.swing.JPanel frontSide_btn_holder;
    private javax.swing.JLabel full_name;
    private javax.swing.JLabel header;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel main_container;
    private javax.swing.JLabel minize_lb;
    private javax.swing.JLabel model;
    private javax.swing.JPanel right;
    private javax.swing.JPanel up_date;
    // End of variables declaration//GEN-END:variables
}
