
package hotel.management;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


public class ID_Generation extends javax.swing.JInternalFrame {
    Connection conn = null;
    PreparedStatement pps, pps1, pps2, pps3, pps4, pps6, pps5, pps7, pps8, pps9, pps10, pps11, pps12 = null;
    ResultSet rs, rs1, rs2, rs3, rs4, rs5, rs6, rs7, rs8, rs9, rs10, rs11, rs12 = null;

   
    public ID_Generation() {
        initComponents();
        
         my();
    }

    public void my(){
        try {
            conn = DBConnection.getConnction();
            String state = "in_usage";
            String sql = "SELECT item_number,item_name,item_description,model,serial_number,date_oflast_order,cost_per_item,conditions, warranty_ex_date, assigned_date, status,name, surname FROM  inventory_items  INNER JOIN  user_item_relation  ON  inventory_items.item_id = user_item_relation.item_id INNER JOIN employee ON  employee.user_login_id = user_item_relation.user_login_id WHERE status =?";
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

        jPanel1 = new javax.swing.JPanel();
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
        jLabel37 = new javax.swing.JLabel();
        Fiter = new javax.swing.JTextField();
        lb_search = new javax.swing.JLabel();
        edit = new javax.swing.JButton();
        Delete_item = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        setTitle("ID Generator");
        setMaximumSize(new java.awt.Dimension(1213, 600));
        setMinimumSize(new java.awt.Dimension(1213, 600));
        setPreferredSize(new java.awt.Dimension(1213, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(1290, 570));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 1230, 430));

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));
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

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(102, 102, 102));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Warranty Expiry");
        jPanel4.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, 120, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1230, 100));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(102, 102, 102));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Dispose");
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel37MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 60, 80, 30));
        jPanel1.add(Fiter, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 60, 220, 30));

        lb_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_google_web_search_35px.png"))); // NOI18N
        jPanel1.add(lb_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 50, 70, 50));

        edit.setBackground(new Color(255,255,255,30));
        edit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        edit.setForeground(new java.awt.Color(102, 102, 102));
        edit.setText("Re-Assign");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jPanel1.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, -1, -1));

        Delete_item.setBackground(new Color(255,255,255,30));
        Delete_item.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Delete_item.setForeground(new java.awt.Color(102, 102, 102));
        Delete_item.setText("Delete");
        Delete_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_itemActionPerformed(evt);
            }
        });
        jPanel1.add(Delete_item, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_direction_30px.png"))); // NOI18N
        jLabel3.setText("    Items Designated To Individuals");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 260, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1230, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Main_list_ViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Main_list_ViewMouseClicked
        DefaultTableModel tableMode_type = (DefaultTableModel) Main_list_View.getModel();
       // table_clicked = tableMode_type.getValueAt(Main_list_View.getSelectedRow(), 0).toString();
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

    private void Delete_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_itemActionPerformed
        /*   if (table_clicked.equals("none")) {
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

        }*/
    }//GEN-LAST:event_Delete_itemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete_item;
    private javax.swing.JTextField Fiter;
    private javax.swing.JTable Main_list_View;
    private javax.swing.JButton edit;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_search;
    // End of variables declaration//GEN-END:variables
}
