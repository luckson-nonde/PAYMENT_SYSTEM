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

public class Teacher_Inventory extends javax.swing.JFrame {

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
    private static Teacher_Inventory Obj = null;
    private String passed_user_id;
       
    
            int xx = 0;
            int yy = 0;
    
     Teacher_Inventory() {
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));

        showContent_OnMain_table();
        TableContent();
        //hide update btn
        
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


    public void TableContent() {
      
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
        jLabel32 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Main_list_View = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        showCategories = new javax.swing.JComboBox();
        Item_Category_Table = new javax.swing.JPanel();
        main_structure = new javax.swing.JPanel();
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
        Side_bar = new javax.swing.JPanel();
        side1 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        export_toExcel = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
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

        jLabel32.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(224, 224, 224));
        jLabel32.setText("Stock List");
        jLabel32.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table_table.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 90, 50));

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
        side1.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 120, 80));

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
        side1.add(export_toExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 130, 70));

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(204, 204, 204));
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_export_pdf_35px.png"))); // NOI18N
        jLabel57.setText("EXPORT PDF");
        side1.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 120, 70));

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
        landing_Panel.add(lb_gb_table, new org.netbeans.lib.awtextra.AbsoluteConstraints(-90, 10, 1460, 1050));

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

        Top_Header.add(btn10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 100, 40));

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
        jLabel23.setText(" Request From  Stock");
        jLabel23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn11.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 160, 40));

        Top_Header.add(btn11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 220, 40));

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
        jLabel39.setText("In Stock");
        jLabel39.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn15.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 40));

        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        btn15.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 30, 60));

        Top_Header.add(btn15, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 140, 40));

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
        jLabel22.setText("New Purchases");
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn17.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 110, 40));

        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        btn17.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 30, 60));

        Top_Header.add(btn17, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 150, 40));

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn16MouseClicked
      

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
        data_entry.setVisible(true);
        
    }//GEN-LAST:event_btn17MouseClicked

    private void btn17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn17MouseEntered
        btn17.setBackground(new Color(33, 173, 178));
    }//GEN-LAST:event_btn17MouseEntered

    private void btn17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn17MouseExited
        btn17.setBackground(new Color(115, 115, 115));
    }//GEN-LAST:event_btn17MouseExited

  
    
    private void btn10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn10MouseEntered
        btn10.setBackground(new Color(33, 173, 178));

    }//GEN-LAST:event_btn10MouseEntered

    private void btn10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn10MouseExited
        btn10.setBackground(new Color(115, 115, 115));

    }//GEN-LAST:event_btn10MouseExited

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
      
        Item_Category_Table.hide();
        home_table.hide();
        data_entry.setVisible(true);
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        data_entry.hide();
        home_table.hide();
       
        Item_Category_Table.setVisible(true);

        
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked

        data_entry.hide();
        home_table.hide();
        Item_Category_Table.setVisible(true);

      
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        // TODO add your handling code here:
        this.setExtendedState(Teacher_Inventory.ICONIFIED);

    }//GEN-LAST:event_jLabel19MouseClicked

    private void Main_list_ViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Main_list_ViewMouseClicked
        DefaultTableModel tableMode_type = (DefaultTableModel) Main_list_View.getModel();
        table_clicked = tableMode_type.getValueAt(Main_list_View.getSelectedRow(), 0).toString();
    }//GEN-LAST:event_Main_list_ViewMouseClicked

    private void btn10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn10MouseClicked
