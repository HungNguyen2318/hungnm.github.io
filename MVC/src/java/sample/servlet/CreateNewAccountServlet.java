/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.registration.RegistrationCreateError;
import sample.registration.RegistrationDAO;

/**
 *
 * @author Acer
 */
@WebServlet(name = "CreateNewAccountServlet", urlPatterns = {"/CreateNewAccountServlet"})
public class CreateNewAccountServlet extends HttpServlet {

    private final String ERROR_PAGE = "createNewAccount.jsp";
    private final String LOGIN_PAGE = "login.html";

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
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String confirm = request.getParameter("txtConfirm");
        String fullname = request.getParameter("txtFullname");
        
        String url = ERROR_PAGE;
        RegistrationCreateError errors = new RegistrationCreateError();
        boolean foundError = false;
        try {
            /* TODO output your page here. You may use following sample code. */
            if (username.trim().length() < 6 || username.trim().length() > 20) {
                foundError = true;
                errors.setUserLengthErr("Username require input from 6 to 20");
            }
            if (password.trim().length() < 6 || password.trim().length() > 30) {
                foundError = true;
                errors.setPasswordLengthErr("Password require input from 6 to 30");
            } else if (!confirm.trim().equals(password.trim())) {
                foundError = true;
                errors.setConfirmNotMatch("Cofirm must match password");
            }
            if (fullname.trim().length() < 2 || fullname.trim().length() > 50) {
                foundError = true;
                errors.setFullNameLengthErr("Fullname require input 2 to 50 ");
            }
            if(foundError) {
                // catching errors
                request.setAttribute("CREATEER", errors);
            } else {
                RegistrationDAO dao = new RegistrationDAO();
                boolean result = dao.creatAccount(username, password, fullname, false);
                
                if(result) {
                    url = LOGIN_PAGE;
                }
            }
        } catch (SQLException ex) {
            log("CreateNewAccountServlet _ SQLException" + ex.getMessage());
            if(ex.getMessage().contains("duplicate")) {
                errors.setUsernameIsExisted(username + " is existed!!");
                request.setAttribute("CREATEER", errors);
            }
        } catch (NamingException ex) {
            log("CreateNewAccountServlet _ NamingException" + ex.getMessage());
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
