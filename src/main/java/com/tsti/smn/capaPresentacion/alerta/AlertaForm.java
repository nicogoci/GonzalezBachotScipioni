package com.tsti.smn.capaPresentacion.alerta;

import com.tsti.smn.pojos.Alerta;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AlertaForm {

	private Long idAlerta;
	
	@NotNull(message="La ciudad no puede ser nula")
	private Long idCiudad;
	@NotNull(message="Debe ingresar el dia de la alerta")	
	private String fechaAlerta;
	@NotNull(message="Debe ingresar una descripción para la alerta")
	@Size(min=10, max=500, message="La descripción debe tener entre 10 y 500 caracteres")
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


