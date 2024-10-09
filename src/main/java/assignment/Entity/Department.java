/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.Entity;

/**
 *
 * @author Chezis P
 */
public class Department {
    int ID;
    String Name;
    String Desc;

    public Department(int ID, String Name, String Desc) {
        this.ID = ID;
        this.Name = Name;
        this.Desc = Desc;
    }

    public Department() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String Desc) {
        this.Desc = Desc;
    }
    
    public void run() {
        System.out.println("Department đang chạy");
    }
    
    
}
