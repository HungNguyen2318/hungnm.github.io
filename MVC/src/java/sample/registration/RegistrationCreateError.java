/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.registration;

/**
 *
 * @author Acer
 */
public class RegistrationCreateError {
    private String userLengthErr;
    private String passwordLengthErr;
    private String fullNameLengthErr;
    private String confirmNotMatch;
    private String usernameIsExisted;

    public RegistrationCreateError() {
    }

    public RegistrationCreateError(String userLengthErr, String passwordLengthErr, String fullNameLengthErr, String confirmNotMatch) {
        this.userLengthErr = userLengthErr;
        this.passwordLengthErr = passwordLengthErr;
        this.fullNameLengthErr = fullNameLengthErr;
        this.confirmNotMatch = confirmNotMatch;
    }

    public String getUserLengthErr() {
        return userLengthErr;
    }

    public void setUserLengthErr(String userLengthErr) {
        this.userLengthErr = userLengthErr;
    }

    public String getPasswordLengthErr() {
        return passwordLengthErr;
    }

    public void setPasswordLengthErr(String passwordLengthErr) {
        this.passwordLengthErr = passwordLengthErr;
    }

    public String getFullNameLengthErr() {
        return fullNameLengthErr;
    }

    public void setFullNameLengthErr(String fullNameLengthErr) {
        this.fullNameLengthErr = fullNameLengthErr;
    }

    public String getConfirmNotMatch() {
        return confirmNotMatch;
    }

    public void setConfirmNotMatch(String confirmNotMatch) {
        this.confirmNotMatch = confirmNotMatch;
    }

    public String getUsernameIsExisted() {
        return usernameIsExisted;
    }

    public void setUsernameIsExisted(String usernameIsExisted) {
        this.usernameIsExisted = usernameIsExisted;
    }
    
}
