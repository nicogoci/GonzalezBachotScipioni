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
		
//		try {
//			List<Persona> personas =new ArrayList<Persona>();
//			
//			Persona p1=new Persona();
//			p1.setApellido("Perez");
//			p1.setNombre("Juan");
//			p1.setDni(111111L);
//			p1.setFechaNacimiento(new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2000"));
//			personas.add(p1);
//			
//			Persona p2=new Persona();
//			p2.setApellido("Fede");
//			p2.setNombre("Sartore");
//			p2.setDni(111111L);
//			p2.setFechaNacimiento(new SimpleDateFormat("dd/MM/yyyy").parse("03/06/1990"));
//			personas.add(p2);
//			
//			return personas;
//			
//		} catch (ParseException e) {
//			e.printStackTrace();
//			return new ArrayList<Persona>();
//		}
		return repo.findAll();
	}

	@Override
	public List<Persona> filter(PersonasBuscarForm filter) {
		
//		try {
//			List<Persona> personas =new ArrayList<Persona>();
//			Ciudad c1 = new Ciudad();
//			c1.setId(1L);
//			c1.setNombre("Santa Fe");
//			
//			Persona p1=new Persona();
//			p1.setApellido("Perez");
//			p1.setNombre("Juan");
//			p1.setDni(111111L);
//			p1.setFechaNacimiento(new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2000"));
//			p1.setCiudad(c1);
//			personas.add(p1);
//			
//			Persona p2=new Persona();
//			p2.setApellido("Fede");
//			p2.setNombre("Sartore");
//			p2.setDni(111111L);
//			p2.setFechaNacimiento(new SimpleDateFormat("dd/MM/yyyy").parse("03/06/1990"));
//			p2.setCiudad(c1);
//			personas.add(p2);
//			
//			return personas;
//			
//		} catch (ParseException e) {
//			e.printStackTrace();
//			return new ArrayList<Persona>();
//		}
		
//		//ver https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html
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
//		Ciudad c1 = new Ciudad();
//		c1.setId(1L);
//		c1.setNombre("Santa Fe");
//		
//		Persona p1=new Persona();
//		p1.setApellido("Perez");
//		p1.setNombre("Juan");
//		p1.setDni(111111L);
//		p1.setFechaNacimiento(new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2000"));
//		p1.setCiudad(c1);
//		return p1; 
		
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

	
}
