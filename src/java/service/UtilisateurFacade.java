/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Utilisateur;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ghost
 */
@Stateless
public class UtilisateurFacade extends AbstractFacade<Utilisateur> implements UtilisateurFacadeLocal {

    @PersistenceContext(unitName = "casernePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UtilisateurFacade() {
        super(Utilisateur.class);
    }

    @Override
     public Utilisateur FindUser(String login, String pwd) {
        List<Utilisateur> listU=em.createNamedQuery("Utilisateur.findByGoodUser", Utilisateur.class)
                .setParameter("login", login).setParameter("password", pwd).getResultList();
        if(listU.isEmpty())
        {
            return  null;
            
        }
        else 
        {
             return listU.get(0);
        }
                     
    }
    
}
