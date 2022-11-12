package com.tsti.smn.pojos;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Alerta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAlerta;

	@ManyToOne
	private Ciudad ciudad;
	
	private LocalDate fechaAlerta;
	
	private String descripcion;

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public LocalDate getFechaAlerta() {
		return fechaAlerta;
	}

	public void setFechaAlerta(LocalDate fechaHoy) {
		this.fechaAlerta = fechaHoy;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getidAlerta() {
		return idAlerta;
	}
	public void setidAlerta(Long idAlerta) {
		this.idAlerta = idAlerta;
	}


}
