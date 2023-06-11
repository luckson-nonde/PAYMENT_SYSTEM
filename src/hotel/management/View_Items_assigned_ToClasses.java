
package hotel.management;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;



public class View_Items_assigned_ToClasses extends javax.swing.JInternalFrame {
    Connection conn = null;
    PreparedStatement pps, pps1, pps2, pps3, pps4, pps6, pps5, pps7, pps8, pps9, pps10, pps11, pps12 = null;
    ResultSet rs, rs1, rs2, rs3, rs4, rs5, rs6, rs7, rs8, rs9, rs10, rs11, rs12 = null;

        String table_clicked = "none";

   
    public View_Items_assigned_ToClasses() {
        initComponents();
         this.setBackground(new Color(0, 0, 0, 0));
         my();
    }

    public void my(){
        try {
            conn = DBConnection.getConnction();
            String state = "in_usage";
            String sql = "SELECT item_number,item_name,item_description,model,serial_number,date_oflast_order,cost_per_item,conditions, warranty_ex_date, assigned_date, status,room_number, room_type FROM  inventory_items  INNER JOIN  user_item_relation  ON  inventory_items.item_id = user_item_relation.item_id INNER JOIN rooms ON  rooms.classroom_id = user_item_relation.classroom_id WHERE status =?";
            pps = conn.prepareStatement(sql);
            pps.setString(1, state);
            rs = pps.executeQuery();
            Main_list_View.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        } 
    
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main_type_viewer = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Main_list_View = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        Fiter = new javax.swing.JTextField();
        edit = new javax.swing.JButton();
        more_info = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        PopUp = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Main_list_View1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        setTitle("ID Generator");
        setMaximumSize(new java.awt.Dimension(1213, 600));
        setMinimumSize(new java.awt.Dimension(1213, 600));
        setPreferredSize(new java.awt.Dimension(1213, 600));
        getContentPane().setLayout(new java.awt.CardLayout());

        main_type_viewer.setBackground(new java.awt.Color(204, 204, 204));
        main_type_viewer.setPreferredSize(new java.awt.Dimension(1290, 570));
        main_type_viewer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

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
        Main_list_View.setRowHeight(25);
        Main_list_View.setShowVerticalLines(false);
        Main_list_View.setTableHeader(null);
        Main_list_View.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Main_list_ViewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Main_list_View);

