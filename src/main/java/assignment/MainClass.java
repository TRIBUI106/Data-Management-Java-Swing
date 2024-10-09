/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package assignment;

import assignment.Connector.ConnectorHelper;
import assignment.View.Login;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Chezis P
 */
public class MainClass {

    public static void main(String[] args) {
        try (Connection conn = ConnectorHelper.connection()){
            System.out.println("Connected To Database Successfully !");
            Login form = new Login();
            form.setVisible(true);
        } catch (SQLException ex) {
            System.out.println("Err: " + ex);
        }
    }
}
