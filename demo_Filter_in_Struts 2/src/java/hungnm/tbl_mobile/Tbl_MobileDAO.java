/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungnm.tbl_mobile;

import hungnm.utils.DBUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author SE130008
 */
public class Tbl_MobileDAO implements Serializable {

    private List<Tbl_MobileDTO> list;

    public List<Tbl_MobileDTO> getList() {
        return list;
    }

    public void searchMobile(String searchValue)
            throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            con = DBUtils.makeConnection();
            if (con != null) {
                String slq = "select * from tbl_Mobile "
                        + "where mobileId like ? or mobileName like ?";
                stm = con.prepareStatement(slq);
                stm.setString(1, "%" + searchValue + "%");
                stm.setString(2, "%" + searchValue + "%");

                rs = stm.executeQuery();
                while (rs.next()) {
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    String mobileId = rs.getString(1);
                    String mobileName = rs.getString(2);
                    float price = rs.getFloat(3);
                    int quantity = rs.getInt(4);

                    Tbl_MobileDTO dto
                            = new Tbl_MobileDTO(mobileId, mobileName, price, quantity);
                    list.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
}
