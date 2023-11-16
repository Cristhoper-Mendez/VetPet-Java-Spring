package mm221162023Veterinariaspring.VetPet.utilidades;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InicializarArchivo {
    public static void InicializarArchivo(String rutaArchivo){
        if(Files.exists(Paths.get(rutaArchivo))){
            System.out.println("Existe");
        } else {
            try {
                Files.createFile(Paths.get(rutaArchivo));
                System.out.println("Creado;");
            } catch (IOException e) {
                System.err.println("Error al crear el archivo: " + e.getMessage());
            }
        }
    }
}
