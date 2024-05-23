package datosJDBC;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class Conexionjdbc {
	
	private static final String JDBC_URL="jdbc:mysql://localhost:3306/Test_Java?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private static final String JDBC_USER = "luis.martinez";
	private static final String JDBC_PASSWD = "123456789";
	
	// Pool de conexiones 
	
	public static DataSource getDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl(JDBC_URL);
		ds.setUsername(JDBC_USER);
		ds.setPassword(JDBC_PASSWD);
		// Definimos el tamano inciial del pool de conexiones
		ds.setInitialSize(5); // Tener cuidado cuantas conexiones abrira
		return ds;
	}
	
	public static Connection getConnection() throws SQLException{
		return getDataSource().getConnection();
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
