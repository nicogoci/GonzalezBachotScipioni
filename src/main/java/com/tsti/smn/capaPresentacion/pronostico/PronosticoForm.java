package com.tsti.smn.capaPresentacion.pronostico;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.tsti.smn.pojos.Persona;
import com.tsti.smn.pojos.Pronostico;

public class PronosticoForm {

	private Long idPronostico;
	@NotNull
	
	private Long idCiudad;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaPronostico;
	
	private int porcentajeLLuvia;
	
	private int cantidadLLuvia;
	
	private String descripcion;


	public PronosticoForm() {
		super();
	}
	
	
	public PronosticoForm(Pronostico p) {
		super();
		this.idPronostico=p.getIdPronostico();
		this.porcentajeLLuvia=p.getPorcentajeLluvia();
		this.cantidadLLuvia=p.getCantidadLLuvia();
		this.idCiudad=p.getCiudad().getId();
		this.fechaPronostico=p.getFechaPronostico();
		this.descripcion=p.getDescripcion();
	}

	public Long getIdPronostico() {
		return idPronostico;
	}


	public void setIdPronostico(Long idPronostico) {
		this.idPronostico = idPronostico;
	}


	public Long getIdCiudad() {
		return idCiudad;
	}


	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}


	public int getPorcentajeLLuvia() {
		return porcentajeLLuvia;
	}


	public void setPorcentajeLLuvia(int porcentajeLLuvia) {
		this.porcentajeLLuvia = porcentajeLLuvia;
	}


	public int getCantidadLLuvia() {
		return cantidadLLuvia;
	}


	public void setCantidadLLuvia(int cantidadLLuvia) {
		this.cantidadLLuvia = cantidadLLuvia;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Pronostico toPojo()
	{
		Pronostico p = new Pronostico();
		p.setIdPronostico(this.getIdPronostico());
		p.setDescripcion(this.getDescripcion());
		p.setCantidadLLuvia(this.getCantidadLLuvia());
		p.setPorcentajeLluvia(this.getPorcentajeLLuvia());
		p.setFechaPronostico(this.getFechaPronostico());
		
		return p;
	}
	public Date getFechaPronostico() {
		return fechaPronostico;
	}
	public void setFechaPronostico(Date fechaPronostico) {
		this.fechaPronostico = fechaPronostico;
	}
	
}
