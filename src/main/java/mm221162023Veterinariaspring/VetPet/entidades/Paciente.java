package mm221162023Veterinariaspring.VetPet.entidades;

import java.time.LocalDate;

public class Paciente {

    int idPaciente;
    String nombrePaciente;
    String nombreDueño;
    double edadPaciente;
    int razaId;
    int tipoPaciente;
    LocalDate fechaInscripcion;
    boolean sexo; // true macho, false hembra
    String medidas;
    int numeroIdentificacion;
    String pelajePaciente;
    LocalDate fechaNacimiento;
    boolean activo;

    // Relaciones
    Raza razaPaciente;

    public Paciente() {
    }

    public Paciente(String pacienteStr) {
        String[] partes = pacienteStr.split(",");

        this.idPaciente = Integer.parseInt(partes[0]);
        this.nombrePaciente = partes[1];
        this.nombreDueño = partes[2];
        this.edadPaciente = Double.parseDouble(partes[3]);
        this.razaId = Integer.parseInt(partes[4]);
        this.tipoPaciente = Integer.parseInt(partes[5]);
        this.fechaInscripcion = LocalDate.parse(partes[6]);
        this.sexo = Boolean.parseBoolean(partes[7]);
        this.medidas = partes[8];
        this.numeroIdentificacion = Integer.parseInt(partes[9]);
        this.pelajePaciente = partes[10];
        this.fechaNacimiento = LocalDate.parse(partes[11]);
        this.activo = Boolean.parseBoolean(partes[12]);
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getNombreDueño() {
        return nombreDueño;
    }

    public void setNombreDueño(String nombreDueño) {
        this.nombreDueño = nombreDueño;
    }

    public double getEdadPaciente() {
        return edadPaciente;
    }

    public void setEdadPaciente(double edadPaciente) {
        this.edadPaciente = edadPaciente;
    }

    public int getRazaId() {
        return razaId;
    }

    public void setRazaId(int razaId) {
        this.razaId = razaId;
    }

    public Raza getRazaPaciente() {
        return razaPaciente;
    }

    public void setRazaPaciente(Raza razaPaciente) {
        this.razaPaciente = razaPaciente;
    }

    public int getTipoPaciente() {
        return tipoPaciente;
    }

    public void setTipoPaciente(int tipoPaciente) {
        this.tipoPaciente = tipoPaciente;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public boolean getSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public String getMedidas() {
        return medidas;
    }

    public void setMedidas(String medidas) {
        this.medidas = medidas;
    }

    public int getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(int numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getPelajePaciente() {
        return pelajePaciente;
    }

    public void setPelajePaciente(String pelajePaciente) {
        this.pelajePaciente = pelajePaciente;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        String str = this.idPaciente + "," + this.nombrePaciente + "," + this.nombreDueño + ","
                + this.edadPaciente + "," + this.razaId + "," + tipoPaciente
                + "," + fechaInscripcion + "," + this.sexo + "," + this.medidas + ","
                + this.numeroIdentificacion + "," + this.pelajePaciente + ","
                + this.fechaNacimiento + "," + this.activo;

        return str;
    }
}
