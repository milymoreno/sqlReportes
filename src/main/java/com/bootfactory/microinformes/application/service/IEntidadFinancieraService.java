package com.bootfactory.microinformes.application.service;

import java.util.List;

import com.bootfactory.microinformes.application.modelDTO.EntidadFinancieraDTO;

public interface IEntidadFinancieraService {
	
	public List<EntidadFinancieraDTO> obtenerEntidadFinanciera(Long  idEntidadFinanciera);

}
