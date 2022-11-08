/**
 * @author kuttel
 *
 */
package com.tsti.smn.capaServicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsti.smn.capaDaos.IProvinciaRepo;
import com.tsti.smn.pojos.Provincia;

@Service
public class ProvinciaServiceImpl implements ProvinciaService {
//	Logger LOG = LoggerFactory.getLogger(CiudadService.class);
//	
	@Autowired
	IProvinciaRepo repo;

	@Override
	public List<Provincia> getAll() {
//		List<Provincia> provincias = new ArrayList<Provincia>();
//		
//		Provincia p1 = new Provincia();
//		p1.setId(1L);
//		p1.setNombre("Santa Fe");
//		provincias.add(p1);
//		
//		Provincia p2 = new Provincia();
//		p2.setId(2L);
//		p2.setNombre("Entre Rios");
//		provincias.add(p1);
//
//		return provincias;
		
		return repo.findAll();
	}



	@Override
	public Provincia getById(Long idCiudad) {
//		Provincia c = new Provincia();
//		c.setId(1L);
//		c.setNombre("Santa Fe");
//		return c;
		return repo.findById(idCiudad).get();
	}

}
