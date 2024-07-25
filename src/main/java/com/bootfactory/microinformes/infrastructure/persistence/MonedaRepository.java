package com.bootfactory.microinformes.infrastructure.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bootfactory.microinformes.domain.model.entity.Moneda;

@Repository
public interface MonedaRepository extends JpaRepository<Moneda, Long>{
	
	
	@Query(value = "select m.* from moneda m join entfin_moneda  e on m.id=e.moneda_id"
			+ " WHERE \r\n"
			+ "e.entidadfinanciera_id=:idEntidadFinanciera\r\n", nativeQuery = true)
	public List<Moneda> listarMonedasbyEntidadFinanciera( Long idEntidadFinanciera);
		
	

}
