/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanhnhq.car;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import khanhnhq.db.DBHelper;

/**
 *
 * @author PC
 */
public class CarDAO implements Serializable{
    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    public CarDAO() {
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

    public int countAllCar() throws Exception
    {
        String sql = "Select count(*) From tblCar";
        try
        {
            conn = DBHelper.makeConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while(rs.next())
            {
                return rs.getInt(1);
            }
        }
        finally
        {
            closeConnection();
        }
        return 0;
    }

    public List<CarDTO> getAllCar(int index, int size) throws Exception
    {
        List<CarDTO> result;
        CarDTO dto;
        String carID, carName, carImage, carColor, category;
        float price;
        int carQuantity, yearOfManufacture;
        String sql = "With x As(Select ROW_NUMBER() Over (Order By carName) as num, carID, carName, carImage, carPrice, carColor, yearOfManufacture, category From tblCar) Select carID, carName, carImage, carPrice, carColor, yearOfManufacture, category From x Where num between ?*?-(?-1) And ?*?";
        try
        {
            conn = DBHelper.makeConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, index);
            preStm.setInt(2, size);
            preStm.setInt(3, size);
            preStm.setInt(4, index);
            preStm.setInt(5, size);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next())
            {
                carID = rs.getString("carID");
                carName = rs.getString("carName");
                carImage = rs.getString("carImage");
                price = rs.getFloat("carPrice");
                carColor = rs.getString("carColor");
                yearOfManufacture = rs.getInt("yearOfManufacture");
                category = rs.getString("category");
                dto = new CarDTO(carID, carName, carImage, carColor, category, price, yearOfManufacture);
                result.add(dto);
            }
        }
        finally
        {
            closeConnection();
        }
        return result;
    }
//    public int countCarByName(String name) throws Exception
//    {
//        String sql = "Select count(*) From tblCar Where carName Like ?";
//        try
//        {
//            conn = DBHelper.makeConnection();
//            preStm = conn.prepareStatement(sql);
//            preStm.setString(1,"%" + name + "%");
//            rs = preStm.executeQuery();
//            while(rs.next())
//            {
//                return rs.getInt(1);
//            }
//        }
//        finally
//        {
//            closeConnection();
//        }
//        return 0;
//    }
//
//    public List<CarDTO> getCarByName(int index, int size, String name) throws Exception
//    {
//        List<CarDTO> result;
//        CarDTO dto;
//        String carID, carName, carImage, carColor, category;
//        float price;
//        int yearOfManufacture;
//        String sql = "With x As(Select ROW_NUMBER() Over (Order By carName) as num, carID, carName, carImage, carPrice, carColor, yearOfManufacture, category From tblCar Where carName Like ?) Select carID, carName, carImage, carPrice, carColor, yearOfManufacture, category From x Where num between ?*?-(?-1) And ?*?";
//        try
//        {
//            conn = DBHelper.makeConnection();
//            preStm = conn.prepareStatement(sql);
//            preStm.setString(1, "%" + name + "%");
//            preStm.setInt(2, index);
//            preStm.setInt(3, size);
//            preStm.setInt(4, size);
//            preStm.setInt(5, index);
//            preStm.setInt(6, size);
//            rs = preStm.executeQuery();
//            result = new ArrayList<>();
//            while (rs.next())
//            {
//                carID = rs.getString("carID");
//                carName = rs.getString("carName");
//                carImage = rs.getString("carImage");
//                price = rs.getFloat("carPrice");
//                carColor = rs.getString("carColor");
//                yearOfManufacture = rs.getInt("yearOfManufacture");
//                category = rs.getString("category");
//                dto = new CarDTO(carID, carName, carImage, carColor, category, price, yearOfManufacture);
//                result.add(dto);
//            }
//        }
//        finally
//        {
//            closeConnection();
//        }
//        return result;
//    }
//
//    public int countCarByCategory(String category) throws Exception
//    {
//        String sql = "Select count(*) From tblCar Where category = ?";
//        try
//        {
//            conn = DBHelper.makeConnection();
//            preStm = conn.prepareStatement(sql);
//            preStm.setString(1, category);
//            rs = preStm.executeQuery();
//            while(rs.next())
//            {
//                return rs.getInt(1);
//            }
//        }
//        finally
//        {
//            closeConnection();
//        }
//        return 0;
//    }
//
//    public List<CarDTO> getCarByCategory(int index, int size, String cate) throws Exception
//    {
//        List<CarDTO> result;
//        CarDTO dto;
//        String carID, carName, carImage, carColor, category;
//        float price;
//        int yearOfManufacture;
//        String sql = "With x As(Select ROW_NUMBER() Over (Order By carName) as num, carID, carName, carImage, carPrice, carColor, yearOfManufacture, category From tblCar Where category = ?) Select carID, carName, carImage, carPrice, carColor, yearOfManufacture, category From x Where num between ?*?-(?-1) And ?*?";
//        try
//        {
//            conn = DBHelper.makeConnection();
//            preStm = conn.prepareStatement(sql);
//            preStm.setString(1, cate);
//            preStm.setInt(2, index);
//            preStm.setInt(3, size);
//            preStm.setInt(4, size);
//            preStm.setInt(5, index);
//            preStm.setInt(6, size);
//            rs = preStm.executeQuery();
//            result = new ArrayList<>();
//            while (rs.next())
//            {
//                carID = rs.getString("carID");
//                carName = rs.getString("carName");
//                carImage = rs.getString("carImage");
//                price = rs.getFloat("carPrice");
//                carColor = rs.getString("carColor");
//                yearOfManufacture = rs.getInt("yearOfManufacture");
//                category = rs.getString("category");
//                dto = new CarDTO(carID, carName, carImage, carColor, category, price, yearOfManufacture);
//                result.add(dto);
//            }
//        }
//        finally
//        {
//            closeConnection();
//        }
//        return result;
//    }

    public List<CarDTO> getCarByDate() throws Exception
    {
        List<CarDTO> result;
        CarDTO dto;
        String carID, carName, carImage, carColor, category;
        float price;
        int yearOfManufacture;
        String sql = "Select carID, carName, carImage, carPrice, carColor, yearOfManufacture, category From tblCar";
        try
        {
            conn = DBHelper.makeConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next())
            {
                carID = rs.getString("carID");
                carName = rs.getString("carName");
                carImage = rs.getString("carImage");
                price = rs.getFloat("carPrice");
                carColor = rs.getString("carColor");
                yearOfManufacture = rs.getInt("yearOfManufacture");
                category = rs.getString("category");
                dto = new CarDTO(carID, carName, carImage, carColor, category, price, yearOfManufacture);
                result.add(dto);
            }
        }
        finally
        {
            closeConnection();
        }
        return result;
    }

