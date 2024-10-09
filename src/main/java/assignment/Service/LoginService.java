/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.Service;

import static assignment.DAO.LoginDAO.checkLoginData;
import static assignment.DAO.announceDAO.*;

/**
 *
 * @author Chezis P
 */
public class LoginService {
    
    public static boolean checkLogin(String name, String pass) {
        boolean b = false;
        
        // Check
        if ( name.length() <= 0 ) {
            announceWar("Bạn chưa nhập Username !");
            return b;
        }
        
        if ( pass.length() <= 0 ) {
            announceWar("Bạn chưa nhập Password !");
            return b;
        }
        
        // DAO
        b = checkLoginData(name, pass);
        
        if ( b == false ) {
            announceErr("Dữ liệu không khớp");
            return b;
        } else if ( b == true ) {
            announceInfo("Đăng nhập thành công");
            return b;
        }
        
        return b;
    }
            
}
