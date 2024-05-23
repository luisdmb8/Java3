package datosJDBC;

import java.sql.SQLException;

import java.util.List;

import tablaDB.PersonaDTO;

//DAO Data Access Object

public interface PersonaDAO {
	
	public List<PersonaDTO> select() throws SQLException;
	public int insert(PersonaDTO persona) throws SQLException;
	public int update(PersonaDTO persona) throws SQLException;
	public int delete(PersonaDTO persona) throws SQLException;

}
