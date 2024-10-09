/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package assignment.View;

import static assignment.DAO.announceDAO.announceWar;
import assignment.View.Employee.AddEmployee;
import assignment.Entity.Employee;
import assignment.Service.EmployeeService;
import assignment.View.Employee.EditEmployee;
import assignment.View.Employee.ViewEmployeeInfo;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Chezis P
 */
public class EmployeeUI extends javax.swing.JPanel {

    private EmployeeService service;
    
    public EmployeeUI() {
        initComponents();
        initEmployeeTableConfig();
        initEmployeeData();
        onLoadIncrement();
    }
    
    private Font setDefaultFont() {
        Font f = new Font("Segoe UI", Font.BOLD, 20);
        return f;
    }
    
    private Font setBiggerFont() {
        Font f = new Font("Segoe UI", Font.BOLD, 24);
        return f;
    }
    
    private void initEmployeeData() {
        this.service = new EmployeeService();
        DefaultTableModel model = (DefaultTableModel) tblEmployeeList.getModel();
        model.setRowCount(0);
        for ( Employee x :  service.getData() ) {
            model.addRow(new Object[]{
                x.getID(),
                x.getName(),
                x.getAge(),
                x.getDesc(),
                x.getDpmName()
            });
        }
    }
    

    private void exportToCSV(JTable table) throws IOException {
        FileWriter csvWriter = new FileWriter("src/main/resources/output/employee-list.csv");
        for (int i = 0; i < table.getColumnCount(); i++) {
            csvWriter.write(table.getColumnName(i) + ",");
        }
        csvWriter.write("\n");

        for (int i = 0; i < table.getRowCount(); i++) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                csvWriter.write(table.getValueAt(i, j).toString() + ",");
            }
            csvWriter.write("\n");
        }
        csvWriter.close();
        JOptionPane.showMessageDialog(null, "Exported successfully!");
    }
    
    private void onLoadIncrement() {
        service.onLoad();
    }
    
    private static void setColumnWidth(JTable table, int columnIndex, int width) {
        table.getColumnModel().getColumn(columnIndex).setPreferredWidth(width);
    }
    
    private void initEmployeeTableConfig() {
        tblEmployeeList.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblEmployeeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Chọn 1 hàng tại một thời điểm
        tblEmployeeList.setRowSelectionAllowed(true); // Cho phép chọn cả hàng
        tblEmployeeList.setColumnSelectionAllowed(false); // Chỉ cho phép chọn hàng, không phải ô

        DefaultTableModel table = (DefaultTableModel) tblEmployeeList.getModel();

        int firstColumnWidth = 50; // Độ rộng của cột 0

        // Lấy tổng chiều rộng của bảng
//        int tableWidth = tblEmployeeList.getParent().getWidth();
        int tableWidth = 1051;

        // Tính toán lại độ rộng còn lại sau khi trừ độ rộng của cột 0
        int remainingWidth = tableWidth - firstColumnWidth;

        int column1Width = (remainingWidth / 4) - 40;
        int column2Width = (remainingWidth / 4);
        int column3Width = (remainingWidth / 4);
        int column4Width = (remainingWidth / 4) + 40;
        
        setColumnWidth(tblEmployeeList, 0, firstColumnWidth);
        setColumnWidth(tblEmployeeList, 1, column1Width);
        setColumnWidth(tblEmployeeList, 2, column2Width);
        setColumnWidth(tblEmployeeList, 3, column3Width);
        setColumnWidth(tblEmployeeList, 4, column4Width);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa

        // Áp dụng renderer căn giữa cho cột 0 và cột 1
        tblEmployeeList.getColumnModel().getColumn(0).setCellRenderer(centerRenderer); // Cột 0
        tblEmployeeList.getColumnModel().getColumn(1).setCellRenderer(centerRenderer); // Cột 1

        // Căn lề trái hoặc phải cho các cột còn lại nếu cần
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.LEFT); // Căn trái

        tblEmployeeList.getColumnModel().getColumn(2).setCellRenderer(leftRenderer); // Cột 2
        tblEmployeeList.getColumnModel().getColumn(3).setCellRenderer(leftRenderer); // Cột 3
        tblEmployeeList.getColumnModel().getColumn(4).setCellRenderer(leftRenderer); // Cột 4

        // Áp dụng renderer cho tất cả các cột để thay đổi màu nền khi hàng được chọn
        DefaultTableCellRenderer highlightRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (isSelected) {       
                    cell.setBackground(Color.LIGHT_GRAY);
                } else {
                    cell.setBackground(Color.WHITE);
                }
                return cell;
            }
        };

        for (int i = 0; i < tblEmployeeList.getColumnCount(); i++) {
            tblEmployeeList.getColumnModel().getColumn(i).setCellRenderer(highlightRenderer);
        }

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrPane1 = new javax.swing.JScrollPane();
        tblEmployeeList = new javax.swing.JTable();
        lblAddEmployee = new javax.swing.JLabel();
        lblEditEmployee = new javax.swing.JLabel();
        lblCheckEmployeeInfo = new javax.swing.JLabel();
        lblDeleteEmployee = new javax.swing.JLabel();
        lblExportXLS = new javax.swing.JLabel();
        lblRefresh = new javax.swing.JLabel();
        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1050, 530));

        tblEmployeeList.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblEmployeeList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblEmployeeList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên", "Tuổi", "Mô tả", "Phòng ban"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmployeeList.setColumnSelectionAllowed(true);
        tblEmployeeList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblEmployeeList.setGridColor(new java.awt.Color(255, 255, 255));
        tblEmployeeList.setRequestFocusEnabled(false);
        tblEmployeeList.setRowHeight(35);
        tblEmployeeList.setSelectionBackground(new java.awt.Color(227, 227, 227));
        tblEmployeeList.getTableHeader().setReorderingAllowed(false);
        tblEmployeeList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmployeeListMouseClicked(evt);
            }
        });
        scrPane1.setViewportView(tblEmployeeList);
        tblEmployeeList.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        lblAddEmployee.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblAddEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add-user_1.png"))); // NOI18N
        lblAddEmployee.setText("Thêm");
        lblAddEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddEmployeeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAddEmployeeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAddEmployeeMouseExited(evt);
            }
        });

        lblEditEmployee.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblEditEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/xem-tt.png"))); // NOI18N
        lblEditEmployee.setText("Cập nhật");
        lblEditEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblEditEmployeeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblEditEmployeeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblEditEmployeeMouseExited(evt);
            }
        });

        lblCheckEmployeeInfo.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblCheckEmployeeInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit-info_1.png"))); // NOI18N
        lblCheckEmployeeInfo.setText("Chi tiết");
        lblCheckEmployeeInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCheckEmployeeInfoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCheckEmployeeInfoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCheckEmployeeInfoMouseExited(evt);
            }
        });

        lblDeleteEmployee.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblDeleteEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/duoi-viec.png"))); // NOI18N
        lblDeleteEmployee.setText("Đuổi việc");
        lblDeleteEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDeleteEmployeeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblDeleteEmployeeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblDeleteEmployeeMouseExited(evt);
            }
        });

        lblExportXLS.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblExportXLS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/xls_1.png"))); // NOI18N
        lblExportXLS.setText("Xuất File");
        lblExportXLS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExportXLSMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblExportXLSMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblExportXLSMouseExited(evt);
            }
        });

        lblRefresh.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh-page.png"))); // NOI18N
        lblRefresh.setText("Làm mới");
        lblRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRefreshMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblRefreshMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRefreshMouseExited(evt);
            }
        });

        lblSearch.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblSearch.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        lblSearch.setText("Tìm kiếm");
        lblSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblSearch.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        lblSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSearchMouseClicked(evt);
            }
        });

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSearch.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 255), 1, true), javax.swing.BorderFactory.createEmptyBorder(0, 7, 0, 0)));
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAddEmployee)
                .addGap(18, 18, 18)
                .addComponent(lblEditEmployee)
                .addGap(18, 18, 18)
                .addComponent(lblCheckEmployeeInfo)
                .addGap(18, 18, 18)
                .addComponent(lblDeleteEmployee)
                .addGap(18, 18, 18)
                .addComponent(lblExportXLS)
                .addGap(18, 18, 18)
                .addComponent(lblRefresh)
                .addGap(26, 26, 26)
                .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSearch)
                .addContainerGap())
            .addComponent(scrPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDeleteEmployee)
                            .addComponent(lblEditEmployee)
                            .addComponent(lblCheckEmployeeInfo)
                            .addComponent(lblExportXLS)
                            .addComponent(lblRefresh)
                            .addComponent(lblSearch)
                            .addComponent(txtSearch))
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAddEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)))
                .addComponent(scrPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblEmployeeListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmployeeListMouseClicked

    }//GEN-LAST:event_tblEmployeeListMouseClicked

    private void lblEditEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditEmployeeMouseClicked
        DefaultTableModel model = (DefaultTableModel) tblEmployeeList.getModel();
        int index = tblEmployeeList.getSelectedRow();
        
        if ( index == -1 ) {
            announceWar("Không thể sửa thông tin Employee khi chưa chọn !");
            return;
        }
        
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (parentFrame != null) {
            parentFrame.dispose();
        }
        
        int ID = Integer.parseInt(model.getValueAt(index, 0).toString());
        String name = model.getValueAt(index, 1).toString();
        int age = Integer.parseInt(model.getValueAt(index, 2).toString());
        String desc = model.getValueAt(index, 3).toString();
        String pb = model.getValueAt(index, 4).toString();
        
        EditEmployee form = new EditEmployee(ID, name, age, desc, pb);
        form.setVisible(true);
    }//GEN-LAST:event_lblEditEmployeeMouseClicked

    private void lblCheckEmployeeInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCheckEmployeeInfoMouseClicked
        int index = tblEmployeeList.getSelectedRow();
        if ( index == -1 ) {
            announceWar("Không thể xem thông tin Employee khi chưa chọn !");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tblEmployeeList.getModel();
        String name = model.getValueAt(index, 1).toString();
        String age = model.getValueAt(index, 2).toString();
        String desc = model.getValueAt(index, 3).toString();
        String dpmName = model.getValueAt(index, 4).toString();
        ViewEmployeeInfo form = new ViewEmployeeInfo(name, age, desc, dpmName);
        form.setVisible(true);
    }//GEN-LAST:event_lblCheckEmployeeInfoMouseClicked

    private void lblExportXLSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExportXLSMouseClicked
        try {
            exportToCSV(tblEmployeeList);
        } catch (IOException ex) {
            Logger.getLogger(EmployeeUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblExportXLSMouseClicked

    
    private void lblAddEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddEmployeeMouseClicked
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (parentFrame != null) {
            parentFrame.dispose();
        }
        AddEmployee form = new AddEmployee();
        form.setVisible(true);
    }//GEN-LAST:event_lblAddEmployeeMouseClicked

    private void lblRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRefreshMouseClicked
        initEmployeeData();
    }//GEN-LAST:event_lblRefreshMouseClicked

    private void lblSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSearchMouseClicked
        String s = txtSearch.getText();
        searchEmployee(s);
    }//GEN-LAST:event_lblSearchMouseClicked

    private void lblAddEmployeeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddEmployeeMouseEntered
        lblAddEmployee.setFont(setBiggerFont());
    }//GEN-LAST:event_lblAddEmployeeMouseEntered

    private void lblAddEmployeeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddEmployeeMouseExited
        lblAddEmployee.setFont(setDefaultFont());
    }//GEN-LAST:event_lblAddEmployeeMouseExited

    private void lblEditEmployeeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditEmployeeMouseEntered
        lblEditEmployee.setFont(setBiggerFont());
    }//GEN-LAST:event_lblEditEmployeeMouseEntered

    private void lblEditEmployeeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEditEmployeeMouseExited
        lblEditEmployee.setFont(setDefaultFont());
    }//GEN-LAST:event_lblEditEmployeeMouseExited

    private void lblCheckEmployeeInfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCheckEmployeeInfoMouseEntered
        lblCheckEmployeeInfo.setFont(setBiggerFont());
    }//GEN-LAST:event_lblCheckEmployeeInfoMouseEntered

    private void lblCheckEmployeeInfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCheckEmployeeInfoMouseExited
        lblCheckEmployeeInfo.setFont(setDefaultFont());
    }//GEN-LAST:event_lblCheckEmployeeInfoMouseExited

    private void lblDeleteEmployeeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDeleteEmployeeMouseExited
        lblDeleteEmployee.setFont(setDefaultFont());
    }//GEN-LAST:event_lblDeleteEmployeeMouseExited

    private void lblDeleteEmployeeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDeleteEmployeeMouseEntered
        lblDeleteEmployee.setFont(setBiggerFont());
    }//GEN-LAST:event_lblDeleteEmployeeMouseEntered

    private void lblExportXLSMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExportXLSMouseEntered
        lblExportXLS.setFont(setBiggerFont());
    }//GEN-LAST:event_lblExportXLSMouseEntered

    private void lblExportXLSMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExportXLSMouseExited
        lblExportXLS.setFont(setDefaultFont());
    }//GEN-LAST:event_lblExportXLSMouseExited

    private void lblRefreshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRefreshMouseEntered
        lblRefresh.setFont(setBiggerFont());
    }//GEN-LAST:event_lblRefreshMouseEntered

    private void lblRefreshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRefreshMouseExited
        lblRefresh.setFont(setDefaultFont());
    }//GEN-LAST:event_lblRefreshMouseExited

    private void lblDeleteEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDeleteEmployeeMouseClicked
        int index = tblEmployeeList.getSelectedRow();
        if ( index == -1 ) {
            announceWar("Không thể xóa Employee khi chưa chọn !");
            return;
        }
        
        DefaultTableModel model = (DefaultTableModel) tblEmployeeList.getModel();
        int ID = (int) model.getValueAt(index, 0);
        boolean b = service.deleteEmployee(ID);
        
        if ( b == true ) {
            initEmployeeData();
            JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            
            String crAdmin;
            
            String[] parts = parentFrame.getTitle().split("Admin : "); 
            crAdmin = parts[0];
            
            parentFrame.setVisible(false);

            SwingUtilities.invokeLater(() -> {
                Index Index = new Index(crAdmin);
                Index.setVisible(true);
            });
        }
    }//GEN-LAST:event_lblDeleteEmployeeMouseClicked

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String s = txtSearch.getText();
            searchEmployee(s);
        }
    }//GEN-LAST:event_txtSearchKeyPressed

    private void searchEmployee(String input) {
        List<Object> objList = service.searchEmployee(input);
        DefaultTableModel model = (DefaultTableModel) tblEmployeeList.getModel();
        if (objList != null) {
            model.setRowCount(0);
            for ( Object x : objList ) {
                model.addRow((Object[]) x);
            }
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAddEmployee;
    private javax.swing.JLabel lblCheckEmployeeInfo;
    private javax.swing.JLabel lblDeleteEmployee;
    private javax.swing.JLabel lblEditEmployee;
    private javax.swing.JLabel lblExportXLS;
    private javax.swing.JLabel lblRefresh;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JScrollPane scrPane1;
    private javax.swing.JTable tblEmployeeList;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}