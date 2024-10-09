package assignment.DAO;

import assignment.Connector.ConnectorHelper;
import assignment.Entity.Department;
import java.sql.*;
import java.util.*;
import static assignment.DAO.Handle.Handle;

public interface DepartmentDAO {

    default List<Department> getAllDepartments() {
        List<Department> dpmList = new ArrayList<>();
        try (
            Connection conn = ConnectorHelper.connection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM DEPARTMENT")) {
             
            while (rs.next()) {
                dpmList.add(new Department(
                        rs.getInt("DEPARTMENT_ID"), 
                        rs.getString("DEPARTMENT_NAME"), 
                        rs.getString("DESCRIPTION"))
                );
            }
        } catch (SQLException ex) {
            Handle(ex);
        }
        return dpmList;
    }
    
    default int addDepartment(String Name, String Desc) {
        String SQL = "INSERT INTO DEPARTMENT(DEPARTMENT_NAME, `DESCRIPTION`) VALUES (? , ?)";
        try (
                Connection conn = ConnectorHelper.connection();
                PreparedStatement prstm = conn.prepareStatement(SQL);
                ) {
            
            prstm.setString(1, Name);
            prstm.setString(2, Desc);
            prstm.executeUpdate();
            return getAddedDepartment(Name); 
            
        } catch (SQLException ex) {
            Handle(ex);
        }
        return 0;
    }
    
    private int getAddedDepartment(String Name) {
        String SQL = "SELECT DEPARTMENT_ID FROM DEPARTMENT WHERE DEPARTMENT_NAME = ?";
        int id = 0;
        try (
                Connection conn = ConnectorHelper.connection();
                PreparedStatement prstm = conn.prepareStatement(SQL);
                ){
            
            prstm.setString(1, Name);
            
            try (ResultSet rs = prstm.executeQuery()) {
                while (rs.next()) {
                    id = rs.getInt("DEPARTMENT_ID");
                }
                return id;
            }
            
        } catch (SQLException ex) {
            Handle(ex);
        }
        return 0;
    }
    
    default void editDepartment(int ID, String Name, String Desc) {
        String SQL = "UPDATE DEPARTMENT "
                + "SET DEPARTMENT_NAME = ?, "
                + "`DESCRIPTION` = ? "
                + "WHERE DEPARTMENT_ID = ? ";
        try (
                Connection conn = ConnectorHelper.connection();
                PreparedStatement prstm = conn.prepareStatement(SQL);
                ) {
            prstm.setString(1, Name);
            prstm.setString(2, Desc);
            prstm.setInt(3, ID);
            prstm.executeUpdate();
        } catch (SQLException ex) {
            Handle(ex);
        }
    }
    
    default void deleteDepartment(int ID) {
        String SQL = "DELETE FROM DEPARTMENT WHERE DEPARTMENT_ID = ?";
        try (
                Connection conn = ConnectorHelper.connection();
                PreparedStatement prstm = conn.prepareStatement(SQL);
                )
        {
            prstm.setInt(1, ID);
            prstm.executeUpdate();
        } catch (SQLException ex) {
            Handle(ex);
        }
    }
    
    default Department searchDepartment(String name) {  
        String SQL = "SELECT * FROM DEPARTMENT WHERE DEPARTMENT_NAME LIKE ?";
        Department dpm = null;
        try (
                Connection conn = ConnectorHelper.connection();
                PreparedStatement prstm = conn.prepareStatement(SQL);
                ) {
            prstm.setString(1, "%" + name + "%");
            ResultSet rs = prstm.executeQuery();
            while (rs.next()) {
                dpm = new Department(rs.getInt("DEPARTMENT_ID"), rs.getString("DEPARTMENT_NAME"), rs.getString("DESCRIPTION"));
            }
            return dpm;
        } catch (SQLException ex) {
            Handle(ex);
        }
        return dpm;
    }
    
    default Department searchDepartment(int ID) { 
        String SQL = "SELECT * FROM DEPARTMENT WHERE DEPARTMENT_ID = ?";
        Department dpm = null;
        try (
                Connection conn = ConnectorHelper.connection();
                PreparedStatement prstm = conn.prepareStatement(SQL);
                ) {
            prstm.setInt(1, ID);
            ResultSet rs = prstm.executeQuery();
            while (rs.next()) {
                dpm = new Department(rs.getInt("DEPARTMENT_ID"), rs.getString("DEPARTMENT_NAME"), rs.getString("DESCRIPTION"));
            }
            return dpm;
        } catch (SQLException ex) {
            Handle(ex);
        }
        return dpm;
    }
    
}
