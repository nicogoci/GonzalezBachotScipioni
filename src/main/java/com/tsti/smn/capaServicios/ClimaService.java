package com.tsti.smn.capaServicios;


import com.tsti.smn.capaPresentacion.clima.ClimaBuscarForm;
import com.tsti.smn.pojos.Clima;



public interface ClimaService {
	Clima clima (ClimaBuscarForm clima);//

	Clima getClimaById(Long idClima) throws Exception;//

	Clima getClimaByCiudad(Long idCiudad) throws Exception;

	void save(Clima clima);
}
