/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelets;

import entities.Niveau;
import entities.Obstacle;
import entities.Soldat;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.NiveauFacadeLocal;
import service.ObstacleFacadeLocal;
import service.SoldatFacadeLocal;

/**
 *
 * @author ghost
 */
@WebServlet(name = "ObstacleServelet", urlPatterns = {"/obstacle"})
public class ObstacleServelet extends HttpServlet {

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
    private ObstacleFacadeLocal obsEjb;
    @EJB
    private NiveauFacadeLocal nivEjb;
    @EJB
    private SoldatFacadeLocal soldatEjb;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "addObstacle":
                List<Niveau>listNiveau=nivEjb.findAll();
                List<Obstacle>listObstacle=obsEjb.findAll();
                List<Soldat>listSoldat=soldatEjb.findAll();
                request.setAttribute("listNiv", listNiveau);
                request.setAttribute("listObstacle", listObstacle);
                 request.setAttribute("listSoldat", listSoldat);
                getServletContext().getRequestDispatcher("/obstacle.jsp").forward(request, response);
                break;
            case "addNiveau":
                 
                getServletContext().getRequestDispatcher("/niveau.jsp").forward(request, response);
                break;
            case "":
                 List<Obstacle>listObs=obsEjb.findAll();
                   request.setAttribute("listObs",listObs );
                       getServletContext().getRequestDispatcher("/consulterObstacle.jsp").forward(request, response);
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "addObstacle":
                Obstacle obs = new Obstacle();
                obs.setNumObstacle(request.getParameter("numObstacle"));
                obs.setNomObstacle(request.getParameter("nomObstacle"));
                obs.setNiveau(nivEjb.find(Integer.parseInt(request.getParameter("niveau"))));
                obs.setNoteMin(Integer.parseInt(request.getParameter("noteMin")));
                obs.setTemps(Integer.parseInt(request.getParameter("temps")));                
                try
                {
                   
                    obsEjb.create(obs);
                getServletContext().getRequestDispatcher("/obstacle.jsp").forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
            case "addNiveau":
                Niveau niv = new Niveau();
                try {
                    niv.setLevel(request.getParameter("level"));
                    niv.setBonus(Integer.parseInt(request.getParameter("bonus")));
                    System.out.println(niv.getLevel() + "/" + niv.getBonus());
                    nivEjb.create(niv);
                    getServletContext().getRequestDispatcher("/niveau.jsp").forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;

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
