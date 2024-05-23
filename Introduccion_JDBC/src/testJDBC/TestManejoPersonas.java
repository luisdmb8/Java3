package testJDBC;

import java.util.List;

import datosJDBC.PersonaDataAcessObject;
import tablaDB.Persona;

public class TestManejoPersonas {
	public static void main(String[] args) {
		PersonaDataAcessObject personaDao = new PersonaDataAcessObject();

		// Select de todo 

		//		List<Persona> personas = personaDao.seleccionar();
		//Tipo foreach
		//		for(Persona persona: personas) {
		//			System.out.println("persona = " + persona);
		//		}

		// INSERTAR UN NUEVO OBJETO DE TIPO PERSONA

//				Persona personaNueva = new Persona("Carlos", "Esparza", "cesparza@gmail.com", "123456754");
//				personaDao.insertar(personaNueva);


		// Modificar un objeto de persona

		//		Persona personaupdate = new Persona(3, "Javier","Esparza torre", "cesparza@gmail.com", "123456754");
		//		personaDao.actualizar(personaupdate);

		// Eliminar una ccolumna

		Persona personadelete = new Persona(5);
		personaDao.eliminar(personadelete);

		List<Persona> personas = personaDao.seleccionar();
		for(Persona persona: personas) {
			System.out.println("persona = " + persona);
		}
	}
}
