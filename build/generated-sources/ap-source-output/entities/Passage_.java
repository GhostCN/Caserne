package entities;

import entities.DetailPassage;
import entities.Note;
import entities.Obstacle;
import entities.Soldat;
import entities.Utilisateur;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-23T19:18:43")
@StaticMetamodel(Passage.class)
public class Passage_ { 

    public static volatile SingularAttribute<Passage, String> numPassage;
    public static volatile SingularAttribute<Passage, String> date;
    public static volatile SingularAttribute<Passage, String> instructeur;
    public static volatile SingularAttribute<Passage, Note> note;
    public static volatile ListAttribute<Passage, DetailPassage> detailPassageList;
    public static volatile SingularAttribute<Passage, Integer> id;
    public static volatile SingularAttribute<Passage, Soldat> soldat;
    public static volatile SingularAttribute<Passage, Utilisateur> user;
    public static volatile SingularAttribute<Passage, Obstacle> obstacle;

}