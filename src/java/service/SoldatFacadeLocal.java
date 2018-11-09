/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Soldat;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ghost
 */
@Local
public interface SoldatFacadeLocal {

    void create(Soldat soldat);

    void edit(Soldat soldat);

    void remove(Soldat soldat);

    Soldat find(Object id);

    List<Soldat> findAll();
    List<Soldat> findCadidat();
        List<Soldat> findInstructeur();
    List<Soldat> findRange(int[] range);

    int count();
    
}
