package com.bootfactory.microinformes.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootfactory.microinformes.domain.model.entity.VisRecaudosEsperados;

public interface VisRecaudosEsperadosRepository extends JpaRepository<VisRecaudosEsperados, Long>,VisRecaudosEsperadosRepositoryCustom{

}
