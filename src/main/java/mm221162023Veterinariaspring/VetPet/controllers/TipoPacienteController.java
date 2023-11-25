package mm221162023Veterinariaspring.VetPet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;

import mm221162023Veterinariaspring.VetPet.entidades.TipoPaciente;
import mm221162023Veterinariaspring.VetPet.servicios.ServicioTipoPaciente;
import mm221162023Veterinariaspring.VetPet.utilidades.RespuestaEstandard;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import mm221162023Veterinariaspring.VetPet.utilidades.Validador;

@Controller
public class TipoPacienteController {

    @Autowired
    private ServicioTipoPaciente sTipoPaciente;

    @GetMapping("/tipo-pacientes")
    public String TipoPacientes(Model model) {
        var tipoPacientes = sTipoPaciente.ObtenerTipoPacientesActivos();
        model.addAttribute("tipoPacientes", tipoPacientes);

        return "TipoPaciente/InicioTipoPaciente";
    }

    @GetMapping("/crear-tipo-paciente")
    public String CrearTipoPaciente(Model model) {
        TipoPaciente tipoPaciente = new TipoPaciente();
        model.addAttribute("tipoPaciente", tipoPaciente);

        return "TipoPaciente/CrearTipoPaciente";
    }

    @PostMapping("/post-tipo-paciente")
    public String PostTipoPaciente(TipoPaciente tp, Model model) {
        tp.setActivo(true);

        if (!Validador.ValidarTipoPaciente(tp)) {
            model.addAttribute("mensaje", "Todos los campos son requeridos.");

            model.addAttribute("tipoPaciente", tp);

            return "TipoPaciente/CrearTipoPaciente";
        }

        sTipoPaciente.CrearTipoPaciente(tp);

        return "redirect:tipo-pacientes";
    }

    @GetMapping("/editar-tipo-paciente/{idTipoPaciente}")
    public String EditarTipoPaciente(@PathVariable("idTipoPaciente") int idTipoPaciente, Model model) {
        TipoPaciente tp = sTipoPaciente.ObtenerTipoPacientePorId(idTipoPaciente);
        model.addAttribute("tipoPaciente", tp);

        return "TipoPaciente/EditarTipoPaciente";
    }

    @PostMapping("/put-tipo-paciente")
    public String PutTipoPaciente(TipoPaciente tp, Model model) {

        if (!Validador.ValidarTipoPaciente(tp)) {
            model.addAttribute("mensaje", "Todos los campos son requeridos.");

            model.addAttribute("tipoPaciente", tp);

            return "TipoPaciente/EditarTipoPaciente";
        }

        sTipoPaciente.ActualizarTipoPaciente(tp);

        return "redirect:tipo-pacientes";
    }

    @PostMapping("/delete-tipo-paciente/{idTipoPaciente}")
    @ResponseBody()
    public RespuestaEstandard DeleteTipoPaciente(@PathVariable("idTipoPaciente") int idTipoPaciente, Model model) {
        sTipoPaciente.EliminarTipoPaciente(idTipoPaciente);

        RespuestaEstandard res = new RespuestaEstandard(false, "Eliminado correctamente.");

        return res;
    }
}
