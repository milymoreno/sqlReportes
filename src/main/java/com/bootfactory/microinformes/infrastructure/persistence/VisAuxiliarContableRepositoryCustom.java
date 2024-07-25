package com.bootfactory.microinformes.infrastructure.persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.bootfactory.microinformes.domain.model.entity.VisAuxiliarContable;

public interface VisAuxiliarContableRepositoryCustom {
	
	List<VisAuxiliarContable> listarPaginado(@Param("fechaInicial") LocalDate fechaInicial,@Param("fechaFinal") LocalDate fechaFinal,@Param("nroObligacion") String nroObligacion,
			@Param("registroInicial") int registroInicial, @Param("registroFinal") int registroFinal);
	
	public Long contar(LocalDate fechaInicial, LocalDate fechaFinal, String nroObligacion);

}
