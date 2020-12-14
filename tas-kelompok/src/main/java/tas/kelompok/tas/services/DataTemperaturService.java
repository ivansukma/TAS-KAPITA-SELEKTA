/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tas.kelompok.tas.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tas.kelompok.tas.entities.fromdatabase.DataTemperatur;
import tas.kelompok.tas.repositories.DataTemperaturRepository;

/**
 *
 * @author USER
 */
@Service
public class DataTemperaturService {
    
    @Autowired
    DataTemperaturRepository dataTemperaturRepository;
    
    public List<DataTemperatur> getAll(){
        return dataTemperaturRepository.findAll();
    }
    
    public DataTemperatur save(DataTemperatur dataTemperatur) {
        return dataTemperaturRepository.save(dataTemperatur);
    }
    
    public List<DataTemperatur> getforUser(String id){
        return dataTemperaturRepository.findForStudent(id);
    }
    
    
}
