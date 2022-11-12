package com.tsti.smn.capaServicios;

import java.util.List;

import com.tsti.smn.capaPresentacion.personas.PersonasBuscarForm;
import com.tsti.smn.pojos.Persona;

public interface PersonaService {

	

	List<Persona> getAll();
	
	List<Persona> filter(PersonasBuscarForm filter);

	/**
	 * Si la persona existe la actualizará, sino la creará en BD
	 * @param persona
	 */
	void save(Persona persona);

	/**
	 * permite obtener una persona determinada 
	 * @param idPersona identificador de la persona buscada
	 * @return persona encontrada o null si no encontr{o la persona
	 * @throws Exception ante un error
	 */
	Persona getPersonaById(Long idPersona) throws Exception;
	List<Persona> getPersonaByIdCiudad(Long idCiudad) throws Exception;

	void deletePersonaByid(Long id);

	
}
