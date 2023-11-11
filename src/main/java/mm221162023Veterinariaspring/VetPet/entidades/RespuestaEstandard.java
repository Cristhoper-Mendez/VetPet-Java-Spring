package mm221162023Veterinariaspring.VetPet.entidades;

public class RespuestaEstandard {
    private boolean error;
    private String mensaje;

    public RespuestaEstandard() {
    }

    public RespuestaEstandard(boolean error, String mensaje) {
        this.error = error;
        this.mensaje = mensaje;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
