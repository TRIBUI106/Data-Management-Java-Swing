/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package assignment.DAO;

import assignment.Connector.ConnectorHelper;
import java.sql.Connection;
import java.sql.*;
import static assignment.DAO.Handle.Handle;

/**
 *
 * @author Chezis P
 */
public interface LoginDAO {
    
    public static boolean checkLoginData(String username, String password) {
        boolean b = false;
        try {
            Connection conn = ConnectorHelper.connection();
            String SQL = "SELECT username, password from ADMIN; ";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(SQL);
            while (rs.next()) {
                if ( username.equals(rs.getString("username")) ) {
                    if ( password.equals(rs.getString("password")) ) {
                        b = true;
                    }
                }
            }
            return b;
        } catch (SQLException ex) {
            Handle(ex);
        }
        
        return b;
    }
    
}
