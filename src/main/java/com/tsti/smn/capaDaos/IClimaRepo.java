package com.tsti.smn.capaDaos;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tsti.smn.pojos.Clima;

public interface IClimaRepo extends JpaRepository<Clima, Long> {
	Clima findByCiudadAndFecha (Long ciudad, Date fecha);
}
