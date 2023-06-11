/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hotel.management;

import java.awt.Color;

/**
 *
 * @author USER
 */
public class Report extends javax.swing.JFrame {

    public Report() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        frontSide_btn_holder = new javax.swing.JPanel();
        hotel_ma = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        calender = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        report_panelBTN = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        admin_btn = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        expenses = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        archived_booking = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        CMS = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        Tex_manager_lb = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        Top_header = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        exit_lb = new javax.swing.JLabel();
        minize_lb = new javax.swing.JLabel();
        Report_main_Container = new javax.swing.JPanel();
        pCover = new javax.swing.JPanel();
        pGuests = new javax.swing.JPanel();
        pCurrency = new javax.swing.JPanel();
        pOccupancy = new javax.swing.JPanel();
        pLocation = new javax.swing.JPanel();
        pFinancial = new javax.swing.JPanel();
        pExpenses = new javax.swing.JPanel();
        pCoupon = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        frontSide_btn_holder.setBackground(new java.awt.Color(61, 61, 61));
        frontSide_btn_holder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                frontSide_btn_holderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                frontSide_btn_holderMouseExited(evt);
            }
        });
        frontSide_btn_holder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        hotel_ma.setBackground(new java.awt.Color(61, 61, 61));
        hotel_ma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hotel_maMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hotel_maMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hotel_maMouseExited(evt);
            }
        });
        hotel_ma.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_verified_account_30px.png"))); // NOI18N
        jLabel20.setText("  Coupon");
        hotel_ma.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 140, 60));

        jLabel86.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel86.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        hotel_ma.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 60));

        frontSide_btn_holder.add(hotel_ma, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 210, 60));

        calender.setBackground(new java.awt.Color(61, 61, 61));
        calender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calenderMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                calenderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                calenderMouseExited(evt);
            }
        });
        calender.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_handshake_heart_30px.png"))); // NOI18N
        jLabel23.setText("     Guests");
        calender.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 60));

        jLabel87.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel87.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        calender.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 60));

        frontSide_btn_holder.add(calender, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 210, 60));

        report_panelBTN.setBackground(new java.awt.Color(61, 61, 61));
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
        jLabel21.setText("   Currency");
        report_panelBTN.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 60));

        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel88.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        report_panelBTN.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 60));

        frontSide_btn_holder.add(report_panelBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 210, 60));

        admin_btn.setBackground(new java.awt.Color(61, 61, 61));
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
        admin_btn.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 44));

        jLabel91.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel91.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        admin_btn.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 60));

        frontSide_btn_holder.add(admin_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 60));

        expenses.setBackground(new java.awt.Color(61, 61, 61));
        expenses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                expensesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                expensesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                expensesMouseExited(evt);
            }
        });
        expenses.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_general_ledger_30px.png"))); // NOI18N
        jLabel46.setText("     Financial");
        expenses.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 0, 120, 44));

        jLabel92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel92.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        expenses.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 60));

        frontSide_btn_holder.add(expenses, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 210, 60));

        archived_booking.setBackground(new java.awt.Color(61, 61, 61));
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
        jLabel39.setText("  Expenses");
        archived_booking.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 44));

        jLabel85.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel85.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        archived_booking.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 60));

        frontSide_btn_holder.add(archived_booking, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 210, 60));

        CMS.setBackground(new java.awt.Color(61, 61, 61));
        CMS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CMSMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CMSMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CMSMouseExited(evt);
            }
        });
        CMS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_Taxi_Location_30px.png"))); // NOI18N
        jLabel22.setText("   Location");
        CMS.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 60));

        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel90.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        CMS.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 60));

        frontSide_btn_holder.add(CMS, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 210, 60));

        Tex_manager_lb.setBackground(new java.awt.Color(61, 61, 61));
        Tex_manager_lb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tex_manager_lbMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Tex_manager_lbMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Tex_manager_lbMouseExited(evt);
            }
        });
        Tex_manager_lb.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel73.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_weight_care_30px.png"))); // NOI18N
        jLabel73.setText("  Occupancy");
        Tex_manager_lb.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 60));

        jPanel31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel74.setText("Search Records");
        jPanel31.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        Tex_manager_lb.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 130, 30));

        jPanel32.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel75.setText("Search Records");
        jPanel32.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel76.setText("Search Records");
        jPanel33.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel32.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 130, 30));

        Tex_manager_lb.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 130, 30));

        jLabel89.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel89.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_back_15px.png"))); // NOI18N
        Tex_manager_lb.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 30, 60));

        frontSide_btn_holder.add(Tex_manager_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 210, 60));

        jPanel1.add(frontSide_btn_holder, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 760));

        Top_header.setBackground(new java.awt.Color(82, 120, 152));
        Top_header.setMinimumSize(new java.awt.Dimension(990, 100));
        Top_header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Hi Admin,  Welcome To Report  Management");
        Top_header.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, 30));

        exit_lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit_lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_delete_18px_1.png"))); // NOI18N
        exit_lb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit_lbMouseClicked(evt);
            }
        });
        Top_header.add(exit_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 0, 50, 60));

        minize_lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minize_lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hotel/management/images/icons8_minus_19px.png"))); // NOI18N
        minize_lb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minize_lbMouseClicked(evt);
            }
        });
        Top_header.add(minize_lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 0, 40, 60));

        jPanel1.add(Top_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 1140, 60));

        Report_main_Container.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout pCoverLayout = new javax.swing.GroupLayout(pCover);
        pCover.setLayout(pCoverLayout);
        pCoverLayout.setHorizontalGroup(
            pCoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
        );
        pCoverLayout.setVerticalGroup(
            pCoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        Report_main_Container.add(pCover, "card2");

        javax.swing.GroupLayout pGuestsLayout = new javax.swing.GroupLayout(pGuests);
        pGuests.setLayout(pGuestsLayout);
        pGuestsLayout.setHorizontalGroup(
            pGuestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
        );
        pGuestsLayout.setVerticalGroup(
            pGuestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        Report_main_Container.add(pGuests, "card2");

        javax.swing.GroupLayout pCurrencyLayout = new javax.swing.GroupLayout(pCurrency);
        pCurrency.setLayout(pCurrencyLayout);
        pCurrencyLayout.setHorizontalGroup(
            pCurrencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
        );
        pCurrencyLayout.setVerticalGroup(
            pCurrencyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        Report_main_Container.add(pCurrency, "card2");

        javax.swing.GroupLayout pOccupancyLayout = new javax.swing.GroupLayout(pOccupancy);
        pOccupancy.setLayout(pOccupancyLayout);
        pOccupancyLayout.setHorizontalGroup(
            pOccupancyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
        );
        pOccupancyLayout.setVerticalGroup(
            pOccupancyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        Report_main_Container.add(pOccupancy, "card2");

        javax.swing.GroupLayout pLocationLayout = new javax.swing.GroupLayout(pLocation);
        pLocation.setLayout(pLocationLayout);
        pLocationLayout.setHorizontalGroup(
            pLocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
        );
        pLocationLayout.setVerticalGroup(
            pLocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        Report_main_Container.add(pLocation, "card2");

        javax.swing.GroupLayout pFinancialLayout = new javax.swing.GroupLayout(pFinancial);
        pFinancial.setLayout(pFinancialLayout);
        pFinancialLayout.setHorizontalGroup(
            pFinancialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
        );
        pFinancialLayout.setVerticalGroup(
            pFinancialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        Report_main_Container.add(pFinancial, "card2");

        javax.swing.GroupLayout pExpensesLayout = new javax.swing.GroupLayout(pExpenses);
        pExpenses.setLayout(pExpensesLayout);
        pExpensesLayout.setHorizontalGroup(
            pExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
        );
        pExpensesLayout.setVerticalGroup(
            pExpensesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        Report_main_Container.add(pExpenses, "card2");

        pCoupon.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pCouponLayout = new javax.swing.GroupLayout(pCoupon);
        pCoupon.setLayout(pCouponLayout);
        pCouponLayout.setHorizontalGroup(
            pCouponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1140, Short.MAX_VALUE)
        );
        pCouponLayout.setVerticalGroup(
            pCouponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        Report_main_Container.add(pCoupon, "card2");

        jPanel1.add(Report_main_Container, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 1140, 700));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 760));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void hotel_maMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hotel_maMouseClicked
       pCover.hide();
        pGuests.hide();
        pCurrency.hide();
        pLocation.hide();
        pFinancial.hide();
        pExpenses.hide();
        pCoupon.setVisible(true);    
    }//GEN-LAST:event_hotel_maMouseClicked

    private void hotel_maMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hotel_maMouseEntered
        hotel_ma.setBackground(new Color(33,173,178));
    }//GEN-LAST:event_hotel_maMouseEntered

    private void hotel_maMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hotel_maMouseExited
        hotel_ma.setBackground(new Color(61,61,61));
    }//GEN-LAST:event_hotel_maMouseExited

    private void calenderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calenderMouseClicked
   
        
        pCover.hide();
        pGuests.setVisible(true);
        pCurrency.hide();
        pLocation.hide();
        pOccupancy.hide();
        pFinancial.hide();
        pExpenses.hide();
        pCoupon.hide();
      
    }//GEN-LAST:event_calenderMouseClicked

    private void calenderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calenderMouseEntered
        calender.setBackground(new Color(33,173,178));
    }//GEN-LAST:event_calenderMouseEntered

    private void calenderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calenderMouseExited
        calender.setBackground(new Color(61,61,61));
    }//GEN-LAST:event_calenderMouseExited

    private void admin_btnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btnMouseClicked
        if(!pCover.isShowing()){
        
        pCover.setVisible(true);
        pGuests.hide();
        pCurrency.hide();
        pLocation.hide();
        pOccupancy.hide();
        pFinancial.hide();
        pExpenses.hide();
        pCoupon.hide();
       }else{
         this.dispose();
        Admin_Home.getObj().setVisible(true);
       
       }
        
   
    }//GEN-LAST:event_admin_btnMouseClicked

    private void admin_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btnMouseEntered
        admin_btn.setBackground(new Color(82,120,152));
    }//GEN-LAST:event_admin_btnMouseEntered

    private void admin_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admin_btnMouseExited
        admin_btn.setBackground(new Color(61,61,61));
    }//GEN-LAST:event_admin_btnMouseExited

    private void expensesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expensesMouseClicked
        pCover.hide();
        pGuests.hide();
        pCurrency.hide();
        pLocation.hide();
                pOccupancy.hide();

        pFinancial.setVisible(true);
        pExpenses.hide();
        pCoupon.hide();        // TODO add your handling code here:
    }//GEN-LAST:event_expensesMouseClicked

    private void expensesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expensesMouseEntered
        expenses.setBackground(new Color(33,173,178));
    }//GEN-LAST:event_expensesMouseEntered

    private void expensesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_expensesMouseExited
        expenses.setBackground(new Color(61,61,61));
    }//GEN-LAST:event_expensesMouseExited

    private void archived_bookingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_archived_bookingMouseClicked
        pCover.hide();
        pGuests.hide();
        pCurrency.hide();
                pOccupancy.hide();

        pLocation.hide();
        pFinancial.hide();
        pExpenses.setVisible(true);
        pCoupon.hide();    
    }//GEN-LAST:event_archived_bookingMouseClicked

    private void archived_bookingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_archived_bookingMouseEntered
        archived_booking.setBackground(new Color(33,173,178));
    }//GEN-LAST:event_archived_bookingMouseEntered

    private void archived_bookingMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_archived_bookingMouseExited
        archived_booking.setBackground(new Color(61,61,61));
    }//GEN-LAST:event_archived_bookingMouseExited

    private void CMSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMSMouseClicked
   pCover.hide();
        pGuests.hide();
        pCurrency.hide();
        pLocation.setVisible(true);
        pFinancial.hide();
        pOccupancy.hide();
        pExpenses.hide();
        pCoupon.hide();
    }//GEN-LAST:event_CMSMouseClicked

    private void CMSMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMSMouseEntered
        CMS.setBackground(new Color(33,173,178));
    }//GEN-LAST:event_CMSMouseEntered

    private void CMSMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CMSMouseExited
        CMS.setBackground(new Color(61,61,61));
    }//GEN-LAST:event_CMSMouseExited

    private void Tex_manager_lbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tex_manager_lbMouseClicked
             pCover.hide();
        pGuests.hide();
                
        pCurrency.hide();
        
        pOccupancy.setVisible(true);
        pLocation.hide();
        pFinancial.hide();
        pExpenses.hide();
        pCoupon.hide();       
    }//GEN-LAST:event_Tex_manager_lbMouseClicked

    private void Tex_manager_lbMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tex_manager_lbMouseEntered
        Tex_manager_lb.setBackground(new Color(33,173,178));
    }//GEN-LAST:event_Tex_manager_lbMouseEntered

    private void Tex_manager_lbMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tex_manager_lbMouseExited
        Tex_manager_lb.setBackground(new Color(61,61,61));
    }//GEN-LAST:event_Tex_manager_lbMouseExited

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

    private void report_panelBTNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_report_panelBTNMouseExited
        report_panelBTN.setBackground(new Color(61,61,61));
    }//GEN-LAST:event_report_panelBTNMouseExited

    private void report_panelBTNMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_report_panelBTNMouseEntered
        report_panelBTN.setBackground(new Color(33,173,178));
    }//GEN-LAST:event_report_panelBTNMouseEntered

    private void report_panelBTNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_report_panelBTNMouseClicked
      pCover.hide();
        pGuests.hide();
        pCurrency.setVisible(true);
        pLocation.hide();
                pOccupancy.hide();

        pFinancial.hide();
        pExpenses.hide();
        pCoupon.hide();
    }//GEN-LAST:event_report_panelBTNMouseClicked

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
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Report().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CMS;
    private javax.swing.JPanel Report_main_Container;
    private javax.swing.JPanel Tex_manager_lb;
    private javax.swing.JPanel Top_header;
    private javax.swing.JPanel admin_btn;
    private javax.swing.JPanel archived_booking;
    private javax.swing.JPanel calender;
    private javax.swing.JLabel exit_lb;
    private javax.swing.JPanel expenses;
    private javax.swing.JPanel frontSide_btn_holder;
    private javax.swing.JPanel hotel_ma;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JLabel minize_lb;
    private javax.swing.JPanel pCoupon;
    private javax.swing.JPanel pCover;
    private javax.swing.JPanel pCurrency;
    private javax.swing.JPanel pExpenses;
    private javax.swing.JPanel pFinancial;
    private javax.swing.JPanel pGuests;
    private javax.swing.JPanel pLocation;
    private javax.swing.JPanel pOccupancy;
    private javax.swing.JPanel report_panelBTN;
    // End of variables declaration//GEN-END:variables
}
