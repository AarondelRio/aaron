package com.ipartek.formacion.service;

import java.io.FileNotFoundException;
import java.util.List;

import com.ipartek.formacion.domain.Curso;


public interface CursoService {
	
	List<Curso> getAll();
	
	List<Curso> autocomplete(String filtro);
	
	List<Curso> getLast10();
	
	Curso getById(int idCurso);	
	
	boolean update(Curso curso);
	
	boolean add(Curso curso);
	
	boolean delete(int idCurso);
	
	void migrate() throws Exception;
}
