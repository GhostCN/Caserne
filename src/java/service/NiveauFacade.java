/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Niveau;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ghost
 */
@Stateless
public class NiveauFacade extends AbstractFacade<Niveau> implements NiveauFacadeLocal {

    @PersistenceContext(unitName = "casernePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NiveauFacade() {
        super(Niveau.class);
    }
    
}
