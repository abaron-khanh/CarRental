/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanhnhq.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import khanhnhq.car.CarDAO;
import khanhnhq.car.CarDTO;
import khanhnhq.cart.CartDTO;

/**
 *
 * @author PC
 */
public class AddCarToCartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("txtName");
        try
        {
            CarDAO dao = new CarDAO();
            HttpSession session = request.getSession();
            CartDTO shoppingCart = (CartDTO) session.getAttribute("shoppingCart");
            List<CarDTO> list = dao.findMoreCarAddToCart(name);
            
            if(list != null)
            {
                for(CarDTO dtos : shoppingCart.getCart().values())
                {
                    for(int i = 0; i < list.size(); i++)
                    {
                        if(dtos.getCarName().equals(name))
                        {
                            if(dtos.getCarID().equals(list.get(i).getCarID()))
                            {
                                list.remove(i);
                            }
                        }
                    }
                }
                if(list.size() != 0)
                {
                    shoppingCart.addToCart(list.get(0));
                    float Total = 0;
                    for (CarDTO dtos : shoppingCart.getCart().values())
                    {
                        Total = Total + dtos.getPrice();
                    }
                    session.setAttribute("shoppingCart", shoppingCart);
                    session.setAttribute("total", (float)Math.round(Total * 100)/100);
                }
                else
                {
                    request.setAttribute("notify", "There are no available car for " + name +"!!!");
                }
            }
            else
            {
                request.setAttribute("notify", "There are no available car for " + name +"!!!");
            }
            
        }
        catch (Exception e) 
        {
            log("ERROR at AddCarToCartServlet" + e.getMessage());
        } 
        finally 
        {
            request.getRequestDispatcher("view_cart.jsp").forward(request, response);
//            response.sendRedirect("view_cart.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
