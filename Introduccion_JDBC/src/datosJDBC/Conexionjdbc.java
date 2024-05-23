package datosJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexionjdbc {
	
	private static final String JDBC_URL="jdbc:mysql://localhost:3306/Test_Java?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private static final String JDBC_USER = "luis.martinez";
	private static final String JDBC_PASSWD = "123456789";
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWD);
	}
	// ejecuta la instruccion con la variable que se crea
	public static void close(ResultSet rs) throws SQLException {
		rs.close();
	}
	// Nos permite ejecutar sentencia sobre la tabla de DB 
	public static void close(Statement smtm) throws SQLException {
		smtm.close();
	}
	// este es el mismo de Statement 
	
	// The object used for executing a static SQL statement and returning the results it produces.
	public static void close(PreparedStatement smtm) throws SQLException {
		smtm.close();
	}
	
	public static void close(Connection conn) throws SQLException {
		conn.close();
	}
}
