package hotel.management;

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Class_conf extends javax.swing.JFrame {

       Connection conn = null;
      PreparedStatement pps, pps1, pps2, pps3, pps4, pps6, pps5, pps7, pps8, pps9, pps10, pps11, pps12 ,pps13 = null;
      ResultSet rs, rs1, rs2, rs3, rs4, rs5, rs6, rs7, rs8, rs9, rs10, rs11, rs12 ,rs13= null;

    String Class_ResourceGetting_id = null;
    String insert_classromID_Class  = null;
    
    
    String get_class_id  = "none";   
    String  obtained_class_id = null;
   
    String  subject_selected   = "none";
    String  obtained_subject_id = null;
     
     
    //user access
    private static String Recieved_user_id = null;
    private static String usertype = null;
    //passing user id
    private static Class_conf Obj = null;
    String passed_user_id;
     
     
    
            int xx = 0;
            int yy = 0;
            String Search_EmployeeID = null;

        Class_conf() {
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));
        
              ComboDisplay();
             showContent_onAllTables();

       
    }

  
        
        public void ComboDisplay(){
       // /---------------------------------------------------------------floors-------------------------------  
        try {
            conn = DBConnection.getConnction();
             pps = conn.prepareStatement("SELECT * FROM rooms");
             rs = pps.executeQuery();
             while(rs.next()){
              combo_room.addItem( rs.getString("room_number"));//ROOM NUMBERS pa combo on the create room--
            }
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex); }
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
       
    }
    
    
    
    
    
    
    
      
 

   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        frontSide_btn_holder = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        right = new javax.swing.JPanel();
        building_classes_panel = new javax.swing.JPanel();
        Class_Config_panel = new javax.swing.JPanel();
        BookedContainer_main1 = new javax.swing.JPanel();
        ClassViewer_list = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lb_ByRoomType = new javax.swing.JLabel();
        Searching_panel_holder = new javax.swing.JPanel();
        SByRoomType = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        Add_price4 = new javax.swing.JLabel();
        lb_bg_btnFirstView3 = new javax.swing.JLabel();
        Cover = new javax.swing.JPanel();
        addRoom_type = new javax.swing.JLabel();
        Assign = new javax.swing.JLabel();
        Delecte25 = new javax.swing.JLabel();
        edit19 = new javax.swing.JLabel();
        Delecte26 = new javax.swing.JLabel();
        lb_bg_btnFirstView2 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        CreatedClasses = new javax.swing.JTable();
        jPanel37 = new javax.swing.JPanel();
        jLabel222 = new javax.swing.JLabel();
        jLabel223 = new javax.swing.JLabel();
        jLabel224 = new javax.swing.JLabel();
        jLabel225 = new javax.swing.JLabel();
        jLabel226 = new javax.swing.JLabel();
        jLabel227 = new javax.swing.JLabel();
        table_holder_bg16 = new javax.swing.JLabel();
        class_entry = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        mixm_numberOf_subject = new javax.swing.JTextField();
        Count_title7 = new javax.swing.JLabel();
        SaveClass = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtTime = new javax.swing.JTextField();
        comb_class_name = new javax.swing.JComboBox();
        combGrade = new javax.swing.JComboBox();
        lb_UpdateClass = new javax.swing.JLabel();
        timeOut = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        combo_room = new javax.swing.JComboBox();
        txtPeriod = new javax.swing.JComboBox();
        jLabel28 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        lb_reloads = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel196 = new javax.swing.JLabel();
        add_compusary_subject = new javax.swing.JPanel();
        combAp = new javax.swing.JComboBox();
        class_level = new javax.swing.JComboBox();
        level_change = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        subject_table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lb_numclasses = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lb_class_period = new javax.swing.JLabel();
        lb_number_ofSubjects = new javax.swing.JLabel();
        lb_classname = new javax.swing.JLabel();
        lb_reloads5 = new javax.swing.JLabel();
        lb_reloads6 = new javax.swing.JLabel();
        Count_title8 = new javax.swing.JLabel();
        class_name = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        lb_reloads1 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel197 = new javax.swing.JLabel();
        lb_reloads2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        panel_Teachers = new javax.swing.JPanel();
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

        jLabel34.setBackground(new java.awt.Color(102, 102, 102));
        jLabel34.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(163, 200, 199));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_double_right_35px_1.png"))); // NOI18N
        jLabel34.setText("GENERATE CLASSES  ");
        jLabel34.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel34.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel34.setName("next"); // NOI18N
        jLabel34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel34MouseClicked(evt);
            }
        });
        frontSide_btn_holder.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 170, 40));

        jPanel1.add(frontSide_btn_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 200, 660));

        right.setBackground(new java.awt.Color(153, 153, 153));
        right.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(right, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 760, 1380, 50));

        building_classes_panel.setLayout(new java.awt.CardLayout());

        Class_Config_panel.setBackground(new Color(66,66,66,50));
        Class_Config_panel.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        Class_Config_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BookedContainer_main1.setBackground(new java.awt.Color(255, 255, 255));
        BookedContainer_main1.setLayout(new java.awt.CardLayout());

        ClassViewer_list.setBackground(new Color(66,66,66,5));
        ClassViewer_list.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel77.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(102, 102, 102));
        jLabel77.setText("CLASS");
        jLabel77.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ClassViewer_list.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 50, 50));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_user_25px.png"))); // NOI18N
        ClassViewer_list.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 40, 70));

        lb_ByRoomType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_ByRoomType.setForeground(new java.awt.Color(255, 255, 255));
        lb_ByRoomType.setText("Fliter");
        lb_ByRoomType.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb_ByRoomType.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_ByRoomTypeMouseClicked(evt);
            }
        });
        ClassViewer_list.add(lb_ByRoomType, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 80, 50));

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
        Cover.add(addRoom_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 60, 40));

        Assign.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Assign.setForeground(new java.awt.Color(255, 255, 255));
        Assign.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_checked_25px_2.png"))); // NOI18N
        Assign.setText("Subjects");
        Assign.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AssignMouseClicked(evt);
            }
        });
        Cover.add(Assign, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 80, 40));

        Delecte25.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte25.setForeground(new java.awt.Color(255, 255, 255));
        Delecte25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_no_entry_25px.png"))); // NOI18N
        Delecte25.setText("Delecte");
        Delecte25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Delecte25MouseClicked(evt);
            }
        });
        Cover.add(Delecte25, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 80, 40));

        edit19.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        edit19.setForeground(new java.awt.Color(255, 255, 255));
        edit19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_upload_to_ftp_30px.png"))); // NOI18N
        edit19.setText("Edit");
        edit19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edit19MouseClicked(evt);
            }
        });
        Cover.add(edit19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, 40));

        Delecte26.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte26.setForeground(new java.awt.Color(255, 255, 255));
        Delecte26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Delecte26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        Cover.add(Delecte26, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, -10, 380, 70));

        Searching_panel_holder.add(Cover, "card2");

        ClassViewer_list.add(Searching_panel_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 370, 60));

        lb_bg_btnFirstView2.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        lb_bg_btnFirstView2.setForeground(new java.awt.Color(255, 255, 255));
        lb_bg_btnFirstView2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_bg_btnFirstView2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        ClassViewer_list.add(lb_bg_btnFirstView2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, -10, 170, 80));

        CreatedClasses.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        CreatedClasses.setForeground(new java.awt.Color(102, 102, 102));
        CreatedClasses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        CreatedClasses.setRowHeight(35);
        CreatedClasses.setRowMargin(5);
        CreatedClasses.setShowVerticalLines(false);
        CreatedClasses.setTableHeader(null);
        CreatedClasses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreatedClassesMouseClicked(evt);
            }
        });
        jScrollPane19.setViewportView(CreatedClasses);

        ClassViewer_list.add(jScrollPane19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 1040, 400));

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel222.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel222.setForeground(new java.awt.Color(102, 102, 102));
        jLabel222.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel222.setText(" YEAR GROUP");
        jPanel37.add(jLabel222, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 150, 50));

        jLabel223.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel223.setForeground(new java.awt.Color(102, 102, 102));
        jLabel223.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel223.setText(" GRADE");
        jPanel37.add(jLabel223, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 50));

        jLabel224.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel224.setForeground(new java.awt.Color(102, 102, 102));
        jLabel224.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel224.setText("   ROOM  ");
        jPanel37.add(jLabel224, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 150, 50));

        jLabel225.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel225.setForeground(new java.awt.Color(102, 102, 102));
        jLabel225.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel225.setText(" ROOM CAPACITY");
        jPanel37.add(jLabel225, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 160, 50));

        jLabel226.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel226.setForeground(new java.awt.Color(102, 102, 102));
        jLabel226.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel226.setText("  PERIOD");
        jPanel37.add(jLabel226, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 170, 50));

        jLabel227.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel227.setForeground(new java.awt.Color(102, 102, 102));
        jLabel227.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel227.setText(" ROOM TYPE");
        jPanel37.add(jLabel227, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 130, 50));

        ClassViewer_list.add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 1040, 50));

        table_holder_bg16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        table_holder_bg16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/add_Room_typebg.png"))); // NOI18N
        ClassViewer_list.add(table_holder_bg16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1130, 600));

        BookedContainer_main1.add(ClassViewer_list, "card8");

        class_entry.setBackground(new Color(66,66,66,5));
        class_entry.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setBackground(new java.awt.Color(51, 51, 51));
        jLabel32.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(153, 153, 153));
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_adjust_25px.png"))); // NOI18N
        jLabel32.setText(" Mexm  subjects");
        class_entry.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 260, 190, 30));

        mixm_numberOf_subject.setForeground(new java.awt.Color(102, 102, 102));
        mixm_numberOf_subject.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mixm_numberOf_subjectKeyTyped(evt);
            }
        });
        class_entry.add(mixm_numberOf_subject, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 260, 300, 35));

        Count_title7.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title7.setForeground(new java.awt.Color(255, 255, 255));
        Count_title7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_30px.png"))); // NOI18N
        Count_title7.setText("Class list");
        Count_title7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Count_title7MouseClicked(evt);
            }
        });
        class_entry.add(Count_title7, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 80, 150, 50));

        SaveClass.setBackground(new java.awt.Color(51, 51, 51));
        SaveClass.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        SaveClass.setForeground(new java.awt.Color(153, 153, 153));
        SaveClass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_data_recovery_25px.png"))); // NOI18N
        SaveClass.setText("Save");
        SaveClass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveClassMouseClicked(evt);
            }
        });
        class_entry.add(SaveClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 420, 120, 50));

        jLabel18.setBackground(new java.awt.Color(51, 51, 51));
        jLabel18.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(153, 153, 153));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_home_25px.png"))); // NOI18N
        jLabel18.setText("   Class Room");
        class_entry.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 200, 30));

        jLabel24.setBackground(new java.awt.Color(51, 51, 51));
        jLabel24.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(153, 153, 153));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_grades_25px.png"))); // NOI18N
        jLabel24.setText("    Grade &");
        class_entry.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 200, 30));

        jLabel33.setBackground(new java.awt.Color(51, 51, 51));
        jLabel33.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(153, 153, 153));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel33.setText("Class Name");
        class_entry.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 80, 30));

        jLabel27.setBackground(new java.awt.Color(51, 51, 51));
        jLabel27.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(153, 153, 153));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("        End");
        class_entry.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 340, 70, 40));

        txtTime.setForeground(new java.awt.Color(102, 102, 102));
        class_entry.add(txtTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 340, 120, 35));

        comb_class_name.setBackground(new Color(255,255,255,30));
        comb_class_name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comb_class_name.setForeground(new java.awt.Color(102, 102, 102));
        comb_class_name.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "E", "W", "X", "Y", "Z" }));
        class_entry.add(comb_class_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 180, 35));

        combGrade.setBackground(new Color(255,255,255,30));
        combGrade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        combGrade.setForeground(new java.awt.Color(102, 102, 102));
        combGrade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        class_entry.add(combGrade, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 140, 35));

        lb_UpdateClass.setBackground(new java.awt.Color(51, 51, 51));
        lb_UpdateClass.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        lb_UpdateClass.setForeground(new java.awt.Color(153, 153, 153));
        lb_UpdateClass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_update_25px.png"))); // NOI18N
        lb_UpdateClass.setText("Update");
        lb_UpdateClass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_UpdateClassMouseClicked(evt);
            }
        });
        class_entry.add(lb_UpdateClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 420, 120, 50));

        timeOut.setForeground(new java.awt.Color(102, 102, 102));
        class_entry.add(timeOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 340, 120, 35));

        jLabel26.setBackground(new java.awt.Color(51, 51, 51));
        jLabel26.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(153, 153, 153));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_adjust_25px.png"))); // NOI18N
        jLabel26.setText("   Class Period");
        class_entry.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 200, 30));

        combo_room.setBackground(new Color(255,255,255,30));
        combo_room.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        combo_room.setForeground(new java.awt.Color(102, 102, 102));
        class_entry.add(combo_room, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 300, 35));

        txtPeriod.setBackground(new Color(255,255,255,30));
        txtPeriod.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPeriod.setForeground(new java.awt.Color(102, 102, 102));
        txtPeriod.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Morning Classes", "Afternoon Classes", "Evening Classes" }));
        class_entry.add(txtPeriod, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 300, 40));

        jLabel28.setBackground(new java.awt.Color(51, 51, 51));
        jLabel28.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(153, 153, 153));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_lock_orientation_30px.png"))); // NOI18N
        jLabel28.setText("   Start Time");
        class_entry.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 340, 140, 30));

        jDateChooser1.setForeground(new java.awt.Color(102, 102, 102));
        class_entry.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 170, 300, 35));

        lb_reloads.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        lb_reloads.setForeground(new java.awt.Color(153, 153, 153));
        lb_reloads.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_submit_progress_25px.png"))); // NOI18N
        lb_reloads.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_reloadsMouseClicked(evt);
            }
        });
        class_entry.add(lb_reloads, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, 30, 60));

        jLabel22.setBackground(new java.awt.Color(51, 51, 51));
        jLabel22.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(153, 153, 153));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_pay_date_25px.png"))); // NOI18N
        jLabel22.setText("    Year Group");
        class_entry.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, 140, 30));

        jLabel196.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel196.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/Untitled-2.png"))); // NOI18N
        class_entry.add(jLabel196, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 1090, 470));

        BookedContainer_main1.add(class_entry, "card3");

        add_compusary_subject.setBackground(new Color(66,66,66,5));
        add_compusary_subject.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        combAp.setBackground(new Color(255,255,255,30));
        combAp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        combAp.setForeground(new java.awt.Color(102, 102, 102));
        combAp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Optional", "Compulsory" }));
        add_compusary_subject.add(combAp, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 120, 30));

        class_level.setBackground(new Color(255,255,255,30));
        class_level.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        class_level.setForeground(new java.awt.Color(102, 102, 102));
        class_level.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Secondary", "Primary" }));
        add_compusary_subject.add(class_level, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 160, 30));

        level_change.setBackground(new Color(255,255,255,30));
        level_change.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        level_change.setForeground(new java.awt.Color(102, 102, 102));
        level_change.setText("Revert ");
        level_change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                level_changeActionPerformed(evt);
            }
        });
        add_compusary_subject.add(level_change, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, 30));

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

        add_compusary_subject.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 380, 330));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Type");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 60, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("class level");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 60, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Subjects");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("application");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 60, 30));

        add_compusary_subject.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 380, 40));

        lb_numclasses.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        lb_numclasses.setForeground(new java.awt.Color(153, 153, 153));
        lb_numclasses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        lb_numclasses.setText("Class Rooms");
        lb_numclasses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_numclassesMouseClicked(evt);
            }
        });
        add_compusary_subject.add(lb_numclasses, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 210, 170, 50));

        jLabel29.setBackground(new java.awt.Color(51, 51, 51));
        jLabel29.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(153, 153, 153));
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_grades_25px.png"))); // NOI18N
        jLabel29.setText("# of Subjects");
        add_compusary_subject.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 400, 130, 30));

        lb_class_period.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        lb_class_period.setForeground(new java.awt.Color(153, 153, 153));
        lb_class_period.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        lb_class_period.setText("Class Rooms");
        lb_class_period.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_class_periodMouseClicked(evt);
            }
        });
        add_compusary_subject.add(lb_class_period, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 330, 160, 50));

        lb_number_ofSubjects.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        lb_number_ofSubjects.setForeground(new java.awt.Color(153, 153, 153));
        lb_number_ofSubjects.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        lb_number_ofSubjects.setText("Class Rooms");
        lb_number_ofSubjects.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_number_ofSubjectsMouseClicked(evt);
            }
        });
        add_compusary_subject.add(lb_number_ofSubjects, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 390, 160, 50));

        lb_classname.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        lb_classname.setForeground(new java.awt.Color(153, 153, 153));
        lb_classname.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        lb_classname.setText("Class Rooms");
        lb_classname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_classnameMouseClicked(evt);
            }
        });
        add_compusary_subject.add(lb_classname, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 150, 170, 50));

        lb_reloads5.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        lb_reloads5.setForeground(new java.awt.Color(153, 153, 153));
        lb_reloads5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        lb_reloads5.setText("Class Rooms");
        lb_reloads5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_reloads5MouseClicked(evt);
            }
        });
        add_compusary_subject.add(lb_reloads5, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 270, 160, 50));

        lb_reloads6.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        lb_reloads6.setForeground(new java.awt.Color(153, 153, 153));
        lb_reloads6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        lb_reloads6.setText("Class Rooms");
        lb_reloads6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_reloads6MouseClicked(evt);
            }
        });
        add_compusary_subject.add(lb_reloads6, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 440, 160, 50));

        Count_title8.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title8.setForeground(new java.awt.Color(255, 255, 255));
        Count_title8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_30px.png"))); // NOI18N
        Count_title8.setText("Class list");
        Count_title8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Count_title8MouseClicked(evt);
            }
        });
        add_compusary_subject.add(Count_title8, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 80, 150, 50));

        class_name.setBackground(new java.awt.Color(51, 51, 51));
        class_name.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        class_name.setForeground(new java.awt.Color(153, 153, 153));
        class_name.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_home_25px.png"))); // NOI18N
        class_name.setText("   Class Name");
        add_compusary_subject.add(class_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 160, 130, 30));

        jLabel25.setBackground(new java.awt.Color(51, 51, 51));
        jLabel25.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(153, 153, 153));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_grades_25px.png"))); // NOI18N
        jLabel25.setText("Class Room");
        add_compusary_subject.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, 130, 30));

        jLabel30.setBackground(new java.awt.Color(51, 51, 51));
        jLabel30.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(153, 153, 153));
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_adjust_25px.png"))); // NOI18N
        jLabel30.setText("   Class Period");
        add_compusary_subject.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 340, 130, 30));

        jLabel31.setBackground(new java.awt.Color(51, 51, 51));
        jLabel31.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(153, 153, 153));
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_lock_orientation_30px.png"))); // NOI18N
        jLabel31.setText("Add Subjects To Class");
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
        });
        add_compusary_subject.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, 200, 40));

        lb_reloads1.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        lb_reloads1.setForeground(new java.awt.Color(153, 153, 153));
        lb_reloads1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_submit_progress_25px.png"))); // NOI18N
        lb_reloads1.setText(" Room Capacity");
        lb_reloads1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_reloads1MouseClicked(evt);
            }
        });
        add_compusary_subject.add(lb_reloads1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 270, 150, 50));

        jLabel23.setBackground(new java.awt.Color(51, 51, 51));
        jLabel23.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(153, 153, 153));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_pay_date_25px.png"))); // NOI18N
        jLabel23.setText("    Year Group");
        add_compusary_subject.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 440, 150, 50));

        jLabel197.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel197.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/Untitled-2.png"))); // NOI18N
        add_compusary_subject.add(jLabel197, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 1110, 470));

        lb_reloads2.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        lb_reloads2.setForeground(new java.awt.Color(153, 153, 153));
        lb_reloads2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_submit_progress_25px.png"))); // NOI18N
        lb_reloads2.setText("Class Rooms");
        lb_reloads2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_reloads2MouseClicked(evt);
            }
        });
        add_compusary_subject.add(lb_reloads2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 370, 120, 50));

        BookedContainer_main1.add(add_compusary_subject, "card3");

        Class_Config_panel.add(BookedContainer_main1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1140, 610));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_delete_25px.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        Class_Config_panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 60, 60, 50));

        building_classes_panel.add(Class_Config_panel, "card3");

        panel_Teachers.setBackground(new java.awt.Color(255, 255, 255));
        panel_Teachers.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        building_classes_panel.add(panel_Teachers, "card2");

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

    private void admin_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btnMouseClicked


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

    private void lb_ByRoomTypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_ByRoomTypeMouseClicked

        if(Cover.isShowing()){
            Cover.hide();
            SByRoomType.setVisible(true);
        }else if(SByRoomType.isShowing()){
            SByRoomType.hide();
            Cover.setVisible(true);
        }
    }//GEN-LAST:event_lb_ByRoomTypeMouseClicked

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        try {

            conn = DBConnection.getConnction();
            String sql ="SELECT  grade_room,class_period,room_number,room_type,room_capacity,date FROM classes,rooms WHERE classes.classroom_id = rooms.classroom_id  AND grade_room  like '%" + jTextField1.getText() + "%'  OR class_period  like '%" + jTextField1.getText() + "%'   OR  room_number  like '%" + jTextField1.getText() + "%'   OR  room_type  like '%" + jTextField1.getText() + "%' "
            + "  OR  room_capacity  like '%" + jTextField1.getText() + "%'  OR  date  like '%" + jTextField1.getText() + "%'  ";
            pps = conn.prepareStatement(sql);
            rs = pps.executeQuery();
            CreatedClasses.setModel(DbUtils.resultSetToTableModel(rs));//sho
        } catch (SQLException ex) {Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);}

    }//GEN-LAST:event_jTextField1KeyTyped

    private void Add_price4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_price4MouseClicked
        ClassViewer_list.hide();
        class_entry.setVisible(true);
        lb_UpdateClass.hide();
        SaveClass.setVisible(true);
    }//GEN-LAST:event_Add_price4MouseClicked

    private void addRoom_typeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addRoom_typeMouseClicked
        ClassViewer_list.hide();
        add_compusary_subject.hide();
        class_entry.setVisible(true);

        lb_UpdateClass.hide();
        SaveClass.setVisible(true);
    }//GEN-LAST:event_addRoom_typeMouseClicked

    
    
    String class_names = null;
    String class_capacity = null;
    String class_counts = null;
    
    
    private void AssignMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AssignMouseClicked
        if (get_class_id.equals("none")) {
            JOptionPane.showMessageDialog(null, "Select the class");
        } else if (!get_class_id.equals("none")) {
            try {
                conn = DBConnection.getConnction();
                pps3 = conn.prepareStatement("SELECT class_id,grade_room,class_period,DATE   ,room_number,room_capacity FROM    rooms INNER JOIN  classes ON classes.classroom_id = rooms.classroom_id WHERE grade_room = ?");
                pps3.setString(1, get_class_id);
                rs3 = pps3.executeQuery();

                if(rs3.next()){
                    ClassViewer_list.hide();
                    class_entry.hide();
                    add_compusary_subject.setVisible(true);

                    obtained_class_id = rs3.getString("class_id");

                    class_names = rs3.getString("grade_room");    //getting the class name to use for a search
                    lb_classname.setText(rs3.getString("grade_room"));

                    lb_numclasses.setText(rs3.getString("room_number"));
                    lb_class_period.setText(rs3.getString("class_period"));

                    class_capacity = rs3.getString("room_capacity");
                    lb_reloads5.setText(rs3.getString("room_capacity"));           // capacity - number of students
                    lb_reloads6.setText(rs3.getString("date"));

                }
            } catch (Exception ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

            try { //count the number of subjects from yhe joint tables
                conn = DBConnection.getConnction();
                String sql = "SELECT   subjects.subject_name,  classes.grade_room,	 COUNT(class_subject_joint.class_subject_id)  AS subject_count FROM  class_subject_joint   INNER JOIN  subjects  ON  subjects.subject_id = class_subject_joint.subject_id    INNER JOIN classes ON  classes.class_id = class_subject_joint.class_id WHERE grade_room =? GROUP BY grade_room";
                pps8 = conn.prepareStatement(sql);
                pps8.setString(1, lb_classname.getText());
                rs8 = pps8.executeQuery();
                if(rs8.next()){
                    lb_number_ofSubjects.setText(rs8.getString("subject_count"));
                }
            } catch (SQLException ex) { JOptionPane.showMessageDialog(null, ex); }

            count_students();
        }

    }//GEN-LAST:event_AssignMouseClicked

    private void Delecte25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Delecte25MouseClicked
        shouw();
        try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("DELETE  FROM classes WHERE class_id = ?");
            pps.setString(1, Class_ResourceGetting_id);
            pps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        showContent_onAllTables();//show changes on the table after delete

    }//GEN-LAST:event_Delecte25MouseClicked

    private void edit19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit19MouseClicked
        ClassViewer_list.hide();
        Class_Config_panel.hide();
        lb_UpdateClass.setVisible(true);
        SaveClass.hide();
        class_entry.setVisible(true);
        shouw();
    }//GEN-LAST:event_edit19MouseClicked

    private void CreatedClassesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreatedClassesMouseClicked
        if(Cover.isShowing()){
            Cover.hide();
            SByRoomType.setVisible(true);
        }else if(SByRoomType.isShowing()){
            SByRoomType.hide();
            Cover.setVisible(true);
        }
        DefaultTableModel tableMode_type = (DefaultTableModel) CreatedClasses.getModel();
        get_class_id = tableMode_type.getValueAt(CreatedClasses.getSelectedRow(), 0).toString();

    }//GEN-LAST:event_CreatedClassesMouseClicked

    private void mixm_numberOf_subjectKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mixm_numberOf_subjectKeyTyped
        char iNumb = evt.getKeyChar();
        if(!(Character.isDigit(iNumb))
            ||(iNumb == KeyEvent.VK_BACKSPACE)
            ||(iNumb == KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_mixm_numberOf_subjectKeyTyped

    private void Count_title7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Count_title7MouseClicked
        ClassViewer_list.setVisible(true);
        class_entry.hide();
    }//GEN-LAST:event_Count_title7MouseClicked

    private void SaveClassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveClassMouseClicked
        //GET CLASS ROOM ID TO INSERT IN CLASS MAKING

        String room = combo_room.getSelectedItem().toString();
        try {conn = DBConnection.getConnction();
            pps = conn.prepareStatement("SELECT * FROM rooms WHERE  room_number= ? ");
            pps.setString(1, room);
            rs = pps.executeQuery();
            if(rs.next()){
                insert_classromID_Class  = rs.getString("classroom_id");
            }
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex); }

        //CHECKING IF THE CLASS READY EXISTS
        String Rgrade  = combGrade.getSelectedItem().toString().trim();
        String mClass_name  = comb_class_name.getSelectedItem().toString().trim();
        try {conn = DBConnection.getConnction();
            String sql = "SELECT * FROM classes WHERE grade_room =? ";
            pps8 = conn.prepareStatement(sql);
            pps8.setString(1 ,  Rgrade + mClass_name);
            rs8  =  pps8.executeQuery();
            if(rs8.next()){
                JOptionPane.showMessageDialog(null, "class Already Exists");
            }else{
                checking_if_roomANDperiod_exist();// IF THE CLASS DOESNT EXIST, CHECK THE ROOM ALLOCATED IF ITS FREE
            }
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);}
    }//GEN-LAST:event_SaveClassMouseClicked

     public void checking_if_roomANDperiod_exist(){
    
               //CHECKING IF THE ROOM IS BEING USED AT THE SAME TIME
                String ROOM  = combo_room.getSelectedItem().toString().trim();
                String CLASS_PERIOD  = txtPeriod.getSelectedItem().toString().trim();

                try {    
                    conn = DBConnection.getConnction();
                    String sql = "SELECT class_id,grade_room,class_period,DATE   ,room_number,room_capacity FROM    rooms INNER JOIN  classes ON classes.classroom_id = rooms.classroom_id WHERE  class_period =? AND room_number =? ";  
                    pps9 = conn.prepareStatement(sql);
                    pps9.setString(1 , CLASS_PERIOD );
                    pps9.setString(2 , ROOM);

                    rs9  =  pps9.executeQuery();
                     if(rs9.next()){
                     JOptionPane.showMessageDialog(null, "room in Usage at that Period");
                     }else{  insert_class();  }                  
                } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);}
    
    }
    
    public void insert_class(){

        
        String Rgrade  = combGrade.getSelectedItem().toString().trim();
         String mClass_name  = comb_class_name.getSelectedItem().toString().trim();
        try {
            String dateSelected = ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();
                 conn = DBConnection.getConnction();
                String sql = "INSERT INTO classes (grade_room,classroom_id, class_period,date,time,time_out, num_of_subjects) VALUES (?,?,?,?,?,?,?)";
                pps = conn.prepareStatement(sql);
                pps.setString(1 ,  Rgrade+mClass_name);
                pps.setString(2 ,  insert_classromID_Class);
                pps.setString(3 ,  txtPeriod.getSelectedItem().toString().trim());  
                pps.setString(4 ,  dateSelected);
                pps.setString(5 ,  txtTime.getText().trim());
                pps.setString(6 ,  timeOut.getText().trim());
                pps.setString(7 ,  mixm_numberOf_subject.getText().trim());

                pps.executeUpdate();
               
                  txtPeriod .setSelectedIndex(0);
                  combo_room.setSelectedIndex(0);
                  combGrade.setSelectedIndex(0);
                  jDateChooser1.setDate(null);
                  txtTime.setText(null);
                  timeOut.setText(null);
                  mixm_numberOf_subject.setText(null);
                  
                  JOptionPane.showMessageDialog(null, "Successfully Saved");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

                showContent_onAllTables();
    
    
    
    }
    
    public void shouw(){
    
     try {
              DefaultTableModel tableMode =(DefaultTableModel)CreatedClasses.getModel();
              String grade = tableMode.getValueAt(CreatedClasses.getSelectedRow(), 0).toString();
            
                conn = DBConnection.getConnction();
                String sql = "SELECT  * FROM  classes WHERE grade_room =?";
                pps = conn.prepareStatement(sql);
                pps.setString(1, grade);
                rs= pps.executeQuery();
                txtPeriod.removeAllItems();
                if(rs.next()){
                  Class_ResourceGetting_id = rs.getString("class_id");
                  txtPeriod.addItem(rs.getString("class_period")); 
                  txtTime.setText(rs.getString("time"));
                  timeOut.setText(rs.getString("time_out"));

                  combGrade.removeAllItems();
                  combGrade.addItem(rs.getString("grade_room"));
                }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
                showContent_onAllTables();
    }

    
    
    private void lb_UpdateClassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_UpdateClassMouseClicked

        //getting the new classroom id for the selected class from combo to update in the class table
        String room = combo_room.getSelectedItem().toString().substring(30).trim();  //removes everything from left going right
        String grade = combo_room.getSelectedItem().toString().substring(5, 15).trim();//getting the string from the starting index 0 ending at index 2
        String getclassroomID_toUpdate_inAclass = null;
        try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("SELECT * FROM rooms WHERE room_name =? AND room_number=?  ");
            pps.setString(1, room);
            pps.setString(2, grade);

            rs = pps.executeQuery();
            if(rs.next()){
                getclassroomID_toUpdate_inAclass  = rs.getString("classroom_id");
            }
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex); }

        // updating
        try {
            String dateSelected = ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();

            conn = DBConnection.getConnction();
            String sql = "UPDATE  classes SET  grade_room =?, class_period =?,date =?, time =?, time_out =?, classroom_id =? WHERE class_id = ?";
            pps = conn.prepareStatement(sql);
            pps.setString(1 , combGrade.getSelectedItem().toString().trim());
            pps.setString(2 , txtPeriod.getSelectedItem().toString().trim());
            pps.setString( 3, dateSelected);
            pps.setString(4 , txtTime.getText());
            pps.setString(5 , timeOut.getText());

            pps.setString(6 , getclassroomID_toUpdate_inAclass);

            pps.setString(7 ,Class_ResourceGetting_id);
            pps.executeUpdate();
            combo_room. setSelectedIndex(0);
            combGrade.setSelectedIndex(0);
            txtPeriod.setSelectedIndex(0);
            txtTime .setText(null);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        showContent_onAllTables();
    }//GEN-LAST:event_lb_UpdateClassMouseClicked

    private void lb_reloadsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_reloadsMouseClicked

        combo_room.removeAllItems();
        combGrade.removeAllItems();
        ComboDisplay();
        combGrade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
    }//GEN-LAST:event_lb_reloadsMouseClicked

    private void level_changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_level_changeActionPerformed
        String level=  class_level.getSelectedItem().toString();
        String applica =  combAp.getSelectedItem().toString();

        if(level.equals("Secondary")){
            combAp.setSelectedIndex(0);
            combAp.setEnabled(true);

            try {
                conn = DBConnection.getConnction();
                String sql = "SELECT subject_name,subject_application,subject_type,class_level FROM subjects WHERE  class_level = 'Secondary' AND subject_application =?"; //
                pps2 = conn.prepareStatement(sql);
                pps2.setString(1, applica);
                rs2 = pps2.executeQuery();
                subject_table.setModel(DbUtils.resultSetToTableModel(rs2));
            } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

        }else  if(level.equals("Primary")){
            combAp.setSelectedIndex(1);
            combAp.setEnabled(false);

            try {
                conn = DBConnection.getConnction();
                String sql = "SELECT subject_name,subject_application,subject_type,class_level  FROM subjects WHERE  class_level = 'Primary' ";
                pps4 = conn.prepareStatement(sql);
                rs4 = pps4.executeQuery();
                subject_table.setModel(DbUtils.resultSetToTableModel(rs4));
            } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

        }
    }//GEN-LAST:event_level_changeActionPerformed

    private void subject_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subject_tableMouseClicked
        DefaultTableModel tableMode_type = (DefaultTableModel) subject_table.getModel();
        subject_selected = tableMode_type.getValueAt(subject_table.getSelectedRow(), 0).toString();
    }//GEN-LAST:event_subject_tableMouseClicked

    private void lb_numclassesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_numclassesMouseClicked
        String getClass_id = null;
        try {
            conn = DBConnection.getConnction();
            pps3 = conn.prepareStatement("SELECT *  FROM classes WHERE grade_room = ?");
            pps3.setString(1, lb_classname.getText());
            rs3 = pps3.executeQuery();
            if(rs3.next()){
                getClass_id = rs3.getString("class_id");
                JOptionPane.showMessageDialog(null, getClass_id);
            }
        } catch (Exception ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

        try {
            conn = DBConnection.getConnction();
            String sql = "SELECT   subjects.subject_name,  classes.grade_room,	 COUNT(*)  AS subject_count FROM  subjects  JOIN  class_subject_joint  ON  subjects.subject_id = class_subject_joint.subject_id   INNER JOIN classes ON  classes.class_id = class_subject_joint.class_id WHERE grade_room = ? GROUP BY 1;"; //
            pps2 = conn.prepareStatement(sql);
            pps2.setString(1, getClass_id);
            rs2 = pps2.executeQuery();

            subject_table.setModel(DbUtils.resultSetToTableModel(rs2));
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

    }//GEN-LAST:event_lb_numclassesMouseClicked

    private void lb_class_periodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_class_periodMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lb_class_periodMouseClicked

    private void lb_number_ofSubjectsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_number_ofSubjectsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lb_number_ofSubjectsMouseClicked

    private void lb_classnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_classnameMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lb_classnameMouseClicked

    private void lb_reloads5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_reloads5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lb_reloads5MouseClicked

    private void lb_reloads6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_reloads6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lb_reloads6MouseClicked

    private void Count_title8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Count_title8MouseClicked
        ClassViewer_list.setVisible(true);
        class_entry.hide();
        add_compusary_subject.hide();
    }//GEN-LAST:event_Count_title8MouseClicked

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
        if (subject_selected.equals("none")) {
            JOptionPane.showMessageDialog(null, "Select the Subject to Assign");
        } else if (!subject_selected.equals("none")) {
            try {
                conn = DBConnection.getConnction();
                pps7 = conn.prepareStatement("SELECT *  FROM subjects WHERE subject_name = ?");
                pps7.setString(1, subject_selected);
                rs7 = pps7.executeQuery();
                if(rs7.next()){
                    obtained_subject_id = rs7.getString("subject_id");
                    Check_4a_class_subject_joint();
                }
            } catch (Exception ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
        }

    }//GEN-LAST:event_jLabel31MouseClicked

    private void lb_reloads1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_reloads1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lb_reloads1MouseClicked

    private void lb_reloads2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_reloads2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lb_reloads2MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseClicked

        
            Class_Assignment myr = new Class_Assignment();
            myr.setVisible(true);

      
            this.dispose();
            
        
     
    }//GEN-LAST:event_jLabel34MouseClicked
   
     public void count_students(){
            try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("SELECT  count(student_ids) FROM students  WHERE Student_Class =?");
            pps.setString(1, class_names);
            rs = pps.executeQuery();
            if (rs.next()) {
                String count_students = rs.getString("count(student_ids)");
                int Students = Integer.parseInt(count_students);//reconverting Occuped space to int

                int ClassCapacity = Integer.parseInt(class_capacity);//reconverting capacity to int

                if (ClassCapacity == Students) {
                       lb_reloads5.setText("this Class is full");

                } else if (Students > ClassCapacity  ) {
                       lb_reloads5.setText("Class OverLoaded");

                }else {

              int      ClassCapacity_caculation = ClassCapacity - Students;
                    lb_reloads5.setText(Integer.toString(ClassCapacity_caculation)); //reconverting sum variables back to string and adding it to a lebal
                    //show on the waiting list panel
                 //   lb_reloads5.setText(Integer.toString(ClassCapacity_caculation));

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Class_Assignment.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    
    }
    
    
    
    
    
     public void Check_4a_class_subject_joint(){
          int formart_obtained_class_ID = Integer.parseInt(obtained_class_id);   
          int formart_obtained_subject_ID = Integer.parseInt(obtained_subject_id);
          
          try {
            conn = DBConnection.getConnction();
            String sql = "SELECT class_id,subject_id FROM  class_subject_joint WHERE  class_id =? AND subject_id =?";
            pps8 = conn.prepareStatement(sql);
            pps8.setInt(1, formart_obtained_class_ID);
            pps8.setInt(2, formart_obtained_subject_ID);
            rs8 = pps8.executeQuery();
            if(rs8.next()){
               JOptionPane.showMessageDialog(null, "Subject Already Assigned To That Class");

            }else{
              Make_a_class_subject_joint();  
            }

        } catch (SQLException ex) { JOptionPane.showMessageDialog(null, ex); }
    
    
    }
  
     
      public void Make_a_class_subject_joint(){
     
          int formart_obtained_class_ID = Integer.parseInt(obtained_class_id);   
          int formart_obtained_subject_ID = Integer.parseInt(obtained_subject_id);
          
          try {
            conn = DBConnection.getConnction();
            String sql = "INSERT INTO class_subject_joint (class_id,subject_id) VALUES (?,?)";
            pps8 = conn.prepareStatement(sql);
            pps8.setInt(1, formart_obtained_class_ID);
            pps8.setInt(2, formart_obtained_subject_ID);

            pps8.executeUpdate();
            JOptionPane.showMessageDialog(null, "Subject Assigned");

        } catch (SQLException ex) { JOptionPane.showMessageDialog(null, ex); }
 
       count_subjects_inAclass();
     }
     
      
      
      public void count_subjects_inAclass(){
    
     try {
            conn = DBConnection.getConnction();
            String sql = "SELECT   subjects.subject_name,  classes.grade_room,	 COUNT(class_subject_joint.class_subject_id)  AS subject_count FROM  class_subject_joint   INNER JOIN  subjects  ON  subjects.subject_id = class_subject_joint.subject_id    INNER JOIN classes ON  classes.class_id = class_subject_joint.class_id WHERE grade_room =? GROUP BY grade_room";
            pps8 = conn.prepareStatement(sql);
            pps8.setString(1, lb_classname.getText());
            rs8 = pps8.executeQuery();
            if(rs8.next()){
               lb_number_ofSubjects.setText(rs8.getString("subject_count"));

            }
        } catch (SQLException ex) { JOptionPane.showMessageDialog(null, ex); }
    
    
    //  lb_reloads6
    }
      
      
     
    public void showContent_onAllTables(){
  
    try {
      
         conn = DBConnection.getConnction();
          String sql = " SELECT  grade_room,class_period,room_number,room_type,room_capacity,date FROM classes,rooms WHERE classes.classroom_id = rooms.classroom_id";
         pps = conn.prepareStatement(sql);
         rs = pps.executeQuery();
         CreatedClasses.setModel(DbUtils.resultSetToTableModel(rs));
    } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
         //rooms on the 
    
    
      try {
            conn = DBConnection.getConnction();
            String sql = "SELECT subject_name,subject_application,subject_type,class_level FROM subjects WHERE  class_level = 'Secondary' AND subject_application ='Compulsory'"; //
            pps2 = conn.prepareStatement(sql);
            rs2 = pps2.executeQuery();
            subject_table.setModel(DbUtils.resultSetToTableModel(rs2));
          } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
         
    
    
    
     }
   
    
    
    
    
    
    
    
 



    
     public static Class_conf getObj() {  //public method for instance Restriction
        if (Obj == null) {
            Obj = new Class_conf();
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
            java.util.logging.Logger.getLogger(Class_conf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Class_conf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Class_conf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Class_conf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Class_conf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Add_price4;
    private javax.swing.JLabel Assign;
    private javax.swing.JLabel BackGround_layer1;
    private javax.swing.JPanel BookedContainer_main1;
    private javax.swing.JPanel ClassViewer_list;
    private javax.swing.JPanel Class_Config_panel;
    private javax.swing.JLabel Count_title7;
    private javax.swing.JLabel Count_title8;
    private javax.swing.JPanel Cover;
    private javax.swing.JTable CreatedClasses;
    private javax.swing.JLabel Delecte25;
    private javax.swing.JLabel Delecte26;
    private javax.swing.JPanel SByRoomType;
    private javax.swing.JLabel SaveClass;
    private javax.swing.JPanel Searching_panel_holder;
    private javax.swing.JLabel addRoom_type;
    private javax.swing.JPanel add_compusary_subject;
    private javax.swing.JPanel admin_btn;
    private javax.swing.JPanel building_classes_panel;
    private javax.swing.JPanel class_entry;
    private javax.swing.JComboBox class_level;
    private javax.swing.JLabel class_name;
    private javax.swing.JComboBox combAp;
    private javax.swing.JComboBox combGrade;
    private javax.swing.JComboBox comb_class_name;
    private javax.swing.JComboBox combo_room;
    private javax.swing.JLabel edit19;
    private javax.swing.JLabel exit_lb;
    private javax.swing.JPanel frontSide_btn_holder;
    private javax.swing.JLabel header;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel196;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lb_ByRoomType;
    private javax.swing.JLabel lb_UpdateClass;
    private javax.swing.JLabel lb_bg_btnFirstView2;
    private javax.swing.JLabel lb_bg_btnFirstView3;
    private javax.swing.JLabel lb_class_period;
    private javax.swing.JLabel lb_classname;
    private javax.swing.JLabel lb_number_ofSubjects;
    private javax.swing.JLabel lb_numclasses;
    private javax.swing.JLabel lb_reloads;
    private javax.swing.JLabel lb_reloads1;
    private javax.swing.JLabel lb_reloads2;
    private javax.swing.JLabel lb_reloads5;
    private javax.swing.JLabel lb_reloads6;
    private javax.swing.JButton level_change;
    private javax.swing.JLabel minize_lb;
    private javax.swing.JTextField mixm_numberOf_subject;
    private javax.swing.JLabel model;
    private javax.swing.JPanel panel_Teachers;
    private javax.swing.JPanel right;
    private javax.swing.JTable subject_table;
    private javax.swing.JLabel table_holder_bg16;
    private javax.swing.JTextField timeOut;
    private javax.swing.JComboBox txtPeriod;
    private javax.swing.JTextField txtTime;
    // End of variables declaration//GEN-END:variables
}
