/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.Entity;

/**
 *
 * @author Chezis P
 */
public class Employee {
    int ID;
    String Name;
    int Age;
    String Desc;
    int dpmID;
    String dpmName;

    public Employee() {
    }

    public Employee(int ID, String Name, int Age, String Desc, int dpmID) {
        this.ID = ID;
        this.Name = Name;
        this.Age = Age;
        this.Desc = Desc;
        this.dpmID = dpmID;
    }

    public Employee(int ID, String Name, int Age, String Desc, String dpmName) {
        this.ID = ID;
        this.Name = Name;
        this.Age = Age;
        this.Desc = Desc;
        this.dpmName = dpmName;
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

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String Desc) {
        this.Desc = Desc;
    }

    public int getDpmID() {
        return dpmID;
    }

    public void setDpmID(int dpmID) {
        this.dpmID = dpmID;
    }

    public String getDpmName() {
        return dpmName;
    }

    public void setDpmName(String dpmName) {
        this.dpmName = dpmName;
    }
    
    public void run() {
        System.out.println("Department đang chạy");
    }
       
    
}
