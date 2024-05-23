package labUsusario;

import java.util.List;

public class TestUsuarioCredenciales {
	public static void main(String[] args) {
		UsuarioDataAcessObject usuarioDAO = new UsuarioDataAcessObject();

		//Insertar
//		Usuario usuarioNuevo = new Usuario("usuariodel", "jkhdvghxc!23");
//		usuarioDAO.insertar(usuarioNuevo);
		
		// Actualizar

//		Usuario usuarioupdate = new Usuario(2, "santiago.carrillo", "123456754");
//		usuarioDAO.actualizar(usuarioupdate);
		
		// Delete
		
		Usuario usuariodelete = new Usuario(3);
		usuarioDAO.eliminar(usuariodelete);
		
		List<Usuario> usuarios = usuarioDAO.seleccionar();
		for(Usuario usuariio: usuarios) {
			System.out.println("Usuario = " + usuariio);
		}
		
	}

}
