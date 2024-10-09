/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package assignment.View;

import assignment.DAO.announceDAO;
import java.awt.*;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author Chezis P
 */
public class Index extends javax.swing.JFrame {

    public static String currentAdmin;
    
    public Index() {
        announceDAO.announceErr("Vui lòng đăng nhập và thử lại !");
        this.setVisible(false);
        Login form = new Login();
        form.setVisible(true);
    }
    
    public Index(String s) {
        initComponents();
        initDefaultData(s);
    }
    
    public void initDefaultData(String s) {
        this.setTitle("Data Management | Admin : " + s);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setBackground(Color.white);
        getContentPane().setBackground(Color.white);
        Index.currentAdmin = s;
        lblCurrentAdmin.setText("User: " + currentAdmin);
        ClearView();
        Department_UI.setVisible(true);
    }
    
    public void ClearView() {
        Department_UI.setVisible(false);
        Employee_UI.setVisible(false);
        Chart_UI.setVisible(false);
    }
    
    public void triggerValidateCharts() {
        Panel_For_ChartUI.remove(Chart_UI);
        Panel_For_ChartUI.add(Chart_UI);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCurrentAdmin = new javax.swing.JLabel();
        imgProfile = new javax.swing.JLabel();
        imgLogo = new javax.swing.JLabel();
        btnDepartment = new javax.swing.JButton();
        btnEmployee = new javax.swing.JButton();
        btnChart = new javax.swing.JButton();
        Department_UI = new assignment.View.DepartmentUI();
        Employee_UI = new assignment.View.EmployeeUI();
        Panel_For_ChartUI = new javax.swing.JPanel();
        Chart_UI = new assignment.View.ChartUI();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCurrentAdmin.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblCurrentAdmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCurrentAdmin.setText("<CurrentAdmin>");
        getContentPane().add(lblCurrentAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 130, -1));

        imgProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/profile.png"))); // NOI18N
        getContentPane().add(imgProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 130, -1));

        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        getContentPane().add(imgLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 130));

        btnDepartment.setBackground(new java.awt.Color(255, 255, 255));
        btnDepartment.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btnDepartment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/department.png"))); // NOI18N
        btnDepartment.setText("Department");
        btnDepartment.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 15, 0, 0));
        btnDepartment.setBorderPainted(false);
        btnDepartment.setFocusPainted(false);
        btnDepartment.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDepartment.setIconTextGap(10);
        btnDepartment.setMaximumSize(new java.awt.Dimension(167, 32));
        btnDepartment.setMinimumSize(new java.awt.Dimension(167, 32));
        btnDepartment.setPreferredSize(new java.awt.Dimension(167, 32));
        btnDepartment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDepartmentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDepartmentMouseExited(evt);
            }
        });
        btnDepartment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepartmentActionPerformed(evt);
            }
        });
        getContentPane().add(btnDepartment, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 200, 40));

        btnEmployee.setBackground(new java.awt.Color(255, 255, 255));
        btnEmployee.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btnEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/employee.png"))); // NOI18N
        btnEmployee.setText("Employee");
        btnEmployee.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 15, 0, 0));
        btnEmployee.setBorderPainted(false);
        btnEmployee.setFocusPainted(false);
        btnEmployee.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEmployee.setIconTextGap(10);
        btnEmployee.setMaximumSize(new java.awt.Dimension(167, 32));
        btnEmployee.setMinimumSize(new java.awt.Dimension(167, 32));
        btnEmployee.setPreferredSize(new java.awt.Dimension(167, 32));
        btnEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEmployeeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEmployeeMouseExited(evt);
            }
        });
        btnEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeActionPerformed(evt);
            }
        });
        getContentPane().add(btnEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 200, 40));

        btnChart.setBackground(new java.awt.Color(255, 255, 255));
        btnChart.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        btnChart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/chart.png"))); // NOI18N
        btnChart.setText("Dashboard");
        btnChart.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 15, 0, 0));
        btnChart.setBorderPainted(false);
        btnChart.setFocusPainted(false);
        btnChart.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnChart.setIconTextGap(10);
        btnChart.setMaximumSize(new java.awt.Dimension(167, 32));
        btnChart.setMinimumSize(new java.awt.Dimension(167, 32));
        btnChart.setPreferredSize(new java.awt.Dimension(167, 32));
        btnChart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnChartMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnChartMouseExited(evt);
            }
        });
        btnChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChartActionPerformed(evt);
            }
        });
        getContentPane().add(btnChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 200, 40));
        getContentPane().add(Department_UI, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 5, 1050, 540));
        getContentPane().add(Employee_UI, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        Panel_For_ChartUI.add(Chart_UI);

        getContentPane().add(Panel_For_ChartUI, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 1050, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDepartmentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDepartmentMouseEntered
        btnDepartment.setBackground(Color.decode("#bdd6ff"));
    }//GEN-LAST:event_btnDepartmentMouseEntered

    private void btnDepartmentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDepartmentMouseExited
        btnDepartment.setBackground(Color.white);
    }//GEN-LAST:event_btnDepartmentMouseExited

    private void btnEmployeeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmployeeMouseEntered
        btnEmployee.setBackground(Color.decode("#bdd6ff"));
    }//GEN-LAST:event_btnEmployeeMouseEntered

    private void btnEmployeeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEmployeeMouseExited
        btnEmployee.setBackground(Color.white);
    }//GEN-LAST:event_btnEmployeeMouseExited

    private void btnChartMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChartMouseEntered
        btnChart.setBackground(Color.decode("#bdd6ff"));
    }//GEN-LAST:event_btnChartMouseEntered

    private void btnChartMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChartMouseExited
        btnChart.setBackground(Color.white);
    }//GEN-LAST:event_btnChartMouseExited

    private void btnDepartmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepartmentActionPerformed
        ClearView();
        Department_UI.setVisible(true);
    }//GEN-LAST:event_btnDepartmentActionPerformed

    private void btnEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeActionPerformed
        ClearView();
        Employee_UI.setVisible(true);
    }//GEN-LAST:event_btnEmployeeActionPerformed

    private void btnChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChartActionPerformed
        ClearView();
        Chart_UI.setVisible(true);
    }//GEN-LAST:event_btnChartActionPerformed

    public static void main(String args[]) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Window".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private assignment.View.ChartUI Chart_UI;
    private assignment.View.DepartmentUI Department_UI;
    private assignment.View.EmployeeUI Employee_UI;
    private javax.swing.JPanel Panel_For_ChartUI;
    private javax.swing.JButton btnChart;
    private javax.swing.JButton btnDepartment;
    private javax.swing.JButton btnEmployee;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JLabel imgProfile;
    private javax.swing.JLabel lblCurrentAdmin;
    // End of variables declaration//GEN-END:variables
}
