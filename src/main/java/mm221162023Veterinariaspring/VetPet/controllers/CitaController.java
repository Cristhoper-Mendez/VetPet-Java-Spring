package mm221162023Veterinariaspring.VetPet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import mm221162023Veterinariaspring.VetPet.entidades.Cita;
import mm221162023Veterinariaspring.VetPet.entidades.Paciente;
import mm221162023Veterinariaspring.VetPet.servicios.ServicioCita;
import mm221162023Veterinariaspring.VetPet.servicios.ServicioPaciente;
import mm221162023Veterinariaspring.VetPet.utilidades.RespuestaEstandard;

@Controller
public class CitaController {

    @Autowired
    private ServicioCita sCita;
    // Revisar entidad paciente medidas se refiere a altura y peso.

    @Autowired
    private ServicioPaciente sPaciente;

    @GetMapping({"/citas", "/"})
    public String InicioCitas(Model model) {

        var citas = sCita.ObtenerCitasActivas();
        model.addAttribute("citas", citas);

        return "Citas/InicioCitas";
    }

    @GetMapping("/crear-cita")
    public String CrearCita(Model model) {

        Cita c = new Cita();
        model.addAttribute("cita", c);

        var pacientes = sPaciente.ObtenerPacientesActivos();
        model.addAttribute("pacientes", pacientes);

        return "Citas/CrearCita";
    }

    @PostMapping("/post-cita")
    public String PostCita(Cita c, Model model) {

        Paciente p = sPaciente.ObtenerPacientePorId(c.getIdPaciente());
        c.setNombrePaciente(p.getNombrePaciente());

        c.setActivo(true);

        if (sCita.ValidarLimiteCitas(c)) {
            var pacientes = sPaciente.ObtenerPacientesActivos();
            model.addAttribute("pacientes", pacientes);

            model.addAttribute("mensaje", "Limite de citas para este dia alcanzado.");

            return "Citas/CrearCita";
        }

        sCita.CrearCita(c);

        return "redirect:citas";
    }

    @PostMapping("/delete-cita/{idCita}")
    @ResponseBody
    public RespuestaEstandard DeleteCita(@PathVariable("idCita") int idCita, Model model) {
        sCita.EliminarCita(idCita);

        return new RespuestaEstandard(false, "exitoso.");
    }

    @GetMapping("/editar-cita/{idCita}")
    public String EditarCita(@PathVariable("idCita") int idCita, Model model) {

        Cita cita = sCita.ObtenerCitaPorIdCita(idCita);
        model.addAttribute("cita", cita);

        var pacientes = sPaciente.ObtenerPacientesActivos();
        model.addAttribute("pacientes", pacientes);

        return "Citas/EditarCita";
    }

    @PostMapping("/put-cita")
    public String PutCita(Cita c, Model model) {

        Paciente p = sPaciente.ObtenerPacientePorId(c.getIdPaciente());
        c.setNombrePaciente(p.getNombrePaciente());

        if (sCita.ValidarLimiteCitas(c)) {
            var pacientes = sPaciente.ObtenerPacientesActivos();
            model.addAttribute("pacientes", pacientes);

            model.addAttribute("mensaje", "Limite de citas para este dia alcanzado.");

            return "Citas/EditarCita";
        }

        sCita.ActualizarCita(c);

        return "redirect:citas";
    }
}
