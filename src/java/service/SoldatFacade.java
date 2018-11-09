/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Soldat;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ghost
 */
@Stateless
public class SoldatFacade extends AbstractFacade<Soldat> implements SoldatFacadeLocal {

    @PersistenceContext(unitName = "casernePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SoldatFacade() {
        super(Soldat.class);
    }

    @Override
    public List<Soldat> findCadidat() {
         List<Soldat> listU=em.createNamedQuery("Soldat.findByTypeSoldat", Soldat.class)
                .setParameter("typeSoldat", "soldat").getResultList();
         return listU; 
    }

    @Override
    public List<Soldat> findInstructeur() {
        List<Soldat> listU=em.createNamedQuery("Soldat.findByTypeSoldat", Soldat.class)
                .setParameter("typeSoldat", "instructeur").getResultList();
         return listU; 
    }

  
    
}
