/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author ghost
 */
@Entity
@Table(name = "note")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Note.findAll", query = "SELECT n FROM Note n")
    , @NamedQuery(name = "Note.findById", query = "SELECT n FROM Note n WHERE n.id = :id")
    , @NamedQuery(name = "Note.findByNoteFin", query = "SELECT n FROM Note n WHERE n.noteFin = :noteFin")
    , @NamedQuery(name = "Note.findBySoldat", query = "SELECT n FROM Note n WHERE n.soldat = :soldat")})
public class Note implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "noteFin")
    private double noteFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "soldat")
    private int soldat;
    @OneToMany(mappedBy = "note")
    private List<Passage> passageList;

    public Note() {
    }

    public Note(Integer id) {
        this.id = id;
    }

    public Note(Integer id, double noteFin, int soldat) {
        this.id = id;
        this.noteFin = noteFin;
        this.soldat = soldat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getNoteFin() {
        return noteFin;
    }

    public void setNoteFin(double noteFin) {
        this.noteFin = noteFin;
    }

    public int getSoldat() {
        return soldat;
    }

    public void setSoldat(int soldat) {
        this.soldat = soldat;
    }

    @XmlTransient
    @JsonIgnore
    public List<Passage> getPassageList() {
        return passageList;
    }

    public void setPassageList(List<Passage> passageList) {
        this.passageList = passageList;
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
        if (!(object instanceof Note)) {
            return false;
        }
        Note other = (Note) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Note[ id=" + id + " ]";
    }
    
}
