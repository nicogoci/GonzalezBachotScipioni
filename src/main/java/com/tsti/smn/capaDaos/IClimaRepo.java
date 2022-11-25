package com.tsti.smn.capaDaos;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tsti.smn.pojos.Clima;

@Repository
public interface IClimaRepo extends JpaRepository<Clima, Long> {
	
	@Query("SELECT c FROM Clima c WHERE c.ciudad.id=?1 and c.fecha=?2")
	Clima findByCiudadAndFecha (Long ciudad, LocalDate fecha);
	
	@Transactional
	@Modifying
	@Query (value= "UPDATE clima c SET c.temperatura = :temperatura, c.estado_id = :estado, c.porcentaje_humedad = :porcentajeHumedad where ciudad_id = :idCiudad and fecha = :fecha", nativeQuery= true)
	public void updateClima(@Param ("temperatura") int temperatura, @Param ("estado") Long estado, @Param ("porcentajeHumedad") int porcentajeHumedad, @Param ("fecha") LocalDate fecha, @Param ("idCiudad") Long idCiudad );
}
