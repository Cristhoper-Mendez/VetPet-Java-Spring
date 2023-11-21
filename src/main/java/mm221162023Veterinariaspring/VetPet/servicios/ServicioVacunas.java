package mm221162023Veterinariaspring.VetPet.servicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import mm221162023Veterinariaspring.VetPet.entidades.Vacuna;
import mm221162023Veterinariaspring.VetPet.interfaces.IVacunaServicio;
import mm221162023Veterinariaspring.VetPet.utilidades.InicializarArchivo;
import org.springframework.stereotype.Service;

@Service
public class ServicioVacunas implements IVacunaServicio {

    String archivo;

    public ServicioVacunas() {
        String directoryName = System.getProperty("user.dir");
        directoryName = directoryName + "\\src\\main\\java\\mm221162023Veterinariaspring\\VetPet\\archivos\\Vacunas.txt";

        InicializarArchivo.InicializarArchivo(directoryName);

        this.archivo = directoryName;
    }

    @Override
    public List<Vacuna> ObtenerVacunas() {
        List<Vacuna> LstVacunas = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.archivo));

            String linea;

            while ((linea = reader.readLine()) != null && !linea.equals("")) {
                Vacuna vacunas = new Vacuna(linea);

                LstVacunas.add(vacunas);
            }
        } catch (IOException e) {
        }

        return LstVacunas;
    }

    @Override
    public boolean CrearVacunas(Vacuna vacunas) {
        try {
            List<Vacuna> LstVacunas = this.ObtenerVacunas();
            int size = LstVacunas.size();
            int id = 1;

            if (size > 0) {
                id = LstVacunas.get(size - 1).getIdVacuna() + 1;
            }

            vacunas.setIdVacuna(id);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.archivo, true))) {
                writer.write(vacunas.toString());
                writer.newLine();
            }

        } catch (IOException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean ActualizarVacunas(Vacuna vacunas) {
        try {
            List<Vacuna> LstVacunas = this.ObtenerVacunas();

            for (int i = 0; i < LstVacunas.size(); i++) {
                if (LstVacunas.get(i).getIdVacuna() == vacunas.getIdVacuna()) {
                    LstVacunas.set(i, vacunas);
                    break;
                }
            }

            GuardarVacunas(LstVacunas);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean EliminarVacunas(int vacunaId) {
        try {
            List<Vacuna> LstVacunas = this.ObtenerVacunas();

            for (int i = 0; i < LstVacunas.size(); i++) {
                if (LstVacunas.get(i).getIdVacuna() == vacunaId) {
                    Vacuna vacunas = LstVacunas.get(i);
                    vacunas.setActivo(false);
                    LstVacunas.set(i, vacunas);
                    break;
                }
            }

            GuardarVacunas(LstVacunas);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private void GuardarVacunas(List<Vacuna> LstVacunas) {
        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.archivo, false))) {
                for (Vacuna vacuna : LstVacunas) {
                    writer.write(vacuna.toString());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
        }
    }

    @Override
    public List<Vacuna> ObtenerVacunasActivas() {
        List<Vacuna> LstVacunasActivas = new ArrayList<>();
        List<Vacuna> LstVacunas = this.ObtenerVacunas();

        for (Vacuna v : LstVacunas) {
            if (v.isActivo() == true) {
                LstVacunasActivas.add(v);
            }
        }

        return LstVacunasActivas;
    }

}
