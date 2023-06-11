package hotel.management;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;






import static java.util.Collections.list;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Inventory extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pps, pps1, pps2, pps3, pps4, pps6, pps5, pps7, pps8, pps9, pps10, pps11, pps12 ,pps13 = null;
    ResultSet rs, rs1, rs2, rs3, rs4, rs5, rs6, rs7, rs8, rs9, rs10, rs11, rs12 ,rs13= null;

    
    
    String category_id = null;

    //joint var to make a joint table 
    String getItem_id = null;
    String getCategory_id = null;
    String getItem_Type_id = null;

    //CATEGORY UPDATE AND DELETE
    String Resource_forCategory_ID = null;

    //CATEGORY UPDATE AND DELETE
    String Resource_Type_ID = null;

    String table_clicked = "none";
    String request_table_clicked = "none";
    String  purchese_table_clicked = "none";
    
    String Item_id = null;   // id to make a relation between the item and the details table
    String Detail_Item_id = null;
    int getDetails_id;
    
     String  fname  = "none";
     String  lname  = "none";

     
     //make a relation between the item and the user
       String  item_id = null;
       String   user_id  = null;
       
    private static String Recieved_user_id = null;
    private static String usertype = null;
    //passing user id
    private static Inventory Obj = null;
    private String passed_user_id;
       
    
            int xx = 0;
            int yy = 0;
    
     Inventory() {
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));

        showContent_OnMain_table();
        TableContent();
        ComboContent();
        //hide update btn
         update_Category_Entry.hide();
        
        lb_forCost_ofRepair.hide();
        txt_forCost_ofRepair.hide();
        hiddenCompounents();
        
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
           //       jLabel37.setText("Hi !"+fname +"  "+lname + "  Welcome ID Manager");
                 model.setText(rs6.getString("user"));
              
                 
            
                }
            } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void hiddenCompounents(){
    btn_item_submit2.hide();
    warrant_view.hide();
    order_view.hide();
    
    }
    
    
    public void showContent_OnMain_table() {
        try {
            conn = DBConnection.getConnction();
            String sql = " SELECT  item_number, category_name,type_name , item_name,item_description,model,serial_number,date_oflast_order,cost_per_item,conditions, warranty_ex_date FROM  inventory_items  INNER JOIN    inventory_joint  ON  inventory_items.item_id = inventory_joint.item_id\n"
                    + "INNER JOIN inventory_category ON  inventory_category.category_id = inventory_joint.category_id INNER JOIN inventory_type ON \n"
                    + "inventory_type.item_type_id = inventory_joint.item_type_id ";

            pps10 = conn.prepareStatement(sql);
            rs10 = pps10.executeQuery();
            Main_list_View.setModel(DbUtils.resultSetToTableModel(rs10));
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//SELECT item_number,item_name,item_description,model,serial_number,date_oflast_order,conditions, warranty_ex_date, assigned_date, status,room_number, room_type FROM  inventory_items  INNER JOIN  user_item_relation  ON  inventory_items.item_id = user_item_relation.item_id INNER JOIN rooms ON  rooms.classroom_id = user_item_relation.classroom_id
    public void ComboContent() {
        try {
            conn = DBConnection.getConnction();
            pps3 = conn.prepareStatement("SELECT * FROM inventory_category");
            rs3 = pps3.executeQuery();
            while (rs3.next()) {
                Combo_Category.addItem(rs3.getString("category_name"));//ShowFloors pa combo on the create room
                showCategories.addItem(rs3.getString("category_name"));//home table
                Combo_Category_forRequest.addItem(rs3.getString("category_name"));//on request order form
            }
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

        try { //
            conn = DBConnection.getConnction();
            pps8 = conn.prepareStatement("SELECT * FROM inventory_type");
            rs8 = pps8.executeQuery();
            while (rs8.next()) {
                ComboItem_type.addItem(rs8.getString("type_name"));
                ComboItem_typeForRequest.addItem(rs8.getString("type_name"));
            }
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

    }

    public void TableContent() {
        try {
            conn = DBConnection.getConnction();
            String sql = " SELECT category_name,category_number,category_description FROM inventory_category";
            pps4 = conn.prepareStatement(sql);
            rs4 = pps4.executeQuery();
            category_tb.setModel(DbUtils.resultSetToTableModel(rs4));
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

        try {
            conn = DBConnection.getConnction();
            String sql = " SELECT type_name,type_number,type_description FROM inventory_type";
            pps4 = conn.prepareStatement(sql);
            rs4 = pps4.executeQuery();
            SockType_tb.setModel(DbUtils.resultSetToTableModel(rs4));
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

        try {
            conn = DBConnection.getConnction();
            String sql = " SELECT request_number,item_name,item_description,cost_per_item,conditions,warranty_ex_date,category  FROM request WHERE order_process = ?";
            pps12 = conn.prepareStatement(sql);//
            pps12.setString(1, "unProcessed");
            rs12 = pps12.executeQuery();
            request_list.setModel(DbUtils.resultSetToTableModel(rs12));
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
            
     
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        desktop_panel = new javax.swing.JDesktopPane();
        landing_Panel = new javax.swing.JPanel();
        table_layer = new javax.swing.JPanel();
        home_table = new javax.swing.JPanel();
        table_table = new javax.swing.JPanel();
        Delete_item = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        btn_entry = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Main_list_View = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        showCategories = new javax.swing.JComboBox();
        Item_Category_Table = new javax.swing.JPanel();
        main_structure = new javax.swing.JPanel();
        Category_list = new javax.swing.JPanel();
        table_header = new javax.swing.JPanel();
        jLabel196 = new javax.swing.JLabel();
        jLabel197 = new javax.swing.JLabel();
        jLabel214 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        category_tb = new javax.swing.JTable();
        btn_container1 = new javax.swing.JPanel();
        btn_FirstView1 = new javax.swing.JPanel();
        txt_Category_Search = new javax.swing.JTextField();
        Add_price2 = new javax.swing.JLabel();
        lb_bg_btnFirstView1 = new javax.swing.JLabel();
        btn_secondView1 = new javax.swing.JPanel();
        Delecte13 = new javax.swing.JLabel();
        edit13 = new javax.swing.JLabel();
        add_floor = new javax.swing.JLabel();
        lb_bg_btnSecondView1 = new javax.swing.JLabel();
        table_holder_bg11 = new javax.swing.JLabel();
        jLabel198 = new javax.swing.JLabel();
        Category_entry1 = new javax.swing.JPanel();
        cate_name = new javax.swing.JTextField();
        cate_number = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        cate_description = new javax.swing.JTextArea();
        jLabel35 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        update_Category_Entry = new javax.swing.JButton();
        Savebtn1 = new javax.swing.JButton();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        gb1 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        Type_list = new javax.swing.JPanel();
        table_header1 = new javax.swing.JPanel();
        jLabel199 = new javax.swing.JLabel();
        jLabel200 = new javax.swing.JLabel();
        jLabel215 = new javax.swing.JLabel();
        jScrollPane21 = new javax.swing.JScrollPane();
        SockType_tb = new javax.swing.JTable();
        btn_container2 = new javax.swing.JPanel();
        btn_FirstView2 = new javax.swing.JPanel();
        txt_Search_type = new javax.swing.JTextField();
        Add_price3 = new javax.swing.JLabel();
        lb_bg_btnFirstView2 = new javax.swing.JLabel();
        btn_secondView2 = new javax.swing.JPanel();
        Delecte14 = new javax.swing.JLabel();
        edit14 = new javax.swing.JLabel();
        add_floor1 = new javax.swing.JLabel();
        lb_bg_btnSecondView2 = new javax.swing.JLabel();
        table_holder_bg12 = new javax.swing.JLabel();
        jLabel201 = new javax.swing.JLabel();
        Type_entry = new javax.swing.JPanel();
        typename = new javax.swing.JTextField();
        typenumber = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Typedescription = new javax.swing.JTextArea();
        jLabel33 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        update_structureEntry = new javax.swing.JButton();
        Savebtn = new javax.swing.JButton();
        jLabel79 = new javax.swing.JLabel();
        gb = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        request_table = new javax.swing.JPanel();
        table_header2 = new javax.swing.JPanel();
        jLabel202 = new javax.swing.JLabel();
        jLabel216 = new javax.swing.JLabel();
        jLabel217 = new javax.swing.JLabel();
        jLabel218 = new javax.swing.JLabel();
        jLabel205 = new javax.swing.JLabel();
        jLabel219 = new javax.swing.JLabel();
        jLabel220 = new javax.swing.JLabel();
        jScrollPane22 = new javax.swing.JScrollPane();
        request_list = new javax.swing.JTable();
        btn_container3 = new javax.swing.JPanel();
        btn_FirstView3 = new javax.swing.JPanel();
        txt_search_request = new javax.swing.JTextField();
        Add_price4 = new javax.swing.JLabel();
        lb_bg_btnFirstView3 = new javax.swing.JLabel();
        btn_secondView3 = new javax.swing.JPanel();
        Delecte15 = new javax.swing.JLabel();
        edit15 = new javax.swing.JLabel();
        add_floor2 = new javax.swing.JLabel();
        lb_bg_btnSecondView3 = new javax.swing.JLabel();
        table_holder_bg13 = new javax.swing.JLabel();
        jLabel204 = new javax.swing.JLabel();
        Purchases = new javax.swing.JPanel();
        table_header3 = new javax.swing.JPanel();
        jLabel203 = new javax.swing.JLabel();
        jLabel221 = new javax.swing.JLabel();
        jLabel222 = new javax.swing.JLabel();
        jLabel223 = new javax.swing.JLabel();
        jLabel206 = new javax.swing.JLabel();
        jLabel224 = new javax.swing.JLabel();
        jLabel225 = new javax.swing.JLabel();
        jScrollPane23 = new javax.swing.JScrollPane();
        Purchases_list = new javax.swing.JTable();
        btn_container4 = new javax.swing.JPanel();
        btn_FirstView4 = new javax.swing.JPanel();
        jTextField6 = new javax.swing.JTextField();
        Add_price5 = new javax.swing.JLabel();
        lb_bg_btnFirstView4 = new javax.swing.JLabel();
        btn_secondView4 = new javax.swing.JPanel();
        Delecte16 = new javax.swing.JLabel();
        lb_bg_btnSecondView4 = new javax.swing.JLabel();
        table_holder_bg14 = new javax.swing.JLabel();
        jLabel207 = new javax.swing.JLabel();
        data_entry = new javax.swing.JPanel();
        txt_Item_Description = new javax.swing.JTextField();
        txt_Item_Name = new javax.swing.JTextField();
        txt_Item_number = new javax.swing.JTextField();
        Combo_Category = new javax.swing.JComboBox();
        warrant_view = new javax.swing.JTextField();
        warranty_expiry = new com.toedter.calendar.JDateChooser();
        ComboItem_type = new javax.swing.JComboBox();
        txt_Item_Condition = new javax.swing.JTextField();
        image_chooser = new javax.swing.JButton();
        img_url = new javax.swing.JTextField();
        txt_Serial_number = new javax.swing.JTextField();
        txt_Item_Mode = new javax.swing.JTextField();
        txt_Purchase = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        order_view = new javax.swing.JTextField();
        last_date_order = new com.toedter.calendar.JDateChooser();
        btn_item_submit = new javax.swing.JButton();
        img_pane = new javax.swing.JPanel();
        img_holder = new javax.swing.JLabel();
        btn_item_submit2 = new javax.swing.JButton();
        request = new javax.swing.JPanel();
        txt_Item_Condition1 = new javax.swing.JTextField();
        txt_Item_Description1 = new javax.swing.JTextField();
        txt_Item_Name1 = new javax.swing.JTextField();
        txt_Item_number1 = new javax.swing.JTextField();
        ComboItem_typeForRequest = new javax.swing.JComboBox();
        Combo_Category_forRequest = new javax.swing.JComboBox();
        jLabel32 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        txt_Purchase1 = new javax.swing.JTextField();
        txt_Item_Mode1 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        warranty_expiry1 = new com.toedter.calendar.JDateChooser();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        btn_item_submit1 = new javax.swing.JButton();
        Side_bar = new javax.swing.JPanel();
        side1 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        export_toExcel = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        side2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        side3 = new javax.swing.JPanel();
        lb_gb_table = new javax.swing.JLabel();
        model = new javax.swing.JLabel();
        Top_Header = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        btn10 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btn9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btn11 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        btn12 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        btn14 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        btn15 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        btn17 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        btn16 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        item_Problem_Solution = new javax.swing.JPanel();
        P_Title = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        P_Save = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        P_Text = new javax.swing.JTextArea();
        jLabel61 = new javax.swing.JLabel();
        P_Update = new javax.swing.JButton();
        txt_forCost_ofRepair = new javax.swing.JTextField();
        lb_forCost_ofRepair = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        txt_problem = new javax.swing.JTextArea();
        jLabel60 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        desktop_panel.setBackground(new java.awt.Color(255, 255, 255));

        landing_Panel.setBackground(new java.awt.Color(204, 204, 204));
        landing_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_layer.setLayout(new java.awt.CardLayout());

        home_table.setBackground(new java.awt.Color(255, 255, 255));
        home_table.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_table.setBackground(new java.awt.Color(153, 153, 153));
        table_table.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Delete_item.setBackground(new Color(255,255,255,30));
        Delete_item.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Delete_item.setForeground(new java.awt.Color(102, 102, 102));
        Delete_item.setText("Delete");
        Delete_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_itemActionPerformed(evt);
            }
        });
        table_table.add(Delete_item, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        edit.setBackground(new Color(255,255,255,30));
        edit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        edit.setForeground(new java.awt.Color(102, 102, 102));
        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        table_table.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        btn_entry.setBackground(new Color(255,255,255,30));
        btn_entry.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btn_entry.setForeground(new java.awt.Color(102, 102, 102));
        btn_entry.setText("New");
        btn_entry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_entryActionPerformed(evt);
            }
        });
        table_table.add(btn_entry, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Model");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 100, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Item #");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 70, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Category");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 70, 40));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Description");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 100, 40));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Type");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 50, 40));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Name");
        jPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 100, 40));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(102, 102, 102));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Warranty Expiry");
        jPanel4.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, 120, 40));

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(102, 102, 102));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Last Order Date");
        jPanel4.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 100, 40));

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(102, 102, 102));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Serial #");
        jPanel4.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 100, 40));

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(102, 102, 102));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Cost per Item");
        jPanel4.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 100, 40));

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(102, 102, 102));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("Condition");
        jPanel4.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, 100, 40));

        table_table.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1160, 50));
        table_table.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 4, 210, 40));

        home_table.add(table_table, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1160, 100));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        Main_list_View.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Main_list_View.setForeground(new java.awt.Color(153, 153, 153));
        Main_list_View.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Main_list_View.setIntercellSpacing(new java.awt.Dimension(0, 1));
        Main_list_View.setRowHeight(25);
        Main_list_View.setShowVerticalLines(false);
        Main_list_View.setTableHeader(null);
        Main_list_View.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Main_list_ViewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Main_list_View);

        home_table.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 1160, 420));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Fiter");
        home_table.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 120, 30));

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        home_table.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 250, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Category");
        home_table.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 100, 30));

        showCategories.setBackground(new Color(255,255,255,30));
        showCategories.setForeground(new java.awt.Color(51, 51, 51));
        home_table.add(showCategories, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 10, 200, 30));

        table_layer.add(home_table, "card2");

        Item_Category_Table.setBackground(new java.awt.Color(255, 255, 255));
        Item_Category_Table.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        main_structure.setBackground(new java.awt.Color(255, 255, 255));
        main_structure.setLayout(new java.awt.CardLayout());

        Category_list.setBackground(new java.awt.Color(255, 255, 255));
        Category_list.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_header.setBackground(new java.awt.Color(255, 255, 255));
        table_header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel196.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel196.setForeground(new java.awt.Color(140, 140, 140));
        jLabel196.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel196.setText("Category Name");
        table_header.add(jLabel196, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 50));

        jLabel197.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel197.setForeground(new java.awt.Color(140, 140, 140));
        jLabel197.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel197.setText("  Description");
        table_header.add(jLabel197, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 140, 50));

        jLabel214.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel214.setForeground(new java.awt.Color(140, 140, 140));
        jLabel214.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel214.setText("   Category Number");
        table_header.add(jLabel214, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 170, 50));

        Category_list.add(table_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 880, 50));

        category_tb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        category_tb.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        category_tb.setForeground(new java.awt.Color(140, 140, 140));
        category_tb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        category_tb.setGridColor(new java.awt.Color(255, 255, 255));
        category_tb.setIntercellSpacing(new java.awt.Dimension(20, 5));
        category_tb.setRowHeight(30);
        category_tb.setTableHeader(null);
        category_tb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                category_tbMouseClicked(evt);
            }
        });
        jScrollPane20.setViewportView(category_tb);

        Category_list.add(jScrollPane20, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 870, 360));

        btn_container1.setBackground(new java.awt.Color(255, 255, 255));
        btn_container1.setLayout(new java.awt.CardLayout());

        btn_FirstView1.setBackground(new java.awt.Color(255, 255, 255));
        btn_FirstView1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_Category_Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_Category_SearchKeyTyped(evt);
            }
        });
        btn_FirstView1.add(txt_Category_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 220, 30));

        Add_price2.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Add_price2.setForeground(new java.awt.Color(255, 255, 255));
        Add_price2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Add_price2.setText(" Category");
        Add_price2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_price2MouseClicked(evt);
            }
        });
        btn_FirstView1.add(Add_price2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 100, 50));

        lb_bg_btnFirstView1.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        lb_bg_btnFirstView1.setForeground(new java.awt.Color(255, 255, 255));
        lb_bg_btnFirstView1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_bg_btnFirstView1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btnInventory.png"))); // NOI18N
        btn_FirstView1.add(lb_bg_btnFirstView1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, -1, 90));

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
        btn_secondView1.add(Delecte13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 80, 40));

        edit13.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        edit13.setForeground(new java.awt.Color(255, 255, 255));
        edit13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_upload_to_ftp_30px.png"))); // NOI18N
        edit13.setText("Edit");
        edit13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edit13MouseClicked(evt);
            }
        });
        btn_secondView1.add(edit13, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 70, 40));

        add_floor.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        add_floor.setForeground(new java.awt.Color(255, 255, 255));
        add_floor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        add_floor.setText(" Category");
        add_floor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_floorMouseClicked(evt);
            }
        });
        btn_secondView1.add(add_floor, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 90, 40));

        lb_bg_btnSecondView1.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        lb_bg_btnSecondView1.setForeground(new java.awt.Color(255, 255, 255));
        lb_bg_btnSecondView1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_bg_btnSecondView1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btnInventory.png"))); // NOI18N
        lb_bg_btnSecondView1.setText("Delecte");
        btn_secondView1.add(lb_bg_btnSecondView1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -20, 420, 120));

        btn_container1.add(btn_secondView1, "card2");

        Category_list.add(btn_container1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, 380, 70));

        table_holder_bg11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        table_holder_bg11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/display.png"))); // NOI18N
        Category_list.add(table_holder_bg11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 1100, 580));

        jLabel198.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel198.setForeground(new java.awt.Color(140, 140, 140));
        jLabel198.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel198.setText("Category");
        Category_list.add(jLabel198, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        main_structure.add(Category_list, "card8");

        Category_entry1.setBackground(new java.awt.Color(255, 255, 255));
        Category_entry1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cate_name.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        cate_name.setForeground(new java.awt.Color(102, 102, 102));
        Category_entry1.add(cate_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 310, 40));

        cate_number.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        cate_number.setForeground(new java.awt.Color(102, 102, 102));
        Category_entry1.add(cate_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 310, 40));

        cate_description.setColumns(20);
        cate_description.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        cate_description.setForeground(new java.awt.Color(102, 102, 102));
        cate_description.setRows(5);
        jScrollPane3.setViewportView(cate_description);

        Category_entry1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, 350, 140));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(153, 153, 153));
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel35.setText("Category Name");
        Category_entry1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 130, 40));

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(153, 153, 153));
        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel42.setText("Category Number");
        Category_entry1.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 130, 40));

        update_Category_Entry.setBackground(new Color(255,255,255,30));
        update_Category_Entry.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        update_Category_Entry.setForeground(new java.awt.Color(102, 102, 102));
        update_Category_Entry.setText("update");
        update_Category_Entry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_Category_EntryActionPerformed(evt);
            }
        });
        Category_entry1.add(update_Category_Entry, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 430, 90, 30));

        Savebtn1.setBackground(new Color(255,255,255,30));
        Savebtn1.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Savebtn1.setForeground(new java.awt.Color(102, 102, 102));
        Savebtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Savebtn1.setText("Add");
        Savebtn1.setBorder(null);
        Savebtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Savebtn1ActionPerformed(evt);
            }
        });
        Category_entry1.add(Savebtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 430, 100, 30));

        jLabel80.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(153, 153, 153));
        jLabel80.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_view_25px.png"))); // NOI18N
        jLabel80.setText("   Category List");
        jLabel80.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel80MouseClicked(evt);
            }
        });
        Category_entry1.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 140, 50));

        jLabel81.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(153, 153, 153));
        jLabel81.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel81.setText("Description");
        Category_entry1.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 180, 100, 50));

        gb1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        gb1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/Untitled-2.png"))); // NOI18N
        Category_entry1.add(gb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1160, 470));

        jLabel82.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(153, 153, 153));
        jLabel82.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel82.setText("   Category Entry");
        Category_entry1.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 50));

        main_structure.add(Category_entry1, "card3");

        Type_list.setBackground(new java.awt.Color(255, 255, 255));
        Type_list.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_header1.setBackground(new java.awt.Color(255, 255, 255));
        table_header1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel199.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel199.setForeground(new java.awt.Color(140, 140, 140));
        jLabel199.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel199.setText("Type Name");
        table_header1.add(jLabel199, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 50));

        jLabel200.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel200.setForeground(new java.awt.Color(140, 140, 140));
        jLabel200.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel200.setText("  Description");
        table_header1.add(jLabel200, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 140, 50));

        jLabel215.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel215.setForeground(new java.awt.Color(140, 140, 140));
        jLabel215.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel215.setText(" Type Number");
        table_header1.add(jLabel215, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 170, 50));

        Type_list.add(table_header1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 880, 50));

        SockType_tb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        SockType_tb.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        SockType_tb.setForeground(new java.awt.Color(140, 140, 140));
        SockType_tb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        SockType_tb.setGridColor(new java.awt.Color(255, 255, 255));
        SockType_tb.setIntercellSpacing(new java.awt.Dimension(20, 5));
        SockType_tb.setRowHeight(30);
        SockType_tb.setTableHeader(null);
        SockType_tb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SockType_tbMouseClicked(evt);
            }
        });
        jScrollPane21.setViewportView(SockType_tb);

        Type_list.add(jScrollPane21, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 870, 360));

        btn_container2.setBackground(new java.awt.Color(255, 255, 255));
        btn_container2.setLayout(new java.awt.CardLayout());

        btn_FirstView2.setBackground(new java.awt.Color(255, 255, 255));
        btn_FirstView2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_Search_type.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_Search_typeKeyPressed(evt);
            }
        });
        btn_FirstView2.add(txt_Search_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 200, 30));

        Add_price3.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Add_price3.setForeground(new java.awt.Color(255, 255, 255));
        Add_price3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Add_price3.setText(" Enter Type");
        Add_price3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_price3MouseClicked(evt);
            }
        });
        btn_FirstView2.add(Add_price3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 100, 50));

        lb_bg_btnFirstView2.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        lb_bg_btnFirstView2.setForeground(new java.awt.Color(255, 255, 255));
        lb_bg_btnFirstView2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_bg_btnFirstView2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btnInventory.png"))); // NOI18N
        btn_FirstView2.add(lb_bg_btnFirstView2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 390, 70));

        btn_container2.add(btn_FirstView2, "card3");

        btn_secondView2.setBackground(new java.awt.Color(255, 255, 255));
        btn_secondView2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Delecte14.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte14.setForeground(new java.awt.Color(255, 255, 255));
        Delecte14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_no_entry_25px.png"))); // NOI18N
        Delecte14.setText("Delecte");
        Delecte14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Delecte14MouseClicked(evt);
            }
        });
        btn_secondView2.add(Delecte14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 80, 40));

        edit14.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        edit14.setForeground(new java.awt.Color(255, 255, 255));
        edit14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_upload_to_ftp_30px.png"))); // NOI18N
        edit14.setText("Edit");
        edit14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edit14MouseClicked(evt);
            }
        });
        btn_secondView2.add(edit14, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 70, 40));

        add_floor1.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        add_floor1.setForeground(new java.awt.Color(255, 255, 255));
        add_floor1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        add_floor1.setText(" Types");
        add_floor1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_floor1MouseClicked(evt);
            }
        });
        btn_secondView2.add(add_floor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 100, 40));

        lb_bg_btnSecondView2.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        lb_bg_btnSecondView2.setForeground(new java.awt.Color(255, 255, 255));
        lb_bg_btnSecondView2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_bg_btnSecondView2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btnInventory.png"))); // NOI18N
        lb_bg_btnSecondView2.setText("Delecte");
        btn_secondView2.add(lb_bg_btnSecondView2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 400, 60));

        btn_container2.add(btn_secondView2, "card2");

        Type_list.add(btn_container2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, 370, -1));

        table_holder_bg12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        table_holder_bg12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/display.png"))); // NOI18N
        Type_list.add(table_holder_bg12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 1100, 580));

        jLabel201.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel201.setForeground(new java.awt.Color(140, 140, 140));
        jLabel201.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel201.setText("Sock Type");
        Type_list.add(jLabel201, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        main_structure.add(Type_list, "card8");

        Type_entry.setBackground(new java.awt.Color(255, 255, 255));
        Type_entry.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        typename.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        typename.setForeground(new java.awt.Color(102, 102, 102));
        Type_entry.add(typename, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 310, 40));

        typenumber.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        typenumber.setForeground(new java.awt.Color(102, 102, 102));
        Type_entry.add(typenumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, 310, 40));

        Typedescription.setColumns(20);
        Typedescription.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        Typedescription.setForeground(new java.awt.Color(102, 102, 102));
        Typedescription.setRows(5);
        jScrollPane2.setViewportView(Typedescription);

        Type_entry.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, 350, 140));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(153, 153, 153));
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel33.setText("Type Name");
        Type_entry.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 130, 40));

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(153, 153, 153));
        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel41.setText("Type  Number");
        Type_entry.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 130, 40));

        update_structureEntry.setBackground(new Color(255,255,255,30));
        update_structureEntry.setForeground(new java.awt.Color(102, 102, 102));
        update_structureEntry.setText("update");
        update_structureEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_structureEntryActionPerformed(evt);
            }
        });
        Type_entry.add(update_structureEntry, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 450, 90, 30));

        Savebtn.setBackground(new Color(255,255,255,30));
        Savebtn.setForeground(new java.awt.Color(102, 102, 102));
        Savebtn.setText("Add");
        Savebtn.setBorder(null);
        Savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SavebtnActionPerformed(evt);
            }
        });
        Type_entry.add(Savebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 450, 80, 30));

        jLabel79.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(153, 153, 153));
        jLabel79.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel79.setText("Description");
        Type_entry.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, 100, 50));

        gb.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        gb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/Untitled-2.png"))); // NOI18N
        Type_entry.add(gb, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1160, 470));

        jLabel83.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(153, 153, 153));
        jLabel83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel83.setText("Sock Type");
        Type_entry.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 50));

        jLabel84.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(153, 153, 153));
        jLabel84.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_view_25px.png"))); // NOI18N
        jLabel84.setText("   Type  List");
        jLabel84.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel84MouseClicked(evt);
            }
        });
        Type_entry.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 140, 50));

        main_structure.add(Type_entry, "card3");

        request_table.setBackground(new java.awt.Color(255, 255, 255));
        request_table.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_header2.setBackground(new java.awt.Color(255, 255, 255));
        table_header2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel202.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel202.setForeground(new java.awt.Color(140, 140, 140));
        jLabel202.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel202.setText("Item Name");
        table_header2.add(jLabel202, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 50));

        jLabel216.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel216.setForeground(new java.awt.Color(140, 140, 140));
        jLabel216.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel216.setText(" Item Number");
        table_header2.add(jLabel216, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 140, 50));

        jLabel217.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel217.setForeground(new java.awt.Color(140, 140, 140));
        jLabel217.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel217.setText("warranty expirly date");
        table_header2.add(jLabel217, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 170, 50));

        jLabel218.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel218.setForeground(new java.awt.Color(140, 140, 140));
        jLabel218.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel218.setText("Make");
        table_header2.add(jLabel218, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 80, 50));

        jLabel205.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel205.setForeground(new java.awt.Color(140, 140, 140));
        jLabel205.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel205.setText("Category");
        table_header2.add(jLabel205, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 100, 50));

        jLabel219.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel219.setForeground(new java.awt.Color(140, 140, 140));
        jLabel219.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel219.setText("Condition");
        table_header2.add(jLabel219, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 100, 50));

        jLabel220.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel220.setForeground(new java.awt.Color(140, 140, 140));
        jLabel220.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel220.setText("Cost");
        table_header2.add(jLabel220, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 70, 50));

        request_table.add(table_header2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 910, 50));

        request_list.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        request_list.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        request_list.setForeground(new java.awt.Color(140, 140, 140));
        request_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        request_list.setGridColor(new java.awt.Color(255, 255, 255));
        request_list.setIntercellSpacing(new java.awt.Dimension(20, 5));
        request_list.setRowHeight(30);
        request_list.setTableHeader(null);
        request_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                request_listMouseClicked(evt);
            }
        });
        jScrollPane22.setViewportView(request_list);

        request_table.add(jScrollPane22, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 900, 360));

        btn_container3.setBackground(new java.awt.Color(255, 255, 255));
        btn_container3.setLayout(new java.awt.CardLayout());

        btn_FirstView3.setBackground(new java.awt.Color(255, 255, 255));
        btn_FirstView3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_search_request.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_search_requestKeyPressed(evt);
            }
        });
        btn_FirstView3.add(txt_search_request, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 180, 30));

        Add_price4.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Add_price4.setForeground(new java.awt.Color(255, 255, 255));
        Add_price4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Add_price4.setText(" Process request");
        Add_price4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_price4MouseClicked(evt);
            }
        });
        btn_FirstView3.add(Add_price4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 140, 50));

        lb_bg_btnFirstView3.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        lb_bg_btnFirstView3.setForeground(new java.awt.Color(255, 255, 255));
        lb_bg_btnFirstView3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_bg_btnFirstView3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btnInventory.png"))); // NOI18N
        btn_FirstView3.add(lb_bg_btnFirstView3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 390, 70));

        btn_container3.add(btn_FirstView3, "card3");

        btn_secondView3.setBackground(new java.awt.Color(255, 255, 255));
        btn_secondView3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Delecte15.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte15.setForeground(new java.awt.Color(255, 255, 255));
        Delecte15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_no_entry_25px.png"))); // NOI18N
        Delecte15.setText("Delecte");
        Delecte15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Delecte15MouseClicked(evt);
            }
        });
        btn_secondView3.add(Delecte15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 80, 40));

        edit15.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        edit15.setForeground(new java.awt.Color(255, 255, 255));
        edit15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_upload_to_ftp_30px.png"))); // NOI18N
        edit15.setText("Edit");
        edit15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edit15MouseClicked(evt);
            }
        });
        btn_secondView3.add(edit15, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 70, 40));

        add_floor2.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        add_floor2.setForeground(new java.awt.Color(255, 255, 255));
        add_floor2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        add_floor2.setText(" Request");
        add_floor2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_floor2MouseClicked(evt);
            }
        });
        btn_secondView3.add(add_floor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 100, 40));

        lb_bg_btnSecondView3.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        lb_bg_btnSecondView3.setForeground(new java.awt.Color(255, 255, 255));
        lb_bg_btnSecondView3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_bg_btnSecondView3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btnInventory.png"))); // NOI18N
        lb_bg_btnSecondView3.setText("Delecte");
        btn_secondView3.add(lb_bg_btnSecondView3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 400, 60));

        btn_container3.add(btn_secondView3, "card2");

        request_table.add(btn_container3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, 370, -1));

        table_holder_bg13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        table_holder_bg13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/display.png"))); // NOI18N
        request_table.add(table_holder_bg13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 1100, 580));

        jLabel204.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel204.setForeground(new java.awt.Color(140, 140, 140));
        jLabel204.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel204.setText("  All Request");
        request_table.add(jLabel204, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        main_structure.add(request_table, "card8");

        Purchases.setBackground(new java.awt.Color(255, 255, 255));
        Purchases.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_header3.setBackground(new java.awt.Color(255, 255, 255));
        table_header3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel203.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel203.setForeground(new java.awt.Color(140, 140, 140));
        jLabel203.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel203.setText("Item Name");
        table_header3.add(jLabel203, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 50));

        jLabel221.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel221.setForeground(new java.awt.Color(140, 140, 140));
        jLabel221.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel221.setText(" Item Number");
        table_header3.add(jLabel221, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 140, 50));

        jLabel222.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel222.setForeground(new java.awt.Color(140, 140, 140));
        jLabel222.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel222.setText("warranty expirly date");
        table_header3.add(jLabel222, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 170, 50));

        jLabel223.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel223.setForeground(new java.awt.Color(140, 140, 140));
        jLabel223.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel223.setText("Make");
        table_header3.add(jLabel223, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 80, 50));

        jLabel206.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel206.setForeground(new java.awt.Color(140, 140, 140));
        jLabel206.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel206.setText("Category");
        table_header3.add(jLabel206, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 100, 50));

        jLabel224.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel224.setForeground(new java.awt.Color(140, 140, 140));
        jLabel224.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel224.setText("Condition");
        table_header3.add(jLabel224, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 100, 50));

        jLabel225.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel225.setForeground(new java.awt.Color(140, 140, 140));
        jLabel225.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel225.setText("Cost");
        table_header3.add(jLabel225, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 70, 50));

        Purchases.add(table_header3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 910, 50));

        Purchases_list.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        Purchases_list.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        Purchases_list.setForeground(new java.awt.Color(140, 140, 140));
        Purchases_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Purchases_list.setGridColor(new java.awt.Color(255, 255, 255));
        Purchases_list.setIntercellSpacing(new java.awt.Dimension(20, 5));
        Purchases_list.setRowHeight(30);
        Purchases_list.setTableHeader(null);
        Purchases_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Purchases_listMouseClicked(evt);
            }
        });
        jScrollPane23.setViewportView(Purchases_list);

        Purchases.add(jScrollPane23, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 900, 360));

        btn_container4.setBackground(new java.awt.Color(255, 255, 255));
        btn_container4.setLayout(new java.awt.CardLayout());

        btn_FirstView4.setBackground(new java.awt.Color(255, 255, 255));
        btn_FirstView4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        btn_FirstView4.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 180, 30));

        Add_price5.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Add_price5.setForeground(new java.awt.Color(255, 255, 255));
        Add_price5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Add_price5.setText("    add to assets");
        Add_price5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_price5MouseClicked(evt);
            }
        });
        btn_FirstView4.add(Add_price5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 140, 50));

        lb_bg_btnFirstView4.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        lb_bg_btnFirstView4.setForeground(new java.awt.Color(255, 255, 255));
        lb_bg_btnFirstView4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_bg_btnFirstView4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btnInventory.png"))); // NOI18N
        btn_FirstView4.add(lb_bg_btnFirstView4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, 400, 70));

        btn_container4.add(btn_FirstView4, "card3");

        btn_secondView4.setBackground(new java.awt.Color(255, 255, 255));
        btn_secondView4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Delecte16.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte16.setForeground(new java.awt.Color(255, 255, 255));
        Delecte16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_no_entry_25px.png"))); // NOI18N
        Delecte16.setText("Delecte");
        Delecte16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Delecte16MouseClicked(evt);
            }
        });
        btn_secondView4.add(Delecte16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 80, 40));

        lb_bg_btnSecondView4.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        lb_bg_btnSecondView4.setForeground(new java.awt.Color(255, 255, 255));
        lb_bg_btnSecondView4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_bg_btnSecondView4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btnInventory.png"))); // NOI18N
        lb_bg_btnSecondView4.setText("Delecte");
        btn_secondView4.add(lb_bg_btnSecondView4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 400, 60));

        btn_container4.add(btn_secondView4, "card2");

        Purchases.add(btn_container4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, 370, -1));

        table_holder_bg14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        table_holder_bg14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/display.png"))); // NOI18N
        Purchases.add(table_holder_bg14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 1100, 580));

        jLabel207.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        jLabel207.setForeground(new java.awt.Color(140, 140, 140));
        jLabel207.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel207.setText("  Purchases");
        Purchases.add(jLabel207, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        main_structure.add(Purchases, "card8");

        Item_Category_Table.add(main_structure, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 700));

        table_layer.add(Item_Category_Table, "card4");

        data_entry.setBackground(new java.awt.Color(255, 255, 255));
        data_entry.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_Item_Description.setForeground(new java.awt.Color(102, 102, 102));
        data_entry.add(txt_Item_Description, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 260, 40));

        txt_Item_Name.setForeground(new java.awt.Color(102, 102, 102));
        data_entry.add(txt_Item_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 270, 260, 40));

        txt_Item_number.setForeground(new java.awt.Color(102, 102, 102));
        data_entry.add(txt_Item_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 260, 40));

        Combo_Category.setBackground(new Color(255,255,255,30));
        data_entry.add(Combo_Category, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 260, 40));

        warrant_view.setForeground(new java.awt.Color(102, 102, 102));
        warrant_view.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                warrant_viewMouseClicked(evt);
            }
        });
        data_entry.add(warrant_view, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 410, 260, 40));

        warranty_expiry.setBackground(new Color(255,255,255,30));
        warranty_expiry.setForeground(new java.awt.Color(102, 102, 102));
        warranty_expiry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                warranty_expiryMouseClicked(evt);
            }
        });
        data_entry.add(warranty_expiry, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 410, 260, 40));

        ComboItem_type.setBackground(new Color(255,255,255,30));
        data_entry.add(ComboItem_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 260, 40));

        txt_Item_Condition.setForeground(new java.awt.Color(102, 102, 102));
        data_entry.add(txt_Item_Condition, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 260, 40));

        image_chooser.setBackground(new Color(255,255,255,30));
        image_chooser.setText("Image");
        image_chooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                image_chooserActionPerformed(evt);
            }
        });
        data_entry.add(image_chooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 280, 70, 40));

        img_url.setForeground(new java.awt.Color(102, 102, 102));
        data_entry.add(img_url, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 280, 260, 40));

        txt_Serial_number.setForeground(new java.awt.Color(102, 102, 102));
        data_entry.add(txt_Serial_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 220, 260, 40));

        txt_Item_Mode.setForeground(new java.awt.Color(102, 102, 102));
        data_entry.add(txt_Item_Mode, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 150, 260, 40));

        txt_Purchase.setForeground(new java.awt.Color(102, 102, 102));
        data_entry.add(txt_Purchase, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 90, 260, 40));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_reversed_numerical_sorting_25px.png"))); // NOI18N
        jLabel12.setText("Item Type");
        data_entry.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 150, 40));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_alphabetical_sorting_25px.png"))); // NOI18N
        jLabel16.setText("Item Category");
        data_entry.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 150, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_dog_tag_25px.png"))); // NOI18N
        jLabel17.setText("Item Name");
        data_entry.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 150, 40));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_numeric_25px.png"))); // NOI18N
        jLabel18.setText("Item number");
        data_entry.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 150, 40));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_air_quality_25px.png"))); // NOI18N
        jLabel25.setText("Item Condition");
        data_entry.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 150, 40));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_metamorphose_25px.png"))); // NOI18N
        jLabel26.setText("Item Description");
        data_entry.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 150, 40));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_add_image_25px.png"))); // NOI18N
        jLabel27.setText("Item Image");
        data_entry.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, 150, 40));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(102, 102, 102));
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_refresh_barcode_25px.png"))); // NOI18N
        jLabel29.setText("Serial number");
        data_entry.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 150, 40));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(102, 102, 102));
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_time_slider_25px.png"))); // NOI18N
        jLabel30.setText("Item Model");
        data_entry.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 150, 150, 40));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(102, 102, 102));
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_in_transit_25px.png"))); // NOI18N
        jLabel31.setText("Purchase Price Per Item");
        data_entry.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, 180, 40));

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(102, 102, 102));
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_health_calendar_25px.png"))); // NOI18N
        jLabel34.setText("Warranty Expiry Date");
        data_entry.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 410, 150, 40));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(102, 102, 102));
        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/oder.png"))); // NOI18N
        jLabel36.setText("Date of Last Order");
        data_entry.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 350, 150, 40));

        order_view.setForeground(new java.awt.Color(102, 102, 102));
        order_view.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                order_viewMouseClicked(evt);
            }
        });
        data_entry.add(order_view, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 350, 260, 40));

        last_date_order.setBackground(new Color(255,255,255,30));
        last_date_order.setForeground(new java.awt.Color(102, 102, 102));
        data_entry.add(last_date_order, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 350, 260, 40));

        btn_item_submit.setBackground(new Color(255,255,255,30));
        btn_item_submit.setText("Commit");
        btn_item_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_item_submitActionPerformed(evt);
            }
        });
        data_entry.add(btn_item_submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 510, 150, 30));

        img_pane.setBackground(new java.awt.Color(153, 153, 153));
        img_pane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img_holder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_User_Group_125px.png"))); // NOI18N
        img_pane.add(img_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, 150));

        data_entry.add(img_pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 60, 200, 170));

        btn_item_submit2.setBackground(new Color(255,255,255,30));
        btn_item_submit2.setText("Update");
        btn_item_submit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_item_submit2ActionPerformed(evt);
            }
        });
        data_entry.add(btn_item_submit2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 510, 90, 30));

        table_layer.add(data_entry, "card3");

        request.setBackground(new java.awt.Color(255, 255, 255));
        request.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_Item_Condition1.setForeground(new java.awt.Color(102, 102, 102));
        request.add(txt_Item_Condition1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 140, 260, 40));

        txt_Item_Description1.setForeground(new java.awt.Color(102, 102, 102));
        request.add(txt_Item_Description1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 450, 260, 40));

        txt_Item_Name1.setForeground(new java.awt.Color(102, 102, 102));
        request.add(txt_Item_Name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, 260, 40));

        txt_Item_number1.setForeground(new java.awt.Color(102, 102, 102));
        request.add(txt_Item_number1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 260, 40));

        ComboItem_typeForRequest.setBackground(new Color(255,255,255,30));
        request.add(ComboItem_typeForRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 260, 40));

        Combo_Category_forRequest.setBackground(new Color(255,255,255,30));
        request.add(Combo_Category_forRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 260, 40));

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(102, 102, 102));
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_in_transit_25px.png"))); // NOI18N
        jLabel32.setText("Order Price ");
        request.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 230, 180, 40));

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(102, 102, 102));
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_time_slider_25px.png"))); // NOI18N
        jLabel45.setText("Item Model");
        request.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 300, 150, 40));

        txt_Purchase1.setForeground(new java.awt.Color(102, 102, 102));
        request.add(txt_Purchase1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 230, 260, 40));

        txt_Item_Mode1.setForeground(new java.awt.Color(102, 102, 102));
        request.add(txt_Item_Mode1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 300, 260, 40));

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(102, 102, 102));
        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_health_calendar_25px.png"))); // NOI18N
        jLabel48.setText("Warranty Expiry Date");
        request.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 380, 150, 40));

        warranty_expiry1.setBackground(new Color(255,255,255,30));
        warranty_expiry1.setForeground(new java.awt.Color(102, 102, 102));
        request.add(warranty_expiry1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 380, 260, 40));

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(102, 102, 102));
        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_reversed_numerical_sorting_25px.png"))); // NOI18N
        jLabel49.setText("Item Type");
        request.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 150, 40));

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(102, 102, 102));
        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_alphabetical_sorting_25px.png"))); // NOI18N
        jLabel50.setText("REQUEST FORM");
        request.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 220, 50));

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(102, 102, 102));
        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_numeric_25px.png"))); // NOI18N
        jLabel51.setText("Request number");
        request.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 150, 40));

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(102, 102, 102));
        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_dog_tag_25px.png"))); // NOI18N
        jLabel52.setText("Item Name");
        request.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 150, 40));

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(102, 102, 102));
        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_metamorphose_25px.png"))); // NOI18N
        jLabel53.setText("Item Description");
        request.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 450, 150, 40));

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(102, 102, 102));
        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_air_quality_25px.png"))); // NOI18N
        jLabel54.setText("Item Condition");
        request.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, 150, 40));

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(102, 102, 102));
        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_alphabetical_sorting_25px.png"))); // NOI18N
        jLabel55.setText("Item Category");
        request.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 150, 30));

        btn_item_submit1.setBackground(new Color(255,255,255,30));
        btn_item_submit1.setText("Commit");
        btn_item_submit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_item_submit1ActionPerformed(evt);
            }
        });
        request.add(btn_item_submit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 520, 90, 30));

        table_layer.add(request, "card5");

        landing_Panel.add(table_layer, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 1190, 580));

        Side_bar.setBackground(new java.awt.Color(115, 115, 115));
        Side_bar.setLayout(new java.awt.CardLayout());

        side1.setBackground(new java.awt.Color(115, 115, 115));
        side1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(204, 204, 204));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_microsoft_excel_35px.png"))); // NOI18N
        jLabel46.setText("IMPORT  EXCEL");
        jLabel46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel46MouseClicked(evt);
            }
        });
        side1.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 90));

        export_toExcel.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        export_toExcel.setForeground(new java.awt.Color(204, 204, 204));
        export_toExcel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        export_toExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_database_export_35px.png"))); // NOI18N
        export_toExcel.setText("EXPORT  EXCEL");
        export_toExcel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                export_toExcelMouseClicked(evt);
            }
        });
        side1.add(export_toExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 130, 70));

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(204, 204, 204));
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_export_pdf_35px.png"))); // NOI18N
        jLabel57.setText("EXPORT PDF");
        side1.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 120, 70));

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(204, 204, 204));
        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_pivot_table_35px.png"))); // NOI18N
        jLabel58.setText(" DESIGNATE");
        jLabel58.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel58MouseClicked(evt);
            }
        });
        side1.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 130, 70));

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(204, 204, 204));
        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_mind_map_35px_1.png"))); // NOI18N
        jLabel59.setText("TO  INDIVIDUALS");
        jLabel59.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel59MouseClicked(evt);
            }
        });
        side1.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 130, 70));

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(204, 204, 204));
        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_central_air_conditioning_35px_2.png"))); // NOI18N
        jLabel63.setText(" TO ROOMS");
        jLabel63.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel63MouseClicked(evt);
            }
        });
        side1.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 130, 70));

        Side_bar.add(side1, "card2");

        side2.setBackground(new java.awt.Color(115, 115, 115));
        side2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_diff_files_30px.png"))); // NOI18N
        jLabel13.setText("Asset Entry");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        side2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 120, 60));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_inscription_30px_1.png"))); // NOI18N
        jLabel14.setText("Categorize");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        side2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 100, 60));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 204, 204));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_ocr_30px.png"))); // NOI18N
        jLabel15.setText("Stock Types");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        side2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 120, 60));

        Side_bar.add(side2, "card2");

        side3.setBackground(new java.awt.Color(115, 115, 115));
        side3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Side_bar.add(side3, "card2");

        landing_Panel.add(Side_bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 130, 580));

        lb_gb_table.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/background_fortable.png"))); // NOI18N
        landing_Panel.add(lb_gb_table, new org.netbeans.lib.awtextra.AbsoluteConstraints(-90, 0, 1460, 1060));

        model.setForeground(new java.awt.Color(240, 240, 240));
        model.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        model.setText("jLabel2");
        landing_Panel.add(model, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 130, 30));

        javax.swing.GroupLayout desktop_panelLayout = new javax.swing.GroupLayout(desktop_panel);
        desktop_panel.setLayout(desktop_panelLayout);
        desktop_panelLayout.setHorizontalGroup(
            desktop_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktop_panelLayout.createSequentialGroup()
                .addComponent(landing_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        desktop_panelLayout.setVerticalGroup(
            desktop_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktop_panelLayout.createSequentialGroup()
                .addComponent(landing_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        desktop_panel.setLayer(landing_Panel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanel1.add(desktop_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1370, 690));

        Top_Header.setBackground(new java.awt.Color(204, 204, 204));
        Top_Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_minus_19px.png"))); // NOI18N
        jLabel19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        Top_Header.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 20, 50, 40));

        btn10.setBackground(new java.awt.Color(115, 115, 115));
        btn10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn10MouseExited(evt);
            }
        });
        btn10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/home_white.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn10.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 40));

        Top_Header.add(btn10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 80, 40));

        btn9.setBackground(new java.awt.Color(115, 115, 115));
        btn9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_delete_18px_1.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        btn9.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        Top_Header.add(btn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 20, 40, 40));

        btn11.setBackground(new java.awt.Color(115, 115, 115));
        btn11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn11MouseExited(evt);
            }
        });
        btn11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(224, 224, 224));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText(" Request");
        jLabel23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn11.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 70, 40));

        Top_Header.add(btn11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 140, 40));

        btn12.setBackground(new java.awt.Color(115, 115, 115));
        btn12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn12MouseExited(evt);
            }
        });
        btn12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel47.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(224, 224, 224));
        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel47.setText("problems");
        jLabel47.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn12.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        Top_Header.add(btn12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 140, 40));

        btn14.setBackground(new java.awt.Color(115, 115, 115));
        btn14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn14MouseExited(evt);
            }
        });
        btn14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel73.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(224, 224, 224));
        jLabel73.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel73.setText("Solutions");
        jLabel73.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn14.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 80, 40));

        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel74.setText("Search Records");
        jPanel31.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        btn14.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 130, 30));

        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel75.setText("Search Records");
        jPanel32.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel76.setText("Search Records");
        jPanel33.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel32.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 130, 30));

        btn14.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 130, 30));

        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        btn14.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 30, 60));

        Top_Header.add(btn14, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 160, 40));

        btn15.setBackground(new java.awt.Color(115, 115, 115));
        btn15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn15MouseExited(evt);
            }
        });
        btn15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(224, 224, 224));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Assets");
        jLabel39.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn15.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 40));

        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        btn15.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 30, 60));

        Top_Header.add(btn15, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 140, 40));

        btn17.setBackground(new java.awt.Color(115, 115, 115));
        btn17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn17MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn17MouseExited(evt);
            }
        });
        btn17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(224, 224, 224));
        jLabel22.setText("New Request");
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn17.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 100, 40));

        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        btn17.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 30, 60));

        Top_Header.add(btn17, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 20, 150, 40));

        btn16.setBackground(new java.awt.Color(115, 115, 115));
        btn16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn16MouseExited(evt);
            }
        });
        btn16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(224, 224, 224));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Purchases");
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn16.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 90, 40));

        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        btn16.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 30, 60));

        Top_Header.add(btn16, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, 140, 40));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/sear.png"))); // NOI18N
        Top_Header.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 20, 40, 40));

        txt_search.setBackground(new Color(255,255,255,1));
        txt_search.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txt_search.setForeground(new java.awt.Color(153, 153, 153));
        txt_search.setBorder(null);
        txt_search.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_searchKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_searchKeyTyped(evt);
            }
        });
        Top_Header.add(txt_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 20, 210, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/s.png"))); // NOI18N
        Top_Header.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 0, -1, 70));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/header.png"))); // NOI18N
        jLabel1.setText("jLabel1");
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
        Top_Header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 10, 1380, 80));

        jPanel1.add(Top_Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 80));

        item_Problem_Solution.setBackground(new Color(255,255,255,20));
        item_Problem_Solution.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        P_Title.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P_Title.setForeground(new java.awt.Color(102, 102, 102));
        P_Title.setText("Item Problem");
        item_Problem_Solution.add(P_Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 640, 90, 60));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        P_Save.setBackground(new Color(255,255,255,30));
        P_Save.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        P_Save.setForeground(new java.awt.Color(102, 102, 102));
        P_Save.setText("Save");
        P_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P_SaveActionPerformed(evt);
            }
        });
        jPanel2.add(P_Save, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, 110, 40));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(153, 153, 153));
        jLabel24.setText("Item's Problem");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 100, 70));

        P_Text.setColumns(20);
        P_Text.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        P_Text.setForeground(new java.awt.Color(102, 102, 102));
        P_Text.setRows(5);
        P_Text.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(51, 51, 51))); // NOI18N
        jScrollPane4.setViewportView(P_Text);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 420, 150));

        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/ex.png"))); // NOI18N
        jLabel61.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel61MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 0, 50, 40));

        P_Update.setBackground(new Color(255,255,255,30));
        P_Update.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        P_Update.setForeground(new java.awt.Color(102, 102, 102));
        P_Update.setText("update");
        P_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                P_UpdateActionPerformed(evt);
            }
        });
        jPanel2.add(P_Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 390, 110, 40));

        txt_forCost_ofRepair.setBackground(new Color(255,255,255,1));
        txt_forCost_ofRepair.setForeground(new java.awt.Color(204, 204, 204));
        txt_forCost_ofRepair.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 6, 1, 1));
        jPanel2.add(txt_forCost_ofRepair, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, 230, 33));

        lb_forCost_ofRepair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/searc.png"))); // NOI18N
        jPanel2.add(lb_forCost_ofRepair, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 250, -1, 90));

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(153, 153, 153));
        jLabel62.setText("Cost");
        jPanel2.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 220, 50, 30));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(false);
        jScrollPane5.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, 340, 150));

        txt_problem.setColumns(20);
        txt_problem.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txt_problem.setRows(5);
        txt_problem.setEnabled(false);
        jScrollPane6.setViewportView(txt_problem);

        jPanel2.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 360, 140));

        item_Problem_Solution.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 1000, 440));

        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/popup.png"))); // NOI18N
        item_Problem_Solution.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 1290, 440));

        jPanel1.add(item_Problem_Solution, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn16MouseClicked
        Category_list.hide();
        Category_entry1.hide();
        update_structureEntry.hide();
        Type_entry.hide();
        request.hide();

        home_table.hide();
        data_entry.hide();
        Item_Category_Table.setVisible(true);
        request_table.hide();
        Purchases.setVisible(true);

        try {
            conn = DBConnection.getConnction();
            String sql = " SELECT request_number,item_name,item_description,cost_per_item,conditions,warranty_ex_date,category  FROM request WHERE order_process = ?";
            pps12 = conn.prepareStatement(sql);//
            pps12.setString(1, "Processed");
            rs12 = pps12.executeQuery();
            Purchases_list.setModel(DbUtils.resultSetToTableModel(rs12));
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_btn16MouseClicked

    private void btn16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn16MouseEntered
        btn16.setBackground(new Color(33, 173, 178));
    }//GEN-LAST:event_btn16MouseEntered

    private void btn16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn16MouseExited
        btn16.setBackground(new Color(115, 115, 115));
    }//GEN-LAST:event_btn16MouseExited

    private void btn11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn11MouseClicked
        Category_list.hide();
        Category_entry1.hide();
        update_structureEntry.hide();
        Type_entry.hide();
        request.hide();

        home_table.hide();
        data_entry.hide();
        Item_Category_Table.setVisible(true);
        request_table.setVisible(true);
    }//GEN-LAST:event_btn11MouseClicked

    private void btn11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn11MouseEntered
        btn11.setBackground(new Color(33, 173, 178));
    }//GEN-LAST:event_btn11MouseEntered

    private void btn11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn11MouseExited
        btn11.setBackground(new Color(115, 115, 115));
    }//GEN-LAST:event_btn11MouseExited

    private void btn15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn15MouseClicked
        Item_Category_Table.hide();
        data_entry.hide();
        side3.hide();
        side2.hide();
        side1.setVisible(true);
        home_table.setVisible(true);
    }//GEN-LAST:event_btn15MouseClicked

    private void btn15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn15MouseEntered
        btn15.setBackground(new Color(33, 173, 178));
    }//GEN-LAST:event_btn15MouseEntered

    private void btn15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn15MouseExited
        btn15.setBackground(new Color(115, 115, 115));
    }//GEN-LAST:event_btn15MouseExited

    private void btn17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn17MouseClicked
        //turning the item entry form 
        side3.hide();
        side1.hide();
        side2.setVisible(true);

        home_table.hide();
        data_entry.hide();
        Item_Category_Table.hide();
        data_entry.hide();
        request.setVisible(true);
    }//GEN-LAST:event_btn17MouseClicked

    private void btn17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn17MouseEntered
        btn17.setBackground(new Color(33, 173, 178));
    }//GEN-LAST:event_btn17MouseEntered

    private void btn17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn17MouseExited
        btn17.setBackground(new Color(115, 115, 115));
    }//GEN-LAST:event_btn17MouseExited

    private void btn14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn14MouseClicked
  if(!home_table.isShowing())  {    
                    Category_list.hide();
                    Category_entry1.hide();
                    update_structureEntry.hide();
                    Type_entry.hide();
                    request.hide();

                    data_entry.hide();
                    Item_Category_Table.hide();
                    request_table.hide();
                    home_table.setVisible(true);
        
  }else{  
        
        if (table_clicked.equals("none")) {
            JOptionPane.showMessageDialog(null, "Select the Item");
        } else if (!table_clicked.equals("none")) {

                    Category_list.hide();
                    Category_entry1.hide();
                    update_structureEntry.hide();
                    Type_entry.hide();
                    request.hide();

                    data_entry.hide();
                    Item_Category_Table.hide();
                    request_table.hide();
                    home_table.setVisible(true);
            
            try {
                conn = DBConnection.getConnction();
                pps = conn.prepareStatement("SELECT  Item_id   FROM inventory_items WHERE item_number = ?");
                pps.setString(1, table_clicked);
                rs = pps.executeQuery();
                if (rs.next()) {
                    Detail_Item_id = rs.getString("Item_id");
                    P_Title.setText("Solution");

                    lb_forCost_ofRepair.setVisible(true);
                    txt_forCost_ofRepair.setVisible(true);
                    P_Save.hide();

                    P_Update.setVisible(true);
                    Category_list.hide();
                    Category_entry1.hide();
                    update_structureEntry.hide();
                    Type_entry.hide();
                    request.hide();

                    home_table.hide();
                    data_entry.hide();
                    Item_Category_Table.hide();
                    request_table.hide();
                    desktop_panel.hide();
                    Top_Header.hide();
                    
                    table_layer.setVisible(true);
                    home_table.setVisible(true);

                    item_Problem_Solution.setVisible(true);
                    problem();
                }
            } catch (Exception ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
        }
       }
    }//GEN-LAST:event_btn14MouseClicked

    public void problem(){
     try {// converting the IDs
            int ConvertedDetails_Item_id = Integer.parseInt(Detail_Item_id);
            conn = DBConnection.getConnction();
            pps8 = conn.prepareStatement("SELECT * FROM  item_details  WHERE Item_id =? ");
            pps8.setInt(1, ConvertedDetails_Item_id);
            rs8 = pps8.executeQuery();
            if(rs8.next()){
                txt_problem.setText(rs8.getString("problem"));
            }
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
    }
    
    private void btn14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn14MouseEntered
        btn14.setBackground(new Color(33, 173, 178));
    }//GEN-LAST:event_btn14MouseEntered

    private void btn14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn14MouseExited
        btn14.setBackground(new Color(115, 115, 115));
    }//GEN-LAST:event_btn14MouseExited

    private void btn12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn12MouseClicked
   
  if(!home_table.isShowing())  {    
                    Category_list.hide();
                    Category_entry1.hide();
                    update_structureEntry.hide();
                    Type_entry.hide();
                    request.hide();

                    data_entry.hide();
                    Item_Category_Table.hide();
                    request_table.hide();
                    home_table.setVisible(true);
        
  }else{
      
   if (table_clicked.equals("none")) {
      JOptionPane.showMessageDialog(null, "Select the Item");
      } else if (!table_clicked.equals("none")) {
                    Category_list.hide();
                    Category_entry1.hide();
                    update_structureEntry.hide();
                    Type_entry.hide();
                    request.hide();

                    data_entry.hide();
                    Item_Category_Table.hide();
                    request_table.hide();
                    home_table.setVisible(true);
            
                try {
                conn = DBConnection.getConnction();
                pps = conn.prepareStatement("SELECT  Item_id   FROM inventory_items WHERE item_number = ?");
                pps.setString(1, table_clicked);
                rs = pps.executeQuery();
                while (rs.next()) {
                    Item_id = rs.getString("Item_id");
                    P_Title.setText("Problem");
                    P_Save.setVisible(true);
                    P_Update.hide();
                    
                    Category_list.hide();
                    Category_entry1.hide();
                    update_structureEntry.hide();
                    Type_entry.hide();
                    request.hide();

                    desktop_panel.hide();
                    Top_Header.hide(); // 0977874932
                  
                    home_table.hide();
                    data_entry.hide();
                    Item_Category_Table.hide();
                    request_table.hide();
  
                     home_table.setVisible(true);
                     item_Problem_Solution.setVisible(true);
                     
                     
                 
                }
            } catch (Exception ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
        }
  }

      
    }//GEN-LAST:event_btn12MouseClicked

    private void btn12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn12MouseEntered
        btn12.setBackground(new Color(33, 173, 178));

    }//GEN-LAST:event_btn12MouseEntered

    private void btn12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn12MouseExited
        btn12.setBackground(new Color(115, 115, 115));

    }//GEN-LAST:event_btn12MouseExited

    private void btn10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn10MouseEntered
        btn10.setBackground(new Color(33, 173, 178));

    }//GEN-LAST:event_btn10MouseEntered

    private void btn10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn10MouseExited
        btn10.setBackground(new Color(115, 115, 115));

    }//GEN-LAST:event_btn10MouseExited

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void btn_entryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_entryActionPerformed
        data_entry.hide();
        home_table.hide();
        request.hide();
        Category_list.setVisible(true); 
        Category_entry1.hide();
        update_structureEntry.hide();
        Type_entry.hide();
        Type_list.hide();
        Item_Category_Table.setVisible(true);
        side1.hide();
        side2.setVisible(true);
        side3.hide();
        home_table.hide();
        data_entry.hide();
        
    }//GEN-LAST:event_btn_entryActionPerformed

    private void category_tbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_category_tbMouseClicked

        if (btn_FirstView1.isShowing()) {
            btn_FirstView1.hide();
            btn_secondView1.setVisible(true);
            
        } else if (btn_secondView1.isShowing()) {
            btn_secondView1.hide();
            btn_FirstView1.setVisible(true);
        }
    }//GEN-LAST:event_category_tbMouseClicked

    private void Add_price2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_price2MouseClicked
        // TODO add your handling code here:
        Category_list.hide();
        Type_entry.setVisible(true);
        update_structureEntry.hide();
        Savebtn.setVisible(true);
    }//GEN-LAST:event_Add_price2MouseClicked

    private void Delecte13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Delecte13MouseClicked
        try {
            DefaultTableModel tableMode2 = (DefaultTableModel) category_tb.getModel();
            String Structure_name = tableMode2.getValueAt(category_tb.getSelectedRow(), 0).toString();
            conn = DBConnection.getConnction();

            pps = conn.prepareStatement("SELECT *  FROM inventory_category WHERE category_name = ?");
            pps.setString(1, Structure_name);
            rs = pps.executeQuery();
            if (rs.next()) {
                Resource_forCategory_ID = rs.getString("category_id");
                // deleteSelected();
            }
        } catch (Exception ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

        try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("DELETE  FROM inventory_category WHERE category_id = ?");
            pps.setString(1, Resource_forCategory_ID);
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Category Deleted");
            TableContent();//show on tables fuction
            //   Count_Roomtype();//show on labels for counting
        } catch (Exception ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_Delecte13MouseClicked

    private void edit13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit13MouseClicked
        try {
            DefaultTableModel tableMode2 = (DefaultTableModel) category_tb.getModel();
            String Structure_name = tableMode2.getValueAt(category_tb.getSelectedRow(), 0).toString();

            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("SELECT * FROM inventory_category WHERE category_name = ?");
            pps.setString(1, Structure_name);
            rs = pps.executeQuery();
            if (rs.next()) {
                //if the structure is found put the id nd name in resources
                Resource_forCategory_ID = rs.getString("category_id");

                cate_name.setText(rs.getString("category_name"));
                cate_number.setText(rs.getString("category_number"));
                cate_description.setText(rs.getString("category_description"));

                Category_list.hide();         //changing page,, from list to entry ^^
                Category_entry1.setVisible(true);
                update_structureEntry.setVisible(true);
                Savebtn1.hide();
                update_Category_Entry.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Category found, Select and Press Edit");
                Category_list.setVisible(true);  //if name of structure is not found,, stay on the same page
                Category_entry1.hide();
            }
        } catch (Exception ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_edit13MouseClicked

    private void add_floorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_floorMouseClicked
        Category_list.hide();
        Type_entry.hide();
        Category_entry1.setVisible(true);

        update_structureEntry.hide();
        Savebtn.setVisible(true);
    }//GEN-LAST:event_add_floorMouseClicked

    private void update_structureEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_structureEntryActionPerformed
        // updating
        try {
            int convert_Resource_Type_ID = Integer.parseInt(Resource_Type_ID);
            conn = DBConnection.getConnction();

            pps12 = conn.prepareStatement("UPDATE inventory_type SET type_name =?,type_number =?,type_description =?  WHERE item_type_id = ?");
            pps12.setString(1, typename.getText().trim());
            pps12.setString(2, typenumber.getText().trim());
            pps12.setString(3, Typedescription.getText().trim());
            pps12.setInt(4, convert_Resource_Type_ID);

            pps12.executeUpdate();

            typename.setText(null);
            typenumber.setText(null);
            Typedescription.setText(null);
            JOptionPane.showMessageDialog(null, "Successfully");
            TableContent();
            Savebtn.setVisible(true);
            update_structureEntry.hide();
//show on tables fuction
        } catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);}
    }//GEN-LAST:event_update_structureEntryActionPerformed

    private void SavebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SavebtnActionPerformed
        try {
            conn = DBConnection.getConnction();
            pps5 = conn.prepareStatement("SELECT * FROM inventory_type WHERE type_name =? AND type_number =?");// AND contact = ?
            pps5.setString(1, typename.getText().trim());
            pps5.setString(2, typenumber.getText().trim());
            rs5 = pps5.executeQuery();
            if (rs5.next()) {
                JOptionPane.showMessageDialog(null, "inventory type Already Exists");
            } else {
                insertAfter_Search();
            }
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_SavebtnActionPerformed

    public void insertAfter_Search() {
        try {
            conn = DBConnection.getConnction();
            pps7 = conn.prepareStatement("INSERT INTO inventory_type(type_name, type_number,type_description) VALUES (?,?,?) ");// AND contact = ?
            pps7.setString(1, typename.getText().trim());
            pps7.setString(2, typenumber.getText().trim());
            pps7.setString(3, Typedescription.getText().trim());

            pps7.executeUpdate();
            JOptionPane.showMessageDialog(null, "Type Created");
            TableContent();
            ComboContent();
            typename.setText(null);
            typenumber.setText(null);
            Typedescription.setText(null);

        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
    }

    private void update_Category_EntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_Category_EntryActionPerformed
        // updating
        try {
            conn = DBConnection.getConnction();

            pps = conn.prepareStatement("UPDATE inventory_category SET category_name =?,category_number =?,category_description =? WHERE category_id = ?");
            pps.setString(1, cate_name.getText().trim());
            pps.setString(2, cate_number.getText().trim());
            pps.setString(3, cate_description.getText().trim());
            pps.setString(4, Resource_forCategory_ID);

            pps.executeUpdate();
            cate_name.setText(null);
            cate_number.setText(null);
            cate_description.setText(null);
            JOptionPane.showMessageDialog(null, "Successfully");
            TableContent();//show on tables fuction
            Savebtn1.setVisible(true);
            update_Category_Entry.hide();
            //   Count_Roomtype();//show on labels for counting
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }//GEN-LAST:event_update_Category_EntryActionPerformed

    private void Savebtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Savebtn1ActionPerformed
        try {
            conn = DBConnection.getConnction();
            String sql = " SELECT * FROM inventory_category WHERE category_name =?";
            pps = conn.prepareStatement(sql);
            pps.setString(1, cate_name.getText().trim());
            rs = pps.executeQuery();
            if (!rs.next()) {
                insertCategory();
            } else {
                JOptionPane.showMessageDialog(null, "Category already Exists");

            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Savebtn1ActionPerformed

    public void insertCategory() {
        try {
            conn = DBConnection.getConnction();
            String sql = "INSERT INTO inventory_category (category_name,category_number,category_description) VALUES (?,?,?)";
            pps1 = conn.prepareStatement(sql);
            pps1.setString(1, cate_name.getText().trim());
            pps1.setString(2, cate_number.getText().trim());
            pps1.setString(3, cate_description.getText().trim());
            pps1.executeUpdate();
            cate_name.setText(null);
            cate_number.setText(null);
            cate_description.setText(null);
            JOptionPane.showMessageDialog(null, "Category Created");

            TableContent();//show on tables fuction
            ComboContent();//show on labels for counting
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        Category_list.hide();
        Category_entry1.hide();
        update_structureEntry.hide();
        Type_entry.hide();
        request.hide();
        Item_Category_Table.hide();
        home_table.hide();
        data_entry.setVisible(true);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        data_entry.hide();
        home_table.hide();
        update_structureEntry.hide();
        request.hide();
        Item_Category_Table.setVisible(true);

        Type_entry.hide();
        Type_list.hide();

        Category_list.setVisible(true);
        Category_entry1.hide();

    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel84MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel84MouseClicked

        update_structureEntry.hide();
        Category_entry1.hide();
        Category_list.hide();

        Type_entry.hide();
        Type_list.setVisible(true);

    }//GEN-LAST:event_jLabel84MouseClicked

    private void jLabel80MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel80MouseClicked
        update_structureEntry.hide();
        Type_entry.hide();
        Category_entry1.hide();
        Category_list.setVisible(true);

        //btn
        btn_secondView1.hide();
        btn_FirstView1.setVisible(true);
    }//GEN-LAST:event_jLabel80MouseClicked

    private void SockType_tbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SockType_tbMouseClicked
        if (btn_FirstView2.isShowing()) {
            btn_FirstView2.hide();
            btn_secondView2.setVisible(true);
        } else if (btn_secondView2.isShowing()) {
            btn_secondView2.hide();
            btn_FirstView2.setVisible(true);
        }
    }//GEN-LAST:event_SockType_tbMouseClicked

    private void Delecte14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Delecte14MouseClicked
        try {
            DefaultTableModel tableMode2 = (DefaultTableModel) SockType_tb.getModel();
            String Structure_name = tableMode2.getValueAt(SockType_tb.getSelectedRow(), 0).toString();
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("SELECT *  FROM inventory_type WHERE type_name = ?");
            pps.setString(1, Structure_name);
            rs = pps.executeQuery();
            if (rs.next()) {
                Resource_Type_ID = rs.getString("item_type_id");
            }
        } catch (Exception ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

        try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("DELETE  FROM inventory_type WHERE item_type_id = ?");
            pps.setString(1, Resource_Type_ID);
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "ITem type Deleted");
            TableContent();//show on tables fuction
            //   Count_Roomtype();//show on labels for counting
        } catch (Exception ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_Delecte14MouseClicked

    private void edit14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit14MouseClicked
        try {
            DefaultTableModel tableMode_type = (DefaultTableModel) SockType_tb.getModel();
            String type_name = tableMode_type.getValueAt(SockType_tb.getSelectedRow(), 0).toString();
            conn = DBConnection.getConnction();
            pps11 = conn.prepareStatement("SELECT * FROM inventory_type WHERE type_name = ?");
            pps11.setString(1, type_name);
            rs11 = pps11.executeQuery();
            if (rs11.next()) {
                //if the structure is found put the id nd name in resources
                Resource_Type_ID = rs11.getString("item_type_id");
                typename.setText(rs11.getString("type_name"));
                typenumber.setText(rs11.getString("type_number"));
                Typedescription.setText(rs11.getString("type_description"));

                Type_list.hide();         //changing page,, from list to entry ^^
                Type_entry.setVisible(true);
                update_structureEntry.setVisible(true);
                Savebtn.hide();
                update_structureEntry.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Item Type found, Select and Press Edit");
                Type_list.setVisible(true);  //if name of structure is not found,, stay on the same page
                Type_entry.hide();
            }
        } catch (Exception ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_edit14MouseClicked

    private void add_floor1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_floor1MouseClicked
        Type_list.hide();
        Type_entry.setVisible(true);
    }//GEN-LAST:event_add_floor1MouseClicked

    private void Add_price3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_price3MouseClicked
        Type_list.hide();
        Type_entry.setVisible(true);

    }//GEN-LAST:event_Add_price3MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked

        data_entry.hide();
        home_table.hide();
        Item_Category_Table.setVisible(true);

        request.hide();

        Category_list.hide();
        Category_entry1.hide();
        update_structureEntry.hide();

        Type_entry.hide();
        Type_list.setVisible(true);
    }//GEN-LAST:event_jLabel15MouseClicked

    private void btn_item_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_item_submitActionPerformed
        try {
            conn = DBConnection.getConnction();
            pps6 = conn.prepareStatement("SELECT * FROM inventory_items WHERE (item_number=? OR item_name = ?)  AND (model = ? AND serial_number=?)");
            pps6.setString(1, txt_Item_number.getText().trim());
            pps6.setString(2, txt_Item_Name.getText().trim());
            pps6.setString(3, txt_Item_Mode.getText().trim());
            pps6.setString(4, txt_Serial_number.getText().trim());
            rs6 = pps6.executeQuery();
            if (rs6.next()) {
                JOptionPane.showMessageDialog(null, "Item Already Exists");
            } else {
                insertingITEMS();
            }
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

    }//GEN-LAST:event_btn_item_submitActionPerformed

    private void image_chooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_image_chooserActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setFileHidingEnabled(false);
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            java.io.File f = chooser.getSelectedFile();
            img_url.setText(f.getPath());
            try {
                ImageIcon icon = new ImageIcon(ImageIO.read(f));
                Image image = icon.getImage();
                Image modifiedImage = image.getScaledInstance(img_pane.getWidth(), img_pane.getHeight(), Image.SCALE_SMOOTH);
                icon = new ImageIcon(modifiedImage);
                img_holder.setIcon(icon);
            } catch (IOException ex) {Logger.getLogger(Adminstrative.class.getName()).log(Level.SEVERE, null, ex);}
        }
    }//GEN-LAST:event_image_chooserActionPerformed

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        // TODO add your handling code here:
        this.setExtendedState(Inventory.ICONIFIED);

    }//GEN-LAST:event_jLabel19MouseClicked

    private void Main_list_ViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Main_list_ViewMouseClicked
        DefaultTableModel tableMode_type = (DefaultTableModel) Main_list_View.getModel();
        table_clicked = tableMode_type.getValueAt(Main_list_View.getSelectedRow(), 0).toString();
    }//GEN-LAST:event_Main_list_ViewMouseClicked

    private void Delete_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_itemActionPerformed
        if (table_clicked.equals("none")) {
            JOptionPane.showMessageDialog(null, "Select the Item you wish to delete");
        } else if (!table_clicked.equals("none")) {
            try {
                conn = DBConnection.getConnction();

                pps = conn.prepareStatement("DELETE  FROM inventory_items WHERE item_number = ?");
                pps.setString(1, table_clicked);
                pps.executeUpdate();
                showContent_OnMain_table();//show on tables fuction

                JOptionPane.showMessageDialog(null, "Item Deleted");

            } catch (Exception ex) {
                Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_Delete_itemActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        if (table_clicked.equals("none")) {
            JOptionPane.showMessageDialog(null, "Select the Item you wish to Edit");
            } else if (!table_clicked.equals("none")) {
              try {
                conn = DBConnection.getConnction();
                pps6 = conn.prepareStatement("SELECT * FROM inventory_items WHERE item_number=? ");
                pps6.setString(1, table_clicked);
                rs6 = pps6.executeQuery();
                byte[] image = null;
                if (rs6.next()) {
                    side1.hide();
                    side2.setVisible(true);
                    side3.hide();
                    home_table.hide();
                    data_entry.hide();
                    Category_list.hide();
                    Category_entry1.hide();
                    update_structureEntry.hide();
                    Type_entry.hide();
                    request.hide();

                    Item_Category_Table.hide();
                    request_table.hide();
                    home_table.hide();
                    data_entry.setVisible(true);
                    Item_Category_Table.hide();
                    
                    txt_Item_number.setText(rs6.getString("item_number"));
                    txt_Item_Name.setText(rs6.getString("item_name"));
                    txt_Item_Description.setText(rs6.getString("item_description"));
                    txt_Item_Mode.setText(rs6.getString("model"));
                    txt_Serial_number.setText(rs6.getString("serial_number"));
                    txt_Purchase.setText(rs6.getString("cost_per_item"));
                    txt_Item_Condition.setText(rs6.getString("conditions"));
                 
                    last_date_order.hide();
                    order_view.setVisible(true);
                    order_view.setText(rs6.getString("date_oflast_order") );  
                    
                    warranty_expiry.hide();
                    warrant_view.setVisible(true);
                    warrant_view.setText(rs6.getString("warranty_ex_date"));
                    
                    btn_item_submit2.setVisible(true);
                    btn_item_submit.hide();
                    
                      
                    img_url.setText(null);
                    img_holder.setText(null);

                    image = rs6.getBytes("item_image");
                    Image img = Toolkit.getDefaultToolkit().createImage(image);
                    ImageIcon icon = new ImageIcon(img);
                    img_holder.setIcon(icon);
                }

            } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);} 

        }
    }//GEN-LAST:event_editActionPerformed

    private void btn10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn10MouseClicked
