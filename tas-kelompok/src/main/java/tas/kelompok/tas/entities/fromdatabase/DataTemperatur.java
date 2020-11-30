/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tas.kelompok.tas.entities.fromdatabase;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "data_temperatur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DataTemperatur.findAll", query = "SELECT d FROM DataTemperatur d")
    , @NamedQuery(name = "DataTemperatur.findById", query = "SELECT d FROM DataTemperatur d WHERE d.id = :id")
    , @NamedQuery(name = "DataTemperatur.findByTanggalPeriksa", query = "SELECT d FROM DataTemperatur d WHERE d.tanggalPeriksa = :tanggalPeriksa")
    , @NamedQuery(name = "DataTemperatur.findBySuhuTubuh", query = "SELECT d FROM DataTemperatur d WHERE d.suhuTubuh = :suhuTubuh")
    , @NamedQuery(name = "DataTemperatur.findByKonfirmasiSuhu", query = "SELECT d FROM DataTemperatur d WHERE d.konfirmasiSuhu = :konfirmasiSuhu")})
public class DataTemperatur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "tanggal_periksa")
    @Temporal(TemporalType.DATE)
    private Date tanggalPeriksa;
    @Basic(optional = false)
    @Column(name = "suhu_tubuh")
    private double suhuTubuh;
    @Basic(optional = false)
    @Column(name = "konfirmasi_suhu")
    private boolean konfirmasiSuhu;
    @JoinColumn(name = "id_form", referencedColumnName = "id_form")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private FormKepentingan idForm;

    public DataTemperatur() {
    }

    public DataTemperatur(Integer id) {
        this.id = id;
    }

    public DataTemperatur(Integer id, Date tanggalPeriksa, double suhuTubuh, boolean konfirmasiSuhu) {
        this.id = id;
        this.tanggalPeriksa = tanggalPeriksa;
        this.suhuTubuh = suhuTubuh;
        this.konfirmasiSuhu = konfirmasiSuhu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTanggalPeriksa() {
        return tanggalPeriksa;
    }

    public void setTanggalPeriksa(Date tanggalPeriksa) {
        this.tanggalPeriksa = tanggalPeriksa;
    }

    public double getSuhuTubuh() {
        return suhuTubuh;
    }

    public void setSuhuTubuh(double suhuTubuh) {
        this.suhuTubuh = suhuTubuh;
    }

    public boolean getKonfirmasiSuhu() {
        return konfirmasiSuhu;
    }

    public void setKonfirmasiSuhu(boolean konfirmasiSuhu) {
        this.konfirmasiSuhu = konfirmasiSuhu;
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
        if (!(object instanceof DataTemperatur)) {
            return false;
        }
        DataTemperatur other = (DataTemperatur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tas.kelompok.tas.entities.fromdatabase.DataTemperatur[ id=" + id + " ]";
    }
    
}
