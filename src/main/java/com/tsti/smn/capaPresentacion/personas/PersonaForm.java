package com.tsti.smn.capaPresentacion.personas;

import java.util.Date;



import org.springframework.format.annotation.DateTimeFormat;

import com.tsti.smn.pojos.Persona;

/**
 * Objeto necesario para insertar o eliminar una persona. 
 * Nótese que en lugar de referenciar al objeto Ciudad, reemplaza ese atributo por el idCiudad, lo cual resulta mas sencillo de representar en JSON
 *
 */
public class PersonaForm {

//	@NotNull(message = "el dni no puede ser nulo")
//	@Min(value = 7000000, message = "el dni debe ser mayor a 7000000")
	private Long dni;
//	@NotNull
//	@Size(min=2, max=30)
	private String apellido;
//	@NotNull
//	@Size(min=2, max=30)
	private String nombre;
//	@NotNull
	private Long idCiudad;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaNacimiento;
//	@NotNull
//	@size(min=8, max=30)
	private String mail;
	
	public PersonaForm() {
		super();
	}
	public PersonaForm(Persona p) {
		super();
		this.nombre=p.getNombre();
		this.apellido=p.getApellido();
		this.dni=p.getDni();
		this.idCiudad=p.getCiudad().getId();
		this.fechaNacimiento=p.getFechaNacimiento();
		this.mail=p.getMail();
	}
	public Long getDni() {
		return dni;
	}
	public void setDni(Long dni) {
		this.dni = dni;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Persona toPojo()
	{
		Persona p = new Persona();
		p.setDni(this.getDni());
		p.setApellido(this.getApellido());
		p.setNombre(this.getNombre());
		p.setDni(this.getDni());
		p.setFechaNacimiento(this.getFechaNacimiento());
		p.setMail(this.getMail());
		return p;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
}
