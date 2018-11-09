package entities;

import entities.Obstacle;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-23T19:18:43")
@StaticMetamodel(Niveau.class)
public class Niveau_ { 

    public static volatile ListAttribute<Niveau, Obstacle> obstacleList;
    public static volatile SingularAttribute<Niveau, String> level;
    public static volatile SingularAttribute<Niveau, Integer> bonus;
    public static volatile SingularAttribute<Niveau, Integer> id;

}