package mm221162023Veterinariaspring.VetPet.entidades;

public class TipoPaciente {

    int IdTipoPaciente;
    String nombreTipoPaciente;
    boolean activo;

    public TipoPaciente() {
    }

    public TipoPaciente(String tipoStr) {
        String[] partes = tipoStr.split(",");

        this.IdTipoPaciente = Integer.parseInt(partes[0]);
        this.nombreTipoPaciente = partes[1];
        this.activo = Boolean.parseBoolean(partes[2]);
    }

    public int getIdTipoPaciente() {
        return IdTipoPaciente;
    }

    public void setIdTipoPaciente(int IdTipoPaciente) {
        this.IdTipoPaciente = IdTipoPaciente;
    }

    public String getNombreTipoPaciente() {
        return nombreTipoPaciente;
    }

    public void setNombreTipoPaciente(String nombreTipoPaciente) {
        this.nombreTipoPaciente = nombreTipoPaciente;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return this.IdTipoPaciente + "," + this.nombreTipoPaciente + "," + this.activo;
    }
}
