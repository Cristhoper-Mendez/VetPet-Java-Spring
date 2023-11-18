package mm221162023Veterinariaspring.VetPet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import java.time.LocalDate;

import mm221162023Veterinariaspring.VetPet.entidades.Paciente;
import mm221162023Veterinariaspring.VetPet.entidades.Raza;
import mm221162023Veterinariaspring.VetPet.servicios.ServicioPaciente;
import mm221162023Veterinariaspring.VetPet.utilidades.RespuestaEstandard;
import mm221162023Veterinariaspring.VetPet.servicios.ServicioRaza;
import mm221162023Veterinariaspring.VetPet.servicios.ServicioTipoPaciente;

@Controller
public class PacienteController {

    @Autowired
    private ServicioPaciente sPaciente;

    @Autowired
    private ServicioRaza sRaza;

    @Autowired
    private ServicioTipoPaciente sTipoPaciente;

    @GetMapping("/pacientes")
    public String Pacientes(Model model) {
        var pacientes = sPaciente.ObtenerPacientesActivos();
        model.addAttribute("pacientes", pacientes);

        return "Paciente/InicioPacientes";
    }

    @GetMapping("/crear-paciente")
    public String CrearPaciente(Model model) {
        Paciente p = new Paciente();
        p.setFechaInscripcion(LocalDate.now());
        model.addAttribute("paciente", p);

        var razas = sRaza.ObtenerRazasActivas();
        model.addAttribute("razas", razas);

        var tipos = sTipoPaciente.ObtenerTipoPacientesActivos();
        model.addAttribute("tipoPacientes", tipos);

        return "Paciente/CrearPaciente";
    }

    @PostMapping("/post-paciente")
    public String PostPaciente(Paciente p, Model model) {

        Raza r = sRaza.ObtenerRazaPorId(p.getRazaId());

        p.setTipoPaciente(r.getTipoPaciente());
        p.setActivo(true);
        p.setFechaInscripcion(LocalDate.now());

        sPaciente.CrearPaciente(p);

        return "redirect:pacientes";
    }

    @PostMapping("/delete-paciente/{idPaciente}")
    @ResponseBody()
    public RespuestaEstandard DeletePaciente(@PathVariable("idPaciente") int idPaciente, Model model) {

        sPaciente.EliminarPaciente(idPaciente);
        RespuestaEstandard res = new RespuestaEstandard(false, "Exitoso.");

        return res;
    }

    @GetMapping("/editar-paciente/{idPaciente}")
    public String EditarPaciente(@PathVariable("idPaciente") int idPaciente, Model model) {

        Paciente p = sPaciente.ObtenerPacientePorId(idPaciente);
        model.addAttribute("paciente", p);

        var razas = sRaza.ObtenerRazasActivas();
        model.addAttribute("razas", razas);

        return "Paciente/EditarPaciente";
    }

    @PostMapping("/put-paciente")
    public String PutPaciente(Paciente p, Model model) {

        Raza r = sRaza.ObtenerRazaPorId(p.getRazaId());
        p.setTipoPaciente(r.getTipoPaciente());

        sPaciente.ActualizarPaciente(p);

        return "redirect:pacientes";
    }
}
