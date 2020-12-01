/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tas.kelompok.tas.entities.fromdatabase;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author USER
 */
@Entity
@Table(name = "form_kepentingan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormKepentingan.findAll", query = "SELECT f FROM FormKepentingan f")
    , @NamedQuery(name = "FormKepentingan.findByIdForm", query = "SELECT f FROM FormKepentingan f WHERE f.idForm = :idForm")
    , @NamedQuery(name = "FormKepentingan.findByRiwayatPenyakit", query = "SELECT f FROM FormKepentingan f WHERE f.riwayatPenyakit = :riwayatPenyakit")
    , @NamedQuery(name = "FormKepentingan.findByFakultasKunjungan", query = "SELECT f FROM FormKepentingan f WHERE f.fakultasKunjungan = :fakultasKunjungan")
    , @NamedQuery(name = "FormKepentingan.findByStatus", query = "SELECT f FROM FormKepentingan f WHERE f.status = :status")})
public class FormKepentingan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_form")
    private Integer idForm;
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
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "id_admin", referencedColumnName = "ID_Pengguna")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pengguna idAdmin;
    @JoinColumn(name = "id_mahasiswa", referencedColumnName = "ID_Pengguna")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pengguna idMahasiswa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idForm", fetch = FetchType.LAZY)
    private List<DataTemperatur> dataTemperaturList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idForm", fetch = FetchType.LAZY)
    private List<Kuesioner> kuesionerList;

    public FormKepentingan() {
    }

    public FormKepentingan(Integer idForm) {
        this.idForm = idForm;
    }

    public FormKepentingan(Integer idForm, String kepentingan, String riwayatPenyakit, String fakultasKunjungan) {
        this.idForm = idForm;
        this.kepentingan = kepentingan;
        this.riwayatPenyakit = riwayatPenyakit;
        this.fakultasKunjungan = fakultasKunjungan;
    }

    public Integer getIdForm() {
        return idForm;
    }

    public void setIdForm(Integer idForm) {
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
    public List<DataTemperatur> getDataTemperaturList() {
        return dataTemperaturList;
    }

    public void setDataTemperaturList(List<DataTemperatur> dataTemperaturList) {
        this.dataTemperaturList = dataTemperaturList;
    }

    @XmlTransient
    public List<Kuesioner> getKuesionerList() {
        return kuesionerList;
    }

    public void setKuesionerList(List<Kuesioner> kuesionerList) {
        this.kuesionerList = kuesionerList;
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
        return "tas.kelompok.tas.entities.fromdatabase.FormKepentingan[ idForm=" + idForm + " ]";
    }
    
}
