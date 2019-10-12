/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.servlet;

import com.sun.net.httpserver.HttpServer;
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
import javax.servlet.http.HttpSession;
import sample.registration.RegistrationCreateError;
import sample.registration.RegistrationDAO;

/**
 *
 * @author Acer
 */
@WebServlet(name = "UpdateServlet", urlPatterns = {"/UpdateServlet"})
public class UpdateServlet extends HttpServlet {

    private final String EEROR_PAGE = "search.jsp";

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

        boolean isrole = request.getParameter("chkAdmin") != null;
        RegistrationCreateError errors = new RegistrationCreateError();
        boolean foundError = false;
        String searchValue = request.getParameter("lastSearchValue");
        String url = "SearchLastnameServlet?"
                
                + "&txtSearch="
                + searchValue;
        try {
            /* TODO output your page here. You may use following sample code. */
            if (password.trim().length() < 6 || password.trim().length() > 30) {
                foundError = true;
                errors.setPasswordLengthErr("Password require input from 6 to 30");
            }
            if (foundError) {
               request.setAttribute("UPDATEERROR", errors);
                
            } else {
                RegistrationDAO dao = new RegistrationDAO();
                boolean result = dao.UpdateAccount(username, password, isrole);
                if (result) {
                    url = "searchLastname?"
                            
                            + "&txtSearch="
                            + searchValue;
                }
            }

        } catch (SQLException ex) {
            log("UpdateServlet _ SQLException" + ex.getMessage());
        } catch (NamingException ex) {
            log("UpdateServlet _ NamingException" + ex.getMessage());
        } finally {
            if (foundError) {
                RequestDispatcher rd = request.getRequestDispatcher(url);
                rd.forward(request, response);
//                 response.sendRedirect(url);
            } else {
                response.sendRedirect(url);
            }
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
