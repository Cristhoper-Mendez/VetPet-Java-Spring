package mm221162023Veterinariaspring.VetPet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;

import mm221162023Veterinariaspring.VetPet.entidades.TipoPaciente;
import mm221162023Veterinariaspring.VetPet.servicios.ServicioTipoPaciente;
import mm221162023Veterinariaspring.VetPet.utilidades.RespuestaEstandard;

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
    
    @GetMapping("/crear-tipo-paciente")
    public String CrearTipoPaciente(Model model){
        TipoPaciente tipoPaciente = new TipoPaciente();
        model.addAttribute("tipoPaciente", tipoPaciente);
        
        return "TipoPaciente/CrearTipoPaciente";
    }

    @PostMapping("/post-tipo-paciente")
    public String PostTipoPaciente(TipoPaciente tp, Model model){
        tp.setActivo(true);
        
        sTipoPaciente.CrearTipoPaciente(tp);
        
        return "redirect:tipo-pacientes";
    }
}
