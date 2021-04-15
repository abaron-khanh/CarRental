/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanhnhq.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import khanhnhq.db.DBHelper;

/**
 *
 * @author PC
 */
public class AccountDAO {
    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    public AccountDAO() {
    }

    private void closeConnection() throws Exception
    {
        if(rs != null)
            rs.close();
        if(preStm != null)
            preStm.close();
        if(conn != null)
            conn.close();
    }

    public AccountDTO checkLogin(String username, String password) throws Exception
    {
        String user, fullname, status, email;
        AccountDTO dto = null;
        String sql = "Select username, fullname, status, email From tblAccount Where username = ? And password = ?  Collate Latin1_General_CS_AS";
        try {
                conn = DBHelper.makeConnection();
                preStm = conn.prepareStatement(sql);
                preStm.setString(1, username);
                preStm.setString(2, password);
                rs = preStm.executeQuery();
                if(rs.next())
                {
                    user = rs.getString("username");
                    fullname = rs.getString("fullname");
                    status = rs.getString("status");
                    email = rs.getString("email");
                    dto = new AccountDTO(user, fullname, status, email);
                }
            }

        finally{
            closeConnection();
        }
        return dto;
    }
    
    public boolean setStatus(String username) throws Exception
    {
        boolean check = false;
        String sql = "Update tblAccount Set status = 'Active' Where username = ?";
        try
        {
            conn = DBHelper.makeConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            check = preStm.executeUpdate() >0;
        }
        finally
        {
            closeConnection();
        }
        return check;
    }
    
    public List<AccountDTO> getAllUser() throws Exception
    {
        List<AccountDTO> result;
        String username, email;
        AccountDTO dto;
        String sql = "Select username, email From tblAccount";
        try
        {
            conn = DBHelper.makeConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) 
            {
                username = rs.getString("username");
                email = rs.getString("email");
                dto = new AccountDTO(username, email);
                result.add(dto);
            }
        }
        finally
        {
            closeConnection();
        }
        return result;
    }
    
    public boolean createAccount(String username, String fullname, String password, String email) throws Exception
    {
        boolean check = false;
        Date date = new Date();
        try 
        {
            String sql = "Insert Into tblAccount(username, password, fullname, status, createDate, email) Values(?,?,?,?,?,?)";
            conn = DBHelper.makeConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, password);
            preStm.setString(3, fullname);
            preStm.setString(4, "Inactive");
            preStm.setTimestamp(5, new Timestamp(date.getTime()));
            preStm.setString(6, email);
            check = preStm.executeUpdate() > 0;
        }
        finally
        {
            closeConnection();
        }
        return check;
    }
}
