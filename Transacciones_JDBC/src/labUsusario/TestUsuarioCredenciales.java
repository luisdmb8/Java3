package labUsusario;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import datosJDBC.Conexionjdbc;

public class TestUsuarioCredenciales {
	public static void main(String[] args) {
		Connection conexion =  null;

		
		// Se crea un objeto de tipo conexion 
		
			try {
				conexion =  Conexionjdbc.getConnection();
				// quire decir que no e haga un autp comit 
				if(conexion.getAutoCommit()) {
					conexion.setAutoCommit(false);
				}
			
			UsuarioDataAcessObject usuariojdbc = new UsuarioDataAcessObject(conexion);
			Usuario cambioUsuario = new Usuario();
			cambioUsuario.setId_usuario(2);
			cambioUsuario.setUsuario("scarrillo");
			cambioUsuario.setPassword("jashjgd");
			usuariojdbc.actualizar(cambioUsuario);
			
			Usuario agregarUsuario = new Usuario();
			agregarUsuario.setUsuario("luis.martinez");
			agregarUsuario.setPassword(";l,mnckjb");
			usuariojdbc.insertar(agregarUsuario);
			
			conexion.commit();
			System.out.println("Se ha hecho commit de la transaccion");
			
			} catch (SQLException e) {
				e.printStackTrace(System.out);
				System.out.println("Ingresar al RollBack");
				try {
					conexion.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace(System.out);
				}
			}

		
	}

}
