
package hotel.management;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.AreaRendererEndType;
import org.jfree.chart.renderer.category.AreaRenderer;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;


public class Fee_Analysis extends javax.swing.JFrame {

    
      Connection conn = null;
      PreparedStatement pps, pps1, pps2, pps3, pps4, pps6, pps5, pps7, pps8, pps9, pps10, pps11, pps12 ,pps13 = null;
      ResultSet rs, rs1, rs2, rs3, rs4, rs5, rs6, rs7, rs8, rs9, rs10, rs11, rs12 ,rs13= null;


    

    public Fee_Analysis() {
        initComponents();
        this.setBackground(new Color(0, 0, 0, 0));
         line_chart();
         areaChart();
          pieChart();

    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Line_Chart = new javax.swing.JLabel();
        AreaChart = new javax.swing.JLabel();
        minize_lb = new javax.swing.JLabel();
        AreaChart1 = new javax.swing.JLabel();
        exit_lb = new javax.swing.JLabel();
        header_Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(1350, 760));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new Color(225,225,225,10));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("jLabel1");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 90, 50));

        Line_Chart.setForeground(new java.awt.Color(204, 204, 204));
        Line_Chart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_descending_sorting_35px.png"))); // NOI18N
        Line_Chart.setText("  Line Chart");
        Line_Chart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Line_ChartMouseClicked(evt);
            }
        });
        jPanel1.add(Line_Chart, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 120, 30));

        AreaChart.setForeground(new java.awt.Color(204, 204, 204));
        AreaChart.setText("Area   Chart");
        AreaChart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AreaChartMouseClicked(evt);
            }
        });
        jPanel1.add(AreaChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 120, 30));

        minize_lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minize_lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_minus_19px.png"))); // NOI18N
        minize_lb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minize_lbMouseClicked(evt);
            }
        });
        jPanel1.add(minize_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 0, 60, 60));

        AreaChart1.setForeground(new java.awt.Color(204, 204, 204));
        AreaChart1.setText("Pie   Chart");
        AreaChart1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AreaChart1MouseClicked(evt);
            }
        });
        jPanel1.add(AreaChart1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 120, 30));

        exit_lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit_lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_delete_18px_1.png"))); // NOI18N
        exit_lb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit_lbMouseClicked(evt);
            }
        });
        jPanel1.add(exit_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 0, 70, 60));

        header_Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/header.png"))); // NOI18N
        header_Background.setText("jLabel2");
        jPanel1.add(header_Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1390, 90));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 760));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Line_ChartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Line_ChartMouseClicked
       
     
        
        line_chart();
        



    }//GEN-LAST:event_Line_ChartMouseClicked

    public void line_chart(){
    
    
        try {
          String sql = "SELECT date, Amount_paid FROM fee_history";
          JDBCCategoryDataset dataset =new  JDBCCategoryDataset(DBConnection.getConnction(), sql);
          JFreeChart chart = ChartFactory.createLineChart(null, "Date",   "fees", dataset, PlotOrientation.VERTICAL, false, true, true); 
          BarRenderer renderer = null;
          CategoryPlot Plot = null;
          renderer = new BarRenderer(); 
        
           ChartFrame frame = new ChartFrame("Line chart",chart);
           frame.setVisible(true);
           frame.setLocation(5, 75);
           frame.setSize(1360,300);
        } catch (Exception ex) {
         Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    
    private void AreaChartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AreaChartMouseClicked
     
         areaChart();
    }//GEN-LAST:event_AreaChartMouseClicked

    public void areaChart(){
    
        try {
         String sql = "SELECT  date, Amount_paid FROM fee_history";
         JDBCCategoryDataset dataset = new  JDBCCategoryDataset(DBConnection.getConnction(), sql);
        
        JFreeChart chart = ChartFactory.createAreaChart( "","Period","Payments",dataset, PlotOrientation.VERTICAL,false,true, true );
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
       //plot.setForegroundAlpha(0.2f);
         plot.setDomainGridlinesVisible(false);
         plot.setRangeGridlinesVisible(false);

         plot.setBackgroundPaint(new Color(234,234,234));
         AreaRenderer renderer = (AreaRenderer) plot.getRenderer();
         renderer.setEndType(AreaRendererEndType.LEVEL);
      
        
         chart.setBackgroundPaint(Color.GREEN);
         chart.setBackgroundPaint(null);
	 chart.setBackgroundImageAlpha(0.4f); 
            
        
          ChartFrame frame = new ChartFrame("Area  Chart",chart);
          frame.setVisible(true);
          frame.setLocation(5, 370);
          frame.setSize(725,390);
            
        } catch (Exception ex) {
                     Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);
   
        }
    
    
    }
    
    
    
    
    
    private void exit_lbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_lbMouseClicked
        Dialog frame = new Dialog();
        frame.setVisible(true);
    }//GEN-LAST:event_exit_lbMouseClicked

    private void minize_lbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minize_lbMouseClicked
        this.setExtendedState(Fee_Analysis.ICONIFIED);
    }//GEN-LAST:event_minize_lbMouseClicked

    private void AreaChart1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AreaChart1MouseClicked
 pieChart();
    }//GEN-LAST:event_AreaChart1MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
       Adminstrative me = new Adminstrative();
       this.dispose();
       me.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    public void pieChart(){
    
           
  try {
      
      
      String Girls = null;
      String Boys = null;
      String Total = null;

      
    conn = DBConnection.getConnction();
    pps = conn.prepareStatement("SELECT  COUNT(student_ids)  FROM students WHERE Student_Gender = 'Female'");
    rs = pps.executeQuery();             if (rs.next()) {Girls = rs.getString("count(student_ids)");}

    conn = DBConnection.getConnction();
    pps1 = conn.prepareStatement("SELECT  COUNT(student_ids)  FROM students WHERE Student_Gender = 'Male'");
    rs1 = pps1.executeQuery();            if (rs1.next()) {Boys = rs1.getString("count(student_ids)");}
            
    conn = DBConnection.getConnction();
    pps2 = conn.prepareStatement("SELECT  COUNT(student_ids)  FROM students");
    rs2 = pps2.executeQuery();            if (rs2.next()) {Total = rs2.getString("count(student_ids)");}        
           
            
        
         DefaultPieDataset pieDataset = new DefaultPieDataset();
         pieDataset.setValue("Girls", new Integer(Girls));
         pieDataset.setValue("Boys", new Integer(Boys));
         pieDataset.setValue("Total", new Integer(Total));

         
        JFreeChart chart = ChartFactory.createPieChart3D("Students", pieDataset, false, true, Locale.ENGLISH);
        PiePlot3D p = (PiePlot3D) chart.getPlot();
         
        
          ChartFrame frame = new ChartFrame("",chart);
                    frame.setLocation(5, 370);

          frame.setLocation(720, 370);
          frame.setVisible(true);
          frame.setSize(645,200);

        } catch (Exception ex) {
                     Logger.getLogger(Admin_Home.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
    
    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Fee_Analysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fee_Analysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fee_Analysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fee_Analysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fee_Analysis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AreaChart;
    private javax.swing.JLabel AreaChart1;
    private javax.swing.JLabel Line_Chart;
    private javax.swing.JLabel exit_lb;
    private javax.swing.JLabel header_Background;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel minize_lb;
    // End of variables declaration//GEN-END:variables
}
