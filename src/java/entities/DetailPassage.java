/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ghost
 */
@Entity
@Table(name = "detailPassage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetailPassage.findAll", query = "SELECT d FROM DetailPassage d")
    , @NamedQuery(name = "DetailPassage.findById", query = "SELECT d FROM DetailPassage d WHERE d.id = :id")
    , @NamedQuery(name = "DetailPassage.findByResultat", query = "SELECT d FROM DetailPassage d WHERE d.resultat = :resultat")})
public class DetailPassage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "resultat")
    private String resultat;
    @JoinColumn(name = "passage", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Passage passage;
    @JoinColumn(name = "soldat", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Soldat soldat;

    public DetailPassage() {
    }

    public DetailPassage(Integer id) {
        this.id = id;
    }

    public DetailPassage(Integer id, String resultat) {
        this.id = id;
        this.resultat = resultat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public Passage getPassage() {
        return passage;
    }

    public void setPassage(Passage passage) {
        this.passage = passage;
    }

    public Soldat getSoldat() {
        return soldat;
    }

    public void setSoldat(Soldat soldat) {
        this.soldat = soldat;
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
        if (!(object instanceof DetailPassage)) {
            return false;
        }
        DetailPassage other = (DetailPassage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DetailPassage[ id=" + id + " ]";
    }
    
}
