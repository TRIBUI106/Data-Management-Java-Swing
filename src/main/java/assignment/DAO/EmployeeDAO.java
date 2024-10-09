/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package assignment.DAO;
import assignment.Connector.ConnectorHelper;
import static assignment.DAO.Handle.Handle;
import assignment.Entity.Employee;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Chezis P
 */
public interface EmployeeDAO {
    
    default void triggerAutoIncrement() {
        String SQL = "ALTER TABLE EMPLOYEE AUTO_INCREMENT = ?";
        String getMax = "SELECT MAX(EMPLOYEE_ID) as max FROM EMPLOYEE";
        try (
                
                Connection conn = ConnectorHelper.connection();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(getMax);
                ) {
            if ( rs.next() ) {
                int maxID = rs.getInt("max");
                int autoIncrementValue = (maxID > 0 ) ? maxID + 1 : 1;
                try (PreparedStatement prstm = conn.prepareStatement(SQL)) {
                    prstm.setInt(1, autoIncrementValue);
                    prstm.executeUpdate();
                }
            }
        } catch (SQLException ex) {
            Handle(ex);
        }
    }
 
    default List<Employee> getAllEmployees() {
        List<Employee> empList = new ArrayList<>();
        String SQL = "SELECT em.EMPLOYEE_ID, em.EMPLOYEE_NAME, em.AGE, em.`DESCRIPTION`, dpm.DEPARTMENT_ID, dpm.DEPARTMENT_NAME FROM EMPLOYEE em LEFT JOIN DEPARTMENT dpm ON em.DEPARTMENT_ID = dpm.DEPARTMENT_ID;";
        try (
                Connection conn = ConnectorHelper.connection();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(SQL);
                ) {
            while ( rs.next() ) {
                empList.add(new Employee(
                        rs.getInt("EMPLOYEE_ID"), 
                        rs.getString("EMPLOYEE_NAME"), 
                        rs.getInt("AGE"), 
                        rs.getString("DESCRIPTION"), 
                        rs.getString("DEPARTMENT_ID") + " : " + rs.getString("DEPARTMENT_NAME")
                ));
            }
            
        } catch (SQLException ex) {
            Handle(ex);
        }
        return empList;
    }
    
    default List<String> getDepartmentList() {
        List<String> list = new ArrayList<>();
        String singleRow;
        try (
                Connection conn = ConnectorHelper.connection();
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT DEPARTMENT_ID, DEPARTMENT_NAME FROM DEPARTMENT")
                ) {
            
            while (rs.next()) {
                singleRow = "" + rs.getInt("DEPARTMENT_ID") + " : " + rs.getString("DEPARTMENT_NAME") + "";
                list.add(singleRow);
            }
            
            return list;
        } catch (SQLException ex) {
            Handle(ex);
        }
        return list;
    }
    
    default int add_Employee(String Name, int Age, String Desc, int DPMID, String Email) {
        String SQL = "INSERT INTO EMPLOYEE(EMPLOYEE_NAME, AGE, `DESCRIPTION`, DEPARTMENT_ID, EMAIL) VALUES (?,?,?,?,?)";
        int rtn = 0;
        try (
                Connection conn = ConnectorHelper.connection();
                PreparedStatement prstm = conn.prepareStatement(SQL);
                ) {
            prstm.setString(1, Name);
            prstm.setInt(2, Age);
            prstm.setString(3, Desc);
            prstm.setInt(4, DPMID);
            prstm.setString(5, Email);
            prstm.executeUpdate();
            rtn = 1;
            announceDAO.announceInfo("<html>Đã thêm Employee <u>" + Name + "</u> thành công !</html>");
            return rtn;
        } catch (SQLException ex){
            Handle(ex);
        } 
        return rtn;
    }
    
    default boolean edit_Employee(int ID, String Name, int Age, String Desc, int DpmID) {
        boolean b = false;
        String SQL = "UPDATE EMPLOYEE SET EMPLOYEE_NAME = ?, AGE = ?, DESCRIPTION = ?, DEPARTMENT_ID = ? WHERE EMPLOYEE_ID = ?";
        try (
                Connection conn = ConnectorHelper.connection();
                PreparedStatement prstm = conn.prepareStatement(SQL);
                ) {
            prstm.setString(1, Name);
            prstm.setInt(2, Age);
            prstm.setString(3, Desc);
            prstm.setInt(4, DpmID);
            prstm.setInt(5, ID);
            prstm.executeUpdate();
            b = true;
        } catch (SQLException ex) {
            Handle(ex);
        }
        return b;
    }
    
    default boolean delete_Employee(int ID) {
        boolean b = false;
        String SQL = "DELETE FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
        try (
                Connection conn = ConnectorHelper.connection();
                PreparedStatement prstm = conn.prepareStatement(SQL);
                ) {
            prstm.setInt(1, ID);
            prstm.executeUpdate();
            b = true;
            return b;
        } catch (SQLException ex) {
            Handle(ex);
        }
        return b;
    }
    
    default List<Object> search_Employee(int ID) {
        List<Object> objList = new ArrayList<>();
        Object obj;
        String SQL = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_ID = ?";
        try (
                Connection conn = ConnectorHelper.connection();
                PreparedStatement prstm = conn.prepareStatement(SQL);
                ) {
            prstm.setInt(1, ID);
            ResultSet rs = prstm.executeQuery();
            while (rs.next()) {
                objList.add(new Object[]{
                    rs.getInt("EMPLOYEE_ID"),
                    rs.getString("EMPLOYEE_NAME"),
                    rs.getInt("AGE"),
                    rs.getString("DESCRIPTION"),
                    rs.getInt("DEPARTMENT_ID")
                });
            }
            return objList;
        } catch (SQLException ex) {
            Handle(ex);
        }
        return null;
    }
    
    default List<Object> search_Employee(String Name) {
        List<Object> objList = new ArrayList<>();
        Object obj;
        String SQL = "SELECT * FROM EMPLOYEE WHERE EMPLOYEE_NAME LIKE ?";
        try (
                Connection conn = ConnectorHelper.connection();
                PreparedStatement prstm = conn.prepareStatement(SQL);
                ) {
            prstm.setString(1, "%" + Name + "%");
            ResultSet rs = prstm.executeQuery();
            while (rs.next()) {
                objList.add(new Object[]{
                    rs.getInt("EMPLOYEE_ID"),
                    rs.getString("EMPLOYEE_NAME"),
                    rs.getInt("AGE"),
                    rs.getString("DESCRIPTION"),
                    rs.getInt("DEPARTMENT_ID")
                });
            }
            return objList;
        } catch (SQLException ex) {
            Handle(ex);
        }
        return null;
    }
    
}
