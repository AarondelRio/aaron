package com.ipartek.formacion.domain;

public class Message {
	private String type;
	private String msg;
	public Message() {
		super();
		this.type = "default";
		this.msg = "";
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void buildMsg(String msg){
		if ("".equals(this.msg)){
			this.msg = msg;
		}else{
			this.msg = this.msg + msg;
		}
	}
	@Override
	public String toString() {
		return "Message [type=" + type + ", msg=" + msg + "]";
	}
	
	
}
