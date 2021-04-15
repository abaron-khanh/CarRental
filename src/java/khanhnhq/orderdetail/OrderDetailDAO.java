/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanhnhq.orderdetail;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import khanhnhq.car.CarDTO;
import khanhnhq.db.DBHelper;
import khanhnhq.order.OrderDTO;

/**
 *
 * @author PC
 */
public class OrderDetailDAO implements Serializable{
    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    public OrderDetailDAO() {
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
    
    public boolean createOrderDetails(String orderDetailID, String carID, String orderID) throws Exception
    {
        boolean check = false;
        try 
        {
            String sql = "Insert Into tblOrderDetail(orderDetailID, carID, orderID) Values(?,?,?)";
            conn = DBHelper.makeConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, orderDetailID);
            preStm.setString(2, carID);
            preStm.setString(3, orderID);
            check = preStm.executeUpdate() > 0;
        } 
        finally
        {
            closeConnection();
        }
        return check;
    }
    
    public List<CarDTO> getAllOrderDetailByID(String id) throws Exception
    {
        List<CarDTO> result;
        CarDTO dto;
        String orderDetailID, carName, carColor, category, carImage, feedback;
        float price;
        int yearOfManufacture, rating;
        String sql = "Select O.orderDetailID, C.carID, C.carName, C.carImage, C.carPrice, C.carColor, C.yearOfManufacture, C.category, O.feedback, O.rating From tblCar C Inner Join tblOrderDetail O On C.carID = O.carID Where O.orderID = ?";
        try
        {
            conn = DBHelper.makeConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) 
            {                
                orderDetailID = rs.getString("orderDetailID");
                carName = rs.getString("carName") + " (" + rs.getString("carID") + ")";
                carImage = rs.getString("carImage");
                price = rs.getFloat("carPrice");
                rating = rs.getInt("rating");
                carColor = rs.getString("carColor");
                yearOfManufacture = rs.getInt("yearOfManufacture");
                category = rs.getString("category");
                feedback = rs.getString("feedback");
                dto = new CarDTO(orderDetailID, carName, carImage, carColor, category, price, yearOfManufacture);
                dto.setFeedback(feedback);
                dto.setRating(rating);
                result.add(dto);
            }
        }
        finally
        {
            closeConnection();
        }
        return result;
    }
    
    public boolean setFeedback(String id, String content, int star) throws Exception
    {
        boolean check = false;
        String sql = "Update tblOrderDetail Set feedback = ?, rating = ? Where orderDetailID = ?";
        try
        {
            conn = DBHelper.makeConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, content);
            preStm.setInt(2, star);
            preStm.setString(3, id);
            check = preStm.executeUpdate() >0;
        }
        finally
        {
            closeConnection();
        }
        return check;
    }
}
