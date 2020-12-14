/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tas.kelompok.tas.controllers.SistemSuhuController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tas.kelompok.tas.entities.fromdatabase.DataTemperatur;
import tas.kelompok.tas.entities.fromdatabase.FormKepentingan;
import tas.kelompok.tas.entities.rest.LoginOutput;
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
    public String dataSuhuMahasiswa(Model model, @PathVariable String id_mahasiswa) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginOutput output = (LoginOutput) authentication.getPrincipal();
        model.addAttribute("lihatDataTabel", dataTemperaturService.getforUser(id_mahasiswa));
        model.addAttribute("idForm", output.getUser().getId());
        return "lihat_suhu_mahasiswa";
    }

}
