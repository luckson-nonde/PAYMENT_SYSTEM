package hotel.management;

import com.sun.corba.se.impl.presentation.rmi.ExceptionHandler;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import javax.imageio.ImageIO;
public class Admin_Home extends javax.swing.JFrame {

      Connection conn = null;
      PreparedStatement pps, pps1, pps2, pps3, pps4, pps6, pps5, pps7, pps8, pps9, pps10, pps11, pps12 ,pps13 = null;
      ResultSet rs, rs1, rs2, rs3, rs4, rs5, rs6, rs7, rs8, rs9, rs10, rs11, rs12 ,rs13= null;


    String Structure_status = null;
    String RoomStatus = null;
    String Hall_Status = null;

    String Time_Limit = null;
    String Amenities_status = null;

    String  usertype = null;   //RESOURCES FOR EDITING
    
    String holdStatus_for_houseKeeping = null; //check box
    String house_keeping_id_resuorce = null;

    String RESOURCE_FOR_STRUCTURE_ID = null;   //RESOURCES FOR EDITING
    String RESOURSE_FOR_STRUCTURE_ID = null;//rsource for adding structure id into room 

    //container variables that holds passed on info
    private String pass_user_id;
    private String user_name;

   String global_user_id = null; // A variable thats holds the id 
   
    String  user_access_id = null; 
    String resuorce = null;//resource to hold the id for amenities after qurying the avaliable content then use it when updating

    private static Admin_Home Obj = null;
    
      int xx = 0;
      int yy = 0;

       Admin_Home() {
        initComponents();
        
         ShowRoomType_onTable();
         Count_Roomtype();
         ComboDisplay();
         changeIcon();
       }
    
       
 
       
 
