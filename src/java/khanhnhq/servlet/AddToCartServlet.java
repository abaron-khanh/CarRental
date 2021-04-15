/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanhnhq.servlet;

import java.io.IOException;
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
public class AddToCartServlet extends HttpServlet {
    private static final String LOGIN = "login.html";
    private static final String LOAD = "LoadAllCarServlet";
    private static final String DATE = "SearchByDateServlet";
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
        String id = request.getParameter("cartCarID");
        String isSearch = request.getParameter("isSearch");
        String name = request.getParameter("txtSearchName");
        String category = request.getParameter("btnCategory");
        String rentalDate = request.getParameter("txtRentalDate");
        String returnDate = request.getParameter("txtReturnDate");
        String url = LOAD;
        try
        {
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");
            if(username != null)
            {
                CarDAO dao = new CarDAO();
                CarDTO dto = dao.findCarAddToCart(id);
                CartDTO shoppingCart = (CartDTO) session.getAttribute("shoppingCart");
//                Float total = (Float) session.getAttribute("total");
                float Total = 0;
                if (shoppingCart == null) 
                {
                    shoppingCart = new CartDTO(username);
                }
                shoppingCart.addToCart(dto);
                for (CarDTO dtos : shoppingCart.getCart().values())
                {
                    Total = Total + dtos.getPrice();
                }
                session.setAttribute("shoppingCart", shoppingCart);
                session.setAttribute("total", (float)Math.round(Total * 100)/100);
//                System.out.println("Customer: " + username);
//                for (CarDTO dtos : shoppingCart.getCart().values()) 
//                {
//                    System.out.println(dtos.getCarID()+ "-" + dtos.getCarName());
//                }
                if(isSearch == null)
                    url = LOAD;
                else
                {
                    url = DATE;
                }
            }
            else
            {
                url = LOGIN;
            }
        }
        catch (Exception e) 
        {
            log("ERROR at AddToCartServlet" + e.getMessage());
        } 
        finally 
        {
            request.getRequestDispatcher(url).forward(request, response);
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
