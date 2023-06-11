

package hotel.management;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;


public class RecordsV extends javax.swing.JFrame {
       Connection conn = null;
      PreparedStatement pps, pps1, pps2, pps3, pps4, pps6, pps5, pps7, pps8, pps9, pps10, pps11, pps12 ,pps13 = null;
      ResultSet rs, rs1, rs2, rs3, rs4, rs5, rs6, rs7, rs8, rs9, rs10, rs11, rs12 ,rs13= null;

        
              //passing user id
            private static RecordsV Obj = null;
            private String passed_user_id;

            private static String Recieved_user_id = null;
            private static String usertype = null;
      
            
               // gettingbalance();
 
     RecordsV() {
        initComponents();
        show_classOn_combo();
        all_records();
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

        Main_holder = new javax.swing.JPanel();
        Settings_Outer_holder = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        all_records2 = new javax.swing.JLabel();
        all_records3 = new javax.swing.JLabel();
        all_records4 = new javax.swing.JLabel();
        all_records5 = new javax.swing.JLabel();
        all_records6 = new javax.swing.JLabel();
        all_records7 = new javax.swing.JLabel();
        all_records8 = new javax.swing.JLabel();
        all_records9 = new javax.swing.JLabel();
        all_records11 = new javax.swing.JLabel();
        all_records12 = new javax.swing.JLabel();
        all_records14 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        lb_search = new javax.swing.JLabel();
        class_chooser = new javax.swing.JComboBox();
        lb_BackupSettings_btn = new javax.swing.JLabel();
        lb_PaymentSettings_btn = new javax.swing.JLabel();
        lb_GeneralSettings_btn = new javax.swing.JLabel();
        all_records = new javax.swing.JLabel();
        lb_FullPayments_btn = new javax.swing.JLabel();
        lb_Title_holder = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        txtSearch1 = new javax.swing.JTextField();
        tables_panel = new javax.swing.JPanel();
        All_Records_table = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        table_allRecords = new javax.swing.JTable();
        ByClass_table1 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        table_class = new javax.swing.JTable();
        full_paymenttable2 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        full_payment_table = new javax.swing.JTable();
        New_Recordstable = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        NewRecords_table = new javax.swing.JTable();
        With_Balancetable = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        with_balanceTable = new javax.swing.JTable();
        Search_byName = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        Table_searchName = new javax.swing.JTable();
        main_BG = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Main_holder.setBackground(new java.awt.Color(255, 255, 255));
        Main_holder.setLayout(new java.awt.CardLayout());

        Settings_Outer_holder.setBackground(new java.awt.Color(252, 252, 252));
        Settings_Outer_holder.setMinimumSize(new java.awt.Dimension(1350, 760));
        Settings_Outer_holder.setPreferredSize(new java.awt.Dimension(1350, 760));
        Settings_Outer_holder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        all_records2.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        all_records2.setForeground(new java.awt.Color(153, 153, 153));
        all_records2.setText(" Student ID");
        all_records2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                all_records2MouseClicked(evt);
            }
        });
        jPanel1.add(all_records2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 80, 30));

        all_records3.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        all_records3.setForeground(new java.awt.Color(153, 153, 153));
        all_records3.setText("Name");
        all_records3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                all_records3MouseClicked(evt);
            }
        });
        jPanel1.add(all_records3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, 30));

        all_records4.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        all_records4.setForeground(new java.awt.Color(153, 153, 153));
        all_records4.setText("   Fees");
        all_records4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                all_records4MouseClicked(evt);
            }
        });
        jPanel1.add(all_records4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 70, 30));

        all_records5.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        all_records5.setForeground(new java.awt.Color(153, 153, 153));
        all_records5.setText("Amount Paid");
        all_records5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                all_records5MouseClicked(evt);
            }
        });
        jPanel1.add(all_records5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, 30));

        all_records6.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        all_records6.setForeground(new java.awt.Color(153, 153, 153));
        all_records6.setText("Bank Name");
        all_records6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                all_records6MouseClicked(evt);
            }
        });
        jPanel1.add(all_records6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 80, 30));

        all_records7.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        all_records7.setForeground(new java.awt.Color(153, 153, 153));
        all_records7.setText("Cheque #");
        all_records7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                all_records7MouseClicked(evt);
            }
        });
        jPanel1.add(all_records7, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, -1, 30));

        all_records8.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        all_records8.setForeground(new java.awt.Color(153, 153, 153));
        all_records8.setText("Payment Date");
        all_records8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                all_records8MouseClicked(evt);
            }
        });
        jPanel1.add(all_records8, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, -1, 30));

        all_records9.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        all_records9.setForeground(new java.awt.Color(153, 153, 153));
        all_records9.setText("Payment ");
        all_records9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                all_records9MouseClicked(evt);
            }
        });
        jPanel1.add(all_records9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 10, -1, 30));

        all_records11.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        all_records11.setForeground(new java.awt.Color(153, 153, 153));
        all_records11.setText("Balance");
        all_records11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                all_records11MouseClicked(evt);
            }
        });
        jPanel1.add(all_records11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 70, 30));

        all_records12.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        all_records12.setForeground(new java.awt.Color(153, 153, 153));
        all_records12.setText("Term");
        all_records12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                all_records12MouseClicked(evt);
            }
        });
        jPanel1.add(all_records12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 10, 60, 30));

        all_records14.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        all_records14.setForeground(new java.awt.Color(153, 153, 153));
        all_records14.setText("Grade");
        all_records14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                all_records14MouseClicked(evt);
            }
        });
        jPanel1.add(all_records14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 10, 60, 30));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 42, 1340, 30));

        Settings_Outer_holder.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 1370, 60));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_delete_25px.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        Settings_Outer_holder.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 10, 50, 50));

        lb_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_google_web_search_35px_2.png"))); // NOI18N
        lb_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_searchMouseClicked(evt);
            }
        });
        Settings_Outer_holder.add(lb_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 20, -1, 30));

        class_chooser.setBackground(new Color(255,255,255,10));
        class_chooser.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None" }));
        Settings_Outer_holder.add(class_chooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 20, 90, 30));

        lb_BackupSettings_btn.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        lb_BackupSettings_btn.setForeground(new java.awt.Color(255, 255, 255));
        lb_BackupSettings_btn.setText("By Class");
        lb_BackupSettings_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_BackupSettings_btnMouseEntered(evt);
            }
        });
        Settings_Outer_holder.add(lb_BackupSettings_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 200, 50));

        lb_PaymentSettings_btn.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        lb_PaymentSettings_btn.setForeground(new java.awt.Color(255, 255, 255));
        lb_PaymentSettings_btn.setText("With Balance");
        lb_PaymentSettings_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_PaymentSettings_btnMouseClicked(evt);
            }
        });
        Settings_Outer_holder.add(lb_PaymentSettings_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, -1, 50));

        lb_GeneralSettings_btn.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        lb_GeneralSettings_btn.setForeground(new java.awt.Color(255, 255, 255));
        lb_GeneralSettings_btn.setText("New Records ");
        lb_GeneralSettings_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_GeneralSettings_btnMouseClicked(evt);
            }
        });
        Settings_Outer_holder.add(lb_GeneralSettings_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 100, 50));

        all_records.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        all_records.setForeground(new java.awt.Color(102, 102, 102));
        all_records.setText("All Records");
        all_records.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                all_recordsMouseClicked(evt);
            }
        });
        Settings_Outer_holder.add(all_records, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 100, 40));

        lb_FullPayments_btn.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        lb_FullPayments_btn.setForeground(new java.awt.Color(255, 255, 255));
        lb_FullPayments_btn.setText("Full Payments");
        lb_FullPayments_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_FullPayments_btnMouseClicked(evt);
            }
        });
        Settings_Outer_holder.add(lb_FullPayments_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, 50));

        lb_Title_holder.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lb_Title_holder.setForeground(new java.awt.Color(153, 153, 153));
        lb_Title_holder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Search_15px.png"))); // NOI18N
        lb_Title_holder.setText("Search");
        lb_Title_holder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_Title_holderMouseEntered(evt);
            }
        });
        Settings_Outer_holder.add(lb_Title_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, 190, 50));

        txtSearch.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtSearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtSearchMouseExited(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });
        Settings_Outer_holder.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 20, 250, 30));

        txtSearch1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSearch1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearch1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearch1KeyReleased(evt);
            }
        });
        Settings_Outer_holder.add(txtSearch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 20, 250, 30));

        tables_panel.setLayout(new java.awt.CardLayout());

        All_Records_table.setBackground(new java.awt.Color(255, 255, 255));
        All_Records_table.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane8.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        table_allRecords.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 6));
        table_allRecords.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        table_allRecords.setForeground(new java.awt.Color(153, 153, 153));
        table_allRecords.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_allRecords.setIntercellSpacing(new java.awt.Dimension(20, 10));
        table_allRecords.setRowHeight(30);
        table_allRecords.setShowVerticalLines(false);
        table_allRecords.setTableHeader(null);
        table_allRecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_allRecordsMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(table_allRecords);

        All_Records_table.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1340, 560));

        tables_panel.add(All_Records_table, "card2");

        ByClass_table1.setBackground(new java.awt.Color(255, 255, 255));
        ByClass_table1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_class.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 6));
        table_class.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        table_class.setForeground(new java.awt.Color(102, 102, 102));
        table_class.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_class.setIntercellSpacing(new java.awt.Dimension(20, 10));
        table_class.setRowHeight(37);
        table_class.setShowVerticalLines(false);
        table_class.setTableHeader(null);
        jScrollPane9.setViewportView(table_class);

        ByClass_table1.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1380, 710));

        tables_panel.add(ByClass_table1, "card3");

        full_paymenttable2.setBackground(new java.awt.Color(255, 255, 255));
        full_paymenttable2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        full_payment_table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 6));
        full_payment_table.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        full_payment_table.setForeground(new java.awt.Color(102, 102, 102));
        full_payment_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        full_payment_table.setIntercellSpacing(new java.awt.Dimension(20, 10));
        full_payment_table.setRowHeight(37);
        full_payment_table.setShowVerticalLines(false);
        full_payment_table.setTableHeader(null);
        jScrollPane10.setViewportView(full_payment_table);

        full_paymenttable2.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 1380, 720));

        tables_panel.add(full_paymenttable2, "card4");

        New_Recordstable.setBackground(new java.awt.Color(255, 255, 255));
        New_Recordstable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NewRecords_table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 6));
        NewRecords_table.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        NewRecords_table.setForeground(new java.awt.Color(102, 102, 102));
        NewRecords_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        NewRecords_table.setIntercellSpacing(new java.awt.Dimension(20, 10));
        NewRecords_table.setRowHeight(37);
        NewRecords_table.setShowVerticalLines(false);
        NewRecords_table.setTableHeader(null);
        jScrollPane12.setViewportView(NewRecords_table);

        New_Recordstable.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 1380, 720));

        tables_panel.add(New_Recordstable, "card4");

        With_Balancetable.setBackground(new java.awt.Color(255, 255, 255));
        With_Balancetable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        with_balanceTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 6));
        with_balanceTable.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        with_balanceTable.setForeground(new java.awt.Color(102, 102, 102));
        with_balanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        with_balanceTable.setIntercellSpacing(new java.awt.Dimension(20, 10));
        with_balanceTable.setRowHeight(37);
        with_balanceTable.setShowVerticalLines(false);
        with_balanceTable.setTableHeader(null);
        jScrollPane11.setViewportView(with_balanceTable);

        With_Balancetable.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 1380, 720));

        tables_panel.add(With_Balancetable, "card4");

        Search_byName.setBackground(new java.awt.Color(255, 255, 255));
        Search_byName.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Table_searchName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 6));
        Table_searchName.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        Table_searchName.setForeground(new java.awt.Color(102, 102, 102));
        Table_searchName.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Table_searchName.setIntercellSpacing(new java.awt.Dimension(20, 10));
        Table_searchName.setRowHeight(37);
        Table_searchName.setShowVerticalLines(false);
        Table_searchName.setTableHeader(null);
        jScrollPane13.setViewportView(Table_searchName);

        Search_byName.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1380, 710));

        tables_panel.add(Search_byName, "card4");

        Settings_Outer_holder.add(tables_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 1370, 560));

        main_BG.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        main_BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/hBG.png"))); // NOI18N
        Settings_Outer_holder.add(main_BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, -10, 1630, 810));

        Main_holder.add(Settings_Outer_holder, "card6");

        getContentPane().add(Main_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 1430, 810));

        Background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/Untitled-1.png"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1420, 830));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void all_records2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_all_records2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_all_records2MouseClicked

    private void all_records3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_all_records3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_all_records3MouseClicked

    private void all_records4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_all_records4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_all_records4MouseClicked

    private void all_records5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_all_records5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_all_records5MouseClicked

    private void all_records6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_all_records6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_all_records6MouseClicked

    private void all_records7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_all_records7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_all_records7MouseClicked

    private void all_records8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_all_records8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_all_records8MouseClicked

    private void all_records9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_all_records9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_all_records9MouseClicked

    private void all_records11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_all_records11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_all_records11MouseClicked

    private void all_records12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_all_records12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_all_records12MouseClicked

    private void all_records14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_all_records14MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_all_records14MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
                    Adminstrative add = new Adminstrative();  //iinstance 
                    add .setVisible(true);
                    //passing user id 
                    add.setPassed_id(Recieved_user_id); //upon closing send the user ID
                    add.printPassed_id();

                    this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void lb_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_searchMouseClicked
        String classSearch = class_chooser.getSelectedItem().toString().trim();

        if(classSearch != "None"){
            txtSearch.setVisible(true);
            txtSearch1.hide();
            try {
                conn = DBConnection.getConnction();
                String sql ="SELECT Student_Id,Full_name,School_feesOf, Amount_Paid,Remaining_balance,BanK_name,Cheque_number,Date,PaymentType,Term,Student_Class  FROM fee_history  WHERE Student_Class = ?";
                pps = conn.prepareStatement(sql);
                pps.setString(1, classSearch);
                rs = pps.executeQuery();
                table_class.removeAll();
                table_class.setModel(DbUtils.resultSetToTableModel(rs));//sho
                
                With_Balancetable .setVisible(false);
                New_Recordstable.setVisible(false);
                All_Records_table.setVisible(false);
                full_paymenttable2.setVisible(false);
                ByClass_table1.setVisible(true);

              } catch (SQLException ex) {Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);}
              }else {
               lb_Title_holder.setText("Search By Name");
               txtSearch.hide();
               txtSearch1.setVisible(true);

        }
    }//GEN-LAST:event_lb_searchMouseClicked

    private void lb_BackupSettings_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_BackupSettings_btnMouseEntered
        
    }//GEN-LAST:event_lb_BackupSettings_btnMouseEntered

    private void lb_PaymentSettings_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_PaymentSettings_btnMouseClicked
        ByClass_table1.setVisible(false);
        New_Recordstable.setVisible(false);
        All_Records_table.setVisible(false);
        full_paymenttable2.setVisible(false);
        With_Balancetable .setVisible(true);
        Search_byName.setVisible(false);
        try {
            conn = DBConnection.getConnction();
            String sql ="SELECT Student_Id,Full_name,School_feesOf, Amount_Paid,Remaining_balance,BanK_name,Cheque_number,Date,PaymentType,Term,Student_Class  FROM fee_history WHERE  School_feesOf != Amount_Paid";
            pps = conn.prepareStatement(sql);
            rs = pps.executeQuery();
            with_balanceTable.setModel(DbUtils.resultSetToTableModel(rs));//sho
        } catch (SQLException ex) {Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);}

    }//GEN-LAST:event_lb_PaymentSettings_btnMouseClicked

    private void lb_GeneralSettings_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_GeneralSettings_btnMouseClicked
        With_Balancetable .setVisible(false);
        All_Records_table.setVisible(false);
        ByClass_table1.setVisible(false);
        full_paymenttable2.setVisible(false);
        New_Recordstable.setVisible(true);
        Search_byName.setVisible(false);

        try {
            conn = DBConnection.getConnction();
            String sql ="SELECT Student_Id,Full_name,School_feesOf, Amount_Paid,Remaining_balance,BanK_name,Cheque_number,Date,PaymentType,Term,Student_Class  FROM fee_history ORDER  BY date DESC LIMIT  2 ";
            pps = conn.prepareStatement(sql);
            rs = pps.executeQuery();
            NewRecords_table.setModel(DbUtils.resultSetToTableModel(rs));//sho
        } catch (SQLException ex) {Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);}

    }//GEN-LAST:event_lb_GeneralSettings_btnMouseClicked

    private void all_recordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_all_recordsMouseClicked
        With_Balancetable .setVisible(false);
        ByClass_table1.setVisible(false);
        full_paymenttable2.setVisible(false);
        New_Recordstable.setVisible(false);
        Search_byName.setVisible(false);
        All_Records_table.setVisible(true);

        all_records();
    }//GEN-LAST:event_all_recordsMouseClicked
    
    
    
    public void all_records(){
    try {
        conn = DBConnection.getConnction();
        String sql ="SELECT Student_Id,Full_name,School_feesOf, Amount_Paid,Remaining_balance,BanK_name,Cheque_number,Date,PaymentType,Term,Student_Class  FROM fee_history";
        pps = conn.prepareStatement(sql);
         rs = pps.executeQuery();
         table_allRecords.setModel(DbUtils.resultSetToTableModel(rs));//sho
      } catch (SQLException ex) {Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);}

}
    private void lb_FullPayments_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_FullPayments_btnMouseClicked
        With_Balancetable .setVisible(false);
        ByClass_table1.setVisible(false);
        New_Recordstable.setVisible(false);
        Search_byName.setVisible(false);
        All_Records_table.setVisible(false);
        Search_byName.setVisible(false);
        full_paymenttable2.setVisible(true);

        try {
            conn = DBConnection.getConnction();
            String sql ="SELECT Student_Id,Full_name,School_feesOf, Amount_Paid,Remaining_balance,BanK_name,Cheque_number,Date,PaymentType,Term,Student_Class FROM fee_history WHERE  School_feesOf <= Amount_Paid";
            pps = conn.prepareStatement(sql);
            rs = pps.executeQuery();
            full_payment_table.setModel(DbUtils.resultSetToTableModel(rs));//sho
        } catch (SQLException ex) {Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);}

    }//GEN-LAST:event_lb_FullPayments_btnMouseClicked

    private void lb_Title_holderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_Title_holderMouseEntered
    }//GEN-LAST:event_lb_Title_holderMouseEntered

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased

      if(full_paymenttable2.isShowing()){
            DefaultTableModel table = (DefaultTableModel)full_payment_table.getModel();
            String search = txtSearch.getText().toLowerCase();
            TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
            tr.setRowFilter(RowFilter.regexFilter(search));
            full_payment_table.setRowSorter(tr);

        }else if(With_Balancetable.isShowing()){
            DefaultTableModel table = (DefaultTableModel)with_balanceTable.getModel();
            String search = txtSearch.getText().toLowerCase();
            TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
            tr.setRowFilter(RowFilter.regexFilter(search));
            with_balanceTable.setRowSorter(tr);

        }else if(New_Recordstable.isShowing()){
            DefaultTableModel table = (DefaultTableModel)NewRecords_table.getModel();
            String search = txtSearch.getText().toLowerCase();
            TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
            tr.setRowFilter(RowFilter.regexFilter(search));
            NewRecords_table.setRowSorter(tr);

        }else if(ByClass_table1.isShowing()){
            DefaultTableModel table = (DefaultTableModel)table_class.getModel();
            String search = txtSearch.getText().toLowerCase();
            TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
            tr.setRowFilter(RowFilter.regexFilter(search));
            table_class.setRowSorter(tr);

        }

    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearch1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch1KeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            With_Balancetable .setVisible(false);
            All_Records_table.setVisible(false);
            ByClass_table1.setVisible(false);
            full_paymenttable2.setVisible(false);
            New_Recordstable.setVisible(false);
            Search_byName.setVisible(true);

            String name = txtSearch1.getText().trim();
            try {
                conn = DBConnection.getConnction();
                String sql ="SELECT Student_Id,Full_name,School_feesOf, Amount_Paid,Remaining_balance,BanK_name,Cheque_number,Date,PaymentType,Term,Student_Class  FROM fee_history  WHERE Full_name = ?";
                pps = conn.prepareStatement(sql);
                pps.setString(1, name);
                rs = pps.executeQuery();
                Table_searchName.setModel(DbUtils.resultSetToTableModel(rs));//sho
            } catch (SQLException ex) {Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);}

        }
    }//GEN-LAST:event_txtSearch1KeyPressed

    private void txtSearch1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearch1KeyReleased

    private void table_allRecordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_allRecordsMouseClicked
                     
      
        DefaultTableModel tableMode = (DefaultTableModel) table_allRecords.getModel();
        String ID = tableMode.getValueAt(table_allRecords.getSelectedRow(), 0).toString();
      
        DefaultTableModel tableMode_for_date = (DefaultTableModel) table_allRecords.getModel();
        String Date = tableMode_for_date.getValueAt(table_allRecords.getSelectedRow(), 8).toString();
      
          try { 
                conn = DBConnection.getConnction();
                String sql ="SELECT payername, PayeerID  FROM fee_history  WHERE Student_Id = ?  AND Date =?";
                pps = conn.prepareStatement(sql);
                pps.setString(1, ID);
                pps.setString(2, Date);

                rs = pps.executeQuery();
                if(rs.next()){
                      String payname = rs.getString("payername");
                       String payid = rs.getString("PayeerID");
                      JOptionPane.showMessageDialog(null, "event working" + payname +  payid );

                }
            } catch (SQLException ex) {Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);}

      
      
    }//GEN-LAST:event_table_allRecordsMouseClicked

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
      try {
        conn = DBConnection.getConnction();
        String sql ="SELECT Student_Id,Full_name,School_feesOf, Amount_Paid,Remaining_balance,BanK_name,Cheque_number,Date,PaymentType,Term,Student_Class  FROM fee_history     WHERE Student_Id  like '%" + txtSearch.getText() + "%'  OR Full_name  like '%" + txtSearch.getText() + "%'   OR  Student_Class  like '%" + txtSearch.getText() + "%'   OR  Term  like '%" + txtSearch.getText() + "%' "
                    + "  OR  Date  like '%" + txtSearch.getText() + "%'  OR  BanK_name  like '%" + txtSearch.getText() + "%'   OR Amount_Paid  like '%" + txtSearch.getText() + "%' ";
         pps = conn.prepareStatement(sql);
         rs = pps.executeQuery();
         table_allRecords.setModel(DbUtils.resultSetToTableModel(rs));//sho
      } catch (SQLException ex) {Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);}
        
        
    }//GEN-LAST:event_txtSearchKeyTyped

    private void txtSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchMouseExited

    private void txtSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseEntered
                     lb_Title_holder.hide();

    }//GEN-LAST:event_txtSearchMouseEntered
     public void show_classOn_combo(){
    try {
        conn = DBConnection.getConnction();
        String sql ="SELECT grade_room  FROM classes";
        pps = conn.prepareStatement(sql);
         rs = pps.executeQuery();
         while(rs.next()){
            class_chooser.addItem(rs.getString("grade_room"));
         }
      } catch (SQLException ex) {Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);}

}
     
     
     public static RecordsV getObj() {  //public method for instance Restriction
        if (Obj == null) {
            Obj = new RecordsV();
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
            java.util.logging.Logger.getLogger(RecordsV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecordsV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecordsV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecordsV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecordsV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel All_Records_table;
    private javax.swing.JLabel Background;
    private javax.swing.JPanel ByClass_table1;
    private javax.swing.JPanel Main_holder;
    private javax.swing.JTable NewRecords_table;
    private javax.swing.JPanel New_Recordstable;
    private javax.swing.JPanel Search_byName;
    private javax.swing.JPanel Settings_Outer_holder;
    private javax.swing.JTable Table_searchName;
    private javax.swing.JPanel With_Balancetable;
    private javax.swing.JLabel all_records;
    private javax.swing.JLabel all_records11;
    private javax.swing.JLabel all_records12;
    private javax.swing.JLabel all_records14;
    private javax.swing.JLabel all_records2;
    private javax.swing.JLabel all_records3;
    private javax.swing.JLabel all_records4;
    private javax.swing.JLabel all_records5;
    private javax.swing.JLabel all_records6;
    private javax.swing.JLabel all_records7;
    private javax.swing.JLabel all_records8;
    private javax.swing.JLabel all_records9;
    private javax.swing.JComboBox class_chooser;
    private javax.swing.JTable full_payment_table;
    private javax.swing.JPanel full_paymenttable2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lb_BackupSettings_btn;
    private javax.swing.JLabel lb_FullPayments_btn;
    private javax.swing.JLabel lb_GeneralSettings_btn;
    private javax.swing.JLabel lb_PaymentSettings_btn;
    private javax.swing.JLabel lb_Title_holder;
    private javax.swing.JLabel lb_search;
    private javax.swing.JLabel main_BG;
    private javax.swing.JTable table_allRecords;
    private javax.swing.JTable table_class;
    private javax.swing.JPanel tables_panel;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSearch1;
    private javax.swing.JTable with_balanceTable;
    // End of variables declaration//GEN-END:variables
}
