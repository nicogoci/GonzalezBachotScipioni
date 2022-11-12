package com.tsti.smn.capaServicios;

import java.util.List;

import com.tsti.smn.pojos.Alerta;

public interface AlertaService {
	List<Alerta> getAll();
	
	void save(Alerta alerta);

	Alerta getById(Long idAlerta);

}