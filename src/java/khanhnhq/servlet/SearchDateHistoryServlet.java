/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanhnhq.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import khanhnhq.order.OrderDAO;
import khanhnhq.order.OrderDTO;
import khanhnhq.orderdetail.OrderDetailDAO;

/**
 *
 * @author PC
 */
public class SearchDateHistoryServlet extends HttpServlet {

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
        String from = request.getParameter("txtOrderDateFrom");
        String to = request.getParameter("txtOrderDateTo");
        try
        {
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");
            OrderDAO dao = new OrderDAO();
            OrderDetailDAO ODdao = new OrderDetailDAO();
//            String year = date.substring(6, 10);
//            String month = date.substring(0, 2);
//            String day = date.substring(3, 5);
            List<OrderDTO> listOrder = dao.getAllOrderByUsernameAndDate(username, from, to);
            for(int i = 0; i < listOrder.size(); i++)
            {
                listOrder.get(i).setDetail(ODdao.getAllOrderDetailByID(listOrder.get(i).getOrderID()));
            }
            request.setAttribute("listSearchOrder", listOrder);
        }
        catch (Exception e) 
        {
            log("Error at SearchNameHistoryServlet" + e.getMessage());
        }
        finally
        {
            request.getRequestDispatcher("history.jsp").forward(request, response);
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
