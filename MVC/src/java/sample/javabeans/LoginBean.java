/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.javabeans;

import java.sql.SQLException;
import javax.naming.NamingException;
import sample.registration.RegistrationDAO;

/**
 *
 * @author Acer
 */
public class LoginBean {
    private String username;
    private String password;

    public LoginBean() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public boolean checkLogin() throws SQLException, NamingException {
        RegistrationDAO dao = new RegistrationDAO();
        boolean result = dao.checkLogin(username, password);
        return result;
    }
}
