package com.tsti.smn.capaPresentacion.clima;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import com.tsti.smn.pojos.Clima;


public class ClimaForm {
	
	
	private Long idClima;
	
	private LocalDate fecha;
	
	
	@NotNull (message = "Debe ingresar La temperatura")
	private int temperatura;
	
	@NotNull (message = "Debe ingresar el estado del clima")
	private Long idEstado;
	
	@NotNull (message = "Debe ingresar el porcentaje de humedad")
	@Min(value=0, message = "El porcentaje de humedad debe ser mayor o igual a 0")
	@Max(value=100, message = "El porcentaje de humedad debe menor a 100")
	private int porcentajeHumedad;
	
	@NotNull (message = "Debe ingresar una ciudad")
	private Long idCiudad;
	
	
	public ClimaForm() {
		super();
	}
	
	public ClimaForm(Clima c) {
		super();
		this.idClima = c.getIdClima();
		this.fecha = LocalDate.now();
		this.temperatura = c.getTemperatura();
		this.idEstado = c.getEstado().getId();
		this.porcentajeHumedad = c.getPorcentajeHumedad();
		this.idCiudad = c.getCiudad().getId();
	}

	public Long getIdClima() {
		return idClima;
	}

	public void setIdClima(Long idClima) {
		this.idClima = idClima;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}

	public Long getEstado() {
		return idEstado;
	}

	public void setEstado(Long estado) {
		this.idEstado = estado;
	}

	public int getPorcentajeHumedad() {
		return porcentajeHumedad;
	}

	public void setPorcentajeHumedad(int porcentajeHumedad) {
		this.porcentajeHumedad = porcentajeHumedad;
	}

	public Long getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}	
	
	public Clima toPojo()
	{
		Clima c = new Clima();
		c.setIdClima(this.idClima);
		c.setFecha(LocalDate.now());
		c.setTemperatura(this.getTemperatura());
		c.setPorcentajeHumedad(this.getPorcentajeHumedad());
		return c;
	}

}
