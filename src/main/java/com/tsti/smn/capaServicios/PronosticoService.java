package com.tsti.smn.capaServicios;

import java.util.List;



import com.tsti.smn.capaPresentacion.pronostico.PronosticosBuscarForm;
import com.tsti.smn.pojos.Pronostico;


public interface PronosticoService {

	List<Pronostico> getAll();

	List<Pronostico> filter(PronosticosBuscarForm filter);

	void save(Pronostico pronostico);
	

	Pronostico getPronosticoById(Long idPronostico) throws Exception;

	void deletePronosticoByid(Long idPronostico);
}
