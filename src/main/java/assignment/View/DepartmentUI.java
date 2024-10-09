/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package assignment.View;

import assignment.DAO.announceDAO;
import static assignment.DAO.announceDAO.announceErr;
import assignment.Entity.Department;
import assignment.Service.DepartmentService;
import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Chezis P
 */
public class DepartmentUI extends javax.swing.JPanel {

    private DepartmentService service;
    private boolean isViewing = false;
    private boolean isEditing = false;
    
    public DepartmentUI() {
        initComponents();
        initDepartmentTableConfig();
        initDepartmentData();
        txtDesc.setMargin(new Insets(0, 2, 10, 2));
    }
    
    private void initDepartmentData() {
        this.service = new  DepartmentService();
        DefaultTableModel model = (DefaultTableModel) tblDepartmentList.getModel();
        model.setRowCount(0);
        for ( Department x :  service.getData() ) {
            model.addRow(new Object[]{
                x.getID(),
                x.getName(),    
                x.getDesc()
            });
        }
    }
    

    private void exportToCSV(JTable table) throws IOException {
        FileWriter csvWriter = new FileWriter("src/main/resources/output/employee_list.csv");
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
    
    
    private static void setColumnWidth(JTable table, int columnIndex, int width) {
        table.getColumnModel().getColumn(columnIndex).setPreferredWidth(width);
    }    
    
    private void initDepartmentTableConfig() {
        tblDepartmentList.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblDepartmentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Chọn 1 hàng tại một thời điểm
        tblDepartmentList.setRowSelectionAllowed(true); // Cho phép chọn cả hàng
        tblDepartmentList.setColumnSelectionAllowed(false); // Chỉ cho phép chọn hàng, không phải ô

        DefaultTableModel table = (DefaultTableModel) tblDepartmentList.getModel();

        int firstColumnWidth = 50; // Độ rộng của cột 0
        setColumnWidth(tblDepartmentList, 0, firstColumnWidth);

        // Lấy tổng chiều rộng của bảng
//        int tableWidth = tblDepartmentList.getParent().getWidth();
        int tableWidth = 1050;

        // Tính toán lại độ rộng còn lại sau khi trừ độ rộng của cột 0
        int remainingWidth = tableWidth - firstColumnWidth;

        // Giữ nguyên điều chỉnh +/- 400 cho cột 1 và cột 2
        int column1Width = (remainingWidth / 2) - 400;
        int column2Width = (remainingWidth / 2) + 400;

        // Set độ rộng cho cột 1 và cột 2
        setColumnWidth(tblDepartmentList, 1, column1Width);
        setColumnWidth(tblDepartmentList, 2, column2Width);

        // Tạo renderer để căn giữa nội dung cho cột 0 và cột 1
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa

        // Áp dụng renderer căn giữa cho cột 0 và cột 1
        tblDepartmentList.getColumnModel().getColumn(0).setCellRenderer(centerRenderer); // Cột 0
        tblDepartmentList.getColumnModel().getColumn(1).setCellRenderer(centerRenderer); // Cột 1

        // Áp dụng renderer cho tất cả các cột để thay đổi màu nền khi hàng được chọn
        DefaultTableCellRenderer highlightRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (isSelected) {
                    cell.setBackground(Color.LIGHT_GRAY); // Màu nền xám nhạt khi hàng được chọn
                } else {
                    cell.setBackground(Color.WHITE); // Màu nền mặc định khi không được chọn
                }

                return cell;
            }
        };

