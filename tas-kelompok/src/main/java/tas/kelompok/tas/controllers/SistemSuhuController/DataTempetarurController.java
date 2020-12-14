/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tas.kelompok.tas.controllers.SistemSuhuController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tas.kelompok.tas.entities.fromdatabase.DataTemperatur;
import tas.kelompok.tas.entities.fromdatabase.FormKepentingan;
import tas.kelompok.tas.services.DataTemperaturService;

/**
 *
 * @author USER
 */
@Controller
@RequestMapping("lihatdata")

public class DataTempetarurController {

    @Autowired
    DataTemperaturService dataTemperaturService;

    @GetMapping("")
    public String dataSuhu(Model model) {
        model.addAttribute("lihatDataTabel", dataTemperaturService.getAll());
        return "lihat_data";
    }

    @GetMapping("suhumahasiswa/{id_mahasiswa}")
    public String dataSuhuMahasiswa(Model model) {
        model.addAttribute("lihatDataTabel", dataTemperaturService.getAll());
        return "lihat_suhu_mahasiswa";
    }

}
