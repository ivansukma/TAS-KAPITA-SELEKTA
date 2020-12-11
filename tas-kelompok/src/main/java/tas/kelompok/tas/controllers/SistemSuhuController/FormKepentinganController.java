/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tas.kelompok.tas.controllers.SistemSuhuController;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import tas.kelompok.tas.entities.fromdatabase.FormKepentingan;
import tas.kelompok.tas.entities.fromdatabase.Kuesioner;
import tas.kelompok.tas.entities.fromdatabase.Pengguna;
import tas.kelompok.tas.entities.rest.LoginOutput;
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
    ProfileService profileService;
    
    @GetMapping("")
    public String pengguna(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginOutput output = (LoginOutput) authentication.getPrincipal();
        model.addAttribute("kepentinganForm", new FormKepentingan());
        model.addAttribute("idForm", output.getUser().getId());
        return "formkepentingan";
    }
    

    @PostMapping("save")
    public RedirectView save(FormKepentingan formkepentingan, HttpServletRequest request, 
    @ModelAttribute FormKepentingan formKepentingan, 
    RedirectAttributes redirectAttributes) {
        formKepentinganService.save(formkepentingan);
        int id = formkepentingan.getIdForm();
        System.out.println(id);
        redirectAttributes.addFlashAttribute("idCoba", id);
        //model.addAttribute("idData", id);
        return new RedirectView("/kuesioner", true);
    }
    
    @GetMapping("formmasuk/{status}")
    public String formMasuk(Model model, @PathVariable String status) {
        model.addAttribute("lihatformmasuk", formKepentinganService.getByStatus(status));
        return "lihat_form";
    }
    
    @GetMapping("update/{status}/{id_form}")
    public String updateStatus(Model model, @PathVariable int id_form, @PathVariable String status) {
        formKepentinganService.updateStatus(id_form, status);
        return "redirect:/formkepentingan/formmasuk/menunggu";
    }
    
    
    @GetMapping("status")
    public String formStatus(Model model) {
        model.addAttribute("statusform", formKepentinganService.getByAllStatus());
        return "status_form";
    }
    
    @GetMapping("status/{status}")
    public String formByStatus(Model model, @PathVariable String status) {
        model.addAttribute("statusform", formKepentinganService.getByStatus(status));
        return "status_form";
    }
    @GetMapping("statusmahasiswa")
    public String formStatusMahasiswa(Model model) {
        model.addAttribute("statusform", formKepentinganService.getByAllStatus());
        return "status_mahasiswa";
    }
    
    @GetMapping("statusmahasiswa/{status}")
    public String formByStatusMahasiswa(Model model, @PathVariable String status) {
        model.addAttribute("statusform", formKepentinganService.getByStatus(status));
        return "status_mahasiswa";
    }
    
           
}
