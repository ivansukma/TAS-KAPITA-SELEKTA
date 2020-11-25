/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.ivan.uts.entities.fromdatabase;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "macam_gejala")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MacamGejala.findAll", query = "SELECT m FROM MacamGejala m")
    , @NamedQuery(name = "MacamGejala.findById", query = "SELECT m FROM MacamGejala m WHERE m.id = :id")
    , @NamedQuery(name = "MacamGejala.findByRagamGejala", query = "SELECT m FROM MacamGejala m WHERE m.ragamGejala = :ragamGejala")})
public class MacamGejala implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @Column(name = "ragam_gejala")
    private String ragamGejala;
    @JoinColumn(name = "id_kuesioner", referencedColumnName = "id_kuesioner")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Kuesioner idKuesioner;

    public MacamGejala() {
    }

    public MacamGejala(String id) {
        this.id = id;
    }

    public MacamGejala(String id, String ragamGejala) {
        this.id = id;
        this.ragamGejala = ragamGejala;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRagamGejala() {
        return ragamGejala;
    }

    public void setRagamGejala(String ragamGejala) {
        this.ragamGejala = ragamGejala;
    }

    public Kuesioner getIdKuesioner() {
        return idKuesioner;
    }

    public void setIdKuesioner(Kuesioner idKuesioner) {
        this.idKuesioner = idKuesioner;
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
        if (!(object instanceof MacamGejala)) {
            return false;
        }
        MacamGejala other = (MacamGejala) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uts.ivan.uts.entities.fromdatabase.MacamGejala[ id=" + id + " ]";
    }
    
}
