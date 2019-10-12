/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Acer
 */
@WebServlet(name = "DispatchServlet", urlPatterns = {"/DispatchServlet"})
public class DispatchServlet extends HttpServlet {

    private final String LOGIN_PAGE = "login.html";
    private final String LOGIN_SERVLET = "LoginServlet";
    private final String SEARCH_LASTNAME_SERVLET = "SearchLastnameServlet";
    private final String DELETE_ACCOUNT_SERVLET = "DeleteAcountServlet";
     private final String INIT_APP_SERVLET = "InitAppServlet";
     private final String UPDATE_SERVLET = "UpdateServlet";
     private final String ADD_ITEM_TO_CART_SERVLET = "AddItemToCartServlet";
     private final String VIEW_CART_PAGE = "viewCart.jsp";
     private final String REMOVE_ITEMS_FROM_CART = "RemoveItemsFromCartServlet";
     private final String CHECK_OUT = "CheckoutServlet";
     private final String CREATE_NEW_ACOUNT_SERVLET = "CreateNewAccountServlet";
    /**
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
        PrintWriter out = response.getWriter();
        String button = request.getParameter("btAction");
        String url = LOGIN_PAGE;
        try {

            if (button == null) {
                url = INIT_APP_SERVLET;
            } else if (button.equals("Login")) {
                url = LOGIN_SERVLET;
            } else if (button.equals("Search")) {
                url = SEARCH_LASTNAME_SERVLET;
            } else if (button.equals("delete")) {
                url = DELETE_ACCOUNT_SERVLET;
            } else if (button.equals("Update")) {
                url = UPDATE_SERVLET;
                
            } else if(button.equals("Add book to your cart")) {
                url = ADD_ITEM_TO_CART_SERVLET;
                
            } else if(button.equals("View your Cart")) {
                url = VIEW_CART_PAGE;
            } else if(button.equals("remove selected items")) {
                url = REMOVE_ITEMS_FROM_CART;
            } else if(button.equals("checkout")) {
                url = CHECK_OUT;
            } else if(button.equals("Sign up")) {
                url = CREATE_NEW_ACOUNT_SERVLET;
            }

        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();

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
