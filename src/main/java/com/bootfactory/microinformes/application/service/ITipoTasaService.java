package com.bootfactory.microinformes.application.service;

import java.util.List;

import com.bootfactory.microinformes.application.modelDTO.TasaDTO;
import com.bootfactory.microinformes.application.modelDTO.TipoTasaDTO;

public interface ITipoTasaService {
	
	public List<TipoTasaDTO> listarTiposTasas(Long idEntidadFinanciera);

}
