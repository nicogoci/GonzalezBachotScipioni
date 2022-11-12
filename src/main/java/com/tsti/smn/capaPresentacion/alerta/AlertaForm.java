package com.tsti.smn.capaPresentacion.alerta;

import java.util.Date;

import com.tsti.smn.pojos.Alerta;
import com.tsti.smn.pojos.Ciudad;

public class AlertaForm {
	
	private Long idAlerta;
	
	private Ciudad ciudad;
	
	private Date fechaAlerta;
	
	private String descripcion;
	

	public AlertaForm() {
		super();
	}

	public AlertaForm(Alerta a) {
	super();
	
	this.idAlerta=a.getidAlerta();
	this.ciudad=a.getCiudad();
	this.fechaAlerta=a.getFechaAlerta();
	this.descripcion=a.getDescripcion();

	
	
	}
	public Long getIdAlerta() {
		return idAlerta;
	}


	public void setIdAlerta(Long idAlerta) {
		this.idAlerta = idAlerta;
	}


	public Ciudad getCiudad() {
		return ciudad;
	}


	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Date getFechaAlerta() {
		return fechaAlerta;
	}


	public void setFechaAlerta(Date fechaAlerta) {
		this.fechaAlerta = fechaAlerta;
	}
	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

		public Alerta toPojo() {
		Alerta a = new Alerta();
		a.setidAlerta(this.getIdAlerta());
		a.setCiudad(this.getCiudad());
		a.setFechaAlerta(this.getFechaAlerta());
		a.setDescripcion(this.getDescripcion());
		return a;
		}
}


