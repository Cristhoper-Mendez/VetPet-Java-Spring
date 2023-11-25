package mm221162023Veterinariaspring.VetPet.utilidades;

import java.time.LocalDate;
import mm221162023Veterinariaspring.VetPet.entidades.*;

public class Validador {

    public boolean ValidarRaza(Raza r) {
        boolean result = true;

        if (r.getNombreRaza() == null && r.getNombreRaza().isEmpty()) {
            result = false;
        }

        if (r.getTipoPaciente() == 0) {
            result = false;
        }

        return result;
    }

    public boolean ValidarCita(Cita c) {
        boolean result = true;

        if (c.getFechaCita() == null) {
            result = false;
        }

        if (c.getIdPaciente() == 0) {
            result = false;
        }

        if (c.getMotivo().isEmpty()) {
            result = false;
        }

        if (c.getNombrePaciente().isEmpty()) {
            result = false;
        }

        return result;
    }

    public boolean ValidarExpediente(Expediente ex) {
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

    public boolean ValidarPaciente(Paciente p) {
        return validarCampoNoNulo(p.getNombrePaciente())
                && validarCampoNoNulo(p.getNombreDueno())
                && validarCampoPositivo(p.getEdadPaciente())
                && validarCampoPositivo(p.getRazaId())
                && validarCampoPositivo(p.getTipoPaciente())
                && validarCampoNotNull(p.getFechaInscripcion())
                && validarCampoNoNulo(p.getMedidas())
                && validarCampoPositivo(p.getNumeroIdentificacion())
                && validarCampoNoNulo(p.getPelajePaciente())
                && validarCampoNotNull(p.getFechaNacimiento());
    }

    public boolean ValidarTipoPaciente(TipoPaciente tp) {
        return validarCampoNoNulo(tp.getNombreTipoPaciente())
                && validarCampoPositivo(tp.getIdTipoPaciente());
    }

    public boolean ValidarVacuna(Vacuna v) {
        return validarCampoNoNulo(v.getNombreVacuna())
                && validarCampoPositivo(v.getPeso())
                && validarCampoPositivo(v.getAltura())
                && validarCampoPositivo(v.getEdad());
    }

    private boolean validarCampoNoNulo(String campo) {
        return campo != null && !campo.isEmpty();
    }

    private boolean validarCampoPositivo(double campo) {
        return campo > 0;
    }

    private boolean validarCampoPositivo(int campo) {
        return campo > 0;
    }

    private boolean validarCampoNotNull(LocalDate campo) {
        return campo != null;
    }
}
