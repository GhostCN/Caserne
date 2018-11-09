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
@Table(name = "obstacle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Obstacle.findAll", query = "SELECT o FROM Obstacle o")
    , @NamedQuery(name = "Obstacle.findById", query = "SELECT o FROM Obstacle o WHERE o.id = :id")
    , @NamedQuery(name = "Obstacle.findByNumObstacle", query = "SELECT o FROM Obstacle o WHERE o.numObstacle = :numObstacle")
    , @NamedQuery(name = "Obstacle.findByNomObstacle", query = "SELECT o FROM Obstacle o WHERE o.nomObstacle = :nomObstacle")
    , @NamedQuery(name = "Obstacle.findByNoteMin", query = "SELECT o FROM Obstacle o WHERE o.noteMin = :noteMin")
    , @NamedQuery(name = "Obstacle.findByTemps", query = "SELECT o FROM Obstacle o WHERE o.temps = :temps")})
public class Obstacle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "numObstacle")
    private String numObstacle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nomObstacle")
    private String nomObstacle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "noteMin")
    private double noteMin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "temps")
    private int temps;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "obstacle")
    private List<Passage> passageList;
    @JoinColumn(name = "niveau", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Niveau niveau;

    public Obstacle() {
    }

    public Obstacle(Integer id) {
        this.id = id;
    }

    public Obstacle(Integer id, String numObstacle, String nomObstacle, double noteMin, int temps) {
        this.id = id;
        this.numObstacle = numObstacle;
        this.nomObstacle = nomObstacle;
        this.noteMin = noteMin;
        this.temps = temps;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumObstacle() {
        return numObstacle;
    }

    public void setNumObstacle(String numObstacle) {
        this.numObstacle = numObstacle;
    }

    public String getNomObstacle() {
        return nomObstacle;
    }

    public void setNomObstacle(String nomObstacle) {
        this.nomObstacle = nomObstacle;
    }

    public double getNoteMin() {
        return noteMin;
    }

    public void setNoteMin(double noteMin) {
        this.noteMin = noteMin;
    }

    public int getTemps() {
        return temps;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }

    @XmlTransient
    @JsonIgnore
    public List<Passage> getPassageList() {
        return passageList;
    }

    public void setPassageList(List<Passage> passageList) {
        this.passageList = passageList;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
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
        if (!(object instanceof Obstacle)) {
            return false;
        }
        Obstacle other = (Obstacle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Obstacle[ id=" + id + " ]";
    }
    
}
