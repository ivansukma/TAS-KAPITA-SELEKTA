/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tas.kelompok.tas.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tas.kelompok.tas.entities.fromdatabase.Pengguna;
import tas.kelompok.tas.entities.rest.LoginOutput;
import tas.kelompok.tas.entities.rest.ProfileInfo;
import tas.kelompok.tas.entities.rest.ProfileAddress;
import tas.kelompok.tas.entities.rest.ProfileContact;
import tas.kelompok.tas.entities.rest.ProfileEducation;
import tas.kelompok.tas.entities.rest.ProfileOccupation;
import tas.kelompok.tas.repositories.PenggunaRepository;

/**
 *
 * @author ivanr
 */
@Service
public class ProfileService {

    @Autowired
    RestTemplate restTemplate;

    @Value("${api.uri}")
    private String uri;

    public ProfileInfo getProfileInfo(String id) {
        ProfileInfo result;
        Map<String, String> param = new HashMap<>();

        param.put("id", id);

        result = restTemplate.getForObject(uri + "profile/basic/{id}" /*+ getUserId()*/, ProfileInfo.class, param);
        return result;
    }

    public Pengguna listLogin(String id) {

        Pengguna pengguna = new Pengguna();

        ProfileInfo resultBasic;
        Map<String, String> paramBasic = new HashMap<>();
        paramBasic.put("id", id);
        resultBasic = restTemplate.getForObject(uri + "profile/basic/{id}" /*+ getUserId()*/, ProfileInfo.class, paramBasic);
        pengguna.setIDPengguna(resultBasic.getId());
        //pengguna.setUsername(resultBasic.getEmail());
        //pengguna.setPassword("test");
        pengguna.setNama(resultBasic.getName());

        ProfileContact resultContact;
        Map<String, String> paramContact = new HashMap<>();
        paramContact.put("id", id);
        resultContact = restTemplate.getForObject(uri + "profile/contact/{id}" /*+ getUserId()*/, ProfileContact.class, paramContact);
        pengguna.setTelefon(resultContact.getPhone());

        //pengguna.setStatusDaftarulang(true);
        Date date = new Date();
        //pengguna.setTanggalBolehDaftarulang(date);
        
        return pengguna;
    }

    public ProfileAddress getProfileAddress(String id) {
        ProfileAddress result;
        Map<String, String> param = new HashMap<>();

        param.put("id", id);

        result = restTemplate.getForObject(uri + "profile/address/{id}" /*+ getUserId()*/, ProfileAddress.class, param);
        return result;
    }

    public ProfileContact getProfileContact(String id) {
        ProfileContact result;
        Map<String, String> param = new HashMap<>();

        param.put("id", id);

        result = restTemplate.getForObject(uri + "profile/contact/{id}" /*+ getUserId()*/, ProfileContact.class, param);
        return result;
    }

    public ProfileOccupation getProfileOccupation(String id) {
        ProfileOccupation result;
        Map<String, String> param = new HashMap<>();

        param.put("id", id);

        result = restTemplate.getForObject(uri + "profile/currentoccupation/{id}" /*+ getUserId()*/, ProfileOccupation.class, param);
        return result;
    }

    public ProfileEducation getProfileEducation(String id) {
        ProfileEducation result;
        Map<String, String> param = new HashMap<>();

        param.put("id", id);

        result = restTemplate.getForObject(uri + "profile/education/{id}" /*+ getUserId()*/, ProfileEducation.class, param);
        return result;
    }
    //=================Get ID FOR SPRING SECURITY====================     
/*
    public String getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginOutput output = (LoginOutput) authentication.getPrincipal();
        return output.getUser().getId();
    }
*/
    //=============================PER SAVE AN DUNIAWI========================================

    public boolean updateProfileBasic(ProfileInfo input) {
        boolean result = true;
        try {
            restTemplate.postForObject(uri + "profile/basic/", input, ProfileInfo.class);
        } catch (Exception e) {
            result = false;
        }

        return result;
    }

    public boolean updateProfileAddress(ProfileAddress input) {
        boolean result = true;
        try {
            restTemplate.postForObject(uri + "profile/address/", input, ProfileAddress.class);
        } catch (Exception e) {
            result = false;
        }

        return result;
    }

    public boolean updateProfileContact(ProfileContact input) {
        boolean result = true;
        try {
            restTemplate.postForObject(uri + "profile/contact/", input, ProfileContact.class);
        } catch (Exception e) {
            result = false;
        }

        return result;
    }

    public boolean updateProfileOccupation(ProfileOccupation input) {
        boolean result = true;
        try {
            restTemplate.postForObject(uri + "profile/currentoccupation/", input, ProfileOccupation.class);
        } catch (Exception e) {
            result = false;
        }

        return result;
    }

    public boolean updateProfileEducation(ProfileEducation input) {
        boolean result = true;
        try {
            restTemplate.postForObject(uri + "profile/education/", input, ProfileEducation.class);
        } catch (Exception e) {
            result = false;
        }

        return result;
    }

}
