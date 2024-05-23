package testJDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import datosJDBC.Conexionjdbc;
import datosJDBC.PersonaDataAcessObject;
import tablaDB.Persona;

public class TestManejoPersonas {
	public static void main(String[] args) {
		
		Connection conexion =  null;

				
		// Se crea un objeto de tipo conexion 
		try {
			conexion =  Conexionjdbc.getConnection();
			// quire decir que no e haga un autp comit 
			if(conexion.getAutoCommit()) {
				conexion.setAutoCommit(false);
			}
			
		PersonaDataAcessObject personajdbc = new PersonaDataAcessObject(conexion);
		Persona cambioPersona = new Persona();
		cambioPersona.setIdPersona(3);
		cambioPersona.setNombre("Javier Fernando");
		cambioPersona.setApellido("Esparta");
		cambioPersona.setEmail("cesparza@gmail.com");
		cambioPersona.setTelefono("123456754");
		personajdbc.actualizar(cambioPersona);
		
		// no tiene id porque se crea automatico , los valores que no estan quedaran en null
		Persona nuevaPersona = new Persona();
		nuevaPersona.setNombre("David");
		nuevaPersona.setApellido("Bautista");
		personajdbc.insertar(nuevaPersona);
		
		conexion.commit();
		System.out.println("Se ha hecho commit de la transaccion");


		} catch (SQLException e) {
			e.printStackTrace(System.out);
			System.out.println("Ingresar al RollBack");
			try {
				// si falla algo en la transaccion hara Rollback de todo
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace(System.out);
			}
		}
		
	}

}
