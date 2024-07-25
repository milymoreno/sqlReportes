package com.bootfactory.microinformes.infrastructure.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bootfactory.microinformes.domain.model.entity.Tasa;

@Repository
public interface TasaRepository extends JpaRepository<Tasa, Long>{
	
	@Query(value = "SELECT t.* from tasa t", nativeQuery = true)
	List<Tasa> listarTasas();

}
