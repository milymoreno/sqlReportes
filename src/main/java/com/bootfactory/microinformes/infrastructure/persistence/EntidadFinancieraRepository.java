package com.bootfactory.microinformes.infrastructure.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bootfactory.microinformes.domain.model.entity.EntidadFinanciera;

@Repository
public interface EntidadFinancieraRepository extends JpaRepository<EntidadFinanciera, Long>{
	
	@Query(value = """
            SELECT e.* FROM ENTIDADFINANCIERA e\
             WHERE 
            e.ID=:idEntidadFinanciera
            """, nativeQuery = true)
	List<EntidadFinanciera> buscarEntidadFinanciera(Long idEntidadFinanciera);

}
