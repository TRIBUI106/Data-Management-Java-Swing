/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package assignment.View;

import assignment.DAO.DashboardDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author Chezis P
 */


public class ChartUI extends javax.swing.JPanel implements DashboardDAO {

    public ChartUI() {
        initComponents();
        
        JFreeChart pieChart = createChart1(getDatasetOf_Age());
        ChartPanel chartPanel = new ChartPanel(pieChart);
        
        JFreeChart pieChart2 = createChart2(getDatasetOf_NVperPB());
        ChartPanel chartPanel2 = new ChartPanel(pieChart2);
        
        chart1.add(chartPanel);
        chart1.validate();
        chart1.repaint();

        chart2.add(chartPanel2);
        chart2.validate();
        chart2.repaint();
    }
        
    private JFreeChart createChart1(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart("TUỔI CÁC NHÂN VIÊN", dataset, true, true, true);
        return chart;
    }

    private PieDataset getDatasetOf_Age() {
        List<Integer> list = getTuoiEmployee();
//        System.out.println("Danh sách tuổi: " + list); // Kiểm tra danh sách tuổi

        HashMap<Integer, Integer> ageCount = new HashMap<>();
        DefaultPieDataset dataset = new DefaultPieDataset();
        int ageListSize = 0;

        for (int age : list) {
            if (ageCount.containsKey(age)) {
                ageCount.put(age, ageCount.get(age) + 1); 
            } else {
                ageCount.put(age, 1);
            }
        }

        for (Integer key : ageCount.keySet()) {
            ageListSize += ageCount.get(key);
        }
        for (Integer key : ageCount.keySet()) {
            double percentage = ((double) ageCount.get(key) / ageListSize * 100);
            dataset.setValue("Tuổi " + key, percentage);
        }
        return dataset;
    }
    
    private JFreeChart createChart2(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart("SL NHÂN VIÊN / PHÒNG BAN", dataset, true, true, true);
        return chart;
    }

    private PieDataset getDatasetOf_NVperPB() {
        List<String> strList = getCountEmployeePerPB(); 
        DefaultPieDataset dataset = new DefaultPieDataset(); 
        int totalEmployees = strList != null ? strList.stream().mapToInt(x -> Integer.parseInt(x.split(" \\| ")[1].trim())).sum() : 0;  // Chat GPT

        if (totalEmployees > 0) { // Check nếu >= 1
            strList.forEach(x -> {
                String[] parts = x.split(" \\| ");
                int empCount = Integer.parseInt(parts[1].trim());
                double percentage = ((double) empCount / totalEmployees) * 100; 
                dataset.setValue(parts[0].trim() + " | " + empCount, percentage);
            });
        } else {
            System.out.println("Không có dữ liệu.");
        }

        return dataset; 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chart1 = new javax.swing.JPanel();
        chart2 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        chart1.setBackground(new java.awt.Color(255, 255, 255));
        chart1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        chart1.setPreferredSize(new java.awt.Dimension(508, 504));
        chart1.setLayout(new java.awt.BorderLayout());

        chart2.setBackground(new java.awt.Color(255, 255, 255));
        chart2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        chart2.setPreferredSize(new java.awt.Dimension(508, 504));
        chart2.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chart1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chart2, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chart2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chart1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel chart1;
    private javax.swing.JPanel chart2;
    // End of variables declaration//GEN-END:variables
}
