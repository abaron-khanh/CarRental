/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanhnhq.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import khanhnhq.car.CarDAO;
import khanhnhq.car.CarDTO;
import khanhnhq.cart.CartDTO;
import khanhnhq.order.OrderDAO;
import khanhnhq.orderdetail.OrderDetailDAO;

/**
 *
 * @author PC
 */
public class CheckOutServlet extends HttpServlet {

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
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        String cusName = request.getParameter("txtCustomerName");
        String phone = request.getParameter("txtCustomerPhone");
        String address = request.getParameter("txtAddress");
        String rentalDate = request.getParameter("txtRentalDate");
        String returnDate = request.getParameter("txtReturnDate");
        SimpleDateFormat formatter1 = new SimpleDateFormat("MM/dd/yyyy");
        String action = request.getParameter("btnAction");
        String url = "";
        try
        {
            boolean check = true;
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");
            CartDTO shoppingCart = (CartDTO) session.getAttribute("shoppingCart");
            CarDAO dao = new CarDAO();
            if(action.equals("Update Total Price"))
            {
                float Total = 0;
                for(CarDTO dtos : shoppingCart.getCart().values())
                {
                    Total =  Total + dtos.getPrice();
                    dtos.setError("");
                }

                long getDiff = formatter1.parse(returnDate).getTime() - formatter1.parse(rentalDate).getTime();
                long getDaysDiff = getDiff / (24 * 60 * 60 * 1000);
                Total = Total * (getDaysDiff + 1);
                session.setAttribute("total", Total);
                session.setAttribute("cusName", cusName);
                session.setAttribute("cusPhone", phone);
                session.setAttribute("cusAddress", address);
                session.setAttribute("rentalDate", rentalDate);
                session.setAttribute("returnDate", returnDate);
                url = "view_cart.jsp";
            }
            else
            {
                for (CarDTO dtos : shoppingCart.getCart().values())
                {
                    if(dao.checkAvailableByDate(dtos.getCarID(), rentalDate, returnDate))
                    {
                        dtos.setError("This car is not available between these days!");
                        check = false;
                    }
                }
                if(check == false)
                {
                    session.setAttribute("cusName", cusName);
                    session.setAttribute("cusPhone", phone);
                    session.setAttribute("cusAddress", address);
                    session.setAttribute("rentalDate", rentalDate);
                    session.setAttribute("returnDate", returnDate);
                    url = "view_cart.jsp";
                }
                else
                {
                    OrderDAO oderDAO = new OrderDAO();
                    String lastID = oderDAO.getLastOrderByUser(username);
                    String orderID = null;
                    if(lastID == null)
                    {
                        orderID = shoppingCart.getCustomerName() + "-1";
                    }
                    else
                    {
                        String[] tmp = lastID.split("-");
                        orderID = shoppingCart.getCustomerName() + "-" + (Integer.parseInt(tmp[1]) + 1);
                    }
                    float Total = 0;
                    for(CarDTO dtos : shoppingCart.getCart().values())
                    {
                        Total =  Total + dtos.getPrice();
                    }

                    long getDiff = formatter1.parse(returnDate).getTime() - formatter1.parse(rentalDate).getTime();
                    long getDaysDiff = getDiff / (24 * 60 * 60 * 1000);
                    Total = Total * (getDaysDiff + 1);
                    boolean createOrder = oderDAO.createOrder(orderID, username, (float)Math.round(Total * 100)/100, formatter1.parse(rentalDate), formatter1.parse(returnDate), "Ordered", cusName, phone, address, new Date());
                    if(createOrder)
                    {
                        OrderDetailDAO detailDAO = new OrderDetailDAO();

                        int count = 1;
                        for(CarDTO dto : shoppingCart.getCart().values())
                        {
                            String orderDetailID = orderID + "-" + count++;
                            detailDAO.createOrderDetails(orderDetailID, dto.getCarID(), orderID);
                        }
                    }
                    session.setAttribute("total", Total);
                    session.setAttribute("orderDetail", shoppingCart.getCart().values());
                    session.setAttribute("cusName", cusName);
                    session.setAttribute("cusPhone", phone);
                    session.setAttribute("cusAddress", address);
                    session.setAttribute("rentalDate", rentalDate);
                    session.setAttribute("returnDate", returnDate);

                    session.removeAttribute("shoppingCart");
                    url = "order_view.jsp";
                }
            }
            
        }
        catch (Exception e) 
        {
            log("ERROR at CheckOutServlet" + e.getMessage());
        } 
        finally 
        {
//            request.getRequestDispatcher(url).forward(request, response);
            response.sendRedirect(url);
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
