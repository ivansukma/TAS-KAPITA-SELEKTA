/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tas.kelompok.tas.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tas.kelompok.tas.entities.fromdatabase.DataTemperatur;
import tas.kelompok.tas.entities.fromdatabase.FormKepentingan;

/**
 *
 * @author USER
 */
public interface DataTemperaturRepository extends JpaRepository<DataTemperatur, Integer> {
    @Query(value = "SELECT * FROM data_temperatur WHERE id = :id", nativeQuery = true)
    List<DataTemperatur> findForStudent(@Param("id") String id);
}
