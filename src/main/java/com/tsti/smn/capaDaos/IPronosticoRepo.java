package com.tsti.smn.capaDaos;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.tsti.smn.pojos.Pronostico;

@Repository
public interface IPronosticoRepo extends JpaRepository<Pronostico, Long>{

	List<Pronostico> findByFechaPronostico(Date fechaPronostico);
	List<Pronostico> findByFechaPronosticoAfter(java.util.Date fechaactual);
	List<Pronostico> findByCiudadIdAndFechaPronosticoAfter(Long idCiudadSeleccionada, java.util.Date fechaactual);
	Pronostico findByCiudadIdAndFechaPronostico(Long idCiudadSeleccionada, java.util.Date fecha);
}
