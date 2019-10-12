/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Acer
 */
public class DBUtilities implements Serializable{
    public static Connection makeConnection() throws SQLException, NamingException{
        Context context = new InitialContext();
        Context tomcatCtx = (Context) context.lookup("java:comp/env");
        DataSource ds = (DataSource) tomcatCtx.lookup("Van0705");
        Connection con = ds.getConnection();
        
        return con;
        
//        //1
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        //2 
//        String url =  "jdbc:sqlserver://localhost:1433;databaseName=QuanLiUser;instanceName=SE130680\\SQLEXPRESS";
//        
//        Connection con = DriverManager.getConnection(url, "sa", "van070599");
//        
//        return con;
    }
}
