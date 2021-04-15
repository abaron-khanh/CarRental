/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanhnhq.order;

import java.io.Serializable;
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
public class OrderDAO implements Serializable{
    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    public OrderDAO() {
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
    
    public String getLastOrderByUser(String username) throws Exception
    {
        String orderID = null;
        try 
        {
            String sql = "Select orderID From tblOrder Where createDate = (Select MAX(createDate) From tblOrder Where username = ?)";
            conn = DBHelper.makeConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            if(rs.next())
            {
                orderID = rs.getString("orderID");
            }
        } 
        finally
        {
            closeConnection();
        }
        return orderID;
    }
    
    public boolean createOrder(String orderID, String username, float total, Date rentalDate, Date returnDate, String status,String customerName, String customerPhone, String customerAddress, Date createDate) throws Exception
    {
        boolean check = false;
        try 
        {
            String sql = "Insert Into tblOrder(orderID, username, total, orderDate, returnDate, status, customerName, customerPhone, customerAddress, createDate, isDeleted) Values(?,?,?,?,?,?,?,?,?,?,?)";
            conn = DBHelper.makeConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, orderID);
            preStm.setString(2, username);
            preStm.setFloat(3, (float)Math.round(total*100)/100);
            preStm.setTimestamp(4, new Timestamp(rentalDate.getTime()));
            preStm.setTimestamp(5, new Timestamp(returnDate.getTime()));
            preStm.setString(6, status);
            preStm.setString(7, customerName);
            preStm.setString(8, customerPhone);
            preStm.setString(9, customerAddress);
            preStm.setTimestamp(10, new Timestamp(createDate.getTime()));
            preStm.setString(11, "inactive");
            check = preStm.executeUpdate() > 0;
        }
        finally
        {
            closeConnection();
        }
        return check;
    }
    
    public boolean setStatus() throws Exception
    {
        boolean check = false;
        String sql = "Update tblOrder Set status = 'Returned' Where GETDATE() > returnDate";
        try
        {
            conn = DBHelper.makeConnection();
            preStm = conn.prepareStatement(sql);
            check = preStm.executeUpdate() >0;
        }
        finally
        {
            closeConnection();
        }
        return check;
    }
    
