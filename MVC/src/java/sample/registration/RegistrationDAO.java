/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.registration;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import utils.DBUtilities;

/**
 *
 * @author Acer
 */
public class RegistrationDAO implements Serializable {

    public boolean checkLogin(String userName, String password) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        //1 open con
        try {

            con = DBUtilities.makeConnection();
            if (con != null) {
                //2 create sql string
                String slq = "select username from usermanager where username = ? and password =?";
                stm = con.prepareStatement(slq);
                stm.setString(1, userName);
                stm.setString(2, password);

                //esucute querry
                rs = stm.executeQuery();

                if (rs.next()) {
                    return true;
                }
            }//end if con is not noull
        } finally {
            if (con != null) {
                rs.close();
                stm.close();
                con.close();
            }

        }
        return false;
    }
    private List<RegistrationDTO> listAccount;

    public List<RegistrationDTO> getListAccount() {
        return listAccount;
    }

    public void searchLastName(String searchValue) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        //1 open con
        try {

            con = DBUtilities.makeConnection();
            if (con != null) {
                //2 create sql string
                String slq = "select username, password, lastname, isAdmin from usermanager where lastname like ?";
                stm = con.prepareStatement(slq);
                stm.setString(1, "%" + searchValue + "%");

                //esucute querry
                rs = stm.executeQuery();
                while (rs.next()) {
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String lastname = rs.getString("lastname");
                    boolean role = rs.getBoolean("isAdmin");

                    RegistrationDTO dto = new RegistrationDTO(username, password, lastname, role);
                    if (this.listAccount == null) {
                        this.listAccount = new ArrayList<>();

                    }
                    this.listAccount.add(dto);
                }

            }//end if con is not noull
        } finally {
            if (con != null) {
                rs.close();
                stm.close();
                con.close();
            }

        }

    }

    public static boolean deleteAccount(String username) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        //1 open con
        try {

            con = DBUtilities.makeConnection();
            if (con != null) {
                //2 create sql string
                String slq = "delete from userManager where username = ?";
                stm = con.prepareStatement(slq);
                stm.setString(1, username);

                int row = stm.executeUpdate();

                //esucute querry
                if (row > 0) {
                    return true;
                }

            }//end if con is not noull
        } finally {
            if (con != null) {

                stm.close();
                con.close();
            }

        }
        return false;

    }

    public static boolean UpdateAccount(String username, String password, boolean role) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;

        //1 open con
        try {

            con = DBUtilities.makeConnection();
            if (con != null) {
                //2 create sql string
                String slq = "update userManager set password = ? , isAdmin = ? where username = ?";
                stm = con.prepareStatement(slq);
                stm.setString(1, password);
                stm.setBoolean(2, role);
                stm.setString(3, username);

                int row = stm.executeUpdate();

                //esucute querry
                if (row > 0) {
                    return true;
                }

            }//end if con is not noull
        } finally {
            if (con != null) {

                stm.close();
                con.close();
            }

        }
        return false;

    }

    public static int getRowCartTable() throws NamingException, SQLException {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        int row = 0;
        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                String sql = "select * from Cart";
                st = con.createStatement();
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    ++row;
                }
                return row;

            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return -1;

    }

    public static boolean InsertToCart(int id, String title, int quantity) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement pst = null;
        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                String sql = "insert cart(id, title, quantity) values (?,?,?)";
                pst = con.prepareCall(sql);

                pst.setInt(1, id);
                pst.setString(2, title);
                pst.setInt(3, quantity);

                int row = pst.executeUpdate();

                //esucute querry
                if (row > 0) {
                    return true;
                }

            }
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean creatAccount(String username, String password, String fullName, boolean role) throws SQLException, NamingException{
        Connection con = null;
        PreparedStatement stm = null;

        //1 open con
        try {

            con = DBUtilities.makeConnection();
            if (con != null) {
                //2 create sql string
                String slq = "insert [dbo].[UserManager] values (?,?,?,?)";
                stm = con.prepareStatement(slq);
                stm.setString(1, username);
                stm.setString(2, password);
                stm.setString(3, fullName);
                stm.setBoolean(4, role);
                int row = stm.executeUpdate();

                //esucute querry
                if (row > 0) {
                    return true;
                }

            }//end if con is not noull
        } finally {
            if (con != null) {

                stm.close();
                con.close();
            }

        }
        return false;

    }
}
