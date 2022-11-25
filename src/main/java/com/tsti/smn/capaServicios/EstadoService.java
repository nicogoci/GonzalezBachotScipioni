package com.tsti.smn.capaServicios;

import java.util.List;

import org.springframework.stereotype.Service;
import com.tsti.smn.pojos.Estado;
@Service
public interface EstadoService {
	
	List<Estado> findAll();
	Estado getById(Long id) throws Exception;

}
