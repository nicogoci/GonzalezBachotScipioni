package com.tsti.smn.capaPresentacion.alerta;

import java.util.Date;

import com.tsti.smn.pojos.Alerta;
import com.tsti.smn.pojos.Ciudad;

public class AlertaForm {
	
	private Long idAlerta;
	
	private Long idCiudad;
	
	private String fechaAlerta;
	
	private String descripcion;
	

	public AlertaForm() {
		super();
	}

	public AlertaForm(Alerta a) {
	
		super();
	
		this.idAlerta=a.getidAlerta();
		this.idCiudad=a.getCiudad().getId();
		this.descripcion=a.getDescripcion();

	
	
	}
	public Long getIdAlerta() {
		return idAlerta;
	}


	public void setIdAlerta(Long idAlerta) {
		this.idAlerta = idAlerta;
	}


	public Long getidCiudad() {
		return idCiudad;
	}


	public void setidCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getFechaAlerta() {
		return fechaAlerta;
	}


	public void setFechaAlerta(String fechaAlerta) {
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
			a.setDescripcion(this.getDescripcion());
			return a;
		}
}


