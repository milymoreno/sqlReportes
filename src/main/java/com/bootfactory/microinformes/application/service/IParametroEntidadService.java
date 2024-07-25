package com.bootfactory.microinformes.application.service;

import java.util.List;

import com.bootfactory.microinformes.application.modelDTO.ParametroEntidadDTO;

public interface IParametroEntidadService {
	
	public List<ParametroEntidadDTO> obtenerParametroEntidad(Long  idEntidadFinanciera);

}
