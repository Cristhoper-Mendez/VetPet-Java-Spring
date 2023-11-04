package mm221162023Veterinariaspring.VetPet.interfaces;

import java.util.List;
import mm221162023Veterinariaspring.VetPet.entidades.Cita;

public interface ICitaServicio {
     public List<Cita> ObtenerCitas();

    public List<Cita> ObtenerCitasActivas();

    public boolean CrearCita(Cita cita);

    public boolean ActualizarCita(Cita cita);

    public boolean EliminarCita(int idCita);

    public List<Cita> ObtenerCitasPorPacienteId(int idPaciente);
}
