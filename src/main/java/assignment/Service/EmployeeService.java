/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.Service;

import assignment.DAO.EmployeeDAO;
import static assignment.DAO.announceDAO.announceConfirm;
import static assignment.DAO.announceDAO.announceInfo;
import static assignment.DAO.announceDAO.announceWar;
import assignment.Entity.Employee;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Chezis P
 */
public class EmployeeService implements EmployeeDAO {
    
    private List<Employee> empList = new ArrayList<>();
    
    public List<Employee> getData() {
        return empList = getAllEmployees();
    }
    
    public void onLoad() {
        triggerAutoIncrement();
    }
    
    public boolean addNewEmployee(String Name, String Age, String Desc, int DPMID) {
        boolean rtn = false;
        if ( Name.length() <= 0 || Name.equals("")) {
            announceWar("<html>Bạn chưa nhập <u>Tên</u> !</html>");
            return rtn;
        }
        
        if ( String.valueOf(Age).length() <= 0 || String.valueOf(Age).equals("")) {
            announceWar("<html>Bạn chưa nhập <u>Tuổi</u> !</html>");
            return rtn;
        }
        
        if ( Desc.length() <= 0 || Desc.equals("")) {
            announceWar("<html>Bạn chưa nhập <u>Mô tả</u> !</html>");
            return rtn;
        }
        
        try {
            /* Parse if success */
            Integer.parseInt(Age);
        } catch ( NumberFormatException ex) {
            announceWar("Tuổi phải là số !");
            return rtn;
        }
        
        int age = Integer.parseInt(Age);
        
        if ( age < 0 ) {
            announceWar("Tuổi phải lớn hơn 17 và nhỏ hơn 60 !");
            return rtn;
        }
        
        if ( age < 18 && age > 0 ) {
            announceWar("Tuổi quá nhỏ !");
            return rtn;
        }
        
        if ( age >= 60 ) {
            announceWar("Tuổi này về hưu rồi !");
            return rtn;
        }
        
        String[] parts = Name.split(" ");
        StringBuilder emailBuilder = new StringBuilder();

        for (String part : parts) {
            emailBuilder.append(replaceDiacritics(part.toLowerCase()));
        }
        
        Random random = new Random();
        int rNumb = random.nextInt(999) + 99;

        String email = emailBuilder.toString() + String.valueOf(rNumb) + "@cz.com"; // Sửa từ "gmaill.com" thành "gmail.com"
        
        if (add_Employee(Name, Integer.parseInt(Age), Desc, DPMID, email) == 1 ) {
            rtn = true;
        }
        
        return rtn;
        
    }
    
    private String replaceDiacritics(String input) {
        return input
                .replace("á", "a").replace("à", "a").replace("ả", "a").replace("ã", "a").replace("ạ", "a")
                .replace("ă", "a").replace("â", "a").replace("ấ", "a").replace("ầ", "a").replace("ẩ", "a")
                .replace("ẫ", "a").replace("ậ", "a")
                .replace("đ", "d")
                .replace("é", "e").replace("è", "e").replace("ẻ", "e").replace("ẽ", "e").replace("ẹ", "e")
                .replace("ê", "e").replace("ế", "e").replace("ề", "e").replace("ể", "e").replace("ễ", "e")
                .replace("ệ", "e")
                .replace("í", "i").replace("ì", "i").replace("ỉ", "i").replace("ĩ", "i").replace("ị", "i")
                .replace("ó", "o").replace("ò", "o").replace("ỏ", "o").replace("õ", "o").replace("ọ", "o")
                .replace("ô", "o").replace("ố", "o").replace("ồ", "o").replace("ổ", "o").replace("ỗ", "o")
                .replace("ộ", "o").replace("ơ", "o").replace("ớ", "o").replace("ờ", "o").replace("ở", "o")
                .replace("ỡ", "o").replace("ợ", "o")
                .replace("ú", "u").replace("ù", "u").replace("ủ", "u").replace("ũ", "u").replace("ụ", "u")
                .replace("ư", "u").replace("ứ", "u").replace("ừ", "u").replace("ử", "u").replace("ữ", "u")
                .replace("ự", "u")
                .replace("ý", "y").replace("ỳ", "y").replace("ỷ", "y").replace("ỹ", "y").replace("ỵ", "y");
    }
    
    public boolean updateEmployee(String title, String Name, String iAge, String Desc, String PB) {
        boolean b = false;
        int Age;
        if ( Name.length() <= 0 || Name.equals("") ) {
            announceWar("<html>Bạn không được bỏ trống <u>Tên</u> !</html>");
            return b;
        }
        
        if ( iAge.length() <= 0 || iAge.equals("") ) {
            announceWar("<html>Bạn không được bỏ trống <u>Tuổi</u> !</html>");
            return b;
        }
        
        if ( Desc.length() <= 0 || Desc.equals("") ) {
            announceWar("<html>Bạn không được bỏ trống <u>Mô tả</u> !</html>");
            return b;
        }
        
        try {
            Age = Integer.parseInt(iAge);
        } catch (NumberFormatException ex) {
            announceWar("Tuổi phải là một số !");
            return b;
        }
        
        int id = Integer.parseInt(title.split(" | ")[0]);
        int dpmId = Integer.parseInt(PB.split(" | ")[0]);
        
        b = edit_Employee(id, Name, Age, Desc, dpmId);
        if ( b == true ) {
            announceInfo("Đã chỉnh sửa Employee với ID " + id + " thành công !");
        }
        
        return b;
        
    }
    
    public boolean deleteEmployee(int ID) {
        boolean B = false;
        int i = announceConfirm("Bạn có chắc chắn muốn xóa Employee với ID : " + ID + " ?");
        switch (i) {
            case JOptionPane.YES_OPTION:
                System.out.println("Delete");
                B = delete_Employee(ID);
                if ( B == true ) {
                    announceInfo("Đã xóa thành công Employee với ID : " + ID + " !");
                    triggerAutoIncrement();
                }
                return B;
            case JOptionPane.NO_OPTION:
                break;
            case JOptionPane.CANCEL_OPTION:
                break;
            default:
                System.out.println("Err");
        }
        return B;
    }
    
    public List<Object> searchEmployee(String s) {
        if ( s.length() <= 0 ) {
            announceWar("Bạn chưa nhập gì vào ô tìm kiếm !");
            return null;
        }
        List<Object> objList = new ArrayList<>();
        try {
            int i = Integer.parseInt(s);
            
            objList = search_Employee(i);
        } catch (NumberFormatException ex) {
            
            objList = search_Employee(s);
        }
        
        if (!objList.isEmpty()) {
            System.out.println("Founded " + objList.size() + " employee(s) with info");
            return objList;
        } else {
            announceWar("Không tìm thấy Employee !\n>> " + s);
            return null;
        } 
    }
        
}
