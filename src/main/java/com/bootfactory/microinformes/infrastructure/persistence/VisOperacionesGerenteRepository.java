package com.bootfactory.microinformes.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootfactory.microinformes.domain.model.entity.VisOperacionesGerente;

public interface VisOperacionesGerenteRepository extends JpaRepository<VisOperacionesGerente, Long>,VisOperacionesGerenteCustom{

}