    public void icon(){
       try {conn = DBConnection.getConnction();
            pps = conn.prepareStatement(" SELECT  * FROM  access WHERE access_id =?");
            pps.setString(1,global_user_id.trim()); 
            rs = pps.executeQuery();
            byte[] image = null;
            while(rs.next()){
                 user_access_id  =  rs.getString("access_id");

                 String fname=  rs.getString("first_name");
                 String lname=  rs.getString("last_name");
                 lb_user.setText(fname +"  "+lname);
                 user_mode.setText(rs.getString("user"));
              
                 
                 image = rs.getBytes("user_pic");
                 Image img = Toolkit.getDefaultToolkit().createImage(image);
                 ImageIcon icon = new ImageIcon(img);

                Image modifiedImaged = img.getScaledInstance(img_usera.getWidth(), img_usera.getHeight(), Image.SCALE_SMOOTH);
                icon = new ImageIcon(modifiedImaged);
                user_img.setIcon(icon);
                }
            } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    
    //*********************************************************GETTING CURRENT USER ID
    public void setUserID(String user_id) {
        pass_user_id = user_id;
    }

    public String getUserID() {
        return pass_user_id;
    }

    public void printUserID() {
        global_user_id = getUserID();//setting the id of the user who logged in and set it to a global variable
         icon();
         changeIcon();
    }
    
    
     public void changeIcon(){
      
                  if(user_mode.getText().equals("Administration")){
                    access3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_padlock_13px.png"))); 
                    access4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_padlock_13px.png"))); 
                    access5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_padlock_13px.png"))); 
                    access6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_padlock_13px.png"))); 
                    access7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_padlock_13px.png"))); 
                    access.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_padlock_13px.png"))); 

                 }else if(user_mode.getText().equals("Accountant")){
                    access4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_padlock_13px.png"))); 
                    access5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_padlock_13px.png"))); 
                    access6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_padlock_13px.png"))); 
                 
                 }else if(user_mode.getText().equals("Reception")){
                    access4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_padlock_13px.png"))); 
                    access5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_padlock_13px.png"))); 
                    access6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_padlock_13px.png"))); 
                 }
  
  }     
    
    
    
    
    
    public void ComboDisplay() {
            //---------------------------------------------------------------floors----------------------------------------  
            try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("SELECT * FROM structure_type");
            rs = pps.executeQuery();
            while (rs.next()) {
 
            } } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public void Count_Roomtype() {
        // /-----------------------------------------------------------------Count_Roomtype-------------------------------  
  
        try {
                        conn = DBConnection.getConnction();

            pps9 = conn.prepareStatement("SELECT  count(structure_id) FROM  structure_type");
            rs9 = pps9.executeQuery();
            if (rs9.next()) {
                String sum = rs9.getString("count(structure_id)");
                FloorCount_lb_FM.setText(sum);
                employees_lb_onRoom.setText(sum);  
                
                structure_lb_onRooms.setText(sum);  
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }

        
       
        
        
//-----------------------------------------------------------------floor count-------------------------------
        try {
             conn = DBConnection.getConnction();
            pps8 = conn.prepareStatement("SELECT  count(classroom_id) FROM  rooms");
            rs8 = pps8.executeQuery();
            if (rs8.next()) {
                String sum = rs8.getString("count(classroom_id)");
                RoomCount_lb_FM.setText(sum);
                
                Rooms_lb_onRooms.setText(sum);
                
            }
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

   

        // /-----------------------------------------------------------------hall type countroomcount16-------------------------------
        try {
                        conn = DBConnection.getConnction();

            pps7 = conn.prepareStatement("SELECT  count(employeeid) FROM  employee");
            rs7 = pps7.executeQuery();
            if (rs7.next()) {
                String sum = rs7.getString("count(employeeid)");
                roomcount19.setText(sum);
                
                employees_lb_onRoom.setText(sum);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }

        // /-----------------------------------------------------------------hall type countroomcount16-------------------------------
        try {
           conn = DBConnection.getConnction();

            pps6 = conn.prepareStatement("SELECT  count(student_ids) FROM  students");
            rs6 = pps6.executeQuery();
            if (rs6.next()) {
                String sum = rs6.getString("count(student_ids)");
                roomcount20.setText(sum);
                
                Students_lb_onRooms.setText(sum);

            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        
        
        
        
       
        
             // /-----------------------------------------------------------------Roomcount-------------------------------
        try {
                        conn = DBConnection.getConnction();

            pps = conn.prepareStatement("SELECT  count(classroom_id) FROM  rooms");
            rs = pps.executeQuery();
            if (rs.next()) {
                String sum = rs.getString("count(classroom_id)");
                Rooms_lb_onRooms.setText(sum);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // /-----------------------------------------------------------------displying table content on jtable-----------------------------------------------------
    public void ShowRoomType_onTable() {//school srtucture

        try {
            conn = DBConnection.getConnction();
            String sql = " SELECT structure_name,room_number,room_type,room_capacity,room_status FROM structure_type, rooms WHERE structure_type.structure_id = rooms.structure_id";
            pps = conn.prepareStatement(sql);
            rs = pps.executeQuery();
            Rooms_Table_display.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //struture  Structure_Table_display
        try {
           

            conn = DBConnection.getConnction();
            String sql = " SELECT structure_number,structure_capacity,structure_types,structure_name,structure_status FROM structure_type";
            pps = conn.prepareStatement(sql);
            rs = pps.executeQuery();
            Structure_Table_display.setModel(DbUtils.resultSetToTableModel(rs));//showing content on the floor table list
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    //show structure on room creation 
        //struture  
        try {
            
            conn = DBConnection.getConnction();
            String sql = " SELECT * FROM structure_type";
            pps = conn.prepareStatement(sql);
            rs = pps.executeQuery();
            while (rs.next()) {
                Structure_onComboSelection.addItem(rs.getString("structure_name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }

      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jLabel62 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        Main_container = new javax.swing.JPanel();
        minize_lb = new javax.swing.JLabel();
        exit_lb = new javax.swing.JLabel();
        user_mode = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        left = new javax.swing.JPanel();
        Side_Panel = new javax.swing.JPanel();
        btnShow = new javax.swing.JPanel();
        dash = new javax.swing.JLabel();
        Button_holder = new javax.swing.JPanel();
        cover = new javax.swing.JPanel();
        send_noitice1 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        access9 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        admin_btn1 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        access10 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        send_noitice = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        access8 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        send_noitice2 = new javax.swing.JPanel();
        jLabel78 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        access11 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        admin_btn2 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        access12 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        Structure_btnLay2 = new javax.swing.JPanel();
        btn_rooms = new javax.swing.JPanel();
        rooms = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        btn_hall = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        btn_structuretype = new javax.swing.JPanel();
        floors = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        btn_hall1 = new javax.swing.JPanel();
        halls1 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        reports = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        front_holder = new javax.swing.JPanel();
        Structure = new javax.swing.JPanel();
        access = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        admin_btn = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        access7 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        expenses = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        access6 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        Adminstrative = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        access4 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        HR = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        access3 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        expenses1 = new javax.swing.JPanel();
        jLabel94 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        access5 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        lb_user = new javax.swing.JLabel();
        img_usera = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        user_img = new javax.swing.JLabel();
        Class_config_holder = new javax.swing.JPanel();
        home_page = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        home_cover = new javax.swing.JPanel();
        pay = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        backgroud_img = new javax.swing.JLabel();
        profile = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        dash_img = new javax.swing.JLabel();
        lb_department = new javax.swing.JLabel();
        lb_email = new javax.swing.JLabel();
        lb_name = new javax.swing.JLabel();
        lb_location = new javax.swing.JLabel();
        lb_designation = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 6), new java.awt.Dimension(0, 6), new java.awt.Dimension(32767, 6));
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        structureDesign = new javax.swing.JPanel();
        jLabel115 = new javax.swing.JLabel();
        Count_title16 = new javax.swing.JLabel();
        RoomCount_lb_FM = new javax.swing.JLabel();
        Count_title42 = new javax.swing.JLabel();
        lb_hold16 = new javax.swing.JLabel();
        lb_hold18 = new javax.swing.JLabel();
        roomcount19 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        lb_hold19 = new javax.swing.JLabel();
        roomcount20 = new javax.swing.JLabel();
        Count_title19 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        main_structure = new javax.swing.JPanel();
        Structure_list = new javax.swing.JPanel();
        table_header = new javax.swing.JPanel();
        jLabel196 = new javax.swing.JLabel();
        jLabel197 = new javax.swing.JLabel();
        jLabel198 = new javax.swing.JLabel();
        jLabel214 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        Structure_Table_display = new javax.swing.JTable();
        btn_container1 = new javax.swing.JPanel();
        btn_FirstView1 = new javax.swing.JPanel();
        search_structure = new javax.swing.JTextField();
        Add_price2 = new javax.swing.JLabel();
        lb_bg_btnFirstView1 = new javax.swing.JLabel();
        btn_secondView1 = new javax.swing.JPanel();
        Delecte13 = new javax.swing.JLabel();
        edit13 = new javax.swing.JLabel();
        add_floor = new javax.swing.JLabel();
        lb_bg_btnSecondView1 = new javax.swing.JLabel();
        table_holder_bg11 = new javax.swing.JLabel();
        Structure_entry = new javax.swing.JPanel();
        Struture_name = new javax.swing.JTextField();
        Struture_number = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Structure_description = new javax.swing.JTextArea();
        jLabel33 = new javax.swing.JLabel();
        StructureType = new javax.swing.JComboBox();
        jLabel32 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        active_structure = new javax.swing.JCheckBox();
        jLabel113 = new javax.swing.JLabel();
        inactive_structure = new javax.swing.JCheckBox();
        jLabel118 = new javax.swing.JLabel();
        update_structureEntry = new javax.swing.JButton();
        Savebtn = new javax.swing.JButton();
        Struture_capacity = new javax.swing.JTextField();
        Count_title18 = new javax.swing.JLabel();
        Reload_combo = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        gb = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        FloorCount_lb_FM = new javax.swing.JLabel();
        Count_title17 = new javax.swing.JLabel();
        lb_hold17 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        RoomsDesign = new javax.swing.JPanel();
        Students_lb_onRooms = new javax.swing.JLabel();
        Count_title4 = new javax.swing.JLabel();
        lb_hold7 = new javax.swing.JLabel();
        lb_hold5 = new javax.swing.JLabel();
        lb_hold6 = new javax.swing.JLabel();
        lb_hold4 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        Count_title45 = new javax.swing.JLabel();
        employees_lb_onRoom = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        structure_lb_onRooms = new javax.swing.JLabel();
        Count_title6 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        Rooms_lb_onRooms = new javax.swing.JLabel();
        Count_title7 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_container2 = new javax.swing.JPanel();
        btn_FirstView2 = new javax.swing.JPanel();
        search_rooms = new javax.swing.JTextField();
        Add_price3 = new javax.swing.JLabel();
        lb_bg_btnFirstView2 = new javax.swing.JLabel();
        btn_secondView2 = new javax.swing.JPanel();
        House_keeping = new javax.swing.JLabel();
        Delecte1 = new javax.swing.JLabel();
        edit3 = new javax.swing.JLabel();
        Add_rooms = new javax.swing.JLabel();
        lb_bg_btnSecondView2 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        Rooms_Table_display = new javax.swing.JTable();
        jPanel26 = new javax.swing.JPanel();
        jLabel193 = new javax.swing.JLabel();
        jLabel199 = new javax.swing.JLabel();
        jLabel195 = new javax.swing.JLabel();
        jLabel213 = new javax.swing.JLabel();
        jLabel215 = new javax.swing.JLabel();
        table_holder_bg1 = new javax.swing.JLabel();
        panel_for_halls = new javax.swing.JPanel();
        edit4 = new javax.swing.JLabel();
        edit11 = new javax.swing.JLabel();
        Delecte3 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel201 = new javax.swing.JLabel();
        jLabel202 = new javax.swing.JLabel();
        jLabel203 = new javax.swing.JLabel();
        jLabel204 = new javax.swing.JLabel();
        jScrollPane22 = new javax.swing.JScrollPane();
        halls_Table_display = new javax.swing.JTable();
        table_holder_bg3 = new javax.swing.JLabel();
        roomcount14 = new javax.swing.JLabel();
        Count_title13 = new javax.swing.JLabel();
        lb_hold13 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        lb_hold12 = new javax.swing.JLabel();
        Count_title12 = new javax.swing.JLabel();
        lb_Halltype_Count_Hs = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        Count_title14 = new javax.swing.JLabel();
        FloorCount_lb_Hs = new javax.swing.JLabel();
        lb_hold14 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        Count_title15 = new javax.swing.JLabel();
        lb_Halls_Count_Hs = new javax.swing.JLabel();
        lb_hold15 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        MakeHall_type_Holder = new javax.swing.JPanel();
        jLabel119 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        title8 = new javax.swing.JLabel();
        title14 = new javax.swing.JLabel();
        title21 = new javax.swing.JLabel();
        txtShortCode1 = new javax.swing.JTextField();
        txtSlug1 = new javax.swing.JTextField();
        txtTitle1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDescrip1 = new javax.swing.JTextArea();
        title22 = new javax.swing.JLabel();
        title23 = new javax.swing.JLabel();
        txtBasicOccupancy1 = new javax.swing.JTextField();
        txtHighOc1 = new javax.swing.JTextField();
        Save_Halltype = new javax.swing.JLabel();
        title26 = new javax.swing.JLabel();
        combo_Floor_CH = new javax.swing.JComboBox();
        title31 = new javax.swing.JLabel();
        txtHall_number = new javax.swing.JTextField();
        title33 = new javax.swing.JLabel();
        title32 = new javax.swing.JLabel();
        jCheckBox7 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        title29 = new javax.swing.JLabel();
        jCheckBox8 = new javax.swing.JCheckBox();
        title34 = new javax.swing.JLabel();
        title28 = new javax.swing.JLabel();
        bg_addRoomtype2 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        Count_title5 = new javax.swing.JLabel();
        price_manager_holder = new javax.swing.JPanel();
        jLabel164 = new javax.swing.JLabel();
        tit_for_page = new javax.swing.JLabel();
        tit_for_table = new javax.swing.JLabel();
        bg_for_price = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        tit_forCombo_Roomtype = new javax.swing.JLabel();
        makeRooms_holder = new javax.swing.JPanel();
        jLabel163 = new javax.swing.JLabel();
        jLabel165 = new javax.swing.JLabel();
        title11 = new javax.swing.JLabel();
        title13 = new javax.swing.JLabel();
        title20 = new javax.swing.JLabel();
        CreateRooms = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel166 = new javax.swing.JLabel();
        title17 = new javax.swing.JLabel();
        title19 = new javax.swing.JLabel();
        title15 = new javax.swing.JLabel();
        Structure_onComboSelection = new javax.swing.JComboBox();
        txtRoom_number = new javax.swing.JTextField();
        Room_type = new javax.swing.JTextField();
        room_capacity = new javax.swing.JTextField();
        title24 = new javax.swing.JLabel();
        title18 = new javax.swing.JLabel();
        bg_addRoomtype1 = new javax.swing.JLabel();
        background_home = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel62.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(204, 204, 204));
        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_grand_master_key_25px_2.png"))); // NOI18N
        jLabel62.setText("  Logged In As");
        getContentPane().add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 4, 120, 50));

        jLabel19.setText("jLabel19");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(-200, 280, -1, -1));

        Main_container.setBackground(new java.awt.Color(153, 153, 153));
        Main_container.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        Main_container.setForeground(new java.awt.Color(255, 255, 255));
        Main_container.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        minize_lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minize_lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_minus_19px.png"))); // NOI18N
        minize_lb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minize_lbMouseClicked(evt);
            }
        });
        Main_container.add(minize_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 0, 60, 60));

        exit_lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit_lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_delete_18px_1.png"))); // NOI18N
        exit_lb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit_lbMouseClicked(evt);
            }
        });
        Main_container.add(exit_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 0, 50, 60));

        user_mode.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        user_mode.setForeground(new java.awt.Color(172, 170, 170));
        Main_container.add(user_mode, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 10, 100, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/header.png"))); // NOI18N
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel1MouseDragged(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        Main_container.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1370, 80));

        left.setBackground(new java.awt.Color(153, 153, 153));
        Main_container.add(left, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 0, 30, 790));

        Side_Panel.setBackground(new java.awt.Color(66, 66, 66));
        Side_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnShow.setBackground(new java.awt.Color(102, 102, 102));
        btnShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnShowMouseClicked(evt);
            }
        });
        btnShow.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dash.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dash.setForeground(new java.awt.Color(255, 255, 255));
        dash.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_circled_menu_40px.png"))); // NOI18N
        dash.setText("        Dashboard");
        btnShow.add(dash, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 50));

        Side_Panel.add(btnShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 210, 60));

        Button_holder.setLayout(new java.awt.CardLayout());

        cover.setBackground(new java.awt.Color(121, 119, 119));
        cover.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        send_noitice1.setBackground(new java.awt.Color(121, 119, 119));
        send_noitice1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                send_noitice1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                send_noitice1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                send_noitice1MouseExited(evt);
            }
        });
        send_noitice1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel70.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_upload_to_ftp_30px.png"))); // NOI18N
        send_noitice1.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 50, -1));

        jLabel96.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel96.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        send_noitice1.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 30, 30));

        access9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_unlock_19px.png"))); // NOI18N
        send_noitice1.add(access9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 20, 30));

        jLabel71.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setText("   Send Notice");
        send_noitice1.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 110, 30));

        cover.add(send_noitice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 210, 50));

        admin_btn1.setBackground(new java.awt.Color(121, 119, 119));
        admin_btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        admin_btn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_btn1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                admin_btn1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                admin_btn1MouseExited(evt);
            }
        });
        admin_btn1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel72.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_administrative_tools_30px_1.png"))); // NOI18N
        admin_btn1.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        jLabel97.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel97.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        admin_btn1.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 40));

        access10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_unlock_19px.png"))); // NOI18N
        admin_btn1.add(access10, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 0, -1, 40));

        jLabel77.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jLabel77.setText("Complaints View");
        admin_btn1.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 100, 40));

        cover.add(admin_btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 210, 50));

        send_noitice.setBackground(new java.awt.Color(121, 119, 119));
        send_noitice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                send_noiticeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                send_noiticeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                send_noiticeMouseExited(evt);
            }
        });
        send_noitice.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel68.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_upload_to_ftp_30px.png"))); // NOI18N
        send_noitice.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 50, 30));

        jLabel95.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel95.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        send_noitice.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 30, 30));

        access8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_unlock_19px.png"))); // NOI18N
        send_noitice.add(access8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 20, 30));

        jLabel69.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("   Approve lessons ");
        send_noitice.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 110, 30));

        cover.add(send_noitice, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 210, 50));

        send_noitice2.setBackground(new java.awt.Color(121, 119, 119));
        send_noitice2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                send_noitice2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                send_noitice2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                send_noitice2MouseExited(evt);
            }
        });
        send_noitice2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel78.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_upload_to_ftp_30px.png"))); // NOI18N
        send_noitice2.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 50, 30));

        jLabel98.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel98.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        send_noitice2.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 30, 30));

        access11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_unlock_19px.png"))); // NOI18N
        send_noitice2.add(access11, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 20, 30));

        jLabel85.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setText("   Approve Expense ");
        send_noitice2.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 140, 30));

        cover.add(send_noitice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 210, 50));

        admin_btn2.setBackground(new java.awt.Color(121, 119, 119));
        admin_btn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        admin_btn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admin_btn2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                admin_btn2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                admin_btn2MouseExited(evt);
            }
        });
        admin_btn2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel87.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(255, 255, 255));
        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_administrative_tools_30px_1.png"))); // NOI18N
        admin_btn2.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        jLabel99.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        admin_btn2.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 40));

        access12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_unlock_19px.png"))); // NOI18N
        admin_btn2.add(access12, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 20, 40));

        jLabel88.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
        jLabel88.setText(" Manage User Access");
        admin_btn2.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 130, 40));

        cover.add(admin_btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 210, 50));

        Button_holder.add(cover, "card6");

        Structure_btnLay2.setBackground(new java.awt.Color(121, 119, 119));
        Structure_btnLay2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_rooms.setBackground(new java.awt.Color(121, 119, 119));
        btn_rooms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_roomsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_roomsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_roomsMouseExited(evt);
            }
        });

        rooms.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        rooms.setForeground(new java.awt.Color(255, 255, 255));
        rooms.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rooms.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_weight_care_30px.png"))); // NOI18N
        rooms.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel61.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("GENERATE ROOMS");

        javax.swing.GroupLayout btn_roomsLayout = new javax.swing.GroupLayout(btn_rooms);
        btn_rooms.setLayout(btn_roomsLayout);
        btn_roomsLayout.setHorizontalGroup(
            btn_roomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_roomsLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(btn_roomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rooms, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        btn_roomsLayout.setVerticalGroup(
            btn_roomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_roomsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rooms, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        Structure_btnLay2.add(btn_rooms, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 210, 90));

        btn_hall.setBackground(new java.awt.Color(121, 119, 119));
        btn_hall.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_hallMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_hallMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_hallMouseExited(evt);
            }
        });

        jLabel29.setBackground(new java.awt.Color(102, 102, 102));
        jLabel29.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_double_right_35px_1.png"))); // NOI18N
        jLabel29.setText("GENERATE CLASSES  ");
        jLabel29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel29.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel29.setName("next"); // NOI18N

        javax.swing.GroupLayout btn_hallLayout = new javax.swing.GroupLayout(btn_hall);
        btn_hall.setLayout(btn_hallLayout);
        btn_hallLayout.setHorizontalGroup(
            btn_hallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_hallLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        btn_hallLayout.setVerticalGroup(
            btn_hallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_hallLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        Structure_btnLay2.add(btn_hall, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 210, 80));

        btn_structuretype.setBackground(new java.awt.Color(121, 119, 119));
        btn_structuretype.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_structuretypeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_structuretypeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_structuretypeMouseExited(evt);
            }
        });

        floors.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        floors.setForeground(new java.awt.Color(255, 255, 255));
        floors.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        floors.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_octahedron_30px.png"))); // NOI18N
        floors.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel60.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("GENERATE STRUCTURES ");

        javax.swing.GroupLayout btn_structuretypeLayout = new javax.swing.GroupLayout(btn_structuretype);
        btn_structuretype.setLayout(btn_structuretypeLayout);
        btn_structuretypeLayout.setHorizontalGroup(
            btn_structuretypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_structuretypeLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(floors, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(btn_structuretypeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_structuretypeLayout.setVerticalGroup(
            btn_structuretypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_structuretypeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(floors, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        Structure_btnLay2.add(btn_structuretype, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 210, 80));

        btn_hall1.setBackground(new java.awt.Color(121, 119, 119));
        btn_hall1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_hall1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_hall1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_hall1MouseExited(evt);
            }
        });

        halls1.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        halls1.setForeground(new java.awt.Color(255, 255, 255));
        halls1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        halls1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_verified_account_30px.png"))); // NOI18N
        halls1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel64.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("GENERATE HALL");

        javax.swing.GroupLayout btn_hall1Layout = new javax.swing.GroupLayout(btn_hall1);
        btn_hall1.setLayout(btn_hall1Layout);
        btn_hall1Layout.setHorizontalGroup(
            btn_hall1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_hall1Layout.createSequentialGroup()
                .addGroup(btn_hall1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btn_hall1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(halls1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(btn_hall1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        btn_hall1Layout.setVerticalGroup(
            btn_hall1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_hall1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(halls1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        Structure_btnLay2.add(btn_hall1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 210, -1));

        Button_holder.add(Structure_btnLay2, "card3");

        reports.setBackground(new java.awt.Color(121, 119, 119));
        reports.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel80.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(255, 255, 255));
        jLabel80.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_round_15px_1.png"))); // NOI18N
        jLabel80.setText("  Expenses");
        jLabel80.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reports.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 160, 50));

        jLabel81.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(255, 255, 255));
        jLabel81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_round_15px_1.png"))); // NOI18N
        jLabel81.setText("  Occupancy");
        jLabel81.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reports.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 160, 50));

        jLabel82.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_round_15px_1.png"))); // NOI18N
        jLabel82.setText("  Guests");
        jLabel82.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reports.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 160, 50));

        jLabel83.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_round_15px_1.png"))); // NOI18N
        jLabel83.setText("  Financial");
        jLabel83.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reports.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 160, 50));

        jLabel84.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_round_15px_1.png"))); // NOI18N
        jLabel84.setText("  Coupon");
        jLabel84.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reports.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 160, 50));

        Button_holder.add(reports, "card5");

        front_holder.setBackground(new java.awt.Color(121, 119, 119));
        front_holder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        front_holder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                front_holderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                front_holderMouseExited(evt);
            }
        });
        front_holder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Structure.setBackground(new java.awt.Color(121, 119, 119));
        Structure.setToolTipText("Generate a vitual structure");
        Structure.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StructureMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                StructureMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                StructureMouseExited(evt);
            }
        });
        Structure.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        access.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_unlock_19px.png"))); // NOI18N
        Structure.add(access, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 30, 40));

        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        Structure.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 20, 40));

        jLabel21.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_autism_30px.png"))); // NOI18N
        Structure.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 40));

        jLabel20.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText(" Structure Config");
        Structure.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 100, 40));

        front_holder.add(Structure, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 210, 50));

        admin_btn.setBackground(new java.awt.Color(121, 119, 119));
        admin_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_administrative_tools_30px_1.png"))); // NOI18N
        admin_btn.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        admin_btn.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 40));

        access7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_unlock_19px.png"))); // NOI18N
        admin_btn.add(access7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 30, 20));

        jLabel67.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText(" System  Settings");
        admin_btn.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 40));

        front_holder.add(admin_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 210, 50));

        expenses.setBackground(new java.awt.Color(121, 119, 119));
        expenses.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        jLabel92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        expenses.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 20, 40));

        jLabel46.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_general_ledger_30px.png"))); // NOI18N
        expenses.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        access6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_unlock_19px.png"))); // NOI18N
        expenses.add(access6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 20, 40));

        jLabel66.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setText("  Inventory Manager");
        expenses.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 130, 40));

        front_holder.add(expenses, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 210, 50));

        Adminstrative.setBackground(new java.awt.Color(121, 119, 119));
        Adminstrative.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AdminstrativeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AdminstrativeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AdminstrativeMouseExited(evt);
            }
        });
        Adminstrative.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_upload_to_ftp_30px.png"))); // NOI18N
        Adminstrative.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 50, 40));

        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel93.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        Adminstrative.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 30, 40));

        access4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_unlock_19px.png"))); // NOI18N
        Adminstrative.add(access4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 20, 40));

        jLabel63.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("   Adminstrative");
        Adminstrative.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 110, 40));

        front_holder.add(Adminstrative, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 210, 70));

        HR.setBackground(new java.awt.Color(121, 119, 119));
        HR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HRMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HRMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HRMouseExited(evt);
            }
        });
        HR.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel73.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_weight_care_30px.png"))); // NOI18N
        HR.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel74.setText("Search Records");
        jPanel31.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        HR.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 130, 30));

        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel75.setText("Search Records");
        jPanel32.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel76.setText("Search Records");
        jPanel33.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel32.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 130, 30));

        HR.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 130, 30));

        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        HR.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 20, 40));

        access3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_unlock_19px.png"))); // NOI18N
        HR.add(access3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 20, 40));

        jLabel23.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("    HR Management");
        HR.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 110, 40));

        front_holder.add(HR, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 210, 50));

        expenses1.setBackground(new java.awt.Color(121, 119, 119));
        expenses1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        expenses1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                expenses1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                expenses1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                expenses1MouseExited(evt);
            }
        });
        expenses1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel94.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel94.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        expenses1.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 40));

        jLabel47.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_general_ledger_30px.png"))); // NOI18N
        expenses1.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        access5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_unlock_19px.png"))); // NOI18N
        expenses1.add(access5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 20, 40));

        jLabel65.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("Generator  ID");
        expenses1.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 90, 40));

        front_holder.add(expenses1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 210, 50));

        Button_holder.add(front_holder, "card2");

        Side_Panel.add(Button_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 210, 630));

        jPanel28.setBackground(new java.awt.Color(121, 119, 119));
        jPanel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel28MouseClicked(evt);
            }
        });
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_user.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        lb_user.setForeground(new java.awt.Color(255, 255, 255));
        lb_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_ok_12px.png"))); // NOI18N
        lb_user.setText("name");
        jPanel28.add(lb_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 120, 20));

        img_usera.setBackground(new java.awt.Color(121, 119, 119));
        img_usera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icon.png"))); // NOI18N
        img_usera.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 90));

        user_img.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        user_img.setForeground(new java.awt.Color(153, 153, 153));
        user_img.setPreferredSize(new java.awt.Dimension(50, 60));
        img_usera.add(user_img, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, 70));

        jPanel28.add(img_usera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 100));

        Side_Panel.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 100));

        Main_container.add(Side_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 210, 710));

        Class_config_holder.setBackground(new java.awt.Color(255, 255, 255));
        Class_config_holder.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Class_config_holder.setLayout(new java.awt.CardLayout());

        home_page.setBackground(new java.awt.Color(255, 255, 255));
        home_page.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setText("Go To My Settings");
        home_page.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 110, 30));

        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setText("School Details and Database");
        home_page.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 190, 30));

        jLabel22.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(204, 204, 204));
        jLabel22.setText("Go To My Admin");
        home_page.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, 110, 30));

        jLabel24.setForeground(new java.awt.Color(204, 204, 204));
        jLabel24.setText("Student Registration, Payments");
        home_page.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 180, 30));

        jLabel15.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setText("Work Force");
        home_page.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, 110, 30));

        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("Create  Departments, Employees");
        home_page.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 50, 190, 30));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_registration_50px.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        home_page.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 250, 80));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_settings_50px.png"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        home_page.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 260, 80));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/shortcut3.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        home_page.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 10, 330, 100));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/shortcut2.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        home_page.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 340, 100));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_unit_50px.png"))); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        home_page.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, 250, 70));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/shortcut1.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        home_page.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 330, 90));

        jPanel4.setLayout(new java.awt.CardLayout());

        home_cover.setBackground(new java.awt.Color(255, 255, 255));
        home_cover.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_create_document_90px.png"))); // NOI18N
        pay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                payMouseClicked(evt);
            }
        });
        home_cover.add(pay, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 120, 130));

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_paid_parking_90px.png"))); // NOI18N
        jLabel18.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        home_cover.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 130, 130));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_pass_fail_90px.png"))); // NOI18N
        jLabel25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });
        home_cover.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 90, 90, 110));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_id_verified_90px.png"))); // NOI18N
        jLabel26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });
        home_cover.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 280, 110, 100));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_gantt_chart_90px.png"))); // NOI18N
        jLabel27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        home_cover.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, 80, 80));

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Clock_Settings_90px.png"))); // NOI18N
        jLabel30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        home_cover.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 390, 100, 120));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(102, 102, 102));
        jLabel31.setText("INVENTORY");
        home_cover.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 70, 90, 40));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(102, 102, 102));
        jLabel34.setText("MANAGEMENT");
        home_cover.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 100, 110, 30));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(102, 102, 102));
        jLabel35.setText("IDENTFIATION");
        home_cover.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 290, 110, 40));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(102, 102, 102));
        jLabel36.setText("GENERATION");
        home_cover.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 320, 80, 30));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(102, 102, 102));
        jLabel37.setText("REGISTRATION");
        home_cover.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 100, 40));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(102, 102, 102));
        jLabel39.setText("MANAGEMENT");
        home_cover.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, 30));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(102, 102, 102));
        jLabel40.setText("STUDENT");
        home_cover.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, -1, 40));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(102, 102, 102));
        jLabel43.setText("REPORT");
        home_cover.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 480, -1, 40));

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(102, 102, 102));
        jLabel48.setText("ANALYSIS");
        home_cover.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 500, -1, 40));

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(102, 102, 102));
        jLabel53.setText("RECORDS HISTORY");
        home_cover.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 460, 150, 40));

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(102, 102, 102));
        jLabel54.setText("VIEW PORTAL");
        home_cover.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 490, 90, 40));

        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_business_network_60px.png"))); // NOI18N
        home_cover.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 80, 80));

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(102, 102, 102));
        jLabel56.setText("TM");
        home_cover.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, 50, 40));

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(102, 102, 102));
        jLabel58.setText("instant");
        home_cover.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 120, 50));

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(102, 102, 102));
        jLabel57.setText("PAYMENT");
        home_cover.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, 80));

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(102, 102, 102));
        jLabel59.setText("SMS");
        home_cover.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 150, 50));

        backgroud_img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backgroud_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/home.png"))); // NOI18N
        home_cover.add(backgroud_img, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, -100, 1130, 810));

        jPanel4.add(home_cover, "card3");

        profile.setBackground(new java.awt.Color(255, 255, 255));
        profile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dash_img.setPreferredSize(new java.awt.Dimension(150, 120));
        jPanel3.add(dash_img, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 190));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 250, 190));

        lb_department.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lb_department.setForeground(new java.awt.Color(102, 102, 102));
        lb_department.setText("name");
        jPanel2.add(lb_department, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 200, 20));

        lb_email.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lb_email.setForeground(new java.awt.Color(102, 102, 102));
        lb_email.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_send_email_13px.png"))); // NOI18N
        lb_email.setText("name");
        jPanel2.add(lb_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 300, 30));

        lb_name.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        lb_name.setForeground(new java.awt.Color(102, 102, 102));
        lb_name.setText("name");
        jPanel2.add(lb_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 300, 40));

        lb_location.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lb_location.setForeground(new java.awt.Color(102, 102, 102));
        lb_location.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_location_13px.png"))); // NOI18N
        lb_location.setText("name");
        jPanel2.add(lb_location, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, 300, 40));

        lb_designation.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lb_designation.setForeground(new java.awt.Color(102, 102, 102));
        lb_designation.setText("name");
        jPanel2.add(lb_designation, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 200, 20));
        jPanel2.add(filler1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 50, 80));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_ok_12px.png"))); // NOI18N
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 20, 20));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Address");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 80, 40));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Email");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 80, 30));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Department");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 80, 30));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Designation");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 80, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1080, 520));

        profile.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1140, 550));

        jPanel4.add(profile, "card2");

        home_page.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1150, 600));

        Class_config_holder.add(home_page, "card2");

        structureDesign.setBackground(new java.awt.Color(255, 255, 255));
        structureDesign.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel115.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(153, 153, 153));
        jLabel115.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel115.setText("STRUCTURE  MANAGEMENT");
        structureDesign.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 50));

        Count_title16.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title16.setForeground(new java.awt.Color(33, 173, 178));
        Count_title16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title16.setText("Rooms");
        structureDesign.add(Count_title16, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 80, 30));

        RoomCount_lb_FM.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RoomCount_lb_FM.setText("00");
        structureDesign.add(RoomCount_lb_FM, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 70, 30));

        Count_title42.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title42.setForeground(new java.awt.Color(33, 173, 178));
        Count_title42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title42.setText("Employees");
        structureDesign.add(Count_title42, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 100, 20));

        lb_hold16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_condo_30px.png"))); // NOI18N
        structureDesign.add(lb_hold16, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 60, 60));

        lb_hold18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_direction_30px.png"))); // NOI18N
        structureDesign.add(lb_hold18, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, 60, 60));

        roomcount19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roomcount19.setText("45");
        structureDesign.add(roomcount19, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 90, 80, 30));

        jLabel116.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/counter4.png"))); // NOI18N
        jLabel116.setText("jLabel41");
        structureDesign.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 250, 80));

        lb_hold19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_literature_30px.png"))); // NOI18N
        structureDesign.add(lb_hold19, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 60, 60, 60));

        roomcount20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roomcount20.setText("45");
        structureDesign.add(roomcount20, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 80, 60, 30));

        Count_title19.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title19.setForeground(new java.awt.Color(33, 173, 178));
        Count_title19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title19.setText("Students");
        structureDesign.add(Count_title19, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 50, 90, 50));

        jLabel117.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/count4.png"))); // NOI18N
        jLabel117.setText("jLabel41");
        structureDesign.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 50, 250, 80));

        jLabel134.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/count.png"))); // NOI18N
        structureDesign.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 260, 80));

        main_structure.setBackground(new java.awt.Color(255, 255, 255));
        main_structure.setLayout(new java.awt.CardLayout());

        Structure_list.setBackground(new java.awt.Color(255, 255, 255));
        Structure_list.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_header.setBackground(new java.awt.Color(255, 255, 255));
        table_header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel196.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel196.setForeground(new java.awt.Color(140, 140, 140));
        jLabel196.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel196.setText("Structure Number");
        table_header.add(jLabel196, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 50));

        jLabel197.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel197.setForeground(new java.awt.Color(140, 140, 140));
        jLabel197.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel197.setText("  Status");
        table_header.add(jLabel197, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, 140, 50));

        jLabel198.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel198.setForeground(new java.awt.Color(140, 140, 140));
        jLabel198.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel198.setText("  Capacity");
        table_header.add(jLabel198, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 150, 50));

        jLabel214.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel214.setForeground(new java.awt.Color(140, 140, 140));
        jLabel214.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel214.setText("   Type");
        table_header.add(jLabel214, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 140, 50));

        Structure_list.add(table_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 820, 50));

        Structure_Table_display.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        Structure_Table_display.setForeground(new java.awt.Color(140, 140, 140));
        Structure_Table_display.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Structure_Table_display.setGridColor(new java.awt.Color(255, 255, 255));
        Structure_Table_display.setIntercellSpacing(new java.awt.Dimension(20, 5));
        Structure_Table_display.setRowHeight(30);
        Structure_Table_display.setTableHeader(null);
        Structure_Table_display.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Structure_Table_displayMouseClicked(evt);
            }
        });
        jScrollPane20.setViewportView(Structure_Table_display);

        Structure_list.add(jScrollPane20, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 820, 360));

        btn_container1.setBackground(new java.awt.Color(255, 255, 255));
        btn_container1.setLayout(new java.awt.CardLayout());

        btn_FirstView1.setBackground(new java.awt.Color(255, 255, 255));
        btn_FirstView1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        search_structure.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search_structureKeyTyped(evt);
            }
        });
        btn_FirstView1.add(search_structure, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 190, 30));

        Add_price2.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Add_price2.setForeground(new java.awt.Color(255, 255, 255));
        Add_price2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Add_price2.setText(" structure");
        Add_price2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_price2MouseClicked(evt);
            }
        });
        btn_FirstView1.add(Add_price2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 100, 50));

        lb_bg_btnFirstView1.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        lb_bg_btnFirstView1.setForeground(new java.awt.Color(255, 255, 255));
        lb_bg_btnFirstView1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_bg_btnFirstView1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        btn_FirstView1.add(lb_bg_btnFirstView1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 340, 80));

        btn_container1.add(btn_FirstView1, "card3");

        btn_secondView1.setBackground(new java.awt.Color(255, 255, 255));
        btn_secondView1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Delecte13.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte13.setForeground(new java.awt.Color(255, 255, 255));
        Delecte13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_no_entry_25px.png"))); // NOI18N
        Delecte13.setText("Delecte");
        Delecte13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Delecte13MouseClicked(evt);
            }
        });
        btn_secondView1.add(Delecte13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 50));

        edit13.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        edit13.setForeground(new java.awt.Color(255, 255, 255));
        edit13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_upload_to_ftp_30px.png"))); // NOI18N
        edit13.setText("Edit");
        edit13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edit13MouseClicked(evt);
            }
        });
        btn_secondView1.add(edit13, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 100, 50));

        add_floor.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        add_floor.setForeground(new java.awt.Color(255, 255, 255));
        add_floor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        add_floor.setText(" structure");
        add_floor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_floorMouseClicked(evt);
            }
        });
        btn_secondView1.add(add_floor, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 100, 50));

        lb_bg_btnSecondView1.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        lb_bg_btnSecondView1.setForeground(new java.awt.Color(255, 255, 255));
        lb_bg_btnSecondView1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_bg_btnSecondView1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        lb_bg_btnSecondView1.setText("Delecte");
        btn_secondView1.add(lb_bg_btnSecondView1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 360, 70));

        btn_container1.add(btn_secondView1, "card2");

        Structure_list.add(btn_container1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, 320, 60));

        table_holder_bg11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        table_holder_bg11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/display.png"))); // NOI18N
        Structure_list.add(table_holder_bg11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1150, 530));

        main_structure.add(Structure_list, "card8");

        Structure_entry.setBackground(new java.awt.Color(255, 255, 255));
        Structure_entry.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Structure_entry.add(Struture_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 310, 40));
        Structure_entry.add(Struture_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, 310, 40));

        Structure_description.setColumns(20);
        Structure_description.setRows(5);
        jScrollPane1.setViewportView(Structure_description);

        Structure_entry.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, 350, 140));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel33.setText("Struture type");
        Structure_entry.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 130, 40));

        StructureType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Floors", "Blocks", "Rooms" }));
        Structure_entry.add(StructureType, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 310, 40));

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel32.setText("Struture Name");
        Structure_entry.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 130, 40));

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel41.setText("Struture Number");
        Structure_entry.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 130, 40));

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel44.setText("Struture Capacity");
        Structure_entry.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 380, 110, 40));

        jLabel112.setText("Active");
        Structure_entry.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 440, 80, 40));

        buttonGroup2.add(active_structure);
        active_structure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                active_structureActionPerformed(evt);
            }
        });
        Structure_entry.add(active_structure, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 450, 60, -1));

        jLabel113.setText("Inactive");
        Structure_entry.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 440, 100, 40));

        buttonGroup2.add(inactive_structure);
        inactive_structure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inactive_structureActionPerformed(evt);
            }
        });
        Structure_entry.add(inactive_structure, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 450, 60, -1));

        jLabel118.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel118.setText("Struture Status");
        Structure_entry.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, 130, 40));

        update_structureEntry.setText("update");
        update_structureEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_structureEntryActionPerformed(evt);
            }
        });
        Structure_entry.add(update_structureEntry, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 450, 90, 30));

        Savebtn.setBackground(new java.awt.Color(123, 166, 144));
        Savebtn.setForeground(new java.awt.Color(255, 255, 255));
        Savebtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Savebtn.setText("Add");
        Savebtn.setBorder(null);
        Savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SavebtnActionPerformed(evt);
            }
        });
        Structure_entry.add(Savebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 450, 100, 30));
        Structure_entry.add(Struture_capacity, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 380, 350, 40));

        Count_title18.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title18.setForeground(new java.awt.Color(33, 173, 178));
        Count_title18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_30px.png"))); // NOI18N
        Count_title18.setText("Back Floor list");
        Count_title18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Count_title18MouseClicked(evt);
            }
        });
        Structure_entry.add(Count_title18, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 80, 130, 50));

        Reload_combo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_submit_progress_25px.png"))); // NOI18N
        Reload_combo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Reload_comboMouseClicked(evt);
            }
        });
        Structure_entry.add(Reload_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, 40, 40));

        jLabel79.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel79.setText("Description");
        Structure_entry.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, 70, 50));

        gb.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        gb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/Untitled-2.png"))); // NOI18N
        Structure_entry.add(gb, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1160, 470));

        main_structure.add(Structure_entry, "card3");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        main_structure.add(jPanel16, "card4");

        structureDesign.add(main_structure, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1140, 560));

        FloorCount_lb_FM.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        FloorCount_lb_FM.setText("00");
        structureDesign.add(FloorCount_lb_FM, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 80, 30));

        Count_title17.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title17.setForeground(new java.awt.Color(33, 173, 178));
        Count_title17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title17.setText("Structure");
        structureDesign.add(Count_title17, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 120, 50));

        lb_hold17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Escalator_Down_30px.png"))); // NOI18N
        structureDesign.add(lb_hold17, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 60, 60));

        jLabel114.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/count2.png"))); // NOI18N
        structureDesign.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 260, 80));

        Class_config_holder.add(structureDesign, "card8");

        RoomsDesign.setBackground(new java.awt.Color(255, 255, 255));
        RoomsDesign.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Students_lb_onRooms.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Students_lb_onRooms.setText("45");
        RoomsDesign.add(Students_lb_onRooms, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 90, 80, 30));

        Count_title4.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title4.setForeground(new java.awt.Color(33, 173, 178));
        Count_title4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title4.setText("Students");
        RoomsDesign.add(Count_title4, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 60, 100, 30));

        lb_hold7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_direction_30px.png"))); // NOI18N
        RoomsDesign.add(lb_hold7, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, 60, 60));

        lb_hold5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_condo_30px.png"))); // NOI18N
        RoomsDesign.add(lb_hold5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 60, 60));

        lb_hold6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Escalator_Down_30px.png"))); // NOI18N
        RoomsDesign.add(lb_hold6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 60, 60));

        lb_hold4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_literature_30px.png"))); // NOI18N
        RoomsDesign.add(lb_hold4, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 60, 60, 60));

        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/count4.png"))); // NOI18N
        jLabel49.setText("jLabel41");
        RoomsDesign.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 50, 250, 80));

        Count_title45.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title45.setForeground(new java.awt.Color(33, 173, 178));
        Count_title45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title45.setText("Employees");
        RoomsDesign.add(Count_title45, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 100, 30));

        employees_lb_onRoom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        employees_lb_onRoom.setText("45");
        RoomsDesign.add(employees_lb_onRoom, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 90, 80, 30));

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/counter4.png"))); // NOI18N
        jLabel50.setText("jLabel41");
        RoomsDesign.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 250, 80));

        structure_lb_onRooms.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        structure_lb_onRooms.setText("45");
        RoomsDesign.add(structure_lb_onRooms, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 100, 70, 20));

        Count_title6.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title6.setForeground(new java.awt.Color(33, 173, 178));
        Count_title6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title6.setText("Structure");
        RoomsDesign.add(Count_title6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 100, 50));

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/count2.png"))); // NOI18N
        jLabel51.setText("jLabel41");
        RoomsDesign.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 250, 80));

        Rooms_lb_onRooms.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Rooms_lb_onRooms.setText("45");
        RoomsDesign.add(Rooms_lb_onRooms, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 70, 20));

        Count_title7.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title7.setForeground(new java.awt.Color(33, 173, 178));
        Count_title7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title7.setText("Rooms");
        RoomsDesign.add(Count_title7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 100, 30));

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/count.png"))); // NOI18N
        RoomsDesign.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 260, 80));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(33, 173, 178));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ROOMS");
        RoomsDesign.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 50));

        btn_container2.setBackground(new java.awt.Color(255, 255, 255));
        btn_container2.setLayout(new java.awt.CardLayout());

        btn_FirstView2.setBackground(new java.awt.Color(255, 255, 255));
        btn_FirstView2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        search_rooms.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search_roomsKeyTyped(evt);
            }
        });
        btn_FirstView2.add(search_rooms, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 220, 30));

        Add_price3.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Add_price3.setForeground(new java.awt.Color(255, 255, 255));
        Add_price3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Add_price3.setText(" Rooms");
        Add_price3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_price3MouseClicked(evt);
            }
        });
        btn_FirstView2.add(Add_price3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 100, 50));

        lb_bg_btnFirstView2.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        lb_bg_btnFirstView2.setForeground(new java.awt.Color(255, 255, 255));
        lb_bg_btnFirstView2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_bg_btnFirstView2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        btn_FirstView2.add(lb_bg_btnFirstView2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 60));

        btn_container2.add(btn_FirstView2, "card3");

        btn_secondView2.setBackground(new java.awt.Color(255, 255, 255));
        btn_secondView2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        House_keeping.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        House_keeping.setForeground(new java.awt.Color(255, 255, 255));
        House_keeping.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_housekeeping_30px.png"))); // NOI18N
        House_keeping.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                House_keepingMouseClicked(evt);
            }
        });
        btn_secondView2.add(House_keeping, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, 40));

        Delecte1.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte1.setForeground(new java.awt.Color(255, 255, 255));
        Delecte1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_no_entry_25px.png"))); // NOI18N
        Delecte1.setText("Delecte");
        Delecte1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Delecte1MouseClicked(evt);
            }
        });
        btn_secondView2.add(Delecte1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, 40));

        edit3.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        edit3.setForeground(new java.awt.Color(255, 255, 255));
        edit3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_upload_to_ftp_30px.png"))); // NOI18N
        edit3.setText("Edit");
        edit3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edit3MouseClicked(evt);
            }
        });
        btn_secondView2.add(edit3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 80, 40));

        Add_rooms.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Add_rooms.setForeground(new java.awt.Color(255, 255, 255));
        Add_rooms.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Add_rooms.setText(" Rooms");
        Add_rooms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_roomsMouseClicked(evt);
            }
        });
        btn_secondView2.add(Add_rooms, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 80, 40));

        lb_bg_btnSecondView2.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        lb_bg_btnSecondView2.setForeground(new java.awt.Color(255, 255, 255));
        lb_bg_btnSecondView2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_bg_btnSecondView2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        lb_bg_btnSecondView2.setText("Delecte");
        btn_secondView2.add(lb_bg_btnSecondView2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 400, 70));

        btn_container2.add(btn_secondView2, "card2");

        RoomsDesign.add(btn_container2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 590, 360, 60));

        Rooms_Table_display.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        Rooms_Table_display.setForeground(new java.awt.Color(140, 140, 140));
        Rooms_Table_display.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Rooms_Table_display.setGridColor(new java.awt.Color(255, 255, 255));
        Rooms_Table_display.setIntercellSpacing(new java.awt.Dimension(20, 5));
        Rooms_Table_display.setRowHeight(30);
        Rooms_Table_display.setTableHeader(null);
        Rooms_Table_display.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Rooms_Table_displayMouseClicked(evt);
            }
        });
        jScrollPane19.setViewportView(Rooms_Table_display);

        RoomsDesign.add(jScrollPane19, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 950, 370));

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel193.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel193.setForeground(new java.awt.Color(153, 153, 153));
        jLabel193.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel193.setText("Structure ");
        jPanel26.add(jLabel193, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 50));

        jLabel199.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel199.setForeground(new java.awt.Color(153, 153, 153));
        jLabel199.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel199.setText("   Status");
        jPanel26.add(jLabel199, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, 120, 50));

        jLabel195.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel195.setForeground(new java.awt.Color(153, 153, 153));
        jLabel195.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel195.setText("  Type");
        jPanel26.add(jLabel195, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 100, 50));

        jLabel213.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel213.setForeground(new java.awt.Color(153, 153, 153));
        jLabel213.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel213.setText(" Capacity");
        jPanel26.add(jLabel213, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 140, 50));

        jLabel215.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel215.setForeground(new java.awt.Color(153, 153, 153));
        jLabel215.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel215.setText(" Room  ");
        jPanel26.add(jLabel215, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 120, 50));

        RoomsDesign.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 950, 50));

        table_holder_bg1.setForeground(new java.awt.Color(255, 255, 255));
        table_holder_bg1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        table_holder_bg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/display.png"))); // NOI18N
        RoomsDesign.add(table_holder_bg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1130, 590));

        Class_config_holder.add(RoomsDesign, "card4");

        panel_for_halls.setBackground(new java.awt.Color(255, 255, 255));
        panel_for_halls.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        edit4.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        edit4.setForeground(new java.awt.Color(255, 255, 255));
        edit4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        edit4.setText("Hall");
        edit4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edit4MouseClicked(evt);
            }
        });
        panel_for_halls.add(edit4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 640, 100, 40));

        edit11.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        edit11.setForeground(new java.awt.Color(255, 255, 255));
        edit11.setText("Edit");
        panel_for_halls.add(edit11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 640, 50, 40));

        Delecte3.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte3.setForeground(new java.awt.Color(255, 255, 255));
        Delecte3.setText("Delecte");
        panel_for_halls.add(Delecte3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 640, -1, 40));

        jLabel101.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        panel_for_halls.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 610, 350, 90));

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel201.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel201.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel201.setText("  STATUS");
        jPanel29.add(jLabel201, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 100, 50));

        jLabel202.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel202.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel202.setText("  NAME");
        jPanel29.add(jLabel202, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 40));

        jLabel203.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel203.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel203.setText("  HALL CAPACITY");
        jPanel29.add(jLabel203, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 140, 50));

        jLabel204.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel204.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel204.setText("  SHORT CODE");
        jPanel29.add(jLabel204, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 120, 50));

        panel_for_halls.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 800, 50));

        halls_Table_display.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        halls_Table_display.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        halls_Table_display.setGridColor(new java.awt.Color(255, 255, 255));
        halls_Table_display.setIntercellSpacing(new java.awt.Dimension(20, 5));
        halls_Table_display.setRowHeight(30);
        halls_Table_display.setTableHeader(null);
        jScrollPane22.setViewportView(halls_Table_display);

        panel_for_halls.add(jScrollPane22, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 800, -1));

        table_holder_bg3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        table_holder_bg3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/display.png"))); // NOI18N
        panel_for_halls.add(table_holder_bg3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1130, 580));

        roomcount14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roomcount14.setText("45");
        panel_for_halls.add(roomcount14, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 80, 60, 30));

        Count_title13.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title13.setForeground(new java.awt.Color(33, 173, 178));
        Count_title13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title13.setText("Booked");
        panel_for_halls.add(Count_title13, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 50, 100, 40));

        lb_hold13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_literature_30px.png"))); // NOI18N
        panel_for_halls.add(lb_hold13, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 60, 60, 60));

        jLabel105.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/count4.png"))); // NOI18N
        jLabel105.setText("jLabel41");
        panel_for_halls.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 50, 250, 80));

        lb_hold12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_direction_30px.png"))); // NOI18N
        panel_for_halls.add(lb_hold12, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, 60, 60));

        Count_title12.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title12.setForeground(new java.awt.Color(33, 173, 178));
        Count_title12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title12.setText("Hall Types");
        panel_for_halls.add(Count_title12, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 100, 20));

        lb_Halltype_Count_Hs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_Halltype_Count_Hs.setText("45");
        panel_for_halls.add(lb_Halltype_Count_Hs, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 80, 60, 30));

        jLabel106.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/counter4.png"))); // NOI18N
        jLabel106.setText("jLabel41");
        panel_for_halls.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 250, 80));

        Count_title14.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title14.setForeground(new java.awt.Color(33, 173, 178));
        Count_title14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title14.setText("Floors");
        panel_for_halls.add(Count_title14, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 120, 40));

        FloorCount_lb_Hs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        FloorCount_lb_Hs.setText("45");
        panel_for_halls.add(FloorCount_lb_Hs, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 60, 30));

        lb_hold14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Escalator_Down_30px.png"))); // NOI18N
        panel_for_halls.add(lb_hold14, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 60, 60));

        jLabel107.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/counter3.png"))); // NOI18N
        panel_for_halls.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 260, 80));

        Count_title15.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title15.setForeground(new java.awt.Color(33, 173, 178));
        Count_title15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title15.setText("Halls ");
        panel_for_halls.add(Count_title15, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 100, 30));

        lb_Halls_Count_Hs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_Halls_Count_Hs.setText("45");
        panel_for_halls.add(lb_Halls_Count_Hs, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 50, 40));

        lb_hold15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_condo_30px.png"))); // NOI18N
        panel_for_halls.add(lb_hold15, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 60, 60));

        jLabel108.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/count.png"))); // NOI18N
        panel_for_halls.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 260, 80));

        jLabel109.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(33, 173, 178));
        jLabel109.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel109.setText("Halls");
        panel_for_halls.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 50));

        Class_config_holder.add(panel_for_halls, "card6");

        MakeHall_type_Holder.setBackground(new java.awt.Color(255, 255, 255));
        MakeHall_type_Holder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel119.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(33, 173, 178));
        jLabel119.setText("Details");
        MakeHall_type_Holder.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 60, 40));

        jLabel45.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Hall TYPES ENTRY");
        MakeHall_type_Holder.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 70, 160, 60));

        title8.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        title8.setText("Title");
        MakeHall_type_Holder.add(title8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 150, 30));

        title14.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        title14.setText("Slug");
        MakeHall_type_Holder.add(title14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 160, 40));

        title21.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        title21.setText("Short Code");
        MakeHall_type_Holder.add(title21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 150, 40));

        txtShortCode1.setBackground(new java.awt.Color(204, 204, 204));
        txtShortCode1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        MakeHall_type_Holder.add(txtShortCode1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 280, 40));

        txtSlug1.setBackground(new java.awt.Color(204, 204, 204));
        txtSlug1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        MakeHall_type_Holder.add(txtSlug1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 280, 40));

        txtTitle1.setBackground(new java.awt.Color(204, 204, 204));
        txtTitle1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        MakeHall_type_Holder.add(txtTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 280, 40));

        txtDescrip1.setColumns(20);
        txtDescrip1.setRows(5);
        jScrollPane3.setViewportView(txtDescrip1);

        MakeHall_type_Holder.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 430, 420, 140));

        title22.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        title22.setText("    Description");
        MakeHall_type_Holder.add(title22, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 360, 110, 70));

        title23.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        title23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_insert_white_space_30px.png"))); // NOI18N
        title23.setText("Base Occupancy");
        MakeHall_type_Holder.add(title23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 160, 40));

        txtBasicOccupancy1.setBackground(new java.awt.Color(204, 204, 204));
        txtBasicOccupancy1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        MakeHall_type_Holder.add(txtBasicOccupancy1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 440, 280, 40));

        txtHighOc1.setBackground(new java.awt.Color(204, 204, 204));
        txtHighOc1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        MakeHall_type_Holder.add(txtHighOc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 520, 280, 40));

        Save_Halltype.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        Save_Halltype.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Save_Halltype.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_add_35px.png"))); // NOI18N
        Save_Halltype.setText("Save");
        Save_Halltype.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Save_HalltypeMouseClicked(evt);
            }
        });
        MakeHall_type_Holder.add(Save_Halltype, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 150, 90, 40));

        title26.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        title26.setText("Structure type");
        MakeHall_type_Holder.add(title26, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 120, 30));

        MakeHall_type_Holder.add(combo_Floor_CH, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 210, 320, 40));

        title31.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        title31.setText("Hall Numer");
        MakeHall_type_Holder.add(title31, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, 120, 40));

        txtHall_number.setBackground(new java.awt.Color(204, 204, 204));
        txtHall_number.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 5, 1, 1));
        MakeHall_type_Holder.add(txtHall_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 290, 320, 40));

        title33.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        title33.setText("Operational ");
        MakeHall_type_Holder.add(title33, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 610, 90, 40));

        title32.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        title32.setText("Maintance");
        MakeHall_type_Holder.add(title32, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 610, 80, 40));

        buttonGroup1.add(jCheckBox7);
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });
        MakeHall_type_Holder.add(jCheckBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 620, -1, 20));

        buttonGroup1.add(jCheckBox6);
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });
        MakeHall_type_Holder.add(jCheckBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 620, -1, 20));

        title29.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        title29.setText("Decommisioned");
        MakeHall_type_Holder.add(title29, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 610, 120, 40));

        buttonGroup1.add(jCheckBox8);
        jCheckBox8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox8ActionPerformed(evt);
            }
        });
        MakeHall_type_Holder.add(jCheckBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 620, -1, 20));

        title34.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        title34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_insert_white_space_30px.png"))); // NOI18N
        title34.setText("Room Status");
        MakeHall_type_Holder.add(title34, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 600, 150, 50));

        title28.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        title28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_add_white_space_30px.png"))); // NOI18N
        title28.setText(" Higher Occupancy");
        MakeHall_type_Holder.add(title28, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 160, 30));

        bg_addRoomtype2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bg_addRoomtype2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/add_Room_typebg.png"))); // NOI18N
        MakeHall_type_Holder.add(bg_addRoomtype2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 40, 1180, 630));

        jLabel120.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(33, 173, 178));
        jLabel120.setText("Hall TYPE ");
        MakeHall_type_Holder.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 50));

        Count_title5.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title5.setForeground(new java.awt.Color(33, 173, 178));
        Count_title5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_30px.png"))); // NOI18N
        Count_title5.setText("  Hall Type  List");
        Count_title5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Count_title5MouseClicked(evt);
            }
        });
        MakeHall_type_Holder.add(Count_title5, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 0, 150, 60));

        Class_config_holder.add(MakeHall_type_Holder, "card13");

        price_manager_holder.setBackground(new java.awt.Color(255, 255, 255));
        price_manager_holder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel164.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel164.setForeground(new java.awt.Color(255, 255, 255));
        jLabel164.setText("Special Prices ");
        price_manager_holder.add(jLabel164, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, 50));

        tit_for_page.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        tit_for_page.setText("Room Type");
        price_manager_holder.add(tit_for_page, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 100, 50));

        tit_for_table.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        tit_for_table.setText("Regular ");
        price_manager_holder.add(tit_for_table, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, 40));

        bg_for_price.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bg_for_price.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/Untitled-2.png"))); // NOI18N
        price_manager_holder.add(bg_for_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(-120, 90, 1460, 490));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        price_manager_holder.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, 320, 40));

        tit_forCombo_Roomtype.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tit_forCombo_Roomtype.setText("Room Type");
        price_manager_holder.add(tit_forCombo_Roomtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, 100, 40));

        Class_config_holder.add(price_manager_holder, "card14");

        makeRooms_holder.setBackground(new java.awt.Color(255, 255, 255));
        makeRooms_holder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel163.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel163.setForeground(new java.awt.Color(255, 255, 255));
        jLabel163.setText("ROOM  ENTRY");
        makeRooms_holder.add(jLabel163, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 100, 160, 60));

        jLabel165.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel165.setForeground(new java.awt.Color(33, 173, 178));
        jLabel165.setText("Details");
        makeRooms_holder.add(jLabel165, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 60, 40));

        title11.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        title11.setText("Structure ");
        makeRooms_holder.add(title11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 140, 40));

        title13.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        title13.setText("Decommisioned");
        makeRooms_holder.add(title13, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 600, 120, 40));

        title20.setFont(new java.awt.Font("Trebuchet MS", 1, 15)); // NOI18N
        title20.setForeground(new java.awt.Color(102, 102, 102));
        title20.setText("Room Type");
        makeRooms_holder.add(title20, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 270, 140, 40));

        CreateRooms.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        CreateRooms.setForeground(new java.awt.Color(153, 153, 153));
        CreateRooms.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_upload_to_cloud_30px.png"))); // NOI18N
        CreateRooms.setText("  Create");
        CreateRooms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreateRoomsMouseClicked(evt);
            }
        });
        makeRooms_holder.add(CreateRooms, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 580, 110, 60));

        buttonGroup1.add(jCheckBox3);
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        makeRooms_holder.add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 610, -1, 20));

        buttonGroup1.add(jCheckBox4);
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });
        makeRooms_holder.add(jCheckBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 610, -1, 20));

        buttonGroup1.add(jCheckBox5);
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });
        makeRooms_holder.add(jCheckBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 610, -1, 20));

        jLabel166.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel166.setForeground(new java.awt.Color(33, 173, 178));
        jLabel166.setText("CREATE ROOMS ");
        makeRooms_holder.add(jLabel166, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, 50));

        title17.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        title17.setText("Maintance");
        makeRooms_holder.add(title17, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 600, 70, 40));

        title19.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        title19.setText("Operational ");
        makeRooms_holder.add(title19, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 600, 90, 40));

        title15.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        title15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_insert_white_space_30px.png"))); // NOI18N
        title15.setText("Room Status");
        makeRooms_holder.add(title15, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 530, 180, 40));

        makeRooms_holder.add(Structure_onComboSelection, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 300, 40));
        makeRooms_holder.add(txtRoom_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, 300, 40));
        makeRooms_holder.add(Room_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 270, 280, 40));
        makeRooms_holder.add(room_capacity, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 390, 270, 40));

        title24.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        title24.setText("Room Number");
        makeRooms_holder.add(title24, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 120, 40));

        title18.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        title18.setText("Room Capcity");
        makeRooms_holder.add(title18, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 390, 120, 40));

        bg_addRoomtype1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bg_addRoomtype1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/add_Room_typebg.png"))); // NOI18N
        makeRooms_holder.add(bg_addRoomtype1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 70, 1180, 630));

        Class_config_holder.add(makeRooms_holder, "card15");

        Main_container.add(Class_config_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 1120, 700));

        background_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/background_admins.png"))); // NOI18N
        background_home.setText("jLabel60");
        Main_container.add(background_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 0, 2000, 920));

        getContentPane().add(Main_container, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 790));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void StructureMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StructureMouseClicked
   //chech if the user is an admin
            try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement(" SELECT  * FROM  access WHERE access_id =?");
            pps.setString(1,global_user_id.trim()); 
            rs = pps.executeQuery();
                 if(rs.next()){
                      String fname=  rs.getString("first_name");
                      String lname=  rs.getString("last_name");
                      lb_user.setText(fname +"  "+lname);
                      usertype=  rs.getString("user");
                     }
                    } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
             
               if(usertype.equals("Administration")){
                       
                    front_holder.hide();
                    reports.hide();
                    Structure_btnLay2.setVisible(true);
                }else if(usertype.equals("Accountant") ){
                        
                    JOptionPane.showMessageDialog(null, "You Have No Access");
                } else if (usertype.equals("Reception")){JOptionPane.showMessageDialog(null, "You Have No Access");}
        
        
        
        
        
      
    }//GEN-LAST:event_StructureMouseClicked

    private void StructureMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StructureMouseEntered
        Structure.setBackground(new Color(33, 173, 178));
    }//GEN-LAST:event_StructureMouseEntered

    private void StructureMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StructureMouseExited
        Structure.setBackground(new Color(121,119,119));
    }//GEN-LAST:event_StructureMouseExited

    private void HRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HRMouseClicked
            //chech if the user is an admin
            try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement(" SELECT  * FROM  access WHERE access_id =?");
            pps.setString(1,global_user_id.trim()); 
            rs = pps.executeQuery();
                 if(rs.next()){
                      String fname=  rs.getString("first_name");
                      String lname=  rs.getString("last_name");
                      lb_user.setText(fname +"  "+lname);
                      usertype=  rs.getString("user");
                     }
                    } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
             
               if(usertype.equals("Administration")){
                    Departments mylayer = new Departments();
                    mylayer.setVisible(true);
                    
                     //**************************************send id
                     mylayer.setPassed_id(global_user_id);
                     mylayer.printPassed_id();
                     this.dispose();
                     //*********************************************
                }else if(usertype.equals("Accountant") ){
                     Departments mylayer = new Departments();
                     mylayer.setVisible(true);
                    
                     //**************************************send id
                     mylayer.setPassed_id(global_user_id);
                     mylayer.printPassed_id();
                     this.dispose();
                     //*********************************************
                } else if (usertype.equals("Reception")){JOptionPane.showMessageDialog(null, "You Have No Access");}
        
        
       
    }//GEN-LAST:event_HRMouseClicked

    private void HRMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HRMouseEntered
        HR.setBackground(new Color(33, 173, 178));

    }//GEN-LAST:event_HRMouseEntered

    private void HRMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HRMouseExited
        HR.setBackground(new Color(121,119,119));

    }//GEN-LAST:event_HRMouseExited

    private void front_holderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_front_holderMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_front_holderMouseEntered

    private void front_holderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_front_holderMouseExited
        // TODO add your handling code here:////////////eixt
        // if(evt.getSource()==MuiltpleOption1 ){
        //   top.setVisible(true);

            //   }

    }//GEN-LAST:event_front_holderMouseExited

    private void btnShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnShowMouseClicked
        if (cover.isShowing()) {
            front_holder.setVisible(true);
            Structure_btnLay2.hide();
            reports.hide();
            cover.hide();

        } else if (!cover.isShowing()) {
            front_holder.hide();
            Structure_btnLay2.hide();
            reports.hide();
            cover.setVisible(true);
            home_page.setVisible(true);
            RoomsDesign.hide();
            panel_for_halls.hide();

        }
    }//GEN-LAST:event_btnShowMouseClicked

    private void admin_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btnMouseClicked
      //chech if the user is an admin
            try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement(" SELECT  * FROM  access WHERE access_id =?");
            pps.setString(1,global_user_id.trim()); 
            rs = pps.executeQuery();
                 if(rs.next()){
                      String fname=  rs.getString("first_name");
                      String lname=  rs.getString("last_name");
                     // lb_user.setText(fname +"  "+lname);
                      usertype=  rs.getString("user");
                     }
                    } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
             
               if(usertype.equals("Administration")){
                            Settings my = new Settings();
                             my.setVisible(true);
                          //**************************************send id
                            my.setPassed_id(global_user_id);
                            my.printPassed_id();
                            this.dispose();

                     //*********************************************
                }else if(usertype.equals("Accountant") ){
                    JOptionPane.showMessageDialog(null, "You Have No Access");
                } else if (usertype.equals("Reception")){JOptionPane.showMessageDialog(null, "You Have No Access");}
        
     
    }//GEN-LAST:event_admin_btnMouseClicked

    private void admin_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btnMouseEntered
        admin_btn.setBackground(new Color(33, 173, 178));

    }//GEN-LAST:event_admin_btnMouseEntered

    private void admin_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btnMouseExited
        admin_btn.setBackground(new Color(121,119,119));
    }//GEN-LAST:event_admin_btnMouseExited

    private void expensesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expensesMouseClicked
        //chech if the user is an admin
            String user_id = null;
            try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement(" SELECT  * FROM  access WHERE access_id =?");
            pps.setString(1,global_user_id.trim()); 
            rs = pps.executeQuery();
                 if(rs.next()){
                      String fname=  rs.getString("first_name");
                      String lname=  rs.getString("last_name");
                      lb_user.setText(fname +"  "+lname);
                      usertype=  rs.getString("user");
                      user_id =  rs.getString("access_id");

                     }
                    } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
             
               if(usertype.equals("Administration")){
                     Inventory in = new Inventory();
                      in.setVisible(true);
                    //**************************************send id
                     in.setPassed_id(user_id);
                     in.printPassed_id();
                     this.dispose();
                     //*********************************************
                }else if(usertype.equals("Accountant") ){
                     Inventory in = new Inventory();
                      in.setVisible(true);
                    //**************************************send id
                     in.setPassed_id(user_id);
                     in.printPassed_id();
                     this.dispose();
                     //*********************************************
                } else if (usertype.equals("Reception")){
                       Inventory in = new Inventory();
                      in.setVisible(true);
                    //**************************************send id
                     in.setPassed_id(user_id);
                     in.printPassed_id();
                     this.dispose();
                     //*********************************************
                }     
        
   
    }//GEN-LAST:event_expensesMouseClicked

    private void expensesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expensesMouseEntered
        expenses.setBackground(new Color(33, 173, 178));

    }//GEN-LAST:event_expensesMouseEntered

    private void expensesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expensesMouseExited
        expenses.setBackground(new Color(121,119,119));

    }//GEN-LAST:event_expensesMouseExited

    private void btn_roomsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_roomsMouseEntered
        btn_rooms.setBackground(new Color(33, 173, 178));
    }//GEN-LAST:event_btn_roomsMouseEntered

    private void btn_hallMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hallMouseEntered
        btn_hall.setBackground(new Color(33, 173, 178));
    }//GEN-LAST:event_btn_hallMouseEntered

    private void btn_structuretypeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_structuretypeMouseEntered
        btn_structuretype.setBackground(new Color(33, 173, 178));
    }//GEN-LAST:event_btn_structuretypeMouseEntered

    private void btn_roomsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_roomsMouseExited
        btn_rooms.setBackground(new Color(121,119,119));

    }//GEN-LAST:event_btn_roomsMouseExited

    private void btn_hallMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hallMouseExited
        btn_hall.setBackground(new Color(121,119,119));

    }//GEN-LAST:event_btn_hallMouseExited

    private void btn_structuretypeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_structuretypeMouseExited
        btn_structuretype.setBackground(new Color(121,119,119));
    }//GEN-LAST:event_btn_structuretypeMouseExited

    private void btn_roomsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_roomsMouseClicked
        home_page.hide();
        panel_for_halls.hide();
        price_manager_holder.hide();
        MakeHall_type_Holder.hide();
        structureDesign.hide();
        RoomsDesign.setVisible(true);

    }//GEN-LAST:event_btn_roomsMouseClicked

    private void btn_structuretypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_structuretypeMouseClicked
        home_page.hide();
        panel_for_halls.hide();
        RoomsDesign.hide();
        price_manager_holder.hide();
        RoomsDesign.hide();
        MakeHall_type_Holder.hide();

        structureDesign.setVisible(true);
    }//GEN-LAST:event_btn_structuretypeMouseClicked

    private void SavebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SavebtnActionPerformed
        try {
              conn = DBConnection.getConnction();
            pps = conn.prepareStatement("SELECT * FROM structure_type WHERE (structure_types =  ? AND structure_name =?) AND (structure_number =  ? AND structure_capacity =?) ");// AND contact = ?
            pps.setString(1, StructureType.getSelectedItem().toString().trim());
            pps.setString(2, Struture_name.getText().trim());
            pps.setString(3, Struture_number.getText().trim());
            pps.setString(4, Struture_capacity.getText().toString().trim());
            rs = pps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Structure Already Exists");
            } else {
                inserting_Structure_afterChecking();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_SavebtnActionPerformed

    public void inserting_Structure_afterChecking() {
        // inserting floors
        try {
           
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("INSERT INTO structure_type (structure_types,structure_name,structure_number, structure_capacity,structure_description, structure_status) VALUES (?,?,?,?,?,?)");
            pps.setString(1, StructureType.getSelectedItem().toString().trim());
            pps.setString(2, Struture_name.getText().trim());
            pps.setString(3, Struture_number.getText().trim());
            pps.setString(4, Struture_capacity.getText().trim());
            pps.setString(5, Structure_description.getText().trim());
            pps.setString(6, Structure_status);
            pps.executeUpdate();
            Struture_name.setText(null);
            Struture_number.setText(null);
            Structure_description.setText(null);
            StructureType.setSelectedIndex(0);
            Struture_capacity.setText(null);
            JOptionPane.showMessageDialog(null, "Successfully");
            ShowRoomType_onTable();//show on tables fuction
            Count_Roomtype();//show on labels for counting
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }


    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
        RoomStatus = "Operational";
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        RoomStatus = "Maintance";
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        RoomStatus = "Decommisioned";
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void Count_title18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Count_title18MouseClicked
        Structure_list.setVisible(true);
        Structure_entry.hide();
        //clear all fields^
        Struture_name.setText(null);
        Struture_number.setText(null);
        Structure_description.setText(null);
        StructureType.removeAllItems();
        StructureType.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Floors", "Blocks", "Rooms"}));

        Struture_capacity.setText(null);
    }//GEN-LAST:event_Count_title18MouseClicked
//SELECT
    private void add_floorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_floorMouseClicked
        Structure_list.hide();
        Structure_entry.setVisible(true);

        update_structureEntry.hide();
        Savebtn.setVisible(true);
    }//GEN-LAST:event_add_floorMouseClicked

    private void Add_roomsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_roomsMouseClicked
        home_page.hide();
        RoomsDesign.hide();
        panel_for_halls.hide();
        RoomsDesign.hide();
        structureDesign.hide();
        price_manager_holder.hide();
        MakeHall_type_Holder.hide();
        makeRooms_holder.setVisible(true);
    }//GEN-LAST:event_Add_roomsMouseClicked

    private void active_structureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_active_structureActionPerformed
        Structure_status = "Active";
    }//GEN-LAST:event_active_structureActionPerformed

    private void inactive_structureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inactive_structureActionPerformed
        Structure_status = "Inactive";
    }//GEN-LAST:event_inactive_structureActionPerformed

    private void CreateRoomsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateRoomsMouseClicked
        //seacrching if there is a room_name and room_number in the room table
        try {
            conn = DBConnection.getConnction();
            String sql = " SELECT * FROM rooms WHERE  room_number =?";
            pps = conn.prepareStatement(sql);
            pps.setString(1, txtRoom_number.getText().trim());
            rs = pps.executeQuery();
            if (rs.next()) {
             JOptionPane.showMessageDialog(null, "Room Already Exists ");

            }else{
                insertRoom();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CreateRoomsMouseClicked

    public void insertRoom() {
        
       //getting  structure  id to insert  rooms  
        try {
            conn = DBConnection.getConnction();
            String sql = " SELECT * FROM structure_type WHERE structure_name =?";
            pps = conn.prepareStatement(sql);
            pps.setString(1, Structure_onComboSelection.getSelectedItem().toString().trim());
            rs = pps.executeQuery();
            if (rs.next()) {
               RESOURSE_FOR_STRUCTURE_ID = rs.getString("structure_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        
        
        
        // inserting rooms

        int formart_Structure_ID = Integer.parseInt(RESOURSE_FOR_STRUCTURE_ID);

        try {
            conn = DBConnection.getConnction();

            String sql = "INSERT INTO rooms (structure_id,room_number,room_type,room_status,room_capacity) VALUES (?,?,?,?,?)";
            pps = conn.prepareStatement(sql);
            pps.setInt(1, formart_Structure_ID);
            pps.setString(2, txtRoom_number.getText().trim());
            pps.setString(3, Room_type.getText().trim());
            pps.setString(4, RoomStatus);
            pps.setString(5, room_capacity.getText());

            pps.executeUpdate();
            Structure_onComboSelection.setSelectedIndex(0);
            txtRoom_number.setText(null);
            Room_type.setText(null);
            room_capacity.setText(null);
            JOptionPane.showMessageDialog(null, "Room Added On Structure");

            ShowRoomType_onTable();//show on tables fuction
            Count_Roomtype();//show on labels for counting
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }


    private void Save_HalltypeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Save_HalltypeMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        try {
                        conn = DBConnection.getConnction();

            String sql = "INSERT INTO hall_type (title,slug, short_code,base_occupancy, high_occupancy,description,structure_type,hall_number,hall_status) VALUES (?,?,?,?,?,?,?,?,?)";
            pps = conn.prepareStatement(sql);
            pps.setString(1, txtTitle1.getText());
            pps.setString(2, txtSlug1.getText());
            pps.setString(3, txtShortCode1.getText());
            pps.setString(4, txtBasicOccupancy1.getText());
            pps.setString(5, txtHighOc1.getText());
            pps.setString(6, txtDescrip1.getText());
            pps.setString(7, combo_Floor_CH.getSelectedItem().toString().trim());
            pps.setString(8, txtHall_number.getText());
            pps.setString(9, Hall_Status);

            pps.executeUpdate();
            txtTitle1.setText(null);
            txtSlug1.setText(null);
            txtShortCode1.setText(null);
            txtBasicOccupancy1.setText(null);
            txtHighOc1.setText(null);
            txtDescrip1.setText(null);
            combo_Floor_CH.setSelectedIndex(0);
            txtHall_number.setText(null);
            JOptionPane.showMessageDialog(null, "Successfully Saved");
            ShowRoomType_onTable();//show on tables fuction
            Count_Roomtype();//show on labels for counting

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }


    }//GEN-LAST:event_Save_HalltypeMouseClicked

    private void Count_title5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Count_title5MouseClicked
        RoomsDesign.hide();
        panel_for_halls.hide();
        RoomsDesign.hide();
        structureDesign.hide();
        price_manager_holder.hide();
        makeRooms_holder.hide();

        home_page.hide();
        MakeHall_type_Holder.hide();

    }//GEN-LAST:event_Count_title5MouseClicked

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        Hall_Status = "Operational";

    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
        Hall_Status = "Maintance";
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void jCheckBox8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox8ActionPerformed
        Hall_Status = "Decommisioned";
    }//GEN-LAST:event_jCheckBox8ActionPerformed

    private void edit4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit4MouseClicked

        home_page.hide();
        RoomsDesign.hide();

        panel_for_halls.hide();
        RoomsDesign.hide();

        price_manager_holder.hide();
        structureDesign.hide();
        MakeHall_type_Holder.setVisible(true);
    }//GEN-LAST:event_edit4MouseClicked

    private void Delecte1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Delecte1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Delecte1MouseClicked

    private void House_keepingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_House_keepingMouseClicked
        // TODO add your handling code here:
        Main_container.hide();

        DefaultTableModel tableMode = (DefaultTableModel) Rooms_Table_display.getModel();
        String ID = tableMode.getValueAt(Rooms_Table_display.getSelectedRow(), 1).toString();
        try {
             conn = DBConnection.getConnction();
            pps = conn.prepareStatement("SELECT * FROM rooms WHERE room_number  = ?");
            pps.setString(1, ID);
            rs = pps.executeQuery();
            if (rs.next()) {
                     //  Room_for_houseKeeping_id_resuorce =rs.getString("house_keeping_id");  

                    //   roomnumber  .setText(rs.getString("room_number")); 
                //   roomtype  .setText(rs.getString("room_type")); 
                //   floor.setText(rs.getString("floor")); 
            }
        } catch (Exception ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_House_keepingMouseClicked

    private void update_structureEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_structureEntryActionPerformed
        // updating
        try {
            conn = DBConnection.getConnction();

            pps = conn.prepareStatement("UPDATE structure_type SET structure_types =?,structure_name =?,structure_number =?, structure_capacity =?,structure_description=?, structure_status =? WHERE structure_id = ?");
            pps.setString(1, StructureType.getSelectedItem().toString().trim());
            pps.setString(2, Struture_name.getText().trim());
            pps.setString(3, Struture_number.getText().trim());
            pps.setString(4, Struture_capacity.getText().trim());
            pps.setString(5, Structure_description.getText().trim());
            pps.setString(6, Structure_status);
            pps.setString(7, RESOURCE_FOR_STRUCTURE_ID);

            pps.executeUpdate();
            Struture_name.setText(null);
            Struture_number.setText(null);
            Structure_description.setText(null);
            StructureType.setSelectedIndex(0);
            Struture_capacity.setText(null);
            JOptionPane.showMessageDialog(null, "Successfully");
            ShowRoomType_onTable();//show on tables fuction
            Count_Roomtype();//show on labels for counting
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_update_structureEntryActionPerformed

    private void AdminstrativeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminstrativeMouseClicked
     //chech if the user is an admin
        String user_id = null;
            try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement(" SELECT  * FROM  access WHERE access_id =?");
            pps.setString(1,global_user_id.trim()); 
            rs = pps.executeQuery();
                 if(rs.next()){
                      String fname=  rs.getString("first_name");
                      String lname=  rs.getString("last_name");
                      lb_user.setText(fname +"  "+lname);
                      usertype=  rs.getString("user");
                      user_id =  rs.getString("access_id");

                     }
                    } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
             
               if(usertype.equals("Administration")){
                    Adminstrative myadm = new Adminstrative();
                    this.dispose();
                    myadm.setVisible(true);
                    //**************************************send id
                     myadm.setPassed_id(user_id);
                     myadm.printPassed_id();
                     //*********************************************
                }else if(usertype.equals("Accountant") ){
                    Adminstrative myadm = new Adminstrative();
                    this.dispose();
                    myadm.setVisible(true);
                      //************************************send id
                     myadm.setPassed_id(user_id);
                     myadm.printPassed_id();
                     //*********************************************
                } else if (usertype.equals("Reception")){
                     Adminstrative myadm = new Adminstrative();
                    this.dispose();
                    myadm.setVisible(true);
                      //************************************send id
                     myadm.setPassed_id(user_id);
                     myadm.printPassed_id();
                     //*********************************************
                }
    }//GEN-LAST:event_AdminstrativeMouseClicked

    
    
    
    private void AdminstrativeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminstrativeMouseEntered
        Adminstrative.setBackground(new Color(33, 173, 178));
    }//GEN-LAST:event_AdminstrativeMouseEntered

    private void AdminstrativeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminstrativeMouseExited

        Adminstrative.setBackground(new Color(121,119,119));

    }//GEN-LAST:event_AdminstrativeMouseExited

    private void edit3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit3MouseClicked
        // hidding the panels
        home_page.hide();
        RoomsDesign.hide();
        panel_for_halls.hide();
        RoomsDesign.hide();
        structureDesign.hide();
        price_manager_holder.hide();
        MakeHall_type_Holder.hide();

        makeRooms_holder.setVisible(true);

    }//GEN-LAST:event_edit3MouseClicked

    private void edit13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit13MouseClicked

        try {
            DefaultTableModel tableMode2 = (DefaultTableModel) Structure_Table_display.getModel();
            String Structure_name = tableMode2.getValueAt(Structure_Table_display.getSelectedRow(), 3).toString();

             conn = DBConnection.getConnction();

            pps = conn.prepareStatement("SELECT * FROM structure_type WHERE structure_name = ?");
            pps.setString(1, Structure_name);
            rs = pps.executeQuery();
            StructureType.removeAllItems();

            if (rs.next()) {
                //if the structure is found put the id nd name in resources
                RESOURCE_FOR_STRUCTURE_ID = rs.getString("structure_id");
                Struture_name.setText(rs.getString("structure_name"));
                Struture_number.setText(rs.getString("structure_number"));
                Structure_description.setText(rs.getString("structure_description"));
                Struture_capacity.setText(rs.getString("structure_capacity"));

                StructureType.addItem(rs.getString("structure_types"));
                String status = rs.getString("structure_status");

                if (status.equalsIgnoreCase("Active")) {
                    active_structure.setSelected(true);

                } else if (status.equalsIgnoreCase("Inactive")) {
                    inactive_structure.setSelected(false);
                }
                Structure_list.hide();   //changing page,, from list to entry ^^
                Structure_entry.setVisible(true);
                update_structureEntry.setVisible(true);
                Savebtn.hide();
            } else {
                JOptionPane.showMessageDialog(null, "structurenot found, Select and Press Edit");
                Structure_list.setVisible(true);  //if name of structure is not found,, stay on the same page
                Structure_entry.hide();
            }
        } catch (Exception ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_edit13MouseClicked

    private void Reload_comboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Reload_comboMouseClicked
        StructureType.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Floors", "Blocks", "Rooms"}));
    }//GEN-LAST:event_Reload_comboMouseClicked

    private void Delecte13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Delecte13MouseClicked
        try {
            DefaultTableModel tableMode2 = (DefaultTableModel) Structure_Table_display.getModel();
            String Structure_name = tableMode2.getValueAt(Structure_Table_display.getSelectedRow(), 3).toString();
                       conn = DBConnection.getConnction();

            pps = conn.prepareStatement("SELECT * FROM structure_type WHERE structure_name = ?");
            pps.setString(1, Structure_name);
            rs = pps.executeQuery();
            if (rs.next()) {
               RESOURCE_FOR_STRUCTURE_ID = rs.getString("structure_id");
               deleteSelected();
            }
        } catch (Exception ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Delecte13MouseClicked

    private void Rooms_Table_displayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Rooms_Table_displayMouseClicked
      if(btn_FirstView2.isShowing()){
          btn_FirstView2.hide();
         btn_secondView2.setVisible(true);
        }else if(btn_secondView2.isShowing()){
          btn_secondView2.hide();
          btn_FirstView2.setVisible(true);
        }

    }//GEN-LAST:event_Rooms_Table_displayMouseClicked

    private void Add_price2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_price2MouseClicked
        // TODO add your handling code here:
         Structure_list.hide();
        Structure_entry.setVisible(true);
        update_structureEntry.hide();
        Savebtn.setVisible(true);
    }//GEN-LAST:event_Add_price2MouseClicked

    private void Structure_Table_displayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Structure_Table_displayMouseClicked

       if(btn_FirstView1.isShowing()){
          btn_FirstView1.hide();
         btn_secondView1.setVisible(true);
        }else if(btn_secondView1.isShowing()){
          btn_secondView1.hide();
          btn_FirstView1.setVisible(true);
        }

    }//GEN-LAST:event_Structure_Table_displayMouseClicked

    private void Add_price3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_price3MouseClicked
        home_page.hide();
        RoomsDesign.hide();
        panel_for_halls.hide();
        RoomsDesign.hide();
        structureDesign.hide();
        price_manager_holder.hide();
        MakeHall_type_Holder.hide();
        makeRooms_holder.setVisible(true);
    }//GEN-LAST:event_Add_price3MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
           //chech if the user is an admin
            try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement(" SELECT  * FROM  access WHERE access_id =?");
            pps.setString(1,global_user_id.trim()); 
            rs = pps.executeQuery();
                 if(rs.next()){
                      String fname=  rs.getString("first_name");
                      String lname=  rs.getString("last_name");
                     // lb_user.setText(fname +"  "+lname);
                      usertype=  rs.getString("user");
                     }
                    } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
             
               if(usertype.equals("Administration")){
                            Settings my = new Settings();
                             my.setVisible(true);
                          //**************************************send id
                            my.setPassed_id(global_user_id);
                            my.printPassed_id();
                            this.dispose();

                     //*********************************************
                }else if(usertype.equals("Accountant") ){
                    JOptionPane.showMessageDialog(null, "You Have No Access");
                } else if (usertype.equals("Reception")){JOptionPane.showMessageDialog(null, "You Have No Access");}
        
        
        
        
       
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jPanel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel28MouseClicked
      
        if(profile.isShowing()){
           profile.hide();
           home_cover.setVisible(true);
        
        }else if(home_cover.isShowing()){
           profile.setVisible(true);
           home_cover.hide();
        }
    }//GEN-LAST:event_jPanel28MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
       
           //chech if the user is an admin
            try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement(" SELECT  * FROM  access WHERE access_id =?");
            pps.setString(1,global_user_id.trim()); 
            rs = pps.executeQuery();
                 if(rs.next()){
                      String fname=  rs.getString("first_name");
                      String lname=  rs.getString("last_name");
                      lb_user.setText(fname +"  "+lname);
                      usertype=  rs.getString("user");
                     }
                    } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
             
               if(usertype.equals("Administration")){
                    Departments mylayer = new Departments();
                    mylayer.setVisible(true);
                    
                     //**************************************send id
                     mylayer.setPassed_id(global_user_id);
                     mylayer.printPassed_id();
                     this.dispose();
                     //*********************************************
                }else if(usertype.equals("Accountant") ){
                     Departments mylayer = new Departments();
                     mylayer.setVisible(true);
                    
                     //**************************************send id
                     mylayer.setPassed_id(global_user_id);
                     mylayer.printPassed_id();
                     this.dispose();
                     //*********************************************
                } else if (usertype.equals("Reception")){JOptionPane.showMessageDialog(null, "You Have No Access");}
        
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
       //chech if the user is an admin
        String user_id = null;
            try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement(" SELECT  * FROM  access WHERE access_id =?");
            pps.setString(1,global_user_id.trim()); 
            rs = pps.executeQuery();
                 if(rs.next()){
                      String fname=  rs.getString("first_name");
                      String lname=  rs.getString("last_name");
                      lb_user.setText(fname +"  "+lname);
                      usertype=  rs.getString("user");
                      user_id =  rs.getString("access_id");

                     }
                    } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
             
               if(usertype.equals("Administration")){
                    Adminstrative myadm = new Adminstrative();
                    this.dispose();
                    myadm.setVisible(true);
                    //**************************************send id
                     myadm.setPassed_id(user_id);
                     myadm.printPassed_id();
                     //*********************************************
                }else if(usertype.equals("Accountant") ){
                    Adminstrative myadm = new Adminstrative();
                    this.dispose();
                    myadm.setVisible(true);
                      //************************************send id
                     myadm.setPassed_id(user_id);
                     myadm.printPassed_id();
                     //*********************************************
                } else if (usertype.equals("Reception")){
                     Adminstrative myadm = new Adminstrative();
                    this.dispose();
                    myadm.setVisible(true);
                      //************************************send id
                     myadm.setPassed_id(user_id);
                     myadm.printPassed_id();
                     //*********************************************
                }
       
    }//GEN-LAST:event_jLabel8MouseClicked

    private void expenses1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expenses1MouseClicked
        //chech if the user is an admin
            String user_id = null;
            try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement(" SELECT  * FROM  access WHERE access_id =?");
            pps.setString(1,global_user_id.trim()); 
            rs = pps.executeQuery();
                 if(rs.next()){
                      String fname=  rs.getString("first_name");
                      String lname=  rs.getString("last_name");
                      lb_user.setText(fname +"  "+lname);
                      usertype=  rs.getString("user");
                      user_id =  rs.getString("access_id");

                     }
                    } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
             
               if(usertype.equals("Administration")){
                     ID_Card_Generetor in = new ID_Card_Generetor();
                      in.setVisible(true);
                    //**************************************send id
                     in.setPassed_id(user_id);
                     in.printPassed_id();
                     this.dispose();
                     //*********************************************
                }else if(usertype.equals("Accountant") ){
                     ID_Card_Generetor in = new ID_Card_Generetor();
                      in.setVisible(true);
                    //**************************************send id
                     in.setPassed_id(user_id);
                     in.printPassed_id();
                     this.dispose();
                     //*********************************************
                } else if (usertype.equals("Reception")){
                       ID_Card_Generetor in = new ID_Card_Generetor();
                      in.setVisible(true);
                    //**************************************send id
                     in.setPassed_id(user_id);
                     in.printPassed_id();
                     this.dispose();
                     //*********************************************
                }      
                
                
       
    }//GEN-LAST:event_expenses1MouseClicked

    private void expenses1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expenses1MouseEntered
        expenses1.setBackground(new Color(33, 173, 178));
    }//GEN-LAST:event_expenses1MouseEntered

    private void expenses1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expenses1MouseExited
        expenses1.setBackground(new Color(121,119,119));
    }//GEN-LAST:event_expenses1MouseExited

    private void payMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_payMouseClicked
                   Adminstrative myadm = new Adminstrative();
                    this.dispose();
                    myadm.setVisible(true);
                    //**************************************send id
                     myadm.setPassed_id(global_user_id);
                     myadm.printPassed_id();
    }//GEN-LAST:event_payMouseClicked

    private void minize_lbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minize_lbMouseClicked
        this.setExtendedState(Admin_Home.ICONIFIED);
    }//GEN-LAST:event_minize_lbMouseClicked

    private void exit_lbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_lbMouseClicked
        Dialog frame = new Dialog();
        frame.setVisible(true);
    }//GEN-LAST:event_exit_lbMouseClicked

    private void search_structureKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_structureKeyTyped
        
    try {

    conn = DBConnection.getConnction();
    String sql = " SELECT structure_number,structure_capacity,structure_types,structure_name,structure_status FROM structure_type   WHERE structure_number  like '%" + search_structure.getText() + "%'  OR structure_capacity  like '%" + search_structure.getText() + "%'   OR  structure_types  like '%" + search_structure.getText() + "%'   OR  structure_name  like '%" + search_structure.getText() + "%' "
                     + "  OR  structure_status  like '%" + search_structure.getText() + "%' ";
    pps8 = conn.prepareStatement(sql);
    rs8 = pps8.executeQuery();
    Structure_Table_display.setModel(DbUtils.resultSetToTableModel(rs8));
    } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

    }//GEN-LAST:event_search_structureKeyTyped

    private void search_roomsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_roomsKeyTyped
     try {
    conn = DBConnection.getConnction();
    String sql = "  SELECT structure_name,room_number,room_type,room_capacity,room_status FROM structure_type, rooms WHERE structure_type.structure_id = rooms.structure_id  AND room_status  like '%" + search_rooms.getText() + "%'  OR room_capacity  like '%" + search_rooms.getText() + "%'   OR  room_type  like '%" + search_rooms.getText() + "%'   OR  structure_name  like '%" + search_rooms.getText() + "%' "
                     + "  OR  room_number  like '%" + search_rooms.getText() + "%' ";
    
    pps7 = conn.prepareStatement(sql);
    rs7 = pps7.executeQuery();
    Rooms_Table_display.setModel(DbUtils.resultSetToTableModel(rs7));
    } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}  
        
        
    }//GEN-LAST:event_search_roomsKeyTyped

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
         int x=evt.getXOnScreen();
         int y=evt.getYOnScreen();
         this.setLocation(x-xx, y-yy);
    }//GEN-LAST:event_jLabel1MouseDragged

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
          xx = evt.getX();
          yy = evt.getY();
    }//GEN-LAST:event_jLabel1MousePressed

    private void btn_hall1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hall1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_hall1MouseClicked

    private void btn_hall1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hall1MouseEntered
        btn_hall1.setBackground(new Color(33, 173, 178));
    }//GEN-LAST:event_btn_hall1MouseEntered

    private void btn_hall1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hall1MouseExited
        btn_hall1.setBackground(new Color(121,119,119));
    }//GEN-LAST:event_btn_hall1MouseExited

    private void btn_hallMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hallMouseClicked
        // TODO add your handling code here:
        
         
        
           //chech if the user is an admin
            try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement(" SELECT  * FROM  access WHERE access_id =?");
            pps.setString(1,global_user_id.trim()); 
            rs = pps.executeQuery();
                 while(rs.next()){
                      String fname=  rs.getString("first_name");
                      String lname=  rs.getString("last_name");
                      lb_user.setText(fname +"  "+lname);
                      usertype=  rs.getString("user");
                     }
                    } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
             
               if(usertype.equals("Administration")){
                      Class_conf myr = new Class_conf();
                      myr.setVisible(true);
                      
                       //**************************************send id
                            myr.setPassed_id(global_user_id);
                            myr.printPassed_id();
                            this.dispose();
                }else if(usertype.equals("Accountant") ){
                     Class_conf myr = new Class_conf();
                      this.dispose();
                      myr.setVisible(true);
                } else if (usertype.equals("Reception")){
                  JOptionPane.showMessageDialog(null, "You Have No Access");

                }
        
        
        
        
    }//GEN-LAST:event_btn_hallMouseClicked

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
                  Adminstrative myadm = new Adminstrative();
                    this.dispose();
                    myadm.setVisible(true);
                    //**************************************send id
                     myadm.setPassed_id(global_user_id);
                     myadm.printPassed_id();
    }//GEN-LAST:event_jLabel18MouseClicked

    private void send_noiticeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_send_noiticeMouseClicked
        String user_id = null;
            try {
            conn = DBConnection.getConnction();
            pps3 = conn.prepareStatement(" SELECT  * FROM  access WHERE access_id =?");
            pps3.setString(1,global_user_id.trim()); 
            rs3 = pps3.executeQuery();
                 if(rs3.next()){
                      String fname=  rs3.getString("first_name");
                      String lname=  rs3.getString("last_name");
                      lb_user.setText(fname +"  "+lname);
                      usertype=  rs3.getString("user");
                      user_id =  rs3.getString("access_id");

                     }
                    } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
             
               if(usertype.equals("Administration")){
                    AdminApprove_lesson_plan myadm = new AdminApprove_lesson_plan();
                    this.dispose();
                    myadm.setVisible(true);
                    //**************************************send id
                     myadm.setPassed_id(user_id);
                     myadm.printPassed_id();
                     //*********************************************
                }else if(usertype.equals("Accountant") ){
                    AdminApprove_lesson_plan myadm = new AdminApprove_lesson_plan();
                    this.dispose();
                    myadm.setVisible(true);
                      //************************************send id
                     myadm.setPassed_id(user_id);
                     myadm.printPassed_id();
                     //*********************************************
                } else if (usertype.equals("Reception")){
                     AdminApprove_lesson_plan myadm = new AdminApprove_lesson_plan();
                    this.dispose();
                    myadm.setVisible(true);
                      //************************************send id
                     myadm.setPassed_id(user_id);
                     myadm.printPassed_id();
                     //*********************************************
                }
    }//GEN-LAST:event_send_noiticeMouseClicked

    private void send_noiticeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_send_noiticeMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_send_noiticeMouseEntered

    private void send_noiticeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_send_noiticeMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_send_noiticeMouseExited

    private void send_noitice1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_send_noitice1MouseClicked
       String user_id = null;
            try {
            conn = DBConnection.getConnction();
            pps3 = conn.prepareStatement(" SELECT  * FROM  access WHERE access_id =?");
            pps3.setString(1,global_user_id.trim()); 
            rs3 = pps3.executeQuery();
                 if(rs3.next()){
                      String fname=  rs3.getString("first_name");
                      String lname=  rs3.getString("last_name");
                      lb_user.setText(fname +"  "+lname);
                      usertype=  rs3.getString("user");
                      user_id =  rs3.getString("access_id");

                     }
                    } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
             
               if(usertype.equals("Administration")){
                    Admin_Notification myadm = new Admin_Notification();
                    this.dispose();
                    myadm.setVisible(true);
                    //**************************************send id
                     myadm.setPassed_id(user_id);
                     myadm.printPassed_id();
                     //*********************************************
                }else if(usertype.equals("Accountant") ){
                    Admin_Notification myadm = new Admin_Notification();
                    this.dispose();
                    myadm.setVisible(true);
                      //************************************send id
                     myadm.setPassed_id(user_id);
                     myadm.printPassed_id();
                     //*********************************************
                } else if (usertype.equals("Reception")){
                     Admin_Notification myadm = new Admin_Notification();
                    this.dispose();
                    myadm.setVisible(true);
                      //************************************send id
                     myadm.setPassed_id(user_id);
                     myadm.printPassed_id();
                     //*********************************************
                }
    }//GEN-LAST:event_send_noitice1MouseClicked

    private void send_noitice1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_send_noitice1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_send_noitice1MouseEntered

    private void send_noitice1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_send_noitice1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_send_noitice1MouseExited

    private void admin_btn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btn1MouseClicked
        
         Admin_Complaints_View.getObj().setVisible(true);
         
       //passing user id 
        Admin_Complaints_View.getObj().setPassed_id(pass_user_id);
        Admin_Complaints_View.getObj().printPassed_id();
        this.dispose();
    }//GEN-LAST:event_admin_btn1MouseClicked

    private void admin_btn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btn1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_admin_btn1MouseEntered

    private void admin_btn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btn1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_admin_btn1MouseExited

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
                  
        Inventory.getObj().setVisible(true);
         
       //passing user id 
        Inventory.getObj().setPassed_id(pass_user_id);
        Inventory.getObj().printPassed_id();
        this.dispose();
        
                   
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        ID_Card_Generetor.getObj().setVisible(true);
       
        ID_Card_Generetor.getObj().setPassed_id(pass_user_id);
        ID_Card_Generetor.getObj().printPassed_id();
        this.dispose();
        
                    
    }//GEN-LAST:event_jLabel26MouseClicked

    private void send_noitice2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_send_noitice2MouseClicked
       
         Admin_Expenses_Approval.getObj().setVisible(true);
       
        Admin_Expenses_Approval.getObj().setPassed_id(pass_user_id);
        Admin_Expenses_Approval.getObj().printPassed_id();
        this.dispose(); 
        
        
    }//GEN-LAST:event_send_noitice2MouseClicked

    private void send_noitice2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_send_noitice2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_send_noitice2MouseEntered

    private void send_noitice2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_send_noitice2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_send_noitice2MouseExited

    private void admin_btn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btn2MouseClicked
         Team_manger.getObj().setVisible(true);
         
       //passing user id 
        Team_manger.getObj().setPassed_id(pass_user_id);
        Team_manger.getObj().printPassed_id();
        this.dispose();
    }//GEN-LAST:event_admin_btn2MouseClicked

    private void admin_btn2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btn2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_admin_btn2MouseEntered

    private void admin_btn2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btn2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_admin_btn2MouseExited

    public void deleteSelected() {
        try {
           conn = DBConnection.getConnction();

            pps = conn.prepareStatement("DELETE  FROM structure_type WHERE structure_id = ?");
            pps.setString(1, RESOURCE_FOR_STRUCTURE_ID);
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Structure Deleted");
            ShowRoomType_onTable();//show on tables fuction
            Count_Roomtype();//show on labels for counting
        } catch (Exception ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    public static Admin_Home getObj() {  //public method for instance Restriction
        if (Obj == null) {
            Obj = new Admin_Home();
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
            java.util.logging.Logger.getLogger(Admin_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Add_price2;
    private javax.swing.JLabel Add_price3;
    private javax.swing.JLabel Add_rooms;
    private javax.swing.JPanel Adminstrative;
    private javax.swing.JPanel Button_holder;
    private javax.swing.JPanel Class_config_holder;
    private javax.swing.JLabel Count_title12;
    private javax.swing.JLabel Count_title13;
    private javax.swing.JLabel Count_title14;
    private javax.swing.JLabel Count_title15;
    private javax.swing.JLabel Count_title16;
    private javax.swing.JLabel Count_title17;
    private javax.swing.JLabel Count_title18;
    private javax.swing.JLabel Count_title19;
    private javax.swing.JLabel Count_title4;
    private javax.swing.JLabel Count_title42;
    private javax.swing.JLabel Count_title45;
    private javax.swing.JLabel Count_title5;
    private javax.swing.JLabel Count_title6;
    private javax.swing.JLabel Count_title7;
    private javax.swing.JLabel CreateRooms;
    private javax.swing.JLabel Delecte1;
    private javax.swing.JLabel Delecte13;
    private javax.swing.JLabel Delecte3;
    private javax.swing.JLabel FloorCount_lb_FM;
    private javax.swing.JLabel FloorCount_lb_Hs;
    private javax.swing.JPanel HR;
    private javax.swing.JLabel House_keeping;
    private javax.swing.JPanel Main_container;
    private javax.swing.JPanel MakeHall_type_Holder;
    private javax.swing.JLabel Reload_combo;
    private javax.swing.JLabel RoomCount_lb_FM;
    private javax.swing.JTextField Room_type;
    private javax.swing.JPanel RoomsDesign;
    private javax.swing.JTable Rooms_Table_display;
    private javax.swing.JLabel Rooms_lb_onRooms;
    private javax.swing.JLabel Save_Halltype;
    private javax.swing.JButton Savebtn;
    private javax.swing.JPanel Side_Panel;
    private javax.swing.JPanel Structure;
    private javax.swing.JComboBox StructureType;
    private javax.swing.JTable Structure_Table_display;
    private javax.swing.JPanel Structure_btnLay2;
    private javax.swing.JTextArea Structure_description;
    private javax.swing.JPanel Structure_entry;
    private javax.swing.JPanel Structure_list;
    private javax.swing.JComboBox Structure_onComboSelection;
    private javax.swing.JTextField Struture_capacity;
    private javax.swing.JTextField Struture_name;
    private javax.swing.JTextField Struture_number;
    private javax.swing.JLabel Students_lb_onRooms;
    private javax.swing.JLabel access;
    private javax.swing.JLabel access10;
    private javax.swing.JLabel access11;
    private javax.swing.JLabel access12;
    private javax.swing.JLabel access3;
    private javax.swing.JLabel access4;
    private javax.swing.JLabel access5;
    private javax.swing.JLabel access6;
    private javax.swing.JLabel access7;
    private javax.swing.JLabel access8;
    private javax.swing.JLabel access9;
    private javax.swing.JCheckBox active_structure;
    private javax.swing.JLabel add_floor;
    private javax.swing.JPanel admin_btn;
    private javax.swing.JPanel admin_btn1;
    private javax.swing.JPanel admin_btn2;
    private javax.swing.JLabel backgroud_img;
    private javax.swing.JLabel background_home;
    private javax.swing.JLabel bg_addRoomtype1;
    private javax.swing.JLabel bg_addRoomtype2;
    private javax.swing.JLabel bg_for_price;
    private javax.swing.JPanel btnShow;
    private javax.swing.JPanel btn_FirstView1;
    private javax.swing.JPanel btn_FirstView2;
    private javax.swing.JPanel btn_container1;
    private javax.swing.JPanel btn_container2;
    private javax.swing.JPanel btn_hall;
    private javax.swing.JPanel btn_hall1;
    private javax.swing.JPanel btn_rooms;
    private javax.swing.JPanel btn_secondView1;
    private javax.swing.JPanel btn_secondView2;
    private javax.swing.JPanel btn_structuretype;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JComboBox combo_Floor_CH;
    private javax.swing.JPanel cover;
    private javax.swing.JLabel dash;
    private javax.swing.JLabel dash_img;
    private javax.swing.JLabel edit11;
    private javax.swing.JLabel edit13;
    private javax.swing.JLabel edit3;
    private javax.swing.JLabel edit4;
    private javax.swing.JLabel employees_lb_onRoom;
    private javax.swing.JLabel exit_lb;
    private javax.swing.JPanel expenses;
    private javax.swing.JPanel expenses1;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel floors;
    private javax.swing.JPanel front_holder;
    private javax.swing.JLabel gb;
    private javax.swing.JLabel halls1;
    private javax.swing.JTable halls_Table_display;
    private javax.swing.JPanel home_cover;
    private javax.swing.JPanel home_page;
    private javax.swing.JPanel img_usera;
    private javax.swing.JCheckBox inactive_structure;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox8;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel195;
    private javax.swing.JLabel jLabel196;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel198;
    private javax.swing.JLabel jLabel199;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel201;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel204;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel213;
    private javax.swing.JLabel jLabel214;
    private javax.swing.JLabel jLabel215;
    private javax.swing.JLabel jLabel22;
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
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
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
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
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
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lb_Halls_Count_Hs;
    private javax.swing.JLabel lb_Halltype_Count_Hs;
    private javax.swing.JLabel lb_bg_btnFirstView1;
    private javax.swing.JLabel lb_bg_btnFirstView2;
    private javax.swing.JLabel lb_bg_btnSecondView1;
    private javax.swing.JLabel lb_bg_btnSecondView2;
    private javax.swing.JLabel lb_department;
    private javax.swing.JLabel lb_designation;
    private javax.swing.JLabel lb_email;
    private javax.swing.JLabel lb_hold12;
    private javax.swing.JLabel lb_hold13;
    private javax.swing.JLabel lb_hold14;
    private javax.swing.JLabel lb_hold15;
    private javax.swing.JLabel lb_hold16;
    private javax.swing.JLabel lb_hold17;
    private javax.swing.JLabel lb_hold18;
    private javax.swing.JLabel lb_hold19;
    private javax.swing.JLabel lb_hold4;
    private javax.swing.JLabel lb_hold5;
    private javax.swing.JLabel lb_hold6;
    private javax.swing.JLabel lb_hold7;
    private javax.swing.JLabel lb_location;
    private javax.swing.JLabel lb_name;
    private javax.swing.JLabel lb_user;
    private javax.swing.JPanel left;
    private javax.swing.JPanel main_structure;
    private javax.swing.JPanel makeRooms_holder;
    private javax.swing.JLabel minize_lb;
    private javax.swing.JPanel panel_for_halls;
    private javax.swing.JLabel pay;
    private javax.swing.JPanel price_manager_holder;
    private javax.swing.JPanel profile;
    private javax.swing.JPanel reports;
    private javax.swing.JTextField room_capacity;
    private javax.swing.JLabel roomcount14;
    private javax.swing.JLabel roomcount19;
    private javax.swing.JLabel roomcount20;
    private javax.swing.JLabel rooms;
    private javax.swing.JTextField search_rooms;
    private javax.swing.JTextField search_structure;
    private javax.swing.JPanel send_noitice;
    private javax.swing.JPanel send_noitice1;
    private javax.swing.JPanel send_noitice2;
    private javax.swing.JPanel structureDesign;
    private javax.swing.JLabel structure_lb_onRooms;
    private javax.swing.JPanel table_header;
    private javax.swing.JLabel table_holder_bg1;
    private javax.swing.JLabel table_holder_bg11;
    private javax.swing.JLabel table_holder_bg3;
    private javax.swing.JLabel tit_forCombo_Roomtype;
    private javax.swing.JLabel tit_for_page;
    private javax.swing.JLabel tit_for_table;
    private javax.swing.JLabel title11;
    private javax.swing.JLabel title13;
    private javax.swing.JLabel title14;
    private javax.swing.JLabel title15;
    private javax.swing.JLabel title17;
    private javax.swing.JLabel title18;
    private javax.swing.JLabel title19;
    private javax.swing.JLabel title20;
    private javax.swing.JLabel title21;
    private javax.swing.JLabel title22;
    private javax.swing.JLabel title23;
    private javax.swing.JLabel title24;
    private javax.swing.JLabel title26;
    private javax.swing.JLabel title28;
    private javax.swing.JLabel title29;
    private javax.swing.JLabel title31;
    private javax.swing.JLabel title32;
    private javax.swing.JLabel title33;
    private javax.swing.JLabel title34;
    private javax.swing.JLabel title8;
    private javax.swing.JTextField txtBasicOccupancy1;
    private javax.swing.JTextArea txtDescrip1;
    private javax.swing.JTextField txtHall_number;
    private javax.swing.JTextField txtHighOc1;
    private javax.swing.JTextField txtRoom_number;
    private javax.swing.JTextField txtShortCode1;
    private javax.swing.JTextField txtSlug1;
    private javax.swing.JTextField txtTitle1;
    private javax.swing.JButton update_structureEntry;
    private javax.swing.JLabel user_img;
    private javax.swing.JLabel user_mode;
    // End of variables declaration//GEN-END:variables
}
