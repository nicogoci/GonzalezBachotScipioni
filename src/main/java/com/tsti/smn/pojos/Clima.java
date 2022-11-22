package com.tsti.smn.pojos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Clima {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idClima;
	
	private Date fecha;
	
	private int temperatura;
	
	private String estado;
	
	private int porcentajeHumedad;
	
	@ManyToOne
	private Ciudad ciudad;
	
	

	@Override
	public String toString() {
		return "Clima:  fecha=" + fecha + ", ciudad=" + ciudad +", temperatura=" + temperatura + ", estado="
				+ estado + ", porcentaje de humedad=" + porcentajeHumedad;
	}

	public long getIdClima() {
		return idClima;
	}

	public void setIdClima(long idClima) {
		this.idClima = idClima;
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

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}	 
	
	
}
