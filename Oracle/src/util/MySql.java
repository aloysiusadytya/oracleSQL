/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user only
 */
public class MySql {
    private String ipAddress;
    private String port;
    private String sid;
    private String userName;
    private String password;
    
    public static String USER_NAME="rsku";
    public static String PASSWORD="rsku";

    public MySql() {
    }

    public MySql(String ipAddress, String port, String sid, String userName, String password) {
        this.ipAddress = ipAddress;
        this.port = port;
        this.sid = sid;
        this.userName = userName;
        this.password = password;
    }
    
    public Connection getConnection(){
        Connection con = null;
        try {
            //step1 load the driver class
            Class.forName("com.mysql.jdbc.Driver");
            String connString = "jdbc:mysql://"+ipAddress+":"+port+":"+sid;
            System.out.println(connString);
            //step2 create  the connection object
            con = DriverManager.getConnection(connString,userName,password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyOracle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MyOracle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    
    
}
