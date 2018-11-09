/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Passage;
import static entities.Passage_.instructeur;
import entities.Soldat;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ghost
 */
@Stateless
public class PassageFacade extends AbstractFacade<Passage> implements PassageFacadeLocal {

    @PersistenceContext(unitName = "casernePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PassageFacade() {
        super(Passage.class);
    }

    @Override
    public List<Soldat> GetSoldatBynumPassage(String numPass) {
        List<Passage> listPass = em.createNamedQuery("Passage.findByNumPassage", Passage.class)
                .setParameter("numPassage", numPass).getResultList();
        List<Soldat> listSoldat = new ArrayList<>();
        for (Passage passage : listPass) {
            listSoldat.add(em.find(Soldat.class, passage.getSoldat()));
        }
        return listSoldat;
    }

    @Override
    public List<Passage> findAllByOne(String num) {
       List<Passage> listPass = em.createNamedQuery("Passage.findByInstructeur",Passage.class).setParameter("instructeur", num).getResultList();
       return listPass;
    }

}
