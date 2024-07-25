package com.bootfactory.microinformes.infrastructure.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bootfactory.microinformes.domain.model.entity.ParametroEntidad;

@Repository
public interface ParametroEntidadRepository extends JpaRepository<ParametroEntidad, Long>{
	
	@Query(value = "SELECT p.* FROM PARAMETROENTIDAD p"
			+ " WHERE \r\n"
			+ "p.ENTIDADFINANCIERA_ID=:idEntidadFinanciera\r\n", nativeQuery = true)
	List<ParametroEntidad> listarParametroEntidad(Long idEntidadFinanciera);

}
