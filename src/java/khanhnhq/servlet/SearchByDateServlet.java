/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanhnhq.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import khanhnhq.car.CarDAO;
import khanhnhq.car.CarDTO;

/**
 *
 * @author PC
 */
public class SearchByDateServlet extends HttpServlet {

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
        String index = request.getParameter("SearchPageIndex");
        String rentalDate = request.getParameter("txtRentalDate");
        String returnDate = request.getParameter("txtReturnDate");
        String name = request.getParameter("txtSearchName");
        String category = request.getParameter("txtCategory");
        String url = "home.jsp";
        try
        {
            CarDAO dao = new CarDAO();
            List<CarDTO> list = dao.getCarByDate();
            for(int i = 0; i < list.size(); i++)
            {
//                list.get(i).setAvailableQuantity(list.get(i).getCarQuantity() - dao.getRentingQuantity(rentalDate, returnDate, list.get(i).getCarID()));
////                System.out.println(list.get(i).getCarID() + "-" + list.get(i).getAvailableQuantity());
//                if(list.get(i).getCarQuantity() - dao.getRentingQuantity(rentalDate, returnDate, list.get(i).getCarID()) == 0)
//                {
//                    list.remove(i);
//                    i--;
//                }
                if(dao.checkAvailableByDate(list.get(i).getCarID(), rentalDate, returnDate))
                {
                    list.remove(list.get(i));
                    i--;
                }
            }
            if(name.equals(""))
            {
                for(int i = 0; i < list.size(); i++)
                {
                    if(!list.get(i).getCategory().equals(category))
                    {
                        list.remove(list.get(i));
                        i--;
                    }
                }
            }
            else
            {
                for(int i = 0; i < list.size(); i++)
                {
                    if(!list.get(i).getCarName().toLowerCase().contains(name.toLowerCase()))
                    {
                        list.remove(list.get(i));
                        i--;
                    }
                }
            }
            if(index == null)
            {
                index = "1";
            }
            int pageSize = 10;
            int endPage = 0;
            int count = list.size();
            endPage = count / pageSize;
            if(count % pageSize != 0)
            {
                endPage++;
            }
            List<CarDTO> listCar = new ArrayList<>();
            for(int i = Integer.parseInt(index)*pageSize - pageSize; listCar.size() < pageSize && i < list.size(); i++)
            {
                listCar.add(list.get(i));
            }
            request.setAttribute("listSearchCar", listCar);
            request.setAttribute("countSearchPage", endPage);
            request.setAttribute("currentSearchPage", index);
            request.setAttribute("searchRentalDate", rentalDate);
            request.setAttribute("searchReturnDate", returnDate);
            request.setAttribute("searchName", name);
            request.setAttribute("searchCategory", category);
        }
        catch (Exception e) 
        {
            log("Error at SearchByCategoryServlet" + e.getMessage());
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
