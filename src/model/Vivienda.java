package model;

public class Vivienda {

	private int id;
	private String descripcion;
	private int idLocalidad;
	
	/**
	 * 
	 */
	public Vivienda() {
		super();
	}

	/**
	 * 
	 * @param id
	 * @param descripcion
	 * @param idLocalidad
	 */
	public Vivienda(int id, String descripcion, int idLocalidad) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.idLocalidad = idLocalidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	@Override
	public String toString() {
		return descripcion;
	}
	
	
}
