/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tas.kelompok.tas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tas.kelompok.tas.entities.fromdatabase.Kuesioner;

/**
 *
 * @author USER
 */
public interface KuesionerRepository extends JpaRepository<Kuesioner, Integer>{
    
}
