package mm221162023Veterinariaspring.VetPet.interfaces;

import java.util.List;
import mm221162023Veterinariaspring.VetPet.entidades.Vacuna;

public interface IVacunaServicio {

    public List<Vacuna> ObtenerVacunas();

    public List<Vacuna> ObtenerVacunasActivas();
    
    public Vacuna ObtenerVacunaPorId(int idVacuna);

    public boolean CrearVacunas(Vacuna vacuna);

    public boolean ActualizarVacunas(Vacuna vacuna);

    public boolean EliminarVacunas(int vacunaId);

}
