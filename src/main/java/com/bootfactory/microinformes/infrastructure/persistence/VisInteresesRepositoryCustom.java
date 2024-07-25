package com.bootfactory.microinformes.infrastructure.persistence;

import java.time.LocalDate;
import java.util.List;

import com.bootfactory.microinformes.domain.model.entity.VisIntereses;

public interface VisInteresesRepositoryCustom {
	
	Long contar(Boolean esReporteMora,LocalDate fechaInicial, LocalDate fechaFinal, String nroObligacion, String nombreProducto);

	List<VisIntereses> listarPaginado(Boolean esReporteMora,LocalDate fechaInicial, LocalDate fechaFinal, String nroObligacion,
			String nombreProducto, int registroInicial, int registroFinal);


}
