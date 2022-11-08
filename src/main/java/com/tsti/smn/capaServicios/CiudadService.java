package com.tsti.smn.capaServicios;


import java.util.List;

import com.tsti.smn.capaPresentacion.ciudades.CiudadesBuscarForm;
import com.tsti.smn.pojos.Ciudad;
/**
 * Clase que permite gestionar la entidad Ciudad en el sistema.
 * @author kuttel
 * @version 1.0
 */

public interface CiudadService {

	

	/**
	 * Obtiene la lista completa de ciudades
	 * @return Todas las ciudades
	 */
	List<Ciudad> getAll();
	
	/**
	 * Obtiene una ciudad determinada
	 * @param idCiudad Identificador de la ciudad buscada
	 * @return Ciudad encontrada
	 */
	Ciudad getById(Long idCiudad) ;
	
	List<Ciudad> filter(CiudadesBuscarForm filter);

	void deleteByid(Long id);

	void save(Ciudad c);

}
