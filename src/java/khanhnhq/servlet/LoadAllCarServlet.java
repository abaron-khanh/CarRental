/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanhnhq.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
public class LoadAllCarServlet extends HttpServlet {

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
        String index = request.getParameter("PageIndex");
        String url = "home.jsp";
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        try
        {
            CarDAO dao = new CarDAO();
            if(index == null)
            {
                index = "1";
            }
            int pageSize = 10;
            int endPage = 0;
            int count = dao.countAllCar();
            endPage = count / pageSize;
            if(count % pageSize != 0)
            {
                endPage++;
            }
            List<CarDTO> listCar = dao.getAllCar(Integer.parseInt(index), pageSize);
//            for(int i = 0; i < listCar.size(); i++)
//            {
//                listCar.get(i).setAvailableQuantity(listCar.get(i).getCarQuantity() - dao.getRentingQuantity(sdf.format(date), sdf.format(date), listCar.get(i).getCarID()));
//            }
            request.setAttribute("listCar", listCar);
            request.setAttribute("countHomePage", endPage);
            request.setAttribute("currentPage", index);
            HttpSession session = request.getSession();
            session.setAttribute("currentDate", sdf.format(date));
            session.setAttribute("rentalDate", sdf.format(date));
            session.setAttribute("returnDate", sdf.format(date));
            CartDTO shoppingCart = (CartDTO) session.getAttribute("shoppingCart");
            if(shoppingCart != null)
            {
                float Total = 0;
                for(CarDTO dtos : shoppingCart.getCart().values())
                {
                    Total =  Total + dtos.getPrice();
                }
                session.setAttribute("total", Total);
            }
        }
        catch (Exception e) 
        {
            log("Error at LoadAllCarServlet" + e.getMessage());
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
