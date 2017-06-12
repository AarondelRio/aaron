package com.ipartek.formacion.domain;
/**
 * POJO para la gestion de mensajes
 * @author Curso
 *
 */
public class Message {
	private String type;
	private String msg;
	
	/**
	 * Constructor por defecto
	 */
	public Message() {
		super();
		this.type = "default";
		this.msg = "";
	}
	
	/**
	 * Getter
	 * @return tipo de mensaje, danger, succes, warning, info
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Setter
	 * @param type  tipo de mensaje, danger, succes, warning, info
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Getter
	 * @return msg, texto del mensaje
	 */
	public String getMsg() {
		return this.msg;
	}
	
	/**
	 * Setter
	 * @param msg msg, texto del mensaje
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	/**
	 * Construye un mensaje, guardando lo anteriormente seteado
	 * @param msg msg, texto del mensaje
	 */
	public void buildMsg(String msg){
		if ("".equals(this.msg)){
			this.msg = msg;
		}else{
			this.msg = this.msg + msg;
		}
	}
	@Override()
	public String toString() {
		return "Message [type=" + this.type + ", msg=" + this.msg + "]";
	}
	
	
}
