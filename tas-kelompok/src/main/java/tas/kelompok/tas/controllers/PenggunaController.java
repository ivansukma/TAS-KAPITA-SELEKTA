/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tas.kelompok.tas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tas.kelompok.tas.entities.fromdatabase.Pengguna;
import tas.kelompok.tas.services.PenggunaService;

/**
 *
 * @author USER
 */
@Controller
@RequestMapping("pengguna")
public class PenggunaController {

    @Autowired
    PenggunaService penggunaService;

    @GetMapping("")
    public String pengguna(Model model) {
        model.addAttribute("penggunaForm", new Pengguna());
        return "pengguna";
    }
    
    @PostMapping("save")
    public String save(Pengguna pengguna){
        penggunaService.save(pengguna);
        return "redirect:/pengguna";
    }
    
}
