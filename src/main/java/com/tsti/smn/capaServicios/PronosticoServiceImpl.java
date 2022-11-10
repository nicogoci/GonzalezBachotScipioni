package com.tsti.smn.capaServicios;

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
	public List<Pronostico> getAll() {
	
		return repo.findAll();
	}

	@Override
	public List<Pronostico> filter(PronosticosBuscarForm filter) {

		if(filter.getFechaPronostico()==null )
			return repo.findAll();
		else
			return repo.findByFechaPronostico(filter.getFechaPronostico());
		
		
		
	}

	@Override
	public void save(Pronostico pronostico) {
		repo.save(pronostico);
		
	}

	@Override
	public Pronostico getPronosticoById(Long idPronostico) throws Exception {

		
		Optional<Pronostico> p = repo.findById(idPronostico);
		
		if(p!=null) {
			return p.get();
		} else {
			throw new Exception("No existe la persona con el id="+idPronostico);
		}
	}

	@Override
	public void deletePronosticoByid(Long id) {
		repo.deleteById(id);
		
	}
}
