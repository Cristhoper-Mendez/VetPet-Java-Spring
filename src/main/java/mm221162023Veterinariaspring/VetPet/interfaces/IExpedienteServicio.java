package mm221162023Veterinariaspring.VetPet.interfaces;

import java.util.List;
import mm221162023Veterinariaspring.VetPet.entidades.Expediente;

public interface IExpedienteServicio {

    public List<Expediente> ObtenerExpediente();

    public List<Expediente> ObtenerExpedienteActivas();

    public boolean CrearExpediente(Expediente expediente);

    public boolean ActualizarExpediente(Expediente expediente);

    public boolean EliminarExpediente(int expedienteId);

    public List<Expediente> ObtenerExpedientePorIdPaciente(int idPaciente);
}
