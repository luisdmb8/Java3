package testJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestMysqlJDBC {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/Test_Java?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
//?useSSL=false == no usa la seguridad 
//useTimezone=true&serverTimezone=UTC = Timezone donde esta la DB 
//allowPublicKeyRetrieval=true = Permite que nos podamos conectar de manera exitosa a MYSQL
// Puede que se requiera para Aplicaciones Web 
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		try {
			Connection conexion = DriverManager.getConnection(url, "luis.martinez", "LuisT3l1nt3l!");
			//Nos permite ejecutar sentencia sobre la tabla de DB 
			Statement instruccion = conexion.createStatement();
			// Variable creada para la sentencia
			String sql = "Select id_persona, nombre, apellido, email, telefono FROM persona";
			// ejecuta la instruccion con la variable que se crea
			ResultSet resultado = instruccion.executeQuery(sql);
			while(resultado.next()) {
				System.out.print("Id Persona: " + resultado.getInt("id_persona"));
				System.out.print(" Nombre: " + resultado.getString("nombre"));
				System.out.print(" Apellido: " + resultado.getString("apellido"));
				System.out.print(" email: " + resultado.getString("email"));
				System.out.println(" telefono: " + resultado.getString("telefono"));
			}
			resultado.close();
			instruccion.close();
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
		
	}

}
