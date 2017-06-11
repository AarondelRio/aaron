package com.ipartek.formacion.domain;

public class MigrationData {
	int cursosInsertados;
	int cursosExistian;
	int cursosIncompletos;
	public MigrationData() {
		super();
		this.cursosInsertados = 0;
		this.cursosExistian = 0;
		this.cursosIncompletos = 0;
	}
	public int getCursosInsertados() {
		return cursosInsertados;
	}
	public void addCursosInsertados() {
		this.cursosInsertados++;
	}
	public void setCursosInsertados(int cursosInsertados) {
		this.cursosInsertados = cursosInsertados;
	}
	public int getCursosExistian() {
		return cursosExistian;
	}
	public void addCursosExistian() {
		this.cursosExistian++;
	}
	public void setCursosExistian(int cursosExistian) {
		this.cursosExistian = cursosExistian;
	}
	public int getCursosIncompletos() {
		return cursosIncompletos;
	}
	public void addCursosIncompletos() {
		this.cursosIncompletos++;
	}
	public void setCursosIncompletos(int cursosIncompletos) {
		this.cursosIncompletos = cursosIncompletos;
	}
	@Override
	public String toString() {
		return "Migrate [cursosInsertados=" + cursosInsertados + ", cursosExistian=" + cursosExistian
				+ ", cursosIncompletos=" + cursosIncompletos + "]";
	}
	
}
