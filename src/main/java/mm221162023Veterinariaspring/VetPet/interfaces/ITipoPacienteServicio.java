package mm221162023Veterinariaspring.VetPet.interfaces;

import java.util.List;
import mm221162023Veterinariaspring.VetPet.entidades.TipoPaciente;

public interface ITipoPacienteServicio {
     public List<TipoPaciente> ObtenerTipoPacientesActivos();

    public List<TipoPaciente> ObtenerTipoPacientes();

    public boolean CrearTipoPaciente(TipoPaciente tipoPaciente);

    public boolean ActualizarTipoPaciente(TipoPaciente tipoPaciente);

    public boolean EliminarTipoPaciente(int tipoPacienteId);

    public TipoPaciente ObtenerTipoPacientePorId(int idTipoPaciente);
}
