package com.tsti.smn.capaPresentacion.personas;

public class PersonasBuscarForm {
//	@NotNull
	private Long dni;
	private String nombre;
	private Long IdCiudadSeleccionada;
	
	

	public Long getDni() {
		if(dni!=null && dni>0)
			return dni;
		else
			return null;
	}
	public Long getIdCiudadSeleccionada() {
		return IdCiudadSeleccionada;
	}
	public void setIdCiudadSeleccionada(Long idCiudadSeleccionada) {
		IdCiudadSeleccionada = idCiudadSeleccionada;
	}
	public void setDni(Long dni) {
		this.dni = dni;
	}
	public String getNombre() {
		if(nombre!=null && nombre.length()>0)
			return nombre;
		else
			return null;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	

}
