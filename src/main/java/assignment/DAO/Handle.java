/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package assignment.DAO;

import java.sql.SQLException;

/**
 *
 * @author Chezis P
 */
public interface Handle {
    
    public static void Handle(SQLException ex) {
        System.out.println("Err: " + ex);
        return;
    }
    
}
