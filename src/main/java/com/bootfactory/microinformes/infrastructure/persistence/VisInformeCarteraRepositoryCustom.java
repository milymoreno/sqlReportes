package com.bootfactory.microinformes.infrastructure.persistence;

import java.util.List;

import com.bootfactory.microinformes.domain.model.entity.VisInformeCartera;
import com.bootfactory.microinformes.domain.model.enums.EnumEstadoObligacion;
import com.bootfactory.microinformes.domain.model.enums.EnumRolCliente;

public interface VisInformeCarteraRepositoryCustom {
	
	List<VisInformeCartera> listarPaginado(Long idEntidadFinanciera, String tipoIdentificacion, String identificacion, EnumRolCliente rolCliente, EnumEstadoObligacion estadoObligacion,
			int registroInicial,  int registroFinal);

	Long contar(Long idEntidadFinanciera, String tipoIdentificacion, String identificacion, EnumRolCliente rolCliente, EnumEstadoObligacion estadoObligacion);

}
