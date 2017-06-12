package com.ipartek.formacion.service;

import java.io.FileReader;
import java.util.List;
import com.ipartek.formacion.domain.Curso;
import com.ipartek.formacion.domain.MigrationData;
import com.ipartek.formacion.repository.CursoDAO;

import au.com.bytecode.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Servicio para la gestion de cursos
 * @author Aaron
 *
 */
@Service(value="cursoService")
public class CursoServiceImpl implements CursoService {

	@Autowired() 
	private CursoDAO cursoDAO;
	@Override()
	public List<Curso> getAll() {
		return this.cursoDAO.getAll();
	}
	@Override()
	public List<Curso> autocomplete(String filtro) {
		return this.cursoDAO.autocomplete(filtro);
	}
	@Override()
	public boolean update(Curso curso) {
		return this.cursoDAO.update(curso);
	}
	@Override()
	public boolean add(Curso curso) {
		return this.cursoDAO.add(curso);
	}
	@Override()
	public boolean delete(int idCurso) {
		return this.cursoDAO.delete(idCurso);
	}
	@Override()
	public Curso getById(int idCurso) {
		return this.cursoDAO.getById(idCurso);
	}
	@Override()
	public List<Curso> getLast10() {
		return this.cursoDAO.getLast10();
	}
	@Override()
	public MigrationData migrate() throws Exception {
		MigrationData migDat = new MigrationData();
		int cont = 0;
		CSVReader reader = new CSVReader(new FileReader("c:\\cursos.csv"),';');
	     List<String[]> myEntries = reader.readAll();
	     for (String[] linea: myEntries) {
	    	 if(cont!=0){
		    	 Curso curso = new Curso();
		    	 curso.setNombre(linea[1]);
		    	 curso.setCodigo(linea[8]);
		    	 if(!"".equals(curso.getCodigo()) && !"".equals(curso.getNombre())){
		    		 if(!this.cursoDAO.cursoExiste(curso)){
			    		 this.cursoDAO.add(curso);
			    		 migDat.addCursosInsertados();
		    		 }else{
		    			migDat.addCursosExistian();
		    		 }		    	 
		    	 }else{
		    		 migDat.addCursosIncompletos();
		    	 }
	    	 }
	    	 cont++;
		}
	     reader.close();
	     return migDat;
	}
	@Override()
	public boolean cursoExiste(Curso curso) {
		return this.cursoDAO.cursoExiste(curso);
	}

}
