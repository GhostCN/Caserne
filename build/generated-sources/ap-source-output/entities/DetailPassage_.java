package entities;

import entities.Passage;
import entities.Soldat;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-23T19:18:43")
@StaticMetamodel(DetailPassage.class)
public class DetailPassage_ { 

    public static volatile SingularAttribute<DetailPassage, Passage> passage;
    public static volatile SingularAttribute<DetailPassage, Integer> id;
    public static volatile SingularAttribute<DetailPassage, Soldat> soldat;
    public static volatile SingularAttribute<DetailPassage, String> resultat;

}