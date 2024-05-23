package labUsusario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import datosJDBC.Conexionjdbc;

public class UsuarioDataAcessObject {
	
	private Connection conexionTransaccional;

	private static final String SQL_SELECT = "SELECT id_usuario, usuario, password FROM usuario";
	private static final String SQL_INSERT = "INSERT INTO usuario(usuario, password) VALUES (?, ?)";
	private static final String SQL_UPDATE = "UPDATE usuario SET usuario= ?, password= ? WHERE id_usuario = ?";	
	private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario = ?";
	
	// recibir la conexion 
	public UsuarioDataAcessObject() {
		super();
	}

	//Permiti el objeto de tipo conexion 
	public UsuarioDataAcessObject(Connection conexionTransaccional) {
		this.conexionTransaccional = conexionTransaccional;
	}

	public List<Usuario> seleccionar () throws SQLException {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Usuario usuariio = null;
		List<Usuario> usuarios = new ArrayList<>();

		try {
			conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexionjdbc.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while(rs.next()) {
				int id_usuario = rs.getInt("id_usuario");
				String usuario = rs.getString("usuario");
				String password = rs.getString("password");


				// se llama el constructor
				usuariio = new Usuario(id_usuario, usuario , password);
				// se agregara el metodo add para que se agregue a la lista  
				usuarios.add(usuariio);
			}
		} 
		// se cierra la conexion , se cierran en el orden inverso que se abrieron
		finally {
			try {
				Conexionjdbc.close(rs);
				Conexionjdbc.close(stmt);
				if (this.conexionTransaccional == null) {
					Conexionjdbc.close(conn);
				}
			} catch (SQLException e) {
				e.printStackTrace(System.out);
			}
		}

		return usuarios;

	}

	public int insertar (Usuario usuario) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registros = 0;

		try {
			conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexionjdbc.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, usuario.getPassword());
			//Para que actualice el estado en la DB
			registros = stmt.executeUpdate();

		} 
		finally {
			try {
				Conexionjdbc.close(stmt);
				if (this.conexionTransaccional == null) {
					Conexionjdbc.close(conn);
				}
			} catch (SQLException e) {
				e.printStackTrace(System.out);
			}
		}
		return registros;
	}

	public int actualizar (Usuario usuario) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registros = 0;

		try {
			conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexionjdbc.getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, usuario.getUsuario());
			stmt.setString(2, usuario.getPassword());
			stmt.setInt(3, usuario.getId_usuario());
			//Para que actualice el estado en la DB
			registros = stmt.executeUpdate();

		} 
		finally {
			try {
				Conexionjdbc.close(stmt);
				if (this.conexionTransaccional == null) {
					Conexionjdbc.close(conn);
				}
			} catch (SQLException e) {
				e.printStackTrace(System.out);
			}
		}
		return registros;
	}
	
	public int eliminar (Usuario usuario) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registros = 0;

		try {
			conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexionjdbc.getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, usuario.getId_usuario());
			//Para que actualice el estado en la DB
			registros = stmt.executeUpdate();

		} 
		finally {
			try {
				Conexionjdbc.close(stmt);
				if (this.conexionTransaccional == null) {
					Conexionjdbc.close(conn);
				}
			} catch (SQLException e) {
				e.printStackTrace(System.out);
			}
		}
		return registros;
	}

}
