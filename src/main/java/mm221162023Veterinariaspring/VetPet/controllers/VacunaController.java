package mm221162023Veterinariaspring.VetPet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import mm221162023Veterinariaspring.VetPet.entidades.Vacuna;
import mm221162023Veterinariaspring.VetPet.servicios.ServicioVacunas;
import mm221162023Veterinariaspring.VetPet.utilidades.RespuestaEstandard;
import mm221162023Veterinariaspring.VetPet.utilidades.Validador;

@Controller
public class VacunaController {

    @Autowired
    private ServicioVacunas sVacunas;

    @GetMapping("/vacunas")
    public String Vacunas(Model model) {

        var vacunas = sVacunas.ObtenerVacunasActivas();
        model.addAttribute("vacunas", vacunas);

        return "Vacunas/InicioVacunas";
    }

    @GetMapping("/crear-vacuna")
    public String CrearVacuna(Model model) {

        Vacuna v = new Vacuna();
        model.addAttribute("vacuna", v);

        return "Vacunas/CrearVacuna";
    }

    @PostMapping("/post-vacuna")
    public String PostVacuna(Vacuna v, Model model) {

        v.setActivo(true);

        if (!Validador.ValidarVacuna(v)) {
            model.addAttribute("vacuna", v);
            model.addAttribute("mensaje", "Todos los campos son requeridos.");

            return "Vacunas/CrearVacuna";
        }
        sVacunas.CrearVacunas(v);

        return "redirect:vacunas";
    }

    @PostMapping("/delete-vacuna/{idVacuna}")
    @ResponseBody
    public RespuestaEstandard DeleteVacuna(@PathVariable("idVacuna") int idVacuna, Model model) {
        sVacunas.EliminarVacunas(idVacuna);

        return new RespuestaEstandard(false, "Exitoso.");
    }

    @GetMapping("/editar-vacuna/{idVacuna}")
    public String EditarVacuna(@PathVariable("idVacuna") int idVacuna, Model model) {

        Vacuna vacuna = sVacunas.ObtenerVacunaPorId(idVacuna);
        model.addAttribute("vacuna", vacuna);

        return "Vacunas/EditarVacuna";
    }

    @PostMapping("/put-vacuna")
    public String PutVacuna(Vacuna v, Model model) {

        if (!Validador.ValidarVacuna(v)) {
            model.addAttribute("vacuna", v);
            model.addAttribute("mensaje", "Todos los campos son requeridos.");

            return "Vacunas/EditarVacuna";
        }

        sVacunas.ActualizarVacunas(v);

        return "redirect:vacunas";
    }
}
