package com.tsti.smn.capaPresentacion.ciudades;

import com.tsti.smn.pojos.Ciudad;

/**
 * Objeto necesario para insertar o eliminar una persona. 
 * Nótese que en lugar de referenciar al objeto Ciudad, reemplaza ese atributo por el idCiudad, lo cual resulta mas sencillo de representar en JSON
 *
 */
public class CiudadForm {

	private Long id;

//	@NotNull
//	@Size(min=2, max=30)
	private String nombre;
//	@NotNull
	private Long idProvincia;
	
	
	public CiudadForm() {
		super();
	}
	public CiudadForm(Ciudad c) {
		super();
		this.id=c.getId();
		this.nombre=c.getNombre();
		this.idProvincia=c.getProvincia().getId();
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public Long getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(Long idProvincia) {
		this.idProvincia = idProvincia;
	}
	public Ciudad toPojo()
	{
		Ciudad c = new Ciudad();
		c.setId(this.id);
		c.setNombre(this.getNombre());
		return c;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
