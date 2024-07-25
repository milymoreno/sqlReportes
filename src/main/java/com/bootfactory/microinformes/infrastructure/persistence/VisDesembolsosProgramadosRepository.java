package com.bootfactory.microinformes.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootfactory.microinformes.domain.model.entity.VisDesembolsosProgramados;

public interface VisDesembolsosProgramadosRepository extends JpaRepository<VisDesembolsosProgramados, Long>,VisDesembolsosProgramadosRepositoryCustom{

}
