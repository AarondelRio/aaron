package com.ipartek.formacion.repository;

import java.util.List;

import javax.sql.DataSource;

import com.ipartek.formacion.domain.Curso;

public interface CursoDAO {
	
	void setDataSource(DataSource dataSource);
	
	List<Curso> getAll();
	
	List<Curso> autocomplete(String filtro);
	
	List<Curso> getLast10();
	
	Curso getById(int idCurso);

	boolean update(Curso curso);
	
	boolean add(Curso curso);
	
	boolean delete(int idCurso);
	
	
}
