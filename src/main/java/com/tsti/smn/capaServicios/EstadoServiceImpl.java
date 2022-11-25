package com.tsti.smn.capaServicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsti.smn.capaDaos.IEstadoRepo;
import com.tsti.smn.pojos.Estado;
@Service
public class EstadoServiceImpl implements EstadoService {
	@Autowired
	private IEstadoRepo repo;

	@Override
	public List<Estado> findAll() {
		List<Estado> estados = repo.findAll();
		return estados;
	}
	
	@Override
	public Estado getById(Long id) throws Exception {
		if (repo.findById(id).isPresent())
			return repo.findById(id).get();
		else 
			throw new Exception ("No se encontro el estado");
	}

}
