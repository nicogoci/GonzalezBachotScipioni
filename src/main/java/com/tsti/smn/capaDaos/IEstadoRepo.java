package com.tsti.smn.capaDaos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsti.smn.pojos.Estado;

@Repository
public interface IEstadoRepo extends JpaRepository<Estado, Long> {

}
