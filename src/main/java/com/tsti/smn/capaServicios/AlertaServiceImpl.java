package com.tsti.smn.capaServicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsti.smn.capaDaos.IAlertaRepo;
import com.tsti.smn.capaPresentacion.alerta.AlertaBuscarForm;
import com.tsti.smn.pojos.Alerta;

@Service
public class AlertaServiceImpl implements AlertaService {
	
	@Autowired
	IAlertaRepo repo;

	@Override
	public List<Alerta> getAll() {
		return repo.findAll();
	}

	@Override
	public Alerta getByCiudad(String ciudad) throws Exception {

		
		Optional<Alerta> p = repo.findBy(ciudad);
		
		if(p!=null) {
			return p.get();
		} else {
			throw new Exception("No hay alertas extremas para "+ciudad);
		}

	}

	@Override
	public List<Alerta> filter(AlertaBuscarForm filter) {
		if(filter.getFechaAlerta()==null )
			return repo.findAll();
		else
			return repo.findByCiudadOrFechaAlerta(filter.getCiudadAlerta(), filter.getFechaAlerta());
	}

	@Override
	public void save(Alerta alerta) {
		repo.save(alerta);
		
	}
	
}
