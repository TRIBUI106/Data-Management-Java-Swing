/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package assignment.View.Employee;

import assignment.DAO.EmployeeDAO;
import assignment.Service.EmployeeService;
import assignment.View.Index;
import static assignment.View.Index.currentAdmin;
import java.util.Comparator;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author Chezis P
 */
public class EditEmployee extends javax.swing.JFrame implements EmployeeDAO {

    private EmployeeService service;
    
    public EditEmployee() {
        initComponents();
        setResizable(false);
    }
    
    public EditEmployee(int ID, String Name, int Age, String Desc, String PB) {
        this.service = new EmployeeService();
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle(ID + " | Editing Employee : " + Name);
        txtName.setText(Name);
        txtAge.setText(String.valueOf(Age));
        txtDesc.setText(Desc);
        getPhongBanList();
        setSelectedPhongBan(PB);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                Index form = new Index(currentAdmin);
                dispose();
                form.setVisible(true);
            }
        });
    }
    
    private void getPhongBanList() {
        JComboBox<String> combo = cboDepartmentList;
        List<String> list = getDepartmentList();
        list.sort(Comparator.comparingInt(x -> Integer.parseInt(x.split(" : ")[0])));
        combo.removeAllItems();
        for ( String x : list ) {
            combo.addItem(x);
        }
    }
    
    private void setSelectedPhongBan(String PB) {
        JComboBox<String> combo = cboDepartmentList;
        combo.setSelectedItem(PB);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAddNewUser = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblAge = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        lblDesc = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDesc = new javax.swing.JTextArea();
        lblDpm = new javax.swing.JLabel();
        cboDepartmentList = new javax.swing.JComboBox<>();
        icoAdd = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblAddNewUser.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lblAddNewUser.setText("Editing Employee");

        lblName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblName.setText("Tên người dùng");

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtName.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(0, 7, 0, 0)));

        lblAge.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblAge.setText("Tuổi");

        txtAge.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtAge.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(0, 7, 0, 0)));

        lblDesc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDesc.setText("Mô tả");

        txtDesc.setColumns(20);
        txtDesc.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtDesc.setRows(5);
        txtDesc.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(0, 7, 0, 0)));
        jScrollPane1.setViewportView(txtDesc);

        lblDpm.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDpm.setText("Phòng ban");

        cboDepartmentList.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cboDepartmentList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Danh sách phòng ban" }));
        cboDepartmentList.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        icoAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user-pen (2).png"))); // NOI18N

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnUpdate.setText("UPDATE EMPLOYEE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cboDepartmentList, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lblName)
                        .addGap(177, 177, 177)
                        .addComponent(lblAge))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lblDesc)
                        .addGap(257, 257, 257)
                        .addComponent(lblDpm)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(icoAdd)
                .addGap(18, 18, 18)
                .addComponent(lblAddNewUser)
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icoAdd)
                    .addComponent(lblAddNewUser))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblName)
                    .addComponent(lblAge))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDesc)
                    .addComponent(lblDpm))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cboDepartmentList, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String Title = getTitle();
        String Name = txtName.getText();
        String Age = txtAge.getText();
        String Desc = txtDesc.getText();
        String Dpm = cboDepartmentList.getSelectedItem().toString();
        boolean b = service.updateEmployee(Title, Name, Age, Desc, Dpm);
        if ( b == true ) {
            this.dispose();
            Index index = new Index(currentAdmin);
            index.setVisible(true);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(EditEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cboDepartmentList;
    private javax.swing.JLabel icoAdd;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddNewUser;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblDpm;
    private javax.swing.JLabel lblName;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextArea txtDesc;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
