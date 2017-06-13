package com.ipartek.formacion.controller;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.formacion.domain.Curso;
import com.ipartek.formacion.domain.Message;
import com.ipartek.formacion.domain.MigrationData;
import com.ipartek.formacion.service.CursoService;

/**
 * Controlador para Cursos
 * @author Aaron
 *
 */
@Controller()
public class CursoController {

	@Autowired()
	private CursoService cursoService;
	
	private Message msg;

	/**
	 * Controlador encargado de devolver los ultimos 10 Cursos
	 * @param model cursos, ultimos 10 cursos
	 * @return view home.jsp
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("cursos", this.cursoService.getLast10());
		return "home";
	}
	
	/**
	 * Controlador encargado de devolver todos los Cursos a la parte de gestion de Cursos
	 * @param model cursos, todos los cursos
	 * @return view admin/index.jsp
	 */
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(Model model) {
		model.addAttribute("cursos", this.cursoService.getAll());
		return "admin/index";
	}
	
	/**
	 * Controlador encargado de consultar un Curso
	 * @param idCurso identificador unico del Curso a consultar, -1 si el Curso es nuevo
	 * @param model curso, curso
	 * @return view admin/detalle.jsp
	 */
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
	
	/**
	 * Controlador encargado de Crear un Curso Nuevo
	 * @param curso POJO Curso
	 * @param model cursos, todos los cursos. msg, mensaje
	 * @return view admin/index.jsp
	 */
	@RequestMapping(value = "/admin/crear", method = RequestMethod.POST)
	public String crear(Curso curso, Model model) {
		try{
			this.msg = new Message();
			if(!this.cursoService.cursoExiste(curso)){
				if(this.cursoService.add(curso)){		
					this.msg.setType("success");
					this.msg.buildMsg("El curso se ha a�adido correctamente");
				}
			}else{
				this.msg.setType("warning");
				this.msg.buildMsg("El curso ya existe");
			}
		} catch (Exception e) {
			this.msg.setType("danger");
			this.msg.setMsg("La aplicacion ha fallado en servidor, pongase en contacto con el administrador");
		}
		model.addAttribute("msg", this.msg);
		model.addAttribute("cursos", this.cursoService.getAll());
		return "admin/index";
	}

	/**
	 * Controlador encargado de modificar un Curso
	 * @param curso POJO Curso
	 * @param model cursos, todos los cursos. msg, mensaje
	 * @return view admin/index.jsp
	 */
	@RequestMapping(value = "/admin/modificar", method = RequestMethod.POST)
	public String modificar(Curso curso, Model model) {
		try{
			this.msg = new Message();
			if(!this.cursoService.cursoExiste(curso)){
				if(this.cursoService.update(curso)){		
					this.msg.setType("success");
					this.msg.buildMsg("El curso se ha modifcado correctamente");
				}
			}else{
				this.msg.setType("warning");
				this.msg.buildMsg("El curso ya existe");
			}
		} catch (Exception e) {
			this.msg.setType("danger");
			this.msg.setMsg("La aplicacion ha fallado en servidor, pongase en contacto con el administrador");
		}
		model.addAttribute("msg", this.msg);
		model.addAttribute("cursos", this.cursoService.getAll());
		return "admin/index";
	}

	/**
	 * Controlador encargado de eliminar un Curso
	 * @param idCurso identificador unico de Curso
	 * @param model cursos, todos los cursos. msg, mensajes
	 * @return view admin/index.jsp
	 */
	@RequestMapping(value = "/admin/eliminar/{idCurso}", method = RequestMethod.GET)
	public String eliminar(@PathVariable() int idCurso, Model model) {
		try{
			this.msg = new Message();
			if(this.cursoService.delete(idCurso)){		
				this.msg.setType("success");
				this.msg.buildMsg("El curso se ha eliminado correctamente");
			}else{
				this.msg.setType("warning");
				this.msg.buildMsg("El curso no se ha eliminado correctamente");
			}
		} catch (Exception e) {
			this.msg.setType("danger");
			this.msg.setMsg("La aplicacion ha fallado en servidor, pongase en contacto con el administrador");
		}
		model.addAttribute("msg", this.msg);
		model.addAttribute("cursos", this.cursoService.getAll());
		return "admin/index";
	}
	
	/**
	 * Controlador encargado de migrar un Excel a SQL
	 * @param model cursos, todos los cursos. msg, mensaje
	 * @return admin/index.jsp
	 */
	@RequestMapping(value = "/admin/migrate", method = RequestMethod.GET)
	public String migrate(Model model) {
		try {
			this.msg = new Message();	
			MigrationData migDat = this.cursoService.migrate();			
			this.msg.setType("success");
			this.msg.buildMsg("Se han insertado " + migDat.getCursosInsertados() + " Cursos, ");
			this.msg.buildMsg(migDat.getCursosExistian() + " Cursos ya existian");
			this.msg.buildMsg(" y " + migDat.getCursosIncompletos() + " Cursos estaban incompletos");
		} catch (FileNotFoundException e) {
			this.msg.setType("danger");
			this.msg.setMsg("El archivo no se encuentra en C: con el nombre cursos.csv");
		} catch (Exception e) {
			this.msg.setType("danger");
			this.msg.setMsg("La aplicacion ha fallado en servidor, pongase en contacto con el administrador");
		}
		model.addAttribute("msg", this.msg);
		model.addAttribute("cursos", this.cursoService.getAll());
		return "admin/index";
	}
}

