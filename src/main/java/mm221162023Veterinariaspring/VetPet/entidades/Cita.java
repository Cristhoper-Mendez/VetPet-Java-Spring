package mm221162023Veterinariaspring.VetPet.entidades;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

public class Cita {

    int idCita;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate fechaCita;
    int idPaciente;
    String motivo;
    String nombrePaciente;
    boolean activo;

    public Cita() {
    }

    public Cita(String citaStr) {
        String[] partes = citaStr.split(",");

        this.idCita = Integer.parseInt(partes[0]);
        this.fechaCita = LocalDate.parse(partes[1]);
        this.idPaciente = Integer.parseInt(partes[2]);
        this.motivo = partes[3];
        this.nombrePaciente = partes[4];
        this.activo = Boolean.parseBoolean(partes[5]);
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public LocalDate getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        String str = this.idCita + "," + this.fechaCita + "," + this.idPaciente + "," + this.motivo + "," + this.nombrePaciente + "," + this.activo;

        return str;
    }
}
