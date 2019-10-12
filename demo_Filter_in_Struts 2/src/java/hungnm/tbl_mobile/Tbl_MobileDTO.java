/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungnm.tbl_mobile;

/**
 *
 * @author SE130008
 */
public class Tbl_MobileDTO {
    private String mobileId;
    private String mobileName;
    private float price;
    private int quantity;

    public Tbl_MobileDTO() {
    }

    public Tbl_MobileDTO(String mobileId, String mobileName, float price, int quantity) {
        this.mobileId = mobileId;
        this.mobileName = mobileName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getMobileId() {
        return mobileId;
    }

    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
