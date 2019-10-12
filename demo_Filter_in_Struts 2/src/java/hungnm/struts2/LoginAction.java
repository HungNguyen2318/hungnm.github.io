/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungnm.struts2;

import com.opensymphony.xwork2.ActionContext;
import hungnm.tbl_account.Tbl_AccountDAO;
import hungnm.tbl_account.Tbl_AccountDTO;
import java.util.Map;

/**
 *
 * @author SE130008
 */
public class LoginAction {
    private String username;
    private String password;
    
    private final String SUCCESS = "success";
    private final String FAIL = "fail";
    
    public LoginAction() {
    }
    
    public String execute() throws Exception {
        Tbl_AccountDAO dao = new Tbl_AccountDAO();
        
        Tbl_AccountDTO user = dao.checkLogin(username, password);
        
        if(user != null ){
            Map session = ActionContext.getContext().getSession();
            session.put("USER", user);
//            session.put("login","1");
            
            return SUCCESS;
        } else 
            return  FAIL;        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
