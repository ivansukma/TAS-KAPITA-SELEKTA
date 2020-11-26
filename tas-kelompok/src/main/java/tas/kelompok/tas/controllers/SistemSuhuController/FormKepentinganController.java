/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tas.kelompok.tas.controllers.SistemSuhuController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tas.kelompok.tas.entities.fromdatabase.FormKepentingan;
import tas.kelompok.tas.entities.fromdatabase.Kuesioner;

/**
 *
 * @author USER
 */
@Controller
@RequestMapping("formkepentingan")
public class FormKepentinganController {
    
    @GetMapping("")
    public String form1(Model model){
        model.addAttribute("kepentinganForm", new FormKepentingan());
        return "formkepentingan";
    }
    
    @PostMapping("save")
    public String simpanform1(){
        return "redirect:/formkepentingan/kuesioner";
    }
    
    
    @GetMapping("kuesioner")
    public String form2(Model model){
        model.addAttribute("kuesionerForm", new Kuesioner());
        return "kuesioner";
    }
}