    public List<OrderDTO> getAllOrderByUsername(String user) throws Exception
    {
        List<OrderDTO> result;
        OrderDTO dto;
        String orderID, username, status, customerName, customerPhone, customerAddress;
        float total;
        Date orderDate, returnDate, createDate;
        String sql = "Select orderID, username, total, orderDate, returnDate, status, customerName, customerPhone, customerAddress, createDate From tblOrder Where username = ? And isDeleted = 'inactive' Order By createDate DESC";
        try
        {
            conn = DBHelper.makeConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, user);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) 
            {                
                orderID = rs.getString("orderID");
                username = rs.getString("username");
                total = rs.getFloat("total");
                orderDate = rs.getDate("orderDate");
                returnDate = rs.getDate("returnDate");
                status = rs.getString("status");
                customerName = rs.getString("customerName");
                customerPhone = rs.getString("customerPhone");
                customerAddress = rs.getString("customerAddress");
                createDate = rs.getDate("createDate");
                dto = new OrderDTO(orderID, username, status, customerName, customerAddress, customerPhone, total, orderDate, returnDate, createDate);
                result.add(dto);
            }
        }
        finally
        {
            closeConnection();
        }
        return result;
    }
    
    public boolean setIsDeleted(String id) throws Exception
    {
        boolean check = false;
        String sql = "Update tblOrder Set isDeleted = 'active' Where orderID = ?";
        try
        {
            conn = DBHelper.makeConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            check = preStm.executeUpdate() >0;
        }
        finally
        {
            closeConnection();
        }
        return check;
    }
    
    public List<OrderDTO> getAllOrderByUsernameAndSearchName(String user, String name) throws Exception
    {
        List<OrderDTO> result;
        OrderDTO dto;
        String orderID, username, status, customerName, customerPhone, customerAddress;
        float total;
        Date orderDate, returnDate, createDate;
        String sql = "Select O.orderID, O.username, O.total, O.orderDate, O.returnDate, O.status, O.customerName, O.customerPhone, O.customerAddress, O.createDate From tblOrder O Inner Join tblOrderDetail D On O.orderID = D.orderID Inner Join tblCar C On D.carID = C.carID Where O.username = ? And O.isDeleted = 'inactive' And C.carName Like ? Group By O.orderID, O.username, O.total, O.orderDate, O.returnDate, O.status, O.customerName, O.customerPhone, O.customerAddress, O.createDate Order By createDate DESC";
        try
        {
            conn = DBHelper.makeConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, user);
            preStm.setString(2, "%" + name +"%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) 
            {                
                orderID = rs.getString("orderID");
                username = rs.getString("username");
                total = rs.getFloat("total");
                orderDate = rs.getDate("orderDate");
                returnDate = rs.getDate("returnDate");
                status = rs.getString("status");
                customerName = rs.getString("customerName");
                customerPhone = rs.getString("customerPhone");
                customerAddress = rs.getString("customerAddress");
                createDate = rs.getDate("createDate");
                dto = new OrderDTO(orderID, username, status, customerName, customerAddress, customerPhone, total, orderDate, returnDate, createDate);
                result.add(dto);
            }
        }
        finally
        {
            closeConnection();
        }
        return result;
    }
    
    public List<OrderDTO> getAllOrderByUsernameAndDate(String user, String from, String to) throws Exception
    {
        List<OrderDTO> result;
        OrderDTO dto;
        String orderID, username, status, customerName, customerPhone, customerAddress;
        float total;
        Date orderDate, returnDate, createDate;
//        String sql = "Select O.orderID, O.username, O.total, O.orderDate, O.returnDate, O.status, O.customerName, O.customerPhone, O.customerAddress, O.createDate From tblOrder O Inner Join tblOrderDetail D On O.orderID = D.orderID Inner Join tblCar C On D.carID = C.carID Where O.username = ? And O.isDeleted = 'inactive' And year(O.createDate) = ? And Month(O.createDate) = ? And Day(O.createDate) = ? Group By O.orderID, O.username, O.total, O.orderDate, O.returnDate, O.status, O.customerName, O.customerPhone, O.customerAddress, O.createDate Order By createDate ASC";
        String sql = "Select O.orderID, O.username, O.total, O.orderDate, O.returnDate, O.status, O.customerName, O.customerPhone, O.customerAddress, O.createDate From tblOrder O Inner Join tblOrderDetail D On O.orderID = D.orderID Inner Join tblCar C On D.carID = C.carID Where O.createDate Between ? And ? And O.username = ? And O.isDeleted = 'inactive' Group By O.orderID, O.username, O.total, O.orderDate, O.returnDate, O.status, O.customerName, O.customerPhone, O.customerAddress, O.createDate Order By createDate ASC";
        try
        {
            conn = DBHelper.makeConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, from);
            preStm.setString(2, to + " 23:59:59.999");
            preStm.setString(3, user);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) 
            {                
                orderID = rs.getString("orderID");
                username = rs.getString("username");
                total = rs.getFloat("total");
                orderDate = rs.getDate("orderDate");
                returnDate = rs.getDate("returnDate");
                status = rs.getString("status");
                customerName = rs.getString("customerName");
                customerPhone = rs.getString("customerPhone");
                customerAddress = rs.getString("customerAddress");
                createDate = rs.getDate("createDate");
                dto = new OrderDTO(orderID, username, status, customerName, customerAddress, customerPhone, total, orderDate, returnDate, createDate);
                result.add(dto);
            }
        }
        finally
        {
            closeConnection();
        }
        return result;
    }
}