        main_type_viewer.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 1210, 440));

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Last Order Date");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 100, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Item #");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Name");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 70, 40));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Serial #");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 100, 40));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Description");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 80, 40));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Model");
        jPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 100, 40));

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(102, 102, 102));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Last Order Date");
        jPanel4.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 100, 40));

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(102, 102, 102));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Cost per Item");
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
        jPanel4.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 10, 100, 40));

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(102, 102, 102));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Room Type");
        jPanel4.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 10, 120, 40));

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(102, 102, 102));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("Room # ");
        jPanel4.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 10, 120, 40));

        main_type_viewer.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 1210, 80));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(102, 102, 102));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Dispose");
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel37MouseClicked(evt);
            }
        });
        main_type_viewer.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 40, 100, 30));

        Fiter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                FiterKeyPressed(evt);
            }
        });
        main_type_viewer.add(Fiter, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 40, 220, 30));

        edit.setBackground(new Color(255,255,255,30));
        edit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        edit.setForeground(new java.awt.Color(102, 102, 102));
        edit.setText("Re-Assign");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        main_type_viewer.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        more_info.setBackground(new Color(255,255,255,30));
        more_info.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        more_info.setForeground(new java.awt.Color(102, 102, 102));
        more_info.setText("Info");
        more_info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                more_infoActionPerformed(evt);
            }
        });
        main_type_viewer.add(more_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 90, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_google_web_search_35px.png"))); // NOI18N
        main_type_viewer.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, 70, 50));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_direction_30px.png"))); // NOI18N
        jLabel3.setText("    Items Designated To Classes");
        main_type_viewer.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 260, 50));

        getContentPane().add(main_type_viewer, "card2");

        PopUp.setBackground(new Color (240,240,240,95));
        PopUp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        Main_list_View1.setForeground(new java.awt.Color(153, 153, 153));
        Main_list_View1.setModel(new javax.swing.table.DefaultTableModel(
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
        Main_list_View1.setRowHeight(35);
        Main_list_View1.setRowMargin(10);
        Main_list_View1.setShowHorizontalLines(false);
        Main_list_View1.setShowVerticalLines(false);
        Main_list_View1.setTableHeader(null);
        Main_list_View1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Main_list_View1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Main_list_View1);

        PopUp.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 850, 170));

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Item #");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 70, 40));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Description");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 100, 40));

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(102, 102, 102));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("Serial #");
        jPanel5.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 100, 40));

        PopUp.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 850, 80));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/ex.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        PopUp.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 390, 50, 50));

        getContentPane().add(PopUp, "card3");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Main_list_ViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Main_list_ViewMouseClicked
        DefaultTableModel tableMode_type = (DefaultTableModel) Main_list_View.getModel();
        table_clicked = tableMode_type.getValueAt(Main_list_View.getSelectedRow(), 0).toString();
    }//GEN-LAST:event_Main_list_ViewMouseClicked

    private void jLabel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseClicked
        // TODO add your handling code here:ent.MouseEvent evt) {                                      
        this.dispose();
    }//GEN-LAST:event_jLabel37MouseClicked

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
/*
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

        }*/
    }//GEN-LAST:event_editActionPerformed
    String item_id = null;
    private void more_infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_more_infoActionPerformed
            if (table_clicked.equals("none")) {
            JOptionPane.showMessageDialog(null, "Select the Item you wish to View");
            } else if (!table_clicked.equals("none")) {
            try {
                conn = DBConnection.getConnction();
                pps6 = conn.prepareStatement("SELECT *   FROM inventory_items WHERE item_number =? ");
                pps6.setString(1, table_clicked);
                rs6 = pps6.executeQuery();
                if(rs6.next()){
                    item_id = rs6.getString("Item_id");
                    Item_details();
                }
            } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}

        }
    }//GEN-LAST:event_more_infoActionPerformed

    
    
    
    
    public void Item_details(){
        try {
                conn = DBConnection.getConnction();
                pps7 = conn.prepareStatement("SELECT  problem,solution,cost  FROM item_details WHERE Item_id =? ");
                pps7.setString(1, item_id);
                rs7 = pps7.executeQuery();
                Main_list_View1.setModel(DbUtils.resultSetToTableModel(rs7));
               
                main_type_viewer.hide();
                PopUp.setVisible(true);
        } catch (SQLException ex) {Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);}
    }
    
    
    private void Main_list_View1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Main_list_View1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Main_list_View1MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
       main_type_viewer.setVisible(true);
       PopUp.hide();
                 
    }//GEN-LAST:event_jLabel1MouseClicked

    private void FiterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FiterKeyPressed
                
         try {
            conn = DBConnection.getConnction();
            String state = "in_usage";
            String sql = "SELECT item_number,item_name,item_description,model,serial_number,date_oflast_order,cost_per_item,conditions, warranty_ex_date, assigned_date, status,room_number, room_type FROM  inventory_items  INNER JOIN  user_item_relation  ON  inventory_items.item_id = user_item_relation.item_id INNER JOIN rooms ON  rooms.classroom_id = user_item_relation.classroom_id WHERE  status =?  AND   item_number  like '%" + Fiter.getText() + "%'  OR item_name  like '%" + Fiter.getText() + "%'   OR  item_description  like '%" + Fiter.getText() + "%'   OR  conditions  like '%" + Fiter.getText() + "%' "
                    + "  OR  cost_per_item  like '%" + Fiter.getText() + "%'  OR  room_type  like '%" + Fiter.getText() + "%'   OR room_number  like '%" + Fiter.getText() + "%' ";
            pps = conn.prepareStatement(sql);
            pps.setString(1, state);
            rs = pps.executeQuery();
            Main_list_View.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }         
                
    }//GEN-LAST:event_FiterKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Fiter;
    private javax.swing.JTable Main_list_View;
    private javax.swing.JTable Main_list_View1;
    private javax.swing.JPanel PopUp;
    private javax.swing.JButton edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel main_type_viewer;
    private javax.swing.JButton more_info;
    // End of variables declaration//GEN-END:variables
}
