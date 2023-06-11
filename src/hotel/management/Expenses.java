
package hotel.management;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import java.util.Base64;

public class Expenses extends javax.swing.JFrame {
         Connection conn = null;
      PreparedStatement pps, pps1, pps2, pps3, pps4, pps6, pps5, pps7, pps8, pps9, pps10, pps11, pps12 ,pps13 = null;
      ResultSet rs, rs1, rs2, rs3, rs4, rs5, rs6, rs7, rs8, rs9, rs10, rs11, rs12 ,rs13= null;
    
    String price_ID_resource = null;
    
    
      private static String Recieved_user_id = null;
      private static String usertype = null;
    //passing user id
    private static Expenses Obj = null;
    private String passed_user_id;

    
     Expenses() {
        initComponents();
        myClass();
        UpdateFees.hide();
        SaveFees.hide();
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
                 jLabel37.setText("Hi !"+fname +"  "+lname + "  Welcome ID Manager");
                 model.setText(rs6.getString("user"));
              
                 
            
                }
            } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    
    
     public void myClass(){
               // Checking price renge
        try {
           
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("SELECT fees, renge_start, renge_end  FROM price_settings");
            rs = pps.executeQuery();
            jTable17 .setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
     }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layer_holder = new javax.swing.JPanel();
        model = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        minize_lb = new javax.swing.JLabel();
        exit_lb = new javax.swing.JLabel();
        admin_btn = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        header_forExp = new javax.swing.JLabel();
        right = new javax.swing.JPanel();
        left = new javax.swing.JPanel();
        frontSide_btn_holder = new javax.swing.JPanel();
        report_panelBTN = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        archived_booking = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        center_card = new javax.swing.JPanel();
        pExpenses = new javax.swing.JPanel();
        roomcount5 = new javax.swing.JLabel();
        roomcount6 = new javax.swing.JLabel();
        Count_title4 = new javax.swing.JLabel();
        Count_title5 = new javax.swing.JLabel();
        Count_title6 = new javax.swing.JLabel();
        roomcount7 = new javax.swing.JLabel();
        roomcount8 = new javax.swing.JLabel();
        lb_hold4 = new javax.swing.JLabel();
        lb_hold5 = new javax.swing.JLabel();
        lb_hold6 = new javax.swing.JLabel();
        lb_hold7 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        Count_title41 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        Spending_main = new javax.swing.JPanel();
        spend_list = new javax.swing.JPanel();
        btn_container = new javax.swing.JPanel();
        btn_FirstView = new javax.swing.JPanel();
        Add_price = new javax.swing.JLabel();
        lb_bg_btnFirstView = new javax.swing.JLabel();
        btn_secondView = new javax.swing.JPanel();
        addRoom_type = new javax.swing.JLabel();
        Delecte7 = new javax.swing.JLabel();
        edit9 = new javax.swing.JLabel();
        lb_bg_btnSecondView = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel192 = new javax.swing.JLabel();
        jLabel193 = new javax.swing.JLabel();
        jLabel194 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        jTable17 = new javax.swing.JTable();
        table_holder_bg16 = new javax.swing.JLabel();
        spend_entry = new javax.swing.JPanel();
        Count_title7 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        UpdateFees = new javax.swing.JLabel();
        SaveFees = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        RengeEnd = new javax.swing.JComboBox();
        RengeStart = new javax.swing.JComboBox();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        amount = new javax.swing.JTextField();
        bgTaxForm1 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        layer_holder.setBackground(new java.awt.Color(153, 153, 153));
        layer_holder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        model.setForeground(new java.awt.Color(240, 240, 240));
        model.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        model.setText("jLabel2");
        layer_holder.add(model, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 10, 110, 40));

        jLabel37.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Hi Admin,  Welcome To Report  Management");
        layer_holder.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, 30));

        minize_lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minize_lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_minus_19px.png"))); // NOI18N
        minize_lb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minize_lbMouseClicked(evt);
            }
        });
        layer_holder.add(minize_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 0, 40, 60));

        exit_lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit_lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_delete_18px_1.png"))); // NOI18N
        exit_lb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit_lbMouseClicked(evt);
            }
        });
        layer_holder.add(exit_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 0, 50, 60));

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
        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_upload_to_ftp_30px.png"))); // NOI18N
        jLabel42.setText("   Home");
        admin_btn.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, 40));

        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        admin_btn.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 30, 40));

        layer_holder.add(admin_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 210, 40));

        header_forExp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/header.png"))); // NOI18N
        header_forExp.setText("jLabel1");
        layer_holder.add(header_forExp, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, -1, 80));

        right.setBackground(new java.awt.Color(153, 153, 153));
        layer_holder.add(right, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 740, 1400, 60));

        left.setBackground(new java.awt.Color(153, 153, 153));
        layer_holder.add(left, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 60, 50, 740));

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

        report_panelBTN.setBackground(new java.awt.Color(121, 119, 119));
        report_panelBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                report_panelBTNMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                report_panelBTNMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                report_panelBTNMouseExited(evt);
            }
        });
        report_panelBTN.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Currency_Settings_30px.png"))); // NOI18N
        jLabel21.setText("   Student ");
        report_panelBTN.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 60));

        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        report_panelBTN.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 60));

        frontSide_btn_holder.add(report_panelBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 210, 60));

        archived_booking.setBackground(new java.awt.Color(121, 119, 119));
        archived_booking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                archived_bookingMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                archived_bookingMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                archived_bookingMouseExited(evt);
            }
        });
        archived_booking.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_binder_30px_1.png"))); // NOI18N
        jLabel39.setText("  School Fees");
        archived_booking.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 130, 44));

        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        archived_booking.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 60));

        frontSide_btn_holder.add(archived_booking, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 210, 60));

        layer_holder.add(frontSide_btn_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 210, 660));

        center_card.setLayout(new java.awt.CardLayout());

        pExpenses.setBackground(new java.awt.Color(255, 255, 255));
        pExpenses.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        pExpenses.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roomcount5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roomcount5.setText("45");
        pExpenses.add(roomcount5, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 40, 60, 30));

        roomcount6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roomcount6.setText("45");
        pExpenses.add(roomcount6, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 40, 60, 30));

        Count_title4.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title4.setForeground(new java.awt.Color(33, 173, 178));
        Count_title4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title4.setText("Class");
        pExpenses.add(Count_title4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 100, 20));

        Count_title5.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title5.setForeground(new java.awt.Color(33, 173, 178));
        Count_title5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title5.setText("Room Types");
        pExpenses.add(Count_title5, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 100, 20));

        Count_title6.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title6.setForeground(new java.awt.Color(33, 173, 178));
        Count_title6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title6.setText("Students");
        pExpenses.add(Count_title6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 100, 20));

        roomcount7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roomcount7.setText("45");
        pExpenses.add(roomcount7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 60, 30));

        roomcount8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roomcount8.setText("45");
        pExpenses.add(roomcount8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 60, 30));

        lb_hold4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Escalator_Down_30px.png"))); // NOI18N
        pExpenses.add(lb_hold4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 60, 60));

        lb_hold5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_direction_30px.png"))); // NOI18N
        pExpenses.add(lb_hold5, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 60, 60));

        lb_hold6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_literature_30px.png"))); // NOI18N
        pExpenses.add(lb_hold6, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 20, 60, 60));

        lb_hold7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_hold7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_condo_30px.png"))); // NOI18N
        pExpenses.add(lb_hold7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 60, 60));

        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/counters.png"))); // NOI18N
        pExpenses.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 260, 80));

        Count_title41.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title41.setForeground(new java.awt.Color(33, 173, 178));
        Count_title41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title41.setText("Booked");
        pExpenses.add(Count_title41, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 10, 100, 20));

        jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/counter2.png"))); // NOI18N
        jLabel67.setText("jLabel41");
        pExpenses.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 250, 80));

        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/counter1.png"))); // NOI18N
        jLabel68.setText("jLabel41");
        pExpenses.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 250, 80));

        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/counter4.png"))); // NOI18N
        jLabel69.setText("jLabel41");
        pExpenses.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 250, 80));

        Spending_main.setBackground(new java.awt.Color(255, 255, 255));
        Spending_main.setLayout(new java.awt.CardLayout());

        spend_list.setBackground(new java.awt.Color(255, 255, 255));
        spend_list.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_container.setBackground(new java.awt.Color(255, 255, 255));
        btn_container.setLayout(new java.awt.CardLayout());

        btn_FirstView.setBackground(new java.awt.Color(255, 255, 255));
        btn_FirstView.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Add_price.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Add_price.setForeground(new java.awt.Color(255, 255, 255));
        Add_price.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        Add_price.setText(" Price");
        Add_price.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Add_priceMouseClicked(evt);
            }
        });
        btn_FirstView.add(Add_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 80, 60));

        lb_bg_btnFirstView.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        lb_bg_btnFirstView.setForeground(new java.awt.Color(255, 255, 255));
        lb_bg_btnFirstView.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_bg_btnFirstView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        btn_FirstView.add(lb_bg_btnFirstView, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, -10, 160, 70));

        btn_container.add(btn_FirstView, "card3");

        btn_secondView.setBackground(new java.awt.Color(255, 255, 255));
        btn_secondView.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addRoom_type.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        addRoom_type.setForeground(new java.awt.Color(255, 255, 255));
        addRoom_type.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_plus_math_20px.png"))); // NOI18N
        addRoom_type.setText(" Fees");
        addRoom_type.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addRoom_typeMouseClicked(evt);
            }
        });
        btn_secondView.add(addRoom_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 80, 40));

        Delecte7.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Delecte7.setForeground(new java.awt.Color(255, 255, 255));
        Delecte7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_no_entry_25px.png"))); // NOI18N
        Delecte7.setText("Delecte");
        Delecte7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Delecte7MouseClicked(evt);
            }
        });
        btn_secondView.add(Delecte7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 80, 60));

        edit9.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        edit9.setForeground(new java.awt.Color(255, 255, 255));
        edit9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_upload_to_ftp_30px.png"))); // NOI18N
        edit9.setText("Edit");
        edit9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                edit9MouseClicked(evt);
            }
        });
        btn_secondView.add(edit9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 90, 60));

        lb_bg_btnSecondView.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        lb_bg_btnSecondView.setForeground(new java.awt.Color(255, 255, 255));
        lb_bg_btnSecondView.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_bg_btnSecondView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/btn.png"))); // NOI18N
        lb_bg_btnSecondView.setText("Delecte");
        btn_secondView.add(lb_bg_btnSecondView, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 360, 70));

        btn_container.add(btn_secondView, "card2");

        spend_list.add(btn_container, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, 320, 60));

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel192.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel192.setForeground(new java.awt.Color(102, 102, 102));
        jLabel192.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel192.setText("Ending On");
        jPanel26.add(jLabel192, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 120, 50));

        jLabel193.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel193.setForeground(new java.awt.Color(102, 102, 102));
        jLabel193.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel193.setText("Fee");
        jPanel26.add(jLabel193, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 50));

        jLabel194.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel194.setForeground(new java.awt.Color(102, 102, 102));
        jLabel194.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_up_down_arrow_20px.png"))); // NOI18N
        jLabel194.setText("Starting  From ");
        jPanel26.add(jLabel194, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 120, 50));

        spend_list.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 800, -1));

        jScrollPane19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jTable17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jTable17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable17.setForeground(new java.awt.Color(102, 102, 102));
        jTable17.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable17.setRowHeight(30);
        jTable17.setRowMargin(10);
        jTable17.setTableHeader(null);
        jTable17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable17MouseClicked(evt);
            }
        });
        jScrollPane19.setViewportView(jTable17);

        spend_list.add(jScrollPane19, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 122, 800, 330));

        table_holder_bg16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        table_holder_bg16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/display.png"))); // NOI18N
        spend_list.add(table_holder_bg16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 550));

        Spending_main.add(spend_list, "card8");

        spend_entry.setBackground(new java.awt.Color(255, 255, 255));
        spend_entry.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Count_title7.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        Count_title7.setForeground(new java.awt.Color(33, 173, 178));
        Count_title7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Count_title7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_30px.png"))); // NOI18N
        Count_title7.setText("  View list");
        Count_title7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Count_title7MouseClicked(evt);
            }
        });
        spend_entry.add(Count_title7, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 70, 150, 50));

        jLabel72.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(102, 102, 102));
        jLabel72.setText("From Grade");
        spend_entry.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 100, 30));

        UpdateFees.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        UpdateFees.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UpdateFees.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/balance.png"))); // NOI18N
        UpdateFees.setText("Update");
        UpdateFees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateFeesMouseClicked(evt);
            }
        });
        spend_entry.add(UpdateFees, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 400, 130, 60));

        SaveFees.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SaveFees.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SaveFees.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/balance.png"))); // NOI18N
        SaveFees.setText("Save");
        SaveFees.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveFeesMouseClicked(evt);
            }
        });
        spend_entry.add(SaveFees, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 410, 130, 50));

        jLabel77.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(102, 102, 102));
        jLabel77.setText("Year");
        spend_entry.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 100, 40));

        jLabel74.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(102, 102, 102));
        jLabel74.setText("Amount");
        spend_entry.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 370, 100, 40));

        jLabel73.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(102, 102, 102));
        jLabel73.setText("To Grade ");
        spend_entry.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 220, 80, 50));

        jLabel78.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(102, 102, 102));
        jLabel78.setText("Grade Renge");
        spend_entry.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 120, 50));

        jLabel75.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setText("School Fees");
        spend_entry.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 190, 50));

        RengeEnd.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        spend_entry.add(RengeEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 230, 120, 30));

        RengeStart.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));
        spend_entry.add(RengeStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 110, 30));
        spend_entry.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, 320, 40));
        spend_entry.add(amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 320, 40));

        bgTaxForm1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bgTaxForm1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/Untitled-2.png"))); // NOI18N
        spend_entry.add(bgTaxForm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 50, 1160, 470));

        jLabel76.setText("jLabel66");
        spend_entry.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        Spending_main.add(spend_entry, "card3");

        pExpenses.add(Spending_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1140, 540));

        center_card.add(pExpenses, "card3");

        layer_holder.add(center_card, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 1100, 670));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/background_admi.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        layer_holder.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 60, -1, 780));

        getContentPane().add(layer_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 800));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void report_panelBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_report_panelBTNMouseClicked
        pExpenses.hide();
    }//GEN-LAST:event_report_panelBTNMouseClicked

    private void report_panelBTNMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_report_panelBTNMouseEntered
        report_panelBTN.setBackground(new Color(33,173,178));
    }//GEN-LAST:event_report_panelBTNMouseEntered

    private void report_panelBTNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_report_panelBTNMouseExited
        report_panelBTN.setBackground(new Color(121,119,119));
    }//GEN-LAST:event_report_panelBTNMouseExited

    private void admin_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btnMouseClicked
              Adminstrative myEX = new Adminstrative();
                         myEX.setVisible(true);
                         
                         //**************************************send id
                     myEX.setPassed_id(Recieved_user_id);
                     myEX.printPassed_id();
                     this.dispose();

    }//GEN-LAST:event_admin_btnMouseClicked

    private void admin_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btnMouseEntered
        admin_btn.setBackground(new Color(82,120,152));
    }//GEN-LAST:event_admin_btnMouseEntered

    private void admin_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btnMouseExited
        admin_btn.setBackground(new Color(121,119,119));
    }//GEN-LAST:event_admin_btnMouseExited

    private void archived_bookingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_archived_bookingMouseClicked
     pExpenses.setVisible(true);
    }//GEN-LAST:event_archived_bookingMouseClicked

    private void archived_bookingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_archived_bookingMouseEntered
        archived_booking.setBackground(new Color(33,173,178));
    }//GEN-LAST:event_archived_bookingMouseEntered

    private void archived_bookingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_archived_bookingMouseExited
        archived_booking.setBackground(new Color(121,119,119));
    }//GEN-LAST:event_archived_bookingMouseExited

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

    private void addRoom_typeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addRoom_typeMouseClicked
        spend_list.hide();
        UpdateFees.hide();
        spend_entry.setVisible(true);
    }//GEN-LAST:event_addRoom_typeMouseClicked

    private void Count_title7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Count_title7MouseClicked
        spend_list.setVisible(true);
        spend_entry.hide();
        
        btn_FirstView.setVisible(true);
        btn_secondView.hide();
        
            amount.setText(null);
            RengeStart.setSelectedIndex(0);
            RengeEnd.setSelectedIndex(0);
    }//GEN-LAST:event_Count_title7MouseClicked

    private void SaveFeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveFeesMouseClicked
         // Checking price renge
        try {
           
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("SELECT  * FROM price_settings WHERE renge_start =? ");  //AND renge_end = ?               pps.setString(2, RengeEnd.getSelectedItem().toString().trim());

            pps.setString(1, RengeStart.getSelectedItem().toString().trim());
              rs = pps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Starting Price Range Already Exists");
            } else {
              inserting_Price_renge();
            }
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }//GEN-LAST:event_SaveFeesMouseClicked

    private void Add_priceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Add_priceMouseClicked
        spend_list.hide();
        UpdateFees.hide();
        SaveFees.setVisible(true);
        spend_entry.setVisible(true);
        
    }//GEN-LAST:event_Add_priceMouseClicked

    private void jTable17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable17MouseClicked
        
        if(btn_FirstView.isShowing()){
          btn_FirstView.hide();
          btn_secondView.setVisible(true);
        
        }else if (btn_secondView.isShowing()){
        
          btn_FirstView.setVisible(true);
          btn_secondView.hide();
        
        }
       
    }//GEN-LAST:event_jTable17MouseClicked

    private void Delecte7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Delecte7MouseClicked
           DefaultTableModel tableMode =(DefaultTableModel)jTable17.getModel();
           String Starting = tableMode.getValueAt(jTable17.getSelectedRow(), 1).toString();
           
            DefaultTableModel tableMode1 =(DefaultTableModel)jTable17.getModel();
            String ending = tableMode1.getValueAt(jTable17.getSelectedRow(), 2).toString();
           
           try {
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("DELETE  FROM price_settings WHERE renge_start = ?  AND renge_end = ?");
            pps.setString(1, Starting);
            pps.setString(2, ending);
            pps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Removed");

        } catch (Exception ex) {
             Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
               
    
                  myClass();//show changes on the table after delete  
    }//GEN-LAST:event_Delecte7MouseClicked

    private void edit9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit9MouseClicked
          spend_list.hide();
          spend_entry.setVisible(true);
         SaveFees.hide();

         UpdateFees.setVisible(true);
            DefaultTableModel tableMode =(DefaultTableModel)jTable17.getModel();
            String Starting = tableMode.getValueAt(jTable17.getSelectedRow(), 1).toString();
           
            DefaultTableModel tableMode1 =(DefaultTableModel)jTable17.getModel();
            String ending = tableMode1.getValueAt(jTable17.getSelectedRow(), 2).toString();
        
       
        try {
             conn = DBConnection.getConnction();
              pps = conn.prepareStatement("SELECT *  FROM price_settings WHERE renge_start = ?  AND renge_end = ?");
            pps.setString(1, Starting);
            pps.setString(2, ending);

            rs = pps.executeQuery();
            if (rs.next()) {
              price_ID_resource = rs.getString("price_id");
               amount.setText(rs.getString("fees"));
               
            }
        } catch (Exception ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_edit9MouseClicked

    private void UpdateFeesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateFeesMouseClicked
            // inserting price settings
        try {
        int    ID = Integer.parseInt(price_ID_resource);

            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("UPDATE  price_settings  SET fees =?, renge_start=?, renge_end=? WHERE price_id = ? ");
            pps.setString(1, amount.getText().trim());
            pps.setString(2, RengeStart.getSelectedItem().toString().trim());
            pps.setString(3, RengeEnd.getSelectedItem().toString().trim());
            pps.setInt(4, ID);

            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Price Added");
           
            amount.setText(null);
            RengeStart.setSelectedIndex(0);
            RengeEnd.setSelectedIndex(0);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
         myClass();
        
    }//GEN-LAST:event_UpdateFeesMouseClicked

   
    
    
    
    
    public void inserting_Price_renge(){
          // inserting price settings
        try {
                   String dateSelected = ((JTextField) jDateChooser1.getDateEditor().getUiComponent()).getText();//conveting date to string then putting it on a resource
           
            conn = DBConnection.getConnction();
            pps = conn.prepareStatement("INSERT INTO price_settings (fees,renge_start,renge_end,date) VALUES (?,?,?,?)");
            pps.setString(1, amount.getText().trim());
            pps.setString(2, RengeStart.getSelectedItem().toString().trim());
            pps.setString(3, RengeEnd.getSelectedItem().toString().trim());
           pps.setString(4, dateSelected);

            pps.executeUpdate();
           JOptionPane.showMessageDialog(null, "Price Added");

           
                   amount.setText(null);
                   RengeStart.setSelectedIndex(0);
                   RengeEnd.setSelectedIndex(0);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
         myClass();
    }
    
      public static Expenses getObj() {  //public method for instance Restriction
        if (Obj == null) {
            Obj = new Expenses();
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
            java.util.logging.Logger.getLogger(Expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Expenses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Expenses().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Add_price;
    private javax.swing.JLabel Count_title4;
    private javax.swing.JLabel Count_title41;
    private javax.swing.JLabel Count_title5;
    private javax.swing.JLabel Count_title6;
    private javax.swing.JLabel Count_title7;
    private javax.swing.JLabel Delecte7;
    private javax.swing.JComboBox RengeEnd;
    private javax.swing.JComboBox RengeStart;
    private javax.swing.JLabel SaveFees;
    private javax.swing.JPanel Spending_main;
    private javax.swing.JLabel UpdateFees;
    private javax.swing.JLabel addRoom_type;
    private javax.swing.JPanel admin_btn;
    private javax.swing.JTextField amount;
    private javax.swing.JPanel archived_booking;
    private javax.swing.JLabel bgTaxForm1;
    private javax.swing.JPanel btn_FirstView;
    private javax.swing.JPanel btn_container;
    private javax.swing.JPanel btn_secondView;
    private javax.swing.JPanel center_card;
    private javax.swing.JLabel edit9;
    private javax.swing.JLabel exit_lb;
    private javax.swing.JPanel frontSide_btn_holder;
    private javax.swing.JLabel header_forExp;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JTable jTable17;
    private javax.swing.JPanel layer_holder;
    private javax.swing.JLabel lb_bg_btnFirstView;
    private javax.swing.JLabel lb_bg_btnSecondView;
    private javax.swing.JLabel lb_hold4;
    private javax.swing.JLabel lb_hold5;
    private javax.swing.JLabel lb_hold6;
    private javax.swing.JLabel lb_hold7;
    private javax.swing.JPanel left;
    private javax.swing.JLabel minize_lb;
    private javax.swing.JLabel model;
    private javax.swing.JPanel pExpenses;
    private javax.swing.JPanel report_panelBTN;
    private javax.swing.JPanel right;
    private javax.swing.JLabel roomcount5;
    private javax.swing.JLabel roomcount6;
    private javax.swing.JLabel roomcount7;
    private javax.swing.JLabel roomcount8;
    private javax.swing.JPanel spend_entry;
    private javax.swing.JPanel spend_list;
    private javax.swing.JLabel table_holder_bg16;
    // End of variables declaration//GEN-END:variables
}
