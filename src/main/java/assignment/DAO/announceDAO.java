/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package assignment.DAO;

import javax.swing.JOptionPane;

/**
 *
 * @author Chezis P
 */
public interface announceDAO {
    
    public static void announceErr(String s) {
        JOptionPane.showMessageDialog(null, s, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void announceInfo(String s) {
        JOptionPane.showMessageDialog(null, s, "Error", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void announceWar(String s) {
        JOptionPane.showMessageDialog(null, s, "Warning", JOptionPane.WARNING_MESSAGE);
    }
    
    public static void announceCustom(String s1, String s2, int type) {
        JOptionPane.showMessageDialog(null, s1, s2, type);
    }
    
    public static int announceConfirm(String s) {
        return JOptionPane.showConfirmDialog(null, s, "Asking Client", JOptionPane.YES_NO_CANCEL_OPTION);
    }
    
}
