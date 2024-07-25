package com.bootfactory.microinformes.infrastructure.persistence;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.bootfactory.microinformes.application.modelDTO.VisOperacionesGerenteDTO;

public interface VisOperacionesGerenteCustom {
	
	List<VisOperacionesGerenteDTO> listarPaginado(@Param("fechaInicial") LocalDate fechaInicial,@Param("fechaFinal") LocalDate fechaFinal,
			@Param("registroInicial") int registroInicial, @Param("registroFinal") int registroFinal);
	
	public Long contar(LocalDate fechaInicial, LocalDate fechaFinal);

}
