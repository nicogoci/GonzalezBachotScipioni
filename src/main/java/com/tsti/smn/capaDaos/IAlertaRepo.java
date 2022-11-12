package com.tsti.smn.capaDaos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsti.smn.pojos.Alerta;

@Repository
public interface IAlertaRepo extends JpaRepository<Alerta, Long> {

}
