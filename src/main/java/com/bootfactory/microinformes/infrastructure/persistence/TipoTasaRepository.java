package com.bootfactory.microinformes.infrastructure.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bootfactory.microinformes.domain.model.entity.TipoTasa;

@Repository
public interface TipoTasaRepository extends JpaRepository<TipoTasa, Long> {

	@Query(value = """
            SELECT t.* from TIPOTASA t
            WHERE 
            t.entidadfinanciera_id=:idEntidadFinanciera\
            """, nativeQuery = true)
	List<TipoTasa> listartiposTasas( Long idEntidadFinanciera);

}
