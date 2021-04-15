/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanhnhq.account;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author PC
 */
public class AccountDTO implements Serializable{
    private String username, fullname, password, status, email;
    private Date createDate;

    public AccountDTO() {
    }

    public AccountDTO(String username, String fullname,String status, String email) {
        this.username = username;
        this.fullname = fullname;
        this.status = status;
        this.email = email;
    }

    public AccountDTO(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
