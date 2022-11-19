package com.tsti.smn.capaServicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsti.smn.capaDaos.IPronosticoRepo;
import com.tsti.smn.capaPresentacion.pronostico.PronosticosBuscarForm;
import com.tsti.smn.pojos.Pronostico;




@Service
public class PronosticoServiceImpl implements PronosticoService {

	@Autowired
	IPronosticoRepo repo;

	@Override
	public Pronostico getById(Long idPronostico) {
		return repo.findById(idPronostico).get();
	}
	@Override
	public List<Pronostico> filter(PronosticosBuscarForm filter) {
		Date fechaactual = new Date(System.currentTimeMillis());
		List<Pronostico> vacia = new ArrayList<Pronostico>();
		if(filter.getIdCiudadSeleccionada()==null && filter.getFechaPronostico()==null) {
			return repo.findByFechaPronosticoAfter(fechaactual);
		}else if (filter.getIdCiudadSeleccionada()!=null && filter.getFechaPronostico()==null) {
			return repo.findByCiudadIdAndFechaPronosticoAfter(filter.getIdCiudadSeleccionada(),fechaactual);
			}else if(filter.getIdCiudadSeleccionada()==null && filter.getFechaPronostico()!=null && filter.getFechaPronostico().after(fechaactual)) {
				return repo.findByFechaPronosticoAfter(filter.getFechaPronostico());
			}else {
				return vacia;
			}
		}
	

	@Override
	public void save(Pronostico pronostico) {
		repo.save(pronostico);
		
	}
	@Override
	public Pronostico findByCiudadIdAndFechaPronostico(Long idCiudadSeleccionada, Date fecha) {
		
		return repo.findByCiudadIdAndFechaPronostico(idCiudadSeleccionada, fecha);
	}



	
	
	
}
