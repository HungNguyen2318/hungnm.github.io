/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungnm.tbl_account;

import hungnm.utils.DBUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author SE130008
 */
public class Tbl_AccountDAO implements Serializable{
    public Tbl_AccountDTO checkLogin(String username, String password) 
            throws NamingException,SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Tbl_AccountDTO user = null;
        
        try {
            con = DBUtils.makeConnection();
            if(con!=null) {
                String sql = "Select * from tbl_Account "
                        +"where username=? and password=?";
                stm = con.prepareStatement(sql);
                stm.setString(1,username);
                stm.setString(2,password);
                
                rs = stm.executeQuery();
                if(rs.next()){
                    String fullname = rs.getString(3);
                    
                    user = new Tbl_AccountDTO(username, "", fullname, 1);
                    //lưu ý: để bảo trên session ta sẽ set chuỗi "" 
                }//end if ts
            }//end if con
        } finally {
            if(rs != null)
                rs.close();
            if(stm != null)
                rs.close();
            if(con != null)
                con.close();
        }
        return user;            
    }
}
