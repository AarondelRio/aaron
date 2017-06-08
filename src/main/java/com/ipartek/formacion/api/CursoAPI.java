package com.ipartek.formacion.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ipartek.formacion.domain.Curso;
import com.ipartek.formacion.service.CursoService;



@Controller
@RequestMapping(value = "/api/")
public class CursoAPI {

	@Autowired
	CursoService cursoService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<Curso>> listar() {

		ResponseEntity<List<Curso>> response = null;
		List<Curso> cursos = null;

		try {
			cursos = (List<Curso>) this.cursoService.getLast10();
			
			if (cursos != null) {
				if (cursos.isEmpty()) {
					response = new ResponseEntity<List<Curso>>(HttpStatus.NO_CONTENT);
				} else {
					response = new ResponseEntity<List<Curso>>(cursos, HttpStatus.OK);
				}
			}
		} catch (Exception e) {
			response = new ResponseEntity<List<Curso>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	@RequestMapping(value="", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> autocomplete(@RequestParam(value = "filtro", required = true) String filtro)
	{

		List<Curso> cursos = null;
		if (filtro != null){
			cursos = null;
		} 
		return cursos;
	}

	
}
