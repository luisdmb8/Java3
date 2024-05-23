package testJDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import datosJDBC.Conexionjdbc;
import datosJDBC.PersonaDaoJDBC;
import datosJDBC.PersonaDAO;
import tablaDB.PersonaDTO;


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
			
		PersonaDAO personaDao = new PersonaDaoJDBC(conexion);
		
		List<PersonaDTO> personas = personaDao.select();
		
		for (PersonaDTO persona: personas) {
			System.out.println("Personas DTO: " + persona);
		}
	
		
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
