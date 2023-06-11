package hotel.management;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
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
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

public class Payments extends javax.swing.JFrame {

    Connection conn = null;

    PreparedStatement pps, pps1, pps2 ,pps3,pps4,pps5,pps6,pps7,pps8,pps9,pps10 = null;
    ResultSet rs, rs1, rs2 ,rs3,rs4,rs5,rs6,rs7,rs8,rs9,rs10,rs11,rs12,rs13,rs14 = null;

 // gettingbalance();
    String Gender,   grade = null;

    //VARibles for caculating the payments
    int Var_FeeCharged, var_AmountPaid, SumUp, Previous_Bill, sum;

    int Var_FeeCharged1, var_AmountPaid1, SumUp1, Previous_Bill1, sum1;

    int defau = 000;
    
    int amountToBePaid, balance, fees;
    
     int xx = 0;
     int yy = 0;
     
     //container variables that holds passed on info
    private String pass_user_id;
    private String user_name;
    
   private static Payments Obj = null;
   String global_user_id = null; // A variable thats holds the id 
   
    String  user_access_id = null; 
    String resuorce = null;//resource to hold the id for amenities after qurying the avaliable content then use it when updating


     
       
    public void setUserID(String user_id) {
        pass_user_id = user_id;
    }

    public String getUserID() {
        return pass_user_id;
    }

    public void printUserID() {
        global_user_id = getUserID();//setting the id of the user who logged in and set it to a global variable
       
        
    }
    
     
     
     
    public Payments() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        Student_info.hide();

        lb_GeneralSettings_btn.setVisible(false);
        lb_FullPayments_btn.setVisible(false);
        lb_PaymentSettings_btn.setVisible(false);
        txtSearch.setVisible(false);
        lb_Title_holder.setVisible(false);
        lb_printing_btn.setVisible(false);

