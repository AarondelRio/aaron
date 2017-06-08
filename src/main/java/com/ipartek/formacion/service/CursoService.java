package com.ipartek.formacion.service;

import java.io.FileNotFoundException;
import java.util.List;

import com.ipartek.formacion.domain.Curso;


public interface CursoService {
	
	List<Curso> getAll();
	
	Curso getById(int idCurso);
	
	List<Curso> getLast10();
	
	boolean update(Curso curso);
	
	boolean add(Curso curso);
	
	boolean delete(int idCurso);
	
	void migrate() throws Exception;
}
