
package hotel.management;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

public class Item_Designate extends javax.swing.JInternalFrame {

    Connection conn = null;
    PreparedStatement pps, pps1, pps2, pps3, pps4, pps6, pps5, pps7, pps8, pps9, pps10, pps11, pps12 = null;
    ResultSet rs, rs1, rs2, rs3, rs4, rs5, rs6, rs7, rs8, rs9, rs10, rs11, rs12 = null;

    
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
     String   item_id   = null;
     String   user_id  = null;
     String   room_id  = null;
    
    
    private static Item_Designate Obj = null;
    //container variables that holds passed on info
    private String Item_number = null;
   
    
    public Item_Designate() {
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));
        item_location();
        
        ROOM.hide();
        USER.hide();
    }

     //*********************************************************GETTING CURRENT USER ID
    public void setItem_number(String Item_num) {
        Item_number = Item_num;
    }

    public String getItem_number() {
        return Item_number;
    }

    public void printItem_number() {
        getItem_number();//setting the id of the user who logged in and set it to a global variable
        Item_Details();

    }
    
    
    public void Item_Details(){
       try {
                conn = DBConnection.getConnction();
                pps12 = conn.prepareStatement("SELECT * FROM inventory_items WHERE item_number=? ");
                pps12.setString(1, Item_number);
                rs12 = pps12.executeQuery(); 
                byte[] m_Image = null;

                if (rs12.next()) {
                  
                  item_user_relation.setVisible(true);
                    employee_fiter.setVisible(true);
                    
                    t_Item_number.setText(rs12.getString("item_number"));
                    item_name.setText(rs12.getString("item_name"));
                    t_Purchase.setText(rs12.getString("cost_per_item"));
                    t_Item_Condition.setText(rs12.getString("conditions"));
                    t_warranty_ex_date.setText(rs12.getString("warranty_ex_date"));
                    
                    
                     t_Item_number1.setText(rs12.getString("item_number"));
                    item_name1.setText(rs12.getString("item_name"));
                    t_Purchase1.setText(rs12.getString("cost_per_item"));
                    t_Item_Condition1.setText(rs12.getString("conditions"));
                    t_warranty_ex_date1.setText(rs12.getString("warranty_ex_date"));
                    
                    item_id = rs12.getString("Item_id");
   
                     /* */
                    
                    
                      m_Image = rs12.getBytes("item_image");
                     Image img = Toolkit.getDefaultToolkit().createImage(m_Image);
                     ImageIcon icon = new ImageIcon(img);

                    // Image modifiedImaged = img.getScaledInstance(200,200 Image.SCALE_SMOOTH);  //img_panel.getWidth(), img_panel.getHeight(),
                   //  icon = new ImageIcon(modifiedImaged);

                     lb_Img.setIcon(icon);  
                    
                }

            } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
    
    
    }
    
    
    
    
    
      public void item_location(){
    
        try {
      
        conn = DBConnection.getConnction();
          String sql = " SELECT room_number,room_type,room_status,room_capacity FROM rooms";
         pps = conn.prepareStatement(sql);
         rs = pps.executeQuery();
         User_table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

        try {
         conn = DBConnection.getConnction();
         String sql = " SELECT name,surname,department,designation FROM employee";
          pps2 = conn.prepareStatement(sql);
          rs2 = pps2.executeQuery();
          User_table1.setModel(DbUtils.resultSetToTableModel(rs2));

         } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
      
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        item_user_relation = new javax.swing.JPanel();
        user = new javax.swing.JPanel();
        img_panel = new javax.swing.JPanel();
        lb_Img = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        Item_Chooser = new javax.swing.JPanel();
        Item_Option = new javax.swing.JPanel();
        btnOffice = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnUser = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel238 = new javax.swing.JLabel();
        jLabel248 = new javax.swing.JLabel();
        Item_To_Room = new javax.swing.JPanel();
        jScrollPane29 = new javax.swing.JScrollPane();
        User_table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel39 = new javax.swing.JPanel();
        jLabel229 = new javax.swing.JLabel();
        jLabel231 = new javax.swing.JLabel();
        jLabel232 = new javax.swing.JLabel();
        jLabel233 = new javax.swing.JLabel();
        jLabel250 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        employee_fiter = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel73 = new javax.swing.JLabel();
        txt_Search_rooms = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Item_To_User = new javax.swing.JPanel();
        jScrollPane30 = new javax.swing.JScrollPane();
        User_table1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel40 = new javax.swing.JPanel();
        jLabel244 = new javax.swing.JLabel();
        jLabel245 = new javax.swing.JLabel();
        jLabel246 = new javax.swing.JLabel();
        jLabel247 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel74 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lb_search = new javax.swing.JLabel();
        txt_Search_employee = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        employee_fiter1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        t_Item_number = new javax.swing.JLabel();
        t_Purchase = new javax.swing.JLabel();
        t_Item_Condition = new javax.swing.JLabel();
        t_warranty_ex_date = new javax.swing.JLabel();
        jLabel249 = new javax.swing.JLabel();
        jLabel235 = new javax.swing.JLabel();
        jLabel237 = new javax.swing.JLabel();
        jLabel236 = new javax.swing.JLabel();
        jLabel230 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        item_name = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel234 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        Assign = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        title_user1 = new javax.swing.JLabel();
        t_warranty_ex_date1 = new javax.swing.JLabel();
        jLabel239 = new javax.swing.JLabel();
        t_Item_Condition1 = new javax.swing.JLabel();
        jLabel240 = new javax.swing.JLabel();
        t_Purchase1 = new javax.swing.JLabel();
        jLabel241 = new javax.swing.JLabel();
        t_Item_number1 = new javax.swing.JLabel();
        item_name1 = new javax.swing.JLabel();
        jLabel242 = new javax.swing.JLabel();
        jLabel243 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        user_name = new javax.swing.JLabel();
        user_surname = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        lb_lname_capacity = new javax.swing.JLabel();
        Department_name = new javax.swing.JLabel();
        designation = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel72 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        USER = new javax.swing.JButton();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        fiter_assets = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel67 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        ROOM = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(1213, 604));
        setMinimumSize(new java.awt.Dimension(1213, 604));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1213, 604));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new java.awt.CardLayout());

        item_user_relation.setBackground(new Color(102,102,102,90));
        item_user_relation.setMaximumSize(new java.awt.Dimension(1170, 680));
        item_user_relation.setMinimumSize(new java.awt.Dimension(1170, 680));
        item_user_relation.setPreferredSize(new java.awt.Dimension(1170, 680));
        item_user_relation.setLayout(new java.awt.CardLayout());

        user.setBackground(new java.awt.Color(204, 204, 204));
        user.setMinimumSize(new java.awt.Dimension(1270, 680));
        user.setName(""); // NOI18N
        user.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        img_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        img_panel.add(lb_Img, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 100));

        user.add(img_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 120, 100));
        user.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 240, 60));
        user.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 240, 60));

        Item_Chooser.setBackground(new java.awt.Color(255, 255, 255));
        Item_Chooser.setLayout(new java.awt.CardLayout());

        Item_Option.setBackground(new java.awt.Color(255, 255, 255));
        Item_Option.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnOffice.setBackground(new java.awt.Color(255, 255, 255));
        btnOffice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOfficeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnOfficeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnOfficeMouseExited(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Google_Tag_Manager_75px.png"))); // NOI18N

        javax.swing.GroupLayout btnOfficeLayout = new javax.swing.GroupLayout(btnOffice);
        btnOffice.setLayout(btnOfficeLayout);
        btnOfficeLayout.setHorizontalGroup(
            btnOfficeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnOfficeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnOfficeLayout.setVerticalGroup(
            btnOfficeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );

        Item_Option.add(btnOffice, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 180, 110));

        btnUser.setBackground(new java.awt.Color(255, 255, 255));
        btnUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUserMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUserMouseExited(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_manager_75px.png"))); // NOI18N

        javax.swing.GroupLayout btnUserLayout = new javax.swing.GroupLayout(btnUser);
        btnUser.setLayout(btnUserLayout);
        btnUserLayout.setHorizontalGroup(
            btnUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnUserLayout.setVerticalGroup(
            btnUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
        );

        Item_Option.add(btnUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 180, 110));

        jLabel238.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel238.setForeground(new java.awt.Color(153, 153, 153));
        jLabel238.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel238.setText("Assign To Rooms");
        Item_Option.add(jLabel238, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 150, 40));

        jLabel248.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel248.setForeground(new java.awt.Color(153, 153, 153));
        jLabel248.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel248.setText("Assign To Individuals");
        Item_Option.add(jLabel248, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 360, 150, 40));

        Item_Chooser.add(Item_Option, "card4");

        Item_To_Room.setBackground(new java.awt.Color(255, 255, 255));
        Item_To_Room.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        User_table.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        User_table.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        User_table.setForeground(new java.awt.Color(102, 102, 102));
        User_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        User_table.setGridColor(new java.awt.Color(255, 255, 255));
        User_table.setIntercellSpacing(new java.awt.Dimension(20, 5));
        User_table.setRowHeight(30);
        User_table.setTableHeader(null);
        User_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                User_tableMouseClicked(evt);
            }
        });
        jScrollPane29.setViewportView(User_table);

        Item_To_Room.add(jScrollPane29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 680, 340));

        jButton1.setBackground(new Color(255,255,255,30));
        jButton1.setText("Contiune");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Item_To_Room.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 500, 90, 30));

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel229.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel229.setForeground(new java.awt.Color(153, 153, 153));
        jLabel229.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel229.setText(" Capacity");
        jPanel39.add(jLabel229, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 100, 50));

        jLabel231.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel231.setForeground(new java.awt.Color(153, 153, 153));
        jLabel231.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel231.setText("Room Name");
        jPanel39.add(jLabel231, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 120, 50));

        jLabel232.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel232.setForeground(new java.awt.Color(153, 153, 153));
        jLabel232.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel232.setText("Room Type");
        jPanel39.add(jLabel232, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 120, 50));

        jLabel233.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel233.setForeground(new java.awt.Color(153, 153, 153));
        jLabel233.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel233.setText("Room Number");
        jPanel39.add(jLabel233, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 130, 30));

        jLabel250.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel250.setForeground(new java.awt.Color(153, 153, 153));
        jLabel250.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel250.setText("Room State");
        jPanel39.add(jLabel250, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 120, 50));

        Item_To_Room.add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 680, 40));

        jLabel78.setText("Fiter Users");
        Item_To_Room.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 160, 30));

        employee_fiter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                employee_fiterKeyReleased(evt);
            }
        });
        Item_To_Room.add(employee_fiter, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 170, 30));
        Item_To_Room.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 240, 40));
        Item_To_Room.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 240, 40));

        jLabel73.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(153, 153, 153));
        jLabel73.setText("Rooms");
        Item_To_Room.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, -10, 130, 50));

        txt_Search_rooms.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_Search_roomsKeyPressed(evt);
            }
        });
        Item_To_Room.add(txt_Search_rooms, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 250, 30));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_faq_30px.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        Item_To_Room.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 90, 40));

        Item_Chooser.add(Item_To_Room, "card3");

        Item_To_User.setBackground(new java.awt.Color(255, 255, 255));
        Item_To_User.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        User_table1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        User_table1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        User_table1.setForeground(new java.awt.Color(102, 102, 102));
        User_table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        User_table1.setGridColor(new java.awt.Color(255, 255, 255));
        User_table1.setIntercellSpacing(new java.awt.Dimension(20, 5));
        User_table1.setRowHeight(30);
        User_table1.setTableHeader(null);
        User_table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                User_table1MouseClicked(evt);
            }
        });
        jScrollPane30.setViewportView(User_table1);

        Item_To_User.add(jScrollPane30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 630, 330));

        jButton2.setBackground(new Color(255,255,255,30));
        jButton2.setText("Contiune");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Item_To_User.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 490, 90, 30));

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel244.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel244.setForeground(new java.awt.Color(153, 153, 153));
        jLabel244.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel244.setText("Designation");
        jPanel40.add(jLabel244, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 100, 50));

        jLabel245.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel245.setForeground(new java.awt.Color(153, 153, 153));
        jLabel245.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel245.setText("Department");
        jPanel40.add(jLabel245, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 120, 50));

        jLabel246.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel246.setForeground(new java.awt.Color(153, 153, 153));
        jLabel246.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel246.setText("Surname");
        jPanel40.add(jLabel246, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 120, 50));

        jLabel247.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel247.setForeground(new java.awt.Color(153, 153, 153));
        jLabel247.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel247.setText("  Name");
        jPanel40.add(jLabel247, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 130, 30));

        Item_To_User.add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 680, 40));
        Item_To_User.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 240, 40));
        Item_To_User.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 240, 40));

        jLabel74.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(153, 153, 153));
        jLabel74.setText("Employees");
        Item_To_User.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 130, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_faq_30px.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        Item_To_User.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 60, 40));

        lb_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_google_web_search_35px.png"))); // NOI18N
        Item_To_User.add(lb_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, -1, 50));

        txt_Search_employee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_Search_employeeKeyPressed(evt);
            }
        });
        Item_To_User.add(txt_Search_employee, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 170, 30));

        jLabel79.setText("Fiter Users");
        Item_To_User.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 490, 160, 30));

        employee_fiter1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                employee_fiter1KeyReleased(evt);
            }
        });
        Item_To_User.add(employee_fiter1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 490, 170, 30));

        Item_Chooser.add(Item_To_User, "card3");

        user.add(Item_Chooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 730, 530));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/ex.png"))); // NOI18N
        jLabel6.setText("  Home");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        user.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 80, 50));

        t_Item_number.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        t_Item_number.setForeground(new java.awt.Color(102, 102, 102));
        t_Item_number.setText("Item Name");
        user.add(t_Item_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 180, 40));

        t_Purchase.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        t_Purchase.setForeground(new java.awt.Color(102, 102, 102));
        t_Purchase.setText("Item Name");
        user.add(t_Purchase, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 180, 40));

        t_Item_Condition.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        t_Item_Condition.setForeground(new java.awt.Color(102, 102, 102));
        t_Item_Condition.setText("Item Name");
        user.add(t_Item_Condition, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 180, 40));

        t_warranty_ex_date.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        t_warranty_ex_date.setForeground(new java.awt.Color(102, 102, 102));
        t_warranty_ex_date.setText("Item Name");
        user.add(t_warranty_ex_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 180, 40));

        jLabel249.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel249.setForeground(new java.awt.Color(153, 153, 153));
        jLabel249.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel249.setText("  Warrant Date Expirly");
        user.add(jLabel249, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 150, 40));

        jLabel235.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel235.setForeground(new java.awt.Color(153, 153, 153));
        jLabel235.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel235.setText("  Item Number");
        user.add(jLabel235, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 150, 40));

        jLabel237.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel237.setForeground(new java.awt.Color(153, 153, 153));
        jLabel237.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel237.setText("  Item Condition");
        user.add(jLabel237, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 150, 40));

        jLabel236.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel236.setForeground(new java.awt.Color(153, 153, 153));
        jLabel236.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel236.setText("  Item Cost");
        user.add(jLabel236, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 150, 40));

        jLabel230.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel230.setForeground(new java.awt.Color(153, 153, 153));
        jLabel230.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel230.setText("  Item Name");
        user.add(jLabel230, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 150, 40));

        jLabel70.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(153, 153, 153));
        jLabel70.setText("Item Details");
        user.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 130, 70));

        item_name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        item_name.setForeground(new java.awt.Color(102, 102, 102));
        item_name.setText("Item Name");
        user.add(item_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 180, 40));

        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/popup.png"))); // NOI18N
        user.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 20, 1300, 630));

        jLabel234.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel234.setForeground(new java.awt.Color(153, 153, 153));
        jLabel234.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel234.setText("  Item Name");
        user.add(jLabel234, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 150, 40));

        jLabel71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_close_window_25px_1.png"))); // NOI18N
        jLabel71.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel71.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel71MouseClicked(evt);
            }
        });
        user.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, -80, 80, 50));

        item_user_relation.add(user, "card2");

        Assign.setBackground(new java.awt.Color(255, 255, 255));
        Assign.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setTableHeader(null);
        jScrollPane7.setViewportView(jTable1);

        Assign.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 180, 260, 410));

        title_user1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        title_user1.setForeground(new java.awt.Color(102, 102, 102));
        title_user1.setText("User");
        Assign.add(title_user1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 90, 30));

        t_warranty_ex_date1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        t_warranty_ex_date1.setForeground(new java.awt.Color(255, 255, 255));
        t_warranty_ex_date1.setText("Item Name");
        Assign.add(t_warranty_ex_date1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 510, 110, 40));

        jLabel239.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel239.setForeground(new java.awt.Color(204, 204, 204));
        jLabel239.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel239.setText("Warrant Ex ");
        Assign.add(jLabel239, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 510, 110, 40));

        t_Item_Condition1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        t_Item_Condition1.setForeground(new java.awt.Color(255, 255, 255));
        t_Item_Condition1.setText("Item Name");
        Assign.add(t_Item_Condition1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 470, 110, 40));

        jLabel240.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel240.setForeground(new java.awt.Color(204, 204, 204));
        jLabel240.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel240.setText("Condition");
        Assign.add(jLabel240, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, 90, 40));

        t_Purchase1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        t_Purchase1.setForeground(new java.awt.Color(255, 255, 255));
        t_Purchase1.setText("Item Name");
        Assign.add(t_Purchase1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, 110, 40));

        jLabel241.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel241.setForeground(new java.awt.Color(204, 204, 204));
        jLabel241.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel241.setText("Cost");
        Assign.add(jLabel241, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 70, 40));

        t_Item_number1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        t_Item_number1.setForeground(new java.awt.Color(255, 255, 255));
        t_Item_number1.setText("Item Name");
        Assign.add(t_Item_number1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 110, 40));

        item_name1.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        item_name1.setForeground(new java.awt.Color(255, 255, 255));
        item_name1.setText("Item Name");
        Assign.add(item_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 110, 40));

        jLabel242.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel242.setForeground(new java.awt.Color(204, 204, 204));
        jLabel242.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel242.setText("Number");
        Assign.add(jLabel242, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 80, 40));

        jLabel243.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel243.setForeground(new java.awt.Color(204, 204, 204));
        jLabel243.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel243.setText("Name");
        Assign.add(jLabel243, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 70, 40));

        jLabel92.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(204, 204, 204));
        jLabel92.setText("Department name");
        Assign.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 420, 120, 50));

        jLabel93.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(204, 204, 204));
        jLabel93.setText(" Designated in");
        Assign.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 470, 120, 50));

        user_name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        user_name.setForeground(new java.awt.Color(255, 255, 255));
        user_name.setText("User");
        Assign.add(user_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 100, 30));

        user_surname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        user_surname.setForeground(new java.awt.Color(255, 255, 255));
        user_surname.setText("User");
        Assign.add(user_surname, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 100, 30));

        jLabel88.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(204, 204, 204));
        jLabel88.setText("First name");
        Assign.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 60, 30));

        lb_lname_capacity.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lb_lname_capacity.setForeground(new java.awt.Color(204, 204, 204));
        lb_lname_capacity.setText("Last name");
        Assign.add(lb_lname_capacity, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 70, 30));

        Department_name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Department_name.setForeground(new java.awt.Color(255, 255, 255));
        Department_name.setText("User");
        Assign.add(Department_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 420, 130, 50));

        designation.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        designation.setForeground(new java.awt.Color(255, 255, 255));
        designation.setText("User");
        Assign.add(designation, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 470, 130, 50));

        jLabel69.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(102, 102, 102));
        jLabel69.setText("Assets");
        Assign.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 130, -1, 30));

        jLabel65.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/left.png"))); // NOI18N
        jLabel65.setText("jLabel65");
        Assign.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 350, 490));

        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(102, 102, 102));
        jLabel68.setText("Department");
        Assign.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(474, 360, 90, 30));

        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/right.png"))); // NOI18N
        Assign.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 110, 370, 500));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        Assign.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 1080, 20));

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));
        Assign.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 1070, 20));

        jLabel72.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_close_window_25px_1.png"))); // NOI18N
        jLabel72.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel72.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel72MouseClicked(evt);
            }
        });
        Assign.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, -60, 70, 50));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(1213, 604));
        jPanel3.setMinimumSize(new java.awt.Dimension(1213, 604));
        jPanel3.setPreferredSize(new java.awt.Dimension(1213, 604));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        USER.setBackground(new Color(255,255,255,30));
        USER.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        USER.setForeground(new java.awt.Color(102, 102, 102));
        USER.setText("Assign To User");
        USER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                USERActionPerformed(evt);
            }
        });
        jPanel3.add(USER, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 150, -1));
        jPanel3.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 180, -1));

        fiter_assets.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fiter_assetsKeyReleased(evt);
            }
        });
        jPanel3.add(fiter_assets, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 10, 180, -1));

        jButton3.setBackground(new Color(255,255,255,30));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(102, 102, 102));
        jButton3.setText("Re-Assign");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 150, -1));

        jLabel67.setText("Fiter");
        jPanel3.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, -1, 40));

        jLabel66.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/centre.png"))); // NOI18N
        jPanel3.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, 440, 240));

        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_connect_127px_3.png"))); // NOI18N
        jPanel3.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, 188, 156));

        ROOM.setBackground(new Color(255,255,255,30));
        ROOM.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ROOM.setForeground(new java.awt.Color(102, 102, 102));
        ROOM.setText("Assign To Room");
        ROOM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ROOMActionPerformed(evt);
            }
        });
        jPanel3.add(ROOM, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 150, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/backtoSearch.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 50, 50));

        Assign.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 1190, 590));

        item_user_relation.add(Assign, "card3");

        jPanel1.add(item_user_relation, "card3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1220, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, "card2");

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -30, 1220, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void employee_fiterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_employee_fiterKeyReleased
        DefaultTableModel table = (DefaultTableModel) User_table.getModel();
        String search = employee_fiter.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        tr.setRowFilter(RowFilter.regexFilter(search));
        User_table.setRowSorter(tr);
    }//GEN-LAST:event_employee_fiterKeyReleased

    private void User_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_User_tableMouseClicked
        DefaultTableModel first_name = (DefaultTableModel) User_table.getModel();
        fname = first_name.getValueAt(User_table.getSelectedRow(), 0).toString();

        DefaultTableModel last_name = (DefaultTableModel) User_table.getModel();
        lname = last_name.getValueAt(User_table.getSelectedRow(), 1).toString();

    }//GEN-LAST:event_User_tableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (fname.equals("none")) {
            JOptionPane.showMessageDialog(null, "Select the Room");
        } else if (!fname.equals("none")) {
            
           try {
          conn = DBConnection.getConnction();
          String sql = " SELECT classroom_id,room_number,room_type,room_status,room_name,room_capacity FROM rooms WHERE room_number =? AND  room_type =?";
          pps3 = conn.prepareStatement(sql);
          pps3.setString(1, fname);
          pps3.setString(2, lname);

           rs3 = pps3.executeQuery();
         
            if(rs3.next()){
            Department_name.setText(rs3.getString("room_name"));
            designation.setText(rs3.getString("room_number"));
            
            
            jLabel88.setText("Name");
            user_name.setText(rs3.getString("room_type"));
            
            
            lb_lname_capacity.setText("Capacity");
            user_surname.setText(rs3.getString("room_capacity"));
            
            room_id = rs3.getString("classroom_id");  
            show_Already_Assigned_Assets_ToRooms();

             Assign.setVisible(true); 
             user.hide();  
             ROOM.setVisible(true); 
             USER.hide(); 
             }
         
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
            
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel71MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel71MouseClicked
        item_user_relation.hide();
    }//GEN-LAST:event_jLabel71MouseClicked

    private void jLabel72MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel72MouseClicked
        Assign.hide();
        user.setVisible(true);
    }//GEN-LAST:event_jLabel72MouseClicked

    private void USERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_USERActionPerformed
      ///
          String Assigned_date = ((JTextField) jDateChooser2.getDateEditor().getUiComponent()).getText();//conveting date to string then putting it on a resource
            try {
            conn = DBConnection.getConnction();
            pps5 = conn.prepareStatement("SELECT * FROM user_item_relation WHERE Item_id =?");// AND contact = ?
            pps5.setString(1, item_id);
            rs5 = pps5.executeQuery();
            if (rs5.next()) {
                JOptionPane.showMessageDialog(null, "Item Already Designated");
            } else {
                insert_item_userRelation();
            }
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_USERActionPerformed

    private void fiter_assetsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fiter_assetsKeyReleased
        DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
        String search = fiter_assets.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        tr.setRowFilter(RowFilter.regexFilter(search));
        jTable1.setRowSorter(tr);
    }//GEN-LAST:event_fiter_assetsKeyReleased

    
        public void insert_room_userRelation() {
            String Assigned_date = ((JTextField) jDateChooser2.getDateEditor().getUiComponent()).getText();//conveting date to string then putting it on a resource
            try {
            conn = DBConnection.getConnction();
            String state = "in_usage";
            pps7 = conn.prepareStatement("INSERT INTO user_item_relation(Item_id, classroom_id,assigned_date,status) VALUES (?,?,?,?) ");// AND contact = ?
            pps7.setString(1,item_id);
            pps7.setString(2, room_id);
            pps7.setString(3, Assigned_date);
            pps7.setString(4, state);

            pps7.executeUpdate();
            show_Already_Assigned_Assets_ToRooms();

           JOptionPane.showMessageDialog(null, "Relation created");
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
    }
        
         public void show_Already_Assigned_Assets_ToRooms(){
         try {
            conn = DBConnection.getConnction();
            String sql = "SELECT  room_number,room_type, item_number, item_name    FROM  inventory_items  INNER JOIN user_item_relation ON inventory_items.item_id = user_item_relation.item_id     INNER JOIN rooms ON  rooms.classroom_id = user_item_relation.classroom_id   WHERE room_number = ? AND room_type =?";
            pps5 = conn.prepareStatement(sql);
            pps5.setString(1, fname);
            pps5.setString(2, lname);
            rs5 = pps5.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs5));
         } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
       }   
        
        
        
        
        
        
        
    
      public void insert_item_userRelation() {
            
          
           Date date = new Date();
            java.sql.Date sqldate = new java.sql.Date(date.getTime());
          
            try {
            conn = DBConnection.getConnction();
            String state = "in_usage";
            pps7 = conn.prepareStatement("INSERT INTO user_item_relation(Item_id, user_login_id,assigned_date,status) VALUES (?,?,?,?) ");// AND contact = ?
            pps7.setString(1,item_id);
            pps7.setString(2, user_id);
            pps7.setDate(3, sqldate);
            pps7.setString(4, state);

            pps7.executeUpdate();
            show_Already_Assigned_Assets();

           JOptionPane.showMessageDialog(null, "Relation created");
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
    }
        public void show_Already_Assigned_Assets(){
       try {
            conn = DBConnection.getConnction();
            String sql = "SELECT  name,surname, item_number, item_name    FROM  inventory_items  INNER JOIN user_item_relation ON inventory_items.item_id = user_item_relation.item_id     INNER JOIN employee ON  employee.user_login_id = user_item_relation.user_login_id   WHERE name = ? AND surname =?";
            pps4 = conn.prepareStatement(sql);
            pps4.setString(1, fname);
            pps4.setString(2, lname);
            rs4 = pps4.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs4));
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
    }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnOfficeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOfficeMouseEntered
         btnOffice.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_btnOfficeMouseEntered

    private void btnUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUserMouseEntered
            btnUser.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_btnUserMouseEntered

    private void btnOfficeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOfficeMouseExited
        btnOffice.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnOfficeMouseExited

    private void btnUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUserMouseExited
        btnUser.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_btnUserMouseExited

    private void btnUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUserMouseClicked
        Item_Option.hide();
        Item_To_Room.hide();
        Item_To_User.setVisible(true);
    }//GEN-LAST:event_btnUserMouseClicked

    private void btnOfficeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOfficeMouseClicked
        Item_Option.hide();
        Item_To_User.hide();
        Item_To_Room.setVisible(true);
    }//GEN-LAST:event_btnOfficeMouseClicked

    private void User_table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_User_table1MouseClicked
         DefaultTableModel first_name = (DefaultTableModel) User_table1.getModel();
         fname = first_name.getValueAt(User_table1.getSelectedRow(), 0).toString();
    
          DefaultTableModel last_name = (DefaultTableModel) User_table1.getModel();
          lname = last_name.getValueAt(User_table1.getSelectedRow(), 1).toString();
    }//GEN-LAST:event_User_table1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          if (fname.equals("none")) {
               JOptionPane.showMessageDialog(null, "Select the User");
            } else if (!fname.equals("none")) {
                try {
                 conn = DBConnection.getConnction();
                 String sql = " SELECT * FROM employee   WHERE name =? AND  surname =?";
                  pps = conn.prepareStatement(sql);
                  pps.setString(1, fname);
                  pps.setString(2, lname);

                  rs = pps.executeQuery();
                  if(rs.next()){
                   Department_name.setText(rs.getString("department"));
                   designation.setText(rs.getString("designation"));
                   user_name.setText(rs.getString("name"));
                   user_surname.setText(rs.getString("surname"));
                   user_id = rs.getString("user_login_id");
                   show_Already_Assigned_Assets();
                    
                    Assign.setVisible(true); 
                    user.hide();  
                    
                     ROOM.hide();
                     USER.setVisible(true);
                 }
                 } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
            }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void employee_fiter1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_employee_fiter1KeyReleased
         DefaultTableModel table = (DefaultTableModel) User_table1.getModel();
        String search = employee_fiter1.getText().toLowerCase();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        tr.setRowFilter(RowFilter.regexFilter(search));
        User_table1.setRowSorter(tr);
    }//GEN-LAST:event_employee_fiter1KeyReleased

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        Item_To_Room.hide();
        Item_To_User.hide();
        Item_Option.setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        Item_To_Room.hide();
        Item_To_User.hide();
        Item_Option.setVisible(true);

    }//GEN-LAST:event_jLabel4MouseClicked

    private void ROOMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ROOMActionPerformed
         String Assigned_date = ((JTextField) jDateChooser2.getDateEditor().getUiComponent()).getText();//conveting date to string then putting it on a resource
        try {
            conn = DBConnection.getConnction();
            pps5 = conn.prepareStatement("SELECT * FROM user_item_relation WHERE Item_id =?");// AND contact = ?
            pps5.setString(1, item_id);
            rs5 = pps5.executeQuery();
            if (rs5.next()) {
                JOptionPane.showMessageDialog(null, "Item Already Designated");
            } else {
                insert_room_userRelation();
            }
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
    }//GEN-LAST:event_ROOMActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
       Assign.hide();
       user.setVisible(true);
       
    }//GEN-LAST:event_jLabel5MouseClicked

    private void txt_Search_employeeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Search_employeeKeyPressed
                try {
                  conn = DBConnection.getConnction();
                  String sql = " SELECT name,surname,department,designation FROM employee   WHERE   name  like '%" + txt_Search_employee.getText() + "%'  OR surname  like '%" + txt_Search_employee.getText() + "%'   OR  department  like '%" + txt_Search_employee.getText() + "%'   OR  designation  like '%" + txt_Search_employee.getText() + "%'";
                  pps2 = conn.prepareStatement(sql);
                  rs2 = pps2.executeQuery();
                  User_table1.setModel(DbUtils.resultSetToTableModel(rs2));
                 
                 } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
                
    }//GEN-LAST:event_txt_Search_employeeKeyPressed

    private void txt_Search_roomsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_Search_roomsKeyPressed
       
        try {
      
        conn = DBConnection.getConnction();
          String sql = " SELECT room_number,room_type,room_status,room_name,room_capacity FROM rooms   WHERE   room_number  like '%" + txt_Search_rooms.getText() + "%'  OR room_type  like '%" + txt_Search_rooms.getText() + "%'   OR  room_name  like '%" + txt_Search_rooms.getText() + "%'   OR    room_capacity  like '%" + txt_Search_rooms.getText() + "%' ";
         pps = conn.prepareStatement(sql);
         rs = pps.executeQuery();
         User_table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
      
    }//GEN-LAST:event_txt_Search_roomsKeyPressed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
         this.dispose();

    }//GEN-LAST:event_jLabel6MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Assign;
    private javax.swing.JLabel Department_name;
    private javax.swing.JPanel Item_Chooser;
    private javax.swing.JPanel Item_Option;
    private javax.swing.JPanel Item_To_Room;
    private javax.swing.JPanel Item_To_User;
    private javax.swing.JButton ROOM;
    private javax.swing.JButton USER;
    private javax.swing.JTable User_table;
    private javax.swing.JTable User_table1;
    private javax.swing.JPanel btnOffice;
    private javax.swing.JPanel btnUser;
    private javax.swing.JLabel designation;
    private javax.swing.JTextField employee_fiter;
    private javax.swing.JTextField employee_fiter1;
    private javax.swing.JTextField fiter_assets;
    private javax.swing.JPanel img_panel;
    private javax.swing.JLabel item_name;
    private javax.swing.JLabel item_name1;
    private javax.swing.JPanel item_user_relation;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel229;
    private javax.swing.JLabel jLabel230;
    private javax.swing.JLabel jLabel231;
    private javax.swing.JLabel jLabel232;
    private javax.swing.JLabel jLabel233;
    private javax.swing.JLabel jLabel234;
    private javax.swing.JLabel jLabel235;
    private javax.swing.JLabel jLabel236;
    private javax.swing.JLabel jLabel237;
    private javax.swing.JLabel jLabel238;
    private javax.swing.JLabel jLabel239;
    private javax.swing.JLabel jLabel240;
    private javax.swing.JLabel jLabel241;
    private javax.swing.JLabel jLabel242;
    private javax.swing.JLabel jLabel243;
    private javax.swing.JLabel jLabel244;
    private javax.swing.JLabel jLabel245;
    private javax.swing.JLabel jLabel246;
    private javax.swing.JLabel jLabel247;
    private javax.swing.JLabel jLabel248;
    private javax.swing.JLabel jLabel249;
    private javax.swing.JLabel jLabel250;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lb_Img;
    private javax.swing.JLabel lb_lname_capacity;
    private javax.swing.JLabel lb_search;
    private javax.swing.JLabel t_Item_Condition;
    private javax.swing.JLabel t_Item_Condition1;
    private javax.swing.JLabel t_Item_number;
    private javax.swing.JLabel t_Item_number1;
    private javax.swing.JLabel t_Purchase;
    private javax.swing.JLabel t_Purchase1;
    private javax.swing.JLabel t_warranty_ex_date;
    private javax.swing.JLabel t_warranty_ex_date1;
    private javax.swing.JLabel title_user1;
    private javax.swing.JTextField txt_Search_employee;
    private javax.swing.JTextField txt_Search_rooms;
    private javax.swing.JPanel user;
    private javax.swing.JLabel user_name;
    private javax.swing.JLabel user_surname;
    // End of variables declaration//GEN-END:variables
}
