package com.tsti.smn.capaPresentacion.alerta;

import java.sql.Date;

public class AlertaBuscarForm {
	private Date fechaAlerta;
	private String ciudadAlerta;
	
	public Date getFechaAlerta() {
		return fechaAlerta;
	}
	public void setFechaAlerta(Date fechaAlerta) {
		this.fechaAlerta = fechaAlerta;
	}
	public String getCiudadAlerta() {
		return ciudadAlerta;
	}
	public void setCiudadAlerta(String ciudadAlerta) {
		this.ciudadAlerta = ciudadAlerta;
	}

}
