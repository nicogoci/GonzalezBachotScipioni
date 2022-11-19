package com.tsti.smn.capaPresentacion.pronostico;

import java.util.Date;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.tsti.smn.pojos.Pronostico;

public class PronosticoForm {


	private Long idPronostico;
	
	@NotNull(message = "Debe ingresar una ciudad")
	private Long idCiudad;
	
	@NotNull(message = "Debe ingresar una fecha")
	@Future(message = "Debe ingresar una fecha posterior al día de hoy")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaPronostico;
	
	@NotNull(message = "Debe ingresar un porcentaje de lluvia")
	@Min(value=0, message = "el porcentaje de lluvia debe ser mayor o igual a 0 y menor a 100")
	@Max(value=100, message = "el porcentaje de lluvia debe ser mayor o igual a 0 y menor a 100")
	private int porcentajeLluvia;
	
	@NotNull(message = "Debe ingresar la cantidad de lluvia")
	@Min(value=0, message = "La cantidad de lluvia debe ser mayor o igual a 0")
	private int cantidadLluvia;
	
	@NotNull(message = "Debe ingresar una descripcion")
	@NotBlank(message = "Debe ingresar una descripcion!!")
	@Size(min=0, max=500 , message = "No debe superar los 500 caracteres")
	private String descripcion;


	public PronosticoForm() {
		super();
	}
	
	
	public PronosticoForm(Pronostico p) {
		super();
		this.idPronostico=p.getIdPronostico();
		this.porcentajeLluvia=p.getPorcentajeLluvia();
		this.cantidadLluvia=p.getCantidadLluvia();
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


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Pronostico toPojo()
	{
		Pronostico p = new Pronostico();
		p.setIdPronostico(this.idPronostico);
		p.setDescripcion(this.getDescripcion());
		p.setCantidadLluvia(this.getCantidadLluvia());
		p.setPorcentajeLluvia(this.getPorcentajeLluvia());
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
