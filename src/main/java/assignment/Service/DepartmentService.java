package assignment.Service;

import assignment.DAO.DepartmentDAO;
import assignment.DAO.announceDAO;
import static assignment.DAO.announceDAO.announceErr;
import assignment.Entity.Department;
import java.util.*;
import javax.swing.JOptionPane;

public class DepartmentService implements DepartmentDAO {
    
    private List<Department> dpmList = new ArrayList<>();
        
    public List<Department> getData() {
        return dpmList = getAllDepartments();
    }
    
    public int addNewDepartment(String Name, String Desc) {
                
        if (Name.length() <= 0 ) {
            announceErr("Bạn chưa nhập Tên phòng !");
            return 0;
        }
        
        if (Desc.length() <= 0 ) {
            announceErr("Bạn chưa nhập Mô tả !");
            return 0;
        }
        
        int id = addDepartment(Name, Desc);
        if ( id != 0 ) {
            announceDAO.announceInfo("Đã thêm 1 Department với tên: " + Name + " !");
            return id;
        } else {
            announceDAO.announceWar("Không thể thêm department !");
        }
        return 0;
    }
    
    public void editCurrentDepartment(int ID, String Name, String Desc) {
        
        if (Name.length() <= 0 ) {
            announceErr("Không được bỏ trống Tên phòng !");
            return;
        }
        
        if (Desc.length() <= 0 ) {
            announceErr("Không được bỏ trống Mô tả !");
            return;
        }
        
        editDepartment(ID, Name, Desc);
        
    }
    
    public void deleteCurrentDepartment(int ID, String Name) {
        
        int i = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xoá " + Name + " ?", "Asking Client", JOptionPane.YES_NO_CANCEL_OPTION);
        switch (i) {
            case JOptionPane.YES_OPTION:
                deleteDepartment(ID);
                break;
            case JOptionPane.NO_OPTION:
                System.out.println("Client Cancle");
                break;
            case JOptionPane.CANCEL_OPTION:
                System.out.println("Client Cancle");
                break;
            default:
                System.out.println("Err !");
                break;
        }
    }
    
    public Department searchByName(String Name) {
        Department dpm = null;
        try {
            int ID = Integer.parseInt(Name);
            dpm = searchDepartment(ID);
        } catch (NumberFormatException ex) {
            dpm = searchDepartment(Name);
        }
        return dpm;
    }
}
    