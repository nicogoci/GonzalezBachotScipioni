package com.tsti.smn.excepciones;

public class Excepcion extends Exception{

	private static final long serialVersionUID = 1L;
	
	private String atributo;

	
	
	public Excepcion() {
		super();
	}

	
	public Excepcion(String mensaje) {
		super(mensaje);
		
	}


	public Excepcion(String atributo, String mensaje) {
		super(mensaje);
		this.atributo = atributo;
	}


	public String getAtributo() {
		return atributo;
	}


	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}
	
	
}
