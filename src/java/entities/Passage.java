/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author ghost
 */
@Entity
@Table(name = "passage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Passage.findAll", query = "SELECT p FROM Passage p")
    , @NamedQuery(name = "Passage.findById", query = "SELECT p FROM Passage p WHERE p.id = :id")
    , @NamedQuery(name = "Passage.findByNumPassage", query = "SELECT p FROM Passage p WHERE p.numPassage = :numPassage")
    , @NamedQuery(name = "passage.ghostdistinct", query = "SELECT DISTINCT p FROM Passage p ")
    , @NamedQuery(name = "Passage.findByDate", query = "SELECT p FROM Passage p WHERE p.date = :date")
    , @NamedQuery(name = "Passage.findByInstructeur", query = "SELECT p FROM Passage p WHERE p.instructeur = :instructeur")})
public class Passage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "numPassage")
    private String numPassage;
    @Size(max = 30)
    @Column(name = "date")
    private String date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "instructeur")
    private String instructeur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "passage")
    private List<DetailPassage> detailPassageList;
    @JoinColumn(name = "user", referencedColumnName = "id")
    @ManyToOne
    private Utilisateur user;
    @JoinColumn(name = "soldat", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Soldat soldat;
    @JoinColumn(name = "note", referencedColumnName = "id")
    @ManyToOne
    private Note note;
    @JoinColumn(name = "obstacle", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Obstacle obstacle;

    public Passage() {
    }

    public Passage(Integer id) {
        this.id = id;
    }

    public Passage(Integer id, String numPassage, String instructeur) {
        this.id = id;
        this.numPassage = numPassage;
        this.instructeur = instructeur;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumPassage() {
        return numPassage;
    }

    public void setNumPassage(String numPassage) {
        this.numPassage = numPassage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInstructeur() {
        return instructeur;
    }

    public void setInstructeur(String instructeur) {
        this.instructeur = instructeur;
    }

    @XmlTransient
    @JsonIgnore
    public List<DetailPassage> getDetailPassageList() {
        return detailPassageList;
    }

    public void setDetailPassageList(List<DetailPassage> detailPassageList) {
        this.detailPassageList = detailPassageList;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public Soldat getSoldat() {
        return soldat;
    }

    public void setSoldat(Soldat soldat) {
        this.soldat = soldat;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Passage)) {
            return false;
        }
        Passage other = (Passage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Passage[ id=" + id + " ]";
    }
    
}
