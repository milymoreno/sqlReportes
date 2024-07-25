package com.bootfactory.microinformes.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootfactory.microinformes.domain.model.entity.VisAplicacionPagoOperativo;

public interface VisAplicacionPagoRepository extends JpaRepository<VisAplicacionPagoOperativo, String>,VisAplicacionPagoRepositoryCustom{

	

}
