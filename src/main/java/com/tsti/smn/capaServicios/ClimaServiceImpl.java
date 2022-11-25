package com.tsti.smn.capaServicios;


import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tsti.smn.capaDaos.IClimaRepo;
import com.tsti.smn.pojos.Clima;


@Service
public class ClimaServiceImpl implements ClimaService{

	
	@Autowired
	IClimaRepo repo;
	
	@Override
	public Clima getClimaByCiudad(Long idCiudad) throws Exception {
		Clima c = repo.findByCiudadAndFecha(idCiudad, LocalDate.now());
		
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
	public Clima getClimaById(Long idClima) throws Exception {
		if(repo.findById(idClima).isPresent())
		return repo.findById(idClima).get();
		else {
			throw new Exception ("El registro no existe");
		}
	}



	@Override
	public void saveOrUpdate(Clima clima) {		
		
		if (repo.findByCiudadAndFecha(clima.getCiudad().getId(), clima.getFecha()) != null) {
			repo.updateClima(clima.getTemperatura(), clima.getEstado().getId(), clima.getPorcentajeHumedad(), clima.getFecha(), clima.getCiudad().getId());
		}else {
			save(clima);
		}
	}



	
	

}
