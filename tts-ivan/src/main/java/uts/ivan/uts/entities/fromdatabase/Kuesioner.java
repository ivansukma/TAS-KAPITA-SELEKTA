/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.ivan.uts.entities.fromdatabase;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ivanr
 */
@Entity
@Table(name = "kuesioner")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kuesioner_1.findAll", query = "SELECT k FROM Kuesioner_1 k")
    , @NamedQuery(name = "Kuesioner_1.findByIdKuesioner", query = "SELECT k FROM Kuesioner_1 k WHERE k.idKuesioner = :idKuesioner")
    , @NamedQuery(name = "Kuesioner_1.findByGejalaUmum", query = "SELECT k FROM Kuesioner_1 k WHERE k.gejalaUmum = :gejalaUmum")
    , @NamedQuery(name = "Kuesioner_1.findByKunjunganRS", query = "SELECT k FROM Kuesioner_1 k WHERE k.kunjunganRS = :kunjunganRS")
    , @NamedQuery(name = "Kuesioner_1.findByKunjunganLuarkota", query = "SELECT k FROM Kuesioner_1 k WHERE k.kunjunganLuarkota = :kunjunganLuarkota")
    , @NamedQuery(name = "Kuesioner_1.findByStatusPernahdirawatCovid19", query = "SELECT k FROM Kuesioner_1 k WHERE k.statusPernahdirawatCovid19 = :statusPernahdirawatCovid19")})
public class Kuesioner implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_kuesioner")
    private String idKuesioner;
    @Basic(optional = false)
    @Column(name = "gejala_umum")
    private boolean gejalaUmum;
    @Basic(optional = false)
    @Column(name = "kunjungan_RS")
    private String kunjunganRS;
    @Basic(optional = false)
    @Column(name = "kunjungan_luarkota")
    private String kunjunganLuarkota;
    @Basic(optional = false)
    @Column(name = "status_pernahdirawat_covid19")
    private String statusPernahdirawatCovid19;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idKuesioner", fetch = FetchType.LAZY)
    private Collection<MacamGejala> macamGejalaCollection;
    @JoinColumn(name = "id_form", referencedColumnName = "id_form")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private FormKepentingan idForm;

    public Kuesioner() {
    }

    public Kuesioner(String idKuesioner) {
        this.idKuesioner = idKuesioner;
    }

    public Kuesioner(String idKuesioner, boolean gejalaUmum, String kunjunganRS, String kunjunganLuarkota, String statusPernahdirawatCovid19) {
        this.idKuesioner = idKuesioner;
        this.gejalaUmum = gejalaUmum;
        this.kunjunganRS = kunjunganRS;
        this.kunjunganLuarkota = kunjunganLuarkota;
        this.statusPernahdirawatCovid19 = statusPernahdirawatCovid19;
    }

    public String getIdKuesioner() {
        return idKuesioner;
    }

    public void setIdKuesioner(String idKuesioner) {
        this.idKuesioner = idKuesioner;
    }

    public boolean getGejalaUmum() {
        return gejalaUmum;
    }

    public void setGejalaUmum(boolean gejalaUmum) {
        this.gejalaUmum = gejalaUmum;
    }

    public String getKunjunganRS() {
        return kunjunganRS;
    }

    public void setKunjunganRS(String kunjunganRS) {
        this.kunjunganRS = kunjunganRS;
    }

    public String getKunjunganLuarkota() {
        return kunjunganLuarkota;
    }

    public void setKunjunganLuarkota(String kunjunganLuarkota) {
        this.kunjunganLuarkota = kunjunganLuarkota;
    }

    public String getStatusPernahdirawatCovid19() {
        return statusPernahdirawatCovid19;
    }

    public void setStatusPernahdirawatCovid19(String statusPernahdirawatCovid19) {
        this.statusPernahdirawatCovid19 = statusPernahdirawatCovid19;
    }

    @XmlTransient
    public Collection<MacamGejala> getMacamGejalaCollection() {
        return macamGejalaCollection;
    }

    public void setMacamGejalaCollection(Collection<MacamGejala> macamGejalaCollection) {
        this.macamGejalaCollection = macamGejalaCollection;
    }

    public FormKepentingan getIdForm() {
        return idForm;
    }

    public void setIdForm(FormKepentingan idForm) {
        this.idForm = idForm;
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
        if (!(object instanceof Kuesioner)) {
            return false;
        }
        Kuesioner other = (Kuesioner) object;
        if ((this.idKuesioner == null && other.idKuesioner != null) || (this.idKuesioner != null && !this.idKuesioner.equals(other.idKuesioner))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uts.ivan.uts.entities.fromdatabase.Kuesioner_1[ idKuesioner=" + idKuesioner + " ]";
    }
    
}
