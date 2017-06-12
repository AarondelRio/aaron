package com.ipartek.formacion.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.domain.Curso;


/**
 * Mapper para el POJO Curso
 * @author Aaron
 *
 */
public class CursoMapper implements RowMapper<Curso> {

	@Override()
	public Curso mapRow(ResultSet resulSet, int rowNum) throws SQLException {
		Curso curso= new Curso();
		curso.setId(resulSet.getInt("id"));
		curso.setNombre(resulSet.getString("nombre"));
		curso.setCodigo(resulSet.getString("codigo"));
		return curso;
	}

}
