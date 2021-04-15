/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanhnhq.servlet;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import khanhnhq.account.AccountDAO;
import khanhnhq.account.AccountDTO;
import khanhnhq.google.VerifyRecaptcha;
import khanhnhq.order.OrderDAO;

/**
 *
 * @author PC
 */
public class LoginServlet extends HttpServlet {
    private final String HOME = "LoadAllCarServlet";
    private final String ERROR = "error.jsp";
    private final String VERIFY = "verify.jsp";
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
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
        String url = "";
        try 
        {
            OrderDAO oDAO = new OrderDAO();
            oDAO.setStatus();
            boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
            HttpSession session = request.getSession();
            AccountDAO dao = new AccountDAO();
            AccountDTO dto = dao.checkLogin(username, password);
            if(dto == null || !verify)
            {
                if(dto == null)
                {
                    request.setAttribute("error", "Your username or password is invalid!!!");
                }
                else
                {
                    request.setAttribute("error", "You must complete the reCaptcha!!!");
                }
                url = ERROR;
            }
            else if(dto.getStatus().equals("Inactive"))
            {
                url = VERIFY;
                session.setAttribute("username", dto.getUsername());
                session.setAttribute("fullname", dto.getFullname());
                session.setAttribute("email", dto.getEmail());
            }
            else
            {
                url = HOME;
                session.setAttribute("username", dto.getUsername());
                session.setAttribute("fullname", dto.getFullname());
            }
        } 
        catch (Exception e) 
        {
            log("Error at LoginServlet" + e.getMessage());
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
