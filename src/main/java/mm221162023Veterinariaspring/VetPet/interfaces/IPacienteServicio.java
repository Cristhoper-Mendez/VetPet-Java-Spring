package mm221162023Veterinariaspring.VetPet.interfaces;

import java.util.List;
import mm221162023Veterinariaspring.VetPet.entidades.Paciente;

public interface IPacienteServicio {
     public List<Paciente> ObtenerPacientes();

    public List<Paciente> ObtenerPacientesActivos();

    public boolean CrearPaciente(Paciente paciente);

    public boolean ActualizarPaciente(Paciente paciente);

    public boolean EliminarPaciente(int pacienteId);

    public Paciente ObtenerPacientePorId(int idPaciente);
}
