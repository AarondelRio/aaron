package com.ipartek.formacion.repository;

import java.util.List;

import javax.sql.DataSource;

import com.ipartek.formacion.domain.Curso;
/**
 * DAO Encargado de realizar la gestion de Cursos
 * @author Aaron
 *
 */
public interface CursoDAO {
	
	/**
	 * Clase encargada de conectar con la BBDD
	 * @param dataSource Pool de Conexiones
	 */
	void setDataSource(DataSource dataSource);
	
	/**
	 * Busca Cursos que contengan el parametro de busqueda
	 * @param filtro parametro de busqueda
	 * @return List de Cursos, vacio si no encuentra ninguno
	 */
	List<Curso> autocomplete(String filtro);
	
	/**
	 * Busca todos los Cursos en la BBDD
	 * @return List de Cursos, vacio si no encuentra ninguno
	 */
	List<Curso> getAll();
	
	/**
	 * Busca los ultimos 10 Cursos en la BBDD
	 * @return List de Cursos, vacio si no encuentra ninguno
	 */
	List<Curso> getLast10();

	/**
	 * Busca por ID un Curso en la BBDD
	 * @param idCurso identificador unico de Curso
	 * @return Curso, null si no encuentra ninguno
	 */
	Curso getById(int idCurso);

	/**
	 * Actualiza un registro en la BBDD
	 * @param curso POJO Curso
	 * @return true si se ha actualizado de forma correcta, false en caso contrario
	 */
	boolean update(Curso curso);
	
	/**
	 * Añade un registro en la BBDD
	 * @param curso POJO Curso
	 * @return true si se ha añadido de forma correcta, false en caso contrario
	 */
	boolean add(Curso curso);
	
	/**
	 * Elimina un registro de la BBDD
	 * @param idCurso identificador unico de Curso
	 * @return true si se ha eliminado de forma correcta, false en caso contrario
	 */
	boolean delete(int idCurso);
	
	/**
	 * Comprueba si el Curso existe en la BBDD
	 * @param curso POJO Curso
	 * @return true si lo ha encontrado, false en caso contrario
	 */
	boolean cursoExiste(Curso curso);
}
