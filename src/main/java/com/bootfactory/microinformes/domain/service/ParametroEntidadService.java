package com.bootfactory.microinformes.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bootfactory.microinformes.application.mapper.ParametroEntidadMapper;
import com.bootfactory.microinformes.application.modelDTO.ParametroEntidadDTO;
import com.bootfactory.microinformes.application.service.IParametroEntidadService;
import com.bootfactory.microinformes.domain.model.entity.ParametroEntidad;
import com.bootfactory.microinformes.infrastructure.persistence.ParametroEntidadRepository;

@Service
public class ParametroEntidadService implements IParametroEntidadService{
	
	
	private final ParametroEntidadRepository repository;
	private final ParametroEntidadMapper mapper;

	public ParametroEntidadService(ParametroEntidadMapper mapper, ParametroEntidadRepository repository) {
		this.mapper = mapper;
		this.repository = repository;
	}
	
	public List<ParametroEntidadDTO> obtenerParametroEntidad(Long  idEntidadFinanciera){
		
			List<ParametroEntidad> parametros = repository.listarParametroEntidad(idEntidadFinanciera);
			return mapper.toDtoList(parametros);
		

	}

}
