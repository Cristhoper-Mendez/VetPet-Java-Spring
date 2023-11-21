package mm221162023Veterinariaspring.VetPet.controllers;

import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import mm221162023Veterinariaspring.VetPet.entidades.Expediente;
import mm221162023Veterinariaspring.VetPet.entidades.Paciente;
import mm221162023Veterinariaspring.VetPet.entidades.Vacuna;
import mm221162023Veterinariaspring.VetPet.servicios.ServicioExpediente;
import mm221162023Veterinariaspring.VetPet.servicios.ServicioPaciente;
import mm221162023Veterinariaspring.VetPet.servicios.ServicioVacunas;
import mm221162023Veterinariaspring.VetPet.utilidades.RespuestaEstandard;

@Controller
public class ExpedienteController {
    
    @Autowired
    private ServicioExpediente sExpedientes;
    
    @Autowired
    private ServicioPaciente sPacientes;
    
    @Autowired
    private ServicioVacunas sVacunas;
    
    @GetMapping("/expedientes")
    public String Expedientes(Model model) {
        
        var expedientes = sExpedientes.ObtenerExpedienteActivas();
        model.addAttribute("expedientes", expedientes);
        
        return "Expediente/InicioExpedientes";
    }
    
    @GetMapping("/crear-expediente")
    public String CrearExpediente(Model model) {
        
        Expediente exp = new Expediente();
        model.addAttribute("expediente", exp);
        
        var pacientes = sPacientes.ObtenerPacientesActivos();
        model.addAttribute("pacientes", pacientes);
        
        var vacunas = sVacunas.ObtenerVacunasActivas();
        model.addAttribute("vacunas", vacunas);
        
        return "Expediente/CrearExpediente";
    }
    
    @PostMapping("/post-expediente")
    public String PostExpediente(Expediente xp, Model model) {
        
        xp.setActivo(true);
        xp.setFechaCita(LocalDate.now());
        sExpedientes.CrearExpediente(xp);
        
        return "redirect:expedientes";
    }
}
