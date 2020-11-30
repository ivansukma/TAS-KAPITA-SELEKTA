/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tas.kelompok.tas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tas.kelompok.tas.entities.fromdatabase.Kuesioner;
import tas.kelompok.tas.repositories.KuesionerRepository;

/**
 *
 * @author USER
 */
@Service
public class KuesionerService {
    @Autowired
    KuesionerRepository kuesionerRepository;
    
    public Kuesioner save(Kuesioner kuesioner) {
        return kuesionerRepository.save(kuesioner);
    }
}
