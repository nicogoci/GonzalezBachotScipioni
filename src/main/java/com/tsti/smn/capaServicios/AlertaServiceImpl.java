package com.tsti.smn.capaServicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsti.smn.capaDaos.IAlertaRepo;
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
	public void save(Alerta alerta) {
		repo.save(alerta);
		
	}

	@Override
	public Alerta getById(Long idAlerta) {
		return repo.findById(idAlerta).get();
	}
	
}