if(!home_table.isShowing()){
        Item_Category_Table.hide();
        data_entry.hide();

        side3.hide();
        side2.hide();
        side1.setVisible(true);
        home_table.setVisible(true);
}else{
Admin_Home.getObj().setVisible(true);
 //passing user id 
 Admin_Home.getObj().setUserID(Recieved_user_id);
 Admin_Home.getObj().printUserID();

 this.dispose();

}
     
       
    }//GEN-LAST:event_btn10MouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        DefaultTableModel table = (DefaultTableModel) Main_list_View.getModel();
        String search = txtSearch.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        tr.setRowFilter(RowFilter.regexFilter(search));
        Main_list_View.setRowSorter(tr);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btn_item_submit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_item_submit1ActionPerformed
        try {
            conn = DBConnection.getConnction();
            pps6 = conn.prepareStatement("SELECT * FROM request WHERE request_number =?");
            pps6.setString(1, txt_Item_number1.getText().trim());
            rs6 = pps6.executeQuery();
            if (rs6.next()) {
                JOptionPane.showMessageDialog(null, "Item Order Already Exists");
            } else {
                inserting_order();
            }
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_btn_item_submit1ActionPerformed

    private void request_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_request_listMouseClicked
        if (btn_FirstView3.isShowing()) {
            btn_FirstView3.hide();
            btn_secondView3.setVisible(true);
        } else if (btn_secondView3.isShowing()) {
            btn_secondView3.hide();
            btn_FirstView3.setVisible(true);}

        DefaultTableModel tableMode_type = (DefaultTableModel) request_list.getModel();
        request_table_clicked = tableMode_type.getValueAt(request_list.getSelectedRow(), 0).toString();
    }//GEN-LAST:event_request_listMouseClicked

    private void Add_price4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_price4MouseClicked
        if (request_table_clicked.equals("none")) {
            JOptionPane.showMessageDialog(null, "Select the Item you wish to delete");
        } else if (!request_table_clicked.equals("none")) {
            try {
                conn = DBConnection.getConnction();
                String status = "Processed";
                pps = conn.prepareStatement("Update  request SET  order_process =? WHERE request_number = ?");
                pps.setString(1, status);
                pps.setString(2, request_table_clicked);

                pps.executeUpdate();
                showContent_OnMain_table();//show on tables fuction
                JOptionPane.showMessageDialog(null, "Item processed");
            } catch (Exception ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
        }
    }//GEN-LAST:event_Add_price4MouseClicked

    private void Delecte15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Delecte15MouseClicked
        String request_id = null;
        try {
            DefaultTableModel tableMode2 = (DefaultTableModel) request_list.getModel();
            String Structure_name = tableMode2.getValueAt(request_list.getSelectedRow(), 0).toString();
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("SELECT *  FROM request WHERE request_number = ?");
            pps.setString(1, Structure_name);
            rs = pps.executeQuery();
            if (rs.next()) {
                request_id = rs.getString("request_id");
            }
        } catch (Exception ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

        try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("DELETE  FROM request WHERE request_id = ?");
            pps.setString(1, request_id);
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Request Deleted");
            TableContent();//show on tables fuction
        } catch (Exception ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_Delecte15MouseClicked

    private void edit15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit15MouseClicked
        if (request_table_clicked.equals("none")) {
            JOptionPane.showMessageDialog(null, "Select the Item you wish to Edit");
        } else if (!request_table_clicked.equals("none")) {
            try {
                conn = DBConnection.getConnction();
                pps11 = conn.prepareStatement("SELECT * FROM request WHERE request_number = ?");
                pps11.setString(1, request_table_clicked);
                rs11 = pps11.executeQuery();
                Combo_Category.removeAllItems();
                ComboItem_type.removeAllItems();
                if (rs11.next()) {
                    //if the structure is found put the id nd name in resources
                    Resource_Type_ID = rs11.getString("request_id");
                    txt_Item_number.setText(rs11.getString("request_number"));
                    txt_Item_Name.setText(rs11.getString("item_name"));
                    txt_Item_Description.setText(rs11.getString("item_description"));

                    txt_Purchase.setText(rs11.getString("cost_per_item"));
                    txt_Item_Condition.setText(rs11.getString("conditions"));

                    Typedescription.setText(rs11.getString("warranty_ex_date"));
                    Combo_Category.addItem(rs11.getString("category"));
                    ComboItem_type.addItem(rs11.getString("type"));

                    //turning the item entry form 
                    side3.hide();
                    side1.hide();
                    side2.setVisible(true);

                    home_table.hide();
                    data_entry.hide();
                    Item_Category_Table.hide();
                    data_entry.hide();
                    request.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Item Type found, Select and Press Edit");
                    Type_list.setVisible(true);  //if name of structure is not found,, stay on the same page
                    Type_entry.hide();
                }
            } catch (Exception ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
        }
    }//GEN-LAST:event_edit15MouseClicked

    private void add_floor2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_floor2MouseClicked
        //turning the item entry form 
        side3.hide();
        side1.hide();
        side2.setVisible(true);

        home_table.hide();
        data_entry.hide();
        Item_Category_Table.hide();
        data_entry.hide();
        request.setVisible(true);

    }//GEN-LAST:event_add_floor2MouseClicked

    private void Purchases_listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Purchases_listMouseClicked
       
        DefaultTableModel tableMode_type = (DefaultTableModel) Purchases_list.getModel();
        purchese_table_clicked = tableMode_type.getValueAt(Purchases_list.getSelectedRow(), 0).toString();
    }//GEN-LAST:event_Purchases_listMouseClicked

    private void Add_price5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_price5MouseClicked
         if (purchese_table_clicked.equals("none")) {
          JOptionPane.showMessageDialog(null, "Select the Purchesed Item");
        } else if (!purchese_table_clicked.equals("none")) {
            try {
                conn = DBConnection.getConnction();
                pps6 = conn.prepareStatement("SELECT * FROM request WHERE request_number = ?");
                pps6.setString(1, purchese_table_clicked);
                rs6 = pps6.executeQuery();
                    Combo_Category.removeAllItems();
                    ComboItem_type.removeAllItems();
                if (rs6.next()) {
                    side1.hide();
                    side2.setVisible(true);
                    side3.hide();
                    home_table.hide();
                    data_entry.hide();
                    Category_list.hide();
                    Category_entry1.hide();
                    update_structureEntry.hide();
                    Type_entry.hide();
                    request.hide();

                    Item_Category_Table.hide();
                    request_table.hide();
                    home_table.hide();
                    data_entry.setVisible(true);
                    Item_Category_Table.hide();
                    
                    txt_Item_number.setText(rs6.getString("request_number"));
                    
                    txt_Item_Name.setEnabled(false);
                    txt_Item_Name.setText(rs6.getString("item_name"));
                    
                    txt_Item_Description.setEnabled(false);
                    txt_Item_Description.setText(rs6.getString("item_description"));
                    
                    txt_Purchase.setEnabled(false);
                    txt_Purchase.setText(rs6.getString("cost_per_item"));
                    
                    
                    txt_Item_Condition.setEnabled(false);
                    txt_Item_Condition.setText(rs6.getString("conditions"));
                    
                    Combo_Category.addItem(rs6.getString("category"));
                    ComboItem_type.addItem(rs6.getString("type"));
                    
                            
                    order_view.hide();
                    last_date_order.setVisible(true);
                   
                    warranty_expiry.hide();
                    warrant_view.setVisible(true);
                    warrant_view.setText(rs6.getString("warranty_ex_date"));
                    
                    btn_item_submit2.hide();
                    btn_item_submit.setVisible(true);
                    btn_item_submit.setText("Add to Assets");
                      
                    img_url.setText(null);
                    img_holder.setText(null);

                }

            } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);} 
        }        
        
    }//GEN-LAST:event_Add_price5MouseClicked

    private void Delecte16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Delecte16MouseClicked
        String purchases_id_resource = null;
        try {
            DefaultTableModel tableMode2 = (DefaultTableModel) Purchases_list.getModel();
            String purchases_number = tableMode2.getValueAt(Purchases_list.getSelectedRow(), 0).toString();
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("SELECT *  FROM request WHERE request_number = ?");
            pps.setString(1, purchases_number);
            rs = pps.executeQuery();
            if (rs.next()) {
                purchases_id_resource = rs.getString("request_id");
            }
        } catch (Exception ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

          // deleting    
        try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("DELETE  FROM request WHERE request_id = ?");
            pps.setString(1, purchases_id_resource);
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "ITem type Deleted");
            TableContent();//show on tables fuction
        } catch (Exception ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_Delecte16MouseClicked

    private void P_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P_SaveActionPerformed
        try {// converting the IDs
            int Converted_Item_id = Integer.parseInt(Item_id);
            conn = DBConnection.getConnction();
            pps7 = conn.prepareStatement("INSERT INTO item_details(Item_id, problem) VALUES (?,?) ");
            pps7.setInt(1, Converted_Item_id);
            pps7.setString(2, P_Text.getText());
            pps7.executeUpdate();
            P_Text.setText(null);
            insert_joints();
           JOptionPane.showMessageDialog(null, "problem recorded");

           } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_P_SaveActionPerformed

    
    public void insert_joints(){
        String get_details_id = null ;
       try {// getting the Item the item details id
            int Converted_Item_id = Integer.parseInt(Item_id);
            conn = DBConnection.getConnction();
            pps8 = conn.prepareStatement("SELECT * FROM item_details WHERE Item_id =?");
            pps8.setInt(1, Converted_Item_id);
            rs8 = pps8.executeQuery();
            if(rs8.next()){
             get_details_id = rs8.getString("details_id");
           // JOptionPane.showMessageDialog(null, "problem recorded  id "  + get_details_id);
             
            }
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
       
       
           try {// updating the joint table with a problem id 
            int Details_Item_ids = Integer.parseInt(get_details_id);
           int Item_ids = Integer.parseInt(Item_id);
            
            
            conn = DBConnection.getConnction();
            pps9 = conn.prepareStatement("UPDATE  inventory_joint SET  details_id =?  WHERE Item_id =? ");
            pps9.setInt(1, Details_Item_ids);  
            pps9.setInt(2, Item_ids);
            pps9.executeUpdate();
            } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
       
       
       
    
    
    }
    
    
    
    
    
    
    private void jLabel61MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel61MouseClicked
        Category_list.hide();
        Category_entry1.hide();
        update_structureEntry.hide();
        Type_entry.hide();
        request.hide();

        home_table.hide();
        data_entry.hide();
        Item_Category_Table.hide();
        request_table.hide();

        desktop_panel.setVisible(true);
        Top_Header.setVisible(true);
        item_Problem_Solution.hide();
    }//GEN-LAST:event_jLabel61MouseClicked

    private void P_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_P_UpdateActionPerformed
         try {// converting the IDs
            int ConvertedDetails_Item_id = Integer.parseInt(Detail_Item_id);
            conn = DBConnection.getConnction();
            pps8 = conn.prepareStatement("SELECT * FROM  item_details  WHERE Item_id =? ");
            pps8.setInt(1, ConvertedDetails_Item_id);
            rs8 = pps8.executeQuery();
            if(rs8.next()){
              updateItem_Details();
            }else{
             JOptionPane.showMessageDialog(null, "This Item Has NO Problem");
            }
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_P_UpdateActionPerformed

    private void btn_item_submit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_item_submit2ActionPerformed
     String order_Date = null;
     String warrant_Date = null;
    
        InputStream inputSteam = null;
        String dir = img_url.getText();

        try {
            inputSteam = new FileInputStream(new File(dir));
        } catch (FileNotFoundException ex) {Logger.getLogger(Adminstrative.class.getName()).log(Level.SEVERE, null, ex);}
    
                try {
                String oder_date = ((JTextField) last_date_order.getDateEditor().getUiComponent()).getText();//conveting date to string then putting it on a resource
                String warrant_date = ((JTextField) warranty_expiry.getDateEditor().getUiComponent()).getText();//conveting date to string then putting it on a resource
            
                conn = DBConnection.getConnction();
                pps6 = conn.prepareStatement("UPDATE inventory_items SET item_number =?, item_name =?, item_description =?, model=? , serial_number =?, cost_per_item =?,date_oflast_order=?, conditions =?,warranty_ex_date =? WHERE item_number=? "); //, item_image=?
                pps6.setString(1, txt_Item_number.getText().trim());
                pps6.setString(2, txt_Item_Name.getText().trim());
                pps6.setString(3, txt_Item_Description.getText().trim());
                pps6.setString(4, txt_Item_Mode.getText().trim());
                pps6.setString(5, txt_Serial_number.getText().trim());
                pps6.setString(6, txt_Purchase.getText().trim());
               
                if( order_view.isShowing()){
                  order_Date = order_view.getText().trim();
                }else if (last_date_order.isShowing()){
                 order_Date= ((JTextField) last_date_order.getDateEditor().getUiComponent()).getText();
                }
                
                  if( warrant_view.isShowing()){
                  warrant_Date = warrant_view.getText().trim();
                }else if (last_date_order.isShowing()){
                 warrant_Date = ((JTextField) warranty_expiry.getDateEditor().getUiComponent()).getText();
                }
                  
                pps6.setString(7, order_Date);
                pps6.setString(8, txt_Item_Condition.getText().trim());
                pps6.setString(9, warrant_Date);
                pps6.setString(10, txt_Item_number.getText());
             //   pps6.setBlob(11, inputSteam);

                pps6.executeUpdate();
                JOptionPane.showMessageDialog(null, "Updated");
                showContent_OnMain_table();
                
                txt_Item_number.setText(null);
                txt_Item_Name.setText(null);
                txt_Item_Description.setText(null);
                txt_Item_Mode.getText();
                txt_Serial_number.setText(null);
                txt_Purchase.setText(null);
                txt_Item_Condition.setText(null);
                last_date_order.setDate(null);
                warranty_expiry.setDate(null);
                Combo_Category.setSelectedIndex(0);
                ComboItem_type.setSelectedIndex(0);
                txt_Item_Mode.setText(null);
                img_url.setText(null);
                img_holder.setText(null);
                } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_btn_item_submit2ActionPerformed

    private void jLabel58MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel58MouseClicked
         if (table_clicked.equals("none")) {
            JOptionPane.showMessageDialog(null, "Select the Item you wish to assign a user");
            } else if (!table_clicked.equals("none")) {
            Item_Designate me = new Item_Designate();
            BasicInternalFrameUI bi = (BasicInternalFrameUI)me.getUI();//removing the  JInternal_frame title Bar
            bi.setNorthPane(null);  //remove header
            me.setLocation(142, 24);//location

            me.setItem_number(table_clicked); //getting the containt obtaint from the table and passing it onto another frame
            me.printItem_number(); //print method
            desktop_panel.add(me).setVisible(true); //adding it on the desktop frame
        }
        
       
    }//GEN-LAST:event_jLabel58MouseClicked
    

    private void warranty_expiryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_warranty_expiryMouseClicked
        
    }//GEN-LAST:event_warranty_expiryMouseClicked

    private void warrant_viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_warrant_viewMouseClicked
        warranty_expiry.setVisible(true);
        warrant_view.hide();
    }//GEN-LAST:event_warrant_viewMouseClicked

    private void order_viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_order_viewMouseClicked
         last_date_order.setVisible(true);
       order_view.hide();
    }//GEN-LAST:event_order_viewMouseClicked

    private void jLabel59MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel59MouseClicked
         ID_Generation me = new ID_Generation();
         BasicInternalFrameUI bi = (BasicInternalFrameUI)me.getUI();//removing the  JInternal_frame title Bar
         bi.setNorthPane(null);
         me.setLocation(144, 24);
         desktop_panel.add(me).setVisible(true); //adding it on the desktop frame
    }//GEN-LAST:event_jLabel59MouseClicked

    private void jLabel63MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel63MouseClicked
         View_Items_assigned_ToClasses me = new View_Items_assigned_ToClasses();
         BasicInternalFrameUI bi = (BasicInternalFrameUI)me.getUI();//removing the  JInternal_frame title Bar
         bi.setNorthPane(null);
         me.setLocation(144, 24);
         desktop_panel.add(me).setVisible(true); //adding it on the desktop frame
    }//GEN-LAST:event_jLabel63MouseClicked

    private void export_toExcelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_export_toExcelMouseClicked
    // exporting to excel
             try {// converting the IDs
                    conn = DBConnection.getConnction();
                    String sql = "  SELECT  item_number, category_name,type_name , item_name,item_description,model,serial_number,date_oflast_order,cost_per_item,conditions, "
                            + "warranty_ex_date, item_details.problem ,item_details.solution,item_details.cost FROM  inventory_items  INNER JOIN    inventory_joint  ON "
                            + " inventory_items.item_id = inventory_joint.item_id INNER JOIN inventory_category ON  inventory_category.category_id = inventory_joint.category_id INNER JOIN "
                            + "inventory_type ON inventory_type.item_type_id = inventory_joint.item_type_id    LEFT JOIN item_details  ON item_details.details_id =  inventory_joint.details_id";
                    PreparedStatement pps = conn.prepareStatement(sql);
                    ResultSet resultset = pps.executeQuery();
                    
                    
                    try {
                        
                        JFileChooser chooser = new JFileChooser();
                        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);  
                        chooser.showSaveDialog(null);
                        String path = chooser.getSelectedFile().getAbsolutePath();
                        writeToExcel(resultset, path +".xlsx" );
                        JOptionPane.showMessageDialog(null, "Excel Created");   //C:\Users\USER\Desktop\inventory
                      
                       } catch (IOException ex) {
                       Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
                      }
            
           } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}  
    }//GEN-LAST:event_export_toExcelMouseClicked

    private void txt_searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyPressed
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
         
         }

    }//GEN-LAST:event_txt_searchKeyPressed

    private void txt_searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyTyped
   // converting the IDs     // pps8 = conn.prepareStatement("SELECT * FROM  inventory_items  WHERE item_name  like '%" + txt_search.getText() + "%'  ");    
                
                  try {
                    conn = DBConnection.getConnction();
                    String  sql = " SELECT  item_number, category_name,type_name , item_name,item_description,model,serial_number,date_oflast_order,cost_per_item,conditions, warranty_ex_date FROM  inventory_items  INNER JOIN    inventory_joint  ON  inventory_items.item_id = inventory_joint.item_id\n"
                    + "INNER JOIN inventory_category ON  inventory_category.category_id = inventory_joint.category_id INNER JOIN inventory_type ON \n"
                    + "inventory_type.item_type_id = inventory_joint.item_type_id   WHERE item_name  like '%" + txt_search.getText() + "%'  OR item_number  like '%" + txt_search.getText() + "%'   OR  conditions  like '%" + txt_search.getText() + "%'   OR  category_name  like '%" + txt_search.getText() + "%' "
                    + "  OR  cost_per_item  like '%" + txt_search.getText() + "%'  OR  type_name  like '%" + txt_search.getText() + "%'   OR item_description  like '%" + txt_search.getText() + "%'   "; 
                    pps8 = conn.prepareStatement(sql);
                    rs8 = pps8.executeQuery();
                    Main_list_View.setModel(DbUtils.resultSetToTableModel(rs8));
                 } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
            
    }//GEN-LAST:event_txt_searchKeyTyped

    private void txt_Category_SearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Category_SearchKeyTyped
           try {
                conn = DBConnection.getConnction();
                String sql = " SELECT category_name,category_number,category_description FROM inventory_category    WHERE category_name  like '%" + txt_Category_Search.getText() + "%'  OR category_number  like '%" + txt_Category_Search.getText() + "%'   OR  category_description  like '%" + txt_Category_Search.getText() + "%'   ";
                pps4 = conn.prepareStatement(sql);
                rs4 = pps4.executeQuery();
                category_tb.setModel(DbUtils.resultSetToTableModel(rs4));
              } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
                
    }//GEN-LAST:event_txt_Category_SearchKeyTyped

    private void txt_Search_typeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Search_typeKeyPressed
        try {
            conn = DBConnection.getConnction();
            String sql = " SELECT type_name,type_number,type_description FROM inventory_type   WHERE type_name  like '%" + txt_Search_type.getText() + "%'  OR type_number  like '%" + txt_Search_type.getText() + "%'   OR  type_description  like '%" + txt_Search_type.getText() + "%'  ";
            pps6 = conn.prepareStatement(sql);
            rs6 = pps6.executeQuery();
            SockType_tb.setModel(DbUtils.resultSetToTableModel(rs6));
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
        
    }//GEN-LAST:event_txt_Search_typeKeyPressed

    private void txt_search_requestKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_search_requestKeyPressed
                       
               
     try {
            conn = DBConnection.getConnction();
            String sql = " SELECT request_number,item_name,item_description,cost_per_item,conditions,warranty_ex_date,category  FROM request WHERE request_number  like '%" + txt_search_request.getText() + "%'  OR item_name  like '%" + txt_search_request.getText() + "%'   OR  item_description  like '%" + txt_search_request.getText() + "%'";
            pps12 = conn.prepareStatement(sql);//
            rs12 = pps12.executeQuery();
            request_list.setModel(DbUtils.resultSetToTableModel(rs12));
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}           
               
    }//GEN-LAST:event_txt_search_requestKeyPressed

    private void jLabel46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseClicked
       
       JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setFileHidingEnabled(false);
        if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
           java.io.File excelFilePath = chooser.getSelectedFile();
   
        
          
        // String excelFilePath = "Students.xlsx";
 
        int batchSize = 20;
 
       // Connection connection = null;
      //  conn = DBConnection.getConnction();

        try {
            long start = System.currentTimeMillis();
             
            FileInputStream inputStream = new FileInputStream(excelFilePath);
 
            Workbook workbook = new XSSFWorkbook(inputStream);
 
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = firstSheet.iterator();
 
             conn = DBConnection.getConnction();
             conn.setAutoCommit(false);
  
            String sql = "INSERT INTO item_details (Item_id, problem, solution,cost) VALUES (?, ?, ?,? )";
            PreparedStatement statement = conn.prepareStatement(sql);    
             
            int count = 0;
             
            rowIterator.next(); // skip the header row
             
            while (rowIterator.hasNext()) {
                Row nextRow = rowIterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
 
                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();
 
                    int columnIndex = nextCell.getColumnIndex();
 
                    switch (columnIndex) {
                    case 0:
                        String name = nextCell.getStringCellValue();
                        statement.setString(1, name);
                        break;
                    case 1:
                        Date enrollDate = nextCell.getDateCellValue();
                        statement.setTimestamp(2, new Timestamp(enrollDate.getTime()));
                    case 2:
                        int progress = (int) nextCell.getNumericCellValue();
                        statement.setInt(3, progress);
                    }
 
                }
                 
                statement.addBatch();
                 
                if (count % batchSize == 0) {
                    statement.executeBatch();
                }              
 
            }
 
            workbook.close();
             
            // execute the remaining queries
            statement.executeBatch();
  
            conn.commit();
            conn.close();
             
            long end = System.currentTimeMillis();
            System.out.printf("Import done in %d ms\n", (end - start));
             
        } catch (IOException ex1) {
            System.out.println("Error reading file");
            ex1.printStackTrace();
        } catch (SQLException ex2) {
            System.out.println("Database error");
            ex2.printStackTrace();
        } 
        }
        
    }//GEN-LAST:event_jLabel46MouseClicked

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
         int x=evt.getXOnScreen();
         int y=evt.getYOnScreen();
         this.setLocation(x-xx, y-yy);
    }//GEN-LAST:event_jLabel1MouseDragged

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
         xx = evt.getX();
         yy = evt.getY();
    }//GEN-LAST:event_jLabel1MousePressed

    
    public void searchMain_table(){
             
        
        
    }
    
    
    
    
    private static void writeToExcel(ResultSet resultset, String FileName ) throws SQLException,IOException {
       ResultSetMetaData rsmd = resultset.getMetaData();
       List<String> columns = new ArrayList<String>(){{
           for(int i = 1; i <= rsmd.getColumnCount(); i++){
                add(rsmd.getColumnLabel(i));
           }
       }};
    
       
      
     
     try(Workbook book = new XSSFWorkbook()){
       Sheet sheet = book.createSheet();
       Row header = sheet.createRow(0);
       
       for(int i =0 ; i < columns.size(); i++){
       header.createCell(i).setCellValue(columns.get(i));
       }
       
       int RowIndex = 0;
       while(resultset.next()){
       Row row =sheet.createRow(++RowIndex);
      for(int i = 0; i <columns.size(); i++){
           row.createCell(i).setCellValue(Objects.toString(resultset.getObject(columns.get(i)), ""));
      }
       
       }
         try(FileOutputStream fos = new FileOutputStream(FileName, true)){
         book.write(fos);
         }
       
     }
    
       
       
    
    }
    
   
    
    public void updateItem_Details() {
             try {// converting the IDs
            int ConvertedDetails_Item_id = Integer.parseInt(Detail_Item_id);
            conn = DBConnection.getConnction();
            pps8 = conn.prepareStatement("UPDATE  item_details SET  solution =? ,cost =? WHERE Item_id =? ");
            pps8.setString(1, P_Text.getText());  
            pps8.setString(2, txt_forCost_ofRepair.getText());
            pps8.setInt(3, ConvertedDetails_Item_id);
            pps8.executeUpdate();
            JOptionPane.showMessageDialog(null, "Solution & Cost Are now listed");

            P_Text.setText(null);
            txt_forCost_ofRepair .setText(null);
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

    }

    public void inserting_order() {
        String WdateSelected1 = ((JTextField) warranty_expiry1.getDateEditor().getUiComponent()).getText();//conveting date to string then putting it on a resource
        try {
            String status = "unProcessed";

            conn = DBConnection.getConnction();
            pps9 = conn.prepareStatement("INSERT INTO request(request_number, item_name,item_description,cost_per_item,conditions,warranty_ex_date,category,type, order_process) VALUES (?,?,?,?,?,?,?,?,?) ");
            pps9.setString(1, txt_Item_number1.getText().trim());
            pps9.setString(2, txt_Item_Name1.getText().trim());
            pps9.setString(3, txt_Item_Description1.getText().trim());
            pps9.setString(4, txt_Purchase1.getText().trim());
            pps9.setString(5, txt_Item_Condition1.getText().trim());
            pps9.setString(6, WdateSelected1.trim());
            pps9.setString(7, Combo_Category_forRequest.getSelectedItem().toString().trim());
            pps9.setString(8, ComboItem_typeForRequest.getSelectedItem().toString().trim());
            pps9.setString(9, status.trim());

            pps9.executeUpdate();
            JOptionPane.showMessageDialog(null, " Order Made");
            TableContent();
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertingITEMS() {
        InputStream inputSteam = null;
        String dir = img_url.getText();

        try {
            inputSteam = new FileInputStream(new File(dir));
        } catch (FileNotFoundException ex) {Logger.getLogger(Adminstrative.class.getName()).log(Level.SEVERE, null, ex);}

            String LdateSelected = ((JTextField) last_date_order.getDateEditor().getUiComponent()).getText();//conveting date to string then putting it on a resource
            String WdateSelected1 = ((JTextField) warranty_expiry.getDateEditor().getUiComponent()).getText();//conveting date to string then putting it on a resource
        try {
            conn = DBConnection.getConnction();
            pps9 = conn.prepareStatement("INSERT INTO inventory_items(item_number, item_name,item_description,model,serial_number,date_oflast_order,cost_per_item,conditions,warranty_ex_date,item_image) VALUES (?,?,?,?,?,?,?,?,?,?) ");  //,item_image
            pps9.setString(1, txt_Item_number.getText().trim());
            pps9.setString(2, txt_Item_Name.getText().trim());
            pps9.setString(3, txt_Item_Description.getText().trim());
            pps9.setString(4, txt_Item_Mode.getText().trim());
            pps9.setString(5, txt_Serial_number.getText().trim());
            pps9.setString(6, LdateSelected.trim());
            pps9.setString(7, txt_Purchase.getText().trim());
            pps9.setString(8, txt_Item_Condition.getText().trim());
            pps9.setString(9, WdateSelected1.trim());
            pps9.setBlob(10, inputSteam);
            pps9.executeUpdate();
            JOptionPane.showMessageDialog(null, "Item Recorded");
            inserting_items_joint();       //insert into joint table

        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
    }

    public void inserting_items_joint() {
        // ITEM ID
       try {
            conn = DBConnection.getConnction();
            pps6 = conn.prepareStatement("SELECT * FROM inventory_items WHERE (item_number=? OR item_name = ?)  AND (model = ? AND serial_number=?)");
            pps6.setString(1, txt_Item_number.getText().trim());
            pps6.setString(2, txt_Item_Name.getText().trim());
            pps6.setString(3, txt_Item_Mode.getText().trim());
            pps6.setString(4, txt_Serial_number.getText().trim());
            rs6 = pps6.executeQuery();
            if (rs6.next()) {
                getItem_id = rs6.getString("item_id");
              }
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

        try {  ///GETTING CATEGORY ID
            String cate =  Combo_Category.getSelectedItem().toString();
            
            conn = DBConnection.getConnction();
            pps3 = conn.prepareStatement("SELECT * FROM inventory_category WHERE category_name =?");
            pps3.setString(1, cate);

            rs3 = pps3.executeQuery();
            if (rs3.next()) {
                getCategory_id = rs3.getString("category_id");
                JOptionPane.showMessageDialog(null, getCategory_id);
            }
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

        
        
            try { //GETTING CATEGORY TYPE ID
            conn = DBConnection.getConnction();
            String type  =  ComboItem_type.getSelectedItem().toString().trim();
            
            pps13 = conn.prepareStatement("SELECT * FROM inventory_type  WHERE type_name =?");
            pps13.setString(1, type);
            rs13 = pps13.executeQuery();
            while (rs13.next()) {
                getItem_Type_id = rs13.getString("item_type_id");
            }

        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

      try {// converting the IDs
            int Convert_category_id = Integer.parseInt(getCategory_id);
            int Convert_itemType_id = Integer.parseInt(getItem_Type_id);
            int Convert_Item_id = Integer.parseInt(getItem_id);
            conn = DBConnection.getConnction();
            pps7 = conn.prepareStatement("INSERT INTO inventory_joint(category_id, item_type_id,Item_id) VALUES (?,?,?) ");// AND contact = ?
            pps7.setInt(1, Convert_category_id);
            pps7.setInt(2, Convert_itemType_id);
            pps7.setInt(3, Convert_Item_id);

            pps7.executeUpdate();
            showContent_OnMain_table();    // call the show function

            txt_Item_number.setText(null);
            txt_Item_Name.setText(null);
            txt_Item_Description.setText(null);
            txt_Item_Mode.getText();
            txt_Serial_number.setText(null);
            txt_Purchase.setText(null);
            txt_Item_Condition.setText(null);
            last_date_order.setDate(null);
            warranty_expiry.setDate(null);
            Combo_Category.setSelectedIndex(0);
            ComboItem_type.setSelectedIndex(0);
            txt_Item_Mode.setText(null);
            img_url.setText(null);
            img_holder.setText(null);
            
            btn_item_submit.setText("Commit");
            txt_Item_Name.enable(true);
            txt_Item_Description.enable(true);
            txt_Item_Condition.enable(true);
            warranty_expiry.enable(true);
                    
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    
    public static Inventory getObj() {  //public method for instance Restriction
        if (Obj == null) {
            Obj = new Inventory();
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
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventory().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Add_price2;
    private javax.swing.JLabel Add_price3;
    private javax.swing.JLabel Add_price4;
    private javax.swing.JLabel Add_price5;
    private javax.swing.JPanel Category_entry1;
    private javax.swing.JPanel Category_list;
    private javax.swing.JComboBox ComboItem_type;
    private javax.swing.JComboBox ComboItem_typeForRequest;
    private javax.swing.JComboBox Combo_Category;
    private javax.swing.JComboBox Combo_Category_forRequest;
    private javax.swing.JLabel Delecte13;
    private javax.swing.JLabel Delecte14;
    private javax.swing.JLabel Delecte15;
    private javax.swing.JLabel Delecte16;
    private javax.swing.JButton Delete_item;
    private javax.swing.JPanel Item_Category_Table;
    private javax.swing.JTable Main_list_View;
    private javax.swing.JButton P_Save;
    private javax.swing.JTextArea P_Text;
    private javax.swing.JLabel P_Title;
    private javax.swing.JButton P_Update;
    private javax.swing.JPanel Purchases;
    private javax.swing.JTable Purchases_list;
    private javax.swing.JButton Savebtn;
    private javax.swing.JButton Savebtn1;
    private javax.swing.JPanel Side_bar;
    private javax.swing.JTable SockType_tb;
    private javax.swing.JPanel Top_Header;
    private javax.swing.JPanel Type_entry;
    private javax.swing.JPanel Type_list;
    private javax.swing.JTextArea Typedescription;
    private javax.swing.JLabel add_floor;
    private javax.swing.JLabel add_floor1;
    private javax.swing.JLabel add_floor2;
    private javax.swing.JPanel btn10;
    private javax.swing.JPanel btn11;
    private javax.swing.JPanel btn12;
    private javax.swing.JPanel btn14;
    private javax.swing.JPanel btn15;
    private javax.swing.JPanel btn16;
    private javax.swing.JPanel btn17;
    private javax.swing.JPanel btn9;
    private javax.swing.JPanel btn_FirstView1;
    private javax.swing.JPanel btn_FirstView2;
    private javax.swing.JPanel btn_FirstView3;
    private javax.swing.JPanel btn_FirstView4;
    private javax.swing.JPanel btn_container1;
    private javax.swing.JPanel btn_container2;
    private javax.swing.JPanel btn_container3;
    private javax.swing.JPanel btn_container4;
    private javax.swing.JButton btn_entry;
    private javax.swing.JButton btn_item_submit;
    private javax.swing.JButton btn_item_submit1;
    private javax.swing.JButton btn_item_submit2;
    private javax.swing.JPanel btn_secondView1;
    private javax.swing.JPanel btn_secondView2;
    private javax.swing.JPanel btn_secondView3;
    private javax.swing.JPanel btn_secondView4;
    private javax.swing.JTextArea cate_description;
    private javax.swing.JTextField cate_name;
    private javax.swing.JTextField cate_number;
    private javax.swing.JTable category_tb;
    private javax.swing.JPanel data_entry;
    private javax.swing.JDesktopPane desktop_panel;
    private javax.swing.JButton edit;
    private javax.swing.JLabel edit13;
    private javax.swing.JLabel edit14;
    private javax.swing.JLabel edit15;
    private javax.swing.JLabel export_toExcel;
    private javax.swing.JLabel gb;
    private javax.swing.JLabel gb1;
    private javax.swing.JPanel home_table;
    private javax.swing.JButton image_chooser;
    private javax.swing.JLabel img_holder;
    private javax.swing.JPanel img_pane;
    private javax.swing.JTextField img_url;
    private javax.swing.JPanel item_Problem_Solution;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel196;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel198;
    private javax.swing.JLabel jLabel199;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel200;
    private javax.swing.JLabel jLabel201;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel204;
    private javax.swing.JLabel jLabel205;
    private javax.swing.JLabel jLabel206;
    private javax.swing.JLabel jLabel207;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel214;
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
    private javax.swing.JLabel jLabel225;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JPanel landing_Panel;
    private com.toedter.calendar.JDateChooser last_date_order;
    private javax.swing.JLabel lb_bg_btnFirstView1;
    private javax.swing.JLabel lb_bg_btnFirstView2;
    private javax.swing.JLabel lb_bg_btnFirstView3;
    private javax.swing.JLabel lb_bg_btnFirstView4;
    private javax.swing.JLabel lb_bg_btnSecondView1;
    private javax.swing.JLabel lb_bg_btnSecondView2;
    private javax.swing.JLabel lb_bg_btnSecondView3;
    private javax.swing.JLabel lb_bg_btnSecondView4;
    private javax.swing.JLabel lb_forCost_ofRepair;
    private javax.swing.JLabel lb_gb_table;
    private javax.swing.JPanel main_structure;
    private javax.swing.JLabel model;
    private javax.swing.JTextField order_view;
    private javax.swing.JPanel request;
    private javax.swing.JTable request_list;
    private javax.swing.JPanel request_table;
    private javax.swing.JComboBox showCategories;
    private javax.swing.JPanel side1;
    private javax.swing.JPanel side2;
    private javax.swing.JPanel side3;
    private javax.swing.JPanel table_header;
    private javax.swing.JPanel table_header1;
    private javax.swing.JPanel table_header2;
    private javax.swing.JPanel table_header3;
    private javax.swing.JLabel table_holder_bg11;
    private javax.swing.JLabel table_holder_bg12;
    private javax.swing.JLabel table_holder_bg13;
    private javax.swing.JLabel table_holder_bg14;
    private javax.swing.JPanel table_layer;
    private javax.swing.JPanel table_table;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txt_Category_Search;
    private javax.swing.JTextField txt_Item_Condition;
    private javax.swing.JTextField txt_Item_Condition1;
    private javax.swing.JTextField txt_Item_Description;
    private javax.swing.JTextField txt_Item_Description1;
    private javax.swing.JTextField txt_Item_Mode;
    private javax.swing.JTextField txt_Item_Mode1;
    private javax.swing.JTextField txt_Item_Name;
    private javax.swing.JTextField txt_Item_Name1;
    private javax.swing.JTextField txt_Item_number;
    private javax.swing.JTextField txt_Item_number1;
    private javax.swing.JTextField txt_Purchase;
    private javax.swing.JTextField txt_Purchase1;
    private javax.swing.JTextField txt_Search_type;
    private javax.swing.JTextField txt_Serial_number;
    private javax.swing.JTextField txt_forCost_ofRepair;
    private javax.swing.JTextArea txt_problem;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_search_request;
    private javax.swing.JTextField typename;
    private javax.swing.JTextField typenumber;
    private javax.swing.JButton update_Category_Entry;
    private javax.swing.JButton update_structureEntry;
    private javax.swing.JTextField warrant_view;
    private com.toedter.calendar.JDateChooser warranty_expiry;
    private com.toedter.calendar.JDateChooser warranty_expiry1;
    // End of variables declaration//GEN-END:variables
}
