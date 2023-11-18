package mm221162023Veterinariaspring.VetPet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import mm221162023Veterinariaspring.VetPet.entidades.Cita;
import mm221162023Veterinariaspring.VetPet.servicios.ServicioCita;
import mm221162023Veterinariaspring.VetPet.servicios.ServicioPaciente;
import mm221162023Veterinariaspring.VetPet.utilidades.RespuestaEstandard;

@Controller
public class CitaController {
    
    @Autowired
    private ServicioCita sCita;
    
    @GetMapping("/citas")
    public String InicioCitas(Model model) {
        
        var citas = sCita.ObtenerCitasActivas();
        model.addAttribute("citas", citas);
        
        return "Citas/InicioCitas";
    }
}
