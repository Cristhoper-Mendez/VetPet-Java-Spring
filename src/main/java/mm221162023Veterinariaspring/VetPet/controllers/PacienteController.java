package mm221162023Veterinariaspring.VetPet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import mm221162023Veterinariaspring.VetPet.entidades.Paciente;
import mm221162023Veterinariaspring.VetPet.servicios.ServicioPaciente;

@Controller
public class PacienteController {
    
    @Autowired
    private ServicioPaciente sPaciente;
    
    @GetMapping("/pacientes")
    public String Pacientes(Model model){
        var pacientes = sPaciente.ObtenerPacientesActivos();
        model.addAttribute("pacientes", pacientes);
        
        return "Paciente/InicioPacientes";
    }
}
