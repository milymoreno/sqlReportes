package com.bootfactory.microinformes.infrastructure.persistence;

import java.time.LocalDate;
import java.util.List;

import com.bootfactory.microinformes.domain.model.entity.VisAplicacionPagoOperativo;

public interface VisAplicacionPagoRepositoryCustom {
	
	Long contar(String referenciaPago, String nroObligacion, LocalDate fechaInicial, LocalDate fechaFinal,
			LocalDate fechaAplicacionContableInicial, LocalDate fechaAplicacionContableFinal,
			String descTipoIdentificacionComprador, String identificacionComprador, String descTipoIdentificacionVendedor,
			String identificacionVendedor);

	List<VisAplicacionPagoOperativo> listarPaginado(String referenciaPago, String nroObligacion, LocalDate fechaInicial,
			LocalDate fechaFinal, LocalDate fechaAplicacionContableInicial, LocalDate fechaAplicacionContableFinal,
			String descTipoIdentificacionComprador, String identificacionComprador, String descTipoIdentificacionVendedor,
			String identificacionVendedor, int registroInicial, int registroFinal);

}
