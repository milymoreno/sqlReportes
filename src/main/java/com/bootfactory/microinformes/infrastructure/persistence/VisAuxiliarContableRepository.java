package com.bootfactory.microinformes.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootfactory.microinformes.domain.model.entity.VisAuxiliarContable;

public interface VisAuxiliarContableRepository extends JpaRepository<VisAuxiliarContable, String>,VisAuxiliarContableRepositoryCustom {

}
