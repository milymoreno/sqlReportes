package com.bootfactory.microinformes.infrastructure.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bootfactory.microinformes.domain.model.entity.TipoIdentificacion;

@Repository
public interface TipoIdentificacionRepository extends JpaRepository<TipoIdentificacion, Long> {
	
	
	@Query(value = "select t.* from tident t join entfin_tipoident e on t.id=e.TIPOIDENTIFICACION_ID\r\n"
			+ "where e.ENTIDADFINANCIERA_ID=:idEntidadFinanciera", nativeQuery = true)
	List<TipoIdentificacion> listarTiposIdentificacion(Long idEntidadFinanciera);
	
	
	@Query(value = "select t.* from tident t join entfin_tipoident e on t.id=e.TIPOIDENTIFICACION_ID\r\n"
			+ "where e.ENTIDADFINANCIERA_ID=:idEntidadFinanciera\r\n"
			+ "and t.codigo=:codTipoIdentificacion", nativeQuery = true)
	List<TipoIdentificacion> buscarTipoIdentificacionByCodigo(Long idEntidadFinanciera,Long codTipoIdentificacion);
}


	


