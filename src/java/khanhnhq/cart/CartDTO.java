/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanhnhq.cart;

import java.io.Serializable;
import java.util.HashMap;
import khanhnhq.car.CarDAO;
import khanhnhq.car.CarDTO;

/**
 *
 * @author PC
 */
public class CartDTO implements Serializable{
    private String customerName;
    private HashMap<String, CarDTO> cart;
    
    public CartDTO(String customerName) {
        this.customerName = customerName;
        this.cart = new HashMap<>();
    }
    
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public HashMap<String, CarDTO> getCart() {
        return cart;
    }

    public void setCart(HashMap<String, CarDTO> cart) {
        this.cart = cart;
    }
    
    public void addToCart(CarDTO dto) throws Exception
    {
        if(!this.cart.containsKey(dto.getCarID()))
        {
            this.cart.put(dto.getCarID(), dto);
        }
    }
    
    public void remove(String id) throws Exception
    {
        if(this.cart.containsKey(id))
        {
            this.cart.remove(id);
        }
    }
}
