package datosJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tablaDB.Persona;

public class PersonaDataAcessObject {

	// Conexion transaccional
	private Connection conexionTransaccional;


	private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
	private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, email, telefono) VALUES (?, ?, ? ,?)";
	private static final String SQL_UPDATE = "UPDATE persona SET nombre= ?, apellido= ?, email = ?, telefono = ? WHERE id_persona = ?";
	private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";

	// recibir la conexion 
	public PersonaDataAcessObject() {
		super();
	}

	//Permiti el objeto de tipo conexion 
	public PersonaDataAcessObject(Connection conexionTransaccional) {
		this.conexionTransaccional = conexionTransaccional;
	}

	public List<Persona> seleccionar () {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		Persona persona = null;
		List<Persona> personas = new ArrayList<>();

		try {
			conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexionjdbc.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while(rs.next()) {
				int idPersona = rs.getInt("id_persona");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String email = rs.getString("email");
				String telefono = rs.getString("telefono");

				// se llama el constructor
				persona = new Persona(idPersona, nombre, apellido, email , telefono);

				// se agregara el metodo add para que se agregue a la lista  
				personas.add(persona);
			}

		} catch (SQLException e) {
			e.printStackTrace(System.out);
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

		return personas;

	}

	public int insertar (Persona persona) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registros = 0;

		try {
			conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexionjdbc.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, persona.getNombre());
			stmt.setString(2, persona.getApellido());
			stmt.setString(3, persona.getEmail());
			stmt.setString(4, persona.getTelefono());
			//Para que actualice el estado en la DB
			registros = stmt.executeUpdate();

		} 
		finally {
			try {
				Conexionjdbc.close(stmt);
				if (this.conexionTransaccional == null) {
					Conexionjdbc.close(conn);
				}			} catch (SQLException e) {
					e.printStackTrace(System.out);
				}
		}
		return registros;
	}


	public int actualizar (Persona persona) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registros = 0;

		try {
			conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexionjdbc.getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, persona.getNombre());
			stmt.setString(2, persona.getApellido());
			stmt.setString(3, persona.getEmail());
			stmt.setString(4, persona.getTelefono());
			stmt.setInt(5, persona.getIdPersona());
			//Para que actualice el estado en la DB
			registros = stmt.executeUpdate();

		} 
		finally {
			try {
				Conexionjdbc.close(stmt);
				if (this.conexionTransaccional == null) {
					Conexionjdbc.close(conn);
				}			} catch (SQLException e) {
					e.printStackTrace(System.out);
				}
		}
		return registros;
	}

	public int eliminar (Persona persona) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		int registros = 0;

		try {
			conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexionjdbc.getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, persona.getIdPersona());
			//Para que actualice el estado en la DB
			registros = stmt.executeUpdate();

		} 
		finally {
			try {
				Conexionjdbc.close(stmt);
				if (this.conexionTransaccional == null) {
					Conexionjdbc.close(conn);
				}			} catch (SQLException e) {
					e.printStackTrace(System.out);
				}
		}
		return registros;
	}

}
