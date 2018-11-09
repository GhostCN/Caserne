/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelets;

import entities.Utilisateur;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.UtilisateurFacadeLocal;

/**
 *
 * @author ghost
 */
@WebServlet(name = "UserServelet", urlPatterns = {"/user"})

public class UserServelet extends HttpServlet {

    @EJB
    private UtilisateurFacadeLocal userEJB;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
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
        String login = request.getParameter("login");
        String pwd = request.getParameter("password");
        System.out.println(login + "/" + pwd);
        Utilisateur u = userEJB.FindUser(login, pwd);
        if (u != null) {

            if (u.getProfile().equalsIgnoreCase("admin")) {
                HttpSession session = request.getSession(true);
                session.setAttribute("userSession", u);
                getServletContext().getRequestDispatcher("/menu.jsp").forward(request, response);

            }

            if (u.getProfile().equalsIgnoreCase("instructeur")) {
                HttpSession session = request.getSession(true);
                session.setAttribute("userSession", u);
                getServletContext().getRequestDispatcher("/menu_1.jsp").forward(request, response);

            }

        } else {
            request.setAttribute("error", "Login ou Password incorrect");
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
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
