package com.tsti.smn.capaDaos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tsti.smn.pojos.Ciudad;

@Repository
public interface ICiudadRepo extends JpaRepository<Ciudad, Long> {


	@Query("SELECT c FROM Ciudad c WHERE c.nombre like ?1 or c.provincia.id=?2")
	List<Ciudad> findByNombreOrIdProvincia(String nombre, Long idProvinciaSeleccionada);


}
