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
@Table(name = "soldat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Soldat.findAll", query = "SELECT s FROM Soldat s")
    , @NamedQuery(name = "Soldat.findById", query = "SELECT s FROM Soldat s WHERE s.id = :id")
    , @NamedQuery(name = "Soldat.findByMatricule", query = "SELECT s FROM Soldat s WHERE s.matricule = :matricule")
    , @NamedQuery(name = "Soldat.findByPrenom", query = "SELECT s FROM Soldat s WHERE s.prenom = :prenom")
    , @NamedQuery(name = "Soldat.findByNom", query = "SELECT s FROM Soldat s WHERE s.nom = :nom")
    , @NamedQuery(name = "Soldat.findByTel", query = "SELECT s FROM Soldat s WHERE s.tel = :tel")
    , @NamedQuery(name = "Soldat.findByEmail", query = "SELECT s FROM Soldat s WHERE s.email = :email")
    , @NamedQuery(name = "Soldat.findByGrade", query = "SELECT s FROM Soldat s WHERE s.grade = :grade")
    , @NamedQuery(name = "Soldat.findByTypeSoldat", query = "SELECT s FROM Soldat s WHERE s.typeSoldat = :typeSoldat")})
public class Soldat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "matricule")
    private String matricule;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "tel")
    private String tel;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "grade")
    private String grade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "typeSoldat")
    private String typeSoldat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "soldat")
    private List<DetailPassage> detailPassageList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "soldat")
    private List<Passage> passageList;

    public Soldat() {
    }

    public Soldat(Integer id) {
        this.id = id;
    }

    public Soldat(Integer id, String matricule, String prenom, String nom, String tel, String email, String grade, String typeSoldat) {
        this.id = id;
        this.matricule = matricule;
        this.prenom = prenom;
        this.nom = nom;
        this.tel = tel;
        this.email = email;
        this.grade = grade;
        this.typeSoldat = typeSoldat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getTypeSoldat() {
        return typeSoldat;
    }

    public void setTypeSoldat(String typeSoldat) {
        this.typeSoldat = typeSoldat;
    }

    @XmlTransient
    @JsonIgnore
    public List<DetailPassage> getDetailPassageList() {
        return detailPassageList;
    }

    public void setDetailPassageList(List<DetailPassage> detailPassageList) {
        this.detailPassageList = detailPassageList;
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
        if (!(object instanceof Soldat)) {
            return false;
        }
        Soldat other = (Soldat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Soldat[ id=" + id + " ]";
    }
    
}
