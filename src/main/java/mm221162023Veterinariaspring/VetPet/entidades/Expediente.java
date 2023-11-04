package mm221162023Veterinariaspring.VetPet.entidades;

import java.time.LocalDate;

public class Expediente {
      int idExpediente;
    int idVacuna;
    int idPaciente;
    LocalDate fechaCita;
    String medicamentoRecetado;
    String informacionAdicional;
    boolean activo;

    public Expediente() {
    }

    public Expediente(String expedienteStr) {
        String[] partes = expedienteStr.split(",");

        this.idExpediente = Integer.parseInt(partes[0]);
        this.idVacuna = Integer.parseInt(partes[1]);
        this.idPaciente = Integer.parseInt(partes[2]);
        this.fechaCita = LocalDate.parse(partes[3]);
        this.medicamentoRecetado = partes[4];
        this.informacionAdicional = partes[5];
        this.activo = Boolean.parseBoolean(partes[6]);
    }

    public int getIdExpediente() {
        return idExpediente;
    }

    public void setIdExpediente(int idExpediente) {
        this.idExpediente = idExpediente;
    }

    public int getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(int idVacuna) {
        this.idVacuna = idVacuna;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public LocalDate getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getMedicamentoRecetado() {
        return medicamentoRecetado;
    }

    public void setMedicamentoRecetado(String medicamentoRecetado) {
        this.medicamentoRecetado = medicamentoRecetado;
    }

    public String getInformacionAdicional() {
        return informacionAdicional;
    }

    public void setInformacionAdicional(String informacionAdicional) {
        this.informacionAdicional = informacionAdicional;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        String str = this.idExpediente + "," + this.idVacuna + "," + this.idPaciente + ","
                + fechaCita + "," + medicamentoRecetado + "," + this.informacionAdicional + "," + this.activo;

        return str;
    }
}
