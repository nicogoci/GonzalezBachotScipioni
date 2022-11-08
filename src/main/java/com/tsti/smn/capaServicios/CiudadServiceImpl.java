/**
 * @author kuttel
 *
 */
package com.tsti.smn.capaServicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsti.smn.capaDaos.ICiudadRepo;
import com.tsti.smn.capaPresentacion.ciudades.CiudadesBuscarForm;
import com.tsti.smn.pojos.Ciudad;

@Service
public class CiudadServiceImpl implements CiudadService {
//	Logger LOG = LoggerFactory.getLogger(CiudadService.class);
//	
	@Autowired
	ICiudadRepo repo;

	@Override
	public List<Ciudad> getAll() {
//		List<Ciudad> ciudades = new ArrayList<Ciudad>();
//		
//		Provincia p1 = new Provincia();
//		p1.setId(1L);
//		p1.setNombre("Santa Fe");
//		
//		Ciudad c1 = new Ciudad();
//		c1.setId(1L);
//		c1.setNombre("Santa Fe");
//		c1.setProvincia(p1);
//		ciudades.add(c1);
//		
//		Ciudad c2 = new Ciudad();
//		c2.setId(2L);
//		c2.setNombre("Rafaela");
//		c2.setProvincia(p1);
//		ciudades.add(c2);
//
//		return ciudades;
//		
		return repo.findAll();
	}



	@Override
	public Ciudad getById(Long idCiudad) {
//		Provincia p1 = new Provincia();
//		p1.setId(1L);
//		p1.setNombre("Santa Fe");
//		
//		Ciudad c = new Ciudad();
//		c.setId(1L);
//		c.setNombre("Santa Fe");
//		c.setProvincia(p1);
//		return c;
		return repo.findById(idCiudad).get();
	}
	
	@Override
	public List<Ciudad> filter(CiudadesBuscarForm filter)
	{
//		Provincia p1 = new Provincia();
//		p1.setId(1L);
//		p1.setNombre("Santa Fe");
//		
//		List<Ciudad> ciudades = new ArrayList<Ciudad>();
//		Ciudad c1 = new Ciudad();
//		c1.setId(1L);
//		c1.setNombre("Santa Fe");
//		c1.setProvincia(p1);
//		ciudades.add(c1);
//		
//		Ciudad c2 = new Ciudad();
//		c2.setId(2L);
//		c2.setNombre("Rafaela");
//		c2.setProvincia(p1);
//		ciudades.add(c2);
//
//		return ciudades;
		//ver https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html
		if(filter.getNombre()==null && filter.getProvinciaSeleccionada()==null)
			return repo.findAll();
		else
			return repo.findByNombreOrIdProvincia(filter.getNombre(),filter.getProvinciaSeleccionada());
				
	}



	@Override
	public void deleteByid(Long id) {
		repo.deleteById(id);
		
	}



	@Override
	public void save(Ciudad c) {
		repo.save(c);
		
	}

}
