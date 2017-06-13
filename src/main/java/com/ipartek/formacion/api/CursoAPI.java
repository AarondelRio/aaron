package com.ipartek.formacion.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ipartek.formacion.domain.Curso;
import com.ipartek.formacion.service.CursoService;


/**
 * Controlador encargado de gestionar el servicio REST
 * @author Aaron
 *
 */
@Controller()
@RequestMapping(value = "/api/")
public class CursoAPI {

	@Autowired()
	private CursoService cursoService;

//	@RequestMapping(value = "", method = RequestMethod.GET)
//	public ResponseEntity<List<Curso>> listar() {
//
//		ResponseEntity<List<Curso>> response = null;
//		List<Curso> cursos = null;
//
//		try {
//			cursos = (List<Curso>) this.cursoService.getLast10();
//			
//			if (cursos != null) {
//				if (cursos.isEmpty()) {
//					response = new ResponseEntity<List<Curso>>(HttpStatus.NO_CONTENT);
//				} else {
//					response = new ResponseEntity<List<Curso>>(cursos, HttpStatus.OK);
//				}
//			}
//		} catch (Exception e) {
//			response = new ResponseEntity<List<Curso>>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		return response;
//	}
	
	/**
	 * Controlador que devuelve los cursos que contienen el parametro de busqueda
	 * @param filtro parametro de busqueda
	 * @return JSON de cursos
	 */
	@RequestMapping(value="cursos", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Curso> autocomplete(@RequestParam(value = "filtro", required = false) String filtro){

		List<Curso> cursos = null;
		if (filtro != null){
			cursos = this.cursoService.autocomplete(filtro);
		} else {
			cursos = this.cursoService.getAll();
		}
		return cursos;
	}

	
}
