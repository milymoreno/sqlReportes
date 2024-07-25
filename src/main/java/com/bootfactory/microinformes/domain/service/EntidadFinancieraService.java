package com.bootfactory.microinformes.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bootfactory.microinformes.application.mapper.EntidadFinancieraMapper;
import com.bootfactory.microinformes.application.modelDTO.EntidadFinancieraDTO;
import com.bootfactory.microinformes.application.service.IEntidadFinancieraService;
import com.bootfactory.microinformes.domain.model.entity.EntidadFinanciera;
import com.bootfactory.microinformes.infrastructure.persistence.EntidadFinancieraRepository;

@Service
public class EntidadFinancieraService implements IEntidadFinancieraService{
	
	
	private final EntidadFinancieraRepository repository;
	private final EntidadFinancieraMapper mapper;

	public EntidadFinancieraService(EntidadFinancieraMapper mapper, EntidadFinancieraRepository repository) {
		this.mapper = mapper;
		this.repository = repository;
	}
	
	public List<EntidadFinancieraDTO> obtenerEntidadFinanciera(Long  idEntidadFinanciera){
		
			List<EntidadFinanciera> entidad = repository.buscarEntidadFinanciera(idEntidadFinanciera);
			return mapper.toDtoList(entidad);
		

	}

}
