/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.entities;

import com.lateu.projet.lycee.Enum.Appreciation;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 *
 * @author richardlateu
 */
@NamedQueries({
    @NamedQuery(name = "Note.All", query = "select n from Notes n ORDER BY n.id DESC")
})
@Entity
public class Notes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Max(20)
    @Min(0)
    private double note;
    @Column(nullable = false)
    private Appreciation appreciation;
    /**
     *
     */

    @ManyToOne(fetch = FetchType.EAGER)
    private Eleve eleve;
    /**
     *
     */
 
    @ManyToOne(fetch = FetchType.EAGER)
    private AnneeScolaire annee;
    /**
     *
     */

    @ManyToOne(fetch = FetchType.EAGER)
    private Sequence sequence;
    /**
     *
     */

    @ManyToOne(fetch = FetchType.EAGER)
    private Matiere matiere;

    public Notes(double note, Appreciation appreciation) {
        this.note = note;
        this.appreciation = appreciation;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public AnneeScolaire getAnnee() {
        return annee;
    }

    public void setAnnee(AnneeScolaire annee) {
        this.annee = annee;
    }

    public Sequence getSequence() {
        return sequence;
    }

    public void setSequence(Sequence sequence) {
        this.sequence = sequence;
    }

    public Notes() {
    }

    public double getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Notes)) {
            return false;
        }
        Notes other = (Notes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lateu.projet.lycee.entities.Notes[ id=" + id + " ]";
    }

    public Appreciation getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(Appreciation appreciation) {
        this.appreciation = appreciation;
    }
}
