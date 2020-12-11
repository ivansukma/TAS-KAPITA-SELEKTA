/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tas.kelompok.tas.repositories;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;
import tas.kelompok.tas.entities.fromdatabase.FormKepentingan;

/**
 *
 * @author USER
 */
public interface FormKepentinganRepository extends JpaRepository<FormKepentingan, Integer> {
    @Query(value = "SELECT * FROM form_kepentingan WHERE status ='diterima' OR status='ditolak'", nativeQuery = true)
    List<FormKepentingan> findByAllStatus();
    
    @Query(value = "SELECT * FROM form_kepentingan WHERE status = :status", nativeQuery = true)
    List<FormKepentingan> findByStatus(@Param("status") String status);
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE form_kepentingan SET status = 'diterima' WHERE id_form = :id_form", nativeQuery = true)
    void updateByStatus(@Param(value = "id_form") int id_form);
}