        mark_deposite.hide();
        mark_Cheque.hide();
        Mark_cash.hide();
        Payee_ExtraInfo.hide();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        payment_entry = new javax.swing.JPanel();
        Cashn = new javax.swing.JPanel();
        HistoryPanel = new javax.swing.JPanel();
        front = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        PaidAmount = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Schoolfees = new javax.swing.JTextField();
        Current_Balanec = new javax.swing.JTextField();
        txtFullName = new javax.swing.JTextField();
        txtStudentGrade = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        PayeersName = new javax.swing.JTextField();
        txtStudentId = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        BankName = new javax.swing.JTextField();
        Chequenumber = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        txtAmount_Tobe_Paid = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        payeersID = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        Search_by_fullStudent_name = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        lb_ON_SearchBylastName = new javax.swing.JLabel();
        txt_SearchBy_Student_Fullname = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        timeOf_payment = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Search_by_IDPanel = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        lb_ON_txtSearch_BY_id = new javax.swing.JLabel();
        txtSearch_by_id = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        Paymen_methodsPanel = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cashBtn = new javax.swing.JRadioButton();
        chequeBtn = new javax.swing.JRadioButton();
        depostBtn = new javax.swing.JRadioButton();
        backTo_search = new javax.swing.JLabel();
        Option_for_searchPanel = new javax.swing.JPanel();
        lb_searchOn_Option = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        txtSearchOption = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        Save_payments = new javax.swing.JButton();
        print_payment = new javax.swing.JPanel();
        ReSourcePanel = new javax.swing.JPanel();
        txtSurcesCurrent = new javax.swing.JTextField();
        TxtResourceForSearByName = new javax.swing.JTextField();
        TxtResourceForSearById = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtResourceForDateFormatingINtoString = new javax.swing.JTextField();
        Student_info = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        lb_imageIcon = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lb_printing_btn = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        lb_gender = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        lb_age = new javax.swing.JLabel();
        lb_date = new javax.swing.JLabel();
        lb_name = new javax.swing.JLabel();
        lb_address = new javax.swing.JLabel();
        lb_status = new javax.swing.JLabel();
        lb_grade = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Receipt = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        CardsOf_receipt = new javax.swing.JPanel();
        Rec_editable = new javax.swing.JPanel();
        Receipt_form1 = new javax.swing.JPanel();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        lb_schoollevel1 = new javax.swing.JLabel();
        lb_forSchool_name20 = new javax.swing.JLabel();
        lb_forReceipt_number1 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        lb_forStudent_name8 = new javax.swing.JLabel();
        lb_forDate6 = new javax.swing.JLabel();
        lb_forDate7 = new javax.swing.JLabel();
        lb_forDate8 = new javax.swing.JLabel();
        lb_forStudent_name9 = new javax.swing.JLabel();
        lb_forDate_holddate10 = new javax.swing.JLabel();
        lb_forDate_holddate11 = new javax.swing.JLabel();
        lb_forDate_holddate12 = new javax.swing.JLabel();
        lb_forDate_holddate13 = new javax.swing.JLabel();
        lb_forStudent_name10 = new javax.swing.JLabel();
        lb_forStudent_name11 = new javax.swing.JLabel();
        lb_forDate_holddate14 = new javax.swing.JLabel();
        lb_forStudent_name12 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        lb_forReceipt_title2 = new javax.swing.JLabel();
        lb_forDate_holddate16 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        mark_deposite = new javax.swing.JLabel();
        lb_forDate9 = new javax.swing.JLabel();
        lb_forStudent_name13 = new javax.swing.JLabel();
        lb_forStudent_name14 = new javax.swing.JLabel();
        lb_forStudent_name15 = new javax.swing.JLabel();
        lb_forStudent_name16 = new javax.swing.JLabel();
        mark_Cheque = new javax.swing.JLabel();
        Mark_cash = new javax.swing.JLabel();
        lb_school_name = new javax.swing.JLabel();
        lb_school_address = new javax.swing.JLabel();
        lb_forDate10 = new javax.swing.JLabel();
        lb_forSchool_name23 = new javax.swing.JLabel();
        lb_forSchool_name24 = new javax.swing.JLabel();
        lb_forSchool_name25 = new javax.swing.JLabel();
        lb_recei = new javax.swing.JLabel();
        lb_forSchool_name27 = new javax.swing.JLabel();
        lb_forschoolfee = new javax.swing.JLabel();
        lb_forSchool_name31 = new javax.swing.JLabel();
        lb_forSchool_name33 = new javax.swing.JLabel();
        lb_forSchool_name35 = new javax.swing.JLabel();
        lb_forSchool_balance = new javax.swing.JLabel();
        lb_forSchool_name39 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        lb_forDate_holddate18 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        lb_forDate_holddate19 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        lb_forSchool_name29 = new javax.swing.JLabel();
        lb_forSchool_name38 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Receipt_printable = new javax.swing.JPanel();
        Receipt_form = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        lb_schoollevel = new javax.swing.JLabel();
        lb_forSchool_name = new javax.swing.JLabel();
        lb_forReceipt_number = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lb_forStudent_name = new javax.swing.JLabel();
        lb_forDate3 = new javax.swing.JLabel();
        lb_forDate4 = new javax.swing.JLabel();
        lb_forDate5 = new javax.swing.JLabel();
        lb_forStudent_name2 = new javax.swing.JLabel();
        lb_forDate_holddate2 = new javax.swing.JLabel();
        lb_forDate_holddate4 = new javax.swing.JLabel();
        lb_forDate_holddate5 = new javax.swing.JLabel();
        lb_forDate_holddate6 = new javax.swing.JLabel();
        lb_forStudent_name3 = new javax.swing.JLabel();
        lb_forStudent_name4 = new javax.swing.JLabel();
        lb_forDate_holddate7 = new javax.swing.JLabel();
        lb_forDate_holddate9 = new javax.swing.JLabel();
        lb_forStudent_name5 = new javax.swing.JLabel();
        lb_forReceipt_title1 = new javax.swing.JLabel();
        lb_forDate_holddate3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lb_forDate1 = new javax.swing.JLabel();
        lb_forStudent_name1 = new javax.swing.JLabel();
        lb_forStudent_name6 = new javax.swing.JLabel();
        lb_forStudent_name7 = new javax.swing.JLabel();
        lb_forSchool_name1 = new javax.swing.JLabel();
        lb_forSchool_name2 = new javax.swing.JLabel();
        lb_forDate_holddate8 = new javax.swing.JLabel();
        lb_forDate2 = new javax.swing.JLabel();
        lb_forSchool_name3 = new javax.swing.JLabel();
        lb_forSchool_name4 = new javax.swing.JLabel();
        lb_forSchool_name5 = new javax.swing.JLabel();
        lb_forSchool_name6 = new javax.swing.JLabel();
        lb_forSchool_name7 = new javax.swing.JLabel();
        lb_forSchool_name8 = new javax.swing.JLabel();
        lb_forSchool_name9 = new javax.swing.JLabel();
        lb_forSchool_name10 = new javax.swing.JLabel();
        lb_forSchool_name11 = new javax.swing.JLabel();
        lb_forSchool_name12 = new javax.swing.JLabel();
        lb_forSchool_name13 = new javax.swing.JLabel();
        lb_forSchool_name14 = new javax.swing.JLabel();
        lb_forSchool_name15 = new javax.swing.JLabel();
        lb_forSchool_name16 = new javax.swing.JLabel();
        lb_forSchool_name17 = new javax.swing.JLabel();
        lb_forSchool_name18 = new javax.swing.JLabel();
        lb_forSchool_name19 = new javax.swing.JLabel();
        print_thePrintable_receipt = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Records = new javax.swing.JPanel();
        Records_View = new javax.swing.JPanel();
        all_records3 = new javax.swing.JLabel();
        lb_Title_holder1 = new javax.swing.JLabel();
        lb_Title_holder = new javax.swing.JLabel();
        all_records4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        all_records1 = new javax.swing.JLabel();
        all_records2 = new javax.swing.JLabel();
        all_records5 = new javax.swing.JLabel();
        all_records6 = new javax.swing.JLabel();
        all_records7 = new javax.swing.JLabel();
        all_records8 = new javax.swing.JLabel();
        all_records9 = new javax.swing.JLabel();
        all_records11 = new javax.swing.JLabel();
        all_records12 = new javax.swing.JLabel();
        all_records14 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        all_records15 = new javax.swing.JLabel();
        all_records16 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lb_PaymentSettings_btn = new javax.swing.JLabel();
        lb_GeneralSettings_btn = new javax.swing.JLabel();
        all_records = new javax.swing.JLabel();
        lb_FullPayments_btn = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        left_White_borderHide = new javax.swing.JPanel();
        Right_White_borderHide = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
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
        Payee_ExtraInfo = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        pDATE = new javax.swing.JLabel();
        pNAME = new javax.swing.JLabel();
        pID = new javax.swing.JLabel();
        Close_Extra = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(1350, 760));
        getContentPane().setLayout(new java.awt.CardLayout());

        payment_entry.setBackground(new Color(61,61,61,90));
        payment_entry.setMinimumSize(new java.awt.Dimension(1370, 760));
        payment_entry.setPreferredSize(new java.awt.Dimension(1370, 760));
        payment_entry.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                payment_entryMouseDragged(evt);
            }
        });
        payment_entry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                payment_entryMousePressed(evt);
            }
        });
        payment_entry.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Cashn.setBackground(new java.awt.Color(255, 255, 255));
        Cashn.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        Cashn.setLayout(new java.awt.CardLayout());

        HistoryPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        front.setBackground(new java.awt.Color(255, 255, 255));
        front.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_estimate_30px.png"))); // NOI18N
        jLabel21.setText("  Current Balance       ");
        front.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 430, 170, 40));

        PaidAmount.setBackground(new java.awt.Color(204, 204, 204));
        PaidAmount.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        PaidAmount.setForeground(new java.awt.Color(255, 255, 255));
        PaidAmount.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 3, 1, 1));
        front.add(PaidAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 350, 37));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_get_cash_30px.png"))); // NOI18N
        jLabel16.setText("  School fees of          ");
        front.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 220, 40));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_paper_money_30px.png"))); // NOI18N
        jLabel14.setText("   Amount Paid ");
        front.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 220, 40));

        Schoolfees.setBackground(new java.awt.Color(204, 204, 204));
        Schoolfees.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        Schoolfees.setForeground(new java.awt.Color(255, 255, 255));
        Schoolfees.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 3, 1, 1));
        Schoolfees.setEnabled(false);
        Schoolfees.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SchoolfeesKeyPressed(evt);
            }
        });
        front.add(Schoolfees, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 350, 37));

        Current_Balanec.setBackground(new java.awt.Color(204, 204, 204));
        Current_Balanec.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        Current_Balanec.setForeground(new java.awt.Color(255, 255, 255));
        Current_Balanec.setText("0000");
        Current_Balanec.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 3, 1, 1));
        front.add(Current_Balanec, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 430, 350, 37));

        txtFullName.setBackground(new java.awt.Color(204, 204, 204));
        txtFullName.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        txtFullName.setForeground(new java.awt.Color(255, 255, 255));
        txtFullName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 3, 1, 1));
        txtFullName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFullNameKeyPressed(evt);
            }
        });
        front.add(txtFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 350, 37));

        txtStudentGrade.setBackground(new java.awt.Color(204, 204, 204));
        txtStudentGrade.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        txtStudentGrade.setForeground(new java.awt.Color(255, 255, 255));
        txtStudentGrade.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 3, 1, 1));
        txtStudentGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentGradeActionPerformed(evt);
            }
        });
        front.add(txtStudentGrade, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 350, 37));

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_report_card_30px.png"))); // NOI18N
        jLabel23.setText("  Student Grade");
        front.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 160, 30));

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_people_30px.png"))); // NOI18N
        jLabel25.setText("  Payeer's Names ");
        front.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 160, 30));

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_name_tag_30px.png"))); // NOI18N
        jLabel27.setText("  Student ID");
        front.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 160, 30));

        PayeersName.setBackground(new java.awt.Color(204, 204, 204));
        PayeersName.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        PayeersName.setForeground(new java.awt.Color(255, 255, 255));
        PayeersName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 3, 1, 1));
        PayeersName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                PayeersNameKeyPressed(evt);
            }
        });
        front.add(PayeersName, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 350, 37));

        txtStudentId.setBackground(new java.awt.Color(204, 204, 204));
        txtStudentId.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        txtStudentId.setForeground(new java.awt.Color(255, 255, 255));
        txtStudentId.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 3, 1, 1));
        txtStudentId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtStudentIdKeyPressed(evt);
            }
        });
        front.add(txtStudentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 350, 37));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_american_express_30px.png"))); // NOI18N
        jLabel13.setText(" Name of the Bank   ");
        front.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 550, 180, 30));

        BankName.setBackground(new java.awt.Color(204, 204, 204));
        BankName.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        BankName.setForeground(new java.awt.Color(255, 255, 255));
        BankName.setText("None");
        BankName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 3, 1, 1));
        front.add(BankName, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 550, 350, 37));

        Chequenumber.setBackground(new java.awt.Color(204, 204, 204));
        Chequenumber.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        Chequenumber.setForeground(new java.awt.Color(255, 255, 255));
        Chequenumber.setText("0000");
        Chequenumber.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 3, 1, 1));
        front.add(Chequenumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 600, 350, 37));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_bounced_check_30px.png"))); // NOI18N
        jLabel12.setText("  Cheque Number       ");
        front.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 600, 190, 30));

        jLabel31.setBackground(new java.awt.Color(255, 255, 255));
        jLabel31.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(102, 102, 102));
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Pay_Date_30px.png"))); // NOI18N
        jLabel31.setText("  Date  fo Payment      ");
        front.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 650, 180, 30));

        jDateChooser3.setBackground(new java.awt.Color(204, 204, 204));
        front.add(jDateChooser3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 650, 260, 30));

        txtAmount_Tobe_Paid.setBackground(new java.awt.Color(204, 204, 204));
        txtAmount_Tobe_Paid.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        txtAmount_Tobe_Paid.setForeground(new java.awt.Color(255, 255, 255));
        txtAmount_Tobe_Paid.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 3, 1, 1));
        front.add(txtAmount_Tobe_Paid, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 490, 350, 37));

        jLabel34.setBackground(new java.awt.Color(255, 255, 255));
        jLabel34.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(102, 102, 102));
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/balance.png"))); // NOI18N
        jLabel34.setText("Amount To Paid");
        front.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, 170, 30));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_identification_documents_30px.png"))); // NOI18N
        jLabel15.setText("  Payeer's NRC/ID");
        front.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 160, 30));

        payeersID.setBackground(new java.awt.Color(204, 204, 204));
        payeersID.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        payeersID.setForeground(new java.awt.Color(255, 255, 255));
        payeersID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 3, 1, 1));
        payeersID.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        payeersID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                payeersIDKeyPressed(evt);
            }
        });
        front.add(payeersID, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 350, 37));

        jPanel4.setLayout(new java.awt.CardLayout());

        Search_by_fullStudent_name.setBackground(new java.awt.Color(255, 255, 255));
        Search_by_fullStudent_name.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        Search_by_fullStudent_name.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 570, 10));

        lb_ON_SearchBylastName.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lb_ON_SearchBylastName.setForeground(new java.awt.Color(255, 255, 255));
        lb_ON_SearchBylastName.setText("Enter Student Name");
        Search_by_fullStudent_name.add(lb_ON_SearchBylastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 200, 40));

        txt_SearchBy_Student_Fullname.setBackground(new java.awt.Color(153, 153, 153));
        txt_SearchBy_Student_Fullname.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txt_SearchBy_Student_Fullname.setForeground(new java.awt.Color(255, 255, 255));
        txt_SearchBy_Student_Fullname.setText("          ");
        txt_SearchBy_Student_Fullname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_SearchBy_Student_FullnameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_SearchBy_Student_FullnameMouseExited(evt);
            }
        });
        txt_SearchBy_Student_Fullname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_SearchBy_Student_FullnameKeyPressed(evt);
            }
        });
        Search_by_fullStudent_name.add(txt_SearchBy_Student_Fullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 370, 40));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        Search_by_fullStudent_name.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 570, 10));

        timeOf_payment.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        timeOf_payment.setForeground(new java.awt.Color(255, 255, 255));
        timeOf_payment.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "   Term One", "   Term Two", "   Term Three" }));
        timeOf_payment.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        timeOf_payment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Search_by_fullStudent_name.add(timeOf_payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 110, 60));

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("ID");
        jLabel24.setToolTipText("Press ID to Search By ID");
        jLabel24.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });
        jPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 50, 40));

        Search_by_fullStudent_name.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 140, 60));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_broom_25px.png"))); // NOI18N
        Search_by_fullStudent_name.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, 40));

        jPanel4.add(Search_by_fullStudent_name, "card6");

        Search_by_IDPanel.setBackground(new java.awt.Color(255, 255, 255));
        Search_by_IDPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        Search_by_IDPanel.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 650, -1));

        lb_ON_txtSearch_BY_id.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lb_ON_txtSearch_BY_id.setForeground(new java.awt.Color(102, 102, 102));
        lb_ON_txtSearch_BY_id.setText("      Search by Student ID ");
        Search_by_IDPanel.add(lb_ON_txtSearch_BY_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 200, 40));

        txtSearch_by_id.setBackground(new java.awt.Color(153, 153, 153));
        txtSearch_by_id.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        txtSearch_by_id.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 30, 1, 1));
        txtSearch_by_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearch_by_idKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearch_by_idKeyTyped(evt);
            }
        });
        Search_by_IDPanel.add(txtSearch_by_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 400, 40));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        Search_by_IDPanel.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 560, 20));

        jPanel11.setBackground(new java.awt.Color(153, 153, 153));

        jLabel28.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Name");
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        Search_by_IDPanel.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 150, 60));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        Search_by_IDPanel.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 630, 20));

        jPanel4.add(Search_by_IDPanel, "card2");

        Paymen_methodsPanel.setBackground(new java.awt.Color(255, 255, 255));
        Paymen_methodsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(204, 204, 204));
        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel10.setText("Payment methods");
        jPanel8.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 120, 40));

        cashBtn.setBackground(new java.awt.Color(204, 204, 204));
        cashBtn.setText("By Cash");
        cashBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cashBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashBtnActionPerformed(evt);
            }
        });
        jPanel8.add(cashBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 110, 40));

        chequeBtn.setBackground(new java.awt.Color(204, 204, 204));
        chequeBtn.setText("By Cheque");
        chequeBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        chequeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chequeBtnActionPerformed(evt);
            }
        });
        jPanel8.add(chequeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 120, 40));

        depostBtn.setBackground(new java.awt.Color(204, 204, 204));
        depostBtn.setText("By Depost");
        depostBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        depostBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depostBtnActionPerformed(evt);
            }
        });
        jPanel8.add(depostBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 110, 40));

        backTo_search.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        backTo_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/backtoSearch.png"))); // NOI18N
        backTo_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backTo_searchMouseClicked(evt);
            }
        });
        jPanel8.add(backTo_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        Paymen_methodsPanel.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 570, 40));

        jPanel4.add(Paymen_methodsPanel, "card4");

        Option_for_searchPanel.setBackground(new java.awt.Color(255, 255, 255));
        Option_for_searchPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_searchOn_Option.setBackground(new java.awt.Color(255, 255, 255));
        lb_searchOn_Option.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lb_searchOn_Option.setText("   Name or ID");
        Option_for_searchPanel.add(lb_searchOn_Option, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 130, 20));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        Option_for_searchPanel.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 580, 20));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        Option_for_searchPanel.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        txtSearchOption.setBackground(new java.awt.Color(153, 153, 153));
        txtSearchOption.setText("              ");
        txtSearchOption.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtSearchOption.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchOptionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchOptionKeyTyped(evt);
            }
        });
        Option_for_searchPanel.add(txtSearchOption, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 400, 60));

        jPanel4.add(Option_for_searchPanel, "card5");

        front.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -10, 640, 70));

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_businessman_30px.png"))); // NOI18N
        jLabel26.setText("  Student Name");
        front.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 220, 30));

        Save_payments.setBackground(new java.awt.Color(255, 255, 255));
        Save_payments.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        Save_payments.setText("Save");
        Save_payments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Save_paymentsActionPerformed(evt);
            }
        });
        front.add(Save_payments, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 650, 80, 30));

        HistoryPanel.add(front, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 720));

        Cashn.add(HistoryPanel, "card4");

        print_payment.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Cashn.add(print_payment, "card5");

        txtSurcesCurrent.setText("Resources for current balance");

        jLabel2.setText("Searching resources");

        javax.swing.GroupLayout ReSourcePanelLayout = new javax.swing.GroupLayout(ReSourcePanel);
        ReSourcePanel.setLayout(ReSourcePanelLayout);
        ReSourcePanelLayout.setHorizontalGroup(
            ReSourcePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReSourcePanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(ReSourcePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSurcesCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtResourceForDateFormatingINtoString, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(ReSourcePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtResourceForSearByName, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtResourceForSearById, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(114, 114, 114))
        );
        ReSourcePanelLayout.setVerticalGroup(
            ReSourcePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReSourcePanelLayout.createSequentialGroup()
                .addGroup(ReSourcePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ReSourcePanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(txtSurcesCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ReSourcePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtResourceForSearById, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(ReSourcePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ReSourcePanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtResourceForSearByName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ReSourcePanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(txtResourceForDateFormatingINtoString, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(608, Short.MAX_VALUE))
        );

        Cashn.add(ReSourcePanel, "card3");

        payment_entry.add(Cashn, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 610, 720));

        Student_info.setBackground(new java.awt.Color(255, 255, 255));
        Student_info.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Student_info.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 470, 10));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_clock_30px.png"))); // NOI18N
        Student_info.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 40, 30));
        Student_info.add(lb_imageIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 170, 120));

        jLabel29.setBackground(new java.awt.Color(255, 255, 255));
        jLabel29.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(102, 102, 102));
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_gender_30px.png"))); // NOI18N
        jLabel29.setText("  Student Gender");
        Student_info.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 150, 30));

        lb_printing_btn.setBackground(new java.awt.Color(255, 255, 255));
        lb_printing_btn.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lb_printing_btn.setForeground(new java.awt.Color(102, 102, 102));
        lb_printing_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_print_35px.png"))); // NOI18N
        lb_printing_btn.setText("  Print Receipt");
        lb_printing_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_printing_btnMouseClicked(evt);
            }
        });
        Student_info.add(lb_printing_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 160, 80));

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(102, 102, 102));
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Pay_Date_30px.png"))); // NOI18N
        jLabel32.setText("  Date  fo Birth      ");
        Student_info.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 180, 30));

        jLabel33.setBackground(new java.awt.Color(255, 255, 255));
        jLabel33.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(102, 102, 102));
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_health_calendar_30px.png"))); // NOI18N
        jLabel33.setText("  Student  Status");
        Student_info.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 200, 30));

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(102, 102, 102));
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_home_address_30px.png"))); // NOI18N
        jLabel35.setText("  physical adress");
        Student_info.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 180, 30));

        lb_gender.setBackground(new java.awt.Color(255, 255, 255));
        lb_gender.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lb_gender.setForeground(new java.awt.Color(102, 102, 102));
        lb_gender.setText("  Student Name");
        Student_info.add(lb_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 140, 30));

        jLabel37.setBackground(new java.awt.Color(255, 255, 255));
        jLabel37.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(102, 102, 102));
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_compare_heights_30px.png"))); // NOI18N
        jLabel37.setText("  Student Age");
        Student_info.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 150, 30));

        jLabel38.setBackground(new java.awt.Color(255, 255, 255));
        jLabel38.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(102, 102, 102));
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_businessman_30px.png"))); // NOI18N
        jLabel38.setText("  Student Name");
        Student_info.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 150, 30));

        lb_age.setBackground(new java.awt.Color(255, 255, 255));
        lb_age.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lb_age.setForeground(new java.awt.Color(102, 102, 102));
        lb_age.setText("  Student Name");
        Student_info.add(lb_age, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 140, 30));

        lb_date.setBackground(new java.awt.Color(255, 255, 255));
        lb_date.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lb_date.setForeground(new java.awt.Color(102, 102, 102));
        lb_date.setText("  Student Name");
        Student_info.add(lb_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 430, 230, 30));

        lb_name.setBackground(new java.awt.Color(255, 255, 255));
        lb_name.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lb_name.setForeground(new java.awt.Color(102, 102, 102));
        lb_name.setText("  Student Name");
        Student_info.add(lb_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 140, 30));

        lb_address.setBackground(new java.awt.Color(255, 255, 255));
        lb_address.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lb_address.setForeground(new java.awt.Color(102, 102, 102));
        lb_address.setText("  Student Name");
        Student_info.add(lb_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 230, 30));

        lb_status.setBackground(new java.awt.Color(255, 255, 255));
        lb_status.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lb_status.setForeground(new java.awt.Color(102, 102, 102));
        lb_status.setText("  Student Name");
        Student_info.add(lb_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 230, 30));

        lb_grade.setBackground(new java.awt.Color(255, 255, 255));
        lb_grade.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lb_grade.setForeground(new java.awt.Color(102, 102, 102));
        lb_grade.setText("  Student Name");
        Student_info.add(lb_grade, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 230, 30));

        jLabel92.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(153, 153, 153));
        jLabel92.setText("Payment History");
        jLabel92.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel92.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel92MouseClicked(evt);
            }
        });
        Student_info.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 140, 40));

        jLabel36.setBackground(new java.awt.Color(255, 255, 255));
        jLabel36.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(102, 102, 102));
        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_report_card_30px.png"))); // NOI18N
        jLabel36.setText("  Student Grade");
        Student_info.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 160, 30));

        payment_entry.add(Student_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 490, 720));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_delete_18px_1.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        payment_entry.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 0, 60, 60));

        getContentPane().add(payment_entry, "card2");

        Receipt.setBackground(new Color(255,255,255,10));
        Receipt.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        Receipt.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 180, 60, 30));

        CardsOf_receipt.setBackground(new java.awt.Color(153, 153, 153));
        CardsOf_receipt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(247, 247, 247), 1, true));
        CardsOf_receipt.setLayout(new java.awt.CardLayout());

        Rec_editable.setBackground(new java.awt.Color(153, 153, 153));
        Rec_editable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(247, 247, 247), 1, true));
        Rec_editable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Receipt_form1.setBackground(new java.awt.Color(255, 255, 255));
        Receipt_form1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        Receipt_form1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Receipt_form1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 970, 10));
        Receipt_form1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 970, 10));

        lb_schoollevel1.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        lb_schoollevel1.setForeground(new java.awt.Color(70, 116, 146));
        lb_schoollevel1.setText("PRE-SCHOOL");
        Receipt_form1.add(lb_schoollevel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 170, 20));

        lb_forSchool_name20.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lb_forSchool_name20.setForeground(new java.awt.Color(70, 116, 146));
        lb_forSchool_name20.setText("Duration  Of  Payment :");
        Receipt_form1.add(lb_forSchool_name20, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 170, 20));

        lb_forReceipt_number1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_forReceipt_number1.setForeground(new java.awt.Color(70, 116, 146));
        lb_forReceipt_number1.setText("# 2020001");
        Receipt_form1.add(lb_forReceipt_number1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 60, 20));

        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_forStudent_name8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_forStudent_name8.setForeground(new java.awt.Color(70, 116, 146));
        lb_forStudent_name8.setText("Luckson c  nonde");
        jPanel14.add(lb_forStudent_name8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 110, 20));

        lb_forDate6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_forDate6.setForeground(new java.awt.Color(70, 116, 146));
        lb_forDate6.setText("Student  Name  :");
        jPanel14.add(lb_forDate6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, -1));

        lb_forDate7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_forDate7.setForeground(new java.awt.Color(70, 116, 146));
        lb_forDate7.setText("Received From :");
        jPanel14.add(lb_forDate7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 110, 30));

        lb_forDate8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_forDate8.setForeground(new java.awt.Color(70, 116, 146));
        lb_forDate8.setText("Student Class   :");
        jPanel14.add(lb_forDate8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 110, 30));

        lb_forStudent_name9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_forStudent_name9.setForeground(new java.awt.Color(70, 116, 146));
        lb_forStudent_name9.setText("Amount  in words :");
        jPanel14.add(lb_forStudent_name9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 120, 20));

        lb_forDate_holddate10.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_forDate_holddate10.setForeground(new java.awt.Color(70, 116, 146));
        lb_forDate_holddate10.setText("Due date                        :");
        jPanel14.add(lb_forDate_holddate10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 120, 30));

        lb_forDate_holddate11.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_forDate_holddate11.setForeground(new java.awt.Color(70, 116, 146));
        lb_forDate_holddate11.setText("Issue date                 :");
        jPanel14.add(lb_forDate_holddate11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 30));

        lb_forDate_holddate12.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_forDate_holddate12.setForeground(new java.awt.Color(70, 116, 146));
        lb_forDate_holddate12.setText("September 23, 2021");
        jPanel14.add(lb_forDate_holddate12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 130, 30));

        lb_forDate_holddate13.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_forDate_holddate13.setForeground(new java.awt.Color(70, 116, 146));
        lb_forDate_holddate13.setText("K 200");
        jPanel14.add(lb_forDate_holddate13, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 130, 20));

        lb_forStudent_name10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_forStudent_name10.setForeground(new java.awt.Color(70, 116, 146));
        lb_forStudent_name10.setText("Elizabeth chansa");
        jPanel14.add(lb_forStudent_name10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 110, -1));

        lb_forStudent_name11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_forStudent_name11.setForeground(new java.awt.Color(70, 116, 146));
        lb_forStudent_name11.setText("Amount                :");
        jPanel14.add(lb_forStudent_name11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 130, 20));

        lb_forDate_holddate14.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_forDate_holddate14.setForeground(new java.awt.Color(70, 116, 146));
        lb_forDate_holddate14.setText("October 23, 2021");
        jPanel14.add(lb_forDate_holddate14, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 130, 20));

        lb_forStudent_name12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lb_forStudent_name12.setForeground(new java.awt.Color(70, 116, 146));
        lb_forStudent_name12.setText("7B");
        jPanel14.add(lb_forStudent_name12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 50, -1));
        jPanel14.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 260, -1));

        Receipt_form1.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 950, 120));

        lb_forReceipt_title2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_forReceipt_title2.setForeground(new java.awt.Color(70, 116, 146));
        lb_forReceipt_title2.setText("Receipt     :");
        Receipt_form1.add(lb_forReceipt_title2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 60, 20));

        lb_forDate_holddate16.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_forDate_holddate16.setForeground(new java.awt.Color(70, 116, 146));
        lb_forDate_holddate16.setText("September 23, 2021");
        Receipt_form1.add(lb_forDate_holddate16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 170, 20));

        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mark_deposite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_checkmark_20px.png"))); // NOI18N
        jPanel18.add(mark_deposite, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 0, 20, 30));

        lb_forDate9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_forDate9.setForeground(new java.awt.Color(70, 116, 146));
        lb_forDate9.setText("Paid By            :");
        jPanel18.add(lb_forDate9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 30));

        lb_forStudent_name13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_forStudent_name13.setForeground(new java.awt.Color(70, 116, 146));
        lb_forStudent_name13.setText("[]      (if)  Check # :  .............................");
        jPanel18.add(lb_forStudent_name13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 280, 30));

        lb_forStudent_name14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_forStudent_name14.setForeground(new java.awt.Color(70, 116, 146));
        lb_forStudent_name14.setText("  Deposite  []       (if)  Trans :  ........................");
        jPanel18.add(lb_forStudent_name14, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 260, 30));

        lb_forStudent_name15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_forStudent_name15.setForeground(new java.awt.Color(70, 116, 146));
        lb_forStudent_name15.setText("   Cash []");
        jPanel18.add(lb_forStudent_name15, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 70, 30));

        lb_forStudent_name16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_forStudent_name16.setForeground(new java.awt.Color(70, 116, 146));
        lb_forStudent_name16.setText("Cheque ");
        jPanel18.add(lb_forStudent_name16, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 60, 30));

        mark_Cheque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_checkmark_20px.png"))); // NOI18N
        jPanel18.add(mark_Cheque, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 30));

        Mark_cash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_checkmark_20px.png"))); // NOI18N
        jPanel18.add(Mark_cash, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 30, 30));

        Receipt_form1.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 950, 30));

        lb_school_name.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lb_school_name.setForeground(new java.awt.Color(70, 116, 146));
        lb_school_name.setText("The Programmer");
        Receipt_form1.add(lb_school_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 230, 40));

        lb_school_address.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lb_school_address.setForeground(new java.awt.Color(70, 116, 146));
        lb_school_address.setText("[name of recever ]");
        Receipt_form1.add(lb_school_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 130, 20));

        lb_forDate10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_forDate10.setForeground(new java.awt.Color(70, 116, 146));
        lb_forDate10.setText("Date :");
        Receipt_form1.add(lb_forDate10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 63, 40, -1));

        lb_forSchool_name23.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lb_forSchool_name23.setForeground(new java.awt.Color(70, 116, 146));
        lb_forSchool_name23.setText("For Payment Of    :   ");
        Receipt_form1.add(lb_forSchool_name23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 110, 20));

        lb_forSchool_name24.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lb_forSchool_name24.setForeground(new java.awt.Color(70, 116, 146));
        lb_forSchool_name24.setText("Signed By   : ..............................................................");
        Receipt_form1.add(lb_forSchool_name24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 270, 20));

        lb_forSchool_name25.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_forSchool_name25.setForeground(new java.awt.Color(70, 116, 146));
        lb_forSchool_name25.setText("Received By     :");
        Receipt_form1.add(lb_forSchool_name25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 100, 20));

        lb_recei.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lb_recei.setForeground(new java.awt.Color(70, 116, 146));
        lb_recei.setText("[name of recever ]");
        Receipt_form1.add(lb_recei, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 100, 20));

        lb_forSchool_name27.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lb_forSchool_name27.setForeground(new java.awt.Color(70, 116, 146));
        lb_forSchool_name27.setText("Tuition Fee :");
        Receipt_form1.add(lb_forSchool_name27, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 80, 20));

        lb_forschoolfee.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lb_forschoolfee.setForeground(new java.awt.Color(70, 116, 146));
        lb_forschoolfee.setText("k 0000");
        Receipt_form1.add(lb_forschoolfee, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, 110, 20));

        lb_forSchool_name31.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lb_forSchool_name31.setForeground(new java.awt.Color(70, 116, 146));
        lb_forSchool_name31.setText("Other            :");
        Receipt_form1.add(lb_forSchool_name31, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 80, 20));

        lb_forSchool_name33.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lb_forSchool_name33.setForeground(new java.awt.Color(70, 116, 146));
        lb_forSchool_name33.setText("Transport     :");
        Receipt_form1.add(lb_forSchool_name33, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 80, 20));

        lb_forSchool_name35.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lb_forSchool_name35.setForeground(new java.awt.Color(70, 116, 146));
        lb_forSchool_name35.setText("Total             :");
        Receipt_form1.add(lb_forSchool_name35, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 290, 80, 20));

        lb_forSchool_balance.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lb_forSchool_balance.setForeground(new java.awt.Color(70, 116, 146));
        lb_forSchool_balance.setText("K 0000");
        Receipt_form1.add(lb_forSchool_balance, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 320, 130, 20));

        lb_forSchool_name39.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_forSchool_name39.setForeground(new java.awt.Color(70, 116, 146));
        lb_forSchool_name39.setText("Addres       :");
        Receipt_form1.add(lb_forSchool_name39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 90, 20));
        Receipt_form1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 130, -1));

        lb_forDate_holddate18.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_forDate_holddate18.setForeground(new java.awt.Color(70, 116, 146));
        lb_forDate_holddate18.setText("ending date");
        Receipt_form1.add(lb_forDate_holddate18, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 220, -1, 20));
        Receipt_form1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 220, 110, 20));

        lb_forDate_holddate19.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_forDate_holddate19.setForeground(new java.awt.Color(70, 116, 146));
        lb_forDate_holddate19.setText("Starting date");
        Receipt_form1.add(lb_forDate_holddate19, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 220, -1, 20));
        Receipt_form1.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 220, 120, 20));
        Receipt_form1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 150, -1));
        Receipt_form1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 130, -1));
        Receipt_form1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 320, 130, -1));
        Receipt_form1.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 290, 130, -1));

        lb_forSchool_name29.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lb_forSchool_name29.setForeground(new java.awt.Color(70, 116, 146));
        lb_forSchool_name29.setText("Fines            :");
        Receipt_form1.add(lb_forSchool_name29, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, 80, 20));

        lb_forSchool_name38.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lb_forSchool_name38.setForeground(new java.awt.Color(70, 116, 146));
        lb_forSchool_name38.setText("Balance Due:");
        Receipt_form1.add(lb_forSchool_name38, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 320, 80, 20));

        Rec_editable.add(Receipt_form1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 971, 380));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/balance.png"))); // NOI18N
        jLabel6.setText("Process");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        Rec_editable.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 320, 90, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_home_25px.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        Rec_editable.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 0, 70, 50));

        CardsOf_receipt.add(Rec_editable, "card2");

        Receipt_printable.setBackground(new java.awt.Color(153, 153, 153));
        Receipt_printable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(247, 247, 247), 1, true));
        Receipt_printable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Receipt_form.setBackground(new java.awt.Color(255, 255, 255));
        Receipt_form.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        Receipt_form.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Receipt_form.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 970, 10));
        Receipt_form.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 970, 10));

        lb_schoollevel.setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        lb_schoollevel.setForeground(new java.awt.Color(70, 116, 146));
        lb_schoollevel.setText("PRE-SCHOOL");
        Receipt_form.add(lb_schoollevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 170, 20));

        lb_forSchool_name.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lb_forSchool_name.setForeground(new java.awt.Color(70, 116, 146));
        lb_forSchool_name.setText("During Payment Of  Payment :");
        Receipt_form.add(lb_forSchool_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, 200, 30));

        lb_forReceipt_number.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_forReceipt_number.setForeground(new java.awt.Color(70, 116, 146));
        lb_forReceipt_number.setText("# 2020001");
        Receipt_form.add(lb_forReceipt_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 60, 30));

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_forStudent_name.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_forStudent_name.setForeground(new java.awt.Color(70, 116, 146));
        lb_forStudent_name.setText("Luckson c  nonde");
        jPanel6.add(lb_forStudent_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 110, 20));

        lb_forDate3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_forDate3.setForeground(new java.awt.Color(70, 116, 146));
        lb_forDate3.setText("Student Name  :");
        jPanel6.add(lb_forDate3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, -1));

        lb_forDate4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_forDate4.setForeground(new java.awt.Color(70, 116, 146));
        lb_forDate4.setText("Received From :");
        jPanel6.add(lb_forDate4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 110, 30));

        lb_forDate5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_forDate5.setForeground(new java.awt.Color(70, 116, 146));
        lb_forDate5.setText("Student Class   :");
        jPanel6.add(lb_forDate5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 110, 30));

        lb_forStudent_name2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_forStudent_name2.setForeground(new java.awt.Color(70, 116, 146));
        lb_forStudent_name2.setText("Amount  in words :");
        jPanel6.add(lb_forStudent_name2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 120, 20));

        lb_forDate_holddate2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_forDate_holddate2.setForeground(new java.awt.Color(70, 116, 146));
        lb_forDate_holddate2.setText("Due date                        :");
        jPanel6.add(lb_forDate_holddate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 120, 20));

        lb_forDate_holddate4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_forDate_holddate4.setForeground(new java.awt.Color(70, 116, 146));
        lb_forDate_holddate4.setText("Issue date                 :");
        jPanel6.add(lb_forDate_holddate4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 30));

        lb_forDate_holddate5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_forDate_holddate5.setForeground(new java.awt.Color(70, 116, 146));
        lb_forDate_holddate5.setText("September 23, 2021");
        jPanel6.add(lb_forDate_holddate5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 130, 30));

        lb_forDate_holddate6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_forDate_holddate6.setForeground(new java.awt.Color(70, 116, 146));
        lb_forDate_holddate6.setText("K 200");
        jPanel6.add(lb_forDate_holddate6, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 130, 20));

        lb_forStudent_name3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_forStudent_name3.setForeground(new java.awt.Color(70, 116, 146));
        lb_forStudent_name3.setText("Elizabeth chansa");
        jPanel6.add(lb_forStudent_name3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 110, -1));

        lb_forStudent_name4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_forStudent_name4.setForeground(new java.awt.Color(70, 116, 146));
        lb_forStudent_name4.setText("Amount                :");
        jPanel6.add(lb_forStudent_name4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 7, 130, 20));

        lb_forDate_holddate7.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_forDate_holddate7.setForeground(new java.awt.Color(70, 116, 146));
        lb_forDate_holddate7.setText("October 23, 2021");
        jPanel6.add(lb_forDate_holddate7, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 90, 130, 20));

        lb_forDate_holddate9.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_forDate_holddate9.setForeground(new java.awt.Color(70, 116, 146));
        lb_forDate_holddate9.setText("Two hundred kwach only");
        jPanel6.add(lb_forDate_holddate9, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 130, 20));

        lb_forStudent_name5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lb_forStudent_name5.setForeground(new java.awt.Color(70, 116, 146));
        lb_forStudent_name5.setText("7B");
        jPanel6.add(lb_forStudent_name5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 50, -1));

        Receipt_form.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 950, 120));

        lb_forReceipt_title1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_forReceipt_title1.setForeground(new java.awt.Color(70, 116, 146));
        lb_forReceipt_title1.setText("Receipt     :");
        Receipt_form.add(lb_forReceipt_title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 60, 30));

        lb_forDate_holddate3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_forDate_holddate3.setForeground(new java.awt.Color(70, 116, 146));
        lb_forDate_holddate3.setText("September 23, 2021");
        Receipt_form.add(lb_forDate_holddate3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 130, 30));

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_forDate1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_forDate1.setForeground(new java.awt.Color(70, 116, 146));
        lb_forDate1.setText("Paid By            :");
        jPanel7.add(lb_forDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 30));

        lb_forStudent_name1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_forStudent_name1.setForeground(new java.awt.Color(70, 116, 146));
        lb_forStudent_name1.setText("Check [ ]   (if)  Check # :  .............................");
        jPanel7.add(lb_forStudent_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 290, 30));

        lb_forStudent_name6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_forStudent_name6.setForeground(new java.awt.Color(70, 116, 146));
        lb_forStudent_name6.setText("  Deposit  [ ]  (if)  Trans :  ......................");
        jPanel7.add(lb_forStudent_name6, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 260, 30));

        lb_forStudent_name7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_forStudent_name7.setForeground(new java.awt.Color(70, 116, 146));
        lb_forStudent_name7.setText("   Cash [ ]");
        jPanel7.add(lb_forStudent_name7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 70, 30));

        Receipt_form.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 950, 30));

        lb_forSchool_name1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lb_forSchool_name1.setForeground(new java.awt.Color(70, 116, 146));
        lb_forSchool_name1.setText("The Programmer");
        Receipt_form.add(lb_forSchool_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 230, 40));

        lb_forSchool_name2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lb_forSchool_name2.setForeground(new java.awt.Color(70, 116, 146));
        lb_forSchool_name2.setText("[name of recever ]");
        Receipt_form.add(lb_forSchool_name2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 100, 20));

        lb_forDate_holddate8.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lb_forDate_holddate8.setForeground(new java.awt.Color(70, 116, 146));
        lb_forDate_holddate8.setText("From [starting date] To [end date]");
        Receipt_form.add(lb_forDate_holddate8, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 210, -1, 30));

        lb_forDate2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_forDate2.setForeground(new java.awt.Color(70, 116, 146));
        lb_forDate2.setText("Date :");
        Receipt_form.add(lb_forDate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 40, 30));

        lb_forSchool_name3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lb_forSchool_name3.setForeground(new java.awt.Color(70, 116, 146));
        lb_forSchool_name3.setText("For Payment Of    :   [Purpose of payment]");
        Receipt_form.add(lb_forSchool_name3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 260, 30));

        lb_forSchool_name4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lb_forSchool_name4.setForeground(new java.awt.Color(70, 116, 146));
        lb_forSchool_name4.setText("Signed By   : ..............................................................");
        Receipt_form.add(lb_forSchool_name4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 270, 20));

        lb_forSchool_name5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_forSchool_name5.setForeground(new java.awt.Color(70, 116, 146));
        lb_forSchool_name5.setText("Received By     :");
        Receipt_form.add(lb_forSchool_name5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 100, 20));

        lb_forSchool_name6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lb_forSchool_name6.setForeground(new java.awt.Color(70, 116, 146));
        lb_forSchool_name6.setText("[name of recever ]");
        Receipt_form.add(lb_forSchool_name6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 100, 20));

        lb_forSchool_name7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lb_forSchool_name7.setForeground(new java.awt.Color(70, 116, 146));
        lb_forSchool_name7.setText("Tuition Fee :");
        Receipt_form.add(lb_forSchool_name7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, 80, 20));

        lb_forSchool_name8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lb_forSchool_name8.setForeground(new java.awt.Color(70, 116, 146));
        lb_forSchool_name8.setText("Fines            :");
        Receipt_form.add(lb_forSchool_name8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, 80, 20));

        lb_forSchool_name9.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lb_forSchool_name9.setForeground(new java.awt.Color(70, 116, 146));
        lb_forSchool_name9.setText("[name of recever ]");
        Receipt_form.add(lb_forSchool_name9, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 310, 100, 20));

        lb_forSchool_name10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lb_forSchool_name10.setForeground(new java.awt.Color(70, 116, 146));
        lb_forSchool_name10.setText("[name of recever ]");
        Receipt_form.add(lb_forSchool_name10, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 280, 100, 20));

        lb_forSchool_name11.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lb_forSchool_name11.setForeground(new java.awt.Color(70, 116, 146));
        lb_forSchool_name11.setText("Other            :");
        Receipt_form.add(lb_forSchool_name11, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 80, 20));

        lb_forSchool_name12.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lb_forSchool_name12.setForeground(new java.awt.Color(70, 116, 146));
        lb_forSchool_name12.setText("[name of recever ]");
        Receipt_form.add(lb_forSchool_name12, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, 100, 20));

        lb_forSchool_name13.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lb_forSchool_name13.setForeground(new java.awt.Color(70, 116, 146));
        lb_forSchool_name13.setText("Transport     :");
        Receipt_form.add(lb_forSchool_name13, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 80, 20));

        lb_forSchool_name14.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lb_forSchool_name14.setForeground(new java.awt.Color(70, 116, 146));
        lb_forSchool_name14.setText("[name of recever ]");
        Receipt_form.add(lb_forSchool_name14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, 100, 20));

        lb_forSchool_name15.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lb_forSchool_name15.setForeground(new java.awt.Color(70, 116, 146));
        lb_forSchool_name15.setText("Total             :");
        Receipt_form.add(lb_forSchool_name15, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 280, 80, 20));

        lb_forSchool_name16.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lb_forSchool_name16.setForeground(new java.awt.Color(70, 116, 146));
        lb_forSchool_name16.setText("[name of recever ]");
        Receipt_form.add(lb_forSchool_name16, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 280, 100, 20));

        lb_forSchool_name17.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lb_forSchool_name17.setForeground(new java.awt.Color(70, 116, 146));
        lb_forSchool_name17.setText("Balance Due:");
        Receipt_form.add(lb_forSchool_name17, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 310, 80, 20));

        lb_forSchool_name18.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        lb_forSchool_name18.setForeground(new java.awt.Color(70, 116, 146));
        lb_forSchool_name18.setText("[name of recever ]");
        Receipt_form.add(lb_forSchool_name18, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 310, 100, 20));

        lb_forSchool_name19.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lb_forSchool_name19.setForeground(new java.awt.Color(70, 116, 146));
        lb_forSchool_name19.setText("Address           :");
        Receipt_form.add(lb_forSchool_name19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 100, 20));

        Receipt_printable.add(Receipt_form, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 971, 380));

        print_thePrintable_receipt.setBackground(new java.awt.Color(0, 0, 0));
        print_thePrintable_receipt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        print_thePrintable_receipt.setForeground(new java.awt.Color(102, 102, 102));
        print_thePrintable_receipt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/balance.png"))); // NOI18N
        print_thePrintable_receipt.setText(" Print ");
        print_thePrintable_receipt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                print_thePrintable_receiptMouseClicked(evt);
            }
        });
        Receipt_printable.add(print_thePrintable_receipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 350, 80, 30));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_faq_30px.png"))); // NOI18N
        jLabel7.setText(" Back");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        Receipt_printable.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 280, -1, 40));

        CardsOf_receipt.add(Receipt_printable, "card3");

        Receipt.add(CardsOf_receipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 1150, 400));

        getContentPane().add(Receipt, "card4");

        Records.setMinimumSize(new java.awt.Dimension(1370, 760));
        Records.setPreferredSize(new java.awt.Dimension(1370, 760));
        Records.setLayout(new java.awt.CardLayout());

        Records_View.setBackground(new java.awt.Color(252, 252, 252));
        Records_View.setMinimumSize(new java.awt.Dimension(1350, 760));
        Records_View.setPreferredSize(new java.awt.Dimension(1350, 760));
        Records_View.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        all_records3.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        all_records3.setForeground(new java.awt.Color(102, 102, 102));
        all_records3.setText("Name");
        all_records3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                all_records3MouseClicked(evt);
            }
        });
        Records_View.add(all_records3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 60, 50));

        lb_Title_holder1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lb_Title_holder1.setForeground(new java.awt.Color(102, 102, 102));
        lb_Title_holder1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_Title_holder1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_google_web_search_35px.png"))); // NOI18N
        lb_Title_holder1.setText("   Fiter");
        lb_Title_holder1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_Title_holder1MouseClicked(evt);
            }
        });
        Records_View.add(lb_Title_holder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 120, 50));

        lb_Title_holder.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lb_Title_holder.setForeground(new java.awt.Color(102, 102, 102));
        lb_Title_holder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_Title_holder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Search_15px.png"))); // NOI18N
        lb_Title_holder.setText("   Fiter");
        lb_Title_holder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lb_Title_holderMouseEntered(evt);
            }
        });
        Records_View.add(lb_Title_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 10, 120, 50));

        all_records4.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        all_records4.setForeground(new java.awt.Color(102, 102, 102));
        all_records4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        all_records4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        all_records4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                all_records4MouseClicked(evt);
            }
        });
        Records_View.add(all_records4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, -10, 230, 80));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        all_records1.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        all_records1.setForeground(new java.awt.Color(102, 102, 102));
        all_records1.setText("To Be Paid");
        jPanel1.add(all_records1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 10, -1, 40));

        all_records2.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        all_records2.setForeground(new java.awt.Color(102, 102, 102));
        all_records2.setText(" Student ID");
        jPanel1.add(all_records2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 40));

        all_records5.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        all_records5.setForeground(new java.awt.Color(102, 102, 102));
        all_records5.setText("Amount Paid");
        jPanel1.add(all_records5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, 40));

        all_records6.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        all_records6.setForeground(new java.awt.Color(102, 102, 102));
        all_records6.setText("Bank Name");
        jPanel1.add(all_records6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 80, 40));

        all_records7.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        all_records7.setForeground(new java.awt.Color(102, 102, 102));
        all_records7.setText("Cheque #");
        jPanel1.add(all_records7, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, -1, 40));

        all_records8.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        all_records8.setForeground(new java.awt.Color(102, 102, 102));
        all_records8.setText("Payment Date");
        jPanel1.add(all_records8, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, -1, 40));

        all_records9.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        all_records9.setForeground(new java.awt.Color(102, 102, 102));
        all_records9.setText("Payment ");
        jPanel1.add(all_records9, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, -1, 40));

        all_records11.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        all_records11.setForeground(new java.awt.Color(102, 102, 102));
        all_records11.setText("Balance");
        jPanel1.add(all_records11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, -1, 40));

        all_records12.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        all_records12.setForeground(new java.awt.Color(102, 102, 102));
        all_records12.setText("Term");
        jPanel1.add(all_records12, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 10, 60, 40));

        all_records14.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        all_records14.setForeground(new java.awt.Color(102, 102, 102));
        all_records14.setText("Grade");
        jPanel1.add(all_records14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 10, 60, 40));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 42, 1290, 30));

        all_records15.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        all_records15.setForeground(new java.awt.Color(102, 102, 102));
        all_records15.setText("   Fees");
        jPanel1.add(all_records15, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 70, 40));

        all_records16.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        all_records16.setForeground(new java.awt.Color(102, 102, 102));
        all_records16.setText("Name");
        jPanel1.add(all_records16, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 10, 40, 40));

        Records_View.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 1450, 50));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_delete_25px.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        Records_View.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 10, 60, 60));

        lb_PaymentSettings_btn.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        lb_PaymentSettings_btn.setForeground(new java.awt.Color(255, 255, 255));
        lb_PaymentSettings_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_direction_30px.png"))); // NOI18N
        lb_PaymentSettings_btn.setText("With Balance");
        lb_PaymentSettings_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_PaymentSettings_btnMouseClicked(evt);
            }
        });
        Records_View.add(lb_PaymentSettings_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, -1, 70));

        lb_GeneralSettings_btn.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        lb_GeneralSettings_btn.setForeground(new java.awt.Color(255, 255, 255));
        lb_GeneralSettings_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_direction_30px.png"))); // NOI18N
        lb_GeneralSettings_btn.setText("New Records ");
        lb_GeneralSettings_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_GeneralSettings_btnMouseClicked(evt);
            }
        });
        Records_View.add(lb_GeneralSettings_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 130, 70));

        all_records.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        all_records.setForeground(new java.awt.Color(102, 102, 102));
        all_records.setText("All Records");
        all_records.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                all_recordsMouseClicked(evt);
            }
        });
        Records_View.add(all_records, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 50));

        lb_FullPayments_btn.setFont(new java.awt.Font("Trebuchet MS", 0, 16)); // NOI18N
        lb_FullPayments_btn.setForeground(new java.awt.Color(255, 255, 255));
        lb_FullPayments_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_direction_30px.png"))); // NOI18N
        lb_FullPayments_btn.setText("Full Payments");
        lb_FullPayments_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb_FullPayments_btnMouseClicked(evt);
            }
        });
        Records_View.add(lb_FullPayments_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, -1, 70));

        txtSearch.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        Records_View.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 20, 250, 30));

        left_White_borderHide.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout left_White_borderHideLayout = new javax.swing.GroupLayout(left_White_borderHide);
        left_White_borderHide.setLayout(left_White_borderHideLayout);
        left_White_borderHideLayout.setHorizontalGroup(
            left_White_borderHideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        left_White_borderHideLayout.setVerticalGroup(
            left_White_borderHideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 670, Short.MAX_VALUE)
        );

        Records_View.add(left_White_borderHide, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 140, 70, 670));

        Right_White_borderHide.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout Right_White_borderHideLayout = new javax.swing.GroupLayout(Right_White_borderHide);
        Right_White_borderHide.setLayout(Right_White_borderHideLayout);
        Right_White_borderHideLayout.setHorizontalGroup(
            Right_White_borderHideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
        );
        Right_White_borderHideLayout.setVerticalGroup(
            Right_White_borderHideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );

        Records_View.add(Right_White_borderHide, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 130, 130, 660));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1320, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        Records_View.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 770, -1, 40));

        tables_panel.setLayout(new java.awt.CardLayout());

        All_Records_table.setBackground(new java.awt.Color(255, 255, 255));
        All_Records_table.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_allRecords.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 6));
        table_allRecords.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        table_allRecords.setForeground(new java.awt.Color(153, 153, 153));
        table_allRecords.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_allRecords.setIntercellSpacing(new java.awt.Dimension(5, 5));
        table_allRecords.setRowHeight(25);
        table_allRecords.setShowVerticalLines(false);
        table_allRecords.setTableHeader(null);
        table_allRecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_allRecordsMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(table_allRecords);

        All_Records_table.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 1310, 660));

        tables_panel.add(All_Records_table, "card2");

        ByClass_table1.setBackground(new java.awt.Color(255, 255, 255));
        ByClass_table1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_class.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 6));
        table_class.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        ByClass_table1.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 1340, 700));

        tables_panel.add(ByClass_table1, "card3");

        full_paymenttable2.setBackground(new java.awt.Color(255, 255, 255));
        full_paymenttable2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        full_payment_table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 6));
        full_payment_table.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        full_paymenttable2.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 1410, 700));

        tables_panel.add(full_paymenttable2, "card4");

        New_Recordstable.setBackground(new java.awt.Color(255, 255, 255));
        New_Recordstable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NewRecords_table.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 6));
        NewRecords_table.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        New_Recordstable.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 1230, 700));

        tables_panel.add(New_Recordstable, "card4");

        With_Balancetable.setBackground(new java.awt.Color(255, 255, 255));
        With_Balancetable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        with_balanceTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 6));
        with_balanceTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        With_Balancetable.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 1280, 700));

        tables_panel.add(With_Balancetable, "card4");

        Search_byName.setBackground(new java.awt.Color(255, 255, 255));
        Search_byName.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Table_searchName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Table_searchName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Table_searchName.setForeground(new java.awt.Color(102, 102, 102));
        Table_searchName.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Table_searchName.setIntercellSpacing(new java.awt.Dimension(5, 5));
        Table_searchName.setRowHeight(25);
        Table_searchName.setShowVerticalLines(false);
        Table_searchName.setTableHeader(null);
        jScrollPane13.setViewportView(Table_searchName);

        Search_byName.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 1320, 630));

        tables_panel.add(Search_byName, "card4");

        Records_View.add(tables_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 1370, 670));

        main_BG.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        main_BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/hBG.png"))); // NOI18N
        Records_View.add(main_BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, -10, 1610, 820));

        Records.add(Records_View, "card6");

        Payee_ExtraInfo.setBackground(new Color(255,255,255,1));
        Payee_ExtraInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Payee's     ID");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Payee's     Name");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 120, 30));

        pDATE.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pDATE.setForeground(new java.awt.Color(204, 204, 204));
        pDATE.setText("2020 /02 /12");
        jPanel3.add(pDATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 170, 30));

        pNAME.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pNAME.setForeground(new java.awt.Color(102, 102, 102));
        pNAME.setText("jLabel19");
        jPanel3.add(pNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 250, 30));

        pID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pID.setForeground(new java.awt.Color(102, 102, 102));
        pID.setText("jLabel19");
        jPanel3.add(pID, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 250, 30));

        Payee_ExtraInfo.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 0, 410, 122));

        Close_Extra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Close_ExtraMouseClicked(evt);
            }
        });
        Payee_ExtraInfo.add(Close_Extra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 120));

        Records.add(Payee_ExtraInfo, "card5");

        getContentPane().add(Records, "card4");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SchoolfeesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SchoolfeesKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            PaidAmount.requestFocus();

        }
    }//GEN-LAST:event_SchoolfeesKeyPressed

    private void txtFullNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFullNameKeyPressed
        //short search using name

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Schoolfees.requestFocus();

        }
    }//GEN-LAST:event_txtFullNameKeyPressed

    private void txtStudentGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentGradeActionPerformed
       
    }//GEN-LAST:event_txtStudentGradeActionPerformed

    private void PayeersNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PayeersNameKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtStudentId.requestFocus();
        }
    }//GEN-LAST:event_PayeersNameKeyPressed

    private void txtStudentIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStudentIdKeyPressed
      
    }//GEN-LAST:event_txtStudentIdKeyPressed

    private void payeersIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_payeersIDKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            PayeersName.requestFocus();
        }
    }//GEN-LAST:event_payeersIDKeyPressed

    private void txt_SearchBy_Student_FullnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchBy_Student_FullnameKeyPressed
  
          if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
          try {
                String fullname = txt_SearchBy_Student_Fullname.getText().trim();
                conn = DBConnection.getConnction();
                pps4 = conn.prepareStatement("SELECT * FROM   schoolfee  WHERE   Full_Name = ?");
                pps4.setString(1, fullname);
                rs4 = pps4.executeQuery();
                
                if (rs4.next()) {
                   Student_personalInfo();
                    txtStudentGrade.setText(rs4.getString("Student_Class"));
                   
                     String ReminedBalance = rs4.getString("Remaining_balance");
                     balance = Integer.parseInt(ReminedBalance);

                     txtSurcesCurrent.setText(ReminedBalance.trim());
                    
                    
                     String fee =    Schoolfees.getText().trim();
                     fees = Integer.parseInt(fee);

                     amountToBePaid = fees + balance;
                     txtAmount_Tobe_Paid.setText(Integer.toString(amountToBePaid));
                    
                    String studId = rs4.getString("Student_Id");
                    txtStudentId.setText(studId.trim());
                    String studfName = rs4.getString("full_name");
                    txtFullName.setText(studfName.trim());
                    payeersID.requestFocus();
                    Student_info.setVisible(true);
                    
                    Search_by_fullStudent_name.hide();
                    Option_for_searchPanel.hide();
                    Search_by_IDPanel.hide();
                    Paymen_methodsPanel.hide();
                    Paymen_methodsPanel.setVisible(true);

                   

                } else {
                    JOptionPane.showMessageDialog(this, "No Payments Records Found");
                    search_forStudentFrom_studentList();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Payments.class.getName()).log(Level.SEVERE, null, ex);
            }
        } //key events
       
      
    }//GEN-LAST:event_txt_SearchBy_Student_FullnameKeyPressed
 
    public void Student_personalInfo() {
        try {
            conn = DBConnection.getConnction();
            pps6 = conn.prepareStatement("SELECT *  FROM students WHERE Full_Name = ?");
            pps6.setString(1, txt_SearchBy_Student_Fullname.getText().trim());
            rs6 = pps6.executeQuery();

            byte[] image = null;
            while (rs6.next()) {

                lb_name.setText(rs6.getString("Full_Name"));
                lb_age.setText(rs6.getString("Student_Age"));
                lb_gender.setText(rs6.getString("Student_Gender"));
                lb_grade.setText(rs6.getString("Student_Class"));
                
                grade = rs6.getString("Student_Class");
                
                lb_status.setText(rs6.getString("Health_Status"));
                lb_address.setText(rs6.getString("physical_adress"));
                lb_date.setText(rs6.getString("Date"));

                image = rs6.getBytes("image");
                Image img = Toolkit.getDefaultToolkit().createImage(image);
                ImageIcon icon = new ImageIcon(img);
                lb_imageIcon.setIcon(icon);
                
                 EvaluatingPrice();

            }

        } catch (Exception ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void EvaluatingPrice(){
             //GETTING THE STUDENTS GRADE AND COMPARING IT TO THE PRICE-GRADE RENGE TO GET THEIR SCHOOL 
           
        if(grade.equals("None")){
          Schoolfees.setText("Assign Class To This Student");

        }else{
        
            CharSequence gradeAlone = grade.subSequence(0, 2);
            int  converted_gradeAlone = Integer.parseInt((String) gradeAlone);
            try {
           conn = DBConnection.getConnction();

            pps7 = conn.prepareStatement("SELECT  * FROM  price_settings WHERE  renge_end >= ?");
            pps7.setInt(1, converted_gradeAlone);
            rs7 = pps7.executeQuery();
            if (rs7.next()) {
              Schoolfees.setText(rs7.getString("fees"));
            }else{
             Schoolfees.setText("No Fees For This Grade");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
    public void search_forStudentFrom_studentList() {//****************************************************************searching for student by name in the student list 
        try {
            conn = DBConnection.getConnction();
            pps5 = conn.prepareStatement("SELECT * FROM   students  WHERE   Full_Name = ?");
            pps5.setString(1, txt_SearchBy_Student_Fullname.getText().trim());
            rs5 = pps5.executeQuery();
            byte[] image = null;
            if (rs5.next()) {
                
                Student_info.setVisible(true); //student info set to visiable
                txtStudentGrade.setText(rs5.getString("Student_Class"));
                txtStudentId.setText(rs5.getString("Student_ID"));
                txtFullName.setText(rs5.getString("Full_Name"));

                image = rs5.getBytes("image");
                Image img = Toolkit.getDefaultToolkit().createImage(image);
                ImageIcon icon = new ImageIcon(img);
                lb_imageIcon.setIcon(icon);
                Schoolfees.requestFocus();
               Student_personalInfo();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Payments.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        Search_by_fullStudent_name.hide();
        Option_for_searchPanel.hide();
        Search_by_IDPanel.setVisible(true);
        Paymen_methodsPanel.hide();
        Paymen_methodsPanel.hide();

    }//GEN-LAST:event_jLabel24MouseClicked

    private void txtSearch_by_idKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch_by_idKeyPressed
        // TO display  information of a student from db using one text field id
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                String Student_Search_ByID = txtSearch_by_id.getText().toString().trim();
                conn = DBConnection.getConnction();

                pps4 = conn.prepareStatement("SELECT Student_Grade ,full_name,Remaining_balance, Student_ID FROM  cashpay  WHERE  Student_ID = ? AND Date =(SELECT max(Date) FROM cashpay)");
                pps4.setString(1, Student_Search_ByID);
                rs4 = pps4.executeQuery();
                if (rs4.next()) {
                    String studgrade = rs4.getString("Student_Grade");
                    txtStudentGrade.setText(studgrade.trim());
                    String ReminedBalance = rs4.getString("Remaining_balance");

                    txtSurcesCurrent.setText(ReminedBalance.trim());
                    txtAmount_Tobe_Paid.setText(ReminedBalance.trim());

                    String studfName = rs4.getString(2);
                    txtFullName.setText(studfName.trim());

                    String studlName = rs4.getString("Student_ID");
                    txtStudentId.setText(studlName.trim());
                    Schoolfees.requestFocus();

                } else {
                    JOptionPane.showMessageDialog(this, "No Payments Records Found");
                    try { ///------------------------------------------------------searching for a studeent in registration table
                        String StudentId3 = txtSearch_by_id.getText();
                        conn = DBConnection.getConnction();
                        pps4 = conn.prepareStatement(" SELECT Student_Class ,full_name,Student_ID  FROM users WHERE Student_ID = ?");
                        pps4.setString(1, StudentId3);

                        rs4 = pps4.executeQuery();
                        if (rs4.next() == false) {

                            JOptionPane.showMessageDialog(this, "Student not Registered");

                        //    Registered.getObj().setVisible(true);
                         //   this.hide();
                        } else {

                            String studgrade = rs4.getString("Student_Class");
                            txtStudentGrade.setText(studgrade.trim());

                            String studfName = rs4.getString("full_name");
                            txtFullName.setText(studfName.trim());

                            // String studlName = rs4.getString(3);
                            // txtLastName.setText(studlName.trim());
                            String myStudent_id = rs4.getString("Student_ID");
                            txtStudentId.setText(myStudent_id.trim());

                            Schoolfees.requestFocus();

                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(Payments.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            } catch (SQLException ex) {
                Logger.getLogger(Payments.class.getName()).log(Level.SEVERE, null, ex);
            }
            Search_by_fullStudent_name.hide();
            Option_for_searchPanel.hide();
            Search_by_IDPanel.hide();
            Paymen_methodsPanel.hide();
            Paymen_methodsPanel.setVisible(true);
        }
    }//GEN-LAST:event_txtSearch_by_idKeyPressed

    private void txtSearch_by_idKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearch_by_idKeyTyped
        if (txtSearch_by_id.getText().length() <= 0) {
            lb_ON_txtSearch_BY_id.setForeground(new Color(51, 51, 51));
        } else if (txtSearch_by_id.getText().length() >= 1) {
            lb_ON_txtSearch_BY_id.setForeground(new Color(255, 255, 255, 1));
        }
    }//GEN-LAST:event_txtSearch_by_idKeyTyped

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        Option_for_searchPanel.hide();
        Search_by_IDPanel.hide();
        Paymen_methodsPanel.hide();
        Paymen_methodsPanel.hide();
        Search_by_fullStudent_name.setVisible(true);
    }//GEN-LAST:event_jLabel28MouseClicked

    private void cashBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashBtnActionPerformed
        PaymentType = "Cash";
        cashBtn.setSelected(true);
        chequeBtn.setSelected(false);
        depostBtn.setSelected(false);

        String mySearch = txtSearchOption.getText().toString().toUpperCase().trim();
        txtSearch_by_id.requestFocus();

        if (mySearch.equals("ID")) {
            Option_for_searchPanel.hide();
            //when radio btn is seleted on the payment methods, it hide and show the search text
            Paymen_methodsPanel.hide();
            Search_by_fullStudent_name.hide();
            Search_by_IDPanel.setVisible(true);

        } else if (mySearch.equals("NAME")) {
            Option_for_searchPanel.hide();
            Search_by_IDPanel.hide();
            Paymen_methodsPanel.hide();
            Search_by_fullStudent_name.setVisible(true);
        }

        if (evt.getSource() == cashBtn) {

            payeersID.setEditable(true);
            PayeersName.setEditable(true);
            txtStudentId.setEditable(true);
            txtStudentGrade.setEditable(true);
            txtFullName.setEditable(true);
            Schoolfees.setEditable(true);
            PaidAmount.setEditable(true);
            Current_Balanec.setEditable(true);
            BankName.setEditable(false);
            Chequenumber.setEditable(false);
            txtAmount_Tobe_Paid.setEditable(false);
            jDateChooser3.setEnabled(true);

        }
    }//GEN-LAST:event_cashBtnActionPerformed

    private void chequeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chequeBtnActionPerformed
        cashBtn.setSelected(false);
        chequeBtn.setSelected(true);
        depostBtn.setSelected(false);
        PaymentType = "Cheque";

        String mySearch = txtSearchOption.getText().toString().toUpperCase().trim();

        if (mySearch.equals("ID")) {
            Option_for_searchPanel.hide();
            //when radio btn is seleted on the payment methods, it hide and show the search text
            Paymen_methodsPanel.hide();
            Search_by_fullStudent_name.hide();
            Search_by_IDPanel.setVisible(true);

        } else if (mySearch.equals("NAME")) {
            Option_for_searchPanel.hide();
            Search_by_IDPanel.hide();
            Paymen_methodsPanel.hide();
            Search_by_fullStudent_name.setVisible(true);
        }

        if (evt.getSource() == chequeBtn) {
            payeersID.setEditable(true);
            PayeersName.setEditable(true);
            txtStudentId.setEditable(true);
            txtStudentGrade.setEditable(true);
            txtFullName.setEditable(true);
            Schoolfees.setEditable(true);
            PaidAmount.setEditable(true);
            Current_Balanec.setEditable(true);
            BankName.setEditable(true);
            Chequenumber.setEditable(true);
            txtAmount_Tobe_Paid.setEditable(false);
            jDateChooser3.setEnabled(true);

        }
    }//GEN-LAST:event_chequeBtnActionPerformed

    private void depostBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depostBtnActionPerformed
        PaymentType = "Depost";
        cashBtn.setSelected(false);
        chequeBtn.setSelected(false);
        depostBtn.setSelected(true);

        String mySearch = txtSearchOption.getText().toString().toUpperCase().trim();

        if (mySearch.equals("ID")) {
            Option_for_searchPanel.hide();
            Search_by_fullStudent_name.hide();
            //when radio btn is seleted on the payment methods, it hide and show the search text
            Paymen_methodsPanel.hide();
            Search_by_IDPanel.setVisible(true);

        } else if (mySearch.equals("NAME")) {
            Option_for_searchPanel.hide();
            Search_by_IDPanel.hide();
            Paymen_methodsPanel.hide();
            Search_by_fullStudent_name.setVisible(true);
        }

        if (evt.getSource() == depostBtn) {
            payeersID.setEditable(true);
            PayeersName.setEditable(true);
            txtStudentId.setEditable(true);
            txtStudentGrade.setEditable(true);
            txtFullName.setEditable(true);
            Schoolfees.setEditable(true);
            PaidAmount.setEditable(true);
            Current_Balanec.setEditable(true);
            BankName.setEditable(true);
            Chequenumber.setEditable(true);
            txtAmount_Tobe_Paid.setEditable(false);
            jDateChooser3.setEnabled(true);
        }
    }//GEN-LAST:event_depostBtnActionPerformed

    private void txtSearchOptionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchOptionKeyPressed
        String mySearch = txtSearchOption.getText().toString().toUpperCase().trim();

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            if (mySearch.equals("ID")) {
                Option_for_searchPanel.hide();
                Paymen_methodsPanel.setVisible(true);
                Search_by_IDPanel.hide();

            } else if (mySearch.equals("NAME")) {
                Option_for_searchPanel.hide();
                Search_by_IDPanel.hide();
                Paymen_methodsPanel.setVisible(true);
            }

        }
    }//GEN-LAST:event_txtSearchOptionKeyPressed

    private void txtSearchOptionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchOptionKeyTyped
        if (txtSearchOption.getText().length() <= 0) {
            lb_searchOn_Option.setForeground(new Color(51, 51, 51));

        } else if (txtSearchOption.getText().length() >= 1) {
            lb_searchOn_Option.setForeground(new Color(255, 255, 255, 1));
        }
    }//GEN-LAST:event_txtSearchOptionKeyTyped

    private void Save_paymentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Save_paymentsActionPerformed

        if (txtAmount_Tobe_Paid.getText().isEmpty()) {

            String schoolfees = Schoolfees.getText().trim();//the amount entered by the school as school fees
            Var_FeeCharged = Integer.parseInt(schoolfees);

            String paidAmount = PaidAmount.getText().trim();//the amount paid by the student
            var_AmountPaid = Integer.parseInt(paidAmount);

            sum = Var_FeeCharged - var_AmountPaid;
            Current_Balanec.setText(Integer.toString(sum));//deducting amount paid from school fees and putting it on the txtCurrent balance

        }else if (!txtAmount_Tobe_Paid.getText().isEmpty()) {

             String amounttobepaid = txtAmount_Tobe_Paid.getText().trim();// balance on the textfild checking if the student has balance in the data base
        int    tobePaid = Integer.parseInt(amounttobepaid); 
            
            
            String paidAmount = PaidAmount.getText().trim();
           int   amountp = Integer.parseInt(paidAmount);  //amount paid to the school
            
            
            sum1 =   tobePaid - amountp;
            Current_Balanec.setText(Integer.toString(sum1));//deducting amount paid -  Previous Balance and putting it on the amout paid

        }  //IF CURRENT BALANCE IS EMPT CLOSING

        String dateSelected = ((JTextField) jDateChooser3.getDateEditor().getUiComponent()).getText();//conveting date to string then putting it on a resource
        txtResourceForDateFormatingINtoString.setText(dateSelected);

        if (txtResourceForDateFormatingINtoString.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Date of payment required !");
            jDateChooser3.requestFocus();
        } else {
            String FindId = txtStudentId.getText();  //checking if we have a payment made or not
            try {
                conn = DBConnection.getConnction();
                pps = conn.prepareStatement("SELECT * FROM schoolfee WHERE Student_ID = ? ");
                pps.setString(1, FindId);
                rs = pps.executeQuery();
                if (rs.next()) {  //
                    ifRecords_Exist(); //updating the payment
                } else {
                    ifRecords_Doesnt_Exist(); //inserting new records

                }
            } catch (SQLException ex) {
                Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);
            }
            //making payment history
            copyingRecords();
        }
    }//GEN-LAST:event_Save_paymentsActionPerformed

    public void copyingRecords() {
        String FindId = txtStudentId.getText().trim();  //checking if we have a payment made or not
        try {
            conn = DBConnection.getConnction();
            String sql = "INSERT INTO  fee_history (Student_Id,Full_name,School_feesOf, Amount_Paid,Remaining_balance,BanK_name,Cheque_number,Date,PaymentType,Term,Student_Class,AmountTo_Be_Paid,payername,PayeerID)  SELECT Student_Id,Full_name,School_feesOf, Amount_Paid,Remaining_balance,BanK_name,Cheque_number,Date,PaymentType,Term,Student_Class,AmountTo_Be_Paid,payername,PayeerID FROM schoolfee WHERE Student_ID = ? ";
            pps = conn.prepareStatement(sql);
            pps.setString(1, FindId);
            pps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void ifRecords_Exist() {

        String schoolfees_Dedicated = Schoolfees.getText().trim();//the amount entered by the school as school fees

        String paidAmountDedicated = PaidAmount.getText().trim();
        String Id = txtStudentId.getText().trim();
        try {
            conn = DBConnection.getConnction();
            String sql = " UPDATE  schoolfee SET Student_ID = ?,Full_Name  = ?,School_feesOf  = ?,Amount_Paid  = ?,Remaining_balance  = ?,BanK_name  = ? ,  Cheque_number  = ?,Date  = ?,PaymentType  = ?,Term  = ?,Student_Class  = ?,AmountTo_Be_Paid  = ? , payername =?, PayeerID =? WHERE Student_Id =?";
            pps = conn.prepareStatement(sql);
            pps.setString(1, txtStudentId.getText());
            pps.setString(2, txtFullName.getText());
            pps.setString(3, schoolfees_Dedicated);
            pps.setString(4, paidAmountDedicated);
            pps.setString(5, Current_Balanec.getText());
            pps.setString(6, BankName.getText());
            pps.setString(7, Chequenumber.getText());
            pps.setString(8, txtResourceForDateFormatingINtoString.getText().toString().trim());
            pps.setString(9, PaymentType);
            pps.setString(10, timeOf_payment.getSelectedItem().toString().trim());
            pps.setString(11, txtStudentGrade.getText());
            pps.setString(12, txtAmount_Tobe_Paid.getText());
            pps.setString(13, PayeersName.getText());
            pps.setString(14, payeersID.getText());
            pps.setString(15, Id);

            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Payment made");
            lb_printing_btn.setVisible(true);

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void ifRecords_Doesnt_Exist() {
        String schoolfees_Dedicated = Schoolfees.getText().trim();//the amount entered by the school as school fees

        String paidAmountDedicated = PaidAmount.getText().trim();

        try {
            conn = DBConnection.getConnction();
            String sql = " INSERT INTO schoolfee (full_name,Student_Id ,School_feesOf,Amount_Paid ,Remaining_balance,BanK_name,Cheque_number, Date,PaymentType,Term,Student_Class,AmountTo_Be_Paid,payername,PayeerID ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pps = conn.prepareStatement(sql);
            pps.setString(1, txtFullName.getText());
            pps.setString(2, txtStudentId.getText());
            pps.setString(3, schoolfees_Dedicated);
            pps.setString(4, paidAmountDedicated);
            pps.setString(5, Current_Balanec.getText());
            pps.setString(6, BankName.getText());
            pps.setString(7, Chequenumber.getText());
            pps.setString(8, txtResourceForDateFormatingINtoString.getText().toString().trim());
            pps.setString(9, PaymentType);
            pps.setString(10, timeOf_payment.getSelectedItem().toString().trim());
            pps.setString(11, txtStudentGrade.getText());

            pps.setString(12, txtAmount_Tobe_Paid.getText());
            pps.setString(13, PayeersName.getText());
            pps.setString(14, payeersID.getText());
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Payment made");
            lb_printing_btn.setVisible(true);

            pps.close();
            conn.close();

        } catch (Exception e) {
            System.err.println(e);
        }
    }


    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void lb_PaymentSettings_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_PaymentSettings_btnMouseClicked
        ByClass_table1.setVisible(false);
        New_Recordstable.setVisible(false);
        All_Records_table.setVisible(false);
        full_paymenttable2.setVisible(false);
        With_Balancetable.setVisible(true);
        Search_byName.setVisible(false);

        try {
            conn = DBConnection.getConnction();
            String sql = "SELECT Student_Id,Full_name,School_feesOf, Amount_Paid,Remaining_balance,BanK_name,Cheque_number,Date,PaymentType,Term,Student_Class,AmountTo_Be_Paid,payername,PayeerID  FROM fee_history WHERE  School_feesOf != Amount_Paid  AND Student_Id =?";
            pps = conn.prepareStatement(sql);
            pps.setString(1, txtStudentId.getText().trim());
            rs = pps.executeQuery();
            with_balanceTable.setModel(DbUtils.resultSetToTableModel(rs));//sho
        } catch (SQLException ex) {
            Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_lb_PaymentSettings_btnMouseClicked

    private void lb_GeneralSettings_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_GeneralSettings_btnMouseClicked
        With_Balancetable.setVisible(false);
        All_Records_table.setVisible(false);
        ByClass_table1.setVisible(false);
        full_paymenttable2.setVisible(false);
        New_Recordstable.setVisible(true);
        Search_byName.setVisible(false);

        try {
            conn = DBConnection.getConnction();
            String sql = "SELECT Student_Id,Full_name,School_feesOf, Amount_Paid,Remaining_balance,BanK_name,Cheque_number,Date,PaymentType,Term,Student_Class,AmountTo_Be_Paid,payername,PayeerID  FROM fee_history WHERE Student_Id =? ORDER  BY date DESC LIMIT  1 ";
            pps = conn.prepareStatement(sql);
            pps.setString(1, txtStudentId.getText().trim());
            rs = pps.executeQuery();
            NewRecords_table.setModel(DbUtils.resultSetToTableModel(rs));//sho
        } catch (SQLException ex) {
            Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_lb_GeneralSettings_btnMouseClicked

    private void all_recordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_all_recordsMouseClicked
        With_Balancetable.setVisible(false);
        ByClass_table1.setVisible(false);
        full_paymenttable2.setVisible(false);
        New_Recordstable.setVisible(false);
        Search_byName.setVisible(false);
        All_Records_table.setVisible(true);
        
        
        try {
            conn = DBConnection.getConnction();
            String sql = "SELECT Student_Id,Full_name,School_feesOf, Amount_Paid,Remaining_balance,BanK_name,Cheque_number,Date,PaymentType,Term,Student_Class,AmountTo_Be_Paid  FROM fee_history  WHERE Full_name = ?";
            pps = conn.prepareStatement(sql);
            pps.setString(1, lb_name.getText().trim());
            rs = pps.executeQuery();
            table_allRecords.setModel(DbUtils.resultSetToTableModel(rs));//sho
        } catch (SQLException ex) {
            Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_all_recordsMouseClicked

    private void all_records3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_all_records3MouseClicked
       Records_View.hide();
        Payee_ExtraInfo.setVisible(true);
        DefaultTableModel tableModes = (DefaultTableModel) table_allRecords.getModel();
        String studentid = tableModes.getValueAt(table_allRecords.getSelectedRow(), 0).toString();

         DefaultTableModel tableModes1 = (DefaultTableModel) table_allRecords.getModel();
         String Term = tableModes.getValueAt(table_allRecords.getSelectedRow(), 10).toString();
 
        try {
            conn = DBConnection.getConnction();
            String sql = "SELECT * FROM fee_history  WHERE Student_Id =? AND Term =?";
            pps = conn.prepareStatement(sql);
            pps.setString(1, studentid);
           pps.setString(2, Term);

            rs = pps.executeQuery();
            if(rs.next()){
            pNAME.setText(rs.getString("payername"));
             pID.setText(rs.getString("PayeerID"));
             pDATE.setText(rs.getString("Date"));
            
            
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }//GEN-LAST:event_all_records3MouseClicked

    private void all_records4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_all_records4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_all_records4MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.dispose();

    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel92MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel92MouseClicked
        Records.setVisible(true);
        payment_entry.hide();

        With_Balancetable.setVisible(false);
        All_Records_table.setVisible(false);
        ByClass_table1.setVisible(false);
        full_paymenttable2.setVisible(false);
        New_Recordstable.setVisible(false);
        Search_byName.setVisible(true);

        try {
            conn = DBConnection.getConnction();
            String sql = "SELECT Student_Id,Full_name,School_feesOf, Amount_Paid,Remaining_balance,BanK_name,Cheque_number,Date,PaymentType,Term,Student_Class,AmountTo_Be_Paid  FROM fee_history  WHERE Full_name = ?";
            pps = conn.prepareStatement(sql);
            pps.setString(1, lb_name.getText().trim());
            rs = pps.executeQuery();
            Table_searchName.setModel(DbUtils.resultSetToTableModel(rs));//sho
        } catch (SQLException ex) {
            Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jLabel92MouseClicked

    private void lb_FullPayments_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_FullPayments_btnMouseClicked
        With_Balancetable.setVisible(false);
        ByClass_table1.setVisible(false);
        New_Recordstable.setVisible(false);
        Search_byName.setVisible(false);
        All_Records_table.setVisible(false);
        Search_byName.setVisible(false);
        full_paymenttable2.setVisible(true);

        try {
            conn = DBConnection.getConnction();
            String sql = "SELECT Student_Id,Full_name,School_feesOf, Amount_Paid,Remaining_balance,BanK_name,Cheque_number,Date,PaymentType,Term,Student_Class,AmountTo_Be_Paid  FROM fee_history WHERE  School_feesOf <= Amount_Paid AND  Student_Id =?";
            pps = conn.prepareStatement(sql);
            pps.setString(1, txtStudentId.getText().trim());

            rs = pps.executeQuery();
            full_payment_table.setModel(DbUtils.resultSetToTableModel(rs));//sho
        } catch (SQLException ex) {
            Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_lb_FullPayments_btnMouseClicked

    private void lb_Title_holderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_Title_holderMouseEntered
        lb_Title_holder.hide();
    }//GEN-LAST:event_lb_Title_holderMouseEntered

    private void lb_Title_holder1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_Title_holder1MouseClicked
        lb_GeneralSettings_btn.setVisible(true);
        lb_FullPayments_btn.setVisible(true);
        lb_PaymentSettings_btn.setVisible(true);
        txtSearch.setVisible(true);
        lb_Title_holder.setVisible(true);
    }//GEN-LAST:event_lb_Title_holder1MouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased

        if (All_Records_table.isShowing()) {
            DefaultTableModel table = (DefaultTableModel) table_allRecords.getModel();
            String search = txtSearch.getText().toLowerCase();
            TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
            tr.setRowFilter(RowFilter.regexFilter(search));
            table_allRecords.setRowSorter(tr);

        } else if (full_paymenttable2.isShowing()) {
            DefaultTableModel table = (DefaultTableModel) full_payment_table.getModel();
            String search = txtSearch.getText().toLowerCase();
            TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
            tr.setRowFilter(RowFilter.regexFilter(search));
            full_payment_table.setRowSorter(tr);

        } else if (With_Balancetable.isShowing()) {
            DefaultTableModel table = (DefaultTableModel) with_balanceTable.getModel();
            String search = txtSearch.getText().toLowerCase();
            TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
            tr.setRowFilter(RowFilter.regexFilter(search));
            with_balanceTable.setRowSorter(tr);

        } else if (New_Recordstable.isShowing()) {
            DefaultTableModel table = (DefaultTableModel) NewRecords_table.getModel();
            String search = txtSearch.getText().toLowerCase();
            TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
            tr.setRowFilter(RowFilter.regexFilter(search));
            NewRecords_table.setRowSorter(tr);

        } else if (ByClass_table1.isShowing()) {
            DefaultTableModel table = (DefaultTableModel) table_class.getModel();
            String search = txtSearch.getText().toLowerCase();
            TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
            tr.setRowFilter(RowFilter.regexFilter(search));
            table_class.setRowSorter(tr);

        }

    }//GEN-LAST:event_txtSearchKeyReleased

    private void txt_SearchBy_Student_FullnameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_SearchBy_Student_FullnameMouseEntered
        lb_ON_SearchBylastName.hide();
    }//GEN-LAST:event_txt_SearchBy_Student_FullnameMouseEntered

    private void txt_SearchBy_Student_FullnameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_SearchBy_Student_FullnameMouseExited
      
        if(txt_SearchBy_Student_Fullname.getText().isEmpty()){
                lb_ON_SearchBylastName.setVisible(true);

        }else{
                    lb_ON_SearchBylastName.hide();

    }
        
    }//GEN-LAST:event_txt_SearchBy_Student_FullnameMouseExited

    public void print(boolean prompt) {
        PrinterJob printJob = PrinterJob.getPrinterJob();
        PageFormat format = printJob.defaultPage();
        Paper paper = format.getPaper();
        paper.setImageableArea(18, 0, 180, 840);// Paper format for receipt printer
        format.setPaper(paper);
        printJob.setPrintable((Printable) this, format);
        if (!prompt || printJob.printDialog()) {
            try {
                printJob.print();
            } catch (PrinterException pe) {
                // SimpleLogger.variable("Error printing: " + pe);
            }
        }
    }


    private void lb_printing_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb_printing_btnMouseClicked

        lb_forStudent_name8.setText(txtFullName.getText().trim());
        lb_forStudent_name10.setText(PayeersName.getText().trim());
        lb_forStudent_name12.setText(txtStudentGrade.getText());

        String dateSelected = ((JTextField) jDateChooser3.getDateEditor().getUiComponent()).getText();//conveting date to string then putting it on a resource
        lb_forDate_holddate12.setText(dateSelected);

        lb_forDate_holddate13.setText(PaidAmount.getText());
        lb_forschoolfee.setText(Schoolfees.getText());
        lb_forSchool_balance.setText(Current_Balanec.getText());
        if (PaymentType.equals("Cash")) {

            Mark_cash.setVisible(true);

        } else if (PaymentType.equals("Cheque")) {

            mark_Cheque.setVisible(true);

        }
        if (PaymentType.equals("Depost")) {

            mark_deposite.setVisible(true);
        }
        
         try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("SELECT * FROM school_settings");
            rs = pps.executeQuery();
            if (rs.next()) {
                lb_school_name.setText(rs.getString("school_name"));
               lb_school_address.setText(rs.getString("school_address"));

            }

        } catch (Exception ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);  
        }
        
        Receipt.setVisible(true);
        payment_entry.hide();
        Records.hide();
    }//GEN-LAST:event_lb_printing_btnMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        Rec_editable.hide();
        Receipt_printable.setVisible(true);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void print_thePrintable_receiptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_print_thePrintable_receiptMouseClicked
        //printing the panel with its content
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Print Receipt");

        job.setPrintable(new Printable() {
            public int print(Graphics pg, PageFormat pf, int PageNum) {
                pf.setOrientation(PageFormat.LANDSCAPE);
                if (PageNum > 0) {
                    return Printable.NO_SUCH_PAGE;
                }
                java.awt.Graphics2D g2 = (java.awt.Graphics2D) pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.63, 0.80);
                Receipt_form.print(g2);

                return Printable.PAGE_EXISTS;
            }
        });

        boolean ok = job.printDialog();
        if (ok) {

            try {
                job.print();
            } catch (PrinterException ex) {
            }

        }
    }//GEN-LAST:event_print_thePrintable_receiptMouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        Rec_editable.setVisible(true);
        Receipt_printable.hide();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        Receipt.hide();
        payment_entry.setVisible(true);
        Records.hide();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void table_allRecordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_allRecordsMouseClicked
        Records_View.hide();
        Payee_ExtraInfo.setVisible(true);
    }//GEN-LAST:event_table_allRecordsMouseClicked

    private void Close_ExtraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Close_ExtraMouseClicked
        Payee_ExtraInfo.hide();
        Records_View.setVisible(true);

    }//GEN-LAST:event_Close_ExtraMouseClicked

    private void backTo_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backTo_searchMouseClicked
         Search_by_IDPanel.hide();
         Paymen_methodsPanel.hide();
         Option_for_searchPanel.hide();
         txt_SearchBy_Student_Fullname.setText(null);
         Search_by_fullStudent_name.setVisible(true);
    }//GEN-LAST:event_backTo_searchMouseClicked

    private void payment_entryMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_payment_entryMouseDragged
      /*   int x=evt.getXOnScreen();
         int y=evt.getYOnScreen();
         this.setLocation(x-xx, y-yy);*/
    }//GEN-LAST:event_payment_entryMouseDragged

    private void payment_entryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_payment_entryMousePressed
          xx = evt.getX();
          yy = evt.getY();
    }//GEN-LAST:event_payment_entryMousePressed

  
    public static Payments getObj() {  //public method for instance Restriction
        if (Obj == null) {
            Obj = new Payments();
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
            java.util.logging.Logger.getLogger(Payments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Payments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Payments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Payments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Payments().setVisible(true);
            }
        });
    }
    private String PaymentType;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel All_Records_table;
    private javax.swing.JTextField BankName;
    private javax.swing.JPanel ByClass_table1;
    private javax.swing.JPanel CardsOf_receipt;
    private javax.swing.JPanel Cashn;
    private javax.swing.JTextField Chequenumber;
    private javax.swing.JLabel Close_Extra;
    private javax.swing.JTextField Current_Balanec;
    private javax.swing.JPanel HistoryPanel;
    private javax.swing.JLabel Mark_cash;
    private javax.swing.JTable NewRecords_table;
    private javax.swing.JPanel New_Recordstable;
    private javax.swing.JPanel Option_for_searchPanel;
    private javax.swing.JTextField PaidAmount;
    private javax.swing.JPanel Payee_ExtraInfo;
    private javax.swing.JTextField PayeersName;
    private javax.swing.JPanel Paymen_methodsPanel;
    private javax.swing.JPanel ReSourcePanel;
    private javax.swing.JPanel Rec_editable;
    private javax.swing.JPanel Receipt;
    private javax.swing.JPanel Receipt_form;
    private javax.swing.JPanel Receipt_form1;
    private javax.swing.JPanel Receipt_printable;
    private javax.swing.JPanel Records;
    private javax.swing.JPanel Records_View;
    private javax.swing.JPanel Right_White_borderHide;
    private javax.swing.JButton Save_payments;
    private javax.swing.JTextField Schoolfees;
    private javax.swing.JPanel Search_byName;
    private javax.swing.JPanel Search_by_IDPanel;
    private javax.swing.JPanel Search_by_fullStudent_name;
    private javax.swing.JPanel Student_info;
    private javax.swing.JTable Table_searchName;
    private javax.swing.JTextField TxtResourceForSearById;
    private javax.swing.JTextField TxtResourceForSearByName;
    private javax.swing.JPanel With_Balancetable;
    private javax.swing.JLabel all_records;
    private javax.swing.JLabel all_records1;
    private javax.swing.JLabel all_records11;
    private javax.swing.JLabel all_records12;
    private javax.swing.JLabel all_records14;
    private javax.swing.JLabel all_records15;
    private javax.swing.JLabel all_records16;
    private javax.swing.JLabel all_records2;
    private javax.swing.JLabel all_records3;
    private javax.swing.JLabel all_records4;
    private javax.swing.JLabel all_records5;
    private javax.swing.JLabel all_records6;
    private javax.swing.JLabel all_records7;
    private javax.swing.JLabel all_records8;
    private javax.swing.JLabel all_records9;
    private javax.swing.JLabel backTo_search;
    private javax.swing.JRadioButton cashBtn;
    private javax.swing.JRadioButton chequeBtn;
    private javax.swing.JRadioButton depostBtn;
    private javax.swing.JPanel front;
    private javax.swing.JTable full_payment_table;
    private javax.swing.JPanel full_paymenttable2;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JLabel lb_FullPayments_btn;
    private javax.swing.JLabel lb_GeneralSettings_btn;
    private javax.swing.JLabel lb_ON_SearchBylastName;
    private javax.swing.JLabel lb_ON_txtSearch_BY_id;
    private javax.swing.JLabel lb_PaymentSettings_btn;
    private javax.swing.JLabel lb_Title_holder;
    private javax.swing.JLabel lb_Title_holder1;
    private javax.swing.JLabel lb_address;
    private javax.swing.JLabel lb_age;
    private javax.swing.JLabel lb_date;
    private javax.swing.JLabel lb_forDate1;
    private javax.swing.JLabel lb_forDate10;
    private javax.swing.JLabel lb_forDate2;
    private javax.swing.JLabel lb_forDate3;
    private javax.swing.JLabel lb_forDate4;
    private javax.swing.JLabel lb_forDate5;
    private javax.swing.JLabel lb_forDate6;
    private javax.swing.JLabel lb_forDate7;
    private javax.swing.JLabel lb_forDate8;
    private javax.swing.JLabel lb_forDate9;
    private javax.swing.JLabel lb_forDate_holddate10;
    private javax.swing.JLabel lb_forDate_holddate11;
    private javax.swing.JLabel lb_forDate_holddate12;
    private javax.swing.JLabel lb_forDate_holddate13;
    private javax.swing.JLabel lb_forDate_holddate14;
    private javax.swing.JLabel lb_forDate_holddate16;
    private javax.swing.JLabel lb_forDate_holddate18;
    private javax.swing.JLabel lb_forDate_holddate19;
    private javax.swing.JLabel lb_forDate_holddate2;
    private javax.swing.JLabel lb_forDate_holddate3;
    private javax.swing.JLabel lb_forDate_holddate4;
    private javax.swing.JLabel lb_forDate_holddate5;
    private javax.swing.JLabel lb_forDate_holddate6;
    private javax.swing.JLabel lb_forDate_holddate7;
    private javax.swing.JLabel lb_forDate_holddate8;
    private javax.swing.JLabel lb_forDate_holddate9;
    private javax.swing.JLabel lb_forReceipt_number;
    private javax.swing.JLabel lb_forReceipt_number1;
    private javax.swing.JLabel lb_forReceipt_title1;
    private javax.swing.JLabel lb_forReceipt_title2;
    private javax.swing.JLabel lb_forSchool_balance;
    private javax.swing.JLabel lb_forSchool_name;
    private javax.swing.JLabel lb_forSchool_name1;
    private javax.swing.JLabel lb_forSchool_name10;
    private javax.swing.JLabel lb_forSchool_name11;
    private javax.swing.JLabel lb_forSchool_name12;
    private javax.swing.JLabel lb_forSchool_name13;
    private javax.swing.JLabel lb_forSchool_name14;
    private javax.swing.JLabel lb_forSchool_name15;
    private javax.swing.JLabel lb_forSchool_name16;
    private javax.swing.JLabel lb_forSchool_name17;
    private javax.swing.JLabel lb_forSchool_name18;
    private javax.swing.JLabel lb_forSchool_name19;
    private javax.swing.JLabel lb_forSchool_name2;
    private javax.swing.JLabel lb_forSchool_name20;
    private javax.swing.JLabel lb_forSchool_name23;
    private javax.swing.JLabel lb_forSchool_name24;
    private javax.swing.JLabel lb_forSchool_name25;
    private javax.swing.JLabel lb_forSchool_name27;
    private javax.swing.JLabel lb_forSchool_name29;
    private javax.swing.JLabel lb_forSchool_name3;
    private javax.swing.JLabel lb_forSchool_name31;
    private javax.swing.JLabel lb_forSchool_name33;
    private javax.swing.JLabel lb_forSchool_name35;
    private javax.swing.JLabel lb_forSchool_name38;
    private javax.swing.JLabel lb_forSchool_name39;
    private javax.swing.JLabel lb_forSchool_name4;
    private javax.swing.JLabel lb_forSchool_name5;
    private javax.swing.JLabel lb_forSchool_name6;
    private javax.swing.JLabel lb_forSchool_name7;
    private javax.swing.JLabel lb_forSchool_name8;
    private javax.swing.JLabel lb_forSchool_name9;
    private javax.swing.JLabel lb_forStudent_name;
    private javax.swing.JLabel lb_forStudent_name1;
    private javax.swing.JLabel lb_forStudent_name10;
    private javax.swing.JLabel lb_forStudent_name11;
    private javax.swing.JLabel lb_forStudent_name12;
    private javax.swing.JLabel lb_forStudent_name13;
    private javax.swing.JLabel lb_forStudent_name14;
    private javax.swing.JLabel lb_forStudent_name15;
    private javax.swing.JLabel lb_forStudent_name16;
    private javax.swing.JLabel lb_forStudent_name2;
    private javax.swing.JLabel lb_forStudent_name3;
    private javax.swing.JLabel lb_forStudent_name4;
    private javax.swing.JLabel lb_forStudent_name5;
    private javax.swing.JLabel lb_forStudent_name6;
    private javax.swing.JLabel lb_forStudent_name7;
    private javax.swing.JLabel lb_forStudent_name8;
    private javax.swing.JLabel lb_forStudent_name9;
    private javax.swing.JLabel lb_forschoolfee;
    private javax.swing.JLabel lb_gender;
    private javax.swing.JLabel lb_grade;
    private javax.swing.JLabel lb_imageIcon;
    private javax.swing.JLabel lb_name;
    private javax.swing.JLabel lb_printing_btn;
    private javax.swing.JLabel lb_recei;
    private javax.swing.JLabel lb_school_address;
    private javax.swing.JLabel lb_school_name;
    private javax.swing.JLabel lb_schoollevel;
    private javax.swing.JLabel lb_schoollevel1;
    private javax.swing.JLabel lb_searchOn_Option;
    private javax.swing.JLabel lb_status;
    private javax.swing.JPanel left_White_borderHide;
    private javax.swing.JLabel main_BG;
    private javax.swing.JLabel mark_Cheque;
    private javax.swing.JLabel mark_deposite;
    private javax.swing.JLabel pDATE;
    private javax.swing.JLabel pID;
    private javax.swing.JLabel pNAME;
    private javax.swing.JTextField payeersID;
    private javax.swing.JPanel payment_entry;
    private javax.swing.JPanel print_payment;
    private javax.swing.JLabel print_thePrintable_receipt;
    private javax.swing.JTable table_allRecords;
    private javax.swing.JTable table_class;
    private javax.swing.JPanel tables_panel;
    private javax.swing.JComboBox timeOf_payment;
    private javax.swing.JTextField txtAmount_Tobe_Paid;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtResourceForDateFormatingINtoString;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSearchOption;
    private javax.swing.JTextField txtSearch_by_id;
    private javax.swing.JTextField txtStudentGrade;
    private javax.swing.JTextField txtStudentId;
    private javax.swing.JTextField txtSurcesCurrent;
    private javax.swing.JTextField txt_SearchBy_Student_Fullname;
    private javax.swing.JTable with_balanceTable;
    // End of variables declaration//GEN-END:variables
}
