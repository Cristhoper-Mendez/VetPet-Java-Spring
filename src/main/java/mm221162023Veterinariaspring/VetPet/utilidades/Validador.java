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
        boolean result = true;

        if (p.getNombreDueno() == null || p.getNombreDueno().isEmpty()) {
            result = false;
        }

        if (p.getNombrePaciente() == null || p.getNombrePaciente().isEmpty()) {
            result = false;
        }

        if (p.getRazaId() <= 0) {
            result = false;
        }

        if (p.getEdadPaciente() <= 0) {
            result = false;
        }

        if (p.getMedidas() == null || p.getMedidas().isEmpty()) {
            result = false;
        }

        if (p.getNumeroIdentificacion() <= 0) {
            result = false;
        }

        if (p.getPelajePaciente() == null || p.getPelajePaciente().isEmpty()) {
            result = false;
        }

        if (p.getFechaNacimiento() == null) {
            result = false;
        }

        return result;
    }

    public static boolean ValidarTipoPaciente(TipoPaciente tp) {
        boolean result = true;
        if (tp.getNombreTipoPaciente() == null || tp.getNombreTipoPaciente().isEmpty()) {
            result = false;
        }

        return result;
    }

    public static boolean ValidarVacuna(Vacuna v) {
        boolean result = true;

        if (v.getNombreVacuna() == null || v.getNombreVacuna().isEmpty()) {
            result = false;
        }

        if (v.getPeso() <= 0) {
            result = false;
        }

        if (v.getAltura() <= 0) {
            result = false;
        }

        if (v.getEdad() <= 0) {
            result = false;
        }

        return result;
    }

}
