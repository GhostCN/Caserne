package entities;

import entities.Passage;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-23T19:18:43")
@StaticMetamodel(Note.class)
public class Note_ { 

    public static volatile SingularAttribute<Note, Double> noteFin;
    public static volatile ListAttribute<Note, Passage> passageList;
    public static volatile SingularAttribute<Note, Integer> id;
    public static volatile SingularAttribute<Note, Integer> soldat;

}