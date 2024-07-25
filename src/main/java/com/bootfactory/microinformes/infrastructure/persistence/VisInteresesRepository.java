package com.bootfactory.microinformes.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootfactory.microinformes.domain.model.entity.VisIntereses;

public interface VisInteresesRepository extends JpaRepository<VisIntereses, Long>,VisInteresesRepositoryCustom{

}
