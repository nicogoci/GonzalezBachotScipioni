package com.tsti.smn.capaPresentacion.clima;

import java.util.Date;

import com.tsti.smn.pojos.Clima;
import com.tsti.smn.pojos.Pronostico;

public class ClimaForm {
	
	private long idClima;
	
	private Date fecha;
	
	private int temperatura;
	
	private String estado;
	
	private int porcentajeHumedad;
	
	private long idCiudad;
	
	
	public ClimaForm() {
		super();
	}
	
	public ClimaForm(Clima c) {
		super();
		this.idClima = c.getIdClima();
		this.fecha = c.getFecha();
		this.temperatura = c.getTemperatura();
		this.estado = c.getEstado();
		this.porcentajeHumedad = c.getPorcentajeHumedad();
		this.idCiudad = c.getCiudad().getId();
	}

	public long getIdClima() {
		return idClima;
	}

	public void setIdClima(long idClima) {
		this.idClima = idClima;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getPorcentajeHumedad() {
		return porcentajeHumedad;
	}

	public void setPorcentajeHumedad(int porcentajeHumedad) {
		this.porcentajeHumedad = porcentajeHumedad;
	}

	public long getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(long idCiudad) {
		this.idCiudad = idCiudad;
	}	
	
	public Clima toPojo()
	{
		Clima c = new Clima();
		c.setIdClima(this.idClima);
		c.setFecha(this.getFecha());
		c.setTemperatura(this.getTemperatura());
		c.setEstado(this.getEstado());
		c.setPorcentajeHumedad(this.getPorcentajeHumedad());
		return c;
	}

}
