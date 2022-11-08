package com.tsti.smn.capaDaos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsti.smn.pojos.Persona;

@Repository
public interface IPersonaRepo extends JpaRepository<Persona, Long> {
	List<Persona> findByNombreOrDni( String nombre, Long dni);

}
