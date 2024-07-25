package com.bootfactory.microinformes.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootfactory.microinformes.domain.model.entity.VisInformeCartera;
@Repository
public interface VisInformeCarteraRepository extends JpaRepository<VisInformeCartera, Long >, VisInformeCarteraRepositoryCustom{

}
