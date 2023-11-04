package mm221162023Veterinariaspring.VetPet.entidades;

public class Usuario {
       int idUsuario;
    String nombres;
    String apellidos;
    String correo;
    String password;
    boolean activo;

    public Usuario() {
    }

    public Usuario(String usuarioStr) {
        String[] partes = usuarioStr.split(",");

        this.idUsuario = Integer.parseInt(partes[0]);
        this.nombres = partes[1];
        this.apellidos = partes[2];
        this.correo = partes[3];
        this.password = partes[4];
        this.activo = Boolean.parseBoolean(partes[5]);
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        String str = this.idUsuario + "," + this.nombres + "," + this.apellidos
                + "," + this.correo + "," + this.password + "," + this.activo;

        return str;
    }
}
