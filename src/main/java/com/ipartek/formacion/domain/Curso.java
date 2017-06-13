package com.ipartek.formacion.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * POJO Curso
 * @author Aaron
 *
 */
public class Curso {
	private int id;
	@NotNull()
	@Size(message="Longitud Incorrecta, minimo {min} y maximo {max} caracteres",min=1, max=255)
	private String nombre;
	@NotNull()
	@Size(message="Longitud Incorrecta, minimo {min} y maximo {max} caracteres",min=1, max=55)
	private String codigo;
	
	/**
	 * Constructor para curso
	 */
	public Curso() {
		super();
		this.id = -1;
		this.nombre = "";
		this.codigo = "";
	}
	/**
	 * Getter
	 * @return ID
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Setter
	 * @param id ID de curso
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Getter
	 * @return nombre
	 */
	public String getNombre() {
		return this.nombre;
	}
	
	/**
	 * Setter
	 * @param nombre Nombre de curso
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * GetterS
	 * @return codigo
	 */
	public String getCodigo() {
		return this.codigo;
	}
	
	/**
	 * Setter
	 * @param codigo codigo de curso
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	@Override()
	public String toString() {
		return "Curso [id=" + this.id + ", nombre=" + this.nombre + ", codigo=" + this.codigo + "]";
	}
	
}
