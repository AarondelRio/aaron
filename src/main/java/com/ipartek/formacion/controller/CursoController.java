package com.ipartek.formacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.formacion.domain.Curso;
import com.ipartek.formacion.service.CursoService;


@Controller()
public class CursoController {

	@Autowired()
	private CursoService cursoService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("cursos", this.cursoService.getLast10());
		return "home";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(Model model) {
		model.addAttribute("cursos", this.cursoService.getAll());
		return "admin/index";
	}
	
	@RequestMapping(value = "/admin/consultar/{idCurso}", method = RequestMethod.GET)
	public String consultar(@PathVariable() int idCurso, Model model) {
		if(idCurso!=-1){
			model.addAttribute("curso", this.cursoService.getById(idCurso));
		}else{
			Curso curso = new Curso();
			model.addAttribute("curso", curso);
		}
		return "admin/detalle";
	}
	
	
	@RequestMapping(value = "/admin/crear", method = RequestMethod.POST)
	public String crear(Curso curso, Model model) {
		this.cursoService.add(curso);
		model.addAttribute("cursos", this.cursoService.getAll());
		return "admin/index";
	}

	@RequestMapping(value = "/admin/modificar", method = RequestMethod.POST)
	public String modificar(Curso curso, Model model) {
		this.cursoService.update(curso);
		model.addAttribute("cursos", this.cursoService.getAll());
		return "admin/index";
	}


	@RequestMapping(value = "/admin/eliminar/{idCurso}", method = RequestMethod.GET)
	public String eliminar(@PathVariable() int idCurso, Model model) {
		this.cursoService.delete(idCurso);
		model.addAttribute("cursos", this.cursoService.getAll());
		return "admin/index";
	}
	
	@RequestMapping(value = "/admin/migrate", method = RequestMethod.GET)
	public String migrate(Model model) {
		try {
			this.cursoService.migrate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("cursos", this.cursoService.getAll());
		return "admin/index";
	}
}

