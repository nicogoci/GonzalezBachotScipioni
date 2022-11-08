package com.tsti.smn.capaDaos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsti.smn.pojos.Provincia;

@Repository
public interface IProvinciaRepo extends JpaRepository<Provincia, Long> {


}
