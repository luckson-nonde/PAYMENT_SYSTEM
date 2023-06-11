package hotel.management;

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import sun.misc.FloatingDecimal;

public class Teacher_Student_Data_Entry extends javax.swing.JFrame {

      Connection conn = null;
      PreparedStatement pps, pps1, pps2, pps3, pps4, pps6,        pps5, pps7, pps8, pps9, pps10, pps11, pps12 ,pps13 = null;
      ResultSet rs, rs1, rs2, rs3, rs4, rs5, rs6,                  rs7, rs8, rs9, rs10, rs11, rs12 ,rs13= null;


  String p1  ,p2, p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,p21,p22,p23,p24,p25,p26,p27,p28,p29,p30,p31,p32,p33,p34,p35,p36,p37,p38 ,p39,p40,p41,p42,p43,p44,p45,p46,p47,p48,p49,p50,p51,p52,p53,p54,p55,p56,p57,p58,p59,p60,p61,p62,p63,p64,p65,p66,p67,p68,p69,p70,p71,p72,p73,p74,p75,p76,p77,p78,p79,p80,p81,p82,p83,p84,p85,p86,p87,p88,p89,p90,p91,p92,p93,p94,p95,p96,p97,p98,p99,p100                ;

     
    //user access
    private static String Recieved_user_id = null;
    private static String usertype = null;
    //passing user id
    private static Teacher_Student_Data_Entry Obj = null;
    String passed_user_id;
     
String class_teacher_class = null;
    
            int xx = 0;
            int yy = 0;
            String Search_EmployeeID = null;

        Teacher_Student_Data_Entry() {
        initComponents();
        txtResourceForDateFormatingINtoString.hide();
        this.setBackground(new Color(0, 0, 0, 0));
         myClass();
       
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
         String  Student_class = null;
    public void myClass(){
        try {
            conn = DBConnection.getConnction();
            pps1 = conn.prepareStatement("SELECT * FROM classes");
            rs1 = pps1.executeQuery();
            while(rs1.next()){
              showclasses.addItem(rs1.getString("grade_room"));
              Student_class = rs1.getString("grade_room");
            }
        } catch (SQLException ex) { JOptionPane.showMessageDialog(null, ex);}
        
        
    }
    
      public void infoicon(){
                    try {conn = DBConnection.getConnction();
                    pps6 = conn.prepareStatement(" SELECT  * FROM  access WHERE access_id =?");
                    pps6.setString(1,Recieved_user_id.trim()); 
                    rs6 = pps6.executeQuery();
                  while(rs6.next()){
                 String fname=  rs6.getString("first_name");
                 String lname=  rs6.getString("last_name");
                 jLabel37.setText("Hi !"+fname +"  "+lname + "  Welcome Results Entry");
                 model.setText(rs6.getString("user"));
                 System_ID.setText(Recieved_user_id);
                  jLabel12.setText(fname  +"  "+ lname );
                }
                } catch (SQLException ex) { Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex); }
       
       
               
             try {  //GETTING AN EMPLOYEE NAME AND ID JOINT WITH THE HANDLING CLASS
            conn = DBConnection.getConnction();
            String sql = " SELECT employee.name, employee.user_login_id, classes.grade_room FROM employee INNER JOIN class_subject_joint ON employee.user_login_id = class_subject_joint.user_login_id INNER JOIN classes ON class_subject_joint.class_id = classes.class_id WHERE class_subject_joint.user_login_id = ? AND teacher_state = \"Class Teacher\"";
            pps5 = conn.prepareStatement(sql);
            pps5.setString(1, Recieved_user_id);
            rs5 = pps5.executeQuery();
            if(rs5.next()){
             class_teacher_class = rs5.getString("grade_room");
            }
            } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
       
       
           Toshow_all_student_fromeONE_Class();
           Toshow_all_subject_fromeONE_Class();
    }
    
     public void Toshow_all_subject_fromeONE_Class(){   
       
        try {
             conn = DBConnection.getConnction();
             String sql = "SELECT subjects.subject_name FROM subjects JOIN class_subject_joint ON subjects.subject_id = class_subject_joint.subject_id INNER JOIN classes ON classes.class_id = class_subject_joint.class_id WHERE grade_room = ? "; //
                pps2 = conn.prepareStatement(sql);
                pps2.setString(1, class_teacher_class);
               
                rs2 = pps2.executeQuery();
             while(rs2.next()){
              showsubjects.addItem(rs2.getString("subject_name"));
             }
               
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
     }
     

       public void Toshow_all_student_fromeONE_Class(){
           
             Date date = new Date();
             java.sql.Date sqldate = new java.sql.Date(date.getTime());
           
           String timeLate = "Late";
           String timePresent = "Present";

           //USING THE CLASS THE TEACHERS HANDLS TO CALL ALL STUDENTS IN THAT CLASS   student_register
           try {conn = DBConnection.getConnction();
            pps4= conn.prepareStatement("SELECT  * FROM  student_register WHERE (Class =? AND day_time =?) AND (attendency =? ||  attendency =? ) ");
            pps4.setString(1,class_teacher_class.trim()); 
             pps4.setDate(2,sqldate); 
             pps4.setString(3,timeLate);
             pps4.setString(4,timePresent);
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
                     
                    pps4.close();
                    rs4.close();
                    conn.close();
                    
                }
            
            
            
                     //  
            
            
            } catch (SQLException ex) {   }
           
           
              String username =  Sn1.getText().trim();
              if(username.equals("")){
                   JOptionPane.showMessageDialog(null, "Un-Marked Register,  NOTE: Only Students With Results Will be Marked Present For That Day ");
                 Toshow_all_studentFrm_Studentist_AfterNt_fund_inTherRegister();
              }
              
            
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
        building_classes_panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
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
        R5 = new javax.swing.JTextField();
        R1 = new javax.swing.JTextField();
        R2 = new javax.swing.JTextField();
        R3 = new javax.swing.JTextField();
        R4 = new javax.swing.JTextField();
        R6 = new javax.swing.JTextField();
        R7 = new javax.swing.JTextField();
        R8 = new javax.swing.JTextField();
        R9 = new javax.swing.JTextField();
        R10 = new javax.swing.JTextField();
        R11 = new javax.swing.JTextField();
        R12 = new javax.swing.JTextField();
        R13 = new javax.swing.JTextField();
        R14 = new javax.swing.JTextField();
        R15 = new javax.swing.JTextField();
        R16 = new javax.swing.JTextField();
        R17 = new javax.swing.JTextField();
        R18 = new javax.swing.JTextField();
        R19 = new javax.swing.JTextField();
        R20 = new javax.swing.JTextField();
        R21 = new javax.swing.JTextField();
        R22 = new javax.swing.JTextField();
        R24 = new javax.swing.JTextField();
        R25 = new javax.swing.JTextField();
        R26 = new javax.swing.JTextField();
        R30 = new javax.swing.JTextField();
        R33 = new javax.swing.JTextField();
        R28 = new javax.swing.JTextField();
        R34 = new javax.swing.JTextField();
        R31 = new javax.swing.JTextField();
        R38 = new javax.swing.JTextField();
        R29 = new javax.swing.JTextField();
        R27 = new javax.swing.JTextField();
        R35 = new javax.swing.JTextField();
        R37 = new javax.swing.JTextField();
        R39 = new javax.swing.JTextField();
        R36 = new javax.swing.JTextField();
        R32 = new javax.swing.JTextField();
        R48 = new javax.swing.JTextField();
        R51 = new javax.swing.JTextField();
        R41 = new javax.swing.JTextField();
        R45 = new javax.swing.JTextField();
        R50 = new javax.swing.JTextField();
        R49 = new javax.swing.JTextField();
        R42 = new javax.swing.JTextField();
        R43 = new javax.swing.JTextField();
        R44 = new javax.swing.JTextField();
        R46 = new javax.swing.JTextField();
        R40 = new javax.swing.JTextField();
        R47 = new javax.swing.JTextField();
        R52 = new javax.swing.JTextField();
        R53 = new javax.swing.JTextField();
        R54 = new javax.swing.JTextField();
        R55 = new javax.swing.JTextField();
        R56 = new javax.swing.JTextField();
        R57 = new javax.swing.JTextField();
        R58 = new javax.swing.JTextField();
        R59 = new javax.swing.JTextField();
        R60 = new javax.swing.JTextField();
        R61 = new javax.swing.JTextField();
        R62 = new javax.swing.JTextField();
        R63 = new javax.swing.JTextField();
        R64 = new javax.swing.JTextField();
        R65 = new javax.swing.JTextField();
        R66 = new javax.swing.JTextField();
        R67 = new javax.swing.JTextField();
        R68 = new javax.swing.JTextField();
        R69 = new javax.swing.JTextField();
        R70 = new javax.swing.JTextField();
        R71 = new javax.swing.JTextField();
        R72 = new javax.swing.JTextField();
        R73 = new javax.swing.JTextField();
        R74 = new javax.swing.JTextField();
        R75 = new javax.swing.JTextField();
        R76 = new javax.swing.JTextField();
        R77 = new javax.swing.JTextField();
        R78 = new javax.swing.JTextField();
        R79 = new javax.swing.JTextField();
        R80 = new javax.swing.JTextField();
        R81 = new javax.swing.JTextField();
        R82 = new javax.swing.JTextField();
        R83 = new javax.swing.JTextField();
        R84 = new javax.swing.JTextField();
        R85 = new javax.swing.JTextField();
        R86 = new javax.swing.JTextField();
        R87 = new javax.swing.JTextField();
        R88 = new javax.swing.JTextField();
        R89 = new javax.swing.JTextField();
        R90 = new javax.swing.JTextField();
        R91 = new javax.swing.JTextField();
        R92 = new javax.swing.JTextField();
        R93 = new javax.swing.JTextField();
        R94 = new javax.swing.JTextField();
        R95 = new javax.swing.JTextField();
        R96 = new javax.swing.JTextField();
        R97 = new javax.swing.JTextField();
        R102 = new javax.swing.JTextField();
        R101 = new javax.swing.JTextField();
        R100 = new javax.swing.JTextField();
        R99 = new javax.swing.JTextField();
        R98 = new javax.swing.JTextField();
        R23 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Save_results_info = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        M_Data_Chosen = new javax.swing.JTextField();
        total_marks = new javax.swing.JTextField();
        showsubjects = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        percentage = new javax.swing.JLabel();
        showclasses = new javax.swing.JComboBox();
        View_subject_inThat_ciass = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        System_ID = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        txtResourceForDateFormatingINtoString = new javax.swing.JTextField();
        Term_chooser = new javax.swing.JComboBox();
        Term_mode_chooser = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
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
        right.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(right, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 760, 1380, 60));

        building_classes_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel3.add(Sn52, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 240, 30));

        Sn53.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn53.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn53, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 240, 30));

        Sn54.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn54.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn54, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 240, 30));

        Sn55.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn55.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn55, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 240, 30));

        Sn56.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn56.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn56, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 240, 30));

        Sn57.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn57.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn57, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 240, 30));

        Sn58.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn58.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn58, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, 240, 30));

        Sn59.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn59.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn59, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 360, 240, 30));

        Sn60.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn60.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn60, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, 240, 30));

        Sn61.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn61.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn61, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 460, 240, 30));

        Sn62.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn62.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn62, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 510, 240, 30));

        Sn63.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn63.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn63, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 560, 240, 30));

        Sn64.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn64.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn64, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 610, 240, 30));

        Sn65.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn65.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn65, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 650, 240, 30));

        Sn66.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn66.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn66, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 710, 240, 30));

        Sn67.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn67.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn67, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 760, 240, 30));

        Sn68.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn68.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn68, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 810, 240, 30));

        Sn69.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn69.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn69, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 860, 240, 30));

        Sn70.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn70.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn70, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 910, 240, 30));

        Sn71.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn71.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn71, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 960, 240, 30));

        Sn72.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn72.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn72, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 1010, 240, 30));

        Sn73.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn73.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn73, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 1060, 240, 30));

        Sn74.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn74.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn74, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 1110, 240, 30));

        Sn75.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn75.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn75, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 1160, 240, 30));

        Sn76.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn76.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn76, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 1210, 240, 30));

        Sn77.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn77.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn77, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 1260, 240, 30));

        Sn78.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn78.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn78, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 1310, 240, 30));

        Sn79.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn79.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn79, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 1360, 240, 30));

        Sn80.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn80.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn80, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 1410, 240, 30));

        Sn81.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn81.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn81, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 1460, 240, 30));

        Sn82.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn82.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn82, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 1510, 240, 30));

        Sn83.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn83.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn83, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 1560, 240, 30));

        Sn84.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn84.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn84, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 1610, 240, 30));

        Sn85.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn85.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn85, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 1660, 240, 30));

        Sn86.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn86.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn86, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 1710, 240, 30));

        Sn87.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn87.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn87, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 1760, 240, 30));

        Sn88.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn88.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn88, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 1810, 240, 30));

        Sn89.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn89.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn89, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 1860, 240, 30));

        Sn90.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn90.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn90, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 1910, 240, 30));

        Sn91.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn91.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn91, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 1960, 240, 30));

        Sn92.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn92.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn92, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 2010, 240, 30));

        Sn93.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn93.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn93, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 2060, 240, 30));

        Sn94.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn94.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn94, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 2110, 240, 30));

        Sn95.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn95.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn95, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 2160, 240, 30));

        Sn96.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn96.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn96, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 2210, 240, 30));

        Sn97.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn97.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn97, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 2260, 240, 30));

        Sn98.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn98.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn98, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 2310, 240, 30));

        Sn102.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn102.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn102, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 2510, 240, 30));

        Sn99.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn99.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn99, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 2360, 240, 30));

        Sn100.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn100.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn100, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 2410, 240, 30));

        Sn101.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn101.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn101, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 2460, 240, 30));

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
        jPanel3.add(Sn20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 970, 240, 30));

        Sn21.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn21.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1010, 240, 30));

        Sn22.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn22.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1060, 240, 30));

        Sn23.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn23.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1110, 240, 30));

        Sn24.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        Sn24.setForeground(new java.awt.Color(153, 153, 153));
        jPanel3.add(Sn24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 1160, 240, 30));

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
        jPanel3.add(R5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 90, 30));

        R1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                R1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                R1KeyTyped(evt);
            }
        });
        jPanel3.add(R1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 90, 30));

        R2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                R2KeyPressed(evt);
            }
        });
        jPanel3.add(R2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 90, 30));

        R3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                R3KeyPressed(evt);
            }
        });
        jPanel3.add(R3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 90, 30));
        jPanel3.add(R4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 90, 30));
        jPanel3.add(R6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 90, 30));
        jPanel3.add(R7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 90, 30));
        jPanel3.add(R8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, 90, 30));
        jPanel3.add(R9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, 90, 30));
        jPanel3.add(R10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 460, 90, 30));
        jPanel3.add(R11, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 510, 90, 30));
        jPanel3.add(R12, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 560, 90, 30));
        jPanel3.add(R13, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 610, 90, 30));
        jPanel3.add(R14, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 660, 90, 30));
        jPanel3.add(R15, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 710, 90, 30));
        jPanel3.add(R16, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 760, 90, 30));
        jPanel3.add(R17, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 810, 90, 30));
        jPanel3.add(R18, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 860, 90, 30));
        jPanel3.add(R19, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 910, 90, 30));
        jPanel3.add(R20, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 960, 90, 30));
        jPanel3.add(R21, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1010, 90, 30));
        jPanel3.add(R22, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1060, 90, 30));
        jPanel3.add(R24, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1160, 90, 30));
        jPanel3.add(R25, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1210, 90, 30));
        jPanel3.add(R26, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1260, 90, 30));
        jPanel3.add(R30, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1460, 90, 30));
        jPanel3.add(R33, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1610, 90, 30));
        jPanel3.add(R28, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1360, 90, 30));
        jPanel3.add(R34, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1660, 90, 30));
        jPanel3.add(R31, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1510, 90, 30));
        jPanel3.add(R38, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1860, 90, 30));
        jPanel3.add(R29, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1410, 90, 30));
        jPanel3.add(R27, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1310, 90, 30));
        jPanel3.add(R35, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1710, 90, 30));
        jPanel3.add(R37, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1810, 90, 30));
        jPanel3.add(R39, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1910, 90, 30));
        jPanel3.add(R36, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1760, 90, 30));
        jPanel3.add(R32, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1560, 90, 30));
        jPanel3.add(R48, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 2360, 90, 30));
        jPanel3.add(R51, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 2510, 90, 30));
        jPanel3.add(R41, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 2010, 90, 30));
        jPanel3.add(R45, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 2210, 90, 30));
        jPanel3.add(R50, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 2460, 90, 30));
        jPanel3.add(R49, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 2410, 90, 30));
        jPanel3.add(R42, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 2060, 90, 30));
        jPanel3.add(R43, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 2110, 90, 30));
        jPanel3.add(R44, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 2160, 90, 30));
        jPanel3.add(R46, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 2260, 90, 30));
        jPanel3.add(R40, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1960, 90, 30));
        jPanel3.add(R47, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 2310, 90, 30));
        jPanel3.add(R52, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 90, 30));
        jPanel3.add(R53, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, 90, 30));
        jPanel3.add(R54, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, 90, 30));
        jPanel3.add(R55, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, 90, 30));
        jPanel3.add(R56, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 210, 90, 30));
        jPanel3.add(R57, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 260, 90, 30));
        jPanel3.add(R58, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 310, 90, 30));
        jPanel3.add(R59, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 360, 90, 30));
        jPanel3.add(R60, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 410, 90, 30));
        jPanel3.add(R61, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 460, 90, 30));
        jPanel3.add(R62, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 510, 90, 30));
        jPanel3.add(R63, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 560, 90, 30));
        jPanel3.add(R64, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 610, 90, 30));
        jPanel3.add(R65, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 660, 90, 30));
        jPanel3.add(R66, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 710, 90, 30));
        jPanel3.add(R67, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 760, 90, 30));
        jPanel3.add(R68, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 810, 90, 30));
        jPanel3.add(R69, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 860, 90, 30));
        jPanel3.add(R70, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 910, 90, 30));
        jPanel3.add(R71, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 960, 90, 30));
        jPanel3.add(R72, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 1010, 90, 30));
        jPanel3.add(R73, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 1060, 90, 30));
        jPanel3.add(R74, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 1110, 90, 30));
        jPanel3.add(R75, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 1160, 90, 30));
        jPanel3.add(R76, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 1210, 90, 30));
        jPanel3.add(R77, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 1260, 90, 30));
        jPanel3.add(R78, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 1310, 90, 30));
        jPanel3.add(R79, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 1360, 90, 30));
        jPanel3.add(R80, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 1410, 90, 30));
        jPanel3.add(R81, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 1460, 90, 30));
        jPanel3.add(R82, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 1510, 90, 30));
        jPanel3.add(R83, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 1560, 90, 30));
        jPanel3.add(R84, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 1610, 90, 30));
        jPanel3.add(R85, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 1660, 90, 30));
        jPanel3.add(R86, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 1710, 90, 30));
        jPanel3.add(R87, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 1760, 90, 30));
        jPanel3.add(R88, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 1810, 90, 30));
        jPanel3.add(R89, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 1860, 90, 30));
        jPanel3.add(R90, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 1910, 90, 30));
        jPanel3.add(R91, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 1960, 90, 30));
        jPanel3.add(R92, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 2010, 90, 30));
        jPanel3.add(R93, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 2060, 90, 30));
        jPanel3.add(R94, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 2110, 90, 30));
        jPanel3.add(R95, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 2160, 90, 30));
        jPanel3.add(R96, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 2210, 90, 30));
        jPanel3.add(R97, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 2260, 90, 30));
        jPanel3.add(R102, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 2510, 90, 30));
        jPanel3.add(R101, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 2460, 90, 30));
        jPanel3.add(R100, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 2410, 90, 30));
        jPanel3.add(R99, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 2360, 90, 30));
        jPanel3.add(R98, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 2310, 90, 30));
        jPanel3.add(R23, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 1110, 90, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 2700));

        jScrollPane1.setViewportView(jPanel2);

        building_classes_panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 720));
        building_classes_panel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 80, 210, 20));

        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Exam Date");
        building_classes_panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 190, 60, 30));

        jButton1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 153, 153));
        jButton1.setText("Revert");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        building_classes_panel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 100, 80, -1));

        Save_results_info.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        Save_results_info.setForeground(new java.awt.Color(153, 153, 153));
        Save_results_info.setText("Submit Resuits");
        Save_results_info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Save_results_infoActionPerformed(evt);
            }
        });
        building_classes_panel.add(Save_results_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 630, 120, 30));

        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("MUITIPE TRIGER");
        building_classes_panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 30, 140, 40));
        building_classes_panel.add(M_Data_Chosen, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 100, 140, -1));
        building_classes_panel.add(total_marks, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 150, 140, -1));

        showsubjects.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        showsubjects.setForeground(new java.awt.Color(153, 153, 153));
        building_classes_panel.add(showsubjects, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 500, 140, -1));

        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Press Mark Register to save the informatin");
        building_classes_panel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 580, 240, 40));

        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Total Marks");
        building_classes_panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 140, 80, 40));

        percentage.setForeground(new java.awt.Color(153, 153, 153));
        percentage.setText("System ID");
        building_classes_panel.add(percentage, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 340, 80, 20));

        showclasses.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        showclasses.setForeground(new java.awt.Color(153, 153, 153));
        showclasses.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select A Class" }));
        building_classes_panel.add(showclasses, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 450, 130, -1));

        View_subject_inThat_ciass.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        View_subject_inThat_ciass.setForeground(new java.awt.Color(153, 153, 153));
        View_subject_inThat_ciass.setText("View Subjects");
        View_subject_inThat_ciass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                View_subject_inThat_ciassActionPerformed(evt);
            }
        });
        building_classes_panel.add(View_subject_inThat_ciass, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 450, -1, -1));

        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Subjects");
        building_classes_panel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 500, 80, 20));

        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Class Teacher");
        building_classes_panel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 270, 80, 20));

        System_ID.setForeground(new java.awt.Color(153, 153, 153));
        System_ID.setText("Subjects");
        building_classes_panel.add(System_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 300, 180, 20));

        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("Subjects");
        building_classes_panel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 270, 60, 20));

        jDateChooser1.setBackground(new Color(225,225,225,2));
        jDateChooser1.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(225,225,225,2)));
        building_classes_panel.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 190, 150, 30));
        building_classes_panel.add(txtResourceForDateFormatingINtoString, new org.netbeans.lib.awtextra.AbsoluteConstraints(869, 10, 240, 0));

        Term_chooser.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        Term_chooser.setForeground(new java.awt.Color(153, 153, 153));
        Term_chooser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "First Term", "Second Term", "Third Term", "Final", "Mid Term" }));
        building_classes_panel.add(Term_chooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 390, 130, -1));

        Term_mode_chooser.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        Term_mode_chooser.setForeground(new java.awt.Color(153, 153, 153));
        Term_mode_chooser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Quiz", "Test", "Exam", "" }));
        building_classes_panel.add(Term_mode_chooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 390, 110, -1));

        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("System ID");
        building_classes_panel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 300, 80, 20));

        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("System ID");
        building_classes_panel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 340, 80, 20));

        jPanel1.add(building_classes_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 1130, 710));

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
        admin_btn.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, -6, 160, 50));

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
          //  jComboBox1.getSelectedItem().toString()
         String Action =  M_Data_Chosen.getText();
          R1.setText(Action);
        
     R10.setText(Action);
   R100.setText(Action);
    R101.setText(Action);
     R102.setText(Action);
    R11.setText(Action);
     R12.setText(Action);
    R13.setText(Action);
     R14.setText(Action);
    R15.setText(Action);
     R16.setText(Action);
    R17.setText(Action);
     R18.setText(Action);
     R19.setText(Action);
     R2.setText(Action);
     R20.setText(Action);
    R21.setText(Action);
     R22.setText(Action);
    R23.setText(Action);
   R24.setText(Action);
    R25.setText(Action);
    R26.setText(Action);
    R27.setText(Action);
    R28.setText(Action);
    R29.setText(Action);
     R3.setText(Action);
   R30.setText(Action);
    R31.setText(Action);
     R32.setText(Action);
     R33.setText(Action);
    R34.setText(Action);
     R35.setText(Action);
    R36.setText(Action);
     R37.setText(Action);
     R38.setText(Action);
   R39.setText(Action);
     R4.setText(Action);
     R40.setText(Action);
    R41.setText(Action);
     R42.setText(Action);
    R43.setText(Action);
    R44.setText(Action);
   R45.setText(Action);
    R46.setText(Action);
    R47.setText(Action);
    R48.setText(Action);
     R49.setText(Action);
    R5.setText(Action);
     R50.setText(Action);
     R51.setText(Action);
   R52.setText(Action);
    R53.setText(Action);
     R54.setText(Action);
    R55.setText(Action);
     R56.setText(Action);
     R57.setText(Action);
     R58.setText(Action);
     R59.setText(Action);
     R6.setText(Action);
     R60.setText(Action);
     R61.setText(Action);
     R62.setText(Action);
     R63.setText(Action);
    R64.setText(Action);
    R65.setText(Action);
    R66.setText(Action);
    R67.setText(Action);
     R68.setText(Action);
     R69.setText(Action);
     R7.setText(Action);
     R70.setText(Action);
     R71.setText(Action);
     R72.setText(Action);
     R73.setText(Action);
    R74.setText(Action);
    R75.setText(Action);
     R76.setText(Action);
    R77.setText(Action);
     R78.setText(Action);
   R79.setText(Action);
     R8.setText(Action);
    R80.setText(Action);
     R82.setText(Action);
    R83.setText(Action);
    R84.setText(Action);
    R85.setText(Action);
    R86.setText(Action);
     R87.setText(Action);
     R88.setText(Action);
     R89.setText(Action);
     R9.setText(Action);
     R90.setText(Action);
     R91.setText(Action);
     R92.setText(Action);
     R93.setText(Action);
     R94.setText(Action);
     R95.setText(Action);
     R96.setText(Action);
    R97.setText(Action);
    R98.setText(Action);
    R99.setText(Action); 
    R100.setText(Action); 
    R101.setText(Action); 
    R102.setText(Action);
    R81.setText(Action);
    }//GEN-LAST:event_jButton1ActionPerformed

    
    String subject_teacher_id = null;
    
    private void Save_results_infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Save_results_infoActionPerformed
                 
        
        String dateSelected = ((JTextField) jDateChooser1.getDateEditor().getUiComponent()).getText();//conveting date to string then putting it on a resource
        txtResourceForDateFormatingINtoString.setText(dateSelected);
        
        if(total_marks.getText().isEmpty()){
         JOptionPane.showMessageDialog(null, "Enter Percentage");
         total_marks.requestFocus();
       }else  if (txtResourceForDateFormatingINtoString.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Date of Results Entry Is required !");
            jDateChooser1.requestFocus();
      
       
       }else{
           
           
                        //marking 
        
               
           
           
           
         checking_ifTheRegisterWasMarked();
          
       }
       
           
    }//GEN-LAST:event_Save_results_infoActionPerformed

    public void checking_ifTheRegisterWasMarked(){
              //checking if the register hasnt been marked
        try {
            
                 Date date = jDateChooser1.getDate();    
                java.sql.Date sqldate = new java.sql.Date(date.getTime());
                conn = DBConnection.getConnction();
                pps9 = conn.prepareStatement("SELECT  * FROM  student_register WHERE day_time = ? AND Class = ?");
                pps9.setDate(1, sqldate); 
                pps9.setString(2, class_teacher_class); 
                rs9 = pps9.executeQuery();
            if (rs9.next()) { insert_results();  }else{ insert_results_afterREGISTER_NT_FUND(); }
          
            } catch (SQLException ex) { Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
       
    
    };
    
     public void Toshow_all_studentFrm_Studentist_AfterNt_fund_inTherRegister(){
          
            try {conn = DBConnection.getConnction(); //USING THE CLASS THE TEACHERS HANDLS TO CALL ALL STUDENTS IN THAT CLASS
            pps4= conn.prepareStatement("SELECT  * FROM  students WHERE Student_Class =?");
            pps4.setString(1,class_teacher_class.trim()); 
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
     
      @SuppressWarnings("empty-statement")
      
      
      
       public void insert_results(){
         
         
 int pass1  = 40, passed1    = 50, failed1    = 39, totallyfailed1   = 0, good1  = 70,avaerage1 = 60,  very_good1 =80, Excellent1 = 90, avaerage_end1  =59, good_end1  =69,very_good_end1 = 79, Excellent_end1  =100   ;
 int pass2  = 40, passed2    = 50, failed2    = 39, totallyfailed2   = 0, good2  = 70,avaerage2 = 60,  very_good2 =80, Excellent2 = 90, avaerage_end2  =59, good_end2  =69,very_good_end2 = 79, Excellent_end2  =100   ;
 int pass3  = 40, passed3    = 50, failed3    = 39, totallyfailed3  = 0, good3  = 70,avaerage3 = 60,  very_good3 =80, Excellent3 = 90, avaerage_end3  =59, good_end3  =69,very_good_end3 = 79, Excellent_end3  =100   ;
 int pass4  = 40, passed4    = 50, failed4    = 39, totallyfailed4   = 0, good4  = 70,avaerage4 = 60,  very_good4 =80, Excellent4 = 90, avaerage_end4 =59, good_end4  =69,very_good_end4 = 79, Excellent_end4  =100   ;
 int pass5  = 40, passed5    = 50, failed5   = 39, totallyfailed5   = 0, good5  = 70,avaerage5 = 60,  very_good5 =80, Excellent5 = 90, avaerage_end5  =59, good_end5  =69,very_good_end5 = 79, Excellent_end5  =100   ;
 int pass6  = 40, passed6    = 50, failed6    = 39, totallyfailed6   = 0, good6  = 70,avaerage6 = 60,  very_good6 =80, Excellent6 = 90, avaerage_end6  =59, good_end6  =69,very_good_end6 = 79, Excellent_end6  =100   ;
 int pass7  = 40, passed7    = 50, failed7    = 39, totallyfailed7   = 0, good7  = 70,avaerage7 = 60,  very_good7 =80, Excellent7 = 90, avaerage_end7  =59, good_end7  =69,very_good_end7 = 79, Excellent_end7  =100   ;
 int pass8  = 40, passed8    = 50, failed8    = 39, totallyfailed8   = 0, good8  = 70,avaerage8 = 60,  very_good8 =80, Excellent8 = 90, avaerage_end8  =59, good_end8  =69,very_good_end8 = 79, Excellent_end8  =100   ;
 int pass9 = 40, passed9    = 50, failed9    = 39, totallyfailed9   = 0, good9  = 70,avaerage9 = 60,  very_good9 =80, Excellent9 = 90, avaerage_end9  =59, good_end9  =69,very_good_end9= 79, Excellent_end9  =100   ;
 int pass10 = 40, passed10  = 50, failed10    = 39, totallyfailed10   = 0, good10  = 70,avaerage10 = 60,  very_good10 =80, Excellent10 = 90, avaerage_end10  =59, good_end10  =69,very_good_end10 = 79, Excellent_end10  =100;
        
        
        
        
 int pass11  = 40, passed11    = 50, failed11    = 39, totallyfailed11   = 0, good11  = 70,avaerage11 = 60,  very_good11 =80, Excellent11 = 90, avaerage_end11  =59, good_end11  =69,very_good_end11 = 79, Excellent_end11  =100   ;
 int pass12  = 40, passed12    = 50, failed12    = 39, totallyfailed12   = 0, good12  = 70,avaerage12 = 60,  very_good12 =80, Excellent12 = 90, avaerage_end12  =59, good_end12  =69,very_good_end12 = 79, Excellent_end12  =100   ;
 int pass13  = 40, passed13    = 50, failed13    = 39, totallyfailed13  = 0, good13  = 70,avaerage13 = 60,  very_good13 =80, Excellent13 = 90, avaerage_end13  =59, good_end13  =69,very_good_end13 = 79, Excellent_end13  =100   ;
 int pass14  = 40, passed14    = 50, failed14    = 39, totallyfailed14   = 0, good14  = 70,avaerage14 = 60,  very_good14 =80, Excellent14 = 90, avaerage_end14 =59, good_end14  =69,very_good_end14 = 79, Excellent_end14  =100   ;
 int pass15  = 40, passed15    = 50, failed15   = 39, totallyfailed15   = 0, good15  = 70,avaerage15 = 60,  very_good15 =80, Excellent15 = 90, avaerage_end15  =59, good_end15  =69,very_good_end15 = 79, Excellent_end15  =100   ;
 int pass16  = 40, passed16    = 50, failed16    = 39, totallyfailed16   = 0, good16  = 70,avaerage16 = 60,  very_good16 =80, Excellent16 = 90, avaerage_end16  =59, good_end16  =69,very_good_end16 = 79, Excellent_end16  =100   ;
 int pass17  = 40, passed17    = 50, failed17    = 39, totallyfailed17   = 0, good17  = 70,avaerage17 = 60,  very_good17 =80, Excellent17 = 90, avaerage_end17  =59, good_end17  =69,very_good_end17 = 79, Excellent_end17  =100   ;
 int pass18  = 40, passed18    = 50, failed18    = 39, totallyfailed18   = 0, good18  = 70,avaerage18 = 60,  very_good18 =80, Excellent18 = 90, avaerage_end18  =59, good_end18  =69,very_good_end18 = 79, Excellent_end18  =100   ;
 int pass19 = 40, passed19    = 50, failed19    = 39, totallyfailed19   = 0, good19  = 70,avaerage19 = 60,  very_good19 =80, Excellent19 = 90, avaerage_end19  =59, good_end19  =69,very_good_end19 = 79, Excellent_end19  =100   ;
 int pass20  = 40, passed20    = 50, failed20    = 39, totallyfailed20   = 0, good20  = 70,avaerage20 = 60,  very_good20 =80, Excellent20 = 90, avaerage_end20  =59, good_end20  =69,very_good_end20 = 79, Excellent_end20  =100   ;

 int pass21  = 40, passed21    = 50, failed21    = 39, totallyfailed21   = 0, good21  = 70,avaerage21 = 60,  very_good21 =80, Excellent21 = 90, avaerage_end21  =59, good_end21  =69,very_good_end21 = 79, Excellent_end21  =100   ;
 int pass22  = 40, passed22    = 50, failed22    = 39, totallyfailed22   = 0, good22  = 70,avaerage22 = 60,  very_good22 =80, Excellent22 = 90, avaerage_end22  =59, good_end22  =69,very_good_end22 = 79, Excellent_end22  =100   ;
 int pass23  = 40, passed23    = 50, failed23    = 39, totallyfailed23  = 0, good23  = 70,avaerage23 = 60,  very_good23 =80, Excellent23 = 90, avaerage_end23  =59, good_end23  =69,very_good_end23 = 79, Excellent_end23  =100   ;
 int pass24  = 40, passed24    = 50, failed24    = 39, totallyfailed24   = 0, good24  = 70,avaerage24 = 60,  very_good24 =80, Excellent24 = 90, avaerage_end24 =59, good_end24  =69,very_good_end24 = 79, Excellent_end24  =100   ;
 int pass25  = 40, passed25    = 50, failed25   = 39, totallyfailed25   = 0, good25  = 70,avaerage25 = 60,  very_good25 =80, Excellent25 = 90, avaerage_end25  =59, good_end25  =69,very_good_end25 = 79, Excellent_end25  =100   ;
 int pass26  = 40, passed26    = 50, failed26    = 39, totallyfailed26   = 0, good26  = 70,avaerage26 = 60,  very_good26 =80, Excellent26 = 90, avaerage_end26  =59, good_end26  =69,very_good_end26 = 79, Excellent_end26  =100   ;
 int pass27  = 40, passed27    = 50, failed27    = 39, totallyfailed27   = 0, good27  = 70,avaerage27 = 60,  very_good27 =80, Excellent27 = 90, avaerage_end27  =59, good_end27  =69,very_good_end27 = 79, Excellent_end27  =100   ;
 int pass28  = 40, passed28    = 50, failed28    = 39, totallyfailed28   = 0, good28  = 70,avaerage28 = 60,  very_good28 =80, Excellent28 = 90, avaerage_end28  =59, good_end28  =69,very_good_end28 = 79, Excellent_end28  =100   ;
 int pass29 = 40, passed29    = 50, failed29    = 39, totallyfailed29   = 0, good29  = 70,avaerage29 = 60,  very_good29 =80, Excellent29 = 90, avaerage_end29  =59, good_end29  =69,very_good_end29 = 79, Excellent_end29  =100   ;
 int pass30  = 40, passed30    = 50, failed30    = 39, totallyfailed30   = 0, good30  = 70,avaerage30 = 60,  very_good30 =80, Excellent30 = 90, avaerage_end30  =59, good_end30  =69,very_good_end30 = 79, Excellent_end30  =100   ;

 int pass31  = 40, passed31    = 50, failed31    = 39, totallyfailed31   = 0, good31  = 70,avaerage31 = 60,  very_good31 =80, Excellent31 = 90, avaerage_end31  =59, good_end31  =69,very_good_end31 = 79, Excellent_end31  =100   ;
 int pass32  = 40, passed32    = 50, failed32    = 39, totallyfailed32   = 0, good32  = 70,avaerage32 = 60,  very_good32 =80, Excellent32 = 90, avaerage_end32  =59, good_end32  =69,very_good_end32 = 79, Excellent_end32  =100   ;
 int pass33  = 40, passed33    = 50, failed33    = 39, totallyfailed33  = 0, good33  = 70,avaerage33 = 60,  very_good33 =80, Excellent33 = 90, avaerage_end33  =59, good_end33  =69,very_good_end33 = 79, Excellent_end33  =100   ;
 int pass34  = 40, passed34    = 50, failed34    = 39, totallyfailed34   = 0, good34  = 70,avaerage34 = 60,  very_good34 =80, Excellent34 = 90, avaerage_end34 =59, good_end34  =69,very_good_end34 = 79, Excellent_end34  =100   ;
 int pass35  = 40, passed35    = 50, failed35   = 39, totallyfailed35   = 0, good35  = 70,avaerage35 = 60,  very_good35 =80, Excellent35 = 90, avaerage_end35  =59, good_end35  =69,very_good_end35 = 79, Excellent_end35  =100   ;
 int pass36  = 40, passed36    = 50, failed36    = 39, totallyfailed36   = 0, good36  = 70,avaerage36 = 60,  very_good36 =80, Excellent36 = 90, avaerage_end36  =59, good_end36  =69,very_good_end36 = 79, Excellent_end36  =100   ;
 int pass37  = 40, passed37    = 50, failed37    = 39, totallyfailed37   = 0, good37  = 70,avaerage37 = 60,  very_good37 =80, Excellent37 = 90, avaerage_end37  =59, good_end37  =69,very_good_end37 = 79, Excellent_end37  =100   ;
 int pass38  = 40, passed38    = 50, failed38    = 39, totallyfailed38   = 0, good38  = 70,avaerage38 = 60,  very_good38 =80, Excellent38 = 90, avaerage_end38  =59, good_end38  =69,very_good_end38 = 79, Excellent_end38  =100   ;
 int pass39 = 40, passed39    = 50, failed39    = 39, totallyfailed39   = 0, good39  = 70,avaerage39 = 60,  very_good39 =80, Excellent39 = 90, avaerage_end39  =59, good_end39  =69,very_good_end39 = 79, Excellent_end39  =100   ;
 int pass40  = 40, passed40    = 50, failed40    = 39, totallyfailed40   = 0, good40  = 70,avaerage40 = 60,  very_good40 =80, Excellent40 = 90, avaerage_end40  =59, good_end40  =69,very_good_end40 = 79, Excellent_end40  =100   ;

 int pass41  = 40, passed41   = 50, failed41    = 39, totallyfailed41   = 0, good41  = 70,avaerage41 = 60,  very_good41 =80, Excellent41 = 90, avaerage_end41  =59, good_end41  =69,very_good_end41 = 79, Excellent_end41  =100   ;
 int pass42  = 40, passed42    = 50, failed42    = 39, totallyfailed42   = 0, good42  = 70,avaerage42 = 60,  very_good42 =80, Excellent42 = 90, avaerage_end42  =59, good_end42  =69,very_good_end42 = 79, Excellent_end42  =100   ;
 int pass43  = 40, passed43    = 50, failed43    = 39, totallyfailed43  = 0, good43  = 70,avaerage43 = 60,  very_good43 =80, Excellent43 = 90, avaerage_end43  =59, good_end43  =69,very_good_end43 = 79, Excellent_end43  =100   ;
 int pass44  = 40, passed44    = 50, failed44    = 39, totallyfailed44   = 0, good44  = 70,avaerage44 = 60,  very_good44 =80, Excellent44 = 90, avaerage_end44 =59, good_end44  =69,very_good_end44 = 79, Excellent_end44  =100   ;
 int pass45  = 40, passed45    = 50, failed45   = 39, totallyfailed45   = 0, good45  = 70,avaerage45 = 60,  very_good45 =80, Excellent45 = 90, avaerage_end45  =59, good_end45  =69,very_good_end45 = 79, Excellent_end45  =100   ;
 int pass46  = 40, passed46    = 50, failed46    = 39, totallyfailed46   = 0, good46  = 70,avaerage46 = 60,  very_good46 =80, Excellent46 = 90, avaerage_end46  =59, good_end46  =69,very_good_end46 = 79, Excellent_end46  =100   ;
 int pass47  = 40, passed47    = 50, failed47    = 39, totallyfailed47   = 0, good47  = 70,avaerage47 = 60,  very_good47 =80, Excellent47 = 90, avaerage_end47  =59, good_end47  =69,very_good_end47 = 79, Excellent_end3l47  =100   ;
 int pass48  = 40, passed48    = 50, failed48    = 39, totallyfailed48   = 0, good48  = 70,avaerage48 = 60,  very_good48 =80, Excellent48 = 90, avaerage_end48  =59, good_end48  =69,very_good_end48 = 79, Excellent_end48  =100   ;
 int pass49 = 40, passed49    = 50, failed49    = 39, totallyfailed49   = 0, good49  = 70,avaerage49 = 60,  very_good49 =80, Excellent49 = 90, avaerage_end49  =59, good_end49  =69,very_good_end49 = 79, Excellent_end49  =100   ;
 int pass50  = 40, passed50    = 50, failed50    = 39, totallyfailed50   = 0, good50  = 70,avaerage50 = 60,  very_good50 =80, Excellent50 = 90, avaerage_end50  =59, good_end50  =69,very_good_end50 = 79, Excellent_end50  =100   ;





 int pass51  = 40, passed51    = 50, failed51    = 39, totallyfailed51   = 0, good51  = 70,avaerage51 = 60,  very_good51 =80, Excellent51 = 90, avaerage_end51  =59, good_end51  = 69,very_good_end51 = 79, Excellent_end51  =100   ;
 int pass52  = 40, passed52    = 50, failed52    = 39, totallyfailed52   = 0, good52  = 70,avaerage52 = 60,  very_good52 =80, Excellent52 = 90, avaerage_end52  =59, good_end52  =69,very_good_end52 = 79, Excellent_end52  =100   ;
 int pass53  = 40, passed53    = 50, failed53    = 39, totallyfailed53  = 0, good53  = 70,avaerage53 = 60,  very_good53 =80, Excellent53 = 90, avaerage_end53  =59, good_end53  =69,very_good_end53 = 79, Excellent_end53  =100   ;
 int pass54  = 40, passed54    = 50, failed54    = 39, totallyfailed54   = 0, good54  = 70,avaerage54 = 60,  very_good54 =80, Excellent54 = 90, avaerage_end54 =59, good_end54  =69,very_good_end54 = 79, Excellent_end54  =100   ;
 int pass55  = 40, passed55    = 50, failed55   = 39, totallyfailed55   = 0, good55  = 70,avaerage55 = 60,  very_good55 =80, Excellent55 = 90, avaerage_end55  =59, good_end55  =69,very_good_end55 = 79, Excellent_end55  =100   ;
 int pass56  = 40, passed56    = 50, failed56    = 39, totallyfailed56   = 0, good56  = 70,avaerage56 = 60,  very_good56 =80, Excellent56 = 90, avaerage_end56  =59, good_end56  =69,very_good_end56 = 79, Excellent_end56  =100   ;
 int pass57  = 40, passed57    = 50, failed57    = 39, totallyfailed57   = 0, good57  = 70,avaerage57 = 60,  very_good57 =80, Excellent57 = 90, avaerage_end57  =59, good_end57  =69,very_good_end57 = 79, Excellent_end57  =100   ;
 int pass58  = 40, passed58    = 50, failed58    = 39, totallyfailed58   = 0, good58  = 70,avaerage58 = 60,  very_good58 =80, Excellent58 = 90, avaerage_end58  =59, good_end58  =69,very_good_end58 = 79, Excellent_end58  =100   ;
 int pass59 = 40, passed59    = 50, failed59    = 39, totallyfailed59   = 0, good59  = 70,avaerage59 = 60,  very_good59 =80, Excellent59 = 90, avaerage_end59  =59, good_end59  =69,very_good_end59 = 79, Excellent_end59  =100   ;
 int pass60  = 40, passed60    = 50, failed60    = 39, totallyfailed60   = 0, good60  = 70,avaerage60 = 60,  very_good60 =80, Excellent60 = 90, avaerage_end60  =59, good_end60  =69,very_good_end60 = 79, Excellent_end60  =100   ;

 int pass61  = 40, passed61    = 50, failed61    = 39, totallyfailed61   = 0, good61  = 70,avaerage61 = 60,  very_good61 =80, Excellent61 = 90, avaerage_end61  =59, good_end61  =69,very_good_end61 = 79, Excellent_end61  =100   ;
 int pass62  = 40, passed62    = 50, failed62    = 39, totallyfailed62   = 0, good62  = 70,avaerage62 = 60,  very_good62 =80, Excellent62 = 90, avaerage_end62  =59, good_end62  =69,very_good_end62 = 79, Excellent_end62  =100   ;
 int pass63  = 40, passed63    = 50, failed63    = 39, totallyfailed63  = 0, good63  = 70,avaerage63 = 60,  very_good63 =80, Excellent63 = 90, avaerage_end63  =59, good_end63  =69,very_good_end63 = 79, Excellent_end63  =100   ;
 int pass64  = 40, passed64    = 50, failed64    = 39, totallyfailed64   = 0, good64  = 70,avaerage64 = 60,  very_good64 =80, Excellent64 = 90, avaerage_end64 =59, good_end64  =69,very_good_end64 = 79, Excellent_end64  =100   ;
 int pass65  = 40, passed65    = 50, failed65   = 39, totallyfailed65   = 0, good65  = 70,avaerage65 = 60,  very_good65 =80, Excellent65 = 90, avaerage_end65  =59, good_end65  =69,very_good_end65 = 79, Excellent_end65  =100   ;
 int pass66  = 40, passed66    = 50, failed66    = 39, totallyfailed66   = 0, good66  = 70,avaerage66 = 60,  very_good66 =80, Excellent66 = 90, avaerage_end66  =59, good_end66  =69,very_good_end66 = 79, Excellent_end66  =100   ;
 int pass67  = 40, passed67    = 50, failed67    = 39, totallyfailed67   = 0, good67  = 70,avaerage67 = 60,  very_good67 =80, Excellent67 = 90, avaerage_end67  =59, good_end67  =69,very_good_end67 = 79, Excellent_end67  =100   ;
 int pass68  = 40, passed68    = 50, failed68    = 39, totallyfailed68   = 0, good68  = 70,avaerage68 = 60,  very_good68 =80, Excellent68 = 90, avaerage_end68  =59, good_end68  =69,very_good_end68 = 79, Excellent_end68  =100   ;
 int pass69 = 40, passed69    = 50, failed69    = 39, totallyfailed69   = 0, good69  = 70,avaerage69 = 60,  very_good69 =80, Excellent69 = 90, avaerage_end69  =59, good_end69  =69,very_good_end69 = 79, Excellent_end69  =100   ;
 int pass70  = 40, passed70    = 50, failed70    = 39, totallyfailed70   = 0, good70  = 70,avaerage70 = 60,  very_good70 =80, Excellent70 = 90, avaerage_end70  =59, good_end70  =69,very_good_end70 = 79, Excellent_end70  =100   ;


 int pass71  = 40, passed71    = 50, failed71    = 39, totallyfailed71   = 0, good71  = 70,avaerage71 = 60,  very_good71 =80, Excellent71 = 90, avaerage_end71  =59, good_end71  =69,very_good_end71 = 79, Excellent_end71  =100   ;
 int pass72  = 40, passed72    = 50, failed72    = 39, totallyfailed72   = 0, good72  = 70,avaerage72 = 60,  very_good72 =80, Excellent72 = 90, avaerage_end72  =59, good_end72  =69,very_good_end72 = 79, Excellent_end72  =100   ;
 int pass73  = 40, passed73    = 50, failed73    = 39, totallyfailed73  = 0, good73  = 70,avaerage73 = 60,  very_good73 =80, Excellent73 = 90, avaerage_end73  =59, good_end73  =69,very_good_end73 = 79, Excellent_end73  =100   ;
 int pass74  = 40, passed74    = 50, failed74    = 39, totallyfailed74   = 0, good74  = 70,avaerage74 = 60,  very_good74 =80, Excellent74 = 90, avaerage_end74 =59, good_end74  =69,very_good_end74 = 79, Excellent_end74  =100   ;
 int pass75  = 40, passed75    = 50, failed75   = 39, totallyfailed75   = 0, good75  = 70,avaerage75 = 60,  very_good75 =80, Excellent75 = 90, avaerage_end75  =59, good_end75  =69,very_good_end75 = 79, Excellent_end75  =100   ;
 int pass76  = 40, passed76    = 50, failed76    = 39, totallyfailed76   = 0, good76  = 70,avaerage76 = 60,  very_good76 =80, Excellent76 = 90, avaerage_end76  =59, good_end76  =69,very_good_end76 = 79, Excellent_end76  =100   ;
 int pass77  = 40, passed77    = 50, failed77    = 39, totallyfailed77   = 0, good77  = 70,avaerage77 = 60,  very_good77 =80, Excellent77 = 90, avaerage_end77  =59, good_end77  =69,very_good_end77 = 79, Excellent_end77  =100   ;
 int pass78  = 40, passed78    = 50, failed78    = 39, totallyfailed78   = 0, good78  = 70,avaerage78 = 60,  very_good78 =80, Excellent78 = 90, avaerage_end78  =59, good_end78  =69,very_good_end78 = 79, Excellent_end78  =100   ;
 int pass79 = 40, passed79    = 50, failed79    = 39, totallyfailed79   = 0, good79  = 70,avaerage79 = 60,  very_good79 =80, Excellent79 = 90, avaerage_end79  =59, good_end79  =69,very_good_end79 = 79, Excellent_end79  =100   ;
 int pass80  = 40, passed80    = 50, failed80    = 39, totallyfailed80   = 0, good80  = 70,avaerage80 = 60,  very_good80 =80, Excellent80 = 90, avaerage_end80  =59, good_end80  =69,very_good_end80 = 79, Excellent_end80  =100   ;

 int pass81  = 40, passed81    = 50, failed81    = 39, totallyfailed81   = 0, good81  = 70,avaerage81 = 60,  very_good81 =80, Excellent81 = 90, avaerage_end81  =59, good_end81  =69,very_good_end81 = 79, Excellent_end81  =100   ;
 int pass82  = 40, passed82    = 50, failed82    = 39, totallyfailed82   = 0, good82  = 70,avaerage82 = 60,  very_good82 =80, Excellent82 = 90, avaerage_end82  =59, good_end82  =69,very_good_end82 = 79, Excellent_end82  =100   ;
 int pass83  = 40, passed83    = 50, failed83    = 39, totallyfailed83  = 0, good83  = 70,avaerage83 = 60,  very_good83 =80, Excellent83 = 90, avaerage_end83  =59, good_end83  =69,very_good_end83 = 79, Excellent_end83  =100   ;
 int pass84  = 40, passed84    = 50, failed84    = 39, totallyfailed84   = 0, good84  = 70,avaerage84 = 60,  very_good84 =80, Excellent84 = 90, avaerage_end84 =59, good_end84  =69,very_good_end84 = 79, Excellent_end84  =100   ;
 int pass85  = 40, passed85    = 50, failed85   = 39, totallyfailed85   = 0, good85  = 70,avaerage85 = 60,  very_good85 =80, Excellent85 = 90, avaerage_end85  =59, good_end85  =69,very_good_end85 = 79, Excellent_end85  =100   ;
 int pass86  = 40, passed86    = 50, failed86    = 39, totallyfailed86   = 0, good86  = 70,avaerage86 = 60,  very_good86 =80, Excellent86 = 90, avaerage_end86  =59, good_end86  =69,very_good_end86 = 79, Excellent_end86  =100   ;
 int pass87  = 40, passed87    = 50, failed87    = 39, totallyfailed87   = 0, good87  = 70,avaerage87 = 60,  very_good87 =80, Excellent87 = 90, avaerage_end87  =59, good_end87  =69,very_good_end87 = 79, Excellent_end87  =100   ;
 int pass88  = 40, passed88    = 50, failed88    = 39, totallyfailed88   = 0, good88  = 70,avaerage88 = 60,  very_good88 =80, Excellent88 = 90, avaerage_end88  =59, good_end88  =69,very_good_end88 = 79, Excellent_end88  =100   ;
 int pass89 = 40, passed89    = 50, failed89    = 39, totallyfailed89   = 0, good89  = 70,avaerage89 = 60,  very_good89 =80, Excellent89 = 90, avaerage_end89  =59, good_end89  =69,very_good_end89 = 79, Excellent_end89  =100   ;
 int pass90  = 40, passed90    = 50, failed90    = 39, totallyfailed90   = 0, good90  = 70,avaerage90 = 60,  very_good90 =80, Excellent90 = 90, avaerage_end90  =59, good_end90  =69,very_good_end90 = 79, Excellent_end90  =100   ;

 int pass91  = 40, passed91   = 50, failed91    = 39, totallyfailed91   = 0, good91  = 70,avaerage91 = 60,  very_good91 =80, Excellent91 = 90, avaerage_end91  =59, good_end91  =69,very_good_end91 = 79, Excellent_end91  =100   ;
 int pass92  = 40, passed92    = 50, failed92    = 39, totallyfailed92   = 0, good92  = 70,avaerage92 = 60,  very_good92 =80, Excellent92 = 90, avaerage_end92  =59, good_end92  =69,very_good_end92 = 79, Excellent_end92  =100   ;
 int pass93  = 40, passed93    = 50, failed93    = 39, totallyfailed93  = 0, good93  = 70,avaerage93 = 60,  very_good93 =80, Excellent93 = 90, avaerage_end93  =59, good_end93  =69,very_good_end93 = 79, Excellent_end93  =100   ;
 int pass94  = 40, passed94    = 50, failed94    = 39, totallyfailed94   = 0, good94  = 70,avaerage94 = 60,  very_good94 =80, Excellent94 = 90, avaerage_end94 =59, good_end94  =69,very_good_end94 = 79, Excellent_end94  =100   ;
 int pass95  = 40, passed95    = 50, failed95   = 39, totallyfailed95   = 0, good95  = 70,avaerage95 = 60,  very_good95 =80, Excellent95 = 90, avaerage_end95  =59, good_end95  =69,very_good_end95 = 79, Excellent_end95  =100   ;
 int pass96  = 40, passed96    = 50, failed96    = 39, totallyfailed96   = 0, good96  = 70,avaerage96 = 60,  very_good96 =80, Excellent96 = 90, avaerage_end96  =59, good_end96  =69,very_good_end96 = 79, Excellent_end96  =100   ;
 int pass97  = 40, passed97    = 50, failed97    = 39, totallyfailed97   = 0, good97  = 70,avaerage97 = 60,  very_good97 =80, Excellent97 = 90, avaerage_end97  =59, good_end97  =69,very_good_end97 = 79, Excellent_end97  =100   ;
 int pass98  = 40, passed98    = 50, failed98    = 39, totallyfailed98   = 0, good98  = 70,avaerage98 = 60,  very_good98 =80, Excellent98 = 90, avaerage_end98  =59, good_end98  =69,very_good_end98 = 79, Excellent_end98  =100   ;
 int pass99 = 40, passed99    = 50, failed99    = 39, totallyfailed99   = 0, good99  = 70,avaerage99 = 60,  very_good99 =80, Excellent99 = 90, avaerage_end99  =59, good_end99  =69,very_good_end99 = 79, Excellent_end99  =100   ;
 int pass100  = 40, passed100    = 50, failed100   = 39, totallyfailed100   = 0, good100  = 70,avaerage100 = 60,  very_good100 =80, Excellent100 = 90, avaerage_end100  =59, good_end100  =69,very_good_end100 = 79, Excellent_end100  =100   ;

 int pass101  = 40, passed101    = 50, failed101    = 39, totallyfailed101   = 0, good101  = 70,avaerage101 = 60,  very_good101 =80, Excellent101 = 90, avaerage_end101  =59, good_end101  =69,very_good_end101 = 79, Excellent_end101  =100   ;
 int pass102  = 40, passed102    = 50, failed102    = 39, totallyfailed102   = 0, good102  = 70,avaerage102 = 60,  very_good102 =80, Excellent102 = 90, avaerage_end102  =59, good_end102  =69,very_good_end102 = 79, Excellent_end102  =100   ;
 int pass103  = 40, passed103    = 50, failed103    = 39, totallyfailed103  = 0, good103  = 70,avaerage103 = 60,  very_good103 =80, Excellent103 = 90, avaerage_end103  =59, good_end103  =69,very_good_end103 = 79, Excellent_end103  =100   ;
 int pass104  = 40, passed104    = 50, failed104    = 39, totallyfailed104   = 0, good104  = 70,avaerage104 = 60,  very_good104 =80, Excellent104 = 90, avaerage_end104 =59, good_end104  =69,very_good_end104 = 79, Excellent_end104  =100   ;
 int pass105  = 40, passed105    = 50, failed105   = 39, totallyfailed105   = 0, good105  = 70,avaerage105 = 60,  very_good105 =80, Excellent105 = 90, avaerage_end105  =59, good_end105  =69,very_good_end105 = 79, Excellent_end105  =100   ;
 int pass106  = 40, passed106    = 50, failed106    = 39, totallyfailed106   = 0, good106  = 70,avaerage106 = 60,  very_good106 =80, Excellent106 = 90, avaerage_end106  =59, good_end106  =69,very_good_end106 = 79, Excellent_end106  =100   ;
 int pass107  = 40, passed107    = 50, failed107    = 39, totallyfailed107   = 0, good107  = 70,avaerage107 = 60,  very_good107 =80, Excellent107 = 90, avaerage_end107  =59, good_end107  =69,very_good_end107 = 79, Excellent_end107  =100   ;
 int pass108  = 40, passed108    = 50, failed108    = 39, totallyfailed108   = 0, good108  = 70,avaerage108 = 60,  very_good108 =80, Excellent108 = 90, avaerage_end108  =59, good_end108  =69,very_good_end108 = 79, Excellent_end108  =100   ;
 int pass109 = 40, passed109    = 50, failed109    = 39, totallyfailed109   = 0, good109  = 70,avaerage109 = 60,  very_good109 =80, Excellent109 = 90, avaerage_end109  =59, good_end109  =69,very_good_end109= 79, Excellent_end109  =100   ;
 int pass110  = 40;
         
             String Term_mode_choosers =Term_mode_chooser.getSelectedItem().toString().trim();
             String Term_choosers = Term_chooser.getSelectedItem().toString().trim();
             
            String Term = Term_choosers + Term_mode_choosers;
        
        try {
            
              Date date = jDateChooser1.getDate();
             java.sql.Date sqldate = new java.sql.Date(date.getTime());
                 
             conn = DBConnection.getConnction();
             
            
            
            pps7= conn.prepareStatement("INSERT INTO  student_resuits (Full_name,subject, Marks_obtain,Total_Marks,Percentage,Day_time,Class,Term,Comments,Handing_Teacher)VALUES (?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?), "
                    + "(?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),  "
                    + "(?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?), "
                    + "(?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?) ");  //,
            
             
             
             pps7.setString(1 , Sn1.getText().trim());                  //student name
             pps7.setString(2 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(3 , R1.getText().trim());                   // marks_obtained 
             pps7.setString(4 , total_marks.getText().trim());                     // total_marks_  
                            double converted_marks_obtained1 = Double.parseDouble(R1.getText().trim());  double converted_total_marks1 = Double.parseDouble(total_marks.getText().trim());
                         int percetage1 =(int)(converted_marks_obtained1/converted_total_marks1* 100) ;
                      if ((percetage1 <= failed1 )&&(percetage1 >= totallyfailed1 )){ p1 = "Failed";  }else if ((percetage1 <=passed1 )&&(percetage1  >= pass1  )   ){ p1 = "Pass";  }  else if ((percetage1  <= avaerage1 )&&(percetage1  >= avaerage_end1  )){ p1 = "Avaerage"; ; 
                } else if ((percetage1  <=good1 )&&(percetage1 >= good_end1 ) ){ p1 ="Good";  }else if ((percetage1 <= very_good1 )&&(percetage1 >= very_good_end1  )){ p1 = "Very Good";    }else if ((percetage1 <= Excellent1 )&&(percetage1  >= very_good1 )   ){ p1 = "Excellent";   }
            
             pps7.setDouble(5 , percetage1);                                    
             pps7.setDate(6 ,  sqldate);
             pps7.setString(7 , class_teacher_class);
             pps7.setString(8 , Term);
              pps7.setString( 9, p1);//inserting cmements by students marks
             pps7.setString(10 , System_ID.getText().trim());
             
              

            
           
             pps7.setString(11 , Sn2.getText().trim());                  //student name
             pps7.setString(12 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(13 , R2.getText().trim());                   // marks_obtained 
             pps7.setString(14 , total_marks.getText().trim());                     // total_marks_  
                   double converted_marks_obtained2 = Double.parseDouble(R2.getText().trim());  double converted_total_marks2 = Double.parseDouble(total_marks.getText().trim());
                   int percetage2 =(int)(converted_marks_obtained2/converted_total_marks2* 100) ;
                   if ((percetage2 <= failed2  )&&(percetage2 >= totallyfailed2 )){ p2 = "Failed";  }else if ((percetage2 <=passed2 )&&(percetage2  >= pass2 )   ){ p2 = "Pass";  }  else if ((percetage2  <= avaerage2 )&&(percetage2  >= avaerage_end2  )){ p2 = "Avaerage"; ; 
                    } else if ((percetage2  <= good2  )&&(percetage2 >= good_end2  ) ){ p2 ="Good";  }else if ((percetage2 <= very_good2)&&(percetage2 >= very_good_end2 )){ p2 = "Very Good";    }else if ((percetage2 <= Excellent2 )&&(percetage2  >= very_good2 )   ){ p2 = "Excellent"; }
             pps7.setDouble(15 ,percetage2);                                           // Percentage  
             pps7.setDate(16 , sqldate);
             pps7.setString(17 , class_teacher_class);
             pps7.setString(18 , Term);
             pps7.setString(19, p2);//inserting cmements by students marks
             pps7.setString( 20, System_ID.getText().trim());
             
              
              
              
          
             
             
             
             
            
             
             pps7.setString(21 , Sn3.getText().trim());                  //student name
             pps7.setString(22 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(23 , R3.getText().trim());                   // marks_obtained 
             pps7.setString(24 , total_marks.getText().trim());                     // total_marks_  
                      double converted_marks_obtained3 = Double.parseDouble(R3.getText().trim());  double converted_total_marks3 = Double.parseDouble(total_marks.getText().trim());
                      int percetage3 =(int)(converted_marks_obtained3/converted_total_marks3* 100) ;
                      if ((percetage3 <= failed3 )&&(percetage3 >= totallyfailed3)){ p3 = "Failed";  }else if ((percetage3 <=passed3 )&&(percetage3  >= pass3 )   ){ p3 = "Pass";  }  else if ((percetage3  <= avaerage3 )&&(percetage3  >= avaerage_end3 )){ p3 = "Avaerage"; ; 
                      } else if ((percetage3  <=good3 )&&(percetage3 >= good_end3 ) ){ p3 ="Good";  }else if ((percetage3 <= very_good3 )&&(percetage3 >= very_good_end3 )){ p3 = "Very Good";    }else if ((percetage3 <= Excellent3 )&&(percetage3  >= very_good3 )   ){ p3 = "Excellent";   }
            
             pps7.setDouble(25 , percetage3);                                           // Percentage  
             pps7.setDate(26, sqldate);
             pps7.setString(27, class_teacher_class);
             pps7.setString(28 , Term);
             pps7.setString( 29, p3);//inserting cmements by students marks
             pps7.setString( 30, System_ID.getText().trim());
            
              
             
             pps7.setString(31 , Sn4.getText().trim());                  //student name
             pps7.setString(32 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(33 , R4.getText().trim());                   // marks_obtained 
             pps7.setString(34 , total_marks.getText().trim());                     // total_marks_  
            
                   double converted_marks_obtained4 = Double.parseDouble(R4.getText().trim());  double converted_total_marks4 = Double.parseDouble(total_marks.getText().trim());
                    int percetage4 =(int)(converted_marks_obtained4/converted_total_marks4* 100) ;
                  if ((percetage4 <= failed4 )&&(percetage4 >= totallyfailed4)){ p4 = "Failed";  }else if ((percetage4 <=passed4 )&&(percetage4  >= pass4 )   ){ p4 = "Pass";  }  else if ((percetage4  <= avaerage4 )&&(percetage4  >= avaerage_end4 )){ p4 = "Avaerage"; ; 
                } else if ((percetage4 <=good4 )&&(percetage4 >= good_end4) ){ p4 ="Good";  }else if ((percetage4 <= very_good4 )&&(percetage4 >= very_good_end4 )){ p4 = "Very Good";    }else if ((percetage4 <= Excellent4 )&&(percetage4  >= very_good4 )   ){ p4 = "Excellent";   } 
            
             pps7.setDouble(35, percetage4 );                                           // Percentage  
             pps7.setDate(36, sqldate);
             pps7.setString(37 , class_teacher_class);
             pps7.setString(38, Term);
              pps7.setString(39 , p4);//inserting cmements by students marks
             pps7.setString( 40, System_ID.getText().trim());
            
            
             
             pps7.setString(41 , Sn5.getText().trim());                  //student name
             pps7.setString(42 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(43 , R5.getText().trim());                   // marks_obtained 
             pps7.setString(44 , total_marks.getText().trim());                     // total_marks_  
            
                double converted_marks_obtained5 = Double.parseDouble(R5.getText().trim());  double converted_total_marks5 = Double.parseDouble(total_marks.getText().trim());
                    int percetage5=(int)(converted_marks_obtained5/converted_total_marks5* 100) ;
                  if ((percetage5 <= failed5 )&&(percetage5 >= totallyfailed5)){ p5 = "Failed";  }else if ((percetage5 <=passed5 )&&(percetage5  >= pass5 )   ){ p5 = "Pass";  }  else if ((percetage5  <= avaerage5 )&&(percetage5  >= avaerage_end5 )){ p5 = "Avaerage"; ; 
                } else if ((percetage5 <=good5  )&&(percetage5 >= good_end5 ) ){ p5 ="Good";  }else if ((percetage5 <= very_good5 )&&(percetage5 >= very_good_end5 )){ p5 = "Very Good";    }else if ((percetage5 <= Excellent5 )&&(percetage5  >= very_good5 )   ){ p5 = "Excellent";   }
            
             pps7.setDouble(45, percetage5);                                           // Percentage  
             pps7.setDate(46, sqldate);
             pps7.setString(47 , class_teacher_class);
             pps7.setString(48, Term);
              pps7.setString(49 , p5);//inserting cmements by students marks
             pps7.setString( 50, System_ID.getText().trim());
             
             
             
              pps7.setString(51 , Sn6.getText().trim());                  //student name
             pps7.setString(52 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(53 , R6.getText().trim());                   // marks_obtained 
             pps7.setString(54 , total_marks.getText().trim());                     // total_marks_  
            
                   double converted_marks_obtained6 = Double.parseDouble(R6.getText().trim());  double converted_total_marks6 = Double.parseDouble(total_marks.getText().trim());
                    int percetage6=(int)(converted_marks_obtained6 / converted_total_marks6 * 100) ;
                  if ((percetage6 <= failed6 )&&(percetage6 >= totallyfailed6)){ p6 = "Failed";  }else if ((percetage6 <=passed6 )&&(percetage6  >= pass6 )   ){ p6 = "Pass";  }  else if ((percetage6  <= avaerage6 )&&(percetage6  >= avaerage_end6 )){ p6 = "Avaerage"; ; 
                   } else if ((percetage6 <=good6 )&&(percetage6 >= good_end6 ) ){ p6 ="Good";  }else if ((percetage6 <= very_good6 )&&(percetage6 >= very_good_end6 )){ p6 = "Very Good";    }else if ((percetage6 <= Excellent6 )&&(percetage6  >= very_good6 )   ){ p6 = "Excellent";   }  
            
             pps7.setDouble(55, percetage6);                                           // Percentage  
             pps7.setDate(56, sqldate);
             pps7.setString(57 , class_teacher_class);
             pps7.setString(58, Term);
              pps7.setString(59 , p6);//inserting cmements by students marks
             pps7.setString( 60, System_ID.getText().trim());
             
             
             
              pps7.setString(61 , Sn7.getText().trim());                  //student name
             pps7.setString(62 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(63 , R7.getText().trim());                   // marks_obtained 
             pps7.setString(64 , total_marks.getText().trim());                     // total_marks_  
            
                   double converted_marks_obtained7 = Double.parseDouble(R7.getText().trim());  double converted_total_marks7 = Double.parseDouble(total_marks.getText().trim());
                    int percetage7=(int)(converted_marks_obtained7 / converted_total_marks7 * 100) ;
                  if ((percetage7 <= failed7 )&&(percetage7 >= totallyfailed7)){ p7 = "Failed";  }else if ((percetage7 <=passed7)&&(percetage7  >= pass7 )   ){ p7 = "Pass";  }  else if ((percetage7  <= avaerage7 )&&(percetage7  >= avaerage_end7 )){ p7 = "Avaerage"; ; 
                   } else if ((percetage7 <=good7 )&&(percetage7 >= good_end7 ) ){ p7="Good";  }else if ((percetage7 <= very_good7 )&&(percetage7 >= very_good_end7 )){ p7 = "Very Good";    }else if ((percetage7 <= Excellent7 )&&(percetage7  >= very_good7 )   ){ p7 = "Excellent";   }  
            
             pps7.setDouble(65, percetage7);                                           // Percentage  
             pps7.setDate(66, sqldate);
             pps7.setString(67 , class_teacher_class);
             pps7.setString(68, Term);
              pps7.setString(69 , p7);//inserting cmements by students marks
             pps7.setString( 70, System_ID.getText().trim());
             
          
            
                pps7.setString(71 , Sn8.getText().trim());                  //student name
             pps7.setString(72 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(73 , R8.getText().trim());                   // marks_obtained 
             pps7.setString(74 , total_marks.getText().trim());                     // total_marks_  
            
                   double converted_marks_obtained8 = Double.parseDouble(R8.getText().trim());  double converted_total_marks8 = Double.parseDouble(total_marks.getText().trim());
                    int percetage8=(int)(converted_marks_obtained8 / converted_total_marks8 * 100) ;
                  if ((percetage8 <= failed8 )&&(percetage8 >= totallyfailed8)){ p8 = "Failed";  }else if ((percetage8 <=passed8 )&&(percetage8  >= pass8 )   ){ p8  = "Pass";  }  else if ((percetage8  <= avaerage8 )&&(percetage8  >= avaerage_end8 )){ p8 = "Avaerage"; ; 
                   } else if ((percetage8 <=good8 )&&(percetage8 >= good_end8 ) ){ p8 ="Good";  }else if ((percetage8 <= very_good8 )&&(percetage8 >= very_good_end8 )){ p8  = "Very Good";    }else if ((percetage8 <= Excellent8 )&&(percetage8  >= very_good8 )   ){ p8  = "Excellent";   }  
            
             pps7.setDouble(75, percetage8);                                           // Percentage  
             pps7.setDate(76, sqldate);
             pps7.setString(77 , class_teacher_class);
             pps7.setString(78, Term);
              pps7.setString(79 , p8);//inserting cmements by students marks
             pps7.setString( 80, System_ID.getText().trim());
             
             
             
             
                pps7.setString(81 , Sn9.getText().trim());                  //student name
                pps7.setString(82 , showsubjects.getSelectedItem().toString().trim()); //subjects
                pps7.setString(83 , R9.getText().trim());                   // marks_obtained 
                pps7.setString(84 , total_marks.getText().trim());                     // total_marks_  
            
                   double converted_marks_obtained9 = Double.parseDouble(R9.getText().trim());  double converted_total_marks9 = Double.parseDouble(total_marks.getText().trim());
                    int percetage9=(int)(converted_marks_obtained9 / converted_total_marks9 * 100) ;
                  if ((percetage9 <= failed9 )&&(percetage9 >= totallyfailed9)){ p9 = "Failed";  }else if ((percetage9 <=passed9 )&&(percetage9  >= pass9 )   ){ p9  = "Pass";  }  else if ((percetage9  <= avaerage9 )&&(percetage9  >= avaerage_end9 )){ p9  = "Avaerage"; ; 
                   } else if ((percetage9 <=good9 )&&(percetage9 >= good_end9 ) ){ p9="Good";  }else if ((percetage9 <= very_good9 )&&(percetage9 >= very_good_end9 )){ p9  = "Very Good";    }else if ((percetage9 <= Excellent9 )&&(percetage9  >= very_good9 )   ){ p9  = "Excellent";   }  
            
             pps7.setDouble(85, percetage9);                                           // Percentage  
             pps7.setDate(86, sqldate);
             pps7.setString(87 , class_teacher_class);
             pps7.setString(88, Term);
              pps7.setString(89 , p9);//inserting cmements by students marks
             pps7.setString( 90, System_ID.getText().trim());
             
             
             
             
                pps7.setString(91 , Sn10.getText().trim());                  //student name
             pps7.setString(92 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(93 , R10.getText().trim());                   // marks_obtained 
             pps7.setString(94 , total_marks.getText().trim());                     // total_marks_  
            
                   double converted_marks_obtained10 = Double.parseDouble(R10.getText().trim());  double converted_total_marks10 = Double.parseDouble(total_marks.getText().trim());
                    int percetage10=(int)(converted_marks_obtained10 / converted_total_marks10 * 100) ;
                  if ((percetage10 <= failed10 )&&(percetage10 >= totallyfailed10)){ p10 = "Failed";  }else if ((percetage10 <=passed10 )&&(percetage10  >= pass10 )   ){ p10  = "Pass";  }  else if ((percetage10  <= avaerage10 )&&(percetage10  >= avaerage_end10 )){ p10  = "Avaerage"; ; 
                   } else if ((percetage10 <=good10 )&&(percetage10 >= good_end10 ) ){ p10="Good";  }else if ((percetage10 <= very_good10 )&&(percetage10 >= very_good_end10 )){ p10  = "Very Good";    }else if ((percetage10 <= Excellent10 )&&(percetage10  >= very_good10 )   ){ p10  = "Excellent";   }  
            
             pps7.setDouble(95, percetage10);                                           // Percentage  
             pps7.setDate(96, sqldate);
             pps7.setString(97 , class_teacher_class);
             pps7.setString(98, Term);
              pps7.setString(99 , p10);//inserting cmements by students marks
             pps7.setString( 100, System_ID.getText().trim());
             
           
             
             
              
             
                pps7.setString(101 , Sn11.getText().trim());                  //student name
             pps7.setString(102 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(103 , R11.getText().trim());                   // marks_obtained 
             pps7.setString(104 , total_marks.getText().trim());                     // total_marks_  
            
                   double converted_marks_obtained11 = Double.parseDouble(R11.getText().trim());  double converted_total_marks11 = Double.parseDouble(total_marks.getText().trim());
                    int percetage11  =(int)(converted_marks_obtained11 / converted_total_marks11 * 100) ;
                  if ((percetage11 <= failed11 )&&(percetage11 >= totallyfailed11)){ p11 = "Failed";  }else if ((percetage11 <=passed11 )&&(percetage11  >= pass11 )   ){p11 = "Pass";  }  else if ((percetage11  <= avaerage11 )&&(percetage11  >= avaerage_end11 )){p11 = "Avaerage"; ; 
                   } else if ((percetage11 <=good11 )&&(percetage11 >= good_end11 ) ){ p11="Good";  }else if ((percetage11 <= very_good11 )&&(percetage11 >= very_good_end11 )){ p11 = "Very Good";    }else if ((percetage11 <= Excellent11 )&&(percetage11  >= very_good11 )   ){ p11 = "Excellent";   }  
            
             pps7.setDouble(105, percetage11);                                           // Percentage  
             pps7.setDate(106, sqldate);
             pps7.setString(107 , class_teacher_class);
             pps7.setString(108, Term);
              pps7.setString(109 , p11);//inserting cmements by students marks
             pps7.setString( 110, System_ID.getText().trim());
             
            
        
        
             
             
                pps7.setString(111 , Sn12.getText().trim());                  //student name
             pps7.setString(112 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(113 , R12.getText().trim());                   // marks_obtained 
             pps7.setString(114 , total_marks.getText().trim());                     // total_marks_  
            
                   double converted_marks_obtained12 = Double.parseDouble(R12.getText().trim());  double converted_total_marks12 = Double.parseDouble(total_marks.getText().trim());
                    int percetage12 =(int)(converted_marks_obtained12  / converted_total_marks12  * 100) ;
                  if ((percetage12  <= failed12 )&&(percetage12  >= totallyfailed12)){ p12  = "Failed";  }else if ((percetage12 <=passed12 )&&(percetage12  >= pass12 )   ){ p12 = "Pass";  }  else if ((percetage12  <= avaerage12 )&&(percetage12  >= avaerage_end12 )){ p12 = "Avaerage"; ; 
                   } else if ((percetage12  <=good12 )&&(percetage12  >= good_end12 ) ){ p12 ="Good";  }else if ((percetage12 <= very_good12 )&&(percetage12 >= very_good_end12 )){ p12 = "Very Good";    }else if ((percetage12 <= Excellent12 )&&(percetage12  >= very_good12 )   ){ p12 = "Excellent";   }  
            
             pps7.setDouble(115, percetage12 );                                           // Percentage  
             pps7.setDate(116, sqldate);
             pps7.setString(117 , class_teacher_class);
             pps7.setString(118, Term);
               pps7.setString(119 , p12 );//inserting cmements by students marks
             pps7.setString( 120, System_ID.getText().trim());  
             
             
             
                pps7.setString(121 , Sn13.getText().trim());                  //student name
             pps7.setString(122 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(123 , R13.getText().trim());                   // marks_obtained 
             pps7.setString(124 , total_marks.getText().trim());                     // total_marks_  
            
                   double converted_marks_obtained13 = Double.parseDouble(R13.getText().trim());  double converted_total_marks13 = Double.parseDouble(total_marks.getText().trim());
                    int percetage13  =(int)(converted_marks_obtained13 / converted_total_marks13 * 100) ;
                  if ((percetage13 <= failed13 )&&(percetage13 >= totallyfailed13)){ p13 = "Failed";  }else if ((percetage13 <=passed13 )&&(percetage13  >= pass13 )   ){p13 = "Pass";  }  else if ((percetage13  <= avaerage13 )&&(percetage13  >= avaerage_end13 )){p13 = "Avaerage"; ; 
                   } else if ((percetage13 <=good13 )&&(percetage13 >= good_end13 ) ){ p13="Good";  }else if ((percetage13 <= very_good13 )&&(percetage13 >= very_good_end13 )){ p13 = "Very Good";    }else if ((percetage13 <= Excellent13 )&&(percetage13  >= very_good13 )   ){ p13 = "Excellent";   }  
            
             pps7.setDouble(125, percetage13);                                           // Percentage  
             pps7.setDate(126, sqldate);
             pps7.setString(127 , class_teacher_class);
             pps7.setString(128, Term);
              pps7.setString(129 , p13);//inserting cmements by students marks
             pps7.setString(130, System_ID.getText().trim());
             
             
             
                pps7.setString(131 , Sn14.getText().trim());                  //student name
             pps7.setString(132 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(133 , R14.getText().trim());                   // marks_obtained 
             pps7.setString(134 , total_marks.getText().trim());                     // total_marks_  
            
                   double converted_marks_obtained14 = Double.parseDouble(R14.getText().trim());  double converted_total_marks14 = Double.parseDouble(total_marks.getText().trim());
                    int percetage14 =(int)(converted_marks_obtained14  / converted_total_marks14  * 100) ;
                  if ((percetage14  <= failed14 )&&(percetage14  >= totallyfailed14)){ p14  = "Failed";  }else if ((percetage14 <=passed14 )&&(percetage14  >= pass14 )   ){ p14 = "Pass";  }  else if ((percetage14  <= avaerage14 )&&(percetage14  >= avaerage_end14 )){ p14 = "Avaerage"; ; 
                   } else if ((percetage14  <=good14 )&&(percetage14  >= good_end14 ) ){ p14 ="Good";  }else if ((percetage14 <= very_good14 )&&(percetage14 >= very_good_end14 )){ p14 = "Very Good";    }else if ((percetage14 <= Excellent14 )&&(percetage14  >= very_good14 )   ){ p14 = "Excellent";   }  
            
             pps7.setDouble(135, percetage14 );                                           // Percentage  
             pps7.setDate(136, sqldate);
             pps7.setString(137 , class_teacher_class);
             pps7.setString(138, Term);
              pps7.setString(139 , p14 );//inserting cmements by students marks
             pps7.setString( 140, System_ID.getText().trim()); 
             
             
             
             
                pps7.setString(141 , Sn15.getText().trim());                  //student name
             pps7.setString(142 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(143 , R15.getText().trim());                   // marks_obtained 
             pps7.setString(144 , total_marks.getText().trim());                     // total_marks_  
            
                   double converted_marks_obtained15 = Double.parseDouble(R15.getText().trim());  double converted_total_marks15 = Double.parseDouble(total_marks.getText().trim());
                    int percetage15  =(int)(converted_marks_obtained15 / converted_total_marks15 * 100) ;
                  if ((percetage15 <= failed15 )&&(percetage15 >= totallyfailed15)){ p15 = "Failed";  }else if ((percetage15 <=passed15 )&&(percetage15  >= pass15 )   ){p15 = "Pass";  }  else if ((percetage15  <= avaerage15 )&&(percetage15  >= avaerage_end15 )){p15 = "Avaerage"; ; 
                   } else if ((percetage15 <=good15 )&&(percetage15 >= good_end15 ) ){ p15="Good";  }else if ((percetage15 <= very_good15 )&&(percetage15 >= very_good_end15 )){ p15 = "Very Good";    }else if ((percetage15 <= Excellent15 )&&(percetage15  >= very_good15 )   ){ p15= "Excellent";   }  
            
             pps7.setDouble(145, percetage15);                                           // Percentage  
             pps7.setDate(146, sqldate);
             pps7.setString(147 , class_teacher_class);
             pps7.setString(148, Term);
              pps7.setString(149 , p15);//inserting cmements by students marks
             pps7.setString( 150, System_ID.getText().trim());
             
           
             
           
                pps7.setString(151 , Sn16.getText().trim());                  //student name
             pps7.setString(152 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(153 , R16.getText().trim());                   // marks_obtained 
             pps7.setString(154 , total_marks.getText().trim());                     // total_marks_  
            
                   double converted_marks_obtained16 = Double.parseDouble(R16.getText().trim());  double converted_total_marks16 = Double.parseDouble(total_marks.getText().trim());
                    int percetage16 =(int)(converted_marks_obtained16  / converted_total_marks16  * 100) ;
                  if ((percetage16  <= failed16 )&&(percetage16 >= totallyfailed16)){ p16  = "Failed";  }else if ((percetage16 <=passed16 )&&(percetage16  >= pass16 )   ){ p16 = "Pass";  }  else if ((percetage16  <= avaerage16 )&&(percetage16  >= avaerage_end16 )){ p16 = "Avaerage"; ; 
                   } else if ((percetage16  <=good16 )&&(percetage16  >= good_end16 ) ){ p16 ="Good";  }else if ((percetage16 <= very_good16 )&&(percetage16 >= very_good_end16 )){ p16 = "Very Good";    }else if ((percetage16 <= Excellent16 )&&(percetage16  >= very_good16 )   ){ p16 = "Excellent";   }  
            
             pps7.setDouble(155, percetage16 );                                           // Percentage  
             pps7.setDate(156, sqldate);
             pps7.setString(157 , class_teacher_class);
             pps7.setString(158, Term);
              pps7.setString(159 , p16 );//inserting cmements by students marks
             pps7.setString( 160, System_ID.getText().trim()); 
     
             
             
        

             
                pps7.setString(161 , Sn17.getText().trim());                  //student name
             pps7.setString(162 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(163 , R17.getText().trim());                   // marks_obtained 
             pps7.setString(164 , total_marks.getText().trim());                     // total_marks_  
            
                   double converted_marks_obtained17 = Double.parseDouble(R17.getText().trim());  double converted_total_marks17= Double.parseDouble(total_marks.getText().trim());
                    int percetage17  =(int)(converted_marks_obtained17 / converted_total_marks17 * 100) ;
                  if ((percetage17 <= failed17 )&&(percetage17 >= totallyfailed17)){ p17 = "Failed";  }else if ((percetage17 <=passed17 )&&(percetage17  >= pass17 )   ){p17 = "Pass";  }  else if ((percetage17  <= avaerage17 )&&(percetage17  >= avaerage_end17 )){p17 = "Avaerage"; ; 
                   } else if ((percetage17 <=good17 )&&(percetage17 >= good_end17 ) ){ p17="Good";  }else if ((percetage17 <= very_good17 )&&(percetage17 >= very_good_end17 )){ p17 = "Very Good";    }else if ((percetage17 <= Excellent17 )&&(percetage17  >= very_good17  )   ){ p17 = "Excellent";   }  
            
             pps7.setDouble(165, percetage17);                                           // Percentage  
             pps7.setDate(166, sqldate);
             pps7.setString(167 , class_teacher_class);
             pps7.setString(168, Term);
              pps7.setString(169 , p17);//inserting cmements by students marks
              pps7.setString(170, System_ID.getText().trim());
             
             
             
                pps7.setString(171 , Sn18.getText().trim());                  //student name
             pps7.setString(172 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(173 , R18.getText().trim());                   // marks_obtained 
             pps7.setString(174 , total_marks.getText().trim());                     // total_marks_  
            
                   double converted_marks_obtained18 = Double.parseDouble(R18.getText().trim());  double converted_total_marks18 = Double.parseDouble(total_marks.getText().trim());
                    int percetage18=(int)(converted_marks_obtained18  / converted_total_marks18  * 100) ;
                  if ((percetage18  <= failed18 )&&(percetage18  >= totallyfailed18)){ p18  = "Failed";  }else if ((percetage18 <=passed18 )&&(percetage18  >= pass18 )   ){ p18 = "Pass";  }  else if ((percetage18  <= avaerage18 )&&(percetage18  >= avaerage_end18 )){ p18 = "Avaerage"; ; 
                   } else if ((percetage18 <=good18 )&&(percetage18  >= good_end18 ) ){ p18 ="Good";  }else if ((percetage18 <= very_good18 )&&(percetage18 >= very_good_end18 )){ p18 = "Very Good";    }else if ((percetage18 <= Excellent18 )&&(percetage18  >= very_good18 )   ){ p18 = "Excellent";   }  
            
             pps7.setDouble(175, percetage18 );                                           // Percentage  
             pps7.setDate(176, sqldate);
             pps7.setString(177 , class_teacher_class);
             pps7.setString(178, Term);
              pps7.setString(179 , p18 );//inserting cmements by students marks
             pps7.setString( 180, System_ID.getText().trim()); 
             
             
             
             
                pps7.setString(181 , Sn19.getText().trim());                  //student name
             pps7.setString(182 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(183 , R19.getText().trim());                   // marks_obtained 
             pps7.setString(184 , total_marks.getText().trim());                     // total_marks_  
            
                   double converted_marks_obtained19 = Double.parseDouble(R19.getText().trim());  double converted_total_marks19 = Double.parseDouble(total_marks.getText().trim());
                    int percetage19  =(int)(converted_marks_obtained19 / converted_total_marks19 * 100) ;
                  if ((percetage19 <= failed19 )&&(percetage19 >= totallyfailed19)){ p19 = "Failed";  }else if ((percetage19 <=passed19 )&&(percetage19  >= pass19 )   ){p19 = "Pass";  }  else if ((percetage19  <= avaerage19 )&&(percetage19  >= avaerage_end19 )){p19 = "Avaerage"; ; 
                   } else if ((percetage19 <=good19 )&&(percetage19 >= good_end19 ) ){ p19="Good";  }else if ((percetage19 <= very_good19 )&&(percetage19 >= very_good_end19 )){ p19 = "Very Good";    }else if ((percetage19 <= Excellent19 )&&(percetage19  >= very_good19 )   ){ p19= "Excellent";   }  
            
             pps7.setDouble(185, percetage19);                                           // Percentage  
             pps7.setDate(186, sqldate);
             pps7.setString(187 , class_teacher_class);
             pps7.setString(188, Term);
              pps7.setString(189 , p19);//inserting cmements by students marks
             pps7.setString( 190, System_ID.getText().trim());
             
             
             
                pps7.setString(191 , Sn20.getText().trim());                  //student name
             pps7.setString(192 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(193 , R20.getText().trim());                   // marks_obtained 
             pps7.setString(194 , total_marks.getText().trim());                     // total_marks_  
            
                   double converted_marks_obtained20 = Double.parseDouble(R20.getText().trim());  double converted_total_marks20= Double.parseDouble(total_marks.getText().trim());
                    int percetage20=(int)(converted_marks_obtained20  / converted_total_marks20  * 100) ;
                  if ((percetage20  <= failed20 )&&(percetage20 >= totallyfailed20)){ p20  = "Failed";  }else if ((percetage20 <=passed20 )&&(percetage20  >= pass20 )   ){ p20 = "Pass";  }  else if ((percetage20  <= avaerage20 )&&(percetage20  >= avaerage_end20 )){ p20 = "Avaerage"; ; 
                   } else if ((percetage20  <=good20 )&&(percetage20  >= good_end20 ) ){ p20 ="Good";  }else if ((percetage20 <= very_good20 )&&(percetage20 >= very_good_end20 )){ p20 = "Very Good";    }else if ((percetage20 <= Excellent20 )&&(percetage20  >= very_good20 )   ){ p20 = "Excellent";   }  
            
             pps7.setDouble(195, percetage20 );                                           // Percentage  
             pps7.setDate(196, sqldate);
             pps7.setString(197 , class_teacher_class);
             pps7.setString(198, Term);
              pps7.setString(199 , p20 );//inserting cmements by students marks
             pps7.setString( 200, System_ID.getText().trim()); 
             
             
             

 pps7.setString(201 ,Sn21.getText().trim());//student name
 pps7.setString(202 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString(203 ,R21.getText().trim());// marks_obtained 
pps7.setString(204 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained21 = Double.parseDouble(R21.getText().trim()); double converted_total_marks21= Double.parseDouble(total_marks.getText().trim());
int percetage21=(int)(converted_marks_obtained21  / converted_total_marks21  * 100) ; 

if ((percetage21  <= failed21 )&&(percetage21 >= totallyfailed21)){ 
  p21  = "Failed";  
}else if ((percetage21 <=passed21 )&&(percetage21  >= pass21 )   ){ 
  p21 = "Pass"; 
}  else if ((percetage21  <= avaerage21 )&&(percetage21  >= avaerage_end21 )){ p21 = "Avaerage"; 
} else if ((percetage21  <=good21 )&&(percetage21  >= good_end21 ) )
{ 
p21 ="Good"; 
 }else if ((percetage21 <= very_good21 )&&(percetage21 >= very_good_end21 ))
 {
 
p21 = "Very Good";    
   }else if ((percetage21 <= Excellent21 )&&(percetage21  >= very_good21 )   )
 {
 
p21 = "Excellent";  
  }  
            
pps7.setDouble(205, percetage21 );                                            
pps7.setDate(206, sqldate);
pps7.setString(207 , class_teacher_class);
pps7.setString(208, Term);
pps7.setString(209 , p21 );//inserting cmements by stude
pps7.setString( 210, System_ID.getText().trim()); 






pps7.setString(211 ,Sn22.getText().trim());//student name
 pps7.setString(212 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString(213 ,R22.getText().trim());// marks_obtained 
pps7.setString(214 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained22 = Double.parseDouble(R22.getText().trim()); 

double converted_total_marks22= Double.parseDouble(total_marks.getText().trim());

int percetage22=(int)(converted_marks_obtained22  / converted_total_marks22  * 100) ;

if ((percetage22  <= failed22 )&&(percetage22 >= totallyfailed22)){ 
  p22  = "Failed";  
}else if ((percetage22 <=passed22 )&&(percetage22  >= pass22 )   ){ 
  p22 = "Pass"; 
}  else if ((percetage22  <= avaerage22 )&&(percetage22  >= avaerage_end22 ))
{ 
p22 = "Avaerage"; 
} 
else if ((percetage22  <=good22 )&&(percetage22  >= good_end22 ) )
{ 
p22 ="Good"; 
 }else if ((percetage22 <= very_good22 )&&(percetage22 >= very_good_end22 ))
 {
  p22 = "Very Good";    
 }else if ((percetage22 <= Excellent22 )&&(percetage22  >= very_good22 )   )
 {
  p22 = "Excellent";  
 
  }  
            
pps7.setDouble(215, percetage22 );                                            
pps7.setDate(216, sqldate);
pps7.setString(217 , class_teacher_class);
pps7.setString(218, Term);
pps7.setString(219 , p22 );//inserting cmements by stude
pps7.setString( 220, System_ID.getText().trim()); 



pps7.setString(221 ,Sn23.getText().trim());//student name
 pps7.setString(222 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString(223 ,R23.getText().trim());// marks_obtained 
pps7.setString(224 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained23 = Double.parseDouble(R23.getText().trim()); 

double converted_total_marks23= Double.parseDouble(total_marks.getText().trim());

int percetage23=(int)(converted_marks_obtained23  / converted_total_marks23  * 100) ;

if ((percetage23  <= failed23 )&&(percetage23 >= totallyfailed23)){ 
  p23  = "Failed";  
}else if ((percetage23 <=passed23 )&&(percetage23  >= pass23 )   ){ 
  p23 = "Pass"; 
}  else if ((percetage23  <= avaerage23 )&&(percetage23  >= avaerage_end23 ))
{ 
p23 = "Avaerage"; 
} 
else if ((percetage23  <=good23 )&&(percetage23  >= good_end23 ) )
{ 
p23 ="Good"; 
 }else if ((percetage23 <= very_good23 )&&(percetage23 >= very_good_end23 ))
 {
  p23 = "Very Good";    
 }else if ((percetage23 <= Excellent23 )&&(percetage23  >= very_good23 )   )
 {
  p23 = "Excellent";  
 
  }  
            
pps7.setDouble(225, percetage23 );                                            
pps7.setDate(226, sqldate);
pps7.setString(227 , class_teacher_class);
pps7.setString(228, Term);
pps7.setString(229 , p23 );//inserting cmements by stude
pps7.setString( 230, System_ID.getText().trim()); 

             
             
 
pps7.setString(231 ,Sn24.getText().trim());//student name
 pps7.setString(232 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString(233 ,R24.getText().trim());// marks_obtained 
pps7.setString(234 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained24 = Double.parseDouble(R24.getText().trim()); 

double converted_total_marks24= Double.parseDouble(total_marks.getText().trim());

int percetage24 =(int)(converted_marks_obtained24  / converted_total_marks24  * 100) ;

if ((percetage24  <= failed24 )&&(percetage24 >= totallyfailed24 )){ 
  p24  = "Failed";  
}else if ((percetage24 <=passed24 )&&(percetage24  >= pass24 )   ){ 
  p24 = "Pass"; 
}  else if ((percetage24  <= avaerage24)&&(percetage24  >= avaerage_end24 ))
{ 
p24 = "Avaerage"; 
} 
else if ((percetage24  <=good24 )&&(percetage24  >= good_end24) )
{ 
p24 ="Good"; 
 }else if ((percetage24 <= very_good24 )&&(percetage24 >= very_good_end24 ))
 {
  p24 = "Very Good";    
 }else if ((percetage24 <= Excellent24 )&&(percetage24  >= very_good24 )   )
 {
  p24 = "Excellent";  
 
  }  
            
pps7.setDouble(235, percetage24 );                                            
pps7.setDate(236, sqldate);
pps7.setString(237 , class_teacher_class);
pps7.setString(238, Term);
pps7.setString(239 , p24 );//inserting cmements by stude
pps7.setString( 240, System_ID.getText().trim());





pps7.setString( 241 ,Sn25 .getText().trim());//student name
 pps7.setString(  242 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 243 ,R25 .getText().trim());// marks_obtained 
pps7.setString( 244 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained25 = Double.parseDouble(R25.getText().trim()); 

double converted_total_marks25 = Double.parseDouble(total_marks.getText().trim());

int percetage25 =(int)(converted_marks_obtained25  / converted_total_marks25  * 100) ;

if ((percetage25  <= failed25 )&&(percetage25 >= totallyfailed25)){ 
  p25  = "Failed";  
}else if ((percetage25 <=passed25 )&&(percetage25  >= pass25 )   ){ 
  p25 = "Pass"; 
}  else if ((percetage25  <= avaerage25 )&&(percetage25  >= avaerage_end25 ))
{ 
p25 = "Avaerage"; 
} 
else if ((percetage25  <=good25 )&&(percetage25  >= good_end25 ) )
{ 
p25 ="Good"; 
 }else if ((percetage25 <= very_good25 )&&(percetage25 >= very_good_end25 ))
 {
  p25  = "Very Good";    
 }else if ((percetage25 <= Excellent25 )&&(percetage25  >= very_good25)   )
 {
  p25 = "Excellent";  
 
  }  
            
pps7.setDouble( 245, percetage25 );                                            
pps7.setDate(  246 , sqldate);
pps7.setString(  247 , class_teacher_class);
pps7.setString(  248, Term);
pps7.setString(  249 , p25 );//inserting cmements by stude
pps7.setString( 250, System_ID.getText().trim());


  

pps7.setString( 251 ,Sn26 .getText().trim());//student name
 pps7.setString(  252 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 253 ,R26 .getText().trim());// marks_obtained 
pps7.setString( 254 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained26 = Double.parseDouble(R26.getText().trim()); 

double converted_total_marks26 = Double.parseDouble(total_marks.getText().trim());

int percetage26 =(int)(converted_marks_obtained26  / converted_total_marks26  * 100) ;

if ((percetage26  <= failed26)&&(percetage26 >= totallyfailed26)){ 
  p26  = "Failed";  
}else if ((percetage26 <=passed26 )&&(percetage26  >= pass26 )   ){ 
  p26 = "Pass"; 
}  else if ((percetage26  <= avaerage26 )&&(percetage26  >= avaerage_end26 ))
{ 
p26 = "Avaerage"; 
} 
else if ((percetage26  <=good26 )&&(percetage26  >= good_end26 ) )
{ 
p26 ="Good"; 
 }else if ((percetage26 <= very_good26 )&&(percetage26 >= very_good_end26 ))
 {
  p26  = "Very Good";    
 }else if ((percetage26 <= Excellent26 )&&(percetage26  >= very_good26 )   )
 {
  p26 = "Excellent";  
 
  }  
            
pps7.setDouble( 255, percetage26 );                                            
pps7.setDate(  256 , sqldate);
pps7.setString(  257 , class_teacher_class);
pps7.setString(  258, Term);
pps7.setString(  259 , p26 );//inserting cmements by stude
pps7.setString( 260, System_ID.getText().trim());





pps7.setString( 261 ,Sn27 .getText().trim());//student name
 pps7.setString(  262 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 263 ,R27 .getText().trim());// marks_obtained 
pps7.setString( 264 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained27 = Double.parseDouble(R27.getText().trim()); 

double converted_total_marks27 = Double.parseDouble(total_marks.getText().trim());

int percetage27 =(int)(converted_marks_obtained27  / converted_total_marks27  * 100) ;

if ((percetage27  <= failed27 )&&(percetage27 >= totallyfailed27)){ 
  p27  = "Failed";  
}else if ((percetage27 <=passed27 )&&(percetage27  >= pass27 )   ){ 
  p27 = "Pass"; 
}  else if ((percetage27  <= avaerage27 )&&(percetage27  >= avaerage_end27 ))
{ 
 p27 = "Avaerage"; 
} 
else if ((percetage27  <=good27 )&&(percetage27  >= good_end27 ) )
{ 
 p27 ="Good"; 
 }else if ((percetage27 <= very_good27 )&&(percetage27 >= very_good_end27 ))
 {
  p27  = "Very Good";    
 }else if ((percetage27 <= Excellent27 )&&(percetage27  >= very_good27 )   )
 {
  p27 = "Excellent";  
 
  }  
            
pps7.setDouble( 265, percetage27 );                                            
pps7.setDate(  266 , sqldate);
pps7.setString(  267 , class_teacher_class);
pps7.setString(  268, Term);
pps7.setString(  269 , p27 );//inserting cmements by stude
pps7.setString( 270, System_ID.getText().trim());







pps7.setString( 271 ,Sn28 .getText().trim());//student name
 pps7.setString(  272 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 273 ,R28 .getText().trim());// marks_obtained 
pps7.setString( 274 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained28 = Double.parseDouble(R28.getText().trim()); 

double converted_total_marks28 = Double.parseDouble(total_marks.getText().trim());

int percetage28 =(int)(converted_marks_obtained28  / converted_total_marks28  * 100) ;

if ((percetage28  <= failed28 )&&(percetage28 >= totallyfailed28)){ 
  p28  = "Failed";  
}else if ((percetage28 <=passed28 )&&(percetage28  >= pass28 )   ){ 
  p28 = "Pass"; 
}  else if ((percetage28  <= avaerage28 )&&(percetage28  >= avaerage_end28 ))
{ 
 p28 = "Avaerage"; 
} 
else if ((percetage28  <=good28 )&&(percetage28  >= good_end28 ) )
{ 
 p28 ="Good"; 
 }else if ((percetage28 <= very_good28 )&&(percetage28 >= very_good_end28 ))
 {
  p28  = "Very Good";    
 }else if ((percetage28 <= Excellent28 )&&(percetage28  >= very_good28 )   )
 {
  p28 = "Excellent";  
 
  }  
            
pps7.setDouble( 275, percetage28 );                                            
pps7.setDate(  276 , sqldate);
pps7.setString(  277 , class_teacher_class);
pps7.setString(  278, Term);
pps7.setString(  279 , p28 );//inserting cmements by stude
pps7.setString( 280, System_ID.getText().trim());


pps7.setString( 281 ,Sn29 .getText().trim());//student name
 pps7.setString(  282 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 283 ,R29 .getText().trim());// marks_obtained 
pps7.setString( 284 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained29 = Double.parseDouble(R29.getText().trim()); 

double converted_total_marks29 = Double.parseDouble(total_marks.getText().trim());

int percetage29 =(int)(converted_marks_obtained29  / converted_total_marks29  * 100) ;

if ((percetage29  <= failed29 )&&(percetage29 >= totallyfailed29)){ 
  p29  = "Failed";  
}else if ((percetage29 <=passed29 )&&(percetage29  >= pass29 )   ){ 
  p29 = "Pass"; 
}  else if ((percetage29  <= avaerage29 )&&(percetage29  >= avaerage_end29 ))
{ 
 p29 = "Avaerage"; 
} 
else if ((percetage29  <=good29 )&&(percetage29  >= good_end29 ) )
{ 
 p29 ="Good"; 
 }else if ((percetage29 <= very_good29 )&&(percetage29 >= very_good_end29 ))
 {
  p29  = "Very Good";    
 }else if ((percetage29 <= Excellent29 )&&(percetage29  >= very_good29 )   )
 {
  p29 = "Excellent";  
 
  }  
            
pps7.setDouble( 285, percetage29 );                                            
pps7.setDate(  286 , sqldate);
pps7.setString(  287 , class_teacher_class);
pps7.setString(  288, Term);
pps7.setString(  289 , p29 );//inserting cmements by stude
pps7.setString( 290, System_ID.getText().trim());




pps7.setString( 291 ,Sn30 .getText().trim());//student name
 pps7.setString(292 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 293 ,R30 .getText().trim());// marks_obtained 
pps7.setString( 294 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained30 = Double.parseDouble(R30.getText().trim()); 

double converted_total_marks30 = Double.parseDouble(total_marks.getText().trim());

int percetage30 =(int)(converted_marks_obtained30  / converted_total_marks30  * 100) ;

if ((percetage30  <= failed30 )&&(percetage30 >= totallyfailed30)){ 
  p30  = "Failed";  
}else if ((percetage30 <=passed30 )&&(percetage30  >= pass30 )   ){ 
  p30 = "Pass"; 
}  else if ((percetage30  <= avaerage30 )&&(percetage30  >= avaerage_end30 ))
{ 
 p30 = "Avaerage"; 
} 
else if ((percetage30  <=good30 )&&(percetage30  >= good_end30 ) )
{ 
 p30 ="Good"; 
 }else if ((percetage30 <= very_good30)&&(percetage30 >= very_good_end30 ))
 {
  p30  = "Very Good";    
 }else if ((percetage30 <= Excellent30 )&&(percetage30  >= very_good30 )   )
 {
  p30 = "Excellent";  
 
  }  
            
pps7.setDouble( 295, percetage30 );                                            
pps7.setDate(  296 , sqldate);
pps7.setString(  297 , class_teacher_class);
pps7.setString(  298, Term);
pps7.setString(  299 , p30 );//inserting cmements by stude
pps7.setString( 300, System_ID.getText().trim());









pps7.setString( 301 ,Sn31 .getText().trim());//student name
 pps7.setString(  302 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 303 ,R31 .getText().trim());// marks_obtained 
pps7.setString( 304 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained31 = Double.parseDouble(R31.getText().trim()); 

double converted_total_marks31 = Double.parseDouble(total_marks.getText().trim());

int percetage31 =(int)(converted_marks_obtained31  / converted_total_marks31  * 100) ;

if (( percetage31  <= failed31 )&&( percetage31 >= totallyfailed31)){ 
  p31  = "Failed";  
}else if (( percetage31 <=passed31 )&&( percetage31 >= pass31 )   ){ 
  p31 = "Pass";  
}  else if (( percetage31  <= avaerage31 )&&(  percetage31  >= avaerage_end31 ))
{ 
 p31 = "Avaerage"; 
} 
else if ((  percetage31  <=good31 )&&(  percetage31  >= good_end31 ) )
{ 
 p31 ="Good"; 
 }else if ((  percetage31 <= very_good31 )&&(percetage31 >= very_good_end31 ))
 {
  p31  = "Very Good";    
 }else if (( percetage31 <= Excellent31 )&&( percetage31  >= very_good31 )   )
 {
  p31 = "Excellent";  
 
  }  
            
pps7.setDouble( 305,  percetage31 );                                            
pps7.setDate(  306 , sqldate);
pps7.setString(  307 , class_teacher_class);
pps7.setString(  308, Term);
pps7.setString(  309 , p31 );//inserting cmements by stude
pps7.setString( 310, System_ID.getText().trim());



















pps7.setString( 311 ,Sn32 .getText().trim());//student name
 pps7.setString(  312 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 313 ,R32 .getText().trim());// marks_obtained 
pps7.setString( 314 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained32 = Double.parseDouble(R32.getText().trim()); 

double converted_total_marks32 = Double.parseDouble(total_marks.getText().trim());

int percetage32 =(int)(converted_marks_obtained32  / converted_total_marks32  * 100) ;

if (( percetage32  <= failed32 )&&( percetage32 >= totallyfailed32)){ 
  p32  = "Failed";  
}else if (( percetage32 <=passed32 )&&( percetage32 >= pass32 )   ){ 
  p32 = "Pass";  
}  else if (( percetage32  <= avaerage32 )&&(  percetage32  >= avaerage_end32 ))
{ 
 p32 = "Avaerage"; 
} 
else if (( percetage32  <=good32 )&&(  percetage32  >= good_end32 ) )
{ 
 p32 ="Good"; 
 }else if ((  percetage32 <= very_good32 )&&(percetage32 >= very_good_end32 ))
 {
  p32  = "Very Good";    
 }else if (( percetage32 <= Excellent32 )&&( percetage32  >= very_good32 )   )
 {
  p32 = "Excellent";  
 
  }  
            
pps7.setDouble( 315,  percetage32 );                                            
pps7.setDate(  316 , sqldate);
pps7.setString(  317 , class_teacher_class);
pps7.setString(  318, Term);
pps7.setString(  319 , p32 );//inserting cmements by stude
pps7.setString( 320, System_ID.getText().trim());










pps7.setString( 321 ,Sn33 .getText().trim());//student name
 pps7.setString(  322 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 323 ,R33 .getText().trim());// marks_obtained 
pps7.setString( 324 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained33 = Double.parseDouble(R33.getText().trim()); 

double converted_total_marks33 = Double.parseDouble(total_marks.getText().trim());

int percetage33 =(int)(converted_marks_obtained33  / converted_total_marks33  * 100) ;

if (( percetage33  <= failed33 )&&( percetage33 >= totallyfailed33)){ 
  p33  = "Failed";  
}else if (( percetage33 <=passed33 )&&( percetage33 >= pass33 )   ){ 
  p33 = "Pass";  
}  else if (( percetage33  <= avaerage33 )&&(  percetage33  >= avaerage_end33 ))
{ 
 p33 = "Avaerage"; 
} 
else if (( percetage33  <=good33 )&&( percetage33  >= good_end33 ) )
{ 
 p33 ="Good"; 
 }else if ((  percetage33 <= very_good33 )&&( percetage33 >= very_good_end33 ))
 {
  p33  = "Very Good";    
 }else if (( percetage33 <= Excellent33 )&&( percetage33  >= very_good33 )   )
 {
  p33 = "Excellent";  
 
  }  
            
pps7.setDouble( 325, percetage33 );                                            
pps7.setDate(  326 , sqldate);
pps7.setString(  327 , class_teacher_class);
pps7.setString(  328, Term);
pps7.setString(  329 , p33 );//inserting cmements by stude
pps7.setString( 330, System_ID.getText().trim());



pps7.setString( 331 ,Sn34 .getText().trim());//student name
 pps7.setString(  332 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 333 ,R34 .getText().trim());// marks_obtained 
pps7.setString( 334 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained34 = Double.parseDouble(R34.getText().trim()); 

double converted_total_marks34 = Double.parseDouble(total_marks.getText().trim());

int percetage34 =(int)(converted_marks_obtained34  / converted_total_marks34  * 100) ;

if (( percetage34  <= failed34 )&&( percetage34 >= totallyfailed34)){ 
  p34  = "Failed";  
}else if (( percetage34 <=passed34 )&&( percetage34 >= pass34 )   ){ 
  p34 = "Pass";  
}  else if (( percetage34  <= avaerage34 )&&(  percetage34  >= avaerage_end34 ))
{ 
 p34 = "Avaerage"; 
} 
else if ((  percetage34  <=good34 )&&(  percetage34  >= good_end34 ) )
{ 
 p34 ="Good"; 
 }else if ((  percetage34 <= very_good34 )&&( percetage34 >= very_good_end34 ))
 {
  p34  = "Very Good";    
 }else if (( percetage34 <= Excellent34 )&&( percetage34  >= very_good34 )   )
 {
  p34 = "Excellent";  
 
  }  
            
pps7.setDouble( 335,  percetage34 );                                            
pps7.setDate(  336 , sqldate);
pps7.setString(  337 , class_teacher_class);
pps7.setString(  338, Term);
pps7.setString(  339 , p34 );//inserting cmements by stude
pps7.setString( 340, System_ID.getText().trim());








pps7.setString( 341 ,Sn35 .getText().trim());//student name
 pps7.setString(  342 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 343 ,R35 .getText().trim());// marks_obtained 
pps7.setString( 344 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained35 = Double.parseDouble(R35.getText().trim()); 

double converted_total_marks35 = Double.parseDouble(total_marks.getText().trim());

int percetage35 =(int)(converted_marks_obtained35  / converted_total_marks35  * 100) ;

if (( percetage35  <= failed35 )&&( percetage35 >= totallyfailed35)){ 
  p35  = "Failed";  
}else if (( percetage35 <=passed35 )&&( percetage35 >= pass35 )   ){ 
  p35 = "Pass";  
}  else if (( percetage35  <= avaerage35 )&&(  percetage35  >= avaerage_end35 )){ 
 p35 = "Avaerage"; 
} 
else if (( percetage35  <=good35 )&&(  percetage35  >= good_end35 ) )
{ 
 p35 ="Good"; 
 }else if ((  percetage35 <= very_good35 )&&( percetage35 >= very_good_end35 ))
 {
  p35  = "Very Good";    
 }else if (( percetage35 <= Excellent35 )&&( percetage35  >= very_good35 )   )
 {
  p35 = "Excellent";  
 
  }  
            
pps7.setDouble( 345,  percetage35 );                                            
pps7.setDate(  346 , sqldate);
pps7.setString(  347 , class_teacher_class);
pps7.setString(  348, Term);
pps7.setString(  349 , p35 );//inserting cmements by stude
pps7.setString( 350, System_ID.getText().trim());



pps7.setString( 351 ,Sn36 .getText().trim());//student name
 pps7.setString(  352 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 353 ,R36 .getText().trim());// marks_obtained 
pps7.setString( 354 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained36 = Double.parseDouble(R36.getText().trim()); 

double converted_total_marks36 = Double.parseDouble(total_marks.getText().trim());

int percetage36 =(int)(converted_marks_obtained36  / converted_total_marks36  * 100) ;

if (( percetage36  <= failed36 )&&( percetage36 >= totallyfailed36)){ 
  p36  = "Failed";  
}else if (( percetage36 <=passed36 )&&( percetage36 >= pass36 )   ){ 
  p36 = "Pass";  
}  else if (( percetage36  <= avaerage36 )&&(  percetage36  >= avaerage_end36 ))
{ 
 p36 = "Avaerage"; 
} 
else if ((  percetage36  <=good36 )&&(  percetage36  >= good_end36 ) )
{ 
 p36 ="Good"; 
 }else if ((  percetage36 <= very_good36 )&&( percetage36 >= very_good_end36 ))
 {
  p36  = "Very Good";    
 }else if (( percetage36 <= Excellent36 )&&( percetage36  >= very_good36)   )
 {
  p36 = "Excellent";  
 
  }  
            
pps7.setDouble( 355,  percetage36 );                                            
pps7.setDate(  356 , sqldate);
pps7.setString(  357 , class_teacher_class);
pps7.setString(  358, Term);
pps7.setString(  359 , p36 );//inserting cmements by stude
pps7.setString( 360, System_ID.getText().trim());



pps7.setString( 361 ,Sn37 .getText().trim());//student name
 pps7.setString(  362 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 363 ,R37 .getText().trim());// marks_obtained 
pps7.setString( 364 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained37 = Double.parseDouble(R37.getText().trim()); 

double converted_total_marks37 = Double.parseDouble(total_marks.getText().trim());

int percetage37 =(int)(converted_marks_obtained37  / converted_total_marks37  * 100) ;

if (( percetage37  <= failed37 )&&( percetage37 >= totallyfailed37)){ 
  p37  = "Failed";  
}else if (( percetage37 <=passed37 )&&( percetage37 >= pass37 )   ){ 
  p37 = "Pass";  
}  else if (( percetage37  <= avaerage37 )&&(  percetage37  >= avaerage_end37 ))
{ 
 p37 = "Avaerage"; 
} 
else if ((  percetage37  <=good37 )&&(  percetage37  >= good_end37) )
{ 
 p37 ="Good"; 
 }else if ((  percetage37 <= very_good37 )&&( percetage37 >= very_good_end37 ))
 {
  p37  = "Very Good";    
 }else if (( percetage37 <= Excellent37 )&&( percetage37  >= very_good37 )   )
 {
  p37 = "Excellent";  
 
  }  
            
pps7.setDouble( 365,  percetage37 );                                            
pps7.setDate(  366 , sqldate);
pps7.setString(  367 , class_teacher_class);
pps7.setString(  368, Term);
pps7.setString(  369 , p37 );//inserting cmements by stude
pps7.setString( 370, System_ID.getText().trim());






pps7.setString( 371 ,Sn38 .getText().trim());//student name
 pps7.setString(  372 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 373 ,R38 .getText().trim());// marks_obtained 
pps7.setString( 374 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained38 = Double.parseDouble(R38.getText().trim()); 

double converted_total_marks38 = Double.parseDouble(total_marks.getText().trim());

int percetage38 =(int)(converted_marks_obtained38  / converted_total_marks38  * 100) ;

if (( percetage38  <= failed38 )&&( percetage38 >= totallyfailed38)){ 
  p38  = "Failed";  
}else if (( percetage38 <=passed38 )&&( percetage38 >= pass38 )   ){ 
  p38 = "Pass";  
}  else if (( percetage38  <= avaerage38 )&&(  percetage38  >= avaerage_end38 ))
{ 
 p38 = "Avaerage"; 
} 
else if ((  percetage38  <=good38 )&&(  percetage38  >= good_end38 ) )
{ 
 p38 ="Good"; 
 }else if (( percetage38 <= very_good38 )&&( percetage38 >= very_good_end38 ))
 {
  p38  = "Very Good";    
 }else if (( percetage38 <= Excellent38 )&&( percetage38  >= very_good38 )   )
 {
  p38 = "Excellent";  
 
  }  
            
pps7.setDouble( 375,  percetage38 );                                            
pps7.setDate(  376 , sqldate);
pps7.setString(  377 , class_teacher_class);
pps7.setString(  378, Term);
pps7.setString(  379 , p38 );//inserting cmements by stude
pps7.setString( 380, System_ID.getText().trim());









pps7.setString( 381 ,Sn39 .getText().trim());//student name
 pps7.setString(  382 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 383 ,R39 .getText().trim());// marks_obtained 
pps7.setString( 384 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained39 = Double.parseDouble(R39.getText().trim()); 

double converted_total_marks39 = Double.parseDouble(total_marks.getText().trim());

int percetage39 =(int)(converted_marks_obtained39  / converted_total_marks39  * 100) ;

if (( percetage39  <= failed39 )&&( percetage39 >= totallyfailed39)){ 
  p39  = "Failed";  
}else if (( percetage39 <=passed39 )&&( percetage39 >= pass39 )   ){ 
  p39 = "Pass";  
}  else if (( percetage39  <= avaerage39 )&&(  percetage39  >= avaerage_end39 ))
{ 
 p39 = "Avaerage"; 
} 
else if ((  percetage39  <=good39 )&&(  percetage39  >= good_end39 ) )
{ 
 p39 ="Good"; 
 }else if ((  percetage39 <= very_good39 )&&( percetage39 >= very_good_end39 ))
 {
  p39  = "Very Good";    
 }else if (( percetage39 <= Excellent39 )&&( percetage39  >= very_good39 )   )
 {
  p39 = "Excellent";  
 
  }  
            
pps7.setDouble( 385,  percetage39 );                                            
pps7.setDate(  386 , sqldate);
pps7.setString(  387 , class_teacher_class);
pps7.setString(  388, Term);
pps7.setString(  389 , p39 );//inserting cmements by stude
pps7.setString( 390, System_ID.getText().trim());

///,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,



   pps7.setString( 391 ,Sn40 .getText().trim());//student name
 pps7.setString(  392 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 393 ,R40 .getText().trim());// marks_obtained 
pps7.setString( 394 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained40 = Double.parseDouble(R40.getText().trim()); 

double converted_total_marks40 = Double.parseDouble(total_marks.getText().trim());

int percetage40 =(int)(converted_marks_obtained40  / converted_total_marks40  * 100) ;

if (( percetage40  <= failed40 )&&( percetage40 >= totallyfailed40)){ 
  p40  = "Failed";  
}else if (( percetage40 <=passed49 )&&( percetage40 >= pass40 )   ){ 
  p40 = "Pass";  
}  else if (( percetage40  <= avaerage40 )&&(  percetage40  >= avaerage_end40 ))
{ 
 p40 = "Avaerage"; 
} 
else if ((  percetage40  <=good40)&&(  percetage40  >= good_end40 ) )
{ 
 p40 ="Good"; 
 }else if ((  percetage40 <= very_good40 )&&( percetage40 >= very_good_end40 ))
 {
  p40  = "Very Good";    
 }else if (( percetage40 <= Excellent40 )&&( percetage40  >= very_good40 )   )
 {
  p40 = "Excellent";  
 
  }  
            
pps7.setDouble( 395,  percetage40 );                                            
pps7.setDate(  396 , sqldate);
pps7.setString(  397 , class_teacher_class);
pps7.setString(  398, Term);
pps7.setString(  399 , p40 );//inserting cmements by stude
pps7.setString( 400, System_ID.getText().trim());





pps7.setString( 401 ,Sn41 .getText().trim());//student name
 pps7.setString(  402 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 403 ,R41 .getText().trim());// marks_obtained 
pps7.setString( 404 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained41 = Double.parseDouble(R41.getText().trim()); 

double converted_total_marks41 = Double.parseDouble(total_marks.getText().trim());

int percetage41 =(int)(converted_marks_obtained41  / converted_total_marks41  * 100) ;

if (( percetage41  <= failed41 )&&( percetage41 >= totallyfailed41)){ 
  p41  = "Failed";  
}else if (( percetage41 <=passed41 )&&( percetage41 >= pass41 )   ){ 
  p41 = "Pass";  
}  else if (( percetage41  <= avaerage41 )&&(  percetage41  >= avaerage_end41 ))
{ 
 p41 = "Avaerage"; 
} 
else if ((  percetage41  <=good41 )&&(  percetage41  >= good_end41 ) )
{ 
 p41 ="Good"; 
 }else if ((  percetage41 <= very_good41 )&&( percetage41 >= very_good_end41 ))
 {
  p41  = "Very Good";    
 }else if (( percetage41 <= Excellent41 )&&( percetage41  >= very_good41 )   )
 {
  p41 = "Excellent";  
 
  }  
            
pps7.setDouble( 405,  percetage41 );                                            
pps7.setDate(  406 , sqldate);
pps7.setString(  407 , class_teacher_class);
pps7.setString(  408, Term);
pps7.setString(  409 , p41 );//inserting cmements by stude
pps7.setString( 410, System_ID.getText().trim());            
             
             
             
  
pps7.setString( 411 ,Sn42 .getText().trim());//student name
 pps7.setString(  412 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 413 ,R42 .getText().trim());// marks_obtained 
pps7.setString( 414 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained42 = Double.parseDouble(R39.getText().trim()); 

double converted_total_marks42 = Double.parseDouble(total_marks.getText().trim());

int percetage42 =(int)(converted_marks_obtained42  / converted_total_marks42  * 100) ;

if (( percetage42  <= failed42 )&&( percetage42 >= totallyfailed42)){ 
  p42  = "Failed";  
}else if (( percetage42 <=passed42 )&&( percetage42 >= pass42 )   ){ 
  p42 = "Pass";  
}  else if (( percetage42  <= avaerage42 )&&(  percetage42  >= avaerage_end42 ))
{ 
 p42 = "Avaerage"; 
} 
else if ((  percetage42  <=good42 )&&(  percetage42  >= good_end42 ) )
{ 
 p42 ="Good"; 
 }else if ((  percetage42 <= very_good42 )&&( percetage42 >= very_good_end42 ))
 {
  p42  = "Very Good";    
 }else if (( percetage42 <= Excellent42 )&&( percetage42  >= very_good42 )   )
 {
  p42 = "Excellent";  
 
  }  
            
pps7.setDouble( 415,  percetage42 );                                            
pps7.setDate(  416 , sqldate);
pps7.setString(  417 , class_teacher_class);
pps7.setString(  418, Term);
pps7.setString(  419 , p42 );//inserting cmements by stude
pps7.setString( 420, System_ID.getText().trim());






pps7.setString( 421 ,Sn43 .getText().trim());//student name
 pps7.setString(  422 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 423 ,R43 .getText().trim());// marks_obtained 
pps7.setString( 424 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained43 = Double.parseDouble(R43.getText().trim()); 

double converted_total_marks43 = Double.parseDouble(total_marks.getText().trim());

int percetage43 =(int)(converted_marks_obtained43  / converted_total_marks43  * 100) ;

if (( percetage43  <= failed43 )&&( percetage43 >= totallyfailed43)){ 
  p43  = "Failed";  
}else if (( percetage43 <=passed43 )&&( percetage43 >= pass43 )   ){ 
  p43 = "Pass";  
}  else if (( percetage43  <= avaerage43 )&&(  percetage43  >= avaerage_end43 ))
{ 
 p43 = "Avaerage"; 
} 
else if ((  percetage43  <=good43 )&&(  percetage43  >= good_end43 ) )
{ 
 p43 ="Good"; 
 }else if ((  percetage43 <= very_good43 )&&( percetage43 >= very_good_end43 ))
 {
  p43  = "Very Good";    
 }else if (( percetage43 <= Excellent43 )&&( percetage43  >= very_good43 )   )
 {
  p43 = "Excellent";  
 
  }  
            
pps7.setDouble( 425,  percetage43 );                                            
pps7.setDate(  426 , sqldate);
pps7.setString(  427 , class_teacher_class);
pps7.setString(  428, Term);
pps7.setString(  429 , p43 );//inserting cmements by stude
pps7.setString( 430, System_ID.getText().trim());



pps7.setString( 431 ,Sn44 .getText().trim());//student name
 pps7.setString(  432 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 433 ,R44 .getText().trim());// marks_obtained 
pps7.setString( 434 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained44 = Double.parseDouble(R44.getText().trim()); 

double converted_total_marks44 = Double.parseDouble(total_marks.getText().trim());

int percetage44 =(int)(converted_marks_obtained44  / converted_total_marks44  * 100) ;

if (( percetage44  <= failed44 )&&( percetage44 >= totallyfailed44)){ 
  p44  = "Failed";  
}else if (( percetage44 <=passed44 )&&( percetage44 >= pass44 )   ){ 
  p44 = "Pass";  
}  else if (( percetage44  <= avaerage44 )&&(  percetage44  >= avaerage_end44 ))
{ 
 p44 = "Avaerage"; 
} 
else if ((  percetage44  <=good44 )&&(  percetage44  >= good_end44 ) )
{ 
 p44 ="Good"; 
 }else if ((  percetage44 <= very_good44 )&&( percetage44 >= very_good_end44 ))
 {
  p44  = "Very Good";    
 }else if (( percetage44 <= Excellent44 )&&( percetage44  >= very_good44 )   )
 {
  p44 = "Excellent";  
 
  }  
            
pps7.setDouble( 435,  percetage44 );                                            
pps7.setDate(  436 , sqldate);
pps7.setString(  437 , class_teacher_class);
pps7.setString(  438, Term);
pps7.setString(  439 , p44 );//inserting cmements by stude
pps7.setString( 440, System_ID.getText().trim());





pps7.setString( 441 ,Sn45 .getText().trim());//student name
 pps7.setString(  442 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 443 ,R45 .getText().trim());// marks_obtained 
pps7.setString( 444 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained45 = Double.parseDouble(R45.getText().trim()); 

double converted_total_marks45 = Double.parseDouble(total_marks.getText().trim());

int percetage45 =(int)(converted_marks_obtained45  / converted_total_marks45  * 100) ;

if (( percetage45  <= failed45 )&&( percetage45 >= totallyfailed45)){ 
  p45  = "Failed";  
}else if (( percetage45 <=passed45 )&&( percetage45 >= pass45 )   ){ 
  p45 = "Pass";  
}  else if (( percetage45  <= avaerage45 )&&(  percetage45  >= avaerage_end45 ))
{ 
 p45 = "Avaerage"; 
} 
else if ((  percetage45  <=good45 )&&(  percetage45  >= good_end45 ) )
{ 
 p45 ="Good"; 
 }else if ((  percetage45 <= very_good45 )&&( percetage45 >= very_good_end45 ))
 {
  p45  = "Very Good";    
 }else if (( percetage45 <= Excellent45 )&&( percetage45  >= very_good45 )   )
 {
  p45 = "Excellent";  
 
  }  
            
pps7.setDouble( 445,  percetage45 );                                            
pps7.setDate(  446 , sqldate);
pps7.setString(  447 , class_teacher_class);
pps7.setString(  448, Term);
pps7.setString(  449 , p45 );//inserting cmements by stude
pps7.setString(  450, System_ID.getText().trim());







pps7.setString( 451 ,Sn46 .getText().trim());//student name
 pps7.setString(  452 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 453 ,R46 .getText().trim());// marks_obtained 
pps7.setString( 454 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained46 = Double.parseDouble(R46.getText().trim()); 

double converted_total_marks46 = Double.parseDouble(total_marks.getText().trim());

int percetage46 =(int)(converted_marks_obtained46  / converted_total_marks46  * 100) ;

if (( percetage46  <= failed46 )&&( percetage46 >= totallyfailed46)){ 
  p46  = "Failed";  
}else if (( percetage46 <=passed46 )&&( percetage46 >= pass46 )   ){ 
  p46 = "Pass";  
}  else if (( percetage46  <= avaerage46 )&&(  percetage46  >= avaerage_end46 ))
{ 
 p46 = "Avaerage"; 
} 
else if ((  percetage46  <=good46 )&&(  percetage46  >= good_end46 ) )
{ 
 p46 ="Good"; 
 }else if ((  percetage46 <= very_good46 )&&( percetage46 >= very_good_end46 ))
 {
  p46  = "Very Good";    
 }else if (( percetage46 <= Excellent46 )&&( percetage46  >= very_good46 )   )
 {
  p46 = "Excellent";  
 
  }  
            
pps7.setDouble( 455,  percetage46 );                                            
pps7.setDate(  456 , sqldate);
pps7.setString(  457 , class_teacher_class);
pps7.setString(  458, Term);
pps7.setString(  459 , p46 );//inserting cmements by stude
pps7.setString( 460 , System_ID.getText().trim());






pps7.setString( 461 ,Sn47 .getText().trim());//student name
 pps7.setString(  462 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 463 ,R47 .getText().trim());// marks_obtained 
pps7.setString( 464 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained47 = Double.parseDouble(R47.getText().trim()); 

double converted_total_marks47 = Double.parseDouble(total_marks.getText().trim());

int percetage47 =(int)(converted_marks_obtained47  / converted_total_marks47  * 100) ;

if (( percetage47  <= failed47 )&&( percetage47 >= totallyfailed47)){ 
  p47  = "Failed";  
}else if (( percetage47 <=passed47 )&&( percetage47 >= pass47 )   ){ 
  p47 = "Pass";  
}  else if (( percetage47  <= avaerage47 )&&(  percetage47  >= avaerage_end47 ))
{ 
 p47 = "Avaerage"; 
} 
else if ((  percetage47  <=good47 )&&(  percetage47  >= good_end47 ) )
 { 
 p47 ="Good"; 
 }else if ((  percetage47 <= very_good47 )&&( percetage47 >= very_good_end47 ))
 {
  p47  = "Very Good";    
 }else if (( percetage47 <= Excellent47 )&&( percetage47  >= very_good47 )   )
 {
  p47 = "Excellent";  
 
  }  
            
pps7.setDouble( 465,  percetage47 );                                            
pps7.setDate(  466 , sqldate); 
pps7.setString(  467 , class_teacher_class);
pps7.setString(  468, Term);
pps7.setString(  469 , p47 );//inserting cmements by stude
pps7.setString( 470, System_ID.getText().trim());           
             
             
             
             
 pps7.setString( 471 ,Sn48 .getText().trim());//student name
 pps7.setString(  472 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 473 ,R48 .getText().trim());// marks_obtained 
pps7.setString( 474 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained48 = Double.parseDouble(R48.getText().trim()); 

double converted_total_marks48 = Double.parseDouble(total_marks.getText().trim());

int percetage48 =(int)(converted_marks_obtained48  / converted_total_marks48  * 100) ;
if (( percetage48  <= failed48 )&&( percetage48 >= totallyfailed48)){ 
  p48  = "Failed";  
}else if (( percetage48 <=passed48 )&&( percetage48 >= pass48 )   ){ 
  p48 = "Pass";  
}  else if (( percetage48  <= avaerage48 )&&(  percetage48  >= avaerage_end48 ))
{ 
 p48 = "Avaerage"; 
} 
else if ((  percetage48  <=good48 )&&(  percetage48  >= good_end48 ) )
{ 
 p48 ="Good"; 
 }else if ((  percetage48 <= very_good48 )&&( percetage48 >= very_good_end48 ))
 {
  p48  = "Very Good";    
 }else if (( percetage48 <= Excellent48 )&&( percetage48  >= very_good48 )   )
 {
  p48 = "Excellent";  
 
  }  
            
pps7.setDouble( 475,  percetage48 );                                            
pps7.setDate(  476 , sqldate); 
pps7.setString(  477 , class_teacher_class);
pps7.setString(  478, Term);
pps7.setString(  479 , p48 );//inserting cmements by stude
pps7.setString( 480, System_ID.getText().trim());





pps7.setString( 481 ,Sn49 .getText().trim());//student name
 pps7.setString(  482 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 483 ,R49 .getText().trim());// marks_obtained 
pps7.setString( 484 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained49 = Double.parseDouble(R49.getText().trim()); 

double converted_total_marks49 = Double.parseDouble(total_marks.getText().trim());

int percetage49 =(int)(converted_marks_obtained49  / converted_total_marks49  * 100) ;

if (( percetage49  <= failed49 )&&( percetage49 >= totallyfailed49)){ 
  p49  = "Failed";  
}else if (( percetage49 <=passed49 )&&( percetage49 >= pass49 )   ){ 
  p49 = "Pass";  
}  else if (( percetage49  <= avaerage49 )&&(  percetage49  >= avaerage_end49 ))
{ 
 p49 = "Avaerage"; 
} 
else if ((  percetage49  <=good49 )&&(  percetage49  >= good_end49 ) )
{ 
 p49 ="Good"; 
 }else if ((  percetage49 <= very_good49 )&&( percetage49 >= very_good_end49 ))
 {
  p49  = "Very Good";    
 }else if (( percetage49 <= Excellent49 )&&( percetage49  >= very_good49 )   )
 {
  p49 = "Excellent";  
 
  }  
            
pps7.setDouble( 485,  percetage49 );                                            
pps7.setDate(  486 , sqldate); 
pps7.setString(  487 , class_teacher_class);
pps7.setString(  488, Term);
pps7.setString(  489 , p49 );//inserting cmements by stude
pps7.setString( 490, System_ID.getText().trim());







pps7.setString( 491 ,Sn50 .getText().trim());//student name
 pps7.setString(  492 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 493 ,R50 .getText().trim());// marks_obtained 
pps7.setString( 494 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained50 = Double.parseDouble(R50.getText().trim()); 

double converted_total_marks50 = Double.parseDouble(total_marks.getText().trim());

int percetage50 =(int)(converted_marks_obtained50  / converted_total_marks50  * 100) ;

if (( percetage50  <= failed50 )&&( percetage50 >= totallyfailed50)){ 
  p50  = "Failed";  
}else if (( percetage50 <=passed50 )&&( percetage50 >= pass50 )   ){ 
  p50 = "Pass";  
}  else if (( percetage50  <= avaerage50 )&&(  percetage50  >= avaerage_end50 ))
{ 
 p50 = "Avaerage"; 
} 
else if ((  percetage50  <=good50 )&&(  percetage50  >= good_end50 ) )
{ 
 p50 ="Good"; 
 }else if ((  percetage50 <= very_good50 )&&( percetage50 >= very_good_end50 ))
 {
  p50  = "Very Good";    
 }else if (( percetage50 <= Excellent50 )&&( percetage50  >= very_good50 )   )
 {
  p50 = "Excellent";  
 
  }  
            
pps7.setDouble( 495,  percetage50 );                                            
pps7.setDate(  496 , sqldate); 
pps7.setString(  497 , class_teacher_class);
pps7.setString(  498, Term);
pps7.setString(  499 , p50 );//inserting cmements by stude
pps7.setString( 500, System_ID.getText().trim());






pps7.setString( 501 ,Sn51 .getText().trim());//student name
 pps7.setString(  502 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 503 ,R51 .getText().trim());// marks_obtained 
pps7.setString( 504 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained51 = Double.parseDouble(R50.getText().trim()); 

double converted_total_marks51 = Double.parseDouble(total_marks.getText().trim());

int percetage51 =(int)(converted_marks_obtained51  / converted_total_marks51  * 100) ;

if (( percetage51  <= failed51 )&&( percetage51 >= totallyfailed51)){ 
  p51  = "Failed";  
}else if (( percetage51 <=passed51 )&&( percetage51 >= pass51 )   ){ 
  p51 = "Pass";  
}  else if (( percetage51  <= avaerage51 )&&(  percetage51  >= avaerage_end51 ))
{ 
 p51 = "Avaerage"; 
} 
else if ((  percetage51  <=good51 )&&(  percetage51  >= good_end51 ) )
{ 
 p51 ="Good"; 
 }else if ((  percetage51 <= very_good51 )&&( percetage51 >= very_good_end51 ))
 {
  p51  = "Very Good";    
 }else if (( percetage51 <= Excellent51 )&&( percetage51  >= very_good51 )   )
 {
  p51 = "Excellent";  
 
  }  
            
pps7.setDouble( 505,  percetage51 );                                            
pps7.setDate(  506 , sqldate); 
pps7.setString(  507 , class_teacher_class);
pps7.setString(  508, Term);
pps7.setString(  509 , p51 );//inserting cmements by stude
pps7.setString( 510, System_ID.getText().trim());

            

pps7.setString( 511 ,Sn52 .getText().trim());//student name
 pps7.setString(  512 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 513 ,R52 .getText().trim());// marks_obtained 
pps7.setString( 514 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained52 = Double.parseDouble(R52.getText().trim()); 

double converted_total_marks52 = Double.parseDouble(total_marks.getText().trim());

int percetage52 =(int)(converted_marks_obtained52  / converted_total_marks52  * 100) ;

if (( percetage52  <= failed52 )&&( percetage52 >= totallyfailed52)){ 
  p52  = "Failed";  
}else if (( percetage52 <=passed52 )&&( percetage52 >= pass52 )   ){ 
  p52 = "Pass";  
}  else if (( percetage52  <= avaerage52 )&&(  percetage52  >= avaerage_end52 ))
{ 
 p52 = "Avaerage"; 
} 
else if ((  percetage52  <=good52 )&&(  percetage52  >= good_end52 ) )
{ 
 p52 ="Good"; 
 }else if ((  percetage52 <= very_good52 )&&( percetage52 >= very_good_end52 ))
 {
  p52  = "Very Good";    
 }else if (( percetage52 <= Excellent52 )&&( percetage52  >= very_good52 )   )
 {
  p52 = "Excellent";  
 
  }  
            
pps7.setDouble( 515,  percetage52 );                                            
pps7.setDate(  516 , sqldate); 
pps7.setString(  517 , class_teacher_class);
pps7.setString(  518, Term);
pps7.setString(  519 , p52 );//inserting cmements by stude
pps7.setString( 520, System_ID.getText().trim());


 

pps7.setString( 521 ,Sn53 .getText().trim());//student name
 pps7.setString(  522 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 523 ,R53 .getText().trim());// marks_obtained 
pps7.setString( 524 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained53 = Double.parseDouble(R53.getText().trim()); 

double converted_total_marks53 = Double.parseDouble(total_marks.getText().trim());

int percetage53 =(int)(converted_marks_obtained53  / converted_total_marks53  * 100) ;

if (( percetage53  <= failed53 )&&( percetage53 >= totallyfailed53)){ 
  p53  = "Failed";  
}else if (( percetage53 <=passed53 )&&( percetage53 >= pass53 )   ){ 
  p53 = "Pass";  
}  else if (( percetage53  <= avaerage53 )&&(  percetage53  >= avaerage_end53 ))
{ 
 p53 = "Avaerage"; 
} 
else if ((  percetage53  <=good53 )&&(  percetage53  >= good_end53 ) )
{ 
 p53 ="Good"; 
 }else if ((  percetage53 <= very_good53 )&&( percetage53 >= very_good_end53 ))
 {
  p53  = "Very Good";    
 }else if (( percetage53 <= Excellent53 )&&( percetage53  >= very_good53 )   )
 {
  p53 = "Excellent";  
 
  }  
            
pps7.setDouble( 525,  percetage53 );                                            
pps7.setDate(  526 , sqldate); 
pps7.setString(  527 , class_teacher_class);
pps7.setString(  528, Term);
pps7.setString(  529 , p53 );//inserting cmements by stude
pps7.setString( 530, System_ID.getText().trim());





pps7.setString( 531 ,Sn54 .getText().trim());//student name
 pps7.setString(  532 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 533 ,R54 .getText().trim());// marks_obtained 
pps7.setString( 534 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained54 = Double.parseDouble(R54.getText().trim()); 

double converted_total_marks54 = Double.parseDouble(total_marks.getText().trim());

int percetage54 =(int)(converted_marks_obtained54  / converted_total_marks54  * 100) ;

if (( percetage54  <= failed54 )&&( percetage54 >= totallyfailed54)){ 
  p54  = "Failed";  
}else if (( percetage54 <=passed54 )&&( percetage54 >= pass54 )   ){ 
  p54 = "Pass";  
}  else if (( percetage54  <= avaerage54 )&&(  percetage54  >= avaerage_end54 ))
{ 
 p54 = "Avaerage"; 
} 
else if ((  percetage54  <=good54 )&&(  percetage54  >= good_end54 ) )
{ 
 p54 ="Good"; 
 }else if ((  percetage54 <= very_good54 )&&( percetage54 >= very_good_end54 ))
 {
  p54  = "Very Good";    
 }else if (( percetage54 <= Excellent54 )&&( percetage54  >= very_good54 )   )
 {
  p54 = "Excellent";  
 
  }  
            
pps7.setDouble( 535,  percetage54 );                                            
pps7.setDate(  536 , sqldate); 
pps7.setString(  537 , class_teacher_class);
pps7.setString(  538, Term);
pps7.setString(  539 , p54 );//inserting cmements by stude
pps7.setString( 540, System_ID.getText().trim());




pps7.setString( 541 ,Sn55 .getText().trim());//student name
 pps7.setString(  542 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 543 ,R55 .getText().trim());// marks_obtained 
pps7.setString( 544 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained55 = Double.parseDouble(R55.getText().trim()); 

double converted_total_marks55 = Double.parseDouble(total_marks.getText().trim());

int percetage55 =(int)(converted_marks_obtained55  / converted_total_marks55  * 100) ;

if (( percetage55  <= failed55 )&&( percetage55 >= totallyfailed55)){ 
  p55  = "Failed";  
}else if (( percetage55 <=passed55 )&&( percetage55 >= pass55 )   ){ 
  p55 = "Pass";  
}  else if (( percetage55  <= avaerage55 )&&(  percetage55  >= avaerage_end55 ))
{ 
 p55 = "Avaerage"; 
} 
else if ((  percetage55  <=good55 )&&(  percetage55  >= good_end55 ) )
{ 
 p55 ="Good"; 
 }else if ((  percetage55 <= very_good55 )&&( percetage55 >= very_good_end55 ))
 {
  p55  = "Very Good";    
 }else if (( percetage55 <= Excellent55 )&&( percetage55  >= very_good55 )   )
 {
  p55 = "Excellent";  
 
  }  
            
pps7.setDouble( 545,  percetage55 );                                            
pps7.setDate(  546 , sqldate); 
pps7.setString(  547 , class_teacher_class);
pps7.setString(  548, Term);
pps7.setString(  549 , p55 );//inserting cmements by stude
pps7.setString( 550, System_ID.getText().trim());




 


pps7.setString( 551 ,Sn56 .getText().trim());//student name
 pps7.setString(  552 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 553 ,R56 .getText().trim());// marks_obtained 
pps7.setString( 554 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained56 = Double.parseDouble(R56.getText().trim()); 

double converted_total_marks56 = Double.parseDouble(total_marks.getText().trim());

int percetage56 =(int)(converted_marks_obtained56  / converted_total_marks56  * 100) ;

if (( percetage56  <= failed55 )&&( percetage56 >= totallyfailed56)){ 
  p56  = "Failed";  
}else if (( percetage56 <=passed56 )&&( percetage56 >= pass56 )   ){ 
  p56 = "Pass";  
}  else if (( percetage56  <= avaerage56 )&&(  percetage56  >= avaerage_end56 ))
{ 
 p56 = "Avaerage"; 
} 
else if ((  percetage56  <=good56 )&&(  percetage56  >= good_end56 ) )
{ 
 p56 ="Good"; 
 }else if ((  percetage56 <= very_good56 )&&( percetage56 >= very_good_end56 ))
 {
  p56  = "Very Good";    
 }else if (( percetage56 <= Excellent56 )&&( percetage56  >= very_good56 )   )
 {
  p56 = "Excellent";  
 
  }  
            
pps7.setDouble( 555,  percetage56 );                                            
pps7.setDate(  556 , sqldate); 
pps7.setString(  557 , class_teacher_class);
pps7.setString(  558, Term);
pps7.setString(  559 , p56 );//inserting cmements by stude
pps7.setString( 560, System_ID.getText().trim());             
             
             
             

pps7.setString( 561 ,Sn57 .getText().trim());//student name
 pps7.setString(  562 ,showsubjects.getSelectedItem().toString().trim()); //subjects2
pps7.setString( 563 ,R57 .getText().trim());// marks_obtained 
pps7.setString( 564 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained57 = Double.parseDouble(R57.getText().trim()); 

double converted_total_marks57 = Double.parseDouble(total_marks.getText().trim());

int percetage57 =(int)(converted_marks_obtained57  / converted_total_marks57  * 100) ;

if (( percetage57  <= failed57 )&&( percetage57 >= totallyfailed57)){ 
  p57  = "Failed";  
}else if (( percetage57 <=passed57 )&&( percetage57 >= pass57 )   ){ 
  p57 = "Pass";  
}  else if (( percetage57  <= avaerage57 )&&(  percetage57  >= avaerage_end57 ))
{ 
 p57 = "Avaerage"; 
} 
else if ((  percetage57  <=good57 )&&(  percetage57  >= good_end57 ) )
{ 
 p57 ="Good"; 
 }else if ((  percetage57 <= very_good57 )&&( percetage57 >= very_good_end57 ))
 {
  p57  = "Very Good";    
 }else if (( percetage57 <= Excellent57 )&&( percetage57  >= very_good57 )   )
 {
  p57 = "Excellent";  
 
  }  
            
pps7.setDouble( 565,  percetage57 );                                            
pps7.setDate(  566 , sqldate); 
pps7.setString(  567 , class_teacher_class);
pps7.setString(  568, Term);
pps7.setString(  569 , p57 );//inserting cmements by stude
pps7.setString( 570, System_ID.getText().trim());






pps7.setString( 571 ,Sn58 .getText().trim());//student name
 pps7.setString(  572 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 573 ,R58 .getText().trim());// marks_obtained 
pps7.setString( 574 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained58 = Double.parseDouble(R58.getText().trim()); 

double converted_total_marks58 = Double.parseDouble(total_marks.getText().trim());

int percetage58 =(int)(converted_marks_obtained58  / converted_total_marks58  * 100) ;

if (( percetage58  <= failed58 )&&( percetage58 >= totallyfailed58)){ 
  p58  = "Failed";  
}else if (( percetage58 <=passed58 )&&( percetage58 >= pass58 )   ){ 
  p58 = "Pass";  
}  else if (( percetage58  <= avaerage58 )&&(  percetage58  >= avaerage_end58 ))
{ 
 p58 = "Avaerage"; 
} 
else if ((  percetage58  <=good58 )&&(  percetage58  >= good_end58 ) )
{ 
 p58 ="Good"; 
 }else if ((  percetage58 <= very_good58 )&&( percetage58 >= very_good_end58 ))
 {
  p58  = "Very Good";    
 }else if (( percetage58 <= Excellent58 )&&( percetage58  >= very_good58 )   )
 {
  p58 = "Excellent";  
 
  }  
            
pps7.setDouble( 575,  percetage58 );                                            
pps7.setDate(  576 , sqldate); 
pps7.setString(  577 , class_teacher_class);
pps7.setString(  578, Term);
pps7.setString(  579 , p58 );//inserting cmements by stude
pps7.setString( 580, System_ID.getText().trim());








 pps7.setString( 581 ,Sn59 .getText().trim());//student name
 pps7.setString(  582 ,showsubjects.getSelectedItem().toString().trim()); //subjects
 pps7.setString( 583 ,R59 .getText().trim());// marks_obtained 
 pps7.setString( 584 ,total_marks.getText().trim());                // total_marks_  
            
 double converted_marks_obtained59 = Double.parseDouble(R59.getText().trim()); 

 double converted_total_marks59 = Double.parseDouble(total_marks.getText().trim());

 int percetage59 =(int)(converted_marks_obtained59  / converted_total_marks59  * 100);

 if (( percetage59  <= failed59 )&&( percetage59 >= totallyfailed59)){ 
  p59  = "Failed";  
}else if (( percetage59 <=passed59 )&&( percetage59 >= pass59 )   ){ 
  p59 = "Pass";  
}  else if (( percetage59  <= avaerage59 )&&(  percetage59  >= avaerage_end59 ))
{ 
 p59 = "Avaerage"; 
} 
else if ((  percetage59  <=good59 )&&(  percetage59  >= good_end59 ) )
{ 
 p59 ="Good"; 
 }else if ((  percetage59 <= very_good59 )&&( percetage59 >= very_good_end59 ))
 {
  p59  = "Very Good";    
 }else if (( percetage59 <= Excellent59 )&&( percetage59  >= very_good59)   )
 {
  p59 = "Excellent";  
 
  }  
            
pps7.setDouble( 585,  percetage59 );                                            
pps7.setDate(  586 , sqldate); 
pps7.setString(  587 , class_teacher_class);
pps7.setString(  588, Term);
pps7.setString(  589 , p59 );//inserting cmements by stude
pps7.setString( 590, System_ID.getText().trim());




pps7.setString( 591 ,Sn60 .getText().trim());//student name
 pps7.setString(  592 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 593 ,R60 .getText().trim());// marks_obtained 
pps7.setString( 594 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained60 = Double.parseDouble(R60.getText().trim()); 

double converted_total_marks60 = Double.parseDouble(total_marks.getText().trim());

int percetage60 =(int)(converted_marks_obtained60  / converted_total_marks60  * 100) ;

if (( percetage60  <= failed60 )&&( percetage60 >= totallyfailed60)){ 
  p60  = "Failed";  
}else if (( percetage60 <=passed60 )&&( percetage60 >= pass60 )   ){ 
  p60 = "Pass";  
}  else if (( percetage60  <= avaerage60 )&&(  percetage60  >= avaerage_end60 ))
{ 
 p60 = "Avaerage"; 
} 
else if ((  percetage60  <=good60 )&&(  percetage60  >= good_end60 ) )
{ 
 p60 ="Good"; 
 }else if ((  percetage60 <= very_good60 )&&( percetage60 >= very_good_end60 ))
 {
  p60  = "Very Good";    
 }else if (( percetage60 <= Excellent60 )&&( percetage60  >= very_good60 )   )
 {
  p60 = "Excellent";  
 
  }  
            
pps7.setDouble( 595,  percetage60 );                                            
pps7.setDate(  596 , sqldate); 
pps7.setString(  597 , class_teacher_class);
pps7.setString(  598, Term);
pps7.setString(  599 , p60 );//inserting cmements by stude
pps7.setString( 600, System_ID.getText().trim());
             
           

pps7.setString( 601 ,Sn61 .getText().trim());//student name
 pps7.setString(  602 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 603 ,R61 .getText().trim());// marks_obtained 
pps7.setString( 604 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained61 = Double.parseDouble(R61.getText().trim()); 

double converted_total_marks61 = Double.parseDouble(total_marks.getText().trim());

int percetage61 =(int)(converted_marks_obtained61  / converted_total_marks61  * 100) ;

if (( percetage61  <= failed61 )&&( percetage61 >= totallyfailed61)){ 
  p61 = "Failed";  
}else if (( percetage61 <=passed61 )&&( percetage61 >= pass61 )   ){ 
  p61 = "Pass";  
}  else if (( percetage61  <= avaerage61 )&&(  percetage61  >= avaerage_end61 ))
{ 
 p61 = "Avaerage"; 
} 
else if ((  percetage61  <=good61 )&&(  percetage61  >= good_end61 ) )
{ 
 p61 ="Good"; 
 }else if ((  percetage61 <= very_good61 )&&( percetage61 >= very_good_end61 ))
 {
  p61  = "Very Good";    
 }else if (( percetage61 <= Excellent61 )&&( percetage61  >= very_good61 )   )
 {
  p61 = "Excellent";  
 
  }  
            
pps7.setDouble( 605,  percetage61 );                                            
pps7.setDate(  606 , sqldate); 
pps7.setString(  607 , class_teacher_class);
pps7.setString(  608, Term);
pps7.setString(  609 , p61 );//inserting cmements by stude
pps7.setString( 610, System_ID.getText().trim());




pps7.setString( 611 ,Sn62 .getText().trim());//student name
 pps7.setString(  612 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 613 ,R62 .getText().trim());// marks_obtained 
pps7.setString( 614 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained62 = Double.parseDouble(R62.getText().trim()); 

double converted_total_marks62 = Double.parseDouble(total_marks.getText().trim());

int percetage62 =(int)(converted_marks_obtained62  / converted_total_marks62  * 100) ;

if (( percetage62  <= failed62 )&&( percetage62 >= totallyfailed62)){ 
  p62 = "Failed";  
}else if (( percetage62 <=passed62 )&&( percetage62 >= pass62 )   ){ 
  p62 = "Pass";  
}  else if (( percetage62  <= avaerage62 )&&(  percetage62  >= avaerage_end62 ))
{ 
 p62 = "Avaerage"; 
} 
else if ((  percetage62  <=good62 )&&(  percetage62  >= good_end62 ) )
{ 
 p62 ="Good"; 
 }else if ((  percetage62 <= very_good62 )&&( percetage62 >= very_good_end62 ))
 {
  p62  = "Very Good";    
 }else if (( percetage62 <= Excellent62 )&&( percetage62  >= very_good62 )   )
 {
  p62 = "Excellent";  
 
  }  
            
pps7.setDouble( 615,  percetage62 );                                            
pps7.setDate(  616 , sqldate); 
pps7.setString(  617 , class_teacher_class);
pps7.setString(  618, Term);
pps7.setString(  619 , p62 );//inserting cmements by stude
pps7.setString( 620, System_ID.getText().trim());



pps7.setString( 621 ,Sn63 .getText().trim());//student name
 pps7.setString(  622 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 623 ,R63 .getText().trim());// marks_obtained 
pps7.setString( 624 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained63 = Double.parseDouble(R63.getText().trim()); 

double converted_total_marks63 = Double.parseDouble(total_marks.getText().trim());

int percetage63 =(int)(converted_marks_obtained63  / converted_total_marks63  * 100) ;

if (( percetage63  <= failed63 )&&( percetage63 >= totallyfailed63)){ 
  p63 = "Failed";  
}else if (( percetage63 <=passed63 )&&( percetage63 >= pass63 )   ){ 
  p63 = "Pass";  
}  else if (( percetage63  <= avaerage36 )&&(  percetage63  >= avaerage_end63 ))
{ 
 p63 = "Avaerage"; 
} 
else if ((  percetage63  <=good63 )&&(  percetage63  >= good_end63 ) )
{ 
 p63 ="Good"; 
 }else if ((  percetage63 <= very_good63 )&&( percetage63 >= very_good_end63 ))
 {
  p63  = "Very Good";    
 }else if (( percetage63 <= Excellent63 )&&( percetage63  >= very_good63 )   )
 {
  p63 = "Excellent";  
 
  }  
            
pps7.setDouble( 625,  percetage63 );                                            
pps7.setDate(  626 , sqldate); 
pps7.setString(  627 , class_teacher_class);
pps7.setString(  628, Term);
pps7.setString(  629 , p63 );//inserting cmements by stude
pps7.setString( 630, System_ID.getText().trim());





pps7.setString( 631 ,Sn64 .getText().trim());//student name
 pps7.setString(  632 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 633 ,R64 .getText().trim());// marks_obtained 
pps7.setString( 634 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained64 = Double.parseDouble(R64.getText().trim()); 

double converted_total_marks64 = Double.parseDouble(total_marks.getText().trim());

int percetage64 =(int)(converted_marks_obtained64  / converted_total_marks64  * 100) ;

if (( percetage64  <= failed64 )&&( percetage64 >= totallyfailed64)){ 
  p64 = "Failed";  
}else if (( percetage64 <=passed64 )&&( percetage64 >= pass64 )   ){ 
  p64 = "Pass";  
}  else if (( percetage64  <= avaerage64 )&&(  percetage64  >= avaerage_end64 ))
{ 
 p64 = "Avaerage"; 
} 
else if ((  percetage64  <=good64 )&&(  percetage64  >= good_end64 ) )
{ 
 p64 ="Good"; 
 }else if ((  percetage64 <= very_good64 )&&( percetage64 >= very_good_end64))
 {
  p64  = "Very Good";    
 }else if (( percetage64 <= Excellent64 )&&( percetage64  >= very_good64 )   )
 {
  p64 = "Excellent";  
 
  }  
            
pps7.setDouble( 635,  percetage64 );                                            
pps7.setDate(  636 , sqldate); 
pps7.setString(  637 , class_teacher_class);
pps7.setString(  638, Term);
pps7.setString(  639 , p64 );//inserting cmements by stude
pps7.setString( 640, System_ID.getText().trim());             
             
             
 
pps7.setString( 641 ,Sn65 .getText().trim());//student name
 pps7.setString(  642 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 643 ,R65 .getText().trim());// marks_obtained 
pps7.setString( 644 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained65 = Double.parseDouble(R65.getText().trim()); 

double converted_total_marks65 = Double.parseDouble(total_marks.getText().trim());

int percetage65 =(int)(converted_marks_obtained65  / converted_total_marks65  * 100) ;

if (( percetage65  <= failed65 )&&( percetage65 >= totallyfailed65)){ 
  p65 = "Failed";  
}else if (( percetage65 <=passed65 )&&( percetage65 >= pass65 )   ){ 
  p65 = "Pass";  
}  else if (( percetage65  <= avaerage65 )&&(  percetage65  >= avaerage_end65 ))
{ 
 p65 = "Avaerage"; 
} 
else if ((  percetage65  <=good65 )&&(  percetage65  >= good_end65 ) )
{ 
 p65 ="Good"; 
 }else if ((  percetage65 <= very_good65 )&&( percetage65 >= very_good_end65 ))
 {
  p65  = "Very Good";    
 }else if (( percetage65 <= Excellent65 )&&( percetage65  >= very_good65 )   )
 {
  p65 = "Excellent";  
 
  }  
            
pps7.setDouble( 645,  percetage65 );                                            
pps7.setDate(  646 , sqldate); 
pps7.setString(  647 , class_teacher_class);
pps7.setString(  648, Term);
pps7.setString(  649 , p65 );//inserting cmements by stude
pps7.setString( 650, System_ID.getText().trim());








pps7.setString( 651 ,Sn66 .getText().trim());//student name
 pps7.setString(  652 ,showsubjects.getSelectedItem().toString().trim()); //subjects20
pps7.setString( 653 ,R66 .getText().trim());// marks_obtained 
pps7.setString( 654 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained66 = Double.parseDouble(R66.getText().trim()); 

double converted_total_marks66 = Double.parseDouble(total_marks.getText().trim());

int percetage66 =(int)(converted_marks_obtained66  / converted_total_marks66  * 100) ;

if (( percetage66  <= failed66 )&&( percetage66 >= totallyfailed66)){ 
  p66 = "Failed";  
}else if (( percetage66 <=passed66 )&&( percetage66 >= pass66 )   ){ 
  p66 = "Pass";  
}  else if (( percetage66  <= avaerage66 )&&(  percetage66  >= avaerage_end66 ))
{ 
 p66 = "Avaerage"; 
} 
else if ((  percetage66  <=good66 )&&(  percetage66  >= good_end66 ) )
{ 
 p66 ="Good"; 
 }else if ((  percetage66 <= very_good66 )&&( percetage66 >= very_good_end66 ))
 {
  p66  = "Very Good";    
 }else if (( percetage66 <= Excellent66 )&&( percetage66  >= very_good66 )   )
 {
  p66 = "Excellent";  
 
  }  
            
pps7.setDouble( 655,  percetage66 );                                            
pps7.setDate(  656 , sqldate); 
pps7.setString(  657 , class_teacher_class);
pps7.setString(  658, Term);
pps7.setString(  659 , p66 );//inserting cmements by stude
pps7.setString( 660, System_ID.getText().trim());



pps7.setString( 661 ,Sn67 .getText().trim());//student name
 pps7.setString(  662 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 663 ,R67 .getText().trim());// marks_obtained 
pps7.setString( 664 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained67 = Double.parseDouble(R67.getText().trim()); 

double converted_total_marks67 = Double.parseDouble(total_marks.getText().trim());

int percetage67 =(int)(converted_marks_obtained67  / converted_total_marks67  * 100) ;

if (( percetage67  <= failed67 )&&( percetage67 >= totallyfailed67)){ 
  p67 = "Failed";  
}else if (( percetage67 <=passed67 )&&( percetage67 >= pass67 )   ){ 
  p67 = "Pass";  
}  else if (( percetage67  <= avaerage67 )&&(  percetage67  >= avaerage_end67 ))
{ 
 p67 = "Avaerage"; 
} 
else if ((  percetage67  <=good67 )&&(  percetage67  >= good_end67 ) )
{ 
 p67 ="Good"; 
 }else if ((  percetage67 <= very_good67 )&&( percetage67 >= very_good_end67 ))
 {
  p67  = "Very Good";    
 }else if (( percetage67 <= Excellent67 )&&( percetage67  >= very_good67 )   )
 {
  p67 = "Excellent";  
 
  }  
            
pps7.setDouble( 665,  percetage67 );                                            
pps7.setDate(  666 , sqldate); 
pps7.setString(  667 , class_teacher_class);
pps7.setString(  668, Term);
pps7.setString(  669 , p67 );//inserting cmements by stude
pps7.setString( 670, System_ID.getText().trim());




pps7.setString( 671 ,Sn68 .getText().trim());//student name
pps7.setString(  672 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 673 ,R68 .getText().trim());// marks_obtained 
pps7.setString( 674 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained68 = Double.parseDouble(R68.getText().trim()); 

double converted_total_marks68 = Double.parseDouble(total_marks.getText().trim());

int percetage68 =(int)(converted_marks_obtained68  / converted_total_marks68  * 100) ;

if (( percetage68  <= failed68 )&&( percetage68 >= totallyfailed68)){ 
  p68 = "Failed";  
}else if (( percetage68 <=passed68 )&&( percetage68 >= pass68 )   ){ 
  p68 = "Pass";  
}  else if (( percetage68  <= avaerage68 )&&(  percetage68  >= avaerage_end68))
{ 
 p68 = "Avaerage"; 
} 
else if ((  percetage68  <=good68 )&&(  percetage68  >= good_end68 ) )
{ 
 p68 ="Good"; 
 }else if ((  percetage68 <= very_good68 )&&( percetage68 >= very_good_end68 ))
 {
  p68  = "Very Good";    
 }else if (( percetage68 <= Excellent68 )&&( percetage68  >= very_good68 )   )
 {
  p68 = "Excellent";  

}  
            
pps7.setDouble( 675,  percetage68 );                                            
pps7.setDate(  676 , sqldate); 
pps7.setString(  677 , class_teacher_class);
pps7.setString(  678, Term);
pps7.setString(  679 , p68 );//inserting cmements by stude
pps7.setString( 680, System_ID.getText().trim());





pps7.setString( 681 ,Sn69 .getText().trim());//student name
 pps7.setString(  682 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 683 ,R69 .getText().trim());// marks_obtained 
pps7.setString( 684 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained69 = Double.parseDouble(R69.getText().trim()); 

double converted_total_marks69 = Double.parseDouble(total_marks.getText().trim());

int percetage69 =(int)(converted_marks_obtained69  / converted_total_marks69  * 100) ;

if (( percetage69  <= failed69 )&&( percetage69 >= totallyfailed69)){ 
  p69 = "Failed";  
}else if (( percetage69 <=passed69 )&&( percetage69 >= pass69 )   ){ 
  p69 = "Pass";  
}  else if (( percetage69  <= avaerage69 )&&(  percetage69  >= avaerage_end69 ))
{ 
 p69 = "Avaerage"; 
} 
else if ((  percetage69  <=good69 )&&(  percetage69  >= good_end69 ) )
{ 
 p69 ="Good"; 
 }else if ((  percetage69 <= very_good69 )&&( percetage69 >= very_good_end69 ))
 {
  p69  = "Very Good";    
 }else if (( percetage69 <= Excellent69 )&&( percetage69  >= very_good69 )   )
 {
  p69 = "Excellent";  
 
  }  
            
pps7.setDouble( 685,  percetage69 );                                            
pps7.setDate(  686 , sqldate); 
pps7.setString(  687 , class_teacher_class);
pps7.setString(  688, Term);
pps7.setString(  689 , p69 );//inserting cmements by stude
pps7.setString( 690, System_ID.getText().trim());





  pps7.setString( 691 ,Sn70 .getText().trim());//student name
  pps7.setString(  692 ,showsubjects.getSelectedItem().toString().trim()); //subjshowsubjects.getSelectedItemects
  pps7.setString( 693 ,R70 .getText().trim());// marks_obtained 
  pps7.setString( 694 ,total_marks.getText().trim());                // total_marks_  
            
  double converted_marks_obtained70  = Double.parseDouble(R70.getText().trim()); 

  double converted_total_marks70 = Double.parseDouble(total_marks.getText().trim());

  int percetage70 =(int)(converted_marks_obtained70  / converted_total_marks70  * 100) ;

if (( percetage70  <= failed70 )&&( percetage70 >= totallyfailed70)){ 
  p70 = "Failed";  
}else if (( percetage70 <=passed70 )&&( percetage70 >= pass70 )   ){ 
  p70 = "Pass";  
}  else if (( percetage70  <= avaerage70 )&&(  percetage70  >= avaerage_end70 ))
{ 
 p70 = "Avaerage"; 
} 
else if ((  percetage70  <=good70 )&&(  percetage70  >= good_end70 ) )
{ 
  p70 ="Good"; 
 }else if ((  percetage70 <= very_good70 )&&( percetage70 >= very_good_end70))
 {
  p70  = "Very Good";    
 }else if (( percetage70 <= Excellent70 )&&( percetage70  >= very_good70 )   )
 {
  p70 = "Excellent";  
 
  }  
            
pps7.setDouble( 695,  percetage70 );                                            
pps7.setDate(  696 , sqldate); 
pps7.setString(  697 , class_teacher_class);
pps7.setString(  698, Term);
pps7.setString(  699 , p70 );//inserting cmements by stude
pps7.setString( 700, System_ID.getText().trim());








pps7.setString( 701 ,Sn71 .getText().trim());//student name
 pps7.setString(  702 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 703 ,R71 .getText().trim());// marks_obtained 
pps7.setString( 704 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained71 = Double.parseDouble(R71.getText().trim()); 

double converted_total_marks71 = Double.parseDouble(total_marks.getText().trim());

int percetage71 =(int)(converted_marks_obtained71  / converted_total_marks71  * 100) ;

if (( percetage71  <= failed71 )&&( percetage71 >= totallyfailed71)){ 
  p71 = "Failed";  
}else if (( percetage71 <=passed71)&&( percetage71 >= pass71 )   ){ 
  p71 = "Pass";  
}  else if (( percetage71  <= avaerage71 )&&(  percetage71  >= avaerage_end71 ))
{ 
 p71 = "Avaerage"; 
} 
else if ((  percetage71  <=good71 )&&(  percetage71  >= good_end71 ) )
{ 
 p71 ="Good"; 
 }else if ((  percetage71 <= very_good71 )&&( percetage71 >= very_good_end71 ))
 {
  p71  = "Very Good";    
 }else if (( percetage71 <=     Excellent71 )&&( percetage71  >= very_good71 )   )
 {
  p71 = "Excellent";  
 
  }  
            
pps7.setDouble( 705,  percetage71 );                                            
pps7.setDate(  706 , sqldate); 
pps7.setString(  707 , class_teacher_class);
pps7.setString(  708, Term);
pps7.setString(  709 , p71 );//inserting cmements by stude
pps7.setString( 710, System_ID.getText().trim());






pps7.setString( 711 ,Sn72 .getText().trim());//student name
pps7.setString(  712 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 713 ,R72 .getText().trim());// marks_obtained 
pps7.setString( 714 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained72 = Double.parseDouble(R72.getText().trim()); 

double converted_total_marks72 = Double.parseDouble(total_marks.getText().trim());

int percetage72 =(int)(converted_marks_obtained72  / converted_total_marks72  * 100) ;

if (( percetage72  <= failed72 )&&( percetage72 >= totallyfailed72)){ 
  p72 = "Failed";  
}else if (( percetage72 <=passed72 )&&( percetage72 >= pass72 )   ){ 
  p72 = "Pass";  
}  else if (( percetage72  <= avaerage72 )&&(  percetage72  >= avaerage_end72 ))
{ 
 p72 = "Avaerage"; 
} 
else if ((  percetage72  <=good72 )&&(  percetage72  >= good_end72 ) )
{ 
 p72 ="Good"; 
 }else if ((  percetage72 <= very_good72 )&&( percetage72 >= very_good_end72 ))
 {
  p72  = "Very Good";    
 }else if (( percetage72 <=     Excellent72 )&&( percetage72  >= very_good72 )   )
 {
  p72 = "Excellent";  
 
  }  
            
pps7.setDouble( 715,  percetage72 );                                            
pps7.setDate(  716 , sqldate); 
pps7.setString(  717 , class_teacher_class);
pps7.setString(  718, Term);
pps7.setString(  719 , p72 );//inserting cmements by stude
pps7.setString( 720, System_ID.getText().trim());            



pps7.setString( 721 ,Sn73 .getText().trim());//student name
 pps7.setString(  722 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 723 ,R73 .getText().trim());// marks_obtained 
pps7.setString( 724 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained73 = Double.parseDouble(R73.getText().trim()); 

double converted_total_marks73 = Double.parseDouble(total_marks.getText().trim());

int percetage73 =(int)(converted_marks_obtained73  / converted_total_marks73  * 100) ;

if (( percetage73  <= failed73 )&&( percetage73 >= totallyfailed73)){ 
  p73 = "Failed";  
}else if (( percetage73 <=passed73 )&&( percetage73 >= pass73 )   ){ 
  p73 = "Pass";  
}  else if (( percetage73  <= avaerage73 )&&(  percetage73  >= avaerage_end73 ))
{ 
 p73 = "Avaerage"; 
} 
else if ((  percetage73  <=good73 )&&(  percetage73  >= good_end73 ) )
{ 
 p73 ="Good"; 
 }else if ((  percetage73 <= very_good73 )&&( percetage73 >= very_good_end73 ))
 {
  p73  = "Very Good";    
 }else if (( percetage73 <=     Excellent73 )&&( percetage73  >= very_good73 )   )
 {
  p73 = "Excellent";  
 
  }  
            
pps7.setDouble( 725,  percetage73 );                                            
pps7.setDate(  726 , sqldate); 
pps7.setString(  727 , class_teacher_class);
pps7.setString(  728, Term);
pps7.setString(  729 , p73 );//inserting cmements by stude
pps7.setString( 730, System_ID.getText().trim());







pps7.setString( 731 ,Sn74 .getText().trim());//student name
 pps7.setString(  732 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 733 ,R74 .getText().trim());// marks_obtained 
pps7.setString( 734 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained74 = Double.parseDouble(R74.getText().trim()); 

double converted_total_marks74 = Double.parseDouble(total_marks.getText().trim());

int percetage74 =(int)(converted_marks_obtained74  / converted_total_marks74  * 100) ;

if (( percetage74  <= failed74 )&&( percetage74 >= totallyfailed74)){ 
  p74 = "Failed";  
}else if (( percetage74 <=passed74 )&&( percetage74 >= pass74 )   ){ 
  p74 = "Pass";  
}  else if (( percetage74  <= avaerage74 )&&(  percetage74  >= avaerage_end74 ))
{ 
 p74 = "Avaerage"; 
} 
else if ((  percetage74  <=good74 )&&(  percetage74  >= good_end74 ) )
{ 
 p74 ="Good"; 
 }else if ((  percetage74 <= very_good74 )&&( percetage74 >= very_good_end74 ))
 {
  p74  = "Very Good";    
 }else if (( percetage74 <=     Excellent74 )&&( percetage74  >= very_good74 )   )
 {
  p74 = "Excellent";  
 
  }  
            
pps7.setDouble( 735,  percetage74 );                                            
pps7.setDate(  736 , sqldate); 
pps7.setString(  737 , class_teacher_class);
pps7.setString(  738, Term);
pps7.setString(  739 , p74 );//inserting cmements by stude
pps7.setString( 740, System_ID.getText().trim());




pps7.setString( 741 ,Sn75 .getText().trim());//student name
 pps7.setString(  742 ,showsubjects.getSelectedItem().toString().trim()); //subjects  11
pps7.setString( 743 ,R75 .getText().trim());// marks_obtained 
pps7.setString( 744 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained75 = Double.parseDouble(R75.getText().trim()); 

double converted_total_marks75 = Double.parseDouble(total_marks.getText().trim());

int percetage75 =(int)(converted_marks_obtained75  / converted_total_marks75  * 100) ;

if (( percetage75  <= failed75 )&&( percetage75 >= totallyfailed75)){ 
  p75 = "Failed";  
}else if (( percetage75 <=passed75 )&&( percetage75 >= pass75 )   ){ 
  p75 = "Pass";  
}  else if (( percetage75  <= avaerage75 )&&(  percetage75  >= avaerage_end75 ))
{ 
 p75 = "Avaerage"; 
} 
else if ((  percetage75  <=good75 )&&(  percetage75  >= good_end75 ) )
{ 
 p75 ="Good"; 
 }else if ((  percetage75 <= very_good75 )&&( percetage75 >= very_good_end75 ))
 {
  p75  = "Very Good";    
 }else if (( percetage75 <=     Excellent75 )&&( percetage75  >= very_good75 )   )
 {
  p75 = "Excellent";  
 
  }  
            
pps7.setDouble( 745,  percetage75 );                                            
pps7.setDate(  746 , sqldate); 
pps7.setString(  747 , class_teacher_class);
pps7.setString(  748, Term);
pps7.setString(  749 , p75 );//inserting cmements by stude
pps7.setString( 750, System_ID.getText().trim());






pps7.setString( 751 ,Sn76 .getText().trim());//student name
 pps7.setString(  752 ,showsubjects.getSelectedItem().toString().trim()); //subjects  10
pps7.setString( 753 ,R76 .getText().trim());// marks_obtained 
pps7.setString( 754 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained76 = Double.parseDouble(R76.getText().trim()); 

double converted_total_marks76 = Double.parseDouble(total_marks.getText().trim());

int percetage76 =(int)(converted_marks_obtained76  / converted_total_marks76  * 100) ;

if (( percetage76  <= failed76 )&&( percetage76 >= totallyfailed76)){ 
  p76 = "Failed";  
}else if (( percetage76 <=passed76 )&&( percetage76 >= pass76 )   ){ 
  p76 = "Pass";  
}  else if (( percetage76  <= avaerage76 )&&(  percetage76  >= avaerage_end76 ))
{ 
 p76 = "Avaerage"; 
} 
 else if ((  percetage76  <=good76 )&&(  percetage76  >= good_end76 ) )
{ 
 p76 ="Good"; 
 }else if ((  percetage76 <= very_good76 )&&( percetage76 >= very_good_end76 ))
 {
  p76  = "Very Good";    
 }else if (( percetage76 <=     Excellent76 )&&( percetage76  >= very_good76 )   )
 {
  p76 = "Excellent";  
 
  }  
            
pps7.setDouble( 755,  percetage76 );                                            
pps7.setDate(  756 , sqldate); 
pps7.setString(  757 , class_teacher_class);
pps7.setString(  758, Term);
pps7.setString(  759 , p76 );//inserting cmements by stude
pps7.setString( 760, System_ID.getText().trim());



pps7.setString( 761 ,Sn77 .getText().trim());//student name
 pps7.setString(  762 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 763 ,R77 .getText().trim());// marks_obtained 
pps7.setString( 764 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained77 = Double.parseDouble(R77.getText().trim()); 

double converted_total_marks77 = Double.parseDouble(total_marks.getText().trim());

int percetage77 =(int)(converted_marks_obtained77  / converted_total_marks77  * 100) ;

if (( percetage77  <= failed77 )&&( percetage77 >= totallyfailed77)){ 
  p77 = "Failed";  
}else if (( percetage77 <=passed77 )&&( percetage77 >= pass77 )   ){ 
  p77 = "Pass";  
}  else if (( percetage77  <= avaerage77 )&&(  percetage77  >= avaerage_end77 ))
{ 
 p77 = "Avaerage"; 
} 
else if ((  percetage77  <=good77 )&&(  percetage77  >= good_end77 ) )
{ 
 p77 ="Good";  
 }else if ((  percetage77 <= very_good77 )&&( percetage77 >= very_good_end77 ))
 {
  p77  = "Very Good";    
 }else if (( percetage77 <=     Excellent77 )&&( percetage77  >= very_good77 )   )
 {
  p77 = "Excellent";  
 
  }  
            
pps7.setDouble( 765,  percetage77 );                                            
pps7.setDate(  766 , sqldate); 
pps7.setString(  767 , class_teacher_class);
pps7.setString(  768, Term);
pps7.setString(  769 , p77 );//inserting cmements by stude
pps7.setString( 770, System_ID.getText().trim());



pps7.setString( 771 ,Sn78 .getText().trim());//student name
 pps7.setString(  772 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 773 ,R78 .getText().trim());// marks_obtained 
pps7.setString( 774 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained78 = Double.parseDouble(R78.getText().trim()); 

double converted_total_marks78 = Double.parseDouble(total_marks.getText().trim());

int percetage78 =(int)(converted_marks_obtained78  / converted_total_marks78  * 100) ;

if (( percetage78  <= failed78 )&&( percetage78 >= totallyfailed78)){ 
  p78 = "Failed";  
}else if (( percetage78 <=passed78)&&( percetage78 >= pass78 )   ){ 
  p78 = "Pass";  
}  else if (( percetage78  <= avaerage78 )&&(  percetage78  >= avaerage_end78 ))
{ 
 p78 = "Avaerage"; 
} 
else if ((  percetage78  <=good78 )&&(  percetage78  >= good_end78 ) )
{ 
 p78 ="Good"; 
 }else if ((  percetage78 <= very_good78 )&&( percetage78 >= very_good_end78 ))
 {
  p78  = "Very Good";    
 }else if (( percetage78 <=     Excellent78 )&&( percetage78  >= very_good78 )   )
 {
  p78 = "Excellent";  
 
  }  
            
pps7.setDouble( 775,  percetage78 );                                            
pps7.setDate(  776 , sqldate); 
pps7.setString(  777 , class_teacher_class);
pps7.setString(  778, Term);
pps7.setString(  779 , p78 );//inserting cmements by stude
pps7.setString( 780, System_ID.getText().trim());





pps7.setString( 781 ,Sn79 .getText().trim());//student name
 pps7.setString(  782 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 783 ,R79 .getText().trim());// marks_obtained 
pps7.setString( 784 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained79 = Double.parseDouble(R79.getText().trim()); 

double converted_total_marks79 = Double.parseDouble(total_marks.getText().trim());

int percetage79 =(int)(converted_marks_obtained79  / converted_total_marks79  * 100) ;

if (( percetage79  <= failed79 )&&( percetage79 >= totallyfailed79)){ 
  p79 = "Failed";  
}else if (( percetage79 <=passed79 )&&( percetage79 >= pass79 )   ){ 
  p79 = "Pass";  
}  else if (( percetage79  <= avaerage79 )&&(  percetage79  >= avaerage_end79 ))
{ 
 p79 = "Avaerage"; 
} 
else if ((  percetage79  <=good79 )&&(  percetage79  >= good_end79 ) )
{ 
 p79 ="Good"; 
 }else if ((  percetage79 <= very_good79 )&&( percetage79 >= very_good_end79 ))
 {
  p79  = "Very Good";    
 }else if (( percetage79 <=     Excellent79 )&&( percetage79  >= very_good79 )   )
 {
  p79 = "Excellent";  
 
  }  
            
pps7.setDouble( 785,  percetage79 );                                            
pps7.setDate(  786 , sqldate); 
pps7.setString(  787 , class_teacher_class);
pps7.setString(  788, Term);
pps7.setString(  789 , p79 );//inserting cmements by stude
pps7.setString( 790, System_ID.getText().trim());






pps7.setString( 791 ,Sn80 .getText().trim());//student name
 pps7.setString(  792 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 793 ,R80 .getText().trim());// marks_obtained 
pps7.setString( 794 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained80 = Double.parseDouble(R80.getText().trim()); 

double converted_total_marks80 = Double.parseDouble(total_marks.getText().trim());

int percetage80 =(int)(converted_marks_obtained80  / converted_total_marks80  * 100) ;

if (( percetage80  <= failed80 )&&( percetage80 >= totallyfailed80)){ 
  p80 = "Failed";  
}else if (( percetage80 <=passed80)&&( percetage80 >= pass80 )   ){ 
  p80 = "Pass";  
}  else if (( percetage80  <= avaerage80 )&&(  percetage80  >= avaerage_end80 ))
{ 
 p80 = "Avaerage"; 
} 
else if ((  percetage80  <=good80 )&&(  percetage80  >= good_end80 ) )
{ 
 p80 ="Good"; 
 }else if ((  percetage80 <= very_good80 )&&( percetage80 >= very_good_end80 ))
 {
  p80  = "Very Good";    
 }else if (( percetage80 <=     Excellent80 )&&( percetage80  >= very_good80 )   )
 {
  p80 = "Excellent";  
 
  }  
            
pps7.setDouble( 795,  percetage80 );                                            
pps7.setDate(  796 , sqldate); 
pps7.setString(  797 , class_teacher_class);
pps7.setString(  798, Term);
pps7.setString(  799 , p80 );//inserting cmements by stude
pps7.setString( 800, System_ID.getText().trim());



pps7.setString( 801 ,Sn81 .getText().trim());//student name
 pps7.setString(  802 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 803 ,R81 .getText().trim());// marks_obtained 
pps7.setString( 804 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained81 = FloatingDecimal.parseDouble(R81.getText().trim()); 

double converted_total_marks81 = FloatingDecimal.parseDouble(total_marks.getText().trim());

int percetage81 =(int)(converted_marks_obtained81  / converted_total_marks81  * 100) ;

if (( percetage81  <= failed81 )&&( percetage81 >= totallyfailed81)){ 
  p81 = "Failed";  
}else if (( percetage81 <=passed81 )&&( percetage81 >= pass81 )   ){ 
  p81 = "Pass";  
}  else if (( percetage81  <= avaerage81 )&&(  percetage81  >= avaerage_end81 ))
{ 
 p81 = "Avaerage"; 
} 
else if ((  percetage81  <=good81 )&&(  percetage81  >= good_end81 ) )
{ 
 p81 ="Good"; 
 }else if ((  percetage81 <= very_good81 )&&( percetage81 >= very_good_end81 ))
 {
  p81  = "Very Good";    
 }else if (( percetage81 <=     Excellent81 )&&( percetage81  >= very_good81 )   )
 {
  p81 = "Excellent";  
 
  }  
            
pps7.setDouble( 805,  percetage81 );                                            
pps7.setDate(  806 , sqldate); 
pps7.setString(  807 , class_teacher_class);
pps7.setString(  808, Term);
pps7.setString(  809 , p81 );//inserting cmements by stude
pps7.setString( 810, System_ID.getText().trim());







pps7.setString( 811 ,Sn82 .getText().trim());//student name
 pps7.setString(  812 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 813 ,R82 .getText().trim());// marks_obtained 
pps7.setString( 814 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained82 = Double.parseDouble(R82.getText().trim()); 

double converted_total_marks82 = Double.parseDouble(total_marks.getText().trim());

int percetage82 =(int)(converted_marks_obtained82  / converted_total_marks82  * 100) ;

if (( percetage82  <= failed82 )&&( percetage82 >= totallyfailed82)){ 
  p82 = "Failed";  
}else if (( percetage82 <=passed82 )&&( percetage82 >= pass82 )   ){ 
  p82 = "Pass";  
}  else if (( percetage82  <= avaerage82 )&&(  percetage82  >= avaerage_end82 ))
{ 
 p82 = "Avaerage"; 
} 
else if ((  percetage82  <=good82 )&&(  percetage82  >= good_end82 ) )
{ 
 p82 ="Good"; 
 }else if ((  percetage82 <= very_good82 )&&( percetage82 >= very_good_end82 ))
 {
  p82  = "Very Good";    
 }else if (( percetage82 <=     Excellent82 )&&( percetage82  >= very_good82 )   )
 {
  p82 = "Excellent";  
 
  }  
            
pps7.setDouble( 815,  percetage82 );                                            
pps7.setDate(  816 , sqldate); 
pps7.setString(  817 , class_teacher_class);
pps7.setString(  818, Term);
pps7.setString(  819 , p82 );//inserting cmements by stude
pps7.setString( 820, System_ID.getText().trim());








pps7.setString( 821 ,Sn83 .getText().trim());//student name
 pps7.setString(  822 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 823 ,R83 .getText().trim());// marks_obtained 
pps7.setString( 824 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained83 = Double.parseDouble(R83.getText().trim()); 

double converted_total_marks83 = Double.parseDouble(total_marks.getText().trim());

int percetage83 =(int)(converted_marks_obtained83  / converted_total_marks83  * 100) ;

if (( percetage83  <= failed83 )&&( percetage83 >= totallyfailed83)){ 
  p83 = "Failed";  
}else if (( percetage83 <=passed83 )&&( percetage83 >= pass83 )   ){ 
  p83 = "Pass";  
}  else if (( percetage83  <= avaerage83 )&&(  percetage83  >= avaerage_end83 ))
{ 
 p83 = "Avaerage"; 
} 
else if ((  percetage83  <=good83 )&&(  percetage83  >= good_end83 ) )
{ 
 p83 ="Good"; 
 }else if ((  percetage83 <= very_good83 )&&( percetage83 >= very_good_end83 ))
 {
  p83  = "Very Good";    
 }else if (( percetage83 <=     Excellent83 )&&( percetage83  >= very_good83 )   )
 {
  p83 = "Excellent";  
 
  }  
            
pps7.setDouble( 825,  percetage83 );                                            
pps7.setDate(  826 , sqldate); 
pps7.setString(  827 , class_teacher_class);
pps7.setString(  828, Term);
pps7.setString(  829 , p83 );//inserting cmements by stude
pps7.setString( 830, System_ID.getText().trim());




pps7.setString( 831 ,Sn84 .getText().trim());//student name
 pps7.setString(  832 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 833 ,R84 .getText().trim());// marks_obtained 
pps7.setString( 834 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained84 = Double.parseDouble(R84.getText().trim()); 

double converted_total_marks84 = Double.parseDouble(total_marks.getText().trim());

int percetage84 =(int)(converted_marks_obtained84  / converted_total_marks84  * 100) ;

if (( percetage84  <= failed84 )&&( percetage84 >= totallyfailed84)){ 
  p84 = "Failed";  
}else if (( percetage84 <=passed84 )&&( percetage84 >= pass84 )   ){ 
  p84 = "Pass";  
}  else if (( percetage84  <= avaerage84 )&&(  percetage84  >= avaerage_end84 ))
{ 
 p84 = "Avaerage"; 
} 
else if ((  percetage84  <=good84 )&&(  percetage84  >= good_end84 ) )
{ 
 p84 ="Good"; 
 }else if ((  percetage84 <= very_good84 )&&( percetage84 >= very_good_end84 ))
 {
  p84  = "Very Good";    
 }else if (( percetage84 <=     Excellent84 )&&( percetage84  >= very_good84 )   )
 {
  p84 = "Excellent";  
 
  }  
            
pps7.setDouble( 835,  percetage84 );                                            
pps7.setDate(  836 , sqldate); 
pps7.setString(  837 , class_teacher_class);
pps7.setString(  838, Term);
pps7.setString(  839 , p84 );//inserting cmements by stude
pps7.setString( 840, System_ID.getText().trim());



pps7.setString( 841 ,Sn85 .getText().trim());//student name
 pps7.setString(  842 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 843 ,R85 .getText().trim());// marks_obtained 
pps7.setString( 844 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained85 = Double.parseDouble(R85.getText().trim()); 

double converted_total_marks85 = Double.parseDouble(total_marks.getText().trim());

int percetage85 =(int)(converted_marks_obtained85  / converted_total_marks85  * 100) ;

if (( percetage85  <= failed85 )&&( percetage85 >= totallyfailed85)){ 
  p85 = "Failed";  
}else if (( percetage85 <=passed85 )&&( percetage85 >= pass85 )   ){ 
  p85 = "Pass";  
}  else if (( percetage85  <= avaerage85 )&&(  percetage85  >= avaerage_end85 ))
{ 
 p85 = "Avaerage"; 
} 
else if ((  percetage85  <=good85 )&&(  percetage85  >= good_end85 ) )
{ 
 p85 ="Good"; 
 }else if ((  percetage85 <= very_good85 )&&( percetage85 >= very_good_end85 ))
 {
  p85  = "Very Good";    
 }else if (( percetage85 <=     Excellent85 )&&( percetage85  >= very_good85 )   )
 {
  p85 = "Excellent";  
 
  }  
            
pps7.setDouble( 845,  percetage85 );                                             
pps7.setDate(  846 , sqldate); 
pps7.setString(  847 , class_teacher_class);
pps7.setString(  848, Term);
pps7.setString(  849 , p85 );//inserting cmements by stude
pps7.setString( 850, System_ID.getText().trim());






pps7.setString( 851 ,Sn86 .getText().trim());//student name
 pps7.setString(  852 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 853 ,R86 .getText().trim());// marks_obtained 
pps7.setString( 854 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained86 = Double.parseDouble(R86.getText().trim()); 

double converted_total_marks86 = Double.parseDouble(total_marks.getText().trim());

int percetage86 =(int)(converted_marks_obtained86  / converted_total_marks86  * 100) ;

if (( percetage86  <= failed86 )&&( percetage86 >= totallyfailed86)){ 
  p86 = "Failed";  
}else if (( percetage86 <=passed86 )&&( percetage86 >= pass86 )   ){ 
  p86 = "Pass";  
}  else if (( percetage86  <= avaerage86 )&&(  percetage86  >= avaerage_end86 ))
{ 
 p86 = "Avaerage"; 
} 
else if ((  percetage86  <=good86 )&&(  percetage86  >= good_end86 ) )
{ 
 p86 ="Good"; 
 }else if ((  percetage86 <= very_good86 )&&( percetage86 >= very_good_end86 ))
 {
  p86  = "Very Good";    
 }else if (( percetage86 <=     Excellent86 )&&( percetage86  >= very_good86 )   )
 {
  p86 = "Excellent";  
 
  }  
            

pps7.setDouble( 855,  percetage86 );                                             
pps7.setDate(   856 , sqldate); 
pps7.setString( 857 , class_teacher_class);
pps7.setString( 858, Term);
pps7.setString( 859 , p86 );//inserting cmements by stude
pps7.setString( 860, System_ID.getText().trim());





 
 
pps7.setString( 861 ,Sn87  .getText().trim());//student name
 pps7.setString(  862 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 863 ,R87 .getText().trim());// marks_obtained 
pps7.setString( 864 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained87 = Double.parseDouble(R87.getText().trim()); 

double converted_total_marks87 = Double.parseDouble(total_marks.getText().trim());

int percetage87 =(int)(converted_marks_obtained87  / converted_total_marks87  * 100) ;

if (( percetage87  <= failed87 )&&( percetage87 >= totallyfailed87)){ 
  p87 = "Failed";  
}else if (( percetage87 <=passed87 )&&( percetage87 >= pass87 )   ){ 
  p87 = "Pass";  
}  else if (( percetage87  <= avaerage87 )&&(  percetage87  >= avaerage_end87 ))
{ 
 p87 = "Avaerage"; 
} 
else if ((  percetage87  <=good87 )&&(  percetage87  >= good_end87 ) )
{ 
 p85 ="Good"; 
 }else if ((  percetage87 <= very_good87 )&&( percetage87 >= very_good_end87 ))
 {
  p85  = "Very Good";    
 }else if (( percetage87 <=     Excellent87 )&&( percetage87  >= very_good87 )   )
 {
  p85 = "Excellent";  
 
  }  
            
pps7.setDouble( 865,  percetage87 );                                             
pps7.setDate(  866 , sqldate); 
pps7.setString(  867 , class_teacher_class);
pps7.setString(  868, Term);
pps7.setString(  869 , p87 );//inserting cmements by stude
pps7.setString( 870, System_ID.getText().trim());


pps7.setString( 871 ,Sn88 .getText().trim());//student name
 pps7.setString(  872 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 873 ,R88 .getText().trim());// marks_obtained 
pps7.setString( 874 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained88 = Double.parseDouble(R88.getText().trim()); 

double converted_total_marks88 = Double.parseDouble(total_marks.getText().trim());

int percetage88 =(int)(converted_marks_obtained88  / converted_total_marks88  * 100) ;

if (( percetage88  <= failed88 )&&( percetage88 >= totallyfailed88)){ 
  p88 = "Failed";  
}else if (( percetage88 <=passed88 )&&( percetage88 >= pass88 )   ){ 
  p88 = "Pass";  
}  else if (( percetage88  <= avaerage88 )&&(  percetage88  >= avaerage_end88 ))
{ 
 p88 = "Avaerage"; 
} 
else if ((  percetage88  <=good88 )&&(  percetage88 >= good_end88 ) )
{ 
 p88 ="Good"; 
 }else if ((  percetage88 <= very_good88 )&&( percetage88 >= very_good_end88 ))
 {
  p88  = "Very Good";    
 }else if (( percetage88 <=     Excellent88 )&&( percetage88  >= very_good88 )   )
 {
  p88 = "Excellent";  
 
  }  
            
pps7.setDouble( 875,  percetage88);                                             
pps7.setDate(  876 , sqldate); 
pps7.setString(  877 , class_teacher_class);
pps7.setString(  878, Term);
pps7.setString(  879 , p88 );//inserting cmements by stude
pps7.setString( 880, System_ID.getText().trim());


pps7.setString( 881 ,Sn89 .getText().trim());//student name
 pps7.setString( 882 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 883 ,R89 .getText().trim());// marks_obtained 
pps7.setString( 884 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained89 = Double.parseDouble(R89.getText().trim()); 

double converted_total_marks89 = Double.parseDouble(total_marks.getText().trim());

int percetage89 =(int)(converted_marks_obtained89  / converted_total_marks89  * 100) ;

if (( percetage89  <= failed89 )&&( percetage89 >= totallyfailed89)){ 
  p89 = "Failed";  
}else if (( percetage89 <=passed89 )&&( percetage89 >= pass89 )   ){ 
  p89 = "Pass";  
}  else if (( percetage89  <= avaerage89 )&&(  percetage89  >= avaerage_end89 ))
{ 
 p89 = "Avaerage"; 
} 
else if ((  percetage89  <=good89 )&&(  percetage89  >= good_end89 ) )
{ 
 p89 ="Good"; 
 }else if ((  percetage89 <= very_good89 )&&( percetage89 >= very_good_end89 ))
 {
  p89 = "Very Good";    
 }else if (( percetage89 <=     Excellent89 )&&( percetage89  >= very_good89 )   )
 {
  p89 = "Excellent";  
 
  }  
            
pps7.setDouble( 885,  percetage89 );                                             
pps7.setDate(  886 , sqldate); 
pps7.setString(  887 , class_teacher_class);
pps7.setString(  888, Term);
pps7.setString(  889 , p89 );//inserting cmements by stude
pps7.setString( 890, System_ID.getText().trim());


pps7.setString( 891 ,Sn90 .getText().trim());//student name
 pps7.setString(  892 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 893 ,R90 .getText().trim());// marks_obtained 
pps7.setString( 894 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained90 = Double.parseDouble(R90.getText().trim()); 

double converted_total_marks90 = Double.parseDouble(total_marks.getText().trim());

int percetage90 =(int)(converted_marks_obtained90  / converted_total_marks90  * 100) ;

if (( percetage90  <= failed90 )&&( percetage90>= totallyfailed90)){ 
  p90 = "Failed";  
}else if (( percetage90 <=passed90 )&&( percetage90 >= pass90)   ){ 
  p90 = "Pass";  
}  else if (( percetage90  <= avaerage90 )&&(  percetage90 >= avaerage_end90 ))
{ 
 p90 = "Avaerage"; 
} 
else if ((  percetage90  <=good90 )&&(  percetage90 >= good_end90 ) )
{ 
 p90 ="Good"; 
 }else if ((  percetage90 <= very_good90)&&( percetage90 >= very_good_end90 ))
 {
  p90  = "Very Good";    
 }else if (( percetage90 <=     Excellent90 )&&( percetage90  >= very_good90 )   )
 {
  p90 = "Excellent";  
 
  }  
            
pps7.setDouble( 895,  percetage90);                                             
pps7.setDate(  896 , sqldate); 
pps7.setString(  897 , class_teacher_class);
pps7.setString(  898, Term);
pps7.setString(  899 , p90 );//inserting cmements by stude
pps7.setString( 900, System_ID.getText().trim());


pps7.setString( 901 ,Sn91 .getText().trim());//student name
 pps7.setString(  902 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 903 ,R91 .getText().trim());// marks_obtained 
pps7.setString( 904 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained91 = Double.parseDouble(R91.getText().trim()); 

double converted_total_marks91 = Double.parseDouble(total_marks.getText().trim());

int percetage91 =(int)(converted_marks_obtained91  / converted_total_marks91  * 100) ;

if (( percetage91  <= failed91 )&&( percetage91 >= totallyfailed91)){ 
  p91 = "Failed";  
}else if (( percetage91 <=passed91 )&&( percetage91 >= pass91 )   ){ 
  p91 = "Pass";  
}  else if (( percetage91  <= avaerage91 )&&(  percetage91  >= avaerage_end91 ))
{ 
 p91 = "Avaerage"; 
} 
else if ((  percetage91  <=good91 )&&(  percetage91  >= good_end91 ) )
{ 
 p91 ="Good"; 
 }else if ((  percetage91 <= very_good91)&&( percetage91 >= very_good_end91 ))
 {
  p91  = "Very Good";    
 }else if (( percetage91 <=     Excellent91 )&&( percetage91  >= very_good91)   )
 {
  p91 = "Excellent";  
 
  }  
            
pps7.setDouble( 905,  percetage91 );                                             
pps7.setDate(  906 , sqldate); 
pps7.setString(  907 , class_teacher_class);
pps7.setString(  908, Term);
pps7.setString(  909 , p91 );//inserting cmements by stude
pps7.setString( 910, System_ID.getText().trim());


pps7.setString( 911 ,Sn92 .getText().trim());//student name
 pps7.setString(  912 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 913 ,R92 .getText().trim());// marks_obtained 
pps7.setString( 914 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained92 = Double.parseDouble(R92.getText().trim()); 

double converted_total_marks92 = Double.parseDouble(total_marks.getText().trim());

int percetage92 =(int)(converted_marks_obtained92  / converted_total_marks92  * 100) ;

if (( percetage92  <= failed92 )&&( percetage92>= totallyfailed92)){ 
  p92 = "Failed";  
}else if (( percetage92 <=passed92)&&( percetage92>= pass92)   ){ 
  p92 = "Pass";  
}  else if (( percetage92  <= avaerage92 )&&(  percetage92 >= avaerage_end92 ))
{ 
 p92 = "Avaerage"; 
} 
else if ((  percetage92  <=good92 )&&(  percetage92  >= good_end92 ) )
{ 
 p92 ="Good"; 
 }else if ((  percetage92 <= very_good92 )&&( percetage85 >= very_good_end92 ))
 {
  p92  = "Very Good";    
 }else if (( percetage92 <=     Excellent92 )&&( percetage92  >= very_good92 )   )
 {
  p92 = "Excellent";  
 
  }  
            
pps7.setDouble( 915,  percetage92 );                                             
pps7.setDate(  916 , sqldate); 
pps7.setString(  917 , class_teacher_class);
pps7.setString(  918, Term);
pps7.setString(  919 , p92 );//inserting cmements by stude
pps7.setString( 920, System_ID.getText().trim());




pps7.setString( 921 ,Sn93 .getText().trim());//student name
 pps7.setString(  922 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 923 ,R93 .getText().trim());// marks_obtained 
pps7.setString( 924 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained93 = Double.parseDouble(R93.getText().trim()); 

double converted_total_marks93 = Double.parseDouble(total_marks.getText().trim());

int percetage93 =(int)(converted_marks_obtained93  / converted_total_marks93  * 100) ;

if (( percetage93  <= failed93 )&&( percetage93 >= totallyfailed93)){ 
  p93 = "Failed";  
}else if (( percetage93 <=passed93 )&&( percetage93 >= pass93 )   ){ 
  p93 = "Pass";  
}  else if (( percetage93  <= avaerage93 )&&(  percetage93  >= avaerage_end93 ))
{ 
 p93 = "Avaerage"; 
} 
else if ((  percetage93  <=good93 )&&(  percetage93  >= good_end93 ) )
{ 
 p93 ="Good"; 
 }else if ((  percetage93 <= very_good93 )&&( percetage93 >= very_good_end93 ))
 {
  p93  = "Very Good";    
 }else if (( percetage93  <=     Excellent93 )&&( percetage93  >= very_good93 )   )
 {
  p93 = "Excellent";  
 
  }  
            
pps7.setDouble( 925,  percetage93 );                                             
pps7.setDate(  926 , sqldate); 
pps7.setString(  927 , class_teacher_class);
pps7.setString(  928, Term);
pps7.setString(  929 , p93 );//inserting cmements by stude
pps7.setString( 930, System_ID.getText().trim());


pps7.setString( 931 ,Sn94 .getText().trim());//student name
 pps7.setString(  932 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 933 ,R94 .getText().trim());// marks_obtained 
pps7.setString( 934 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained94 = Double.parseDouble(R94.getText().trim()); 

double converted_total_marks94 = Double.parseDouble(total_marks.getText().trim());

int percetage94 =(int)(converted_marks_obtained94  / converted_total_marks94  * 100) ;

if (( percetage94  <= failed94 )&&( percetage94 >= totallyfailed94)){ 
  p94 = "Failed";  
}else if (( percetage94 <=passed94 )&&( percetage94 >= pass94 )   ){ 
  p94 = "Pass";  
}  else if (( percetage94  <= avaerage94)&&(  percetage94  >= avaerage_end94 ))
{ 
 p94 = "Avaerage"; 
} 
else if ((  percetage94  <=good94)&&(  percetage94  >= good_end94 ) )
{ 
 p94 ="Good"; 
 }else if ((  percetage94 <= very_good94 )&&( percetage94 >= very_good_end94 ))
 {
  p94  = "Very Good";    
 }else if (( percetage94 <=     Excellent94 )&&( percetage94  >= very_good94 )   )
 {
  p94 = "Excellent";  
 
  }  
            
pps7.setDouble( 935,  percetage94 );                                             
pps7.setDate(  936 , sqldate); 
pps7.setString(  937 , class_teacher_class);
pps7.setString(  938, Term);
pps7.setString(  939 , p94 );//inserting cmements by stude
pps7.setString( 940, System_ID.getText().trim());


pps7.setString( 941 ,Sn95 .getText().trim());//student name
 pps7.setString(  942 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 943 ,R95 .getText().trim());// marks_obtained 
pps7.setString( 944 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained95 = Double.parseDouble(R95.getText().trim()); 

double converted_total_marks95 = Double.parseDouble(total_marks.getText().trim());

int percetage95 =(int)(converted_marks_obtained95  / converted_total_marks95  * 100) ;

if (( percetage95  <= failed95 )&&( percetage95 >= totallyfailed95)){ 
  p95 = "Failed";  
}else if (( percetage95 <=passed95 )&&( percetage95 >= pass95 )   ){ 
  p95 = "Pass";  
}  else if (( percetage95  <= avaerage95 )&&(  percetage95  >= avaerage_end95 ))
{ 
 p95 = "Avaerage"; 
} 
else if ((  percetage95  <=good95 )&&(  percetage95  >= good_end95 ) )
{ 
 p95 ="Good"; 
 }else if ((  percetage95 <= very_good95 )&&( percetage95 >= very_good_end95 ))
 {
  p95  = "Very Good";    
 }else if (( percetage95 <=     Excellent95 )&&( percetage95  >= very_good95 )   )
 {
  p95 = "Excellent";  
 
  }  
            
pps7.setDouble( 945,  percetage95 );                                             
pps7.setDate(  946 , sqldate); 
pps7.setString(  947 , class_teacher_class);
pps7.setString(  948, Term);
pps7.setString(  949 , p95 );//inserting cmements by stude
pps7.setString( 950, System_ID.getText().trim());




pps7.setString( 951 ,Sn96 .getText().trim());//student name
 pps7.setString(  952 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 953 ,R96 .getText().trim());// marks_obtained 
pps7.setString( 954 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained96 = Double.parseDouble(R96.getText().trim()); 

double converted_total_marks96 = Double.parseDouble(total_marks.getText().trim());

int percetage96 =(int)(converted_marks_obtained96  / converted_total_marks96  * 100) ;

if (( percetage96  <= failed96 )&&( percetage95 >= totallyfailed96)){ 
  p96 = "Failed";  
}else if (( percetage96 <=passed96 )&&( percetage96 >= pass96 )   ){ 
  p96 = "Pass";  
}  else if (( percetage96  <= avaerage96 )&&(  percetage96  >= avaerage_end96 ))
{ 
 p96 = "Avaerage"; 
} 
else if ((  percetage96  <=good96)&&(  percetage96  >= good_end96 ) )
{ 
 p96 ="Good"; 
 }else if ((  percetage96 <= very_good96)&&( percetage96 >= very_good_end96 ))
 {
  p96  = "Very Good";    
 }else if (( percetage96 <=     Excellent96)&&( percetage96  >= very_good96)   )
 {
  p96 = "Excellent";  
 
  }  
            
pps7.setDouble( 955,  percetage96 );                                             
pps7.setDate(  956 , sqldate); 
pps7.setString(  957 , class_teacher_class);
pps7.setString(  958, Term);
pps7.setString(  959 , p96);//inserting cmements by stude
pps7.setString( 960, System_ID.getText().trim());



pps7.setString( 961 ,Sn97 .getText().trim());//student name
 pps7.setString(  962 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 963 ,R97 .getText().trim());// marks_obtained 
pps7.setString( 964 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained97 = Double.parseDouble(R95.getText().trim()); 

double converted_total_marks97 = Double.parseDouble(total_marks.getText().trim());

int percetage97 =(int)(converted_marks_obtained97  / converted_total_marks95  * 100) ;

if (( percetage97  <= failed97 )&&( percetage97 >= totallyfailed97)){ 
  p97 = "Failed";  
}else if (( percetage97 <=passed97)&&( percetage97 >= pass97)   ){ 
  p97 = "Pass";  
}  else if (( percetage97  <= avaerage97 )&&(  percetage97  >= avaerage_end97 ))
{ 
 p97 = "Avaerage"; 
} 
else if ((  percetage97 <=good97 )&&(  percetage97  >= good_end97 ) )
{ 
 p97 ="Good"; 
 }else if ((  percetage97 <= very_good97 )&&( percetage97 >= very_good_end97 ))
 {
  p97  = "Very Good";    
 }else if (( percetage97 <=     Excellent97 )&&( percetage97  >= very_good97)   )
 {
  p97 = "Excellent";  
 
  }  
            
pps7.setDouble( 965,  percetage97);                                             
pps7.setDate(  966 , sqldate); 
pps7.setString(  967 , class_teacher_class);
pps7.setString(  968, Term);
pps7.setString(  969 , p97 );//inserting cmements by stude
pps7.setString( 970, System_ID.getText().trim());


pps7.setString( 971 ,Sn98 .getText().trim());//student name
 pps7.setString(  972 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 973 ,R98 .getText().trim());// marks_obtained 
pps7.setString( 974 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained98 = Double.parseDouble(R98.getText().trim()); 

double converted_total_marks98 = Double.parseDouble(total_marks.getText().trim());

int percetage98 =(int)(converted_marks_obtained98  / converted_total_marks98  * 100) ;

if (( percetage98  <= failed98)&&( percetage98 >= totallyfailed98)){ 
  p98 = "Failed";  
}else if (( percetage98 <=passed98 )&&( percetage98 >= pass98 )   ){ 
  p98 = "Pass";  
}  else if (( percetage98  <= avaerage98 )&&(  percetage98  >= avaerage_end98 ))
{ 
 p98 = "Avaerage"; 
} 
else if ((  percetage98  <=good98 )&&(  percetage98  >= good_end98 ) )
{ 
 p98 ="Good"; 
 }else if ((  percetage98 <= very_good98 )&&( percetage98 >= very_good_end98 ))
 {
  p98  = "Very Good";    
 }else if (( percetage98 <=     Excellent98 )&&( percetage98  >= very_good98 )   )
 {
  p98 = "Excellent";  
 
  }  
            
pps7.setDouble( 975,  percetage98);                                             
pps7.setDate(  976 , sqldate); 
pps7.setString(  977 , class_teacher_class);
pps7.setString(  978, Term);
pps7.setString(  979 , p98 );//inserting cmements by stude
pps7.setString( 980, System_ID.getText().trim());


pps7.setString( 981 ,Sn99 .getText().trim());//student name
 pps7.setString(  982 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 983 ,R99 .getText().trim());// marks_obtained 
pps7.setString( 984 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained99 = Double.parseDouble(R99.getText().trim()); 

double converted_total_marks99 = Double.parseDouble(total_marks.getText().trim());

int percetage99 =(int)(converted_marks_obtained99  / converted_total_marks99  * 100) ;

if (( percetage99  <= failed99 )&&( percetage99 >= totallyfailed95)){ 
  p99 = "Failed";  
}else if (( percetage99 <=passed99 )&&( percetage99 >= pass99)   ){ 
  p99 = "Pass";  
}  else if (( percetage99  <= avaerage99 )&&(  percetage99  >= avaerage_end99 ))
{ 
 p99 = "Avaerage"; 
} 
else if ((  percetage99  <=good99 )&&(  percetage99  >= good_end99 ) )
{ 
 p99 ="Good"; 
 }else if ((  percetage99 <= very_good99 )&&( percetage99 >= very_good_end99 ))
 {
  p99 = "Very Good";    
 }else if (( percetage99 <=     Excellent99 )&&( percetage99  >= very_good99 )   )
 {
  p99 = "Excellent";  
 
  }  
            
pps7.setDouble( 985,  percetage99 );                                             
pps7.setDate(  986 , sqldate); 
pps7.setString(  987 , class_teacher_class);
pps7.setString(  988, Term);
pps7.setString(  989 , p99 );//inserting cmements by stude
pps7.setString( 990, System_ID.getText().trim());




pps7.setString( 991 ,Sn100 .getText().trim());//student name
 pps7.setString(  992 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 993 ,R100 .getText().trim());// marks_obtained 
pps7.setString( 994 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained100 = Double.parseDouble(R95.getText().trim()); 

double converted_total_marks100 = Double.parseDouble(total_marks.getText().trim());

int percetage100 =(int)(converted_marks_obtained100  / converted_total_marks100  * 100) ;

if (( percetage100  <= failed100 )&&( percetage100 >= totallyfailed100)){ 
  p100 = "Failed";  
}else if (( percetage100 <=passed100 )&&( percetage100 >= pass100 )   ){ 
  p100 = "Pass";  
}  else if (( percetage100  <= avaerage100 )&&(  percetage100  >= avaerage_end100 ))
{ 
 p100 = "Avaerage"; 
} 
else if ((  percetage100  <=good100 )&&(  percetage100  >= good_end100 ) )
{ 
 p100 ="Good"; 
 }else if ((  percetage100 <= very_good100 )&&( percetage100 >= very_good_end100 ))
 {
  p100  = "Very Good";    
 }else if (( percetage100 <=     Excellent100)&&( percetage100  >= very_good100 )   )
 {
  p100 = "Excellent";  
 
  }  
            

pps7.setDouble( 995,  percetage100 );                                             
pps7.setDate(  996 , sqldate); 
pps7.setString(  997 , class_teacher_class);
pps7.setString(  998, Term);
pps7.setString(  999 , p100 );//inserting cmements by stude
pps7.setString( 1000, System_ID.getText().trim());


  
             pps7.executeUpdate();
             JOptionPane.showMessageDialog(null, "GRADE   " + class_teacher_class +"   RESULTS RECORDED ");
        } catch (SQLException ex) {
            
              Logger.getLogger(Teacher_Student_Data_Entry.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       clean_student_results();
    
    }
    
     
      
   
     
     
    public void insert_results_afterREGISTER_NT_FUND(){
                   
 int pass1  = 40, passed1    = 50, failed1    = 39, totallyfailed1   = 0, good1  = 70,avaerage1 = 60,  very_good1 =80, Excellent1 = 90, avaerage_end1  =59, good_end1  =69,very_good_end1 = 79, Excellent_end1  =100   ;
 int pass2  = 40, passed2    = 50, failed2    = 39, totallyfailed2   = 0, good2  = 70,avaerage2 = 60,  very_good2 =80, Excellent2 = 90, avaerage_end2  =59, good_end2  =69,very_good_end2 = 79, Excellent_end2  =100   ;
 int pass3  = 40, passed3    = 50, failed3    = 39, totallyfailed3  = 0, good3  = 70,avaerage3 = 60,  very_good3 =80, Excellent3 = 90, avaerage_end3  =59, good_end3  =69,very_good_end3 = 79, Excellent_end3  =100   ;
 int pass4  = 40, passed4    = 50, failed4    = 39, totallyfailed4   = 0, good4  = 70,avaerage4 = 60,  very_good4 =80, Excellent4 = 90, avaerage_end4 =59, good_end4  =69,very_good_end4 = 79, Excellent_end4  =100   ;
 int pass5  = 40, passed5    = 50, failed5   = 39, totallyfailed5   = 0, good5  = 70,avaerage5 = 60,  very_good5 =80, Excellent5 = 90, avaerage_end5  =59, good_end5  =69,very_good_end5 = 79, Excellent_end5  =100   ;
 int pass6  = 40, passed6    = 50, failed6    = 39, totallyfailed6   = 0, good6  = 70,avaerage6 = 60,  very_good6 =80, Excellent6 = 90, avaerage_end6  =59, good_end6  =69,very_good_end6 = 79, Excellent_end6  =100   ;
 int pass7  = 40, passed7    = 50, failed7    = 39, totallyfailed7   = 0, good7  = 70,avaerage7 = 60,  very_good7 =80, Excellent7 = 90, avaerage_end7  =59, good_end7  =69,very_good_end7 = 79, Excellent_end7  =100   ;
 int pass8  = 40, passed8    = 50, failed8    = 39, totallyfailed8   = 0, good8  = 70,avaerage8 = 60,  very_good8 =80, Excellent8 = 90, avaerage_end8  =59, good_end8  =69,very_good_end8 = 79, Excellent_end8  =100   ;
 int pass9 = 40, passed9    = 50, failed9    = 39, totallyfailed9   = 0, good9  = 70,avaerage9 = 60,  very_good9 =80, Excellent9 = 90, avaerage_end9  =59, good_end9  =69,very_good_end9= 79, Excellent_end9  =100   ;
 int pass10 = 40, passed10  = 50, failed10    = 39, totallyfailed10   = 0, good10  = 70,avaerage10 = 60,  very_good10 =80, Excellent10 = 90, avaerage_end10  =59, good_end10  =69,very_good_end10 = 79, Excellent_end10  =100;
        
        
        
        
 int pass11  = 40, passed11    = 50, failed11    = 39, totallyfailed11   = 0, good11  = 70,avaerage11 = 60,  very_good11 =80, Excellent11 = 90, avaerage_end11  =59, good_end11  =69,very_good_end11 = 79, Excellent_end11  =100   ;
 int pass12  = 40, passed12    = 50, failed12    = 39, totallyfailed12   = 0, good12  = 70,avaerage12 = 60,  very_good12 =80, Excellent12 = 90, avaerage_end12  =59, good_end12  =69,very_good_end12 = 79, Excellent_end12  =100   ;
 int pass13  = 40, passed13    = 50, failed13    = 39, totallyfailed13  = 0, good13  = 70,avaerage13 = 60,  very_good13 =80, Excellent13 = 90, avaerage_end13  =59, good_end13  =69,very_good_end13 = 79, Excellent_end13  =100   ;
 int pass14  = 40, passed14    = 50, failed14    = 39, totallyfailed14   = 0, good14  = 70,avaerage14 = 60,  very_good14 =80, Excellent14 = 90, avaerage_end14 =59, good_end14  =69,very_good_end14 = 79, Excellent_end14  =100   ;
 int pass15  = 40, passed15    = 50, failed15   = 39, totallyfailed15   = 0, good15  = 70,avaerage15 = 60,  very_good15 =80, Excellent15 = 90, avaerage_end15  =59, good_end15  =69,very_good_end15 = 79, Excellent_end15  =100   ;
 int pass16  = 40, passed16    = 50, failed16    = 39, totallyfailed16   = 0, good16  = 70,avaerage16 = 60,  very_good16 =80, Excellent16 = 90, avaerage_end16  =59, good_end16  =69,very_good_end16 = 79, Excellent_end16  =100   ;
 int pass17  = 40, passed17    = 50, failed17    = 39, totallyfailed17   = 0, good17  = 70,avaerage17 = 60,  very_good17 =80, Excellent17 = 90, avaerage_end17  =59, good_end17  =69,very_good_end17 = 79, Excellent_end17  =100   ;
 int pass18  = 40, passed18    = 50, failed18    = 39, totallyfailed18   = 0, good18  = 70,avaerage18 = 60,  very_good18 =80, Excellent18 = 90, avaerage_end18  =59, good_end18  =69,very_good_end18 = 79, Excellent_end18  =100   ;
 int pass19 = 40, passed19    = 50, failed19    = 39, totallyfailed19   = 0, good19  = 70,avaerage19 = 60,  very_good19 =80, Excellent19 = 90, avaerage_end19  =59, good_end19  =69,very_good_end19 = 79, Excellent_end19  =100   ;
 int pass20  = 40, passed20    = 50, failed20    = 39, totallyfailed20   = 0, good20  = 70,avaerage20 = 60,  very_good20 =80, Excellent20 = 90, avaerage_end20  =59, good_end20  =69,very_good_end20 = 79, Excellent_end20  =100   ;

 int pass21  = 40, passed21    = 50, failed21    = 39, totallyfailed21   = 0, good21  = 70,avaerage21 = 60,  very_good21 =80, Excellent21 = 90, avaerage_end21  =59, good_end21  =69,very_good_end21 = 79, Excellent_end21  =100   ;
 int pass22  = 40, passed22    = 50, failed22    = 39, totallyfailed22   = 0, good22  = 70,avaerage22 = 60,  very_good22 =80, Excellent22 = 90, avaerage_end22  =59, good_end22  =69,very_good_end22 = 79, Excellent_end22  =100   ;
 int pass23  = 40, passed23    = 50, failed23    = 39, totallyfailed23  = 0, good23  = 70,avaerage23 = 60,  very_good23 =80, Excellent23 = 90, avaerage_end23  =59, good_end23  =69,very_good_end23 = 79, Excellent_end23  =100   ;
 int pass24  = 40, passed24    = 50, failed24    = 39, totallyfailed24   = 0, good24  = 70,avaerage24 = 60,  very_good24 =80, Excellent24 = 90, avaerage_end24 =59, good_end24  =69,very_good_end24 = 79, Excellent_end24  =100   ;
 int pass25  = 40, passed25    = 50, failed25   = 39, totallyfailed25   = 0, good25  = 70,avaerage25 = 60,  very_good25 =80, Excellent25 = 90, avaerage_end25  =59, good_end25  =69,very_good_end25 = 79, Excellent_end25  =100   ;
 int pass26  = 40, passed26    = 50, failed26    = 39, totallyfailed26   = 0, good26  = 70,avaerage26 = 60,  very_good26 =80, Excellent26 = 90, avaerage_end26  =59, good_end26  =69,very_good_end26 = 79, Excellent_end26  =100   ;
 int pass27  = 40, passed27    = 50, failed27    = 39, totallyfailed27   = 0, good27  = 70,avaerage27 = 60,  very_good27 =80, Excellent27 = 90, avaerage_end27  =59, good_end27  =69,very_good_end27 = 79, Excellent_end27  =100   ;
 int pass28  = 40, passed28    = 50, failed28    = 39, totallyfailed28   = 0, good28  = 70,avaerage28 = 60,  very_good28 =80, Excellent28 = 90, avaerage_end28  =59, good_end28  =69,very_good_end28 = 79, Excellent_end28  =100   ;
 int pass29 = 40, passed29    = 50, failed29    = 39, totallyfailed29   = 0, good29  = 70,avaerage29 = 60,  very_good29 =80, Excellent29 = 90, avaerage_end29  =59, good_end29  =69,very_good_end29 = 79, Excellent_end29  =100   ;
 int pass30  = 40, passed30    = 50, failed30    = 39, totallyfailed30   = 0, good30  = 70,avaerage30 = 60,  very_good30 =80, Excellent30 = 90, avaerage_end30  =59, good_end30  =69,very_good_end30 = 79, Excellent_end30  =100   ;

 int pass31  = 40, passed31    = 50, failed31    = 39, totallyfailed31   = 0, good31  = 70,avaerage31 = 60,  very_good31 =80, Excellent31 = 90, avaerage_end31  =59, good_end31  =69,very_good_end31 = 79, Excellent_end31  =100   ;
 int pass32  = 40, passed32    = 50, failed32    = 39, totallyfailed32   = 0, good32  = 70,avaerage32 = 60,  very_good32 =80, Excellent32 = 90, avaerage_end32  =59, good_end32  =69,very_good_end32 = 79, Excellent_end32  =100   ;
 int pass33  = 40, passed33    = 50, failed33    = 39, totallyfailed33  = 0, good33  = 70,avaerage33 = 60,  very_good33 =80, Excellent33 = 90, avaerage_end33  =59, good_end33  =69,very_good_end33 = 79, Excellent_end33  =100   ;
 int pass34  = 40, passed34    = 50, failed34    = 39, totallyfailed34   = 0, good34  = 70,avaerage34 = 60,  very_good34 =80, Excellent34 = 90, avaerage_end34 =59, good_end34  =69,very_good_end34 = 79, Excellent_end34  =100   ;
 int pass35  = 40, passed35    = 50, failed35   = 39, totallyfailed35   = 0, good35  = 70,avaerage35 = 60,  very_good35 =80, Excellent35 = 90, avaerage_end35  =59, good_end35  =69,very_good_end35 = 79, Excellent_end35  =100   ;
 int pass36  = 40, passed36    = 50, failed36    = 39, totallyfailed36   = 0, good36  = 70,avaerage36 = 60,  very_good36 =80, Excellent36 = 90, avaerage_end36  =59, good_end36  =69,very_good_end36 = 79, Excellent_end36  =100   ;
 int pass37  = 40, passed37    = 50, failed37    = 39, totallyfailed37   = 0, good37  = 70,avaerage37 = 60,  very_good37 =80, Excellent37 = 90, avaerage_end37  =59, good_end37  =69,very_good_end37 = 79, Excellent_end37  =100   ;
 int pass38  = 40, passed38    = 50, failed38    = 39, totallyfailed38   = 0, good38  = 70,avaerage38 = 60,  very_good38 =80, Excellent38 = 90, avaerage_end38  =59, good_end38  =69,very_good_end38 = 79, Excellent_end38  =100   ;
 int pass39 = 40, passed39    = 50, failed39    = 39, totallyfailed39   = 0, good39  = 70,avaerage39 = 60,  very_good39 =80, Excellent39 = 90, avaerage_end39  =59, good_end39  =69,very_good_end39 = 79, Excellent_end39  =100   ;
 int pass40  = 40, passed40    = 50, failed40    = 39, totallyfailed40   = 0, good40  = 70,avaerage40 = 60,  very_good40 =80, Excellent40 = 90, avaerage_end40  =59, good_end40  =69,very_good_end40 = 79, Excellent_end40  =100   ;

 int pass41  = 40, passed41   = 50, failed41    = 39, totallyfailed41   = 0, good41  = 70,avaerage41 = 60,  very_good41 =80, Excellent41 = 90, avaerage_end41  =59, good_end41  =69,very_good_end41 = 79, Excellent_end41  =100   ;
 int pass42  = 40, passed42    = 50, failed42    = 39, totallyfailed42   = 0, good42  = 70,avaerage42 = 60,  very_good42 =80, Excellent42 = 90, avaerage_end42  =59, good_end42  =69,very_good_end42 = 79, Excellent_end42  =100   ;
 int pass43  = 40, passed43    = 50, failed43    = 39, totallyfailed43  = 0, good43  = 70,avaerage43 = 60,  very_good43 =80, Excellent43 = 90, avaerage_end43  =59, good_end43  =69,very_good_end43 = 79, Excellent_end43  =100   ;
 int pass44  = 40, passed44    = 50, failed44    = 39, totallyfailed44   = 0, good44  = 70,avaerage44 = 60,  very_good44 =80, Excellent44 = 90, avaerage_end44 =59, good_end44  =69,very_good_end44 = 79, Excellent_end44  =100   ;
 int pass45  = 40, passed45    = 50, failed45   = 39, totallyfailed45   = 0, good45  = 70,avaerage45 = 60,  very_good45 =80, Excellent45 = 90, avaerage_end45  =59, good_end45  =69,very_good_end45 = 79, Excellent_end45  =100   ;
 int pass46  = 40, passed46    = 50, failed46    = 39, totallyfailed46   = 0, good46  = 70,avaerage46 = 60,  very_good46 =80, Excellent46 = 90, avaerage_end46  =59, good_end46  =69,very_good_end46 = 79, Excellent_end46  =100   ;
 int pass47  = 40, passed47    = 50, failed47    = 39, totallyfailed47   = 0, good47  = 70,avaerage47 = 60,  very_good47 =80, Excellent47 = 90, avaerage_end47  =59, good_end47  =69,very_good_end47 = 79, Excellent_end3l47  =100   ;
 int pass48  = 40, passed48    = 50, failed48    = 39, totallyfailed48   = 0, good48  = 70,avaerage48 = 60,  very_good48 =80, Excellent48 = 90, avaerage_end48  =59, good_end48  =69,very_good_end48 = 79, Excellent_end48  =100   ;
 int pass49 = 40, passed49    = 50, failed49    = 39, totallyfailed49   = 0, good49  = 70,avaerage49 = 60,  very_good49 =80, Excellent49 = 90, avaerage_end49  =59, good_end49  =69,very_good_end49 = 79, Excellent_end49  =100   ;
 int pass50  = 40, passed50    = 50, failed50    = 39, totallyfailed50   = 0, good50  = 70,avaerage50 = 60,  very_good50 =80, Excellent50 = 90, avaerage_end50  =59, good_end50  =69,very_good_end50 = 79, Excellent_end50  =100   ;





 int pass51  = 40, passed51    = 50, failed51    = 39, totallyfailed51   = 0, good51  = 70,avaerage51 = 60,  very_good51 =80, Excellent51 = 90, avaerage_end51  =59, good_end51  = 69,very_good_end51 = 79, Excellent_end51  =100   ;
 int pass52  = 40, passed52    = 50, failed52    = 39, totallyfailed52   = 0, good52  = 70,avaerage52 = 60,  very_good52 =80, Excellent52 = 90, avaerage_end52  =59, good_end52  =69,very_good_end52 = 79, Excellent_end52  =100   ;
 int pass53  = 40, passed53    = 50, failed53    = 39, totallyfailed53  = 0, good53  = 70,avaerage53 = 60,  very_good53 =80, Excellent53 = 90, avaerage_end53  =59, good_end53  =69,very_good_end53 = 79, Excellent_end53  =100   ;
 int pass54  = 40, passed54    = 50, failed54    = 39, totallyfailed54   = 0, good54  = 70,avaerage54 = 60,  very_good54 =80, Excellent54 = 90, avaerage_end54 =59, good_end54  =69,very_good_end54 = 79, Excellent_end54  =100   ;
 int pass55  = 40, passed55    = 50, failed55   = 39, totallyfailed55   = 0, good55  = 70,avaerage55 = 60,  very_good55 =80, Excellent55 = 90, avaerage_end55  =59, good_end55  =69,very_good_end55 = 79, Excellent_end55  =100   ;
 int pass56  = 40, passed56    = 50, failed56    = 39, totallyfailed56   = 0, good56  = 70,avaerage56 = 60,  very_good56 =80, Excellent56 = 90, avaerage_end56  =59, good_end56  =69,very_good_end56 = 79, Excellent_end56  =100   ;
 int pass57  = 40, passed57    = 50, failed57    = 39, totallyfailed57   = 0, good57  = 70,avaerage57 = 60,  very_good57 =80, Excellent57 = 90, avaerage_end57  =59, good_end57  =69,very_good_end57 = 79, Excellent_end57  =100   ;
 int pass58  = 40, passed58    = 50, failed58    = 39, totallyfailed58   = 0, good58  = 70,avaerage58 = 60,  very_good58 =80, Excellent58 = 90, avaerage_end58  =59, good_end58  =69,very_good_end58 = 79, Excellent_end58  =100   ;
 int pass59 = 40, passed59    = 50, failed59    = 39, totallyfailed59   = 0, good59  = 70,avaerage59 = 60,  very_good59 =80, Excellent59 = 90, avaerage_end59  =59, good_end59  =69,very_good_end59 = 79, Excellent_end59  =100   ;
 int pass60  = 40, passed60    = 50, failed60    = 39, totallyfailed60   = 0, good60  = 70,avaerage60 = 60,  very_good60 =80, Excellent60 = 90, avaerage_end60  =59, good_end60  =69,very_good_end60 = 79, Excellent_end60  =100   ;

 int pass61  = 40, passed61    = 50, failed61    = 39, totallyfailed61   = 0, good61  = 70,avaerage61 = 60,  very_good61 =80, Excellent61 = 90, avaerage_end61  =59, good_end61  =69,very_good_end61 = 79, Excellent_end61  =100   ;
 int pass62  = 40, passed62    = 50, failed62    = 39, totallyfailed62   = 0, good62  = 70,avaerage62 = 60,  very_good62 =80, Excellent62 = 90, avaerage_end62  =59, good_end62  =69,very_good_end62 = 79, Excellent_end62  =100   ;
 int pass63  = 40, passed63    = 50, failed63    = 39, totallyfailed63  = 0, good63  = 70,avaerage63 = 60,  very_good63 =80, Excellent63 = 90, avaerage_end63  =59, good_end63  =69,very_good_end63 = 79, Excellent_end63  =100   ;
 int pass64  = 40, passed64    = 50, failed64    = 39, totallyfailed64   = 0, good64  = 70,avaerage64 = 60,  very_good64 =80, Excellent64 = 90, avaerage_end64 =59, good_end64  =69,very_good_end64 = 79, Excellent_end64  =100   ;
 int pass65  = 40, passed65    = 50, failed65   = 39, totallyfailed65   = 0, good65  = 70,avaerage65 = 60,  very_good65 =80, Excellent65 = 90, avaerage_end65  =59, good_end65  =69,very_good_end65 = 79, Excellent_end65  =100   ;
 int pass66  = 40, passed66    = 50, failed66    = 39, totallyfailed66   = 0, good66  = 70,avaerage66 = 60,  very_good66 =80, Excellent66 = 90, avaerage_end66  =59, good_end66  =69,very_good_end66 = 79, Excellent_end66  =100   ;
 int pass67  = 40, passed67    = 50, failed67    = 39, totallyfailed67   = 0, good67  = 70,avaerage67 = 60,  very_good67 =80, Excellent67 = 90, avaerage_end67  =59, good_end67  =69,very_good_end67 = 79, Excellent_end67  =100   ;
 int pass68  = 40, passed68    = 50, failed68    = 39, totallyfailed68   = 0, good68  = 70,avaerage68 = 60,  very_good68 =80, Excellent68 = 90, avaerage_end68  =59, good_end68  =69,very_good_end68 = 79, Excellent_end68  =100   ;
 int pass69 = 40, passed69    = 50, failed69    = 39, totallyfailed69   = 0, good69  = 70,avaerage69 = 60,  very_good69 =80, Excellent69 = 90, avaerage_end69  =59, good_end69  =69,very_good_end69 = 79, Excellent_end69  =100   ;
 int pass70  = 40, passed70    = 50, failed70    = 39, totallyfailed70   = 0, good70  = 70,avaerage70 = 60,  very_good70 =80, Excellent70 = 90, avaerage_end70  =59, good_end70  =69,very_good_end70 = 79, Excellent_end70  =100   ;


 int pass71  = 40, passed71    = 50, failed71    = 39, totallyfailed71   = 0, good71  = 70,avaerage71 = 60,  very_good71 =80, Excellent71 = 90, avaerage_end71  =59, good_end71  =69,very_good_end71 = 79, Excellent_end71  =100   ;
 int pass72  = 40, passed72    = 50, failed72    = 39, totallyfailed72   = 0, good72  = 70,avaerage72 = 60,  very_good72 =80, Excellent72 = 90, avaerage_end72  =59, good_end72  =69,very_good_end72 = 79, Excellent_end72  =100   ;
 int pass73  = 40, passed73    = 50, failed73    = 39, totallyfailed73  = 0, good73  = 70,avaerage73 = 60,  very_good73 =80, Excellent73 = 90, avaerage_end73  =59, good_end73  =69,very_good_end73 = 79, Excellent_end73  =100   ;
 int pass74  = 40, passed74    = 50, failed74    = 39, totallyfailed74   = 0, good74  = 70,avaerage74 = 60,  very_good74 =80, Excellent74 = 90, avaerage_end74 =59, good_end74  =69,very_good_end74 = 79, Excellent_end74  =100   ;
 int pass75  = 40, passed75    = 50, failed75   = 39, totallyfailed75   = 0, good75  = 70,avaerage75 = 60,  very_good75 =80, Excellent75 = 90, avaerage_end75  =59, good_end75  =69,very_good_end75 = 79, Excellent_end75  =100   ;
 int pass76  = 40, passed76    = 50, failed76    = 39, totallyfailed76   = 0, good76  = 70,avaerage76 = 60,  very_good76 =80, Excellent76 = 90, avaerage_end76  =59, good_end76  =69,very_good_end76 = 79, Excellent_end76  =100   ;
 int pass77  = 40, passed77    = 50, failed77    = 39, totallyfailed77   = 0, good77  = 70,avaerage77 = 60,  very_good77 =80, Excellent77 = 90, avaerage_end77  =59, good_end77  =69,very_good_end77 = 79, Excellent_end77  =100   ;
 int pass78  = 40, passed78    = 50, failed78    = 39, totallyfailed78   = 0, good78  = 70,avaerage78 = 60,  very_good78 =80, Excellent78 = 90, avaerage_end78  =59, good_end78  =69,very_good_end78 = 79, Excellent_end78  =100   ;
 int pass79 = 40, passed79    = 50, failed79    = 39, totallyfailed79   = 0, good79  = 70,avaerage79 = 60,  very_good79 =80, Excellent79 = 90, avaerage_end79  =59, good_end79  =69,very_good_end79 = 79, Excellent_end79  =100   ;
 int pass80  = 40, passed80    = 50, failed80    = 39, totallyfailed80   = 0, good80  = 70,avaerage80 = 60,  very_good80 =80, Excellent80 = 90, avaerage_end80  =59, good_end80  =69,very_good_end80 = 79, Excellent_end80  =100   ;

 int pass81  = 40, passed81    = 50, failed81    = 39, totallyfailed81   = 0, good81  = 70,avaerage81 = 60,  very_good81 =80, Excellent81 = 90, avaerage_end81  =59, good_end81  =69,very_good_end81 = 79, Excellent_end81  =100   ;
 int pass82  = 40, passed82    = 50, failed82    = 39, totallyfailed82   = 0, good82  = 70,avaerage82 = 60,  very_good82 =80, Excellent82 = 90, avaerage_end82  =59, good_end82  =69,very_good_end82 = 79, Excellent_end82  =100   ;
 int pass83  = 40, passed83    = 50, failed83    = 39, totallyfailed83  = 0, good83  = 70,avaerage83 = 60,  very_good83 =80, Excellent83 = 90, avaerage_end83  =59, good_end83  =69,very_good_end83 = 79, Excellent_end83  =100   ;
 int pass84  = 40, passed84    = 50, failed84    = 39, totallyfailed84   = 0, good84  = 70,avaerage84 = 60,  very_good84 =80, Excellent84 = 90, avaerage_end84 =59, good_end84  =69,very_good_end84 = 79, Excellent_end84  =100   ;
 int pass85  = 40, passed85    = 50, failed85   = 39, totallyfailed85   = 0, good85  = 70,avaerage85 = 60,  very_good85 =80, Excellent85 = 90, avaerage_end85  =59, good_end85  =69,very_good_end85 = 79, Excellent_end85  =100   ;
 int pass86  = 40, passed86    = 50, failed86    = 39, totallyfailed86   = 0, good86  = 70,avaerage86 = 60,  very_good86 =80, Excellent86 = 90, avaerage_end86  =59, good_end86  =69,very_good_end86 = 79, Excellent_end86  =100   ;
 int pass87  = 40, passed87    = 50, failed87    = 39, totallyfailed87   = 0, good87  = 70,avaerage87 = 60,  very_good87 =80, Excellent87 = 90, avaerage_end87  =59, good_end87  =69,very_good_end87 = 79, Excellent_end87  =100   ;
 int pass88  = 40, passed88    = 50, failed88    = 39, totallyfailed88   = 0, good88  = 70,avaerage88 = 60,  very_good88 =80, Excellent88 = 90, avaerage_end88  =59, good_end88  =69,very_good_end88 = 79, Excellent_end88  =100   ;
 int pass89 = 40, passed89    = 50, failed89    = 39, totallyfailed89   = 0, good89  = 70,avaerage89 = 60,  very_good89 =80, Excellent89 = 90, avaerage_end89  =59, good_end89  =69,very_good_end89 = 79, Excellent_end89  =100   ;
 int pass90  = 40, passed90    = 50, failed90    = 39, totallyfailed90   = 0, good90  = 70,avaerage90 = 60,  very_good90 =80, Excellent90 = 90, avaerage_end90  =59, good_end90  =69,very_good_end90 = 79, Excellent_end90  =100   ;

 int pass91  = 40, passed91   = 50, failed91    = 39, totallyfailed91   = 0, good91  = 70,avaerage91 = 60,  very_good91 =80, Excellent91 = 90, avaerage_end91  =59, good_end91  =69,very_good_end91 = 79, Excellent_end91  =100   ;
 int pass92  = 40, passed92    = 50, failed92    = 39, totallyfailed92   = 0, good92  = 70,avaerage92 = 60,  very_good92 =80, Excellent92 = 90, avaerage_end92  =59, good_end92  =69,very_good_end92 = 79, Excellent_end92  =100   ;
 int pass93  = 40, passed93    = 50, failed93    = 39, totallyfailed93  = 0, good93  = 70,avaerage93 = 60,  very_good93 =80, Excellent93 = 90, avaerage_end93  =59, good_end93  =69,very_good_end93 = 79, Excellent_end93  =100   ;
 int pass94  = 40, passed94    = 50, failed94    = 39, totallyfailed94   = 0, good94  = 70,avaerage94 = 60,  very_good94 =80, Excellent94 = 90, avaerage_end94 =59, good_end94  =69,very_good_end94 = 79, Excellent_end94  =100   ;
 int pass95  = 40, passed95    = 50, failed95   = 39, totallyfailed95   = 0, good95  = 70,avaerage95 = 60,  very_good95 =80, Excellent95 = 90, avaerage_end95  =59, good_end95  =69,very_good_end95 = 79, Excellent_end95  =100   ;
 int pass96  = 40, passed96    = 50, failed96    = 39, totallyfailed96   = 0, good96  = 70,avaerage96 = 60,  very_good96 =80, Excellent96 = 90, avaerage_end96  =59, good_end96  =69,very_good_end96 = 79, Excellent_end96  =100   ;
 int pass97  = 40, passed97    = 50, failed97    = 39, totallyfailed97   = 0, good97  = 70,avaerage97 = 60,  very_good97 =80, Excellent97 = 90, avaerage_end97  =59, good_end97  =69,very_good_end97 = 79, Excellent_end97  =100   ;
 int pass98  = 40, passed98    = 50, failed98    = 39, totallyfailed98   = 0, good98  = 70,avaerage98 = 60,  very_good98 =80, Excellent98 = 90, avaerage_end98  =59, good_end98  =69,very_good_end98 = 79, Excellent_end98  =100   ;
 int pass99 = 40, passed99    = 50, failed99    = 39, totallyfailed99   = 0, good99  = 70,avaerage99 = 60,  very_good99 =80, Excellent99 = 90, avaerage_end99  =59, good_end99  =69,very_good_end99 = 79, Excellent_end99  =100   ;
 int pass100  = 40, passed100    = 50, failed100   = 39, totallyfailed100   = 0, good100  = 70,avaerage100 = 60,  very_good100 =80, Excellent100 = 90, avaerage_end100  =59, good_end100  =69,very_good_end100 = 79, Excellent_end100  =100   ;

 int pass101  = 40, passed101    = 50, failed101    = 39, totallyfailed101   = 0, good101  = 70,avaerage101 = 60,  very_good101 =80, Excellent101 = 90, avaerage_end101  =59, good_end101  =69,very_good_end101 = 79, Excellent_end101  =100   ;
 int pass102  = 40, passed102    = 50, failed102    = 39, totallyfailed102   = 0, good102  = 70,avaerage102 = 60,  very_good102 =80, Excellent102 = 90, avaerage_end102  =59, good_end102  =69,very_good_end102 = 79, Excellent_end102  =100   ;
 int pass103  = 40, passed103    = 50, failed103    = 39, totallyfailed103  = 0, good103  = 70,avaerage103 = 60,  very_good103 =80, Excellent103 = 90, avaerage_end103  =59, good_end103  =69,very_good_end103 = 79, Excellent_end103  =100   ;
 int pass104  = 40, passed104    = 50, failed104    = 39, totallyfailed104   = 0, good104  = 70,avaerage104 = 60,  very_good104 =80, Excellent104 = 90, avaerage_end104 =59, good_end104  =69,very_good_end104 = 79, Excellent_end104  =100   ;
 int pass105  = 40, passed105    = 50, failed105   = 39, totallyfailed105   = 0, good105  = 70,avaerage105 = 60,  very_good105 =80, Excellent105 = 90, avaerage_end105  =59, good_end105  =69,very_good_end105 = 79, Excellent_end105  =100   ;
 int pass106  = 40, passed106    = 50, failed106    = 39, totallyfailed106   = 0, good106  = 70,avaerage106 = 60,  very_good106 =80, Excellent106 = 90, avaerage_end106  =59, good_end106  =69,very_good_end106 = 79, Excellent_end106  =100   ;
 int pass107  = 40, passed107    = 50, failed107    = 39, totallyfailed107   = 0, good107  = 70,avaerage107 = 60,  very_good107 =80, Excellent107 = 90, avaerage_end107  =59, good_end107  =69,very_good_end107 = 79, Excellent_end107  =100   ;
 int pass108  = 40, passed108    = 50, failed108    = 39, totallyfailed108   = 0, good108  = 70,avaerage108 = 60,  very_good108 =80, Excellent108 = 90, avaerage_end108  =59, good_end108  =69,very_good_end108 = 79, Excellent_end108  =100   ;
 int pass109 = 40, passed109    = 50, failed109    = 39, totallyfailed109   = 0, good109  = 70,avaerage109 = 60,  very_good109 =80, Excellent109 = 90, avaerage_end109  =59, good_end109  =69,very_good_end109= 79, Excellent_end109  =100   ;
 int pass110  = 40;
         
             String Term_mode_choosers =Term_mode_chooser.getSelectedItem().toString().trim();
             String Term_choosers = Term_chooser.getSelectedItem().toString().trim();
             
            String Term = Term_choosers + Term_mode_choosers;
        
        try {
            
                 Date date = jDateChooser1.getDate();
                     java.sql.Date sqldate = new java.sql.Date(date.getTime());
                 
             conn = DBConnection.getConnction();
             
            
            
            pps7= conn.prepareStatement("INSERT INTO  student_resuits (Full_name,subject, Marks_obtain,Total_Marks,Percentage,Day_time,Class,Term,Comments,Handing_Teacher)VALUES (?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?), "
                    + "(?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),  "
                    + "(?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?), "
                    + "(?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?), (?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?),(?,?,?,?,?,?,?,?,?,?) ");  //,
            
             
             
             pps7.setString(1 , Sn1.getText().trim());                  //student name
             pps7.setString(2 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(3 , R1.getText().trim());                   // marks_obtained 
             pps7.setString(4 , total_marks.getText().trim());                     // total_marks_  
                            double converted_marks_obtained1 = Double.parseDouble(R1.getText().trim());  double converted_total_marks1 = Double.parseDouble(total_marks.getText().trim());
                         int percetage1 =(int)(converted_marks_obtained1/converted_total_marks1* 100) ;
                      if ((percetage1 <= failed1 )&&(percetage1 >= totallyfailed1 )){ p1 = "Failed";  }else if ((percetage1 <=passed1 )&&(percetage1  >= pass1  )   ){ p1 = "Pass";  }  else if ((percetage1  <= avaerage1 )&&(percetage1  >= avaerage_end1  )){ p1 = "Avaerage"; ; 
                } else if ((percetage1  <=good1 )&&(percetage1 >= good_end1 ) ){ p1 ="Good";  }else if ((percetage1 <= very_good1 )&&(percetage1 >= very_good_end1  )){ p1 = "Very Good";    }else if ((percetage1 <= Excellent1 )&&(percetage1  >= very_good1 )   ){ p1 = "Excellent";   }
            
             pps7.setDouble(5 , percetage1);                                    
             pps7.setDate(6 ,  sqldate);
             pps7.setString(7 , class_teacher_class);
             pps7.setString(8 , Term);
              pps7.setString( 9, p1);//inserting cmements by students marks
             pps7.setString(10 , System_ID.getText().trim());
             
              

            
           
             pps7.setString(11 , Sn2.getText().trim());                  //student name
             pps7.setString(12 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(13 , R2.getText().trim());                   // marks_obtained 
             pps7.setString(14 , total_marks.getText().trim());                     // total_marks_  
                   double converted_marks_obtained2 = Double.parseDouble(R2.getText().trim());  double converted_total_marks2 = Double.parseDouble(total_marks.getText().trim());
                   int percetage2 =(int)(converted_marks_obtained2/converted_total_marks2* 100) ;
                   if ((percetage2 <= failed2  )&&(percetage2 >= totallyfailed2 )){ p2 = "Failed";  }else if ((percetage2 <=passed2 )&&(percetage2  >= pass2 )   ){ p2 = "Pass";  }  else if ((percetage2  <= avaerage2 )&&(percetage2  >= avaerage_end2  )){ p2 = "Avaerage"; ; 
                    } else if ((percetage2  <= good2  )&&(percetage2 >= good_end2  ) ){ p2 ="Good";  }else if ((percetage2 <= very_good2)&&(percetage2 >= very_good_end2 )){ p2 = "Very Good";    }else if ((percetage2 <= Excellent2 )&&(percetage2  >= very_good2 )   ){ p2 = "Excellent"; }
             pps7.setDouble(15 ,percetage2);                                           // Percentage  
             pps7.setDate(16 , sqldate);
             pps7.setString(17 , class_teacher_class);
             pps7.setString(18 , Term);
             pps7.setString(19, p2);//inserting cmements by students marks
             pps7.setString( 20, System_ID.getText().trim());
             
              
              
              
          
             
             
             
             
            
             
             pps7.setString(21 , Sn3.getText().trim());                  //student name
             pps7.setString(22 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(23 , R3.getText().trim());                   // marks_obtained 
             pps7.setString(24 , total_marks.getText().trim());                     // total_marks_  
                      double converted_marks_obtained3 = Double.parseDouble(R3.getText().trim());  double converted_total_marks3 = Double.parseDouble(total_marks.getText().trim());
                      int percetage3 =(int)(converted_marks_obtained3/converted_total_marks3* 100) ;
                      if ((percetage3 <= failed3 )&&(percetage3 >= totallyfailed3)){ p3 = "Failed";  }else if ((percetage3 <=passed3 )&&(percetage3  >= pass3 )   ){ p3 = "Pass";  }  else if ((percetage3  <= avaerage3 )&&(percetage3  >= avaerage_end3 )){ p3 = "Avaerage"; ; 
                      } else if ((percetage3  <=good3 )&&(percetage3 >= good_end3 ) ){ p3 ="Good";  }else if ((percetage3 <= very_good3 )&&(percetage3 >= very_good_end3 )){ p3 = "Very Good";    }else if ((percetage3 <= Excellent3 )&&(percetage3  >= very_good3 )   ){ p3 = "Excellent";   }
            
             pps7.setDouble(25 , percetage3);                                           // Percentage  
             pps7.setDate(26, sqldate);
             pps7.setString(27, class_teacher_class);
             pps7.setString(28 , Term);
             pps7.setString( 29, p3);//inserting cmements by students marks
             pps7.setString( 30, System_ID.getText().trim());
            
              
             
             pps7.setString(31 , Sn4.getText().trim());                  //student name
             pps7.setString(32 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(33 , R4.getText().trim());                   // marks_obtained 
             pps7.setString(34 , total_marks.getText().trim());                     // total_marks_  
            
                   double converted_marks_obtained4 = Double.parseDouble(R4.getText().trim());  double converted_total_marks4 = Double.parseDouble(total_marks.getText().trim());
                    int percetage4 =(int)(converted_marks_obtained4/converted_total_marks4* 100) ;
                  if ((percetage4 <= failed4 )&&(percetage4 >= totallyfailed4)){ p4 = "Failed";  }else if ((percetage4 <=passed4 )&&(percetage4  >= pass4 )   ){ p4 = "Pass";  }  else if ((percetage4  <= avaerage4 )&&(percetage4  >= avaerage_end4 )){ p4 = "Avaerage"; ; 
                } else if ((percetage4 <=good4 )&&(percetage4 >= good_end4) ){ p4 ="Good";  }else if ((percetage4 <= very_good4 )&&(percetage4 >= very_good_end4 )){ p4 = "Very Good";    }else if ((percetage4 <= Excellent4 )&&(percetage4  >= very_good4 )   ){ p4 = "Excellent";   } 
            
             pps7.setDouble(35, percetage4 );                                           // Percentage  
             pps7.setDate(36, sqldate);
             pps7.setString(37 , class_teacher_class);
             pps7.setString(38, Term);
              pps7.setString(39 , p4);//inserting cmements by students marks
             pps7.setString( 40, System_ID.getText().trim());
            
            
             
             pps7.setString(41 , Sn5.getText().trim());                  //student name
             pps7.setString(42 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(43 , R5.getText().trim());                   // marks_obtained 
             pps7.setString(44 , total_marks.getText().trim());                     // total_marks_  
            
                double converted_marks_obtained5 = Double.parseDouble(R5.getText().trim());  double converted_total_marks5 = Double.parseDouble(total_marks.getText().trim());
                    int percetage5=(int)(converted_marks_obtained5/converted_total_marks5* 100) ;
                  if ((percetage5 <= failed5 )&&(percetage5 >= totallyfailed5)){ p5 = "Failed";  }else if ((percetage5 <=passed5 )&&(percetage5  >= pass5 )   ){ p5 = "Pass";  }  else if ((percetage5  <= avaerage5 )&&(percetage5  >= avaerage_end5 )){ p5 = "Avaerage"; ; 
                } else if ((percetage5 <=good5  )&&(percetage5 >= good_end5 ) ){ p5 ="Good";  }else if ((percetage5 <= very_good5 )&&(percetage5 >= very_good_end5 )){ p5 = "Very Good";    }else if ((percetage5 <= Excellent5 )&&(percetage5  >= very_good5 )   ){ p5 = "Excellent";   }
            
             pps7.setDouble(45, percetage5);                                           // Percentage  
             pps7.setDate(46, sqldate);
             pps7.setString(47 , class_teacher_class);
             pps7.setString(48, Term);
              pps7.setString(49 , p5);//inserting cmements by students marks
             pps7.setString( 50, System_ID.getText().trim());
             
             
             
              pps7.setString(51 , Sn6.getText().trim());                  //student name
             pps7.setString(52 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(53 , R6.getText().trim());                   // marks_obtained 
             pps7.setString(54 , total_marks.getText().trim());                     // total_marks_  
            
                   double converted_marks_obtained6 = Double.parseDouble(R6.getText().trim());  double converted_total_marks6 = Double.parseDouble(total_marks.getText().trim());
                    int percetage6=(int)(converted_marks_obtained6 / converted_total_marks6 * 100) ;
                  if ((percetage6 <= failed6 )&&(percetage6 >= totallyfailed6)){ p6 = "Failed";  }else if ((percetage6 <=passed6 )&&(percetage6  >= pass6 )   ){ p6 = "Pass";  }  else if ((percetage6  <= avaerage6 )&&(percetage6  >= avaerage_end6 )){ p6 = "Avaerage"; ; 
                   } else if ((percetage6 <=good6 )&&(percetage6 >= good_end6 ) ){ p6 ="Good";  }else if ((percetage6 <= very_good6 )&&(percetage6 >= very_good_end6 )){ p6 = "Very Good";    }else if ((percetage6 <= Excellent6 )&&(percetage6  >= very_good6 )   ){ p6 = "Excellent";   }  
            
             pps7.setDouble(55, percetage6);                                           // Percentage  
             pps7.setDate(56, sqldate);
             pps7.setString(57 , class_teacher_class);
             pps7.setString(58, Term);
              pps7.setString(59 , p6);//inserting cmements by students marks
             pps7.setString( 60, System_ID.getText().trim());
             
             
             
              pps7.setString(61 , Sn7.getText().trim());                  //student name
             pps7.setString(62 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(63 , R7.getText().trim());                   // marks_obtained 
             pps7.setString(64 , total_marks.getText().trim());                     // total_marks_  
            
                   double converted_marks_obtained7 = Double.parseDouble(R7.getText().trim());  double converted_total_marks7 = Double.parseDouble(total_marks.getText().trim());
                    int percetage7=(int)(converted_marks_obtained7 / converted_total_marks7 * 100) ;
                  if ((percetage7 <= failed7 )&&(percetage7 >= totallyfailed7)){ p7 = "Failed";  }else if ((percetage7 <=passed7)&&(percetage7  >= pass7 )   ){ p7 = "Pass";  }  else if ((percetage7  <= avaerage7 )&&(percetage7  >= avaerage_end7 )){ p7 = "Avaerage"; ; 
                   } else if ((percetage7 <=good7 )&&(percetage7 >= good_end7 ) ){ p7="Good";  }else if ((percetage7 <= very_good7 )&&(percetage7 >= very_good_end7 )){ p7 = "Very Good";    }else if ((percetage7 <= Excellent7 )&&(percetage7  >= very_good7 )   ){ p7 = "Excellent";   }  
            
             pps7.setDouble(65, percetage7);                                           // Percentage  
             pps7.setDate(66, sqldate);
             pps7.setString(67 , class_teacher_class);
             pps7.setString(68, Term);
              pps7.setString(69 , p7);//inserting cmements by students marks
             pps7.setString( 70, System_ID.getText().trim());
             
          
            
                pps7.setString(71 , Sn8.getText().trim());                  //student name
             pps7.setString(72 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(73 , R8.getText().trim());                   // marks_obtained 
             pps7.setString(74 , total_marks.getText().trim());                     // total_marks_  
            
                   double converted_marks_obtained8 = Double.parseDouble(R8.getText().trim());  double converted_total_marks8 = Double.parseDouble(total_marks.getText().trim());
                    int percetage8=(int)(converted_marks_obtained8 / converted_total_marks8 * 100) ;
                  if ((percetage8 <= failed8 )&&(percetage8 >= totallyfailed8)){ p8 = "Failed";  }else if ((percetage8 <=passed8 )&&(percetage8  >= pass8 )   ){ p8  = "Pass";  }  else if ((percetage8  <= avaerage8 )&&(percetage8  >= avaerage_end8 )){ p8 = "Avaerage"; ; 
                   } else if ((percetage8 <=good8 )&&(percetage8 >= good_end8 ) ){ p8 ="Good";  }else if ((percetage8 <= very_good8 )&&(percetage8 >= very_good_end8 )){ p8  = "Very Good";    }else if ((percetage8 <= Excellent8 )&&(percetage8  >= very_good8 )   ){ p8  = "Excellent";   }  
            
             pps7.setDouble(75, percetage8);                                           // Percentage  
             pps7.setDate(76, sqldate);
             pps7.setString(77 , class_teacher_class);
             pps7.setString(78, Term);
              pps7.setString(79 , p8);//inserting cmements by students marks
             pps7.setString( 80, System_ID.getText().trim());
             
             
             
             
                pps7.setString(81 , Sn9.getText().trim());                  //student name
                pps7.setString(82 , showsubjects.getSelectedItem().toString().trim()); //subjects
                pps7.setString(83 , R9.getText().trim());                   // marks_obtained 
                pps7.setString(84 , total_marks.getText().trim());                     // total_marks_  
            
                   double converted_marks_obtained9 = Double.parseDouble(R9.getText().trim());  double converted_total_marks9 = Double.parseDouble(total_marks.getText().trim());
                    int percetage9=(int)(converted_marks_obtained9 / converted_total_marks9 * 100) ;
                  if ((percetage9 <= failed9 )&&(percetage9 >= totallyfailed9)){ p9 = "Failed";  }else if ((percetage9 <=passed9 )&&(percetage9  >= pass9 )   ){ p9  = "Pass";  }  else if ((percetage9  <= avaerage9 )&&(percetage9  >= avaerage_end9 )){ p9  = "Avaerage"; ; 
                   } else if ((percetage9 <=good9 )&&(percetage9 >= good_end9 ) ){ p9="Good";  }else if ((percetage9 <= very_good9 )&&(percetage9 >= very_good_end9 )){ p9  = "Very Good";    }else if ((percetage9 <= Excellent9 )&&(percetage9  >= very_good9 )   ){ p9  = "Excellent";   }  
            
             pps7.setDouble(85, percetage9);                                           // Percentage  
             pps7.setDate(86, sqldate);
             pps7.setString(87 , class_teacher_class);
             pps7.setString(88, Term);
              pps7.setString(89 , p9);//inserting cmements by students marks
             pps7.setString( 90, System_ID.getText().trim());
             
             
             
             
                pps7.setString(91 , Sn10.getText().trim());                  //student name
             pps7.setString(92 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(93 , R10.getText().trim());                   // marks_obtained 
             pps7.setString(94 , total_marks.getText().trim());                     // total_marks_  
            
                   double converted_marks_obtained10 = Double.parseDouble(R10.getText().trim());  double converted_total_marks10 = Double.parseDouble(total_marks.getText().trim());
                    int percetage10=(int)(converted_marks_obtained10 / converted_total_marks10 * 100) ;
                  if ((percetage10 <= failed10 )&&(percetage10 >= totallyfailed10)){ p10 = "Failed";  }else if ((percetage10 <=passed10 )&&(percetage10  >= pass10 )   ){ p10  = "Pass";  }  else if ((percetage10  <= avaerage10 )&&(percetage10  >= avaerage_end10 )){ p10  = "Avaerage"; ; 
                   } else if ((percetage10 <=good10 )&&(percetage10 >= good_end10 ) ){ p10="Good";  }else if ((percetage10 <= very_good10 )&&(percetage10 >= very_good_end10 )){ p10  = "Very Good";    }else if ((percetage10 <= Excellent10 )&&(percetage10  >= very_good10 )   ){ p10  = "Excellent";   }  
            
             pps7.setDouble(95, percetage10);                                           // Percentage  
             pps7.setDate(96, sqldate);
             pps7.setString(97 , class_teacher_class);
             pps7.setString(98, Term);
              pps7.setString(99 , p10);//inserting cmements by students marks
             pps7.setString( 100, System_ID.getText().trim());
             
           
             
             
              
             
                pps7.setString(101 , Sn11.getText().trim());                  //student name
             pps7.setString(102 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(103 , R11.getText().trim());                   // marks_obtained 
             pps7.setString(104 , total_marks.getText().trim());                     // total_marks_  
            
                   double converted_marks_obtained11 = Double.parseDouble(R11.getText().trim());  double converted_total_marks11 = Double.parseDouble(total_marks.getText().trim());
                    int percetage11  =(int)(converted_marks_obtained11 / converted_total_marks11 * 100) ;
                  if ((percetage11 <= failed11 )&&(percetage11 >= totallyfailed11)){ p11 = "Failed";  }else if ((percetage11 <=passed11 )&&(percetage11  >= pass11 )   ){p11 = "Pass";  }  else if ((percetage11  <= avaerage11 )&&(percetage11  >= avaerage_end11 )){p11 = "Avaerage"; ; 
                   } else if ((percetage11 <=good11 )&&(percetage11 >= good_end11 ) ){ p11="Good";  }else if ((percetage11 <= very_good11 )&&(percetage11 >= very_good_end11 )){ p11 = "Very Good";    }else if ((percetage11 <= Excellent11 )&&(percetage11  >= very_good11 )   ){ p11 = "Excellent";   }  
            
             pps7.setDouble(105, percetage11);                                           // Percentage  
             pps7.setDate(106, sqldate);
             pps7.setString(107 , class_teacher_class);
             pps7.setString(108, Term);
              pps7.setString(109 , p11);//inserting cmements by students marks
             pps7.setString( 110, System_ID.getText().trim());
             
            
        
        
             
             
                pps7.setString(111 , Sn12.getText().trim());                  //student name
             pps7.setString(112 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(113 , R12.getText().trim());                   // marks_obtained 
             pps7.setString(114 , total_marks.getText().trim());                     // total_marks_  
            
                   double converted_marks_obtained12 = Double.parseDouble(R12.getText().trim());  double converted_total_marks12 = Double.parseDouble(total_marks.getText().trim());
                    int percetage12 =(int)(converted_marks_obtained12  / converted_total_marks12  * 100) ;
                  if ((percetage12  <= failed12 )&&(percetage12  >= totallyfailed12)){ p12  = "Failed";  }else if ((percetage12 <=passed12 )&&(percetage12  >= pass12 )   ){ p12 = "Pass";  }  else if ((percetage12  <= avaerage12 )&&(percetage12  >= avaerage_end12 )){ p12 = "Avaerage"; ; 
                   } else if ((percetage12  <=good12 )&&(percetage12  >= good_end12 ) ){ p12 ="Good";  }else if ((percetage12 <= very_good12 )&&(percetage12 >= very_good_end12 )){ p12 = "Very Good";    }else if ((percetage12 <= Excellent12 )&&(percetage12  >= very_good12 )   ){ p12 = "Excellent";   }  
            
             pps7.setDouble(115, percetage12 );                                           // Percentage  
             pps7.setDate(116, sqldate);
             pps7.setString(117 , class_teacher_class);
             pps7.setString(118, Term);
               pps7.setString(119 , p12 );//inserting cmements by students marks
             pps7.setString( 120, System_ID.getText().trim());  
             
             
             
                pps7.setString(121 , Sn13.getText().trim());                  //student name
             pps7.setString(122 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(123 , R13.getText().trim());                   // marks_obtained 
             pps7.setString(124 , total_marks.getText().trim());                     // total_marks_  
            
                   double converted_marks_obtained13 = Double.parseDouble(R13.getText().trim());  double converted_total_marks13 = Double.parseDouble(total_marks.getText().trim());
                    int percetage13  =(int)(converted_marks_obtained13 / converted_total_marks13 * 100) ;
                  if ((percetage13 <= failed13 )&&(percetage13 >= totallyfailed13)){ p13 = "Failed";  }else if ((percetage13 <=passed13 )&&(percetage13  >= pass13 )   ){p13 = "Pass";  }  else if ((percetage13  <= avaerage13 )&&(percetage13  >= avaerage_end13 )){p13 = "Avaerage"; ; 
                   } else if ((percetage13 <=good13 )&&(percetage13 >= good_end13 ) ){ p13="Good";  }else if ((percetage13 <= very_good13 )&&(percetage13 >= very_good_end13 )){ p13 = "Very Good";    }else if ((percetage13 <= Excellent13 )&&(percetage13  >= very_good13 )   ){ p13 = "Excellent";   }  
            
             pps7.setDouble(125, percetage13);                                           // Percentage  
             pps7.setDate(126, sqldate);
             pps7.setString(127 , class_teacher_class);
             pps7.setString(128, Term);
              pps7.setString(129 , p13);//inserting cmements by students marks
             pps7.setString(130, System_ID.getText().trim());
             
             
             
                pps7.setString(131 , Sn14.getText().trim());                  //student name
             pps7.setString(132 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(133 , R14.getText().trim());                   // marks_obtained 
             pps7.setString(134 , total_marks.getText().trim());                     // total_marks_  
            
                   double converted_marks_obtained14 = Double.parseDouble(R14.getText().trim());  double converted_total_marks14 = Double.parseDouble(total_marks.getText().trim());
                    int percetage14 =(int)(converted_marks_obtained14  / converted_total_marks14  * 100) ;
                  if ((percetage14  <= failed14 )&&(percetage14  >= totallyfailed14)){ p14  = "Failed";  }else if ((percetage14 <=passed14 )&&(percetage14  >= pass14 )   ){ p14 = "Pass";  }  else if ((percetage14  <= avaerage14 )&&(percetage14  >= avaerage_end14 )){ p14 = "Avaerage"; ; 
                   } else if ((percetage14  <=good14 )&&(percetage14  >= good_end14 ) ){ p14 ="Good";  }else if ((percetage14 <= very_good14 )&&(percetage14 >= very_good_end14 )){ p14 = "Very Good";    }else if ((percetage14 <= Excellent14 )&&(percetage14  >= very_good14 )   ){ p14 = "Excellent";   }  
            
             pps7.setDouble(135, percetage14 );                                           // Percentage  
             pps7.setDate(136, sqldate);
             pps7.setString(137 , class_teacher_class);
             pps7.setString(138, Term);
              pps7.setString(139 , p14 );//inserting cmements by students marks
             pps7.setString( 140, System_ID.getText().trim()); 
             
             
             
             
                pps7.setString(141 , Sn15.getText().trim());                  //student name
             pps7.setString(142 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(143 , R15.getText().trim());                   // marks_obtained 
             pps7.setString(144 , total_marks.getText().trim());                     // total_marks_  
            
                   double converted_marks_obtained15 = Double.parseDouble(R15.getText().trim());  double converted_total_marks15 = Double.parseDouble(total_marks.getText().trim());
                    int percetage15  =(int)(converted_marks_obtained15 / converted_total_marks15 * 100) ;
                  if ((percetage15 <= failed15 )&&(percetage15 >= totallyfailed15)){ p15 = "Failed";  }else if ((percetage15 <=passed15 )&&(percetage15  >= pass15 )   ){p15 = "Pass";  }  else if ((percetage15  <= avaerage15 )&&(percetage15  >= avaerage_end15 )){p15 = "Avaerage"; ; 
                   } else if ((percetage15 <=good15 )&&(percetage15 >= good_end15 ) ){ p15="Good";  }else if ((percetage15 <= very_good15 )&&(percetage15 >= very_good_end15 )){ p15 = "Very Good";    }else if ((percetage15 <= Excellent15 )&&(percetage15  >= very_good15 )   ){ p15= "Excellent";   }  
            
             pps7.setDouble(145, percetage15);                                           // Percentage  
             pps7.setDate(146, sqldate);
             pps7.setString(147 , class_teacher_class);
             pps7.setString(148, Term);
              pps7.setString(149 , p15);//inserting cmements by students marks
             pps7.setString( 150, System_ID.getText().trim());
             
           
             
           
                pps7.setString(151 , Sn16.getText().trim());                  //student name
             pps7.setString(152 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(153 , R16.getText().trim());                   // marks_obtained 
             pps7.setString(154 , total_marks.getText().trim());                     // total_marks_  
            
                   double converted_marks_obtained16 = Double.parseDouble(R16.getText().trim());  double converted_total_marks16 = Double.parseDouble(total_marks.getText().trim());
                    int percetage16 =(int)(converted_marks_obtained16  / converted_total_marks16  * 100) ;
                  if ((percetage16  <= failed16 )&&(percetage16 >= totallyfailed16)){ p16  = "Failed";  }else if ((percetage16 <=passed16 )&&(percetage16  >= pass16 )   ){ p16 = "Pass";  }  else if ((percetage16  <= avaerage16 )&&(percetage16  >= avaerage_end16 )){ p16 = "Avaerage"; ; 
                   } else if ((percetage16  <=good16 )&&(percetage16  >= good_end16 ) ){ p16 ="Good";  }else if ((percetage16 <= very_good16 )&&(percetage16 >= very_good_end16 )){ p16 = "Very Good";    }else if ((percetage16 <= Excellent16 )&&(percetage16  >= very_good16 )   ){ p16 = "Excellent";   }  
            
             pps7.setDouble(155, percetage16 );                                           // Percentage  
             pps7.setDate(156, sqldate);
             pps7.setString(157 , class_teacher_class);
             pps7.setString(158, Term);
              pps7.setString(159 , p16 );//inserting cmements by students marks
             pps7.setString( 160, System_ID.getText().trim()); 
     
             
             
        

             
                pps7.setString(161 , Sn17.getText().trim());                  //student name
             pps7.setString(162 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(163 , R17.getText().trim());                   // marks_obtained 
             pps7.setString(164 , total_marks.getText().trim());                     // total_marks_  
            
                   double converted_marks_obtained17 = Double.parseDouble(R17.getText().trim());  double converted_total_marks17= Double.parseDouble(total_marks.getText().trim());
                    int percetage17  =(int)(converted_marks_obtained17 / converted_total_marks17 * 100) ;
                  if ((percetage17 <= failed17 )&&(percetage17 >= totallyfailed17)){ p17 = "Failed";  }else if ((percetage17 <=passed17 )&&(percetage17  >= pass17 )   ){p17 = "Pass";  }  else if ((percetage17  <= avaerage17 )&&(percetage17  >= avaerage_end17 )){p17 = "Avaerage"; ; 
                   } else if ((percetage17 <=good17 )&&(percetage17 >= good_end17 ) ){ p17="Good";  }else if ((percetage17 <= very_good17 )&&(percetage17 >= very_good_end17 )){ p17 = "Very Good";    }else if ((percetage17 <= Excellent17 )&&(percetage17  >= very_good17  )   ){ p17 = "Excellent";   }  
            
             pps7.setDouble(165, percetage17);                                           // Percentage  
             pps7.setDate(166, sqldate);
             pps7.setString(167 , class_teacher_class);
             pps7.setString(168, Term);
              pps7.setString(169 , p17);//inserting cmements by students marks
              pps7.setString(170, System_ID.getText().trim());
             
             
             
                pps7.setString(171 , Sn18.getText().trim());                  //student name
             pps7.setString(172 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(173 , R18.getText().trim());                   // marks_obtained 
             pps7.setString(174 , total_marks.getText().trim());                     // total_marks_  
            
                   double converted_marks_obtained18 = Double.parseDouble(R18.getText().trim());  double converted_total_marks18 = Double.parseDouble(total_marks.getText().trim());
                    int percetage18=(int)(converted_marks_obtained18  / converted_total_marks18  * 100) ;
                  if ((percetage18  <= failed18 )&&(percetage18  >= totallyfailed18)){ p18  = "Failed";  }else if ((percetage18 <=passed18 )&&(percetage18  >= pass18 )   ){ p18 = "Pass";  }  else if ((percetage18  <= avaerage18 )&&(percetage18  >= avaerage_end18 )){ p18 = "Avaerage"; ; 
                   } else if ((percetage18 <=good18 )&&(percetage18  >= good_end18 ) ){ p18 ="Good";  }else if ((percetage18 <= very_good18 )&&(percetage18 >= very_good_end18 )){ p18 = "Very Good";    }else if ((percetage18 <= Excellent18 )&&(percetage18  >= very_good18 )   ){ p18 = "Excellent";   }  
            
             pps7.setDouble(175, percetage18 );                                           // Percentage  
             pps7.setDate(176, sqldate);
             pps7.setString(177 , class_teacher_class);
             pps7.setString(178, Term);
              pps7.setString(179 , p18 );//inserting cmements by students marks
             pps7.setString( 180, System_ID.getText().trim()); 
             
             
             
             
                pps7.setString(181 , Sn19.getText().trim());                  //student name
             pps7.setString(182 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(183 , R19.getText().trim());                   // marks_obtained 
             pps7.setString(184 , total_marks.getText().trim());                     // total_marks_  
            
                   double converted_marks_obtained19 = Double.parseDouble(R19.getText().trim());  double converted_total_marks19 = Double.parseDouble(total_marks.getText().trim());
                    int percetage19  =(int)(converted_marks_obtained19 / converted_total_marks19 * 100) ;
                  if ((percetage19 <= failed19 )&&(percetage19 >= totallyfailed19)){ p19 = "Failed";  }else if ((percetage19 <=passed19 )&&(percetage19  >= pass19 )   ){p19 = "Pass";  }  else if ((percetage19  <= avaerage19 )&&(percetage19  >= avaerage_end19 )){p19 = "Avaerage"; ; 
                   } else if ((percetage19 <=good19 )&&(percetage19 >= good_end19 ) ){ p19="Good";  }else if ((percetage19 <= very_good19 )&&(percetage19 >= very_good_end19 )){ p19 = "Very Good";    }else if ((percetage19 <= Excellent19 )&&(percetage19  >= very_good19 )   ){ p19= "Excellent";   }  
            
             pps7.setDouble(185, percetage19);                                           // Percentage  
             pps7.setDate(186, sqldate);
             pps7.setString(187 , class_teacher_class);
             pps7.setString(188, Term);
              pps7.setString(189 , p19);//inserting cmements by students marks
             pps7.setString( 190, System_ID.getText().trim());
             
             
             
                pps7.setString(191 , Sn20.getText().trim());                  //student name
             pps7.setString(192 , showsubjects.getSelectedItem().toString().trim()); //subjects
             pps7.setString(193 , R20.getText().trim());                   // marks_obtained 
             pps7.setString(194 , total_marks.getText().trim());                     // total_marks_  
            
                   double converted_marks_obtained20 = Double.parseDouble(R20.getText().trim());  double converted_total_marks20= Double.parseDouble(total_marks.getText().trim());
                    int percetage20=(int)(converted_marks_obtained20  / converted_total_marks20  * 100) ;
                  if ((percetage20  <= failed20 )&&(percetage20 >= totallyfailed20)){ p20  = "Failed";  }else if ((percetage20 <=passed20 )&&(percetage20  >= pass20 )   ){ p20 = "Pass";  }  else if ((percetage20  <= avaerage20 )&&(percetage20  >= avaerage_end20 )){ p20 = "Avaerage"; ; 
                   } else if ((percetage20  <=good20 )&&(percetage20  >= good_end20 ) ){ p20 ="Good";  }else if ((percetage20 <= very_good20 )&&(percetage20 >= very_good_end20 )){ p20 = "Very Good";    }else if ((percetage20 <= Excellent20 )&&(percetage20  >= very_good20 )   ){ p20 = "Excellent";   }  
            
             pps7.setDouble(195, percetage20 );                                           // Percentage  
             pps7.setDate(196, sqldate);
             pps7.setString(197 , class_teacher_class);
             pps7.setString(198, Term);
              pps7.setString(199 , p20 );//inserting cmements by students marks
             pps7.setString( 200, System_ID.getText().trim()); 
             
             
             

 pps7.setString(201 ,Sn21.getText().trim());//student name
 pps7.setString(202 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString(203 ,R21.getText().trim());// marks_obtained 
pps7.setString(204 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained21 = Double.parseDouble(R21.getText().trim()); double converted_total_marks21= Double.parseDouble(total_marks.getText().trim());
int percetage21=(int)(converted_marks_obtained21  / converted_total_marks21  * 100) ; 

if ((percetage21  <= failed21 )&&(percetage21 >= totallyfailed21)){ 
  p21  = "Failed";  
}else if ((percetage21 <=passed21 )&&(percetage21  >= pass21 )   ){ 
  p21 = "Pass"; 
}  else if ((percetage21  <= avaerage21 )&&(percetage21  >= avaerage_end21 )){ p21 = "Avaerage"; 
} else if ((percetage21  <=good21 )&&(percetage21  >= good_end21 ) )
{ 
p21 ="Good"; 
 }else if ((percetage21 <= very_good21 )&&(percetage21 >= very_good_end21 ))
 {
 
p21 = "Very Good";    
   }else if ((percetage21 <= Excellent21 )&&(percetage21  >= very_good21 )   )
 {
 
p21 = "Excellent";  
  }  
            
pps7.setDouble(205, percetage21 );                                            
pps7.setDate(206, sqldate);
pps7.setString(207 , class_teacher_class);
pps7.setString(208, Term);
pps7.setString(209 , p21 );//inserting cmements by stude
pps7.setString( 210, System_ID.getText().trim()); 






pps7.setString(211 ,Sn22.getText().trim());//student name
 pps7.setString(212 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString(213 ,R22.getText().trim());// marks_obtained 
pps7.setString(214 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained22 = Double.parseDouble(R22.getText().trim()); 

double converted_total_marks22= Double.parseDouble(total_marks.getText().trim());

int percetage22=(int)(converted_marks_obtained22  / converted_total_marks22  * 100) ;

if ((percetage22  <= failed22 )&&(percetage22 >= totallyfailed22)){ 
  p22  = "Failed";  
}else if ((percetage22 <=passed22 )&&(percetage22  >= pass22 )   ){ 
  p22 = "Pass"; 
}  else if ((percetage22  <= avaerage22 )&&(percetage22  >= avaerage_end22 ))
{ 
p22 = "Avaerage"; 
} 
else if ((percetage22  <=good22 )&&(percetage22  >= good_end22 ) )
{ 
p22 ="Good"; 
 }else if ((percetage22 <= very_good22 )&&(percetage22 >= very_good_end22 ))
 {
  p22 = "Very Good";    
 }else if ((percetage22 <= Excellent22 )&&(percetage22  >= very_good22 )   )
 {
  p22 = "Excellent";  
 
  }  
            
pps7.setDouble(215, percetage22 );                                            
pps7.setDate(216, sqldate);
pps7.setString(217 , class_teacher_class);
pps7.setString(218, Term);
pps7.setString(219 , p22 );//inserting cmements by stude
pps7.setString( 220, System_ID.getText().trim()); 



pps7.setString(221 ,Sn23.getText().trim());//student name
 pps7.setString(222 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString(223 ,R23.getText().trim());// marks_obtained 
pps7.setString(224 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained23 = Double.parseDouble(R23.getText().trim()); 

double converted_total_marks23= Double.parseDouble(total_marks.getText().trim());

int percetage23=(int)(converted_marks_obtained23  / converted_total_marks23  * 100) ;

if ((percetage23  <= failed23 )&&(percetage23 >= totallyfailed23)){ 
  p23  = "Failed";  
}else if ((percetage23 <=passed23 )&&(percetage23  >= pass23 )   ){ 
  p23 = "Pass"; 
}  else if ((percetage23  <= avaerage23 )&&(percetage23  >= avaerage_end23 ))
{ 
p23 = "Avaerage"; 
} 
else if ((percetage23  <=good23 )&&(percetage23  >= good_end23 ) )
{ 
p23 ="Good"; 
 }else if ((percetage23 <= very_good23 )&&(percetage23 >= very_good_end23 ))
 {
  p23 = "Very Good";    
 }else if ((percetage23 <= Excellent23 )&&(percetage23  >= very_good23 )   )
 {
  p23 = "Excellent";  
 
  }  
            
pps7.setDouble(225, percetage23 );                                            
pps7.setDate(226, sqldate);
pps7.setString(227 , class_teacher_class);
pps7.setString(228, Term);
pps7.setString(229 , p23 );//inserting cmements by stude
pps7.setString( 230, System_ID.getText().trim()); 

             
             
 
pps7.setString(231 ,Sn24.getText().trim());//student name
 pps7.setString(232 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString(233 ,R24.getText().trim());// marks_obtained 
pps7.setString(234 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained24 = Double.parseDouble(R24.getText().trim()); 

double converted_total_marks24= Double.parseDouble(total_marks.getText().trim());

int percetage24 =(int)(converted_marks_obtained24  / converted_total_marks24  * 100) ;

if ((percetage24  <= failed24 )&&(percetage24 >= totallyfailed24 )){ 
  p24  = "Failed";  
}else if ((percetage24 <=passed24 )&&(percetage24  >= pass24 )   ){ 
  p24 = "Pass"; 
}  else if ((percetage24  <= avaerage24)&&(percetage24  >= avaerage_end24 ))
{ 
p24 = "Avaerage"; 
} 
else if ((percetage24  <=good24 )&&(percetage24  >= good_end24) )
{ 
p24 ="Good"; 
 }else if ((percetage24 <= very_good24 )&&(percetage24 >= very_good_end24 ))
 {
  p24 = "Very Good";    
 }else if ((percetage24 <= Excellent24 )&&(percetage24  >= very_good24 )   )
 {
  p24 = "Excellent";  
 
  }  
            
pps7.setDouble(235, percetage24 );                                            
pps7.setDate(236, sqldate);
pps7.setString(237 , class_teacher_class);
pps7.setString(238, Term);
pps7.setString(239 , p24 );//inserting cmements by stude
pps7.setString( 240, System_ID.getText().trim());





pps7.setString( 241 ,Sn25 .getText().trim());//student name
 pps7.setString(  242 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 243 ,R25 .getText().trim());// marks_obtained 
pps7.setString( 244 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained25 = Double.parseDouble(R25.getText().trim()); 

double converted_total_marks25 = Double.parseDouble(total_marks.getText().trim());

int percetage25 =(int)(converted_marks_obtained25  / converted_total_marks25  * 100) ;

if ((percetage25  <= failed25 )&&(percetage25 >= totallyfailed25)){ 
  p25  = "Failed";  
}else if ((percetage25 <=passed25 )&&(percetage25  >= pass25 )   ){ 
  p25 = "Pass"; 
}  else if ((percetage25  <= avaerage25 )&&(percetage25  >= avaerage_end25 ))
{ 
p25 = "Avaerage"; 
} 
else if ((percetage25  <=good25 )&&(percetage25  >= good_end25 ) )
{ 
p25 ="Good"; 
 }else if ((percetage25 <= very_good25 )&&(percetage25 >= very_good_end25 ))
 {
  p25  = "Very Good";    
 }else if ((percetage25 <= Excellent25 )&&(percetage25  >= very_good25)   )
 {
  p25 = "Excellent";  
 
  }  
            
pps7.setDouble( 245, percetage25 );                                            
pps7.setDate(  246 , sqldate);
pps7.setString(  247 , class_teacher_class);
pps7.setString(  248, Term);
pps7.setString(  249 , p25 );//inserting cmements by stude
pps7.setString( 250, System_ID.getText().trim());


  

pps7.setString( 251 ,Sn26 .getText().trim());//student name
 pps7.setString(  252 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 253 ,R26 .getText().trim());// marks_obtained 
pps7.setString( 254 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained26 = Double.parseDouble(R26.getText().trim()); 

double converted_total_marks26 = Double.parseDouble(total_marks.getText().trim());

int percetage26 =(int)(converted_marks_obtained26  / converted_total_marks26  * 100) ;

if ((percetage26  <= failed26)&&(percetage26 >= totallyfailed26)){ 
  p26  = "Failed";  
}else if ((percetage26 <=passed26 )&&(percetage26  >= pass26 )   ){ 
  p26 = "Pass"; 
}  else if ((percetage26  <= avaerage26 )&&(percetage26  >= avaerage_end26 ))
{ 
p26 = "Avaerage"; 
} 
else if ((percetage26  <=good26 )&&(percetage26  >= good_end26 ) )
{ 
p26 ="Good"; 
 }else if ((percetage26 <= very_good26 )&&(percetage26 >= very_good_end26 ))
 {
  p26  = "Very Good";    
 }else if ((percetage26 <= Excellent26 )&&(percetage26  >= very_good26 )   )
 {
  p26 = "Excellent";  
 
  }  
            
pps7.setDouble( 255, percetage26 );                                            
pps7.setDate(  256 , sqldate);
pps7.setString(  257 , class_teacher_class);
pps7.setString(  258, Term);
pps7.setString(  259 , p26 );//inserting cmements by stude
pps7.setString( 260, System_ID.getText().trim());





pps7.setString( 261 ,Sn27 .getText().trim());//student name
 pps7.setString(  262 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 263 ,R27 .getText().trim());// marks_obtained 
pps7.setString( 264 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained27 = Double.parseDouble(R27.getText().trim()); 

double converted_total_marks27 = Double.parseDouble(total_marks.getText().trim());

int percetage27 =(int)(converted_marks_obtained27  / converted_total_marks27  * 100) ;

if ((percetage27  <= failed27 )&&(percetage27 >= totallyfailed27)){ 
  p27  = "Failed";  
}else if ((percetage27 <=passed27 )&&(percetage27  >= pass27 )   ){ 
  p27 = "Pass"; 
}  else if ((percetage27  <= avaerage27 )&&(percetage27  >= avaerage_end27 ))
{ 
 p27 = "Avaerage"; 
} 
else if ((percetage27  <=good27 )&&(percetage27  >= good_end27 ) )
{ 
 p27 ="Good"; 
 }else if ((percetage27 <= very_good27 )&&(percetage27 >= very_good_end27 ))
 {
  p27  = "Very Good";    
 }else if ((percetage27 <= Excellent27 )&&(percetage27  >= very_good27 )   )
 {
  p27 = "Excellent";  
 
  }  
            
pps7.setDouble( 265, percetage27 );                                            
pps7.setDate(  266 , sqldate);
pps7.setString(  267 , class_teacher_class);
pps7.setString(  268, Term);
pps7.setString(  269 , p27 );//inserting cmements by stude
pps7.setString( 270, System_ID.getText().trim());







pps7.setString( 271 ,Sn28 .getText().trim());//student name
 pps7.setString(  272 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 273 ,R28 .getText().trim());// marks_obtained 
pps7.setString( 274 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained28 = Double.parseDouble(R28.getText().trim()); 

double converted_total_marks28 = Double.parseDouble(total_marks.getText().trim());

int percetage28 =(int)(converted_marks_obtained28  / converted_total_marks28  * 100) ;

if ((percetage28  <= failed28 )&&(percetage28 >= totallyfailed28)){ 
  p28  = "Failed";  
}else if ((percetage28 <=passed28 )&&(percetage28  >= pass28 )   ){ 
  p28 = "Pass"; 
}  else if ((percetage28  <= avaerage28 )&&(percetage28  >= avaerage_end28 ))
{ 
 p28 = "Avaerage"; 
} 
else if ((percetage28  <=good28 )&&(percetage28  >= good_end28 ) )
{ 
 p28 ="Good"; 
 }else if ((percetage28 <= very_good28 )&&(percetage28 >= very_good_end28 ))
 {
  p28  = "Very Good";    
 }else if ((percetage28 <= Excellent28 )&&(percetage28  >= very_good28 )   )
 {
  p28 = "Excellent";  
 
  }  
            
pps7.setDouble( 275, percetage28 );                                            
pps7.setDate(  276 , sqldate);
pps7.setString(  277 , class_teacher_class);
pps7.setString(  278, Term);
pps7.setString(  279 , p28 );//inserting cmements by stude
pps7.setString( 280, System_ID.getText().trim());


pps7.setString( 281 ,Sn29 .getText().trim());//student name
 pps7.setString(  282 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 283 ,R29 .getText().trim());// marks_obtained 
pps7.setString( 284 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained29 = Double.parseDouble(R29.getText().trim()); 

double converted_total_marks29 = Double.parseDouble(total_marks.getText().trim());

int percetage29 =(int)(converted_marks_obtained29  / converted_total_marks29  * 100) ;

if ((percetage29  <= failed29 )&&(percetage29 >= totallyfailed29)){ 
  p29  = "Failed";  
}else if ((percetage29 <=passed29 )&&(percetage29  >= pass29 )   ){ 
  p29 = "Pass"; 
}  else if ((percetage29  <= avaerage29 )&&(percetage29  >= avaerage_end29 ))
{ 
 p29 = "Avaerage"; 
} 
else if ((percetage29  <=good29 )&&(percetage29  >= good_end29 ) )
{ 
 p29 ="Good"; 
 }else if ((percetage29 <= very_good29 )&&(percetage29 >= very_good_end29 ))
 {
  p29  = "Very Good";    
 }else if ((percetage29 <= Excellent29 )&&(percetage29  >= very_good29 )   )
 {
  p29 = "Excellent";  
 
  }  
            
pps7.setDouble( 285, percetage29 );                                            
pps7.setDate(  286 , sqldate);
pps7.setString(  287 , class_teacher_class);
pps7.setString(  288, Term);
pps7.setString(  289 , p29 );//inserting cmements by stude
pps7.setString( 290, System_ID.getText().trim());




pps7.setString( 291 ,Sn30 .getText().trim());//student name
 pps7.setString(292 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 293 ,R30 .getText().trim());// marks_obtained 
pps7.setString( 294 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained30 = Double.parseDouble(R30.getText().trim()); 

double converted_total_marks30 = Double.parseDouble(total_marks.getText().trim());

int percetage30 =(int)(converted_marks_obtained30  / converted_total_marks30  * 100) ;

if ((percetage30  <= failed30 )&&(percetage30 >= totallyfailed30)){ 
  p30  = "Failed";  
}else if ((percetage30 <=passed30 )&&(percetage30  >= pass30 )   ){ 
  p30 = "Pass"; 
}  else if ((percetage30  <= avaerage30 )&&(percetage30  >= avaerage_end30 ))
{ 
 p30 = "Avaerage"; 
} 
else if ((percetage30  <=good30 )&&(percetage30  >= good_end30 ) )
{ 
 p30 ="Good"; 
 }else if ((percetage30 <= very_good30)&&(percetage30 >= very_good_end30 ))
 {
  p30  = "Very Good";    
 }else if ((percetage30 <= Excellent30 )&&(percetage30  >= very_good30 )   )
 {
  p30 = "Excellent";  
 
  }  
            
pps7.setDouble( 295, percetage30 );                                            
pps7.setDate(  296 , sqldate);
pps7.setString(  297 , class_teacher_class);
pps7.setString(  298, Term);
pps7.setString(  299 , p30 );//inserting cmements by stude
pps7.setString( 300, System_ID.getText().trim());









pps7.setString( 301 ,Sn31 .getText().trim());//student name
 pps7.setString(  302 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 303 ,R31 .getText().trim());// marks_obtained 
pps7.setString( 304 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained31 = Double.parseDouble(R31.getText().trim()); 

double converted_total_marks31 = Double.parseDouble(total_marks.getText().trim());

int percetage31 =(int)(converted_marks_obtained31  / converted_total_marks31  * 100) ;

if (( percetage31  <= failed31 )&&( percetage31 >= totallyfailed31)){ 
  p31  = "Failed";  
}else if (( percetage31 <=passed31 )&&( percetage31 >= pass31 )   ){ 
  p31 = "Pass";  
}  else if (( percetage31  <= avaerage31 )&&(  percetage31  >= avaerage_end31 ))
{ 
 p31 = "Avaerage"; 
} 
else if ((  percetage31  <=good31 )&&(  percetage31  >= good_end31 ) )
{ 
 p31 ="Good"; 
 }else if ((  percetage31 <= very_good31 )&&(percetage31 >= very_good_end31 ))
 {
  p31  = "Very Good";    
 }else if (( percetage31 <= Excellent31 )&&( percetage31  >= very_good31 )   )
 {
  p31 = "Excellent";  
 
  }  
            
pps7.setDouble( 305,  percetage31 );                                            
pps7.setDate(  306 , sqldate);
pps7.setString(  307 , class_teacher_class);
pps7.setString(  308, Term);
pps7.setString(  309 , p31 );//inserting cmements by stude
pps7.setString( 310, System_ID.getText().trim());



















pps7.setString( 311 ,Sn32 .getText().trim());//student name
 pps7.setString(  312 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 313 ,R32 .getText().trim());// marks_obtained 
pps7.setString( 314 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained32 = Double.parseDouble(R32.getText().trim()); 

double converted_total_marks32 = Double.parseDouble(total_marks.getText().trim());

int percetage32 =(int)(converted_marks_obtained32  / converted_total_marks32  * 100) ;

if (( percetage32  <= failed32 )&&( percetage32 >= totallyfailed32)){ 
  p32  = "Failed";  
}else if (( percetage32 <=passed32 )&&( percetage32 >= pass32 )   ){ 
  p32 = "Pass";  
}  else if (( percetage32  <= avaerage32 )&&(  percetage32  >= avaerage_end32 ))
{ 
 p32 = "Avaerage"; 
} 
else if (( percetage32  <=good32 )&&(  percetage32  >= good_end32 ) )
{ 
 p32 ="Good"; 
 }else if ((  percetage32 <= very_good32 )&&(percetage32 >= very_good_end32 ))
 {
  p32  = "Very Good";    
 }else if (( percetage32 <= Excellent32 )&&( percetage32  >= very_good32 )   )
 {
  p32 = "Excellent";  
 
  }  
            
pps7.setDouble( 315,  percetage32 );                                            
pps7.setDate(  316 , sqldate);
pps7.setString(  317 , class_teacher_class);
pps7.setString(  318, Term);
pps7.setString(  319 , p32 );//inserting cmements by stude
pps7.setString( 320, System_ID.getText().trim());










pps7.setString( 321 ,Sn33 .getText().trim());//student name
 pps7.setString(  322 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 323 ,R33 .getText().trim());// marks_obtained 
pps7.setString( 324 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained33 = Double.parseDouble(R33.getText().trim()); 

double converted_total_marks33 = Double.parseDouble(total_marks.getText().trim());

int percetage33 =(int)(converted_marks_obtained33  / converted_total_marks33  * 100) ;

if (( percetage33  <= failed33 )&&( percetage33 >= totallyfailed33)){ 
  p33  = "Failed";  
}else if (( percetage33 <=passed33 )&&( percetage33 >= pass33 )   ){ 
  p33 = "Pass";  
}  else if (( percetage33  <= avaerage33 )&&(  percetage33  >= avaerage_end33 ))
{ 
 p33 = "Avaerage"; 
} 
else if (( percetage33  <=good33 )&&( percetage33  >= good_end33 ) )
{ 
 p33 ="Good"; 
 }else if ((  percetage33 <= very_good33 )&&( percetage33 >= very_good_end33 ))
 {
  p33  = "Very Good";    
 }else if (( percetage33 <= Excellent33 )&&( percetage33  >= very_good33 )   )
 {
  p33 = "Excellent";  
 
  }  
            
pps7.setDouble( 325, percetage33 );                                            
pps7.setDate(  326 , sqldate);
pps7.setString(  327 , class_teacher_class);
pps7.setString(  328, Term);
pps7.setString(  329 , p33 );//inserting cmements by stude
pps7.setString( 330, System_ID.getText().trim());



pps7.setString( 331 ,Sn34 .getText().trim());//student name
 pps7.setString(  332 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 333 ,R34 .getText().trim());// marks_obtained 
pps7.setString( 334 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained34 = Double.parseDouble(R34.getText().trim()); 

double converted_total_marks34 = Double.parseDouble(total_marks.getText().trim());

int percetage34 =(int)(converted_marks_obtained34  / converted_total_marks34  * 100) ;

if (( percetage34  <= failed34 )&&( percetage34 >= totallyfailed34)){ 
  p34  = "Failed";  
}else if (( percetage34 <=passed34 )&&( percetage34 >= pass34 )   ){ 
  p34 = "Pass";  
}  else if (( percetage34  <= avaerage34 )&&(  percetage34  >= avaerage_end34 ))
{ 
 p34 = "Avaerage"; 
} 
else if ((  percetage34  <=good34 )&&(  percetage34  >= good_end34 ) )
{ 
 p34 ="Good"; 
 }else if ((  percetage34 <= very_good34 )&&( percetage34 >= very_good_end34 ))
 {
  p34  = "Very Good";    
 }else if (( percetage34 <= Excellent34 )&&( percetage34  >= very_good34 )   )
 {
  p34 = "Excellent";  
 
  }  
            
pps7.setDouble( 335,  percetage34 );                                            
pps7.setDate(  336 , sqldate);
pps7.setString(  337 , class_teacher_class);
pps7.setString(  338, Term);
pps7.setString(  339 , p34 );//inserting cmements by stude
pps7.setString( 340, System_ID.getText().trim());








pps7.setString( 341 ,Sn35 .getText().trim());//student name
 pps7.setString(  342 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 343 ,R35 .getText().trim());// marks_obtained 
pps7.setString( 344 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained35 = Double.parseDouble(R35.getText().trim()); 

double converted_total_marks35 = Double.parseDouble(total_marks.getText().trim());

int percetage35 =(int)(converted_marks_obtained35  / converted_total_marks35  * 100) ;

if (( percetage35  <= failed35 )&&( percetage35 >= totallyfailed35)){ 
  p35  = "Failed";  
}else if (( percetage35 <=passed35 )&&( percetage35 >= pass35 )   ){ 
  p35 = "Pass";  
}  else if (( percetage35  <= avaerage35 )&&(  percetage35  >= avaerage_end35 )){ 
 p35 = "Avaerage"; 
} 
else if (( percetage35  <=good35 )&&(  percetage35  >= good_end35 ) )
{ 
 p35 ="Good"; 
 }else if ((  percetage35 <= very_good35 )&&( percetage35 >= very_good_end35 ))
 {
  p35  = "Very Good";    
 }else if (( percetage35 <= Excellent35 )&&( percetage35  >= very_good35 )   )
 {
  p35 = "Excellent";  
 
  }  
            
pps7.setDouble( 345,  percetage35 );                                            
pps7.setDate(  346 , sqldate);
pps7.setString(  347 , class_teacher_class);
pps7.setString(  348, Term);
pps7.setString(  349 , p35 );//inserting cmements by stude
pps7.setString( 350, System_ID.getText().trim());



pps7.setString( 351 ,Sn36 .getText().trim());//student name
 pps7.setString(  352 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 353 ,R36 .getText().trim());// marks_obtained 
pps7.setString( 354 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained36 = Double.parseDouble(R36.getText().trim()); 

double converted_total_marks36 = Double.parseDouble(total_marks.getText().trim());

int percetage36 =(int)(converted_marks_obtained36  / converted_total_marks36  * 100) ;

if (( percetage36  <= failed36 )&&( percetage36 >= totallyfailed36)){ 
  p36  = "Failed";  
}else if (( percetage36 <=passed36 )&&( percetage36 >= pass36 )   ){ 
  p36 = "Pass";  
}  else if (( percetage36  <= avaerage36 )&&(  percetage36  >= avaerage_end36 ))
{ 
 p36 = "Avaerage"; 
} 
else if ((  percetage36  <=good36 )&&(  percetage36  >= good_end36 ) )
{ 
 p36 ="Good"; 
 }else if ((  percetage36 <= very_good36 )&&( percetage36 >= very_good_end36 ))
 {
  p36  = "Very Good";    
 }else if (( percetage36 <= Excellent36 )&&( percetage36  >= very_good36)   )
 {
  p36 = "Excellent";  
 
  }  
            
pps7.setDouble( 355,  percetage36 );                                            
pps7.setDate(  356 , sqldate);
pps7.setString(  357 , class_teacher_class);
pps7.setString(  358, Term);
pps7.setString(  359 , p36 );//inserting cmements by stude
pps7.setString( 360, System_ID.getText().trim());



pps7.setString( 361 ,Sn37 .getText().trim());//student name
 pps7.setString(  362 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 363 ,R37 .getText().trim());// marks_obtained 
pps7.setString( 364 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained37 = Double.parseDouble(R37.getText().trim()); 

double converted_total_marks37 = Double.parseDouble(total_marks.getText().trim());

int percetage37 =(int)(converted_marks_obtained37  / converted_total_marks37  * 100) ;

if (( percetage37  <= failed37 )&&( percetage37 >= totallyfailed37)){ 
  p37  = "Failed";  
}else if (( percetage37 <=passed37 )&&( percetage37 >= pass37 )   ){ 
  p37 = "Pass";  
}  else if (( percetage37  <= avaerage37 )&&(  percetage37  >= avaerage_end37 ))
{ 
 p37 = "Avaerage"; 
} 
else if ((  percetage37  <=good37 )&&(  percetage37  >= good_end37) )
{ 
 p37 ="Good"; 
 }else if ((  percetage37 <= very_good37 )&&( percetage37 >= very_good_end37 ))
 {
  p37  = "Very Good";    
 }else if (( percetage37 <= Excellent37 )&&( percetage37  >= very_good37 )   )
 {
  p37 = "Excellent";  
 
  }  
            
pps7.setDouble( 365,  percetage37 );                                            
pps7.setDate(  366 , sqldate);
pps7.setString(  367 , class_teacher_class);
pps7.setString(  368, Term);
pps7.setString(  369 , p37 );//inserting cmements by stude
pps7.setString( 370, System_ID.getText().trim());






pps7.setString( 371 ,Sn38 .getText().trim());//student name
 pps7.setString(  372 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 373 ,R38 .getText().trim());// marks_obtained 
pps7.setString( 374 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained38 = Double.parseDouble(R38.getText().trim()); 

double converted_total_marks38 = Double.parseDouble(total_marks.getText().trim());

int percetage38 =(int)(converted_marks_obtained38  / converted_total_marks38  * 100) ;

if (( percetage38  <= failed38 )&&( percetage38 >= totallyfailed38)){ 
  p38  = "Failed";  
}else if (( percetage38 <=passed38 )&&( percetage38 >= pass38 )   ){ 
  p38 = "Pass";  
}  else if (( percetage38  <= avaerage38 )&&(  percetage38  >= avaerage_end38 ))
{ 
 p38 = "Avaerage"; 
} 
else if ((  percetage38  <=good38 )&&(  percetage38  >= good_end38 ) )
{ 
 p38 ="Good"; 
 }else if (( percetage38 <= very_good38 )&&( percetage38 >= very_good_end38 ))
 {
  p38  = "Very Good";    
 }else if (( percetage38 <= Excellent38 )&&( percetage38  >= very_good38 )   )
 {
  p38 = "Excellent";  
 
  }  
            
pps7.setDouble( 375,  percetage38 );                                            
pps7.setDate(  376 , sqldate);
pps7.setString(  377 , class_teacher_class);
pps7.setString(  378, Term);
pps7.setString(  379 , p38 );//inserting cmements by stude
pps7.setString( 380, System_ID.getText().trim());









pps7.setString( 381 ,Sn39 .getText().trim());//student name
 pps7.setString(  382 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 383 ,R39 .getText().trim());// marks_obtained 
pps7.setString( 384 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained39 = Double.parseDouble(R39.getText().trim()); 

double converted_total_marks39 = Double.parseDouble(total_marks.getText().trim());

int percetage39 =(int)(converted_marks_obtained39  / converted_total_marks39  * 100) ;

if (( percetage39  <= failed39 )&&( percetage39 >= totallyfailed39)){ 
  p39  = "Failed";  
}else if (( percetage39 <=passed39 )&&( percetage39 >= pass39 )   ){ 
  p39 = "Pass";  
}  else if (( percetage39  <= avaerage39 )&&(  percetage39  >= avaerage_end39 ))
{ 
 p39 = "Avaerage"; 
} 
else if ((  percetage39  <=good39 )&&(  percetage39  >= good_end39 ) )
{ 
 p39 ="Good"; 
 }else if ((  percetage39 <= very_good39 )&&( percetage39 >= very_good_end39 ))
 {
  p39  = "Very Good";    
 }else if (( percetage39 <= Excellent39 )&&( percetage39  >= very_good39 )   )
 {
  p39 = "Excellent";  
 
  }  
            
pps7.setDouble( 385,  percetage39 );                                            
pps7.setDate(  386 , sqldate);
pps7.setString(  387 , class_teacher_class);
pps7.setString(  388, Term);
pps7.setString(  389 , p39 );//inserting cmements by stude
pps7.setString( 390, System_ID.getText().trim());

///,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,



   pps7.setString( 391 ,Sn40 .getText().trim());//student name
 pps7.setString(  392 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 393 ,R40 .getText().trim());// marks_obtained 
pps7.setString( 394 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained40 = Double.parseDouble(R40.getText().trim()); 

double converted_total_marks40 = Double.parseDouble(total_marks.getText().trim());

int percetage40 =(int)(converted_marks_obtained40  / converted_total_marks40  * 100) ;

if (( percetage40  <= failed40 )&&( percetage40 >= totallyfailed40)){ 
  p40  = "Failed";  
}else if (( percetage40 <=passed49 )&&( percetage40 >= pass40 )   ){ 
  p40 = "Pass";  
}  else if (( percetage40  <= avaerage40 )&&(  percetage40  >= avaerage_end40 ))
{ 
 p40 = "Avaerage"; 
} 
else if ((  percetage40  <=good40)&&(  percetage40  >= good_end40 ) )
{ 
 p40 ="Good"; 
 }else if ((  percetage40 <= very_good40 )&&( percetage40 >= very_good_end40 ))
 {
  p40  = "Very Good";    
 }else if (( percetage40 <= Excellent40 )&&( percetage40  >= very_good40 )   )
 {
  p40 = "Excellent";  
 
  }  
            
pps7.setDouble( 395,  percetage40 );                                            
pps7.setDate(  396 , sqldate);
pps7.setString(  397 , class_teacher_class);
pps7.setString(  398, Term);
pps7.setString(  399 , p40 );//inserting cmements by stude
pps7.setString( 400, System_ID.getText().trim());





pps7.setString( 401 ,Sn41 .getText().trim());//student name
 pps7.setString(  402 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 403 ,R41 .getText().trim());// marks_obtained 
pps7.setString( 404 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained41 = Double.parseDouble(R41.getText().trim()); 

double converted_total_marks41 = Double.parseDouble(total_marks.getText().trim());

int percetage41 =(int)(converted_marks_obtained41  / converted_total_marks41  * 100) ;

if (( percetage41  <= failed41 )&&( percetage41 >= totallyfailed41)){ 
  p41  = "Failed";  
}else if (( percetage41 <=passed41 )&&( percetage41 >= pass41 )   ){ 
  p41 = "Pass";  
}  else if (( percetage41  <= avaerage41 )&&(  percetage41  >= avaerage_end41 ))
{ 
 p41 = "Avaerage"; 
} 
else if ((  percetage41  <=good41 )&&(  percetage41  >= good_end41 ) )
{ 
 p41 ="Good"; 
 }else if ((  percetage41 <= very_good41 )&&( percetage41 >= very_good_end41 ))
 {
  p41  = "Very Good";    
 }else if (( percetage41 <= Excellent41 )&&( percetage41  >= very_good41 )   )
 {
  p41 = "Excellent";  
 
  }  
            
pps7.setDouble( 405,  percetage41 );                                            
pps7.setDate(  406 , sqldate);
pps7.setString(  407 , class_teacher_class);
pps7.setString(  408, Term);
pps7.setString(  409 , p41 );//inserting cmements by stude
pps7.setString( 410, System_ID.getText().trim());            
             
             
             
  
pps7.setString( 411 ,Sn42 .getText().trim());//student name
 pps7.setString(  412 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 413 ,R42 .getText().trim());// marks_obtained 
pps7.setString( 414 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained42 = Double.parseDouble(R39.getText().trim()); 

double converted_total_marks42 = Double.parseDouble(total_marks.getText().trim());

int percetage42 =(int)(converted_marks_obtained42  / converted_total_marks42  * 100) ;

if (( percetage42  <= failed42 )&&( percetage42 >= totallyfailed42)){ 
  p42  = "Failed";  
}else if (( percetage42 <=passed42 )&&( percetage42 >= pass42 )   ){ 
  p42 = "Pass";  
}  else if (( percetage42  <= avaerage42 )&&(  percetage42  >= avaerage_end42 ))
{ 
 p42 = "Avaerage"; 
} 
else if ((  percetage42  <=good42 )&&(  percetage42  >= good_end42 ) )
{ 
 p42 ="Good"; 
 }else if ((  percetage42 <= very_good42 )&&( percetage42 >= very_good_end42 ))
 {
  p42  = "Very Good";    
 }else if (( percetage42 <= Excellent42 )&&( percetage42  >= very_good42 )   )
 {
  p42 = "Excellent";  
 
  }  
            
pps7.setDouble( 415,  percetage42 );                                            
pps7.setDate(  416 , sqldate);
pps7.setString(  417 , class_teacher_class);
pps7.setString(  418, Term);
pps7.setString(  419 , p42 );//inserting cmements by stude
pps7.setString( 420, System_ID.getText().trim());






pps7.setString( 421 ,Sn43 .getText().trim());//student name
 pps7.setString(  422 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 423 ,R43 .getText().trim());// marks_obtained 
pps7.setString( 424 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained43 = Double.parseDouble(R43.getText().trim()); 

double converted_total_marks43 = Double.parseDouble(total_marks.getText().trim());

int percetage43 =(int)(converted_marks_obtained43  / converted_total_marks43  * 100) ;

if (( percetage43  <= failed43 )&&( percetage43 >= totallyfailed43)){ 
  p43  = "Failed";  
}else if (( percetage43 <=passed43 )&&( percetage43 >= pass43 )   ){ 
  p43 = "Pass";  
}  else if (( percetage43  <= avaerage43 )&&(  percetage43  >= avaerage_end43 ))
{ 
 p43 = "Avaerage"; 
} 
else if ((  percetage43  <=good43 )&&(  percetage43  >= good_end43 ) )
{ 
 p43 ="Good"; 
 }else if ((  percetage43 <= very_good43 )&&( percetage43 >= very_good_end43 ))
 {
  p43  = "Very Good";    
 }else if (( percetage43 <= Excellent43 )&&( percetage43  >= very_good43 )   )
 {
  p43 = "Excellent";  
 
  }  
            
pps7.setDouble( 425,  percetage43 );                                            
pps7.setDate(  426 , sqldate);
pps7.setString(  427 , class_teacher_class);
pps7.setString(  428, Term);
pps7.setString(  429 , p43 );//inserting cmements by stude
pps7.setString( 430, System_ID.getText().trim());



pps7.setString( 431 ,Sn44 .getText().trim());//student name
 pps7.setString(  432 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 433 ,R44 .getText().trim());// marks_obtained 
pps7.setString( 434 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained44 = Double.parseDouble(R44.getText().trim()); 

double converted_total_marks44 = Double.parseDouble(total_marks.getText().trim());

int percetage44 =(int)(converted_marks_obtained44  / converted_total_marks44  * 100) ;

if (( percetage44  <= failed44 )&&( percetage44 >= totallyfailed44)){ 
  p44  = "Failed";  
}else if (( percetage44 <=passed44 )&&( percetage44 >= pass44 )   ){ 
  p44 = "Pass";  
}  else if (( percetage44  <= avaerage44 )&&(  percetage44  >= avaerage_end44 ))
{ 
 p44 = "Avaerage"; 
} 
else if ((  percetage44  <=good44 )&&(  percetage44  >= good_end44 ) )
{ 
 p44 ="Good"; 
 }else if ((  percetage44 <= very_good44 )&&( percetage44 >= very_good_end44 ))
 {
  p44  = "Very Good";    
 }else if (( percetage44 <= Excellent44 )&&( percetage44  >= very_good44 )   )
 {
  p44 = "Excellent";  
 
  }  
            
pps7.setDouble( 435,  percetage44 );                                            
pps7.setDate(  436 , sqldate);
pps7.setString(  437 , class_teacher_class);
pps7.setString(  438, Term);
pps7.setString(  439 , p44 );//inserting cmements by stude
pps7.setString( 440, System_ID.getText().trim());





pps7.setString( 441 ,Sn45 .getText().trim());//student name
 pps7.setString(  442 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 443 ,R45 .getText().trim());// marks_obtained 
pps7.setString( 444 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained45 = Double.parseDouble(R45.getText().trim()); 

double converted_total_marks45 = Double.parseDouble(total_marks.getText().trim());

int percetage45 =(int)(converted_marks_obtained45  / converted_total_marks45  * 100) ;

if (( percetage45  <= failed45 )&&( percetage45 >= totallyfailed45)){ 
  p45  = "Failed";  
}else if (( percetage45 <=passed45 )&&( percetage45 >= pass45 )   ){ 
  p45 = "Pass";  
}  else if (( percetage45  <= avaerage45 )&&(  percetage45  >= avaerage_end45 ))
{ 
 p45 = "Avaerage"; 
} 
else if ((  percetage45  <=good45 )&&(  percetage45  >= good_end45 ) )
{ 
 p45 ="Good"; 
 }else if ((  percetage45 <= very_good45 )&&( percetage45 >= very_good_end45 ))
 {
  p45  = "Very Good";    
 }else if (( percetage45 <= Excellent45 )&&( percetage45  >= very_good45 )   )
 {
  p45 = "Excellent";  
 
  }  
            
pps7.setDouble( 445,  percetage45 );                                            
pps7.setDate(  446 , sqldate);
pps7.setString(  447 , class_teacher_class);
pps7.setString(  448, Term);
pps7.setString(  449 , p45 );//inserting cmements by stude
pps7.setString(  450, System_ID.getText().trim());







pps7.setString( 451 ,Sn46 .getText().trim());//student name
 pps7.setString(  452 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 453 ,R46 .getText().trim());// marks_obtained 
pps7.setString( 454 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained46 = Double.parseDouble(R46.getText().trim()); 

double converted_total_marks46 = Double.parseDouble(total_marks.getText().trim());

int percetage46 =(int)(converted_marks_obtained46  / converted_total_marks46  * 100) ;

if (( percetage46  <= failed46 )&&( percetage46 >= totallyfailed46)){ 
  p46  = "Failed";  
}else if (( percetage46 <=passed46 )&&( percetage46 >= pass46 )   ){ 
  p46 = "Pass";  
}  else if (( percetage46  <= avaerage46 )&&(  percetage46  >= avaerage_end46 ))
{ 
 p46 = "Avaerage"; 
} 
else if ((  percetage46  <=good46 )&&(  percetage46  >= good_end46 ) )
{ 
 p46 ="Good"; 
 }else if ((  percetage46 <= very_good46 )&&( percetage46 >= very_good_end46 ))
 {
  p46  = "Very Good";    
 }else if (( percetage46 <= Excellent46 )&&( percetage46  >= very_good46 )   )
 {
  p46 = "Excellent";  
 
  }  
            
pps7.setDouble( 455,  percetage46 );                                            
pps7.setDate(  456 , sqldate);
pps7.setString(  457 , class_teacher_class);
pps7.setString(  458, Term);
pps7.setString(  459 , p46 );//inserting cmements by stude
pps7.setString( 460 , System_ID.getText().trim());






pps7.setString( 461 ,Sn47 .getText().trim());//student name
 pps7.setString(  462 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 463 ,R47 .getText().trim());// marks_obtained 
pps7.setString( 464 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained47 = Double.parseDouble(R47.getText().trim()); 

double converted_total_marks47 = Double.parseDouble(total_marks.getText().trim());

int percetage47 =(int)(converted_marks_obtained47  / converted_total_marks47  * 100) ;

if (( percetage47  <= failed47 )&&( percetage47 >= totallyfailed47)){ 
  p47  = "Failed";  
}else if (( percetage47 <=passed47 )&&( percetage47 >= pass47 )   ){ 
  p47 = "Pass";  
}  else if (( percetage47  <= avaerage47 )&&(  percetage47  >= avaerage_end47 ))
{ 
 p47 = "Avaerage"; 
} 
else if ((  percetage47  <=good47 )&&(  percetage47  >= good_end47 ) )
 { 
 p47 ="Good"; 
 }else if ((  percetage47 <= very_good47 )&&( percetage47 >= very_good_end47 ))
 {
  p47  = "Very Good";    
 }else if (( percetage47 <= Excellent47 )&&( percetage47  >= very_good47 )   )
 {
  p47 = "Excellent";  
 
  }  
            
pps7.setDouble( 465,  percetage47 );                                            
pps7.setDate(  466 , sqldate); 
pps7.setString(  467 , class_teacher_class);
pps7.setString(  468, Term);
pps7.setString(  469 , p47 );//inserting cmements by stude
pps7.setString( 470, System_ID.getText().trim());           
             
             
             
             
 pps7.setString( 471 ,Sn48 .getText().trim());//student name
 pps7.setString(  472 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 473 ,R48 .getText().trim());// marks_obtained 
pps7.setString( 474 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained48 = Double.parseDouble(R48.getText().trim()); 

double converted_total_marks48 = Double.parseDouble(total_marks.getText().trim());

int percetage48 =(int)(converted_marks_obtained48  / converted_total_marks48  * 100) ;
if (( percetage48  <= failed48 )&&( percetage48 >= totallyfailed48)){ 
  p48  = "Failed";  
}else if (( percetage48 <=passed48 )&&( percetage48 >= pass48 )   ){ 
  p48 = "Pass";  
}  else if (( percetage48  <= avaerage48 )&&(  percetage48  >= avaerage_end48 ))
{ 
 p48 = "Avaerage"; 
} 
else if ((  percetage48  <=good48 )&&(  percetage48  >= good_end48 ) )
{ 
 p48 ="Good"; 
 }else if ((  percetage48 <= very_good48 )&&( percetage48 >= very_good_end48 ))
 {
  p48  = "Very Good";    
 }else if (( percetage48 <= Excellent48 )&&( percetage48  >= very_good48 )   )
 {
  p48 = "Excellent";  
 
  }  
            
pps7.setDouble( 475,  percetage48 );                                            
pps7.setDate(  476 , sqldate); 
pps7.setString(  477 , class_teacher_class);
pps7.setString(  478, Term);
pps7.setString(  479 , p48 );//inserting cmements by stude
pps7.setString( 480, System_ID.getText().trim());





pps7.setString( 481 ,Sn49 .getText().trim());//student name
 pps7.setString(  482 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 483 ,R49 .getText().trim());// marks_obtained 
pps7.setString( 484 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained49 = Double.parseDouble(R49.getText().trim()); 

double converted_total_marks49 = Double.parseDouble(total_marks.getText().trim());

int percetage49 =(int)(converted_marks_obtained49  / converted_total_marks49  * 100) ;

if (( percetage49  <= failed49 )&&( percetage49 >= totallyfailed49)){ 
  p49  = "Failed";  
}else if (( percetage49 <=passed49 )&&( percetage49 >= pass49 )   ){ 
  p49 = "Pass";  
}  else if (( percetage49  <= avaerage49 )&&(  percetage49  >= avaerage_end49 ))
{ 
 p49 = "Avaerage"; 
} 
else if ((  percetage49  <=good49 )&&(  percetage49  >= good_end49 ) )
{ 
 p49 ="Good"; 
 }else if ((  percetage49 <= very_good49 )&&( percetage49 >= very_good_end49 ))
 {
  p49  = "Very Good";    
 }else if (( percetage49 <= Excellent49 )&&( percetage49  >= very_good49 )   )
 {
  p49 = "Excellent";  
 
  }  
            
pps7.setDouble( 485,  percetage49 );                                            
pps7.setDate(  486 , sqldate); 
pps7.setString(  487 , class_teacher_class);
pps7.setString(  488, Term);
pps7.setString(  489 , p49 );//inserting cmements by stude
pps7.setString( 490, System_ID.getText().trim());







pps7.setString( 491 ,Sn50 .getText().trim());//student name
 pps7.setString(  492 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 493 ,R50 .getText().trim());// marks_obtained 
pps7.setString( 494 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained50 = Double.parseDouble(R50.getText().trim()); 

double converted_total_marks50 = Double.parseDouble(total_marks.getText().trim());

int percetage50 =(int)(converted_marks_obtained50  / converted_total_marks50  * 100) ;

if (( percetage50  <= failed50 )&&( percetage50 >= totallyfailed50)){ 
  p50  = "Failed";  
}else if (( percetage50 <=passed50 )&&( percetage50 >= pass50 )   ){ 
  p50 = "Pass";  
}  else if (( percetage50  <= avaerage50 )&&(  percetage50  >= avaerage_end50 ))
{ 
 p50 = "Avaerage"; 
} 
else if ((  percetage50  <=good50 )&&(  percetage50  >= good_end50 ) )
{ 
 p50 ="Good"; 
 }else if ((  percetage50 <= very_good50 )&&( percetage50 >= very_good_end50 ))
 {
  p50  = "Very Good";    
 }else if (( percetage50 <= Excellent50 )&&( percetage50  >= very_good50 )   )
 {
  p50 = "Excellent";  
 
  }  
            
pps7.setDouble( 495,  percetage50 );                                            
pps7.setDate(  496 , sqldate); 
pps7.setString(  497 , class_teacher_class);
pps7.setString(  498, Term);
pps7.setString(  499 , p50 );//inserting cmements by stude
pps7.setString( 500, System_ID.getText().trim());






pps7.setString( 501 ,Sn51 .getText().trim());//student name
 pps7.setString(  502 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 503 ,R51 .getText().trim());// marks_obtained 
pps7.setString( 504 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained51 = Double.parseDouble(R50.getText().trim()); 

double converted_total_marks51 = Double.parseDouble(total_marks.getText().trim());

int percetage51 =(int)(converted_marks_obtained51  / converted_total_marks51  * 100) ;

if (( percetage51  <= failed51 )&&( percetage51 >= totallyfailed51)){ 
  p51  = "Failed";  
}else if (( percetage51 <=passed51 )&&( percetage51 >= pass51 )   ){ 
  p51 = "Pass";  
}  else if (( percetage51  <= avaerage51 )&&(  percetage51  >= avaerage_end51 ))
{ 
 p51 = "Avaerage"; 
} 
else if ((  percetage51  <=good51 )&&(  percetage51  >= good_end51 ) )
{ 
 p51 ="Good"; 
 }else if ((  percetage51 <= very_good51 )&&( percetage51 >= very_good_end51 ))
 {
  p51  = "Very Good";    
 }else if (( percetage51 <= Excellent51 )&&( percetage51  >= very_good51 )   )
 {
  p51 = "Excellent";  
 
  }  
            
pps7.setDouble( 505,  percetage51 );                                            
pps7.setDate(  506 , sqldate); 
pps7.setString(  507 , class_teacher_class);
pps7.setString(  508, Term);
pps7.setString(  509 , p51 );//inserting cmements by stude
pps7.setString( 510, System_ID.getText().trim());

            

pps7.setString( 511 ,Sn52 .getText().trim());//student name
 pps7.setString(  512 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 513 ,R52 .getText().trim());// marks_obtained 
pps7.setString( 514 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained52 = Double.parseDouble(R52.getText().trim()); 

double converted_total_marks52 = Double.parseDouble(total_marks.getText().trim());

int percetage52 =(int)(converted_marks_obtained52  / converted_total_marks52  * 100) ;

if (( percetage52  <= failed52 )&&( percetage52 >= totallyfailed52)){ 
  p52  = "Failed";  
}else if (( percetage52 <=passed52 )&&( percetage52 >= pass52 )   ){ 
  p52 = "Pass";  
}  else if (( percetage52  <= avaerage52 )&&(  percetage52  >= avaerage_end52 ))
{ 
 p52 = "Avaerage"; 
} 
else if ((  percetage52  <=good52 )&&(  percetage52  >= good_end52 ) )
{ 
 p52 ="Good"; 
 }else if ((  percetage52 <= very_good52 )&&( percetage52 >= very_good_end52 ))
 {
  p52  = "Very Good";    
 }else if (( percetage52 <= Excellent52 )&&( percetage52  >= very_good52 )   )
 {
  p52 = "Excellent";  
 
  }  
            
pps7.setDouble( 515,  percetage52 );                                            
pps7.setDate(  516 , sqldate); 
pps7.setString(  517 , class_teacher_class);
pps7.setString(  518, Term);
pps7.setString(  519 , p52 );//inserting cmements by stude
pps7.setString( 520, System_ID.getText().trim());


 

pps7.setString( 521 ,Sn53 .getText().trim());//student name
 pps7.setString(  522 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 523 ,R53 .getText().trim());// marks_obtained 
pps7.setString( 524 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained53 = Double.parseDouble(R53.getText().trim()); 

double converted_total_marks53 = Double.parseDouble(total_marks.getText().trim());

int percetage53 =(int)(converted_marks_obtained53  / converted_total_marks53  * 100) ;

if (( percetage53  <= failed53 )&&( percetage53 >= totallyfailed53)){ 
  p53  = "Failed";  
}else if (( percetage53 <=passed53 )&&( percetage53 >= pass53 )   ){ 
  p53 = "Pass";  
}  else if (( percetage53  <= avaerage53 )&&(  percetage53  >= avaerage_end53 ))
{ 
 p53 = "Avaerage"; 
} 
else if ((  percetage53  <=good53 )&&(  percetage53  >= good_end53 ) )
{ 
 p53 ="Good"; 
 }else if ((  percetage53 <= very_good53 )&&( percetage53 >= very_good_end53 ))
 {
  p53  = "Very Good";    
 }else if (( percetage53 <= Excellent53 )&&( percetage53  >= very_good53 )   )
 {
  p53 = "Excellent";  
 
  }  
            
pps7.setDouble( 525,  percetage53 );                                            
pps7.setDate(  526 , sqldate); 
pps7.setString(  527 , class_teacher_class);
pps7.setString(  528, Term);
pps7.setString(  529 , p53 );//inserting cmements by stude
pps7.setString( 530, System_ID.getText().trim());





pps7.setString( 531 ,Sn54 .getText().trim());//student name
 pps7.setString(  532 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 533 ,R54 .getText().trim());// marks_obtained 
pps7.setString( 534 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained54 = Double.parseDouble(R54.getText().trim()); 

double converted_total_marks54 = Double.parseDouble(total_marks.getText().trim());

int percetage54 =(int)(converted_marks_obtained54  / converted_total_marks54  * 100) ;

if (( percetage54  <= failed54 )&&( percetage54 >= totallyfailed54)){ 
  p54  = "Failed";  
}else if (( percetage54 <=passed54 )&&( percetage54 >= pass54 )   ){ 
  p54 = "Pass";  
}  else if (( percetage54  <= avaerage54 )&&(  percetage54  >= avaerage_end54 ))
{ 
 p54 = "Avaerage"; 
} 
else if ((  percetage54  <=good54 )&&(  percetage54  >= good_end54 ) )
{ 
 p54 ="Good"; 
 }else if ((  percetage54 <= very_good54 )&&( percetage54 >= very_good_end54 ))
 {
  p54  = "Very Good";    
 }else if (( percetage54 <= Excellent54 )&&( percetage54  >= very_good54 )   )
 {
  p54 = "Excellent";  
 
  }  
            
pps7.setDouble( 535,  percetage54 );                                            
pps7.setDate(  536 , sqldate); 
pps7.setString(  537 , class_teacher_class);
pps7.setString(  538, Term);
pps7.setString(  539 , p54 );//inserting cmements by stude
pps7.setString( 540, System_ID.getText().trim());




pps7.setString( 541 ,Sn55 .getText().trim());//student name
 pps7.setString(  542 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 543 ,R55 .getText().trim());// marks_obtained 
pps7.setString( 544 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained55 = Double.parseDouble(R55.getText().trim()); 

double converted_total_marks55 = Double.parseDouble(total_marks.getText().trim());

int percetage55 =(int)(converted_marks_obtained55  / converted_total_marks55  * 100) ;

if (( percetage55  <= failed55 )&&( percetage55 >= totallyfailed55)){ 
  p55  = "Failed";  
}else if (( percetage55 <=passed55 )&&( percetage55 >= pass55 )   ){ 
  p55 = "Pass";  
}  else if (( percetage55  <= avaerage55 )&&(  percetage55  >= avaerage_end55 ))
{ 
 p55 = "Avaerage"; 
} 
else if ((  percetage55  <=good55 )&&(  percetage55  >= good_end55 ) )
{ 
 p55 ="Good"; 
 }else if ((  percetage55 <= very_good55 )&&( percetage55 >= very_good_end55 ))
 {
  p55  = "Very Good";    
 }else if (( percetage55 <= Excellent55 )&&( percetage55  >= very_good55 )   )
 {
  p55 = "Excellent";  
 
  }  
            
pps7.setDouble( 545,  percetage55 );                                            
pps7.setDate(  546 , sqldate); 
pps7.setString(  547 , class_teacher_class);
pps7.setString(  548, Term);
pps7.setString(  549 , p55 );//inserting cmements by stude
pps7.setString( 550, System_ID.getText().trim());




 


pps7.setString( 551 ,Sn56 .getText().trim());//student name
 pps7.setString(  552 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 553 ,R56 .getText().trim());// marks_obtained 
pps7.setString( 554 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained56 = Double.parseDouble(R56.getText().trim()); 

double converted_total_marks56 = Double.parseDouble(total_marks.getText().trim());

int percetage56 =(int)(converted_marks_obtained56  / converted_total_marks56  * 100) ;

if (( percetage56  <= failed55 )&&( percetage56 >= totallyfailed56)){ 
  p56  = "Failed";  
}else if (( percetage56 <=passed56 )&&( percetage56 >= pass56 )   ){ 
  p56 = "Pass";  
}  else if (( percetage56  <= avaerage56 )&&(  percetage56  >= avaerage_end56 ))
{ 
 p56 = "Avaerage"; 
} 
else if ((  percetage56  <=good56 )&&(  percetage56  >= good_end56 ) )
{ 
 p56 ="Good"; 
 }else if ((  percetage56 <= very_good56 )&&( percetage56 >= very_good_end56 ))
 {
  p56  = "Very Good";    
 }else if (( percetage56 <= Excellent56 )&&( percetage56  >= very_good56 )   )
 {
  p56 = "Excellent";  
 
  }  
            
pps7.setDouble( 555,  percetage56 );                                            
pps7.setDate(  556 , sqldate); 
pps7.setString(  557 , class_teacher_class);
pps7.setString(  558, Term);
pps7.setString(  559 , p56 );//inserting cmements by stude
pps7.setString( 560, System_ID.getText().trim());             
             
             
             

pps7.setString( 561 ,Sn57 .getText().trim());//student name
 pps7.setString(  562 ,showsubjects.getSelectedItem().toString().trim()); //subjects2
pps7.setString( 563 ,R57 .getText().trim());// marks_obtained 
pps7.setString( 564 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained57 = Double.parseDouble(R57.getText().trim()); 

double converted_total_marks57 = Double.parseDouble(total_marks.getText().trim());

int percetage57 =(int)(converted_marks_obtained57  / converted_total_marks57  * 100) ;

if (( percetage57  <= failed57 )&&( percetage57 >= totallyfailed57)){ 
  p57  = "Failed";  
}else if (( percetage57 <=passed57 )&&( percetage57 >= pass57 )   ){ 
  p57 = "Pass";  
}  else if (( percetage57  <= avaerage57 )&&(  percetage57  >= avaerage_end57 ))
{ 
 p57 = "Avaerage"; 
} 
else if ((  percetage57  <=good57 )&&(  percetage57  >= good_end57 ) )
{ 
 p57 ="Good"; 
 }else if ((  percetage57 <= very_good57 )&&( percetage57 >= very_good_end57 ))
 {
  p57  = "Very Good";    
 }else if (( percetage57 <= Excellent57 )&&( percetage57  >= very_good57 )   )
 {
  p57 = "Excellent";  
 
  }  
            
pps7.setDouble( 565,  percetage57 );                                            
pps7.setDate(  566 , sqldate); 
pps7.setString(  567 , class_teacher_class);
pps7.setString(  568, Term);
pps7.setString(  569 , p57 );//inserting cmements by stude
pps7.setString( 570, System_ID.getText().trim());






pps7.setString( 571 ,Sn58 .getText().trim());//student name
 pps7.setString(  572 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 573 ,R58 .getText().trim());// marks_obtained 
pps7.setString( 574 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained58 = Double.parseDouble(R58.getText().trim()); 

double converted_total_marks58 = Double.parseDouble(total_marks.getText().trim());

int percetage58 =(int)(converted_marks_obtained58  / converted_total_marks58  * 100) ;

if (( percetage58  <= failed58 )&&( percetage58 >= totallyfailed58)){ 
  p58  = "Failed";  
}else if (( percetage58 <=passed58 )&&( percetage58 >= pass58 )   ){ 
  p58 = "Pass";  
}  else if (( percetage58  <= avaerage58 )&&(  percetage58  >= avaerage_end58 ))
{ 
 p58 = "Avaerage"; 
} 
else if ((  percetage58  <=good58 )&&(  percetage58  >= good_end58 ) )
{ 
 p58 ="Good"; 
 }else if ((  percetage58 <= very_good58 )&&( percetage58 >= very_good_end58 ))
 {
  p58  = "Very Good";    
 }else if (( percetage58 <= Excellent58 )&&( percetage58  >= very_good58 )   )
 {
  p58 = "Excellent";  
 
  }  
            
pps7.setDouble( 575,  percetage58 );                                            
pps7.setDate(  576 , sqldate); 
pps7.setString(  577 , class_teacher_class);
pps7.setString(  578, Term);
pps7.setString(  579 , p58 );//inserting cmements by stude
pps7.setString( 580, System_ID.getText().trim());








 pps7.setString( 581 ,Sn59 .getText().trim());//student name
 pps7.setString(  582 ,showsubjects.getSelectedItem().toString().trim()); //subjects
 pps7.setString( 583 ,R59 .getText().trim());// marks_obtained 
 pps7.setString( 584 ,total_marks.getText().trim());                // total_marks_  
            
 double converted_marks_obtained59 = Double.parseDouble(R59.getText().trim()); 

 double converted_total_marks59 = Double.parseDouble(total_marks.getText().trim());

 int percetage59 =(int)(converted_marks_obtained59  / converted_total_marks59  * 100);

 if (( percetage59  <= failed59 )&&( percetage59 >= totallyfailed59)){ 
  p59  = "Failed";  
}else if (( percetage59 <=passed59 )&&( percetage59 >= pass59 )   ){ 
  p59 = "Pass";  
}  else if (( percetage59  <= avaerage59 )&&(  percetage59  >= avaerage_end59 ))
{ 
 p59 = "Avaerage"; 
} 
else if ((  percetage59  <=good59 )&&(  percetage59  >= good_end59 ) )
{ 
 p59 ="Good"; 
 }else if ((  percetage59 <= very_good59 )&&( percetage59 >= very_good_end59 ))
 {
  p59  = "Very Good";    
 }else if (( percetage59 <= Excellent59 )&&( percetage59  >= very_good59)   )
 {
  p59 = "Excellent";  
 
  }  
            
pps7.setDouble( 585,  percetage59 );                                            
pps7.setDate(  586 , sqldate); 
pps7.setString(  587 , class_teacher_class);
pps7.setString(  588, Term);
pps7.setString(  589 , p59 );//inserting cmements by stude
pps7.setString( 590, System_ID.getText().trim());




pps7.setString( 591 ,Sn60 .getText().trim());//student name
 pps7.setString(  592 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 593 ,R60 .getText().trim());// marks_obtained 
pps7.setString( 594 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained60 = Double.parseDouble(R60.getText().trim()); 

double converted_total_marks60 = Double.parseDouble(total_marks.getText().trim());

int percetage60 =(int)(converted_marks_obtained60  / converted_total_marks60  * 100) ;

if (( percetage60  <= failed60 )&&( percetage60 >= totallyfailed60)){ 
  p60  = "Failed";  
}else if (( percetage60 <=passed60 )&&( percetage60 >= pass60 )   ){ 
  p60 = "Pass";  
}  else if (( percetage60  <= avaerage60 )&&(  percetage60  >= avaerage_end60 ))
{ 
 p60 = "Avaerage"; 
} 
else if ((  percetage60  <=good60 )&&(  percetage60  >= good_end60 ) )
{ 
 p60 ="Good"; 
 }else if ((  percetage60 <= very_good60 )&&( percetage60 >= very_good_end60 ))
 {
  p60  = "Very Good";    
 }else if (( percetage60 <= Excellent60 )&&( percetage60  >= very_good60 )   )
 {
  p60 = "Excellent";  
 
  }  
            
pps7.setDouble( 595,  percetage60 );                                            
pps7.setDate(  596 , sqldate); 
pps7.setString(  597 , class_teacher_class);
pps7.setString(  598, Term);
pps7.setString(  599 , p60 );//inserting cmements by stude
pps7.setString( 600, System_ID.getText().trim());
             
           

pps7.setString( 601 ,Sn61 .getText().trim());//student name
 pps7.setString(  602 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 603 ,R61 .getText().trim());// marks_obtained 
pps7.setString( 604 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained61 = Double.parseDouble(R61.getText().trim()); 

double converted_total_marks61 = Double.parseDouble(total_marks.getText().trim());

int percetage61 =(int)(converted_marks_obtained61  / converted_total_marks61  * 100) ;

if (( percetage61  <= failed61 )&&( percetage61 >= totallyfailed61)){ 
  p61 = "Failed";  
}else if (( percetage61 <=passed61 )&&( percetage61 >= pass61 )   ){ 
  p61 = "Pass";  
}  else if (( percetage61  <= avaerage61 )&&(  percetage61  >= avaerage_end61 ))
{ 
 p61 = "Avaerage"; 
} 
else if ((  percetage61  <=good61 )&&(  percetage61  >= good_end61 ) )
{ 
 p61 ="Good"; 
 }else if ((  percetage61 <= very_good61 )&&( percetage61 >= very_good_end61 ))
 {
  p61  = "Very Good";    
 }else if (( percetage61 <= Excellent61 )&&( percetage61  >= very_good61 )   )
 {
  p61 = "Excellent";  
 
  }  
            
pps7.setDouble( 605,  percetage61 );                                            
pps7.setDate(  606 , sqldate); 
pps7.setString(  607 , class_teacher_class);
pps7.setString(  608, Term);
pps7.setString(  609 , p61 );//inserting cmements by stude
pps7.setString( 610, System_ID.getText().trim());




pps7.setString( 611 ,Sn62 .getText().trim());//student name
 pps7.setString(  612 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 613 ,R62 .getText().trim());// marks_obtained 
pps7.setString( 614 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained62 = Double.parseDouble(R62.getText().trim()); 

double converted_total_marks62 = Double.parseDouble(total_marks.getText().trim());

int percetage62 =(int)(converted_marks_obtained62  / converted_total_marks62  * 100) ;

if (( percetage62  <= failed62 )&&( percetage62 >= totallyfailed62)){ 
  p62 = "Failed";  
}else if (( percetage62 <=passed62 )&&( percetage62 >= pass62 )   ){ 
  p62 = "Pass";  
}  else if (( percetage62  <= avaerage62 )&&(  percetage62  >= avaerage_end62 ))
{ 
 p62 = "Avaerage"; 
} 
else if ((  percetage62  <=good62 )&&(  percetage62  >= good_end62 ) )
{ 
 p62 ="Good"; 
 }else if ((  percetage62 <= very_good62 )&&( percetage62 >= very_good_end62 ))
 {
  p62  = "Very Good";    
 }else if (( percetage62 <= Excellent62 )&&( percetage62  >= very_good62 )   )
 {
  p62 = "Excellent";  
 
  }  
            
pps7.setDouble( 615,  percetage62 );                                            
pps7.setDate(  616 , sqldate); 
pps7.setString(  617 , class_teacher_class);
pps7.setString(  618, Term);
pps7.setString(  619 , p62 );//inserting cmements by stude
pps7.setString( 620, System_ID.getText().trim());



pps7.setString( 621 ,Sn63 .getText().trim());//student name
 pps7.setString(  622 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 623 ,R63 .getText().trim());// marks_obtained 
pps7.setString( 624 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained63 = Double.parseDouble(R63.getText().trim()); 

double converted_total_marks63 = Double.parseDouble(total_marks.getText().trim());

int percetage63 =(int)(converted_marks_obtained63  / converted_total_marks63  * 100) ;

if (( percetage63  <= failed63 )&&( percetage63 >= totallyfailed63)){ 
  p63 = "Failed";  
}else if (( percetage63 <=passed63 )&&( percetage63 >= pass63 )   ){ 
  p63 = "Pass";  
}  else if (( percetage63  <= avaerage36 )&&(  percetage63  >= avaerage_end63 ))
{ 
 p63 = "Avaerage"; 
} 
else if ((  percetage63  <=good63 )&&(  percetage63  >= good_end63 ) )
{ 
 p63 ="Good"; 
 }else if ((  percetage63 <= very_good63 )&&( percetage63 >= very_good_end63 ))
 {
  p63  = "Very Good";    
 }else if (( percetage63 <= Excellent63 )&&( percetage63  >= very_good63 )   )
 {
  p63 = "Excellent";  
 
  }  
            
pps7.setDouble( 625,  percetage63 );                                            
pps7.setDate(  626 , sqldate); 
pps7.setString(  627 , class_teacher_class);
pps7.setString(  628, Term);
pps7.setString(  629 , p63 );//inserting cmements by stude
pps7.setString( 630, System_ID.getText().trim());





pps7.setString( 631 ,Sn64 .getText().trim());//student name
 pps7.setString(  632 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 633 ,R64 .getText().trim());// marks_obtained 
pps7.setString( 634 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained64 = Double.parseDouble(R64.getText().trim()); 

double converted_total_marks64 = Double.parseDouble(total_marks.getText().trim());

int percetage64 =(int)(converted_marks_obtained64  / converted_total_marks64  * 100) ;

if (( percetage64  <= failed64 )&&( percetage64 >= totallyfailed64)){ 
  p64 = "Failed";  
}else if (( percetage64 <=passed64 )&&( percetage64 >= pass64 )   ){ 
  p64 = "Pass";  
}  else if (( percetage64  <= avaerage64 )&&(  percetage64  >= avaerage_end64 ))
{ 
 p64 = "Avaerage"; 
} 
else if ((  percetage64  <=good64 )&&(  percetage64  >= good_end64 ) )
{ 
 p64 ="Good"; 
 }else if ((  percetage64 <= very_good64 )&&( percetage64 >= very_good_end64))
 {
  p64  = "Very Good";    
 }else if (( percetage64 <= Excellent64 )&&( percetage64  >= very_good64 )   )
 {
  p64 = "Excellent";  
 
  }  
            
pps7.setDouble( 635,  percetage64 );                                            
pps7.setDate(  636 , sqldate); 
pps7.setString(  637 , class_teacher_class);
pps7.setString(  638, Term);
pps7.setString(  639 , p64 );//inserting cmements by stude
pps7.setString( 640, System_ID.getText().trim());             
             
             
 
pps7.setString( 641 ,Sn65 .getText().trim());//student name
 pps7.setString(  642 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 643 ,R65 .getText().trim());// marks_obtained 
pps7.setString( 644 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained65 = Double.parseDouble(R65.getText().trim()); 

double converted_total_marks65 = Double.parseDouble(total_marks.getText().trim());

int percetage65 =(int)(converted_marks_obtained65  / converted_total_marks65  * 100) ;

if (( percetage65  <= failed65 )&&( percetage65 >= totallyfailed65)){ 
  p65 = "Failed";  
}else if (( percetage65 <=passed65 )&&( percetage65 >= pass65 )   ){ 
  p65 = "Pass";  
}  else if (( percetage65  <= avaerage65 )&&(  percetage65  >= avaerage_end65 ))
{ 
 p65 = "Avaerage"; 
} 
else if ((  percetage65  <=good65 )&&(  percetage65  >= good_end65 ) )
{ 
 p65 ="Good"; 
 }else if ((  percetage65 <= very_good65 )&&( percetage65 >= very_good_end65 ))
 {
  p65  = "Very Good";    
 }else if (( percetage65 <= Excellent65 )&&( percetage65  >= very_good65 )   )
 {
  p65 = "Excellent";  
 
  }  
            
pps7.setDouble( 645,  percetage65 );                                            
pps7.setDate(  646 , sqldate); 
pps7.setString(  647 , class_teacher_class);
pps7.setString(  648, Term);
pps7.setString(  649 , p65 );//inserting cmements by stude
pps7.setString( 650, System_ID.getText().trim());








pps7.setString( 651 ,Sn66 .getText().trim());//student name
 pps7.setString(  652 ,showsubjects.getSelectedItem().toString().trim()); //subjects20
pps7.setString( 653 ,R66 .getText().trim());// marks_obtained 
pps7.setString( 654 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained66 = Double.parseDouble(R66.getText().trim()); 

double converted_total_marks66 = Double.parseDouble(total_marks.getText().trim());

int percetage66 =(int)(converted_marks_obtained66  / converted_total_marks66  * 100) ;

if (( percetage66  <= failed66 )&&( percetage66 >= totallyfailed66)){ 
  p66 = "Failed";  
}else if (( percetage66 <=passed66 )&&( percetage66 >= pass66 )   ){ 
  p66 = "Pass";  
}  else if (( percetage66  <= avaerage66 )&&(  percetage66  >= avaerage_end66 ))
{ 
 p66 = "Avaerage"; 
} 
else if ((  percetage66  <=good66 )&&(  percetage66  >= good_end66 ) )
{ 
 p66 ="Good"; 
 }else if ((  percetage66 <= very_good66 )&&( percetage66 >= very_good_end66 ))
 {
  p66  = "Very Good";    
 }else if (( percetage66 <= Excellent66 )&&( percetage66  >= very_good66 )   )
 {
  p66 = "Excellent";  
 
  }  
            
pps7.setDouble( 655,  percetage66 );                                            
pps7.setDate(  656 , sqldate); 
pps7.setString(  657 , class_teacher_class);
pps7.setString(  658, Term);
pps7.setString(  659 , p66 );//inserting cmements by stude
pps7.setString( 660, System_ID.getText().trim());



pps7.setString( 661 ,Sn67 .getText().trim());//student name
 pps7.setString(  662 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 663 ,R67 .getText().trim());// marks_obtained 
pps7.setString( 664 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained67 = Double.parseDouble(R67.getText().trim()); 

double converted_total_marks67 = Double.parseDouble(total_marks.getText().trim());

int percetage67 =(int)(converted_marks_obtained67  / converted_total_marks67  * 100) ;

if (( percetage67  <= failed67 )&&( percetage67 >= totallyfailed67)){ 
  p67 = "Failed";  
}else if (( percetage67 <=passed67 )&&( percetage67 >= pass67 )   ){ 
  p67 = "Pass";  
}  else if (( percetage67  <= avaerage67 )&&(  percetage67  >= avaerage_end67 ))
{ 
 p67 = "Avaerage"; 
} 
else if ((  percetage67  <=good67 )&&(  percetage67  >= good_end67 ) )
{ 
 p67 ="Good"; 
 }else if ((  percetage67 <= very_good67 )&&( percetage67 >= very_good_end67 ))
 {
  p67  = "Very Good";    
 }else if (( percetage67 <= Excellent67 )&&( percetage67  >= very_good67 )   )
 {
  p67 = "Excellent";  
 
  }  
            
pps7.setDouble( 665,  percetage67 );                                            
pps7.setDate(  666 , sqldate); 
pps7.setString(  667 , class_teacher_class);
pps7.setString(  668, Term);
pps7.setString(  669 , p67 );//inserting cmements by stude
pps7.setString( 670, System_ID.getText().trim());




pps7.setString( 671 ,Sn68 .getText().trim());//student name
pps7.setString(  672 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 673 ,R68 .getText().trim());// marks_obtained 
pps7.setString( 674 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained68 = Double.parseDouble(R68.getText().trim()); 

double converted_total_marks68 = Double.parseDouble(total_marks.getText().trim());

int percetage68 =(int)(converted_marks_obtained68  / converted_total_marks68  * 100) ;

if (( percetage68  <= failed68 )&&( percetage68 >= totallyfailed68)){ 
  p68 = "Failed";  
}else if (( percetage68 <=passed68 )&&( percetage68 >= pass68 )   ){ 
  p68 = "Pass";  
}  else if (( percetage68  <= avaerage68 )&&(  percetage68  >= avaerage_end68))
{ 
 p68 = "Avaerage"; 
} 
else if ((  percetage68  <=good68 )&&(  percetage68  >= good_end68 ) )
{ 
 p68 ="Good"; 
 }else if ((  percetage68 <= very_good68 )&&( percetage68 >= very_good_end68 ))
 {
  p68  = "Very Good";    
 }else if (( percetage68 <= Excellent68 )&&( percetage68  >= very_good68 )   )
 {
  p68 = "Excellent";  

}  
            
pps7.setDouble( 675,  percetage68 );                                            
pps7.setDate(  676 , sqldate); 
pps7.setString(  677 , class_teacher_class);
pps7.setString(  678, Term);
pps7.setString(  679 , p68 );//inserting cmements by stude
pps7.setString( 680, System_ID.getText().trim());





pps7.setString( 681 ,Sn69 .getText().trim());//student name
 pps7.setString(  682 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 683 ,R69 .getText().trim());// marks_obtained 
pps7.setString( 684 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained69 = Double.parseDouble(R69.getText().trim()); 

double converted_total_marks69 = Double.parseDouble(total_marks.getText().trim());

int percetage69 =(int)(converted_marks_obtained69  / converted_total_marks69  * 100) ;

if (( percetage69  <= failed69 )&&( percetage69 >= totallyfailed69)){ 
  p69 = "Failed";  
}else if (( percetage69 <=passed69 )&&( percetage69 >= pass69 )   ){ 
  p69 = "Pass";  
}  else if (( percetage69  <= avaerage69 )&&(  percetage69  >= avaerage_end69 ))
{ 
 p69 = "Avaerage"; 
} 
else if ((  percetage69  <=good69 )&&(  percetage69  >= good_end69 ) )
{ 
 p69 ="Good"; 
 }else if ((  percetage69 <= very_good69 )&&( percetage69 >= very_good_end69 ))
 {
  p69  = "Very Good";    
 }else if (( percetage69 <= Excellent69 )&&( percetage69  >= very_good69 )   )
 {
  p69 = "Excellent";  
 
  }  
            
pps7.setDouble( 685,  percetage69 );                                            
pps7.setDate(  686 , sqldate); 
pps7.setString(  687 , class_teacher_class);
pps7.setString(  688, Term);
pps7.setString(  689 , p69 );//inserting cmements by stude
pps7.setString( 690, System_ID.getText().trim());





  pps7.setString( 691 ,Sn70 .getText().trim());//student name
  pps7.setString(  692 ,showsubjects.getSelectedItem().toString().trim()); //subjshowsubjects.getSelectedItemects
  pps7.setString( 693 ,R70 .getText().trim());// marks_obtained 
  pps7.setString( 694 ,total_marks.getText().trim());                // total_marks_  
            
  double converted_marks_obtained70  = Double.parseDouble(R70.getText().trim()); 

  double converted_total_marks70 = Double.parseDouble(total_marks.getText().trim());

  int percetage70 =(int)(converted_marks_obtained70  / converted_total_marks70  * 100) ;

if (( percetage70  <= failed70 )&&( percetage70 >= totallyfailed70)){ 
  p70 = "Failed";  
}else if (( percetage70 <=passed70 )&&( percetage70 >= pass70 )   ){ 
  p70 = "Pass";  
}  else if (( percetage70  <= avaerage70 )&&(  percetage70  >= avaerage_end70 ))
{ 
 p70 = "Avaerage"; 
} 
else if ((  percetage70  <=good70 )&&(  percetage70  >= good_end70 ) )
{ 
  p70 ="Good"; 
 }else if ((  percetage70 <= very_good70 )&&( percetage70 >= very_good_end70))
 {
  p70  = "Very Good";    
 }else if (( percetage70 <= Excellent70 )&&( percetage70  >= very_good70 )   )
 {
  p70 = "Excellent";  
 
  }  
            
pps7.setDouble( 695,  percetage70 );                                            
pps7.setDate(  696 , sqldate); 
pps7.setString(  697 , class_teacher_class);
pps7.setString(  698, Term);
pps7.setString(  699 , p70 );//inserting cmements by stude
pps7.setString( 700, System_ID.getText().trim());








pps7.setString( 701 ,Sn71 .getText().trim());//student name
 pps7.setString(  702 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 703 ,R71 .getText().trim());// marks_obtained 
pps7.setString( 704 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained71 = Double.parseDouble(R71.getText().trim()); 

double converted_total_marks71 = Double.parseDouble(total_marks.getText().trim());

int percetage71 =(int)(converted_marks_obtained71  / converted_total_marks71  * 100) ;

if (( percetage71  <= failed71 )&&( percetage71 >= totallyfailed71)){ 
  p71 = "Failed";  
}else if (( percetage71 <=passed71)&&( percetage71 >= pass71 )   ){ 
  p71 = "Pass";  
}  else if (( percetage71  <= avaerage71 )&&(  percetage71  >= avaerage_end71 ))
{ 
 p71 = "Avaerage"; 
} 
else if ((  percetage71  <=good71 )&&(  percetage71  >= good_end71 ) )
{ 
 p71 ="Good"; 
 }else if ((  percetage71 <= very_good71 )&&( percetage71 >= very_good_end71 ))
 {
  p71  = "Very Good";    
 }else if (( percetage71 <=     Excellent71 )&&( percetage71  >= very_good71 )   )
 {
  p71 = "Excellent";  
 
  }  
            
pps7.setDouble( 705,  percetage71 );                                            
pps7.setDate(  706 , sqldate); 
pps7.setString(  707 , class_teacher_class);
pps7.setString(  708, Term);
pps7.setString(  709 , p71 );//inserting cmements by stude
pps7.setString( 710, System_ID.getText().trim());






pps7.setString( 711 ,Sn72 .getText().trim());//student name
pps7.setString(  712 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 713 ,R72 .getText().trim());// marks_obtained 
pps7.setString( 714 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained72 = Double.parseDouble(R72.getText().trim()); 

double converted_total_marks72 = Double.parseDouble(total_marks.getText().trim());

int percetage72 =(int)(converted_marks_obtained72  / converted_total_marks72  * 100) ;

if (( percetage72  <= failed72 )&&( percetage72 >= totallyfailed72)){ 
  p72 = "Failed";  
}else if (( percetage72 <=passed72 )&&( percetage72 >= pass72 )   ){ 
  p72 = "Pass";  
}  else if (( percetage72  <= avaerage72 )&&(  percetage72  >= avaerage_end72 ))
{ 
 p72 = "Avaerage"; 
} 
else if ((  percetage72  <=good72 )&&(  percetage72  >= good_end72 ) )
{ 
 p72 ="Good"; 
 }else if ((  percetage72 <= very_good72 )&&( percetage72 >= very_good_end72 ))
 {
  p72  = "Very Good";    
 }else if (( percetage72 <=     Excellent72 )&&( percetage72  >= very_good72 )   )
 {
  p72 = "Excellent";  
 
  }  
            
pps7.setDouble( 715,  percetage72 );                                            
pps7.setDate(  716 , sqldate); 
pps7.setString(  717 , class_teacher_class);
pps7.setString(  718, Term);
pps7.setString(  719 , p72 );//inserting cmements by stude
pps7.setString( 720, System_ID.getText().trim());            



pps7.setString( 721 ,Sn73 .getText().trim());//student name
 pps7.setString(  722 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 723 ,R73 .getText().trim());// marks_obtained 
pps7.setString( 724 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained73 = Double.parseDouble(R73.getText().trim()); 

double converted_total_marks73 = Double.parseDouble(total_marks.getText().trim());

int percetage73 =(int)(converted_marks_obtained73  / converted_total_marks73  * 100) ;

if (( percetage73  <= failed73 )&&( percetage73 >= totallyfailed73)){ 
  p73 = "Failed";  
}else if (( percetage73 <=passed73 )&&( percetage73 >= pass73 )   ){ 
  p73 = "Pass";  
}  else if (( percetage73  <= avaerage73 )&&(  percetage73  >= avaerage_end73 ))
{ 
 p73 = "Avaerage"; 
} 
else if ((  percetage73  <=good73 )&&(  percetage73  >= good_end73 ) )
{ 
 p73 ="Good"; 
 }else if ((  percetage73 <= very_good73 )&&( percetage73 >= very_good_end73 ))
 {
  p73  = "Very Good";    
 }else if (( percetage73 <=     Excellent73 )&&( percetage73  >= very_good73 )   )
 {
  p73 = "Excellent";  
 
  }  
            
pps7.setDouble( 725,  percetage73 );                                            
pps7.setDate(  726 , sqldate); 
pps7.setString(  727 , class_teacher_class);
pps7.setString(  728, Term);
pps7.setString(  729 , p73 );//inserting cmements by stude
pps7.setString( 730, System_ID.getText().trim());







pps7.setString( 731 ,Sn74 .getText().trim());//student name
 pps7.setString(  732 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 733 ,R74 .getText().trim());// marks_obtained 
pps7.setString( 734 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained74 = Double.parseDouble(R74.getText().trim()); 

double converted_total_marks74 = Double.parseDouble(total_marks.getText().trim());

int percetage74 =(int)(converted_marks_obtained74  / converted_total_marks74  * 100) ;

if (( percetage74  <= failed74 )&&( percetage74 >= totallyfailed74)){ 
  p74 = "Failed";  
}else if (( percetage74 <=passed74 )&&( percetage74 >= pass74 )   ){ 
  p74 = "Pass";  
}  else if (( percetage74  <= avaerage74 )&&(  percetage74  >= avaerage_end74 ))
{ 
 p74 = "Avaerage"; 
} 
else if ((  percetage74  <=good74 )&&(  percetage74  >= good_end74 ) )
{ 
 p74 ="Good"; 
 }else if ((  percetage74 <= very_good74 )&&( percetage74 >= very_good_end74 ))
 {
  p74  = "Very Good";    
 }else if (( percetage74 <=     Excellent74 )&&( percetage74  >= very_good74 )   )
 {
  p74 = "Excellent";  
 
  }  
            
pps7.setDouble( 735,  percetage74 );                                            
pps7.setDate(  736 , sqldate); 
pps7.setString(  737 , class_teacher_class);
pps7.setString(  738, Term);
pps7.setString(  739 , p74 );//inserting cmements by stude
pps7.setString( 740, System_ID.getText().trim());




pps7.setString( 741 ,Sn75 .getText().trim());//student name
 pps7.setString(  742 ,showsubjects.getSelectedItem().toString().trim()); //subjects  11
pps7.setString( 743 ,R75 .getText().trim());// marks_obtained 
pps7.setString( 744 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained75 = Double.parseDouble(R75.getText().trim()); 

double converted_total_marks75 = Double.parseDouble(total_marks.getText().trim());

int percetage75 =(int)(converted_marks_obtained75  / converted_total_marks75  * 100) ;

if (( percetage75  <= failed75 )&&( percetage75 >= totallyfailed75)){ 
  p75 = "Failed";  
}else if (( percetage75 <=passed75 )&&( percetage75 >= pass75 )   ){ 
  p75 = "Pass";  
}  else if (( percetage75  <= avaerage75 )&&(  percetage75  >= avaerage_end75 ))
{ 
 p75 = "Avaerage"; 
} 
else if ((  percetage75  <=good75 )&&(  percetage75  >= good_end75 ) )
{ 
 p75 ="Good"; 
 }else if ((  percetage75 <= very_good75 )&&( percetage75 >= very_good_end75 ))
 {
  p75  = "Very Good";    
 }else if (( percetage75 <=     Excellent75 )&&( percetage75  >= very_good75 )   )
 {
  p75 = "Excellent";  
 
  }  
            
pps7.setDouble( 745,  percetage75 );                                            
pps7.setDate(  746 , sqldate); 
pps7.setString(  747 , class_teacher_class);
pps7.setString(  748, Term);
pps7.setString(  749 , p75 );//inserting cmements by stude
pps7.setString( 750, System_ID.getText().trim());






pps7.setString( 751 ,Sn76 .getText().trim());//student name
 pps7.setString(  752 ,showsubjects.getSelectedItem().toString().trim()); //subjects  10
pps7.setString( 753 ,R76 .getText().trim());// marks_obtained 
pps7.setString( 754 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained76 = Double.parseDouble(R76.getText().trim()); 

double converted_total_marks76 = Double.parseDouble(total_marks.getText().trim());

int percetage76 =(int)(converted_marks_obtained76  / converted_total_marks76  * 100) ;

if (( percetage76  <= failed76 )&&( percetage76 >= totallyfailed76)){ 
  p76 = "Failed";  
}else if (( percetage76 <=passed76 )&&( percetage76 >= pass76 )   ){ 
  p76 = "Pass";  
}  else if (( percetage76  <= avaerage76 )&&(  percetage76  >= avaerage_end76 ))
{ 
 p76 = "Avaerage"; 
} 
 else if ((  percetage76  <=good76 )&&(  percetage76  >= good_end76 ) )
{ 
 p76 ="Good"; 
 }else if ((  percetage76 <= very_good76 )&&( percetage76 >= very_good_end76 ))
 {
  p76  = "Very Good";    
 }else if (( percetage76 <=     Excellent76 )&&( percetage76  >= very_good76 )   )
 {
  p76 = "Excellent";  
 
  }  
            
pps7.setDouble( 755,  percetage76 );                                            
pps7.setDate(  756 , sqldate); 
pps7.setString(  757 , class_teacher_class);
pps7.setString(  758, Term);
pps7.setString(  759 , p76 );//inserting cmements by stude
pps7.setString( 760, System_ID.getText().trim());



pps7.setString( 761 ,Sn77 .getText().trim());//student name
 pps7.setString(  762 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 763 ,R77 .getText().trim());// marks_obtained 
pps7.setString( 764 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained77 = Double.parseDouble(R77.getText().trim()); 

double converted_total_marks77 = Double.parseDouble(total_marks.getText().trim());

int percetage77 =(int)(converted_marks_obtained77  / converted_total_marks77  * 100) ;

if (( percetage77  <= failed77 )&&( percetage77 >= totallyfailed77)){ 
  p77 = "Failed";  
}else if (( percetage77 <=passed77 )&&( percetage77 >= pass77 )   ){ 
  p77 = "Pass";  
}  else if (( percetage77  <= avaerage77 )&&(  percetage77  >= avaerage_end77 ))
{ 
 p77 = "Avaerage"; 
} 
else if ((  percetage77  <=good77 )&&(  percetage77  >= good_end77 ) )
{ 
 p77 ="Good";  
 }else if ((  percetage77 <= very_good77 )&&( percetage77 >= very_good_end77 ))
 {
  p77  = "Very Good";    
 }else if (( percetage77 <=     Excellent77 )&&( percetage77  >= very_good77 )   )
 {
  p77 = "Excellent";  
 
  }  
            
pps7.setDouble( 765,  percetage77 );                                            
pps7.setDate(  766 , sqldate); 
pps7.setString(  767 , class_teacher_class);
pps7.setString(  768, Term);
pps7.setString(  769 , p77 );//inserting cmements by stude
pps7.setString( 770, System_ID.getText().trim());



pps7.setString( 771 ,Sn78 .getText().trim());//student name
 pps7.setString(  772 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 773 ,R78 .getText().trim());// marks_obtained 
pps7.setString( 774 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained78 = Double.parseDouble(R78.getText().trim()); 

double converted_total_marks78 = Double.parseDouble(total_marks.getText().trim());

int percetage78 =(int)(converted_marks_obtained78  / converted_total_marks78  * 100) ;

if (( percetage78  <= failed78 )&&( percetage78 >= totallyfailed78)){ 
  p78 = "Failed";  
}else if (( percetage78 <=passed78)&&( percetage78 >= pass78 )   ){ 
  p78 = "Pass";  
}  else if (( percetage78  <= avaerage78 )&&(  percetage78  >= avaerage_end78 ))
{ 
 p78 = "Avaerage"; 
} 
else if ((  percetage78  <=good78 )&&(  percetage78  >= good_end78 ) )
{ 
 p78 ="Good"; 
 }else if ((  percetage78 <= very_good78 )&&( percetage78 >= very_good_end78 ))
 {
  p78  = "Very Good";    
 }else if (( percetage78 <=     Excellent78 )&&( percetage78  >= very_good78 )   )
 {
  p78 = "Excellent";  
 
  }  
            
pps7.setDouble( 775,  percetage78 );                                            
pps7.setDate(  776 , sqldate); 
pps7.setString(  777 , class_teacher_class);
pps7.setString(  778, Term);
pps7.setString(  779 , p78 );//inserting cmements by stude
pps7.setString( 780, System_ID.getText().trim());





pps7.setString( 781 ,Sn79 .getText().trim());//student name
 pps7.setString(  782 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 783 ,R79 .getText().trim());// marks_obtained 
pps7.setString( 784 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained79 = Double.parseDouble(R79.getText().trim()); 

double converted_total_marks79 = Double.parseDouble(total_marks.getText().trim());

int percetage79 =(int)(converted_marks_obtained79  / converted_total_marks79  * 100) ;

if (( percetage79  <= failed79 )&&( percetage79 >= totallyfailed79)){ 
  p79 = "Failed";  
}else if (( percetage79 <=passed79 )&&( percetage79 >= pass79 )   ){ 
  p79 = "Pass";  
}  else if (( percetage79  <= avaerage79 )&&(  percetage79  >= avaerage_end79 ))
{ 
 p79 = "Avaerage"; 
} 
else if ((  percetage79  <=good79 )&&(  percetage79  >= good_end79 ) )
{ 
 p79 ="Good"; 
 }else if ((  percetage79 <= very_good79 )&&( percetage79 >= very_good_end79 ))
 {
  p79  = "Very Good";    
 }else if (( percetage79 <=     Excellent79 )&&( percetage79  >= very_good79 )   )
 {
  p79 = "Excellent";  
 
  }  
            
pps7.setDouble( 785,  percetage79 );                                            
pps7.setDate(  786 , sqldate); 
pps7.setString(  787 , class_teacher_class);
pps7.setString(  788, Term);
pps7.setString(  789 , p79 );//inserting cmements by stude
pps7.setString( 790, System_ID.getText().trim());






pps7.setString( 791 ,Sn80 .getText().trim());//student name
 pps7.setString(  792 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 793 ,R80 .getText().trim());// marks_obtained 
pps7.setString( 794 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained80 = Double.parseDouble(R80.getText().trim()); 

double converted_total_marks80 = Double.parseDouble(total_marks.getText().trim());

int percetage80 =(int)(converted_marks_obtained80  / converted_total_marks80  * 100) ;

if (( percetage80  <= failed80 )&&( percetage80 >= totallyfailed80)){ 
  p80 = "Failed";  
}else if (( percetage80 <=passed80)&&( percetage80 >= pass80 )   ){ 
  p80 = "Pass";  
}  else if (( percetage80  <= avaerage80 )&&(  percetage80  >= avaerage_end80 ))
{ 
 p80 = "Avaerage"; 
} 
else if ((  percetage80  <=good80 )&&(  percetage80  >= good_end80 ) )
{ 
 p80 ="Good"; 
 }else if ((  percetage80 <= very_good80 )&&( percetage80 >= very_good_end80 ))
 {
  p80  = "Very Good";    
 }else if (( percetage80 <=     Excellent80 )&&( percetage80  >= very_good80 )   )
 {
  p80 = "Excellent";  
 
  }  
            
pps7.setDouble( 795,  percetage80 );                                            
pps7.setDate(  796 , sqldate); 
pps7.setString(  797 , class_teacher_class);
pps7.setString(  798, Term);
pps7.setString(  799 , p80 );//inserting cmements by stude
pps7.setString( 800, System_ID.getText().trim());



pps7.setString( 801 ,Sn81 .getText().trim());//student name
 pps7.setString(  802 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 803 ,R81 .getText().trim());// marks_obtained 
pps7.setString( 804 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained81 = FloatingDecimal.parseDouble(R81.getText().trim()); 

double converted_total_marks81 = FloatingDecimal.parseDouble(total_marks.getText().trim());

int percetage81 =(int)(converted_marks_obtained81  / converted_total_marks81  * 100) ;

if (( percetage81  <= failed81 )&&( percetage81 >= totallyfailed81)){ 
  p81 = "Failed";  
}else if (( percetage81 <=passed81 )&&( percetage81 >= pass81 )   ){ 
  p81 = "Pass";  
}  else if (( percetage81  <= avaerage81 )&&(  percetage81  >= avaerage_end81 ))
{ 
 p81 = "Avaerage"; 
} 
else if ((  percetage81  <=good81 )&&(  percetage81  >= good_end81 ) )
{ 
 p81 ="Good"; 
 }else if ((  percetage81 <= very_good81 )&&( percetage81 >= very_good_end81 ))
 {
  p81  = "Very Good";    
 }else if (( percetage81 <=     Excellent81 )&&( percetage81  >= very_good81 )   )
 {
  p81 = "Excellent";  
 
  }  
            
pps7.setDouble( 805,  percetage81 );                                            
pps7.setDate(  806 , sqldate); 
pps7.setString(  807 , class_teacher_class);
pps7.setString(  808, Term);
pps7.setString(  809 , p81 );//inserting cmements by stude
pps7.setString( 810, System_ID.getText().trim());







pps7.setString( 811 ,Sn82 .getText().trim());//student name
 pps7.setString(  812 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 813 ,R82 .getText().trim());// marks_obtained 
pps7.setString( 814 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained82 = Double.parseDouble(R82.getText().trim()); 

double converted_total_marks82 = Double.parseDouble(total_marks.getText().trim());

int percetage82 =(int)(converted_marks_obtained82  / converted_total_marks82  * 100) ;

if (( percetage82  <= failed82 )&&( percetage82 >= totallyfailed82)){ 
  p82 = "Failed";  
}else if (( percetage82 <=passed82 )&&( percetage82 >= pass82 )   ){ 
  p82 = "Pass";  
}  else if (( percetage82  <= avaerage82 )&&(  percetage82  >= avaerage_end82 ))
{ 
 p82 = "Avaerage"; 
} 
else if ((  percetage82  <=good82 )&&(  percetage82  >= good_end82 ) )
{ 
 p82 ="Good"; 
 }else if ((  percetage82 <= very_good82 )&&( percetage82 >= very_good_end82 ))
 {
  p82  = "Very Good";    
 }else if (( percetage82 <=     Excellent82 )&&( percetage82  >= very_good82 )   )
 {
  p82 = "Excellent";  
 
  }  
            
pps7.setDouble( 815,  percetage82 );                                            
pps7.setDate(  816 , sqldate); 
pps7.setString(  817 , class_teacher_class);
pps7.setString(  818, Term);
pps7.setString(  819 , p82 );//inserting cmements by stude
pps7.setString( 820, System_ID.getText().trim());








pps7.setString( 821 ,Sn83 .getText().trim());//student name
 pps7.setString(  822 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 823 ,R83 .getText().trim());// marks_obtained 
pps7.setString( 824 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained83 = Double.parseDouble(R83.getText().trim()); 

double converted_total_marks83 = Double.parseDouble(total_marks.getText().trim());

int percetage83 =(int)(converted_marks_obtained83  / converted_total_marks83  * 100) ;

if (( percetage83  <= failed83 )&&( percetage83 >= totallyfailed83)){ 
  p83 = "Failed";  
}else if (( percetage83 <=passed83 )&&( percetage83 >= pass83 )   ){ 
  p83 = "Pass";  
}  else if (( percetage83  <= avaerage83 )&&(  percetage83  >= avaerage_end83 ))
{ 
 p83 = "Avaerage"; 
} 
else if ((  percetage83  <=good83 )&&(  percetage83  >= good_end83 ) )
{ 
 p83 ="Good"; 
 }else if ((  percetage83 <= very_good83 )&&( percetage83 >= very_good_end83 ))
 {
  p83  = "Very Good";    
 }else if (( percetage83 <=     Excellent83 )&&( percetage83  >= very_good83 )   )
 {
  p83 = "Excellent";  
 
  }  
            
pps7.setDouble( 825,  percetage83 );                                            
pps7.setDate(  826 , sqldate); 
pps7.setString(  827 , class_teacher_class);
pps7.setString(  828, Term);
pps7.setString(  829 , p83 );//inserting cmements by stude
pps7.setString( 830, System_ID.getText().trim());




pps7.setString( 831 ,Sn84 .getText().trim());//student name
 pps7.setString(  832 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 833 ,R84 .getText().trim());// marks_obtained 
pps7.setString( 834 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained84 = Double.parseDouble(R84.getText().trim()); 

double converted_total_marks84 = Double.parseDouble(total_marks.getText().trim());

int percetage84 =(int)(converted_marks_obtained84  / converted_total_marks84  * 100) ;

if (( percetage84  <= failed84 )&&( percetage84 >= totallyfailed84)){ 
  p84 = "Failed";  
}else if (( percetage84 <=passed84 )&&( percetage84 >= pass84 )   ){ 
  p84 = "Pass";  
}  else if (( percetage84  <= avaerage84 )&&(  percetage84  >= avaerage_end84 ))
{ 
 p84 = "Avaerage"; 
} 
else if ((  percetage84  <=good84 )&&(  percetage84  >= good_end84 ) )
{ 
 p84 ="Good"; 
 }else if ((  percetage84 <= very_good84 )&&( percetage84 >= very_good_end84 ))
 {
  p84  = "Very Good";    
 }else if (( percetage84 <=     Excellent84 )&&( percetage84  >= very_good84 )   )
 {
  p84 = "Excellent";  
 
  }  
            
pps7.setDouble( 835,  percetage84 );                                            
pps7.setDate(  836 , sqldate); 
pps7.setString(  837 , class_teacher_class);
pps7.setString(  838, Term);
pps7.setString(  839 , p84 );//inserting cmements by stude
pps7.setString( 840, System_ID.getText().trim());



pps7.setString( 841 ,Sn85 .getText().trim());//student name
 pps7.setString(  842 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 843 ,R85 .getText().trim());// marks_obtained 
pps7.setString( 844 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained85 = Double.parseDouble(R85.getText().trim()); 

double converted_total_marks85 = Double.parseDouble(total_marks.getText().trim());

int percetage85 =(int)(converted_marks_obtained85  / converted_total_marks85  * 100) ;

if (( percetage85  <= failed85 )&&( percetage85 >= totallyfailed85)){ 
  p85 = "Failed";  
}else if (( percetage85 <=passed85 )&&( percetage85 >= pass85 )   ){ 
  p85 = "Pass";  
}  else if (( percetage85  <= avaerage85 )&&(  percetage85  >= avaerage_end85 ))
{ 
 p85 = "Avaerage"; 
} 
else if ((  percetage85  <=good85 )&&(  percetage85  >= good_end85 ) )
{ 
 p85 ="Good"; 
 }else if ((  percetage85 <= very_good85 )&&( percetage85 >= very_good_end85 ))
 {
  p85  = "Very Good";    
 }else if (( percetage85 <=     Excellent85 )&&( percetage85  >= very_good85 )   )
 {
  p85 = "Excellent";  
 
  }  
            
pps7.setDouble( 845,  percetage85 );                                             
pps7.setDate(  846 , sqldate); 
pps7.setString(  847 , class_teacher_class);
pps7.setString(  848, Term);
pps7.setString(  849 , p85 );//inserting cmements by stude
pps7.setString( 850, System_ID.getText().trim());






pps7.setString( 851 ,Sn86 .getText().trim());//student name
 pps7.setString(  852 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 853 ,R86 .getText().trim());// marks_obtained 
pps7.setString( 854 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained86 = Double.parseDouble(R86.getText().trim()); 

double converted_total_marks86 = Double.parseDouble(total_marks.getText().trim());

int percetage86 =(int)(converted_marks_obtained86  / converted_total_marks86  * 100) ;

if (( percetage86  <= failed86 )&&( percetage86 >= totallyfailed86)){ 
  p86 = "Failed";  
}else if (( percetage86 <=passed86 )&&( percetage86 >= pass86 )   ){ 
  p86 = "Pass";  
}  else if (( percetage86  <= avaerage86 )&&(  percetage86  >= avaerage_end86 ))
{ 
 p86 = "Avaerage"; 
} 
else if ((  percetage86  <=good86 )&&(  percetage86  >= good_end86 ) )
{ 
 p86 ="Good"; 
 }else if ((  percetage86 <= very_good86 )&&( percetage86 >= very_good_end86 ))
 {
  p86  = "Very Good";    
 }else if (( percetage86 <=     Excellent86 )&&( percetage86  >= very_good86 )   )
 {
  p86 = "Excellent";  
 
  }  
            

pps7.setDouble( 855,  percetage86 );                                             
pps7.setDate(   856 , sqldate); 
pps7.setString( 857 , class_teacher_class);
pps7.setString( 858, Term);
pps7.setString( 859 , p86 );//inserting cmements by stude
pps7.setString( 860, System_ID.getText().trim());





 
 
pps7.setString( 861 ,Sn87  .getText().trim());//student name
 pps7.setString(  862 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 863 ,R87 .getText().trim());// marks_obtained 
pps7.setString( 864 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained87 = Double.parseDouble(R87.getText().trim()); 

double converted_total_marks87 = Double.parseDouble(total_marks.getText().trim());

int percetage87 =(int)(converted_marks_obtained87  / converted_total_marks87  * 100) ;

if (( percetage87  <= failed87 )&&( percetage87 >= totallyfailed87)){ 
  p87 = "Failed";  
}else if (( percetage87 <=passed87 )&&( percetage87 >= pass87 )   ){ 
  p87 = "Pass";  
}  else if (( percetage87  <= avaerage87 )&&(  percetage87  >= avaerage_end87 ))
{ 
 p87 = "Avaerage"; 
} 
else if ((  percetage87  <=good87 )&&(  percetage87  >= good_end87 ) )
{ 
 p85 ="Good"; 
 }else if ((  percetage87 <= very_good87 )&&( percetage87 >= very_good_end87 ))
 {
  p85  = "Very Good";    
 }else if (( percetage87 <=     Excellent87 )&&( percetage87  >= very_good87 )   )
 {
  p85 = "Excellent";  
 
  }  
            
pps7.setDouble( 865,  percetage87 );                                             
pps7.setDate(  866 , sqldate); 
pps7.setString(  867 , class_teacher_class);
pps7.setString(  868, Term);
pps7.setString(  869 , p87 );//inserting cmements by stude
pps7.setString( 870, System_ID.getText().trim());


pps7.setString( 871 ,Sn88 .getText().trim());//student name
 pps7.setString(  872 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 873 ,R88 .getText().trim());// marks_obtained 
pps7.setString( 874 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained88 = Double.parseDouble(R88.getText().trim()); 

double converted_total_marks88 = Double.parseDouble(total_marks.getText().trim());

int percetage88 =(int)(converted_marks_obtained88  / converted_total_marks88  * 100) ;

if (( percetage88  <= failed88 )&&( percetage88 >= totallyfailed88)){ 
  p88 = "Failed";  
}else if (( percetage88 <=passed88 )&&( percetage88 >= pass88 )   ){ 
  p88 = "Pass";  
}  else if (( percetage88  <= avaerage88 )&&(  percetage88  >= avaerage_end88 ))
{ 
 p88 = "Avaerage"; 
} 
else if ((  percetage88  <=good88 )&&(  percetage88 >= good_end88 ) )
{ 
 p88 ="Good"; 
 }else if ((  percetage88 <= very_good88 )&&( percetage88 >= very_good_end88 ))
 {
  p88  = "Very Good";    
 }else if (( percetage88 <=     Excellent88 )&&( percetage88  >= very_good88 )   )
 {
  p88 = "Excellent";  
 
  }  
            
pps7.setDouble( 875,  percetage88);                                             
pps7.setDate(  876 , sqldate); 
pps7.setString(  877 , class_teacher_class);
pps7.setString(  878, Term);
pps7.setString(  879 , p88 );//inserting cmements by stude
pps7.setString( 880, System_ID.getText().trim());


pps7.setString( 881 ,Sn89 .getText().trim());//student name
 pps7.setString( 882 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 883 ,R89 .getText().trim());// marks_obtained 
pps7.setString( 884 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained89 = Double.parseDouble(R89.getText().trim()); 

double converted_total_marks89 = Double.parseDouble(total_marks.getText().trim());

int percetage89 =(int)(converted_marks_obtained89  / converted_total_marks89  * 100) ;

if (( percetage89  <= failed89 )&&( percetage89 >= totallyfailed89)){ 
  p89 = "Failed";  
}else if (( percetage89 <=passed89 )&&( percetage89 >= pass89 )   ){ 
  p89 = "Pass";  
}  else if (( percetage89  <= avaerage89 )&&(  percetage89  >= avaerage_end89 ))
{ 
 p89 = "Avaerage"; 
} 
else if ((  percetage89  <=good89 )&&(  percetage89  >= good_end89 ) )
{ 
 p89 ="Good"; 
 }else if ((  percetage89 <= very_good89 )&&( percetage89 >= very_good_end89 ))
 {
  p89 = "Very Good";    
 }else if (( percetage89 <=     Excellent89 )&&( percetage89  >= very_good89 )   )
 {
  p89 = "Excellent";  
 
  }  
            
pps7.setDouble( 885,  percetage89 );                                             
pps7.setDate(  886 , sqldate); 
pps7.setString(  887 , class_teacher_class);
pps7.setString(  888, Term);
pps7.setString(  889 , p89 );//inserting cmements by stude
pps7.setString( 890, System_ID.getText().trim());


pps7.setString( 891 ,Sn90 .getText().trim());//student name
 pps7.setString(  892 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 893 ,R90 .getText().trim());// marks_obtained 
pps7.setString( 894 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained90 = Double.parseDouble(R90.getText().trim()); 

double converted_total_marks90 = Double.parseDouble(total_marks.getText().trim());

int percetage90 =(int)(converted_marks_obtained90  / converted_total_marks90  * 100) ;

if (( percetage90  <= failed90 )&&( percetage90>= totallyfailed90)){ 
  p90 = "Failed";  
}else if (( percetage90 <=passed90 )&&( percetage90 >= pass90)   ){ 
  p90 = "Pass";  
}  else if (( percetage90  <= avaerage90 )&&(  percetage90 >= avaerage_end90 ))
{ 
 p90 = "Avaerage"; 
} 
else if ((  percetage90  <=good90 )&&(  percetage90 >= good_end90 ) )
{ 
 p90 ="Good"; 
 }else if ((  percetage90 <= very_good90)&&( percetage90 >= very_good_end90 ))
 {
  p90  = "Very Good";    
 }else if (( percetage90 <=     Excellent90 )&&( percetage90  >= very_good90 )   )
 {
  p90 = "Excellent";  
 
  }  
            
pps7.setDouble( 895,  percetage90);                                             
pps7.setDate(  896 , sqldate); 
pps7.setString(  897 , class_teacher_class);
pps7.setString(  898, Term);
pps7.setString(  899 , p90 );//inserting cmements by stude
pps7.setString( 900, System_ID.getText().trim());


pps7.setString( 901 ,Sn91 .getText().trim());//student name
 pps7.setString(  902 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 903 ,R91 .getText().trim());// marks_obtained 
pps7.setString( 904 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained91 = Double.parseDouble(R91.getText().trim()); 

double converted_total_marks91 = Double.parseDouble(total_marks.getText().trim());

int percetage91 =(int)(converted_marks_obtained91  / converted_total_marks91  * 100) ;

if (( percetage91  <= failed91 )&&( percetage91 >= totallyfailed91)){ 
  p91 = "Failed";  
}else if (( percetage91 <=passed91 )&&( percetage91 >= pass91 )   ){ 
  p91 = "Pass";  
}  else if (( percetage91  <= avaerage91 )&&(  percetage91  >= avaerage_end91 ))
{ 
 p91 = "Avaerage"; 
} 
else if ((  percetage91  <=good91 )&&(  percetage91  >= good_end91 ) )
{ 
 p91 ="Good"; 
 }else if ((  percetage91 <= very_good91)&&( percetage91 >= very_good_end91 ))
 {
  p91  = "Very Good";    
 }else if (( percetage91 <=     Excellent91 )&&( percetage91  >= very_good91)   )
 {
  p91 = "Excellent";  
 
  }  
            
pps7.setDouble( 905,  percetage91 );                                             
pps7.setDate(  906 , sqldate); 
pps7.setString(  907 , class_teacher_class);
pps7.setString(  908, Term);
pps7.setString(  909 , p91 );//inserting cmements by stude
pps7.setString( 910, System_ID.getText().trim());


pps7.setString( 911 ,Sn92 .getText().trim());//student name
 pps7.setString(  912 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 913 ,R92 .getText().trim());// marks_obtained 
pps7.setString( 914 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained92 = Double.parseDouble(R92.getText().trim()); 

double converted_total_marks92 = Double.parseDouble(total_marks.getText().trim());

int percetage92 =(int)(converted_marks_obtained92  / converted_total_marks92  * 100) ;

if (( percetage92  <= failed92 )&&( percetage92>= totallyfailed92)){ 
  p92 = "Failed";  
}else if (( percetage92 <=passed92)&&( percetage92>= pass92)   ){ 
  p92 = "Pass";  
}  else if (( percetage92  <= avaerage92 )&&(  percetage92 >= avaerage_end92 ))
{ 
 p92 = "Avaerage"; 
} 
else if ((  percetage92  <=good92 )&&(  percetage92  >= good_end92 ) )
{ 
 p92 ="Good"; 
 }else if ((  percetage92 <= very_good92 )&&( percetage85 >= very_good_end92 ))
 {
  p92  = "Very Good";    
 }else if (( percetage92 <=     Excellent92 )&&( percetage92  >= very_good92 )   )
 {
  p92 = "Excellent";  
 
  }  
            
pps7.setDouble( 915,  percetage92 );                                             
pps7.setDate(  916 , sqldate); 
pps7.setString(  917 , class_teacher_class);
pps7.setString(  918, Term);
pps7.setString(  919 , p92 );//inserting cmements by stude
pps7.setString( 920, System_ID.getText().trim());




pps7.setString( 921 ,Sn93 .getText().trim());//student name
 pps7.setString(  922 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 923 ,R93 .getText().trim());// marks_obtained 
pps7.setString( 924 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained93 = Double.parseDouble(R93.getText().trim()); 

double converted_total_marks93 = Double.parseDouble(total_marks.getText().trim());

int percetage93 =(int)(converted_marks_obtained93  / converted_total_marks93  * 100) ;

if (( percetage93  <= failed93 )&&( percetage93 >= totallyfailed93)){ 
  p93 = "Failed";  
}else if (( percetage93 <=passed93 )&&( percetage93 >= pass93 )   ){ 
  p93 = "Pass";  
}  else if (( percetage93  <= avaerage93 )&&(  percetage93  >= avaerage_end93 ))
{ 
 p93 = "Avaerage"; 
} 
else if ((  percetage93  <=good93 )&&(  percetage93  >= good_end93 ) )
{ 
 p93 ="Good"; 
 }else if ((  percetage93 <= very_good93 )&&( percetage93 >= very_good_end93 ))
 {
  p93  = "Very Good";    
 }else if (( percetage93  <=     Excellent93 )&&( percetage93  >= very_good93 )   )
 {
  p93 = "Excellent";  
 
  }  
            
pps7.setDouble( 925,  percetage93 );                                             
pps7.setDate(  926 , sqldate); 
pps7.setString(  927 , class_teacher_class);
pps7.setString(  928, Term);
pps7.setString(  929 , p93 );//inserting cmements by stude
pps7.setString( 930, System_ID.getText().trim());


pps7.setString( 931 ,Sn94 .getText().trim());//student name
 pps7.setString(  932 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 933 ,R94 .getText().trim());// marks_obtained 
pps7.setString( 934 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained94 = Double.parseDouble(R94.getText().trim()); 

double converted_total_marks94 = Double.parseDouble(total_marks.getText().trim());

int percetage94 =(int)(converted_marks_obtained94  / converted_total_marks94  * 100) ;

if (( percetage94  <= failed94 )&&( percetage94 >= totallyfailed94)){ 
  p94 = "Failed";  
}else if (( percetage94 <=passed94 )&&( percetage94 >= pass94 )   ){ 
  p94 = "Pass";  
}  else if (( percetage94  <= avaerage94)&&(  percetage94  >= avaerage_end94 ))
{ 
 p94 = "Avaerage"; 
} 
else if ((  percetage94  <=good94)&&(  percetage94  >= good_end94 ) )
{ 
 p94 ="Good"; 
 }else if ((  percetage94 <= very_good94 )&&( percetage94 >= very_good_end94 ))
 {
  p94  = "Very Good";    
 }else if (( percetage94 <=     Excellent94 )&&( percetage94  >= very_good94 )   )
 {
  p94 = "Excellent";  
 
  }  
            
pps7.setDouble( 935,  percetage94 );                                             
pps7.setDate(  936 , sqldate); 
pps7.setString(  937 , class_teacher_class);
pps7.setString(  938, Term);
pps7.setString(  939 , p94 );//inserting cmements by stude
pps7.setString( 940, System_ID.getText().trim());


pps7.setString( 941 ,Sn95 .getText().trim());//student name
 pps7.setString(  942 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 943 ,R95 .getText().trim());// marks_obtained 
pps7.setString( 944 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained95 = Double.parseDouble(R95.getText().trim()); 

double converted_total_marks95 = Double.parseDouble(total_marks.getText().trim());

int percetage95 =(int)(converted_marks_obtained95  / converted_total_marks95  * 100) ;

if (( percetage95  <= failed95 )&&( percetage95 >= totallyfailed95)){ 
  p95 = "Failed";  
}else if (( percetage95 <=passed95 )&&( percetage95 >= pass95 )   ){ 
  p95 = "Pass";  
}  else if (( percetage95  <= avaerage95 )&&(  percetage95  >= avaerage_end95 ))
{ 
 p95 = "Avaerage"; 
} 
else if ((  percetage95  <=good95 )&&(  percetage95  >= good_end95 ) )
{ 
 p95 ="Good"; 
 }else if ((  percetage95 <= very_good95 )&&( percetage95 >= very_good_end95 ))
 {
  p95  = "Very Good";    
 }else if (( percetage95 <=     Excellent95 )&&( percetage95  >= very_good95 )   )
 {
  p95 = "Excellent";  
 
  }  
            
pps7.setDouble( 945,  percetage95 );                                             
pps7.setDate(  946 , sqldate); 
pps7.setString(  947 , class_teacher_class);
pps7.setString(  948, Term);
pps7.setString(  949 , p95 );//inserting cmements by stude
pps7.setString( 950, System_ID.getText().trim());




pps7.setString( 951 ,Sn96 .getText().trim());//student name
 pps7.setString(  952 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 953 ,R96 .getText().trim());// marks_obtained 
pps7.setString( 954 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained96 = Double.parseDouble(R96.getText().trim()); 

double converted_total_marks96 = Double.parseDouble(total_marks.getText().trim());

int percetage96 =(int)(converted_marks_obtained96  / converted_total_marks96  * 100) ;

if (( percetage96  <= failed96 )&&( percetage95 >= totallyfailed96)){ 
  p96 = "Failed";  
}else if (( percetage96 <=passed96 )&&( percetage96 >= pass96 )   ){ 
  p96 = "Pass";  
}  else if (( percetage96  <= avaerage96 )&&(  percetage96  >= avaerage_end96 ))
{ 
 p96 = "Avaerage"; 
} 
else if ((  percetage96  <=good96)&&(  percetage96  >= good_end96 ) )
{ 
 p96 ="Good"; 
 }else if ((  percetage96 <= very_good96)&&( percetage96 >= very_good_end96 ))
 {
  p96  = "Very Good";    
 }else if (( percetage96 <=     Excellent96)&&( percetage96  >= very_good96)   )
 {
  p96 = "Excellent";  
 
  }  
            
pps7.setDouble( 955,  percetage96 );                                             
pps7.setDate(  956 , sqldate); 
pps7.setString(  957 , class_teacher_class);
pps7.setString(  958, Term);
pps7.setString(  959 , p96);//inserting cmements by stude
pps7.setString( 960, System_ID.getText().trim());



pps7.setString( 961 ,Sn97 .getText().trim());//student name
 pps7.setString(  962 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 963 ,R97 .getText().trim());// marks_obtained 
pps7.setString( 964 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained97 = Double.parseDouble(R95.getText().trim()); 

double converted_total_marks97 = Double.parseDouble(total_marks.getText().trim());

int percetage97 =(int)(converted_marks_obtained97  / converted_total_marks95  * 100) ;

if (( percetage97  <= failed97 )&&( percetage97 >= totallyfailed97)){ 
  p97 = "Failed";  
}else if (( percetage97 <=passed97)&&( percetage97 >= pass97)   ){ 
  p97 = "Pass";  
}  else if (( percetage97  <= avaerage97 )&&(  percetage97  >= avaerage_end97 ))
{ 
 p97 = "Avaerage"; 
} 
else if ((  percetage97 <=good97 )&&(  percetage97  >= good_end97 ) )
{ 
 p97 ="Good"; 
 }else if ((  percetage97 <= very_good97 )&&( percetage97 >= very_good_end97 ))
 {
  p97  = "Very Good";    
 }else if (( percetage97 <=     Excellent97 )&&( percetage97  >= very_good97)   )
 {
  p97 = "Excellent";  
 
  }  
            
pps7.setDouble( 965,  percetage97);                                             
pps7.setDate(  966 , sqldate); 
pps7.setString(  967 , class_teacher_class);
pps7.setString(  968, Term);
pps7.setString(  969 , p97 );//inserting cmements by stude
pps7.setString( 970, System_ID.getText().trim());


pps7.setString( 971 ,Sn98 .getText().trim());//student name
 pps7.setString(  972 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 973 ,R98 .getText().trim());// marks_obtained 
pps7.setString( 974 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained98 = Double.parseDouble(R98.getText().trim()); 

double converted_total_marks98 = Double.parseDouble(total_marks.getText().trim());

int percetage98 =(int)(converted_marks_obtained98  / converted_total_marks98  * 100) ;

if (( percetage98  <= failed98)&&( percetage98 >= totallyfailed98)){ 
  p98 = "Failed";  
}else if (( percetage98 <=passed98 )&&( percetage98 >= pass98 )   ){ 
  p98 = "Pass";  
}  else if (( percetage98  <= avaerage98 )&&(  percetage98  >= avaerage_end98 ))
{ 
 p98 = "Avaerage"; 
} 
else if ((  percetage98  <=good98 )&&(  percetage98  >= good_end98 ) )
{ 
 p98 ="Good"; 
 }else if ((  percetage98 <= very_good98 )&&( percetage98 >= very_good_end98 ))
 {
  p98  = "Very Good";    
 }else if (( percetage98 <=     Excellent98 )&&( percetage98  >= very_good98 )   )
 {
  p98 = "Excellent";  
 
  }  
            
pps7.setDouble( 975,  percetage98);                                             
pps7.setDate(  976 , sqldate); 
pps7.setString(  977 , class_teacher_class);
pps7.setString(  978, Term);
pps7.setString(  979 , p98 );//inserting cmements by stude
pps7.setString( 980, System_ID.getText().trim());


pps7.setString( 981 ,Sn99 .getText().trim());//student name
 pps7.setString(  982 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 983 ,R99 .getText().trim());// marks_obtained 
pps7.setString( 984 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained99 = Double.parseDouble(R99.getText().trim()); 

double converted_total_marks99 = Double.parseDouble(total_marks.getText().trim());

int percetage99 =(int)(converted_marks_obtained99  / converted_total_marks99  * 100) ;

if (( percetage99  <= failed99 )&&( percetage99 >= totallyfailed95)){ 
  p99 = "Failed";  
}else if (( percetage99 <=passed99 )&&( percetage99 >= pass99)   ){ 
  p99 = "Pass";  
}  else if (( percetage99  <= avaerage99 )&&(  percetage99  >= avaerage_end99 ))
{ 
 p99 = "Avaerage"; 
} 
else if ((  percetage99  <=good99 )&&(  percetage99  >= good_end99 ) )
{ 
 p99 ="Good"; 
 }else if ((  percetage99 <= very_good99 )&&( percetage99 >= very_good_end99 ))
 {
  p99 = "Very Good";    
 }else if (( percetage99 <=     Excellent99 )&&( percetage99  >= very_good99 )   )
 {
  p99 = "Excellent";  
 
  }  
            
pps7.setDouble( 985,  percetage99 );                                             
pps7.setDate(  986 , sqldate); 
pps7.setString(  987 , class_teacher_class);
pps7.setString(  988, Term);
pps7.setString(  989 , p99 );//inserting cmements by stude
pps7.setString( 990, System_ID.getText().trim());




pps7.setString( 991 ,Sn100 .getText().trim());//student name
 pps7.setString(  992 ,showsubjects.getSelectedItem().toString().trim()); //subjects
pps7.setString( 993 ,R100 .getText().trim());// marks_obtained 
pps7.setString( 994 ,total_marks.getText().trim());                // total_marks_  
            
double converted_marks_obtained100 = Double.parseDouble(R95.getText().trim()); 

double converted_total_marks100 = Double.parseDouble(total_marks.getText().trim());

int percetage100 =(int)(converted_marks_obtained100  / converted_total_marks100  * 100) ;

if (( percetage100  <= failed100 )&&( percetage100 >= totallyfailed100)){ 
  p100 = "Failed";  
}else if (( percetage100 <=passed100 )&&( percetage100 >= pass100 )   ){ 
  p100 = "Pass";  
}  else if (( percetage100  <= avaerage100 )&&(  percetage100  >= avaerage_end100 ))
{ 
 p100 = "Avaerage"; 
} 
else if ((  percetage100  <=good100 )&&(  percetage100  >= good_end100 ) )
{ 
 p100 ="Good"; 
 }else if ((  percetage100 <= very_good100 )&&( percetage100 >= very_good_end100 ))
 {
  p100  = "Very Good";    
 }else if (( percetage100 <=     Excellent100)&&( percetage100  >= very_good100 )   )
 {
  p100 = "Excellent";  
 
  }  
            

pps7.setDouble( 995,  percetage100 );                                             
pps7.setDate(  996 , sqldate); 
pps7.setString(  997 , class_teacher_class);
pps7.setString(  998, Term);
pps7.setString(  999 , p100 );//inserting cmements by stude
pps7.setString( 1000, System_ID.getText().trim());
 
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             
             pps7.executeUpdate();
             
             
             
             
                   

             JOptionPane.showMessageDialog(null, "GRADE   " + class_teacher_class +"   RESULTS RECORDED ");
             
        } catch (SQLException ex) {
              
        }
        clean_student_results();
       Toshow_all_student_whoWrote_theExam();
    
    }
    
    
     public void Toshow_all_student_whoWrote_theExam(){
           
             Date date =jDateChooser1.getDate();
             java.sql.Date sqldate = new java.sql.Date(date.getTime());
           
           
           //USING THE CLASS THE TEACHERS HANDLS TO CALL ALL STUDENTS IN THAT CLASS   student_register
           try {conn = DBConnection.getConnction();
            pps4= conn.prepareStatement("SELECT  * FROM  student_resuits WHERE Class =? AND day_time =?  ");
            pps4.setString(1,class_teacher_class.trim()); 
             pps4.setDate(2,sqldate); 
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
                     
                    pps4.close();
                    rs4.close();
                    conn.close();
                    
                }
            
            
            } catch (SQLException ex) {   }
           
         
           
           
               insert_register();
           
            
              
            
       }
    
     
    
    public void insert_register(){
        
        
    //INSERTING MUITIPLY DATA         Student_class         
        try {
            
            Date date =jDateChooser1.getDate();
            java.sql.Date sqldate = new java.sql.Date(date.getTime());
            String Attaindence_state = "Present";
            
            conn = DBConnection.getConnction();
             pps7= conn.prepareStatement("INSERT INTO  student_register (full_name,attendency,day_time,Class, Class_Teacher)"  
             + " VALUES (?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?) ,(?,?,?,?,?) , (?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?) ,(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?), (?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?)"
                    + ",(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?) ,(?,?,?,?,?) , (?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?) ,(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?), (?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),"
                     + "(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?) ,(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?)   ,(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?), (?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?), "
                     + "(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?) ,(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?)   ,(?,?,?,?,?), (?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),"
                     + "(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?)   ,(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?)   ,(?,?,?,?,?), (?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?),(?,?,?,?,?)");
             
             pps7.setString(1 , Sn1.getText());                               //  1
             pps7.setString(2 , Attaindence_state);  
             pps7.setDate(3 ,   sqldate);
             pps7.setString(4 , class_teacher_class);
             pps7.setString(5 , System_ID.getText());
                
              pps7.setString(6 , Sn2.getText());                               //  2
              pps7.setString(7 , Attaindence_state);  //37
              pps7.setDate(8 , sqldate);
              pps7.setString(9, class_teacher_class);
              pps7.setString(10, System_ID.getText());
              
              pps7.setString(11 ,  Sn3.getText());                             //  3
              pps7.setString(12 ,  Attaindence_state);
              pps7.setDate(13 , sqldate);
              pps7.setString(14 , class_teacher_class);
              pps7.setString(15 , System_ID.getText());
              
              pps7.setString(16 , Sn4.getText());                                      //  4 
              pps7.setString(17 , Attaindence_state);
              pps7.setDate(18 , sqldate);
              pps7.setString(19 , class_teacher_class);
             pps7.setString( 20, System_ID.getText());
              
               pps7.setString(21 , Sn5.getText());                                      //  5
               pps7.setString(22 ,Attaindence_state);
               pps7.setDate(23 , sqldate);
               pps7.setString(24 , class_teacher_class);
               pps7.setString(25 , System_ID.getText());
               
              pps7.setString(26 , Sn6.getText());                                         //  6    
               pps7.setString(27 ,Attaindence_state);
               pps7.setDate(28 , sqldate);
               pps7.setString(29 , class_teacher_class);
               pps7.setString(30 , System_ID.getText());
               
               
               
               
               pps7.setString(31 , Sn7.getText());                                      //  7
               pps7.setString(32 ,Attaindence_state);
               pps7.setDate(33 , sqldate);
               pps7.setString(34 , class_teacher_class);
               pps7.setString(35 , System_ID.getText());
               
                pps7.setString(36 , Sn8.getText());                                     //  8
               pps7.setString(37 ,Attaindence_state);
               pps7.setDate(38 , sqldate);
               pps7.setString(39 , class_teacher_class);
               pps7.setString(40 , System_ID.getText());
               
                pps7.setString(41 , Sn9.getText());                                     //  9
               pps7.setString(42 ,Attaindence_state);
               pps7.setDate(43 , sqldate);
               pps7.setString(44 , class_teacher_class);
             pps7.setString(45 , System_ID.getText());
               
                pps7.setString(46 , Sn10.getText());                                    //  10
               pps7.setString(47 ,Attaindence_state);
               pps7.setDate(48 , sqldate);
               pps7.setString(49 , class_teacher_class);
             pps7.setString(50 , System_ID.getText());
               
               
                pps7.setString(51 , Sn11.getText());                                    //  11
               pps7.setString(52 ,Attaindence_state);
               pps7.setDate(53 , sqldate);
               pps7.setString(54 , class_teacher_class);
             pps7.setString(55 , System_ID.getText());
               
                pps7.setString(56 , Sn12.getText());                                     //  12
               pps7.setString(57 ,Attaindence_state);
               pps7.setDate(58 , sqldate);
               pps7.setString(59 , class_teacher_class);
             pps7.setString(60 , System_ID.getText());
               
                pps7.setString(61 , Sn13.getText());                                      //  13
               pps7.setString(62 ,Attaindence_state);
               pps7.setDate(63 , sqldate);
               pps7.setString(64 , class_teacher_class);
             pps7.setString(65 , System_ID.getText());
               
               
                pps7.setString(66 , Sn14.getText());                                       //  14 
               pps7.setString(67 ,Attaindence_state);
               pps7.setDate(68 , sqldate);
               pps7.setString(69 , class_teacher_class);
                pps7.setString(70 , System_ID.getText());
               
                pps7.setString(71 , Sn15.getText());                                       //  15
               pps7.setString(72 ,Attaindence_state);
               pps7.setDate(73 , sqldate);
               pps7.setString(74 , class_teacher_class);
             pps7.setString(75 , System_ID.getText());
               
                pps7.setString(76 , Sn16.getText());                                        //  16 
               pps7.setString(77 ,Attaindence_state);
               pps7.setDate(78 , sqldate);
               pps7.setString(79 , class_teacher_class);
               pps7.setString(80 , System_ID.getText());
               
                pps7.setString(81 , Sn17.getText());                                        //  17
               pps7.setString(82 ,Attaindence_state);
               pps7.setDate(83 , sqldate);
               pps7.setString(84 , class_teacher_class);
             pps7.setString(85 , System_ID.getText());
               
                pps7.setString(86 , Sn18.getText());                                        //  18
               pps7.setString(87 ,Attaindence_state);
               pps7.setDate(88 , sqldate);
               pps7.setString(89 , class_teacher_class);
             pps7.setString(90 , System_ID.getText());
               
                pps7.setString(91 , Sn19.getText());                                         //  19
               pps7.setString(92 ,Attaindence_state);
               pps7.setDate(93 , sqldate);
               pps7.setString(94 , class_teacher_class);
             pps7.setString(95 , System_ID.getText());
               
                pps7.setString(96 , Sn20.getText());                                          //  20
               pps7.setString(97 ,Attaindence_state);
               pps7.setDate(98 , sqldate);
               pps7.setString(99 , class_teacher_class);
               pps7.setString(100 , System_ID.getText());
             
               
               pps7.setString(101 , Sn21.getText());                                        //  21
                pps7.setString(102 ,Attaindence_state);
               pps7.setDate(103 , sqldate);
               pps7.setString(104 , class_teacher_class);
               pps7.setString(105 , System_ID.getText()); 
               

                pps7.setString(106 , Sn22.getText());                                     //  22
               pps7.setString(107 ,Attaindence_state);
               pps7.setDate(108 , sqldate);
               pps7.setString(109 , class_teacher_class);
               pps7.setString(110  , System_ID.getText());
               
               pps7.setString(111  , Sn23.getText());                                    //  23   
               pps7.setString(112  ,Attaindence_state);
               pps7.setDate(113  , sqldate);
               pps7.setString(114  , class_teacher_class);
               pps7.setString(115  , System_ID.getText());
               
               pps7.setString(116  , Sn24.getText());                                    //  24
               pps7.setString(117  ,Attaindence_state);
               pps7.setDate(118  , sqldate);
               pps7.setString(119  , class_teacher_class);
               pps7.setString(120  , System_ID.getText());
               
               pps7.setString(121  , Sn25.getText());                                     //  25
               pps7.setString(122  ,Attaindence_state);
               pps7.setDate(123  , sqldate);
               pps7.setString(124  , class_teacher_class);
               pps7.setString(125  , System_ID.getText());
               
               pps7.setString(126  , Sn26.getText());                                      //  26  
               pps7.setString(127  ,Attaindence_state);
               pps7.setDate(128  , sqldate);
               pps7.setString(129  , class_teacher_class);
               pps7.setString(130  , System_ID.getText());
               
               
               
                
             pps7.setString(131  , Sn27.getText());                                      //  27
               pps7.setString(132  ,Attaindence_state);
               pps7.setDate(133  , sqldate);
               pps7.setString(134  , class_teacher_class);
               pps7.setString(135  , System_ID.getText());
               
                pps7.setString(136  , Sn28.getText());                                   //  28 
               pps7.setString(137  ,Attaindence_state);
               pps7.setDate(138  , sqldate);
               pps7.setString(139  , class_teacher_class);
               pps7.setString(140  , System_ID.getText());
               
                pps7.setString(141  , Sn29.getText());                                   //  29
               pps7.setString(142  ,Attaindence_state);
               pps7.setDate(143  , sqldate);
               pps7.setString(144  , class_teacher_class);
               pps7.setString(145  , Recieved_user_id);
               
                pps7.setString(146  , Sn30.getText());                                    //  30
               pps7.setString(147  ,Attaindence_state);
               pps7.setDate(148  , sqldate);
               pps7.setString(149  , class_teacher_class);
               pps7.setString(150  , System_ID.getText());
               
               
                pps7.setString(151  , Sn31.getText());                                    //  31
               pps7.setString(152  ,Attaindence_state);
               pps7.setDate(153  , sqldate);
               pps7.setString(154  , class_teacher_class);
               pps7.setString(155  , System_ID.getText());
               
                pps7.setString(156  , Sn32.getText());                                   //  32
               pps7.setString(157  ,Attaindence_state);
               pps7.setDate(158  , sqldate);
               pps7.setString(159  , class_teacher_class);
               pps7.setString(160  , System_ID.getText());
               
                pps7.setString(161  , Sn33.getText());  //  33
               pps7.setString(162  ,Attaindence_state);
               pps7.setDate(163  , sqldate);
               pps7.setString(164  , class_teacher_class);
               pps7.setString(165  , System_ID.getText());
               
               pps7.setString(166  , Sn34.getText());         //  34  
               pps7.setString(167  ,Attaindence_state);
               pps7.setDate(168  , sqldate);
               pps7.setString(169  , class_teacher_class);
               pps7.setString(170  , System_ID.getText());
               
               pps7.setString(171  , Sn35.getText());        //  35
               pps7.setString(172  ,Attaindence_state);
               pps7.setDate(173  , sqldate);
               pps7.setString(174  , class_teacher_class);
               pps7.setString(175  , System_ID.getText());
               
               pps7.setString(176  , Sn36.getText());         //  36
               pps7.setString(177  ,Attaindence_state);
               pps7.setDate(178  , sqldate);
               pps7.setString(179  , class_teacher_class);
               pps7.setString(180  , System_ID.getText());
               
               pps7.setString(181  , Sn37.getText());           //  37
               pps7.setString(182  ,Attaindence_state);
               pps7.setDate(183  ,  sqldate);
               pps7.setString(184  , class_teacher_class);
               pps7.setString(185  , System_ID.getText());
               
               pps7.setString(186  , Sn38.getText());  
               pps7.setString(187  ,Attaindence_state);
               pps7.setDate(188  , sqldate);
               pps7.setString(189  , class_teacher_class);
               pps7.setString(190  , System_ID.getText());
               
                pps7.setString(191  , Sn39.getText());  
               pps7.setString(192  ,Attaindence_state);
               pps7.setDate(193  , sqldate);
               pps7.setString(194  , class_teacher_class);
              pps7.setString(195  , System_ID.getText());  
               
                pps7.setString(196  , Sn40.getText());  
               pps7.setString(197   ,Attaindence_state);
               pps7.setDate(198  , sqldate);
               pps7.setString(199  , class_teacher_class);
               pps7.setString(200  , System_ID.getText());
               
                pps7.setString(201   , Sn41.getText());  
               pps7.setString( 202 ,Attaindence_state);
               pps7.setDate(  203, sqldate);
               pps7.setString(  204, class_teacher_class);
             pps7.setString(  205, System_ID.getText());

               pps7.setString(  206, Sn42.getText());  
               pps7.setString(  207,Attaindence_state);
               pps7.setDate( 208 , sqldate);
               pps7.setString(  209, class_teacher_class);
             pps7.setString(  210, System_ID.getText());
             
               
               pps7.setString( 211, Sn43.getText()); 
               pps7.setString(  212,Attaindence_state);
               pps7.setDate(  213, sqldate);
               pps7.setString(  214, class_teacher_class);
               pps7.setString(  215, System_ID.getText());
               
                pps7.setString(  216, Sn44.getText());  
               pps7.setString(  217,Attaindence_state);
               pps7.setDate(  218, sqldate);
               pps7.setString(  219, class_teacher_class);
             pps7.setString(  220, System_ID.getText());
               
               pps7.setString(  221, Sn45.getText());  
               pps7.setString( 222 ,Attaindence_state);
               pps7.setDate(  223, sqldate);
               pps7.setString(  224, class_teacher_class);
             pps7.setString(  225, System_ID.getText());
               
               pps7.setString(  226, Sn46.getText());  
               pps7.setString(  227,Attaindence_state);
               pps7.setDate(  228, sqldate);
               pps7.setString(  229, class_teacher_class);
              pps7.setString(  230, System_ID.getText());
               
               
              pps7.setString(  231, Sn47.getText());  
                pps7.setString( 232,Attaindence_state);
               pps7.setDate(   233, sqldate);
               pps7.setString(   234, class_teacher_class);
             pps7.setString(   235, System_ID.getText());
               
                   
              pps7.setString( 236, Sn48.getText());  
               pps7.setString( 237,Attaindence_state);
               pps7.setDate( 238, sqldate);
               pps7.setString( 239, class_teacher_class);
             pps7.setString( 240, System_ID.getText());
               
                pps7.setString( 241, Sn49.getText());  
               pps7.setString( 242,Attaindence_state);
               pps7.setDate( 243, sqldate);
               pps7.setString( 244, class_teacher_class);
             pps7.setString( 245, System_ID.getText());
               
                pps7.setString( 246, Sn50.getText());  
               pps7.setString( 247,Attaindence_state);
               pps7.setDate( 248, sqldate);
               pps7.setString( 249, class_teacher_class);
               pps7.setString( 250, System_ID.getText());
                      
                pps7.setString( 251, Sn51.getText());  
               pps7.setString( 252,Attaindence_state);
               pps7.setDate(  253, sqldate);
               pps7.setString( 254, class_teacher_class);
             pps7.setString( 255, System_ID.getText());
               
                pps7.setString( 256, Sn52.getText());  
               pps7.setString( 257,Attaindence_state);
               pps7.setDate( 258, sqldate);
               pps7.setString( 259, class_teacher_class);
             pps7.setString( 260, System_ID.getText());
              
                pps7.setString( 261, Sn53.getText());  
               pps7.setString( 262,Attaindence_state);
               pps7.setDate( 263, sqldate);
               pps7.setString( 264, class_teacher_class);
             pps7.setString( 265, System_ID.getText());
               
                pps7.setString( 266, Sn54.getText());  
               pps7.setString( 267,Attaindence_state);
               pps7.setDate( 268, sqldate);
               pps7.setString( 269, class_teacher_class);
                 pps7.setString( 270, System_ID.getText());
               
                pps7.setString( 271, Sn55.getText());  
               pps7.setString( 272,Attaindence_state);
               pps7.setDate( 273, sqldate);
               pps7.setString( 274, class_teacher_class);
               pps7.setString( 275, System_ID.getText());
               
                pps7.setString( 276, Sn56.getText());  
               pps7.setString( 277,Attaindence_state);
               pps7.setDate( 278, sqldate);
               pps7.setString( 279, class_teacher_class);
             pps7.setString( 280, System_ID.getText());
               
                pps7.setString( 281, Sn57.getText());  
               pps7.setString( 282,Attaindence_state);
               pps7.setDate( 283, sqldate);
               pps7.setString( 284, class_teacher_class);
              pps7.setString( 285, System_ID.getText());
               
                pps7.setString( 286, Sn58.getText());  
               pps7.setString( 287,Attaindence_state);
               pps7.setDate( 288, sqldate);
                pps7.setString( 289, class_teacher_class);
               pps7.setString( 290, System_ID.getText());
               
                pps7.setString( 291, Sn59.getText());  
               pps7.setString( 292,Attaindence_state);
               pps7.setDate( 293, sqldate);
               pps7.setString( 294, class_teacher_class);
               pps7.setString( 295, System_ID.getText());
               
                pps7.setString( 296, Sn60.getText());  
               pps7.setString( 297,Attaindence_state);
               pps7.setDate( 298, sqldate);
               pps7.setString( 299, class_teacher_class);
             pps7.setString( 300, System_ID.getText());
               
                pps7.setString( 301, Sn61.getText());  
               pps7.setString( 302,Attaindence_state);
               pps7.setDate( 303, sqldate);
               pps7.setString( 304, class_teacher_class);
               pps7.setString( 305, System_ID.getText());     
               
               pps7.setString( 306, Sn62.getText());  
               pps7.setString( 307,Attaindence_state);
               pps7.setDate( 308, sqldate);
               pps7.setString( 309, class_teacher_class);
             pps7.setString( 310, System_ID.getText());
               
               pps7.setString( 311, Sn63.getText()); 
               pps7.setString( 312,Attaindence_state);
               pps7.setDate( 313, sqldate);
               pps7.setString( 314, class_teacher_class);
             pps7.setString( 315, System_ID.getText());
             
             
              pps7.setString( 316, Sn64.getText());  
               pps7.setString( 317,Attaindence_state);
               pps7.setDate( 318, sqldate);
               pps7.setString( 319, class_teacher_class);
             pps7.setString( 320, System_ID.getText());
               
               pps7.setString( 321, Sn65.getText());  
               pps7.setString( 322,Attaindence_state);
               pps7.setDate( 323, sqldate);
               pps7.setString( 324, class_teacher_class);
             pps7.setString( 325, System_ID.getText());
               
               pps7.setString( 326, Sn66.getText()); 
               pps7.setString( 327,Attaindence_state);
               pps7.setDate( 328, sqldate);
               pps7.setString( 329, class_teacher_class);
             pps7.setString( 330, System_ID.getText());
               
               
               
                pps7.setString(331 , Sn67.getText());  
               pps7.setString(332 ,Attaindence_state);
               pps7.setDate( 333, sqldate);
               pps7.setString( 334, class_teacher_class);
             pps7.setString( 335, System_ID.getText());
               
                pps7.setString( 336, Sn68.getText());  
               pps7.setString( 337,Attaindence_state);
               pps7.setDate( 338, sqldate);
               pps7.setString( 339, class_teacher_class);
               pps7.setString( 340, System_ID.getText());
               
                pps7.setString( 341, Sn69.getText());  
               pps7.setString( 342,Attaindence_state);
               pps7.setDate( 343, sqldate);
               pps7.setString( 344, class_teacher_class);
             pps7.setString( 345, System_ID.getText());
               
                pps7.setString( 346, Sn70.getText());  
               pps7.setString( 347,Attaindence_state);
               pps7.setDate( 348, sqldate);
                pps7.setString( 349, class_teacher_class);
              pps7.setString( 350, System_ID.getText()); 
               
                pps7.setString( 351, Sn71.getText());  
               pps7.setString( 352,Attaindence_state);
               pps7.setDate( 353, sqldate);
               pps7.setString( 354, class_teacher_class);
             pps7.setString( 355, System_ID.getText());
               
                pps7.setString( 356, Sn72.getText());  
               pps7.setString( 357,Attaindence_state);
               pps7.setDate( 358, sqldate);
               pps7.setString( 359, class_teacher_class);
             pps7.setString( 360, System_ID.getText());
             
                pps7.setString( 361, Sn73.getText());  
               pps7.setString( 362,Attaindence_state);
               pps7.setDate( 363, sqldate);
               pps7.setString( 364, class_teacher_class);
             pps7.setString( 365, System_ID.getText());
               
                pps7.setString( 366, Sn74.getText());  
               pps7.setString( 367,Attaindence_state);
               pps7.setDate( 368, sqldate);
               pps7.setString( 369, class_teacher_class);
             pps7.setString( 370, System_ID.getText());
               
                pps7.setString( 371, Sn75.getText());  
               pps7.setString( 372,Attaindence_state);
               pps7.setDate( 373, sqldate);
               pps7.setString( 374, class_teacher_class);
             pps7.setString( 375, System_ID.getText());
               
                pps7.setString( 376, Sn76.getText());  
               pps7.setString( 377,Attaindence_state);
               pps7.setDate( 378, sqldate);
               pps7.setString( 379, class_teacher_class);
             pps7.setString( 380, System_ID.getText());
               
             
             
             
             
             
             
              pps7.setString( 381, Sn77.getText());  
               pps7.setString( 382,Attaindence_state);
               pps7.setDate( 383, sqldate);
               pps7.setString( 384, class_teacher_class);
             pps7.setString( 385, System_ID.getText());
               
                pps7.setString( 386, Sn78.getText());  
               pps7.setString( 387,Attaindence_state);
               pps7.setDate( 388, sqldate);
               pps7.setString( 389, class_teacher_class);
             pps7.setString( 390, System_ID.getText());
               
                pps7.setString(391, Sn79.getText());  
               pps7.setString(  392,Attaindence_state);
               pps7.setDate( 393, sqldate);
               pps7.setString(  394 , class_teacher_class);
             pps7.setString( 395, System_ID.getText());
               
                pps7.setString( 396, Sn80.getText());  
               pps7.setString( 397,Attaindence_state);
               pps7.setDate(   398, sqldate);
               pps7.setString( 399, class_teacher_class);
             pps7.setString( 400, System_ID.getText());
               
                pps7.setString( 401, Sn81.getText());  
               pps7.setString( 402,Attaindence_state);
               pps7.setDate( 403, sqldate);
               pps7.setString( 404, class_teacher_class);
               pps7.setString( 405, System_ID.getText());
               
               pps7.setString( 406, Sn82.getText());  
               pps7.setString( 407,Attaindence_state);
               pps7.setDate( 408, sqldate);
               pps7.setString( 409, class_teacher_class);
             pps7.setString( 410, System_ID.getText());
               
               pps7.setString( 411, Sn83.getText()); 
               pps7.setString( 412,Attaindence_state);
               pps7.setDate( 413, sqldate);
               pps7.setString( 414, class_teacher_class);
             pps7.setString( 415, System_ID.getText());
               
               pps7.setString( 416, Sn84.getText());  
               pps7.setString( 417,Attaindence_state);
               pps7.setDate( 418, sqldate);
               pps7.setString( 419, class_teacher_class);
             pps7.setString( 420, System_ID.getText());
               
               pps7.setString( 421, Sn85.getText());  
               pps7.setString( 422,Attaindence_state);
               pps7.setDate( 423, sqldate);
               pps7.setString( 424, class_teacher_class);
               pps7.setString( 425, System_ID.getText());
               
               pps7.setString( 426, Sn86.getText()); 
               pps7.setString( 427,Attaindence_state);
               pps7.setDate( 428, sqldate);
               pps7.setString( 429, class_teacher_class);
               pps7.setString( 430, System_ID.getText());
               
               
               
               
                pps7.setString(431 , Sn87.getText());  
               pps7.setString(432  ,Attaindence_state);
               pps7.setDate( 433, sqldate);
               
               pps7.setString( 434, class_teacher_class);
               pps7.setString( 435, System_ID.getText());
               
               pps7.setString( 436, Sn88.getText());  
               pps7.setString( 437,Attaindence_state);
               pps7.setDate( 438, sqldate);
               pps7.setString( 439, class_teacher_class);
             pps7.setString( 440 , System_ID.getText());
               
               pps7.setString( 441, Sn89.getText());  
               pps7.setString( 442,Attaindence_state);
               pps7.setDate( 443, sqldate);
               pps7.setString( 444, class_teacher_class);
             pps7.setString( 445, System_ID.getText());
               
               pps7.setString( 446, Sn90.getText());  
               pps7.setString( 447,Attaindence_state);
               pps7.setDate( 448, sqldate);
                 pps7.setString( 449, class_teacher_class);
             pps7.setString( 450, System_ID.getText());     
               
                pps7.setString( 451, Sn91.getText());  
                pps7.setString( 452,Attaindence_state);
                pps7.setDate( 453 , sqldate);
               pps7.setString( 454, class_teacher_class);
             pps7.setString( 455, System_ID.getText());
             
             
               pps7.setString( 456, Sn92.getText());  
                pps7.setString( 457,Attaindence_state);
                pps7.setDate( 458, sqldate);
               pps7.setString( 459, class_teacher_class);
                pps7.setString( 460, System_ID.getText());
                
                pps7.setString( 461, Sn93.getText());  
                pps7.setString( 462,Attaindence_state);
                pps7.setDate( 463 , sqldate);
               pps7.setString( 464, class_teacher_class);
                pps7.setString( 465, System_ID.getText());
                
                pps7.setString( 466, Sn94.getText());  
               pps7.setString( 467,Attaindence_state);
               pps7.setDate( 468, sqldate);
               pps7.setString( 469, class_teacher_class);
               pps7.setString( 470, System_ID.getText());
               
                pps7.setString( 471, Sn95.getText());  
               pps7.setString( 472,Attaindence_state);
               pps7.setDate( 473, sqldate);
               pps7.setString( 474, class_teacher_class);
             pps7.setString( 475, System_ID.getText());
               
                pps7.setString( 476, Sn96.getText());  
               pps7.setString( 477,Attaindence_state);
               pps7.setDate( 478, sqldate);
               pps7.setString( 479, class_teacher_class);
             pps7.setString( 480, System_ID.getText());
               
                pps7.setString( 481, Sn97.getText());  
               pps7.setString( 482,Attaindence_state);
               pps7.setDate( 483, sqldate);
               pps7.setString( 484, class_teacher_class);
               pps7.setString( 485, System_ID.getText());
               
                pps7.setString( 486, Sn98.getText());  
               pps7.setString( 487,Attaindence_state);
               pps7.setDate( 488, sqldate);
               pps7.setString( 489, class_teacher_class);
                pps7.setString( 490, System_ID.getText());
             
                pps7.setString( 491, Sn99.getText());  
               pps7.setString( 492,Attaindence_state);
               pps7.setDate( 493, sqldate);
               pps7.setString( 494 , class_teacher_class);
               pps7.setString( 495, System_ID.getText());
               
                pps7.setString( 496, Sn100.getText());  
               pps7.setString( 497,Attaindence_state);
               pps7.setDate( 498, sqldate);
               pps7.setString( 499, class_teacher_class);
               pps7.setString(500, System_ID.getText());
               
                pps7.setString(501 , Sn101.getText());  
               pps7.setString(502 ,Attaindence_state);
               pps7.setDate(503 , sqldate);
              pps7.setString(504 , class_teacher_class);
             pps7.setString(505 , System_ID.getText());
               
               pps7.setString(506 , Sn102.getText());  
               pps7.setString(507 ,Attaindence_state);
               pps7.setDate(508 , sqldate);
               pps7.setString(509 , class_teacher_class);
               pps7.setString(510 , System_ID.getText());
               
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
                
                  JOptionPane.showMessageDialog(null, "THE REGISTER HAS BEEN MARKED");
                  clean_student_register();
                  clean_Txt_after_register();
            } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, ex);
            }
    
    
    }
    
    
    public void clean_Txt_after_register(){
    
   
     R1.setText("");
     R10.setText("");
     R100.setText("");
     R101.setText("");
     R102.setText("");
     R11.setText("");
     R12.setText("");
     R13.setText("");
     R14.setText("");
   R15.setText("");
  R16.setText("");
  R17.setText("");
 R18.setText("");
   R19.setText("");
    R2.setText("");
     R20.setText("");
     R21.setText("");
    R22.setText("");
     R23.setText("");
     R24.setText("");
     R25.setText("");
     R26.setText("");
     R27.setText("");
     R28.setText("");
    R29.setText("");
     R3.setText("");
     R30.setText("");
     R31.setText("");
     R32.setText("");
     R33.setText("");
    R34.setText("");
     R35.setText("");
     R36.setText("");
     R37.setText("");
     R38.setText("");
     R39.setText("");
     R4.setText("");
    R40.setText("");
     R41.setText("");
     R42.setText("");
     R43.setText("");
     R44.setText("");
     R45.setText("");
     R46.setText("");
     R47.setText("");
     R48.setText("");
     R49.setText("");
    R5.setText("");
     R50.setText("");
     R51.setText("");
     R52.setText("");
    R53.setText("");
     R54.setText("");
     R55.setText("");
     R56.setText("");
     R57.setText("");
     R58.setText("");
     R59.setText("");
     R6.setText("");
    R60.setText("");
     R61.setText("");
     R62.setText("");
     R63.setText("");
     R64.setText("");
     R65.setText("");
    R66.setText("");
     R67.setText("");
     R68.setText("");
    R69.setText("");
     R7.setText("");
     R70.setText("");
     R71.setText("");
     R72.setText("");
     R73.setText("");
     R74.setText("");
     R75.setText("");
     R76.setText("");
     R77.setText("");
     R78.setText("");
    R79.setText("");
    R8.setText("");
     R80.setText("");
    R81.setText("");
     R82.setText("");
     R83.setText("");
     R84.setText("");
     R85.setText("");
     R86.setText("");
     R87.setText("");
     R88.setText("");
     R89.setText("");
     R9.setText("");
     R90.setText("");
    R91.setText("");
     R92.setText("");
     R93.setText("");
     R94.setText("");
     R95.setText("");
     R96.setText("");
     R97.setText("");
    R98.setText("");
    R99.setText("");
        
       
    
    }
    
    public void clean_student_register(){
    String de = "";
     try {
            conn = DBConnection.getConnction();
            pps2 = conn.prepareStatement("DELETE FROM `student_register` WHERE full_name = ?");
            pps2.setString(1, de);
            pps2.executeUpdate();
              JOptionPane.showMessageDialog(null, "REGISTER CLEARED ");
        } catch (Exception ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        };
    
    }
    
     
    public void clean_student_results(){
    String de = "";
     try {
            conn = DBConnection.getConnction();
            pps2 = conn.prepareStatement("DELETE FROM `student_resuits` WHERE Full_name = ?");
            pps2.setString(1, de);
            pps2.executeUpdate();
              JOptionPane.showMessageDialog(null, "Student Resuits CLEARED ");
        } catch (Exception ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        };
    
    }
    
    
    private void jLabel42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseClicked
              this.dispose();
              Teacher_Home_Page.getObj().setVisible(true);
    }//GEN-LAST:event_jLabel42MouseClicked

    
    
    String subject_Teacher_class = null;
    private void View_subject_inThat_ciassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_View_subject_inThat_ciassActionPerformed
       showsubjects.removeAllItems();
       
                 String level=  showclasses.getSelectedItem().toString();

                try {
                conn = DBConnection.getConnction(); //getting the subject in the seiected ciass
                String sql = "SELECT subjects.subject_name FROM subjects JOIN class_subject_joint ON subjects.subject_id = class_subject_joint.subject_id INNER JOIN classes ON classes.class_id = class_subject_joint.class_id WHERE grade_room = ? "; //AND class_level = ?
                pps2 = conn.prepareStatement(sql);
                pps2.setString(1, level);
                rs2 = pps2.executeQuery();
                while(rs2.next()){
                showsubjects.addItem(rs2.getString("subject_name"));
                }
                } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);}
        
              
          
            
              
            ///-----------------------------------------------------------------displying teachers on the table on class_assignment-----------------------------------------------------
            try {
            conn = DBConnection.getConnction();
            String sql = " SELECT employee.user_login_id, employee.name, employee.surname FROM employee JOIN class_subject_joint ON employee.user_login_id = class_subject_joint.user_login_id INNER JOIN classes ON classes.class_id = class_subject_joint.class_id WHERE grade_room = ?";
            pps8 = conn.prepareStatement(sql);
            pps8.setString(1, showclasses.getSelectedItem().toString().trim());
            rs8 = pps8.executeQuery();
            if(rs8.next()){
                subject_teacher_id = rs8.getString("user_login_id");
                 System_ID.setText(subject_teacher_id);
                 String fname=  rs8.getString("name");
                 String lname=  rs8.getString("surname");
                 jLabel12.setText(fname +"  "+lname );
                
            }
            
            } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex); } 
            clean_studentnames_feds();
            
             String dateSelected = ((JTextField) jDateChooser1.getDateEditor().getUiComponent()).getText();//conveting date to string then putting it on a resource
             txtResourceForDateFormatingINtoString.setText(dateSelected);
        
        if (txtResourceForDateFormatingINtoString.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Date of Results Entry Is required !");
            jDateChooser1.requestFocus();
      
       
       }else{
            Toshow_all_student_fromeONE_Class_frSubject_techer(); 
        }
            
           
    }//GEN-LAST:event_View_subject_inThat_ciassActionPerformed

    private void R1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_R1KeyTyped
                  
              
    }//GEN-LAST:event_R1KeyTyped

    private void R1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_R1KeyPressed
         if (evt.getKeyCode()== KeyEvent.VK_ENTER){
                
                  
                  R2.requestFocus();
                
               
        }
    }//GEN-LAST:event_R1KeyPressed

    private void R2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_R2KeyPressed
            if (evt.getKeyCode()== KeyEvent.VK_ENTER){
                 
                    R3.requestFocus();
        }
    }//GEN-LAST:event_R2KeyPressed

    private void R3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_R3KeyPressed
        if (evt.getKeyCode()== KeyEvent.VK_ENTER){
             
            
             R4.requestFocus();
        }
    }//GEN-LAST:event_R3KeyPressed
   
    
     public void Toshow_all_student_fromeONE_Class_frSubject_techer(){
           
             Date date = jDateChooser1.getDate();
             java.sql.Date sqldate = new java.sql.Date(date.getTime());
             
             class_teacher_class = showclasses.getSelectedItem().toString().trim();
           String timeLate = "Late";
           String timePresent = "Present";

           //USING THE CLASS THE TEACHERS HANDLS TO CALL ALL STUDENTS IN THAT CLASS   class_teacher_class
           try {conn = DBConnection.getConnction();
            pps4= conn.prepareStatement("SELECT  * FROM  student_register WHERE (Class =? AND day_time =?) AND (attendency =? ||  attendency =? ) ");
            pps4.setString(1,class_teacher_class.trim()); 
             pps4.setDate(2,sqldate); 
             pps4.setString(3,timeLate);
             pps4.setString(4,timePresent);
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
                     
                    pps4.close();
                    rs4.close();
                    conn.close();
                    
                }
            
            
            
                     //  
            
            
            } catch (SQLException ex) {   }
           
           
              String username =  Sn1.getText().trim();
              if(username.isEmpty()){
                   JOptionPane.showMessageDialog(null, "Un-Marked Register,  NOTE: Only Students With Results Will be Marked Present For That Day ");
                 Toshow_all_studentFrm_Studentist_AfterNt_fund_inTherRegister();
              }
              
            
       }
    
      
    public void clean_studentnames_feds(){
    
    
    Sn1.setText("");
     Sn10.setText("");
     Sn100.setText("");
    Sn101.setText("");
     Sn102.setText("");
   Sn11.setText("");
     Sn12.setText("");
     Sn13.setText("");
     Sn14.setText("");
     Sn15.setText("");
     Sn16.setText("");
     Sn17.setText("");
     Sn18.setText("");
     Sn19.setText("");
     Sn2.setText("");
     Sn20.setText("");
     Sn21.setText("");
    Sn22.setText("");
     Sn23.setText("");
     Sn24.setText("");
     Sn25.setText("");
     Sn26.setText("");
     Sn27.setText("");
     Sn28.setText("");
     Sn29.setText("");
     Sn3.setText("");
    Sn30.setText("");
    Sn31.setText("");
     Sn32.setText("");
     Sn33.setText("");
     Sn34.setText("");
     Sn35.setText("");
    Sn36.setText("");
     Sn37.setText("");
   Sn38.setText("");
     Sn39.setText("");
  Sn4.setText("");
   Sn40.setText("");
    Sn41.setText("");
    Sn42.setText("");
   Sn43.setText("");
     Sn44.setText("");
     Sn45.setText("");
    Sn46.setText("");
     Sn47.setText("");
    Sn48.setText("");
   Sn49.setText("");
   Sn5.setText("");
     Sn50.setText("");
    Sn51.setText("");
     Sn52.setText("");
     Sn53.setText("");
     Sn54.setText("");
    Sn55.setText("");
     Sn56.setText("");
     Sn57.setText("");
     Sn58.setText("");
     Sn59.setText("");
     Sn6.setText("");
     Sn60.setText("");
    Sn61.setText("");
    Sn62.setText("");
     Sn63.setText("");
     Sn64.setText("");
    Sn65.setText("");
    Sn66.setText("");
     Sn67.setText("");
     Sn68.setText("");
   Sn69.setText("");
     Sn7.setText("");
     Sn70.setText("");
    Sn71.setText("");
     Sn72.setText("");
     Sn73.setText("");
    Sn74.setText("");
    Sn75.setText("");
    Sn76.setText("");
     Sn77.setText("");
     Sn78.setText("");
     Sn79.setText("");
     Sn8.setText("");
     Sn80.setText("");
     Sn81.setText("");
     Sn82.setText("");
    Sn83.setText("");
    Sn84.setText("");
     Sn85.setText("");
     Sn86.setText("");
    Sn87.setText("");
     Sn88.setText("");
     Sn89.setText("");
     Sn9.setText("");
     Sn90.setText("");
     Sn91.setText("");
     Sn92.setText("");
     Sn93.setText("");
     Sn94.setText("");
    Sn95.setText("");
     Sn96.setText("");
     Sn97.setText("");
    Sn98.setText("");
    Sn99.setText("");
        
        
    
    
    
    }
    
    
    


    
     public static Teacher_Student_Data_Entry getObj() {  //public method for instance Restriction
        if (Obj == null) {
            Obj = new Teacher_Student_Data_Entry();
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
            java.util.logging.Logger.getLogger(Teacher_Student_Data_Entry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Teacher_Student_Data_Entry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Teacher_Student_Data_Entry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Teacher_Student_Data_Entry.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Teacher_Student_Data_Entry().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackGround_layer1;
    private javax.swing.JTextField M_Data_Chosen;
    private javax.swing.JTextField R1;
    private javax.swing.JTextField R10;
    private javax.swing.JTextField R100;
    private javax.swing.JTextField R101;
    private javax.swing.JTextField R102;
    private javax.swing.JTextField R11;
    private javax.swing.JTextField R12;
    private javax.swing.JTextField R13;
    private javax.swing.JTextField R14;
    private javax.swing.JTextField R15;
    private javax.swing.JTextField R16;
    private javax.swing.JTextField R17;
    private javax.swing.JTextField R18;
    private javax.swing.JTextField R19;
    private javax.swing.JTextField R2;
    private javax.swing.JTextField R20;
    private javax.swing.JTextField R21;
    private javax.swing.JTextField R22;
    private javax.swing.JTextField R23;
    private javax.swing.JTextField R24;
    private javax.swing.JTextField R25;
    private javax.swing.JTextField R26;
    private javax.swing.JTextField R27;
    private javax.swing.JTextField R28;
    private javax.swing.JTextField R29;
    private javax.swing.JTextField R3;
    private javax.swing.JTextField R30;
    private javax.swing.JTextField R31;
    private javax.swing.JTextField R32;
    private javax.swing.JTextField R33;
    private javax.swing.JTextField R34;
    private javax.swing.JTextField R35;
    private javax.swing.JTextField R36;
    private javax.swing.JTextField R37;
    private javax.swing.JTextField R38;
    private javax.swing.JTextField R39;
    private javax.swing.JTextField R4;
    private javax.swing.JTextField R40;
    private javax.swing.JTextField R41;
    private javax.swing.JTextField R42;
    private javax.swing.JTextField R43;
    private javax.swing.JTextField R44;
    private javax.swing.JTextField R45;
    private javax.swing.JTextField R46;
    private javax.swing.JTextField R47;
    private javax.swing.JTextField R48;
    private javax.swing.JTextField R49;
    private javax.swing.JTextField R5;
    private javax.swing.JTextField R50;
    private javax.swing.JTextField R51;
    private javax.swing.JTextField R52;
    private javax.swing.JTextField R53;
    private javax.swing.JTextField R54;
    private javax.swing.JTextField R55;
    private javax.swing.JTextField R56;
    private javax.swing.JTextField R57;
    private javax.swing.JTextField R58;
    private javax.swing.JTextField R59;
    private javax.swing.JTextField R6;
    private javax.swing.JTextField R60;
    private javax.swing.JTextField R61;
    private javax.swing.JTextField R62;
    private javax.swing.JTextField R63;
    private javax.swing.JTextField R64;
    private javax.swing.JTextField R65;
    private javax.swing.JTextField R66;
    private javax.swing.JTextField R67;
    private javax.swing.JTextField R68;
    private javax.swing.JTextField R69;
    private javax.swing.JTextField R7;
    private javax.swing.JTextField R70;
    private javax.swing.JTextField R71;
    private javax.swing.JTextField R72;
    private javax.swing.JTextField R73;
    private javax.swing.JTextField R74;
    private javax.swing.JTextField R75;
    private javax.swing.JTextField R76;
    private javax.swing.JTextField R77;
    private javax.swing.JTextField R78;
    private javax.swing.JTextField R79;
    private javax.swing.JTextField R8;
    private javax.swing.JTextField R80;
    private javax.swing.JTextField R81;
    private javax.swing.JTextField R82;
    private javax.swing.JTextField R83;
    private javax.swing.JTextField R84;
    private javax.swing.JTextField R85;
    private javax.swing.JTextField R86;
    private javax.swing.JTextField R87;
    private javax.swing.JTextField R88;
    private javax.swing.JTextField R89;
    private javax.swing.JTextField R9;
    private javax.swing.JTextField R90;
    private javax.swing.JTextField R91;
    private javax.swing.JTextField R92;
    private javax.swing.JTextField R93;
    private javax.swing.JTextField R94;
    private javax.swing.JTextField R95;
    private javax.swing.JTextField R96;
    private javax.swing.JTextField R97;
    private javax.swing.JTextField R98;
    private javax.swing.JTextField R99;
    private javax.swing.JButton Save_results_info;
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
    private javax.swing.JLabel System_ID;
    private javax.swing.JComboBox Term_chooser;
    private javax.swing.JComboBox Term_mode_chooser;
    private javax.swing.JPanel Tex_manager_lb;
    private javax.swing.JButton View_subject_inThat_ciass;
    private javax.swing.JPanel admin_btn;
    private javax.swing.JPanel building_classes_panel;
    private javax.swing.JLabel exit_lb;
    private javax.swing.JPanel frontSide_btn_holder;
    private javax.swing.JLabel header;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel37;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel minize_lb;
    private javax.swing.JLabel model;
    private javax.swing.JLabel percentage;
    private javax.swing.JPanel right;
    private javax.swing.JComboBox showclasses;
    private javax.swing.JComboBox showsubjects;
    private javax.swing.JTextField total_marks;
    private javax.swing.JTextField txtResourceForDateFormatingINtoString;
    // End of variables declaration//GEN-END:variables
}
