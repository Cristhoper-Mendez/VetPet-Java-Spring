package mm221162023Veterinariaspring.VetPet.interfaces;

import java.util.List;
import mm221162023Veterinariaspring.VetPet.entidades.Raza;

public interface IRazaServicio {
     public List<Raza> ObtenerRazasActivas();

    public List<Raza> ObtenerRazas();

    public boolean CrearRaza(Raza raza);

    public boolean ActualizarRaza(Raza raza);

    public boolean EliminarRaza(int razaId);

    public Raza ObtenerRazaPorId(int idRaza);

    public List<Raza> ObtenerRazasPorTipoPaciente(int idTipoPaciente);
}
