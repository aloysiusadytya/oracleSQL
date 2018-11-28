/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testMySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import testOracle.TestOracle1;

/**
 *
 * @author user only
 */
public class TestMysql {

    public static void main(String[] args) {
        try {
            //step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //step2 create  the connection object
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://202.94.83.190:3306/rsku", "rsku", "rsku");
            //step3 create the statement object
            Statement stmt = con.createStatement();
            //step4 execute query
//            ResultSet rs = stmt.executeQuery("select * from myDokter");
//            while (rs.next()) {
//                System.out.println(rs.getString(1) + "  " + rs.getString(2));
//            }
            //step5 close the connection object
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestOracle1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
