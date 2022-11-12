package com.tsti.smn.capaServicios;

import java.util.List;

import com.tsti.smn.pojos.Alerta;
import com.tsti.smn.capaPresentacion.alerta.AlertaBuscarForm;

public interface AlertaService {
	List<Alerta> getAll();
	
	Alerta getByCiudad(String ciudad) throws Exception ;
	
	List<Alerta> filter(AlertaBuscarForm filter);
	
	void save(Alerta alerta);

}