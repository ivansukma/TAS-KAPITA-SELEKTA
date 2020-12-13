/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tas.kelompok.tas.controllers.SistemSuhuController;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;
import tas.kelompok.tas.entities.fromdatabase.FormKepentingan;
import tas.kelompok.tas.entities.fromdatabase.Kuesioner;
import tas.kelompok.tas.services.FormKepentinganService;
import tas.kelompok.tas.services.KuesionerService;

/**
 *
 * @author USER
 */
@Controller
@RequestMapping("/kuesioner")
public class KuesionerController {

    @Autowired
    KuesionerService kuesionerService;
    FormKepentinganService formKepentinganService;

    @GetMapping("")
    public String pengguna(Model model, HttpServletRequest request) {
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        FormKepentingan formkepentingan = (FormKepentingan) inputFlashMap.get("idCoba");
        //System.out.println(formkepentingan.getIdForm());
        int id = formkepentingan.getIdForm();
        System.out.println(id);
        model.addAttribute("kuesionerForm", new Kuesioner());
        model.addAttribute("coba", id);
        return "kuesioner";
    }

    @PostMapping("save")
    public String save(Kuesioner kuesioner, HttpServletRequest request) {
        kuesionerService.save(kuesioner);
        return "index";
    }
}
