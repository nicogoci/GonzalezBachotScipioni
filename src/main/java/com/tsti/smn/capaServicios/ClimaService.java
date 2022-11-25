package com.tsti.smn.capaServicios;


import com.tsti.smn.pojos.Clima;


public interface ClimaService {
	

	Clima getClimaById(Long idClima) throws Exception;

	Clima getClimaByCiudad(Long idCiudad) throws Exception;

	void save(Clima clima);
	
	void saveOrUpdate(Clima clima);
}
