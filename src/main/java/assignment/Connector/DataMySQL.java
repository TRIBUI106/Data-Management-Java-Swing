/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.Connector;

/**
 *
 * @author Chezis P
 */
public class DataMySQL {
    
    public static String SQL_Url = "localhost";
    public static String SQL_Port = "3306";
    public static String SQL_Database = "DB_JAVA2";
    public static String SQL_User = "root";
    public static String SQL_Password = "";
    static final String ConnectURL = ( "jdbc:mysql://" + SQL_Url + ":" + SQL_Port + "/" + SQL_Database );
    
}
