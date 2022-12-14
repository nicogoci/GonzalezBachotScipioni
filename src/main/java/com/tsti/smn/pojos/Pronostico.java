package com.tsti.smn.pojos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pronostico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPronostico;
	
	@ManyToOne
	private Ciudad ciudad;
		
	private Date fechaPronostico;
	
	private String descripcion;
	
	private int porcentajeLluvia;
	
	private int cantidadLluvia;
	

	@Override
	public String toString() {
		return "Pronostico [idPronostico=" + idPronostico + ", ciudad=" + ciudad + ", fechaPronostico="
				+ fechaPronostico + ", descripcion=" + descripcion + ", porcentajeLluvia=" + porcentajeLluvia
				+ ", cantidadLLuvia=" + cantidadLluvia + "]";
	}

	public Long getIdPronostico() {
		return idPronostico;
	}

	public void setIdPronostico(Long idPronostico) {
		this.idPronostico = idPronostico;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Date getFechaPronostico() {
		return fechaPronostico;
	}

	public void setFechaPronostico(Date fechaPronostico) {
		this.fechaPronostico = fechaPronostico;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPorcentajeLluvia() {
		return porcentajeLluvia;
	}

	public void setPorcentajeLluvia(int porcentajeLluvia) {
		this.porcentajeLluvia = porcentajeLluvia;
	}

	public int getCantidadLluvia() {
		return cantidadLluvia;
	}

	public void setCantidadLluvia(int cantidadLluvia) {
		this.cantidadLluvia = cantidadLluvia;
	}
	
	
	
	
}
