package com.ipartek.formacion.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.domain.Curso;
import com.ipartek.formacion.repository.mapper.CursoMapper;

@Repository(value = "cursoDAO")
public class CursoDAOImpl implements CursoDAO {

	@Autowired()
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;

	@Autowired()
	@Override()
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbctemplate = new JdbcTemplate(this.dataSource);

	}

	@Override
	public List<Curso> getAll() {
		List<Curso> cursos =  this.jdbctemplate.query(
				"SELECT `id`,  `nombre`, `codigo` FROM cursos ORDER BY `id` DESC;",
				new CursoMapper());
		return cursos;
	}
	
	@Override
	public List<Curso> getLast10() {
		List<Curso> usuarios =  this.jdbctemplate.query(
				"SELECT `id`,  `nombre`, `codigo` FROM cursos ORDER BY `id` DESC LIMIT 10;",
				new CursoMapper());
		return usuarios;
	}
	
	@Override
	public Curso getById(int idCurso) {
		Curso curso = this.jdbctemplate.queryForObject("SELECT `id`, `nombre`, `codigo` FROM `cursos` WHERE `id`= ?",
				new Object[] { idCurso }, new CursoMapper());
		return curso;
	}

	@Override
	public boolean update(Curso curso) {
		boolean modificado = false;
		int lineasModificadas = 0;
		lineasModificadas = this.jdbctemplate.update("UPDATE `cursos` SET `nombre`= ?, `codigo`= ? WHERE `id`= ?", curso.getNombre(),curso.getCodigo(), curso.getId());
		if (lineasModificadas != 0) {
			modificado = true;
		}
		return modificado;
	}

	@Override
	public boolean add(final Curso curso) {
		boolean insertado = false;
		int lineasInsertadas = 0;
		KeyHolder keyHolder = new GeneratedKeyHolder();
		lineasInsertadas = this.jdbctemplate.update(new PreparedStatementCreator() {
			@Override()
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement prepared = connection.prepareStatement("INSERT INTO `cursos` (`nombre`, `codigo`) VALUES (?,?)",
						Statement.RETURN_GENERATED_KEYS);
				prepared.setString(1, curso.getNombre());
				prepared.setString(2, curso.getCodigo());
				return prepared;
			}
		}, keyHolder);
		if (lineasInsertadas != 0) {
			insertado = true;
			curso.setId(keyHolder.getKey().intValue());
		}

		return insertado;
	}

	@Override
	public boolean delete(int idCurso) {
		boolean borrado = false;
		int lineasBorradas = 0;
		lineasBorradas = this.jdbctemplate.update("DELETE FROM `cursos` WHERE `id`= ? ;", idCurso);
		if (lineasBorradas != 0) {
			borrado = true;
		}
		return borrado;
	}

}
