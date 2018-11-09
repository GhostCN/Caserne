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
@Table(name = "niveau")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Niveau.findAll", query = "SELECT n FROM Niveau n")
    , @NamedQuery(name = "Niveau.findById", query = "SELECT n FROM Niveau n WHERE n.id = :id")
    , @NamedQuery(name = "Niveau.findByLevel", query = "SELECT n FROM Niveau n WHERE n.level = :level")
    , @NamedQuery(name = "Niveau.findByBonus", query = "SELECT n FROM Niveau n WHERE n.bonus = :bonus")})
public class Niveau implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "level")
    private String level;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bonus")
    private int bonus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "niveau")
    private List<Obstacle> obstacleList;

    public Niveau() {
    }

    public Niveau(Integer id) {
        this.id = id;
    }

    public Niveau(Integer id, String level, int bonus) {
        this.id = id;
        this.level = level;
        this.bonus = bonus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @XmlTransient
    @JsonIgnore
    public List<Obstacle> getObstacleList() {
        return obstacleList;
    }

    public void setObstacleList(List<Obstacle> obstacleList) {
        this.obstacleList = obstacleList;
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
        if (!(object instanceof Niveau)) {
            return false;
        }
        Niveau other = (Niveau) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Niveau[ id=" + id + " ]";
    }
    
}
