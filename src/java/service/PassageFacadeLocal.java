/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Passage;
import entities.Soldat;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ghost
 */
@Local
public interface PassageFacadeLocal {

    void create(Passage passage);

    void edit(Passage passage);

    void remove(Passage passage);

    Passage find(Object id);
    List<Passage> findAllByOne(String num);
    List<Passage> findAll();
    
    List<Soldat>GetSoldatBynumPassage(String numPass);

    List<Passage> findRange(int[] range);

    int count();
    
}
