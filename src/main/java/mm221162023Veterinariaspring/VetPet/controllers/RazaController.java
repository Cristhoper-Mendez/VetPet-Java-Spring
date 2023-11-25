package mm221162023Veterinariaspring.VetPet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import mm221162023Veterinariaspring.VetPet.entidades.Raza;
import mm221162023Veterinariaspring.VetPet.servicios.ServicioRaza;
import mm221162023Veterinariaspring.VetPet.servicios.ServicioTipoPaciente;
import mm221162023Veterinariaspring.VetPet.utilidades.RespuestaEstandard;
import mm221162023Veterinariaspring.VetPet.utilidades.Validador;

@Controller
public class RazaController {

    @Autowired
    private ServicioRaza sRaza;

    @Autowired
    private ServicioTipoPaciente sTipoPaciente;

    @GetMapping({"/razas"})
    public String Inicio(Model model) {
        var lstRazas = sRaza.ObtenerRazasActivas();

        model.addAttribute("razas", lstRazas);
        return "Raza/InicioRazas";
    }

    @GetMapping("/crear-raza")
    public String CrearRaza(Model model) {
        Raza r = new Raza();
        model.addAttribute("raza", r);

        var lstTipoPacientes = sTipoPaciente.ObtenerTipoPacientesActivos();
        model.addAttribute("tipoPacientes", lstTipoPacientes);

        return "Raza/CrearRaza";
    }

    @PostMapping("/post-raza")
    public String PostRaza(Raza ra, Model model) {

        if (!Validador.ValidarRaza(ra)) {
            model.addAttribute("mensaje", "Todos los campos son requeridos.");
            model.addAttribute("raza", ra);

            var lstTipoPacientes = sTipoPaciente.ObtenerTipoPacientesActivos();
            model.addAttribute("tipoPacientes", lstTipoPacientes);

            return "Raza/CrearRaza";
        }

        ra.setActivo(true);
        sRaza.CrearRaza(ra);

        return "redirect:razas";
    }

    @PostMapping("/delete-raza/{idRaza}")
    @ResponseBody
    public Object DeleteRaza(@PathVariable("idRaza") int idRaza, Model model) {

        sRaza.EliminarRaza(idRaza);

        return new RespuestaEstandard(false, "Eliminado correctamente.");
    }

    @GetMapping("/editar-raza/{idRaza}")
    public String EditarRaza(@PathVariable("idRaza") int idRaza, Model model) {
        Raza raza = sRaza.ObtenerRazaPorId(idRaza);
        model.addAttribute("raza", raza);

        var lstTipoPacientes = sTipoPaciente.ObtenerTipoPacientesActivos();
        model.addAttribute("tipoPacientes", lstTipoPacientes);

        return "Raza/EditarRaza";
    }

    @PostMapping("put-raza")
    public String PutRaza(Raza ra, Model model) {

        if (!Validador.ValidarRaza(ra)) {
            model.addAttribute("mensaje", "Todos los campos son requeridos.");
            model.addAttribute("raza", ra);

            var lstTipoPacientes = sTipoPaciente.ObtenerTipoPacientesActivos();
            model.addAttribute("tipoPacientes", lstTipoPacientes);

            return "Raza/CrearRaza";
        }

        sRaza.ActualizarRaza(ra);

        return "redirect:razas";
    }
}
