/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungnm.struts2;

import hungnm.tbl_mobile.Tbl_MobileDAO;
import hungnm.tbl_mobile.Tbl_MobileDTO;
import java.util.List;

/**
 *
 * @author SE130008
 */
public class SearchMobileAction {
    
    private String searchValue;
    private List<Tbl_MobileDTO> list;
    private final String SUCCESS = "success";
    
    public SearchMobileAction() {
    }
    
    public String execute() throws Exception {
        Tbl_MobileDAO dao = new Tbl_MobileDAO();
        
        if(!searchValue.trim().equals("")){
            dao.searchMobile(searchValue);            
            list = dao.getList();
        }
        return SUCCESS;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public List<Tbl_MobileDTO> getList() {
        return list;
    }

    public void setList(List<Tbl_MobileDTO> list) {
        this.list = list;
    }
    
    
}
