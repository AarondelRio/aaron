package com.ipartek.formacion.service;

import java.util.List;

import com.ipartek.formacion.domain.Curso;
import com.ipartek.formacion.domain.MigrationData;


public interface CursoService {
	
	List<Curso> getAll();
	
	List<Curso> autocomplete(String filtro);
	
	List<Curso> getLast10();
	
	Curso getById(int idCurso);	
	
	boolean update(Curso curso);
	
	boolean add(Curso curso);
	
	boolean delete(int idCurso);
	
	boolean cursoExiste(Curso curso) ;
	
	MigrationData migrate() throws Exception;
}
