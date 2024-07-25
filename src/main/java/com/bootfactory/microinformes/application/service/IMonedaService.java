package com.bootfactory.microinformes.application.service;

import java.util.List;

import com.bootfactory.microinformes.application.modelDTO.MonedaDTO;

public interface IMonedaService {
	
	public List<MonedaDTO> listarMonedasbyEntidadFinanciera(Long idEntidadFinanciera);

}
