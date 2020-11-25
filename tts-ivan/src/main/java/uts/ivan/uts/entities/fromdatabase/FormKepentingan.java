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
import javax.persistence.Lob;
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
@Table(name = "form_kepentingan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormKepentingan_1.findAll", query = "SELECT f FROM FormKepentingan_1 f")
    , @NamedQuery(name = "FormKepentingan_1.findByIdForm", query = "SELECT f FROM FormKepentingan_1 f WHERE f.idForm = :idForm")
    , @NamedQuery(name = "FormKepentingan_1.findByRiwayatPenyakit", query = "SELECT f FROM FormKepentingan_1 f WHERE f.riwayatPenyakit = :riwayatPenyakit")
    , @NamedQuery(name = "FormKepentingan_1.findByFakultasKunjungan", query = "SELECT f FROM FormKepentingan_1 f WHERE f.fakultasKunjungan = :fakultasKunjungan")
    , @NamedQuery(name = "FormKepentingan_1.findByStatus", query = "SELECT f FROM FormKepentingan_1 f WHERE f.status = :status")})
public class FormKepentingan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_form")
    private String idForm;
    @Basic(optional = false)
    @Lob
    @Column(name = "kepentingan")
    private String kepentingan;
    @Basic(optional = false)
    @Column(name = "riwayat_penyakit")
    private String riwayatPenyakit;
    @Basic(optional = false)
    @Column(name = "fakultas_kunjungan")
    private String fakultasKunjungan;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "id_admin", referencedColumnName = "ID_Pengguna")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pengguna idAdmin;
    @JoinColumn(name = "id_mahasiswa", referencedColumnName = "ID_Pengguna")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pengguna idMahasiswa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idForm", fetch = FetchType.LAZY)
    private Collection<DataTemperatur> dataTemperaturCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idForm", fetch = FetchType.LAZY)
    private Collection<Kuesioner> kuesionerCollection;

    public FormKepentingan() {
    }

    public FormKepentingan(String idForm) {
        this.idForm = idForm;
    }

    public FormKepentingan(String idForm, String kepentingan, String riwayatPenyakit, String fakultasKunjungan, String status) {
        this.idForm = idForm;
        this.kepentingan = kepentingan;
        this.riwayatPenyakit = riwayatPenyakit;
        this.fakultasKunjungan = fakultasKunjungan;
        this.status = status;
    }

    public String getIdForm() {
        return idForm;
    }

    public void setIdForm(String idForm) {
        this.idForm = idForm;
    }

    public String getKepentingan() {
        return kepentingan;
    }

    public void setKepentingan(String kepentingan) {
        this.kepentingan = kepentingan;
    }

    public String getRiwayatPenyakit() {
        return riwayatPenyakit;
    }

    public void setRiwayatPenyakit(String riwayatPenyakit) {
        this.riwayatPenyakit = riwayatPenyakit;
    }

    public String getFakultasKunjungan() {
        return fakultasKunjungan;
    }

    public void setFakultasKunjungan(String fakultasKunjungan) {
        this.fakultasKunjungan = fakultasKunjungan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Pengguna getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Pengguna idAdmin) {
        this.idAdmin = idAdmin;
    }

    public Pengguna getIdMahasiswa() {
        return idMahasiswa;
    }

    public void setIdMahasiswa(Pengguna idMahasiswa) {
        this.idMahasiswa = idMahasiswa;
    }

    @XmlTransient
    public Collection<DataTemperatur> getDataTemperaturCollection() {
        return dataTemperaturCollection;
    }

    public void setDataTemperaturCollection(Collection<DataTemperatur> dataTemperaturCollection) {
        this.dataTemperaturCollection = dataTemperaturCollection;
    }

    @XmlTransient
    public Collection<Kuesioner> getKuesionerCollection() {
        return kuesionerCollection;
    }

    public void setKuesionerCollection(Collection<Kuesioner> kuesionerCollection) {
        this.kuesionerCollection = kuesionerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idForm != null ? idForm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormKepentingan)) {
            return false;
        }
        FormKepentingan other = (FormKepentingan) object;
        if ((this.idForm == null && other.idForm != null) || (this.idForm != null && !this.idForm.equals(other.idForm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "uts.ivan.uts.entities.fromdatabase.FormKepentingan_1[ idForm=" + idForm + " ]";
    }
    
}
