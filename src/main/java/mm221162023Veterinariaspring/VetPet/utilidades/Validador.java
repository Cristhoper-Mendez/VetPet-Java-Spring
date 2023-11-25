package mm221162023Veterinariaspring.VetPet.utilidades;

import java.time.LocalDate;
import mm221162023Veterinariaspring.VetPet.entidades.*;

public class Validador {

    public static boolean ValidarRaza(Raza r) {
        boolean result = true;

        if (r.getNombreRaza() == null || r.getNombreRaza().isEmpty()) {
            result = false;
        }

        if (r.getTipoPaciente() == 0) {
            result = false;
        }

        return result;
    }

    public static boolean ValidarCita(Cita c) {
        boolean result = true;

        if (c.getFechaCita() == null) {
            result = false;
        }

        if (c.getIdPaciente() == 0) {
            result = false;
        }

        if (c.getMotivo() == null || c.getMotivo().isEmpty()) {
            result = false;
        }

        return result;
    }

    public static boolean ValidarExpediente(Expediente ex) {
        boolean result = true;

        if (ex.getFechaCita() == null) {
            result = false;
        }

        if (ex.getIdVacuna() == 0) {
            result = false;
        }

        if (ex.getIdPaciente() == 0) {
            result = false;
        }

        if (ex.getInformacionAdicional().isEmpty()) {
            result = false;
        }

        if (ex.getMedicamentoRecetado().isEmpty()) {
            result = false;
        }

        return result;
    }

    public static boolean ValidarPaciente(Paciente p) {
        return validarCampoNoNulo(p.getNombrePaciente())
                && validarCampoNoNulo(p.getNombreDueno())
                && validarCampoPositivo(p.getEdadPaciente())
                && validarCampoPositivo(p.getRazaId())
                && validarCampoNoNulo(p.getMedidas())
                && validarCampoPositivo(p.getNumeroIdentificacion())
                && validarCampoNoNulo(p.getPelajePaciente())
                && validarCampoNotNull(p.getFechaNacimiento());
    }

    public static boolean ValidarTipoPaciente(TipoPaciente tp) {
        return validarCampoNoNulo(tp.getNombreTipoPaciente());
    }

    public static boolean ValidarVacuna(Vacuna v) {
        return validarCampoNoNulo(v.getNombreVacuna())
                && validarCampoPositivo(v.getPeso())
                && validarCampoPositivo(v.getAltura())
                && validarCampoPositivo(v.getEdad());
    }

    private static boolean validarCampoNoNulo(String campo) {
        boolean res = true;
        
        res = campo == null || campo.isEmpty();
       var tr = campo.isEmpty();
        return res;
    }

    private static boolean validarCampoPositivo(double campo) {
        return campo > 0;
    }

    private static boolean validarCampoPositivo(int campo) {
        return campo > 0;
    }

    private static boolean validarCampoNotNull(LocalDate campo) {
        return campo != null;
    }
}