        for (int i = 0; i < tblDepartmentList.getColumnCount(); i++) {
            tblDepartmentList.getColumnModel().getColumn(i).setCellRenderer(highlightRenderer);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnClear = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        pane1 = new javax.swing.JPanel();
        scrPane = new javax.swing.JScrollPane();
        tblDepartmentList = new javax.swing.JTable();
        btnSearchByName = new javax.swing.JButton();
        btnExportCSV = new javax.swing.JButton();
        lblSTT = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        lblDes = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        txtDesc = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        btnClear.setBackground(new java.awt.Color(255, 255, 255));
        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnClear.setForeground(new java.awt.Color(0, 102, 255));
        btnClear.setText("Clear");
        btnClear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(255, 255, 255));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(0, 102, 255));
        btnEdit.setText("Edit");
        btnEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(0, 102, 255));
        btnDelete.setText("Delete");
        btnDelete.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        pane1.setBackground(new java.awt.Color(255, 255, 255));

        tblDepartmentList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblDepartmentList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "ID", "Tên Phòng", "Mô Tả"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDepartmentList.setColumnSelectionAllowed(true);
        tblDepartmentList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblDepartmentList.setGridColor(new java.awt.Color(255, 255, 255));
        tblDepartmentList.setRequestFocusEnabled(false);
        tblDepartmentList.setRowHeight(35);
        tblDepartmentList.setSelectionBackground(new java.awt.Color(227, 227, 227));
        tblDepartmentList.getTableHeader().setReorderingAllowed(false);
        tblDepartmentList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDepartmentListMouseClicked(evt);
            }
        });
        scrPane.setViewportView(tblDepartmentList);
        tblDepartmentList.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout pane1Layout = new javax.swing.GroupLayout(pane1);
        pane1.setLayout(pane1Layout);
        pane1Layout.setHorizontalGroup(
            pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1029, Short.MAX_VALUE)
        );
        pane1Layout.setVerticalGroup(
            pane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrPane, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );

        btnSearchByName.setBackground(new java.awt.Color(255, 255, 255));
        btnSearchByName.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnSearchByName.setForeground(new java.awt.Color(255, 153, 0));
        btnSearchByName.setText("Search");
        btnSearchByName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 102, 0)));
        btnSearchByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchByNameActionPerformed(evt);
            }
        });

        btnExportCSV.setBackground(new java.awt.Color(255, 255, 255));
        btnExportCSV.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnExportCSV.setForeground(new java.awt.Color(0, 102, 255));
        btnExportCSV.setText("Export To CSV");
        btnExportCSV.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));
        btnExportCSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExportCSVMouseClicked(evt);
            }
        });
        btnExportCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportCSVActionPerformed(evt);
            }
        });

        lblSTT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSTT.setText("ID :");

        btnRefresh.setBackground(new java.awt.Color(255, 255, 255));
        btnRefresh.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(0, 102, 255));
        btnRefresh.setText("Refresh");
        btnRefresh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        lblName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblName.setText("Tên Phòng :");

        lblDes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDes.setText("Mô Tả : ");

        txtSearch.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(255, 153, 0));
        txtSearch.setAlignmentX(1.0F);
        txtSearch.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0)), javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0)));
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });

        txtID.setEditable(false);
        txtID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtID.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0)));

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(0, 102, 255));
        btnAdd.setText("Add");
        btnAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtName.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0)));

        txtDesc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtDesc.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtDesc.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDes, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSTT, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblName)))
                    .addComponent(txtDesc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearchByName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnExportCSV, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblSTT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblName)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDesc))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 24, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnExportCSV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearchByName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(7, 7, 7)
                .addComponent(pane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void clear() {
        txtDesc.setText("");
        txtName.setText("");
        txtID.setText("");
        txtSearch.setText("");
        
        txtName.setEditable(true);
        txtDesc.setEditable(true);
        
        isViewing = false;
        initDepartmentData();
    }
    
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if ( isViewing == false ) {
            announceErr("Bạn không xem 1 department nào !");
        } else if (isEditing == false) {
            txtName.setEditable(true);
            txtDesc.setEditable(true);
            isEditing = true;
            btnEdit.setText("Confirm");
        } else {
            txtName.setEditable(false);
            txtDesc.setEditable(false);
            service.editCurrentDepartment(Integer.parseInt(txtID.getText()), txtName.getText(), txtDesc.getText());
            isEditing = false;
            btnEdit.setText("Edit");
            initDepartmentData();
            announceDAO.announceInfo("Đã cập nhật");
        }
    }//GEN-LAST:event_btnEditActionPerformed

    
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if ( !isViewing ) { 
            announceErr("Bạn không xem 1 Department nào !");
        } else {
            service.deleteCurrentDepartment(Integer.parseInt(txtID.getText()), txtName.getText());
            clear();
            initDepartmentData();
            
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void tblDepartmentListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDepartmentListMouseClicked
        int index = tblDepartmentList.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tblDepartmentList.getModel();
        txtID.setText(model.getValueAt(index, 0).toString());
        txtName.setText(model.getValueAt(index, 1).toString());
        txtDesc.setText(model.getValueAt(index, 2).toString());
        txtID.setEditable(false);
        txtName.setEditable(false);
        txtDesc.setEditable(false);
        isViewing = true;
        isEditing = false; 
        btnEdit.setText("Edit");
    }//GEN-LAST:event_tblDepartmentListMouseClicked

    private void btnSearchByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchByNameActionPerformed
        searchByDepartmentName();
    }//GEN-LAST:event_btnSearchByNameActionPerformed

    private void btnExportCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportCSVActionPerformed
        try {
            exportToCSV(tblDepartmentList);
        } catch (IOException ex) {
            Logger.getLogger(DepartmentUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportCSVActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        initDepartmentData();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            searchByDepartmentName();
        }
    }//GEN-LAST:event_txtSearchKeyPressed

    private void searchByDepartmentName() {
        if ( txtSearch.getText().length() <= 0 ) {
            announceErr("Vui lòng nhập tên phòng hoặc ID !");
        } else { 
            Department dpm = service.searchByName(txtSearch.getText());
            if ( dpm != null ) {
                DefaultTableModel model = (DefaultTableModel) tblDepartmentList.getModel();
                model.setRowCount(0);
                model.addRow(new Object[]{
                    dpm.getID(),
                    dpm.getName(),
                    dpm.getDesc()
                });
            } else {
                announceErr("Không tìm thấy Department nào với dữ liệu bạn nhập !");
            }
        }
    }
    
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if ( isViewing == true ) {
            announceErr("Bạn đang xem 1 Department !");
        } else {
            int id = service.addNewDepartment(txtName.getText(), txtDesc.getText());
            if ( id != 0 ) {
                DefaultTableModel model = (DefaultTableModel) tblDepartmentList.getModel();
                model.addRow(new Object[]{
                    id,
                    txtName.getText(),
                    txtDesc.getText()
                });
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnExportCSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExportCSVMouseClicked
        try {
            exportToCSV(tblDepartmentList);
        } catch (IOException ex) {
            Logger.getLogger(EmployeeUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportCSVMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExportCSV;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearchByName;
    private javax.swing.JLabel lblDes;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblSTT;
    private javax.swing.JPanel pane1;
    private javax.swing.JScrollPane scrPane;
    private javax.swing.JTable tblDepartmentList;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
