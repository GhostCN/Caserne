/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Obstacle;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ghost
 */
@Local
public interface ObstacleFacadeLocal {

    void create(Obstacle obstacle);

    void edit(Obstacle obstacle);

    void remove(Obstacle obstacle);

    Obstacle find(Object id);

    List<Obstacle> findAll();

    List<Obstacle> findRange(int[] range);

    int count();
    
}
