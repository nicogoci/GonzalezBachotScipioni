package com.tsti.smn.capaServicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsti.smn.capaDaos.IPersonaRepo;
import com.tsti.smn.capaPresentacion.personas.PersonasBuscarForm;
import com.tsti.smn.pojos.Persona;

@Service
public class PersonaServiceImpl implements PersonaService {

//	Logger LOG = LoggerFactory.getLogger(PersonaService.class);

	
	@Autowired
	IPersonaRepo repo;
	
	
	@Override
	public List<Persona> getAll() {
		return repo.findAll();
	}

	
	@Override
	public List<Persona> filter(PersonasBuscarForm filter) {

		if(filter.getNombre()==null && filter.getDni()==null)
			return repo.findAll();
		else
			return repo.findByNombreOrDni(filter.getNombre(),filter.getDni());
	}

	
	@Override
	public void save(Persona persona) {
		repo.save(persona);
	}

	
	@Override
	public Persona getPersonaById(Long idPersona) throws Exception {

		Optional<Persona> p = repo.findById(idPersona);
		
		if(p!=null) {
			return p.get();
		} else {
			throw new Exception("No existe la persona con el id="+idPersona);
		}
	}

	
	@Override
	public void deletePersonaByid(Long id) {
		repo.deleteById(id);
	}

	
	@Override
	public List<Persona> getPersonaByIdCiudad(Long idCiudad) throws Exception {
		return repo.findByCiudadId(idCiudad);
	}

	
}
