package mm221162023Veterinariaspring.VetPet.entidades;

public class Raza {
    int razaId;
    String nombreRaza;
    int tipoPaciente;
    boolean activo;

    public Raza() {
    }

    public Raza(int razaId, String nombreRaza, boolean activo) {
        this.razaId = razaId;
        this.nombreRaza = nombreRaza;
        this.activo = activo;
    }

    public Raza(String str) {
        String[] partes = str.split(",");
        int razaIdStr = Integer.parseInt(partes[0]);
        String nombre = partes[1];
        boolean activoStr = Boolean.parseBoolean(partes[3]);

        this.razaId = razaIdStr;
        this.nombreRaza = nombre;
        this.tipoPaciente = Integer.parseInt(partes[2]);
        this.activo = activoStr;
    }

    public int getRazaId() {
        return razaId;
    }

    public void setRazaId(int razaId) {
        this.razaId = razaId;
    }

    public String getNombreRaza() {
        return nombreRaza;
    }

    public void setNombreRaza(String nombreRaza) {
        this.nombreRaza = nombreRaza;
    }

    public int getTipoPaciente() {
        return tipoPaciente;
    }

    public void setTipoPaciente(int tipoPaciente) {
        this.tipoPaciente = tipoPaciente;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        String razaStr = this.razaId + "," + this.nombreRaza + "," + this.tipoPaciente + "," + this.activo;

        return razaStr;
    }
}
