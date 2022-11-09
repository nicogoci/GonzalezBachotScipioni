package com.tsti.smn.capaPresentacion.pronostico;

import java.sql.Date;

public class PronosticosBuscarForm {
	private Date fechaPronostico;
	private Long IdCiudadSeleccionada;
	
	
	public Date getFechaPronostico() {
		return fechaPronostico;
	}
	public void setFechaPronostico(Date fechaPronostico) {
		this.fechaPronostico = fechaPronostico;
	}
	public Long getIdCiudadSeleccionada() {
		return IdCiudadSeleccionada;
	}
	public void setIdCiudadSeleccionada(Long idCiudadSeleccionada) {
		IdCiudadSeleccionada = idCiudadSeleccionada;
	}
	
	
}
