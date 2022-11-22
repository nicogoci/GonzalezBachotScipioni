package com.tsti.smn.capaServicios;

import java.time.Instant;
import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsti.smn.capaDaos.IClimaRepo;
import com.tsti.smn.capaPresentacion.clima.ClimaBuscarForm;
import com.tsti.smn.pojos.Clima;


@Service
public class ClimaServiceImpl implements ClimaService{

	
	@Autowired
	IClimaRepo repo;
	
	@Override
	public Clima getClimaByCiudad(Long idCiudad) throws Exception {

		
		Clima c = repo.findByCiudadAndFecha(idCiudad, Date.from(Instant.now()));
		
		if(c!=null) {
			return c;
		} else {
			throw new Exception("No existe reporte");
		}
	}
	
	
	
	
	@Override
	public void save(Clima clima) {
		repo.save(clima);
		
	}
	
	@Override
	public Clima clima(ClimaBuscarForm clima) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Clima getClimaById(Long idClima) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	
	

}