if(!home_table.isShowing()){
        Item_Category_Table.hide();
        data_entry.hide();

        side3.hide();
        side2.hide();
        side1.setVisible(true);
        home_table.setVisible(true);
}else{

              Teacher_Home_Page.getObj().setVisible(true);
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

                 //   Typedescription.setText(rs11.getString("warranty_ex_date"));
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
                } else {
                    JOptionPane.showMessageDialog(null, "Item Type found, Select and Press Edit");
                    
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
                       Logger.getLogger(Teacher_Inventory.class.getName()).log(Level.SEVERE, null, ex);
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

    private void order_viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_order_viewMouseClicked
        last_date_order.setVisible(true);
        order_view.hide();
    }//GEN-LAST:event_order_viewMouseClicked

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

    private void warranty_expiryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_warranty_expiryMouseClicked

    }//GEN-LAST:event_warranty_expiryMouseClicked

    private void warrant_viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_warrant_viewMouseClicked
        warranty_expiry.setVisible(true);
        warrant_view.hide();
    }//GEN-LAST:event_warrant_viewMouseClicked

    
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
            inserting_items_joint();       

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

    
    
    public static Teacher_Inventory getObj() {  //public method for instance Restriction
        if (Obj == null) {
            Obj = new Teacher_Inventory();
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
            java.util.logging.Logger.getLogger(Teacher_Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Teacher_Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Teacher_Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Teacher_Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Teacher_Inventory().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Add_price4;
    private javax.swing.JLabel Add_price5;
    private javax.swing.JComboBox ComboItem_type;
    private javax.swing.JComboBox Combo_Category;
    private javax.swing.JLabel Delecte15;
    private javax.swing.JLabel Delecte16;
    private javax.swing.JPanel Item_Category_Table;
    private javax.swing.JTable Main_list_View;
    private javax.swing.JPanel Purchases;
    private javax.swing.JTable Purchases_list;
    private javax.swing.JPanel Side_bar;
    private javax.swing.JPanel Top_Header;
    private javax.swing.JLabel add_floor2;
    private javax.swing.JPanel btn10;
    private javax.swing.JPanel btn11;
    private javax.swing.JPanel btn15;
    private javax.swing.JPanel btn16;
    private javax.swing.JPanel btn17;
    private javax.swing.JPanel btn9;
    private javax.swing.JPanel btn_FirstView3;
    private javax.swing.JPanel btn_FirstView4;
    private javax.swing.JPanel btn_container3;
    private javax.swing.JPanel btn_container4;
    private javax.swing.JButton btn_item_submit;
    private javax.swing.JButton btn_item_submit2;
    private javax.swing.JPanel btn_secondView3;
    private javax.swing.JPanel btn_secondView4;
    private javax.swing.JPanel data_entry;
    private javax.swing.JDesktopPane desktop_panel;
    private javax.swing.JLabel edit15;
    private javax.swing.JLabel export_toExcel;
    private javax.swing.JPanel home_table;
    private javax.swing.JButton image_chooser;
    private javax.swing.JLabel img_holder;
    private javax.swing.JPanel img_pane;
    private javax.swing.JTextField img_url;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel204;
    private javax.swing.JLabel jLabel205;
    private javax.swing.JLabel jLabel206;
    private javax.swing.JLabel jLabel207;
    private javax.swing.JLabel jLabel21;
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
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JPanel landing_Panel;
    private com.toedter.calendar.JDateChooser last_date_order;
    private javax.swing.JLabel lb_bg_btnFirstView3;
    private javax.swing.JLabel lb_bg_btnFirstView4;
    private javax.swing.JLabel lb_bg_btnSecondView3;
    private javax.swing.JLabel lb_bg_btnSecondView4;
    private javax.swing.JLabel lb_gb_table;
    private javax.swing.JPanel main_structure;
    private javax.swing.JLabel model;
    private javax.swing.JTextField order_view;
    private javax.swing.JTable request_list;
    private javax.swing.JPanel request_table;
    private javax.swing.JComboBox showCategories;
    private javax.swing.JPanel side1;
    private javax.swing.JPanel side2;
    private javax.swing.JPanel side3;
    private javax.swing.JPanel table_header2;
    private javax.swing.JPanel table_header3;
    private javax.swing.JLabel table_holder_bg13;
    private javax.swing.JLabel table_holder_bg14;
    private javax.swing.JPanel table_layer;
    private javax.swing.JPanel table_table;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txt_Item_Condition;
    private javax.swing.JTextField txt_Item_Description;
    private javax.swing.JTextField txt_Item_Mode;
    private javax.swing.JTextField txt_Item_Name;
    private javax.swing.JTextField txt_Item_number;
    private javax.swing.JTextField txt_Purchase;
    private javax.swing.JTextField txt_Serial_number;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_search_request;
    private javax.swing.JTextField warrant_view;
    private com.toedter.calendar.JDateChooser warranty_expiry;
    // End of variables declaration//GEN-END:variables
}
