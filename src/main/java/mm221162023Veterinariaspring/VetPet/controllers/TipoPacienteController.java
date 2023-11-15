package mm221162023Veterinariaspring.VetPet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;

import mm221162023Veterinariaspring.VetPet.entidades.TipoPaciente;
import mm221162023Veterinariaspring.VetPet.servicios.ServicioTipoPaciente;
import mm221162023Veterinariaspring.VetPet.entidades.RespuestaEstandard;

@Controller
public class TipoPacienteController {

    @Autowired
    private ServicioTipoPaciente sTipoPaciente;

    @GetMapping("/tipo-pacientes")
    public String TipoPacientes(Model model)
    {
        var tipoPacientes = sTipoPaciente.ObtenerTipoPacientesActivos();
        model.addAttribute("tipoPacientes", tipoPacientes);
        
        return "TipoPaciente/InicioTipoPaciente";
    }

}
