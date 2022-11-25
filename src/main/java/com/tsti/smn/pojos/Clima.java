package com.tsti.smn.pojos;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Clima {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClima;
	
	@Column(nullable=false)
	private LocalDate fecha;
	
	@Column(nullable=false)
	private int temperatura;
	
	
	@ManyToOne
	private Estado estado;
	
	@Column(nullable=false)
	private int porcentajeHumedad;
	

	@ManyToOne
	private Ciudad ciudad;
	
	

	@Override
	public String toString() {
		return "Clima:  fecha=" + fecha + ", ciudad=" + ciudad.getNombre() +", temperatura=" + temperatura + ", estado="
				+ estado.getNombre() + ", porcentaje de humedad=" + porcentajeHumedad;
	}

	public Long getIdClima() {
		return idClima;
	}

	public void setIdClima(Long idClima) {
		this.idClima = idClima;
	}

	public int getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}


	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
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

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	
}
