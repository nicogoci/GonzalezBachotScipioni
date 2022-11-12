package com.tsti.smn.capaDaos;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.tsti.smn.pojos.Alerta;

@Repository
public interface IAlertaRepo extends JpaRepository<Alerta, Long> {
	@Query("SELECT c FROM Ciudad c WHERE c.nombre like ?1 or c.fechaAlerta=?2")
	List<Alerta> findByCiudadOrFechaAlerta(String nombre, Date fechaAlerta);

	Optional<Alerta> findBy(String ciudad);
}
