package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.domain.Curso;
import com.ipartek.formacion.domain.MigrationData;

/**
 * Interface del Servicio para la gestion de cursos
 * @author Aaron
 *
 */
public interface CursoService {
	
	/**
	 * Servicio encargado de devolver todos los registros de la BBDD
	 * @return List de Cursos, vacio si no existe ninguno
	 */
	List<Curso> getAll();
	
	/**
	 * Servicio encargado de buscar Cursos que contengan el parametro de busqueda
	 * @param filtro parametro de busqueda
	 * @return List de Cursos, vacio si no encuentra ninguna coincidencia
	 */
	List<Curso> autocomplete(String filtro);
	
	/**
	 * Servicio encargado de buscar los diez ultimos registros de la BBDD
	 * @return List de Cursos, vacio si no encuentra ninguno
	 */
	List<Curso> getLast10();
	
	/**
	 * Servicio encargado de buscar un Curso 
	 * @param idCurso identificador unico de curso
	 * @return Curso, null si no encuentra ninguno
	 */
	Curso getById(int idCurso);	
	
	/**
	 * Servicio encargado de actualizar un registro en la BBDD
	 * @param curso POJO Curso
	 * @return true si se ha actualizado de forma correcta, false en caso contrario
	 */
	boolean update(Curso curso);
	
	/**
	 * Servicio encargado  de añadir un registro en la BBDD
	 * @param curso POJO Curso
	 * @return true si se ha añadido de forma correcta, false en caso contrario
	 */
	boolean add(Curso curso);
	
	/**
	 * Servicio encargado de eliminar un registro de la BBDD
	 * @param idCurso identificador unico de Curso
	 * @return true si se ha eliminado de forma correcta, false en caso contrario
	 */
	boolean delete(int idCurso);
	
	/**
	 * Servicio encargador de comprobar si el Curso existe en la BBDD
	 * @param curso POJO Curso
	 * @return true si lo ha encontrado, false en caso contrario
	 */
	boolean cursoExiste(Curso curso) ;
	
	/**
	 * Servicio encargado de migrar un Excel a SQL
	 * @return POJO MigrationData
	 * @throws Exception FileNotFoundException
	 */
	MigrationData migrate() throws Exception;
}
