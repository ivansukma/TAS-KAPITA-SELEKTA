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
    ProfileService profileService;
    FormKepentinganService formKepentinganService;
    
    @GetMapping("")
    public String form1(Model model){
        model.addAttribute("kepentinganForm", new FormKepentingan());
        //System.out.println(profileService.getUserId());
        return "formkepentingan";
    }
    
    @PostMapping("save")
    public String simpanform1(FormKepentingan formKepentingan){
        formKepentinganService.save(formKepentingan);
        return "redirect:/formkepentingan";
    }
    
    
    @GetMapping("kuesioner")
    public String form2(Model model){
        model.addAttribute("kuesionerForm", new Kuesioner());
        return "kuesioner";
    }
}