//    public int getRentingQuantity(String begin, String end, String id) throws Exception
//    {
//        String sql = "Select C.carID, Sum(D.orderQuantity) As 'Count' From tblCar C Inner Join tblOrderDetail D On C.carID = D.carID Inner Join tblOrder O On D.orderID = O.orderID Where ((O.orderDate Between ? And ?) Or (O.returnDate Between ? And ?) Or (O.orderDate < ? And O.returnDate > ?)) And D.carID = ? Group By C.carID";
//        try
//        {
//            conn = DBHelper.makeConnection();
//            preStm = conn.prepareStatement(sql);
//            preStm.setString(1, begin);
//            preStm.setString(2, end);
//            preStm.setString(3, begin);
//            preStm.setString(4, end);
//            preStm.setString(5, begin);
//            preStm.setString(6, end);
//            preStm.setString(7, id);
//            rs = preStm.executeQuery();
//            while(rs.next())
//            {
//                return rs.getInt(2);
//            }
//        }
//        finally
//        {
//            closeConnection();
//        }
//        return 0;
//    }

    public CarDTO findCarAddToCart(String id) throws Exception
    {
        CarDTO dto = null;
        String carID, carName, carImage, carColor, category;
        float price;
        int yearOfManufacture;
        String sql = "Select carID, carName, carImage, carPrice, carColor, yearOfManufacture, category From tblCar Where carID = ?";
        try
        {
            conn = DBHelper.makeConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            if (rs.next())
            {
                carID = rs.getString("carID");
                carName = rs.getString("carName");
                carImage = rs.getString("carImage");
                price = rs.getFloat("carPrice");
                carColor = rs.getString("carColor");
                yearOfManufacture = rs.getInt("yearOfManufacture");
                category = rs.getString("category");
                dto = new CarDTO(carID, carName, carImage, carColor, category, price, yearOfManufacture);
            }
        }
        finally
        {
            closeConnection();
        }
        return dto;
    }

    public boolean setStatus(String id, String status) throws Exception
    {
        boolean check = false;
        String sql = "Update tblCar Set status = ? Where carID = ?";
        try
        {
            conn = DBHelper.makeConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, status);
            preStm.setString(2, id);
            check = preStm.executeUpdate() >0;
        }
        finally
        {
            closeConnection();
        }
        return check;
    }

    public List<CarDTO> findMoreCarAddToCart(String name) throws Exception
    {
        List<CarDTO> result = new ArrayList<>();
        CarDTO dto = null;
        String carID, carName, carImage, carColor, category;
        float price;
        int yearOfManufacture;
        String sql = "Select carID, carName, carImage, carPrice, carColor, yearOfManufacture, category From tblCar Where carName = ?";
        try
        {
            conn = DBHelper.makeConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, name);
            rs = preStm.executeQuery();
            while (rs.next())
            {
                carID = rs.getString("carID");
                carName = rs.getString("carName");
                carImage = rs.getString("carImage");
                price = rs.getFloat("carPrice");
                carColor = rs.getString("carColor");
                yearOfManufacture = rs.getInt("yearOfManufacture");
                category = rs.getString("category");
                dto = new CarDTO(carID, carName, carImage, carColor, category, price, yearOfManufacture);
                result.add(dto);
            }
        }
        finally
        {
            closeConnection();
        }
        return result;
    }

//    public String getStatus(String id) throws Exception
//    {
//        String sql = "Select status From tblCar Where carID = ?";
//        try
//        {
//            conn = DBHelper.makeConnection();
//            preStm = conn.prepareStatement(sql);
//            preStm.setString(1, id);
//            rs = preStm.executeQuery();
//            if(rs.next())
//            {
//                return rs.getString("status");
//            }
//        }
//        finally
//        {
//            closeConnection();
//        }
//        return "";
//    }
    
    public boolean checkAvailableByDate(String id, String begin, String end) throws Exception
    {
        String sql = "Select D.orderID From tblOrder O Inner Join tblOrderDetail D On O.orderID = D.orderID Where ((O.orderDate Between ? And ?) Or (O.returnDate Between ? And ?) Or (O.orderDate < ? And O.returnDate > ?)) And D.carID = ? ";
        try
        {
            conn = DBHelper.makeConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, begin);
            preStm.setString(2, end);
            preStm.setString(3, begin);
            preStm.setString(4, end);
            preStm.setString(5, begin);
            preStm.setString(6, end);
            preStm.setString(7, id);
            rs = preStm.executeQuery();
            while(rs.next())
            {
                return true;
            }
        }
        finally
        {
            closeConnection();
        }
        return false;
    }
}
