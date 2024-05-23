package tablaDB;

public class PersonaDTO {
	private int idPersona;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	
	public PersonaDTO() {
		super();
	}
	// debido a que modificando este se podria eliminar todo lo de la columna 
	// LLave primaria
	public PersonaDTO(int idPersona) {
		super();
		this.idPersona = idPersona;
	}
	
	// Para inserta una nueva columna , el idpersona en autoincrement
	public PersonaDTO(String nombre, String apellido, String email, String telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}
	
	// Para el caso de modificacion 
	
	public PersonaDTO(int idPersona, String nombre, String apellido, String email, String telefono) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	//Para imprimir el estados del objeto 
	
	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", telefono=" + telefono + "]";
	}

}
