package com.ipartek.formacion.domain;
/**
 * POJO para guardar informacion sobre la migracion de Excel a SQL
 * @author Curso
 *
 */
public class MigrationData {
	private int cursosInsertados;
	private int cursosExistian;
	private int cursosIncompletos;
	
	/**
	 * Constructor por defecto
	 */
	public MigrationData() {
		super();
		this.cursosInsertados = 0;
		this.cursosExistian = 0;
		this.cursosIncompletos = 0;
	}
	
	/**
	 * Getter 
	 * @return Cursos Insertados con exito
	 */
	public int getCursosInsertados() {
		return this.cursosInsertados;
	}
	
	/**
	 * Añade 1 a el numero de cursos insertados con exito
	 */
	public void addCursosInsertados() {
		this.cursosInsertados++;
	}
	
	/**
	 * Setter
	 * @param cursosInsertados numero de cursos insertados con exito
	 */
	public void setCursosInsertados(int cursosInsertados) {
		this.cursosInsertados = cursosInsertados;
	}
	
	/**
	 * Getter
	 * @return numero de cursos que ya existian en la BBDD a la hora de hacer la migracion
	 */
	public int getCursosExistian() {
		return this.cursosExistian;
	}
	
	/**
	 * Añade 1 a el numero de cursos que ya existian
	 */
	public void addCursosExistian() {
		this.cursosExistian++;
	}
	
	/**
	 * Setter
	 * @param cursosExistian numero de cursos que ya existian en la BBDD a la hora de hacer la migracion
	 */
	public void setCursosExistian(int cursosExistian) {
		this.cursosExistian = cursosExistian;
	}
	
	/**
	 * Getter
	 * @return numero de cursos incompletos, que bien les falta el nombre o codigo
	 */
	public int getCursosIncompletos() {
		return this.cursosIncompletos;
	}
	
	/**
	 * Añade 1 a el numero de cursos Incompletos, que bien les falta el nombre o codigo
	 */
	public void addCursosIncompletos() {
		this.cursosIncompletos++;
	}
	
	/**
	 * Setter
	 * @param cursosIncompletos numero de cursos incompletos, que bien les falta el nombre o codigo
	 */
	public void setCursosIncompletos(int cursosIncompletos) {
		this.cursosIncompletos = cursosIncompletos;
	}
	@Override()
	public String toString() {
		return "Migrate [cursosInsertados=" + this.cursosInsertados + ", cursosExistian=" + this.cursosExistian
				+ ", cursosIncompletos=" + this.cursosIncompletos + "]";
	}
	
}
