
package assignment.DAO;

import assignment.Connector.ConnectorHelper;
import static assignment.DAO.Handle.Handle;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chezis P
 */
public interface DashboardDAO {
    
    default List<Integer> getTuoiEmployee() {
        List<Integer> ageList = new ArrayList<>();
        String SQL = "SELECT AGE FROM EMPLOYEE";
        try (
                Connection conn = ConnectorHelper.connection();
                Statement stm = conn.createStatement();
                ) {
            ResultSet rs = stm.executeQuery(SQL);
            while (rs.next()) {
                ageList.add(rs.getInt("AGE"));
            }
            return ageList;
        } catch (SQLException ex) {
            Handle(ex);
        }
        return null;
    }
    
    default List<String> getCountEmployeePerPB() {
        List<String> list = new ArrayList<>();
        String SQL = "SELECT dpm.DEPARTMENT_NAME AS dpmName, COUNT(*) AS slnv FROM DEPARTMENT dpm LEFT JOIN EMPLOYEE emp ON dpm.DEPARTMENT_ID = emp.DEPARTMENT_ID GROUP BY dpm.DEPARTMENT_NAME";
        
        try (
                Connection conn = ConnectorHelper.connection();
                Statement stm = conn.createStatement();
                ) {
            ResultSet rs = stm.executeQuery(SQL);
            while (rs.next()) {
                list.add(rs.getString("dpmName") + " | " + rs.getInt("slnv"));
            }
            return list;
        } catch (SQLException ex) {
            Handle(ex);
        }
        
        return null;
    }
    
}
