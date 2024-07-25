package com.bootfactory.microinformes.application.service;

import java.util.List;

import com.bootfactory.microinformes.application.modelDTO.TipoIdentificacionDTO;

public interface ITipoIdentificacionService {
	
	public List<TipoIdentificacionDTO> listarTiposIdentificacion(Long idEntidadFinanciera);

	List<TipoIdentificacionDTO> buscarTipoIdentificacionByCodigo(Long idEntidadFinanciera, Long codTipoIdentificacion);

}
