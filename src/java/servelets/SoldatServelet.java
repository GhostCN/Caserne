/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelets;

import entities.Soldat;
import entities.Utilisateur;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.SoldatFacadeLocal;

/**
 *
 * @author ghost
 */
@WebServlet(name = "SoldatServelet", urlPatterns = {"/soldat"})
public class SoldatServelet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @EJB
    private SoldatFacadeLocal soldatEJB;
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "addSoldat":
                 
                getServletContext().getRequestDispatcher("/Soldat.jsp").forward(request, response);
                break;
            case "Loadtableau":
                List<Soldat> listSoldat=soldatEJB.findAll();
                request.setAttribute("listSoldat", listSoldat);
                  getServletContext().getRequestDispatcher("/ConsulterSoldat.jsp").forward(request, response);
                break;
           
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     @EJB
    private SoldatFacadeLocal soldatEjb;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String action = request.getParameter("action");
        switch (action)
        {
            case "addSoldat":
                
               
                Soldat s = new Soldat();
                s.setMatricule(request.getParameter("matricule"));
                s.setNom(request.getParameter("nom"));
                s.setPrenom(request.getParameter("prenom"));
                s.setEmail(request.getParameter("email"));
                s.setTel(request.getParameter("tel"));
                s.setGrade(request.getParameter("grade"));
                s.setTypeSoldat(request.getParameter("TypeSoldat"));
            //    System.out.println(s.getId());
                System.out.println(s.getMatricule());
                 System.out.println(s.getNom());
                System.out.println(s.getPrenom());
                System.out.println(s.getEmail());
                 System.out.println(s.getTel());
                System.out.println(s.getTypeSoldat());
                 try {
                    soldatEjb.create(s);
                  //  request.setAttribute("reussie", "Soldat bien inséré");
                  //  getServletContext().getRequestDispatcher("/index.jsp");
                } catch (Exception e) {
                    e.printStackTrace();
                }

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
