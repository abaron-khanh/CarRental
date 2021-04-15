/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanhnhq.order;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import khanhnhq.car.CarDTO;

/**
 *
 * @author PC
 */
public class OrderDTO implements Serializable{
    private String orderID, username, status, customerName, address, phone;
    private float total;
    private Date orderDate, returnDate, createDate;
    private List<CarDTO> detail;

    public OrderDTO() {
    }

    public OrderDTO(String orderID, String username, String status, String customerName, String address, String phone, float total, Date orderDate, Date returnDate, Date createDate) {
        this.orderID = orderID;
        this.username = username;
        this.status = status;
        this.customerName = customerName;
        this.address = address;
        this.phone = phone;
        this.total = total;
        this.orderDate = orderDate;
        this.returnDate = returnDate;
        this.createDate = createDate;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<CarDTO> getDetail() {
        return detail;
    }

    public void setDetail(List<CarDTO> detail) {
        this.detail = detail;
    }
}
