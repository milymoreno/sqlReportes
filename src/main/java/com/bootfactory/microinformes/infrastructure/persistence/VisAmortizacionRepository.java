package com.bootfactory.microinformes.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootfactory.microinformes.domain.model.entity.VisAmortizacion;

public interface VisAmortizacionRepository extends JpaRepository<VisAmortizacion,Long>,VisAmortizacionRepositoryCustom {

}
