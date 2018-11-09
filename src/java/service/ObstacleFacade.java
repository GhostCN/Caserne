/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Obstacle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ghost
 */
@Stateless
public class ObstacleFacade extends AbstractFacade<Obstacle> implements ObstacleFacadeLocal {

    @PersistenceContext(unitName = "casernePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ObstacleFacade() {
        super(Obstacle.class);
    }
    
}
