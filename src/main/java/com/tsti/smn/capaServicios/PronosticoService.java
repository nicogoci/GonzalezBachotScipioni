package com.tsti.smn.capaServicios;

import java.util.List;

import com.tsti.smn.capaPresentacion.pronostico.PronosticosBuscarForm;
import com.tsti.smn.pojos.Pronostico;


public interface PronosticoService {

	List<Pronostico> getAll();

	List<Pronostico> filter(PronosticosBuscarForm filter);

	/**
	 * Si la persona existe la actualizará, sino la creará en BD
	 * @param pronostico
	 */
	void save(Pronostico pronostico);
	
	/**
	 * permite obtener una persona determinada 
	 * @param idPronostico identificador de la persona buscada
	
	 * @throws Exception ante un error
	 */

	Pronostico getPronosticoById(Long idPronostico) throws Exception;

	void deletePronosticoByid(Long idPronostico);
}
