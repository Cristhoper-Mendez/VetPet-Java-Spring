package mm221162023Veterinariaspring.VetPet.interfaces;

import java.util.List;
import mm221162023Veterinariaspring.VetPet.entidades.Usuario;

public interface IUsuarioServicio {

    public List<Usuario> ObtenerUsuarios();

    public List<Usuario> ObtenerUsuariosActivos();

    public boolean CrearUsuario(Usuario usuario);

    public boolean ActualizarUsuario(Usuario usuario);

    public boolean EliminarUsuario(int idUsuario);

    public boolean ValidarUsuario(String email, String password);

    public Usuario GetUsuarioPorCorreo(String correo);
}
