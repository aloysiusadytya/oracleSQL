/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testOracle;

import model_HR.Department;
import model_HR.Employee;

/**
 *
 * @author admin
 */
public class TestDepartment2 {
    public static void main(String[] args) {
        Department dept = new Department(10,"Administration");
        dept.readEmployees();
        for (int i = 0; i < dept.getListEmployees().size(); i++) {
            System.out.println(dept.getListEmployees().get(i).toString());
        }
        
        Department dept1 = new Department(20,"Marketing");
        dept1.readEmployees();
        for (int i = 0; i < dept1.getListEmployees().size(); i++) {
            System.out.println(dept1.getListEmployees().get(i).toString());
        }
        
        dept.readManager();
        dept1.readManager();
        for (int i = 0; i < dept.getManagers().size(); i++) {
            Employee man = dept.getManagers().get(i);
            System.out.println("Manager = "+man.toString());
        }
        
        for (int i = 0; i < dept1.getManagers().size(); i++) {
            Employee man = dept1.getManagers().get(i);
            System.out.println("Manager = "+man.toString());
        }
   }
  
}
