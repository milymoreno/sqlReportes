package com.bootfactory.microinformes.infrastructure.persistence;

import java.time.LocalDate;
import java.util.List;

import com.bootfactory.microinformes.domain.model.entity.VisAmortizacion;

public interface VisAmortizacionRepositoryCustom {

	Long contar(LocalDate fechaInicial, LocalDate fechaFinal, String nroObligacion, String nombreProducto);

	List<VisAmortizacion> listarPaginado(LocalDate fechaInicial, LocalDate fechaFinal, String nroObligacion,
			String nombreProducto, int registroInicial, int registroFinal);

}
