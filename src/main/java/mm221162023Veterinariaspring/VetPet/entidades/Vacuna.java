package mm221162023Veterinariaspring.VetPet.entidades;

public class Vacuna {
    
    int idVacuna;
    String nombreVacuna;
    double peso;
    double altura;
    double edad;
    int idPaciente;
    boolean activo;

    public Vacuna() {
    }

    public Vacuna(String vacunaStr) {
        String[] partes = vacunaStr.split(",");

        this.idVacuna = Integer.parseInt(partes[0]);
        this.nombreVacuna = partes[1];
        this.peso = Double.parseDouble(partes[2]);
        this.altura = Double.parseDouble(partes[3]);
        this.edad = Double.parseDouble(partes[4]);
        this.idPaciente = Integer.parseInt(partes[5]);
        this.activo = Boolean.parseBoolean(partes[6]);
    }

    public int getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(int idVacuna) {
        this.idVacuna = idVacuna;
    }

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getEdad() {
        return edad;
    }

    public void setEdad(double edad) {
        this.edad = edad;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        String str = this.idVacuna + "," + this.nombreVacuna + "," + this.peso + "," + this.altura
                + "," + this.edad + "," + this.idPaciente + "," + this.activo;

        return str;
    }
}
