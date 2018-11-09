/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelets;

import entities.Niveau;
import entities.Obstacle;
import entities.Passage;
import entities.Soldat;
import entities.Utilisateur;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;
import service.NiveauFacadeLocal;
import service.ObstacleFacadeLocal;
import service.PassageFacadeLocal;
import service.SoldatFacadeLocal;

/**
 *
 * @author ghost
 */
@WebServlet(name = "ParcourServelet", urlPatterns = {"/parcours"})
public class ParcourServelet extends HttpServlet {

    @EJB
    private NiveauFacadeLocal nivEjb;
    @EJB
    private ObstacleFacadeLocal listObs;
    @EJB
    private SoldatFacadeLocal listSoldat;
    @EJB
    private PassageFacadeLocal passEJB;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            
           case "chargerTableau":
                List<Passage> passList=passEJB.findAll();
                request.setAttribute("passList", passList);
                  getServletContext().getRequestDispatcher("/consulterParcours.jsp").forward(request, response);
             
                break;
       
            case "note":
                List<Passage>listPass=new ArrayList<>();
                List<Obstacle>lObs=listObs.findAll();
                request.setAttribute("lObs", lObs);
                      
                listPass=passEJB.findAll();
                 request.setAttribute("listPass", listPass);
              getServletContext().getRequestDispatcher("/note.jsp").forward(request, response);
                break;
            case "addNiveau":

                getServletContext().getRequestDispatcher("/niveau.jsp").forward(request, response);

                break;

            case "planifier":

                List<Obstacle> ListObst = new ArrayList<>();
                List<Soldat> ListSolda = new ArrayList<>();
                ListObst = listObs.findAll();
                ListSolda = listSoldat.findAll();

                request.setAttribute("ListObst", ListObst);
                request.setAttribute("ListSolda", ListSolda);

                ObjectMapper mapper = new ObjectMapper();
                String data = mapper.writeValueAsString(ListObst);
                response.getWriter().println(data);
                break;

            case "loadPlanifier":
                List<Soldat> ListInstructeur = new ArrayList<>();
                ListInstructeur = listSoldat.findCadidat();
                request.setAttribute("ListInstructeur", ListInstructeur);
                ListObst = listObs.findAll();
                ListSolda = listSoldat.findInstructeur();
                request.setAttribute("ListObst", ListObst);
                request.setAttribute("ListSolda", ListSolda);
                getServletContext().getRequestDispatcher("/PlaniferParcours.jsp").forward(request, response);
                break;

            case "planifierSold":

                ListSolda = listSoldat.findInstructeur();
                request.setAttribute("ListSolda", ListSolda);
                //   request.setAttribute("ListSolda", ListSolda);
                ObjectMapper mapper1 = new ObjectMapper();
                String data1 = mapper1.writeValueAsString(ListSolda);
                response.getWriter().println(data1);
                break;
            case "loadIntructeur":

                ListInstructeur = listSoldat.findCadidat();

                request.setAttribute("ListInstructeur", ListInstructeur);
                ObjectMapper mapper2 = new ObjectMapper();
                String data2 = mapper2.writeValueAsString(ListInstructeur);
                response.getWriter().println(data2);
                break;

            case "addPlaning":
                int idObs = Integer.parseInt(request.getParameter("obstacle").toString());
                int idSoldat = Integer.parseInt(request.getParameter("soldat").toString());
                Passage p = new Passage();
                p.setNumPassage(request.getParameter("numPassage"));
                p.setObstacle(listObs.find(idObs));
                p.setSoldat(listSoldat.find(idSoldat));
                p.setDate(request.getParameter("date"));   
                p.setInstructeur(request.getParameter("instructeur"));
                System.out.println(p.getInstructeur());
                Utilisateur u=(Utilisateur) request.getSession().getAttribute("userSession");
                p.setUser(u);
                try {
                    passEJB.create(p);
                    String result = "OK";
                    ObjectMapper mapper3 = new ObjectMapper();
                    String data3 = mapper3.writeValueAsString(result);
                    response.getWriter().println(data3);
                } catch (Exception e) {
                }

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
            case "addNiveau":
                getServletContext().getRequestDispatcher("/WEB-INF/niveau.jsp").forward(request, response);
                Niveau niv = new Niveau();
                niv.setLevel(request.getParameter("level"));
                niv.setBonus(Integer.parseInt(request.getParameter("bonus")));
                try {
                    nivEjb.create(niv);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "planifier":

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
