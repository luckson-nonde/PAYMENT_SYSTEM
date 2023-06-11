
package hotel.management;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.editor.ChartEditorFactory;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.KeyedValues;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;

public class ID_Card_Generetor extends javax.swing.JFrame {

    
    
    
    
    Connection conn = null;
    PreparedStatement pps, pps1, pps2, pps3, pps4, pps6, pps5, pps7, pps8, pps9, pps10, pps11, pps12, pps13 = null;
    ResultSet rs, rs1, rs2, rs3, rs4, rs5, rs6, rs7, rs8, rs9, rs10, rs11, rs12, rs13 = null;

    String form_ali = null;
    String Student_ID = null;

    private static String Recieved_user_id = null;
    private static String usertype = null;
    //passing user id
    private static ID_Card_Generetor Obj = null;
    private String passed_user_id;


    
    ID_Card_Generetor() {
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));
            icon();
       
            
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
            pps6.setString(1,passed_user_id.trim()); 
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
    
    
    
    
    
    
    
   public static BufferedImage getScreenShot(Component com){
     BufferedImage image = new BufferedImage(com.getWidth(), com.getHeight(), BufferedImage .TYPE_INT_RGB);
     com.paint(image.getGraphics());
     return image;
   } 
    
   
   
   public static void SaveScreenShot(Component com) throws Exception{
     //   BufferedImage img = getScreenShot(com);
     //   ImageIO.write(img, "png", new File(fileName));
        
          BufferedImage img = getScreenShot(com);
          String path = "C:/Users/USER/Desktop/image.png";
          ImageIO.write(img, "png", new File(path));
         
         
   }  
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        main = new javax.swing.JPanel();
        admin_btn = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        sidebar_Structure = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        Search_student = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        sidebar_Design = new javax.swing.JPanel();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        btn_school_info = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        txt_schoolName = new javax.swing.JTextField();
        btn_moto = new javax.swing.JLabel();
        txt_schoolMoto = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        Cover = new javax.swing.JPanel();
        btn_moto1 = new javax.swing.JLabel();
        btn_moto2 = new javax.swing.JLabel();
        Image_chooser = new javax.swing.JLabel();
        Image_chooser1 = new javax.swing.JLabel();
        Image_chooser2 = new javax.swing.JLabel();
        content = new javax.swing.JPanel();
        txt_getName = new javax.swing.JTextField();
        txt_getDate = new com.toedter.calendar.JDateChooser();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_getGrade = new javax.swing.JTextField();
        txt_getGender = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txt_getExam = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        Content = new javax.swing.JPanel();
        One_sides_form = new javax.swing.JPanel();
        ID = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        Ge_Eduction = new javax.swing.JLabel();
        school_title = new javax.swing.JLabel();
        school_moto = new javax.swing.JLabel();
        lb_holder = new javax.swing.JLabel();
        st_gender = new javax.swing.JLabel();
        lb_gender = new javax.swing.JLabel();
        lb_year = new javax.swing.JLabel();
        st_Grade = new javax.swing.JLabel();
        lbs_gender = new javax.swing.JLabel();
        lb_exam = new javax.swing.JLabel();
        st_number = new javax.swing.JLabel();
        st_dob = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lb_student = new javax.swing.JLabel();
        st_name = new javax.swing.JLabel();
        lb_image = new javax.swing.JLabel();
        lb_icon = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        img_holder = new javax.swing.JLabel();
        logo2 = new javax.swing.JPanel();
        school_logo = new javax.swing.JPanel();
        minize_lb = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        model = new javax.swing.JLabel();
        exit_lb = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        main.setBackground(new java.awt.Color(204, 204, 204));
        main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jLabel46.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_home_page_30px.png"))); // NOI18N
        jLabel46.setText("   Back Home");
        admin_btn.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, 40));

        main.add(admin_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 180, 40));

        sidebar_Structure.setBackground(new java.awt.Color(121, 119, 119));
        sidebar_Structure.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(153, 153, 153))); // NOI18N
        sidebar_Structure.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sidebar_StructureMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sidebar_StructureMouseEntered(evt);
            }
        });
        sidebar_Structure.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        sidebar_Structure.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, 310, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Student name");
        sidebar_Structure.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 90, 30));

        Search_student.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Search_studentKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Search_studentKeyTyped(evt);
            }
        });
        sidebar_Structure.add(Search_student, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 210, 30));
        sidebar_Structure.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 70, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/balance.png"))); // NOI18N
        jLabel5.setText("Print  Student ID");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        sidebar_Structure.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 180, 60));
        sidebar_Structure.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 90, 20));
        sidebar_Structure.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 70, 20));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ID processing");
        sidebar_Structure.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 150, 40));
        sidebar_Structure.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 90, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Students Information ");
        sidebar_Structure.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 150, 40));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        sidebar_Structure.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 300, 150));

        jScrollPane3.setViewportView(sidebar_Structure);

        main.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 62, 320, 700));

        sidebar_Design.setBackground(new java.awt.Color(121, 119, 119));
        sidebar_Design.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        sidebar_Design.setPreferredSize(new java.awt.Dimension(184, 140));
        sidebar_Design.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sidebar_DesignMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sidebar_DesignMouseEntered(evt);
            }
        });
        sidebar_Design.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        sidebar_Design.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 30, 20));

        jLabel12.setBackground(new java.awt.Color(153, 153, 153));
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("school motol");
        sidebar_Design.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 100, 30));

        btn_school_info.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_school_info.setForeground(new java.awt.Color(255, 255, 255));
        btn_school_info.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_color_dropper_19px.png"))); // NOI18N
        btn_school_info.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_school_infoMouseClicked(evt);
            }
        });
        sidebar_Design.add(btn_school_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 40, 50));

        jLabel7.setBackground(new java.awt.Color(153, 153, 153));
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("school name");
        sidebar_Design.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 74, 90, 20));
        sidebar_Design.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 60, 20));

        txt_schoolName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_schoolNameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_schoolNameMouseExited(evt);
            }
        });
        txt_schoolName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_schoolNameKeyPressed(evt);
            }
        });
        sidebar_Design.add(txt_schoolName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 200, 30));

        btn_moto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_moto.setForeground(new java.awt.Color(255, 255, 255));
        btn_moto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_color_dropper_19px.png"))); // NOI18N
        btn_moto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_motoMouseClicked(evt);
            }
        });
        sidebar_Design.add(btn_moto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 40, 50));

        txt_schoolMoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txt_schoolMotoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txt_schoolMotoMouseExited(evt);
            }
        });
        txt_schoolMoto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_schoolMotoKeyPressed(evt);
            }
        });
        sidebar_Design.add(txt_schoolMoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 200, 30));

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_color_dropper_19px.png"))); // NOI18N
        jLabel48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel48MouseClicked(evt);
            }
        });
        sidebar_Design.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 40, 50));

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(121, 119, 119));
        jTextField4.setText("Student Info Color");
        jTextField4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTextField4.setEnabled(false);
        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField4MouseClicked(evt);
            }
        });
        sidebar_Design.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 200, 30));

        jPanel2.setLayout(new java.awt.CardLayout());

        Cover.setBackground(new java.awt.Color(121, 119, 119));
        Cover.setForeground(new java.awt.Color(255, 255, 255));
        Cover.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_moto1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_moto1.setForeground(new java.awt.Color(255, 255, 255));
        btn_moto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_color_dropper_19px.png"))); // NOI18N
        btn_moto1.setText(" Header Title");
        btn_moto1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_moto1MouseClicked(evt);
            }
        });
        Cover.add(btn_moto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 180, 50));

        btn_moto2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_moto2.setForeground(new java.awt.Color(255, 255, 255));
        btn_moto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_color_dropper_19px.png"))); // NOI18N
        btn_moto2.setText("Border Color");
        btn_moto2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_moto2MouseClicked(evt);
            }
        });
        Cover.add(btn_moto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 180, 50));

        Image_chooser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Image_chooser.setForeground(new java.awt.Color(255, 255, 255));
        Image_chooser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_businessman_30px.png"))); // NOI18N
        Image_chooser.setText("School Logo");
        Image_chooser.setToolTipText("Choose image");
        Image_chooser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Image_chooserMouseClicked(evt);
            }
        });
        Cover.add(Image_chooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 150, 30));

        Image_chooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Image_chooser1.setForeground(new java.awt.Color(255, 255, 255));
        Image_chooser1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_businessman_30px.png"))); // NOI18N
        Image_chooser1.setText("Student Image");
        Image_chooser1.setToolTipText("Choose image");
        Image_chooser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Image_chooser1MouseClicked(evt);
            }
        });
        Cover.add(Image_chooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 150, 30));

        Image_chooser2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Image_chooser2.setForeground(new java.awt.Color(255, 255, 255));
        Image_chooser2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_businessman_30px.png"))); // NOI18N
        Image_chooser2.setText("Minstry Logo");
        Image_chooser2.setToolTipText("Choose image");
        Image_chooser2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Image_chooser2MouseClicked(evt);
            }
        });
        Cover.add(Image_chooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 150, 30));

        jPanel2.add(Cover, "card2");

        content.setBackground(new java.awt.Color(121, 119, 119));
        content.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_getName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_getNameKeyPressed(evt);
            }
        });
        content.add(txt_getName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 120, -1));
        content.add(txt_getDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 120, -1));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Name       :");
        content.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 60, 20));

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Gender");
        content.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 60, 20));

        txt_getGrade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_getGradeKeyPressed(evt);
            }
        });
        content.add(txt_getGrade, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 120, -1));

        txt_getGender.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_getGenderKeyPressed(evt);
            }
        });
        content.add(txt_getGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 120, -1));

        jTextField6.setText("jTextField3");
        content.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 120, -1));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Grade        :");
        content.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 60, 20));

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Year        :");
        content.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 60, 20));

        jLabel42.setBackground(new java.awt.Color(255, 255, 255));
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Exam #");
        content.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 60, 20));

        txt_getExam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_getExamKeyPressed(evt);
            }
        });
        content.add(txt_getExam, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 120, -1));

        jPanel2.add(content, "card3");

        sidebar_Design.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 200, 420));

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Info Entry");
        sidebar_Design.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 100, 20));

        jScrollPane2.setViewportView(sidebar_Design);

        main.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, 660));

        Content.setBackground(new java.awt.Color(255, 255, 255));
        Content.setLayout(new java.awt.CardLayout());

        One_sides_form.setBackground(new java.awt.Color(153, 153, 153));
        One_sides_form.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ID.setBackground(new java.awt.Color(204, 204, 204));
        ID.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ID.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Ge_Eduction.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Ge_Eduction.setForeground(new java.awt.Color(102, 102, 102));
        Ge_Eduction.setText("MINISTRY OF GENERAL EDUCATION  ");
        jPanel1.add(Ge_Eduction, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 210, 30));

        school_title.setForeground(new java.awt.Color(102, 102, 102));
        school_title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        school_title.setText("THE SCHOOL NAME GOES HERE  hhh");
        jPanel1.add(school_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 190, 30));

        school_moto.setFont(new java.awt.Font("Trebuchet MS", 0, 10)); // NOI18N
        school_moto.setForeground(new java.awt.Color(102, 102, 102));
        school_moto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        school_moto.setText("THE SCHOOL MOTEL GOES HERE");
        jPanel1.add(school_moto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 180, 30));

        lb_holder.setBackground(new java.awt.Color(255, 255, 255));
        lb_holder.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lb_holder.setForeground(new java.awt.Color(153, 153, 153));
        lb_holder.setText(" Holder       :");
        jPanel1.add(lb_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 80, 20));

        st_gender.setBackground(new java.awt.Color(255, 255, 255));
        st_gender.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        st_gender.setForeground(new java.awt.Color(153, 153, 153));
        st_gender.setText("Gender    ");
        jPanel1.add(st_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 180, -1));

        lb_gender.setBackground(new java.awt.Color(255, 255, 255));
        lb_gender.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lb_gender.setForeground(new java.awt.Color(153, 153, 153));
        lb_gender.setText("Gender       :");
        jPanel1.add(lb_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 80, -1));

        lb_year.setBackground(new java.awt.Color(255, 255, 255));
        lb_year.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lb_year.setForeground(new java.awt.Color(153, 153, 153));
        lb_year.setText("Year           :");
        jPanel1.add(lb_year, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 80, -1));

        st_Grade.setBackground(new java.awt.Color(255, 255, 255));
        st_Grade.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        st_Grade.setForeground(new java.awt.Color(153, 153, 153));
        st_Grade.setText("Grade      ");
        jPanel1.add(st_Grade, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 180, 20));

        lbs_gender.setBackground(new java.awt.Color(255, 255, 255));
        lbs_gender.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbs_gender.setForeground(new java.awt.Color(153, 153, 153));
        lbs_gender.setText("Grade         :");
        jPanel1.add(lbs_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 80, 20));

        lb_exam.setBackground(new java.awt.Color(255, 255, 255));
        lb_exam.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lb_exam.setForeground(new java.awt.Color(153, 153, 153));
        lb_exam.setText("Exam No     :");
        jPanel1.add(lb_exam, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 80, 20));

        st_number.setBackground(new java.awt.Color(255, 255, 255));
        st_number.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        st_number.setForeground(new java.awt.Color(153, 153, 153));
        st_number.setText("0973651920");
        jPanel1.add(st_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 180, 20));

        st_dob.setBackground(new java.awt.Color(255, 255, 255));
        st_dob.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        st_dob.setForeground(new java.awt.Color(153, 153, 153));
        st_dob.setText("Year Group");
        jPanel1.add(st_dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 180, -1));

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(153, 153, 153));
        jLabel24.setText("........................");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, -1, 20));

        lb_student.setBackground(new java.awt.Color(255, 255, 255));
        lb_student.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lb_student.setForeground(new java.awt.Color(153, 153, 153));
        lb_student.setText("Student       :");
        jPanel1.add(lb_student, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 80, -1));

        st_name.setBackground(new java.awt.Color(255, 255, 255));
        st_name.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        st_name.setForeground(new java.awt.Color(153, 153, 153));
        st_name.setText("Full Name");
        jPanel1.add(st_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 180, -1));

        lb_image.setBackground(new java.awt.Color(255, 255, 255));
        lb_image.setForeground(new java.awt.Color(153, 153, 153));
        jPanel1.add(lb_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 90, 90));

        lb_icon.setBackground(new java.awt.Color(255, 255, 255));
        lb_icon.setForeground(new java.awt.Color(153, 153, 153));
        jPanel1.add(lb_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 80, 80));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/Icon_logo.png"))); // NOI18N
        jPanel3.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 170, 160));
        jPanel3.add(img_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 80, 110));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 100, 120));

        ID.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 410, 230));

        One_sides_form.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 430, 250));

        logo2.setBackground(new java.awt.Color(153, 153, 153));
        logo2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        One_sides_form.add(logo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 200, 80, 100));

        school_logo.setBackground(new java.awt.Color(153, 153, 153));
        school_logo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        One_sides_form.add(school_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 90, 110));

        Content.add(One_sides_form, "card2");

        main.add(Content, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 810, 700));

        minize_lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minize_lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_minus_19px.png"))); // NOI18N
        minize_lb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minize_lbMouseClicked(evt);
            }
        });
        main.add(minize_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 10, 40, 40));

        jLabel37.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Hi Admin,  Welcome To My  Manager");
        main.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 480, 40));

        model.setForeground(new java.awt.Color(240, 240, 240));
        model.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        model.setText("jLabel2");
        main.add(model, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 10, 110, 40));

        exit_lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit_lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_delete_18px_1.png"))); // NOI18N
        exit_lb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit_lbMouseClicked(evt);
            }
        });
        main.add(exit_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 10, 50, 40));

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/header.png"))); // NOI18N
        main.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, -1, 80));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/background_admi.png"))); // NOI18N
        main.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 20, -1, 850));

        getContentPane().add(main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 760));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sidebar_DesignMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidebar_DesignMouseEntered
        sidebar_Design.setSize(100, 750);
    }//GEN-LAST:event_sidebar_DesignMouseEntered

    private void sidebar_DesignMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidebar_DesignMouseClicked
               sidebar_Design.setSize(100, 750);

    }//GEN-LAST:event_sidebar_DesignMouseClicked

    private void sidebar_StructureMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidebar_StructureMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sidebar_StructureMouseClicked

    private void sidebar_StructureMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidebar_StructureMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_sidebar_StructureMouseEntered

    private void btn_school_infoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_school_infoMouseClicked
       
     JColorChooser colorchooser = new JColorChooser();
     Color color =  JColorChooser.showDialog(null, "Pick A Color For School Title", Color.GRAY);
     school_title.setForeground(color);

    }//GEN-LAST:event_btn_school_infoMouseClicked

    private void minize_lbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minize_lbMouseClicked
        this.setExtendedState(ID_Card_Generetor.ICONIFIED);
    }//GEN-LAST:event_minize_lbMouseClicked

    private void exit_lbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_lbMouseClicked
        Dialog frame = new Dialog();
        frame.setVisible(true);
    }//GEN-LAST:event_exit_lbMouseClicked

    private void btn_motoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_motoMouseClicked
        // TODO add your handling code here:
        JColorChooser colorchooser = new JColorChooser();
     Color color =  JColorChooser.showDialog(null, "Pick A Color For School Title", Color.GRAY);
     school_moto.setForeground(color);
    }//GEN-LAST:event_btn_motoMouseClicked

    private void jLabel48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel48MouseClicked
        // TODO add your handling code here:
        
     JColorChooser colorchooser = new JColorChooser();
     Color color =  JColorChooser.showDialog(null, "Pick A Color For School Title", Color.GRAY);
        st_name.setForeground(color);
        st_dob.setForeground(color);
        st_gender.setForeground(color);
        st_Grade.setForeground(color);
        st_number.setForeground(color);  
        
        lb_student.setForeground(color);
        lb_year.setForeground(color);
        lb_gender.setForeground(color);
         lbs_gender.setForeground(color);
          lb_exam.setForeground(color);
          lb_holder  .setForeground(color);      
        
        lb_holder.setForeground(color);   
         jLabel24.setForeground(color);       
        
    }//GEN-LAST:event_jLabel48MouseClicked

    private void txt_schoolNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_schoolNameKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
           String schoolname =   txt_schoolName.getText();
           school_title.setText(schoolname);
           txt_schoolName.setText(null);
           jLabel7.setVisible(true);
       }
    }//GEN-LAST:event_txt_schoolNameKeyPressed

    private void txt_schoolMotoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_schoolMotoKeyPressed
           if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
           String schoolname =   txt_schoolMoto.getText();
           school_moto.setText(schoolname);
           txt_schoolMoto.setText(null);
           jLabel12.setVisible(true);
       }
    }//GEN-LAST:event_txt_schoolMotoKeyPressed

    private void txt_schoolNameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_schoolNameMouseEntered
       jLabel7.hide();
    }//GEN-LAST:event_txt_schoolNameMouseEntered

    private void txt_schoolMotoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_schoolMotoMouseEntered
       jLabel12.hide();
    }//GEN-LAST:event_txt_schoolMotoMouseEntered

    private void jTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseClicked
           if (Cover.isShowing()) {
            content.setVisible(true);
            Cover.hide();

        } else if (!Cover.isShowing()) {
            content.hide();
            Cover.setVisible(true);

        }
    }//GEN-LAST:event_jTextField4MouseClicked

    private void txt_schoolNameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_schoolNameMouseExited
       if(txt_schoolName.getText().isEmpty()){
        jLabel7.hide();
       }else{
       jLabel7.setVisible(true);
       }
    }//GEN-LAST:event_txt_schoolNameMouseExited

    private void txt_schoolMotoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_schoolMotoMouseExited
     if(txt_schoolMoto.getText().isEmpty()){
        jLabel12.hide();
       }else{
       jLabel12.setVisible(true);
       }
    }//GEN-LAST:event_txt_schoolMotoMouseExited

    private void txt_getNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_getNameKeyPressed
        // TODO add your handling code here:
      if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
          st_dob.requestFocus();
          }
    }//GEN-LAST:event_txt_getNameKeyPressed

    private void txt_getGenderKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_getGenderKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
          st_Grade.requestFocus();
          }
    }//GEN-LAST:event_txt_getGenderKeyPressed

    private void txt_getGradeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_getGradeKeyPressed
          if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
          st_number.requestFocus();
          }
    }//GEN-LAST:event_txt_getGradeKeyPressed

    private void txt_getExamKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_getExamKeyPressed
        // TODO add your handling code here:
             String dateSelected = ((JTextField) txt_getDate.getDateEditor().getUiComponent()).getText();//conveting date to string then putting it on a resource
        
           if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
           st_name.setText(txt_getName.getText());
           st_dob.setText(dateSelected);
           st_gender.setText(txt_getGender.getText());
           st_Grade.setText(txt_getGrade.getText());
           st_number.setText(txt_getExam.getText());

           
           st_name.setText(null);
           st_dob.setText(null);
           st_gender.setText(null);
           st_Grade.setText(null);
           st_number.setText(null);

       }
        
    }//GEN-LAST:event_txt_getExamKeyPressed

    private void btn_moto1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_moto1MouseClicked
            JColorChooser colorchooser = new JColorChooser();
     Color color =  JColorChooser.showDialog(null, "Pick A Color For School Title", Color.GRAY);
     Ge_Eduction.setForeground(color);
    }//GEN-LAST:event_btn_moto1MouseClicked

    private void btn_moto2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_moto2MouseClicked
     JColorChooser colorchooser = new JColorChooser();
     Color color =  JColorChooser.showDialog(null, "Pick A Color For  Background", Color.GRAY);
     ID.setBackground(color);
    }//GEN-LAST:event_btn_moto2MouseClicked

    private void Image_chooserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Image_chooserMouseClicked
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setFileHidingEnabled(false);
        if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
            java.io.File f = chooser.getSelectedFile();

            try {
                ImageIcon icon= new ImageIcon(ImageIO.read(f));
                Image image = icon.getImage();
                Image modifiedImage = image.getScaledInstance(school_logo.getWidth(), school_logo.getHeight(), Image.SCALE_SMOOTH);
                icon = new ImageIcon(modifiedImage);
                //   img_holder.setIcon(new ImageIcon(ImageIO.read(f)));
                lb_image.setIcon(icon);

            } catch (IOException ex) {
                Logger.getLogger(Adminstrative.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_Image_chooserMouseClicked

    private void Image_chooser1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Image_chooser1MouseClicked
          JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setFileHidingEnabled(false);
        if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
            java.io.File f = chooser.getSelectedFile();

            try {
                ImageIcon icon= new ImageIcon(ImageIO.read(f));
                Image image = icon.getImage();
                Image modifiedImage = image.getScaledInstance(jPanel3.getWidth(), jPanel3.getHeight(), Image.SCALE_SMOOTH);
                icon = new ImageIcon(modifiedImage);
                img_holder.setIcon(icon);

            } catch (IOException ex) {
                Logger.getLogger(Adminstrative.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_Image_chooser1MouseClicked

    private void Image_chooser2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Image_chooser2MouseClicked
          JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setFileHidingEnabled(false);
        if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
            java.io.File f = chooser.getSelectedFile();

            try {
                ImageIcon icon= new ImageIcon(ImageIO.read(f));
                Image image = icon.getImage();
                Image modifiedImage = image.getScaledInstance(logo2.getWidth(), logo2.getHeight(), Image.SCALE_SMOOTH);
                icon = new ImageIcon(modifiedImage);
                lb_icon.setIcon(icon);

            } catch (IOException ex) {
                Logger.getLogger(Adminstrative.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_Image_chooser2MouseClicked

    private void admin_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btnMouseClicked
                   Admin_Home.getObj().setVisible(true);
                    //passing user id 
                    Admin_Home.getObj().setUserID(Recieved_user_id);
                    Admin_Home.getObj().printUserID();

                    this.dispose();
    }//GEN-LAST:event_admin_btnMouseClicked

    private void admin_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btnMouseEntered
        admin_btn.setBackground(new Color(82,120,152));
    }//GEN-LAST:event_admin_btnMouseEntered

    private void admin_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btnMouseExited
        admin_btn.setBackground(new Color(121,119,119));
    }//GEN-LAST:event_admin_btnMouseExited

    private void Search_studentKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Search_studentKeyPressed
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
             userINFO();
         }
        
        
    }//GEN-LAST:event_Search_studentKeyPressed

       public void userINFO(){
     try {
         
             Student_ID = Search_student.getText();
            conn = DBConnection.getConnction();
            
            String sql ="SELECT *   FROM students     WHERE Student_Id  like '%" + Student_ID + "%'  OR Full_name  like '%" + Student_ID + "%' ";
            pps = conn.prepareStatement(sql);
            rs = pps.executeQuery();
                 byte[] image = null;
                     
                 while(rs.next()){

                      st_name.setText(rs.getString("Full_Name"));
                       st_dob.setText( rs.getString("Date"));
                       st_gender.setText( rs.getString("Student_Gender"));
                       st_Grade.setText( rs.getString("Student_Class"));
                       st_number.setText( rs.getString("Student_ID"));
                     
                     
                      
                         image = rs.getBytes("image");
                         Image img = Toolkit.getDefaultToolkit().createImage(image);
                         ImageIcon icon = new ImageIcon(img);
                          
                           Image modifiedImage = img.getScaledInstance(jPanel3.getWidth(), jPanel3.getHeight(), Image.SCALE_SMOOTH);
                           icon = new ImageIcon(modifiedImage);
                           img_holder.setIcon(icon);
                        
                }
            } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
          }
 
    }
    public void icon(){
      
       try {
            conn = DBConnection.getConnction();
            pps3 = conn.prepareStatement(" SELECT  * FROM  school_settings");
            rs3 = pps3.executeQuery();
                 byte[] image = null;
                 byte[] images = null;

                 if(rs3.next()){
                     image = rs3.getBytes("school_logo");
                     Image img = Toolkit.getDefaultToolkit().createImage(image);
                     ImageIcon icon = new ImageIcon(img);

                     Image modifiedImaged = img.getScaledInstance(school_logo.getWidth(), school_logo.getHeight(), Image.SCALE_SMOOTH);
                     icon = new ImageIcon(modifiedImaged);
                     lb_image.setIcon(icon);
                     
                     
                      images = rs3.getBytes("minstry_logo");
                     Image imgs = Toolkit.getDefaultToolkit().createImage(images);
                     ImageIcon icons = new ImageIcon(imgs);

                     Image modifiedImages = imgs.getScaledInstance(lb_icon.getWidth(), lb_icon.getHeight(), Image.SCALE_SMOOTH);
                     icons = new ImageIcon(modifiedImages);
                    lb_icon.setIcon(icons);
                     
                     school_title.setText(rs3.getString("school_name"));
                     school_moto.setText(rs3.getString("school_motto"));
                     
                     
                     }
            } catch (SQLException ex) {
            Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
          }
    
    }
    
    
    
    private void Search_studentKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Search_studentKeyTyped
           try {
        conn = DBConnection.getConnction();
        String sql ="SELECT   Full_Name,Student_ID,Student_Gender  FROM students     WHERE Student_Id  like '%" + Search_student.getText() + "%'  OR Full_name  like '%" + Search_student.getText() + "%' ";
         pps = conn.prepareStatement(sql);
         rs = pps.executeQuery();
         
         jTable1.setModel(DbUtils.resultSetToTableModel(rs));//sho
      } catch (SQLException ex) {Logger.getLogger(Class.class.getName()).log(Level.SEVERE, null, ex);}
       
    }//GEN-LAST:event_Search_studentKeyTyped

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
         //printing the panel with its content
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Print Student ID");

        job.setPrintable(new Printable() {
            public int print(Graphics pg, PageFormat pf, int PageNum) {
                pf.setOrientation(PageFormat.LANDSCAPE);
                if (PageNum > 0) {
                    return Printable.NO_SUCH_PAGE;
                }
                java.awt.Graphics2D g2 = (java.awt.Graphics2D) pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                g2.scale(0.63, 0.80);
             //   jLabel1.print(g2);
                ID.print(g2);

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
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
                DefaultTableModel tableMode_type = (DefaultTableModel) jTable1.getModel();
                Student_ID = tableMode_type.getValueAt(jTable1.getSelectedRow(), 0).toString();
                userINFO();
    }//GEN-LAST:event_jTable1MouseClicked

    
      public static ID_Card_Generetor getObj() {  //public method for instance Restriction
        if (Obj == null) {
            Obj = new ID_Card_Generetor();
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
            java.util.logging.Logger.getLogger(ID_Card_Generetor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ID_Card_Generetor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ID_Card_Generetor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ID_Card_Generetor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ID_Card_Generetor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Content;
    private javax.swing.JPanel Cover;
    private javax.swing.JLabel Ge_Eduction;
    private javax.swing.JPanel ID;
    private javax.swing.JLabel Image_chooser;
    private javax.swing.JLabel Image_chooser1;
    private javax.swing.JLabel Image_chooser2;
    private javax.swing.JPanel One_sides_form;
    private javax.swing.JTextField Search_student;
    private javax.swing.JPanel admin_btn;
    private javax.swing.JLabel btn_moto;
    private javax.swing.JLabel btn_moto1;
    private javax.swing.JLabel btn_moto2;
    private javax.swing.JLabel btn_school_info;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JPanel content;
    private javax.swing.JLabel exit_lb;
    private javax.swing.JLabel img_holder;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel lb_exam;
    private javax.swing.JLabel lb_gender;
    private javax.swing.JLabel lb_holder;
    private javax.swing.JLabel lb_icon;
    private javax.swing.JLabel lb_image;
    private javax.swing.JLabel lb_student;
    private javax.swing.JLabel lb_year;
    private javax.swing.JLabel lbs_gender;
    private javax.swing.JPanel logo2;
    private javax.swing.JPanel main;
    private javax.swing.JLabel minize_lb;
    private javax.swing.JLabel model;
    private javax.swing.JPanel school_logo;
    private javax.swing.JLabel school_moto;
    private javax.swing.JLabel school_title;
    private javax.swing.JPanel sidebar_Design;
    private javax.swing.JPanel sidebar_Structure;
    private javax.swing.JLabel st_Grade;
    private javax.swing.JLabel st_dob;
    private javax.swing.JLabel st_gender;
    private javax.swing.JLabel st_name;
    private javax.swing.JLabel st_number;
    private com.toedter.calendar.JDateChooser txt_getDate;
    private javax.swing.JTextField txt_getExam;
    private javax.swing.JTextField txt_getGender;
    private javax.swing.JTextField txt_getGrade;
    private javax.swing.JTextField txt_getName;
    private javax.swing.JTextField txt_schoolMoto;
    private javax.swing.JTextField txt_schoolName;
    // End of variables declaration//GEN-END:variables
}
