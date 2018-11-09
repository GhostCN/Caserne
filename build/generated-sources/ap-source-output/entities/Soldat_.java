package entities;

import entities.DetailPassage;
import entities.Passage;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-23T19:18:43")
@StaticMetamodel(Soldat.class)
public class Soldat_ { 

    public static volatile SingularAttribute<Soldat, String> matricule;
    public static volatile ListAttribute<Soldat, DetailPassage> detailPassageList;
    public static volatile ListAttribute<Soldat, Passage> passageList;
    public static volatile SingularAttribute<Soldat, String> grade;
    public static volatile SingularAttribute<Soldat, String> typeSoldat;
    public static volatile SingularAttribute<Soldat, String> tel;
    public static volatile SingularAttribute<Soldat, Integer> id;
    public static volatile SingularAttribute<Soldat, String> prenom;
    public static volatile SingularAttribute<Soldat, String> nom;
    public static volatile SingularAttribute<Soldat, String> email;

}