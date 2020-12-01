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
import tas.kelompok.tas.entities.fromdatabase.FormKepentingan;
import tas.kelompok.tas.entities.fromdatabase.Kuesioner;
import tas.kelompok.tas.services.FormKepentinganService;
import tas.kelompok.tas.services.ProfileService;

/**
 *
 * @author USER
 */
@Controller
@RequestMapping("formkepentingan")
public class FormKepentinganController {

    @Autowired
    FormKepentinganService formKepentinganService;

    @GetMapping("")
    public String pengguna(Model model) {
        model.addAttribute("kepentinganForm", new FormKepentingan());
        return "formkepentingan";
    }

    @PostMapping("save")
    public String save(FormKepentingan formkepentingan) {
        formKepentinganService.save(formkepentingan);
        return "redirect:/kuesioner";
    }
    
    @GetMapping("lihatdata")
    public String lihatData(Model model) {
        //model.addAttribute("kepentinganForm", new FormKepentingan());
        return "lihat_data";
    }
    
}
