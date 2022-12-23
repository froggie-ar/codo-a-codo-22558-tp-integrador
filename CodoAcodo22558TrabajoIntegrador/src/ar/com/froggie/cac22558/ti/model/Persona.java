package ar.com.froggie.cac22558.ti.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the personas database table.
 * 
 */
@Entity
@Table(name="personas")
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	@GeneratedValue(strategy = GenerationType.AUTO )
	private String id;

	@Column(name="per_apellido", nullable=false, length=50)
	private String apellido;

	@Column(name="per_dni", nullable=false, length=20)
	private String dni;

	@Column(name="per_nombre", nullable=false, length=50)
	private String nombre;

	public Persona() {
	}

	
	public Persona(String id, String apellido, String nombre, String dni) {
		
		super();
		this.id = id;
		this.apellido = apellido;
		this.dni = dni;
		this.nombre = nombre;
		
	}


	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", apellido=" + apellido + ", dni=" + dni + ", nombre=" + nombre + "]";
	}

	
}