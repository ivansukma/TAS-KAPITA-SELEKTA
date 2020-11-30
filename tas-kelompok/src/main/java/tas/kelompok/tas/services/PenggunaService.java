/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tas.kelompok.tas.services;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tas.kelompok.tas.entities.fromdatabase.Pengguna;
import tas.kelompok.tas.repositories.PenggunaRepository;
import tas.kelompok.tas.entities.rest.LoginOutput;

/**
 *
 * @author USER
 */
@Service
public class PenggunaService {

    @Autowired
    PenggunaRepository penggunaRepository;
    ProfileService profileService;
    LoginRestService loginService;

    public Pengguna save() {
        //String id = loginService.getLoginId(output);
        Pengguna pengguna = new Pengguna();
        //pengguna = profileService.listLogin(id);
        pengguna.setIDPengguna("USER-00034");
        //pengguna.setUsername("Matthew");
        pengguna.setNama("Matthew");
        pengguna.setTelefon("012345");
        pengguna.setStatusDaftarulang(true);
        Date date = new Date();
        pengguna.setTanggalBolehDaftarulang(date);
        return penggunaRepository.save(pengguna);
    }
}
