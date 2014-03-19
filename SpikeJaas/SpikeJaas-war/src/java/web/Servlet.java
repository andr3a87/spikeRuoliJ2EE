/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package web;

import ejb.GestoreFilmLocal;
import ejb.Movies;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Principal;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andr3A
 */
public class Servlet extends HttpServlet {
    @EJB
    private GestoreFilmLocal gestoreFilm;

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
        gestoreFilm.addMovie("Stanley Kubrick", "Shining", 1980);
        
        Movies m = new Movies();
        m.setTitolo("Stanley Kubrick");
        m.setRegista("Shining");
        m.setAnno(1980);
        //gestoreFilm.deleteMovie(m);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet at " + request.getContextPath() + "</h1>");
           
            //request.login(username, password);
             
            //Retrieve the Principal
            Principal principal = request.getUserPrincipal();
            String message = "";
            //Display a message based on the User role
            if(request.isUserInRole("administrator")){
                message = "Username : " + principal.getName() + " You are an Administrator";
            }else if(request.isUserInRole("manager")){
                message = "Username : " + principal.getName() + " You are only a Manager";
            }else if(request.isUserInRole("Guest")){
                message = "Username : " + principal.getName() + " You're wasting my resources...";
            }
            else{
                message = " You're simply user";
            }
            out.println(message);
            out.println("</body>");
            out.println("</html>");
            
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
