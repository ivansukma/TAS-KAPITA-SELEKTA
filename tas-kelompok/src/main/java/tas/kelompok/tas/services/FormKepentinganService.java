/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tas.kelompok.tas.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tas.kelompok.tas.entities.fromdatabase.FormKepentingan;
import tas.kelompok.tas.repositories.FormKepentinganRepository;

/**
 *
 * @author USER
 */
@Service
public class FormKepentinganService {
    @Autowired
    FormKepentinganRepository formKepentinganRepository;
    
    public List<FormKepentingan> getAll(){
        return formKepentinganRepository.findAll();
    }
    
    
    public FormKepentingan save(FormKepentingan formKepentingan) {
        return formKepentinganRepository.save(formKepentingan);
    }
    
    public List<FormKepentingan> getByAllStatus() {
        return formKepentinganRepository.findByAllStatus();
    }
    
    public List<FormKepentingan> getByStatus(String status) {
        return formKepentinganRepository.findByStatus(status);
    }
}
