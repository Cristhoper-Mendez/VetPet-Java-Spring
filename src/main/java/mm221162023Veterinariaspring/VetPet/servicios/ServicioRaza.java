package mm221162023Veterinariaspring.VetPet.servicios;

import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import mm221162023Veterinariaspring.VetPet.entidades.Raza;
import mm221162023Veterinariaspring.VetPet.interfaces.IRazaServicio;

@Service
public class ServicioRaza implements IRazaServicio {

    String archivo;

    public ServicioRaza() {
        String directoryName = System.getProperty("user.dir");
        directoryName = directoryName +"\\src\\main\\java\\mm221162023Veterinariaspring\\VetPet\\archivos\\Razas.txt";
        
        this.archivo = directoryName;
    }

    @Override
    public List<Raza> ObtenerRazasActivas() {
        List<Raza> LstRazas = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.archivo));

            String linea;
            while ((linea = reader.readLine()) != null && !linea.equals("")) {
                Raza raza = new Raza(linea);

                if (raza.getActivo()) {
                    LstRazas.add(raza);
                }

            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        return LstRazas;
    }

    @Override
    public List<Raza> ObtenerRazas() {
        List<Raza> LstRazas = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.archivo));

            String linea;
            while ((linea = reader.readLine()) != null && !linea.equals("")) {
                Raza raza = new Raza(linea);

                LstRazas.add(raza);
            }
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        return LstRazas;
    }

    @Override
    public boolean CrearRaza(Raza raza) {
        try {
            List<Raza> LstRazas = this.ObtenerRazas();
            int size = LstRazas.size();
            int id = 1;

            if (size > 0) {
                id = LstRazas.get(size - 1).getRazaId() + 1;
            }

            raza.setRazaId(id);
            String razaStr = raza.toString();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.archivo, true))) {
                writer.write(razaStr);
                writer.newLine();
            }

            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public boolean ActualizarRaza(Raza raza) {
        List<Raza> LstRazas = this.ObtenerRazas();

        try {
            for (int i = 0; i < LstRazas.size(); i++) {
                if (LstRazas.get(i).getRazaId() == raza.getRazaId()) {
                    LstRazas.set(i, raza);
                    break;
                }
            }

            GuardarRazas(LstRazas);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean EliminarRaza(int razaId) {
        try {
            List<Raza> LstRazas = this.ObtenerRazas();

            for (int i = 0; i < LstRazas.size(); i++) {
                if (LstRazas.get(i).getRazaId() == razaId) {
                    Raza raza = LstRazas.get(i);
                    raza.setActivo(false);

                    LstRazas.set(i, raza);
                    break;
                }
            }

            GuardarRazas(LstRazas);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void GuardarRazas(List<Raza> LstRazas) {
        try {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.archivo, false))) {
                for (Raza raza : LstRazas) {
                    writer.write(raza.toString());
                    writer.newLine();
                }
            }

        } catch (IOException e) {
        }
    }

    @Override
    public Raza ObtenerRazaPorId(int idRaza) {
        Raza r = null;
        List<Raza> LstRazas = this.ObtenerRazasActivas();

        for (Raza raza : LstRazas) {
            if (raza.getRazaId() == idRaza) {
                r = raza;
            }
        }

        return r;
    }

    @Override
    public List<Raza> ObtenerRazasPorTipoPaciente(int idTipoPaciente) {
        List<Raza> LstRazasPaciente = new ArrayList<>();
        List<Raza> LstRazas = this.ObtenerRazasActivas();

        for (Raza r : LstRazas) {
            if (r.getTipoPaciente() == idTipoPaciente) {
                LstRazasPaciente.add(r);
            }
        }

        return LstRazasPaciente;
    }
}
