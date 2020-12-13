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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "kuesioner")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kuesioner.findAll", query = "SELECT k FROM Kuesioner k")
    , @NamedQuery(name = "Kuesioner.findById", query = "SELECT k FROM Kuesioner k WHERE k.id = :id")
    , @NamedQuery(name = "Kuesioner.findByGejalaUmum", query = "SELECT k FROM Kuesioner k WHERE k.gejalaUmum = :gejalaUmum")
    , @NamedQuery(name = "Kuesioner.findByKunjunganRS", query = "SELECT k FROM Kuesioner k WHERE k.kunjunganRS = :kunjunganRS")
    , @NamedQuery(name = "Kuesioner.findByKunjunganLuarkota", query = "SELECT k FROM Kuesioner k WHERE k.kunjunganLuarkota = :kunjunganLuarkota")
    , @NamedQuery(name = "Kuesioner.findByStatusPernahdirawatCovid19", query = "SELECT k FROM Kuesioner k WHERE k.statusPernahdirawatCovid19 = :statusPernahdirawatCovid19")})
public class Kuesioner implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "gejala_umum")
    private String gejalaUmum;
    @Basic(optional = false)
    @Column(name = "kunjungan_RS")
    private String kunjunganRS;
    @Basic(optional = false)
    @Column(name = "kunjungan_luarkota")
    private String kunjunganLuarkota;
    @Basic(optional = false)
    @Column(name = "status_pernahdirawat_covid19")
    private String statusPernahdirawatCovid19;
    @JoinColumn(name = "id_form", referencedColumnName = "id_form")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private FormKepentingan idForm;

    public Kuesioner() {
    }

    public Kuesioner(Integer id) {
        this.id = id;
    }

    public Kuesioner(Integer id, String kunjunganRS, String kunjunganLuarkota, String statusPernahdirawatCovid19) {
        this.id = id;
        this.kunjunganRS = kunjunganRS;
        this.kunjunganLuarkota = kunjunganLuarkota;
        this.statusPernahdirawatCovid19 = statusPernahdirawatCovid19;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGejalaUmum() {
        return gejalaUmum;
    }

    public void setGejalaUmum(String gejalaUmum) {
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

    public FormKepentingan getIdForm() {
        return idForm;
    }

    public void setIdForm(FormKepentingan idForm) {
        this.idForm = idForm;
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
        if (!(object instanceof Kuesioner)) {
            return false;
        }
        Kuesioner other = (Kuesioner) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tas.kelompok.tas.entities.fromdatabase.Kuesioner[ id=" + id + " ]";
    }
    
}
