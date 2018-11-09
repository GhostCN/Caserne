package entities;

import entities.Niveau;
import entities.Passage;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-23T19:18:43")
@StaticMetamodel(Obstacle.class)
public class Obstacle_ { 

    public static volatile SingularAttribute<Obstacle, String> numObstacle;
    public static volatile SingularAttribute<Obstacle, String> nomObstacle;
    public static volatile ListAttribute<Obstacle, Passage> passageList;
    public static volatile SingularAttribute<Obstacle, Double> noteMin;
    public static volatile SingularAttribute<Obstacle, Integer> id;
    public static volatile SingularAttribute<Obstacle, Integer> temps;
    public static volatile SingularAttribute<Obstacle, Niveau> niveau;

}