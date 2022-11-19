package com.tsti.smn.capaServicios;

import java.util.List;



import com.tsti.smn.capaPresentacion.pronostico.PronosticosBuscarForm;
import com.tsti.smn.pojos.Pronostico;


public interface PronosticoService {

	List<Pronostico> filter(PronosticosBuscarForm filter);

	void save(Pronostico p);

	Pronostico getById(Long idPronostico);
	
	Pronostico findByCiudadIdAndFechaPronostico(Long idCiudadSeleccionada, java.util.Date fecha);
	

}
