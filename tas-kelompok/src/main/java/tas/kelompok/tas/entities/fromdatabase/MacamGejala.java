/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tas.kelompok.tas.entities.fromdatabase;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
    , @NamedQuery(name = "MacamGejala.findByIdKuesioner", query = "SELECT m FROM MacamGejala m WHERE m.idKuesioner = :idKuesioner")
    , @NamedQuery(name = "MacamGejala.findByRagamGejala", query = "SELECT m FROM MacamGejala m WHERE m.ragamGejala = :ragamGejala")})
public class MacamGejala implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_kuesioner")
    private String idKuesioner;
    @Basic(optional = false)
    @Column(name = "ragam_gejala")
    private String ragamGejala;
    @JoinColumn(name = "id_kuesioner", referencedColumnName = "id_kuesioner", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Kuesioner kuesioner;

    public MacamGejala() {
    }

    public MacamGejala(String idKuesioner) {
        this.idKuesioner = idKuesioner;
    }

    public MacamGejala(String idKuesioner, String ragamGejala) {
        this.idKuesioner = idKuesioner;
        this.ragamGejala = ragamGejala;
    }

    public String getIdKuesioner() {
        return idKuesioner;
    }

    public void setIdKuesioner(String idKuesioner) {
        this.idKuesioner = idKuesioner;
    }

    public String getRagamGejala() {
        return ragamGejala;
    }

    public void setRagamGejala(String ragamGejala) {
        this.ragamGejala = ragamGejala;
    }

    public Kuesioner getKuesioner() {
        return kuesioner;
    }

    public void setKuesioner(Kuesioner kuesioner) {
        this.kuesioner = kuesioner;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKuesioner != null ? idKuesioner.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MacamGejala)) {
            return false;
        }
        MacamGejala other = (MacamGejala) object;
        if ((this.idKuesioner == null && other.idKuesioner != null) || (this.idKuesioner != null && !this.idKuesioner.equals(other.idKuesioner))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tas.kelompok.tas.entities.fromdatabase.MacamGejala[ idKuesioner=" + idKuesioner + " ]";
    }
    
}
